package com.fedex.aggregationservice.model;

import java.util.Map;

public class TrackServiceModel {
	private Map<String, String> track;

	public TrackServiceModel() {
		super();
	}

	public TrackServiceModel(Map<String, String> track) {
		super();
		this.track = track;
	}

	public Map<String, String> getTrack() {
		return track;
	}

	public void setTrack(Map<String, String> track) {
		this.track = track;
	}
}
