package ubiquisense.iorx.protocols.firmata.internal.model.impl;

import ubiquisense.iorx.protocols.firmata.internal.dsl.FirmataPinStateResponse;

public class FirmataPinStateResponseImpl extends FirmataCmdImpl implements FirmataPinStateResponse {

	int pin, model;
	float value;

	public int getPin() {
		return pin;
	}

	public void setPin(int newPin) {
		pin = newPin;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int newModel) {
		model = newModel;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float newValue) {
		value = newValue;
	}

} //FirmataPinStateResponseImpl
