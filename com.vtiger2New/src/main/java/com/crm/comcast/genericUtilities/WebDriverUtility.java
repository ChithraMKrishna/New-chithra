package com.crm.comcast.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
//import com.mysql.jdbc.Driver;

/**
 * 
 * @author abhishek
 *
 */

public class WebDriverUtility {
	private static final String PNG = null;


	/**
	 * it will take for 10 seconds till the page gets load
	 * @param driver
	 */

	public void waitForPageToLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

/**
 * it will check for the element in the GUI for polling time of 500ms
 * 
 * 
 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait  wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
/**
 * it will check for the title in the GUI for polling time of 500ms
 * 
 * 
 */

public void waitForTitleContains(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleContains(title));
	}

/**
 * here we can change the polling time tio any time
 * 
 * 
 */

public void waitForElementToCustom(WebDriver driver,int  pollingTime,WebElement element)
	{
		
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(pollingTime,TimeUnit.SECONDS);
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	
}

/**
 * 
 * here we are giving custom timeout
 * @throws InterruptedException 
 * @throws Throwable 
 * 
 */

public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count=0;
		while (count<10)
		{
			try
			{
				element.click();
			}
			catch (Exception e)
			{
				Thread.sleep(2000);
				count++;
			}
		
			
		}
	}
/**
 * used to switch from one window to another window
 * @param driver
 * @param partialwindow
 */
public void switchToWindow(WebDriver driver,String partialwindow)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while(itr.hasNext())
		{
			 String windowtitle = itr.next();
			 driver.switchTo().window(windowtitle);
			 String currentWindow = driver.getTitle();
			 if(currentWindow.contains(partialwindow))
			 {
				 break;
			 }
		}
	
	}

/**
 * 
 * switch from one window to another window by using index	
 */

public void switchToFrame(WebDriver driver,int index) 
	{
		
		driver.switchTo().frame(index);
	
	}

/**
 * switch from one frame to another frame by using id_attribute
 * 
 */
public void switchToFrame(WebDriver driver,String id_attribute) 
	{
		driver.switchTo().frame(id_attribute);
	}

/**
 * 
 * switch from one frame to another frame by using absolute_path
 */

public void switchToFrame(WebDriver driver,WebElement element) 
	{
		driver.switchTo().frame(element);
	
	}

/**
 * 
 * it is used to switch back from one child frame to parent frame
 */
public void switchBackToMainPage(WebDriver driver)
	{	
		driver.switchTo().defaultContent();
	}

/**
 * it is used to switch to alert popup and accept
 * 
 */
public void switchToAlertPopupAndAccept(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}

/**
 * it is used to switch to alert popup and dismiss 
 * 
 */
public void switchToalertPopupAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();

	}


/**
 * it is used to switch to select dropdown by using value 
 * 
 */
public void selectDropdown(WebElement element,String value) 
	{
		Select sl=new Select(element);
		sl.selectByValue(value);
	}

/**
 * it is used to switch to select dropdown by using visible text
 * 
 */
public void selectDropdownByVText(WebElement element,String visible_text) 
	{
		Select sl=new Select(element);
		sl.selectByVisibleText(visible_text);
	}


/**
 * it is used to mousehover an element
 * 
 */

public void mouseHoverAnElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}


/**
 * it is used to right click an element
 * 
 */
public void rightClickOnelement(WebDriver driver,WebElement element) 
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}

/**
 * it is used to click on enter button using keyboard actions
 * 
 */
public void clickOnEnterButton(WebDriver driver) 
	{
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}


/**
 * it is used to take screeshot
 * @throws IOException 
 * 
 */
public static String takeScreeshot(WebDriver driver,String screenshotName) throws IOException
	{
		TakesScreenshot takescreenshot=(TakesScreenshot) driver;
		File src = takescreenshot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+screenshotName+".PNG");
		Files.copy(src, dst);
		
		return screenshotName;
	}


/**
 * it is used to perform scrollbar actions
 * 
 */
public void srollByActions(WebDriver driver) 
	{
		JavascriptExecutor javascrit=(JavascriptExecutor) driver;
		javascrit.executeScript("window.scrollBy(0,500)");
	}
}
