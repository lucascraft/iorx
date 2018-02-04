/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.hardware.arduino;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.mdl.arduino.Port#getMap <em>Map</em>}</li>
 *   <li>{@link net.sf.smbt.mdl.arduino.Port#getReport <em>Report</em>}</li>
 *   <li>{@link net.sf.smbt.mdl.arduino.Port#getChannel <em>Channel</em>}</li>
 *   <li>{@link net.sf.smbt.mdl.arduino.Port#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getPort()
 * @model
 * @generated
 */
public interface Port  {
	/**
	 * Returns the value of the '<em><b>Map</b></em>' attribute.
	 * The literals are from the enumeration {@link net.sf.smbt.mdl.arduino.PIN_MAPPING}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map</em>' attribute.
	 * @see net.sf.smbt.mdl.arduino.PIN_MAPPING
	 * @see #setMap(PIN_MAPPING)
	 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getPort_Map()
	 * @model
	 * @generated
	 */
	PIN_MAPPING getMap();

	/**
	 * Sets the value of the '{@link net.sf.smbt.mdl.arduino.Port#getMap <em>Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map</em>' attribute.
	 * @see net.sf.smbt.mdl.arduino.PIN_MAPPING
	 * @see #getMap()
	 * @generated
	 */
	void setMap(PIN_MAPPING value);

	/**
	 * Returns the value of the '<em><b>Report</b></em>' attribute.
	 * The literals are from the enumeration {@link net.sf.smbt.mdl.arduino.ARDUINO_REPORT_MODE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Report</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Report</em>' attribute.
	 * @see net.sf.smbt.mdl.arduino.ARDUINO_REPORT_MODE
	 * @see #setReport(ARDUINO_REPORT_MODE)
	 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getPort_Report()
	 * @model
	 * @generated
	 */
	ARDUINO_REPORT_MODE getReport();

	/**
	 * Sets the value of the '{@link net.sf.smbt.mdl.arduino.Port#getReport <em>Report</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Report</em>' attribute.
	 * @see net.sf.smbt.mdl.arduino.ARDUINO_REPORT_MODE
	 * @see #getReport()
	 * @generated
	 */
	void setReport(ARDUINO_REPORT_MODE value);

	/**
	 * Returns the value of the '<em><b>Channel</b></em>' attribute.
	 * The default value is <code>"-999"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel</em>' attribute.
	 * @see #setChannel(int)
	 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getPort_Channel()
	 * @model default="-999"
	 * @generated
	 */
	int getChannel();

	/**
	 * Sets the value of the '{@link net.sf.smbt.mdl.arduino.Port#getChannel <em>Channel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel</em>' attribute.
	 * @see #getChannel()
	 * @generated
	 */
	void setChannel(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getPort_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link net.sf.smbt.mdl.arduino.Port#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Port
