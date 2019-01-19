/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DMX Fixture Valuations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.smbt.dmx.ezdmxctrl.impl.DMXFixtureValuationsImpl#getUniverse <em>Universe</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DMXFixtureValuationsImpl  implements DMXFixtureValuations {
	protected DMXUniverseCtrl universe;

	protected DMXFixtureValuationsImpl() {
		super();
	}

	public DMXUniverseCtrl getUniverse() {
		return universe;
	}

	public DMXUniverseCtrl basicGetUniverse() {
		return universe;
	}

	public void setUniverse(DMXUniverseCtrl newUniverse) {
		DMXUniverseCtrl oldUniverse = universe;
		universe = newUniverse;
	}

} //DMXFixtureValuationsImpl
