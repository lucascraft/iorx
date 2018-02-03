package ubiquisense.iorx.qx.impl;

import ubiquisense.iorx.qx.Cmd;
import ubiquisense.iorx.qx.CmdPipe;
import ubiquisense.iorx.qx.CompoundCmd;
import ubiquisense.iorx.qx.Qx;
import ubiquisense.iorx.qx.Tx;
import ubiquisense.iorx.utils.CmdUtil;
import ubiquisense.iorx.utils.Platform;

public class QxMonitorJob implements Runnable {

	public static long DEFAULT_SPEED = 0;
	
    private final CmdPipe cmdEngine;
    private long processingSpeed;

    /**
     * Constructor w/ parameters
     * 
     * @param engine {@link CmdPipe} to consider
     */
    public QxMonitorJob(final CmdPipe engine, long speed) {
        this(engine);
        processingSpeed = speed;
    }
    
    /**
     * Constructor w/ parameters
     * 
     * @param engine {@link CmdPipe} to consider
     */
    public QxMonitorJob(CmdPipe engine) {
        cmdEngine = engine;
        cmdEngine.eAdapters().add(new QxEventAdapterImpl(this));
        processingSpeed = DEFAULT_SPEED;
    }
    
    private <Q extends Qx> void visitQxCmd(Q qx, Cmd cmd) {
        if (cmd instanceof CompoundCmd) {
        	for (Cmd c : ((CompoundCmd)cmd).getChildren()) {
        		visitQxCmd(qx, c);
        	}
        } else {
        	handleQxCmd(qx, cmd);
        }
    }
    
    private synchronized <Q extends Qx> void handleQxCmd(Q qx, Cmd cmd) {
    	if (cmdEngine.isActivated()) {
	        if (Platform.inDebugMode()) {
	        	System.out.println(
	        		"!!! " + 
	        			(qx instanceof Tx ? "Tx" : "Rx") + 
	        				" Cmd Consumed : " + CmdUtil.INSTANCE.getCmdInfo(cmd)
	        	);
	        }
    	}
    }
    
    /**
     * Getter for currently owned {@link CmdPipe}
     * 
     * @return owned {@link CmdPipe}
     */ 
    public CmdPipe getCmdEngine() {
        return cmdEngine;
    }

	@Override
	public void run() {
	    	if (cmdEngine.isActivated()) {
			    if (!cmdEngine.getTx().getCommands().isEmpty()) {
			        visitQxCmd(
			        	cmdEngine.getTx(), 
			        	cmdEngine.getTx().consumeCommand()
			        );
			    } 
			    if (!cmdEngine.getRx().getCommands().isEmpty()) {
			    	visitQxCmd(
			        	cmdEngine.getRx(), 
			        	cmdEngine.getRx().consumeCommand()
			        );
			    }
	    	}
//		    if (cmdEngine.getRx().getCommands().isEmpty() && cmdEngine.getTx().getCommands().isEmpty()) {
//		    } else {
//	//	       	if (processingSpeed <= 0) {
//		       		start();
//	//	       	} else {
//	//	       		start(processingSpeed);
//	//	       	}
//		    }
		
	}
    
    

}
