package org.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

public class JsonReader {

	public String getJsonData(String filePath, String locName) {
		JSONParser parser = new JSONParser();
		JSONObject jsonobj = null;
		try {
			jsonobj = (JSONObject) parser.parse(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String sub_jsonobj = (String) jsonobj.get(locName);
		return sub_jsonobj;

	}

	public By getJsonLocator(String filepath, String locator) {

		JSONParser parser = new JSONParser();
		PropertiesReader prop=new PropertiesReader();

		JSONObject jsonobj = null;
		By locator_value = null;
		try {
			jsonobj = (JSONObject) parser.parse(new FileReader(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONObject sub_jsonobj = (JSONObject) jsonobj.get(locator);
		String locat = (String) sub_jsonobj.get(prop.getValueByKey("Browser.Type"));

		String[] type = locat.split("=");
		String loctype = type[0];
		switch (loctype) {
		case "xpath":
			locator_value = By.xpath(type[1]);
			break;
		case "id":
			locator_value = By.id(type[1]);
			break;
		case "name":
			locator_value = By.name(type[1]);
			break;
		case "linkText":
			locator_value = By.linkText(type[1]);
			break;
		case "partialLinkText":
			locator_value = By.partialLinkText(type[1]);
			break;
		case "cssSelector":
			locator_value = By.cssSelector(type[1]);
			break;
		case "tagName":
			locator_value = By.tagName(type[1]);
			break;
		case "className":
			locator_value = By.className(type[1]);
			break;

		default:
			break;
		}

		return locator_value;
	}
}
