/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex;


public interface TimeTag {
	
	long getTime();

	
	void setTime(long value);

	
	long getDuration();

	
	void setDuration(long value);

	
	CLIP_STATUS getStatus();

	
	void setStatus(CLIP_STATUS value);

} // TimeTag
