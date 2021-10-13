package Pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericUtilies.ExcelUility;
import com.crm.vtiger.genericUtilies.JavaUtilities;


public class CreateOrgFullForm extends ExcelUility {
	
	
		
	  
	
	@FindBy(xpath="//button[text()='View full form']")
	private WebElement orgname;
	
	public CreateOrgFullForm(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}

	public WebElement getOrgname() {
		return orgname;
	}
	

}
