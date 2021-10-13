package contacts;


import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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


public class Assignment2 extends BaseClass{
	@Test(groups= {"smoketest"})
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
				String text=driver.findElement(By.xpath("//i[@class='text-white m-0 fa-accounts']/ancestor::div/descendant::span[contains(@class,'textOverflowEllipsis ml-2 w-90')]	")).getText();;
						
							System.out.println(text);
							if(text.contains(OrgName))
							{System.out.println("Success");}
							else
							{System.out.println("not Success");}
								
									Thread.sleep(1000);
									driver.findElement(By.xpath("//i[@class='fa fa-times h4 mb-0 c-pointer highlightText-hover close']")).click();
						
	
				
			//create contact
			
			wd.waitAndClick(a.getActions());
			wd.waitUntilPageLoad(driver);
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
			wd.waitUntilPageLoad(driver);
			act.getLastname().sendKeys("manajunath");
			act.getLead().click();
			act.getSave().click();
			
			
			}
			

		}
	