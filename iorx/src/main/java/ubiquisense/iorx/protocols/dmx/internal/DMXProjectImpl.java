/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

import java.util.List;

import ubiquisense.iorx.topology.ledger.XCPAddress;

public class DMXProjectImpl  implements DMXProject {

	protected List<DMXUniverseCtrl> universes;
	protected List<DMXScene> scenes;
	protected static final String ID_EDEFAULT = null;
	protected String id = ID_EDEFAULT;
	protected static final String NAME_EDEFAULT = null;
	protected String name = NAME_EDEFAULT;
	protected DMXLibrary library;

//	/**
//	 * The cached value of the '{@link #getFixtureDefinitions() <em>Fixture Definitions</em>}' reference list.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see #getFixtureDefinitions()
//	 * @generated
//	 * @ordered
//	 */
//	protected List<FixtureDefinition> fixtureDefinitions;

	protected XCPAddress lastAddress;

	protected Object selection;

	protected DMXProjectImpl() {
		super();
	}

	public List<DMXUniverseCtrl> getUniverses() {
		return universes;
	}

	public List<DMXScene> getScenes() {
		return scenes;
	}

	public String getId() {
		return id;
	}

	public void setId(String newId) {
		String oldId = id;
		id = newId;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		String oldName = name;
		name = newName;
	}

	public DMXLibrary getLibrary() {
		return library;
	}
	

//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public List<FixtureDefinition> getFixtureDefinitions() {
//		return fixtureDefinitions;
//	}

	public XCPAddress getLastAddress() {
		return lastAddress;
	}

	public void setLastAddress(XCPAddress newLastAddress) {
	}

	public Object getSelection() {
		
		return selection;
	}

	public Object basicGetSelection() {
		return selection;
	}

	public void setSelection(Object newSelection) {
		Object oldSelection = selection;
	}

	@Override
	public String toString() {

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	@Override
	public void setLibrary(DMXLibrary value) {
		library = value;
	}


} //DMXProjectImpl
