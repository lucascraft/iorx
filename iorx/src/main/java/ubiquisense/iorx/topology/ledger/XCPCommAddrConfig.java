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

package ubiquisense.iorx.topology.ledger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XCPCommAddrConfig {
	public final static XCPCommAddrConfig INSTANCE = new XCPCommAddrConfig();
	
	IPAddressValidator ipAddrValidator = new IPAddressValidator();
	
	public class IPAddressValidator{
	    private Pattern pattern;
	    private Matcher matcher;
	 
	    private static final String IPADDRESS_PATTERN = 
			"^(localhost|([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5]))(\\:\\d\\d\\d?\\d?)?$";
	 
	    public IPAddressValidator(){
		  pattern = Pattern.compile(IPADDRESS_PATTERN);
	    }
	 
	    public boolean validate(String ip){
	      ip = ip == null ? "" : ip.toLowerCase();
	      ip = ip.trim();
		  matcher = pattern.matcher(ip);
		  return matcher.matches();
	    }
	}

//	
//	public List<String> getIPAddresses() {
//		List<String> ips = new ArrayList<String>();
//		for (EzTargetConfig c : getCommunicationConfigs()) {
//			String ip = c.getTargetAddr();
//			if (ipAddrValidator.validate(ip)) {
//				if (!ips.contains(ip)) {
//					ips.add(ip);
//				}
//			}
//		}
//		return ips;
//	}
	
	

}
