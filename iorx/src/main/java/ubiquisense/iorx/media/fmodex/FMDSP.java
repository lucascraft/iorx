/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex;

import org.jouvieje.fmodex.DSP;


public interface FMDSP {
	
	DSP getFmodex();

	void setFmodex(DSP value);

	
	DSP_KIND getKind();

	
	void setKind(DSP_KIND value);

} // FMDSP
