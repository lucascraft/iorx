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
 * A representation of the model object '<em><b>Channel Values</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.dmx.ezdmxctrl.ChannelValues#getChannel <em>Channel</em>}</li>
 *   <li>{@link net.sf.smbt.dmx.ezdmxctrl.ChannelValues#getValue <em>Value</em>}</li>
 *   <li>{@link net.sf.smbt.dmx.ezdmxctrl.ChannelValues#getFx <em>Fx</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.dmx.ezdmxctrl.EzdmxctrlPackage#getChannelValues()
 * @model
 * @generated
 */
public interface ChannelValues  {
//	/**
//	 * Returns the value of the '<em><b>Channel</b></em>' reference.
//	 * <!-- begin-user-doc -->
//	 * <p>
//	 * If the meaning of the '<em>Channel</em>' reference isn't clear,
//	 * there really should be more of a description here...
//	 * </p>
//	 * <!-- end-user-doc -->
//	 * @return the value of the '<em>Channel</em>' reference.
//	 * @see #setChannel(Channel)
//	 * @see net.sf.smbt.dmx.ezdmxctrl.EzdmxctrlPackage#getChannelValues_Channel()
//	 * @model
//	 * @generated
//	 */
//	Channel getChannel();
//
//	/**
//	 * Sets the value of the '{@link net.sf.smbt.dmx.ezdmxctrl.ChannelValues#getChannel <em>Channel</em>}' reference.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @param value the new value of the '<em>Channel</em>' reference.
//	 * @see #getChannel()
//	 * @generated
//	 */
//	void setChannel(Channel value);
//
	int getValue();
	void setValue(int value);
	List<DMXFx> getFx();

} // ChannelValues
