package session;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	WebDriver driver;

	@Before
	public void SetDriver() {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.techfios.com//ibilling//?ng=admin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Test
	public void test() {
		driver.findElement(By.name("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		
		driver.findElement(By.name("login")).click();
		
        System.out.println(driver.getTitle());
	System.out.println(driver.getWindowHandle());
	System.out.println(driver.getCurrentUrl());
	  
		WebElement Actual1=driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
	  String Expected="Dashboard"; // Thread.sleep(3000); //
	 Assert.assertEquals("dashboard is not displayed", Expected, Actual1.getText()); 
	   
	 WebElement Actual2=driver.findElement(By.xpath("//*[@id='side-menu']/li[5]/a/span[1]"));
	  String Expected2="Transactions";
	  Assert.assertEquals("transaction not displayed ", Expected2, Actual2.getText());
	  Actual2.click();
	  
	  WebElement Actual3= driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[6]/a/span[1]"));
	 
	 // System.out.println(Actual3.getText());
	  String expected3="Sales";
	  System.out.println(expected3);
	  Assert.assertEquals("well done not found", Actual3.getText(), expected3);
	  Actual3.click();
	}  
} 
	  
	 

