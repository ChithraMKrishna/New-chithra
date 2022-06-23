package com.crm.comcast.genericUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.crm.comcast.genericUtilities.DataBaseUtility;
import com.crm.comcast.genericUtilities.ExcelUtility;
import com.crm.comcast.genericUtilities.FileUtility;
import com.crm.comcast.genericUtilities.WebDriverUtility;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.SignOutPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public WebDriver web;
	
	public static WebDriver sdriver;
	public DataBaseUtility dLib=new DataBaseUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public ExcelUtility eLib =new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	
	/**
	 * connecting to database
	 */

@BeforeSuite(groups= {"smokeTest","regressionTest"})

	public void dbConfig()
	{
		dLib.connectToDB();
	}




/**
 * launch the browser
 * 
 * @throws Throwable
 */
//@Parameters("browser")
@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void launchBrowser() throws Throwable   //except cross browser execution
	//public void launchBrowser(String browser) throws Throwable    //for cross browser exception
	{
		String browser = fLib.getPropertyKeyValue("browser"); //not need only for cross browser execution
		String url = fLib.getPropertyKeyValue("url");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			web=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			web=new FirefoxDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			web=new ChromeDriver();
		}
		
	//impliciltlywait
		sdriver=web;
		wLib.waitForPageToLoad(web);	
		
	//enter the url of the application	
		web.get(url);
		
		
	//maximize the screen
		web.manage().window().maximize();
		
		
	}


/**
 * login to application
 * @throws Throwable 
 * 
 */


	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public  void logintoApplication() throws Throwable
	{
		String username =fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("password");

		LoginPage loginpg=new LoginPage(web);
		loginpg.loginToApplication(username, password);
	}



/**
 * Logout the application
 * 
 */
@AfterMethod(groups= {"smokeTest","regressionTest"})

		public void logoutApplication()
		{
			SignOutPage sinpage=new SignOutPage(web);
			sinpage.getLogout();
		}


/**
 * close browser
 * 
 */
@AfterClass(groups= {"smokeTest","regressionTest"})

		public void closeBrowser()
		{
			web.close();
		}
		

/**
 * 
 * close database
 */
@AfterSuite(groups= {"smokeTest","regressionTest"})

		public void closedbConnection()
		{
			dLib.closeDB();
		}
		

}
