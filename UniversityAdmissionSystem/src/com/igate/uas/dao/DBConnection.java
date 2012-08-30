package com.igate.uas.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.Loader;

import com.igate.uas.exception.UASException;

public class DBConnection {
	static Logger logger = Logger.getLogger(DBConnection.class);
	
	static DataSource dataSource = null;

	public static Connection getConnection() throws UASException {

		InitialContext ic;
		try {
			ic = new InitialContext();
			Object obj = ic.lookup("java:comp/env/jdbc/myoracle");
			if (obj instanceof DataSource)
				dataSource = (DataSource) obj;
			else
				throw new UASException("Unable to Cast");
			return dataSource.getConnection();
		} catch (NamingException e) {
			//throw new UASException(e.getMessage());
			return getDriverConnection();
			//throw new UASException("Can not Find DataSource");
		} catch (SQLException e) {
			return getDriverConnection();
			//throw new UASException(e.getMessage());
		}
	}
	
	@SuppressWarnings("unused")
	private static String driver;
	private static String driverType;
	private static String databaseUrl;
	private static String userName;
	private static String password;
	private static String networkProtocol;

	public static Connection getDriverConnection() throws UASException {

		OracleDataSource oracleDataSource = null;
		
		try {
			if (oracleDataSource == null) {
				loadPropertiesFile("oracleDatabase.properties");

				oracleDataSource = new OracleDataSource();
				oracleDataSource.setDriverType(driverType);
				oracleDataSource.setNetworkProtocol(networkProtocol);
				oracleDataSource.setURL(databaseUrl);
				oracleDataSource.setUser(userName);
				oracleDataSource.setPassword(password);
			}
			Connection connection = oracleDataSource.getConnection();
			logger.info("Database Driver Connection Made");
			return connection;
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Connection Could not Be Made");
		}
	}

	
	private static void loadPropertiesFile(String fileName)
			throws UASException {

		Properties databaseProperties = new Properties();
		try {
			
			URL propertiesURL = Loader.getResource(fileName);
			databaseProperties.load(propertiesURL.openStream());

			driver = databaseProperties.getProperty("driver");
			databaseUrl = databaseProperties.getProperty("databaseurl");
			userName = databaseProperties.getProperty("username");
			password = databaseProperties.getProperty("password");
			driverType = databaseProperties.getProperty("driverType");
			networkProtocol = databaseProperties.getProperty("networkprotocol");

			logger.info("Properties Read");
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			throw new UASException("Properties File Not Found");
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new UASException("Properties File Not Accessible");
		}

	}
	
}
