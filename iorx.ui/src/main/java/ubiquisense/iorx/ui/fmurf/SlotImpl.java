package ubiquisense.iorx.ui.fmurf;

import java.util.Set;

import com.illposed.osc.OSCMessage;

import ubiquisense.iorx.protocols.tuio.TuioContainer;

public class SlotImpl extends SmuonImpl implements Slot {
	Set<OSCMessage> oscMsg;
	SlotPosition position;
	SlotKind kind;
	SlotVisual visual;

	public SlotImpl(SlotPosition _position) {
		position = _position;
	}

	public SlotImpl(SlotPosition _position, SlotKind _kind) {
		this(_position);
		this.kind = _kind;
	}

	public SlotImpl(SlotPosition _position, SlotKind _kind, SlotVisual _visual) {
		this(_position, _kind);
		this.visual = _visual;
	}

	@Override
	public SlotKind getKind() {
		return kind;
	}

	@Override
	public SlotVisual getVisual() {
		return visual;
	}

	@Override
	public SlotPosition getPosition() {
		return position;
	}


	@Override
	public void draw() {

	}

	@Override
	public Set<OSCMessage> getOscMessages() {
		return oscMsg;
	}

	public String getLabelFromSlotPosition() {
		String ret = "";
		switch (getPosition()) {
		case A:
			ret = "A";
			break;
		case B:
			ret = "B";
			break;
		case C:
			ret = "C";
			break;
		case D:
			ret = "D";
			break;
		case E:
			ret = "E";
			break;
		case F:
			ret = "F";
			break;
		case G:
			ret = "G";
			break;
		case H:
			ret = "H";
			break;
		case I:
			ret = "I";
			break;
		case J:
			ret = "J";
			break;
		case K:
			ret = "K";
			break;
		case L:
			ret = "L";
			break;
		case M:
			ret = "M";
			break;
		case N:
			ret = "N";
			break;
		case O:
			ret = "O";
			break;
		case P:
			ret = "P";
			break;
		default:
			break;
		}
		;
		return ret;

	}

	public int getOrderFromSlotPosition() {
		int ret = -1;
		switch (getPosition()) {
		case A:
			ret = 0;
			break;
		case B:
			ret = 1;
			break;
		case C:
			ret = 2;
			break;
		case D:
			ret = 3;
			break;
		case E:
			ret = 4;
			break;
		case F:
			ret = 5;
			break;
		case G:
			ret = 6;
			break;
		case H:
			ret = 7;
			break;
		case I:
			ret = 8;
			break;
		case J:
			ret = 9;
			break;
		case K:
			ret = 10;
			break;
		case L:
			ret = 11;
			break;
		case M:
			ret = 12;
			break;
		case N:
			ret = 13;
			break;
		case O:
			ret = 14;
			break;
		case P:
			ret = 15;
			break;
		default:
			break;
		}
		;
		return ret;

	}
	 @Override
	public void setTuio(TuioContainer _tuio) {
		// TODO Auto-generated method stub
		super.setTuio(_tuio);
	}
	 @Override
	 public boolean isSelected() {
		// TODO Auto-generated method stub
		return super.isSelected();
	}
}
