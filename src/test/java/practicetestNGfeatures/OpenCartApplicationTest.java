package practicetestNGfeatures;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenCartApplicationTest {
	
	static WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:/Softwares&Drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterMethod
	public void teardown() {
		//driver.close();
	}

	@Test
	public void getTitle() {
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");	
		String title = driver.getTitle();
		System.out.println("The title of the application is "+ title);
		Assert.assertEquals(title, "Account Login");
	}
	
	@Test
	public void validateTheExistenceOfLoginButton() throws InterruptedException {
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");	
		boolean flag = driver.findElement(By.xpath("//input[@value='Login']")).isDisplayed();
		Assert.assertTrue(flag);
		System.out.println(flag);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(3000);
	}
	
	
	
	
	
	
	
}
