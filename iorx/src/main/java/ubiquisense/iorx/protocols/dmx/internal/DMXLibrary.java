/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

import java.util.List;

public interface DMXLibrary  {
//	/**
//	 * Returns the value of the '<em><b>Fixtures</b></em>' containment reference list.
//	 * The list contents are of type {@link net.sf.smbt.dmx.model.qxf.FixtureDefinition}.
//	 * <!-- begin-user-doc -->
//	 * <p>
//	 * If the meaning of the '<em>Fixtures</em>' containment reference list isn't clear,
//	 * there really should be more of a description here...
//	 * </p>
//	 * <!-- end-user-doc -->
//	 * @return the value of the '<em>Fixtures</em>' containment reference list.
//	 * @see net.sf.smbt.dmx.ezdmxctrl.EzdmxctrlPackage#getDMXLibrary_Fixtures()
//	 * @model containment="true"
//	 * @generated
//	 */
//	List<FixtureDefinition> getFixtures();

	List<DMXProject> getProjects();

	List<DMXFx> getFx();

} // DMXLibrary
