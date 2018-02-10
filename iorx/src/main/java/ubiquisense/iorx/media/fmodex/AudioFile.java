/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex;

import java.io.File;


public interface AudioFile  {
	
	File getFile();


	void setFile(File value);


	String getExt();

	void setExt(String value);

} // AudioFile
