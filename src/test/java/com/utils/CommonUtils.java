package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mainpages.LoginPage;


public class CommonUtils {

	public static WebDriver driver;
	
	public void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void readData() throws IOException, InterruptedException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\akumar94\\Documents\\TestingData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheetCount = workbook.getNumberOfSheets();
		int k = 0;
		int column = 0;
		for (int i = 0; i < sheetCount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstCell = rows.next();
				Iterator<Cell> cells = firstCell.cellIterator();
				while (cells.hasNext()) {
					Cell value = cells.next();

					if (value.getStringCellValue().equals("From")) {
						column = k;
					}
					k++;

					System.out.println(column);
					break;
				}
				while (rows.hasNext()) {
					Row r = rows.next();
					String value = r.getCell(column).getStringCellValue();
					System.out.println("Vaue is: " +value);
					String value_to = r.getCell(1).getStringCellValue();
					System.out.println(value_to);
					Thread.sleep(1000);
					driver.findElement(By.xpath(LoginPage.xpaths.get("from_xpath"))).sendKeys(value);
					driver.findElement(By.xpath(LoginPage.xpaths.get("to_xpath"))).sendKeys(value_to);
					driver.findElement(By.xpath(LoginPage.xpaths.get("select_date_xpath"))).click();

					 driver.findElement(By.xpath(LoginPage.xpaths.get("date_xpath")));

					
						// if (cell.getText().equals("13")) {
						driver.findElement(By.xpath(LoginPage.xpaths.get("date_xpath"))).click();
					

						driver.findElement(By.xpath(LoginPage.xpaths.get("search_xpath"))).click();
						driver.findElement(By.id(LoginPage.xpaths.get("popup_id"))).click();
						implicitWait();
						driver.findElement(By.xpath(LoginPage.xpaths.get("class_xpath"))).click();
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
						//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(LoginPage.xpaths.get("button_xpath"))));
						//driver.findElement(By.xpath(LoginPage.xpaths.get("button_xpath"))).click();
					    driver.navigate().back();
						// }
					
				}
				
			}
		}
		workbook.close();
	}
}
