package ubiquisense.iorx.io.impl;

import ubiquisense.iorx.io.Channel;
import ubiquisense.iorx.io.Port;

public class PortImpl implements Port {
	Channel channel;
	public Channel getChannel()
	{
		return channel;
	}
}
