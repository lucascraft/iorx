/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

import java.util.List;

public class DMXChannelImpl  implements DMXChannel {
	protected List<Integer> values;
	protected DMXChannelImpl() {
		super();
	}
	public List<Integer> getValues() {
		
		return values;
	}
	@Override
	public String toString() {

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (values: ");
		result.append(values);
		result.append(')');
		return result.toString();
	}

} //DMXChannelImpl
