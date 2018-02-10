package ubiquisense.iorx.ui.fmurf;

public abstract class SmurferImpl extends SmuonImpl implements Smurfer {

	long speed;
	long delay;
	int range;
	boolean active;
	SmurfStyle animation;
	
	public SmurferImpl() {
		super();
	}
	
	@Override
	public int getRange() {
		// TODO Auto-generated method stub
		return range;
	}
	@Override
	public void setRange(int _range) {
		range = _range;
	}
	
}
