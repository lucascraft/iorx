
package ubiquisense.iorx.hardware.arduino.utils;

public class ArduinoPinEventAdapter {/*implements Adapter {
	
	@Override
	public void notifyChanged(Notification notification) {
		if (notification.getEventType() == Notification.SET ||
				notification.getEventType() == Notification.UNSET) {
			if (notification.getFeature().equals(ArduinoPackage.Literals.ANALOG_PORT__VALUE) ||
					notification.getFeature().equals(ArduinoPackage.Literals.DIGITAL_PORT__VALUE)) {
				Arduino arduinoBoard = (Arduino) ((Port)notification.getNotifier()).eContainer();
				synchronized (arduinoBoard) {
					if (arduinoBoard != null) {
						if (notification.getNotifier() instanceof DigitalPort) {
							for (IPortListener listener : arduinoBoard.getPortsToListen()) {
								if (listener.getMonitoredPort().equals(((DigitalPort)notification.getNotifier()).getMap())) {
									Object oldObjVal = notification.getOldValue();
									Object newObjVal = notification.getNewValue();
									if (oldObjVal instanceof Integer && newObjVal instanceof Integer) {
										listener.handleDigitalOutputMessage(
											(DigitalPort)notification.getNotifier(), 
											(Integer)oldObjVal, 
											(Integer)newObjVal
										);
									}
								}
							}
						} else if (notification.getNotifier() instanceof AnalogPort) {
							for (IPortListener listner : arduinoBoard.getPortsToListen()) {
								if (listner.getMonitoredPort().equals(((AnalogPort)notification.getNotifier()).getMap())) {
									Object oldObjVal = notification.getOldValue();
									Object newObjVal = notification.getNewValue();
									if (oldObjVal instanceof Float && newObjVal instanceof Float) {
										listner.handleAnalogicOutputMessage(
											(AnalogPort)notification.getNotifier(), 
											(Float)oldObjVal, 
											(Float)newObjVal
										);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public Notifier getTarget() {
		return null;
	}

	@Override
	public void setTarget(Notifier newTarget) {

	}

	@Override
	public boolean isAdapterForType(Object type) {
		return false;
	}
	*/
}
