/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.impl;

import java.util.List;

import com.google.common.collect.Lists;

import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.AbstractMixerDevice;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveParam;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Mixer Device</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.smbt.ezabletonctrl.impl.AbstractMixerDeviceImpl#getVolume <em>Volume</em>}</li>
 *   <li>{@link net.sf.smbt.ezabletonctrl.impl.AbstractMixerDeviceImpl#getPanning <em>Panning</em>}</li>
 *   <li>{@link net.sf.smbt.ezabletonctrl.impl.AbstractMixerDeviceImpl#getSends <em>Sends</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractMixerDeviceImpl implements AbstractMixerDevice {
	LiveParam volumeParam;
	LiveParam panParam;
	List<LiveParam> sends;
	
	
	public AbstractMixerDeviceImpl() {
		super();
		sends = Lists.newArrayList();
	}

	public LiveParam getVolume() {
		return volumeParam;
	}

	public void setVolume(LiveParam newVolume) {
		volumeParam = newVolume;
	}

	public LiveParam getPanning() {
		return panParam;
	}

	public void setPanning(LiveParam newPanning) {
		panParam = newPanning;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<LiveParam> getSends() {
		return sends;
	}

} //AbstractMixerDeviceImpl
