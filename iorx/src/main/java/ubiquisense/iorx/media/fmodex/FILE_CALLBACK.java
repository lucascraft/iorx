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


public enum FILE_CALLBACK {

	ASYNC_CANCEL(0, "ASYNC_CANCEL", "ASYNC_CANCEL"),


	ASYNC_READ(1, "ASYNC_READ", "ASYNC_READ"),


	CLOSE(2, "CLOSE", "CLOSE"),


	OPEN(3, "OPEN", "OPEN"),

	READ(4, "READ", "READ"),


	SEEK(5, "SEEK", "SEEK");

	public static final int ASYNC_CANCEL_VALUE = 0;

	
	public static final int ASYNC_READ_VALUE = 1;


	public static final int CLOSE_VALUE = 2;

	public static final int OPEN_VALUE = 3;


	public static final int READ_VALUE = 4;

	
	public static final int SEEK_VALUE = 5;

	
	private static final FILE_CALLBACK[] VALUES_ARRAY =
		new FILE_CALLBACK[] {
			ASYNC_CANCEL,
			ASYNC_READ,
			CLOSE,
			OPEN,
			READ,
			SEEK,
		};

	
	public static final List<FILE_CALLBACK> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	
	public static FILE_CALLBACK get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FILE_CALLBACK result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	
	public static FILE_CALLBACK getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FILE_CALLBACK result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	
	public static FILE_CALLBACK get(int value) {
		switch (value) {
			case ASYNC_CANCEL_VALUE: return ASYNC_CANCEL;
			case ASYNC_READ_VALUE: return ASYNC_READ;
			case CLOSE_VALUE: return CLOSE;
			case OPEN_VALUE: return OPEN;
			case READ_VALUE: return READ;
			case SEEK_VALUE: return SEEK;
		}
		return null;
	}

	
	private final int value;

	
	private final String name;

	private final String literal;

	
	private FILE_CALLBACK(int value, String name, String literal) {
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

} //FILE_CALLBACK
