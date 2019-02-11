<img src="https://github.com/lucascraft/iorx/blob/master/iorx.png"/>

# iorx 

Mutli protocol communication hub

Windows  (osc/dmx/midi) / Raspberry (osc/dmx) over udp/tcp/us)

On raspberry install rxtx first :

$ sudo apt-get install librxtx-java

connect a USB DMX comm (Enttec DMX USB Pro Interface in my case).

Update DmxAppTest.java with correct usb port and led channels.

mvn clean test -P Raspberry -test=DmxAppTest 



	@Test
	public void testDmxFadeToRaimbowOnChannel064Step100()
	{
		String port = "/dev/ttyUSB0";
		
		Ubq mojo = new Ubq();
	
		CmdPipe dmxUsbCom4 = mojo.openUsbPipe("dmx", "dmxMood1", port, 115200);
		
		for (int n=0;n<10;n+=1)
		{
			for (int i=0;i<255;i+=3)
			{
				List<OpenDMXCmd> stack = Lists.newArrayList();
				for (int c=0;c<450;c+=3)
				{
					stack.add(OpenDmxCmdUtils.INSTANCE.createFadeBRG(c+64, i, (c+255-i)%255, (2*i)%255));
				}				
				
				dmxUsbCom4.send(new ByteCmdImpl(OpenDmxCmdUtils.INSTANCE.dumpOpenDMXCmd(stack)));
				
				try {
					Thread.sleep(10l);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}


# iorx.ui

RX IO queues and multitouch UI

Multitouch OSC UI alpha demo :

https://github.com/lucascraft/iorx/blob/master/iorx.ui-0.0.1-SNAPSHOT-with-dependencies.zip

Mouse and/or multitouch OSC controller aiming at manipulating nodes and connections in a graph like organization.

Each event (move, add, remove, connect, disconnect) emits OSC messages to port 4447

A chuck file is provided for additive frequency synthesis demo

It is mandatory to download chuck VM and/or editor separatly in order to get the demo working :

http://audicle.cs.princeton.edu/mini/

To proceed :

1) unzip the iorx.ui-0.0.1-SNAPSHOT-with-dependencies.zip archive
2) execute launch.bat
3) open fmurfOsc.ck into miniAudicle editor
3) Launch chuck VM
4) Add Shred to VM (Plus button)
5) play
6) hack
7) goto (5) : until statified or fail : goto youtube 


<img src="demo-multtouch-iorx-ui.png"/>
