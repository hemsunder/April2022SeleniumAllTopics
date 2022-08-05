package practicetestNGfeatures;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
	
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
	
	@Test(invocationCount=5)
	public void googleTitleTest() {
		driver.get("https://www.google.com/");	
		boolean flag = driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	@Test(enabled=false)
	public void vlidateLanguageTest() throws Exception   {
		driver.get("https://www.google.com/");	
		driver.findElement(By.linkText("తెలుగు")).click();
		Thread.sleep(6000);
		driver.findElement(By.linkText("English")).click();
		Thread.sleep(6000);
	}
	
}
