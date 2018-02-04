/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ubiquino.dsl.impl;

import java.util.List;

import ubiquisense.iorx.protocols.ubiquino.dsl.PortConfig;
import ubiquisense.iorx.protocols.ubiquino.dsl.UbiquinoConfig;


public class UbiquinoConfigImpl implements UbiquinoConfig {
	/**
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
	protected List<PortConfig> ports;

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<PortConfig> getPorts() {
		return ports;
	}

} //UbiquinoConfigImpl
