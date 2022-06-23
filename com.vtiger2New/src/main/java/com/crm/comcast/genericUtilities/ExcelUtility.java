package com.crm.comcast.genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author abhishek
 *
 */

public class ExcelUtility {
	/**
	 * 
	 * 
	 */


	public String ReaddataFrom(String sheet,int row, int cell) throws Throwable
	{
		
		FileInputStream fs=new FileInputStream("./src/test/resources/exl.xlsx");
		Workbook wb=WorkbookFactory.create(fs);
		String c = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return c;
		
	}
	/**
	 * it is used to write data in to excel file
	 * @throws Throwable 
	 * 
	 */
public void writeDataIntoExcel(String sheet,int row, int cell, String data) throws Throwable 
{
	FileInputStream fs=new FileInputStream("./src/test/resources/exl.xlsx");
	Workbook wb=WorkbookFactory.create(fs);
	wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(data);
	FileOutputStream fileout=new FileOutputStream("./src/test/resources/exl.xlsx");
	wb.write(fileout);
	
	}
}
