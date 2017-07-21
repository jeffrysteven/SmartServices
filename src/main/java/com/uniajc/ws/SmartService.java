package com.uniajc.ws;

import com.uniajc.model.Person;
import com.uniajc.model.Teacher;
import com.uniajc.service.PersonServiceImpl;
import com.uniajc.service.TeacherServiceImpl;

public class SmartService {
	
	public Person getPersonData(int id) {
		return new PersonServiceImpl().getPerson(id);
	}
	
	public Teacher getTeacherStatus(int id) {
		return new TeacherServiceImpl().getTeacherStatus(id);
	}
	
}
