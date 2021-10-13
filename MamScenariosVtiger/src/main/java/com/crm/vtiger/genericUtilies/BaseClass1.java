package com.crm.vtiger.genericUtilies;

import java.io.IOException;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import Pom.LoginPage;
import Pom.OpeningPage;

public class BaseClass1 {
	public static WebDriver staticDriver;
	public WebDriver driver=null;
	WebDriverUtilities wu=new WebDriverUtilities();
	
     public FileUtility fu=new FileUtility();
    @BeforeSuite(groups= {"smoketest","regressiontest"})
   public  void connection() throws Throwable
   {
    	//dlib.connection();
    	System.out.println("+++++ DB connection+++++");
   }
    @Parameters(value={"browser"})
    @BeforeClass(groups= {"smoketest","regressiontest"})
    public  void launchBrowser() throws Throwable
    {
    	//read the data from property file
    	String BROWSER=fu.getProperty("browser");
    	String URL=fu.getProperty("url");
    	if(BROWSER.equalsIgnoreCase("chrome"))
    	{
    		driver = new ChromeDriver();
    	}
    	else 
    		{driver=new FirefoxDriver();
    	
    		}
    	driver.get(URL);
    	driver.manage().window().maximize();
    	wu.waitUntilPageLoad(driver);
    	staticDriver=driver;
    	
    }  
    @BeforeMethod(groups= {"smoketest","regressiontest"})
    public void login() throws IOException, Throwable
    {//read from property
    	String USERNAME=fu.getProperty("username");
    	String PASSWORD=fu.getProperty("password");
    	//login
    	LoginPage lp=new LoginPage(driver);
    	lp.login(USERNAME,PASSWORD);
    }
    @AfterMethod(groups= {"smoketest","regressiontest"})
    
    public void logoutApp() throws InterruptedException
    {
    	//sign out of app
    	OpeningPage op=new OpeningPage(driver );
    	
         op.getVtiger().click();
         wu.waitAndClick(op.getLogout());
     	//op.getLogout().click();
    		
    }
    @AfterClass//(groups = {"smoketest","regressiontest"})
    public void closeBrowser()
    {
    	driver.close();
    	System.out.println("++++++++Browser closed++++++");
    }
    
    @AfterSuite(groups= {"smoketest","regressiontest"})
    public void closeDB( )
    {
    	//dlib.closeDB;
    	System.out.println("++++++++DB closed+++++++");
    }
}

