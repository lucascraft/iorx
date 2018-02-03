/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Mime</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getMime()
 * @model
 * @generated
 */
public enum Mime  {
	/**
	 * The '<em><b>BLUETOOTH MIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLUETOOTH_MIME_VALUE
	 * @generated
	 * @ordered
	 */
	BLUETOOTH_MIME(0, "BLUETOOTH_MIME", "btserial://"),

	/**
	 * The '<em><b>UDP MIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UDP_MIME_VALUE
	 * @generated
	 * @ordered
	 */
	UDP_MIME(1, "UDP_MIME", "udpsocket://"),

	/**
	 * The '<em><b>TCP MIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TCP_MIME_VALUE
	 * @generated
	 * @ordered
	 */
	TCP_MIME(2, "TCP_MIME", "tcpsocket://"),

	/**
	 * The '<em><b>USB MIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USB_MIME_VALUE
	 * @generated
	 * @ordered
	 */
	USB_MIME(3, "USB_MIME", "usbsp://"), /**
	 * The '<em><b>XBEE MIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XBEE_MIME_VALUE
	 * @generated
	 * @ordered
	 */
	XBEE_MIME(4, "XBEE_MIME", "xbsp://");

	/**
	 * The '<em><b>BLUETOOTH MIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BLUETOOTH MIME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BLUETOOTH_MIME
	 * @model literal="btserial://"
	 * @generated
	 * @ordered
	 */
	public static final int BLUETOOTH_MIME_VALUE = 0;

	/**
	 * The '<em><b>UDP MIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UDP MIME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UDP_MIME
	 * @model literal="udpsocket://"
	 * @generated
	 * @ordered
	 */
	public static final int UDP_MIME_VALUE = 1;

	/**
	 * The '<em><b>TCP MIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TCP MIME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TCP_MIME
	 * @model literal="tcpsocket://"
	 * @generated
	 * @ordered
	 */
	public static final int TCP_MIME_VALUE = 2;

	/**
	 * The '<em><b>USB MIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USB MIME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USB_MIME
	 * @model literal="usbsp://"
	 * @generated
	 * @ordered
	 */
	public static final int USB_MIME_VALUE = 3;

	/**
	 * The '<em><b>XBEE MIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>XBEE MIME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XBEE_MIME
	 * @model literal="xbsp://"
	 * @generated
	 * @ordered
	 */
	public static final int XBEE_MIME_VALUE = 4;

	/**
	 * An array of all the '<em><b>Mime</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Mime[] VALUES_ARRAY =
		new Mime[] {
			BLUETOOTH_MIME,
			UDP_MIME,
			TCP_MIME,
			USB_MIME,
			XBEE_MIME,
		};

	/**
	 * A public read-only list of all the '<em><b>Mime</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Mime> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Mime</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Mime get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Mime result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Mime</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Mime getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Mime result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Mime</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Mime get(int value) {
		switch (value) {
			case BLUETOOTH_MIME_VALUE: return BLUETOOTH_MIME;
			case UDP_MIME_VALUE: return UDP_MIME;
			case TCP_MIME_VALUE: return TCP_MIME;
			case USB_MIME_VALUE: return USB_MIME;
			case XBEE_MIME_VALUE: return XBEE_MIME;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Mime(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Mime
