/**
 */
package ubiquisense.iorx.comm.http.io.impl;

import ubiquisense.iorx.comm.http.io.Property;

public class PropertyImpl implements Property {
	String key;
	String value;
	
	protected PropertyImpl() {
		super();
	}


	public String getKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(String newKey) {
		key = newKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		value = newValue;
	}

} //PropertyImpl
