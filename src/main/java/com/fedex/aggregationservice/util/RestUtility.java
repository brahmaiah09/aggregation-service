package com.fedex.aggregationservice.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class RestUtility {

	public static Object getRestResponse(String path, String param) {
		Object obj = null;
		try {
			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity responseEntity = restTemplate.getForEntity(path + param, Object.class);
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				obj = responseEntity.getBody();
			} else {
				return null;
			}
		} catch (HttpServerErrorException e) {
			System.out.println("Received 503 error");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return obj;
		}

	}
}
