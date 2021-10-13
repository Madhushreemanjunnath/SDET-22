package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericUtilies.WebDriverUtilities;

public class Org  extends WebDriverUtilities{
	
	@FindBy (xpath="//button[@title='Add Organization']")
	private WebElement addorg;
	
	@FindBy (xpath="//div[@class='vds-bodycontents listBody px-4 bg-grey-hue-8']")
	private WebElement getOrgName;
	
	@FindAll({@FindBy(xpath="//nav[@id='topbar']/i[@title='Global Search']"),
	@FindBy(xpath="//i[@title='Global Search']")})
	private WebElement search;
	@FindAll({@FindBy(xpath="//input[contains(@placeholder,'Type here and press ENTER to start ')]"),
		@FindBy(xpath="//input[@type='text']")
	})
	private WebElement enterKey;
	
	@FindBy(xpath="//span[text()='home']")
	private WebElement orgSearchingName;
	
	
	public WebElement getOrgSearchingName() {
		return orgSearchingName;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getEnterKey() {
		return enterKey;
	}

	public WebElement getGetOrgName() {
		return getOrgName;
	}

	public Org(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}

	public WebElement getAddorg() {
		return addorg;
	}
	

 
}
