/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ubiquino.dsl;

import ubiquisense.iorx.app.IConnectedUnit;
import ubiquisense.iorx.hardware.arduino.Arduino;
import ubiquisense.iorx.topology.ledger.XCPAddress;


public interface Ubiquino extends IConnectedUnit {

	Arduino getBoard();

	void setBoard(Arduino value);

	UbiquinoConfig getConfig();

	void setConfig(UbiquinoConfig value);
	XCPAddress getLastAddress();
	void setLastAddress(XCPAddress value);

} // Ubiquino
