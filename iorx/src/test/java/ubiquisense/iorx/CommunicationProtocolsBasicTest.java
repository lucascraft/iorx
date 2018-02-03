package ubiquisense.iorx;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.inject.Key;
import com.google.inject.name.Names;

import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.protocols.midi.MidiQxCmdHandler;
import ubiquisense.iorx.protocols.osc.OSCQxCmdHandler;

public class CommunicationProtocolsBasicTest extends GuiceInjectionTest {
	

	
	@Test
	public void testProtocolInterpretersInjection()
	{
		
		IXFrameInterpreter oscFrameInterpreter = injector.getInstance(Key.get(IXFrameInterpreter.class, Names.named("osc"))); 
		IXCmdInterpreter oscCmdInterpreter= injector.getInstance(Key.get(IXCmdInterpreter.class, Names.named("osc"))); 
		IQxEventHandler oscQxEventInterpreter= injector.getInstance(Key.get(IQxEventHandler.class, Names.named("osc"))); 

		IXFrameInterpreter midiFrameInterpreter= injector.getInstance(Key.get(IXFrameInterpreter.class, Names.named("midi"))); 
		IXCmdInterpreter midiCmdInterpreter= injector.getInstance(Key.get(IXCmdInterpreter.class, Names.named("midi"))); 
		IQxEventHandler midiQxEventInterpreter= injector.getInstance(Key.get(IQxEventHandler.class, Names.named("midi"))); 
		
		assertTrue(oscFrameInterpreter instanceof OSCQxCmdHandler);
		assertTrue(oscCmdInterpreter instanceof OSCQxCmdHandler);
		assertTrue(oscQxEventInterpreter instanceof OSCQxCmdHandler);
		
		assertTrue(midiFrameInterpreter instanceof MidiQxCmdHandler);
		assertTrue(midiCmdInterpreter instanceof MidiQxCmdHandler);
		assertTrue(midiQxEventInterpreter instanceof MidiQxCmdHandler);
		
	}

}
