package ubiquisense.iorx.ui.config;

import java.util.ArrayList;
import java.util.List;

public class MTConfig {
	int outOscPort;
	String outAddr;
	int inOscPort;
	List<MTFiducialConfig> fiducials;;
	public MTConfig(String outOscAddr, int outOscPort, int inOscPort) {
		this.outAddr = outOscAddr;
		this.outOscPort = outOscPort;
		this.inOscPort = inOscPort;
		fiducials = new ArrayList<>();
	}
	public int getOutOscPort() {
		return outOscPort;
	}
	public String getOutAddr() {
		return outAddr;
	}
	public int getOscInPort() {
		return inOscPort;
	}
	
	public List<MTFiducialConfig> getFiducials() {
		return fiducials;
	}
	
}
