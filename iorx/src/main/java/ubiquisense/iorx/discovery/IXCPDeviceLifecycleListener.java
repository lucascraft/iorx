package ubiquisense.iorx.discovery;


public interface IXCPDeviceLifecycleListener {
	/**
	 * Defines the contact API abstraction for device addition in the OSC based XCP (Cross Communication Protocol) model
	 * 
	 * @param device a generic device possibly owning 1+ services as modeled in XCP  
	 * @param time the time of the addition
	 */
	void onDeviceAdd(XCPDevice device, long time);
	
	/**
	 * Defines the contact API abstraction for device update in the OSC based XCP (Cross Communication Protocol) model
	 * 
	 * @param device a generic device possibly owning 1+ services as modeled in XCP  
	 * @param time the time of the addition
	 */
	void onDeviceUpdate(XCPDevice device, long time);
	
	/**
	 * Defines the contact API abstraction for device removal in the OSC based XCP (Cross Communication Protocol) model
	 * 
	 * @param device a generic device possibly owning 1+ services as modeled in XCP  
	 * @param time the time of the addition
	 */
	void onDeviceRemove(XCPDevice device, long time);
}
