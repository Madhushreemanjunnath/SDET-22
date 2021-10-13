package com.crm.vtiger.genericUtilies;

import java.awt.Desktop.Action;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtilities {
	/**
	 * 
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);;
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
public void waitForElementVisibilty(WebDriver driver, WebElement element)
{
	WebDriverWait w= new WebDriverWait(driver,20);
	w.until(ExpectedConditions.visibilityOf(element));
	}
/**
 * 
 * @param element
 * @throws InterruptedException
 */
public void waitAndClick(WebElement element) throws InterruptedException
{
	int count=0;
	while(count<40)
	{
		try {
			element.click();
			break;
		}
		catch(Throwable e)
		{
			Thread.sleep(1000);
			count++;
		}
	}
}
/**
 * 
 * @param element
 * @param op
 */

public void selectOption(WebElement element,int op)
 {
	Select s=new Select(element);
	s.selectByIndex(op);
	
 }
/**
 * 
 * @param element
 * @param value
 */
public void selectValue(WebElement element,String value)
{
	Select s=new Select(element);
	s.selectByValue(value);
}
/**
 * 
 * @param element
 * @param text
 */

public void selectOption(WebElement element,String text)
{
	Select s=new Select(element);
	s.selectByVisibleText(text);
}
/**
 * 
 * @param driver
 * @param element
 */
public void mosueHover(WebDriver driver,WebElement element)
{
	Actions a=new Actions(driver);
	a.moveToElement(element).perform();
}
/**
 * 
 * @param driver
 * @param element
 */
 public void doubleClick(WebDriver driver,WebElement element)
 {
	 Actions a=new Actions(driver);
	 a.doubleClick(element).perform();
 }
 /**
  * 
  * @param driver
  * @param element
  */
 public void rightClick(WebDriver driver,WebElement element)
 {
	 Actions a=new Actions(driver);
	 a.contextClick(element).perform();
}
 /**
  * 
  * @param driver
  * @param src
  * @param dest
  */
 public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest) {
	 
	 Actions a=new Actions(driver);
	 a.dragAndDrop(src,dest);
 }
 /**
  * 
  * @param driver
  * @param ele
  * @param x
  * @param y
  */
 public void slider(WebDriver driver,WebElement ele, int x,int y)
 {
	 Actions a=new Actions(driver);
	 a.dragAndDropBy(ele,x,y);
 }
 /**
  * 
  * @param driver
  * @param partialWinTitle
  */
 public void switchToWindow(WebDriver driver,String partialWinTitle) {
	 Set<String> window=driver.getWindowHandles();
	 Iterator it=window.iterator();
	 while(it.hasNext())
	 {
		 String windit=(String) it.next();
		 String title=driver.switchTo().window(windit).getTitle();
		 if(title.contains(partialWinTitle));
		 break;
	 }
 }
/**
 * 
 * @param driver
 */
 public void acceptAlert(WebDriver driver)
 {
	 driver.switchTo().alert().accept();
	 
 }
 /**
  * 
  * @param driver
  */
  public void cancelAlert(WebDriver driver)
  {
	  driver.switchTo().alert().dismiss();
  }
  /**
   * 
   * @param driver
   * @param element
   */
  
  public void scrollToWebElement(WebDriver driver,WebElement element) {
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  int y =element.getLocation().getY();
	  js.executeScript("windowScrollBy(0"+y+")",element);
	  
  }
  /**
   * 
   * @param driver
   * @param index
   */
  
  public void switchFrame(WebDriver driver,int index)
  {
	  driver.switchTo().frame(index);
  }
  /**
   * 
   * @param driver
   * @param element
   */
  public void switchFrame(WebDriver driver,WebElement element)
  {
	  driver.switchTo().frame(element);
  }
  public void switchFrame(WebDriver driver,String idOrName)
  {
	  driver.switchTo().frame(idOrName);
  }
  public String takeScreenshot(WebDriver driver,String screenshotName) throws IOException
  {
	  String screenshotPath="./screenshot/"+screenshotName+JavaUtilities.getCurrentDte()+".PNG;";
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File src=ts.getScreenshotAs(OutputType.FILE);
	  File dest=new File(screenshotPath);
	  Files.copy(src,dest);
	  return screenshotPath;
  }
	  public void pressEnterKey() throws Throwable
	  {
		  Robot rc=new Robot();
		  rc.keyPress(KeyEvent.VK_ENTER);
		  rc.keyRelease(KeyEvent.VK_ENTER);
  }
}

