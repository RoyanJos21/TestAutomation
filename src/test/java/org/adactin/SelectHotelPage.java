package org.adactin;

import org.util.BaseClass;
import org.util.XMLReader;

public class SelectHotelPage extends BaseClass {
	String parent="//allLocators/";
	public void selectHotel() {
		XMLReader xml = new XMLReader();
		click(xml.readXml("rdo_selectHotel"));
		click(xml.readXml("btn_click"));
	}

}
