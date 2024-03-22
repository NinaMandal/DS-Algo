package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyLoginVerificationPage extends BasePage {

	public MyLoginVerificationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//div[@role='alert']")
	WebElement msgLogin;
	
	@FindBy(id = "id_username")
	@CacheLookup
	WebElement loginusername;
	
	@FindBy(id = "id_password")
	WebElement loginpwd;
	
//	String successmsg =
	String errormsgverify;
	
	
	
	
	@FindBy(linkText = "Sign out") 
	WebElement lnkSignout;
	
	  String messageStr;
	  
	  public void popup()
	  { WebElement activeElement = driver.switchTo().activeElement(); 
	  messageStr = activeElement.getAttribute("validationMessage");
	  System.out.println("Actual message appeared on screen: " + messageStr); }
	
	
	public boolean isLoginPageExists()
	{
		try
		{
			//if(loginusername.equals("")|| loginpwd.equals("") )
			
			if(msgLogin.isDisplayed()) {
				errormsgverify=msgLogin.getText(); 
				System.out.println("isdisplayed");
				return (true);
			}				
			
		}catch(Exception e) {
			popup();
			if(messageStr.equalsIgnoreCase("Please fill out this field."))
			{
				System.out.println("Please fill out field");
				return (true);
			}
		}
		return false;
		
	}
	
	public void clickLogout() {
		lnkSignout.click();
	}

}
