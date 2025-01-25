package com.orangehrm.app.utitlities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	public ReadConfig() {
		File src = new File("Configurations/config.properties");//Providing the efile location
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();//Creatin an object for properties
                       
			pro.load(fis);//Reading the data from properties file
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	//Method to read config file
	public String getFromConfingFile(String data) {
		String dataFromFile = pro.getProperty(data);//Get the property of data present in config properties file
		return dataFromFile;
	}

}
