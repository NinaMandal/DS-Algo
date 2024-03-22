package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
	
	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "id_username")
	@CacheLookup
	WebElement loginusername;
	
	@FindBy(id = "id_password")
	WebElement loginpwd;
	
	
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	public void sendUserName(String uname) {
		loginusername.sendKeys(uname);
	}
	public void sendPwdName(String password) {
		loginpwd.sendKeys(password);
	}
	
	//Clicking Logging Button
	public void clickLogin() {
		btnLogin.click();
		
	}
	

}
