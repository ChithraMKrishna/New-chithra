package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createcontactlookup
{
	//declaration
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactLnk;

	
	//initialization

		public Createcontactlookup(WebDriver web)
		{
		PageFactory.initElements(web,this);
		}
		
		
	//utilization	
		public WebElement getCreateContactLnk() 
		{
			return createContactLnk;
		}	
		
	//bussiness Library
		public void createcontact()
		{
			createContactLnk.click();
		}
}
