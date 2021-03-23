package org.util;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;

public class XMLReader {
	 By locator_value = null;

	public By readXml(String location) {
		File inputFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\data\\SelectHotelData.xml");
		SAXReader saxReader = new SAXReader();
		PropertiesReader prop=new PropertiesReader();
		Document document = null;
		String parent="//allLocators/";
		try {
			document = saxReader.read(inputFile);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		location = parent+location+"/"+prop.getValueByKey("Browser.Type");
		String mobileTesting = document.selectSingleNode(location).getText();
		String[] loc = mobileTesting.split("=");
		String locType = loc[0];
		switch (locType) {
		case "id":
			locator_value = By.id(loc[1]);
			break;
		case "xpath":
			locator_value = By.xpath(loc[1]);
			break;
		case "name":
			locator_value = By.name(loc[1]);
			break;
		case "linkText":
			locator_value = By.linkText(loc[1]);
			break;
		case "partialLinkText":
			locator_value = By.partialLinkText(loc[1]);
			break;
		case "cssSelector":
			locator_value = By.cssSelector(loc[1]);
			break;
		case "tagName":
			locator_value = By.tagName(loc[1]);
			break;
		case "className":
			locator_value = By.className(loc[1]);
			break;

		default:
			break;
		}

		return locator_value;
	}
}
