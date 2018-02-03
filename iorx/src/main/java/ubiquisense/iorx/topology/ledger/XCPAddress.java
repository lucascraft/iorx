/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.ledger;

import java.util.List;


public interface XCPAddress  {
	String getType();
	void setType(String value);
	String getAddr();
	void setAddr(String value);
	List<Integer> getPorts();
	String getAlias();
	void setAlias(String value);
	String getTransportID();
	void setTransportID(String value);
	String getProtocolID();
	void setProtocolID(String value);
	int getSpeed();
	void setSpeed(int value);
	int getPort();
	void setPort(int value);
	String getName();
	void setName(String value);

} // XCPAddress
