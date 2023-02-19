package com.fedex.aggregationservice.service;

import java.util.List;
import java.util.Map;

import com.fedex.aggregationservice.model.PriceServiceModel;

public interface PriceService {
	PriceServiceModel getPriceServiceDetails(List<String> country);

	Map<String, String> getPriceServiceList(List<String> countryList);
}
