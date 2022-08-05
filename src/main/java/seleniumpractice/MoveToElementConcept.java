package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementConcept {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		// WebDriverManager.chromedriver().setup();

		System.setProperty("webdriver.chrome.driver", "C:/Softwares&Drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		
		//WebElement components = driver.findElement(By.linkText("Components"));
		//WebElement level2ele = driver.findElement(By.xpath("//a[contains(text(),'Monitors')]"));
		//Actions act = new Actions(driver);
		//act.moveToElement(components).moveToElement(level2ele).build().perform();
		//act.moveToElement(components).click(level2ele).build().perform();
		
		By locator = By.linkText("Components");
		By locator2 = By.xpath("//a[contains(text(),'Monitors')]");
		//doSingleLevelMovetoElement(locator);
		doTwoLevelMovetoElement(locator, locator2);

	}
	
		public static void doTwoLevelMovetoElement(By locator1, By locator2) {
			Actions act = new Actions(driver);
			act.moveToElement(getElement(locator1)).moveToElement(getElement(locator2)).build().perform();
		}
	
		public static void doSingleLevelMovetoElement(By locator) {
			Actions act = new Actions(driver);
			act.moveToElement(getElement(locator)).perform();
		}
	
		public static WebElement getElement(By locator) {
			return driver.findElement(locator);
		}

}
