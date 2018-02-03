/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.tuio.internal.tuio11;

import ubiquisense.iorx.cmd.CompoundCmd;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuio Bundle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.osc.eztuio.TuioBundle#getTime <em>Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.osc.eztuio.EztuioPackage#getTuioBundle()
 * @model
 * @generated
 */
public interface TuioBundle extends CompoundCmd {
	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(long)
	 * @see net.sf.smbt.osc.eztuio.EztuioPackage#getTuioBundle_Time()
	 * @model
	 * @generated
	 */
	long getTime();

	/**
	 * Sets the value of the '{@link net.sf.smbt.osc.eztuio.TuioBundle#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(long value);

} // TuioBundle
