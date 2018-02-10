/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import org.jouvieje.fmodex.Geometry;

import ubiquisense.iorx.media.fmodex.FMGeometry;


public class FMGeometryImpl  implements FMGeometry {
	
	protected static final Geometry FMODEX_EDEFAULT = null;

	
	protected Geometry fmodex = FMODEX_EDEFAULT;

	

	public Geometry getFmodex() {
		return fmodex;
	}


	public void setFmodex(Geometry newFmodex) {
		fmodex = newFmodex;
	}


	

} //FMGeometryImpl
