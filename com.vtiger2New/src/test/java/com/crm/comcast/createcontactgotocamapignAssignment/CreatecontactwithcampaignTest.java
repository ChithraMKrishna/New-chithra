package com.crm.comcast.createcontactgotocamapignAssignment;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.comcast.genericUtilities.ExcelUtility;
import com.crm.comcast.genericUtilities.FileUtility;
import com.crm.comcast.genericUtilities.IPathConstants;
import com.crm.comcast.genericUtilities.JavaUtility;
import com.crm.comcast.genericUtilities.WebDriverUtility;
import com.crm.objectRepository.AddCampaignPage;
import com.crm.objectRepository.CampaignDetailsPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.ProductCreatePage;
import com.crm.objectRepository.ProductDetailsPage;
import com.crm.objectRepository.SignOutPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatecontactwithcampaignTest extends BaseClass
{

	@Test
	public void Createcontactwithcampaign() throws Throwable 
	{
		
		
	/*	//initializing webdriver
		
		WebDriver web=null;
		
		//create the object with respect to all utility classes
		
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		
		
		//fetching data from property file
		
		String url = fLib.getPropertyKeyValue("url");
		String username = fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("password");
		String browser = fLib.getPropertyKeyValue("browser");           */
		
		//fetching data from excel sheet
		String productName = eLib.ReaddataFrom("sheet3", 3, 0);
		String pdt_catagory = eLib.ReaddataFrom("sheet3",2 ,1 );
		String manufacturer = eLib.ReaddataFrom("sheet3",3 ,2 );
		String gl_account = eLib.ReaddataFrom("sheet3",5 ,3 );
		String campaignName = eLib.ReaddataFrom("campaign", 1, 0);
		String campaign_status = eLib.ReaddataFrom("campaign", 3,1 );
		String campaign_type = eLib.ReaddataFrom("campaign", 6, 2);
		
		
/*		
		//verifying browser and launch
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			System.setProperty(IPathConstants.chromeKey, IPathConstants.chromePath); 
			web=new ChromeDriver(); 
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			web=new FirefoxDriver();
			
		}
		else
		{
			System.setProperty(IPathConstants.chromeKey,IPathConstants.chromePath);
			//WebDriverManager.chromedriver().setup();
			web=new ChromeDriver();
		}
		*/
	
//random	
	
//int random = jLib.RandomNumber();	
		
		//fetching contact data from excel sheet
		
		//String organisationname=eLib.ReaddataFrom("sheet2",2, 2)+random;
		
		

		
		//WebDriver web=new ChromeDriver();
		
		web.manage().window().maximize();
	//	web.get(url);

		
		//implicitlywait
		
		wLib.waitForPageToLoad(web);

		//login
		
		/*web.findElement(By.name("user_name")).sendKeys(username);
		web.findElement(By.name("user_password")).sendKeys(password);
		web.findElement(By.id("submitButton")).click();*/

	/*	LoginPage lpage=new LoginPage(web);
		lpage.loginToApplication(username, password);		*/

		
	
			//web.findElement(By.linkText("Products")).click();
			HomePage hompg=new HomePage(web);
			hompg.product();
			
			//web.findElement(By.xpath("//img[@alt='Create Product...']")).click();
			ProductCreatePage pdt=new ProductCreatePage(web);
			pdt.pdctclick();
			
			
			//web.findElement(By.name("productname")).sendKeys("harddisk");
			
			/*WebElement opt = web.findElement(By.name("productcategory"));
			Select sl=new Select(opt);
			List<WebElement> element = sl.getOptions();
			for(WebElement count:element)
			{
				String value = count.getText();
				System.out.println(value);
			}
			sl.selectByVisibleText("Hardware");*/
			
			/*WebElement opt1 = web.findElement(By.name("manufacturer"));
			
			Select sl1=new Select(opt1);
			List<WebElement> v2 = sl1.getOptions();
			for(WebElement value:v2)
			{
				String text6 = value.getText();
				System.out.println(text6);
			}
			sl1.selectByVisibleText("MetBeat Corp");*/
			
			/*WebElement opt2 = web.findElement(By.name("glacct"));
			Select sl2=new Select(opt2);
			List<WebElement> opt1 = sl2.getOptions();
			for(WebElement count:opt1)
			{
				String text8 = count.getText();
				System.out.println(text8);
			}
			sl2.selectByVisibleText("301-Sales-Hardware");*/
			
			/*web.findElement(By.xpath("//input[@value='T']")).click();
			WebElement slc = web.findElement(By.id("my_file_element"));
			slc.sendKeys("‪E:\Live project\New folder\Project2 url.txt");*/
			
			
			
			ProductDetailsPage pdtcatag=new ProductDetailsPage(web);
			pdtcatag.pdtDtails(productName);
			pdtcatag.selectdropdownpdtcatagory(pdt_catagory);
		
			pdtcatag.adddtails(manufacturer, gl_account, web);
			
			//web.findElement(By.xpath("//input[@accesskey='S']")).click();

			//web.findElement(By.linkText("More")).click();
			
			HomePage hmpg=new HomePage(web);
			hmpg.moreLink();
			
			//Actions act=new Actions(web);
			//act.moveToElement(a);
			//web.findElement(By.linkText("Campaigns")).click();
			
			hmpg.campaign();
			
			
//	add campaign details	
			
			//web.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
			AddCampaignPage campaign=new  AddCampaignPage(web);
			campaign.campaignlookup();
			
			
			
			
			//web.findElement(By.name("campaignname")).sendKeys("puma shoes");
			//web.findElement(By.xpath("//input[@value='T']")).click();
			
			CampaignDetailsPage campdetail=new CampaignDetailsPage(web);
			campdetail.campaign1(campaignName, campaign_status, campaign_type);
			
//campaign status
			/*WebElement st = web.findElement(By.name("campaignstatus"));
			Select sel=new Select(st);
			
			
			List<WebElement> val = sel.getOptions();
			for(WebElement value:val)
			{
				String text3 = value.getText();
				System.out.println(text3);
			}
			
			sel.selectByVisibleText("Active");*/
			
	//campaign type
			
			/*WebElement act1=web.findElement(By.name("campaigntype"));
			Select sel1=new  Select(act1);
			
			List<WebElement> s = sel1.getOptions();
			for(WebElement element:s)
			{
				String a = element.getText();
				System.out.println(a);
			}
			
			sel1.selectByVisibleText("Webinar");*/
			
//add product
		//web.findElement(By.xpath("//img[@title='Select']")).click();
			 /*Set<String> allId = web.getWindowHandles();
			
			for(String ele:allId)
			 {
				web.switchTo().window(ele);
				String title = web.getTitle();
				System.out.println(title);
			 }
//select product
			web.findElement(By.name("search_text")).sendKeys("harddisk");
			web.findElement(By.name("search")).click();
			web.findElement(By.linkText("harddisk")).click();
			web.switchTo().defaultContent();
			
			web.findElement(By.xpath("//input[@accesskey='S']")).click();
			 */
			
			CampaignDetailsPage campdt=new CampaignDetailsPage(web);
			campdt.campaign2(web, productName);	

	/*		SignOutPage sign=new SignOutPage(web);
			sign.signOutPage();
			
			sign.signoutlnk();
			
			web.close();				*/
		}

	}


