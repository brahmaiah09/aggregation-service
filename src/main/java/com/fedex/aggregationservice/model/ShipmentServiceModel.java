package com.fedex.aggregationservice.model;

import java.util.List;
import java.util.Map;

public class ShipmentServiceModel {
	
	public Map<String, List<String>> shipments;

	public ShipmentServiceModel(Map<String, List<String>> shipments) {
		super();
		this.shipments = shipments;
	}

	public ShipmentServiceModel() {
	
	}

	public Map<String, List<String>> getShipments() {
		return shipments;
	}

	public void setShipments(Map<String, List<String>> shipments) {
		this.shipments = shipments;
	}
	
	
}
