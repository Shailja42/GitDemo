package com.mainpages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonUtils;

public class LoginPage extends CommonUtils {

	public static Map<String, String> xpaths;

	public void loadData() throws IOException {
		xpaths = new HashMap<>();
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(
				"C:\\work-stuff\\workspace\\com.irtc\\src\\test\\java\\com\\objectrepository\\irtc\\application.properties");
		obj.load(objfile);
		for (String key : obj.stringPropertyNames()) {
			String value = obj.getProperty(key);
			xpaths.put(key, (value));
		}
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);

	}

	public void launch() throws IOException {
		loadData();
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		driver.get(xpaths.get("AppUrl"));
		// driver.get("https://www.irctc.co.in/nget/profile/user-registration");
		driver.manage().window().maximize();
	}

	public void book_form() throws IOException, InterruptedException {
		readData();
//		driver.findElement(By.xpath(xpaths.get("select_date_xpath"))).click();
//
//		List<WebElement> columns = driver.findElements(By.xpath(xpaths.get("date_xpath")));
//
//		for (WebElement cell : columns) {
//
//			// if (cell.getText().equals("13")) {
//			driver.findElement(By.xpath(xpaths.get("date_xpath"))).click();
//
//			break;
//			// }
//		}
	}

	public void select_class() throws InterruptedException {
		driver.findElement(By.xpath(xpaths.get("search_xpath"))).click();
		driver.findElement(By.id(xpaths.get("popup_id"))).click();
		implicitWait();
		driver.findElement(By.xpath(xpaths.get("class_xpath"))).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpaths.get("button_xpath"))));
		driver.findElement(By.xpath(xpaths.get("button_xpath"))).click();
		//driver.findElement(By.xpath(xpaths.get("date_arvl_xpath"))).click();
		//driver.findElement(By.xpath(xpaths.get("button_xpath"))).click();

	}

	public void confirm_booking() {
		//driver.findElement(By.xpath(xpaths.get("confirmation_xpath"))).click();

	}

}
