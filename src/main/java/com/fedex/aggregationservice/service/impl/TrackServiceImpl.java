package com.fedex.aggregationservice.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fedex.aggregationservice.model.TrackServiceModel;
import com.fedex.aggregationservice.service.TrackService;
import com.fedex.aggregationservice.util.RestUtility;

@Service
public class TrackServiceImpl implements TrackService {

	private static String path = "http://127.0.0.1:4000/track-status?orderNumber=";

	@Override
	public TrackServiceModel getTrackServiceDetails(List<String> orderNumber) {
		TrackServiceModel trackServiceModel = new TrackServiceModel();
		trackServiceModel.setTrack(getTrackServiceList(orderNumber));
		return trackServiceModel;
	}

	@Override
	public Map<String, String> getTrackServiceList(List<String> orderNumber) {
		Map<String, String> trackMap = new HashMap();
		for (String order : orderNumber) {
			Object responseValue = RestUtility.getRestResponse(path, order);
			if (responseValue != null)
				trackMap.put(order, responseValue.toString());
		}
		return trackMap;
	}

}
