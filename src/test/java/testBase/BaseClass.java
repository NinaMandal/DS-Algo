package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	//Getting this parameters from TestNG xml/Master XML for cross browser testing
	@Parameters({"os","browser"})
	
	public void setup(String os, String br) throws IOException 
	
	
	{
		String hostUrl = "http://localhost:4444/wd/hub";
		//loading properties file.
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
		
		
		//Loading log4j2 xml file.
		logger = LogManager.getLogger(this.getClass()); //Log4j
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  
		  //decide OS
		  if(os.equalsIgnoreCase("windows"))
		  {
			  capabilities.setPlatform(Platform.WINDOWS);
		  }
		  else if(os.equalsIgnoreCase("mac"))
		  {
			  capabilities.setPlatform(Platform.MAC);
		  }
		  else
		  {
			  System.out.println("No matching OS....");
			  return;
		  }
		  
		  
		  
		  //decide browser
		  
		  switch(br.toLowerCase())
		  {
		  case "chrome" : capabilities.setBrowserName("chrome");break;
		  case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
		  case "firefox":capabilities.setBrowserName("firefox");break;
		  default:System.out.println("No matching browser....");return;
		  
		  }
		  
		
		   driver = new RemoteWebDriver(new URL(hostUrl), capabilities);
		  
		  
		}
	else if(p.getProperty("ececution_env").equalsIgnoreCase("local"))
	{

		// Condition check for cross browsing and parallel browsing --locally
		switch(br.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver();break;
		case"edge":driver = new EdgeDriver();break;
		default:System.out.println("No matching browser....");
		return;
		}
			
	}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://dsportalapp.herokuapp.com/register");
		driver.get(p.getProperty("appURL"));
		
		
		//create below code for LOGIN
		//driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
		
}

	/*
	 * @AfterClass public void tearDown() { driver.close(); }
	 */
		
		
		public String randomeString() {
			
			String generatedString=RandomStringUtils.randomAlphabetic(5);
			return generatedString;
			
		}
		
		public String randomeNumber() {
			
			String generatedString=RandomStringUtils.randomNumeric(10);
			return generatedString;
			
		}
		
		public String randomeAlphaNumeric() {
			
			String str= RandomStringUtils.randomAlphabetic(3);
			String num= RandomStringUtils.randomNumeric(4);
			return (str+"@"+num);
			
		}


}
