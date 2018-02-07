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

package ubiquisense.iorx.protocols.tuio.tuio11;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import com.illposed.osc.OSCBundle;
import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPacket;
import com.illposed.osc.utility.OSCByteArrayToJavaConverter;

import ubiquisense.iorx.annotations.CommunicationProtocol;
import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.comm.udp.io.UdpTransportCommunicator;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.protocols.tuio.TuioCursor;
import ubiquisense.iorx.protocols.tuio.TuioObject;
import ubiquisense.iorx.protocols.tuio.internal.tuio11.STATE;
import ubiquisense.iorx.protocols.tuio.internal.tuio11.Tuio2DCur;
import ubiquisense.iorx.protocols.tuio.internal.tuio11.Tuio2DObj;
import ubiquisense.iorx.protocols.tuio.internal.tuio11.TuioBundle;
import ubiquisense.iorx.protocols.tuio.internal.tuio11.impl.TuioBundleImpl;

@CommunicationProtocol(type = "tuio11")
public class Tuio11QxCmdHandler implements IXFrameInterpreter, IXCmdInterpreter, IQxEventHandler {
	private OSCByteArrayToJavaConverter converter;
	
	public Tuio11QxCmdHandler() {
		converter = new OSCByteArrayToJavaConverter();
	}
	
	@Override
	public synchronized byte[] cmd2ByteArray(final Cmd cmd) {
		if (cmd instanceof Tuio2DCur || cmd instanceof Tuio2DObj || cmd instanceof TuioBundle) {
			return Tuio11CmdUtils.INSTANCE.dumpTuio11CmdFromEClassifierMsg(cmd);
		}
		return new byte[0];
	}

	@Override
	public synchronized Cmd byteArray2Cmd(final byte[] stream) {
		if (stream != null && stream.length>1) {
			OSCPacket packet = converter.convert(stream, stream.length);
			if (packet instanceof OSCPacket) {
				return processOSCPacket(packet);
			}
		}
		return null;
	}
	
	private Cmd processOSCPacket(OSCPacket packet, Cmd cmd) {
		if (packet instanceof OSCBundle) {
			if (cmd instanceof TuioBundle) {
				for (OSCPacket p : ((OSCBundle)packet).getPackets()) {
					if (p instanceof OSCMessage) {
						Cmd c = acceptMessage(
							(OSCMessage) p
						);
						if (c != null) {
							((TuioBundle)cmd).getChildren().add(c);
						}
					} else if (p instanceof OSCBundle) {
						if (((OSCBundle)p).getPackets() != null && ((OSCBundle)p).getPackets().size()>0) {
							TuioBundle bundle = new TuioBundleImpl();
							bundle.setTime(((OSCBundle)p).getTimestamp().getTime());
							
							((TuioBundle)cmd).getChildren().add(
								processOSCPacket(
									p, 
									bundle
								)
							);
						}
					} else {
						// uhu ?
					}
				}
			}
			return cmd;
		} else {
			return acceptMessage((OSCMessage) packet);
		}
	}
	
	public Cmd processOSCPacket(OSCPacket packet) {
		if (packet instanceof OSCBundle) {
			TuioBundle bundle = new TuioBundleImpl();
			bundle.setTime(((OSCBundle) packet).getTimestamp().getTime());
			return processOSCPacket(packet, bundle);
		} else {
			return acceptMessage((OSCMessage) packet);
		}
	}
	
	//
	//
	// TUIO stuff ...
	//
	//
	
	private Hashtable<Long,TuioObject> objectList = new Hashtable<Long,TuioObject>();
	private Vector<Long> aliveObjectList = new Vector<Long>();
	private Vector<Long> newObjectList = new Vector<Long>();
	
	private Hashtable<Long,TuioCursor> cursorList = new Hashtable<Long,TuioCursor>();
	private Vector<Long> aliveCursorList = new Vector<Long>();
	private Vector<Long> newCursorList = new Vector<Long>();
	
	private Vector<TuioCursor> freeCursorList = new Vector<TuioCursor>();

	private int maxFingerID = -1;
	
	private long currentFrame = 0;
	private long lastFrame = 0;
	private long startTime = 0;
	private long lastTime = 0;
	
	private final int UNDEFINED = -1;
	
	public Vector<TuioObject> getTuioObjects() {
		return new Vector<TuioObject>(objectList.values());
	}
	
	public Vector<TuioCursor> getTuioCursors() {
		return new Vector<TuioCursor>(cursorList.values());
	}	

	public TuioObject getTuioObject(long s_id) {
		return (TuioObject)objectList.get(s_id);
	}
	
	public TuioCursor getTuioCursor(long s_id) {
		return (TuioCursor)cursorList.get(s_id);
	}	

	public synchronized Cmd acceptMessage(OSCMessage message) {
		Object[] args = message.getArguments().toArray();
		String command = args.length > 0 ? (String)args[0] : "";
		String address = message.getAddress();
		
		if (address == null || "".equals(address)) {
			return null;
		}
		
		if (address.equals("/tuio/2Dobj")) {
			if (command.equals("set")) {
				if ((currentFrame<lastFrame) && (currentFrame>0)) return null;
				long s_id  = ((Integer)args[1]).longValue();
				int f_id  = ((Integer)args[2]).intValue();
				float xpos = ((Float)args[3]).floatValue();
				float ypos = ((Float)args[4]).floatValue();
				float angle = ((Float)args[5]).floatValue();
				float xspeed = ((Float)args[6]).floatValue();
				float yspeed = ((Float)args[7]).floatValue();
				float rspeed = ((Float)args[8]).floatValue();
				float maccel = ((Float)args[9]).floatValue();
				float raccel = ((Float)args[10]).floatValue();
				
				if (objectList.get(s_id) == null) {
				
					TuioObject addObject = new TuioObject(s_id,f_id,xpos,ypos,angle);
					objectList.put(s_id,addObject);
					
					TuioBundle tuioBundle = new TuioBundleImpl();
					tuioBundle.setTime(System.currentTimeMillis());

//					OSCMessage msg = new OSCMessage(message.getAddress());
//					msg.addArgument("alive");
//					msg.addArgument(new Integer(addObject.getSessionID()+""));
//					tuioBundle.getChildren().add(
//						Tuio11CmdUtils.INSTANCE.createTuio11CmdFromEClassifierMsg(
//							addObject, 
//							EztuioPackage.Literals.TUIO2_DOBJ_REMOVE, 
//							msg
//						)
//					);
					
					tuioBundle.getChildren().add(
						Tuio11CmdUtils.INSTANCE.createTuio11CmdFromEClassifierMsg(
							addObject, 
							"TUIO2_DOBJ_ADD", 
							message
						)
					);
					
					return tuioBundle;
				} else {
				
					TuioObject updateObject = (TuioObject)objectList.get(s_id);
					if ((updateObject.xpos!=xpos) || (updateObject.ypos!=ypos) || (updateObject.angle!=angle) || (updateObject.x_speed!=xspeed) || (updateObject.y_speed!=yspeed) || (updateObject.rotation_speed!=rspeed) || (updateObject.motion_accel!=maccel) || (updateObject.rotation_accel!=raccel)) {
						updateObject.update(xpos,ypos,angle,xspeed,yspeed,rspeed,maccel,raccel);

						return Tuio11CmdUtils.INSTANCE.createTuio11CmdFromEClassifierMsg(
							updateObject, 
							"TUIO2_DOBJ_UPDATE", 
							message
						);
					}
				}
	
				System.out.println("set obj " +s_id+" "+f_id+" "+xpos+" "+ypos+" "+angle+" "+xspeed+" "+yspeed+" "+rspeed+" "+maccel+" "+raccel);
				
			} else if (command.equals("alive")) {
				if ((currentFrame<lastFrame) && (currentFrame>0)) return null;
	
				for (int i=1;i<args.length;i++) {
					// get the message content
					long s_id = ((Integer)args[i]).longValue();
					newObjectList.addElement(s_id);
					// reduce the object list to the lost objects
					if (aliveObjectList.contains(s_id))
						 aliveObjectList.removeElement(s_id);
				}
				
				TuioBundle tuioBundle = new TuioBundleImpl();
				tuioBundle.setTime(System.currentTimeMillis());
				
				// remove the remaining objects
				for (int i=0;i<aliveObjectList.size();i++) {
					TuioObject removeObject = (TuioObject)objectList.remove(aliveObjectList.elementAt(i));
					if (removeObject==null) continue;
					
					System.out.println("remove "+removeObject.getSessionID());
					message.addArgument(removeObject.getSessionID()+"");
					tuioBundle.getChildren().add(
						Tuio11CmdUtils.INSTANCE.createTuio11CmdFromEClassifierMsg(
							removeObject, 
							"TUIO2_DOBJ_REMOVE", 
							message
						)
					);
					
					removeObject.remove();
				}
				
				Vector<Long> buffer = aliveObjectList;
				aliveObjectList = newObjectList;
				
				// recycling of the vector
				newObjectList = buffer;
				newObjectList.clear();
				
				if (tuioBundle.getChildren().size()==0) {
					return null;
				} else if (tuioBundle.getChildren().size()==1) {
					return tuioBundle.getChildren().get(0);
				}
				return tuioBundle;
					
			} else if (command.equals("fseq")) {
				if (currentFrame>=0) lastFrame = currentFrame;
				currentFrame = ((Integer)args[1]).intValue();
				
				if ((currentFrame>=lastFrame) || (currentFrame<0)) {
					
					long currentTime = lastTime;
					if (currentFrame>lastFrame) {
						currentTime = System.currentTimeMillis()-startTime;
						lastTime = currentTime;
					}

					TuioBundle tuioBundle = new TuioBundleImpl();
					tuioBundle.setTime(currentTime);

					Enumeration<TuioObject> refreshList = objectList.elements();					
					while(refreshList.hasMoreElements()) {
						TuioObject refreshObject = refreshList.nextElement();
						if (refreshObject.getUpdateTime()==UNDEFINED) refreshObject.setUpdateTime(currentTime);
						
						if (refreshObject.getState() == STATE.TUIO_ACCELERATING_VALUE || refreshObject.getState() == STATE.TUIO_DECELERATING_VALUE || refreshObject.getState() == STATE.TUIO_STOPPED_VALUE) {
							tuioBundle.getChildren().add(
								Tuio11CmdUtils.INSTANCE.createTuio11CmdFromEClassifierMsg(
									refreshObject, 
									"TUIO2_DOBJ_UPDATE", 
									message
								)
							);
						} else if (refreshObject.getState() == STATE.TUIO_REMOVED_VALUE) {
							OSCMessage msg = new OSCMessage(message.getAddress());
							msg.addArgument("alive");
							msg.addArgument(""+refreshObject.session_id);
							tuioBundle.getChildren().add(
								Tuio11CmdUtils.INSTANCE.createTuio11CmdFromEClassifierMsg(
									refreshObject, 
									"TUIO2_DOBJ_REMOVE", 
									msg
								)
							);
						} else if (refreshObject.getState() == STATE.TUIO_ADDED_VALUE) {
							OSCMessage msg = new OSCMessage(message.getAddress());
							msg.addArgument("alive");
							msg.addArgument(""+refreshObject.session_id);
							tuioBundle.getChildren().add(
								Tuio11CmdUtils.INSTANCE.createTuio11CmdFromEClassifierMsg(
									refreshObject, 
									"TUIO2_DOBJ_ADD", 
									msg
								)
							);
						}
					}
					if (tuioBundle.getChildren().size()==0) {
						return null;
					} else if (tuioBundle.getChildren().size()==1) {
						return tuioBundle.getChildren().get(0);
					}
					return tuioBundle;
				}
			}

		} else if (address.equals("/tuio/2Dcur")) {

			if (command.equals("set")) {
				if ((currentFrame<lastFrame) && (currentFrame>0)) return null;

				long s_id  = ((Integer)args[1]).longValue();
				float xpos = ((Float)args[2]).floatValue();
				float ypos = ((Float)args[3]).floatValue();
				float xspeed = ((Float)args[4]).floatValue();
				float yspeed = ((Float)args[5]).floatValue();
				float maccel = ((Float)args[6]).floatValue();
				
				if (cursorList.get(s_id) == null) {
				
					int f_id = cursorList.size();
					if (cursorList.size()<=maxFingerID) {
						TuioCursor closestCursor = freeCursorList.firstElement();
						Enumeration<TuioCursor> testList = freeCursorList.elements();
						while (testList.hasMoreElements()) {
							TuioCursor testCursor = testList.nextElement();
							if (testCursor.getDistance(xpos,ypos)<closestCursor.getDistance(xpos,ypos)) closestCursor = testCursor;
						}
						f_id = closestCursor.getFingerID();
						freeCursorList.removeElement(closestCursor);
					} else maxFingerID = f_id;		
					
					TuioCursor addCursor = new TuioCursor(s_id,f_id,xpos,ypos);
					cursorList.put(s_id,addCursor);

					return Tuio11CmdUtils.INSTANCE.createTuio11CmdFromEClassifierMsg(
						addCursor, 
						"TUIO2_DCUR_ADD", 
						message
					);

				} else {
				
					TuioCursor updateCursor = (TuioCursor)cursorList.get(s_id);
					if ((updateCursor.xpos!=xpos) || (updateCursor.ypos!=ypos) || (updateCursor.x_speed!=xspeed) || (updateCursor.y_speed!=yspeed) || (updateCursor.motion_accel!=maccel)) {

						updateCursor.update(xpos,ypos,xspeed,yspeed,maccel);

						return Tuio11CmdUtils.INSTANCE.createTuio11CmdFromEClassifierMsg(
							updateCursor, 
							"TUIO2_DCUR_UPDATE", 
							message
						);
					}
				}
				
				System.out.println("set cur " + s_id+" "+xpos+" "+ypos+" "+xspeed+" "+yspeed+" "+maccel);
				
			} else if (command.equals("alive")) {
				if ((currentFrame<lastFrame) && (currentFrame>0)) return null;
	
				for (int i=1;i<args.length;i++) {
					// get the message content
					long s_id = ((Integer)args[i]).longValue();
					newCursorList.addElement(s_id);
					// reduce the cursor list to the lost cursors
					if (aliveCursorList.contains(s_id)) 
						aliveCursorList.removeElement(s_id);
				}
				
				TuioBundle tuioBundle = new TuioBundleImpl();
				tuioBundle.setTime(System.currentTimeMillis());

				// remove the remaining cursors
				for (int i=0;i<aliveCursorList.size();i++) {
					TuioCursor removeCursor = (TuioCursor)cursorList.remove(aliveCursorList.elementAt(i));
					if (removeCursor==null) continue;
					removeCursor.remove();
					
					if (removeCursor.finger_id==maxFingerID) {
						maxFingerID = -1;
						if (cursorList.size()>0) {
							Enumeration<TuioCursor> clist = cursorList.elements();
							while (clist.hasMoreElements()) {
								int f_id = clist.nextElement().finger_id;
								if (f_id>maxFingerID) maxFingerID=f_id;
							}
							
							Enumeration<TuioCursor> flist = freeCursorList.elements();
							while (flist.hasMoreElements()) {
								int c_id = flist.nextElement().getFingerID();
								if (c_id>=maxFingerID) freeCursorList.removeElement(c_id);
							}
						} 
					} else if (removeCursor.finger_id<maxFingerID) {
						freeCursorList.addElement(removeCursor);
					}
					
					OSCMessage msg = new OSCMessage(message.getAddress(), message.getArguments());
					msg.addArgument(removeCursor.getSessionID()+"");
					//System.out.println("remove "+id);
					tuioBundle.getChildren().add(
						Tuio11CmdUtils.INSTANCE.createTuio11CmdFromEClassifierMsg(
							removeCursor, 
							"TUIO2_DCUR_REMOVE", 
							msg
						)
					);
				}
				
				Vector<Long> buffer = aliveCursorList;
				aliveCursorList = newCursorList;
				
				// recycling of the vector
				newCursorList = buffer;
				newCursorList.clear();
				
				if (tuioBundle.getChildren().size()==0) {
					return null;
				} else if (tuioBundle.getChildren().size()==1) {
					return tuioBundle.getChildren().get(0);
				}
				return tuioBundle;
				
			} else if (command.equals("fseq")) {
				if (currentFrame>=0) lastFrame = currentFrame;
				currentFrame = ((Integer)args[1]).intValue();
				
				if ((currentFrame>=lastFrame) || (currentFrame<0)) {
					long currentTime = lastTime;
					if (currentFrame>lastFrame) {
						currentTime = System.currentTimeMillis()-startTime;
						lastTime = currentTime;
					}

					TuioBundle tuioBundle = new TuioBundleImpl();
					tuioBundle.setTime(currentTime);
					
					Enumeration<TuioCursor> refreshList = cursorList.elements();					
					while(refreshList.hasMoreElements()) {
						TuioCursor refreshCursor = refreshList.nextElement();
						if (refreshCursor.getUpdateTime()==UNDEFINED) refreshCursor.setUpdateTime(currentTime);
						
						tuioBundle.getChildren().add(
							Tuio11CmdUtils.INSTANCE.createTuio11CmdFromEClassifierMsg(
								refreshCursor, 
								"TUIO2_DCUR_UPDATE", 
								message
							)
						);
					}
					
					if (tuioBundle.getChildren().size()==0) {
						return null;
					} else if (tuioBundle.getChildren().size()==1) {
						return tuioBundle.getChildren().get(0);
					}
					return tuioBundle;
				}
			} 

		}
		
		return null; // Should not happen
	}

	@Override
	public void handleQxEvent(Event event) {
		if (event.getKind().equals(EVENT_KIND.RX_DONE)) {
			Object obj = event.getQx().getEngine().getPort().getChannel();
			if (obj instanceof UdpTransportCommunicator) {
				DatagramSocket socket = ((UdpTransportCommunicator)obj).getSocket();
				DatagramPacket packet = new DatagramPacket(new byte[15360], 15360);
				if (event.getCmd() instanceof Tuio2DCur) {
					packet.setData(
						((Tuio2DCur)event.getCmd()).getMsg().getByteArray()
					);
				} else if (event.getCmd() instanceof Tuio2DObj) {
					packet.setData(
						((Tuio2DObj)event.getCmd()).getMsg().getByteArray()
					);
				} else if (event.getCmd() instanceof TuioBundle) {
					for (OSCPacket p : processTuioBundle((TuioBundle)event.getCmd())) {
						if (socket != null && socket.isBound()) {
							packet.setData(p.getByteArray());
							try {
								socket.send(packet);
							} catch (IOException ioe) {
								ioe.printStackTrace();
							}
						}
					}
					return;
				} else {
					return;
				}
				try {
					if (socket != null && socket.isBound()) {
						socket.send(packet);
					}
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}
	
	private List<OSCPacket> processTuioBundle(TuioBundle bundle) {
		return processTuioBundle(bundle, new ArrayList<OSCPacket>());
	}
	
	private List<OSCPacket> processTuioBundle(TuioBundle bundle, List<OSCPacket> packets) {
		for (Cmd c : bundle.getChildren()) {
			if (c instanceof Tuio2DObj || c instanceof Tuio2DCur) {
				packets.add(Tuio11CmdUtils.INSTANCE.createOSCPacketFromCmd(c));
			} else { // TuioBunle 
				packets.addAll(processTuioBundle((TuioBundle)c, new ArrayList<OSCPacket>()));
			}
		}
		return packets;
	}


	@Override
	public String getID() {
		return "tuio11";
	}
}
