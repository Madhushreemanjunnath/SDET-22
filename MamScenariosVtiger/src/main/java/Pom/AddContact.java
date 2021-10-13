package Pom;



	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class AddContact{
		
		public AddContact(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
			
		}
		
		@FindBy(xpath="//button[@title='Add Contact']")
		private WebElement addcontact;

		public WebElement getAddcontact() {
			return addcontact;
		}
		
		
	}


