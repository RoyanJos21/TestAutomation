package org.testcases;

import org.adactin.BookingHotelPage;
import org.adactin.ConfirmingPage;
import org.adactin.LoginPage;
import org.adactin.SearchHotelPage;
import org.adactin.SelectHotelPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.util.BaseClass;

public class MainRun extends BaseClass {
	@BeforeClass
	public void load_Driver() {
		getdriver();
		loadurl("https://adactinhotelapp.com/index.php");
	}

	@Test
	public void login() {
		LoginPage login = new LoginPage();
		login.loginDetails();
	}

	@Test(dependsOnMethods = "login")
	public void search_Hotel_in_Adactin() {
		SearchHotelPage search = new SearchHotelPage();
		search.searchHotal();
	}

	@Test(dependsOnMethods = "search_Hotel_in_Adactin")
	public void select_Hotel_in_Adactin() {
		SelectHotelPage select = new SelectHotelPage();
		select.selectHotel();
	}

	@Test(dependsOnMethods = "select_Hotel_in_Adactin")
	public void booking_Hotel_in_Adactin() {
		BookingHotelPage book = new BookingHotelPage();
		book.bookHotel();
	}

	@Test(dependsOnMethods = "booking_Hotel_in_Adactin")
	public void getting_order_no() {
		ConfirmingPage confirm = new ConfirmingPage();
		confirm.orderNo();
	}

	@AfterClass()
	public void kill_Browser() {
		quit();
	}

}
