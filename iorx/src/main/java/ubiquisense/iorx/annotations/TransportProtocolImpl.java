package ubiquisense.iorx.annotations;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.lang.annotation.Annotation;

public class TransportProtocolImpl implements TransportProtocol, Serializable {

		  private final String type;

		  public TransportProtocolImpl(String type) {
		    this.type = checkNotNull(type, "name");
		  }

		  public String type() {
		    return this.type;
		  }

		  public int hashCode() {
		    // This is specified in java.lang.Annotation.
		    return (127 * "type".hashCode()) ^ type.hashCode();
		  }

		  public boolean equals(Object o) {
		    if (!(o instanceof TransportProtocol)) {
		      return false;
		    }

		    TransportProtocol other = (TransportProtocol) o;
		    return type.equals(other.type());
		  }

		  public String toString() {
		    return "@" + TransportProtocol.class.getName() + "(type=" + type + ")";
		  }

		  public Class<? extends Annotation> annotationType() {
		    return TransportProtocol.class;
		  }

		  private static final long serialVersionUID = 0;
}
