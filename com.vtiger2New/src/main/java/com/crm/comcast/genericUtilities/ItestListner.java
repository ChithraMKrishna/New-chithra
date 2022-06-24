package com.crm.comcast.genericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ItestListner implements ITestListener
{

	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=report.createTest(result.getMethod().getMethodName());
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.PASS,result.getMethod().getMethodName());
		test.log(Status.PASS,result.getThrowable());
	}

	public void onTestFailure(ITestResult result) 
	{
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL,result.getThrowable());
		
		try {
			
			String screenshotName = WebDriverUtility.takeScreeshot(BaseClass.sdriver, result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
//		String testName = result.getMethod().getMethodName();
//		Reporter.log(testName+"=====executing===",true);
//		
//		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
//		File src = edriver.getScreenshotAs(OutputType.FILE);
//		
//		try
//		{
//		
//			FileUtils.copyFile(src, new File("./screenshot/"+testName+".PNG"));
//			
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//		
	
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReports/report.html");
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Frame work extent report");
		spark.config().setDocumentTitle("Chithra's document");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		
		report.setSystemInfo("created by ","chithra");
		report.setSystemInfo("Reviewed by ","sanjaya");
		report.setSystemInfo("platform","windows");
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		report.flush();
		
	}
	
	

}
