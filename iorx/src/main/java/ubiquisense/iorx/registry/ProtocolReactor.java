package ubiquisense.iorx.registry;

import java.util.Set;

import org.reflections.Reflections;

import com.google.common.collect.Sets;
import com.google.inject.Key;
import com.google.inject.name.Names;

import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.qx.evt.IQxEventHandler;

public class ProtocolReactor extends GuiceRegistery 
{
	public final static ProtocolReactor INSTANCE = new ProtocolReactor();
	
	public Set<ProtocolWithSpecificTransportConfig> getProtocols()
	{
		Set<ProtocolWithSpecificTransportConfig> configs = Sets.newHashSet();
		Set<Class<?>> annotatedClasses = new Reflections("").getTypesAnnotatedWith(javax.inject.Named.class, true);
		annotatedClasses.forEach(c -> configs.add(getProtocolWithSpecificTransport(c.getAnnotation(javax.inject.Named.class).value())));
		return configs;
	}
	
	public ProtocolWithSpecificTransportConfig getProtocolWithSpecificTransport(String id)
	{
		IXFrameInterpreter frameInterpreter = injector.getInstance(Key.get(IXFrameInterpreter.class, Names.named(id))); 
		IXCmdInterpreter cmdInterpreter= injector.getInstance(Key.get(IXCmdInterpreter.class, Names.named(id))); 
		IQxEventHandler eventHandler= injector.getInstance(Key.get(IQxEventHandler.class, Names.named(id))); 

		return new ProtocolWithSpecificTransportConfig(id, id, cmdInterpreter, frameInterpreter, eventHandler);
	}
}
