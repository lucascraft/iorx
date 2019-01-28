/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum MASTER_CTRL  {
	PLAY(0, "PLAY", "PLAY"),
	PAUSE(1, "PAUSE", "PAUSE"),
	STOP(2, "STOP", "STOP"),
	RECORD(3, "RECORD", "RECORD"),
	PREC(4, "PREC", "PREC"),
	NEXT(5, "NEXT", "NEXT"),
	CONTINUE(6, "CONTINUE", "CONTINUE"), 
	UNDO(7, "UNDO", "UNDO"), 
	REDO(8, "REDO", "REDO");

	public static final int PLAY_VALUE = 0;
	public static final int PAUSE_VALUE = 1;
	public static final int STOP_VALUE = 2;
	public static final int RECORD_VALUE = 3;
	public static final int PREC_VALUE = 4;
	public static final int NEXT_VALUE = 5;
	public static final int CONTINUE_VALUE = 6;
	public static final int UNDO_VALUE = 7;
	public static final int REDO_VALUE = 8;
	private static final MASTER_CTRL[] VALUES_ARRAY =
		new MASTER_CTRL[] {
			PLAY,
			PAUSE,
			STOP,
			RECORD,
			PREC,
			NEXT,
			CONTINUE,
			UNDO,
			REDO,
		};
	public static final List<MASTER_CTRL> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
	public static MASTER_CTRL get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MASTER_CTRL result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}
	public static MASTER_CTRL getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MASTER_CTRL result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}
	public static MASTER_CTRL get(int value) {
		switch (value) {
			case PLAY_VALUE: return PLAY;
			case PAUSE_VALUE: return PAUSE;
			case STOP_VALUE: return STOP;
			case RECORD_VALUE: return RECORD;
			case PREC_VALUE: return PREC;
			case NEXT_VALUE: return NEXT;
			case CONTINUE_VALUE: return CONTINUE;
			case UNDO_VALUE: return UNDO;
			case REDO_VALUE: return REDO;
		}
		return null;
	}
	private final int value;

	private final String name;
	private final String literal;
	private MASTER_CTRL(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}
	public int getValue() {
	  return value;
	}
	public String getName() {
	  return name;
	}
	public String getLiteral() {
	  return literal;
	}
	@Override
	public String toString() {
		return literal;
	}
	
} //MASTER_CTRL
