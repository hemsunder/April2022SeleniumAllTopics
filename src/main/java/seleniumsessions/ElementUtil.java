package seleniumsessions;

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
		case "cssselector":
			locator = By.cssSelector(selector);
			break;
		case "linktext":
			locator = By.linkText(selector);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(selector);
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

	public void doClick(String locatorType, String selector) {
		By locator = getBy(locatorType, selector);
		getElement(locator).click();
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public String doGetAttributeValue(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public String doElementGetText(By locator) {
		String eleText = getElement(locator).getText();
		return eleText;
	}

	// non blank list count:
	public int getElementsTextCount(By locator) {
		return getElementsTextList(locator).size();
	}

	// non blank text list:
	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

	public int getEmptyEleTextList(By locator) {
		int totalLinks = getPageElementsCount(locator);
		int totalNonEmptyLinks = getElementsTextCount(locator);
		return totalLinks - totalNonEmptyLinks;
	}

	// 1. total number of links on the page
	public int getPageElementsCount(By locator) {
		return getElements(locator).size();
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public List<String> getEleAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrValList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String attrValue = e.getAttribute(attrName);
			eleAttrValList.add(attrValue);
		}
		return eleAttrValList;
	}

	public void performSearch(By search, String searchKey, By suggListLocator, String suggName)
			throws InterruptedException {
		doSendKeys(search, searchKey);
		Thread.sleep(2000);
		List<WebElement> suggList = getElements(suggListLocator);
		System.out.println("total suggs: " + suggList.size());
		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(suggName)) {
				e.click();
				break;
			}
		}

	}

	public void selectItem(String productName) {
		By locator = By.xpath("//li[text()='" + productName + "']");
		doClick(locator);
	}

	// **************************element displayed utils*****************//
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public int getElementCount(By locator) {
		int eleCount = getElements(locator).size();
		return eleCount;
	}

	public boolean checkSingleElementExist(By locator) {
		if (getElementCount(locator) == 1) {
			return true;
		}
		return false;
	}

	public boolean checkElementMultipleExist(By locator) {
		if (getElementCount(locator) > 1) {
			return true;
		}
		return false;
	}


}
