/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.hardware.arduino;


public interface Port  {

	PIN_MAPPING getMap();


	void setMap(PIN_MAPPING value);


	ARDUINO_REPORT_MODE getReport();


	void setReport(ARDUINO_REPORT_MODE value);


	int getChannel();

	void setChannel(int value);

	String getName();


	void setName(String value);

} // Port
