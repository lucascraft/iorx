/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

import java.util.List;

import ubiquisense.iorx.protocols.osc.internal.OscCmd;

public class DMXFixtureImpl extends DMXFixtureValuationsImpl implements DMXFixture {

	protected List<OscCmd> params;

//	/**
//	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see #getDefinition()
//	 * @generated
//	 * @ordered
//	 */
//	protected FixtureDefinition definition;

	protected static final String VENDOR_EDEFAULT = null;
	protected String vendor = VENDOR_EDEFAULT;
	protected List<ChannelValues> values;
	protected DMXFixtureImpl() {
		super();
	}
	public List<OscCmd> getParams() {
		return params;
	}

//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public FixtureDefinition getDefinition() {
//		
//		return definition;
//	}


//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public void setDefinition(FixtureDefinition newDefinition) {
//		FixtureDefinition oldDefinition = definition;
//		definition = newDefinition;
//	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String newVendor) {
		String oldVendor = vendor;
		vendor = newVendor;
	}

	public List<ChannelValues> getValues() {
		return values;
	}

	@Override
	public String toString() {

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (vendor: ");
		result.append(vendor);
		result.append(')');
		return result.toString();
	}

} //DMXFixtureImpl
