package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickConcept {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		// WebDriverManager.chromedriver().setup();

		System.setProperty("webdriver.chrome.driver", "C:/Softwares&Drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		//WebElement rightclickbtn = driver.findElement(By.cssSelector(".context-menu-one.btn.btn-neutral"));
		//Actions act = new Actions(driver);
		//act.contextClick(rightclickbtn).perform();
		
		By rightclickbtn = By.cssSelector(".context-menu-one.btn.btn-neutral");
		doRightClick(rightclickbtn);
	}
	
	public static void doRightClick(By locator) {
		Actions act = new Actions(driver);
		act.contextClick(getElement(locator)).perform();
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
