package com.uniajc.wsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.uniajc.dao.PersonDAO;
import com.uniajc.model.ContactData;
import com.uniajc.model.Person;
import com.uniajc.utils.JSONUtil;

public class PersonDAOTest {
	
	PersonDAO pDao;
	
	@Before
	public void setUp() throws Exception {
		pDao = new PersonDAO();
	}

	@Test
	public void testGetPersonData() {
		
		ContactData c = new ContactData("Carrera 1c1 # 53 - 65", "jeffreyleji@gmail.com", "3864359", "3186908757", "Cali");
		Person p = new Person(1, "1143841308", "Jeffry Steven Lenis Jimenez", "1992-02-07 00:00:00.0", "M", "O+", c);
		assertEquals(JSONUtil.getInstance().objectToJSONResponse(p), JSONUtil.getInstance().objectToJSONResponse(pDao.getPersonData("1143841308")));
	}

}
