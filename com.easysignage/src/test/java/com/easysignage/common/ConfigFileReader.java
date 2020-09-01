package com.easysignage.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private static ConfigFileReader configReader;

	private ConfigFileReader() {
		BufferedReader reader;
		String propertyFilePath = GetPropertyFilePath();
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	private String GetPropertyFilePath() {

		return "configs//configuration.properties";

		// BufferedReader reader;
		// Properties versionProperties;
		//
		// String propertyFilePath = "configs//curentenvironment.properties";
		// try {
		// reader = new BufferedReader(new FileReader(propertyFilePath));
		// versionProperties = new Properties();
		// try {
		// versionProperties.load(reader);
		// reader.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// throw new RuntimeException("Configuration.properties not found at " +
		// propertyFilePath);
		// }
		//
		// String curentVer = versionProperties.getProperty("auth_tocken");
		//
		// return curentVer == "Regression" ? "configs//regression.properties" :
		// "configs//uat.properties";
	}

	public static ConfigFileReader getInstance() {
		if (configReader == null) {
			configReader = new ConfigFileReader();
		}
		return configReader;
	}

	public String getBaseUrl() {
		String baseUrl = properties.getProperty("websiteUrl");
		if (baseUrl != null)
			return baseUrl;
		else
			throw new RuntimeException("base_Url not specified in the Configuration.properties file.");
	}

	public String getUserName() {
		String userName = properties.getProperty("userName");
		if (userName != null)
			return userName;
		else
			throw new RuntimeException("userName not specified in the Configuration.properties file.");
	}

	public String getPassword() {
		String password = properties.getProperty("password");
		if (password != null)
			return password;
		else
			throw new RuntimeException("password not specified in the Configuration.properties file.");
	}

	public String getTestDataFileLocation() {
		String testDataFileLocation = properties.getProperty("testDataFileLocation");
		if (testDataFileLocation != null)
			return testDataFileLocation;
		else
			throw new RuntimeException("testDataFileLocation not specified in the Configuration.properties file.");
	}
	
	public String getReportConfigPath(){
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
}
