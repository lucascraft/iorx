package ubiquisense.iorx.replay;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import ubiquisense.iorx.Ubq;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.TRANSPORT_PROTOCOL;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.protocols.osc.internal.OscCmdUtils;
import ubiquisense.iorx.topology.ledger.XCPAddress;
import ubiquisense.iorx.topology.ledger.XCPAddressUtils;

public class TrafficPersister {

	private final static TrafficPersister INSTANCE = new TrafficPersister( Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:4444", new int[] {}, -1, null, true));
	
	public static void main(String[] args) {
		INSTANCE.setRecording(true);
		for (int i = 0; i<=1000; i++)
		{
			INSTANCE.getPipe().send(OscCmdUtils.INSTANCE.createOscCmd("/osc/test/message/pipe/message_" + i));
		}
//		INSTANCE.load();
	}
	public CmdPipe getPipe() {
		return pipe;
	}
	private CmdPipe pipe;
	
	class CmdBlockInfo
	{
		private byte[] cmdDump;
		private long timestamp;

		public CmdBlockInfo(long timestamp, byte[] cmdDump) {
			this.cmdDump = cmdDump;
			this.timestamp = timestamp;
		}
		
		public byte[] getCmdDump() {
			return cmdDump;
		}
		public void setCmdDump(byte[] cmdDump) {
			this.cmdDump = cmdDump;
		}
		public long getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}
	}
	
	Charset utf8 = Charset.forName("UTF-8");
	
	private Pattern BLOCK_START = Pattern.compile(new String("__start-block__".getBytes(), utf8));
	private Pattern BLOCK_END = Pattern.compile(new String("__end-block__".getBytes(), utf8));
	private Pattern TIME_SEPARATOR_START = Pattern.compile(new String("__start-timestamp__".getBytes(), utf8));
	private Pattern TIME_SEPARATOR_END = Pattern.compile(new String("__end-timestamp__".getBytes(), utf8));
	private Pattern CMD_SEPARATOR_START = Pattern.compile(new String("__start-cmd__".getBytes(), utf8));
	private Pattern CMD_SEPARATOR_END = Pattern.compile(new String("__end-cmd__".getBytes(), utf8));
	private Pattern CMD_HEADER_START = Pattern.compile(new String("__start-header__".getBytes(), utf8));
	private Pattern CMD_HEADER_END = Pattern.compile(new String("__end-header__".getBytes(), utf8));
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HH:mm:ss.SSS");
	private SimpleDateFormat filedateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
	private IQxEventHandler trafficListener;
	private FileOutputStream outputFileWriter;
	private XCPAddress addr;
	private boolean recording;
	private File replayFile;
	private byte[] bytes;
	private boolean play;
	private Clock clock;
	
	public IQxEventHandler getTrafficListener() {
		return trafficListener;
	}

	public void setTrafficListener(IQxEventHandler trafficListener) {
		this.trafficListener = trafficListener;
	}

	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

	public Clock getClock() {
		return clock;
	}

	public void setClock(Clock clock) {
		this.clock = clock;
	}

	public TreeMap<Long, CmdBlockInfo> getBlocks() {
		return blocks;
	}

	public void setBlocks(TreeMap<Long, CmdBlockInfo> blocks) {
		this.blocks = blocks;
	}

	private TreeMap<Long, CmdBlockInfo> blocks;
	
	public TrafficPersister(CmdPipe pipe) {
		this.pipe = pipe;
		blocks = new TreeMap<Long, TrafficPersister.CmdBlockInfo>();
		clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
		trafficListener = new IQxEventHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (isRecording())
				{
					recordEvent(event);
				}
			}
			@Override
			public String getID() {
				return pipe.getOutputInterpreter().getID();
			}
		};
		pipe.addQxEventHandler(trafficListener);
		addr = XCPAddressUtils.INSTANCE.createXCPAddress(pipe);
		try {
			String homePath = System.getenv("HOMEPATH");
			File iorxDir = new File(homePath +  "/iorx/");
			if (!iorxDir.exists())
			{
				iorxDir.mkdir();
			}
			replayFile = new File(homePath + "/iorx/" + addr.getPrimeName() + "_" + filedateFormat.format(new Date())+".replay");
			outputFileWriter = new FileOutputStream(replayFile);
			outputFileWriter.write(CMD_HEADER_START.pattern().getBytes(utf8));
			outputFileWriter.write(new String(dateFormat.format(new Date()).getBytes(), utf8).getBytes());
			outputFileWriter.write(CMD_HEADER_END.pattern().getBytes(utf8));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	public void load()
	{
		try {
	        bytes = new FileInputStream(replayFile).readAllBytes();
			
			List<MatchResult> headerStarts = new Scanner(replayFile).findAll(CMD_HEADER_START).collect(Collectors.toList());

			List<MatchResult> headerEnds = new Scanner(replayFile).findAll(CMD_HEADER_END).collect(Collectors.toList());

			assert(headerStarts != null);
			assert(headerEnds != null);
			
			assert(headerStarts.size() == headerEnds.size());
			assert(headerStarts.size() == 1);

			int timeStampBlockStart = headerStarts.get(0).end();
			int timeStampBlockEnd = headerEnds.get(0).start();
			
			int size = timeStampBlockEnd - timeStampBlockStart;
			byte[] timestamp = new byte[size];
			
			System.arraycopy(bytes, timeStampBlockStart, timestamp, 0, size);
			
			try {
				Clock.offset(clock, Duration.ofMillis(-(clock.millis() - dateFormat.parse(new String(timestamp, utf8)).getTime())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			List<MatchResult> starts = new Scanner(replayFile).findAll(BLOCK_START).collect(Collectors.toList());
			
			List<MatchResult> ends = new Scanner(replayFile).findAll(BLOCK_END).collect(Collectors.toList());
			
			assert(starts != null);
			assert(ends != null);
			assert(starts.size() == ends.size());
			
			System.out.println(starts.size());
			for (int i=0; i<ends.size(); i++)
			{
				int blockContentStart = starts.get(i).end();
				int blockContentEnd = ends.get(i).start();
				int blockSize = blockContentEnd - blockContentStart;
				byte[] block = new byte[blockSize];
				
				System.arraycopy(bytes, blockContentStart, block, 0, blockSize);

				System.out.println(new String(block, utf8));
				
				CmdBlockInfo blockInfo = processBlock(block);
				
				blocks.put(blockInfo.getTimestamp(), blockInfo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private CmdBlockInfo processBlock(byte[] block)
	{
		
		List<MatchResult> timeStarts = new Scanner(new ByteArrayInputStream(block)).findAll(TIME_SEPARATOR_START).collect(Collectors.toList());
		List<MatchResult> timeEnds = new Scanner(new ByteArrayInputStream(block)).findAll(TIME_SEPARATOR_END).collect(Collectors.toList());
		
		assert(timeStarts != null);
		assert(timeEnds != null);
		assert(timeStarts.size() == timeEnds.size());
		assert(timeStarts.size() == 1);
		
		List<MatchResult> cmdDumpStarts = new Scanner(new ByteArrayInputStream(block)).findAll(CMD_SEPARATOR_START).collect(Collectors.toList());
		List<MatchResult> cmdDumpEnds = new Scanner(new ByteArrayInputStream(block)).findAll(CMD_SEPARATOR_END).collect(Collectors.toList());
		
		assert(cmdDumpStarts != null);
		assert(cmdDumpEnds != null);
		assert(cmdDumpStarts.size() == cmdDumpEnds.size());
		assert(cmdDumpStarts.size() == 1);
		
		
		int timeStampBlockStart = timeStarts.get(0).end();
		int timeStampBlockEnd = timeEnds.get(0).start();

		byte[] timestamp = new byte[timeStampBlockEnd - timeStampBlockStart];
		
		System.arraycopy(block, timeStampBlockStart, timestamp, 0, timeStampBlockEnd - timeStampBlockStart);

		int cmdBlockStart = cmdDumpStarts.get(0).end();
		int cmdBlockEnd = cmdDumpEnds.get(0).start();

		byte[] cmdDump = new byte[cmdBlockEnd - cmdBlockStart];
		
		System.arraycopy(block, cmdBlockStart, cmdDump, 0, cmdBlockEnd - cmdBlockStart);

		try {
			return new CmdBlockInfo(dateFormat.parse(new String(timestamp, utf8)).getTime(), cmdDump);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	*/
	
	public synchronized void recordEvent(Event event)
	{
		Date now = new Date();
		try {
			outputFileWriter.write(BLOCK_START.pattern().getBytes(utf8));
			outputFileWriter.write(TIME_SEPARATOR_START.pattern().getBytes(utf8));
			outputFileWriter.write(dateFormat.format(now).getBytes(utf8));
			outputFileWriter.write(TIME_SEPARATOR_END.pattern().getBytes(utf8));
			outputFileWriter.write(CMD_SEPARATOR_START.pattern().getBytes(utf8));
			outputFileWriter.write(event.getCmd().getQx().getEngine().getOutputInterpreter().cmd2ByteArray(event.getCmd()));
			outputFileWriter.write(CMD_SEPARATOR_END.pattern().getBytes(utf8));
			outputFileWriter.write(BLOCK_END.pattern().getBytes(utf8));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public FileOutputStream getOutputFileWriter() {
		return outputFileWriter;
	}

	public void setOutputFileWriter(FileOutputStream outputFileWriter) {
		this.outputFileWriter = outputFileWriter;
	}

	public XCPAddress getAddr() {
		return addr;
	}

	public void setAddr(XCPAddress addr) {
		this.addr = addr;
	}

	public boolean isRecording() {
		return recording;
	}

	public void setRecording(boolean recording) {
		this.recording = recording;
	}
}
