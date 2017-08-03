package com.uniajc.ws;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.uniajc.service.LocationServiceImpl;
import com.uniajc.service.PersonServiceImpl;
import com.uniajc.service.TeacherServiceImpl;
import com.uniajc.utils.JSONUtil;

/**
 * @author jlenis
 *
 */
public class SmartService {
	
	/**
	 * JSON Util Helper.
	 */
	private JSONUtil jsonUtil = JSONUtil.getInstance();
	
	/**
	 * @param id - Person document id.
	 * @return {String} Person object as JSON.
	 */
	public String getPersonData(String id) {
		return jsonUtil.objectToJSONResponse(new PersonServiceImpl().getPerson(id));
	}
	
	/**
	 * @param id - Person document id.
	 * @return {String} Teacher with contract status object as JSON.
	 */
	public String getTeacherStatus(String id) {
		return jsonUtil.objectToJSONResponse(new TeacherServiceImpl().getTeacher(id, false));
	}
	
	/**
	 * @param id - Person document id.
	 * * @return {String} Teacher with titles object as JSON.
	 */
	public String getTeacherTitles(String id) {
		return jsonUtil.objectToJSONResponse(new TeacherServiceImpl().getTeacher(id, true));
	}
	
	/**
	 * @param jsonAddressesArray - JSON address, city array Ex.[{"address": "123 North Street", "city": "Cali"}]
	 * @param place - UNIAJC place. Values are 0 - North, 1 - South.
	 * * @return {String} Distances and duration to UNIAJC South JSON object.
	 */
	public String getLocationDataTOUNIAJC(String jsonAddressesArray, int place) {
		try {
			JsonArray addressList = (JsonArray) new JsonParser().parse(jsonAddressesArray);
			return jsonUtil.objectToJSONResponse(
					new LocationServiceImpl()
					.getTravelDurationToUNIAJCFromList(addressList, place));
		} catch (Exception e) {
			return "Invalid input"; 
		}
	}
}
