package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage
{
	//Declaration
	
	@FindBy(name="user_name")
	private WebElement usernameTxt;
	
	@FindBy(name="user_password")
	private WebElement passwordTxt;
	
	@FindBy(id="submitButton")	
	private WebElement submitbtn;
	
		
	
	//Initialization
		
	public LoginPage(WebDriver web)
	{
	
		PageFactory.initElements(web, this);
	}


	
	//utilization

	public WebElement getUsernameTxt() 
	{
		return usernameTxt;
	}



	public WebElement getPasswordTxt()
	{
		return passwordTxt;
	}



	public WebElement getSearchbtn() 
	{
		return submitbtn;
	}
	
	
//bussiness libraries
	
	public void loginToApplication(String username,String password) 
	{
		usernameTxt.sendKeys(username);
		passwordTxt.sendKeys(password);
		submitbtn.click();
	}
	
	

}



