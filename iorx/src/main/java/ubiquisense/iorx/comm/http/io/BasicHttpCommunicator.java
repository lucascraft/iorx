 

package ubiquisense.iorx.comm.http.io;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.utils.Platform;



public class BasicHttpCommunicator extends HttpCommunicator {
    protected DataInputStream in;
    
    
    private int response_code;
    private String response_message;
    private byte[] data;
    
    
    protected int access_index;
    
    public BasicHttpCommunicator() {
		properties = new HashMap<String, String>();
	}
	
    @Override
    public void init(String pipeID, String portID, int[] ports) {
    	setParameters(pipeID, portID, ports);
    }
	@Override
	public void get(Event event) {
		doHttp(event);
	}
	
	String postData = "";
	HttpURLConnection httpc;
	private synchronized void doHttp(final Event evt) {
		if (evt != null && evt.getQx() != null && evt.getQx().getEngine() != null) {

			try {
				String command = "";
				final CmdPipe pipe = evt.getQx().getEngine();
				synchronized (pipe.getOutputInterpreter()) {
					pipe.getPort().getChannel().setLastFrame(data);
					properties.clear();
					if (evt.getCmd() instanceof HttpCommCmd) {
						HttpCommCmd cmd = (HttpCommCmd) evt.getCmd();
						command = new String(pipe.getOutputInterpreter().cmd2ByteArray(cmd));
						String url = portID + command;
						if (Platform.inDebugMode()) {
							System.out.println("Http : " + url);
						}
						
						setMethod(HttpMethod.GET.getLiteral());
						setMethod(cmd.getMethod() == null ? HttpMethod.GET.getLiteral() : cmd.getMethod().getLiteral());
						
						Property postProperty = null;
						for (Property p : cmd.getProperties()) {
							if (p.getKey().equals(HttpMethod.POST.getLiteral())) {
								postProperty = p;
							}
						}
						if (postProperty != null) {
							postData = postProperty.getValue();

							cmd.getProperties().remove(postProperty);
						}
						for (Property p : cmd.getProperties()) {
							properties.put(p.getKey(), p.getValue());
						}
					}
					
					if (getMethod().equals(HttpMethod.GET.getLiteral())) {
						URL url = null;
					    try {
					    	String query = portID + "/" + command + getQueryArguments();
					        url = new URL(query);
					        
					        httpc = (HttpURLConnection) url.openConnection();
					        
					        if (httpc != null) {
					        	if (method != null) {
					        		try {
					        			httpc.setRequestMethod(method);
					        		} catch (Exception e) {
					        			e.printStackTrace();
					        			System.out.println(method + " : bad method connection !");
					        		}
					        	}
					        }
					        
					        if (Platform.inDebugMode()) {
						        System.out.println(httpc);
					        }
					        try {
					        	httpc.connect();
					        } catch (Exception e) {
					        	e.printStackTrace();
					        }
					        response_code = httpc.getResponseCode();
					        if (!(response_code == HttpURLConnection.HTTP_OK)
					                && !(response_code == HttpURLConnection.HTTP_PARTIAL)) {
					            response_message = httpc.getResponseMessage();
					            if (response_code == HttpURLConnection.HTTP_UNAUTHORIZED) {
					                System.out.println(portID
					                        + " requires password!\n"+response_message);
					                }
					            }
					    } catch (MalformedURLException e) {
					        e.printStackTrace();
					        System.out.println("Malformed URL");
							pipe.getPort().getChannel().setLastFrame(null);
					    } catch (IOException ioe) {
					        ioe.printStackTrace();
							pipe.getPort().getChannel().setLastFrame(null);
					    }
			
					    
					    
					    in = new DataInputStream(httpc.getInputStream());
					    int len = httpc.getContentLength();
					    if (len == -1) {
					        return;
					    }
					    data = new byte[len];
					    in.readFully(data);
			
					    pipe.receive(data);
							
						pipe.getPort().getChannel().setLastFrame(data);
			
			            httpc.disconnect();
					}
		                
		            properties.clear();
		
				}
			} catch (java.net.SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private String getQueryArguments() {
		if (properties.isEmpty()) {
			return "";
		} else {
			String q = "";
			for (String k : properties.keySet()) {
				q += k + "=" + properties.get(k) + "&";
			}
			return q.substring(0, q.length()-1);
		}
	}
	
	public void close() {
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		httpc.disconnect();
	}
}
