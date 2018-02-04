/**
 */
package ubiquisense.iorx.hardware.arduino.impl;

import java.util.ArrayList;
import java.util.List;

import ubiquisense.iorx.hardware.arduino.Arduino;
import ubiquisense.iorx.hardware.arduino.Bench;

public class BenchImpl implements Bench {

	String name;
	List<Arduino> boards;

	public BenchImpl() {
		boards = new ArrayList<Arduino>();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<Arduino> getBoards() {
		return boards;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		name = newName;
	}

} // BenchImpl
