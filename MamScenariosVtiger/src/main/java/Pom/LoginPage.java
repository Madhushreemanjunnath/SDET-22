package Pom;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericUtilies.FileUtility;

public class LoginPage {
	@FindBy(name="username")
	private WebElement usertb;
	
	@FindBy(name="password")
	private WebElement passwordtd;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement logintb;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
 
 	
	public  void login(String U,String p) throws IOException, ParseException
	{
		
/**FileUtility fu=new FileUtility();
String url=fu.getJSON("url");
driver.get(url);
		
	    String username =fu.getJSON("username");
	    String password =fu.getJSON("password");*/
	        usertb.sendKeys(U);
	 	   passwordtd.sendKeys(p);
	 	  logintb.click();
	}
	

}