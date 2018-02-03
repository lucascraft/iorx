package ubiquisense.iorx;

import org.junit.Test;

import ubiquisense.iorx.utils.DnsSdUtil;

public class DnsServiceDiscoveryTest extends GuiceInjectionTest {
	
	
	@Test
	public void testServiceDiscovery()
	{
		DnsSdUtil.INSTANCE.getRegistry().printServices();
	}
}
