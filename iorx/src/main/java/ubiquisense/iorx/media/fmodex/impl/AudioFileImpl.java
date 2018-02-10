/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import java.io.File;

import ubiquisense.iorx.media.fmodex.AudioFile;

public class AudioFileImpl  implements AudioFile {
	protected static final File FILE_EDEFAULT = null;

	protected File file = FILE_EDEFAULT;

	protected static final String EXT_EDEFAULT = null;

	protected String ext = EXT_EDEFAULT;

	
	public File getFile() {
		return file;
	}

	public void setFile(File newFile) {
		file = newFile;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String newExt) {
		ext = newExt;
	}

	

} //AudioFileImpl
