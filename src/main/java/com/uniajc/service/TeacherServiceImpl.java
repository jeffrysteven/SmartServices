package com.uniajc.service;

import com.uniajc.dao.TeacherDAO;
import com.uniajc.model.Teacher;

public class TeacherServiceImpl implements TeacherInterface {

	@Override
	public Teacher getTeacherStatus(int id) {
		PersonServiceImpl pService = new PersonServiceImpl();
		TeacherDAO tDAO = new TeacherDAO();
		return tDAO.getTeacherStatus(pService.getPerson(id));
	}
}
