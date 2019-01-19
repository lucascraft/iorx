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

package ubiquisense.iorx.ui.audio;

//import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_MODORDER;
//import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_MS;
//import static org.jouvieje.fmodex.enumerations.FMOD_DSP_FFT_WINDOW.FMOD_DSP_FFT_WINDOW_TRIANGLE;
//import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
//import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
//import static org.jouvieje.fmodex.utils.BufferUtils.newFloatBuffer;
//import static org.jouvieje.fmodex.utils.BufferUtils.newIntBuffer;
//import static org.jouvieje.fmodex.utils.SizeOfPrimitive.SIZEOF_INT;
//
//import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//import java.nio.ByteBuffer;
//import java.nio.FloatBuffer;
//import java.nio.IntBuffer;
//import java.util.UUID;
//
//import org.jouvieje.fmodex.Channel;
//import org.jouvieje.fmodex.Sound;
//import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
//
//import javafx.scene.canvas.GraphicsContext;
//import ubiquisense.iorx.media.fmodex.AudioChannel;
//import ubiquisense.iorx.media.fmodex.AudioSound;
//import ubiquisense.iorx.media.fmodex.utils.AudioUtils;
//
public class SpectrumWidget  {

//	private FloatBuffer[] spectrumBuffer = new FloatBuffer[8];
//	private int spectrumBufferLength = 0;
//	private IntBuffer numChannels = newIntBuffer(1);
//	private int grey = 0x404040;
//
//	private Sound gSound = new Sound();
//	private Channel gChannel;
//	
//
//	public void init(AudioChannel aChannel, AudioSound aSound) {
//		if (aChannel != null) {
//			gChannel 	= aChannel.getFmodex();
//		}
//		if (aSound != null) {
//			gSound 		= aSound.getFmodex();
//		}
//	}
//
//	protected void updateProgression(int position) {
//		if(!gSound.isNull() && !gChannel.isNull()) {
//			FMOD_RESULT result;
//			IntBuffer length = newIntBuffer(1);
//
//			result = gSound.getLength(length, FMOD_TIMEUNIT_MODORDER);
//			if(result != FMOD_OK) {
//				gSound.getLength(length, FMOD_TIMEUNIT_MS);
//			}
//
//			int currentPosition = (int)(position * length.get(0) / 1000.0f);
//
//			result = gChannel.setPosition(currentPosition, FMOD_TIMEUNIT_MODORDER);
//			if(result != FMOD_OK) {
//				gChannel.setPosition(currentPosition, FMOD_TIMEUNIT_MS);
//			}
//		}
//	}
//
//	private ByteBuffer bufferGui = newByteBuffer(SIZEOF_INT);
//
//	protected void updateGui() {
//		AudioUtils.INSTANCE.getSystem().update();
//
//		if(!gChannel.isNull()) {
//			FMOD_RESULT result;
//			@SuppressWarnings("unused")
//			int currTime, length;
//			boolean playing;
//
//			result = gChannel.getPosition(bufferGui.asIntBuffer(), FMOD_TIMEUNIT_MODORDER);
//			if(result != FMOD_OK) {
//				gChannel.getPosition(bufferGui.asIntBuffer(), FMOD_TIMEUNIT_MS);
//			}
//			currTime = bufferGui.getInt(0);
//
//			result = gSound.getLength(bufferGui.asIntBuffer(), FMOD_TIMEUNIT_MODORDER);
//			if(result != FMOD_OK) {
//				gSound.getLength(bufferGui.asIntBuffer(), FMOD_TIMEUNIT_MS);
//			}
//			length = bufferGui.getInt(0);
//
//			//getProgressBar().setValue((int)((float)currTime / (float)length * 1000.0f));
//
//			gChannel.isPlaying(bufferGui);
//			playing = bufferGui.get(0) != 0;
//			if(!playing) {
//				gChannel = new Channel();
//				//getPlayStop().setText("Play");
//			}
//		}
//	}
//
//	private void plotSpectrum(Graphics2D gc, int w, int h, boolean uselog) {
//		FMOD_RESULT result = AudioUtils.INSTANCE.getSystem().getSoftwareFormat(null, null, numChannels, null, null, null);
//		if(result != FMOD_OK) {
//			return;
//		}
//		if(spectrumBufferLength < numChannels.get(0)) {
//			for(int i = spectrumBufferLength; i < numChannels.get(0); i++) {
//				spectrumBuffer[i] = newFloatBuffer(512);
//			}
//			spectrumBufferLength = numChannels.get(0);
//		}
//
//		int GRAPHICWINDOW_WIDTH		= w;
//		int GRAPHICWINDOW_HEIGHT	= h;
//
//		//Draw spectrum offscreen
//		BufferedImage image = new BufferedImage(GRAPHICWINDOW_WIDTH, GRAPHICWINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);
//		
//		/*
//		 * Draw a black square with grey lines through it.
//		 */
//		for(int x = 0; x < GRAPHICWINDOW_WIDTH; x++) {
//			for(int y = 0; y < 30; y++) {
//				image.setRGB(x, GRAPHICWINDOW_HEIGHT * y / 30, grey);
//			}
//		}
//		for(int x = 0; x < GRAPHICWINDOW_WIDTH; x += 64) {
//			for(int y = 0; y < GRAPHICWINDOW_HEIGHT; y++) {
//				image.setRGB(x, y, grey);
//			}
//		}
//
//		float max = 0;
//		for(int i = 0; i < numChannels.get(0); i++) {
//			//returns an array of 512 floats
//			result = AudioUtils.INSTANCE.getSystem().getSpectrum(spectrumBuffer[i], 512, i, FMOD_DSP_FFT_WINDOW_TRIANGLE);
//			if(result != FMOD_OK) {
//				return;
//			}
//
//			{
//				for(int j = 0; j < 512; j++) {
//					if(spectrumBuffer[i].get(j) > max) {
//						max = spectrumBuffer[i].get(j);
//					}
//				}
//			}
//
//			if(max > 0.0001f) {
//				/*
//				 * Spectrum graphic is 256 entries wide, and the spectrum is 512 entries.
//				 * The upper band of frequencies at 44khz is pretty boring (ie 11-22khz), so we are only
//				 * going to display the first 256 frequencies, or (0-11khz)
//				 */
//				for(int x = 0; x < 512; x++) {
//					float val, db;
//					int y;
//
//					val = spectrumBuffer[i].get(x);
//
//					if(uselog) {
//						/*
//						 * 1.0   = 0db
//						 * 0.5   = -6db
//						 * 0.25  = -12db
//						 * 0.125 = -24db
//						 */
//						db = 10.0f * (float)Math.log10(val) * 2.0f;
//
//						val = db;
//						if(val < -150) {
//							val = -150;
//						}
//
//						val /= -150.0f;
//						val = 1.0f - val;
//
//						y = (int)(val * GRAPHICWINDOW_HEIGHT);
//					}
//					else {
//						y = (int)(val / max * GRAPHICWINDOW_HEIGHT);
//					}
//
//					if(y >= GRAPHICWINDOW_HEIGHT) {
//						y = GRAPHICWINDOW_HEIGHT - 1;
//					}
//
//					for(int j = 0; j < y; j++) {
//						int r, g, b;
//
//						r = (j << 1);
//						g = 0xFF - (j << 1);
//						b = 0x1F;
//
//						image.setRGB(x * GRAPHICWINDOW_WIDTH / 512, GRAPHICWINDOW_HEIGHT - 1 - j, (r << 16) + (g << 8)
//								+ b);
//					}
//				}
//			}
//		}
//
//		//Draw the spectrum on the screen
//			gc.drawImage(image, 0, 0, w, h, null);
//	}
//
//	private int oscColor = 0xffffaf;
//	private FloatBuffer oscBuffer;
//	private void plotOscilliscope(Graphics2D gc, int w, int h) {
//		int GRAPHICWINDOW_WIDTH		= w;
//		int GRAPHICWINDOW_HEIGHT	= w;
//
//		if (oscBuffer == null) {
//			oscBuffer = newFloatBuffer(GRAPHICWINDOW_WIDTH);
//		} else if (oscBuffer.capacity() != GRAPHICWINDOW_WIDTH) {
//			oscBuffer = newFloatBuffer(GRAPHICWINDOW_WIDTH);
//		}
//		
//		float xoff, step;
//		
//		FMOD_RESULT result = AudioUtils.INSTANCE.getSystem().getSoftwareFormat(null, null, numChannels, null, null, null);
//		if(result != FMOD_OK) {
//			return;
//		}
//
//		//Draw spectrum offscreen
//		BufferedImage image = new BufferedImage(GRAPHICWINDOW_WIDTH, GRAPHICWINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);
//
//		for(int channel = 0; channel < numChannels.get(0); channel++) {
//			AudioUtils.INSTANCE.getSystem().getWaveData(oscBuffer, GRAPHICWINDOW_WIDTH, channel);
//
//			/*
//			 * xoff is the x position that is scaled lookup of the dsp block according to the graphical
//			 * window size.
//			 */
//			xoff = 0;
//			step = 1;
//
//			for(int i = 0; i < GRAPHICWINDOW_WIDTH - 1; i++) {
//				int x, y, y2;
//
//				x = (int)xoff;
//				y = (int)((oscBuffer.get(x) + 1.0f) / 2.0f * GRAPHICWINDOW_HEIGHT);
//				y2 = (int)((oscBuffer.get(x + (int)step) + 1.0f) / 2.0f * GRAPHICWINDOW_HEIGHT);
//
//				y = y < 0 ? 0 : y >= GRAPHICWINDOW_HEIGHT ? GRAPHICWINDOW_HEIGHT - 1 : y;
//				y2 = y2 < 0 ? 0 : y2 >= GRAPHICWINDOW_HEIGHT ? GRAPHICWINDOW_HEIGHT - 1 : y2;
//
//				if(y > y2) {
//					int tmp = y;
//					y = y2;
//					y2 = tmp;
//				}
//
//				for(int j = y; j <= y2; j++) {
//					image.setRGB(i, j, oscColor);
//				}
//
//				xoff += step;
//			}v
//		}
//			
//		gc.drawImage(image, 0, 0, w, h, null);
//		
//	}

	

}
