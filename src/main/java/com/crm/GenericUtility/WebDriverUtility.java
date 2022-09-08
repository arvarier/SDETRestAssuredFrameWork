package com.crm.GenericUtility;


import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
/**
 * 
 * @author jithu
 *
 */

public class WebDriverUtility 
{

	/**
	 * to maximize the browser
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver  driver)
	{
		driver.manage().window().maximize();
	}

	/**
	 * to minimize the browser
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}

	/**
	 * to refresh the page
	 * @param driver
	 */
	public void refreshThePage(WebDriver driver)
	{
		driver.navigate().refresh();
	}

	/**
	 * to go back to previous page
	 * @param driver
	 */
	public void backToPreviousPage(WebDriver driver)
	{
		driver.navigate().back();
	}

	/**
	 * to go forward to next page
	 * @param driver
	 */
	public void forwardToNextPage(WebDriver driver)
	{
		driver.navigate().forward();
	}

	/**
	 * this method will wait till the page gets loaded
	 * @param driver
	 */
	public void waitTillPageGetsLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.implicitlyWaitDuration));
	}

	/**
	 * this method will wait till the element to click
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToClick(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * this method will wait till element to visible
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait  wait= new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this method will wait for title of the page
	 * @param driver
	 * @param title
	 */
	public void PageLoadTitle(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}

	/**
	 * this method will wait for the url of the page
	 * @param driver
	 * @param URL
	 */
	public void pageLoadUrl(WebDriver driver,String URL)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.urlContains(URL));
	}

	/**
	 * this method will ignore the NoSuchElementException for the particular findElement statement
	 * @param driver
	 */
	public void ignoreNoSuchElementException(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}

	/**
	 * this method will wait till the alert message to be visible
	 * @param driver
	 */
	public void waitForAlertMsg(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * this method is used to switch to frame using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}

	/**
	 * this method is used to switch to frame using id
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver, String id)
	{
		driver.switchTo().frame(id);
	}

	/**
	 * this method is used to switch to frame using element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}

	/**
	 * this method is used to switch to main frame
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}

	/**
	 * this method is used to select the element in a dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * this method is used to select the element in a dropdown using value
	 * @param element
	 * @param value
	 */
	public void select(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}

	/**
	 * this method is used to select the element in a dropdown using visibleText
	 * @param text
	 * @param element
	 */
	public void select(String text,WebElement element)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * this method is used to fetch all the options from the dropdown
	 * @param element
	 */
	public void getAllTheOptionsFromDropDown(WebElement element)
	{
		Select select=new Select(element);
		List<WebElement> option = select.getOptions();
		for(WebElement webElement : option)
		{
			String text = webElement.getText();
			System.out.println(text);
		}
	}

	/**
	 * this method is  used to mouse over on the element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}	

	/**
	 *this method is used to right click on element 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * this method is used to right click on element this method is used to double click on element 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick().perform();
	}

	/**
	 * this method is used to click enter key
	 * @param driver
	 */
	public void clickOnEnterKey(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * this method is used to take screenshot
	 * @param driver
	 * @param screenshotName
	 * @return 
	 */
/*	public static String takeScreenshot(WebDriver driver,String screenshotName)
	{
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File src=takesScreenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/"+screenshotName+".PNG");
		try {
			FileUtils.copyFile(src, dest);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return screenshotName;
	}

	/**
	 * this method will wait for the element as per custom wait 
	 * @param driver
	 */
	public void waitAndClickUsingCustomWait(WebDriver driver)
	{
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(10));
		wait.ignoring(NoSuchElementException.class);
	}

	/**
	 * this method is used for custom wait
	 * @param element
	 * @param duration
	 * @param pollingTime
	 */
	public void waitAndClick(WebElement element,int duration,long pollingTime)
	{
		int count=0;
		while(count<duration)
		{
			try 
			{
				element.click();
				break;
			}
			catch(Exception e)
			{
				try
				{
					Thread.sleep(1000);
				}
				catch(Exception e2)
				{
					e2.printStackTrace();
				}
				count++;
			}
		}
	}

	/**
	 * this method is used to switch to child window using page title
	 * @param driver
	 * @param actualTitle
	 */
	public void switchToWindow(WebDriver driver,String actualTitle)
	{
		Set<String> set = driver.getWindowHandles();
		for(String string : set)
		{
			driver.switchTo().window(string);
			String title = driver.getTitle();
			if(title.contains(actualTitle))
			{
				break;
			}
		}
	}

	/**
	 * this method is used to switch to child window using page url
	 * @param actualURL
	 * @param driver
	 */
	public void switchToWindow(String actualURL,WebDriver driver)
	{

		Set<String> set = driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String wId=it.next();
			driver.switchTo().window(wId);
			String url=driver.getCurrentUrl();
			if(url.contains(actualURL))
			{
				break;
			}
		}
	}

	/**
	 * this method is used to switch back to main window
	 */
	public void switchToMainWindow(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}

	/**
	 * this method is used to switch to alert popup and accept it
	 * @param driver
	 * @param expectedMsg
	 */
	public void switchToAlertPopUpAndAccept(WebDriver driver,String expectedMsg)
	{
		Alert alert=driver.switchTo().alert();
		if(alert.getText().trim().equalsIgnoreCase(expectedMsg.trim()))
		{
			System.out.println("Alert msg is verified");
		}
		else
		{
			System.out.println("Alert msg is not verified");
		}
		alert.accept();
	}

	/**
	 * this method is used to switch to alert popup and dismiss it
	 * @param driver
	 * @param expectedMsg
	 */
	public void switchToAlertPopUpAndDismiss(WebDriver driver,String expectedMsg)
	{
		Alert alert=driver.switchTo().alert();
		if(alert.getText().trim().equalsIgnoreCase(expectedMsg.trim()))
		{
			System.out.println("Alert msg is verified");
		}
		else
		{
			System.out.println("Alert msg is not verified");
		}
		alert.dismiss();
	}
	

}


