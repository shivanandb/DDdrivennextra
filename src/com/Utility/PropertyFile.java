package com.Utility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	//public static WebDriver driver;
	public static String plt;
	public Properties properties;
	private final static String propertyFilePath = "C:\\Users\\shivanandbhad.padiy\\eclipse-workspace\\PracticeJ\\Config.properties";
	
	
	 public static String loadData(String Key) {
	        //Declare a properties object
	        Properties prop = new Properties();
	 
	        //Read configuration.properties file
	        try {
	            prop.load(new FileInputStream(propertyFilePath));
	            //prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
	        } catch (IOException e) {
	            System.out.println("Configuration properties file cannot be found");
	        }
	        
	        plt = prop.getProperty(Key);
	        
	       // System.out.println(plt);
			return plt;
	 }

}