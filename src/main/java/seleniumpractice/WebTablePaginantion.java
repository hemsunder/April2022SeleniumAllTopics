package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePaginantion {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		// WebDriverManager.chromedriver().setup();

		System.setProperty("webdriver.chrome.driver", "C:/Softwares&Drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		Thread.sleep(3000);
		
		//By countryCB = By.xpath("//td[text()='Denmark']/preceding-sibling::td/input");
		//doClickCB("Hong Kong");
		
		System.out.println("url is loaded fully");
		String countryName = "Gummadam";
		
		while(true) {
			
			if(driver.findElements(By.xpath("//td[text()='"+countryName+"']")).size()>0) {
				doClickCB(countryName);
				break;
			}
			else {
				
				WebElement next = driver.findElement(By.xpath("//a[text()='Next']"));
				if(next.getAttribute("class").contains("disabled")) {
					System.out.println("The country is not available in the table");
					break;
				}
				else {
					next.click();
					Thread.sleep(1000);
				}	
			}
			
		}	
	}
	
	
	public static void doClickCB(String country) {
		driver.findElement(By.xpath("//td[text()='"+country+"']/preceding-sibling::td/input")).click();
		
	}
	
	

}
