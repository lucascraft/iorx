/**
 */
package ubiquisense.iorx.comm.http.io.impl;

import java.util.ArrayList;
import java.util.List;

import ubiquisense.iorx.comm.http.io.HttpCommCmd;
import ubiquisense.iorx.comm.http.io.HttpMethod;
import ubiquisense.iorx.comm.http.io.Property;
import ubiquisense.iorx.qx.impl.CmdImpl;


public class HttpCommCmdImpl extends CmdImpl implements HttpCommCmd {
	protected HttpCommCmdImpl() {
		props = new ArrayList<>();
	}
	HttpMethod method;
	String cmd;
	List<Property> props;

	public List<Property> getProperties() {
		return props;
	}

	public HttpMethod getMethod() {
		return method;
	}

	public void setMethod(HttpMethod newMethod) {
		method = newMethod;
	}
	
	public String getCommand() {
		return cmd;
	}

	public void setCommand(String newCommand) {
		cmd = newCommand;
	}

} //HttpCommCmdImpl
