package com.uniajc.wsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.uniajc.dao.TeacherDAO;
import com.uniajc.model.ContactData;
import com.uniajc.model.Person;
import com.uniajc.model.Teacher;
import com.uniajc.utils.JSONUtil;

public class TeacherDAOTest {
	
	JSONUtil jsonUtil = JSONUtil.getInstance();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetTeacherStatus() {
		ContactData c = new ContactData("Carrera 1c1 # 53 - 65", "jeffreyleji@gmail.com", "3864359", "3186908757", "Cali");
		Person p = new Person(1, "1143841308", "Jeffry Steven Lenis Jimenez", "1992-02-07 00:00:00.0", "M", "O+", c);
		Teacher t = new Teacher(p, true, "2016-07-20 00:00:00.0", null, "2", null);
		assertEquals(jsonUtil.objectToJSONResponse(t), jsonUtil.objectToJSONResponse(new TeacherDAO().getTeacher(p, false)));
	}
	
	@Test
	public void testGetTeacherTitles() {
		ContactData c = new ContactData("Carrera 1c1 # 53 - 65", "jeffreyleji@gmail.com", "3864359", "3186908757", "Cali");
		Person p = new Person(1, "1143841308", "Jeffry Steven Lenis Jimenez", "1992-02-07 00:00:00.0", "M", "O+", c);
		Teacher t = new Teacher(p, true, "2016-07-20 00:00:00.0", null, "2", null);
		assertEquals(jsonUtil.objectToJSONResponse(t), jsonUtil.objectToJSONResponse(new TeacherDAO().getTeacher(p, false)));
	}

}
