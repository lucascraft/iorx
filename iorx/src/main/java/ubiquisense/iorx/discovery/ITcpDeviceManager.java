
package ubiquisense.iorx.discovery;

import java.util.List;

public interface ITcpDeviceManager extends IDeviceManager {
	List<NetBind> getTcpDevices();
	boolean connectTcpDevice(NetBind bind);
	boolean reconnectTcpDevice(NetBind bind);
	boolean disconnectTcpDevice(NetBind bind);
}
