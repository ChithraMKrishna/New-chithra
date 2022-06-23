package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCampaignPage 
{
	//declaration
	
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private  WebElement campaigncreate;
	
	
	//initialization
	
	public  AddCampaignPage(WebDriver web) 
	{
		PageFactory.initElements(web, this);
	}
	
	//utilization
	
	public WebElement getCampaigncreate()
	{
		return campaigncreate;
	}
	
	
	//business libraries
	
	public void campaignlookup()
	{
		campaigncreate.click();	
	}

	
}
