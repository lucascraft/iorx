
package ubiquisense.iorx.comm.usb.io;

public interface ISerialParams {
	public int getBaudRate();
	public int getParity();
	public int getDataBits();
	public int getStopBits();
}
