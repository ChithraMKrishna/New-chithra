package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebDriverUtility;

public class ProductDetailsPage extends WebDriverUtility
{
	
	//declaration
	
	@FindBy(name="productname")
	private WebElement pdtname;
	
	@FindBy(name="productcategory")
	private WebElement pdtcat;
	
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement vendrlukup;
	
	@FindBy(name ="search_text")
	private WebElement textbox;
	
	@FindBy(name = "search")
	private WebElement searchbtn;
	
	@FindBy(linkText = "HP")
	private WebElement clickvendor;
	
	@FindBy(name="manufacturer")
	private WebElement manufact;
	
	@FindBy(name="glacct")
	private WebElement giccount;
	
	@FindBy(xpath ="//input[@value='T']")
	private WebElement radbtn;
	
	@FindBy(xpath = "//input[@accesskey='S']")
	private WebElement savebtn;
	
	
	
	//initilization
	
	public ProductDetailsPage(WebDriver web) 
	{
		PageFactory.initElements(web, this);
	}
	
	//utilization
	
	public WebElement getPdtname()
	{
		return pdtname;
	}

	public WebElement getPdtcat() 
	{
	return pdtcat;
	}
	

	public WebElement getVendrlukup() 
	{
		return vendrlukup;
	}
	

	public WebElement getTextbox() 
	{
		return textbox;
	}

	public WebElement getSearchbtn() 
	{
		return searchbtn;
	}
	
	public WebElement getClickvendor() 
	{
		return clickvendor;
	}

	public WebElement getManufact() 
	{
		return manufact;
	}

	public WebElement getGiccount() 
	{
		return giccount;
	}

	public WebElement getRadbtn() 
	{
		return radbtn;
	}
	
	public WebElement getSavebtn() 
	{
		return savebtn;
	}

	//business libararies
	public void pdtDtails(String productName)
	{
		pdtname.sendKeys(productName);
	}
	public void selectdropdownpdtcatagory(String pdt_catagory)
	{
		pdtcat.sendKeys(pdt_catagory);
	}
	public void childwindow(WebDriver web,String vendor)
	{
		vendrlukup.click();
		switchToWindow(web, "Vendors&action");
		textbox.sendKeys(vendor);
		searchbtn.click();
		clickvendor.click();
		switchToWindow(web, "Administrator - Products - vtiger");
	}
	public void  adddtails(String manufacturer,String gl_account,WebDriver web)
	{	
		manufact.sendKeys(manufacturer);
		giccount.sendKeys(gl_account);
		savebtn.click();
	}

}

