package ubiquisense.iorx;

import com.google.inject.AbstractModule;

import ubiquisense.iorx.qx.ByteCmd;
import ubiquisense.iorx.qx.Cmd;
import ubiquisense.iorx.qx.CmdEngine;
import ubiquisense.iorx.qx.CmdPipe;
import ubiquisense.iorx.qx.EngineApplication;
import ubiquisense.iorx.qx.Event;
import ubiquisense.iorx.qx.Rx;
import ubiquisense.iorx.qx.Tx;
import ubiquisense.iorx.qx.impl.ByteCmdImpl;
import ubiquisense.iorx.qx.impl.CmdEngineImpl;
import ubiquisense.iorx.qx.impl.CmdImpl;
import ubiquisense.iorx.qx.impl.CmdPipeImpl;
import ubiquisense.iorx.qx.impl.EngineApplicationImpl;
import ubiquisense.iorx.qx.impl.EventImpl;
import ubiquisense.iorx.qx.impl.RxImpl;
import ubiquisense.iorx.qx.impl.TxImpl;

public class ConfigurationModule extends AbstractModule 
{
	@Override
	protected void configure() 
	{
		bind(CmdPipe.class).to(CmdPipeImpl.class);
		bind(Cmd.class).to(CmdImpl.class);
		bind(Rx.class).to(RxImpl.class);
		bind(Tx.class).to(TxImpl.class);
		bind(CmdEngine.class).to(CmdEngineImpl.class);
		bind(EngineApplication.class).to(EngineApplicationImpl.class);
		bind(Event.class).to(EventImpl.class);
		bind(ByteCmd.class).to(ByteCmdImpl.class);
	}
}