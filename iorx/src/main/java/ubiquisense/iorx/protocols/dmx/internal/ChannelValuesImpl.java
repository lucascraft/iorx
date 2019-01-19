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
 * An implementation of the model object '<em><b>Channel Values</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.smbt.dmx.ezdmxctrl.impl.ChannelValuesImpl#getChannel <em>Channel</em>}</li>
 *   <li>{@link net.sf.smbt.dmx.ezdmxctrl.impl.ChannelValuesImpl#getValue <em>Value</em>}</li>
 *   <li>{@link net.sf.smbt.dmx.ezdmxctrl.impl.ChannelValuesImpl#getFx <em>Fx</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChannelValuesImpl  implements ChannelValues {
//	protected Channel channel;

	protected static final int VALUE_EDEFAULT = 0;

	protected int value = VALUE_EDEFAULT;

	protected List<DMXFx> fx;
	protected ChannelValuesImpl() {
		super();
	}

	
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public Channel getChannel() {
//		return channel;
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public void setChannel(Channel newChannel) {
//		Channel oldChannel = channel;
//		channel = newChannel;
//	}

	public int getValue() {
		return value;
	}
	public void setValue(int newValue) {
		int oldValue = value;
		value = newValue;
	}
	public List<DMXFx> getFx() {
		
		return fx;
	}
	@Override
	public String toString() {

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //ChannelValuesImpl
