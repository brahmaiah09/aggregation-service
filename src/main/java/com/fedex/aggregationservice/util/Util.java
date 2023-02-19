package com.fedex.aggregationservice.util;

import java.util.ArrayList;

public class Util {

	public static ArrayList convertObjToList(Object obj) {
		if (obj != null) {
			return (ArrayList) obj;
		}
		return new ArrayList();
	}
}
