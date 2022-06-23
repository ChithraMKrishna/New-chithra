package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreatePage
{
	//declaration
	@FindBy(xpath ="//img[@alt='Create Product...']")
	private WebElement pdctlookup;
	
	//initializaton
	public ProductCreatePage(WebDriver web) 
	{
		
		PageFactory.initElements(web, this);
	}

	
	//utiliztion	
	public WebElement getPdctlookup()
	{
		return pdctlookup;
	}
	
	//bussiness libraries
	
	public void pdctclick()
	{
		pdctlookup.click();	
	}
	
	
}
