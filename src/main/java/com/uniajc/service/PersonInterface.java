package com.uniajc.service;

import com.uniajc.model.Person;

/**
 * @author jlenis
 *
 */
public interface PersonInterface {
	/**
	 * @param {String} id
	 * @return {Person} - person data
	 */
	public Person getPerson(String id);
}
