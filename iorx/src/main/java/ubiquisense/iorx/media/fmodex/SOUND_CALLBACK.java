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


public enum SOUND_CALLBACK {
	
	NON_BLOCK(0, "NON_BLOCK", "NON_BLOCK"),

	
	PCM_READ(1, "PCM_READ", "PCM_READ"),

	PCM_SET_POS(2, "PCM_SET_POS", "PCM_SET_POS");

	
	public static final int NON_BLOCK_VALUE = 0;

	
	public static final int PCM_READ_VALUE = 1;

	public static final int PCM_SET_POS_VALUE = 2;

	private static final SOUND_CALLBACK[] VALUES_ARRAY =
		new SOUND_CALLBACK[] {
			NON_BLOCK,
			PCM_READ,
			PCM_SET_POS,
		};


	public static final List<SOUND_CALLBACK> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static SOUND_CALLBACK get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SOUND_CALLBACK result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static SOUND_CALLBACK getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SOUND_CALLBACK result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static SOUND_CALLBACK get(int value) {
		switch (value) {
			case NON_BLOCK_VALUE: return NON_BLOCK;
			case PCM_READ_VALUE: return PCM_READ;
			case PCM_SET_POS_VALUE: return PCM_SET_POS;
		}
		return null;
	}

	
	private final int value;

	
	private final String name;

	
	private final String literal;

	private SOUND_CALLBACK(int value, String name, String literal) {
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
	
} //SOUND_CALLBACK
