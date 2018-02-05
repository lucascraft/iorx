package ubiquisense.iorx.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Connectible {
	String value();
	TransportProtocol transport();
	CommunicationProtocol communication();
}
