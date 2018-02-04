/**
 */
package ubiquisense.iorx.protocols.firmata.internal.dsl;


public interface FirmataPinStateResponse extends FirmataCmd {
	int getPin();

	void setPin(int value);

	int getModel();

	void setModel(int value);

	float getValue();

	void setValue(float value);

} // FirmataPinStateResponse
