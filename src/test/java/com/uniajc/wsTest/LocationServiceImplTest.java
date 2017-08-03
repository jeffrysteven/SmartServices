package com.uniajc.wsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
		person = pDao.getPersonData("1143841308");
	}

	@Test
	public void testGetTravelDurationToUNIAJC() {
		if(conn.connect()) {
			if(person != null) {
				assertTrue(new LocationServiceImpl().getTravelDurationToUNIAJC(
						person.getContact().getAddress() + ", " + person.getContact().getCity()) != null);
			} else {
				fail("Person not found");
			}
		} else {
			fail("Database Connection failure");
		}
	}
	
	@Test
	public void testGetTravelDurationToUNIAJCFromList() {
		JsonArray addressesArr = new JsonArray();
		JsonObject address = new JsonObject();
		address.addProperty("address", "Carrera 1c 1 # 53 - 65");
		address.addProperty("city", "Cali");
		addressesArr.add(address);
		address = new JsonObject();
		address.addProperty("address", "Calle 13a #100-35");
		address.addProperty("city", "Cali");
		addressesArr.add(address);
		assertTrue(new LocationServiceImpl().getTravelDurationToUNIAJCFromList(addressesArr, 1).size() > 0);
	}

}
