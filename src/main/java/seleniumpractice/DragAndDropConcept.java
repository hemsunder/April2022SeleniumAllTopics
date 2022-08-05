package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		// WebDriverManager.chromedriver().setup();

		System.setProperty("webdriver.chrome.driver", "C:/Softwares&Drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		//WebElement source = driver.findElement(By.id("draggable"));
		//WebElement target = driver.findElement(By.id("droppable"));
		
		//Actions act = new Actions(driver);
		//act.clickAndHold(source).moveToElement(target).release().build().perform();
		
		By source = By.id("draggable");
		By target = By.id("droppable");
		dodraganddrop(source, target);
		//act.dragAndDrop(source, target).perform();

	}
	
	
	public static void dodraganddrop(By locator1, By locator2) {
		Actions act = new Actions(driver);
		//act.clickAndHold(getElement(locator1)).moveToElement(getElement(locator2)).release().build().perform();
		act.dragAndDrop(getElement(locator1), getElement(locator2)).perform();
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
