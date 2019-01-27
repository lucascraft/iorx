package ubiquisense.iorx;

import org.junit.After;
import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Injector;

import ubiquisense.iorx.registry.ConfigurationModule;

public abstract class GuiceInjectionTest {
	protected Injector injector;

	@Before
	public void init() {
		Ubq no_access____qm = Ubq.Reactor;
		injector = Guice.createInjector(new ConfigurationModule());
	}
	
	
	@After
	public void after()
	{
		Ubq.Reactor.closeAll();
		Ubq.Reactor.terminate();
	}


}
