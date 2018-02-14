package ubiquisense.iorx.ui.fx.fiducial;

public class MTConnection {
	MTFiducial f1;
	MTFiducial f2;
	public MTConnection(MTFiducial f1, MTFiducial f2) {
		this.f1 = f1;
		this.f2 = f2;
	}
	public MTFiducial getF1() {
		return f1;
	}
	public void setF1(MTFiducial f1) {
		this.f1 = f1;
	}
	public MTFiducial getF2() {
		return f2;
	}
	public void setF2(MTFiducial f2) {
		this.f2 = f2;
	}
	
}
