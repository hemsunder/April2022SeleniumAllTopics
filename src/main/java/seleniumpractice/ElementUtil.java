package seleniumpractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {
	
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public By getBy(String locatorType, String selector) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(selector);
			break;
		case "name":
			locator = By.name(selector);
			break;
		case "class":
			locator = By.className(selector);
			break;
		case "xpath":
			locator = By.xpath(selector);
			break;
		case "linktext":
			locator = By.linkText(selector);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(selector);
			break;		
		case "cssselector":
			locator = By.cssSelector(selector);
			break;
		case "tagname":
			locator = By.tagName(selector);
			break;

		default:
			break;
		}
		
		return locator;
	}
	

	public void doSendKeys(String locatorType, String selector, String value) {
		By locator = getBy(locatorType, selector);
		getElement(locator).sendKeys(value);
		
	}
	
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public String doGetAttributeValue(String locatorType, String selector, String attrname) {
		By locator = getBy(locatorType, selector);
		return getElement(locator).getAttribute(attrname);
	}
	
	public String doGetAttributeValue(By locator, String attrname) {
		return getElement(locator).getAttribute(attrname);
	}
	
	public void doClick(String locatorType, String selector) {
		By locator = getBy(locatorType, selector);
		getElement(locator).click();
	}
	
	
	public List<String> getElementAttributeValue(By locator, String attrname) {
		List<WebElement> elelist = getElements(locator);
		List<String> eleattrvalue = new ArrayList<String>();
		for(WebElement e:elelist) {
			 String attrName = e.getAttribute(attrname);
			 eleattrvalue.add(attrName);
		}
		return eleattrvalue;
	}
	
	
	public List<String> getLinksText(By locator) {
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
	
	public int getEmptyLinksCount(By locator) {
		int totalLinksCount = getTotalLinksCount(locator);
		int nonEmptyLinksCount = getNonEmptyLinksCount(locator);
		return (totalLinksCount-nonEmptyLinksCount);
	}
	
	public int getNonEmptyLinksCount(By locator) {
		return getLinksText(locator).size();
	}
	
	public int getTotalLinksCount(By locator) {
		List<WebElement> totalLinks = getElements(locator);
		return totalLinks.size();
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	

	
	
	
}
