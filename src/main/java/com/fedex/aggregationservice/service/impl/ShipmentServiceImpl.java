package com.fedex.aggregationservice.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fedex.aggregationservice.model.ShipmentServiceModel;
import com.fedex.aggregationservice.service.ShipmentService;
import com.fedex.aggregationservice.util.RestUtility;
import com.fedex.aggregationservice.util.Util;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	private static String path = "http://127.0.0.1:4000/shipment-products?orderNumber=";

	@Override
	public ShipmentServiceModel getShipmentServiceModel(List<String> orderNumber) {
		ShipmentServiceModel shipmentServiceModel = new ShipmentServiceModel();
		shipmentServiceModel.setShipments(getShipmentServiceList(orderNumber));
		return shipmentServiceModel;
	}

	@Override
	public Map<String, List<String>> getShipmentServiceList(List<String> orderNumber) {

		Map<String, List<String>> dataMap = new HashMap();
		for (String order : orderNumber) {
			Object responseValue = RestUtility.getRestResponse(path, order);
			if (responseValue != null)
				dataMap.put(order, Util.convertObjToList(responseValue));
		}
		return dataMap;

	}
}
