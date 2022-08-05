package seleniumpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElementHandling {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		// WebDriverManager.chromedriver().setup();

		System.setProperty("webdriver.chrome.driver", "C:/Softwares&Drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		
		Thread.sleep(4000);
		
		List<WebElement> list = driver.findElements(By.xpath("//*[name()='svg']//*[name()='g' and @class='state']"));
		
		System.out.println(list.size());
		
		for(WebElement e:list) {
			String country = e.getAttribute("id");
			System.out.println(country);
			if(country.equals("georgia")) {
				e.click();
				break;
			}
		}

	}

}
