package seleniumpractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetFooterLinks {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		// WebDriverManager.chromedriver().setup();

		System.setProperty("webdriver.chrome.driver", "C:/Softwares&Drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://google.com");
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		//driver.get("http://automationpractice.com/");
		
		
		//By locator = By.xpath("//div[@class='KxwPGc SSwjIe']//div[@class='KxwPGc AghGtd']//a");
		//By locator = By.xpath("//footer/div[@class='container']//div[contains(@class,'col-sm')]");
		//By locator = By.xpath("//aside[@id='column-right']//a");
		
		By locator = By.name("q");
		//By locator2 = By.xpath("//div[@class='ac_results']//li");
		By locator2 = By.xpath("//ul[@class='G43f7e' and @role='listbox']//li");
		//getElement(locator).sendKeys("Dress");
		doSendkeys(locator, "Naveen automation labs");
		Thread.sleep(3000);
		selectElement(locator2, "Python");
		
		
		/*
		 * List<WebElement> elements = getElements(locator2); for(WebElement e:elements)
		 * { String text = e.getText(); if(text.contains("T-shirts")) { e.click();
		 * break; } }
		 */
		
		
		
		//List<WebElement> elements = getElements(locator2);
		
		
		
		/*
		 * List<WebElement> footerelements =
		 * driver.findElements(By.xpath("//div[@class='KxwPGc SSwjIe']" +
		 * "//div[@class='KxwPGc AghGtd']//a"));
		 * System.out.println(footerelements.size());
		 * 
		 * for(WebElement e:footerelements) { String footerText = e.getText();
		 * System.out.println(footerText); }
		 */
		
		//doPrintFooterLinks(locator);
		
	}
	
	public static void selectElement(By locator, String itemname) {
		List<WebElement> elements = getElements(locator);
		for(WebElement e:elements) {
			String text = e.getText();
			System.out.println(text);
			if(text.contains(itemname.toLowerCase())) {
				e.click();
				break;
			}
		}
		
	}
	
	public static List<String> doPrintFooterLinks(By locator) {
		List<WebElement> footerelements = getElements(locator);
		List<String> texts = new ArrayList<String>();
		for(WebElement e:footerelements) {
			String text = e.getText();
			//System.out.println(text);
			texts.add(text);
		}
		return texts;
	}
	
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendkeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

}
