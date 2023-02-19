package com.fedex.aggregationservice.dto;

import java.util.List;
import java.util.Map;

public class AggregatedDataDTO {
	private Map<String, List<String>> shipments;
	private Map<String, String> track;
	private Map<String, String> price;

	public AggregatedDataDTO() {
		super();
	}

	public AggregatedDataDTO(Map<String, List<String>> shipments, Map<String, String> track,
			Map<String, String> price) {
		super();
		this.shipments = shipments;
		this.track = track;
		this.price = price;
	}

	public Map<String, List<String>> getShipments() {
		return shipments;
	}

	public void setShipments(Map<String, List<String>> shipments) {
		this.shipments = shipments;
	}

	public Map<String, String> getTrack() {
		return track;
	}

	public void setTrack(Map<String, String> track) {
		this.track = track;
	}

	public Map<String, String> getPrice() {
		return price;
	}

	public void setPrice(Map<String, String> price) {
		this.price = price;
	}

}
