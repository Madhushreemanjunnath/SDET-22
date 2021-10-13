package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericUtilies.WebDriverUtilities;
/**
 * 
 * @author Manjunath
 *
 */
public class CreateOrg extends WebDriverUtilities
{
	
	
	@FindBy(xpath="//input[@class='form-control'][1]")
	private WebElement orgname;
	
	//website
	@FindBy(xpath="//input[@name='email1']")
private WebElement email1;//sendKeys(email);
		   

	//employee
	@FindBy(xpath="//input[@name='employees']")
private WebElement employees;//sendKeys(employee)
		   //phone
	@FindBy(xpath="//input[@name='phone']")
private WebElement phone1;//;.sendKeys(phone);
	
	//industry
	@FindBy(xpath="//select[@name='industry']/option[text()='Government']")
	private WebElement  industry;//.click();
		
		   //annualrevuen 
		 @FindBy(xpath="//input[@name='annual_revenue_currency_value']")
		 private WebElement annual_rev;//).sendKeys("10000");
		
		   //member of 
		   @FindBy(xpath="//i[@class='fa-accounts']")
		   private WebElement memeber;//).click();
		   
		  	@FindBy(xpath="(//a[text()='Acme (demo)'])2")
		  	private WebElement memberassign;
		  	
		  ////*[text()='Eliud KIPCHOGE']/ancestor::div/descendant::  and span[@class='result-medal result-medal--gold']


		@FindBy(xpath="//*[text()='Creating Organization : ']/ancestor::div/descendant::button[@class='btn btn-primary py-7-5 px-3 ml-3']")
				private WebElement save; //)).click();
		
	
		
	public CreateOrg(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}


	public WebElement getMemberassign() {
		return memberassign;
	}

	public WebElement getEmail1() {
		return email1;
	}
	public WebElement getOrgname() {
		return orgname;
	}
	public WebElement getPhone1() {
		return phone1;
	}

public WebElement getEmployees() {
		return employees;
	}
	public WebElement getIndustry() {
		return industry;
	}
	public WebElement getAnnual_rev() {
		return annual_rev;
	}

	public WebElement getMemeber() {
		return memeber;
	}

	public WebElement getSave() {
		return save;
	}
	public void createOrgAction(WebDriver driver,String OrgName,String email,String employee,String phone) throws InterruptedException {

		Thread.sleep(1000);
		getOrgname().sendKeys(OrgName);
		Thread.sleep(1000);
		/*email1.sendKeys(email);
		Thread.sleep(1000);
		employees.sendKeys(employee);
		phone1.sendKeys(phone);
		Thread.sleep(1000);
	    annual_rev.sendKeys("22222222");
	    waitAndClick(industry);
	   //memeber.click();
	   // Thread.sleep(1000);
	    //waitAndClick(memberassign);
	   */
	   save.click();
	   
	}
	
}
