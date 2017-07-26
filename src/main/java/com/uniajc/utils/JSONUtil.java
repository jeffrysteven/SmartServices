package com.uniajc.utils;

import com.google.gson.Gson;

/**
 * @author jlenis
 *
 */
public class JSONUtil {
	
	/**
	 * JSON Util singleton instance.
	 */
	public static final JSONUtil JSONUTILINSTANCE = new JSONUtil();
	
	
	/**
	 * @return Class Instance
	 */
	public static JSONUtil getInstance() {
		return JSONUTILINSTANCE;
	}
	
	
	/**
	 * @param {Object} o - transform any object to JSON. 
	 * @return {String} Object JSON stringified.
	 */
	public String objectToJSONResponse(Object o) {
		return new Gson().toJson(o);
	}
}
