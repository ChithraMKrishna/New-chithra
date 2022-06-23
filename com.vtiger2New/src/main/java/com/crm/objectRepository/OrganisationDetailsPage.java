package com.crm.objectRepository;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebDriverUtility;

public class OrganisationDetailsPage extends WebDriverUtility
{
	//declaration
	
	@FindBy(name="accountname")
	private WebElement accname;
	

	@FindBy(name="industry")
	private WebElement dropdownindustry;
	
	@FindBy(name="accounttype")
	private WebElement dropdownType;
	
	@FindBy(name="rating")
	private WebElement dropdownRating;
	
	@FindBy(xpath = "//input[@accesskey='S']")
	private WebElement radbtn;
	
	
	//initialization

	public  OrganisationDetailsPage(WebDriver web)
	{
		PageFactory.initElements(web, this);
	}


	//utilization
	

	public WebElement getAccname() 
	{
		return accname;
	}
	
	public WebElement getDropdownindustry()
	{
		return dropdownindustry;
	}


	public WebElement getDropdownType()
	{
		return dropdownType;
	}


	public WebElement getDropdownRating() 
	{
		return dropdownRating;
	}


	public WebElement getRadbtn()
	{
		return radbtn;
	}


	
	//bussiness libraries
	


	public void organizatndtils(String  organisationname )
	{
		accname.sendKeys(organisationname);
		
	}
	
	public void selectIndustry(String industryType)
	{
		dropdownindustry.sendKeys(industryType);
	}
	
	public void selectType(String type)
	{
		dropdownType.sendKeys(type);
	}
	
	public void selectRating(String rating )
	{
		dropdownRating.sendKeys(rating);
	}
  public void selectorgbtn() 
  {
	  
	 radbtn.click();  
  }

}

