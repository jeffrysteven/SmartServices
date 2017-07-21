package com.uniajc.dao;

import java.sql.ResultSet;

import com.uniajc.db.ConnectionDB;
import com.uniajc.model.Person;

public class PersonDAO {

	public Person getPersonData(int id) {
		Person person = new Person();
		ConnectionDB conn = new ConnectionDB();
		try {
			conn.connect();
			ResultSet rs = conn.query("SELECT * FROM PERSONANATURALGENERAL WHERE PEGE_ID = "+id);
			if(rs.next()){
				person.setId(rs.getString("PEGE_ID"));
				person.setName(rs.getString("PENG_PRIMERAPELLIDO"));
			}
			return person;
		}catch(Exception e){
			e.printStackTrace();
			conn.disconnect();
			return null;
		}
	}
	
}
