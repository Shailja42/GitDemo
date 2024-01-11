package restAssuredProject;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class gmailLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		
		//sSystem.setProperty("webdriver.chrome.driver","C://Users//akumar94//eclipse-workspace//restAssuredProject//driver//chrome.exe");
			      WebDriver driver = new ChromeDriver();
			      //implicit wait
			     // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			      //URL launch
			      driver.get("https://accounts.google.com/signin");
			      //identify email
			      WebElement l = driver
			      .findElement(By.name("identifier"));
			      l.sendKeys("abc@gmail.com");
			      WebElement b = driver
			      .findElement(By.className("VfPpkd-LgbsSe"));
			      b.click();
			      //identify password
			      WebElement p = driver
			      .findElement(By.name("password"));
			      p.sendKeys("123456");
			      b.click();
			      //close browser
			      driver.close();
			   }

	}


