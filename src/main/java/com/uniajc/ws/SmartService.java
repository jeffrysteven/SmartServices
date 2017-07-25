package com.uniajc.ws;

import com.uniajc.service.PersonServiceImpl;
import com.uniajc.service.TeacherServiceImpl;
import com.uniajc.utils.JSONUtil;

public class SmartService {
	
	private JSONUtil jsonUtil = JSONUtil.getInstance();
	
	public String getPersonData(String id) {
		return jsonUtil.objectToJSONResponse(new PersonServiceImpl().getPerson(id));
	}
	
	public String getTeacherStatus(String id) {
		return jsonUtil.objectToJSONResponse(new TeacherServiceImpl().getTeacher(id, false));
	}
	
	public String getTeacherTitles(String id) {
		return jsonUtil.objectToJSONResponse(new TeacherServiceImpl().getTeacher(id, true));
	}
}
