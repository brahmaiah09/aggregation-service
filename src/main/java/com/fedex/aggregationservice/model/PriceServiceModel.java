package com.fedex.aggregationservice.model;

import java.util.Map;

public class PriceServiceModel {
	private Map<String, String> price;

	public PriceServiceModel() {
		super();
	}

	public PriceServiceModel(Map<String, String> price) {
		super();
		this.price = price;
	}

	public Map<String, String> getPrice() {
		return price;
	}

	public void setPrice(Map<String, String> price) {
		this.price = price;
	}
}
