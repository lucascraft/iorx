package ubiquisense.iorx;

import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_JAR_VERSION;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_LIBRARY_VERSION;
import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_DEFAULT;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_OPENMEMORY;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_SOFTWARE;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.SizeOfPrimitive.SIZEOF_INT;

import java.nio.ByteBuffer;
import java.nio.file.Paths;

import org.jouvieje.fmoddesigner.InitFmodDesigner;
import org.jouvieje.fmodex.Channel;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.Sound;
import org.jouvieje.fmodex.System;
import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.fmodex.structures.FMOD_CREATESOUNDEXINFO;
import org.junit.Before;
import org.junit.Test;

import ubiquisense.iorx.media.fmodex.AudioChannel;
import ubiquisense.iorx.media.fmodex.AudioSound;
import ubiquisense.iorx.media.fmodex.DSP_KIND;
import ubiquisense.iorx.media.fmodex.FMDSP;
import ubiquisense.iorx.media.fmodex.utils.AudioUtils;
import ubiquisense.iorx.nojunit.Medias;

public class AudioFmodexTest {
	protected  static FMOD_CREATESOUNDEXINFO exinfo;
	protected  static int version;
	protected static  org.jouvieje.fmodex.System system;

	@Before
	public void init()
	{
		
		/*
		 * NativeFmodEx/NativeFmodDesigner Init
		 */
		try {
			Init.loadLibraries();
			InitFmodDesigner.loadLibraries();
		}
		catch(InitException e) {
			java.lang.System.err.printf("NativeFmodEx error! %s\n", e.getMessage());
			return;
		}

		/*
		 * Checking NativeFmodEx version
		 */
		if(NATIVEFMODEX_LIBRARY_VERSION != NATIVEFMODEX_JAR_VERSION) {
			java.lang.System.err.printf("Error!  NativeFmodEx library version (%08x) is different to jar version (%08x)\n",
					NATIVEFMODEX_LIBRARY_VERSION, NATIVEFMODEX_JAR_VERSION);
			return;
		}
		/*
		 * Checking NativeFmodDesigner version
		 */
		if(NATIVEFMODDESIGNER_LIBRARY_VERSION != NATIVEFMODDESIGNER_JAR_VERSION) {
			java.lang.System.err.printf("Error!  NativeFmodDesigner library version (%08x) is different to jar version (%08x)\n",
					NATIVEFMODDESIGNER_LIBRARY_VERSION, NATIVEFMODDESIGNER_JAR_VERSION);
			return;
		}
		
		initSystem();

		errorCheck(FmodEx.System_Create(system));
		ByteBuffer bufferr = newByteBuffer(SIZEOF_INT);

		errorCheck(system.getVersion(bufferr.asIntBuffer()));
		version = bufferr.getInt(0);

		if(version < FMOD_VERSION) {
			printfExit("Error!  You are using an old version of FMOD %08x.  This program requires %08x\n", version,
					FMOD_VERSION);
			return;
		}
		errorCheck(system.init(32, FMOD_INIT_NORMAL, null));
	}
	
	@Test
	public void testFModexInit() {
		
		Channel systemChannel = new Channel();
		
		for (String soundFile : new String[] {"riviere3.wav", "buzz.wav", "tone7.au", "", "sound37.mp3"}) 
		{
			Sound sound = new Sound();
	
	        java.nio.file.Path path = Paths.get("src\\media\\" + soundFile);
			java.lang.System.out.println("About to init media\\9_klingeln.wav Sound Buffer");
			try {
				ByteBuffer soundBuffer = Medias.loadMediaIntoMemory(path.toAbsolutePath().toString());
				if (soundBuffer != null) {
						java.lang.System.out.println("Sound Buffer init succeeded");
					exinfo = FMOD_CREATESOUNDEXINFO.allocate();
					if (exinfo != null) {
						exinfo.setLength(soundBuffer.capacity());
						errorCheck(system.createSound(soundBuffer, FMOD_DEFAULT | FMOD_SOFTWARE | FMOD_OPENMEMORY, exinfo, sound));
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				exinfo.release();
			}
			system.playSound(FMOD_CHANNEL_FREE, sound, false, systemChannel);
		}
	}
	
	@Test
	public void testPlayAudioFile()
	{
		AudioChannel aChannel = AudioUtils.INSTANCE.createChannel();
		
		FMDSP dsp = AudioUtils.INSTANCE.createDSP(
			DSP_KIND.ECHO, 
			0f, 
			1f, 
			0.5f
		);
		AudioUtils.INSTANCE.addDSP(
			dsp
		);
        java.nio.file.Path path = Paths.get("src\\media\\sound37.mp3");
		AudioSound aSound2 = AudioUtils.INSTANCE.createSound(
			path.toAbsolutePath().toString(), 
			FMOD_DEFAULT | FMOD_SOFTWARE | /*FMOD_LOOP_NORMAL |*/ FMOD_OPENMEMORY
		);

		AudioUtils.INSTANCE.playSound(
			aSound2, 
			aChannel
		);
	}
	
	static void initSystem() {
		system = new System();
	}
	
	private static void errorCheck(FMOD_RESULT result) {
		if(result != FMOD_RESULT.FMOD_OK) {
			printfExit("FMOD error! (%d) %s\n", result.asInt(), FmodEx.FMOD_ErrorString(result));
		}
	}
	
	protected static  void print(String message) {}
	protected static  void printExit(String message) {
		print(message);
	}
	
	protected static  void printfExit(String format, Object... args) {
		printExit(String.format(format, args));
	}
	
	

}
