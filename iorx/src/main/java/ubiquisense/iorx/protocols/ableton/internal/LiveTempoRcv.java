/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Tempo Rcv</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.ezableton.LiveTempoRcv#getTempo <em>Tempo</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveTempoRcv()
 * @model
 * @generated
 */
public interface LiveTempoRcv extends AbletonLiveSndCmd {
	/**
	 * Returns the value of the '<em><b>Tempo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tempo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tempo</em>' attribute.
	 * @see #setTempo(float)
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveTempoRcv_Tempo()
	 * @model
	 * @generated
	 */
	float getTempo();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveTempoRcv#getTempo <em>Tempo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tempo</em>' attribute.
	 * @see #getTempo()
	 * @generated
	 */
	void setTempo(float value);

} // LiveTempoRcv
