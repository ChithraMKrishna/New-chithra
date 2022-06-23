package com.crm.comcast.genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

	/**
	 * it is used to get common data from propert file based on the key which you have specified as a argument
	 * @return
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fs=new FileInputStream("./src/test/resources/prop.properties");
		Properties p=new Properties();
		p.load(fs);
		String value = p.getProperty(key);
		return value;
		
	}

	

}
