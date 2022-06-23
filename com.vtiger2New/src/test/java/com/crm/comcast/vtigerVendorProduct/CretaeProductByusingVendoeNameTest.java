package com.crm.comcast.vtigerVendorProduct;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CretaeProductByusingVendoeNameTest {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver web=new ChromeDriver();
		web.manage().window().maximize();
		web.get("http://localhost:8888/");
		web.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//login
		web.findElement(By.name("user_name")).sendKeys("admin");
		web.findElement(By.name("user_password")).sendKeys("admin");
		web.findElement(By.id("submitButton")).click();
		
		WebElement ele = web.findElement(By.linkText("More"));
		Actions act=new Actions(web);
		act.moveToElement(ele).perform();
		 web.findElement(By.linkText("Vendors")).click();
		 
		 web.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		 web.findElement(By.name("vendorname")).sendKeys("HP");
		 web.findElement(By.xpath("//input[@type='submit']")).click();
		 
		 web.findElement(By.linkText("Products")).click();
		 web.findElement(By.xpath("//img[@title='Create Product...']")).click();
		 web.findElement(By.name("productname")).sendKeys("Mouse");
		 web.findElement(By.xpath("//img[@title='Select']")).click();
		 
	
		 Set<String> allId = web.getWindowHandles();
		
		for(String child1:allId) 
		 {
			 web.switchTo().window(child1);
			 String title = web.getTitle();
			 System.out.println(title);
		 
		 if(title.contains("Vendors&action"))
		 {
			 break;
		 }
	   
		 }
		web.findElement(By.id("search_txt")).sendKeys("HP");
		web.findElement(By.name("search")).click();
		web.findElement(By.id("2")).click();
		
		 Set<String> allId1 = web.getWindowHandles();
			
			for(String child1:allId1) 
			 {
				 web.switchTo().window(child1);
				 String title = web.getTitle();
				 System.out.println(title);
				 
			 
			
			 }
		web.switchTo().defaultContent();
		
		
		//to inspect save button
		web.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verification
		WebElement text = web.findElement(By.xpath("//span[text()='Mouse -  Product Information']"));
		String actual =text.getText();
		System.out.println(actual);
		String expected = "Product Information";
	if(expected.contains(actual))
		{
			System.out.println("product is added");
		}
		else
		{
			System.out.println("product is not added");
		}       
		
	
		
	   
		web.close();
	}
	
}
