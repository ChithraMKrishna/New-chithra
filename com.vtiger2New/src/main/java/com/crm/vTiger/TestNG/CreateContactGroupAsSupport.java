package com.crm.vTiger.TestNG;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.comcast.genericUtilities.ExcelUtility;
import com.crm.comcast.genericUtilities.FileUtility;
import com.crm.comcast.genericUtilities.IPathConstants;
import com.crm.comcast.genericUtilities.JavaUtility;
import com.crm.comcast.genericUtilities.WebDriverUtility;
import com.crm.objectRepository.ContactDetailsPage;
import com.crm.objectRepository.Createcontactlookup;
import com.crm.objectRepository.HeaderCheckPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.SignOutPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactGroupAsSupport extends BaseClass {

	
	public void createContactGroupAsSupport() throws Throwable
	{
		

	/*	//initializing webdriver
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
		String browser =fLib.getPropertyKeyValue("browser");      */
		
		//fetching contact data from excel sheet
		
		String first_name=eLib.ReaddataFrom("sheet1", 8, 2);
		String last_name=eLib.ReaddataFrom("sheet1", 8, 3);
		String assignvalue = eLib.ReaddataFrom("sheet2", 2, 6);
		String slvalue = eLib.ReaddataFrom("sheet1", 10, 4);
		
/*		//verifying browser and launch
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty(IPathConstants.chromeKey, IPathConstants.chromePath);
			//WebDriverManager.chromedriver().setup();
			 web=new ChromeDriver(); 
		}
		else if (browser.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			web=new FirefoxDriver();
			
		}
		else
		{
			System.setProperty(IPathConstants.chromeKey,IPathConstants.chromePath);
			//WebDriverManager.chromedriver().setup();
			web=new ChromeDriver();
		}
		
		// web=new ChromeDriver();
		web.manage().window().maximize();
		web.get(url);          
		
		wLib.waitForPageToLoad(web);
		//web.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);    */
		
//login
		/*web.findElement(By.name("user_name")).sendKeys(username);
		web.findElement(By.name("user_password")).sendKeys(password);
		web.findElement(By.id("submitButton")).click();*/
		
/*		LoginPage loginpg=new LoginPage(web);
		loginpg.loginToApplication(username, password);    */
		
		
//inspect contacts

		
		
		HomePage hompg=new HomePage(web);
		hompg.createNewContact();
		
		Createcontactlookup contactlookup=new Createcontactlookup(web);
		contactlookup.createcontact();
		
		/*web.findElement(By.linkText("Contacts")).click();
		web.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		WebElement sel = web.findElement(By.name("salutationtype"));*/
		
		
	//enter contact details
		
		//Select s=new  Select(sel);
		//s.selectByVisibleText("Ms.");
		/*wLib.selectDropdownByVText(sel,"Ms.");
		web.findElement(By.name("firstname")).sendKeys(first_name);
		web.findElement(By.name("lastname")).sendKeys(last_name);
		web.findElement(By.xpath("//input[@value='T']")).click();*/
		
	
		ContactDetailsPage contactdtls=new ContactDetailsPage(web);
		contactdtls.selectSalutationDropdown(slvalue);
		contactdtls.contactDetails(first_name, last_name);
		contactdtls.selectassignedTo(assignvalue);
		contactdtls.saveAction();
		
       Assert.fail();
		
		
		//WebElement opt2 = web.findElement(By.name("assigned_group_id"));
		//Select sl3=new Select(opt2);
		//sl3.selectByVisibleText("Marketing Group");
		//wLib.selectDropdownByVText(opt2, "Marketing Group");
		
		//web.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
//verify contact is created
		
		//WebElement ac = web.findElement(By.xpath("//span[@class='dvHeaderText']"));
		HeaderCheckPage headercheck=new HeaderCheckPage(web);
		
		String actual = headercheck.getHeadercheck().getText();
		String expected = first_name;
				
	/*	if(actual.contains(expected))
		{
			System.out.println("contact is added with assigned to support group");
		}
		else
		{
			System.out.println("contact is not added");
		}								*/
		
		
	SoftAssert sart=new SoftAssert();
	sart.assertTrue(actual.contains(expected));
	sart.assertAll();
		
		//screenshot
	//	wLib.takeScreeshot(web,"contacts");				
		
//inspect signout button
		
		//web.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//web.findElement(By.linkText("Sign Out")).click();
	/*	SignOutPage sign=new SignOutPage(web);
		sign.signOutPage();
		
		web.close();             */
			
	}

}
