import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class Practice {
	@Test
	public void DD() throws InterruptedException
	{
		System.out.println("Launch browser");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println("step1");
	driver.findElement(By.id("gh-shop-a")).click();
	System.out.println("step2");
	Thread.sleep(2000);
  List<WebElement> elements=driver.findElements(By.xpath("//table[@id='gh-sbc']/tbody/tr/td[1]/ul[1]/li/a"));
  System.out.println("step3");
 
 for(WebElement w:elements)
	  {
	 Thread.sleep(2000);
	  System.out.println(w.getText());
	  }
	

	
	driver.close();
}
}

