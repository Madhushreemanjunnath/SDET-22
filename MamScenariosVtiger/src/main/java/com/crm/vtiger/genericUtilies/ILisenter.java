package com.crm.vtiger.genericUtilies;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import Pom.BaseClass;

public class ILisenter extends BaseClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	
	
	public void onTestStart(ITestResult result) {
		//step3: create test method
		test=report.createTest(result.getMethod().getMethodName());
		
	}

	
	public void onTestSuccess(ITestResult result) {
		//step4: log for Pass methods
		test.log(Status.PASS, result.getMethod().getMethodName()+" is Passed");
	}

	public void onTestFailure(ITestResult result)
	{
		Object obj=result.getInstance();
		WebDriver driver=null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(obj);
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
EventFiringWebDriver ef =new EventFiringWebDriver(driver);
		File source=ef.getScreenshotAs(OutputType.FILE);
		
		 String screenshotPath="./screenshot/"+result.getMethod().getMethodName()+JavaUtilities.getCurrentDte()+".jpeg";;
		  
		   File dest=new File(screenshotPath);
		  try{
			  Files.copy(source,dest);
		  }
		  catch(IOException e) {
			  e.printStackTrace();
		  }
		  test.log(Status.FAIL, result.getMethod().getMethodName()+" is Failed");
			test.log(Status.FAIL, result.getThrowable());
			test.addScreenCaptureFromPath(screenshotPath);
			
		}


		public void onTestSkipped(ITestResult result) {
			//step6: log for skip methods
			test.log(Status.SKIP, result.getMethod().getMethodName()+" is Skipped");
			test.log(Status.SKIP, result.getThrowable());
			
		}


		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			
			
		}


		public void onStart(ITestContext context) {
			//Step1: Configuration
			ExtentSparkReporter htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/extentreport"+JavaUtilities.getCurrentDte()+".html");
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setDocumentTitle("Vtiger Automation Report");
			htmlReporter.config().setReportName("Execution Report");
			//step2: attaching report and system info
			 report=new ExtentReports();
			report.attachReporter(htmlReporter);
			report.setSystemInfo("OS", "Windows");
			report.setSystemInfo("Url", "http://localhost:8888/");
			report.setSystemInfo("Platform", "Windows10");
			report.setSystemInfo("Repoter Name", "Madhushree");
		}

		
		public void onFinish(ITestContext context) {
			//step7: flush the report
			report.flush();
			
		}

	

	}
	


	
	
	
	
	
	
	
	
	
	


