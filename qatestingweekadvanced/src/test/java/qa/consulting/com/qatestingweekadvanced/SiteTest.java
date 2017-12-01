package qa.consulting.com.qatestingweekadvanced;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import qa.consulting.com.qatestingweekadvanced.ScreenShot;
import qa.consulting.com.qatestingweekadvanced.SpreadSheetReader;

public class SiteTest 
{
	//WebBrowser
	private BrowserManager browserManager;
	private WebDriver webDriver;
	private String browserChoice = "browserchoice.xlsx";
	
	//Site data
	private String urlHome = "http://automationpractice.com/index.php";

	//Reporting
	private static ExtentReports report;
	private ExtentTest test; 
	
	//Spreadsheet
	private SpreadSheetReader ssreader;
	private String registerSheet = "registeruser.xlsx";
	//private String userSheet = "loginuser";
	
	//private Actions builder;
	
	@BeforeClass
	public static void init()
	{	
		report = new ExtentReports();
		String fileName = "AutomationPractice" + ".html";
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
		ssreader = new SpreadSheetReader(browserChoice);
		browserManager = BrowserFactory.getBrowser(BrowserType.valueOf((ssreader.readCell(1, 0,"Sheet1").toUpperCase())));
		webDriver = browserManager.getDriver();
		webDriver.manage().window().maximize();
		//builder = new Actions(webDriver);
	}
	
	@After
	public void tearDown()
	{
		webDriver.quit();
	}
	
	@Test
	public void testRegisterUser() throws Exception
	{
		test = report.createTest("Test - Register and Login as created user");
		
		try
		{
			test.log(Status.INFO, "Test - Register and Login as created user");
			
			//Values from spreadsheet reader
			ssreader = new SpreadSheetReader(registerSheet);
			String email = ssreader.readCell(1, 0,"Sheet1");
			String pwd = ssreader.readCell(1, 4,"Sheet1");
			String title = ssreader.readCell(1, 1,"Sheet1");
			String fName = ssreader.readCell(1, 2,"Sheet1");
			String lName = ssreader.readCell(1, 3,"Sheet1");
			String company = ssreader.readCell(1, 5,"Sheet1");
			String addrLine1 = ssreader.readCell(1, 6,"Sheet1");
			String addrLine2 = ssreader.readCell(1, 7,"Sheet1");
			String city = ssreader.readCell(1, 8,"Sheet1");
			String state = ssreader.readCell(1, 9,"Sheet1");
			String zipcode = ssreader.readCell(1, 10,"Sheet1");
			String country = ssreader.readCell(1, 11,"Sheet1");
			String adinfo = ssreader.readCell(1, 12,"Sheet1");
			String adalias = ssreader.readCell(1, 15,"Sheet1");
			String hPhone = ssreader.readCell(1, 13,"Sheet1");
			String mPhone = ssreader.readCell(1, 14,"Sheet1");
			
			
			test.log(Status.INFO, "Navigate to: " + urlHome);
			
			
			//Navigate to URL
			test.log(Status.INFO, "Navigate to: " + urlHome);
			webDriver.navigate().to(urlHome);
			test.log(Status.INFO, "Navigation successful");
			test.log(Status.INFO, "Current URL: " + webDriver.getCurrentUrl());
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "register-homepage" + "before"));
			
			
			HomePagePOM homepage = PageFactory.initElements(webDriver, HomePagePOM.class);
			homepage.returnLoginLink().click();
			test.log(Status.INFO, "New URL: " + webDriver.getCurrentUrl());
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "register-homepage" + "after"));
			
			
			
			AuthenticationPOM authenticationPage = PageFactory.initElements(webDriver, AuthenticationPOM.class);
			
			//temporary email
			test.log(Status.INFO, "Fill in email field as: " + email);
			//authenticationPage.returnEmailCreate().sendKeys("harambe@example.org");
			authenticationPage.returnEmailCreate().sendKeys(email);
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "register-email" + "before"));
			authenticationPage.returnAccountSubmit().click();
			test.log(Status.INFO, "Clicked on submit button, will wait until form loads");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "register-email" + "after"));
			
			Thread.sleep(2500);
			
			test.log(Status.INFO, "Registration form loaded");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "register-form" + "before"));
			
			test.log(Status.INFO, "Inputting test data from spreadsheet: " + registerSheet);
			if (title.toLowerCase().contains("mr"))
			{
				authenticationPage.returnSFormMale().click();
			}
			else if (title.toLowerCase().contains("mrs"))
			{
				authenticationPage.returnSFormFemale().click();
			}
			
			authenticationPage.returnSFormFirstName().sendKeys(fName);
			authenticationPage.returnSFormLastName().sendKeys(lName);
			//authenticationPage.returnEmailCreate().sendKeys(email);
			authenticationPage.returnPwdLogin().sendKeys(pwd);
			authenticationPage.returnSFormCompany().sendKeys(company);
			authenticationPage.returnSFormAddr1().sendKeys(addrLine1);
			authenticationPage.returnSFormAddr2().sendKeys(addrLine2);
			authenticationPage.returnSFormCity().sendKeys(city);
			authenticationPage.returnSFormPostCode().sendKeys(zipcode);
			authenticationPage.returnSFormAdInfo().sendKeys(adinfo);
			authenticationPage.returnSFormHPhone().sendKeys(hPhone);
			authenticationPage.returnSFormMPhone().sendKeys(mPhone);
			
			//Clear predefined text
			authenticationPage.returnSFormAlias().clear();
			authenticationPage.returnSFormAlias().sendKeys(adalias);
			
			//State selection
			Select selectState = new Select(authenticationPage.returnSFormState());
			selectState.selectByVisibleText(state);
			//Country Selection
			Select selectCountry = new Select(authenticationPage.returnSFormCountry());
			selectCountry.selectByVisibleText(country);
			
			test.log(Status.INFO, "Successful data input");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "register-form" + "after"));
			
			test.log(Status.INFO, "Registration form submitted");
			//Submit
			authenticationPage.returnSFormSubmitLink().click();
			
			test.log(Status.INFO, "URL after registration form: " + webDriver.getCurrentUrl());
			
			
			String myAccountURL = "http://automationpractice.com/index.php?controller=my-account";
			
			if(webDriver.getCurrentUrl().equals(myAccountURL))
			{
				test.log(Status.PASS, "User registration successful");
				test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "register-form" + "success"));
			}
			else
			{
				test.log(Status.FAIL, "User has not been registered");
			}
			
			Thread.sleep(2500);
			//Logout and login test.
			test.log(Status.INFO, "Begin logout test");
			test.log(Status.INFO, "Current URL: " + webDriver.getCurrentUrl());
			homepage.returnLogoutLink().click();
			
			Thread.sleep(2000);
			
			String logOutLink = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
			
			if (webDriver.getCurrentUrl().equals(logOutLink))
			{
				test.log(Status.INFO, "Log out successful");
				test.log(Status.INFO, "Post log out URL: " + webDriver.getCurrentUrl());
				test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "logout" + "success"));
			}
			else
			{
				test.log(Status.FAIL, "Log out unsuccessful");
			}
			
			webDriver.navigate().to(urlHome);
			
			test.log(Status.INFO, "Begin login test");
			homepage.returnLoginLink().click();
			test.log(Status.INFO, "Login page URL: " + webDriver.getCurrentUrl());
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "login-page" + "before"));
			
			authenticationPage.returnEmailLogin().sendKeys(email);
			authenticationPage.returnPwdLogin().sendKeys(pwd);
			
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "login-page" + "filled"));
			
			test.log(Status.INFO, "Login info filled");
			
			authenticationPage.returnLoginLink().click();
			
			Thread.sleep(2500);
			
			if(webDriver.getCurrentUrl().equals(myAccountURL))
			{
				test.log(Status.PASS, "User login successful");
				test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "login-page" + "success"));
			}
			else
			{
				test.log(Status.FAIL, "Could not login to system");
			}
			
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		catch (AssertionError ae)
		{
			test.log(Status.FAIL, "Test failed");
			test.log(Status.DEBUG, ae);
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "error"+"dragable"));
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
	
	//@Test
	public void testShopping()
	{
		//Using filters, we will add items to cart and checkout.
	}
	
}
