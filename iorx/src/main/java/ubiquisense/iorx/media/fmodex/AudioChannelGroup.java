/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex;

import java.util.List;

import org.jouvieje.fmodex.ChannelGroup;


public interface AudioChannelGroup extends IChannel {

	List<IChannel> getChildren();


	ChannelGroup getFmodex();

	
	void setFmodex(ChannelGroup value);

} // AudioChannelGroup
