package com.uniajc.wsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.uniajc.dao.PersonDAO;
import com.uniajc.db.ConnectionDB;
import com.uniajc.model.Person;
import com.uniajc.service.LocationServiceImpl;
import com.uniajc.utils.JSONUtil;

public class LocationServiceImplTest {
	
	ConnectionDB conn;
	JSONUtil jsonUtil = JSONUtil.getInstance();
	PersonDAO pDao;
	Person person;

	@Before
	public void setUp() throws Exception {
		conn = new ConnectionDB();
		pDao = new PersonDAO();
		person = pDao.getPersonData("1143841309");
	}

	@Test
	public void testGetTravelDurationToUNIAJC() {
		if(conn.connect()) {
			if(person != null) {
				assertTrue(new LocationServiceImpl().getTravelDurationToUNIAJC(
						person.getContact().getAddress() + ", " + person.getContact().getCity()) > 0);
			} else {
				fail("Person not found");
			}
		} else {
			fail("Database Connection failure");
		}
	}

}
