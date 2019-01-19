/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

public interface DMXFx {
//	/**
//	 * Returns the value of the '<em><b>Manager</b></em>' container reference.
//	 * It is bidirectional and its opposite is '{@link net.sf.smbt.dmx.ezdmxctrl.DMXLibrary#getFx <em>Fx</em>}'.
//	 * <!-- begin-user-doc -->
//	 * <p>
//	 * If the meaning of the '<em>Manager</em>' container reference isn't clear,
//	 * there really should be more of a description here...
//	 * </p>
//	 * <!-- end-user-doc -->
//	 * @return the value of the '<em>Manager</em>' container reference.
//	 * @see #setManager(DMXLibrary)
//	 * @see net.sf.smbt.dmx.ezdmxctrl.EzdmxctrlPackage#getDMXFx_Manager()
//	 * @see net.sf.smbt.dmx.ezdmxctrl.DMXLibrary#getFx
//	 * @model opposite="fx" transient="false"
//	 * @generated
//	 */
//	DMXLibrary getManager();
//
//	/**
//	 * Sets the value of the '{@link net.sf.smbt.dmx.ezdmxctrl.DMXFx#getManager <em>Manager</em>}' container reference.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @param value the new value of the '<em>Manager</em>' container reference.
//	 * @see #getManager()
//	 * @generated
//	 */
//	void setManager(DMXLibrary value);
//
	DMXfixtureMotion getMotion();

	void setMotion(DMXfixtureMotion value);

	DMXFixtureBehavior getBehavior();

	void setBehavior(DMXFixtureBehavior value);

} // DMXFx
