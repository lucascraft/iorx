package ubiquisense.iorx.xp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public enum TRANSPORT_PROTOCOL
{
  USB(0, "USB", "usb://"),
  TCP(1, "TCP", "tcp://"),
  UDP(2, "UDP", "udp://"),
  HTTP(3, "HTTP", "http://"),
  BLUETOOTH(4, "BLUETOOTH", "bt://"),
  XBEE(5, "XBEE", "xbee://"),
  MIDI(6, "MIDI", "midi://");

  public static final int USB_VALUE = 0;

  public static final int TCP_VALUE = 1;

  public static final int UDP_VALUE = 2;

  public static final int HTTP_VALUE = 3;

  public static final int BLUETOOTH_VALUE = 4;

  public static final int XBEE_VALUE = 5;

  public static final int MIDI_VALUE = 6;

  private static final TRANSPORT_PROTOCOL[] VALUES_ARRAY =
    new TRANSPORT_PROTOCOL[]
    {
      USB,
      TCP,
      UDP,
      HTTP,
      BLUETOOTH,
      XBEE,
      MIDI,
    };

  public static final List<TRANSPORT_PROTOCOL> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  public static TRANSPORT_PROTOCOL get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      TRANSPORT_PROTOCOL result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  public static TRANSPORT_PROTOCOL getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      TRANSPORT_PROTOCOL result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  public static TRANSPORT_PROTOCOL get(int value)
  {
    switch (value)
    {
      case USB_VALUE: return USB;
      case TCP_VALUE: return TCP;
      case UDP_VALUE: return UDP;
      case HTTP_VALUE: return HTTP;
      case BLUETOOTH_VALUE: return BLUETOOTH;
      case XBEE_VALUE: return XBEE;
      case MIDI_VALUE: return MIDI;
    }
    return null;
  }

  private final int value;

  private final String name;

  private final String literal;

  private TRANSPORT_PROTOCOL(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  public int getValue()
  {
    return value;
  }

  public String getName()
  {
    return name;
  }

  public String getLiteral()
  {
    return literal;
  }

  @Override
  public String toString()
  {
    return literal;
  }
  
} //TRANSPORT_PROTOCOL
