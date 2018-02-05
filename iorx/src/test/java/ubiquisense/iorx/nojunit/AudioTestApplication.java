/***********************************************************************************
 * Ubiquisense - A smart ambient utilities framework 
 * 
 * Copyright (c) 2012, Lucas Bigeardel
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

package ubiquisense.iorx.nojunit;

import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;

import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.exceptions.InitException;

public class AudioTestApplication {
	static boolean init;
	static boolean deinit = false;
	public static void main(String[] args) {
		/*
		 * NativeFmodEx Init
		 */
		try {
			Init.loadLibraries();
		}
		catch(InitException e) {
			System.out.printf("NativeFmodEx error! %s\n", e.getMessage());
			return;
		}

		/*
		 * Checking NativeFmodEx version
		 */
		if(NATIVEFMODEX_LIBRARY_VERSION != NATIVEFMODEX_JAR_VERSION) {
			System.out.printf("Error!  NativeFmodEx library version (%08x) is different to jar version (%08x)\n",
					NATIVEFMODEX_LIBRARY_VERSION, NATIVEFMODEX_JAR_VERSION);
			return;
		}

		/*==================================================*/

		init = true;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	protected void print(String message) {
		//getOutputTA().append(message);
		//	getOutputTA().setCaretPosition(getOutputTA().getText().length());
	}

	protected void printf(String format, Object... args) {
		print(String.format(format, args));
	}

	protected void printr(String message) {
/*
 		String text = getOutputTA().getText();
		int index = text.lastIndexOf("\n");
		if(index >= 0) text = text.substring(0, index + 1);
		getOutputTA().setText(text + message);
		getOutputTA().setCaretPosition(getOutputTA().getText().length());
*/
	}

	protected void printfr(String format, Object... args) {
		printr(String.format(format, args));
	}

	protected void printExit(String message) {
		print(message);
//		JOptionPane.showMessageDialog(this, message);
//		end.end();
	}

	protected void printfExit(String format, Object... args) {
		printExit(String.format(format, args));
	}

}
