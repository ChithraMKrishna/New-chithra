package com.crm.comcast.createcontactwithorg.assognment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.comcast.genericUtilities.ExcelUtility;
import com.crm.comcast.genericUtilities.FileUtility;
import com.crm.comcast.genericUtilities.JavaUtility;
import com.crm.comcast.genericUtilities.WebDriverUtility;
import com.crm.objectRepository.ContactDetailsPage;
import com.crm.objectRepository.Createcontactlookup;
import com.crm.objectRepository.HeaderCheckPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.OrganizationDetailslookupPage;
import com.crm.objectRepository.SignOutPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactwithOrganization extends BaseClass {

	@Test
	public void createContactWithOrganTest() throws Throwable
	{
		//initializing webdriver
	/*	
				WebDriver web=null;
			
				//create objet for respective util class
				FileUtility fLib=new FileUtility();
				ExcelUtility eLib=new ExcelUtility();
				JavaUtility jLib=new JavaUtility();
				WebDriverUtility wLib=new WebDriverUtility();
				
				
				//fetching data from property file
				String url = fLib.getPropertyKeyValue("url");
				String username = fLib.getPropertyKeyValue("username");
				String password = fLib.getPropertyKeyValue("password");
				String browser = fLib.getPropertyKeyValue("browser");*/
				
				//fetching contact data from excel sheet
				
				String first_name=eLib.ReaddataFrom("sheet1", 8, 2);
				String last_name=eLib.ReaddataFrom("sheet1", 8, 3);
				String slvalue = eLib.ReaddataFrom("sheet1",10 ,4 );
				String leadvalue = eLib.ReaddataFrom("sheet1",13, 5);
				String assignvalue = eLib.ReaddataFrom("sheet1", 9, 6);
				String orgname = eLib.ReaddataFrom("sheet2",2 ,2 );
				
			/*	//verifying browser and launch
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
				
			//implicitylywait
				//web.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);*/
				wLib.waitForPageToLoad(web);
				
				//login
				
			//	LoginPage lpage=new LoginPage(web);
			//	lpage.loginToApplication(username, password);
				
				//inspect contacts
			
				HomePage hompg=new HomePage(web);
				hompg.createNewContact();
				
				Createcontactlookup contactlookup=new Createcontactlookup(web);
				contactlookup.createcontact();
				
				//WebElement sel = web.findElement(By.name("salutationtype"));
				
			//enter contact details
				ContactDetailsPage contactdtls=new ContactDetailsPage(web);
				contactdtls.selectSalutationDropdown(slvalue);
				
				
				
				/*List<WebElement> c = s.getOptions();
				
				
				for(WebElement values:c)
				{
					String text = values.getText();
					System.out.println(text);
				}*/

				
				contactdtls.contactDetails(first_name, last_name);
			
				/*WebElement opt = web.findElement(By.name("leadsource"));
				Select s1=new Select(opt);
				s1.selectByVisibleText("Partner");*/
				
				OrganizationDetailslookupPage orglookup=new OrganizationDetailslookupPage(web);
				orglookup.clickorglookup(web, orgname);
				
				
				contactdtls.selctleadSource(leadvalue);
				
				
				/*List<WebElement> v = s1.getOptions();
				for(WebElement value1:v)
				{
					String text1 = value1.getText();
					System.out.println(text1);
				}*/
				
			contactdtls.selectassignedTo(assignvalue);
				
			/*	List<WebElement> v1 = sl3.getOptions();
				for(WebElement value3:v1)
				{
					String a = value3.getText();
					System.out.println(a);
					
				}*/
				
			
				//scrolby
				JavascriptExecutor jse=(JavascriptExecutor) web;
				jse.executeScript("window.scrollBy(0,1000)");
				
				//file upload
				//WebElement ele = web.findElement(By.xpath("//input[@type='file']"));
				//ele.sendKeys("‪E:\\Live project\\New folder\\Project conversion -project3.docx");
				

					contactdtls.saveAction();

			//verify the contact is created or not
					//WebElement ac = web.findElement(By.xpath("//span[@class='dvHeaderText']"));
					
					HeaderCheckPage header=new HeaderCheckPage(web);
					
					String actual = header.getHeadercheck().getText();
				
					
					if(actual.contains(first_name))
					{
						System.out.println("oraganization added with is added");
					}
					else
					{
						System.out.println("organization not added with contact");
						
					}
					
					//inspect the signout	
					
				/*	SignOutPage sign=new SignOutPage(web);
					sign.signOutPage();
					
					web.close();*/
				

	}

}
