package ubiquisense.iorx;

import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Injector;

import ubiquisense.iorx.registry.ConfigurationModule;
import ubiquisense.iorx.xp.QuanticMojo;

public abstract class GuiceInjectionTest {
	protected Injector injector;

	@Before
	public void init() {
		QuanticMojo no_access____qm = QuanticMojo.INSTANCE;
		injector = Guice.createInjector(new ConfigurationModule());
	}

}
