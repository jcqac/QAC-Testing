package qa.consulting.com.qatestingintermediate;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class intemediateTest 
{
	private WebDriver webDriver;
	private String uname = "harambe";
	private String loginp = "neverforget";
	
	private String url = "http://thedemosite.co.uk/";
	
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
		//Home page
		DemoSiteHPage homepage = PageFactory.initElements(webDriver, DemoSiteHPage.class);
		
		//Add user page
		homepage.clickAddUser();;
		
		DemoSiteCUserPage addUserPage = PageFactory.initElements(webDriver, DemoSiteCUserPage.class);
		addUserPage.setUsername(uname);
		addUserPage.setPassword(loginp);
		addUserPage.clickBtn();
		
		
		//Test login page
		homepage.clickLoginUser();
		DemoSiteLUserPage loginPage = PageFactory.initElements(webDriver, DemoSiteLUserPage.class);
		loginPage.setUsername(uname);
		loginPage.setPassword(loginp);
		loginPage.clickBtn();
		
		assertEquals("Login has failed", "**Successful Login**", loginPage.returnStatus().getText());
	}	
}
