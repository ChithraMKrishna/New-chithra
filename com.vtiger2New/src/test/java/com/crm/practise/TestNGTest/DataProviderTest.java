package com.crm.practise.TestNGTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest 
{
	@Test(dataProvider = "bookTrainTicket")
	public void bookTicket(String src,String dest)
	{
		System.out.println("From"+src+"To"+dest);
	}
	@DataProvider
	public Object[][] bookTrainTicket()
	{
		Object[][] objArr =new Object[3][2];
		
		
		objArr[0][0]="Banglore";
		objArr[0][1]="kerala";
		
		objArr[1][0]="Banglore";
		objArr[1][1]="Mysore";
		
		objArr[2][0]="Banglore";
		objArr[2][1]="Himachal";
				
		return objArr;
	}
}
