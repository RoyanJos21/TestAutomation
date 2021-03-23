package adactin.pages;

import org.util.BaseClass;
import org.util.JsonReader;

public class SearchHotelPage extends BaseClass {
	String data = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\SearchHotelData.json";
	String locator = System.getProperty("user.dir") + "\\src\\test\\resources\\locators\\SearchHotelLocators.json";

	public void searchHotal() {

		JsonReader j = new JsonReader();

		selectVisible(j.getJsonLocator(locator, "dDn_location"), j.getJsonData(data, "location"));
		selectVisible(j.getJsonLocator(locator, "dDn_hotel"), j.getJsonData(data, "hotelName"));
		selectVisible(j.getJsonLocator(locator, "dDn_roomType"), j.getJsonData(data, "roomType"));
		selectVisible(j.getJsonLocator(locator, "dDn_roomNos"), j.getJsonData(data, "roomNos"));
		type(j.getJsonLocator(locator, "txt_CheckIn"), j.getJsonData(data, "checkIn"));
		type(j.getJsonLocator(locator, "txt_CheckOut"), j.getJsonData(data, "checkOut"));
		selectVisible(j.getJsonLocator(locator, "dDn_adultNos"), j.getJsonData(data, "adultNos"));
		selectVisible(j.getJsonLocator(locator, "dDn_childNos"), j.getJsonData(data, "childNos"));
		click(j.getJsonLocator(locator, "btn_sumbit"));

	}

}
