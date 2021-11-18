package Pom;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.vtiger.genericUtilies.FileUtility;
     
import com.crm.vtiger.genericUtilies.WebDriverUtilities;


public class BaseClass {
	public WebDriver driver=null;
	WebDriverUtilities wu=new WebDriverUtilities();
	public static WebDriver sdriver;c
	
     public FileUtility fu=new FileUtility();
    @BeforeSuite(groups= {"smoketest"})
   public  void connection() throws Throwable
   {
    	//dlib.connection();
    	System.out.println("+++++ DB connection+++++");
   }
    
    @BeforeClass(groups= {"smoketest"})
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
    	sdriver=driver;
    	
    }  
    @BeforeMethod(groups= {"smoketest"})
    public void login() throws IOException, Throwable
    {//read from property
    	String USERNAME=fu.getProperty("username");
    	String PASSWORD=fu.getProperty("password");
    	//login
    	LoginPage lp=new LoginPage(driver);
    	lp.login(USERNAME,PASSWORD);
    }
    @AfterMethod(groups= {"smoketest"})
    
    public void logoutApp() throws InterruptedException
    {
    	//sign out of app
    	Thread.sleep(1000);
    	OpeningPage op=new OpeningPage(driver );
    	wu.waitAndClick(op.getVtiger());
    	  Thread.sleep(2000);
     	op.getLogout().click();
    		
    }
    @AfterClass(groups= {"smoketest"})
    public void closeBrowser()
    {
    	driver.close();
    	System.out.println("++++++++Browser closed++++++");
    }
    
    @AfterSuite(groups= {"smoketest"})
    public void closeDB( )
    {
    	//dlib.closeDB;
    	System.out.println("++++++++DB closed+++++++");
    }
}