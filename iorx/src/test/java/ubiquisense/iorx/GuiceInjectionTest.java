package ubiquisense.iorx;

import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Injector;

public abstract class GuiceInjectionTest {
	protected Injector injector;

	@Before
	public void init() {
		injector = Guice.createInjector(new ConfigurationModule());
	}

}
