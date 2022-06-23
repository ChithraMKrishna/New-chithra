package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.comcast.genericUtilities.WebDriverUtility;

public class ContactDetailsPage extends WebDriverUtility
{
	
	//declaration
	
	@FindBy(name ="firstname")
	private WebElement firstnam;
	
	@FindBy(name="lastname")
	private WebElement lastnam;
	
	@FindBy(xpath ="//input[@value='T']")
	private WebElement Radbtn;
	
	@FindBy(name="leadsource")
	private WebElement leadsourcedropdown;
	
	@FindBy(name="assigned_group_id")
	private WebElement assignedto;
	
	@FindBy(name="salutationtype")
	private WebElement salutation;
	

	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement Savebtn;
	
	

	//initilization
	
	public ContactDetailsPage(WebDriver web)
	{
		PageFactory.initElements(web,this);
	}



	
	//utilization
	

	public WebElement getFirstnam()
	{
		return firstnam;
	}

	
	public WebElement getLastnam() 
	{
		return lastnam;
	}


	public WebElement getRadbtn() 
	{
		return Radbtn;
	}
	
	public WebElement getLeadsourcedropdown()
	{
		return leadsourcedropdown;
	}


	public WebElement getAssignedto()
	{
		return assignedto;
	}


	public WebElement getSalutation() 
	{
		return salutation;
	}

	
	//generic libraries
	
	public void contactDetails(String first_name,String last_name)
	{
		firstnam.sendKeys(first_name);
		lastnam.sendKeys(last_name);
		Radbtn.click();
				
	}
	
	public void selectSalutationDropdown(String slvalue)
	{
		selectDropdownByVText(salutation, slvalue);
	}
	
	public void selctleadSource(String leadvalue)
	{
		selectDropdownByVText(leadsourcedropdown, leadvalue);
	}
		
	public void selectassignedTo (String assignvalue)
	{
		selectDropdownByVText(assignedto, assignvalue);
	}
	

	public void saveAction()
	{
		Savebtn.click();
	}
	
	
}


