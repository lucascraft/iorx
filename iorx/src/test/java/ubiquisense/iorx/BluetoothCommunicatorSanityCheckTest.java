package ubiquisense.iorx;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;

import org.junit.Before;
import org.junit.Test;

import com.intel.bluetooth.DebugLog;

import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.utils.Platform;

public class BluetoothCommunicatorSanityCheckTest {

	int counter = 0;
	Timer timer;
	Thread t;

	@Before
	public void setSystemProperties() {
		Platform.disableDebugMode();
		System.getProperties().put("bluecove.native.path", "../../../../libs/natives/win32/x86_64/");
	}

	public static boolean isTestAddress(String bluetoothAddress) {
		// Only one device during development tests
		if (false) {
			// return bluetoothAddress.equalsIgnoreCase("0019639c4007");
			// return bluetoothAddress.equalsIgnoreCase("00123755ae71");
		}
		return true;
	}

	//@Test
	public void testBluetootPipe() {
		CmdPipe udpOscIoPipe = Ubq.Reactor.createPipe("bt://", "osc", "osc_pipe_bt_1", "127.0.0.0:1234",
				new int[] { }, -1, new HashMap<Object, Object>(), false);

		assertNotNull(udpOscIoPipe);
		assertNotNull(udpOscIoPipe.getAddr());
		assertNotNull(udpOscIoPipe.getPort());
		assertNotNull(udpOscIoPipe.getPorts());
	}

	@Test
	public void testBluetootLibraryLoad() {
		// create timer task to increment counter
		discoveryBluetooth();
	}

	private void discoveryBluetooth() {

		LocalDevice l;
		try {
			l = LocalDevice.getLocalDevice();
		} catch (BluetoothStateException e) {
			System.err.println("Cannot get local device: " + e);
			return;
		}

		System.out.println("Local btaddr is " + l.getBluetoothAddress());
		System.out.println("Local name is " + l.getFriendlyName());

		String bluecoveVersion = LocalDevice.getProperty("bluecove");

		assertNotNull(bluecoveVersion);

		System.out.println("bluecove:" + bluecoveVersion);
		System.out.println("stack:" + LocalDevice.getProperty("bluecove.stack"));
		System.out.println("stack version:" + LocalDevice.getProperty("bluecove.stack.version"));
		System.out.println("radio manufacturer:" + LocalDevice.getProperty("bluecove.radio.manufacturer"));
		System.out.println("radio version:" + LocalDevice.getProperty("bluecove.radio.version"));

		BluetoothInquirer bi = new BluetoothInquirer();

		System.out.println("Starting inquiry");

		if (!bi.startInquiry()) {
			System.out.println("Cannot start inquiry, Exit ...");
			return;
		}
		while (bi.inquiring) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}

		System.out.println("Testing getFriendlyName");
		for (Iterator i = bi.devices.iterator(); i.hasNext();) {
			RemoteDevice btDevice = (RemoteDevice) i.next();
			try {
				System.out.println("Found " + btDevice.getBluetoothAddress() + " : " + btDevice.getFriendlyName(true));
				
//				CmdPipe udpOscIoPipe = Ubq.Reactor.createPipe("bt://", "osc", "osc_pipe_bt_1", btDevice.getBluetoothAddress(),
//						new int[] { }, -1, new HashMap<Object, Object>(), false);
//
//				assertNotNull(udpOscIoPipe);
//				assertNotNull(udpOscIoPipe.getAddr());
//				assertNotNull(udpOscIoPipe.getPort());
//				assertNotNull(udpOscIoPipe.getPorts());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static class BluetoothInquirer implements DiscoveryListener {

		boolean inquiring;

		List devices;

		public boolean startInquiry() {
			inquiring = false;
			devices = new Vector();
			try {
				inquiring = LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, this);
			} catch (BluetoothStateException e) {
				System.err.println("Cannot start inquiry: " + e);
				return false;
			}
			return inquiring;
		}

		public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
			DebugLog.debug("deviceDiscovered");
			devices.add(btDevice);
			StringBuffer name;
			try {
				DebugLog.debug("call getFriendlyName");
				name = new StringBuffer(btDevice.getFriendlyName(false));
			} catch (IOException ioe) {
				ioe.printStackTrace();
				name = new StringBuffer();
			}
			while (name.length() < 20)
				name.append(' ');
			System.out.println("Found " + btDevice.getBluetoothAddress() + " : " + name + " : " + cod);
		}

		public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
		}

		public void serviceSearchCompleted(int transID, int respCode) {
		}

		public void inquiryCompleted(int discType) {
			inquiring = false;
		}

	}

}
