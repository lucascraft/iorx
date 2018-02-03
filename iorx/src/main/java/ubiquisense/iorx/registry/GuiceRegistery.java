package ubiquisense.iorx.registry;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceRegistery {
	protected Injector injector;

	public GuiceRegistery() {
		injector = Guice.createInjector(new ConfigurationModule());
	}
	
	public Injector getInjector() {
		return injector;
	}
}
