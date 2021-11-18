package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericUtilies.WebDriverUtilities;

public class ContactDetails extends WebDriverUtilities{
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastname;
	
	@FindBy(xpath="//select[@name='contacttype']/option[text()='Marketing Qualified Lead']")
private WebElement lead;
			@FindBy(xpath="//button[text()='Save']")
private WebElement save;
			@FindBy(xpath="//select[@name='contacttype']/option[text()='Customer']")
			private WebElement lifestyle;
	@FindBy(xpath="//i[@class='fa-accounts']")
	private WebElement OrgSel;
	
	@FindBy(xpath="//table/tbody/tr/td[*]//a[text()='Manju_ 996']")
	private WebElement specific;
	public WebElement getSpecific() {
		return specific;
	}
	@FindBy(xpath="(//footer[@class='modal-footer']/ancestor::div/descendant::button[contains(text(),'No')])[2]")
	private WebElement yes;
	
	WebElement getYes() {
		return yes;
	}
	public WebElement getOrgSel() {
		return OrgSel;
	}
	public WebElement getLifestyle() {
				return lifestyle;
			}
			public ContactDetails(WebDriver driver)
			{
				PageFactory.initElements(driver,this);
				
			}
			public WebElement getLastname() {
				return lastname;
			}
			public WebElement getLead() {
				return lead;
			}
			public WebElement getSave() {
				return save;
			}
			@FindBy(xpath="//a[text()='Contacts']")
			private WebElement c;
			public void enterDetails(WebDriver driver) throws InterruptedException {
				Thread.sleep(1000);
				System.out.println("enter keys");
				getLastname().sendKeys("Manjunath");
				
				getLead().click();
				getLifestyle().click();
				getSave().click();
				Thread.sleep(1000);
				
				
				
				
			}
			WebElement getC() {
				return c;
			}
			
			public void cwo(WebDriver driver)
			{
				getLastname().sendKeys("manajunath");
				getOrgSel().click();
				getSpecific().click();
				getYes().click();
				getLead().click();
				getSave().click();
			}

}
