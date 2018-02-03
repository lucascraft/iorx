package ubiquisense.iorx;

import java.util.HashMap;

import com.google.inject.Guice;
import com.google.inject.Injector;

import ubiquisense.iorx.cmd.CmdPipe;

public class App 
{
    public static void main( String[] args )
    {

		CmdPipe udpOscIoPipe = QuanticMojo.INSTANCE.createPipe("udp://", "osc", "osc_pipe_1", "127.0.0.0:1234", new int[] {9056}, -1, new HashMap<Object, Object>(), false);
	
		while(!QuanticMojo.INSTANCE.getPipes().isEmpty());
    }
}
