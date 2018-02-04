/**
 */
package ubiquisense.iorx.protocols.ubiquino.dsl.impl;

import java.util.List;

import ubiquisense.iorx.protocols.ubiquino.dsl.PortSampler;

public class PortSamplerImpl implements PortSampler {

	protected List<Integer> samples;

	protected static final int SAMPLE_RATE_EDEFAULT = 0;

	protected int sampleRate = SAMPLE_RATE_EDEFAULT;

	protected static final long SIZE_EDEFAULT = 0L;

	protected long size = SIZE_EDEFAULT;


	public List<Integer> getSamples() {
		return samples;
	}

	public int getSampleRate() {
		return sampleRate;
	}

	public void setSampleRate(int newSampleRate) {
		sampleRate = newSampleRate;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long newSize) {
		size = newSize;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (samples: ");
		result.append(samples);
		result.append(", sampleRate: ");
		result.append(sampleRate);
		result.append(", size: ");
		result.append(size);
		result.append(')');
		return result.toString();
	}

} //PortSamplerImpl
