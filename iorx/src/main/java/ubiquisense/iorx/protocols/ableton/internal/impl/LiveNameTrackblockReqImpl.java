package ubiquisense.iorx.protocols.ableton.internal.impl;

import java.util.List;

import com.google.common.collect.Lists;

import ubiquisense.iorx.protocols.ableton.internal.LiveNameTrackblockReq;

public class LiveNameTrackblockReqImpl extends AbletonLiveSndCmdImpl implements LiveNameTrackblockReq {
	int size;
	int trackID;
	List<String> trackNames;
	public LiveNameTrackblockReqImpl() {
		super();
		trackNames = Lists.newArrayList();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int newSize) {
		size = newSize;
	}

	@SuppressWarnings("unchecked")
	public List<String> getTrackName() {
		return trackNames;
	}

} //LiveNameTrackblockReqImpl
