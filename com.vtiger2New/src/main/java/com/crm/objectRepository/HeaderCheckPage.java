package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderCheckPage
{
	//declaration
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headercheck;
	
	@FindBy(xpath ="//span[@class='lvtHeaderText']")
	private WebElement pdtheadercheck;
	
	//initialization
	
	public HeaderCheckPage(WebDriver web) 
	{
		PageFactory.initElements(web,this);
	}

		
	//utilization
	
	public  WebElement   getHeadercheck() 
	{
		return headercheck;
	}


	public WebElement getPdtheadercheck() 
	{
		return pdtheadercheck;
	}

	

}
