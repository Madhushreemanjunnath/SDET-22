package contacts;


import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.vtiger.genericUtilies.ExcelUility;
import com.crm.vtiger.genericUtilies.JavaUtilities;
import com.crm.vtiger.genericUtilies.WebDriverUtilities;
import Pom.Actions;
import Pom.AddContact;
import Pom.BaseClass;
import Pom.ContactDetails;
import Pom.CreateOrg;
import Pom.CreateOrgFullForm;
import Pom.OpeningPage;
import Pom.Org;

@Listeners(com.crm.vtiger.genericUtilies.ILisenter.class)
public class Assignment2 extends BaseClass{
	
	@Test(groups= {"smoketest","regressionTest"})
	public void  createContactWithOrganisationTest() throws InterruptedException, IOException, ParseException {
				
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
			String home=driver.getWindowHandle();
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
			driver.switchTo().window(home);
	
				
			//create contact
			
			wd.waitAndClick(a.getActions());
			a.getContacts().click();
			
			//click on contact
			
			AddContact ac=new AddContact(driver);
			wd.waitUntilPageLoad(driver);
			ac.getAddcontact().click();
			
			//addcontct page
			
			Actions as=new Actions(driver);
			wd.waitUntilPageLoad(driver);
			as.getcFullFomr().click();
			//
			
			ContactDetails act=new ContactDetails(driver);
			wd.waitUntilPageLoad(driver);
			act.cwo(driver);
			
			driver.switchTo().window(home);
			//logout
			
			
			
			}
			

		}
	