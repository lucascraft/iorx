package ubiquisense.iorx.utils;

/**
 * Resonsible on receiving/emmiting OSC commands in an agent fashion
 * 
 * It also init JmDNS/Bonjour service for Zeroconf discovery 
 * 
 * @author lucas bigeardel
 *
 */
public class DnsSdUtil { /*implements ServiceListener, ServiceTypeListener{

	private JmDNSImpl dnsSdRegistry;
    @SuppressWarnings("unused")
	private final static String serviceKey = "srvname"; // Max 9 chars
    @SuppressWarnings("unused")
	private ServiceInfo service;
    @SuppressWarnings("unused")
	private MulticastSocket multicastSocket;
    
    private List<IXCPDeviceLifecycleListener> deviceListeners;
    private Map<String, ISmartDnsServiceManager> dnsServicesMap;
    @SuppressWarnings("unused")
	private OSCByteArrayToJavaConverter converter;
    
    public final static DnsSdUtil INSTANCE = new DnsSdUtil();

	public DnsSdUtil() {
		dnsServicesMap = dnsServiceRegistrations();
		deviceListeners = new ArrayList<IXCPDeviceLifecycleListener>();
		converter = new OSCByteArrayToJavaConverter();
        try {
        	InetAddress addr = InetAddress.getLocalHost();
        	dnsSdRegistry = (JmDNSImpl) JmDNS.create(addr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		initRegistry();
		initService();
//		scanServices();
	}

	
	public JmDNS getRegistry() {
		return dnsSdRegistry;
	}
	
	public void initRegistry() {
		try {
			dnsSdRegistry.addServiceTypeListener(this);
		} catch (IOException e) {
			e.printStackTrace();
		}

	    String[] list = new String[] {"_ezmojo._udp.local."};

	    for (int i = 0; i < list.length; i++) {
	    	dnsSdRegistry.registerServiceType(list[i]);
	    }
	}

	public List<IXCPDeviceLifecycleListener> getDeviceListeners() {
		return deviceListeners;
	}
	public void addDeviceListener(IXCPDeviceLifecycleListener listener) {
		deviceListeners.add(listener);
	}
	public void removeDeviceListener(IXCPDeviceLifecycleListener listener) {
		deviceListeners.remove(listener);
	}
	
	void initService() {
		
//	        String text = "Ubiquisense Hub";
//	        Map<String, byte[]> properties = new HashMap<String, byte[]>();
//	        properties.put(serviceKey, text.getBytes());
//	        
//	        String serviceID = ServiceName + "." + ServiceTransport + "." + ServiceDomain + ".";
//	        service = ServiceInfo.create(
//	        	serviceID, 
//	        	"ubqt", 
//	        	ServiceDefaultPort, 
//	        	0, 
//	        	0, 
//	        	true, 
//	        	properties
//	        );
	        
//			try {
//				dnsSdRegistry.registerService(service);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			
			//
			// Read and create from registry
			//
			
			initServicesFromRegistry();
	}
	
	private void initServicesFromRegistry() {
		for (String key : dnsServicesMap.keySet()) {
			final ISmartDnsServiceManager dnsService = dnsServicesMap.get(key);
			if (		dnsService instanceof ISmartDnsServiceManager  &&	dnsService.getServiceInfo() instanceof ServiceInfo ) {
//				try {
					//registry.registerService(dnsService.getServiceInfo());
					new Job(UUID.randomUUID().toString()) {
						@Override
						protected IStatus run(IProgressMonitor monitor) {
							dnsService.init();
							dnsService.connect();
							return Status.OK_STATUS;
						}
					}.schedule(2500);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			}
		}
	}
	

//	void scanServices() {
//		Map<String, ServiceInfo> servicesMap = registry.getServices();
//		for (String key : servicesMap.keySet()) {
//			if (key.startsWith("_touchosc") || key.startsWith("_osc") || key.startsWith("_ezmojo")) { // Let's gonna start the OSC topology madness
//				handleOSCServiceInfo(servicesMap.get(key));
//			}
//		}
//	}
//
//	void handleOSCServiceInfo(ServiceInfo serviceInfo) {
//		if (serviceInfo instanceof ServiceInfo) {
//			String hostAddr = serviceInfo.getInetAddress().getHostAddress();
//			String domain = serviceInfo.getDomain();
//			String application = serviceInfo.getApplication();
//			String type = serviceInfo.getType();
//			
//			System.out.println("host : " + hostAddr + ", " + domain + ", " + application + ", " + type);
//		}
//	}
	
	
//	public Map<String, ISmartDnsServiceManager> getDnsServicesMap() {
//		return dnsServicesMap;
//	}
//	
//	private void handleCommand(OSCPacket packet) {
//		// FIXME : take all ADD/UPDATE/REMOVE cases into consideration
//		
//		XCPDevice device = XCPUtil.INSTANCE.getDeviceDescription(packet);
//		
//		for (IXCPDeviceLifecycleListener l : deviceListeners) {
//			if (l instanceof IXCPDeviceLifecycleListener) {
//				l.onDeviceUpdate(device, System.currentTimeMillis());
//			}
//		}
//	}
//	
//	public ISmartDnsServiceManager dnsServiceRegistration(String serviceID) {
//		return dnsServiceRegistrations().get(serviceID);
//	}
	
	
	public Map<String, ISmartDnsServiceManager> dnsServiceRegistrations() {
		Map<String, ISmartDnsServiceManager> dnsServiceManagers = new HashMap<String, ISmartDnsServiceManager>();
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint("net.sf.smbt.quantic.bonjour");
		if (point == null) return null;
		IExtension[] extensions = point.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			for (IConfigurationElement elem : extensions[i].getConfigurationElements()) {
				try {
					ISmartDnsServiceManager dnsServiceManager = (ISmartDnsServiceManager) elem.createExecutableExtension("manager");
					dnsServiceManagers.put(elem.getAttribute("id"), dnsServiceManager);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
		return dnsServiceManagers;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

@Override
public void serviceAdded(ServiceEvent event)
{
    final String name = event.getName();

    for (IXCPDeviceLifecycleListener l : deviceListeners){
    	l.onDeviceAdd(
    		SupervisorUtils.INSTANCE.initXCPDevice(event), 
    		System.currentTimeMillis()
    	);
    }
    
   System.out.println("ADD: " + name);
}

@Override
public void serviceRemoved(ServiceEvent event)
{
    final String name = event.getName();
    System.out.println("REMOVE: " + name);
}

@Override
public void serviceResolved(ServiceEvent event)
{
    final String name = event.getName();
    System.out.println("RESOLVED: " + name);
}

@Override
public void serviceTypeAdded(ServiceEvent event)
{
    final String aType = event.getType();
    

    System.out.println("TYPE: " + aType);
    
    @SuppressWarnings("unused")
	ServiceInfo service = null;
    if (aType.startsWith("_osc._udp.")) {
    	// connect and retrieve Service API contracts
		@SuppressWarnings("unused")
		String name = event.getName();
//		 if (name == null) {
//		    System.out.println("");
//		} else {
//		    if (!name.endsWith(".")) {
//			name = name + "." + event.getType();
//		    } 
//		    service = registry.getServiceInfo(event.getType(), name);
//		    if (service == null) {
//		    	System.out.println("service not found");
//		    } else {
//			if (!name.endsWith(".")) {
//			    name = name + "." + event.getType();
//			}
//			registry.requestServiceInfo(event.getType(), name);
//		    }
//		}
   
    	//service = registry.getServiceInfo(event.getType(), event.getType());

    	
        // This is actually redundant. getServiceInfo will force the resolution of the service and call serviceResolved
      //  this.dislayInfo(service);

//    	CmdEngine oscDevice = QuanticMojo.INSTANCE.openUdpPipe(COMM_PROTOCOL.OSC10, event.getInfo().getInetAddress().getHostAddress());
//    	oscDevice.addQxEventHandler(new AbstractQxEventHandlerImpl() {
//    		@Override
//    		public void handleQxEvent(Event event) {
//    			if (event.getCmd() instanceof OscCmd) {
//    				handleCommand(((OscCmd)event.getCmd()).getMsg());
//    			}
//    		}
//    	});
//    	
//    	oscDevice.send(OscCmdUtils.INSTANCE.createOscCmd("/ubqt/bonjour"));
  
    	
    } else if (aType.startsWith("_ubqt._udp.") && !aType.endsWith(".localhost")) {
    	// distant ubqt : going distributed ?!?
    } else if (aType.startsWith("_ezmojo._udp.") && !aType.endsWith(".localhost")) {
    	// distant ubqt : going distributed ?!?
    }

}

@Override
public void subTypeForServiceTypeAdded(ServiceEvent event)
{
    System.out.println("SUBTYPE: " + event.getType());
}


//@Override
//public void valueChanged(ListSelectionEvent e)
//{
//    if (!e.getValueIsAdjusting())
//    {
//        if (e.getSource() == typeList)
//        {
//            type = (String) typeList.getSelectedValue();
//            System.out.println("VALUE CHANGED: type: " + type);
//            registry.removeServiceListener(type, this);
//            services.setSize(0);
//            info.setText("");
//            if (type != null)
//            {
//            	registry.addServiceListener(type, this);
//            }
//        }
//        else if (e.getSource() == serviceList)
//        {
//            String name = (String) serviceList.getSelectedValue();
//            System.out.println("VALUE CHANGED: type: " + type + " service: " + name);
//            if (name == null)
//            {
//                info.setText("");
//            }
//            else
//            {
//                ServiceInfo service = jmdns.getServiceInfo(type, name);
//                // This is actually redundant. getServiceInfo will force the resolution of the service and call serviceResolved
//                this.dislayInfo(service);
//            }
//        }
//    }
//}


@SuppressWarnings("unused")
private void dislayInfo(ServiceInfo service)
{
    System.out.println("INFO: " + service);
    if (service == null)
    {
        System.out.println("service not found");
    }
    else
    {
        StringBuffer buf = new StringBuffer();
        
        buf.append(service.getName());
        buf.append('.');
        buf.append(service.getTypeWithSubtype());
        buf.append('\n');
        buf.append(service.getServer());
        buf.append(':');
        buf.append(service.getPort());
        buf.append('\n');
        buf.append(service.getInetAddress());
        buf.append(':');
        buf.append(service.getPort());
        buf.append('\n');
        
        for (Enumeration<String> names = service.getPropertyNames(); names.hasMoreElements();)
        {
            String prop = names.nextElement();
            buf.append(prop);
            buf.append('=');
            buf.append(service.getPropertyString(prop));
            buf.append('\n');
        }

        System.out.println(buf.toString());
    }
    */
}
