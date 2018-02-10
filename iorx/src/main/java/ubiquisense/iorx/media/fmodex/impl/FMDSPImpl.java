/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import org.jouvieje.fmodex.DSP;

import ubiquisense.iorx.media.fmodex.DSP_KIND;
import ubiquisense.iorx.media.fmodex.FMDSP;

public class FMDSPImpl implements FMDSP {
	protected static final DSP FMODEX_EDEFAULT = null;

	protected DSP fmodex = FMODEX_EDEFAULT;

	protected static final DSP_KIND KIND_EDEFAULT = DSP_KIND.CHORUS;

	protected DSP_KIND kind = KIND_EDEFAULT;

	
	public DSP getFmodex() {
		return fmodex;
	}

	public void setFmodex(DSP newFmodex) {
		fmodex = newFmodex;
	}

	public DSP_KIND getKind() {
		return kind;
	}

	public void setKind(DSP_KIND newKind) {
		kind = newKind == null ? KIND_EDEFAULT : newKind;
	}


} //FMDSPImpl
