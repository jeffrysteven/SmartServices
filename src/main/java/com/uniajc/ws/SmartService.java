package com.uniajc.ws;

import com.uniajc.service.PersonServiceImpl;
import com.uniajc.service.TeacherServiceImpl;
import com.uniajc.utils.Utils;

public class SmartService {
	
	public String getPersonData(String id) {
		return new Utils().objectToJSONResponse(new PersonServiceImpl().getPerson(id));
	}
	
	public String getTeacherStatus(String id) {
		return new Utils().objectToJSONResponse(new TeacherServiceImpl().getTeacher(id, false));
	}
	
	public String getTeacherTitles(String id) {
		return new Utils().objectToJSONResponse(new TeacherServiceImpl().getTeacher(id, true));
	}
}
