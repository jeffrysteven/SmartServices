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

public class ConnectionDB {
	
	private String hostname;
	private String port;
	private String username;
	private String password;
	private String sid;
	
	private Connection connection;
	private LoggerUtil logger = LoggerUtil.getInstance();
	private Properties prop = new Properties();
	private InputStream input = ConnectionDB.class.getClassLoader().getResourceAsStream("config.properties");

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

	public ConnectionDB(String hostname, String port, String username, String password, Connection connection, String sid) {
		super();
		this.hostname = hostname;
		this.port = port;
		this.username = username;
		this.password = password;
		this.connection = connection;
		this.sid = sid;
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
	
	public ResultSet query(String query) throws SQLException
	{
		if(!this.isConnected())
			this.connect();
		Statement sm = this.connection.createStatement();
		return sm.executeQuery(query);
	}
	
	public boolean isConnected()
	{
		try {
			return this.connection != null && !this.connection.isClosed();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQL Exception", e);
			return false;
		}
	}
	
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
