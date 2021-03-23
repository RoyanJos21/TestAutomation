package org.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader extends BaseClass {
	public String getValueByKey(String keyName) {	
		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream(".\\src\\test\\resources\\locators\\config.properties");
			prop.load(input);
			prop.getProperty(keyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(keyName);
	}

}
