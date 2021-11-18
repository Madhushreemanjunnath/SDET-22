package contacts;


import java.io.IOException;


import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.genericUtilies.BaseClass1;
import com.crm.vtiger.genericUtilies.ExcelUility;
import com.crm.vtiger.genericUtilies.FileUtility;
import com.crm.vtiger.genericUtilies.JavaUtilities;
import com.crm.vtiger.genericUtilies.WebDriverUtilities;

import Pom.Actions;
import Pom.BaseClass;
import Pom.ContactDetails;
import Pom.OpeningPage;
@Listeners(com.crm.vtiger.genericUtilies.ILisenter.class)
public class Assignment1 extends BaseClass
{
		@Test(groups= {"smoketest"})
	public  void createContactTest()  throws Throwable {
		
		//read data from property file
	  	   //read data from excel sheet
			ExcelUility eu=new ExcelUility();
			JavaUtilities ju=new JavaUtilities();
			WebDriverUtilities wb=new WebDriverUtilities();
	  	    //connection();
	    //Launch the 
	    //launchBrowser(driver);
			Assert.fail();
		//Login
	    //login(driver);
	
		
			//Action
		Thread.sleep(1000);
		OpeningPage a=new OpeningPage(driver);
		WebDriverUtilities wd=new WebDriverUtilities();
		
		wd.waitAndClick(a.getActions());
		String home=driver.getWindowHandle();
	   Actions a1=new Actions(driver);
	   String parent=driver.getWindowHandle();
	   System.out.println(parent);
	   a1.Cactions();
	   wd.waitForElementVisibilty(driver,a1.getAddcontact());
      
       //Contact Details
	  
       ContactDetails c=new ContactDetails(driver);
     
   
       c.enterDetails(driver);
       
       //Thread.sleep(2000);
       
       // Thread.sleep(1000);
        
			//logout
		//close Browser
		//close the connection

	}

}
