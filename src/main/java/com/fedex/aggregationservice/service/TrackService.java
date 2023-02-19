package com.fedex.aggregationservice.service;

import java.util.List;
import java.util.Map;

import com.fedex.aggregationservice.model.TrackServiceModel;

public interface TrackService {
	TrackServiceModel getTrackServiceDetails(List<String> orderNumber);

	Map<String, String> getTrackServiceList(List<String> orderNumber);
}
