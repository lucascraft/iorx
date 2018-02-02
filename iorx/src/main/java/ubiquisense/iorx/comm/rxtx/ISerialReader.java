/***********************************************************************************
 * Ubiquisense - A smart ambient utilities framework 
 * 
 * Copyright (c) 2008 - 2010, Lucas Bigeardel
 * 
 * The library is released under:
 * 
 * A) LGPL
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA 02110-1301 USA
 * 
 * B) EPL
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Lucas Bigeardel <lucas.bigeardel@gmail.com> - Initial API and implementation
 ***********************************************************************************/

package ubiquisense.iorx.comm.rxtx;

import java.io.InputStream;

/**
 * 
 * API contract for Serial reader
 * 
 */
public interface ISerialReader {
	/**
	 * Getter for the current serial stream handling the input data.
	 * 
	 * @return The given {@link InputStream} reference
	 */
	InputStream getInpustream();
	
	/**
	 * Read and return the number of bytes available in the buffer.
	 * 
	 * @return the number of bytes available in the buffer
	 */
	int read();
	
	/**
	 * 
	 * @return
	 */
	int last();
	
	/**
	 * 
	 * @return
	 */
	char readChar();
	
	/**
	 * 
	 * @return
	 */
	char lastChar();
	
	/**
	 * Read a bytes buffer from the currently active {@link InputStream} owned reference.
	 * 
	 * @return some bytes according to the buffer length
	 */
	byte[] readBytes();
	
	/**
	 * 
	 * @param outgoing
	 * @return
	 */
	int readBytes(byte outgoing[]);
	
	/**
	 * 
	 * @param interesting
	 * @return
	 */
	byte[] readBytesUntil(int interesting);
	
	/**
	 * 
	 * @param interesting
	 * @param outgoing
	 * @return
	 */
	int readBytesUntil(int interesting, byte outgoing[]);
	
	/**
	 * Read buffer as a String
	 * 
	 * @return String coming from a buffer
	 */
	String readString();
	
	/**
	 * Read buffer until reaching a given interesting point.
	 * 
	 * @param interesting
	 * @return
	 */
	String readStringUntil(int interesting);
}
