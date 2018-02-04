/**
 */
package ubiquisense.iorx.protocols.ubiquino.dsl;

import java.util.List;


public interface PortSampler 
 {

	List<Integer> getSamples();

	
	int getSampleRate();

	
	void setSampleRate(int value);

	
	long getSize();

	
	void setSize(long value);

} // PortSampler
