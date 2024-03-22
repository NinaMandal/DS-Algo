package testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyLoginVerificationPage;
import pageObjects.SignInPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass
{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String username, String password, String status)
	{
		logger.info("****STARTING TC_003_LoginDDT*** ");
	
		
		try {
		//HOME PAGE
				HomePage hp = new HomePage(driver);
				hp.clickSignin();//signin Lionk
				//logger.info("Clicked on SignIN link");
				
				
				//LOGIN PAGE
				//logger.info("************USER LOGIN **************");
				Reporter.log("Create sigin Onject");
				SignInPage login = new SignInPage(driver);
				//Fetching values from DataProviders
				
				login.sendUserName(username); 
				login.sendPwdName(password);
				login.clickLogin();
				//logger.info("************USER Clicked on Login button **************");
				Reporter.log("USER Clicked on Login button");
				
				//LOGIN VERIFICATION PAGE
				MyLoginVerificationPage verifylogin = new MyLoginVerificationPage(driver);
				
				/*
				 * if(username.equals("")) { verifylogin.popup(); }
				 */
				
				boolean targetPage= verifylogin.isLoginPageExists();
				
				Reporter.log("Create OBJ of verification page");
				
				if(status.equalsIgnoreCase("Valid"))
				{
					if(targetPage==true)
					{
						verifylogin.clickLogout();
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
				
				if(status.equalsIgnoreCase("Invalid"))
				{
					if(targetPage==true)
					{
						
						//verifylogin.clickLogout();
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("****Ending TC_003_LoginDDT*** ");
		Reporter.log("Ending TC_003_LoginDDT");		
	}

}
