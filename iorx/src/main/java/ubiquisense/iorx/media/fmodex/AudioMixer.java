/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex;

import java.util.List;

public interface AudioMixer {
	Speaker getOut();

	void setOut(Speaker value);

	List<IChannel> getChannel();

} // AudioMixer
