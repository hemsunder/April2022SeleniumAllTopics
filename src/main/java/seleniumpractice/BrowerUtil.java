package seleniumpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowerUtil {
	
	private WebDriver driver;
	
	public WebDriver initializeBrowser(String browsername) {
		
		if(browsername.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Softwares&Drivers/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Please provide valid browser name");
		}
		return driver;
	}
	
	public void LaunchUrl(String URL) {
		driver.get(URL);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}

}
