package com.crm.vTiger.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtilities.ExcelUtility;
import com.crm.comcast.genericUtilities.FileUtility;
import com.crm.comcast.genericUtilities.JavaUtility;
import com.crm.comcast.genericUtilities.WebDriverUtility;
import com.crm.objectRepository.HeaderCheckPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.ProductCreatePage;
import com.crm.objectRepository.ProductDetailsPage;
import com.crm.objectRepository.SignOutPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductwithvendor extends WebDriverUtility {

	@Test(priority = 5)
	
	public void CreateProductwithvendor() throws Throwable 
	{
		
		//initializing webdriver
			WebDriver web=null;
		
		//to create respective object for utility class
			FileUtility fLib=new FileUtility();
			ExcelUtility eLib=new ExcelUtility();
			JavaUtility jLib=new JavaUtility();
			WebDriverUtility wLib=new WebDriverUtility();
			
			
		//fetching data from property file
		
		String url = fLib.getPropertyKeyValue("url");
		String username =fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("password");
		String browser =fLib.getPropertyKeyValue("browser");
		
		//fetching contact data from excel sheet
		
		String productname = eLib.ReaddataFrom("sheet3",3 ,0 );
		String manufacturer = eLib.ReaddataFrom("sheet3", 2, 2);
		String vendor = eLib.ReaddataFrom("sheet3", 1, 4);
		String pdt_catagory = eLib.ReaddataFrom("sheet3", 2, 1);
		//String manufacturer1 = eLib.ReaddataFrom("sheet3", 1, 2);
		String gl_account = eLib.ReaddataFrom("sheet3",7 , 3);
		//verifying browser and launch
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//System.setProperty(first_name, last_name);
			 web=new ChromeDriver(); 
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			web=new FirefoxDriver();
			
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			web=new ChromeDriver();
		}
		
		
		web.manage().window().maximize();
		web.get(url);
		
		//implicitlywait
		//web.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wLib.waitForPageToLoad(web);
		
		
		//login
		
		LoginPage lpage=new LoginPage(web);
		lpage.loginToApplication(username, password);
		
		//inspect contacts
	
		HomePage hompg=new HomePage(web);
		hompg.product();
		
		ProductCreatePage pdtcreate=new ProductCreatePage(web);
		pdtcreate.pdctclick();
		
		ProductDetailsPage pdtdtls=new ProductDetailsPage(web);
		pdtdtls.pdtDtails(productname);
		pdtdtls.selectdropdownpdtcatagory(pdt_catagory);
		pdtdtls.childwindow(web, vendor);
		pdtdtls.adddtails(manufacturer, gl_account, web);
		
		
		HeaderCheckPage header=new HeaderCheckPage(web);
		
		String actual = header.getPdtheadercheck().getText();
	
		
		if(actual.contains(productname))
		{
			System.out.println("product is added");
		}
		else
		{
			System.out.println("product is not added");
			
		}
		
		//inspect the signout	
		
		SignOutPage sign=new SignOutPage(web);
		sign.signOutPage();
		
		web.close();
			

	}

}
