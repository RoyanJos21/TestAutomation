package org.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;
	public static Robot robot;

	public static WebDriver getdriver() {
		PropertiesReader prop = new PropertiesReader();
		String valueByKey = prop.getValueByKey("Browser.Type");
		switch (valueByKey) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + prop.getValueByKey("chrome.driver"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + prop.getValueByKey("ie.driver"));
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + prop.getValueByKey("firefox.driver"));
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + prop.getValueByKey("edge.driver"));
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;
		default:
			break;
		}

		return driver;
	}

	public static ArrayList<Object[]> getExcelData() {
		ArrayList<Object[]> ob = new ArrayList<Object[]>();
		return ob;
	}

	public void webWait(long waitTime, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public void actionClick(By locator) {
		WebElement element = driver.findElement(locator);
		Actions actions = new Actions(getdriver());
		actions.moveToElement(element).click().build().perform();
	}

	public static String getExcelValue(int rownum, int cellnum) {
		File file = new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\locators\\BookingHotelLocators.xlsx");
		FileInputStream stream = null;
		try {
			stream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);

		int cellType = cell.getCellType();
		String stringCellValue = "";
		if (cellType == 1) {
			stringCellValue = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
			stringCellValue = sm.format(dateCellValue);
		} else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			stringCellValue = String.valueOf(l);
		}
		return stringCellValue;

	}

	public static void loadurl(String data) {
		driver.get(data);
	}

	public static void quit() {
		driver.quit();
	}

	public static void type(By locator, String data) {
		driver.findElement(locator).sendKeys(data);

	}

	public static void click(By locator) {
		driver.findElement(locator).click();
		;

	}

	public static void selectValue(By locator, String data) {
		Select sel = new Select(driver.findElement(locator));
		sel.selectByValue(data);

	}

	public static void selectVisible(By locator, String data) {
		Select sel = new Select(driver.findElement(locator));
		sel.selectByVisibleText(data);

	}

	public static void machine(int key) {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(key);
		robot.keyRelease(key);
	}

	public static void actionMove(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

	public static void contextAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();

	}

	public static void doubleClickAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();

	}

	public static void performAction() {
		Actions actions = new Actions(driver);
		actions.perform();

	}

	public static void clickAction() {
		Actions actions = new Actions(driver);
		actions.click().perform();

	}

	public static void getUrl() {
		String name = driver.getCurrentUrl();
		System.out.println(name);

	}

	public static void getTittle() {
		String title = driver.getTitle();
		System.out.println(title);

	}

	public void attriValue(WebElement element) {
		String name = element.getAttribute("value");
		System.out.println(name);

	}

	public void naviBack() {
		driver.navigate().back();

	}

	public static String text(By locator) {
		WebElement element = driver.findElement(locator);
		String text = element.getText();
		return text;

	}

	public String getAtri(By loc, String text) {
		WebElement element = driver.findElement(loc);
		String attribute = element.getAttribute(text);
		return attribute;
	}

	public void listAsc() {
		List<WebElement> tRows = driver.findElements(By.tagName("tr"));
		for (int i = 0; i < tRows.size(); i++) {
			WebElement row = tRows.get(i);
			List<WebElement> tData = row.findElements(By.tagName("td"));
			for (int j = 0; j < tData.size(); j++) {
				WebElement data = tData.get(j);
				String name = data.getText();
				System.out.println(name);

			}
		}

	}
}
