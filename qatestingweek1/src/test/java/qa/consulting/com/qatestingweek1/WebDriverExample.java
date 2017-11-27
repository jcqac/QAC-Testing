package qa.consulting.com.qatestingweek1;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExample 
{
	private String url = "https://www.google.com";
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
	public void qaTest()
	{
		webDriver.navigate().to(url);
		WebElement searchBar = webDriver.findElement(By.cssSelector("#lst-ib"));
		searchBar.sendKeys("qa\n");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement qaLink = webDriver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div > div > h3 > a"));
		qaLink.click();
		
		String currentUrl = webDriver.getCurrentUrl();
		String expectedUrl = "https://www.qa.com/";
		assertEquals("Not on the right URL", expectedUrl, currentUrl);
	}
	

}
