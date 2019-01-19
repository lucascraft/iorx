 
package ubiquisense.iorx.comm.http.io;

import java.util.Map;

import javax.inject.Named;

import ubiquisense.iorx.io.impl.TransportChannelImpl;

@Named("http://")
public abstract class HttpCommunicator extends TransportChannelImpl {
	public HttpCommunicator() {
	}
    protected String portID;
    protected int[] acceptedPorts;
    protected String method;
    protected String pipeID;
	public abstract void init(String pipeID, String portID, int[] ports);
    protected Map<String, String> properties;
	public void setPortID(String portID) {
		this.portID = portID;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getMethod() {
		return method;
	}
	public String getPortID() {
		return portID;
	}
	public void setAcceptedPorts(int[] acceptedPorts) {
		this.acceptedPorts = acceptedPorts;
	}
	public int[] getAcceptedPorts() {
		return acceptedPorts;
	}
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
	public String getPipeID() {
		return pipeID;
	}
	public void setParameters(String pipeID, String portID, int[] acceptedPorts) {
		this.pipeID = pipeID;
		this.portID = portID;
		this.acceptedPorts = acceptedPorts;
	}
}
