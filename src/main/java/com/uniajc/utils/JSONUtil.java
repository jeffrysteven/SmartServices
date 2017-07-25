package com.uniajc.utils;

import com.google.gson.Gson;

public class JSONUtil {
	
	public static final JSONUtil JSONUTILINSTANCE = new JSONUtil();
	
	public static JSONUtil getInstance() {
		return JSONUTILINSTANCE;
	}
	
	public String objectToJSONResponse(Object o) {
		return new Gson().toJson(o);
	}
}
