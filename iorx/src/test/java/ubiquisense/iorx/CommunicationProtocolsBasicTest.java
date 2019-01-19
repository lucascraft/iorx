package ubiquisense.iorx;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.inject.Key;
import com.google.inject.name.Names;

import ubiquisense.iorx.annotations.Binder;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.protocols.dmx.DMXQxCmdHandler;
import ubiquisense.iorx.protocols.firmata.FirmataCmdQxEventHandler;
import ubiquisense.iorx.protocols.midi.MidiQxCmdHandler;
import ubiquisense.iorx.protocols.osc.OSCQxCmdHandler;

public class CommunicationProtocolsBasicTest extends GuiceInjectionTest {
	

	
	@Test
	public void testProtocolInterpretersInjection()
	{
		
		IXFrameInterpreter oscFrameInterpreter = injector.getInstance(Key.get(IXFrameInterpreter.class, Binder.communication("osc"))); 
		IXCmdInterpreter oscCmdInterpreter= injector.getInstance(Key.get(IXCmdInterpreter.class, Binder.communication("osc"))); 
		IQxEventHandler oscQxEventInterpreter= injector.getInstance(Key.get(IQxEventHandler.class, Binder.communication("osc"))); 

		assertTrue(oscFrameInterpreter instanceof OSCQxCmdHandler);
		assertTrue(oscCmdInterpreter instanceof OSCQxCmdHandler);
		assertTrue(oscQxEventInterpreter instanceof OSCQxCmdHandler);
		
		IXFrameInterpreter midiFrameInterpreter= injector.getInstance(Key.get(IXFrameInterpreter.class, Binder.communication("midi"))); 
		IXCmdInterpreter midiCmdInterpreter= injector.getInstance(Key.get(IXCmdInterpreter.class, Binder.communication("midi"))); 
		IQxEventHandler midiQxEventInterpreter= injector.getInstance(Key.get(IQxEventHandler.class, Binder.communication("midi"))); 
		
		assertTrue(midiFrameInterpreter instanceof MidiQxCmdHandler);
		assertTrue(midiCmdInterpreter instanceof MidiQxCmdHandler);
		assertTrue(midiQxEventInterpreter instanceof MidiQxCmdHandler);
		
		IXFrameInterpreter firmataFrameInterpreter= injector.getInstance(Key.get(IXFrameInterpreter.class, Binder.communication("firmata"))); 
		IXCmdInterpreter firmataCmdInterpreter= injector.getInstance(Key.get(IXCmdInterpreter.class, Binder.communication("firmata"))); 
		IQxEventHandler firmataQxEventInterpreter= injector.getInstance(Key.get(IQxEventHandler.class, Binder.communication("firmata"))); 
		
		assertTrue(firmataFrameInterpreter instanceof FirmataCmdQxEventHandler);
		assertTrue(firmataCmdInterpreter instanceof FirmataCmdQxEventHandler);
		assertTrue(firmataQxEventInterpreter instanceof FirmataCmdQxEventHandler);
		
		IXFrameInterpreter ubiquinoFrameInterpreter= injector.getInstance(Key.get(IXFrameInterpreter.class, Binder.communication("ubiquino"))); 
		IXCmdInterpreter ubiquinoCmdInterpreter= injector.getInstance(Key.get(IXCmdInterpreter.class, Binder.communication("ubiquino"))); 
		IQxEventHandler ubiquinoQxEventInterpreter= injector.getInstance(Key.get(IQxEventHandler.class, Binder.communication("ubiquino"))); 
		
		assertTrue(ubiquinoFrameInterpreter instanceof FirmataCmdQxEventHandler);
		assertTrue(ubiquinoCmdInterpreter instanceof FirmataCmdQxEventHandler);
		assertTrue(ubiquinoQxEventInterpreter instanceof FirmataCmdQxEventHandler);
		
		IXFrameInterpreter dmxFrameInterpreter= injector.getInstance(Key.get(IXFrameInterpreter.class, Binder.communication("dmx"))); 
		IXCmdInterpreter dmxCmdInterpreter= injector.getInstance(Key.get(IXCmdInterpreter.class, Binder.communication("dmx"))); 
		IQxEventHandler dmxQxEventInterpreter= injector.getInstance(Key.get(IQxEventHandler.class, Binder.communication("dmx"))); 
		
		assertTrue(dmxFrameInterpreter instanceof DMXQxCmdHandler);
		assertTrue(dmxCmdInterpreter instanceof DMXQxCmdHandler);
		assertTrue(dmxQxEventInterpreter instanceof DMXQxCmdHandler);
	}

}
