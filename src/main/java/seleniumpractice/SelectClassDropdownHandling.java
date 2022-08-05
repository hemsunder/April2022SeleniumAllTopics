package seleniumpractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassDropdownHandling {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		// WebDriverManager.chromedriver().setup();

		System.setProperty("webdriver.chrome.driver", "C:/Softwares&Drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/hris-hr-software-demo/");
		
		By countryDD = By.id("Form_submitForm_Country");
		
		//doSelectByIndex(countryDD, 5);
		//Thread.sleep(5000);
		//doSelectByVisibleText(countryDD, "India");
		//Thread.sleep(5000);
		//doSelectByValue(countryDD, "Australia");
		System.out.println(getSelectDropdownListOptionsCount(countryDD));
		System.out.println(getSelectDropdownValuesText(countryDD));
		getSelectwithoutusingSelectOptions(countryDD, "India");
		
		
		//Select select = new Select(getElement(countryDD));
		//select.selectByIndex(5);
		

	}
	
	//Not Recommended
	public static void doSelectElement(By locator, String selectType, int num, String visibletext, String value) {
		Select select = new Select(getElement(locator));
		
		switch (selectType) {
		case "index":
			if(num>-1) {
			select.selectByIndex(num);
			}
			break;
			
		case "visibletext":
			int len = visibletext.length();
			if(len>0) {
				select.selectByVisibleText(visibletext);
			}
			break;
			
		case "value":
			int valuelen = value.length();
			if(valuelen>0) {
				select.deselectByValue(value);
			}
			break;

		}
	}
	
	
	//Recommended
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	//Recommended
	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	//Recommended
	public static void doSelectByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
	
	//Recommended
	public static void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public static int getSelectDropdownListOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> options = select.getOptions();
		return options.size();
	}
	
	public static List<String> getSelectDropdownValuesText(By locator) {
		Select select = new Select(getElement(locator));
		List<String> textsList = new ArrayList<String>();
		List<WebElement> options = select.getOptions();
		for(WebElement e:options) {
			String text = e.getText();
			textsList.add(text);
		}
		return textsList;
	}
	
	
	public static void getSelectwithoutusingSelectOptions(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> options = select.getOptions();
		for(WebElement e:options) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}			
		}	
	}
	

}
