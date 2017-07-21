package com.uniajc.dao;

import java.sql.ResultSet;

import com.uniajc.db.ConnectionDB;
import com.uniajc.model.Person;
import com.uniajc.model.Teacher;

public class TeacherDAO {
	
	public Teacher getTeacherStatus(Person p) {
		Teacher teacher = new Teacher();
		ConnectionDB conn = new ConnectionDB();
		try {
			conn.connect();
			ResultSet rs = conn.query("SELECT * FROM TRABAJADOR WHERE PEGE_ID = " + p.getId());
			if(rs.next()){
				teacher.setPerson(p);
				teacher.setStatus(rs.getString("TRAB_ACTIVO"));
			}
			return teacher;
		}catch(Exception e){
			e.printStackTrace();
			conn.disconnect();
			return null;
		}		
	}
}
