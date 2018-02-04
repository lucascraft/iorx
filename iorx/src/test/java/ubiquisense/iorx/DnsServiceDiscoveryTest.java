package ubiquisense.iorx;

import org.junit.Test;

import ubiquisense.iorx.registry.DnsSdRegistry;

public class DnsServiceDiscoveryTest extends GuiceInjectionTest {
	
	
	@Test
	public void testServiceDiscovery()
	{
		DnsSdRegistry.INSTANCE.getRegistry().printServices();
	}
}
