package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyLoginVerificationPage;
import pageObjects.SignInPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test
	public void verify_login()
	{
		logger.info("*STARTING LOGIN PAGE******");
		logger.debug("*Capturing Debug LOG******");
		
		
		try {
			
		//HOME PAGE
		HomePage hp = new HomePage(driver);
		hp.clickSignin();//signin Lionk
		logger.info("Clicked on SignIN link");
			
		
		//LOGIN PAGE
		logger.info("************USER LOGIN **************");
		SignInPage login = new SignInPage(driver);
		login.sendUserName(p.getProperty("username")); //Fetch from Config File
		login.sendPwdName(p.getProperty("password"));
		login.clickLogin();
		logger.info("************USER Clicken on Login button **************");
		
		
		//LOGIN VERIFICATION PAGE
		MyLoginVerificationPage verifylogin = new MyLoginVerificationPage(driver);
		boolean targetPage= verifylogin.isLoginPageExists();
		if(targetPage==true)
		{
			logger.info("*****Login test Passed****");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("***Login test Failed****");
			Assert.fail();
		}
		}catch (Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*Finished LOGIN PAGE******");
		
		
	}
	

	
}
