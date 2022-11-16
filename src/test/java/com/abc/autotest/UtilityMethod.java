package com.abc.autotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UtilityMethod {
	public static Properties prop;
	
	public void loadProperties() {
		prop=new Properties(); //properties object has been created in method 
		try {
			prop.load(new FileInputStream("src/test/resources/config.properties"));
		} catch (FileNotFoundException e) {
			System.out.println("Config.properties file not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
