package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_RegistrationTest extends BaseClass {

	@Test
	public void verify_registration() 
	{
		
	logger.info("**** starting TC_001_RegistrationTest  ***** ");
	
	
	try {
	HomePage hp = new HomePage(driver);
	
	hp.clickRegister();
	logger.info("Clicked on Registration link");
	
	logger.info("Registering User");
	
	RegistrationPage regpage= new RegistrationPage(driver);
	String randomPwd = randomeAlphaNumeric();
	regpage.setUserName(randomeString().toUpperCase());
	regpage.setPwdName(randomPwd);
	regpage.setConfpwdName(randomPwd);
	regpage.clickRegister();
	logger.info("Clicked on Registration Button");
	
	String Url = regpage.currentUrl();
	
	logger.info("Validating expected URL");
	if(Url .equals("https://dsportalapp.herokuapp.com/home"))
	{
		logger.info("Inside If **URL: matched**");
		Assert.assertTrue(true);
		
	}
	else
	{
		logger.info("Inside ELSE **URL not matched*");
		Assert.assertFalse(true);
	}
	
	//Assert.assertEquals("https://dsportalapp.herokuapp.com/home", Url);
	}
	catch(Exception e)
	{
		logger.error("Test Failed");
		Assert.fail();
	}
	
	logger.info("**** Finished TC_001_RegistrationTest  ***** ");
	
	
	}
	
	
	
	
	}