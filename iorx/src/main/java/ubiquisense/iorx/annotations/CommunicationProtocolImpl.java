package ubiquisense.iorx.annotations;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.lang.annotation.Annotation;

public class CommunicationProtocolImpl implements CommunicationProtocol, Serializable {

		  private final String type;

		  public CommunicationProtocolImpl(String type) {
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
		    if (!(o instanceof CommunicationProtocol)) {
		      return false;
		    }

		    CommunicationProtocol other = (CommunicationProtocol) o;
		    return type.equals(other.type());
		  }

		  public String toString() {
		    return "@" + CommunicationProtocol.class.getName() + "(type=" + type + ")";
		  }

		  public Class<? extends Annotation> annotationType() {
		    return CommunicationProtocol.class;
		  }

		  private static final long serialVersionUID = 0;
}
