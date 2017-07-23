package com.uniajc.service;

import com.uniajc.model.Teacher;

public interface TeacherInterface {
	public Teacher getTeacher(String id, boolean includeStatus);
}
