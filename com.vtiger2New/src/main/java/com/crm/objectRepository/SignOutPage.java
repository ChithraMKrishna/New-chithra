package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOutPage 
{
	//declaration
	
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logout; 
	
	@FindBy(linkText ="Sign Out")
	private WebElement signout;
	
	//initiallization
	
	public SignOutPage(WebDriver web)
	{
		PageFactory.initElements(web, this);
	}


	
	//utilization
	
	public WebElement getLogout() 
	{
		return logout;
	}
	
	public WebElement getSignout()
	{
		return signout;
	}

		
	//bussiness Libraries
	
	public void signOutPage()
	{
		logout.click();
	}
	
	public void signoutlnk() 
	{
		signout.click();
		
	}
}

