package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

public class HomePage
{
	
	//declaration
	@FindBy(linkText="Contacts")
	private WebElement contactLnk;
	
	
	@FindBy(linkText ="Organizations")
	private WebElement organizsationLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productLnk;
	
	@FindBy(linkText = "More")
	private WebElement moreLnk;

	@FindBy(linkText ="Campaigns")
	private WebElement campaignLnk;
	
	//initialization

	public HomePage(WebDriver web)
	{
	PageFactory.initElements(web,this);
	}
	
	
	//utilization
	
	public WebElement getContactLnk()
	{
		return contactLnk;
	}
	

	public WebElement getOrganizsationLnk()
	{
		return organizsationLnk;
	}


	
	
	public WebElement getProductLnk() 
	{
		return productLnk;
	}

	public WebElement getMoreLnk() 
	{
		return moreLnk;
	}

	public WebElement getCampaignLnk()
	{
		return campaignLnk;
	}

	
//bussiness Libraries
	

	public void createNewContact()
	{
		contactLnk.click();
		
	}
	
	public void createOrganization()
	{
		organizsationLnk.click();
		
	}
	public void product() 
	{
		productLnk.click();
	}
	
	public void moreLink()
	{
		moreLnk.click();
		
	}
	public void campaign() 
	{
		campaignLnk.click();
	}
	
}
