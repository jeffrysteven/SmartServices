package com.uniajc.dao;

import java.sql.ResultSet;
import java.util.logging.Level;

import com.uniajc.db.ConnectionDB;
import com.uniajc.model.ContactData;
import com.uniajc.model.Person;
import com.uniajc.utils.LoggerUtil;

/**
 * @author Jeffry Lenis
 *
 */
public class PersonDAO {
	
	/**
	 * Logger helper class
	 * 
	 */
	private LoggerUtil logger = LoggerUtil.getInstance();
	
	
	/**
	 * @param id - document number.
	 * @return {Person} Person Object
	 */
	public Person getPersonData(String id) {
		ConnectionDB conn = new ConnectionDB();
		try {
			conn.connect();
			ResultSet rs = conn.query("SELECT PG.PEGE_ID, PG.PEGE_DOCUMENTOIDENTIDAD,"
					+ "PN.PENG_PRIMERNOMBRE, PN.PENG_SEGUNDONOMBRE, PN.PENG_PRIMERAPELLIDO,"
					+ "PN.PENG_SEGUNDOAPELLIDO, PG.PEGE_DIRECCION, PG.PEGE_MAIL, PG.PEGE_TELEFONO,"
					+ "PG.PEGE_TELEFONOCELULAR, PN.PENG_FECHANACIMIENTO, EC.ESCG_DESCRIPCION,"
					+ "PN.PENG_SEXO, PN.PENG_RH, C.CIGE_NOMBRE "
					+ "FROM PERSONAGENERAL PG, PERSONANATURALGENERAL PN, ESTADOCIVILGENERAL EC,"
					+ "CIUDADGENERAL C "
					+ "WHERE PG.PEGE_DOCUMENTOIDENTIDAD = '"+id +"' AND PG.PEGE_ID = PN.PEGE_ID "
					+ "AND PN.ESCG_ID = EC.ESCG_ID AND PG.CIGE_IDRESIDENCIA = C.CIGE_ID");
			if(rs.next()){
				return new Person(rs.getInt("PEGE_ID"), rs.getString("PEGE_DOCUMENTOIDENTIDAD"),
						rs.getString("PENG_PRIMERNOMBRE") + " " + rs.getString("PENG_SEGUNDONOMBRE") + " " +
						rs.getString("PENG_PRIMERAPELLIDO") + " " + rs.getString("PENG_SEGUNDOAPELLIDO"),
						rs.getString("PENG_FECHANACIMIENTO"), rs.getString("PENG_SEXO"), 
						rs.getString("PENG_RH"), new ContactData(rs.getString("PEGE_DIRECCION"), rs.getString("PEGE_MAIL"),
						rs.getString("PEGE_TELEFONO"), rs.getString("PEGE_TELEFONOCELULAR"), rs.getString("CIGE_NOMBRE")));
			} else {
				return null;
			}
		}catch(Exception e){
			logger.log(Level.SEVERE, "Exception occur", e);
			conn.disconnect();
			return null;
		}
	}
	
}
