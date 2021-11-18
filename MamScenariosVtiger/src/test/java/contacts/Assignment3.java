package contacts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.genericUtilies.DataBaseData;
import com.crm.vtiger.genericUtilies.ExcelUility;
import com.crm.vtiger.genericUtilies.FileUtility;
import com.crm.vtiger.genericUtilies.JavaUtilities;
import com.crm.vtiger.genericUtilies.WebDriverUtilities;

import Pom.BaseClass;
import Pom.CreateOrg;
import Pom.CreateOrgFullForm;
import Pom.LoginPage;
import Pom.OpeningPage;
import Pom.Org;

public class Assignment3 extends BaseClass
{
	@Test(groups= {"smoketest"})
	public void createOrganisationTest() throws Throwable
	{
		
      //read data from property file
  	   //read data from excel sheet
		ExcelUility eu=new ExcelUility();
		JavaUtilities ju=new JavaUtilities();
  	String OrgName=eu.getDataFromexcel("Sheet1",0,0)+"_"+ju.getRandomData();
    String email=eu.getDataFromexcel("Sheet1",0,1);
    String  employee=eu.getDataFromexcel("Sheet1",0,2);
    String phone=eu.getDataFromexcel("Sheet1",0,3);
       
    //connection();
    //Launch the 
    //launchBrowser(driver);
	//Login
    //login(driver);
	
		//Action
	Thread.sleep(1000);
	OpeningPage a=new OpeningPage(driver);
	WebDriverUtilities wd=new WebDriverUtilities();
	
	wd.waitAndClick(a.getActions());
	wd.waitAndClick(a.getOrg());
	//organisation
	Org o=new Org(driver);
	wd.waitAndClick(o.getAddorg());
	//click on full form
	CreateOrgFullForm cof=new CreateOrgFullForm(driver);
	wd.waitAndClick(cof.getOrgname());
	
	//Enter info Details
	CreateOrg co=new CreateOrg(driver);
	Thread.sleep(1000);
	//wd.waitForElementVisibilty(driver,co.getOrgname());
	co.createOrgAction(driver,OrgName,email, employee,phone);
	
	//verify
	System.out.println(OrgName);
		wd.waitForElementVisibilty(driver,o.getGetOrgName());
		wd.switchToWindow(driver,"Accounts&sortfield");		
		o.getSearch().click();
		o.getEnterKey().sendKeys("Manju");
		o.getEnterKey().sendKeys(Keys.ENTER);
		wd.waitForElementVisibilty(driver,o.getEnterKey());
		String text=driver.findElement(By.xpath("//i[@class='text-white m-0 fa-accounts']/ancestor::div/descendant::span[contains(@class,'textOverflowEllipsis ml-2 w-90')]	")).getText();
				
					System.out.println(text);
					if(text.contains(OrgName))
					{System.out.println("Success");}
					else
					{System.out.println("not Success");}
						
							Thread.sleep(1000);
							driver.findElement(By.xpath("//i[@class='fa fa-times h4 mb-0 c-pointer highlightText-hover close']")).click();
			//logout
					//close Browser
					//close the connection
	
	}

}