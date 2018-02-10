package ubiquisense.iorx.ui.fmurf;

enum SmurfStyle {
	ORBIT,
	BLINK,
	PULSE,
	NONE
};

public interface Smurfer extends Smuon {

		public int getRange();
		public void setRange(int _range);
}
