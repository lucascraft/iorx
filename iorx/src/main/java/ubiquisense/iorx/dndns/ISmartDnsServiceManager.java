
package ubiquisense.iorx.dndns;

import javax.jmdns.ServiceInfo;

public interface ISmartDnsServiceManager {
	/**
	 * Getter for DN-DNS {@link ServiceInfo} service information
	 * 
	 * @return a DN-DNS {@link ServiceInfo} service information
	 */
	ServiceInfo getServiceInfo();
	
	void init();
	
	void connect();
	
	void disconnect();
	
	void close();
}
