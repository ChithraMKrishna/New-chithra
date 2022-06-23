package com.crm.comcast.genericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author abhishek
 *
 */

public class JavaUtility {
	/**
	 *it is used to generate a random number
	 * @return
	 */

	public int RandomNumber()
	{
		Random random=new Random();
		int randnum=random.nextInt(200);
		return randnum;
	}
	/**
	 * it is used to get systemdateandtime in ist format
	 * @return
	 */
	public String getSystemDateAndTimeInISTformat()
	{
		Date date=new Date();
		return date.toString();
	}
	
	/**
	 * it is used to get system date and time in required format
	 * @return
	 */
	public String getSystemDateAndTimeInFormat()
	{
		Date date=new Date();
		String dateAndTime = date.toString();
		
		String YYYY = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[1];
		int MM = date.getMonth()+1;
		
		String finalformat = YYYY+" "+MM+" "+DD;
		return finalformat;
		
	}
	

}
