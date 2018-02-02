/**
 */
package ubiquisense.iorx.comm.http.io;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Http Method</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.sf.smbt.comm.httpcmd.HttpcmdPackage#getHttpMethod()
 * @model
 * @generated
 */
public enum HttpMethod 
{
	POST(0, "POST", "POST"),
	PUT(1, "PUT", "PUT"),
	GET(2, "GET", "GET"),
	DELETE(3, "DELETE", "DELETE");

	public static final int POST_VALUE = 0;

	public static final int PUT_VALUE = 1;

	public static final int GET_VALUE = 2;

	public static final int DELETE_VALUE = 3;

	private static final HttpMethod[] VALUES_ARRAY =
		new HttpMethod[] {
			POST,
			PUT,
			GET,
			DELETE,
		};

	public static final List<HttpMethod> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static HttpMethod get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HttpMethod result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static HttpMethod getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HttpMethod result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static HttpMethod get(int value) {
		switch (value) {
			case POST_VALUE: return POST;
			case PUT_VALUE: return PUT;
			case GET_VALUE: return GET;
			case DELETE_VALUE: return DELETE;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	private HttpMethod(int value, String name, String literal) {
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
	
} //HttpMethod
