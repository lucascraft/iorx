/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import java.util.List;

import ubiquisense.iorx.media.fmodex.FMDSP;
import ubiquisense.iorx.media.fmodex.IChannel;


public class IChannelImpl  implements IChannel {

	protected List<FMDSP> dspList;

	
	protected IChannelImpl() {
		super();
	}

	public List<FMDSP> getDspList() {
		
		return dspList;
	}


} //IChannelImpl
