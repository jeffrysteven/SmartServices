package com.uniajc.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.uniajc.db.ConnectionDB;
import com.uniajc.model.Person;
import com.uniajc.model.Teacher;
import com.uniajc.model.Title;

public class TeacherDAO {
	
	public Teacher getTeacher(Person p, boolean includeStatus) {
		ConnectionDB conn = new ConnectionDB();
		try {
			conn.connect();
			ResultSet rs = conn.query("SELECT T.TRAB_ACTIVO,TL.TRLA_FECHAINICIAL,TL.TRLA_FECHAFINAL, "
					+ "TL.TIVD_ID FROM TRABAJADORLABOR TL, TRABAJADOR T WHERE TL.PEGE_ID = "+ p.getId() +" AND "
					+ "TL.LABO_ID = (SELECT L.LABO_ID FROM LABOR L WHERE L.LABO_ID = TL.LABO_ID "
					+ "AND L.LABO_DOCENTE = 1) AND TL.PEGE_ID = T.PEGE_ID");
			if(rs.next()){
				Teacher teacher = new Teacher(p, rs.getInt("TRAB_ACTIVO") != 0, rs.getString("TRLA_FECHAINICIAL"),
						rs.getString("TRLA_FECHAFINAL"), rs.getString("TIVD_ID"), includeStatus ? getTeacherTitles(p, conn) : null);
				
				return teacher;
			} else {
				return null;
			}
		} catch(Exception e){
			conn.disconnect();
			return null;
		}		
	}
	
	private ArrayList<Title> getTeacherTitles(Person person, ConnectionDB conn) {
		ArrayList<Title> titles= new ArrayList<Title>();
		try {
			ResultSet rs = conn.query("SELECT TG.TITU_DESCRIPCIONFEMENINA, TG.TITU_DESCRIPCIONMASCULINA,"
					+ "TPNG.TIPN_ESTABLECIMIENTO, TPNG.TIPN_FECHAOBTENCION "
					+ "FROM TITULOPERSONANATURALGENERAL TPNG, TITULOGENERAL TG "
					+ "WHERE TPNG.PEGE_ID = " + person.getId() + " AND TPNG.TITU_ID = TG.TITU_ID");
			while(rs.next()) {
				titles.add(new Title(person.getGenre() == "F" ? rs.getString("TITU_DESCRIPCIONFEMENINA")
						: rs.getString("TITU_DESCRIPCIONMASCULINA"), rs.getString("TIPN_FECHAOBTENCION"),
						rs.getString("TIPN_ESTABLECIMIENTO")));
			}
			return titles;
		}catch(Exception e){
			conn.disconnect();
			return null;
		}
	}
}
