package ubiquisense.iorx.ui.fmurf;

import java.util.ArrayList;
import java.util.List;

import com.illposed.osc.OSCMessage;

import ubiquisense.iorx.protocols.tuio.TuioContainer;
import ubiquisense.iorx.protocols.tuio.TuioCursor;
import ubiquisense.iorx.protocols.tuio.TuioPoint;
import ubiquisense.iorx.ui.fmurf.osc.OscSender;

public class SmurfFinger extends SmuonImpl {
	TuioContainer tuioObj;
	
	List<TuioPoint> points;
	
	public SmurfFinger(TuioContainer tuio) {
		super();
		points = new ArrayList<TuioPoint>();
		tuioObj = tuio;
	}
	

	public TuioContainer getTuio() {
		return tuioObj;
	}


	public void setTuio(TuioContainer tuioObj) {
		this.tuioObj = tuioObj;
	}


	public void setPoints(List<TuioPoint> points) {
		this.points = points;
	}


	// -----------------------------------------------
	//
	// Points accessor
	//
	// -----------------------------------------------
	List<TuioPoint> getPoints() {
		return points;
	}

	// -----------------------------------------------
	//
	// Method to collect all points related to finger 
	// moves between CURSOR_ADD and CURSOR_REMOVE
	// events
	//
	// -----------------------------------------------
	void addPoint(TuioPoint _pos) {
		points.add(_pos);
	}

	// -----------------------------------------------
	//
	// Removes points on CURSOR_REMOVE event
	//
	// -----------------------------------------------
	void clearPoints() {
		points.clear();
	}

	// -----------------------------------------------
	//
	// Add a new cursor instance and send 
	// a OSC message to host/port
	//
	// -----------------------------------------------
	void onAdd(OscSender _sender) {
		OSCMessage msg = new OSCMessage();
		
		TuioCursor obj = (TuioCursor ) getTuio(); 
		if (obj != null) {
			msg.setAddress("/smurf/cursor/" + obj.finger_id + "/add");
			msg.addArgument(obj.getX());
			msg.addArgument(obj.getY());
		}
		_sender.sendMessage(msg);
	}

	// -----------------------------------------------
	//
	// Update cursor instance and send 
	// an OSC message to host/port
	//
	// -----------------------------------------------
	void onUpdate(OscSender _sender) {	
		OSCMessage msg = new OSCMessage();
		
		TuioCursor obj = (TuioCursor ) getTuio(); 
		if (obj != null) {
			msg.setAddress("/smurf/cursor/" + obj.finger_id + "/update");
			msg.addArgument(obj.getX());
			msg.addArgument(obj.getY());
		}
		_sender.sendMessage(msg);
	}

	// -----------------------------------------------
	//
	// Remove cursor instance and send 
	// an OSC message to host/port
	//
	// -----------------------------------------------
	void onRemove(OscSender _sender) {
		OSCMessage msg = new OSCMessage();
		
		TuioCursor obj = (TuioCursor ) getTuio(); 
		if (obj != null) {
			msg.setAddress("/smurf/cursor/" + obj.finger_id + "/remove");
			msg.addArgument(obj.getX());
			msg.addArgument(obj.getY());
		}
		_sender.sendMessage(msg);
	}
}
