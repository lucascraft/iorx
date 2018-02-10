/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public enum CLIP_STATUS  {
	

	PLAY(0, "PLAY", "PLAY"),

	

	PAUSE(1, "PAUSE", "PAUSE"),

	

	STOP(2, "STOP", "STOP");

	

	public static final int PLAY_VALUE = 0;

	

	public static final int PAUSE_VALUE = 1;

	

	public static final int STOP_VALUE = 2;

	

	private static final CLIP_STATUS[] VALUES_ARRAY =
		new CLIP_STATUS[] {
			PLAY,
			PAUSE,
			STOP,
		};



	public static final List<CLIP_STATUS> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));


	public static CLIP_STATUS get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CLIP_STATUS result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}



	public static CLIP_STATUS getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CLIP_STATUS result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}



	public static CLIP_STATUS get(int value) {
		switch (value) {
			case PLAY_VALUE: return PLAY;
			case PAUSE_VALUE: return PAUSE;
			case STOP_VALUE: return STOP;
		}
		return null;
	}


	private final int value;


	private final String name;


	private final String literal;



	private CLIP_STATUS(int value, String name, String literal) {
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
	
} //CLIP_STATUS
