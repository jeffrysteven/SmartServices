package com.uniajc.service;

import com.uniajc.dao.TeacherDAO;
import com.uniajc.model.Person;
import com.uniajc.model.Teacher;

public class TeacherServiceImpl implements TeacherInterface {

	@Override
	public Teacher getTeacher(String id, boolean includeStatus) {
		PersonServiceImpl pService = new PersonServiceImpl();
		TeacherDAO tDAO = new TeacherDAO();
		Person person = pService.getPerson(id);
		if(person != null) {
			return tDAO.getTeacher(person, includeStatus);
		} else {
			return null;
		}
	}
}
