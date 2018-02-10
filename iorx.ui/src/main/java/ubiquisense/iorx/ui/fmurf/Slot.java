package ubiquisense.iorx.ui.fmurf;

import java.util.Set;

import com.illposed.osc.OSCMessage;

enum SlotPosition {
	A(0), B(23), C(45), D(67), E(90), F(112),
			G(135), H(158), I(180), J(202), K(225), L(248),
			M(270), N(292), O(315), P(338);
			
	float angle;
	public float getAngle() {
		return angle;
	}
	private SlotPosition(float f) {
		angle = f;
	}
};


enum SlotKind {
	PUSH,
	TOGGLE
};

enum SlotVisual {
	BOX,
	ROUND,
	TRIANGLE
};

public interface Slot extends Smuon{
		
		SlotKind getKind();
		SlotVisual getVisual();
		SlotPosition getPosition();
		
		Set<OSCMessage> getOscMessages();
		String getLabelFromSlotPosition();
		int getOrderFromSlotPosition();
		
		void draw();

}
