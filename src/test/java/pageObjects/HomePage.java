package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[contains(text(), 'Register')]")
	WebElement lnkRegister;
	
	
	/*
	 * @FindBy(linkText = "Register") WebElement lnkRegister1;
	 * 
	 * @FindBy(linkText = "Sign in") WebElement lnkSignIn1;
	 */
	 
	
	  @FindBy(xpath="//a[contains(text(), 'Sign in')]") WebElement lnkSignIn;
	 
	// This is the Register Link to click 
	public void clickRegister() {
		lnkRegister.click();
	}
	
	// This is the Login Link to click 
	
	public void clickSignin() {
		lnkSignIn.click();
	}
	

}
