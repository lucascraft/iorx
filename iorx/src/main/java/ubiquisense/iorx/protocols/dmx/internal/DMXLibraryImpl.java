/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

import java.util.List;

public class DMXLibraryImpl implements DMXLibrary {
//	/**
//	 * The cached value of the '{@link #getFixtures() <em>Fixtures</em>}' containment reference list.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see #getFixtures()
//	 * @generated
//	 * @ordered
//	 */
//	protected EList<FixtureDefinition> fixtures;
//
	protected List<DMXProject> projects;
	protected List<DMXFx> fx;
	protected DMXLibraryImpl() {
		super();
	}

//	
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public List<FixtureDefinition> getFixtures() {
//		return fixtures;
//	}

	public List<DMXProject> getProjects() {
		return projects;
	}

	public List<DMXFx> getFx() {
		return fx;
	}
} //DMXLibraryImpl
