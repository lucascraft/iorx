package ubiquisense.iorx.io.impl;

import java.util.List;

import ubiquisense.iorx.io.AbstractQxEventHandler;
import ubiquisense.iorx.io.Channel;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.qx.Cmd;
import ubiquisense.iorx.qx.Event;

public class ChannelImpl implements Channel {


	protected List<IXCmdInterpreter> cmdInterpretrers;

	protected List<IXFrameInterpreter> frameInterpreters;

	protected List<AbstractQxEventHandler> eventListeners;

	protected static final byte[] LAST_FRAME_EDEFAULT = null;

	protected byte[] lastFrame = LAST_FRAME_EDEFAULT;


	public List<IXCmdInterpreter> getCmdInterpretrers() {
		return cmdInterpretrers;
	}

	public List<IXFrameInterpreter> getFrameInterpreters() {
		return frameInterpreters;
	}

	public List<AbstractQxEventHandler> getEventListeners() {
		return eventListeners;
	}

	public byte[] getLastFrame() {
		return lastFrame;
	}

	public void setLastFrame(byte[] newLastFrame) {
		lastFrame = newLastFrame;
	}

	public void send(byte[] bytes) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	public void receive(byte[] bytes) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	public boolean inputReady() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	public boolean outputReady() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	public boolean connected() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	public void close() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	public void debug() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	public void get(Event event) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	public void send(Cmd cmd) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	public void receive() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	public void addFrameListener(IXFrameInterpreter frameListener) {
		getFrameInterpreters().add(frameListener);
	}

	public void removeFrameListener(IXFrameInterpreter frameListener) {
		getFrameInterpreters().remove(frameListener);
	}

	public void addCmdListener(IXCmdInterpreter cmdListener) {
		getCmdInterpretrers().add(cmdListener);
	}

	public void removeCmdListener(IXCmdInterpreter cmdListener) {
		getCmdInterpretrers().remove(cmdListener);
	}

	public void addQxEventListener(AbstractQxEventHandler eventListener) {
		getEventListeners().add(eventListener);
	}

	public void removeQxEventListener(AbstractQxEventHandler eventListener) {
		getEventListeners().remove(eventListener);
	}

}
