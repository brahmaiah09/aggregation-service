package com.fedex.aggregationservice.service;

import java.util.List;
import java.util.Map;

import com.fedex.aggregationservice.model.ShipmentServiceModel;

public interface ShipmentService {

	ShipmentServiceModel getShipmentServiceModel(List<String> orderNumber);

	Map<String, List<String>> getShipmentServiceList(List<String> orderNumber);

}
