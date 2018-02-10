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


public enum MEMORY_CALLBACK  {
	
	ALLOC(0, "ALLOC", "ALLOC"),

	
	FREE(1, "FREE", "FREE"),

	
	REALLOC(2, "REALLOC", "REALLOC");

	
	public static final int ALLOC_VALUE = 0;

	public static final int FREE_VALUE = 1;

	public static final int REALLOC_VALUE = 2;

	private static final MEMORY_CALLBACK[] VALUES_ARRAY =
		new MEMORY_CALLBACK[] {
			ALLOC,
			FREE,
			REALLOC,
		};

	public static final List<MEMORY_CALLBACK> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static MEMORY_CALLBACK get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MEMORY_CALLBACK result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static MEMORY_CALLBACK getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MEMORY_CALLBACK result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}


	public static MEMORY_CALLBACK get(int value) {
		switch (value) {
			case ALLOC_VALUE: return ALLOC;
			case FREE_VALUE: return FREE;
			case REALLOC_VALUE: return REALLOC;
		}
		return null;
	}

	private final int value;

	
	private final String name;

	
	private final String literal;

	private MEMORY_CALLBACK(int value, String name, String literal) {
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
	
} //MEMORY_CALLBACK
