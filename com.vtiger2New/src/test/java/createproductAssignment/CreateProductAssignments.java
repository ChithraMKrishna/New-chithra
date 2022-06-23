package createproductAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericUtilities.BaseClass;
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

public class CreateProductAssignments extends BaseClass{
//
	@Test
	public void cteproductAssignment() throws Throwable 
	{
				   
		
//fetching contact data from excel sheet
		
		String productname = eLib.ReaddataFrom("sheet3",3 ,0 );
		String manufacturer = eLib.ReaddataFrom("sheet3", 2, 2);
		String vendor = eLib.ReaddataFrom("sheet3", 1, 4);
		String pdt_catagory = eLib.ReaddataFrom("sheet3", 2, 1);
		String gl_account = eLib.ReaddataFrom("sheet3",7 , 3);
		
		
		
	//implicitlywait
		//web.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wLib.waitForPageToLoad(web);			
		
		
		
		//implicitly wait
		wLib.waitForPageToLoad(web);	
		 
		//inspect contacts
	
		HomePage hompg=new HomePage(web);
		hompg.product();
		
		ProductCreatePage pdtcreate=new ProductCreatePage(web);
		pdtcreate.pdctclick();
		
		ProductDetailsPage pdtdtls=new ProductDetailsPage(web);
		pdtdtls.pdtDtails(productname);
		pdtdtls.selectdropdownpdtcatagory(pdt_catagory);
		pdtdtls.adddtails(manufacturer, gl_account, web);
		
		
		
		HeaderCheckPage header=new HeaderCheckPage(web);
		
		String actual = header.getPdtheadercheck().getText();
	
		
	/*	if(actual.contains(productname))
		{
			System.out.println("product is added");
		}
		else
		{
			System.out.println("product is not added");
			
		}			*/
		
		SoftAssert sart=new SoftAssert();
		sart.assertTrue(actual.contains(productname));
		sart.assertAll();
		
			
	

	}
}


