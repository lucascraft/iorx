/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

import java.util.List;

import ubiquisense.iorx.protocols.osc.internal.OscCmd;

public interface DMXFixture extends DMXFixtureValuations {
	List<OscCmd> getParams();

//	/**
//	 * Returns the value of the '<em><b>Definition</b></em>' reference.
//	 * <!-- begin-user-doc -->
//	 * <p>
//	 * If the meaning of the '<em>Definition</em>' reference isn't clear,
//	 * there really should be more of a description here...
//	 * </p>
//	 * <!-- end-user-doc -->
//	 * @return the value of the '<em>Definition</em>' reference.
//	 * @see #setDefinition(FixtureDefinition)
//	 * @see net.sf.smbt.dmx.ezdmxctrl.EzdmxctrlPackage#getDMXFixture_Definition()
//	 * @model
//	 * @generated
//	 */
//	FixtureDefinition getDefinition();

//	/**
//	 * Sets the value of the '{@link net.sf.smbt.dmx.ezdmxctrl.DMXFixture#getDefinition <em>Definition</em>}' reference.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @param value the new value of the '<em>Definition</em>' reference.
//	 * @see #getDefinition()
//	 * @generated
//	 */
//	void setDefinition(FixtureDefinition value);

	String getVendor();
	void setVendor(String value);
	List<ChannelValues> getValues();

} // DMXFixture
