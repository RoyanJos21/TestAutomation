package adactin.pages;

import org.util.BaseClass;
import org.util.JavaReader;
import org.util.JsonReader;

public class BookingHotelPage extends BaseClass {
	String jsonFile = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\BookingHotelData.json";

	public void bookHotel() {
		JavaReader java = new JavaReader();
		JsonReader json = new JsonReader();
		type(java.txt_firstName, json.getJsonData(jsonFile, "first_name"));
		type(java.txt_lastName, json.getJsonData(jsonFile, "last_name"));
		type(java.txt_address, json.getJsonData(jsonFile, "address"));
		type(java.txt_ccNumber, json.getJsonData(jsonFile, "credit_card_number"));
		selectVisible(java.dDn_ccType, json.getJsonData(jsonFile, "credit_card_type"));
		selectVisible(java.dDn_ccExpMonth, json.getJsonData(jsonFile, "credit_card_exp_month"));
		selectVisible(java.dDn_ccExpYear, json.getJsonData(jsonFile, "credit_card_exp_year"));
		type(java.txt_ccvNumber, json.getJsonData(jsonFile, "credit_card_ccv_number"));
		click(java.btn_click);
	}

}
