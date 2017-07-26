package com.uniajc.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;

import com.uniajc.utils.LoggerUtil;

/**
 * @author jlenis
 *
 */
public class ConnectionDB {
	
	/**
	 * DB Hostname.
	 */
	private String hostname;
	
	/**
	 * DB port
	 */
	private String port;
	
	/**
	 * DB username.
	 */
	private String username;
	
	/**
	 * DB password.
	 */
	private String password;
	
	/**
	 * DB sid.
	 */
	private String sid;
	
	/**
	 * Connection to DB.
	 */
	private Connection connection;
	
	/**
	 * Logger Helper.
	 */
	private LoggerUtil logger = LoggerUtil.getInstance();
	
	/**
	 * Project properties.
	 */
	private Properties prop = new Properties();
	
	/**
	 * Project properties loader.
	 */
	private InputStream input = ConnectionDB.class.getClassLoader().getResourceAsStream("config.properties");

	/**
	 * Sets object attributes to database values.
	 */
	public ConnectionDB() {
		try {
			prop.load(input);
			this.hostname = prop.getProperty("hostname");
			this.port = prop.getProperty("port");
			this.username = prop.getProperty("dbuser");
			this.password = prop.getProperty("dbpassword");
			this.sid = prop.getProperty("sid");
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Exception occur", e);
		}
	}
	
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
	
	/**
	 * Connect to DB.
	 */
	public void connect(){
		String url = "jdbc:oracle:thin:@"+this.hostname+":"+this.port+":xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.connection = DriverManager.getConnection(url, this.username, this.password);
		} catch(Exception e) {
			logger.log(Level.SEVERE, "Connect DB exception", e);
			this.connection = null;
		}
	}
	
	
	/**
	 * @param {String} query
	 * @return {ResultSet} query result.
	 * @throws SQLException
	 */
	public ResultSet query(String query) throws SQLException
	{
		if(!this.isConnected())
			this.connect();
		Statement sm = this.connection.createStatement();
		return sm.executeQuery(query);
	}
	
	
	/**
	 * @return {boolean} validation if connection is already open.
	 */
	public boolean isConnected()
	{
		try {
			return this.connection != null && !this.connection.isClosed();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQL Exception", e);
			return false;
		}
	}
	
	/**
	 * Close DB Connection. 
	 */
	public void disconnect()
	{
		try {
			this.connection.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Connect DB exception", e);
			this.connection = null;
		}
		this.connection = null;
	}
}
