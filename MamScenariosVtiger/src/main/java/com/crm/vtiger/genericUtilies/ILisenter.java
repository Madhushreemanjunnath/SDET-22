package com.crm.vtiger.genericUtilies;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class ILisenter extends BaseClass1 implements ITestListener {
	
	public void onTestFailure(ITestResult result)
	{
EventFiringWebDriver ef =new EventFiringWebDriver(BaseClass1.staticDriver);
		File sourc=driver.getScreenshotAs(OutputType.FILE);
		
		 String screenshotPath=System.getProperty("user.dir")+"screenshotName//"+result.getMethod().getMethodName()+"_"+JavaUtilities.getCurrentDte()+".PNG;";
		  
		   File dest=new File(screenshotPath);
		  try{
			  Files.copy(source,dest);
		  }
		  catch(IOException e) {
			  e.printStackTrace();
		  }
	}

}
