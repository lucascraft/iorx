

package ubiquisense.iorx.discovery;

import java.util.List;

public interface IUSbDeviceManager  extends IDeviceManager {
	List<NetBind> getUdpDevices();
	boolean connectUdpDevice(NetBind bind);
	boolean reconnectUdpDevice(NetBind bind);
	boolean disconnectUdpDevice(NetBind bind);
}
