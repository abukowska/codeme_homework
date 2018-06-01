package com.codeme.homework4.beandanych;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class GetConfigValues {
	private String userName = null;
	private String pass = null;
	private String dbUrl = null;
	
	public void loadConfigValues() {
		String filePath = ".//resources//config.properties"; 
		Properties appProps = new Properties();
		
		try {
			appProps.load(new FileInputStream(filePath));
		} catch (IOException ioe) {
			System.out.println("Config file not found or file corrupted. Exiting the app.");
			System.exit(0);
		}
	
		userName = appProps.getProperty("user");
		pass = appProps.getProperty("pass");
		dbUrl = appProps.getProperty("url");
		
		Map<String, String> configValues = new HashMap<>();
		configValues.put("DB username", userName);
		configValues.put("DB password", pass);
		configValues.put("DB url", dbUrl);
		
		for(Entry<String, String> configValue : configValues.entrySet()) {
			if (configValue.getValue() == null) {
				System.out.println(configValue.getKey() + " config value not found. Exiting the app.");
				System.exit(0);
			}
		}
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
