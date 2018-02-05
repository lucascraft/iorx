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

	@SuppressWarnings("unchecked")
	public List<Arduino> getBoards() {
		return boards;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

} // BenchImpl
