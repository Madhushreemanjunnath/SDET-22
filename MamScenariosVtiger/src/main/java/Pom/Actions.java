package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Actions {
	@FindAll({  @FindBy(xpath="//button[@id='Contacts_listView_addRecord']"),
			@FindBy(xpath="//button[@title='Add Contact']")
			})
			private WebElement addcontact;//.click();
	
	public Actions(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public WebElement getcFullFomr() {
		return cFullFomr;
	}

	@FindBy(xpath="//button[text()='View full form']")
	private WebElement cFullFomr;

	@FindBy(xpath="//span[text()='Contacts']")
private WebElement contact;//.click();
	
	



@FindBy(xpath="//button[text()='View full form']")
private WebElement cFullForm;//.click();
public WebElement getContact() {
	return contact;
}

public WebElement getAddcontact() {
	return addcontact;
}

public WebElement getcFullForm() {
	return cFullForm;
}
  public void Cactions()
  {
	  getContact().click();
	  getAddcontact().click();
	  getcFullForm() .click();
  }
  
}
