package org.adactin;

import org.util.BaseClass;
import org.util.JsonReader;

public class LoginPage extends BaseClass {
	String data = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\LoginData.json";
	String locator = System.getProperty("user.dir") + "\\src\\test\\resources\\locators\\LoginLocators.json";

	public void loginDetails() {
		JsonReader j = new JsonReader();
		type(j.getJsonLocator(locator, "txt_username"), j.getJsonData(data, "username"));
		type(j.getJsonLocator(locator, "txt_lastname"), j.getJsonData(data, "password"));
		click(j.getJsonLocator(locator, "btn_login"));
	}

}
