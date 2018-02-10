/***********************************************************************************
 * Ubiquisense - A smart ambient utilities framework 
 * 
 * Copyright (c) 2012, Lucas Bigeardel
 * 
 * The library is released under:
 * 
 * A) LGPL
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA 02110-1301 USA
 * 
 * B) EPL
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Lucas Bigeardel <lucas.bigeardel@gmail.com> - Initial API and implementation
 ***********************************************************************************/

package ubiquisense.iorx.media.fmodex.utils;

import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_JAR_VERSION;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_LIBRARY_VERSION;
import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_MS;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_INVALID_HANDLE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.newFloatBuffer;
import static org.jouvieje.fmodex.utils.SizeOfPrimitive.SIZEOF_INT;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

import org.jouvieje.fmoddesigner.InitFmodDesigner;
import org.jouvieje.fmodex.Channel;
import org.jouvieje.fmodex.DSP;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.Sound;
import org.jouvieje.fmodex.System;
import org.jouvieje.fmodex.callbacks.FMOD_DSP_READCALLBACK;
import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.fmodex.structures.FMOD_CREATESOUNDEXINFO;
import org.jouvieje.fmodex.structures.FMOD_DSP_DESCRIPTION;
import org.jouvieje.fmodex.structures.FMOD_DSP_STATE;
import org.jouvieje.fmodex.utils.BufferUtils;

import ubiquisense.iorx.media.fmodex.AudioChannel;
import ubiquisense.iorx.media.fmodex.AudioClip;
import ubiquisense.iorx.media.fmodex.AudioFile;
import ubiquisense.iorx.media.fmodex.AudioProject;
import ubiquisense.iorx.media.fmodex.AudioScene;
import ubiquisense.iorx.media.fmodex.AudioSound;
import ubiquisense.iorx.media.fmodex.AudioSoundGroup;
import ubiquisense.iorx.media.fmodex.AudioSystem;
import ubiquisense.iorx.media.fmodex.AudioTrack;
import ubiquisense.iorx.media.fmodex.CLIP_STATUS;
import ubiquisense.iorx.media.fmodex.DSP_KIND;
import ubiquisense.iorx.media.fmodex.Device;
import ubiquisense.iorx.media.fmodex.FMDSP;
import ubiquisense.iorx.media.fmodex.TimeTag;
import ubiquisense.iorx.media.fmodex.impl.AudioChannelImpl;
import ubiquisense.iorx.media.fmodex.impl.AudioClipImpl;
import ubiquisense.iorx.media.fmodex.impl.AudioFileImpl;
import ubiquisense.iorx.media.fmodex.impl.AudioProjectImpl;
import ubiquisense.iorx.media.fmodex.impl.AudioSceneImpl;
import ubiquisense.iorx.media.fmodex.impl.AudioSoundImpl;
import ubiquisense.iorx.media.fmodex.impl.AudioSystemImpl;
import ubiquisense.iorx.media.fmodex.impl.AudioTrackImpl;
import ubiquisense.iorx.media.fmodex.impl.DeviceImpl;
import ubiquisense.iorx.media.fmodex.impl.FMDSPImpl;
import ubiquisense.iorx.media.fmodex.impl.TimeTagImpl;
import ubiquisense.iorx.nojunit.Medias;
import ubiquisense.iorx.utils.Platform;

public class AudioUtils {
	public final static AudioUtils INSTANCE = new AudioUtils();
	
	private List<String> mediaFilePaths;

	private FMOD_CREATESOUNDEXINFO exinfo;
	private int version;
	private org.jouvieje.fmodex.System system;
	private ByteBuffer soundBuffer;
	private ByteBuffer buffer;
	
	private Channel systemChannel;

	public List<String> getMediaFilePaths() {
		return mediaFilePaths;
	}
	

//	public static void main(String[] args) {
//		for (String mfp : AudioUtils.INSTANCE.getMediaFilePaths()) {
//			AudioUtils.INSTANCE.playSound(mfp);
//		}
//
//	}
	
	public AudioUtils() {
		mediaFilePaths = new ArrayList<String>();

		
		init();
		
//		initSystemSoundPlayer();
	}
	
	public void init() {
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
		
		initBuffers();
		initSystem();

		errorCheck(FmodEx.System_Create(system));

		errorCheck(system.getVersion(buffer.asIntBuffer()));
		version = buffer.getInt(0);

		if(version < FMOD_VERSION) {
			printfExit("Error!  You are using an old version of FMOD %08x.  This program requires %08x\n", version,
					FMOD_VERSION);
			return;
		}
		errorCheck(system.init(32, FMOD_INIT_NORMAL, null));
		
		systemChannel = new Channel();
	}
	void initSystem() {
		system = new System();
	}
	void initBuffers() {
		buffer = newByteBuffer(SIZEOF_INT);
	}
	private void errorCheck(FMOD_RESULT result) {
		if(result != FMOD_RESULT.FMOD_OK) {
			printfExit("FMOD error! (%d) %s\n", result.asInt(), FmodEx.FMOD_ErrorString(result));
		}
	}
	protected void print(String message) {}
	protected void printExit(String message) {
		print(message);
	}
	protected void printfExit(String format, Object... args) {
		printExit(String.format(format, args));
	}
	
	public FMDSP createDSP(DSP_KIND kind, float min, float max, float dspGain) {
		FMDSP fDSP =  new FMDSPImpl();
		DSP dsp = new DSP();
		
		FMOD_DSP_READCALLBACK myDSPCallback = new FMOD_DSP_READCALLBACK(){
			ByteBuffer nameBuffer = newByteBuffer(256);

			public FMOD_RESULT FMOD_DSP_READCALLBACK(FMOD_DSP_STATE dsp_state, FloatBuffer inbuffer, FloatBuffer outbuffer,
					int length, int inchannels, int outchannels) {
				DSP thisdsp = dsp_state.getInstance();

				/*
				 * This redundant call just shows using the instance parameter of FMOD_DSP_STATE and using it to 
				 * call a DSP information function. 
				 */
				thisdsp.getInfo(nameBuffer, null, null, null, null);
				String name = BufferUtils.toString(nameBuffer);

				/*
				 * This loop assumes inchannels = outchannels, which it will be if the DSP is created with '0' 
				 * as the number of channels in FMOD_DSP_DESCRIPTION.  
				 * Specifying an actual channel count will mean you have to take care of any number of channels coming in,
				 * but outputting the number of channels specified.  Generally it is best to keep the channel 
				 * count at 0 for maximum compatibility.
				 */
				for(int sample = 0; sample < length; sample++) {
					/*
					 * Feel free to unroll this.
					 */
					for(int channel = 0; channel < inchannels; channel++) {
						/*
						 * This DSP filter just halves the volume! 
						 * Input is modified, and sent to output.
						 */
						/*
						 * Jouvieje note:
						 *  this is valide only if inchannels == outchannels
						 */
						outbuffer.put(inbuffer.get() * 0.2f);
						//Otherwise use :
//						outbuffer.put((sample * outchannels) + channel, inbuffer.get() * 0.2f);
					}
				}
				inbuffer.rewind();
				outbuffer.rewind();

				return FMOD_OK;
			}
		};
		
		
		
		FMOD_DSP_DESCRIPTION dspdesc = FMOD_DSP_DESCRIPTION.allocate();

		dspdesc.setName("DSP unit");
		dspdesc.setChannels(0); // 0 = whatever comes in, else specify. 
		dspdesc.setRead(myDSPCallback);
		
		errorCheck(system.createDSP(dspdesc, dsp));
		
		FloatBuffer gMin = newFloatBuffer(1);
		gMin.put(min);
		
		FloatBuffer gMax = newFloatBuffer(1);
		gMax.put(max);
		
		dsp.getParameterInfo(0, null, null, null, 0, gMin, gMax);
		dsp.setParameter(0, dspGain);

		fDSP.setFmodex(dsp);
		fDSP.setKind(kind);
		return fDSP;
	}
	public AudioSound createSound(AudioSoundGroup group, String filePath, int flags) {
		AudioSound aSound = createSound(filePath, flags);
		group.getChildren().add(aSound);
		return aSound;
	}
	public String resolveMediaPath(String filePath) {
		for (String f : mediaFilePaths) {
			if (f.contains(filePath)) {
				java.lang.System.out.println(f + " Resolved !!!");
				return f;
			}
		}
		return null;
	}
	public AudioSystem createAudioSystem() {
		AudioSystem s = new AudioSystemImpl();
		s.setFmodex(system);
		return s;
	}
	public void addDSP(FMDSP dsp) {
		if (dsp.getFmodex() != null) {
			errorCheck(system.addDSP(dsp.getFmodex(), null));
		}
	}
	public AudioSound createSound(String filePath, int flags) {
		String path = resolveMediaPath(filePath);
		if (path == null) {
			File file = new File(filePath);
			if (file.exists()) {
				try {
					path = file.getCanonicalPath();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return createSoundFromFile(filePath, flags);
	}
	public AudioChannel createChannel() {
		AudioChannel aChannel =  new AudioChannelImpl();
		Channel channel = new Channel();
		aChannel.setFmodex(channel);
		return aChannel;
	}
	public AudioSound createSoundFromFile(String path, int flags) {
		if (path != null) {
			AudioSound aSound =  new AudioSoundImpl();
			Sound sound = new Sound();
			aSound.setFmodex(sound);

			if (Platform.inDebugMode()) {
				java.lang.System.out.println("About to init " + path + " Sound Buffer");
			}
			try {
				soundBuffer = Medias.loadMediaIntoMemory(path);
				if (soundBuffer != null) {
					if (Platform.inDebugMode()) {
						java.lang.System.out.println("Sound Buffer init succeeded");
					}
					exinfo = FMOD_CREATESOUNDEXINFO.allocate();
					if (exinfo != null) {
						exinfo.setLength(soundBuffer.capacity());
						errorCheck(system.createSound(soundBuffer, flags, exinfo, sound));
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				exinfo.release();
			}
			
			return aSound;
		} 
		return null;
	}
	
	public AudioFile createAudioFile(File f) {
		AudioFile file =  new AudioFileImpl();
		file.setFile(f);
		return file;
	}
	
	public AudioTrack createAudioTrack() {
		AudioTrack track 		=  new AudioTrackImpl();
		AudioChannel aChannel 	= createChannel();
		Device device			= createAudioDevice("SpectrumWidget", aChannel, track);
		track.setChannel(aChannel);
		track.getDevices().add(device);
		return track;
	}
	public Device createAudioDevice(String ID, AudioChannel aChannel, AudioTrack aTrack) {
		Device device =  new DeviceImpl();
		device.setChannel(aChannel);
		device.setTrack(aTrack);
		device.setID(ID);
		return device;
	}
	public AudioScene createAudioScene() {
		AudioScene scene =  new AudioSceneImpl();
		for (int i=0;i<25;i++) {
			scene.getClips().add(createClip("clip "+i));
		}
		return scene;
	}
	public AudioClip createClip(String label) {
		AudioClip clip =  new AudioClipImpl();
		clip.setLabel(label);
		return clip;
	}	
	public AudioClip createClip() {
		AudioClip clip =  new AudioClipImpl();
		return clip;
	}	
	public AudioProject createAudioProject() {
		AudioProject p =  new AudioProjectImpl();
		p.setSystem(createAudioSystem());
		for (int i=0; i<20; i++) {
			p.getScenes().add(createAudioScene());
		}
		return p;
	}
	public void end() {
		system.release();
	}	
	public void playSystemSound(AudioSound aSound, Channel aChannel) {
		java.lang.System.out.println("Enter playSystemSound");
		if (aSound != null && aSound.getFmodex() != null && aChannel != null) {
			errorCheck(system.playSound(FMOD_CHANNEL_FREE, aSound.getFmodex(), false, aChannel));
			if (Platform.inDebugMode()) {
				java.lang.System.out.println("playSystemSound Finished without error");
			}
		} else {
			java.lang.System.err.println("playSystemSound Finished with unknown error");
		}
	}
	public void playSound(AudioSound aSound, AudioChannel aChannel) {
		if (Platform.inDebugMode()) {
			java.lang.System.out.println("playSound");
		}
		if (aSound != null && aSound.getFmodex() != null && aChannel != null && aChannel.getFmodex() != null) {
			errorCheck(system.playSound(FMOD_CHANNEL_FREE, aSound.getFmodex(), false, aChannel.getFmodex()));
			if (Platform.inDebugMode()) {
				java.lang.System.out.println("playSound Finished without error");
			}
		} else {
			java.lang.System.out.println("playSound Finished with unknown error");
		}
	}
//	public void stopSound(AudioSound aSound, AudioChannel aChannel) {
//		errorCheck(system.playSound(FMOD_CHANNEL_FREE, aSound.getFmodex(), false, aChannel.getFmodex()));
//	}
	public TimeTag getTimePosition(AudioSound aSound, AudioChannel aChannel) {
		Sound sound		=  aSound.getFmodex();;
		Channel channel = aChannel.getFmodex();
		if (channel != null) {
			system.update();
			FMOD_RESULT result ;
			if(!channel.isNull()) {
				int ms;
				int lenms;
				boolean playing;
				boolean paused;
	
				result = channel.isPlaying(buffer);
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)) {
					errorCheck(result);
				}
				playing = buffer.get(0) != 0;
	
				result = channel.getPaused(buffer);
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)) {
					errorCheck(result);
				}
				paused = buffer.get(0) != 0;
	
				result = channel.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)) {
					errorCheck(result);
				}
				ms = buffer.getInt(0);
	
				result = sound.getLength(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)) {
					errorCheck(result);
				}
				lenms = buffer.getInt(0);
				
				CLIP_STATUS status = (!paused && !playing) ? CLIP_STATUS.STOP : (playing ? CLIP_STATUS.PLAY : CLIP_STATUS.PAUSE);
				
				TimeTag tag =  new TimeTagImpl();
				tag.setDuration(lenms);
				tag.setTime(ms);
				tag.setStatus(status);
	
				return tag;
			}
		}
		TimeTag tag =  new TimeTagImpl();
		tag.setDuration(Long.MIN_VALUE);
		tag.setTime(Long.MIN_VALUE);
		tag.setStatus(CLIP_STATUS.STOP);
		
		return tag;
	}
	public boolean isPlaying(AudioChannel aChannel) {
		try {
			if (aChannel != null && aChannel.getFmodex() instanceof Channel) {
				Channel channel = aChannel.getFmodex();
				channel.isPlaying(buffer);
				FMOD_RESULT result = FMOD_RESULT.FMOD_ERR_CHANNEL_ALLOC;
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)) {
					errorCheck(result);
				}
				return buffer.get(0) != 0;
			}
		} catch(NullPointerException e) {
			//
		}
		return false;
	}

	public System getSystem() {
		return system;
	}
//	
//	public void initSystemSoundPlayer() {
//		initSystemSound(
//			SystemSound.ERROR_1, 
//			"/Media/buzz.wav"
//		);
//		initSystemSound(
//			SystemSound.CELLULAR_RING_1, 
//			"/Media/cellular.wav"
//		);
//		initSystemSound(
//			SystemSound.CELLULAR_RING_1, 
//			"/Media/Phone-cell-41.wav"
//		);
//		initSystemSound(
//			SystemSound.FX_1, 
//			"/Media/sound_effect5.wav"
//		);
//		initSystemSound(
//			SystemSound.SMALL_BELL_RING_1, 
//			"/Media/small-bell-ring-01.mp3"
//		);
//		initSystemSound(
//			SystemSound.SMALL_BELL_RING_2, 
//			"bell-ringing-05.mp3"
//		);
//		initSystemSound(
//			SystemSound.WRONG_1, 
//			"/Media/irish_wrongnumber.mp3"
//		);
//		initSystemSound(
//			SystemSound.FX_2, 
//			"/Media/sound37.mp3"
//		);
//		initSystemSound(
//			SystemSound.FX_3, 
//			"/Media/Ekran.WAV"
//		);
//		initSystemSound(
//			SystemSound.FX_4, 
//			"/Media/FLATALO.mp3"
//		);
//		initSystemSound(
//			SystemSound.DIAL_1, 
//			"/Media/tele_5.wav" 
//		);
//		initSystemSound(
//			SystemSound.DIAL_2, 
//			"/Media/tele_5.wav"
//		);
//		initSystemSound(
//			SystemSound.BYE_1, 
//			"/Media/ByeAndSeeUSoon.wav"
//		);
//		initSystemSound(
//			SystemSound.HELLO_1, 
//			"/Media/welcomeIntoUbiquisense.wav"
//		);
//		initSystemSound(
//			SystemSound.BEEP_21, 
//			"/Media/beep-21.mp3"
//		);
//		initSystemSound(
//			SystemSound.BEEP_24, 
//			"/Media/beep-24.mp3"
//		);
//		initSystemSound(
//			SystemSound.BEEP_27, 
//			"/Media/beep-27.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_10, 
//			"/Media/button-10.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_15, 
//			"/Media/button-15.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_17, 
//			"/Media/button-17.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_19, 
//			"/Media/button-19.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_27, 
//			"/Media/button-27.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_3, 
//			"/Media/button-3.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_3, 
//			"/Media/button-3.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_31, 
//			"/Media/button-31.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_32, 
//			"/Media/button-32.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_33, 
//			"/Media/button-33.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_34, 
//			"/Media/button-34.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_37, 
//			"/Media/button-37.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_38, 
//			"/Media/button-38.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_39, 
//			"/Media/button-39.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_40, 
//			"/Media/button-40.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_41, 
//			"/Media/button-41.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_42, 
//			"/Media/button-42.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_43, 
//			"/Media/button-43.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_44, 
//			"/Media/button-44.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_46, 
//			"/Media/button-46.mp3"
//		);
//		initSystemSound(
//			SystemSound.BUTTON_48, 
//			"/Media/button-48.mp3"
//		);
//	}
//	
//	private void initSystemSound(SystemSound sound, String path) {
//		for (String p : mediaFilePaths) {
//			if (p.endsWith(path)) {
//				java.lang.System.out.println(p + " found compliant with : " + path);
//				systemSounds.put(
//					sound, 
//					createSound(
//						p, 
//						FMOD_DEFAULT | FMOD_SOFTWARE | FMOD_OPENMEMORY
//					)
//				);
//			}
//		}
//	}
//
//	public void playSound(String pathToSoundFile) {
//		if (systemSounds.containsKey(pathToSoundFile)) {
//			playSystemSound(systemSounds.get(pathToSoundFile), systemChannel);
//		} else {
//			if (pathToSoundFile.endsWith(".wav") || pathToSoundFile.endsWith(".ogg") || pathToSoundFile.endsWith(".mp3") || pathToSoundFile.endsWith(".aif")) {
//				if (Platform.inDebugMode()) {
//					java.lang.System.out.println("Load : "  + pathToSoundFile + " with compatible sound file extension");
//				}
//				File f = null;
//				try {
//					f = new File(pathToSoundFile);
//					if (f != null) {
//						if (Platform.inDebugMode()) {
//							java.lang.System.out.println("Load "+ f.getCanonicalPath());
//						}
//						AudioSound aSound = createSoundFromFile(
//							pathToSoundFile, 
//							FMOD_DEFAULT | FMOD_SOFTWARE | FMOD_OPENMEMORY
//						);
//						playSystemSound(aSound, systemChannel);	
//					}
//				} catch(IOException e2) {
//					e2.printStackTrace();
//				}
//				if (Platform.inDebugMode()) {
//					java.lang.System.out.println("Proceed with newt entry");
//				}
//			}
//		}
//	}
//
//	public void playSystemSound(SystemSound sound) {
//		if (systemSounds.containsKey(sound)) {
//			playSystemSound(systemSounds.get(sound), systemChannel);
//		}
//	}
}
