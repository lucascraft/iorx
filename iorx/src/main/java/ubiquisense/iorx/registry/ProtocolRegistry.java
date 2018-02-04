package ubiquisense.iorx.registry;

import java.util.Set;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import com.google.common.collect.Sets;
import com.google.inject.Key;
import com.google.inject.name.Names;

import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;

public final class ProtocolRegistry extends GuiceRegistery 
{
	Set<Class<?>> allInterfacesToImplement = Sets.newHashSet(IXFrameInterpreter.class, IXCmdInterpreter.class, IQxEventHandler.class);
	public Set<CommProtocolConfig> getProtocols()
	{
		Set<CommProtocolConfig> configs = Sets.newHashSet();
		Set<Class<?>> annotatedClasses = new Reflections("").getTypesAnnotatedWith(javax.inject.Named.class, true);
		annotatedClasses.stream().filter(c -> Sets.newHashSet(c.getInterfaces()).containsAll(allInterfacesToImplement))
			.forEach(c -> configs.add(getCommunicationProtocol(c.getAnnotation(javax.inject.Named.class).value())));
		return configs.stream().filter(p -> p != null).collect(Collectors.toSet());
	}
	
	public CommProtocolConfig getCommunicationProtocol(String id)
	{	
		try 
		{
			IXFrameInterpreter frameInterpreter = injector.getInstance(Key.get(IXFrameInterpreter.class, Names.named(id))); 
			IXCmdInterpreter cmdInterpreter= injector.getInstance(Key.get(IXCmdInterpreter.class, Names.named(id))); 
			IQxEventHandler eventHandler= injector.getInstance(Key.get(IQxEventHandler.class, Names.named(id))); 
	
			return new CommProtocolConfig(id, id, cmdInterpreter, frameInterpreter, eventHandler);
		}
		catch (Exception e)
		{
			System.out.println("@named " + id + " is not a Qx interpreter");
		}
		return null;
	}
}
