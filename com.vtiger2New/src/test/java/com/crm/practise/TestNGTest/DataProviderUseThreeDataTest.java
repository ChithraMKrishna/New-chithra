package com.crm.practise.TestNGTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUseThreeDataTest 
{
	@Test(dataProvider = "cashPayment")
	public void bankTransaction(String name,long accnum,int amount)
	{
		System.out.println("Name"+name+"Account Number"+accnum+"Amount"+amount);
	}
	
	@DataProvider
	public Object[][] cashPayment()
	{
		Object[][] objarr=new Object[3][3];
		
		objarr[0][0]="Maya";
		objarr[0][1]=19284999;
		objarr[0][2]=2500;
		
		objarr[1][0]="Vyga";
		objarr[1][1]=673828788;
		objarr[1][2]=300;
		
		objarr[2][0]="Gouri";
		objarr[2][1]=35678888;
		objarr[2][2]=500;
		
		return objarr;
	}
}
