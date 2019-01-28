package ubiquisense.iorx.protocols.ableton.internal.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.illposed.osc.OSCBundle;
import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPacket;

import ubiquisense.iorx.changes.Notification;
import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.cmd.CompoundCmd;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.protocols.ableton.internal.CLIP_STATE;
import ubiquisense.iorx.protocols.ableton.internal.LiveArmReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveClipInfo;
import ubiquisense.iorx.protocols.ableton.internal.LiveClipPosition;
import ubiquisense.iorx.protocols.ableton.internal.LiveDetailView;
import ubiquisense.iorx.protocols.ableton.internal.LiveDevice;
import ubiquisense.iorx.protocols.ableton.internal.LiveDeviceParam;
import ubiquisense.iorx.protocols.ableton.internal.LiveDeviceParamSet;
import ubiquisense.iorx.protocols.ableton.internal.LiveDeviceRange;
import ubiquisense.iorx.protocols.ableton.internal.LiveDeviceRangeAll;
import ubiquisense.iorx.protocols.ableton.internal.LiveDevicelist;
import ubiquisense.iorx.protocols.ableton.internal.LiveMasterDeviceView;
import ubiquisense.iorx.protocols.ableton.internal.LiveMasterMeter;
import ubiquisense.iorx.protocols.ableton.internal.LiveMasterPanReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveMasterVolume;
import ubiquisense.iorx.protocols.ableton.internal.LiveMasterVolumeReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveMuteReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveNameClipReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveNameClipblockreq;
import ubiquisense.iorx.protocols.ableton.internal.LiveNameSceneBlockReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveNameSceneReq;
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
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnDeviceRange;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnDeviceRangeAll;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnDeviceView;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnDevicelist;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnMuteReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnPan;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnPanReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnSend;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnSendReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnSolo;
import ubiquisense.iorx.protocols.ableton.internal.LiveReturnVolume;
import ubiquisense.iorx.protocols.ableton.internal.LiveScene2;
import ubiquisense.iorx.protocols.ableton.internal.LiveSceneReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveScenesQ;
import ubiquisense.iorx.protocols.ableton.internal.LiveScenesReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveSendReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveStateRcv;
import ubiquisense.iorx.protocols.ableton.internal.LiveStateReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveStopClipReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveStopReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveStopTrackReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveTempoRcv;
import ubiquisense.iorx.protocols.ableton.internal.LiveTempoReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveTimeRcv;
import ubiquisense.iorx.protocols.ableton.internal.LiveTimeReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackDeviceView;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackInfo;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackJump;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackMeter;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackMute;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackPan;
import ubiquisense.iorx.protocols.ableton.internal.LiveTrackSolo;
import ubiquisense.iorx.protocols.ableton.internal.LiveTracksQ;
import ubiquisense.iorx.protocols.ableton.internal.LiveTracksReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveUndoReq;
import ubiquisense.iorx.protocols.ableton.internal.LiveVolumeSet;
import ubiquisense.iorx.protocols.ableton.internal.METER_INPUT;
import ubiquisense.iorx.protocols.ableton.internal.TRACK_ARM_STATUS;
import ubiquisense.iorx.protocols.ableton.internal.TRACK_MUTE_STATUS;
import ubiquisense.iorx.protocols.ableton.internal.TRACK_SOLO_STATUS;
import ubiquisense.iorx.protocols.ableton.internal.livePlaySelectionReq;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.AbletonLive;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.AbstractLiveDevice;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveClip;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveMaster;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveParam;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveScene;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveTrack;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.MASTER_CTRL;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.TRACK_CONTROL;
import ubiquisense.iorx.protocols.osc.internal.OscCmd;
import ubiquisense.iorx.protocols.osc.internal.OscCmdUtils;
import ubiquisense.iorx.utils.Platform;



public class AbletonLiveControllerUtils {
	/*
	public final static int LIVE_TRACK_TTL = 5000; // 5 seconds
	public final static int LIVE_SCENE_TTL = 5000; // 5 seconds
	public final static int LIVE_CLIP_TTL = 5000; // 5 seconds
	
	
	private Map<String, Long> tracksLastSeenAliveMap, 
								scenesLastSeenAliveMap, 
								  clipsLastSeenAliveMap, 
								    devicesLastSeenAliveMap;
	
	public static final String P_ABLETON_INPUT_PORT		= "abletonInputPortPreference";
	public static final String P_ABLETON_OUTPUT_PORT	= "abletonOutputPortPreference";
	public static final String P_ABLETON_IP_ADDRESS		= "abletonIPAddressPreference";

	private volatile AbletonLive liveApp;
	private int refreshRate;
	private CmdPipe abletonOscEngine;
	
	private Map<Integer, org.eclipse.swt.graphics.Color> colorsMap;
	
	public RGB computeRgbID(String rgbID) {
		if (rgbID!= null) {
			int val = Integer.valueOf(rgbID);
			int r = (val >> 16) & 0xFF;
			int g = (val >> 8)  & 0xFF;
			int b = val         & 0xFF;
			
			return new RGB(r, g, b);
		}
		return Display.getDefault().getSystemColor(SWT.COLOR_BLUE).getRGB();
	}

	
	private boolean dumpToConsole, monitorDevices;
	
	public boolean isDumpedToConsole() {
		return dumpToConsole;
	}
	
	public void dumpToConsole(boolean dumpToConsole) {
		this.dumpToConsole = dumpToConsole;
	}
	public boolean isMonitorDevices() {
		return monitorDevices;
	}
	
	public void monitorDevices(boolean monitorDevices) {
		this.monitorDevices = monitorDevices;
	}
	
	public CmdPipe getAbletonOscEngine() {
		return abletonOscEngine;
	}
	
	public void resetAbletonOscEngine(String addr, int outPort, int inPort) {
		synchronized(abletonOscEngine) {
			liveAutoConnectJob.cancel();
			final CmdPipe pipe = abletonOscEngine;
			abletonOscEngine = QuanticMojo.INSTANCE.openUdpPipe(
				"oscableton", 
				addr +":"+ outPort, 
				new int[] { inPort }
			);
			abletonOscEngine.setLocked(true);
	
			abletonOscEngine.addQxEventHandler(
				new AbstractQxEventHandlerImpl() {
					public void handleQxEvent(final net.sf.xqz.model.engine.Event event) {
						if (event.getKind().equals(EVENT_KIND.RX_DONE)) {
							if (event.getCmd() instanceof OscCmd) {
								if (dumpToConsole) {
									QuanticMojo.INSTANCE.acceptLocalAgentCmd((OscCmd)event.getCmd());
								}
								handleAbletonLiveRcvCmd(event.getCmd(), abletonOscEngine);
							}
						}
					}
				}
			);
			
			QuanticMojo.INSTANCE.closePipe(pipe, true);

			liveAutoConnectJob.schedule();
		}
	}
	private LiveAutoConnectJob liveAutoConnectJob;
	private org.eclipse.swt.graphics.Color getColor(int code) {
		Integer key = new Integer(code);
		if (!colorsMap.containsKey(key)) {
			org.eclipse.swt.graphics.Color color = new org.eclipse.swt.graphics.Color(
				Display.getDefault(), 
				computeRgbID(""+code)
			);
			colorsMap.put(
				key, 
				color
			);
			return color;
		}
		return colorsMap.get(key);
	}
	public AbletonLiveControllerUtils() {
		liveApp = createDefaultAbletonLiveSession();
		tracksLastSeenAliveMap	= new ConcurrentHashMap<String, Long>();
		scenesLastSeenAliveMap	= new ConcurrentHashMap<String, Long>();
		devicesLastSeenAliveMap = new ConcurrentHashMap<String, Long>();
		clipsLastSeenAliveMap	= new ConcurrentHashMap<String, Long>();
		refreshRate 			= 200;
		colorsMap = new HashMap<Integer, org.eclipse.swt.graphics.Color>();
		//
		// Rx/Tx queue init
		//
		
		IPreferencesService prefs = Platform.getPreferencesService();
		
		int inPort	= prefs.getInt("net.sf.smbt.ui.ableton", P_ABLETON_INPUT_PORT, 9001, null);
		int outPort	= prefs.getInt("net.sf.smbt.ui.ableton", P_ABLETON_OUTPUT_PORT, 9000, null);
		String addr	= prefs.getString("net.sf.smbt.ui.ableton", P_ABLETON_IP_ADDRESS, "localhost", null);
		
		abletonOscEngine = QuanticMojo.INSTANCE.openUdpPipe(
			"oscableton", 
			addr +":"+ outPort, 
			new int[] { inPort }
		);
		abletonOscEngine.setLocked(true);
		//
		// OSC feedback hookup init
		//
		abletonOscEngine.addQxEventHandler(
			new AbstractQxEventHandlerImpl() {
				public void handleQxEvent(final net.sf.xqz.model.engine.Event event) {
					if (event.getCmd() != null && event.getKind().equals(EVENT_KIND.RX_DONE)) {
						if (dumpToConsole) {
							if (event.getCmd() instanceof CompoundCmd) {
								for (Cmd c : ((CompoundCmd)event.getCmd()).getChildren()) {
									if (c instanceof OscCmd) {
										QuanticMojo.INSTANCE.acceptLocalAgentCmd((OscCmd)c);
									}
								}
							} else {
								QuanticMojo.INSTANCE.acceptLocalAgentCmd((OscCmd)event.getCmd());
							}
						}
						handleAbletonLiveRcvCmd(event.getCmd(), abletonOscEngine);
					}
				}
			}
		);

		liveAutoConnectJob = new LiveAutoConnectJob();
		liveAutoConnectJob.schedule(1000);
	}
	
	public void setFreq(int freq) {
		refreshRate = freq;	
	}
	
	public AbletonLive getLiveApp() {
		return liveApp;
	}
	
	private synchronized void handleAbletonLiveRcvCmd(final Cmd cmd, final CmdPipe oscAbletonEngine) {
		if (cmd instanceof CompoundCmd) {
			for (Cmd c : ((CompoundCmd)cmd).getChildren()) {
				handleLiveControlSynchro(c, liveApp, oscAbletonEngine);
			}
		} else {
			handleLiveControlSynchro(cmd, liveApp, oscAbletonEngine);
		}
	}


	public void structuralDump() {
		OSCBundle bundle = new OSCBundle();
		OSCPacket root = new OSCMessage("/live/struct");
		
		bundle.addPacket(root);
		
		OscCmdUtils.INSTANCE.createOscCmd(bundle);
		
		//bundle.addPacket(new OSCMessage("/live/struct/master/arm", new Object[] { liveApp.getMasterTrack().getArm().getLiteral()}));
		//bundle.addPacket(new OSCMessage("/live/struct/master/", new Object[] { liveApp.getMasterTrack().getArm().getLiteral()}));
		
		
		
		QuanticMojo.INSTANCE.acceptLocalAgentCmd();
	}
	class LiveAutoConnectJob extends Job {
		int cpt;
		public LiveAutoConnectJob() {
			super(UUID.randomUUID().toString());
			cpt = 0;
		}
		@Override
		public IStatus run(IProgressMonitor monitor) {
			try {
				//
				// Force model to be populated w/ asking for tracks/scenes/clips/devices on a cyclic basis
				//
				switch (cpt) {
					case 0:
						abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveNameSceneQ());
						break;
					case 1:
						abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveNameTrackQ());
						break;
					case 2:
						abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveNameClipQ());
						break;
					case 3:
						//abletonOscEngine.send(AbletonLiveUtils.INSTANCE.createLiveState());
						abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveTrackInfo());
						abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveTempoReqCmd());
						abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveTimeReqCmd());
						break;
					case 4:
						for (LiveTrack track : liveApp.getTracks()) {
							//synchronized (track) {
								requestTrackInfo(track);
							//}
						}
						break;
					case 5:
						if (monitorDevices) {
							for (LiveTrack track : liveApp.getTracks()) {
								requestDeviceInfo(track);
							}
						}
						break;
				}
				cpt = cpt>=5 ? 0 : cpt+1;
					 
				cleanLiveApp(liveApp);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				schedule(refreshRate);
			}
			
			return Status.OK_STATUS;
		}
	}	
	
	public void requestDeviceInfo(LiveTrack track) {
		int trackID = track.getTrackID();
		if (abletonOscEngine != null && monitorDevices) {
			for (AbstractLiveDevice device : track.getDevices()) {
				for (LiveParam p : device.getParameters()) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveDevice(
							trackID, device.getDeviceID(), Integer.parseInt(p.getKey())
						)
					);
				}
			}
		}
	}

	public void requestTrackInfo(LiveTrack track) {
		int trackID = track.getTrackID();
		if (abletonOscEngine != null) {
			abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveNameTrack(trackID));
			abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveDevicelist(trackID));
			try {
				//synchronized (track) {
					//synchronized (track.getClips()) {
						if (monitorDevices) {
							for (AbstractLiveDevice device : track.getDevices()) {
								abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveDeviceRangeAllQ(trackID, device.getDeviceID()));
							}
						}
						for (LiveClip clip : track.getClips()) {
							int clipID = clip.getClipID();
							abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveClipInfo(trackID, clipID, clip.getClipState().getValue()));
							requestClipInfo(clip);
						}
					//}
				//}
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}
	private void requestClipInfo(LiveClip clip) {
		//abletonOscEngine.send(AbletonLiveUtils.INSTANCE.createLive);
	}

	public CompoundCmd initLiveSession() {
		// this method is supposed to return the ordered list of mandatory stuff for ableton live synchro init
		
		CompoundCmd cCmd = CmdFactory.eINSTANCE.createCompoundCmd();
		
		return cCmd;
	}

	public AbstractLiveDevice createDefaultDevice(int deviceID, String deviceName) {
		AbstractLiveDevice device = EzabletonctrlFactory.eINSTANCE.createPlaceHolderDevice();
		device.setDeviceID(deviceID);
		device.setDeviceName(deviceName);
		return device;
	}
	

	public LiveClip createDefaultClip(int clipID, String clipName) {
		final LiveClip clip = (LiveClip) EzabletonctrlFactory.eINSTANCE.createLiveClip();
		
		clip.setClipID(clipID);
		clip.setClipName(clipName);
		clip.setClipState(CLIP_STATE.STOP);
		clip.setCoarse(0);
		clip.setFine(0);
		clip.setLength(0);
		clip.setLoopEnd(0);
		clip.setLoopStart(0);
		clip.setPosition(0);
		clip.setSizeX(0);
		clip.setSizeY(0);
		clip.setLastSeen(System.currentTimeMillis());
		clipsLastSeenAliveMap.put(""+clipID, System.currentTimeMillis());
		
		clip.eAdapters().add(
			new AdapterImpl(){
				@Override
				public void notifyChanged(Notification msg) {
					if(msg.getEventType() == Notification.SET) {
						if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveClip_ClipID())) {
							handleClipID(clip, msg);
						} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveClip_ClipName())) {
							handleClipName(clip, msg);
						} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveClip_ClipState())) {
							handleClipState(clip, msg);
						} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveClip_Coarse())) {
							handleClipCoarse(clip, msg);
						} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveClip_Fine())) {
							handleClipFine(clip, msg);
						} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveClip_Length())) {
							handleClipLength(clip, msg);
						} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveClip_LoopEnd())) {
							handleClipLoopEnd(clip, msg);
						} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveClip_LoopStart())) {
							handleClipLoopStart(clip, msg);
						} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveClip_Position())) {
							handleClipPosition(clip, msg);
						} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveClip_SizeX())) {
							handleClipSizeX(clip, msg);
						} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveClip_SizeY())) {
							handleClipSizeY(clip, msg);
						}
					}
				}
			}
		);

		return clip;
	}
	
	public void handleClipID(LiveClip clip, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (clip.eContainer() instanceof AbletonLive) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveClipInfo(clip.getTrack().getTrackID(), clip.getClipID(), clip.getClipState().getValue())
					);
				}
			}
		}
	}
	
	public void handleClipName(LiveClip clip, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (clip.eContainer() instanceof AbletonLive) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveClipInfo(clip.getTrack().getTrackID(), clip.getClipID(), clip.getClipState().getValue())
					);
				}
			}
		}
	}
	
	public void handleClipState(LiveClip clip, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (clip.eContainer() instanceof AbletonLive) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveClipInfo(clip.getTrack().getTrackID(), clip.getClipID(), clip.getClipState().getValue())
					);
				}
			}
		}
	}
	
	public void handleClipCoarse(LiveClip clip, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (clip.eContainer() instanceof AbletonLive) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveClipInfo(clip.getTrack().getTrackID(), clip.getClipID(), clip.getClipState().getValue())
					);
				}
			}
		}
	}
	
	public void handleClipFine(LiveClip clip, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (clip.eContainer() instanceof AbletonLive) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveClipInfo(clip.getTrack().getTrackID(), clip.getClipID(), clip.getClipState().getValue())
					);
				}
			}
		}
	}
	
	public void handleClipLength(LiveClip clip, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (clip.eContainer() instanceof AbletonLive) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveClipInfo(clip.getTrack().getTrackID(), clip.getClipID(), clip.getClipState().getValue())
					);
				}
			}
		}
	}
	
	public void handleClipLoopEnd(LiveClip clip, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (clip.eContainer() instanceof AbletonLive) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveClipInfo(clip.getTrack().getTrackID(), clip.getClipID(), clip.getClipState().getValue())
					);
				}
			}
		}
	}
	
	public void handleClipLoopStart(LiveClip clip, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (clip.eContainer() instanceof AbletonLive) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveClipInfo(clip.getTrack().getTrackID(), clip.getClipID(), clip.getClipState().getValue())
					);
				}
			}
		}
	}
	
	public void handleClipPosition(LiveClip clip, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (clip.eContainer() instanceof AbletonLive) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveClipInfo(clip.getTrack().getTrackID(), clip.getClipID(), clip.getClipState().getValue())
					);
				}
			}
		}
	}
	
	public void handleClipSizeX(LiveClip clip, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (clip.eContainer() instanceof AbletonLive) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveClipInfo(clip.getTrack().getTrackID(), clip.getClipID(), clip.getClipState().getValue())
					);
				}
			}
		}
	}

	public void handleClipSizeY(LiveClip clip, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (clip.eContainer() instanceof AbletonLive) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveClipInfo(clip.getTrack().getTrackID(), clip.getClipID(), clip.getClipState().getValue())
					);
				}
			}
		}
	}

	
	public LiveScene createDefaultScene(int sceneID, String mode, String sceneName) {
		final LiveScene scene = (LiveScene) EzabletonctrlFactory.eINSTANCE.createLiveScene();
		
		scene.setMode(mode);
		scene.setSceneID(sceneID);
		scene.setSceneName(sceneName);
		
		scene.eAdapters().add(
			new AdapterImpl(){
				@Override
				public void notifyChanged(Notification msg) {
					if(msg.getEventType() == Notification.SET) {
						if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveScene_Mode())) {
							handleSceneMode(scene, msg);
						} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveScene_SceneID())) {
							handleSceneID(scene, msg);
						} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveScene_SceneName())) {
							handleSceneName(scene, msg);
						}
					}
				}
			}
		);

		return scene;
	}
	
	public void handleSceneMode(LiveScene scene, Notification msg) {
		if (scene.eContainer() instanceof AbletonLive) {
			if (abletonOscEngine instanceof CmdPipe) {
				abletonOscEngine.send(
					AbletonLive8Utils.INSTANCE.createLiveScene2(msg.getNewIntValue())
				);
			}
		}
	}
	
	public void handleSceneName(LiveScene scene, Notification msg) {
		if (scene.eContainer() instanceof AbletonLive) {
			if (abletonOscEngine instanceof CmdPipe) {
				abletonOscEngine.send(
					AbletonLive8Utils.INSTANCE.createLiveNameScene(scene.getSceneID(), msg.getNewStringValue())
				);
			}
		}
	}
	
	public void handleSceneID(LiveScene scene, Notification msg) {
		if (scene.eContainer() instanceof AbletonLive) {
			if (abletonOscEngine instanceof CmdPipe) {
				abletonOscEngine.send(
					AbletonLive8Utils.INSTANCE.createLiveNameScene(msg.getNewIntValue(), scene.getSceneName())
				);
			}
		}
	}
	
	private LiveTrack fillDefaultTrackValues(final LiveTrack track, String trackName, int trackID) {
		
		track.setArm(TRACK_ARM_STATUS.ARMED);
		track.setBeats(0f);
		track.setCoarse(0);
		track.setColor(0);
		track.setDelay(0f);
		track.setFine(0);
		track.setMute(TRACK_MUTE_STATUS.UNMUTE);
		track.setPan(0f);
		track.setSend(0);
		track.setTrackID(trackID);
		track.setSolo(TRACK_SOLO_STATUS.UNSOLO);
		track.setState(TRACK_CONTROL.STOP);
		track.setTrackID(trackID);
		track.setTrackName(trackName);
		track.setVolume(0.6f);
		track.setLastSeen(System.currentTimeMillis());
		
		if (track instanceof LiveMaster) {
			track.eAdapters().add(
					new AdapterImpl(){
						@Override
						public void notifyChanged(Notification msg) {
							if(msg.getEventType() == Notification.SET) {
								if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_Pan())) {
									handleMasterTrackPan(track, msg);
								} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_Volume())) {
									handleMasterTrackVolume(track, msg);
								} 
							} else if(msg.getEventType() == Notification.ADD || msg.getEventType() == Notification.ADD_MANY) {
								if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_Clips())) {
									handleTrackClipsRef(track, msg);
								} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_Devices())) {
									handleTrackDevicesRef(track, msg);
								}
							}
						}
					}
				);
		} else {
			track.eAdapters().add(
				new AdapterImpl(){
					@Override
					public void notifyChanged(Notification msg) {
						if(msg.getEventType() == Notification.SET) {
							if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_Arm())) {
								handleTrackArm(track, msg);
							} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_Beats())) {
								handleTrackBeats(track, msg);
							} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_Coarse())) {
								handleTrackCoarse(track, msg);
							} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_Color())) {
								handleTrackColor(track, msg);
							} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_Delay())) {
								handleTrackDelay(track, msg);
							} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_Fine())) {
								handleTrackFine(track, msg);
							} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_Mute())) {
								handleTrackMute(track, msg);
							} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_Pan())) {
								handleTrackPan(track, msg);
							} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_Send())) {
								handleTrackSend(track, msg);
							} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_Solo())) {
								handleTrackSolo(track, msg);
							}  else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_State())) {
								handleTrackState(track, msg);
							}  else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_TrackID())) {
								handleTrackID(track, msg);
							}  else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_TrackName())) {
								handleTrackName(track, msg);
							}  else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_Volume())) {
								handleTrackVolume(track, msg);
							} 
						} else if(msg.getEventType() == Notification.ADD || msg.getEventType() == Notification.ADD_MANY) {
							if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_Clips())) {
								handleTrackClipsRef(track, msg);
							} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveTrack_Devices())) {
								handleTrackDevicesRef(track, msg);
							}
						}
					}
				}
			);
		}
		return track;
	}
	
	public LiveMaster createDefaultMasterTrack(String trackName, int trackID) {
		return (LiveMaster) fillDefaultTrackValues(EzabletonctrlFactory.eINSTANCE.createLiveMaster(), trackName, trackID);
	}
	
	
	public LiveTrack createDefaultTrack(String trackName, int trackID) {
		return fillDefaultTrackValues(EzabletonctrlFactory.eINSTANCE.createLiveTrack(), trackName, trackID);
	}
	
	public void handleMasterTrackColor(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			AbletonLive liveApp = (AbletonLive) track.eContainer();
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveTrackInfo()
					);
				}
			}
		}
	}
	
	public void handleClipState(int trackID, int clipID, CLIP_STATE clipState) {
		if (abletonOscEngine instanceof CmdPipe) {
			switch(clipState) {
				case PLAYING:
					abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveStopClip(trackID, clipID));
					break;
				case HAS_CLIP:
				case STOP:
					abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLivePlayClipslot(trackID, clipID));
					break;
//				case TRIGGERED:
//				case HAS_CLIP:
//				case NO_CLIP:
//					break;
			}
		}
	}

	
	public void handleMasterTrackState(MASTER_CTRL state) {
		if (abletonOscEngine instanceof CmdPipe) {
			switch(state) {
				case PLAY:
					abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLivePlay());
					break;
				case STOP:
					abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveStop());
					break;
				case CONTINUE:
					abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLivePlayContinue());
					break;
				case NEXT:
					abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveNextCue());
					break;
				case PREC:
					abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLivePrecCue());
					break;
		//				case PAUSE:
		//					abletonOscEngine.send(AbletonLiveUtils.INSTANCE.createLiveP);
		//					break;
		//				case RECORD:
		//					break;
		//				case UNDO:
		//					break;
		//				case REDO:
		//					break;
			}
		}
	}

	public void handleOverdub() {
		abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveOverdub());
	}
	
	public void handleMasterTrackPan(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			AbletonLive liveApp = (AbletonLive) track.eContainer();
			if (liveApp instanceof AbletonLive) {
				boolean oldNotification = liveApp.isUbqtNotificationOn();
				liveApp.setUbqtNotificationOn(false);
				abletonOscEngine.send(
					AbletonLive8Utils.INSTANCE.createLiveMasterPan(0, ((Float)msg.getNewValue()).floatValue())
				);
				liveApp.setUbqtNotificationOn(oldNotification);
			}
		}
	}
	
	public void handleMasterTrackVolume(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			AbletonLive liveApp = (AbletonLive) track.eContainer();
			if (liveApp instanceof AbletonLive) {
				boolean oldNotification = liveApp.isUbqtNotificationOn();
				liveApp.setUbqtNotificationOn(false);
				System.out.println("Send LiveMasterVolume");
				abletonOscEngine.send(
					AbletonLive8Utils.INSTANCE.createLiveMasterVolume(0, ((Float)msg.getNewValue()).floatValue())
				);
				liveApp.setUbqtNotificationOn(oldNotification);
			}
		}
	}	
	
	//
	//
	//
	//
	//
	//
	//
	//
	//
	
	
	public void handleTrackArm(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (track.eContainer() instanceof AbletonLive) {
				AbletonLive liveApp = (AbletonLive) track.eContainer();
				Object obj = msg.getNewValue();
				if (obj instanceof TRACK_ARM_STATUS && liveApp.isUbqtNotificationOn()) {
					abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveArm(track.getTrackID(), ((TRACK_ARM_STATUS)obj).getValue()));
				}
			}
		}
	}

	public void handleTrackBeats(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			AbletonLive liveApp = (AbletonLive) track.eContainer();
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveTrackInfo()
					);
				}
			}
		}
	}
	
	public void handleTrackCoarse(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			AbletonLive liveApp = (AbletonLive) track.eContainer();
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveTrackInfo()
					);
				}
			}
		}
	}
	
	public void handleTrackColor(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			AbletonLive liveApp = (AbletonLive) track.eContainer();
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveTrackInfo()
					);
				}
			}
		}
	}
	
	public void handleTrackDelay(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			AbletonLive liveApp = (AbletonLive) track.eContainer();
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveTrackInfo()
					);
				}
			}
		}
	}
	
	public void handleTrackFine(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			AbletonLive liveApp = (AbletonLive) track.eContainer();
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveTrackInfo()
					);
				}
			}
		}
	}
	
	public void handleTrackPan(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			AbletonLive liveApp = (AbletonLive) track.eContainer();
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveTrackPan(track.getTrackID(), msg.getNewFloatValue())
					);
				}
			}
		}
	}
	
	public void handleTrackSend(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			AbletonLive liveApp = (AbletonLive) track.eContainer();
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveTrackInfo()
					);
				}
			}
		}
	}
	
	public void handleTrackSolo(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			AbletonLive liveApp = (AbletonLive) track.eContainer();
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveTrackSolo(track.getTrackID(), msg.getNewBooleanValue() ? TRACK_SOLO_STATUS.SOLO : TRACK_SOLO_STATUS.UNSOLO)
					);
				}
			}
		}
	}
	
	public void handleTrackState(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			AbletonLive liveApp = (AbletonLive) track.eContainer();
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveTrackInfo()
					);
				}
			}
		}
	}
	public void handleTrackVolume(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			AbletonLive liveApp = (AbletonLive) track.eContainer();
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveTrackVolume(track.getTrackID(), msg.getNewFloatValue())
					);
				}
			}
		}
	}
	public void handleTrackMute(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			AbletonLive liveApp = (AbletonLive) track.eContainer();
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveTrackMute(track.getTrackID(), msg.getNewBooleanValue() ? TRACK_MUTE_STATUS.MUTE : TRACK_MUTE_STATUS.UNMUTE)
					);
				}
			}
		}
	}
	
	public void handleTrackID(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			AbletonLive liveApp = (AbletonLive) track.eContainer();
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveTrackInfo()
					);
				}
			}
		}
	}
	
	public void handleTrackName(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			AbletonLive liveApp = (AbletonLive) track.eContainer();
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
				if (abletonOscEngine instanceof CmdPipe) {
					abletonOscEngine.send(
						AbletonLive8Utils.INSTANCE.createLiveTrackName(track.getTrackID(), msg.getNewStringValue())
					);
				}
			}
		}
	}

	//
	//
	//
	//
	//
	//
	//
	//
		
	public void handleLiveMasterMeter(AbletonLive liveApp, LiveMasterMeter liveMasterMeter) {
		LiveMaster liveMasterTrack = liveApp.getMasterTrack();
		if (liveMasterTrack instanceof LiveMaster) {
			if (liveMasterMeter instanceof LiveMasterMeter) {
				if (liveMasterMeter.getWhich() == METER_INPUT.LEFT_METER) {
					liveMasterTrack.setLeftMeter(liveMasterMeter.getLevel());
				} else {	
					liveMasterTrack.setRightMeter(liveMasterMeter.getLevel());
				}
			}
		}
	}

	public void handleLiveTrackMeter(AbletonLive liveApp, LiveTrackMeter liveTrackMeter) {
		if (liveTrackMeter instanceof LiveTrackMeter) {
			LiveTrack liveTrack = getTrackFromID(liveApp, liveTrackMeter.getTrackID());
			if (liveTrack instanceof LiveTrack) {
				tracksLastSeenAliveMap.put(""+liveTrack.getTrackID(), System.currentTimeMillis());
				if (liveTrackMeter instanceof LiveTrackMeter) {
					if (liveTrackMeter.getWhich() == METER_INPUT.LEFT_METER) {
						liveTrack.setLeftMeter(liveTrackMeter.getLevel());
					} else {	
						liveTrack.setRightMeter(liveTrackMeter.getLevel());
					}
				}
			}
		}
	}
	
	public void handleLiveClipPosition(AbletonLive liveApp, LiveClipPosition liveClipPosition) {
		if (liveClipPosition instanceof LiveClipPosition) {
			LiveTrack liveTrack = getTrackFromID(liveApp, liveClipPosition.getTrackID());
			if (liveTrack instanceof LiveTrack) {
				tracksLastSeenAliveMap.put(""+liveTrack.getTrackID(), System.currentTimeMillis());
				for (LiveClip clip : liveApp.getClips()) {
					if (clip.getClipID() == liveClipPosition.getClipID()) {
						clip.setLastSeen(System.currentTimeMillis());
						clipsLastSeenAliveMap.put(""+clip.getClipID(), System.currentTimeMillis());
						clip.setPosition(liveClipPosition.getPosition());
					}
				}
			}
		}
	}
	
	public void handleTrackClipsRef(LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			AbletonLive liveApp = (AbletonLive) track.eContainer();
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {

			}			
		}
	}
	
	public void handleTrackDevicesRef(final LiveTrack track, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (msg.getNewValue() instanceof AbstractLiveDevice) {
				if (monitorDevices) {
					final AbstractLiveDevice d = (AbstractLiveDevice) msg.getNewValue();
						d.eAdapters().add(
							new AdapterImpl(){
								@Override
								public void notifyChanged(Notification msg) {
									if(msg.getEventType() == Notification.SET) {
										if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getAbstractLiveDevice_DeviceID())) {
											//handleDeviceID(d, msg.get);
										} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getAbstractLiveDevice_DeviceName())) {
											//handleMasterDeviceName(d, msg.getNewStringValue());
										} 
									} else if(msg.getEventType() == Notification.ADD || msg.getEventType() == Notification.ADD_MANY) {
										if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getAbstractLiveDevice_Parameters())) {
											handleDeviceParametersRef(track, d, (LiveParam) msg.getNewValue());
										}
									}
								}
							}
						);
				}
			}
		}
	}
	
	private void handleDeviceParametersRef(final LiveTrack track, final AbstractLiveDevice device, Object obj) {
		if (obj instanceof LiveParam && monitorDevices) {
			LiveParam param = (LiveParam) obj;
					param.eAdapters().add(
						new AdapterImpl(){
							@Override
							public void notifyChanged(Notification msg) {
								if(msg.getEventType() == Notification.SET) {
									if (msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getLiveParam_Value())) {
										int trackID = track.getTrackID();
										int deviceID = device.getDeviceID();
										Object v = msg.getNewValue();
										
										LiveParam p = (LiveParam) msg.getNotifier();
										
										LiveDeviceParamSet deviceParamSet = EzabletonFactory.eINSTANCE.createLiveDeviceParamSet();
										deviceParamSet.setDeviceID(deviceID);
										deviceParamSet.setTrackID(trackID);
										deviceParamSet.setValue(v);
										
										try {
											deviceParamSet.setMin(Float.parseFloat(p.getMin()));
										} catch (Exception e1) {
										}
										
										try {
											deviceParamSet.setMax(Float.parseFloat(p.getMax()));
										} catch (Exception e2) {
										}
										
										String k = p.getKey();
										
										if (k != null) {
											deviceParamSet.setPIndex(Integer.parseInt(k));
										}
										
										float min = deviceParamSet.getMin();
										float max = deviceParamSet.getMax();
										
										float newV = Float.parseFloat(v.toString()) * (max - min) + min;
										
										deviceParamSet.setValue(newV);
										
										
										System.out.println(
												" /live/device" +
												" t:" + deviceParamSet.getTrackID() + 
												" d:" + deviceParamSet.getDeviceID() + 
												" k:" + deviceParamSet.getPIndex() +
												" v:" + deviceParamSet.getValue() + 
												" -:" + deviceParamSet.getMin() + 
												" +:" + deviceParamSet.getMax()
										);
										boolean oldNotification = liveApp.isUbqtNotificationOn();
										liveApp.setUbqtNotificationOn(false);

										abletonOscEngine.send(deviceParamSet);
										
										liveApp.setUbqtNotificationOn(oldNotification);

									}
								}
							}
						}
					);
				}
	}

	
	public AbletonLive handleAddTrack(AbletonLive liveApp, int trackID, String trackName) {
		
		LiveTrack track = createDefaultTrack(trackName, trackID);
		
		liveApp.getTracks().add(track);
		
		return liveApp;
	}
	
	public AbletonLive handleAddDevice(AbletonLive liveApp, int trackID, int deviceID, String deviceName) {
		
		
		LiveTrack track = getTrackFromID(liveApp, trackID);
		if (track != null) {
			// AbstractLiveDevice device = createDefaultDevice(deviceName, trackID);
			// 
			// track.getDevices().add(device);
		}
		return liveApp;
	}
	
	public AbletonLive handleAddScene(AbletonLive liveApp, int sceneID, String sceneName, String mode) {
		LiveScene scene = createDefaultScene(sceneID, mode, sceneName);
		liveApp.getScenes().add(scene);
		liveApp.setCurrentScene(scene);
		return liveApp;
	}
	
	 
	public AbletonLive createDefaultAbletonLiveSession() {
		final AbletonLive abletonLiveSession = EzabletonctrlFactory.eINSTANCE.createAbletonLive();
		
		abletonLiveSession.setVer("8.2");
		abletonLiveSession.setOverdub(false);
		abletonLiveSession.setState(MASTER_CTRL.STOP);
		abletonLiveSession.setVolume(0.5f);
		
		abletonLiveSession.eAdapters().add(new AdapterImpl(){
			@Override
			public void notifyChanged(Notification msg) {
				synchronized(abletonLiveSession) {
				if(msg.getEventType() == Notification.SET) {
					if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getAbletonLive_Overdub())) {
						handleLiveAppOverdub(abletonLiveSession, msg);
					} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getAbletonLive_State())) {
						handleLiveAppState(abletonLiveSession, msg);
					} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getAbletonLive_Tempo())) {
						handleLiveAppTempo(abletonLiveSession, msg);
					} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getAbletonLive_Time())) {
						handleLiveAppTime(abletonLiveSession, msg);
					} 
				} else if(msg.getEventType() == Notification.REMOVE || msg.getEventType() == Notification.REMOVE_MANY || msg.getEventType() == Notification.ADD || msg.getEventType() == Notification.ADD_MANY) {
					if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getAbletonLive_CurrentScene())) {
						handleLiveAppCurrentScene(abletonLiveSession, msg);
					} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getAbletonLive_MasterTrack())) {
						handleLiveAppMasterTrack(abletonLiveSession, msg);
					} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getAbletonLive_Scenes())) {
						handleLiveAppScenes(abletonLiveSession, msg);
					} else if(msg.getFeature().equals(EzabletonctrlPackage.eINSTANCE.getAbletonLive_Tracks())) {
						handleLiveAppTracks(abletonLiveSession, msg);
					} 
				}
			}
			}
		});
		
		// 
		// Following settings will depend on a Live OSC query ...
		//
		
		abletonLiveSession.setMasterTrack(createDefaultMasterTrack("Master", -1));
		
		//
		// Need a query to get currently considered Live Session tracks, scenes, clips, ...
		//
		
		// FIXME : LB to create a Minuit like query here ... !!!
		
		return abletonLiveSession;
	}
	
	
	//
	// Ubqt to Ableton Live command/event handlers
	//
	public void handleLiveAppOverdub(AbletonLive liveApp, Notification msg) {
		// TOGGLE !!!
		abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveOverdub());
	}
	
	
	public void handleLiveAppState(AbletonLive liveApp, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			boolean oldNotification = liveApp.isUbqtNotificationOn();
			liveApp.setUbqtNotificationOn(false);
			if (liveApp instanceof AbletonLive) {
				MASTER_CTRL state = (MASTER_CTRL) msg.getNewValue();
				switch(state) {
					case CONTINUE:
						abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLivePlayContinue());
						break;
					case PLAY:
						abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLivePlay());
						break;
					case STOP:
						abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveStop());
						break;
					case NEXT:
						abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveNextCue());
						break;
					case PREC:
						abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLivePrevCue());
						break;
//					case PAUSE:
//						abletonOscEngine.send(AbletonLiveUtils.INSTANCE.createLiveP);
//						break;
//					case RECORD:
//						abletonOscEngine.send(AbletonLiveUtils.INSTANCE.createLiveState());
//						break;
					case REDO:
						abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveRedo());
						break;
					case UNDO:
						abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveUndo());
						break;
				}
			}
			liveApp.setUbqtNotificationOn(oldNotification);
		}
	}
	
	public void handleLiveAppTempo(AbletonLive liveApp, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
				abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveTempo(msg.getNewFloatValue()));
			}
		}
	}
	
	public void handleLiveAppTime(AbletonLive liveApp, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
				abletonOscEngine.send(AbletonLive8Utils.INSTANCE.createLiveTime(msg.getNewFloatValue()));
			}
		}
	}
	
	
	public void handleLiveAppCurrentScene(AbletonLive liveApp, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
			}	
		}
	}
	
	public void handleLiveAppMaster(AbletonLive liveApp, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
			}
		}
	}
	
	public void handleLiveAppMasterTrack(AbletonLive liveApp, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
			}	
		}
	}
	
	public void handleLiveAppScenes(AbletonLive liveApp, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
			}
		}
	}
	
	public void handleLiveAppTracks(AbletonLive liveApp, Notification msg) {
		if (msg.getOldValue() != msg.getNewValue()) {
			if (liveApp instanceof AbletonLive && liveApp.isUbqtNotificationOn()) {
			}
		}
	}
	
	public void handleLiveControlSynchro(Cmd cmd, final AbletonLive app, final CmdPipe abletonCmdEngine) {
		try {
			handleLiveControlSynchro(cmd, app, abletonCmdEngine, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void handleLiveControlSynchro(Cmd cmd, final AbletonLive app, final CmdPipe abletonCmdEngine, boolean notify) {
		if (app ==null) return;
		
		boolean oldNotifyOnVal = app.isUbqtNotificationOn();
		
		//
		// Force notification status 
		//
		app.setUbqtNotificationOn(notify);
	
			if (cmd instanceof LivePlay) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_PLAY");
				}
				LivePlay livePlay = (LivePlay) cmd;
				updateLiveAppWithPlayStatus(app, livePlay.getStatus().getValue());
			} else if (cmd instanceof LiveScenesQ) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_SCENES_Q");
				}
				LiveScenesQ liveScenesQ = (LiveScenesQ) cmd;
				updateLiveAppWithNumScenes(app, liveScenesQ.getNumScenes());
			} else if (cmd instanceof LiveScene2) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_SCENE2");
				}
				LiveScene2 liveScene2 = (LiveScene2) cmd;
				updateLiveAppWithScene(app, liveScene2.getSceneID(), "");
			} else if (cmd instanceof LiveTracksQ) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_TRACKS_Q");
				}
				LiveTracksQ liveTracksQ = (LiveTracksQ) cmd;
				updateLiveAppWithNumTracks(app, liveTracksQ.getNumTracks());
			} else if (cmd instanceof LiveMasterMeter) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_MASTER_METER");
				}
				LiveMasterMeter liveMasterMeter = (LiveMasterMeter) cmd;
				updateLiveAppWithMasterMeter(app, liveMasterMeter.getWhich(), liveMasterMeter.getLevel());
			} else if (cmd instanceof LiveTrackMeter) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_TRACK_METER");
				}
				LiveTrackMeter liveTrackMeter = (LiveTrackMeter) cmd;
				updateLiveAppWithTrackMeter(app, liveTrackMeter.getTrackID(), liveTrackMeter.getWhich(), liveTrackMeter.getLevel());
			} else if (cmd instanceof LiveTrackPan) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_TRACK_PAN");
				}
				LiveTrackPan liveTrackPan = (LiveTrackPan) cmd;
				updateLiveAppWithTrackPan(app, liveTrackPan.getTrackID(), liveTrackPan.getPan());
			} else if (cmd instanceof LiveTrackSolo) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_TRACK_SOLO");
				}
				LiveTrackSolo liveTrackSolo = (LiveTrackSolo) cmd;
				updateLiveAppWithTrackSolo(app, liveTrackSolo.getTrackID(), TRACK_SOLO_STATUS.SOLO);
			}  else if (cmd instanceof LiveTrackMute) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_TRACK_SOLO");
				}
				LiveTrackMute liveTrackMute = (LiveTrackMute) cmd;
				updateLiveAppWithTrackMute(app, liveTrackMute.getTrackID(), TRACK_MUTE_STATUS.MUTE);
			}  else if (cmd instanceof LiveClipPosition) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_CLIP_POSITION");
				}
				LiveClipPosition liveClipPosition = (LiveClipPosition) cmd;
				updateLiveAppWithClipPosition(app, liveClipPosition.getTrackID(), liveClipPosition.getClipID(), liveClipPosition.getPosition(), liveClipPosition.getLength(), liveClipPosition.getLoopStart(), liveClipPosition.getLoopEnd());
			} else if (cmd instanceof LiveArmReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_ARM_REQ");
				}
				LiveArmReq liveArmReq = (LiveArmReq) cmd;
				updateLiveAppWithArmReq(app, liveArmReq.getTrackID(), liveArmReq.getStatus());
			} else if (cmd instanceof LiveClipInfo) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_CLIP_INFO");
				}
				LiveClipInfo liveClipInfo = (LiveClipInfo) cmd;
				updateLiveAppWithClipInfo(app, liveClipInfo.getTrackID(), liveClipInfo.getClipID(), liveClipInfo.getStatus());
			} else if (cmd instanceof LiveDetailView) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_DETAIL_VIEW");
				}
				LiveDetailView liveDetailView = (LiveDetailView) cmd;
				updateLiveAppWithDetailView(app, liveDetailView.getValue());
			} else if (cmd instanceof LiveDevice) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_DEVICE");
				}
				LiveDevice liveDevice = (LiveDevice) cmd;
				updateLiveAppWithDevice(app, liveDevice.getTrackID(), liveDevice.getDeviceID(), liveDevice.getParam());
			} else if (cmd instanceof LiveDevicelist) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_DEVICELIST");
				}
				updateLiveAppWithDevicelist(app, (LiveDevicelist) cmd);
			} else if (cmd instanceof LiveDeviceRange) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_DEVICE_RANGE");
				}
				updateLiveAppWithDeviceRange(app, (LiveDeviceRange) cmd);
			} else if (cmd instanceof LiveDeviceRangeAll) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_DEVICE_RANGE_ALL");
				}
				updateLiveAppWithDeviceRangeAll(app, (LiveDeviceRangeAll) cmd);
			} else if (cmd instanceof LiveMasterDeviceView) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_MASTER_DEVICE_VIEW");
				}
				LiveMasterDeviceView liveMasterDeviceView = (LiveMasterDeviceView) cmd;
				updateLiveAppWithMasterDeviceWiew(app, liveMasterDeviceView.getDeviceID());
			} else if (cmd instanceof LiveMasterPanReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_MASTER_PAN_REQ");
				}
				LiveMasterPanReq liveMasterPanReq = (LiveMasterPanReq) cmd;
				updateLiveAppWithMasterPanReq(app, liveMasterPanReq.getTrackID(), liveMasterPanReq.getPan());
			} else if (cmd instanceof LiveMasterVolume) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_MASTER_VOLUME");
				}
				LiveMasterVolume liveMasterVolume = (LiveMasterVolume) cmd;
				updateLiveAppWithMasterVolume(app, liveMasterVolume.getTrackID(), liveMasterVolume.getLevel());
			} else if (cmd instanceof LiveMasterVolumeReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_MASTER_VOLUME_REQ");
				}
				LiveMasterVolumeReq liveMasterVolumeReq = (LiveMasterVolumeReq) cmd;
				updateLiveAppWithMasterVolume(app, liveMasterVolumeReq.getTrackID(), liveMasterVolumeReq.getLevel());
			} else if (cmd instanceof LiveMuteReq) {
				System.out.println("LIVE_MUTE_REQ");
				LiveMuteReq liveMuteReq = (LiveMuteReq) cmd;
				updateLiveAppWithMuteReq(app, liveMuteReq.getTrackID(), liveMuteReq.getStatus());
			} else if (cmd instanceof LiveNameClipReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_NAME_CLIP_REQ");
				}
				LiveNameClipReq liveNameClipReq = (LiveNameClipReq) cmd;
				updateLiveAppWithNameClip(app, liveNameClipReq.getTrackID(), liveNameClipReq.getClipID(), liveNameClipReq.getLabel(), liveNameClipReq.getColor());
			} else if (cmd instanceof LiveNameClipblockreq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_NAME_CLIPBLOCKREQ");
				}
				LiveNameClipblockreq liveNameClipblockreq = (LiveNameClipblockreq) cmd;
				updateLiveAppWithNameClipblock(app, liveNameClipblockreq.getTrackID(), liveNameClipblockreq.getClipID(), liveNameClipblockreq.getSizeX(), liveNameClipblockreq.getSizeY());
			} else if (cmd instanceof LiveNameSceneBlockReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_NAME_SCENE_BLOCK_REQ");
				}
				LiveNameSceneBlockReq liveNameSceneBlockReq = (LiveNameSceneBlockReq) cmd;
				updateLiveAppWithDeviceSceneBlock(app, liveNameSceneBlockReq.getTrackID(), liveNameSceneBlockReq.getSize());
			} else if (cmd instanceof LiveNameSceneReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_NAME_SCENE_REQ");
				}
				LiveNameSceneReq liveNameSceneReq = (LiveNameSceneReq) cmd;
				updateLiveAppWithNameScene(app, liveNameSceneReq.getSceneID(), liveNameSceneReq.getSceneName());
			} else if (cmd instanceof LiveNameTrackReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_NAME_TRACK_REQ");
				}
				LiveNameTrackReq liveNameTrackReq = (LiveNameTrackReq) cmd;
				updateLiveAppWithNameTrackInfo(app, liveNameTrackReq.getTrackID(), liveNameTrackReq.getColor(), liveNameTrackReq.getTrackName());
			} else if (cmd instanceof LiveNameTrackblockReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_NAME_TRACKBLOCK_REQ");
				}
				LiveNameTrackblockReq liveNameTrackblockReq = (LiveNameTrackblockReq) cmd;
				updateLiveAppWithNameTrackblockReq(app, liveNameTrackblockReq.getTrackID(), liveNameTrackblockReq.getSize(), liveNameTrackblockReq.getTrackName().toArray(new String[0]));
			} else if (cmd instanceof LiveNextCueReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_NEXT_CUE_REQ");
				}
				LiveNextCueReq liveNextCueReq = (LiveNextCueReq) cmd;
				updateLiveAppWithNextCueReq(app);
			} else if (cmd instanceof LiveOverdub) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_OVERDUB");
				}
				updateLiveAppWithOverdub(app);
			} else if (cmd instanceof LivePanSet) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_PAN_SET");
				}
				LivePanSet livePanSet = (LivePanSet) cmd;
				updateLiveAppWithPanSet(app, livePanSet.getTrackID(), livePanSet.getValue());
			} else if (cmd instanceof LivePitchSet) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_PITCH_SET");
				}
				LivePitchSet livePitchSet = (LivePitchSet) cmd;
				updateLiveAppWithPitchSet(app, livePitchSet.getTrackID(), livePitchSet.getClip(), livePitchSet.getCoarse(), livePitchSet.getFine());
			} else if (cmd instanceof LivePlayClipReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_PLAY_CLIP_REQ");
				}
				LivePlayClipReq livePlayClipReq = (LivePlayClipReq) cmd;
				updateLiveAppWithPlayClipReq(app);
			} else if (cmd instanceof LivePlayClipSlotReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_PLAY_CLIP_SLOT_REQ");
				}
				LivePlayClipSlotReq livePlayClipSlotReq = (LivePlayClipSlotReq) cmd;
				updateLiveAppWithDeviceWiew(app, livePlayClipSlotReq.getTrackID(), livePlayClipSlotReq.getClipID());
			} else if (cmd instanceof LivePlayContinueReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_PLAY_CONTINUE_REQ");
				}
				LivePlayContinueReq livePlayContinueReq = (LivePlayContinueReq) cmd;
				updateLiveAppWithPlayContinueReq(app);
			} else if (cmd instanceof LivePlayReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_PLAY_REQ");
				}
				LivePlayReq livePlayReq = (LivePlayReq) cmd;
				updateLiveAppWithLivePlayReq(app);
			} else if (cmd instanceof LivePlaySceneReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_PLAY_SCENE_REQ");
				}
				LivePlaySceneReq livePlaySceneReq = (LivePlaySceneReq) cmd;
				updateLiveAppWithPlaySceneReq(app, livePlaySceneReq.getSceneID());
			} else if (cmd instanceof LivePlaySceneReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_PLAY_SELECTION_REQ");
				}
				livePlaySelectionReq livePlaySelectionReq = (livePlaySelectionReq) cmd;
				updateLiveAppWithPlaySelection(app);
			} else if (cmd instanceof LivePrevCueReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_PREV_CUE_REQ");
				}
				LivePrevCueReq livePrevCueReq = (LivePrevCueReq) cmd;
				updateLiveAppWithPrevCue(app);
			} else if (cmd instanceof LiveRedoReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_REDO_REQ");
				}
				updateLiveAppWithRedo(app);
			} else if (cmd instanceof LiveReturnDeviceView) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_RETURN_DEVICE_VIEW");
				}
				LiveReturnDeviceView liveReturnDeviceView = (LiveReturnDeviceView) cmd;
				updateLiveAppWithDeviceWiew(app, liveReturnDeviceView.getTrackID(), liveReturnDeviceView.getDeviceID());
			} else if (cmd instanceof LiveReturnDevicelist) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_RETURN_DEVICELIST");
				}
				LiveReturnDevicelist liveReturnDeviceList = (LiveReturnDevicelist) cmd;
				updateLiveAppWithDeviceList(app, liveReturnDeviceList.getTrackID(),  -1);
			} else if (cmd instanceof LiveReturnMuteReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_RETURN_MUTE_REQ");
				}
				LiveReturnMuteReq liveReturnMuteReq = (LiveReturnMuteReq) cmd;
				updateLiveAppWithTrackMute(app, liveReturnMuteReq.getTrackID(), liveReturnMuteReq.getStatus());
			} else if (cmd instanceof LiveReturnPan) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_RETURN_PAN");
				}
				LiveReturnPan liveReturnPan = (LiveReturnPan) cmd;
				updateLiveAppWithTrackPan(app, liveReturnPan.getTrackID(), liveReturnPan.getPan());
			} else if (cmd instanceof LiveReturnPanReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_RETURN_PAN_REQ");
				}
				LiveReturnPanReq liveReturnPanReq = (LiveReturnPanReq) cmd;
				updateLiveAppWithTrackPan(app, liveReturnPanReq.getTrackID(), liveReturnPanReq.getPan());
			} else if (cmd instanceof LiveReturnSend) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_RETURN_SEND");
				}
				LiveReturnSend liveReturnSend = (LiveReturnSend) cmd;
				updateLiveAppWithTrackSend(app, liveReturnSend.getTrackID(), liveReturnSend.getLevel(), liveReturnSend.getSend());
			} else if (cmd instanceof LiveDeviceParam) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_DEVICE__PARAM");
				}
				LiveDeviceParam liveDeviceParam = (LiveDeviceParam) cmd;
				updateLiveAppWithDeviceParam(app, liveDeviceParam.getTrackID(), liveDeviceParam.getDeviceID(), liveDeviceParam.getParam(), liveDeviceParam.getValue(), liveDeviceParam.getName());
			} else if (cmd instanceof LiveReturnSendReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_RETURN_SEND_REQ");
				}
				LiveReturnSendReq liveReturnSendReq = (LiveReturnSendReq) cmd;
				updateLiveAppWithTrackSend(app, liveReturnSendReq.getTrackID(), liveReturnSendReq.getLevel(), liveReturnSendReq.getSend());
			} else if (cmd instanceof LiveReturnSolo) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_RETURN_SOLO");
				}
				LiveReturnSolo liveReturnSolo = (LiveReturnSolo) cmd;
				updateLiveAppWithTrackSolo(app, liveReturnSolo.getTrackID(), liveReturnSolo.getStatus());
			} else if (cmd instanceof LiveReturnVolume) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_RETURN_VOLUME");
				}
				LiveReturnVolume liveReturnVol = (LiveReturnVolume) cmd;
				updateLiveAppWithTrackVolume(app, liveReturnVol.getTrackID(), liveReturnVol.getLevel());
			} else if (cmd instanceof LiveSceneReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_SCENE_REQ");
				}
				LiveSceneReq liveSceneReq = (LiveSceneReq) cmd;
				updateLiveAppWithScene(app, liveSceneReq.getSceneID(), liveSceneReq.getMode());
			} else if (cmd instanceof LiveScenesReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_SCENES_REQ");
				}
				LiveScenesReq liveScenesReq = (LiveScenesReq) cmd;
				updateLiveAppWithScenes(app, liveScenesReq);
			} else if (cmd instanceof LiveSendReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_SEND_REQ");
				}
				LiveSendReq liveSendReq = (LiveSendReq) cmd;
				updateLiveAppWithSend(app, liveSendReq.getTrackID(), liveSendReq.getValue());
			} else if (cmd instanceof LiveStateRcv) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_SCENE_REQ");
				}
				LiveStateRcv liveStateRcv = (LiveStateRcv) cmd;
				updateLiveAppWithStateRcv(app, liveStateRcv.getTempo());
			} else if (cmd instanceof LiveStateReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_STATE_REQ");
				}
				LiveStateReq liveStateReq = (LiveStateReq) cmd;
				updateLiveAppWithState(app);
			} else if (cmd instanceof LiveStopClipReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_STOP_CLIP_REQ");
				}
				LiveStopClipReq liveStopClipReq = (LiveStopClipReq) cmd;
				updateLiveAppWithStopClip(app, liveStopClipReq.getTrackID(), liveStopClipReq.getClipID());
			} else if (cmd instanceof LiveStopReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_STOP_REQ");
				}
				LiveStopReq liveStopReq = (LiveStopReq) cmd;
				updateLiveAppWithStopReq(app);
			} else if (cmd instanceof LiveStopTrackReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_STOP_TRACK_REQ");
				}
				LiveStopTrackReq liveStopTrackReq = (LiveStopTrackReq) cmd;
				updateLiveAppWithStopTrackReq(app, liveStopTrackReq.getTrackID());
			} else if (cmd instanceof LiveTempoRcv) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_TEMPO_RCV");
				}
				LiveTempoRcv liveTempoRcv = (LiveTempoRcv) cmd;
				updateLiveAppWithTempo(app, liveTempoRcv.getTempo());
			} else if (cmd instanceof LiveTempoReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_TEMPO_REQ");
				}
			} else if (cmd instanceof LiveTimeRcv) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_TIME_RCV");
				}
				LiveTimeRcv liveTimeRcv = (LiveTimeRcv) cmd;
				updateLiveAppWithTime(app, liveTimeRcv.getTime());
			} else if (cmd instanceof LiveTimeReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_TIME_REQ");
				}
			} else if (cmd instanceof LiveTrackDeviceView) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_TRACK_DEVICE_VIEW");
				}
				LiveTrackDeviceView liveTrackDeviceView = (LiveTrackDeviceView) cmd;
				updateLiveAppWithTrackDeviceView(app, liveTrackDeviceView.getTrackID(), liveTrackDeviceView.getDeviceID());
			} else if (cmd instanceof LiveTrackInfo) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_TRACK_INFO");
				}
				LiveTrackInfo liveTrackInfo = (LiveTrackInfo) cmd;
				updateLiveAppWithTrackInfo(app, liveTrackInfo.getTrackID());
			} else if (cmd instanceof LiveTrackJump) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_TRACK_JUMP");
				}
				LiveTrackJump liveTrackJump = (LiveTrackJump) cmd;
				updateLiveAppWithTrackJump(app, liveTrackJump.getTrackID(), liveTrackJump.getBeats());
			} else if (cmd instanceof LiveTracksReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_TRACKS_REQ");
				}
				LiveTracksReq liveTracksReq = (LiveTracksReq) cmd;
				updateLiveAppWithTracks(app, liveTracksReq);
			} else if (cmd instanceof LiveUndoReq) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_UNDO_REQ");
				}
				LiveUndoReq liveUndoReq = (LiveUndoReq) cmd;
				updateLiveAppWithUndo(app, liveUndoReq);
			} else if (cmd instanceof LiveVolumeSet) {
				if (Platform.inDebugMode()) {
					System.out.println("LIVE_VOLUME_SET");
				}
			}
		
		//
		// Set old notificationOn value back
		//
		app.setUbqtNotificationOn(oldNotifyOnVal);
	}
	
	public void updateLiveAppWithPlayStatus(AbletonLive liveApp, int status) {
		liveApp.setState(status==1?MASTER_CTRL.STOP:MASTER_CTRL.PLAY);
	}
	
	public void updateLiveAppWithTrackMeter(AbletonLive liveApp, int trackID, METER_INPUT which, float level) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		LiveTrack track = getTrackFromID(liveApp, trackID);
		if (track instanceof LiveTrack) {
			if (which == METER_INPUT.LEFT_METER) {
				track.setLeftMeter(level);
			} else {
				track.setRightMeter(level);
			} 
		}
	}
	
	public void updateLiveAppWithNumScenes(AbletonLive liveApp, int NumScenes) {
		List<LiveScene> scenesToBeRemoved = new ArrayList<LiveScene>();
		for (LiveScene scene : liveApp.getScenes()) {
			if (scene.getSceneID()>NumScenes) {
				scenesToBeRemoved.add(scene);
			}
		}
		for (LiveScene scene2BeRemoved : scenesToBeRemoved) {
			liveApp.getScenes().remove(scene2BeRemoved);
		}
	}
	
	public void updateLiveAppWithNumTracks(AbletonLive liveApp, int NumTracks) {
		List<LiveTrack> tracksToBeRemoved = new ArrayList<LiveTrack>();
		for (LiveTrack track : liveApp.getTracks()) {
			if (track.getTrackID()>NumTracks) {
				tracksToBeRemoved.add(track);
			}
		}
		for (LiveTrack track2BeRemoved : tracksToBeRemoved) {
			liveApp.getTracks().remove(track2BeRemoved);
		}
	}
	
	public void updateLiveAppWithMasterMeter(AbletonLive liveApp, METER_INPUT which, float level) {
		if (liveApp != null && liveApp.getMasterTrack() instanceof LiveMaster && level >= 0.0f) {
			if (which == METER_INPUT.LEFT_METER) {
				liveApp.getMasterTrack().setLeftMeter(level);
			} else {
				liveApp.getMasterTrack().setRightMeter(level);
			}
		}
	}
	
	public void updateLiveAppWithClipPosition(AbletonLive liveApp, int trackID, int clipID, float position, float length, float loopStart, float loopEnd) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		clipsLastSeenAliveMap.put(""+clipID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			boolean clipNotFound = true;
			for (LiveClip clip : liveTrack.getClips()) {
				if (clip.getClipID() == clipID) {
					clip.setPosition(position);
					clip.setLength(length);
					clip.setLoopStart(loopStart);
					clip.setLoopEnd(loopEnd);
					clip.setLastSeen(System.currentTimeMillis());
					clipNotFound = false;
				}
			}
			if (clipNotFound) {
				LiveClip clip = createDefaultClip(clipID, "");
				clip.setPosition(position);
				clip.setLength(length);
				clip.setLoopStart(loopStart);
				clip.setLoopEnd(loopEnd);
			}
		}
	}
	
	public void updateLiveAppWithOverdub(AbletonLive liveApp) {
		liveApp.setOverdub(!liveApp.isOverdub());
	}
	
	
	public void updateLiveAppWithDetailView(AbletonLive liveApp, float value) {
		// dunno what to do w/ that info ...
	}
	
	public void updateLiveAppWithPitchSet(AbletonLive liveApp, int trackID, int clipID, int coarse, int fine) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		clipsLastSeenAliveMap.put(""+clipID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			liveTrack.setLastSeen(System.currentTimeMillis());
			boolean clipNotFound = true;
			for (LiveClip clip : liveTrack.getClips()) {
				if (clip.getClipID() == clipID) {
					clip.setCoarse(coarse);
					clip.setFine(fine);
					clip.setLastSeen(System.currentTimeMillis());
					clipNotFound = false;
				}
			}
			if (clipNotFound) {
				LiveClip clip = createDefaultClip(clipID, "");
				clip.setCoarse(coarse);
				clip.setFine(fine);
			}
		}
	}
	
	public void updateLiveAppWithNameTrackInfo(AbletonLive liveApp, int trackID, int color, String trackName) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack == null) {
			liveTrack = createDefaultTrack(trackName, trackID);
			liveApp.getTracks().add(liveTrack);
		} else {
			liveTrack.setColor(color);
			liveTrack.setTrackName(trackName);
		} 
	}
	
	public void updateLiveAppWithNameScene(AbletonLive liveApp, int sceneID, String sceneName) {
		scenesLastSeenAliveMap.put(""+sceneID, System.currentTimeMillis());
		LiveScene liveScene = getSceneFromID(liveApp, sceneID);
		if (liveScene == null) {
			liveScene = createDefaultScene(sceneID, "", sceneName);
			liveApp.getScenes().add(liveScene);
		}
		liveScene.setSceneName(sceneName);
	}

	public void updateLiveAppWithNameTrackblockReq(AbletonLive liveApp, int trackID, int size, String[] trackNames) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		for (int id = trackID; id < trackID+(size-1); id++) {
			LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
			if (liveTrack instanceof LiveTrack) {
				liveTrack.setTrackName(trackNames[id]);
			}
		}
	}
	
	public void updateLiveAppWithDeviceSceneBlock(AbletonLive liveApp, int trackID, int size) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		// dunno what to do w/ that info ...
	}
	
	public void updateLiveAppWithNameClipblock(AbletonLive liveApp, int trackID, int clipID, int sizeX, int sizeY) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		clipsLastSeenAliveMap.put(""+clipID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			boolean clipFound = false;
			for (LiveClip clip : liveTrack.getClips()) {
				if (clip.getClipID() == clipID) {
					clip.setLastSeen(System.currentTimeMillis());
					clip.setSizeX(sizeX);
					clip.setSizeY(sizeY);
					clipFound = true;
				}
			}
			if (!clipFound) {
				LiveClip clip = createDefaultClip(clipID, "");
				clip.setSizeX(sizeX);
				clip.setSizeY(sizeY);

				liveTrack.getClips().add(clip);
			}
		}
	}
	
	
	public void updateLiveAppWithNameClip(AbletonLive liveApp, int trackID, int clipID, String clipName, int color) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		clipsLastSeenAliveMap.put(""+clipID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			boolean clipNotFound = true;
			for (LiveClip clip : liveTrack.getClips()) {
				if (clip.getClipID() == clipID) {
					clip.setClipName(clipName);
					clip.setColor(getColor(color));
					clip.setLastSeen(System.currentTimeMillis());
					clipNotFound = false;
				}
			}
			if (clipNotFound) {
				LiveClip clip = createDefaultClip(clipID, clipName);
				liveTrack.getClips().add(clip);
			}
		}
	}

	public void cleanLiveApp(AbletonLive liveApp) {
		synchronized (liveApp.getTracks()) {
			List<LiveTrack> tracksToBeRemoved = new ArrayList<LiveTrack>();
			for (LiveTrack track : liveApp.getTracks()) {
				synchronized(track) {
					if (track != null) {
						int id = track.getTrackID();
						if (id >= 0) {
							if (tracksLastSeenAliveMap.containsKey(""+id)) {
								if ((System.currentTimeMillis() - tracksLastSeenAliveMap.get(""+id)) > LIVE_TRACK_TTL) {
									tracksToBeRemoved.add(track);
								}
							}
						}
					}
					List<AbstractLiveDevice> devicesToBeRemoved = new ArrayList<AbstractLiveDevice>();
					for (AbstractLiveDevice device : track.getDevices()) {
						if (device != null) {
							int id = track.getTrackID();
							if (id >= 0) {
								if (devicesLastSeenAliveMap.containsKey(""+id)) {
									if ((System.currentTimeMillis() - devicesLastSeenAliveMap.get(""+id)) > LIVE_TRACK_TTL) {
										devicesToBeRemoved.add(device);
									}
								}
							}
						}
					}
					for (AbstractLiveDevice device : devicesToBeRemoved) {
						track.getDevices().remove(device);
					}
				}
			}
			for (LiveTrack track : tracksToBeRemoved) {
				liveApp.getTracks().remove(track);
			}
		}
		
		synchronized(liveApp.getScenes()) {
			List<LiveScene> scenesToBeRemoved = new ArrayList<LiveScene>();
			for (LiveScene scene : liveApp.getScenes()) {
				if (scene != null) {
					int id = scene.getSceneID();
					if (id >= 0) {
						if (scenesLastSeenAliveMap.containsKey(""+id)) {
							if ((System.currentTimeMillis() - scenesLastSeenAliveMap.get(""+id)) > LIVE_TRACK_TTL) {
								scenesToBeRemoved.add(scene);
							}
						}
					}
				}
			}
			for (LiveScene scene : scenesToBeRemoved) {
				liveApp.getScenes().remove(scene);
			}
			// Remaining tracks
			for (LiveTrack track : liveApp.getTracks()) {
				cleanClips(track);
			}
		}
	}
	
	public void cleanClips(LiveTrack liveTrack) {
		synchronized (liveTrack.getClips()) {
			List<LiveClip> clipsToBeRemoved = new ArrayList<LiveClip>();
			for (LiveClip clip : liveTrack.getClips()) {
				if (clipsLastSeenAliveMap.containsKey(""+clip.getClipID())) {
					if ((System.currentTimeMillis() - clipsLastSeenAliveMap.get(""+clip.getClipID())) > LIVE_CLIP_TTL) {
						clipsToBeRemoved.add(clip);
					}
				}
			}
			for (LiveClip clip : clipsToBeRemoved) {
				liveTrack.getClips().remove(clip);
			}
		}
	}
	
	public void updateLiveAppWithMuteReq(AbletonLive liveApp, int trackID, TRACK_MUTE_STATUS status) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			liveTrack.setMute(status);
		}
	}
	
	public void updateLiveAppWithMasterVolume(AbletonLive liveApp, int trackID, float level) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		if (liveApp.getMasterTrack().getVolume() != level) {
			liveApp.getMasterTrack().eSetDeliver(false);
			liveApp.getMasterTrack().setVolume(level);
			liveApp.getMasterTrack().eSetDeliver(true);
		}
	}
	
	public void updateLiveAppWithPanSet(AbletonLive liveApp, int trackID, float panVal) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			liveApp.getMasterTrack().eSetDeliver(false);
			liveTrack.setPan(panVal);
			liveApp.getMasterTrack().eSetDeliver(true);
		}
	}
	
	public void updateLiveAppWithMasterPanReq(AbletonLive liveApp, int trackID, float panVal) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		if (liveApp.getMasterTrack().getPan() != panVal) {
			liveApp.getMasterTrack().eSetDeliver(false);
			liveApp.getMasterTrack().setPan(panVal);
			liveApp.getMasterTrack().eSetDeliver(true);
		}
	}
	
	public void updateLiveAppWithMasterDeviceWiew(AbletonLive liveApp, int deviceID) {
		devicesLastSeenAliveMap.put(""+deviceID, System.currentTimeMillis());
		AbstractLiveDevice device = getDeviceFromID(liveApp, deviceID);
		if (device instanceof AbstractLiveDevice) {
			// dunno what to do w/ that info ...
		}
	}
	
	private LiveParam findParam(AbstractLiveDevice device, int paramID, boolean create) {
		LiveParam param = null;
		if (device != null) {
			for (LiveParam p : device.getParameters()) {
				if (p != null && p.getKey().equals(paramID+"")) {
					return p;
				}
			}
			if (param == null && create) {
				param = EzabletonctrlFactory.eINSTANCE.createLiveParam();
				param.setKey(""+paramID);
				device.getParameters().add(param);
			}
		}
		return param;
	}

	private String getType(Object obj) {
		return obj.getClass().getCanonicalName();
	}
	
	public void updateLiveAppWithDeviceRange(AbletonLive liveApp, LiveDeviceRange liveDeviceRange) {
		int trackID = liveDeviceRange.getTrackID();
		//liveReturnDevicelist.get
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		if (monitorDevices) {
			LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
			if (liveTrack instanceof LiveTrack) {
				boolean deviceFound = false;
				AbstractLiveDevice device = null;
				for (AbstractLiveDevice d : liveTrack.getDevices()) {
					if (d.getDeviceID() == liveDeviceRange.getDeviceID()) {
						device = d;
						deviceFound = true;
					}
				}
				if (!deviceFound) {
					device = createDefaultDevice(liveDeviceRange.getDeviceID(), "???");
					liveTrack.getDevices().add(device);
				}
				if (device != null) {
					OSCMessage osc = (OSCMessage) liveDeviceRange.getMsg();
					Object[] args = osc.getArguments();
					if (args != null) {
						if (args.length > 0) {
							int cur = 2;
							while (args.length >= (cur + 3)) {
								Integer i	= (Integer) args[cur]; // param idx
								Object min	= (Object) args[cur+1]; // param min
								Object max	= (Object) args[cur+2]; // param max
								
								LiveParam param = findParam(device, i, true);
	
								param.eSetDeliver(false);
								param.setMin(""+min);
								param.setMax(""+max);
								param.setType(getType(min));
								param.eSetDeliver(true);
	
								cur += 3;
							}
						}
					}
				}
			}
		}
	}
	

	public void updateLiveAppWithReturnDeviceRangeAll(AbletonLive liveApp, LiveReturnDeviceRangeAll liveDeviceRange) {
		int trackID = liveDeviceRange.getTrackID();
		//liveReturnDevicelist.get
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		if (monitorDevices) {
			LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
			if (liveTrack instanceof LiveTrack) {
				OSCMessage osc = (OSCMessage) liveDeviceRange.getMsg();
				Object[] args = osc.getArguments();
				if (args != null) {
					if (args.length > 0) {
						//Integer idx = (Integer) args[0];
						int cur = 1;
						while (args.length >= (cur + 2)) {
							Integer i	= (Integer) args[cur];
							String n	= (String) args[cur+1];
							cur += 2;
							boolean deviceFound = false;
							for (AbstractLiveDevice d : liveTrack.getDevices()) {
								if (d.getDeviceID() == i) {
									deviceFound = true;
								}
							}
							if (!deviceFound) {
								liveTrack.getDevices().add(createDefaultDevice(i, n));
							}
						}
					}
				}
			}
		}
	}
	


	public void updateLiveAppWithReturnDeviceRange(AbletonLive liveApp, LiveReturnDeviceRange liveDeviceRange) {
		int trackID = liveDeviceRange.getTrackID();
		//liveReturnDevicelist.get
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		if (monitorDevices) {
			LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
			if (liveTrack instanceof LiveTrack) {
				OSCMessage osc = (OSCMessage) liveDeviceRange.getMsg();
				Object[] args = osc.getArguments();
				if (args != null) {
					if (args.length > 0) {
						//Integer idx = (Integer) args[0];
						int cur = 1;
						while (args.length >= (cur + 2)) {
							Integer i	= (Integer) args[cur];
							String n	= (String) args[cur+1];
							cur += 2;
							boolean deviceFound = false;
							for (AbstractLiveDevice d : liveTrack.getDevices()) {
								if (d.getDeviceID() == i) {
									deviceFound = true;
								}
							}
							if (!deviceFound) {
								liveTrack.getDevices().add(createDefaultDevice(i, n));
							}
						}
					}
				}
			}
		}
	}
	


	public void updateLiveAppWithDeviceRangeAll(AbletonLive liveApp, LiveDeviceRangeAll liveDeviceRange) {
		int trackID = liveDeviceRange.getTrackID();
		//liveReturnDevicelist.get
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		if (monitorDevices) {
			LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
			if (liveTrack instanceof LiveTrack) {
				OSCMessage osc = (OSCMessage) liveDeviceRange.getMsg();
				Object[] args = osc.getArguments();
				if (args != null) {
					if (args.length > 0) {
						//Integer idx = (Integer) args[0];
						int cur = 1;
						while (args.length >= (cur + 2)) {
							Integer i	= (Integer) args[cur];
							String n	= (String) args[cur+1];
							cur += 2;
							boolean deviceFound = false;
							for (AbstractLiveDevice d : liveTrack.getDevices()) {
								if (d.getDeviceID() == i) {
									deviceFound = true;
								}
							}
							if (!deviceFound) {
								liveTrack.getDevices().add(createDefaultDevice(i, n));
							}
						}
					}
				}
			}
		}
	}
	
	public void updateLiveAppWithDevicelist(AbletonLive liveApp, LiveDevicelist liveReturnDevicelist) {
		int trackID = liveReturnDevicelist.getTrackID();
		//liveReturnDevicelist.get
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		if (monitorDevices) {
			LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
			if (liveTrack instanceof LiveTrack) {
				OSCMessage osc = (OSCMessage) liveReturnDevicelist.getMsg();
				Object[] args = osc.getArguments();
				if (args != null) {
					if (args.length > 0) {
						//Integer idx = (Integer) args[0];
						int cur = 1;
						while (args.length >= (cur + 2)) {
							Integer i	= (Integer) args[cur];
							String n	= (String) args[cur+1];
							cur += 2;
							boolean deviceFound = false;
							for (AbstractLiveDevice d : liveTrack.getDevices()) {
								if (d.getDeviceID() == i) {
									deviceFound = true;
								}
							}
							if (!deviceFound) {
								liveTrack.getDevices().add(createDefaultDevice(i, n));
							}
						}
					}
				}
			}
		}
	}
	
	public void updateLiveAppWithDevice(AbletonLive liveApp, int trackID, int clipID, int param) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		clipsLastSeenAliveMap.put(""+clipID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			boolean clipFound = false;
			for (LiveClip clip : liveTrack.getClips()) {
				if (clip.getClipID() == clipID) {
					// dunno what to do w/ that info ...
					clipFound = true;
					
					
				}
			}
			if (!clipFound) {
				LiveClip clip = createDefaultClip(clipID, "");
				liveTrack.getClips().add(clip);
			}
		}
	}
	
	public void updateLiveAppWithClipInfo(AbletonLive liveApp, int trackID, int clipID, CLIP_STATE state) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		clipsLastSeenAliveMap.put(""+clipID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			boolean clipFound = false;
			for (LiveClip clip : liveTrack.getClips()) {
				if (clip.getClipID() == clipID) {
					clip.setClipState(state);
					clip.setLastSeen(System.currentTimeMillis());
					clipFound = true;
				}
			}
			if (!clipFound) {
				LiveClip clip = createDefaultClip(clipID, "");
				clip.setClipState(state);
				liveTrack.getClips().add(clip);
			}
		}
	}
	
	public void updateLiveAppWithArmReq(AbletonLive liveApp, int sceneID, TRACK_ARM_STATUS status) {
		scenesLastSeenAliveMap.put(""+sceneID, System.currentTimeMillis());
		LiveScene liveScene = getSceneFromID(liveApp, sceneID);
		if (liveScene instanceof LiveScene) {
			liveApp.setCurrentScene(liveScene);
		}
	}
	
	public void updateLiveAppWithPlaySceneReq(AbletonLive liveApp, int sceneID) {
		LiveScene liveScene = getSceneFromID(liveApp, sceneID);
		scenesLastSeenAliveMap.put(""+sceneID, System.currentTimeMillis());
		if (liveScene instanceof LiveScene) {
			liveApp.setCurrentScene(liveScene);
		}
	}
	
	public void updateLiveAppWithPlayClipReq(AbletonLive liveApp) {
		// dunno what to do w/ that info ...
	}
	
	public void updateLiveAppWithLivePlayReq(AbletonLive liveApp) {
		liveApp.setState(MASTER_CTRL.PLAY);
	}
	
	public void updateLiveAppWithLivePlay(AbletonLive liveApp) {
		liveApp.setState(MASTER_CTRL.PLAY);
	}
	
	public void updateLiveAppWithPlaySelection(AbletonLive liveApp) {
		liveApp.setState(MASTER_CTRL.PLAY);
	}
	
	public void updateLiveAppWithPlayContinueReq(AbletonLive liveApp) {
		liveApp.setState(MASTER_CTRL.CONTINUE);
	}
	
	public void updateLiveAppWithNextCueReq(AbletonLive liveApp) {
		liveApp.setState(MASTER_CTRL.NEXT);
	}
	
	public void updateLiveAppWithPrevCue(AbletonLive liveApp) {
		liveApp.setState(MASTER_CTRL.PREC);
	}
	
	public void updateLiveAppWithUndo(AbletonLive liveApp, LiveUndoReq undoReq) {
		liveApp.setState(MASTER_CTRL.UNDO);
	}
	
	public void updateLiveAppWithRedo(AbletonLive liveApp) {
		liveApp.setState(MASTER_CTRL.REDO);
	}
	
	public void updateLiveAppWithStopReq(AbletonLive liveApp) {
		liveApp.setState(MASTER_CTRL.STOP);
	}
	
	public void updateLiveAppWithScenes(AbletonLive liveApp, LiveScenesReq scenes) {
		if (scenes instanceof LiveScenesReq) {
			// dunno what to do w/ that info ...
		}
	}
	
	public void updateLiveAppWithStateRcv(AbletonLive liveApp, float tempo) {
		liveApp.setTempo(tempo);
	}
	
	public void updateLiveAppWithSend(AbletonLive liveApp, int trackID, int value) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			liveTrack.setSend(value);
		}
	}
	
	public void updateLiveAppWithState(AbletonLive liveApp) {
		// dunno what to do w/ that info ...
	}
	
	public void updateLiveAppWithStopTrackReq(AbletonLive liveApp, int trackID) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			liveTrack.setState(TRACK_CONTROL.STOP);
		}
	}
	
	public void updateLiveAppWithTempo(AbletonLive liveApp, float tempo) {
		liveApp.setTempo(new Float(tempo));
	}
	
	public void updateLiveAppWithTime(AbletonLive liveApp, float time) {
		liveApp.setTime(new Float(time).longValue());
	}
	
	public void updateLiveAppWithStopClip(AbletonLive liveApp, int trackID, int clipID) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		clipsLastSeenAliveMap.put(""+clipID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			boolean clipFound = false;
			for (LiveClip clip : liveTrack.getClips()) {
				if (clip.getClipID() == clipID) {
					clip.setClipState(CLIP_STATE.STOP);
					clip.setLastSeen(System.currentTimeMillis());
					clipFound = true;
				}
			}
			if (!clipFound) {
				LiveClip clip = createDefaultClip(clipID, "");
				clip.setClipState(CLIP_STATE.STOP);
				liveTrack.getClips().add(clip);
			}
		}
	}
	
	public void updateLiveAppWithTrackDeviceView(AbletonLive liveApp, int trackID, int sceneID) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		scenesLastSeenAliveMap.put(""+sceneID, System.currentTimeMillis());
		// dunno what to do w/ that info ...
	}
	
	public void updateLiveAppWithTrackInfo(AbletonLive liveApp, int trackID) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		// dunno what to do w/ that info ...
	}
	
	public void updateLiveAppWithTrackJump(AbletonLive liveApp, int trackID, float beatsVal) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			liveTrack.setBeats(beatsVal);
		}
	}
	
	public void updateLiveAppWithTracks(AbletonLive liveApp, LiveTracksReq liveTracksReq) {
		// dunno what to do w/ that info ...
	}
	
	public void updateLiveAppWithScene(AbletonLive liveApp, int sceneID, String mode) {
		scenesLastSeenAliveMap.put(""+sceneID, System.currentTimeMillis());
		LiveScene liveScene = getSceneFromID(liveApp, sceneID);
		if (liveScene instanceof LiveScene) {
			//liveScene.setMode(mode);
			liveApp.setCurrentScene(liveScene);
		}
	}
	
	public void updateLiveAppWithTrackVolume(AbletonLive liveApp, int trackID, float level) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			liveTrack.setVolume(level);
		}
	}
	
	public void updateLiveAppWithTrackSolo(AbletonLive liveApp, int trackID, TRACK_SOLO_STATUS status) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			liveTrack.setSolo(status);
		}
	}
	
	public void updateLiveAppWithDeviceParam(AbletonLive liveApp, int trackID, int deviceID, int paramID, Object value, String name) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		devicesLastSeenAliveMap.put(""+deviceID, System.currentTimeMillis());
		if (monitorDevices) {
			LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
			if (liveTrack instanceof LiveTrack) {
				AbstractLiveDevice device = null;
				for (AbstractLiveDevice d : liveTrack.getDevices()) {
					if (d.getDeviceID() == deviceID) {
						device = d;
						break;
					}
				}
				if (device == null) {
					liveTrack.getDevices().add(device = createDefaultDevice(deviceID, "Placeholder"));
				}
				if (device != null) {
					LiveParam p = findParam(device, paramID, true);
					if (p != null) {
						p.eSetDeliver(false);
						p.setKey(""+paramID);
						p.setValue(""+value);
						p.setType(value.getClass().getCanonicalName());
						p.setName(name);
						p.eSetDeliver(true);
					}
				}
			}
		}
	}
	
	public void updateLiveAppWithTrackSend(AbletonLive liveApp, int trackID, float levelVal, int sendVal) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			liveTrack.setVolume(levelVal);
			liveTrack.setSend(sendVal);
		}
	}
	
	public void updateLiveAppWithTrackPan(AbletonLive liveApp, int trackID, float panVal) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			liveTrack.setPan(panVal);
		}
	}

	public void updateLiveAppWithTrackMute(AbletonLive liveApp, int trackID, TRACK_MUTE_STATUS status) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			liveTrack.setMute(status);
		}
	}
	
	public void updateLiveAppWithDeviceList(AbletonLive liveApp, int trackID, int deviceID) {
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		devicesLastSeenAliveMap.put(""+deviceID, System.currentTimeMillis());
		boolean deviceNotFound = true;
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			for (AbstractLiveDevice device : liveTrack.getDevices()) {
				if (device.getDeviceID() == deviceID) {
					deviceNotFound = false;
				}
			}
			if (deviceNotFound) {
				liveTrack.getDevices().add(createDefaultDevice(deviceID, "Placeholder"));
				abletonOscEngine.send(
					AbletonLive8Utils.INSTANCE.createLiveDevicelist(trackID)
				);
				abletonOscEngine.send(
					AbletonLive8Utils.INSTANCE.createLiveDeviceRangeAllQ(trackID, deviceID)
				);
			}
		}
	}
	
	public void updateLiveAppWithDeviceWiew(AbletonLive liveApp, int trackID, int deviceID) {
		devicesLastSeenAliveMap.put(""+deviceID, System.currentTimeMillis());
		tracksLastSeenAliveMap.put(""+trackID, System.currentTimeMillis());
		LiveTrack liveTrack = getTrackFromID(liveApp, trackID);
		if (liveTrack instanceof LiveTrack) {
			boolean deviceNotFound = true;
			for (AbstractLiveDevice device : liveTrack.getDevices()) {
				if (device.getDeviceID() == deviceID) {
					// dunno what to do w/ that info ...
				}
			}
			if (deviceNotFound) {
				AbstractLiveDevice device = EzabletonctrlFactory.eINSTANCE.createPlaceHolderDevice();
				device.setDeviceID(deviceID);
				device.setDeviceName("PlaceHolder");
				liveTrack.getDevices().add(device);
			}
		}
	}
	
	//
	// Get AbletonLive app ref form a track/clip/scene
	// 
	
	public AbletonLive getAbletonLiveFromTrack(LiveTrack track) {
		if (track instanceof LiveTrack) {
			if (track.eContainer() instanceof AbletonLive) {
				return (AbletonLive)track.eContainer();
			}
		}
		return null;
	}
	
	public CmdPipe getEngineFromScene(LiveScene scene) {
		AbletonLive liveApp = getAbletonLiveFromScene(scene);
		return liveApp == null ? null : abletonOscEngine;
	}
	
	public CmdPipe getEngineFromClip(LiveClip clip) {
		AbletonLive liveApp = getAbletonLiveFromClip(clip);
		return liveApp == null ? null : abletonOscEngine;
	}
	
	public CmdPipe getEngineFromTrack(LiveTrack track) {
		AbletonLive liveApp = getAbletonLiveFromTrack(track);
		return liveApp == null ? null : abletonOscEngine;
	}
	
	public AbletonLive getAbletonLiveFromScene(LiveScene scene) {
		if (scene instanceof LiveScene) {
			if (scene.eContainer() instanceof AbletonLive) {
				return (AbletonLive)scene.eContainer();
			}
		}
		return null;
	}

	public AbletonLive getAbletonLiveFromClip(LiveClip clip) {
		if (clip instanceof LiveClip) {
			if (clip.eContainer() instanceof AbletonLive) {
				return (AbletonLive)clip.eContainer();
			}
		}
		return null;
	}
	
	//
	// Ableton Live accessors
	//
	
	public LiveTrack getTrackFromID(AbletonLive liveApp, int trackID) {
		for (LiveTrack liveTrack : liveApp.getTracks()) {
			if (liveTrack.getTrackID() == trackID) {
				return liveTrack;
			}
		}
		return null;
	}
	
	public LiveScene getSceneFromID(AbletonLive liveApp, int sceneID) {
		for (LiveScene scene : liveApp.getScenes()) {
			if (scene.getSceneID() == sceneID) {
				return scene;
			}
		}
		return null;
	}

	public AbstractLiveDevice getDeviceFromID(AbletonLive liveApp, int deviceID) {
		for (LiveTrack track : liveApp.getTracks()) {
			for (AbstractLiveDevice device : track.getDevices()) {
				if (device.getDeviceID() == deviceID) {
					return device;
				}
			}
		}
		return null;
	}
	*/
}