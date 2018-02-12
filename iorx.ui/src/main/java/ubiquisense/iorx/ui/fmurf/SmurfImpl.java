package ubiquisense.iorx.ui.fmurf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.illposed.osc.OSCMessage;

import ubiquisense.iorx.ui.fmurf.enums.SmurfAspect;
import ubiquisense.iorx.ui.fmurf.enums.SmurfEvt;
import ubiquisense.iorx.ui.fmurf.enums.SmurfFunction;
import ubiquisense.iorx.ui.fmurf.enums.SmurfKind;
import ubiquisense.iorx.ui.fmurf.osc.OscSender;
import ubiquisense.iorx.ui.tuio11.impl.TuioObject;

public class SmurfImpl extends SmurferImpl implements Smurf{

	Map<SmurfEvt, Set<OSCMessage>> oscMsgMap;
	Set<Slot> slots;
	OSCMessage OscMessage;
	List<Float> liveData;
	protected SmurfAspect aspect;
	protected SmurfKind kind;
	protected SmurfFunction function;
	protected int lastWaveUid;
	protected boolean beingUpdated;

	public SmurfImpl(TuioObject tuioObj, SmurfKind kind) {
		// super(tuioObj, kind);
		slots = new HashSet<Slot>();
		oscMsgMap = new HashMap<SmurfEvt, Set<OSCMessage>>();

		setTuio(tuioObj);
		setKind(kind);
		setFunction(SmurfFunction.SMURF_FUNC_NONE);
		setLastWaveUid(-1);

		OSCMessage onEvtMsg = new OSCMessage();
		onEvtMsg.setAddress("/smurf/fid/");

		addOscMsgOnEvent(SmurfEvt.EVT_ADD, onEvtMsg);
		addOscMsgOnEvent(SmurfEvt.EVT_UPDATE, onEvtMsg);
		addOscMsgOnEvent(SmurfEvt.EVT_REMOVE, onEvtMsg);

		liveData = new ArrayList<Float>(67);

		//
		// -------------------------------------------------

		// OscMessage slotAofOScMsg = new OscMessage();
		// slotAofOScMsg.setAddress("/smurf/fid/slotAction");
		// slotAofOScMsg.addIntArg(tuioObj.getFiducialId());
		// slotAofOScMsg.addIntArg(0);
		//
		// setSlot(_A, PUSH, BOX, slotAofOScMsg);
		//
		// OscMessage slotBofOScMsg = new OscMessage();
		// slotBofOScMsg.setAddress("/smurf/fid/slotAction");
		// slotBofOScMsg.addIntArg(tuioObj.getFiducialId());
		// slotBofOScMsg.addIntArg(1);
		//
		// setSlot(_B, PUSH, BOX, slotBofOScMsg);
		//
		// OscMessage slotCofOScMsg = new OscMessage();
		// slotCofOScMsg.setAddress("/smurf/fid/slotAction");
		// slotCofOScMsg.addIntArg(tuioObj.getFiducialId());
		// slotCofOScMsg.addIntArg(2);
		//
		// setSlot(_C, PUSH, BOX, slotCofOScMsg);
		//
		// OscMessage slotDofOScMsg = new OscMessage();
		// slotDofOScMsg.setAddress("/smurf/fid/slotAction");
		// slotDofOScMsg.addIntArg(tuioObj.getFiducialId());
		// slotDofOScMsg.addIntArg(3);
		//
		// setSlot(_D, PUSH, BOX, slotAofOScMsg);

		animation = SmurfStyle.PULSE;
		aspect = SmurfAspect.SMURF_ASPECT_DISC;
	}

	public void setAspect(SmurfAspect _aspect) {
		aspect = _aspect;
	}

	public SmurfAspect getAspect() {
		return aspect;
	}

	public Set<Slot> getSlots() {
		return slots;
	}

	public void addOscMsgOnEvent(SmurfEvt evt, OSCMessage msg) {
		if (!oscMsgMap.keySet().contains(evt)) {
			oscMsgMap.put(evt, new HashSet<OSCMessage>());
		}
		oscMsgMap.get(evt).add(msg);
	}

	public void removeOscMsgOnEvent(SmurfEvt evt, OSCMessage msg) {
		// oscMsgMap[evt].erase(msg);
	}

	public void setLastWaveUid(int _uid) {
		lastWaveUid = _uid;
	}

	public int getLastWaveUid() {
		return lastWaveUid;
	}

	public void updateLiveData() {
		// liveData.clear();
		// liveData.push(float(((ofxTuioObject)getTuio()).getAngleDegrees()/360.0));
		draw();
	}

	public void onBeat(OscSender _sender, SWave wave) {
		TuioObject obj = (TuioObject) getTuio();

		OSCMessage onBeatMsg = new OSCMessage();

		onBeatMsg.setAddress("/smurf/fid/" + obj.fiducial_id + "/bang");
		onBeatMsg.getArguments().add(obj.getX());
		onBeatMsg.getArguments().add(obj.getY());
		onBeatMsg.getArguments().add(obj.getAngleDegrees() / 360.0);

		_sender.sendMessage(onBeatMsg);
	}

	public SmurfKind getKind() {
		return kind;
	}

	public void setKind(SmurfKind _kind) {
		kind = _kind;
	}

	public SmurfFunction getFunction() {
		return function;
	}

	public void setFunction(SmurfFunction _function) {
		function = _function;
	}

	public List<Float> getLiveData() {
		return liveData;
	}

	public void setLiveData(List<Float> _livedata) {
		liveData = _livedata;
	}

	public void pushLiveData(int _idx, Float _data) {
		if (liveData.size() > _idx) {
			liveData.set(_idx, _data);
		}
	}

	public void onAdd(OscSender _sender) {
		// Map<SmurfEvt, Set<OSCMessage>>::const_iterator
		// mit (oscMsgMap.begin()),
		// mend(oscMsgMap.end());
		// for(;mit!=mend;++mit) {
		// if (mit.first == EVT_ADD) {
		// vector<OscMessage> v = (vector<OscMessage>) mit.second;
		// for (int i=0; i<v.size(); i++ ) {
		// OscMessage msg = (OscMessage ) v.at(i);
		//
		// OscMessage copy = new OscMessage();
		// copy.copy(msg);
		// copy.clear();
		//
		// ofxTuioObject obj = (ofxTuioObject ) getTuio();
		// if (obj != NULL) {
		// copy.setAddress(msg.getAddress()+ofToString(obj.getFiducialId())+"/add");
		// copy.addFloatArg(obj.getX());
		// copy.addFloatArg(obj.getY());
		// copy.addFloatArg(obj.getAngleDegrees()/360.0);
		// }
		//
		// _sender.sendMessage(copy);
		//
		// delete copy;
		//
		// updateLiveData();
		// }
		//
		// }
		// }
	}

	public void onUpdate(OscSender _sender) {
		// //setBeingUpdated(true);
		// std::map<SmurfEvt, vector<OscMessage>>::const_iterator
		// mit (oscMsgMap.begin()),
		// mend(oscMsgMap.end());
		// for(;mit!=mend;++mit) {
		// if (mit.first == EVT_UPDATE) {
		// vector<OscMessage> v = (vector<OscMessage>) mit.second;
		// for (int i=0; i<v.size(); i++ ) {
		// OscMessage msg = (OscMessage ) v.at(i);
		//
		// OscMessage copy = new OscMessage();
		// copy.copy(msg);
		// copy.clear();
		//
		// ofxTuioObject obj = (ofxTuioObject ) getTuio();
		// if (obj != NULL) {
		// copy.setAddress(msg.getAddress()+ofToString(obj.getFiducialId())+"/update");
		// copy.addFloatArg(obj.getX());
		// copy.addFloatArg(obj.getY());
		// copy.addFloatArg(obj.getAngleDegrees()/360.0);
		// }
		//
		// _sender.sendMessage(copy);
		//
		// delete copy;
		//
		// updateLiveData();
		// }
		// }
		// }
	}

	public void onRemove(OscSender _sender) {
		// std::map<SmurfEvt, vector<OscMessage>>::const_iterator
		// mit (oscMsgMap.begin()),
		// mend(oscMsgMap.end());
		// for(;mit!=mend;++mit) {
		// if (mit.first == EVT_REMOVE) {
		// vector<OscMessage> v = (vector<OscMessage>) mit.second;
		// for (int i=0; i<v.size(); i++ ) {
		// OscMessage msg = (OscMessage ) v.at(i);
		//
		// OscMessage copy = new OscMessage();
		// copy.copy(msg);
		// copy.clear();
		//
		// ofxTuioObject obj = (ofxTuioObject ) getTuio();
		// if (obj != NULL) {
		// copy.setAddress(msg.getAddress()+ofToString(obj.getFiducialId())+"/remove");
		// copy.addFloatArg(obj.getX());
		// copy.addFloatArg(obj.getY());
		// copy.addFloatArg(obj.getAngleDegrees()/360.0);
		// }
		//
		// _sender.sendMessage(copy);
		//
		// delete copy;
		//
		// updateLiveData();
		// }
		// }
		// }
	}

	public Map<SmurfEvt, Set<OSCMessage>> getOscMsgMap() {
		return oscMsgMap;
	}

	public void setSlot(SlotPosition position, SlotKind kind, SlotVisual visual, OSCMessage oscMsg) {
		Slot slot = new SlotImpl(position, kind, visual);
		slot.getOscMessages().add(oscMsg);
		slots.add(slot);
	}

	public void setSlot(SlotPosition position, SlotKind kind, SlotVisual visual, Set<OSCMessage> oscMsgVector) {
		Slot slot = new SlotImpl(position, kind, visual);
		slot.getOscMessages().addAll(oscMsgVector);
		slots.add(slot);
	}

	public void draw() {
		// ofSetCircleResolution(100);
		// ofxTuioObject blob = (ofxTuioObject) getTuio();
		// glColor3f(1.0,0.0,0.0);
		// glPushMatrix();
		// glTranslatef(blob.getX()ofGetWidth(), blob.getY()ofGetHeight(), 0.0);
		//
		// float angle = blob.getAngleDegrees();
		//
		// glRotatef(angle, 0.0, 0.0, 1.0);
		//
		// ofFill();
		// ofEnableAlphaBlending(); // turn on alpha blending
		// ofColor color = getFG();
		// ofSetColor(color.r, color.g, color.b, 255);
		//
		// if (aspect == SMURF_ASPECT_TRANSPARENT) {
		// // draw nothing
		// } else if (aspect == SMURF_ASPECT_DISC) {
		// ofCircle(0.0, 0.0, getRadius()-7);
		// } else if (aspect == SMURF_ASPECT_SQUARE) {
		// ofRect(-getRadius()/2-3, -getRadius()/2-3, getRadius()+6, getRadius()+6);
		// } else if (aspect == SMURF_ASPECT_STAR) {
		// ofCircle(0.0, 0.0, getRadius()-7);
		// } else if (aspect == SMURF_ASPECT_TRIANGLE) {
		//// ofRect(-getRadius()/2-3, -getRadius()/2-3, getRadius()+6, getRadius()+6);
		// ofCircle(0.0, 0.0, getRadius()-5);
		//// ofLine(cosf(120.0)20, sinf(120.0)20, 20, 0.0);
		//// ofLine(20, 0.0, cosf(240.0)20, sinf(240.0)20);
		//// ofLine(cosf(240.0)20, sinf(240.0)20, cosf(120.0)20, sinf(120.0)20);
		// } else {
		// ofCircle(0.0, 0.0, getRadius()-7);
		// }
		//
		// ofDisableAlphaBlending(); // turn off alpha blending
		//
		// glPopMatrix();
		//
		// glPushMatrix();
		// glTranslatef(blob.getX()ofGetWidth(), blob.getY()ofGetHeight(), 0.0);
		//
		//
		// ofEnableAlphaBlending(); // turn on alpha blending
		//
		// ofSetLineWidth(1.0);
		// ofSetColor(200, 200, 200, 60);
		//
		// ofFill();
		// ofSetColor(200, 200, 200, 125);
		//
		//
		// // FUNCTION
		// // --------------------------------
		// if (getFunction() == SMURF_FUNC_KNOB) {
		// float ratio = (angle/360.0);
		// float steps = ratio200.0;
		//
		// for (float cpt=0; cpt<steps;cpt++) {
		//
		// ofCircle(cosf(ofDegToRad(cpt1.8+90.0))getRadius(),
		// sinf(ofDegToRad(cpt1.8+90.0))getRadius(), 2);
		// }
		//
		// ofNoFill();
		//
		// glColor3f(0.9,0.9,0.9);
		//
		// ofCircle(cosf(ofDegToRad(steps1.8+90.0))getRadius(),
		// sinf(ofDegToRad(steps1.8+90.0))getRadius(), 4);
		// glColor3f(0.7,0.6,1.0);
		//
		// ofCircle(cosf(ofDegToRad(steps1.8+90.0))getRadius(),
		// sinf(ofDegToRad(steps1.8+90.0))getRadius(), 4);
		//
		// glColor3f(0.4,0.3,1.0);
		// ofCircle(cosf(ofDegToRad(steps1.8+90.0))getRadius(),
		// sinf(ofDegToRad(steps1.8+90.0))getRadius(), 5);
		// }
		//
		//// // On Smurf Selection
		//// if (isSelected()) {
		//// ofPushStyle();
		//// glColor3f(1.0,0.0,0.0);
		//// ofSetLineWidth(3.0);
		//// ofCircle(0, 0, getRadius()+5);
		//// ofPopStyle();
		//// }
		//
		// glPopMatrix();
		//
		// ofSetColor(200, 200, 200, 125);
		//
		// ofSetLineWidth(1.0);
		//
		// glColor3f(1.0,1.0,1.0);
		//
		//
		// ofNoFill();
		//
		// if (isLabelVisible()) {
		// string str = ofToString((int)(blob.getFiducialId()));
		// ofDrawBitmapString(str, blob.getX()ofGetWidth()-10.0,
		// blob.getY()ofGetHeight()+25.0);
		// }
		//
		// if (isProximaVisible() /&& isBeingUpdated()/) {
		// ofSetLineWidth(0.5);
		// ofSetColor(220, 220, 220, 65);
		//
		// int angle=0;
		// for (int i=0; i<36; i++ ) {
		// float newX = blob.getX()ofGetWidth() + cosf(ofDegToRad(angle))getProxima();
		// float newY = blob.getY()ofGetHeight() + sinf(ofDegToRad(angle))getProxima();
		// ofLine(newX, newY, newX-1, newY);
		// angle += 10;
		// }
		// glColor3f(1.0,1.0,1.0);
		// }
		//
		// if (dynamic_cast<SmurfAnchor>(this) == NULL) {
		//
		//
		// for (int i=0; i<slots.size(); i++ ) {
		// Slot slot = slots.at(i);
		//
		// float newX = blob.getX() +
		// cosf(ofDegToRad(slot.getPosition()))57.0/ofGetWidth();
		// float newY = blob.getY() +
		// sinf(ofDegToRad(slot.getPosition()))57.0/ofGetHeight();
		//
		// slot.getTuio().update(newX, newY, 0.0, 0.0, 0.0);
		//
		// slot.draw();
		// }
		// }
		//
		// //setBeingUpdated(false);

	}

	public boolean isBeingUpdated() {
		return beingUpdated;
	}

	public void setBeingUpdated(boolean _status) {
		beingUpdated = _status;
	}

	public void toggleBeingUpdated() {
		beingUpdated = beingUpdated ? false : true;
	}

	@Override
	public void setSlot(OscSender position, SlotKind kind, SlotVisual visual, OscSender oscSender) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSlot(OscSender position, SlotKind kind, SlotVisual visual, Set<OSCMessage> oscMessages) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pushLiveData(float _idx, float _data) {
		// TODO Auto-generated method stub
		
	}
}
