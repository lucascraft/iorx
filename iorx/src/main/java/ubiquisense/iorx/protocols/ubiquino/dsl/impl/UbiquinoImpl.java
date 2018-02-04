/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ubiquino.dsl.impl;

import java.util.List;

import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.hardware.arduino.Arduino;
import ubiquisense.iorx.protocols.ubiquino.dsl.Ubiquino;
import ubiquisense.iorx.protocols.ubiquino.dsl.UbiquinoConfig;
import ubiquisense.iorx.topology.ledger.XCPAddress;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Ubiquino</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link net.sf.smbt.firmata.ubiquino.impl.UbiquinoImpl#getEngines
 * <em>Engines</em>}</li>
 * <li>{@link net.sf.smbt.firmata.ubiquino.impl.UbiquinoImpl#getDefault
 * <em>Default</em>}</li>
 * <li>{@link net.sf.smbt.firmata.ubiquino.impl.UbiquinoImpl#getBoard
 * <em>Board</em>}</li>
 * <li>{@link net.sf.smbt.firmata.ubiquino.impl.UbiquinoImpl#getConfig
 * <em>Config</em>}</li>
 * <li>{@link net.sf.smbt.firmata.ubiquino.impl.UbiquinoImpl#getLastAddress
 * <em>Last Address</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UbiquinoImpl implements Ubiquino {
	/**
	 * The cached value of the '{@link #getEngines() <em>Engines</em>}' reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEngines()
	 * @generated
	 * @ordered
	 */
	protected List<CmdPipe> engines;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected CmdPipe default_;

	/**
	 * The cached value of the '{@link #getBoard() <em>Board</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBoard()
	 * @generated
	 * @ordered
	 */
	protected Arduino board;

	/**
	 * The cached value of the '{@link #getConfig() <em>Config</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConfig()
	 * @generated
	 * @ordered
	 */
	protected UbiquinoConfig config;

	/**
	 * The cached value of the '{@link #getLastAddress() <em>Last Address</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLastAddress()
	 * @generated
	 * @ordered
	 */
	protected XCPAddress lastAddress;

	

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List<CmdPipe> getEngines() {
		return engines;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CmdPipe getDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDefault(CmdPipe newDefault) {
		default_ = newDefault;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Arduino getBoard() {
		return board;
	}

	public void setBoard(Arduino newBoard) {
			board = newBoard;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UbiquinoConfig getConfig() {
		return config;
	}

	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConfig(UbiquinoConfig newConfig) {
		config = newConfig;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public XCPAddress getLastAddress() {
		return lastAddress;
	}

	public void setLastAddress(XCPAddress newLastAddress) {
		lastAddress = newLastAddress;
	}


} // UbiquinoImpl
