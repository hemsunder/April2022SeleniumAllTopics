package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {
	
	//7. Approach

	public static void main(String[] args) {

		BrowerUtil brUtil = new BrowerUtil();
		WebDriver driver = brUtil.initializeBrowser("edge");
		brUtil.LaunchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		By Register = By.linkText("Register"); 
		By FirstName = By.id("input-firstname");
		
		eleUtil.doClick(Register);
		eleUtil.doSendKeys(FirstName, "Automation");
	}

}
