package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage 
{
	
	//declaration
	
	@FindBy(xpath ="//img[@alt='Create Organization...']")
	private WebElement createorg;
	
	
	//initialization
	
	public CreateOrganizationPage(WebDriver web)
	{
		PageFactory.initElements(web,this);
	}


	//utilization
	
	public WebElement getCreateorg() 
	{
		return createorg;
	}
	
	
	//business libararies
	public void CreateOrg()
	{
		createorg.click();
	}
	
}
