package ubiquisense.iorx.ui.fmurf;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.illposed.osc.OSCMessage;

import ubiquisense.iorx.ui.fmurf.enums.SmurfAspect;
import ubiquisense.iorx.ui.fmurf.enums.SmurfEvt;
import ubiquisense.iorx.ui.fmurf.enums.SmurfFunction;
import ubiquisense.iorx.ui.fmurf.enums.SmurfKind;
import ubiquisense.iorx.ui.fmurf.osc.OscSender;

public interface Smurf extends Smurfer {
	
	public void addOscMsgOnEvent(SmurfEvt evt, OSCMessage msg);
	public void removeOscMsgOnEvent(SmurfEvt evt, OSCMessage msg);
		
	public void setLastWaveUid(int _uid);
	public int getLastWaveUid();
		
	public Set<Slot> getSlots();
		
	public Map<SmurfEvt, Set<OSCMessage>> getOscMsgMap();	
		
	public void onBeat(OscSender _sender, SWave wave);
	public void onAdd(OscSender _sender);
	public void onUpdate(OscSender _sender);
	public void onRemove(OscSender _sender);
			
	public void setSlot(OscSender position, SlotKind kind, SlotVisual visual, OscSender oscSender);
	public void setSlot(OscSender position, SlotKind kind, SlotVisual visual, Set<OSCMessage> oscMessages);
		
	public SmurfKind getKind();
	public void setKind(SmurfKind _kind);
		
	public SmurfFunction getFunction();
	public void setFunction(SmurfFunction _function);
		
	public List<Float> getLiveData();
	public void setLiveData(List<Float> _livedata);
	public void pushLiveData(float _idx, float _data);
	public void updateLiveData();
		
	public  void draw();
		
	public void setAspect(SmurfAspect _aspect);
	public SmurfAspect getAspect();
		
	public boolean isBeingUpdated();
	public 	void setBeingUpdated(boolean _status);
	public void toggleBeingUpdated();	

};

