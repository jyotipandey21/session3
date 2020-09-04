package session;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.Select;

public class Session {

	WebDriver driver;

	@Before
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://objectspy.space/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test
	public void element() throws Exception {
		driver.findElement(By.name("firstname")).sendKeys("jyoti");
		driver.findElement(By.xpath("//input[@ name='lastname']")).sendKeys("dixit");
		// driver.findElement(By.name("lastname")).sendKeys("pandey");(above or)
		driver.findElement(By.xpath("//input[@ name='Password']")).sendKeys("abc123");
		driver.findElement(By.id("sex-0")).click();
		driver.findElement(By.id("exp-0")).click();
		driver.findElement(By.id("datepicker")).sendKeys("07-25-2020");
		driver.findElement(By.id("tool-0")).click();

		// driver.findElement(By.className("control-label")).click();
		// driver.findElement(By.className("input-xlarge")).sendKeys("Africa");
		// driver.findElement(By.xpath("//input[@ name='lastname']")).sendKeys("dixit");

		// * next question? how to open drop down two ways 1.select/2.driver//
		 Select test = new Select(driver.findElement(By.id("continents")));
		 test.selectByVisibleText("Europe");
		 
		// driver.findElement(By.className("input-xlarge")).sendKeys("Africa");//2nd option//
		 
		 
		//* next ?for file we need to create WEBELement class//driver.findElement(By.id("File Upload"));//

		WebElement uploadfile = driver.findElement(By.className("input-file"));
		uploadfile.sendKeys("C:\\techfios\\jason example.txt");
		Thread.sleep(2000);//explicit//
		//uploadfile.click();
		//driver.findElement(By.xpath("//input[@id='photo']"));//optional//
	
	 // * next ?- how to perform partial link//
	 driver.findElement(By.partialLinkText("TF-API ")).click();
      driver.findElement(By.id("page-title"));
    //  driver.findElement(By.className("form-control product-search-keywords")).sendKeys("Null");
}
}