package qa.consulting.com.qatestingweek1;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverLoginTest 
{
	private String url = "https://dev26668.service-now.com/";
	private WebDriver webDriver;
	
	@Before
	public void setUp()
	{
		webDriver = new ChromeDriver();
	}
	
	@After
	public void tearDown()
	{
		webDriver.quit();
	}
	
	@Test
	public void test()
	{
		webDriver.navigate().to(url);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement loginBox = webDriver.findElement(By.id("user_name"));
		loginBox.sendKeys("admin");
		
		WebElement pwordBox = webDriver.findElement(By.id("user_password"));
		pwordBox.sendKeys("3df1#FU!^4Mky38\n");
		
		String currentUrl = webDriver.getCurrentUrl();
		String expectedUrl = "https://dev26668.service-now.com/navpage.do";
		assertEquals("Not on the right URL", expectedUrl, currentUrl);
	}
	

}

