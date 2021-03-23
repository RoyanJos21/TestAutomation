package adactin.pages;

import org.util.BaseClass;
import org.openqa.selenium.By;

public class ConfirmingPage extends BaseClass {
	public void orderNo() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Order No: " + getAtri(By.id("order_no"), "value"));

	}
}
