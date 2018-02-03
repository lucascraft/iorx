package ubiquisense.iorx.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.google.common.collect.Lists;

import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.CompoundCmd;
import ubiquisense.iorx.cmd.PRIORITY;
import ubiquisense.iorx.cmd.impl.CmdImpl;
import ubiquisense.iorx.cmd.impl.CompoundCmdImpl;
import ubiquisense.iorx.protocols.raw.ByteCmd;
import ubiquisense.iorx.protocols.raw.internal.ByteCmdImpl;

public final class CmdUtil implements ICmdUtil {
    private Random randomizer;
    /** PRIORITY pseudo randomization (Normal distribution like) */
    private static Map<PRIORITY, Float> cmdDistributionRatesByPiority;

    public static CmdUtil INSTANCE = new CmdUtil();
    
    
    public CmdUtil() {
        // Randomizer
        randomizer = new Random(100);
        
        /* PRIORITY pseudo randomization (Normal distribution like) */
        cmdDistributionRatesByPiority = new HashMap<PRIORITY, Float>();
        cmdDistributionRatesByPiority.put(PRIORITY.LOWEST, new Float(15.0f));
        cmdDistributionRatesByPiority.put(PRIORITY.LOW, new Float(20.0f));
        cmdDistributionRatesByPiority.put(PRIORITY.MEDIUM, new Float(30.0f));
        cmdDistributionRatesByPiority.put(PRIORITY.HIGH, new Float(20.0f));
        cmdDistributionRatesByPiority.put(PRIORITY.HIGHEST, new Float(15.0f));
	}
    
    public ByteCmd createByteCmd(byte[] message) {
    	ByteCmd msg = new ByteCmdImpl();
		msg.setMessage(message);
		stampCmd(msg);
		return msg;
    }
    
    /**
     * Basically stamp a {@link Cmd} with unique {@link UUID}, a canonical name and a random priority
     */
	public synchronized <T extends Cmd> T stampCmd(T cmd) {
        return stampCmd(cmd, getRandomPRIORITY());
	}
	
    /**
     * Basically stamp a {@link Cmd} with unique {@link UUID}, a canonical name and a random priority
     */
	public synchronized <T extends Cmd> T stampCmd(T cmd, PRIORITY priority) {
		if (cmd == null) return null;
        cmd.setPriority(priority);
        cmd.setStamp(System.currentTimeMillis());
        return cmd;
	}

	/**
	 * Generate basic random anonymous {@link XCmd}
	 */
	public synchronized Cmd generateRamdomCmd() {
    	Cmd cmd = new CmdImpl();
        cmd.setPriority(getRandomPRIORITY());
        cmd.setStamp(System.currentTimeMillis());
        return cmd;
    }
	
	/**
	 * Generate basic random anonymous {@link XCmd}
	 */
	public synchronized List<Cmd> generateRamdomCmd(int nb) {
		List<Cmd> comands = Lists.newArrayList();
		for (int i = 0; i<nb;i++)
		{
			comands.add(generateRamdomCmd());
		}
		return comands;
    }
//	
	/**
	 * Generate basic random anonymous {@link XCmd}
	 */
	public synchronized CompoundCmd createCompoundCmd() {
		CompoundCmd cmd = new CompoundCmdImpl();
        cmd.setPriority(PRIORITY.HIGH);
        cmd.setStamp(System.currentTimeMillis());
        return cmd;
    }
	
	/**
	 * Generate Random PRIORITY
	 */
    public synchronized PRIORITY getRandomPRIORITY() {
        int threshold = -1;
        int percentage = randomizer.nextInt(100);
        for (PRIORITY p : PRIORITY.VALUES) {
            threshold += cmdDistributionRatesByPiority.get(p).intValue();
            if (threshold >= percentage) {
                return p;
            }
        }
        return PRIORITY.LOWEST;
    }
    
    /**
     * Generate random int from seed
     */
    public synchronized int getSomeInt(int size) {
    	return randomizer.nextInt(size) % size;
    }
    
    /**
     * Dump {@link Cmd} info to system.out
     */
    public synchronized void dumpCmdInfo(Cmd c) {
        System.out.println(getCmdInfo(c));
    }
    
    /**
     * Get {@link Cmd} info
     */
    public synchronized String getCmdInfo(Cmd c) {
    	if (c == null) {
    		return "";
    	}
        return c.getClass().getName() + " with " + c.getPriority().getName() + " priority";
    }
    
    /**
     * Get frame info
     */
    public synchronized String getFrameInfo(byte[] frame) {
       	String textualized = "";
    	for (byte b : frame) {
    		textualized += "['" + Byte.toString(b) + "']";
    	}
    	return textualized;
    }
    
    /**
     * Get frame info
     */
    public synchronized String getFrameHexInfo(byte[] frame) {
    	if (frame != null && frame.length > 0) {
    		String textualized = "";
    		for (byte b : frame) {
    			textualized += "['" + valueOf(b) + "']";
    		}
    		return textualized;
    	}
    	return "";
    }
    
	
	public String valueOf(byte num) {
		String hex = Integer.toHexString((int) num & 0xFF);
		return "0x" + (hex.length() == 1 ? "0" : "") + hex;
	}

//    
//    public CmdPipeIO createCmdPipeIO(CmdPipe... pipes) {
//    	CmdPipeIO cmdPipeIO = new CmdPipeIO();
//    	cmdPipeIO.register(pipes);
//    	return cmdPipeIO;
//    }
}
