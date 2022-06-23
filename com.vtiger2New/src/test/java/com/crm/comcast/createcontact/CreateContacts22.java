package com.crm.comcast.createcontact;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.comcast.genericUtilities.ExcelUtility;
import com.crm.comcast.genericUtilities.FileUtility;
import com.crm.comcast.genericUtilities.JavaUtility;
import com.crm.objectRepository.ContactDetailsPage;
import com.crm.objectRepository.HeaderCheckPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContacts22 {

	public static void main(String[] args) throws Throwable
	{

		//initializing webdriver
		
		WebDriver web=null;
	
		//create objet for respective util class
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		
		//fetching data from property file
		String url = fLib.getPropertyKeyValue("url");
		String username = fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("password");
		String browser = fLib.getPropertyKeyValue("browser");
		
		//fetching contact data from excel sheet
		
		String first_name=eLib.ReaddataFrom("sheet1", 7, 2);
		String last_name=eLib.ReaddataFrom("sheet1", 7, 3);
		
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
		web.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//login
		
		web.findElement(By.name("user_name")).sendKeys(username);
		web.findElement(By.name("user_password")).sendKeys(password);
		web.findElement(By.id("submitButton")).click();
		
		
		//inspect contacts
		
		web.findElement(By.linkText("Contacts")).click();
		web.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		WebElement sel = web.findElement(By.name("salutationtype"));
		
		//enter contact details
		Select s=new  Select(sel);
		s.selectByVisibleText("Ms.");
		web.findElement(By.name("firstname")).sendKeys(first_name);
		web.findElement(By.name("lastname")).sendKeys(last_name);
		web.findElement(By.xpath("//input[@value='T']")).click();
		
	
		WebElement opt = web.findElement(By.name("leadsource"));
		Select s1=new Select(opt);
		s1.selectByVisibleText("Partner");
		
		WebElement opt2 = web.findElement(By.name("assigned_group_id"));
		Select sl3=new Select(opt2);
		sl3.selectByVisibleText("Support Group");
		
	
		//scrolby
		JavascriptExecutor jse=(JavascriptExecutor) web;
		jse.executeScript("window.scrollBy(0,1000)");
		
		//file upload
		//WebElement ele = web.findElement(By.xpath("//input[@type='file']"));
		//ele.sendKeys("‪E:\\Live project\\New folder\\Project conversion -project3.docx");
		
		 web.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 

			//verify the contact is created or not
			//WebElement ac = web.findElement(By.xpath("//span[@class='dvHeaderText']"));
		 
		  	HeaderCheckPage header=new HeaderCheckPage(web);
		
			String actual = header.getHeadercheck().getText();
			if(actual.contains("nair veena"))
			{
				System.out.println("contact is added");
			}
			else
			{
				System.out.println("contact is not added");
				
			}
			
			//inspect the signout	
			web.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			web.findElement(By.linkText("Sign Out")).click();
			
			web.close();

	}

}
