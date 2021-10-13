package contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.genericUtilies.WebDriverUtilities;

public class PrakshaSir extends WebDriverUtilities {
@Test
public void path() throws InterruptedException {
	
WebDriver driver=new ChromeDriver();
driver.get("https://demoqa.com/tool-tips");
WebElement ele1=driver.findElement(By.xpath("//button[text()='Hover me to see']"));
//waitForElementVisibilty(driver,ele1);
mosueHover(driver,ele1);
Thread.sleep(1000);
String btn=driver.findElement(By.xpath("//div[text()='You hovered over the Button']")).getText();
System.out.println(btn);
ele1.sendKeys(btn);
driver.close();

}
}
