package com.fedex.aggregationservice.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fedex.aggregationservice.model.PriceServiceModel;
import com.fedex.aggregationservice.service.PriceService;
import com.fedex.aggregationservice.util.RestUtility;

@Service
public class PriceServiceImpl implements PriceService {

	private static String path = "http://127.0.0.1:4000/pricing?countryCode=";

	@Override
	public PriceServiceModel getPriceServiceDetails(List<String> countryList) {
		PriceServiceModel priceServiceModel = new PriceServiceModel();
		priceServiceModel.setPrice(getPriceServiceList(countryList));
		return priceServiceModel;
	}

	@Override
	public Map<String, String> getPriceServiceList(List<String> countryList) {
		Map<String, String> priceMap = new HashMap();
		for (String country : countryList) {
			Object responseValue = RestUtility.getRestResponse(path, country);
			if (responseValue != null)
				priceMap.put(country, responseValue.toString());
		}
		return priceMap;
	}

}
