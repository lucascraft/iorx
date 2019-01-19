/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

import java.util.List;

public interface DMXManager  {
//	/**
//	 * Returns the value of the '<em><b>Fixture Definitions</b></em>' containment reference list.
//	 * The list contents are of type {@link net.sf.smbt.dmx.model.qxf.FixtureDefinition}.
//	 * <!-- begin-user-doc -->
//	 * <p>
//	 * If the meaning of the '<em>Fixture Definitions</em>' containment reference list isn't clear,
//	 * there really should be more of a description here...
//	 * </p>
//	 * <!-- end-user-doc -->
//	 * @return the value of the '<em>Fixture Definitions</em>' containment reference list.
//	 * @see net.sf.smbt.dmx.ezdmxctrl.EzdmxctrlPackage#getDMXManager_FixtureDefinitions()
//	 * @model containment="true"
//	 * @generated
//	 */
//	List<FixtureDefinition> getFixtureDefinitions();

	DMXUniverseCtrl getUniverses();
	void setUniverses(DMXUniverseCtrl value);
	List<DMXScene> getScenes();
	List<DMXFx> getFx();

} // DMXManager
