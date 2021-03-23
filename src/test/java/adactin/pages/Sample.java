package adactin.pages;

import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.util.BaseClass;

public class Sample extends BaseClass {
	public static void main(String[] args) {
	getdriver();
	loadurl("http://www.amazon.in");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
	machine(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left'])[1]")).click();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		System.out.println("Error");
	}
	List<WebElement> az = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	for (int i = 0; i < az.size(); i++) {
		WebElement webElement = az.get(i);
		String text = webElement.getText();
		System.out.println(text);
	}
	
	
	
	
	
	
	
	
	
	
	}

}
