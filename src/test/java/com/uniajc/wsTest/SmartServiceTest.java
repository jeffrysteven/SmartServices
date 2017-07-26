package com.uniajc.wsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.uniajc.ws.SmartService;

public class SmartServiceTest {
	
	SmartService smWS;
	
	@Before
	public void setUp() throws Exception {
		smWS = new SmartService();
	}

	@Test
	public void testGetPersonData() {
		System.out.println(smWS.getPersonData("1143841308"));
		assertNotEquals("null", smWS.getPersonData("1143841308"));
	}

	@Test
	public void testGetTeacherStatus() {
		assertNotEquals("null", smWS.getTeacherStatus("1143841308"));
		System.out.println(smWS.getTeacherStatus("1143841308"));
	}

	@Test
	public void testGetTeacherTitles() {
		assertNotEquals("null", smWS.getTeacherTitles("1143841308"));
		System.out.println(smWS.getTeacherTitles("1143841308"));
	}

}
