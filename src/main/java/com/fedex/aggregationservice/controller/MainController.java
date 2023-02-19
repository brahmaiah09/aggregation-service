package com.fedex.aggregationservice.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fedex.aggregationservice.dto.AggregatedDataDTO;
import com.fedex.aggregationservice.service.PriceService;
import com.fedex.aggregationservice.service.ShipmentService;
import com.fedex.aggregationservice.service.TrackService;

@RestController
@RequestMapping("/")
public class MainController {

	@Autowired
	private ShipmentService shipmentService;
	@Autowired
	private TrackService trackService;
	@Autowired
	private PriceService priceService;

	@RequestMapping(value = "/aggregation", method = RequestMethod.GET)
	public ResponseEntity<?> getAggregationResponse(
			@RequestParam(value = "shipmentsOrderNumbers", required = false) Optional<String> shipmentsOrderNumbers,
			@RequestParam(value = "trackOrderNumbers", required = false) Optional<String> trackOrderNumbers,
			@RequestParam(value = "pricingCountryCodes", required = false) Optional<String> pricingCountryCodes) {

		AggregatedDataDTO response = getResponses(shipmentsOrderNumbers, trackOrderNumbers, pricingCountryCodes);
		return new ResponseEntity(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/shipment", method = RequestMethod.GET)
	public ResponseEntity<?> getShipmentResponse(
			@RequestParam(value = "shipmentsOrderNumbers", required = false) Optional<String> shipmentsOrderNumbers) {
		return new ResponseEntity<Object>(shipmentService.getShipmentServiceModel(
				shipmentsOrderNumbers.isPresent() ? Arrays.asList(shipmentsOrderNumbers.get().split(",")) : null),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/track", method = RequestMethod.GET)
	public ResponseEntity<?> getTrackResponse(
			@RequestParam(value = "trackOrderNumbers", required = false) Optional<String> trackOrderNumbers) {
		return new ResponseEntity<Object>(
				trackService.getTrackServiceDetails(
						trackOrderNumbers.isPresent() ? Arrays.asList(trackOrderNumbers.get().split(",")) : null),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/price", method = RequestMethod.GET)
	public ResponseEntity<?> getPriceResponse(
			@RequestParam(value = "pricingCountryCodes", required = false) Optional<String> pricingCountryCodes) {
		return new ResponseEntity<Object>(
				priceService.getPriceServiceDetails(
						pricingCountryCodes.isPresent() ? Arrays.asList(pricingCountryCodes.get().split(",")) : null),
				HttpStatus.OK);
	}

	private AggregatedDataDTO getResponses(Optional<String> shipmentsOrderNumbers, Optional<String> trackOrderNumbers,
			Optional<String> pricingCountryCodes) {
		List<String> shipmentOrders = shipmentsOrderNumbers.isPresent()
				? Arrays.asList(shipmentsOrderNumbers.get().split(","))
				: null;
		List<String> trackOrders = trackOrderNumbers.isPresent() ? Arrays.asList(trackOrderNumbers.get().split(","))
				: null;
		List<String> pricingCountry = pricingCountryCodes.isPresent()
				? Arrays.asList(pricingCountryCodes.get().split(","))
				: null;

		AggregatedDataDTO dto = new AggregatedDataDTO();
		Map<String, List<String>> shipments = shipmentOrders == null ? new HashMap()
				: shipmentService.getShipmentServiceList(shipmentOrders);
		Map<String, String> track = trackOrders == null ? new HashMap() : trackService.getTrackServiceList(trackOrders);
		Map<String, String> price = pricingCountry == null ? new HashMap()
				: priceService.getPriceServiceList(pricingCountry);

		return new AggregatedDataDTO(shipments, track, price);

	}
}
