package ubiquisense.iorx.annotations;

import com.google.inject.name.Named;

public class Binder {
	 /**
	   * Creates a {@link Named} annotation with {@code name} as the value.
	   */
	  public static CommunicationProtocol communication(String name) {
	    return new CommunicationProtocolImpl(name);
	  }
		
	  /**
	   * Creates a {@link Named} annotation with {@code name} as the value.
	   */
	  public static TransportProtocol transport(String name) {
	    return new TransportProtocolImpl(name);
	  }

}
