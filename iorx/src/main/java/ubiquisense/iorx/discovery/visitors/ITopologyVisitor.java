/***********************************************************************************
 * Ubiquisense - A smart ambient utilities framework 
 * 
 * Copyright (c) 2010, Lucas Bigeardel
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

package ubiquisense.iorx.discovery.visitors;

import java.util.List;

import ubiquisense.iorx.topology.core.AbstractTopologyItem;


public interface ITopologyVisitor <N extends AbstractTopologyItem>{
	/**
	 * Add a new topology node as visitor gets accepted
	 * 
	 * @param node newly added topology node
	 */
	void addNode(N node);
	
	/**
	 * Get topology nodes as walk is completed
	 * 
	 * @return list of topology nodes as walk is completed, void list otherwise
	 */
	List<N> getNodes();
	
	/**
	 * Visit a topology node possibly being accepted 
	 * 
	 * @param node a toplogy node
	 * 
	 * @return true if visit succeeded
	 */
	boolean visit(N node);
	
	/**
	 *  Get topology nodes as walk is completed
	 *  
	 * @return list of topology nodes as walk is completed, void list otherwise
	 */
	List<ubiquisense.iorx.topology.ledger.XCPAddress> getAddresses();
	
	/**
	 * Do a reconciliation on a topology node (eg: looking for device connection status mainly)
	 *  
	 * @param node the topology node currently being reconciled
	 * 
	 * @return OK if node succesfully reconciled, CANCEL otherwise
	 */
	int doReconciliation(N node);
}
