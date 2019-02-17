package ubiquisense.iorx.registry;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.jmdns.ServiceTypeListener;
import javax.jmdns.impl.JmDNSImpl;

import org.reflections.Reflections;

import com.google.common.collect.Sets;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.illposed.osc.utility.OSCByteArrayToJavaConverter;

import ubiquisense.iorx.Ubq;
import ubiquisense.iorx.cmd.CmdEngine;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.discovery.IXCPDeviceLifecycleListener;
import ubiquisense.iorx.discovery.SupervisorUtils;
import ubiquisense.iorx.dndns.ISmartDnsServiceManager;
import ubiquisense.iorx.dndns.services.DnDnsService;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.protocols.osc.internal.OscCmd;
import ubiquisense.iorx.topology.ledger.XCPServiceStatus;

public class DnsSdRegistry extends GuiceRegistery implements ServiceListener, ServiceTypeListener {

	private JmDNSImpl dnsSdRegistry;
	@SuppressWarnings("unused")
	private final static String serviceKey = "srvname"; // Max 9 chars
	@SuppressWarnings("unused")
	private ServiceInfo service;
	@SuppressWarnings("unused")
	private MulticastSocket multicastSocket;

	private List<IXCPDeviceLifecycleListener> deviceListeners;
	@SuppressWarnings("unused")
	private OSCByteArrayToJavaConverter converter;

	public final static DnsSdRegistry INSTANCE = new DnsSdRegistry();

	public DnsSdRegistry() {
		deviceListeners = new ArrayList<IXCPDeviceLifecycleListener>();
		converter = new OSCByteArrayToJavaConverter();
		try {
			InetAddress addr = InetAddress.getLocalHost();
			dnsSdRegistry = (JmDNSImpl) JmDNS.create(addr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		initRegistry();
		initServicesFromRegistry();
		scanServices();
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

		Set<DnDnsService> sdnsServices = getDsDnsServicesRegistrations();
		
		sdnsServices.stream().forEach(s -> {
			try {
				dnsSdRegistry.registerService(
						s.getServiceInfo());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
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

	public Set<DnDnsService> getDsDnsServicesRegistrations() {
		Set<DnDnsService> configs = Sets.newHashSet();
		Set<Class<?>> annotatedClasses = new Reflections("").getTypesAnnotatedWith(javax.inject.Named.class, true);
		annotatedClasses.stream().filter(c -> Sets.newHashSet(c.getInterfaces()).contains(DnDnsService.class)).forEach(
				c -> configs.add(getDsDnsServicesDescritionl(c.getAnnotation(javax.inject.Named.class).value())));
		return configs.stream().filter(p -> p != null).collect(Collectors.toSet());
	}

	public DnDnsService getDsDnsServicesDescritionl(String servicename) {
		try {
			return (DnDnsService) injector
					.getInstance(Key.get(DnDnsService.class, Names.named(servicename)));
		} catch (Exception e) {
			System.out.println("Not a service");
		}
		return null;
	}

	private void initServicesFromRegistry() {
		getDsDnsServicesRegistrations().stream().
			filter(r -> r instanceof ISmartDnsServiceManager && r.getServiceInfo() instanceof ServiceInfo ).
				forEach(r -> {try {
					dnsSdRegistry.registerService(r.getServiceInfo());
					dnsSdRegistry.registerServiceType(r.getServiceInfo().getTypeWithSubtype());
				} catch (IOException e) {
					e.printStackTrace();
				} r.init(); r.connect();});
	}

	public JmDNSImpl getDnsSdRegistry() {
		return dnsSdRegistry;
	}

	void scanServices() {
		Map<String, ServiceInfo> servicesMap = dnsSdRegistry.getServices();
		for (String key : servicesMap.keySet()) {
			if (key.startsWith("_touchosc") || key.startsWith("_osc") || key.startsWith("_iorx")) { 
				handleOSCServiceInfo(servicesMap.get(key));
			}
		}
	}

	void handleOSCServiceInfo(ServiceInfo serviceInfo) {
		if (serviceInfo instanceof ServiceInfo) {
			String hostAddr = serviceInfo.getInetAddress().getHostAddress();
			String domain = serviceInfo.getDomain();
			String application = serviceInfo.getApplication();
			String type = serviceInfo.getType();

			System.out.println(
					"ubiquisense service found : " + hostAddr + ", " + domain + ", " + application + ", " + type);
		}
	}

	public static void checkForDistantPipes(ServiceInfo info) {
		System.out.println("Check for service");
		dislayInfo(info);
	}


	@Override
	public void serviceAdded(ServiceEvent event) {
		final String name = event.getName();

		for (IXCPDeviceLifecycleListener l : deviceListeners) {
			 l.onDeviceAdd(
					 SupervisorUtils.INSTANCE.initXCPDevice(event, XCPServiceStatus.CONNECTED),
					 System.currentTimeMillis()
			 );
		}

		System.out.println("ADD: " + name);
	}

	@Override
	public void serviceRemoved(ServiceEvent event) {
		final String name = event.getName();
		System.out.println("REMOVE: " + name);
	}

	@Override
	public void serviceResolved(ServiceEvent event) {
		final String name = event.getName();
		System.out.println("RESOLVED: " + name);
	}

	@Override
	public void serviceTypeAdded(ServiceEvent event) {
		final String aType = event.getType();

		System.out.println("TYPE: " + aType);

		@SuppressWarnings("unused")
		ServiceInfo service = null;
		if (aType.startsWith("_iorx.")) {
			// connect and retrieve Service API contracts
			@SuppressWarnings("unused")
			String name = "_iorx._udp._local";
			 System.out.println("Get service info : " + name);
			 service = dnsSdRegistry.getServiceInfo(event.getType(), name);
			 if (service == null) {
				 System.out.println("service not found : request");
			 } else {
				 dnsSdRegistry.requestServiceInfo(event.getType(), name);
			 }

			 service = dnsSdRegistry.getServiceInfo(event.getType(), event.getType());

			 this.dislayInfo(service);

			 CmdPipe oscDevice = Ubq.Reactor.openUdpPipe("osc",
			 event.getInfo().getInetAddress().getHostAddress());
			 oscDevice.addQxEventHandler(new IQxEventHandler() {
				
				@Override
				public void handleQxEvent(Event event) {
					if (event.getCmd() instanceof OscCmd) {
						 //handleCommand(((OscCmd)event.getCmd()).getMsg());
					}					
				}
				
				@Override
				public String getID() {
					return "osc";
				}
			});
		}

	}

	@Override
	public void subTypeForServiceTypeAdded(ServiceEvent event) {
		System.out.println("SUBTYPE: " + event.getType());
	}

	// @Override
	// public void valueChanged(ListSelectionEvent e)
	// {
	// if (!e.getValueIsAdjusting())
	// {
	// if (e.getSource() == typeList)
	// {
	// type = (String) typeList.getSelectedValue();
	// System.out.println("VALUE CHANGED: type: " + type);
	// registry.removeServiceListener(type, this);
	// services.setSize(0);
	// info.setText("");
	// if (type != null)
	// {
	// registry.addServiceListener(type, this);
	// }
	// }
	// else if (e.getSource() == serviceList)
	// {
	// String name = (String) serviceList.getSelectedValue();
	// System.out.println("VALUE CHANGED: type: " + type + " service: " + name);
	// if (name == null)
	// {
	// info.setText("");
	// }
	// else
	// {
	// ServiceInfo service = jmdns.getServiceInfo(type, name);
	// // This is actually redundant. getServiceInfo will force the resolution of
	// the service and call serviceResolved
	// this.dislayInfo(service);
	// }
	// }
	// }
	// }

	@SuppressWarnings("unused")
	private static void dislayInfo(ServiceInfo service) {
		System.out.println("INFO: " + service);
		if (service == null) {
			System.out.println("service not found");
		} else {
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

			for (Enumeration<String> names = service.getPropertyNames(); names.hasMoreElements();) {
				String prop = names.nextElement();
				buf.append(prop);
				buf.append('=');
				buf.append(service.getPropertyString(prop));
				buf.append('\n');
			}

			System.out.println(buf.toString());
		}
	}
}
