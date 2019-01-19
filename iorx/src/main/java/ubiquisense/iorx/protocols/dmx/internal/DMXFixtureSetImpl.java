/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DMX Fixture Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.smbt.dmx.ezdmxctrl.impl.DMXFixtureSetImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link net.sf.smbt.dmx.ezdmxctrl.impl.DMXFixtureSetImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DMXFixtureSetImpl extends DMXFixtureValuationsImpl implements DMXFixtureSet {

	protected List<DMXFixtureValuations> children;

	protected static final String LABEL_EDEFAULT = null;

	protected String label = LABEL_EDEFAULT;

	protected DMXFixtureSetImpl() {
		super();
	}

	public List<DMXFixtureValuations> getChildren() {
		
		return children;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
	}

	@Override
	public String toString() {

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

} //DMXFixtureSetImpl
