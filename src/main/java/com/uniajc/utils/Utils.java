package com.uniajc.utils;

import com.google.gson.Gson;

public class Utils {

	public String objectToJSONResponse(Object o) {
		return new Gson().toJson(o);
	}
}
