package com.codeme.homework4.beandanych;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetConfigValues {
	private String userName = null;
	private String pass = null;
	private String dbUrl = null;
	
	public GetConfigValues() {
		String filePath = ".//resources//config.properties"; 
		
		Properties appProps = new Properties();
		try {
			appProps.load(new FileInputStream(filePath));
		} catch (IOException e) {
			System.out.println("No properties file.");
			e.printStackTrace();
		}
		
		userName = appProps.getProperty("user");
		pass = appProps.getProperty("pass");
		dbUrl = appProps.getProperty("url");
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPass() {
		return pass;
	}
	
	public String getDbUrl() {
		return dbUrl;
	}
	

}
