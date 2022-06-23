package com.crm.objectRepository;

import javax.print.event.PrintJobAttributeEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebDriverUtility;

public class OrganizationDetailslookupPage extends WebDriverUtility
{
	//declaration
	
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement orgLookup;
	
	@FindBy(name="search_text")
	private WebElement textbox;
	
	@FindBy(name="search")
	private WebElement serachbtn;
	
	@FindBy(linkText = "Dell")
	private WebElement orgselect;
	
	//initilization
	
	public OrganizationDetailslookupPage(WebDriver web)
	{
		PageFactory.initElements(web,this);
	}

	
	//utilization
	
	
	public WebElement getOrgLookup() 
	{
		return orgLookup;
	}
	
	
	public WebElement getTextbox() 
	{
		return textbox;
	}
	
	

	public WebElement getOrgselect() {
		return orgselect;
	}


	public WebElement getSerachbtn() 
	{
		return serachbtn;
	}

	
//bussiness Library


	public void clickorglookup(WebDriver web,String orgname)
	{
		orgLookup.click();
		switchToWindow(web,"Accounts&action");
		textbox.sendKeys(orgname);
		serachbtn.click();
		orgselect.click();
		switchToWindow(web, "Administrator - Contacts ");
		
		
		
	}


}
