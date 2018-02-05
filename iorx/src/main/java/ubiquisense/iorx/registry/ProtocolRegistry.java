package ubiquisense.iorx.registry;

import java.util.Set;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import com.google.common.collect.Sets;
import com.google.inject.Key;
import com.google.inject.name.Names;

import ubiquisense.iorx.annotations.Binder;
import ubiquisense.iorx.annotations.CommunicationProtocol;
import ubiquisense.iorx.annotations.TransportProtocol;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.io.TransportChannel;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;

public final class ProtocolRegistry extends GuiceRegistery 
{
	Set<Class<?>> allInterfacesToImplement = Sets.newHashSet(IXFrameInterpreter.class, IXCmdInterpreter.class, IQxEventHandler.class);
	public Set<CommProtocolConfig> getCommunictionProtocols()
	{
		Set<CommProtocolConfig> configs = Sets.newHashSet();
		Set<Class<?>> annotatedClasses = new Reflections("").getTypesAnnotatedWith(CommunicationProtocol.class, true);
		annotatedClasses.stream().filter(c -> Sets.newHashSet(c.getInterfaces()).containsAll(allInterfacesToImplement))
			.forEach(c -> configs.add(getCommunicationProtocol(c.getAnnotation(CommunicationProtocol.class).type())));
		return configs.stream().filter(p -> p != null).collect(Collectors.toSet());
	}
	
	public CommProtocolConfig getCommunicationProtocol(String id)
	{	
		try 
		{
			CommunicationProtocol commProtocolToMatch = Binder.communication(id);
			IXFrameInterpreter frameInterpreter = injector.getInstance(Key.get(IXFrameInterpreter.class, commProtocolToMatch)); 
			IXCmdInterpreter cmdInterpreter= injector.getInstance(Key.get(IXCmdInterpreter.class, commProtocolToMatch)); 
			IQxEventHandler eventHandler= injector.getInstance(Key.get(IQxEventHandler.class, commProtocolToMatch)); 
			return new CommProtocolConfig(id, id, cmdInterpreter, frameInterpreter, eventHandler);
		}
		catch (Exception e)
		{
			System.out.println("@named " + id + " is not a Qx interpreter");
		}
		return null;
	}
	

	public TransportChannel getTransportCommunicator(TransportProtocol protocol)
	{
		return getTransportCommunicator(protocol.type());
	}
	
	public TransportChannel getTransportCommunicator(String id)
	{	
		id = !id.endsWith("://")?(id+"://"):id;
		try 
		{
			TransportProtocol commProtocolToMatch = Binder.transport(id);
			TransportChannel transportChannel = injector.getInstance(Key.get(TransportChannel.class, commProtocolToMatch)); 
			return transportChannel;
		}
		catch (Exception e)
		{
			System.out.println("@named " + id + " is not a Qx transport channel");
		}
		return null;
	}
}
