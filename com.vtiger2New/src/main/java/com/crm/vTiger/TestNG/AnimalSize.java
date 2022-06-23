package com.crm.vTiger.TestNG;

import static org.testng.Assert.fail;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AnimalSize {

	
	@Test(invocationCount = 5,priority = 2,retryAnalyzer =com.crm.comcast.genericUtilities.RetryAnalyser.class)//retryAnalyzer =com.crm.comcast.genericUtilities.RetryAnalyser.class
	
	public void elephantTest()
	{
		//System.out.println("big");
		Reporter.log("big");
		//Assert.fail();
	}
	
	@Test(invocationCount = 2)
	//@Test(enabled =true)
	//@Test(priority = 0)  default priority
	//@Test(alwaysRun = true)
	public void antTest()
	{
		System.out.println("small");//if it ails then that will be effect on the exexution of the elepant method
		//Assert.fail();
	}
	
	//@Test(priority = 3)
	//@Test(invocationCount = 0)  //it will skip..default invocation count is 1
	@Test(invocationCount = 1,dependsOnGroups = "antText",alwaysRun = true)  
	public void zebraTest()
	{
		System.out.println("medium");
		//Assert.fail();
	}
	
	
}
