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

package ubiquisense.iorx.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuanticComm {
	public final static QuanticComm INSTANCE = new QuanticComm();
	
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

//	public Collection<EzTargetConfig> getCommunicationConfigs() {
//		List<EzTargetConfig> configs = new ArrayList<EzTargetConfig>();
//		IExtensionRegistry registry = Platform.getExtensionRegistry();
//		IExtensionPoint point = registry.getExtensionPoint("net.sf.smbt.quantic.targetConfig");
//		if (point == null) return null;
//		IExtension[] extensions = point.getExtensions();
//		for (int i = 0; i < extensions.length; i++) {
//			for (IConfigurationElement elem : extensions[i].getConfigurationElements()) {
//				String addr = elem.getAttribute("addr");
//				addr = addr == null ? "" : addr.trim();
//				
//				String inputPort = elem.getAttribute("inputPort");
//				inputPort = inputPort == null ? "" : inputPort.trim();
//				
//				String transport = elem.getAttribute("transport");
//				transport = transport == null ? "" : transport.trim();
//				
//				String protocol = elem.getAttribute("protocol");
//				protocol = protocol == null ? "" : protocol.trim();
//				
//				String speed = elem.getAttribute("speed");
//				speed = speed == null ? "" : speed.trim();
//				
//				EzTargetConfig cfg = new EzTargetConfig(
//					addr, 
//					inputPort, 
//					protocol, 
//					transport, 
//					speed
//				);
//				
//				if (!configs.contains(cfg)) {
//					configs.add(cfg);
//				}
//			}
//		}
//		return configs;
//	}
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
