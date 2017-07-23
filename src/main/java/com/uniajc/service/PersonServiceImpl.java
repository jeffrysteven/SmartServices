package com.uniajc.service;

import com.uniajc.dao.PersonDAO;
import com.uniajc.model.Person;

public class PersonServiceImpl implements PersonInterface{

	@Override
	public Person getPerson(String id) {
		PersonDAO personDAO = new PersonDAO();
		return personDAO.getPersonData(id);
	}
	
}
