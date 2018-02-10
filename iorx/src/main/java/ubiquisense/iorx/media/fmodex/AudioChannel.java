/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex;

import org.jouvieje.fmodex.Channel;



public interface AudioChannel extends IChannel {


	Channel getFmodex();

	void setFmodex(Channel value);
} // AudioChannel
