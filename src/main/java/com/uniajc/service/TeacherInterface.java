package com.uniajc.service;

import com.uniajc.model.Teacher;

/**
 * @author jlenis
 *
 */
public interface TeacherInterface {
	/**
	 * @param id - Person doc id
	 * @param includeStatus - flag to include contract status.
	 * @return {Teacher} - Teacher data.
	 */
	public Teacher getTeacher(String id, boolean includeStatus);
}
