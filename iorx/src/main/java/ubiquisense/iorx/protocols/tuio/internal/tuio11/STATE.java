/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.tuio.internal.tuio11;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum STATE  {
	TUIO_ADDED(0, "TUIO_ADDED", "TUIO_ADDED"),
	TUIO_ACCELERATING(1, "TUIO_ACCELERATING", "TUIO_ACCELERATING"),

	/**
	 * The '<em><b>TUIO DECELERATING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TUIO_DECELERATING_VALUE
	 * @generated
	 * @ordered
	 */
	TUIO_DECELERATING(2, "TUIO_DECELERATING", "TUIO_DECELERATING"),

	/**
	 * The '<em><b>TUIO STOPPED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TUIO_STOPPED_VALUE
	 * @generated
	 * @ordered
	 */
	TUIO_STOPPED(3, "TUIO_STOPPED", "TUIO_STOPPED"),

	/**
	 * The '<em><b>TUIO REMOVED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TUIO_REMOVED_VALUE
	 * @generated
	 * @ordered
	 */
	TUIO_REMOVED(4, "TUIO_REMOVED", "TUIO_REMOVED");

	/**
	 * The '<em><b>TUIO ADDED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TUIO ADDED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TUIO_ADDED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TUIO_ADDED_VALUE = 0;

	/**
	 * The '<em><b>TUIO ACCELERATING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TUIO ACCELERATING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TUIO_ACCELERATING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TUIO_ACCELERATING_VALUE = 1;

	/**
	 * The '<em><b>TUIO DECELERATING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TUIO DECELERATING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TUIO_DECELERATING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TUIO_DECELERATING_VALUE = 2;

	/**
	 * The '<em><b>TUIO STOPPED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TUIO STOPPED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TUIO_STOPPED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TUIO_STOPPED_VALUE = 3;

	/**
	 * The '<em><b>TUIO REMOVED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TUIO REMOVED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TUIO_REMOVED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TUIO_REMOVED_VALUE = 4;

	/**
	 * An array of all the '<em><b>STATE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final STATE[] VALUES_ARRAY =
		new STATE[] {
			TUIO_ADDED,
			TUIO_ACCELERATING,
			TUIO_DECELERATING,
			TUIO_STOPPED,
			TUIO_REMOVED,
		};

	/**
	 * A public read-only list of all the '<em><b>STATE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<STATE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>STATE</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static STATE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			STATE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>STATE</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static STATE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			STATE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>STATE</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static STATE get(int value) {
		switch (value) {
			case TUIO_ADDED_VALUE: return TUIO_ADDED;
			case TUIO_ACCELERATING_VALUE: return TUIO_ACCELERATING;
			case TUIO_DECELERATING_VALUE: return TUIO_DECELERATING;
			case TUIO_STOPPED_VALUE: return TUIO_STOPPED;
			case TUIO_REMOVED_VALUE: return TUIO_REMOVED;
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
	private STATE(int value, String name, String literal) {
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
	
} //STATE
