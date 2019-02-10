<img src="https://github.com/lucascraft/iorx/blob/master/iorx.png"/>

# iorx 

Mutli protocol communication hub

Windows  (osc/dmx/midi) / Raspberry (osc/dmx) over udp/tcp/us)

On raspberry install rxtx first :

$ sudo apt-get install librxtx-java

connect a USB DMX comm (Enttec DMX USB Pro Interface in my case).

Update DmxAppTest.java with correct usb port and led channels.

mvn clean test -P Raspberry -test=DmxAppTest 

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
