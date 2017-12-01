package qa.consulting.com.qatestingintermediatereportspreadsheet;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class intermediateTestReportSpreadsheet 
{
	private WebDriver webDriver;
	
	//Site data
	private String url = "http://thedemosite.co.uk/";
	private String uname;
	private String loginp;
	
	//Reporting
	private static ExtentReports report;
	private ExtentTest test = report.createTest("DemoSiteTest");
	private ScreenShot screenshot = new ScreenShot();
	
	//Spreadsheet
	private String ssheetdeets = "users.xlsx";
	private SpreadSheetReader ssreader;
	
	
	@BeforeClass
	public static void init()
	{
		report = new ExtentReports();
		String fileName = "DemoReport" + ".html";
		String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
		report.attachReporter(new ExtentHtmlReporter(filePath));
	}
	
	@AfterClass
	public static void destroy()
	{
		report.flush();
	}
	
	
	@Before
	public void setUp()
	{
		test.log(Status.INFO, "Starting Web browser");
		webDriver = new ChromeDriver();
		
		ssreader = new SpreadSheetReader(ssheetdeets);		
		uname = ssreader.readCell(1, 0,"Sheet1");
		loginp = ssreader.readCell(1, 1,"Sheet1");
		
		test.log(Status.DEBUG, "Spreadsheet user: " + uname);
		test.log(Status.DEBUG, "Spreadsheet pw: " + loginp);
	}
	
	@After
	public void tearDown()
	{
		webDriver.quit();
	}
	
	@Test
	public void test() throws Exception
	{
		//Extent report test
		test.log(Status.INFO, "Test Starts");
		
		try 
		{
			webDriver.navigate().to(url);
			test.log(Status.INFO, "Navigate to: " + url);
			//Home page
			DemoSiteHPage homepage = PageFactory.initElements(webDriver, DemoSiteHPage.class);
			test.log(Status.INFO, "Navigation successful");
			
			//Add user page
			test.log(Status.INFO, "Attempting to register user");
			test.log(Status.DEBUG, "Registering user: " + uname);
			homepage.clickAddUser();
			DemoSiteCUserPage addUserPage = PageFactory.initElements(webDriver, DemoSiteCUserPage.class);
			
			addUserPage.setUsername(uname);
			addUserPage.setPassword(loginp);
			addUserPage.clickBtn();
			test.log(Status.INFO, "User registration successful.");
			
			
			//Test login page
			test.log(Status.INFO, "Attempting to login as perviously created user");
			test.log(Status.DEBUG, "Logging in as user: " + uname);
			homepage.clickLoginUser();
			DemoSiteLUserPage loginPage = PageFactory.initElements(webDriver, DemoSiteLUserPage.class);
			
			loginPage.setUsername(uname);
			loginPage.setPassword(loginp);
			loginPage.clickBtn();
			test.log(Status.INFO, "User Login Successful");
			
			assertEquals("Login has failed", "**Successful Login**", loginPage.returnStatus().getText());	
			
			test.log(Status.PASS, "Test Successful");
			//test.log(Status.DEBUG, "Success screenshot: " + screenshot.take(webDriver, "loginsuccess"+uname));
		} 
		catch (AssertionError ae)
		{
			test.log(Status.FAIL, "Test failed");
			test.log(Status.FAIL, ae);
			test.addScreenCaptureFromPath(screenshot.take(webDriver, "error"+uname));
			//test.log(Status.DEBUG, screenshot.take(webDriver, "error"+uname));
			//test.log(Status.DEBUG, "Test failed - more info below:\n" + ae.getMessage());
			report.flush();
			throw ae;
		}
		catch (Exception e) 
		{
			test.log(Status.FATAL,e);
			report.flush();
			throw e;
		}
	}
}
