package com.uniajc.ws;

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
}
