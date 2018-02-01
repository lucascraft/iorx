package ubiquisense.iorx;

import com.google.inject.Guice;
import com.google.inject.Injector;

import ubiquisense.iorx.qx.CmdPipe;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		Injector injector = Guice.createInjector(new ConfigurationModule());

		CmdPipe pipe = injector.getInstance(CmdPipe.class);
	
    }
}
