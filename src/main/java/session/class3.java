package session;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class class3 {

	WebDriver driver;
	@Before
	 public void element() {
		 System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		 	 driver=new ChromeDriver();
		 	 driver.get("http://www.techfios.com//ibilling//?ng=admin");
		driver.manage().window().maximize(); 	 
	 driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
	}
	@Test
public void login() throws InterruptedException {
	driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
	driver.findElement(By.id("password")).sendKeys("abc123");
	driver.findElement(By.name("login")).click();
	
	WebElement DASHBOARD_PAGE_TITLE_ELEMENT =driver.findElement(By.xpath("//h2[contains(text(), ' Dashboard ')]"));
	By ELEMENT_BY_LOCATOR =By.xpath("//h2[contains(text(), ' Dashboard ')]");
	WebDriverWait wait=new WebDriverWait(driver ,3);
	wait.until(ExpectedConditions.visibilityOf(DASHBOARD_PAGE_TITLE_ELEMENT));
  
    Assert.assertTrue("Dashboard not found",DASHBOARD_PAGE_TITLE_ELEMENT.isDisplayed());
	 driver.close();	
	}	
}
