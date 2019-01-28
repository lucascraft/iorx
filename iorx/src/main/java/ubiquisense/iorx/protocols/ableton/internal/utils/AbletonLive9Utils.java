/***********************************************************************************
 * Ubiquisense - A smart ambient utilities framework 
 * 
 * Copyright (c) 2008 - 2010, Lucas Bigeardel
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

package ubiquisense.iorx.protocols.ableton.internal.utils;

import java.util.ArrayList;
import java.util.List;

import com.illposed.osc.OSCBundle;
import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPacket;

import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.protocols.ableton.internal.AbletonLiveSndCmd;
import ubiquisense.iorx.protocols.ableton.internal.CLIP_STATE;
import ubiquisense.iorx.protocols.ableton.internal.LiveArmReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveClipInfo;
import ubiquisense.iorx.protocols.ableton.internal.LiveClipPosition;
import ubiquisense.iorx.protocols.ableton.internal.LiveDetailView;
import ubiquisense.iorx.protocols.ableton.internal.LiveDevice;
import ubiquisense.iorx.protocols.ableton.internal.LiveDeviceParam;
import ubiquisense.iorx.protocols.ableton.internal.LiveDeviceParamSet;
import ubiquisense.iorx.protocols.ableton.internal.LiveDeviceRange;
import ubiquisense.iorx.protocols.ableton.internal.LiveDeviceRangeAllQ;
import ubiquisense.iorx.protocols.ableton.internal.LiveDeviceRangeQ;
import ubiquisense.iorx.protocols.ableton.internal.LiveDeviceView;
import ubiquisense.iorx.protocols.ableton.internal.LiveDevicelist;
import ubiquisense.iorx.protocols.ableton.internal.LiveMasterDeviceView;
import ubiquisense.iorx.protocols.ableton.internal.LiveMasterMeter;
import ubiquisense.iorx.protocols.ableton.internal.LiveMasterPanReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveMasterVolume;
import ubiquisense.iorx.protocols.ableton.internal.LiveMasterVolumeReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveMuteReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveNameClipQ;
import ubiquisense.iorx.protocols.ableton.internal.LiveNameClipReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveNameClipblockreq;
import ubiquisense.iorx.protocols.ableton.internal.LiveNameSceneBlockReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveNameSceneQ;
import ubiquisense.iorx.protocols.ableton.internal.LiveNameSceneReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveNameTrackQ;
import ubiquisense.iorx.protocols.ableton.internal.LiveNameTrackReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveNameTrackblockReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveNextCueReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveOverdub;
import ubiquisense.iorx.protocols.ableton.internal.LivePanSet;
import ubiquisense.iorx.protocols.ableton.internal.LivePitchSet;
import ubiquisense.iorx.protocols.ableton.internal.LivePlay;
import ubiquisense.iorx.protocols.ableton.internal.LivePlayClipReq;
import ubiquisense.iorx.protocols.ableton.internal.LivePlayClipSlotReq;
import ubiquisense.iorx.protocols.ableton.internal.LivePlayContinueReq;
import ubiquisense.iorx.protocols.ableton.internal.LivePlayReq;
import ubiquisense.iorx.protocols.ableton.internal.LivePlaySceneReq;
import ubiquisense.iorx.protocols.ableton.internal.LivePrevCueReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveRedoReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnDeviceRangeAllQ;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnDeviceRangeQ;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnDeviceView;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnDevicelist;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnMeter;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnMuteReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnPan;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnPanReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnSend;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnSendReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnSolo;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnVolume;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnVolumeReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveScene2;
import ubiquisense.iorx.protocols.ableton.internal.LiveSceneReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveScenesQ;
import ubiquisense.iorx.protocols.ableton.internal.LiveSendReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveStateRcv;
import ubiquisense.iorx.protocols.ableton.internal.LiveStateReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveStopClipReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveStopReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveTempoRcv;
import ubiquisense.iorx.protocols.ableton.internal.LiveTempoReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveTimeRcv;
import ubiquisense.iorx.protocols.ableton.internal.LiveTimeReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackDeviceView;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackInfo;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackJump;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackMeter;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackMute;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackName;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackPan;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackPitch;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackSend;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackSolo;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackVolume;
import ubiquisense.iorx.protocols.ableton.internal.LiveTracksQ;
import ubiquisense.iorx.protocols.ableton.internal.LiveTracksReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveUndoReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveVolume;
import ubiquisense.iorx.protocols.ableton.internal.LiveVolumeSet;
import ubiquisense.iorx.protocols.ableton.internal.METER_INPUT;
import ubiquisense.iorx.protocols.ableton.internal.PLAY_STATUS;
import ubiquisense.iorx.protocols.ableton.internal.TRACK_ARM_STATUS;
import ubiquisense.iorx.protocols.ableton.internal.TRACK_MUTE_STATUS;
import ubiquisense.iorx.protocols.ableton.internal.TRACK_SOLO_STATUS;
import ubiquisense.iorx.protocols.ableton.internal.livePlaySelectionReq;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveArmReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveClipInfoImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveClipPositionImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveDetailViewImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveDeviceImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveDeviceParamImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveDeviceRangeAllQImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveDeviceRangeImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveDeviceRangeQImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveDeviceViewImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveDevicelistImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveMasterDeviceViewImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveMasterMeterImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveMasterPanReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveMasterVolumeImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveMuteReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveNameClipQImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveNameClipReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveNameClipblockreqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveNameSceneBlockReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveNameSceneQImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveNameSceneReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveNameTrackQImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveNameTrackReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveNameTrackblockReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveNextCueReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveOverdubImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LivePanSetImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LivePitchSetImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LivePlayClipReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LivePlayClipSlotReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LivePlayContinueReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LivePlayImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LivePlaySceneReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LivePrevCueReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveRedoReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveReturnDeviceRangeAllQImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveReturnDeviceRangeQImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveReturnMeterImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveReturnPanImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveReturnSendImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveReturnSoloImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveReturnVolumeImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveScene2Impl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveSceneReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveScenesQImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveSendReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveStateReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveStopClipReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveStopReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveTempoRcvImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveTempoReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveTimeRcvImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveTimeReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveTrackDeviceViewImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveTrackInfoImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveTrackJumpImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveTrackMeterImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveTrackMuteImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveTrackNameImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveTrackPanImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveTrackPitchImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveTrackSendImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveTrackSoloImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveTrackVolumeImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveTracksQImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveTracksReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveUndoReqImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveVolumeImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.LiveVolumeSetImpl;
import ubiquisense.iorx.protocols.ableton.internal.impl.livePlaySelectionReqImpl;

public class AbletonLive9Utils {
	
	public final static AbletonLive9Utils INSTANCE = new AbletonLive9Utils();
	
	public AbletonLiveSndCmd handleAbletonLiveOSCPacket(OSCPacket packet) {
		AbletonLiveSndCmd cmd = null;
		try {
			cmd = _handleAbletonLiveOSCPacket(packet);
			if (cmd != null) {
				cmd.setMsg(packet);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return cmd;
	}
	
	private AbletonLiveSndCmd _handleAbletonLiveOSCPacket(OSCPacket packet) throws Exception {
		if (packet instanceof OSCMessage) {
			OSCMessage msg = (OSCMessage) packet;
			String addr = msg.getAddress();
			
			if (addr.equals("/live/scenes")) {
				Object[] args = msg.getArguments().toArray();
				Integer numScenes = (Integer) args[0];
				return createLiveScenesQ(numScenes);
			} else if (addr.equals("/live/tracks")) {
				Object[] args = msg.getArguments().toArray();
				Integer numTracks = (Integer) args[0];
				return createLiveTracksQ(numTracks);
			} else if (addr.equals("/live/tempo")) {
				Object[] args = msg.getArguments().toArray();
				Float tempo = (Float) args[0];
				return createLiveTempo(tempo);
			} else if (addr.equals("/live/time")) {
				Object[] args = msg.getArguments().toArray();
				Float time = (Float) args[0];
				return createLiveTime(time);
			} else if (addr.equals("/live/master/meter")) {
				Object[] args = msg.getArguments().toArray();
				Integer which = (Integer) args[0];
				Float level = (Float) args[1];
				return createLiveMasterMeter(which, level);
			}  else if (addr.equals("/live/track/meter")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer which = (Integer) args[1];
				Float level = (Float) args[2];
				return createLiveTrackMeter(trackID, which, level);
			} else if (addr.equals("/live/arm")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer value = (Integer) args[1];
				return createLiveArm(trackID, value);
			} else if (addr.equals("/live/clip/info")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID		= (Integer) args[0];
				Integer clipID		= (Integer) args[1];
				Integer clipState	= (Integer) args[2];
				return createLiveClipInfo(trackID, clipID, clipState);
			} else if (addr.equals("/live/clip/position")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID		= (Integer) args[0];
				Integer clipID		= (Integer) args[1];
				Float position		= (Float)   args[2];
				Float length		= (Float)   args[3];
				Float loopStart		= (Float)   args[4];
				Float loopEnd		= (Float)   args[5];
				return createLiveClipPosition(trackID, clipID, position, length, loopStart, loopEnd);
			} else if (addr.equals("/live/detail/view")) {
				Object[] args = msg.getArguments().toArray();
				Integer value = (Integer) args[0];
				((LiveDetailView)msg).setValue(value);
				return createLiveDetailView(value);
			} else if (addr.equals("/live/device/param")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer deviceID = (Integer) args[1];
				Integer param = (Integer) args[2];
				Object obj = args[3];
				String name = (String) args[4];
				return createLiveDevice(trackID, deviceID, param, obj, name);
			}   else if (addr.equals("/live/device")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer deviceID = (Integer) args[1];
				Integer param = (Integer) args[2];
				return createLiveDevice(trackID, deviceID, param);
			}  else if (addr.equals("/live/device/range")) {
				return createLiveDeviceRange(msg);
			}  else if (addr.equals("/live/return/device/range")) {
				return createLiveReturnDeviceRange(msg);
			} else if (addr.equals("/live/devicelist")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				return createLiveDevicelist(trackID);
			} else if (addr.equals("/live/master/device/view")) {
				Object[] args = msg.getArguments().toArray();
				Integer deviceID = (Integer) args[0];
				return createLiveMasterDeviceView(deviceID);
			} else if (addr.equals("/live/master/pan")) {
				Object[] args = msg.getArguments().toArray();
				Float pan = (Float) args[0];
				return createLiveMasterPan(0, pan);
			} else if (addr.equals("/live/master/volume")) {
				Object[] args = msg.getArguments().toArray();
				Float level = (Float) args[0];
				return createLiveMasterVolume(0, level);
			} else if (addr.equals("/live/mute")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer status = (Integer) args[1];
				TRACK_MUTE_STATUS STATUS = status == TRACK_MUTE_STATUS.MUTE.getValue() ? TRACK_MUTE_STATUS.MUTE : TRACK_MUTE_STATUS.UNMUTE;
				return createLiveMute(trackID, STATUS);
			} else if (addr.equals("/live/name/clipblock")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer clipID = (Integer) args[1];
				Integer sizeX = (Integer) args[2];
				Integer sizeY = (Integer) args[3];
				return createLiveNameClipblock(trackID, clipID, sizeX, sizeY);
			} else if (addr.equals("/live/name/clip")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer clipID = (Integer) args[1];
				String label = (String) args[2];
				Integer color = (Integer) args[3];
				return createLiveNameClip(trackID, clipID, label, color);
			} else if (addr.equals("/live/name/scene/block")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer size = (Integer) args[1];
				return createLiveNameSceneBlock(trackID, size);
			} else if (addr.equals("/live/name/scene")) {
				Object[] args = msg.getArguments().toArray();
				Integer sceneID = (Integer) args[0];
				String sceneName = (String) args[1];
				return createLiveNameScene(sceneID, sceneName);
			} else if (addr.equals("/live/name/trackblock")) {
				Object[] args = msg.getArguments().toArray();
				return createLiveNameTrackblock(args);
			} else if (addr.equals("/live/name/track")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				String trackName = (String) args[1];
				Integer color = 0;
				if (args.length > 2) {
					color = (Integer) args[2];
				}
				return createLiveNameTrack(trackID, trackName, color);
			} else if (addr.equals("/live/next/cue")) {
				return createLiveNextCue();
			} else if (addr.equals("/live/prev/cue")) {
				return createLivePrevCue();
			} else if (addr.equals("/live/pan/set")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Float value = (Float) args[1];
				((LivePanSet)msg).setTrackID(trackID);
				((LivePanSet)msg).setValue(value);
				return createLivePanSet(msg);
			} else if (addr.equals("/live/pitch/set")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer clip = (Integer) args[1];
				Integer coarse = (Integer) args[2];
				Integer fine = (Integer) args[3];
				
				((LivePitchSet)msg).setTrackID(trackID);
				((LivePitchSet)msg).setClip(clip);
				((LivePitchSet)msg).setCoarse(coarse);
				((LivePitchSet)msg).setFine(fine);
				return createLivePitchSet(trackID, clip, coarse, fine);
			} else if (addr.equals("/live/play/clip")) {
				createLivePlayClip();
			} else if (addr.equals("/live/play/clipslot")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer clip = (Integer) args[1];
				return createLivePlayClipslot(trackID, clip);
			} else if (addr.equals("/live/play/continue")) {
				return createLivePlayContinue();
			} else if (addr.equals("/live/play")) {
				Object[] args = msg.getArguments().toArray();
				Integer status = (Integer) args[0];
				return createLivePlay(status);
			} else if (addr.equals("/live/play/scene")) {
				Object[] args = msg.getArguments().toArray();
				Integer sceneID = (Integer) args[0];
				return createLivePlayScene(sceneID);
			} else if (addr.equals("/live/prec/cue")) {
				return createLivePrecCue();
			} else if (addr.equals("/live/redo")) {
				return createLiveRedo();
			} else if (addr.equals("/live/return/devicelist")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				return createLiveDevicelist(trackID);
			} else if (addr.equals("/live/return/meter")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer which = (Integer) args[1];
				Float level = (Float) args[2];
				return createLiveReturnMeter(trackID, which, level);
			}  else if (addr.equals("/live/track/meter")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer which = (Integer) args[1];
				Float level = (Float) args[2];
				return createLiveTrackMeter(trackID, which, level);
			}  else if (addr.equals("/live/return/device/view")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer deviceID = (Integer) args[1];
				return createLiveDeviceView(trackID, deviceID);
			} else if (addr.equals("/live/return/mute")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer status = (Integer) args[1];
				TRACK_MUTE_STATUS muteStatus = status == TRACK_MUTE_STATUS.MUTE_VALUE ? TRACK_MUTE_STATUS.MUTE : TRACK_MUTE_STATUS.UNMUTE;
				return createLiveMute(trackID, muteStatus);
			} else if (addr.equals("/live/return/pan")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Float pan  = (Float) args[1];
				return createLiveReturnPan(trackID, pan);
			} else if (addr.equals("/live/return/send")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer send = (Integer) args[1];
				Float level = (Float) args[2];
				return createLiveReturnSend(trackID, level, send);
			} else if (addr.equals("/live/return/solo")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				return createLiveReturnSolo(trackID);
			} else if (addr.equals("/live/return/volume")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Float value = (Float) args[1];
				return createLiveReturnVolume(trackID, value);
			} else if (addr.equals("/live/scene")) {
				Object[] args = msg.getArguments().toArray();
				Integer mode = (Integer) args[0];
				return createLiveScene2(mode);
			} else if (addr.equals("/live/send")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer value = (Integer) args[1];
				return createLiveSend(trackID, value);
			} else if (addr.equals("/live/state")) {
				return createLiveState();
			} else if (addr.equals("/live/stop/clip")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer clipID = (Integer) args[1];
				return createLiveStopClip(trackID, clipID);
			} else if (addr.equals("/live/track/info")) {
				return createLiveTrackInfo();
			} else if (addr.equals("/live/stop")) {
				return createLiveStop();
			} else if (addr.equals("/live/track/device/view")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Integer deviceID = (Integer) args[1];
				return createLiveTrackDeviceView(trackID, deviceID);
			} else if (addr.equals("/live/track/jump")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Float beats = (Float) args[1];
				return createLiveTrackJump(trackID, beats);
			} else if (addr.equals("/live/tracks")) {
				return createLiveTracks();
			} else if (addr.equals("/live/undo")) {
				return createLiveUndo();
			}  else if (addr.equals("/live/volume")) {
				AbletonLiveSndCmd cmd = null;
				Object[] args = msg.getArguments().toArray();
				if (args[0] instanceof Integer) {
					Integer trackID = (Integer) args[0];
					Float level = (Float) args[1];
					cmd = createLiveVolume(trackID, level);
				} else {				
					Float level = (Float) args[0];
					cmd = createLiveVolume(level);
				}
				return cmd;
			} else if (addr.equals("/live/time")) {
				Object[] args = msg.getArguments().toArray();
				Float time = (Float) args[0];
				return createLiveTime(time);
			} else if (addr.equals("/live/volume/set")) {
				Object[] args = msg.getArguments().toArray();
				Integer trackID = (Integer) args[0];
				Float level = (Float) args[1];
				return createLiveVolumeSet(trackID, level);
			} else if (addr.equals("/live/play/selection")) {
				return createLivePlaySelection();
			}
		} else if (packet instanceof OSCBundle) {
			// As far as I know, there is no case of OSCBundle in Ableton Live 
			throw new UnsupportedOperationException();
		}
		
		return null;
	}
	
	public AbletonLiveSndCmd createLiveScenesQ() {
		return new LiveScenesQImpl();
	}
	
	public AbletonLiveSndCmd createLiveScenesQ(int numScenes) {
		LiveScenesQ liveScenesQ = new LiveScenesQImpl();
		liveScenesQ.setNumScenes(numScenes);
		return liveScenesQ;
	}
	
	public AbletonLiveSndCmd createLiveVolume(float level) {
		LiveVolume liveVolume = new LiveVolumeImpl();
		liveVolume.setLevel(level);
		return liveVolume;
	}
	
	public AbletonLiveSndCmd createLiveVolume(int trackID, float level) {
		LiveVolume liveVolume = new LiveVolumeImpl();
		liveVolume.setTrackID(trackID);
		liveVolume.setLevel(level);
		return liveVolume;
	}
	
	public AbletonLiveSndCmd createLiveTracksQ() {
		return new LiveTracksQImpl();
	}
	
	public AbletonLiveSndCmd createLiveTracksQ(int numTracks) {
		LiveTracksQ liveTracksQ = new LiveTracksQImpl();
		liveTracksQ.setNumTracks(numTracks);
		return liveTracksQ;
	}
	
	public AbletonLiveSndCmd createLiveTrackMeter(int trackID, int direction, float level) {
		LiveTrackMeter liveTrackMeter = new LiveTrackMeterImpl();
		liveTrackMeter.setTrackID(trackID);
		liveTrackMeter.setLevel(level);
		liveTrackMeter.setWhich(direction==0?METER_INPUT.LEFT_METER:METER_INPUT.RIGHT_METER);
		return liveTrackMeter;
	}
	
	public AbletonLiveSndCmd createLiveTempo(float tempo) { 
		LiveTempoRcv liveTempoRcv = new LiveTempoRcvImpl();
		liveTempoRcv.setStamp(new Float(tempo).longValue());
		return liveTempoRcv; 
	}
	
	public AbletonLiveSndCmd createLiveArm(int trackID, int status) {
		LiveArmReq liveArmReq = new LiveArmReqImpl();
		liveArmReq.setTrackID(trackID);
		liveArmReq.setStatus(status==TRACK_ARM_STATUS.ARMED_VALUE ? TRACK_ARM_STATUS.ARMED : TRACK_ARM_STATUS.DISARMED);
		return liveArmReq; 
	}
	
	public AbletonLiveSndCmd createLiveClipPosition(int trackID, int clipID, float position, float length, float loopStart, float loopEnd) {
		LiveClipPosition liveClipPosition = new LiveClipPositionImpl();
		liveClipPosition.setTrackID(trackID);
		liveClipPosition.setClipID(clipID);
		liveClipPosition.setPosition(position);
		liveClipPosition.setLength(length);
		liveClipPosition.setLoopStart(loopStart);
		liveClipPosition.setLoopEnd(loopEnd);
		return liveClipPosition;
	}
	
	public AbletonLiveSndCmd createLiveClipInfo(int trackID, int clipID, int clipState) {
		LiveClipInfo liveClipInfo = new LiveClipInfoImpl();
		liveClipInfo.setTrackID(trackID);
		liveClipInfo.setClipID(clipID);
		liveClipInfo.setStatus(CLIP_STATE.get(clipState));
		return liveClipInfo; 
	}
	
	public AbletonLiveSndCmd createLiveDetailView(int value) {
		LiveDetailView liveDetailView = new LiveDetailViewImpl();
		liveDetailView.setValue(value);
		return liveDetailView; 
	}
	
	public AbletonLiveSndCmd createLiveMasterMeter(int which, float level) {
		LiveMasterMeter liveMasterMeter = new LiveMasterMeterImpl();
		liveMasterMeter.setWhich(which==0?METER_INPUT.LEFT_METER:METER_INPUT.RIGHT_METER);
		liveMasterMeter.setLevel(level);
		return liveMasterMeter;
	}
	
	public AbletonLiveSndCmd createLiveDevice(int trackID, int deviceID, int param) {
		LiveDevice liveDevice = new LiveDeviceImpl();
		liveDevice.setTrackID(trackID);
		liveDevice.setDeviceID(deviceID);
		liveDevice.setParam(param);
		return liveDevice; 
	}
	
	public AbletonLiveSndCmd createLiveDevice(int trackID, int deviceID, int param, Object val, String name) {
		LiveDeviceParam liveDeviceParam = new LiveDeviceParamImpl();
		liveDeviceParam.setTrackID(trackID);
		liveDeviceParam.setDeviceID(deviceID);
		liveDeviceParam.setParam(param);
		liveDeviceParam.setValue(val);
		liveDeviceParam.setName(name);
		liveDeviceParam.setType(val != null ? val.getClass().getCanonicalName() : "");
		
		return liveDeviceParam; 
	}
	
	public AbletonLiveSndCmd createLiveMasterDeviceView(int deviceID) {
		LiveMasterDeviceView liveMasterDeviceView = new LiveMasterDeviceViewImpl();
		liveMasterDeviceView.setDeviceID(deviceID);
		return liveMasterDeviceView; 
	}
	
	public AbletonLiveSndCmd createLiveMasterPan(int trackID, float pan) {
		LiveMasterPanReq liveMasterPanReq = new LiveMasterPanReqImpl();
		liveMasterPanReq.setTrackID(trackID);
		liveMasterPanReq.setPan(pan);
		return liveMasterPanReq; 
	}
	
	public AbletonLiveSndCmd createLiveMasterVolume(int trackID, float level) {
		LiveMasterVolume liveMasterVolume = new LiveMasterVolumeImpl();
		liveMasterVolume.setTrackID(trackID);
		liveMasterVolume.setLevel(level);
		return liveMasterVolume; 
	}
	
	public AbletonLiveSndCmd createLiveNameClipblock(int trackID, int clipID, int sizeX, int sizeY) {
		LiveNameClipblockreq liveNameClipblockreq = new LiveNameClipblockreqImpl();
		liveNameClipblockreq.setTrackID(trackID);
		liveNameClipblockreq.setClipID(clipID);
		liveNameClipblockreq.setSizeX(sizeX);
		liveNameClipblockreq.setSizeY(sizeY);
		return liveNameClipblockreq; 
	}
	
	public AbletonLiveSndCmd createLiveNameClip(int trackID, int clipID, String label, int color) {
		LiveNameClipReq liveNameClipReq = new LiveNameClipReqImpl();
		liveNameClipReq.setTrackID(trackID);
		liveNameClipReq.setClipID(clipID);
		liveNameClipReq.setLabel(label);
		liveNameClipReq.setColor(color);
		return liveNameClipReq; 
	}
	
	public AbletonLiveSndCmd createLiveNameSceneBlock(int trackID, int size) {
		LiveNameSceneBlockReq liveNameSceneBlockReq = new LiveNameSceneBlockReqImpl();
		liveNameSceneBlockReq.setTrackID(trackID);
		liveNameSceneBlockReq.setSize(size);
		return liveNameSceneBlockReq; 
	}
	
	public AbletonLiveSndCmd createLiveNameScene(int  sceneID, String name) {
		LiveNameSceneReq liveNameSceneReq = new LiveNameSceneReqImpl();
		liveNameSceneReq.setSceneID(sceneID);
		liveNameSceneReq.setSceneName(name);
		return liveNameSceneReq; 
	}
	
	public AbletonLiveSndCmd createLiveNameTrackblock(Object[] args){
		LiveNameTrackblockReq liveNameTrackblockReq = new LiveNameTrackblockReqImpl();
		liveNameTrackblockReq.setTrackID(0);
		liveNameTrackblockReq.setSize(args.length);
		
		List<String> trackNames = new ArrayList<String>();
		for (Object o : args) {
			trackNames.add((String)o);
		}
		
		liveNameTrackblockReq.getTrackName().addAll(trackNames);
		
		return liveNameTrackblockReq; 
	}
	
	public AbletonLiveSndCmd createLiveNameTrackQ() {
		return new LiveNameTrackQImpl();
	}
	
	public AbletonLiveSndCmd createLiveNameSceneQ() {
		return new LiveNameSceneQImpl();
	}
	
	public AbletonLiveSndCmd createLiveNameClipQ() {
		return new LiveNameClipQImpl();
	}
	
	public AbletonLiveSndCmd createLiveNameTrack(int trackID, String name, int color) {
		LiveNameTrackReq liveNameTrackReq = new LiveNameTrackReqImpl();
		liveNameTrackReq.setTrackID(trackID);
		liveNameTrackReq.setTrackName(name);
		liveNameTrackReq.setColor(color);
		return liveNameTrackReq; 
	}
	
	public AbletonLiveSndCmd createLiveNameTrack(int trackID) {
		LiveNameTrackReq liveNameTrackReq = new LiveNameTrackReqImpl();
		liveNameTrackReq.setTrackID(trackID);
		return liveNameTrackReq; 
	}
	
	public AbletonLiveSndCmd createLiveNextCue() {
		return new LiveNextCueReqImpl();
	}
	
	public AbletonLiveSndCmd createLivePrevCue() { 
		return new LivePrevCueReqImpl();
	}
	
	public AbletonLiveSndCmd createLivePanSet(OSCMessage msg) { 
		return new LivePanSetImpl();
	}
	
	public AbletonLiveSndCmd createLiveDeviceRangeQ(int trackID, int deviceID, int param) {
		LiveDeviceRangeQ liveDeviceRange = new LiveDeviceRangeQImpl();
		liveDeviceRange.setTrackID(trackID);
		liveDeviceRange.setDeviceID(deviceID);
		liveDeviceRange.setParam(param);
		return liveDeviceRange;
	}
	
	public AbletonLiveSndCmd createLiveDeviceRangeAllQ(int trackID, int deviceID) {
		LiveDeviceRangeAllQ liveDeviceRange = new LiveDeviceRangeAllQImpl();
		liveDeviceRange.setTrackID(trackID);
		liveDeviceRange.setDeviceID(deviceID);
		return liveDeviceRange;
	}
	
	public AbletonLiveSndCmd createLiveReturnDeviceRangeQ(int trackID, int deviceID, int param) {
		LiveReturnDeviceRangeQ liveDeviceRange = new LiveReturnDeviceRangeQImpl();
		liveDeviceRange.setTrackID(trackID);
		liveDeviceRange.setDeviceID(deviceID);
		liveDeviceRange.setParam(param);
		return liveDeviceRange;
	}
	
	public AbletonLiveSndCmd createLiveReturnDeviceRangeAllQ(int trackID, int deviceID) {
		LiveReturnDeviceRangeAllQ liveDeviceRange = new LiveReturnDeviceRangeAllQImpl();
		liveDeviceRange.setTrackID(trackID);
		liveDeviceRange.setDeviceID(deviceID);
		return liveDeviceRange;
	}
	
	public AbletonLiveSndCmd createLiveDeviceRange(OSCMessage msg) {
		LiveDeviceRange liveDeviceRange = new LiveDeviceRangeImpl();
		liveDeviceRange.setTrackID((Integer)msg.getArguments().get(0));
		liveDeviceRange.setDeviceID((Integer)msg.getArguments().get(1));
		liveDeviceRange.setMsg(msg);
		return liveDeviceRange;
	}
	
	public AbletonLiveSndCmd createLiveDeviceRangeAll(OSCMessage msg) {
		LiveDeviceRangeAllQ liveDeviceRange = new LiveDeviceRangeAllQImpl();
		liveDeviceRange.setTrackID((Integer)msg.getArguments().get(0));
		liveDeviceRange.setDeviceID((Integer)msg.getArguments().get(1));
		liveDeviceRange.setMsg(msg);
		return liveDeviceRange;
	}
	
	public AbletonLiveSndCmd createLiveReturnDeviceRange(OSCMessage msg) {
		LiveReturnDeviceRangeQ liveDeviceRange = new LiveReturnDeviceRangeQImpl();
		liveDeviceRange.setTrackID((Integer)msg.getArguments().get(0));
		liveDeviceRange.setDeviceID((Integer)msg.getArguments().get(1));
		liveDeviceRange.setMsg(msg);
		return liveDeviceRange;
	}
	
	public AbletonLiveSndCmd createLiveReturnDeviceRangeAll(OSCMessage msg) {
		LiveReturnDeviceRangeAllQ liveDeviceRange = new LiveReturnDeviceRangeAllQImpl();
		liveDeviceRange.setTrackID((Integer)msg.getArguments().get(0));
		liveDeviceRange.setDeviceID((Integer)msg.getArguments().get(1));
		liveDeviceRange.setMsg(msg);
		return liveDeviceRange;
	}
	
	public AbletonLiveSndCmd createLivePitchSet(int trackID, int clip, int coarse, int fine) {
		LivePitchSet livePitchSet = new LivePitchSetImpl();
		livePitchSet.setTrackID(trackID);
		livePitchSet.setClip(clip);
		livePitchSet.setCoarse(coarse);
		livePitchSet.setFine(fine);
		return livePitchSet;
	}
	
	public AbletonLiveSndCmd createLivePlayClip() {
		return new LivePlayClipReqImpl();
	}
	
	public AbletonLiveSndCmd createLivePlayClipslot(int trackID, int clipID) {
		LivePlayClipSlotReq livePlayClipSlotReq = new LivePlayClipSlotReqImpl();
		livePlayClipSlotReq.setTrackID(trackID);
		livePlayClipSlotReq.setClipID(clipID);
		return livePlayClipSlotReq;
	}
	
	public AbletonLiveSndCmd createLivePlayContinue() {
		return new LivePlayContinueReqImpl();
	}
	
	public AbletonLiveSndCmd createLivePlay() {
		return createLivePlay(2);
	}
	
	public AbletonLiveSndCmd createLivePlay(int status) {
		LivePlay livePlay = new LivePlayImpl();
		livePlay.setStatus(status==2?PLAY_STATUS.PLAY:PLAY_STATUS.STOP);
		return livePlay;
	}
	
	public AbletonLiveSndCmd createLivePlayScene(int sceneID) {
		LivePlaySceneReq playSceneReq = new LivePlaySceneReqImpl();
		playSceneReq.setSceneID(sceneID);
		return playSceneReq;
	}
	
	public AbletonLiveSndCmd createLivePrecCue() {
		return new LivePrevCueReqImpl();
	}
	
	public AbletonLiveSndCmd createLiveRedo() {
		return new LiveRedoReqImpl();
	}
	
	public AbletonLiveSndCmd createLiveDevicelist(int trackID) {
		LiveDevicelist devicelist = new LiveDevicelistImpl();
		devicelist.setTrackID(trackID);
		return devicelist;
	}
	
	public AbletonLiveSndCmd createLiveDeviceView(int trackID, int deviceID) {
		LiveDeviceView devicelist = new LiveDeviceViewImpl();
		devicelist.setTrackID(trackID);
		devicelist.setDeviceID(deviceID);
		return devicelist;
	}
	
	public LiveOverdub createLiveOverdub() {
		LiveOverdub liveOverdub = (LiveOverdub) new LiveOverdubImpl();
		return liveOverdub;
	}
	
	public AbletonLiveSndCmd createLiveMute(int trackID, TRACK_MUTE_STATUS STATUS) {
		LiveMuteReq liveMuteReq = new LiveMuteReqImpl();
		liveMuteReq.setTrackID(trackID);
		liveMuteReq.setStatus(STATUS);
		return liveMuteReq;
	}
	
	public AbletonLiveSndCmd createLiveReturnPan(int trackID, float pan) {
		LiveReturnPan liveReturnPan = new LiveReturnPanImpl();
		liveReturnPan.setTrackID(trackID);
		liveReturnPan.setPan(pan);
		return liveReturnPan;
	}
	
	public AbletonLiveSndCmd createLiveReturnMeter(int trackID, int which, float level) {
		LiveReturnMeter liveReturnMeter = new LiveReturnMeterImpl();
		liveReturnMeter.setTrackID(trackID);
		liveReturnMeter.setWhich(METER_INPUT.get(which));
		liveReturnMeter.setLevel(level);
		return liveReturnMeter;
	}
	
	public AbletonLiveSndCmd createLiveReturnSend(int trackID, float level, int send) { 
		LiveReturnSend liveReturnSend = new LiveReturnSendImpl();
		liveReturnSend.setTrackID(trackID);
		liveReturnSend.setLevel(level);
		liveReturnSend.setSend(send);
		return liveReturnSend;
	}
	
	public AbletonLiveSndCmd createLiveReturnSolo(int trackID) {
		LiveReturnSolo liveReturnSolo = new LiveReturnSoloImpl();
		liveReturnSolo.setTrackID(trackID);
		return liveReturnSolo;
	}
	
	public AbletonLiveSndCmd createLiveReturnVolume(int trackID, float level) { 
		LiveReturnVolume liveReturnVolume = new LiveReturnVolumeImpl();
		liveReturnVolume.setTrackID(trackID);
		liveReturnVolume.setLevel(level);
		return liveReturnVolume;
	}
	
	public AbletonLiveSndCmd createLiveScene(String mode, int sceneID) { 
		LiveSceneReq liveSceneReq = new LiveSceneReqImpl();
		liveSceneReq.setMode(mode);
		liveSceneReq.setSceneID(sceneID);
		return liveSceneReq;
	}
	
	public AbletonLiveSndCmd createLiveScene2(int sceneID) { 
		LiveScene2 liveScene = new LiveScene2Impl();
		liveScene.setSceneID(sceneID);
		return liveScene;
	}
	
	public AbletonLiveSndCmd createLiveSend(int trackID, int value) { 
		LiveSendReq liveSendReq = new LiveSendReqImpl();
		liveSendReq.setTrackID(trackID);
		liveSendReq.setValue(value);
		return liveSendReq;
	}
	
	public AbletonLiveSndCmd createLiveState() {
		return new LiveStateReqImpl();
	}
	
	public AbletonLiveSndCmd createLiveStopClip(int trackID, int clipID) {
		LiveStopClipReq liveStopClipReq = new LiveStopClipReqImpl();
		liveStopClipReq.setTrackID(trackID);
		liveStopClipReq.setClipID(clipID);
		return liveStopClipReq;
	}
	
	public AbletonLiveSndCmd createLiveTrackInfo() { 
		return new LiveTrackInfoImpl();
	}
	
	public AbletonLiveSndCmd createLiveTrackVolume(int trackID, float volume) { 
		LiveTrackVolume trackVolume = new LiveTrackVolumeImpl();
		trackVolume.setVolume(volume);
		trackVolume.setTrackID(trackID);
		return trackVolume;
	}
	
	public AbletonLiveSndCmd createLiveTrackMute(int trackID, TRACK_MUTE_STATUS state) { 
		LiveTrackMute trackMute = new LiveTrackMuteImpl();
		trackMute.setState(state);
		trackMute.setTrackID(trackID);
		return trackMute;
	}
	
	public AbletonLiveSndCmd createLiveTrackSolo(int trackID, TRACK_SOLO_STATUS state) { 
		LiveTrackSolo trackSolo = new LiveTrackSoloImpl();
		trackSolo.setState(state);
		trackSolo.setTrackID(trackID);
		return trackSolo;
	}
	
	public AbletonLiveSndCmd createLiveTrackName(int trackID, String name) { 
		LiveTrackName trackName = new LiveTrackNameImpl();
		trackName.setName(name);
		trackName.setTrackID(trackID);
		return trackName;
	}
	
	public AbletonLiveSndCmd createLiveTrackPan(int trackID, float pan) { 
		LiveTrackPan trackPan = new LiveTrackPanImpl();
		trackPan.setPan(pan);
		trackPan.setTrackID(trackID);
		return trackPan;
	}
	
	public AbletonLiveSndCmd createLiveTrackSend(int trackID, float send) { 
		LiveTrackSend trackSend = new LiveTrackSendImpl();
		trackSend.setSend(send);
		trackSend.setTrackID(trackID);
		return trackSend;
	}
	
	public AbletonLiveSndCmd createLiveTrackPitch(int trackID, float pitch) { 
		LiveTrackPitch trackPan = new LiveTrackPitchImpl();
		trackPan.setPitch(pitch);
		trackPan.setTrackID(trackID);
		return trackPan;
	}
	

	
	public AbletonLiveSndCmd createLiveStop() { 
		return new LiveStopReqImpl();
	}
	
	public AbletonLiveSndCmd createLiveTrackDeviceView(int trackID, int deviceID) {
		LiveTrackDeviceView liveTrackDeviceView = new LiveTrackDeviceViewImpl();
		liveTrackDeviceView.setTrackID(trackID);
		liveTrackDeviceView.setDeviceID(deviceID);
		return liveTrackDeviceView;
	}
	
	public AbletonLiveSndCmd createLiveTrackJump(int trackID, float beats) { 
		LiveTrackJump liveTrackJump = new LiveTrackJumpImpl();
		liveTrackJump.setTrackID(trackID);
		liveTrackJump.setBeats(beats);
		return liveTrackJump;
	}
	
	public AbletonLiveSndCmd createLiveTracks() { 
		return new LiveTracksReqImpl();
	}
	
	public AbletonLiveSndCmd createLiveUndo() { 
		return new LiveUndoReqImpl();
	}
	
	public AbletonLiveSndCmd createLiveTime(float time) {
		LiveTimeRcv liveTimeRcv = new LiveTimeRcvImpl();
		liveTimeRcv.setTime(time);
		return liveTimeRcv;
	}
	
	public AbletonLiveSndCmd createLiveVolumeSet(int trackID, float level) {
		LiveVolumeSet liveTimeVolumeSet = new LiveVolumeSetImpl();
		liveTimeVolumeSet.setTrackID(trackID);
		liveTimeVolumeSet.setLevel(level);
		return liveTimeVolumeSet;
	}
	
	public AbletonLiveSndCmd createLivePlaySelection() {
		return new livePlaySelectionReqImpl();
	}
	
	public byte[] dumpAbletonLiveCommand(Cmd cmd) {
		OSCMessage msg = new OSCMessage();
		if (cmd instanceof LiveVolume) {
			msg.setAddress("/live/volume");
			msg.addArgument(new Integer(((LiveVolume)cmd).getTrackID()));
			msg.addArgument(new Float(((LiveVolume)cmd).getLevel()));
			((LiveVolume) cmd).setMsg(msg);
		} else if (cmd instanceof LiveNameTrackQ) {
			msg.setAddress("/live/name/track");
			((LiveNameTrackQ) cmd).setMsg(msg);
		} else if (cmd instanceof LiveScenesQ) {
			msg.setAddress("/live/scenes");
			((LiveScenesQ) cmd).setMsg(msg);
		} else if (cmd instanceof LiveTracksQ) {
			msg.setAddress("/live/tracks");
			((LiveTracksQ) cmd).setMsg(msg);
		} else if (cmd instanceof LiveNameSceneQ) {
			msg.setAddress("/live/name/scene");
			((LiveNameSceneQ) cmd).setMsg(msg);
		} else if (cmd instanceof LiveNameClipQ) {
			msg.setAddress("/live/name/clip");
			((LiveNameClipQ) cmd).setMsg(msg);
		} else if (cmd instanceof LiveTimeRcv) {
			LiveTimeRcv liveTimeRcv = (LiveTimeRcv) cmd;
			msg.setAddress("/live/time");
			msg.addArgument(new Float(liveTimeRcv.getTime()));
			((LiveTimeRcv) cmd).setMsg(msg);
		} else if (cmd instanceof LiveTempoRcv) {
			LiveTempoRcv liveTempoRcv = (LiveTempoRcv) cmd;
			msg.setAddress("/live/tempo");
			msg.addArgument(new Float(liveTempoRcv.getTempo()));
			((LiveTempoRcv) cmd).setMsg(msg);
		} else if (cmd instanceof LiveTempoReq) {
			LiveTempoReq liveTempoReq = (LiveTempoReq) cmd;
			msg.setAddress("/live/tempo");
			msg.addArgument(new Float(liveTempoReq.getStamp()));
			((LiveTempoReq) cmd).setMsg(msg);
		}  else if (cmd instanceof LiveTimeReq) {
			msg.setAddress("/live/time");
		}  else if (cmd instanceof LiveArmReq) {
			LiveArmReq liveArmReq = (LiveArmReq) cmd;
			msg.setAddress("/live/arm");
			msg.addArgument(new Integer(liveArmReq.getTrackID()));
			((LiveArmReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveClipInfo) {
			LiveClipInfo liveClipInfo = (LiveClipInfo) cmd;
			msg.setAddress("/live/clip/info");
			msg.addArgument(new Integer(liveClipInfo.getTrackID()));
			msg.addArgument(new Integer(liveClipInfo.getClipID()));
			((LiveClipInfo) cmd).setMsg(msg);
		} else if (cmd instanceof LiveDetailView) {
			LiveDetailView liveDetailView = (LiveDetailView) cmd;
			msg.setAddress("/live/detail/view");
			msg.addArgument(new Integer(liveDetailView.getValue()));
			((LiveDetailView) cmd).setMsg(msg);
		} else if (cmd instanceof LiveDevice) {
			LiveDevice liveDevice = (LiveDevice) cmd;
			msg.setAddress("/live/device");
			msg.addArgument(new Integer(liveDevice.getTrackID()));
			msg.addArgument(new Integer(liveDevice.getDeviceID()));
			msg.addArgument(new Integer(liveDevice.getParam()));
			((LiveDevice) cmd).setMsg(msg);
		} else if (cmd instanceof LiveDeviceParam) {
			LiveDeviceParam liveDevice = (LiveDeviceParam) cmd;
			msg.setAddress("/live/device/param");
			msg.addArgument(new Integer(liveDevice.getTrackID()));
			msg.addArgument(new Integer(liveDevice.getDeviceID()));
			msg.addArgument(new Integer(liveDevice.getParam()));
			msg.addArgument(liveDevice.getValue());
			msg.addArgument(liveDevice.getName());
			((LiveDevice) cmd).setMsg(msg);
		}  else if (cmd instanceof LiveDeviceRangeQ) {
			LiveDeviceRangeQ liveDevice = (LiveDeviceRangeQ) cmd;
			msg.setAddress("/live/device/range");
			msg.addArgument(new Integer(liveDevice.getTrackID()));
			msg.addArgument(new Integer(liveDevice.getDeviceID()));
			msg.addArgument(new Integer(liveDevice.getParam()));
			((LiveDeviceRangeQ) cmd).setMsg(msg);
		}  else if (cmd instanceof LiveDeviceRangeAllQ) {
			LiveDeviceRangeAllQ liveDevice = (LiveDeviceRangeAllQ) cmd;
			msg.setAddress("/live/device/range");
			msg.addArgument(new Integer(liveDevice.getTrackID()));
			msg.addArgument(new Integer(liveDevice.getDeviceID()));
			((LiveDeviceRangeAllQ) cmd).setMsg(msg);
		}  else if (cmd instanceof LiveReturnDeviceRangeQ) {
			LiveReturnDeviceRangeQ liveDevice = (LiveReturnDeviceRangeQ) cmd;
			msg.setAddress("/live/return/device/range");
			msg.addArgument(new Integer(liveDevice.getTrackID()));
			msg.addArgument(new Integer(liveDevice.getDeviceID()));
			msg.addArgument(new Integer(liveDevice.getParam()));
			((LiveReturnDeviceRangeQ) cmd).setMsg(msg);
		}  else if (cmd instanceof LiveReturnDeviceRangeAllQ) {
			LiveReturnDeviceRangeAllQ liveDevice = (LiveReturnDeviceRangeAllQ) cmd;
			msg.setAddress("/live/return/device/range");
			msg.addArgument(new Integer(liveDevice.getTrackID()));
			msg.addArgument(new Integer(liveDevice.getDeviceID()));
			((LiveReturnDeviceRangeAllQ) cmd).setMsg(msg);
		} else if (cmd instanceof LiveDevicelist) {
			LiveDevicelist liveDeviceList = (LiveDevicelist) cmd;
			msg.setAddress("/live/devicelist");
			msg.addArgument(new Integer(liveDeviceList.getTrackID()));
			((LiveDevicelist) cmd).setMsg(msg);
		} else if (cmd instanceof LiveTrackPan) {
			LiveTrackPan liveTrackPan = (LiveTrackPan) cmd;
			msg.setAddress("/live/pan");
			msg.addArgument(new Integer(liveTrackPan.getTrackID()));
			msg.addArgument(liveTrackPan.getPan());
			((LiveTrackPan) cmd).setMsg(msg);
		} else if (cmd instanceof LiveTrackVolume) {
			LiveTrackVolume liveTrackVolume = (LiveTrackVolume) cmd;
			msg.setAddress("/live/volume");
			msg.addArgument(new Integer(liveTrackVolume.getTrackID()));
			msg.addArgument(new Float(liveTrackVolume.getVolume()));
			((LiveTrackVolume) cmd).setMsg(msg);
		} else if (cmd instanceof LiveTrackSolo) {
			LiveTrackSolo liveTrackSolo = (LiveTrackSolo) cmd;
			msg.setAddress("/live/solo");
			msg.addArgument(new Integer(liveTrackSolo.getTrackID()));
			msg.addArgument(new Integer(liveTrackSolo.getState().getValue()));
			((LiveTrackSolo) cmd).setMsg(msg);
		} else if (cmd instanceof LiveTrackMute) {
			LiveTrackMute liveTrackMute = (LiveTrackMute) cmd;
			msg.setAddress("/live/mute");
			msg.addArgument(new Integer(liveTrackMute.getTrackID()));
			msg.addArgument(new Integer(liveTrackMute.getState().getValue()));
			((LiveTrackMute) cmd).setMsg(msg);
		} else if (cmd instanceof LiveTrackSend) {
			LiveTrackSend liveTrackMute = (LiveTrackSend) cmd;
			msg.setAddress("/live/send");
			msg.addArgument(new Integer(liveTrackMute.getTrackID()));
			msg.addArgument(new Integer(1));
			msg.addArgument(new Float(liveTrackMute.getSend()));
			((LiveTrackSend) cmd).setMsg(msg);
		} else if (cmd instanceof LiveTrackPitch) {
			LiveTrackPitch liveTrackMute = (LiveTrackPitch) cmd;
			msg.setAddress("/live/pitch");
			msg.addArgument(new Integer(liveTrackMute.getTrackID()));
			msg.addArgument(new Float(-48f + (96f * liveTrackMute.getPitch())));
			msg.addArgument(new Float(-50f + (100f * liveTrackMute.getPitch())));
			((LiveTrackPitch) cmd).setMsg(msg);
		} else if (cmd instanceof LiveMasterDeviceView) {
			LiveMasterDeviceView liveMasterDeviceView = (LiveMasterDeviceView) cmd;
			msg.setAddress("/live/master/device/view");
			msg.addArgument(new Integer(liveMasterDeviceView.getDeviceID()));
			((LiveMasterDeviceView) cmd).setMsg(msg);
		} else if (cmd instanceof LiveMasterPanReq) {
			LiveMasterPanReq liveMasterPanReq = (LiveMasterPanReq) cmd;
			msg.setAddress("/live/master/pan");
			msg.addArgument(liveMasterPanReq.getPan());
			((LiveMasterPanReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveMasterVolume) {
			LiveMasterVolume liveMasterVolume = (LiveMasterVolume) cmd;
			msg.setAddress("/live/master/volume");
			msg.addArgument(liveMasterVolume.getLevel());
			((LiveMasterVolume) cmd).setMsg(msg);
		} else if (cmd instanceof LiveMasterVolumeReq) {
			LiveMasterVolumeReq liveMasterVolumeReq = (LiveMasterVolumeReq) cmd;
			msg.setAddress("/live/master/volume");
			msg.addArgument(liveMasterVolumeReq.getLevel());
			((LiveMasterVolumeReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveMuteReq) {
			LiveMuteReq liveMuteReq = (LiveMuteReq) cmd;
			msg.setAddress("/live/mute");
			msg.addArgument(liveMuteReq.getTrackID());
			msg.addArgument(liveMuteReq.getStatus().getValue());
			((LiveMuteReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveNameClipblockreq) {
			LiveNameClipblockreq liveNameClipblockreq = (LiveNameClipblockreq) cmd;
			msg.setAddress("/live/name/clipblock");
			msg.addArgument(liveNameClipblockreq.getTrackID());
			msg.addArgument(liveNameClipblockreq.getClipID());
			msg.addArgument(liveNameClipblockreq.getSizeX());
			msg.addArgument(liveNameClipblockreq.getSizeY());
			((LiveNameClipblockreq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveNameClipReq) {
			LiveNameClipReq liveNameClipReq = (LiveNameClipReq) cmd;
			msg.setAddress("/live/name/clip");
			msg.addArgument(liveNameClipReq.getTrackID());
			msg.addArgument(liveNameClipReq.getClipID());
			msg.addArgument(liveNameClipReq.getLabel());
			((LiveNameClipReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveNameSceneBlockReq) {
			LiveNameSceneBlockReq liveNameSceneBlockReq = (LiveNameSceneBlockReq) cmd;
			msg.setAddress("/live/name/scene/block");
			msg.addArgument(liveNameSceneBlockReq.getTrackID());
			msg.addArgument(liveNameSceneBlockReq.getSize());
			((LiveNameSceneBlockReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveNameSceneReq) {
			LiveNameSceneReq liveNameSceneReq = (LiveNameSceneReq) cmd;
			msg.setAddress("/live/name/scene");
			msg.addArgument(liveNameSceneReq.getSceneID());
			msg.addArgument(liveNameSceneReq.getSceneName());
			((LiveNameSceneReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveNameTrackblockReq) {
			LiveNameTrackblockReq liveNameTrackblockReq = (LiveNameTrackblockReq) cmd;
			msg.setAddress("/live/name/trackblock");
			msg.addArgument(liveNameTrackblockReq.getTrackID());
			msg.addArgument(liveNameTrackblockReq.getSize());
			((LiveNameTrackblockReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveNameTrackReq) {
			LiveNameTrackReq liveNameTrackReq = (LiveNameTrackReq) cmd;
			msg.setAddress("/live/name/track");
			msg.addArgument(liveNameTrackReq.getTrackName());
			msg.addArgument(liveNameTrackReq.getColor());
			((LiveNameTrackReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveNextCueReq) {
			msg.setAddress("/live/next/cue");
			((LiveNextCueReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveOverdub) {
			msg.setAddress("/live/prev/cue");
			((LiveOverdub) cmd).setMsg(msg);
		} else if (cmd instanceof LivePanSet) {
			msg.setAddress("/live/pan/set");
			msg.addArgument(((LivePanSet) cmd).getTrackID());
			((LivePanSet) cmd).setMsg(msg);
		} else if (cmd instanceof LivePitchSet) {
			LivePitchSet livePitchSet = (LivePitchSet) cmd;
			msg.setAddress("/live/pitch/set");
			msg.addArgument(new Integer(livePitchSet.getTrackID()));
			msg.addArgument(new Integer(livePitchSet.getClip()));
			msg.addArgument(new Integer(livePitchSet.getCoarse()));
			msg.addArgument(new Integer(livePitchSet.getFine()));
			((LivePitchSet) cmd).setMsg(msg);
		} else if (cmd instanceof LivePlayClipReq) {
			msg.setAddress("/live/play/clip");
			((LivePlayClipReq) cmd).setMsg(msg);
		} else if (cmd instanceof LivePlayClipSlotReq) {
			LivePlayClipSlotReq livePlayClipSlotReq = (LivePlayClipSlotReq) cmd;
			msg.setAddress("/live/play/clipslot");
			msg.addArgument(new Integer(livePlayClipSlotReq.getTrackID()));
			msg.addArgument(new Integer(livePlayClipSlotReq.getClipID()));
			((LivePlayClipSlotReq) cmd).setMsg(msg);
		} else if (cmd instanceof LivePlayContinueReq) {
			msg.setAddress("/live/play/continue");
			((LivePlayContinueReq) cmd).setMsg(msg);
		} else if (cmd instanceof LivePlayReq) {
			msg.setAddress("/live/play");
			((LivePlayReq) cmd).setMsg(msg);
		}  else if (cmd instanceof LivePlay) {
			msg.setAddress("/live/play");
			((LivePlay) cmd).setMsg(msg);
		} else if (cmd instanceof LivePlaySceneReq) {
			LivePlaySceneReq livePlaySceneReq = (LivePlaySceneReq) cmd;
			msg.setAddress("/live/play/scene");
			msg.addArgument(new Integer(livePlaySceneReq.getSceneID()));
			((LivePlaySceneReq) cmd).setMsg(msg);
		} else if (cmd instanceof LivePrevCueReq) {
			msg.setAddress("/live/prec/cue");
			((LivePrevCueReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveRedoReq) {
			msg.setAddress("/live/redo");
			((LiveRedoReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveReturnDevicelist) {
			msg.setAddress("/live/return/devicelist");
			((LiveReturnDevicelist) cmd).setMsg(msg);
		} else if (cmd instanceof LiveReturnDeviceView) {
			msg.setAddress("/live/return/device/view");
			((LiveReturnDeviceView) cmd).setMsg(msg);
		} else if (cmd instanceof LiveReturnMuteReq) {
			LiveReturnMuteReq liveReturnMuteReq = (LiveReturnMuteReq) cmd;
			msg.setAddress("/live/return/mute");
			msg.addArgument(new Integer(liveReturnMuteReq.getTrackID()));
			msg.addArgument(new Integer(liveReturnMuteReq.getStatus().getValue()));
			((LiveReturnMuteReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveReturnPan) {
			LiveReturnPan liveReturnPan = (LiveReturnPan) cmd;
			msg.setAddress("/live/return/pan");
			msg.addArgument(new Integer(liveReturnPan.getTrackID()));
			msg.addArgument(new Float(liveReturnPan.getPan()));
			((LiveReturnPan) cmd).setMsg(msg);
		} else if (cmd instanceof LiveReturnPanReq) {
			LiveReturnPanReq liveReturnPanReq = (LiveReturnPanReq) cmd;
			msg.setAddress("/live/return/pan");
			msg.addArgument(new Float(liveReturnPanReq.getTrackID()));
			msg.addArgument(new Float(liveReturnPanReq.getPan()));
			((LiveReturnPanReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveReturnSend) {
			LiveReturnSend liveReturnSend = (LiveReturnSend) cmd;
			msg.setAddress("/live/return/send");
			msg.addArgument(new Integer(liveReturnSend.getTrackID()));
			msg.addArgument(new Float(liveReturnSend.getLevel()));
			msg.addArgument(new Integer(liveReturnSend.getSend()));
			((LiveReturnSend) cmd).setMsg(msg);
		} else if (cmd instanceof LiveReturnSendReq) {
			LiveReturnSendReq liveReturnSendReq = (LiveReturnSendReq) cmd;
			msg.setAddress("/live/return/send");
			msg.addArgument(new Integer(liveReturnSendReq.getTrackID()));
			msg.addArgument(new Float(liveReturnSendReq.getLevel()));
			msg.addArgument(new Integer(liveReturnSendReq.getSend()));
			((LiveReturnSendReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveReturnSolo) {
			LiveReturnSolo liveReturnSolo = (LiveReturnSolo) cmd;
			msg.setAddress("/live/return/solo");
			msg.addArgument(new Integer(liveReturnSolo.getTrackID()));
			((LiveReturnSolo) cmd).setMsg(msg);
		} else if (cmd instanceof LiveReturnVolume) {
			LiveReturnVolume liveReturnVolume = (LiveReturnVolume) cmd;
			msg.setAddress("/live/return/volume");
			msg.addArgument(new Integer(liveReturnVolume.getTrackID()));
			msg.addArgument(new Float(liveReturnVolume.getLevel()));
			((LiveReturnVolume) cmd).setMsg(msg);
		} else if (cmd instanceof LiveReturnVolumeReq) {
			LiveReturnVolumeReq liveReturnVolumeReq = (LiveReturnVolumeReq) cmd;
			msg.setAddress("/live/return/volume");
			msg.addArgument(new Integer(liveReturnVolumeReq.getTrackID()));
			msg.addArgument(new Float(liveReturnVolumeReq.getLevel()));
			((LiveReturnVolumeReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveScene2) {
			LiveScene2 liveScene2 = (LiveScene2) cmd;
			msg.setAddress("/live/scene");
			msg.addArgument(new Integer(liveScene2.getSceneID()));
			((LiveScene2) cmd).setMsg(msg);
		}  else if (cmd instanceof LiveSceneReq) {
			LiveSceneReq liveSceneReq = (LiveSceneReq) cmd;
			msg.setAddress("/live/scene");
			msg.addArgument(new Integer(liveSceneReq.getMode()));
			msg.addArgument(new Integer(liveSceneReq.getSceneID()));
			((LiveSceneReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveSendReq) {
			msg.setAddress("/live/send");
			((LiveSendReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveStateRcv) {
			LiveStateRcv liveStateRcv = (LiveStateRcv) cmd;
			msg.setAddress("/live/state");
			msg.addArgument(new Float(liveStateRcv.getTempo()));
			((LiveStateRcv) cmd).setMsg(msg);
		} else if (cmd instanceof LiveStateReq) {
			((LiveStateReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveStopClipReq) {
			LiveStopClipReq liveStopClipReq = (LiveStopClipReq) cmd;
			msg.setAddress("/live/stop/clip");
			msg.addArgument(new Integer(liveStopClipReq.getTrackID()));
			msg.addArgument(new Integer(liveStopClipReq.getClipID()));
			((LiveStopClipReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveTrackInfo) {
			LiveTrackInfo liveTrackInfo = (LiveTrackInfo) cmd;
			msg.setAddress("/live/track/info");
			msg.addArgument(new Integer(liveTrackInfo.getTrackID()));
			((LiveTrackInfo) cmd).setMsg(msg);
		} else if (cmd instanceof LiveStopReq) {
			msg.setAddress("/live/stop");
			((LiveStopReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveTrackDeviceView) {
			LiveTrackDeviceView liveTrackDeviceView = (LiveTrackDeviceView) cmd;
			msg.setAddress("/live/track/device/view");
			msg.addArgument(new Integer(liveTrackDeviceView.getTrackID()));
			msg.addArgument(new Integer(liveTrackDeviceView.getDeviceID()));
			((LiveTrackInfo) cmd).setMsg(msg);
		} else if (cmd instanceof LiveTrackJump) {
			LiveTrackJump liveTrackJump = (LiveTrackJump) cmd;
			msg.setAddress("/live/track/jump");
			msg.addArgument(new Integer(liveTrackJump.getTrackID()));
			msg.addArgument(new Float(liveTrackJump.getBeats()));
			((LiveTrackJump) cmd).setMsg(msg);
		} else if (cmd instanceof LiveTracksReq) {
			msg.setAddress("/live/tracks");
			((LiveTracksReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveUndoReq) {
			msg.setAddress("/live/undo");
			((LiveUndoReq) cmd).setMsg(msg);
		} else if (cmd instanceof LiveTimeRcv) {
			LiveTimeRcv liveTimeRcv = (LiveTimeRcv) cmd;
			msg.setAddress("/live/time");
			msg.addArgument(new Float(liveTimeRcv.getTime()));
			((LiveTimeRcv) cmd).setMsg(msg);
		} else if (cmd instanceof LiveVolumeSet) {
			LiveVolumeSet liveVolumeSet = (LiveVolumeSet) cmd;
			msg.setAddress("/live/volume/set");
			msg.addArgument(new Integer(liveVolumeSet.getTrackID()));
			msg.addArgument(new Float(liveVolumeSet.getLevel()));
			((LiveVolumeSet) cmd).setMsg(msg);
		} else if (cmd instanceof LiveDeviceParamSet) {
			LiveDeviceParamSet liveDeviceParamSet = (LiveDeviceParamSet) cmd;
			msg.setAddress("/live/device");
			msg.addArgument(new Integer(liveDeviceParamSet.getTrackID()));
			msg.addArgument(new Integer(liveDeviceParamSet.getDeviceID()));
			msg.addArgument(new Integer(liveDeviceParamSet.getPIndex()));
			
			Object o = liveDeviceParamSet.getValue();

			if (o instanceof String) {
				try {
					Float vf = Float.parseFloat(o.toString());
					Integer itg = new Integer(vf.intValue());
					msg.addArgument(itg);
				} catch (Exception e) {
				}
			} else if (o instanceof Float) {
				msg.addArgument(o);
			} else if (o instanceof Integer) {
				msg.addArgument(o);	
			}
			//System.out.println("/live/device "+ msg.getArguments()[0] + " " + msg.getArguments()[1] + " " + msg.getArguments()[2] + " " + msg.getArguments()[3]);
			((LiveDeviceParamSet) cmd).setMsg(msg);
		} else if (cmd instanceof livePlaySelectionReq) {
			msg.setAddress("/live/play/selection");
			((livePlaySelectionReq) cmd).setMsg(msg);
		} else if (cmd instanceof livePlaySelectionReq) {
			msg.setAddress("/live/play/selection");
			((livePlaySelectionReq) cmd).setMsg(msg);
		}
		return msg.getByteArray();
	}
	
	public AbletonLiveSndCmd createLiveTempoReqCmd() {
		LiveTempoReq liveTempoReq = new LiveTempoReqImpl();
		return liveTempoReq;
	}
	
	public AbletonLiveSndCmd createLiveTempoRcvCmd(float tempo) {
		LiveTempoRcv liveTempoRcv = new LiveTempoRcvImpl();
		liveTempoRcv.setTempo(tempo);
		return liveTempoRcv;
	}
	
	public LiveTimeReq createLiveTimeReqCmd() {
		LiveTimeReq liveTimeReq = new LiveTimeReqImpl();
		return liveTimeReq;
	}
	
	
}