package seleniumpractice;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		// WebDriverManager.chromedriver().setup();

		System.setProperty("webdriver.chrome.driver", "C:/Softwares&Drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		
		//List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		//System.out.println("Total number of links are : "+linkslist.size());
		
		/*for(int i=0;i<linkslist.size();i++) {
			String textLink = linkslist.get(i).getText();
			if(!textLink.isEmpty()) {
				System.out.println(i + textLink);
			}
		}*/
		
		
		/*int count = 0;
		for(WebElement e:linkslist) {
			String text = e.getText();
			if(!text.isEmpty()) {
				System.out.println(count+" : "+text);
			}
			count++;
		}*/
		
		By links = By.tagName("a");
		/*
		 * int totalLinks = getTotalLinksCount(links); 
		 * System.out.println(totalLinks);
		 */
		
		/*
		 * List<String> linksText = getLinksText(links); 
		 * System.out.println(linksText);
		 */
		
		//System.out.println(getEmptyLinksCount(links));
		List<String> atrValues = getElementAttributeValue(links, "href");
		for(String e:atrValues) {
			System.out.println(e);
		}
	}
	
	
	public static List<String> getElementAttributeValue(By locator, String attrname) {
		List<WebElement> elelist = getElements(locator);
		List<String> eleattrvalue = new ArrayList<String>();
		for(WebElement e:elelist) {
			 String attName = e.getAttribute(attrname);
			 eleattrvalue.add(attName);
		}
		return eleattrvalue;
	}
	
	
	
	
	public static List<String> getNonEmptyLinksText(By locator) {
		List<WebElement> totalLinks = getElements(locator);
		List<String> notemptylinkslist = new ArrayList<String>();
		for(WebElement e:totalLinks) {
			String linkText = e.getText();
			if(!linkText.isEmpty()) {
				notemptylinkslist.add(linkText);
			}	
		}
		return notemptylinkslist;
	}
	
	public static int getEmptyLinksCount(By locator) {
		int totalLinksCount = getTotalLinksCount(locator);
		int nonEmptyLinksCount = getNonEmptyLinksCount(locator);
		return (totalLinksCount-nonEmptyLinksCount);
	}
	
	public static int getNonEmptyLinksCount(By locator) {
		return getNonEmptyLinksText(locator).size();
	}
	
	public static int getTotalLinksCount(By locator) {
		List<WebElement> totalLinks = getElements(locator);
		return totalLinks.size();
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	

}
