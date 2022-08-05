package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FillTheRegistrationForm {
	
	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		// WebDriverManager.chromedriver().setup();

		System.setProperty("webdriver.chrome.driver", "C:/Softwares&Drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		// 1
		/*
		 * driver.findElement(By.linkText("Register")).click();
		 * driver.findElement(By.id("input-firstname")).sendKeys("FirstName");
		 * driver.findElement(By.id("input-lastname")).sendKeys("LastName");
		 * driver.findElement(By.id("input-email")).sendKeys("Email@gmail.com");
		 * driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		 * driver.findElement(By.id("input-password")).sendKeys("password");
		 * driver.findElement(By.id("input-confirm")).sendKeys("password");
		 */

		// 2
		/*
		 * WebElement Register_Link = driver.findElement(By.linkText("Register"));
		 * Register_Link.click();
		 * 
		 * WebElement FirstName_TB = driver.findElement(By.id("input-firstname"));
		 * WebElement LastName_TB = driver.findElement(By.id("input-lastname"));
		 * WebElement Email_TB = driver.findElement(By.id("input-email")); WebElement
		 * Telephone_TB = driver.findElement(By.id("input-telephone")); WebElement
		 * Password_TB = driver.findElement(By.id("input-password")); WebElement
		 * ConfirmPassword_TB = driver.findElement(By.id("input-confirm"));
		 * FirstName_TB.sendKeys("FirstName"); LastName_TB.sendKeys("LastName");
		 * Email_TB.sendKeys("email@email.com"); Telephone_TB.sendKeys("7680971174");
		 * Password_TB.sendKeys("password");
		 * ConfirmPassword_TB.sendKeys("ConfirmPassword");
		 */

		// 3
		/*
		 * By Register = By.linkText("Register"); 
		 * WebElement Register_Link = driver.findElement(Register); 
		 * Register_Link.click();
		 * 
		 * By FirstName = By.id("input-firstname"); 
		 * WebElement FirstName_TB = driver.findElement(FirstName); 
		 * FirstName_TB.sendKeys("FirstName");
		 */
		
		//4: By locators + generic functions
		
		/*By Register = By.linkText("Register"); 
		By FirstName = By.id("input-firstname"); 
		
		getElement(Register).click();
		getElement(FirstName).sendKeys("Testing");
		*/
		
		//5: By locators + generic functions to sendkeys together
		/*By Register = By.linkText("Register"); 
		By FirstName = By.id("input-firstname");
		
		getElement(Register).click();
		doSendKeys(FirstName, "Testing");
		*/
		
		//6. By locators + generic functions to sendkeys together from util class
		
		/*By Register = By.linkText("Register"); 
		By FirstName = By.id("input-firstname");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.getElement(Register).click();
		eleUtil.doSendKeys(FirstName, "Automation");
		*/
		
		//7. By locators + generic functions for actions together from util classes
		
		//8. By locators with String type(by using normal java variables)
		
		/*String firstname_id = "input-firstname";
		String register = "Register";
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doClick("linktext", register);
		eleUtil.doSendKeys("id", firstname_id, "AutomationTesting");
		*/
		
		/*
		 * String firstname_xpath = "//*[@id=\"input-firstname\"]"; String
		 * lastname_xpath = "//*[@id=\"input-lastname\"]"; String register_xpath =
		 * "//*[@id=\"column-right\"]/div/a[2]";
		 * 
		 * ElementUtil eleUtil = new ElementUtil(driver);
		 * 
		 * eleUtil.doClick("XPATH", register_xpath); eleUtil.doSendKeys("XPATH",
		 * firstname_xpath, "AutomationTesting");
		 */
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		By fnlable = By.xpath("//*[@id=\"account\"]/div[2]/label");
		String fname = eleUtil.doGetText(fnlable);
		System.out.println(fname);
		
		String Fname_TB = "input-firstname";
		eleUtil.doGetAttributeValue("id", Fname_TB, "placeholder");
		eleUtil.doSendKeys("id", Fname_TB, "Automation");
		
	}
		
		
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
		
		

}
