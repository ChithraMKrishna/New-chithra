package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebDriverUtility;

public class CampaignDetailsPage extends WebDriverUtility
 {
	//declaration
	
	@FindBy(name="campaignname")
	private WebElement campaignname;

	@FindBy(xpath ="//input[@value='T']")
	private WebElement assignTo;
	
	@FindBy(name="campaignstatus")
	private WebElement campaignstatus;
	
	@FindBy(name="campaigntype")
	private WebElement campaignType;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement addProductlookup;
	
	@FindBy(name ="search_text")
	private WebElement searchTxt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(linkText="harddisk")
	private WebElement selectProduct;
	
	@FindBy(xpath="//input[@accesskey='S']")
	private WebElement savebtn;
	
	//initialization

	public CampaignDetailsPage(WebDriver web)
	{
		
		PageFactory.initElements(web, this);
	}


	
	//utilization

	public WebElement getCampaignname() 
	{
		return campaignname;
	}


	public WebElement getAssignTo() 
	{
		return assignTo;
	}
	
	public WebElement getCampaignstatus() 
	{
		return campaignstatus;
	}

	public WebElement getCampaignType() 
	{
		return campaignType;
	}
	
	public WebElement getAddProductLookUp() 
	{
		return addProductlookup;
	}
	
	public WebElement getSearchTxt()
	{
		return searchTxt;
	}


	public WebElement getSearchBtn() 
	{
		return searchBtn;
	}

	
	public WebElement getSelectProduct() 
	{
		return selectProduct;
	}

	public WebElement getSavebtn() 
	{
		return savebtn;
	}

	
	//business libraries

	public void campaign1(String campaignName,String campaign_status,String campaign_type) 
	{
		campaignname.sendKeys(campaignName);
		assignTo.click();
		campaignstatus.sendKeys(campaign_status);
		campaignType.sendKeys(campaign_type);
			}

	public void campaign2(WebDriver web,String productName) 
	{
		addProductlookup.click();
		switchToWindow(web,"Products&action");
		searchTxt.sendKeys(productName);
		searchBtn.click();
		selectProduct.click();
		switchToWindow(web,"Administrator - Campaigns");
		savebtn.click();
	
	
	}
}
