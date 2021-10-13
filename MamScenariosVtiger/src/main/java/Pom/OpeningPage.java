package Pom;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpeningPage {
	
	@FindBy(xpath="//*[text()='Actions']/ancestor::div/descendant::i[@id='menu']")
  private WebElement actions;
	
	@FindBy(xpath="//*[@id='favourites']/ancestor::div/descendant::span[@title='Organizations']")
	private WebElement org;
	
	@FindAll({@FindBy(xpath="//*[text()='Contacts']/ancestor::div/descendant::span[text()='Ma']"),
		@FindBy(xpath="//span[@class='text-center my-3 font-15']")
	})
			 private WebElement vtiger;
	 
	@FindAll({@FindBy(xpath="//*[text()='Ma']/ancestor::div/descendant::div[text()='Logout']"),
	@FindBy(xpath="//*[text()='Ma']/ancestor::div/descendant::div[@title='Logout'] and div[text()='Logout']")
	})
	private WebElement logout;
	
	@FindBy(xpath="//span[text()='Contacts']")
	private WebElement contacts;
	
	public OpeningPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	 public WebElement getContacts() {
		return contacts;
	}
	public WebElement getActions() {
		return actions;
	}
	public WebElement getOrg() {
		return org;
	}
	
	
	public WebElement getVtiger() {
		return vtiger;
	}
	public WebElement getLogout() {
		return logout;
	}
	
	public void org()
	 {
		 org.click(); 
	 }
	
	}

