/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.hardware.arduino;



public interface Processor {

	int getFreq();

	void setFreq(int value);

	BOARD_KIND getProc();

	void setProc(BOARD_KIND value);

} // Processor
