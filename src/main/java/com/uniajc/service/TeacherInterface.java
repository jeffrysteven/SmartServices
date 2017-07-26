package com.uniajc.service;

import com.uniajc.model.Teacher;

/**
 * @author jlenis
 *
 */
public interface TeacherInterface {
	/**
	 * @param {String} - Person doc id
	 * @param {Boolean} includeStatus - flag to include contract status.
	 * @return {Teacher} - Teacher data.
	 */
	public Teacher getTeacher(String id, boolean includeStatus);
}
