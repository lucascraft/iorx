package ubiquisense.iorx.ui.fmurf;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;
import com.illposed.osc.OSCMessage;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import ubiquisense.iorx.ui.fmurf.enums.AnchorKind;
import ubiquisense.iorx.ui.fmurf.enums.SmurfKind;
import ubiquisense.iorx.ui.fmurf.fmf.FMFOscillator;
import ubiquisense.iorx.ui.fmurf.osc.OscReceiver;
import ubiquisense.iorx.ui.fmurf.osc.OscSender;
import ubiquisense.iorx.ui.tuio11.impl.TuioContainer;
import ubiquisense.iorx.ui.tuio11.impl.TuioCursor;
import ubiquisense.iorx.ui.tuio11.impl.TuioObject;
import ubiquisense.iorx.ui.tuio11.impl.TuioPoint;

public class SmurfBrainImpl {
	//
	Set<Smurf> smurfs;
	Set<SmurfFinger> fingers;
	Set<SmurfConnection> connections;
	
	// OSC
	OscSender sender;
	OscReceiver receiver;
	
	SmurfCfg config;
	
	SmurfBeat beat;
	GridPane mtPane;
	boolean connectionsAllowed;
	
	Set<Smuon> selection;
	
	//ConnectionUtils  connectionUtils;
	int bpm;
	int MIN_GESTURE_POINTS_THRESHOLD=15;
	public SmurfBrainImpl(GridPane mtPane, int bpm, int oscInPort, String outAddr, int oscOutPort)
	{
		this.mtPane = mtPane;
		
		// OSC
		sender = new OscSender(outAddr, oscOutPort);
		receiver = new OscReceiver(oscInPort);
		
		//config = loadConfig();
		
		connectionsAllowed = true;
		//connectionUtils = new ConnectionsUtils();
		selection = new HashSet<Smuon>();
		connectionsAllowed = false;

		initBeat(bpm);
		initTouchEventHandlers(mtPane);
	}
	
	
	public void initTouchEventHandlers(GridPane mtPane)
	{

		mtPane.setOnMouseEntered(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) {
		        System.out.println("Mouse entered"); 
		    }
		});
		
		mtPane.setOnMouseExited(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) {
		        System.out.println("Mouse exited");
		    }
		});
		
		mtPane.setOnMousePressed(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) {
		        System.out.println("Mouse pressed");
		    }
		});	
		
		mtPane.setOnMouseReleased(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) {
		        System.out.println("Mouse released");
		    }
		});	
	}

	public void initBeat(int bpm) {	
		beat = new SmurfBeat();
		beat.setBPM(bpm);
		beat.start();
	}

	public double ofGetWidth()
	{
		return mtPane.getWidth();
	}
	public double ofGetHeight()
	{
		return mtPane.getHeight();
	}

	public void handleBeat(int waveId, Set<SWave> waves) {
		int ret = beat.bang();
		if(ret != -1) {
			(waves).add(new SWave(-1, waveId, (int) ofGetWidth()/2, (int) ofGetHeight()/2, 1000));	
			
			OSCMessage onBeatMsg = new OSCMessage();
			onBeatMsg.setAddress("/smurf/beat");
			onBeatMsg.addArgument(getBPM());
			
			getOscSender().sendMessage(onBeatMsg);
		}
	}

	public void handleOscReceive() {
		while( getOscReceiver().hasWaitingMessages() )
		{
			OSCMessage m = getOscReceiver().getNextMessage();
			
//			if ("/smurf/fid".equals(m.getAddress()) {
//				int npos = m.getAddress().find(std::string("/smurf/fid"));
//				std::string fidAndCommand = m.getAddress().substr(11);
//				std::string fid = fidAndCommand.substr(0,1);
//				
//				if (m.getAddress().find(std::string("/live")) != string::npos) {
//					int nbArgs = m.getNumArgs();				
//									
//					Smurf s = findSmurf(strtof(fid.c_str(), null));
//					if (s != null) {
//						for (int i=0;i<nbArgs;i++) {
//							s.pushLiveData(i, m .getArguments().get(i));
//						}
//						s.draw();
//					}
//				}
//			}
		}
	}

	// ACCESSORS
	//--------------------------------------

	public void setSmurfs(Set<Smurf> _smurfs) {
		smurfs = _smurfs;
	}

	public void setFingers(Set<SmurfFinger> _fingers) {
		fingers = _fingers;
	}

	public void setConnections(Set<SmurfConnection> _connections) {
		connections = _connections;
	}

	public Set<Smurf> getSmurfs() {
		return smurfs;
	}

	public Set<SmurfFinger>  getFingers() {
		return fingers;
	}

	public Set<SmurfConnection>  getConnections() {
		return connections;
	}

	public void setBPM(int _bpm) {
		beat.setBPM(_bpm);
	}

	public int getBPM() {
		return beat.getBPM();
	}

	// OSC sender handling
	//---------------------------------------

	public void setOscSender(OscSender _sender) {
		sender = _sender;
	}

	public OscSender getOscSender() {
		return sender;
	}

	// OSC receiver handling
	//---------------------------------------

	public void setOscReceiver(OscReceiver _receiver) {
		receiver = _receiver;
	}

	public OscReceiver getOscReceiver() {
		return receiver;
	}

	// Configuration
	// ---------------------------------------

	public void setSmurfCfg(SmurfCfg _cfg) {
		config = _cfg;
	}

	public SmurfCfg getSmurfCfg() {
		return config;
	}

	// Gestures
	// ---------------------------

	// Connections
	// ----------------------------
	public boolean isConnectionModeOn() {
		return connectionsAllowed;
	}

	public void toggleConnectionMode() {
		connectionsAllowed=(connectionsAllowed==true?false:true);
	}


	public void handleSimpleSelection(Smurf _smurf) {
		if (_smurf != null) {
			boolean status = _smurf.isSelected()?false:true;
			_smurf.setSelected(status);
		}
	}

	public void handleMultipleSelection(Set<Smurf> _smuon) {
		// Not implemented yet !!!
	}

	SmurfConnection createConnection(Smuon  smuon, float fromID, float toID, SConnectionVisual kind) {
		SmurfAnchor from = SmurfUtils.createSmurfAnchor(findSmurf(fromID), fromID, AnchorKind.ANCHOR_KIND_OUTPUT);
		from.setKind(SmurfKind.SMURF_KIND_ANCHOR);
		
		SmurfAnchor to = SmurfUtils.createSmurfAnchor(findSmurf(toID), toID, AnchorKind.ANCHOR_KIND_INPUT);
		to.setKind(SmurfKind.SMURF_KIND_ANCHOR);

		smurfs.add(from);
		smurfs.add(to);
		
		SmurfConnection connection = new SmurfConnection(from, to, kind);
		connection.setFromAnchor(from);
		connection.setToAnchor(to);
		connection.setConnectionVisual(kind);
		connection.setConnectionKind(SConnectKind.CONNECT_UNKNOWN);
		
		return connection;
	}

	void handleCreateLinkInitial(Smuon  smuon, Smurf _smurf, SConnectionVisual kind) {
		if (_smurf == null) return; // NO from Smurf matched
		if (_smurf.getKind() == SmurfKind.SMURF_KIND_HANDLE) return;
		if (_smurf.getKind() == SmurfKind.SMURF_KIND_ANCHOR) return;
		
		Smurf connectionHandle = SmurfUtils.createAtypicalSmurf(smuon, SmurfKind.SMURF_KIND_HANDLE);
		if (connectionHandle != null) {
			smurfs.add(connectionHandle);
		} else {
			return;
		}
		
		if (_smurf.getTuio() != null && connectionHandle.getTuio() != null) {
			SmurfConnection connection = createConnection(smuon, _smurf.getTuio().session_id, connectionHandle.getTuio().session_id, kind);

			if (connection != null) {
				connections.add(connection);
			}
		}
	}

	void handleCreateNonTangibleSmurf(Smuon  smuon, SmurfKind kind) {
		Smurf atypicalSmurf = SmurfUtils.createAtypicalSmurf(smuon, kind);
		if (atypicalSmurf != null) {
			smurfs.add(atypicalSmurf);
		}
	}



	// TUIO messages Handling
	//---------------------------------------

	void markSelection(SmurfFinger finger, Set<Smurf> smurfs) {
		for (Smurf smurf : smurfs) {
			TuioObject tuio = ( TuioObject) smurf.getTuio();
			for (Slot slot : smurf.getSlots()) {
				float dist = finger.getTuio().getDistance(slot.getTuio())/50;
				if (dist < 0.0002) {
					if (slot.getKind() == SlotKind.TOGGLE) {
						slot.setSelected(slot.isSelected()==false?true:false);
					} else if (slot.getKind() == SlotKind.PUSH) {
						// Special fx ?
					}
					for (OSCMessage msg :slot.getOscMessages()) {
						
						OSCMessage copy = new OSCMessage();
						copy.setAddress(msg.getAddress());
						copy.addArgument(tuio.fiducial_id);
						copy.addArgument(slot.getOrderFromSlotPosition());
						copy.addArgument(tuio.getX());
						copy.addArgument(tuio.getY());
						copy.addArgument(tuio.getAngleDegrees());
						
						getOscSender().sendMessage( copy);
					}
				}
			}
		}
	}

	boolean isCursorAlive(SmurfFinger _finger) {
		return findCursor(_finger.getTuio().session_id) != null;
	}

	SmurfFinger findCursor(float sessionId) {
		for (SmurfFinger finger : fingers) {
			if (finger.getTuio().session_id == sessionId) {
				return finger;
			}
		}
		return null;
	}

	Smurf findSmurf(float sessionId) {
		for (Smurf smurf : smurfs) {
			if (smurf.getTuio().session_id == sessionId) {
				return smurf;
			}
		}
		return null;
	}


	boolean isCursorAlive(float _sessionId) {
		return findCursor(_sessionId) != null;
	}

	Smurf findSmurfGettingDraggedIfAny(float _sessionId) {
		for (Smurf smurf : smurfs) {
			if (smurf.getDragging() == _sessionId) {
				return smurf;
			}
		}
		return null;
	}
					
	// Cursor Add
	void handleCursorAdd(TuioCursor tuioCursor) {
		if (!isCursorAlive(tuioCursor.session_id)) {
			SmurfFinger finger = new SmurfFinger(tuioCursor);
			finger.setTuio(tuioCursor);
			fingers.add(finger);		
			finger.addPoint(tuioCursor.getPosition());
			finger.onAdd(getOscSender());
			handleSelection(finger);
		}
	}

	void removeNoMoreValidConnections(Smurf _smurf) {	
		if (_smurf == null) return;
		Set<SmurfConnection> connectionsToRemove = new HashSet<>();
		for (SmurfConnection connection : connections) {
			if (connection != null) {
				if (connection.fromAnchor() == null || connection.toAnchor() == null) {
					connectionsToRemove.add(connection);
					connection = null;			
				} else if (connection.fromID() == _smurf.getTuio().session_id || connection.toID() == _smurf.getTuio().session_id) {
					if (connection.fromAnchor() != null) {
						if (connection.fromAnchor().getTuio() != null) {
							deleteSmurf(connection.fromAnchor().getTuio().session_id);
						}
					}
					if (connection.toAnchor() != null) {
						if (connection.toAnchor().getTuio() != null) {
							deleteSmurf(connection.toAnchor().getTuio().session_id);
						}
					}
					connectionsToRemove.add(connection);
				}
			}
		}
		connectionsToRemove.removeAll(connectionsToRemove);
	}

	void deleteSmurf(float sid) {
		Set<Smurf> smurfsToRemove = new HashSet<>();
		for (Smurf smurf: smurfs) {
			if (smurf != null) {
				TuioObject tuio = ( TuioObject) smurf.getTuio();
				if (tuio != null && sid == tuio.session_id) {
					smurf.onRemove(getOscSender());
					smurfsToRemove.add(smurf);
					break;
				}
			}
		}
		smurfs.removeAll(smurfsToRemove);
	}

	void handleSelection(SmurfFinger _finger) {
		if (_finger == null) return;

		for (Smurf smurf : smurfs) {
			TuioContainer target = smurf.getTuio();
			if (target != null && target.getDistance(_finger.getTuio()) < 0.03 && !smurf.isAlreadyDragging()) {
				smurf.setDragging(_finger.getTuio().session_id);
				smurf.toggleSelected();
			}
		}	
	}

	public Smurf evalIfTargetIsDropCompatible(Smurf dragged) {
		if (dragged.getKind() == SmurfKind.SMURF_KIND_HANDLE) {
			for (Smurf smurf : smurfs) {
				if (smurf != null) {
					TuioContainer  target = smurf.getTuio();
					if (target != null) {
						if (dragged.getTuio() != null) {
							if (target.getDistance(dragged.getTuio()) < 0.03) {
								if (smurf.getKind() != SmurfKind.SMURF_KIND_HANDLE) {
									return smurf;
								}
							}
						}
					}
				}
			}
		}
		return null; 
	}

	public void doConnectToTargetIfAnyValidConnection(Smurf dragged, Smurf target) {
		for (SmurfConnection connection : connections) {
			if (connection != null) {
				float toID = connection.toID();
				if (dragged.getTuio() != null) {
					if (toID == dragged.getTuio().session_id) {
						if (target != null) {
							connection.setToID(target.getTuio().session_id);
							deleteSmurf(dragged.getTuio().session_id);
						}
					}
				}
			}
		}
	}

	public boolean areAlreadyConnected(Smurf from, Smurf to) {
		if (from != null && to != null) { 
			for (SmurfConnection connection : connections) {
				if (from.getTuio() != null && to.getTuio() != null) {
					if (to.getTuio().session_id == from.getTuio().session_id) {
						return true;
					} else if (
						connection.toID() == to.getTuio().session_id && 
						connection.fromID() == from.getTuio().session_id
					) {
						return true;
					} else if (
						connection.toID() == from.getTuio().session_id && 
						connection.fromID() == to.getTuio().session_id
					) {
						return true;
					} 
				}
			}
		}
		return false;
	}


	public void evalConnectivityToOtherSmurfsOnRangeIfAny(Smurf from) {
		if (from == null || from.getTuio() == null) return;
		if (from instanceof SmurfAnchor) return;
		
		if (from.getKind() == SmurfKind.SMURF_KIND_TANGIBLE) {
			for (Smurf to : smurfs) {
				if (!(to instanceof SmurfAnchor) && to.getKind() == SmurfKind.SMURF_KIND_TANGIBLE) {
					TuioContainer target = to.getTuio();
			
					if (target != null) {
						TuioPoint fromPt = new TuioPoint(from.getTuio().getPosition().getX(), from.getTuio().getPosition().getY());
						TuioPoint toPt = new TuioPoint(to.getTuio().getPosition().getX(), to.getTuio().getPosition().getY());
			
						float fX = fromPt.getX() * (float) mtPane.getWidth();
						float fY = fromPt.getY() * (float) mtPane.getHeight();
						float tX = toPt.getX() * (float) mtPane.getWidth();
						float tY = toPt.getY() * (float) mtPane.getHeight();
			
//						TuioPoint fnPt = new TuioPoint(fX, fY);
//						TuioPoint tnPt = new TuioPoint(tX, tY);
			
						float dx = fX-tX;
						float dy = fY-tY;
			
						float dist = Double.valueOf(Math.sqrt(dx * dx+dy* dy)).floatValue();
			
						if (isConnectionModeOn()) {
							if (from.getProxima() > dist) {
								// To refine
								if (!areAlreadyConnected(from, to)) {
									SmurfConnection connection = createConnection(
																   from, 
																   from.getTuio().session_id,
																   to.getTuio().session_id, 
																   SConnectionVisual.CONNECTION_LINE
																   );
									connections.add(connection);
								}
							} else {
								if (areAlreadyConnected(from, to)) {
									removeNoMoreValidConnections(from);
									removeNoMoreValidConnections(to);
								}
							}
						}
					}
				}
			}
		}
	}


	// Cursor Update
	void handleCursorUpdate(TuioCursor tuioCursor) {
		for (SmurfFinger finger : fingers) {
			if (finger != null && finger.getTuio() != null) {
				if (finger.getTuio().session_id == tuioCursor.session_id) {
					Smurf smurf = findSmurfGettingDraggedIfAny(finger.getTuio().session_id);
					if (smurf != null) {
						finger.clearPoints();
					
						if (smurf.getTuio() != null) {
							((TuioObject)smurf.getTuio()).update(
																   tuioCursor.getPosition().getX(), 
																   tuioCursor.getPosition().getY(),
																   (( TuioObject)smurf.getTuio()).getAngle(), 
																   tuioCursor.getSpeedX(), 
																   tuioCursor.getSpeedY(), 
																   0.0f, 
																   tuioCursor.getMotionSpeed(), 
																   tuioCursor.getMotionAccel()
																   );
						}
					} else {
						finger.addPoint(tuioCursor.getPosition());
					}

					finger.setTuio(tuioCursor);
					finger.onUpdate(getOscSender());

					break;
				}
			}
		}
	}

	// Cursor Remove
	public void handleCursorRemove(TuioCursor tuioCursor) {
		Set<SmurfFinger> fingersToRemove = Sets.newHashSet();
		for (SmurfFinger finger : fingers) {
			if (finger != null && finger.getTuio() != null) {
				if (finger.getTuio().session_id == tuioCursor.session_id) {
					markSelection(finger, smurfs);
				
					if (finger.getPoints() != null && finger.getPoints().size()>MIN_GESTURE_POINTS_THRESHOLD) {
						//handleGesture(finger, gesturesEngine.isMatching(finger.getPoints()));
					}
				
					Smurf dragged = findSmurfGettingDraggedIfAny(finger.getTuio().session_id);
					if (dragged != null) {
						Smurf target = evalIfTargetIsDropCompatible(dragged);
						if (target != null) {
							doConnectToTargetIfAnyValidConnection(dragged, target);
						} else {
							dragged.setDragging(-Float.MAX_VALUE);
						}
					}
					
					finger.onRemove(getOscSender());

					fingersToRemove.add(finger);
					
					break;
				}
			}
		}
		fingers.removeAll(fingersToRemove);
	}
//
//
//
//
	// Smurf Add
	void handleSmurfAdd(TuioObject tuioObject) {
		boolean absent = true;
		for (Smurf smurf : smurfs) {
			if (smurf != null) {
				TuioObject tuio = ( TuioObject) smurf.getTuio();
				if (tuio != null) {
					if (tuio.session_id == tuioObject.session_id) {
						smurf.onAdd(getOscSender());
						absent = false;
						break;
					}
				}
			}
		}
		if (absent) {
			
			SmurfDetails detail = getSmurfCfg().getSmurfDetails(tuioObject.fiducial_id);

			Smurf smurfToAdd;
			if (detail.kind == "OSCILLATOR") {
				smurfToAdd = new FMFOscillator(tuioObject, SmurfKind.SMURF_KIND_TANGIBLE);
			} else if (detail.kind == "PHAZOR") {
				smurfToAdd = new FMFOscillator(tuioObject, SmurfKind.SMURF_KIND_TANGIBLE);
			} else {
				smurfToAdd = new SmurfImpl(tuioObject, SmurfKind.SMURF_KIND_TANGIBLE);
			}

			smurfToAdd.onAdd(getOscSender());

			smurfToAdd.setFG(detail.fg);
			smurfToAdd.setBG(detail.bg);
			smurfToAdd.setAspect(detail.aspect);
			smurfToAdd.setRadius(detail.radius);
			smurfToAdd.setProxima(detail.proxima);
			smurfToAdd.setProximaVisible(detail.proximaVisible);
			smurfToAdd.setRange((int)detail.range);
			smurfToAdd.setFunction(detail.function);
			
			smurfs.add(smurfToAdd);
		}
	}

	// Smurf Update
	void handleSmurfUpdate(TuioObject tuioObject) {
		for (Smurf smurf : smurfs) {
			if (smurf != null) {
				TuioObject tuio = ( TuioObject) smurf.getTuio();
				if (tuio != null) {
					if (tuio.session_id == tuioObject.session_id) {
						smurf.setTuio(tuioObject);
				
						evalConnectivityToOtherSmurfsOnRangeIfAny(smurf);

						smurf.onUpdate(getOscSender());
						break;
					}
				}
			}
		}
	}

	// Smurf Remove
	void handleSmurfRemove(TuioObject tuioObject) {
		Set<Smurf> smurfsToRemove = Sets.newHashSet();
		for (Smurf smurf : smurfs) {
			TuioObject tuio = ( TuioObject) smurf.getTuio();
			if (tuio != null) {
				if (tuio.session_id == tuioObject.session_id) {
					removeNoMoreValidConnections(smurf);
					smurf.getOscMsgMap().clear();
					smurf.onRemove(getOscSender());
				
					smurfsToRemove.add(smurf);
					
					break;
				}
			}
		}
		smurfs.removeAll(smurfsToRemove);
	}

	// TUIO object added
	void objectAdded(TuioObject tuioObject){
		handleSmurfAdd(tuioObject);
	}

	// TUIO object removed
	void objectRemoved(TuioObject tuioObject){
		handleSmurfRemove(tuioObject);
	}

	// TUIO object updated
	void objectUpdated(TuioObject tuioObject){
		handleSmurfUpdate(tuioObject);
	}

	// TUIO cursor added
	void tuioAdded(TuioCursor tuioCursor){
		handleCursorAdd(tuioCursor);
	}

	// TUIO cursor removed
	void tuioRemoved(TuioCursor tuioCursor){
		handleCursorRemove(tuioCursor);
	}

	// TUIO cursor updated
	void tuioUpdated(TuioCursor tuioCursor){
		handleCursorUpdate(tuioCursor);
	}
}
