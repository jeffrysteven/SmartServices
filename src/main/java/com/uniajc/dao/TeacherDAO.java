package com.uniajc.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;

import com.uniajc.db.ConnectionDB;
import com.uniajc.model.Person;
import com.uniajc.model.Teacher;
import com.uniajc.model.Title;
import com.uniajc.utils.LoggerUtil;

/**
 * @author jlenis
 *
 */
public class TeacherDAO {
	
	
	/**
	 * Logger Helper.
	 */
	private LoggerUtil logger = LoggerUtil.getInstance();
	
	/**
	 * Connection to DB.
	 */
	private ConnectionDB conn = new ConnectionDB();
	
	
	/**
	 * @param {Person} p - Teacher associated person. 
	 * @param {boolean} includeStatus - flag to include contract status
	 * @return {Teacher} - Teacher object.
	 */
	public Teacher getTeacher(Person p, boolean includeStatus) {
		try {
			conn.connect();
			ResultSet rs = conn.query("SELECT T.TRAB_ACTIVO,TL.TRLA_FECHAINICIAL,TL.TRLA_FECHAFINAL, "
					+ "TL.TIVD_ID FROM TRABAJADORLABOR TL, TRABAJADOR T WHERE TL.PEGE_ID = "+ p.getId() +" AND "
					+ "TL.LABO_ID = (SELECT L.LABO_ID FROM LABOR L WHERE L.LABO_ID = TL.LABO_ID "
					+ "AND L.LABO_DOCENTE = 1) AND TL.PEGE_ID = T.PEGE_ID");
			if(rs.next()){
				return new Teacher(p, rs.getInt("TRAB_ACTIVO") != 0, rs.getString("TRLA_FECHAINICIAL"),
						rs.getString("TRLA_FECHAFINAL"), rs.getString("TIVD_ID"), includeStatus ? getTeacherTitles(p) : null);
			} else {
				return null;
			}
		} catch(Exception e){
			conn.disconnect();
			return null;
		}		
	}
	
	/**
	 * @param {Person} p - Teacher associated person.
	 * @return {ArrayList<Title>} - Teacher titles.
	 */
	private ArrayList<Title> getTeacherTitles(Person person) {
		ArrayList<Title> titles= new ArrayList<>();
		try {
			conn.connect();
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
			logger.log(Level.SEVERE, "Exception occur", e);
			conn.disconnect();
			return new ArrayList<>();
		}
	}
}
