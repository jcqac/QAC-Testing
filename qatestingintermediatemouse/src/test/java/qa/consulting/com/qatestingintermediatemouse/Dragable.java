package qa.consulting.com.qatestingintermediatemouse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import qa.consulting.com.qatestingintermediatemouse.ScreenShot;

public class Dragable 
{
	private WebDriver webDriver;
	
	//Site data
	private String urlDef = "http://demoqa.com/draggable/";
	private String urlCon = "http://demoqa.com/draggable/#tabs-3";
	private String urlSty = "http://demoqa.com/draggable/#tabs-4";

	//Reporting
	private static ExtentReports report;
	private ExtentTest test; 
	
	private Actions builder;
	
	@BeforeClass
	public static void init()
	{
		report = new ExtentReports();
		String fileName = "DragableReport" + ".html";
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
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		builder = new Actions(webDriver);
	}
	
	@After
	public void tearDown()
	{
		webDriver.quit();
	}
	
	@Test
	public void testDefault() throws Exception
	{
		//Test for report
		test = report.createTest("Test 1 - Default Functionality");
		
		//Dragable page test1
		test.log(Status.INFO, "Test 1 - Default Functionality");
		
		try 
		{
			webDriver.navigate().to(urlDef);
			test.log(Status.INFO, "Navigate to: " + urlDef);
			//Dragable page
			DragablePOM dragablePage = PageFactory.initElements(webDriver, DragablePOM.class);
			test.log(Status.INFO, "Navigation successful");
			
			//Testing Default Functionality
			test.log(Status.DEBUG, "Default functionality - Taking initial screenshot");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "default-dragable" + "before"));
			
			//Initial Point
			Point df1 = (dragablePage.returnDefFunc()).getLocation();
			test.log(Status.DEBUG, "Default functionality - Inital points: " + df1);
			
			
			test.log(Status.INFO, "Attempting to move default functionality dragable element");
			builder.dragAndDropBy(dragablePage.returnDefFunc(), 300, 200).perform();
			
			test.log(Status.DEBUG, "Default functionality - Taking after screenshot");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "default-dragable" + "after"));
			
			//Final Point
			Point df2= (dragablePage.returnDefFunc()).getLocation();
			test.log(Status.DEBUG, "Default functionality - Final points: " + df2);
			
			boolean res1 = false;
			if (df1.equals(df2))
			{
				res1 = true;
			}
			
			assertFalse("Element has not moved", res1);	
			
			test.log(Status.PASS, "Test 1 Successful");
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
	
	@Test
	public void testConstrain() throws Exception
	{
		//Test for report
		test = report.createTest("Test 2 - Constrained Movement");
		
		//Dragable page test2
		test.log(Status.INFO, "Test 2 - Constrained Functionality");
		
		try 
		{
			webDriver.navigate().to(urlCon);
			test.log(Status.INFO, "Navigate to: " + urlCon);
			//Dragable page
			DragablePOM dragablePage = PageFactory.initElements(webDriver, DragablePOM.class);
			test.log(Status.INFO, "Navigation successful");
			
			//Constrained Vertical #################################
			test.log(Status.DEBUG, "Constrained Vertical - Taking initial screenshot");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "constrained-vertical" + "before"));
			
			//Initial Point
			Point con1a = (dragablePage.returnConV()).getLocation();
			test.log(Status.DEBUG, "Constrained Vertical - Inital points: " + con1a);
			
			test.log(Status.INFO, "Attempting to move Constrained Vertical dragable element");
			builder.dragAndDropBy(dragablePage.returnConV(), 300, 200).perform();
			
			test.log(Status.DEBUG, "Constrained Vertical - Taking after screenshot");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "constrained-vertical" + "after"));
			
			//Final Point
			Point con1b= (dragablePage.returnConV()).getLocation();
			
			test.log(Status.DEBUG, "Constrained Vertical - Final points: " + con1b);
			
			boolean resCon1 = false;
			if (getPointX(con1a) == getPointX(con1b))
			{
				resCon1 = true;
			}
			assertTrue("Element Contrained Vertical - Moved Horizontally", resCon1);
			
			
			//Constrained Vertical #################################
			
			//Constrained Horizontal ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			test.log(Status.DEBUG, "Constrained Horizontal - Taking initial screenshot");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "constrained-horizontal" + "before"));
			
			//Initial Point
			Point con2a = (dragablePage.returnConH()).getLocation();
			test.log(Status.DEBUG, "Constrained Horizontal - Inital points: " + con2a);
			
			test.log(Status.INFO, "Attempting to move Constrained Horizontal dragable element");
			builder.dragAndDropBy(dragablePage.returnConH(), 300, 200).perform();
			
			test.log(Status.DEBUG, "Constrained Horizontal - Taking after screenshot");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "constrained-horizontal" + "after"));
			
			//Final Point
			Point con2b= (dragablePage.returnConH()).getLocation();
			
			test.log(Status.DEBUG, "Constrained Horizontal - Final points: " + con2b);
			
			boolean resCon2 = false;
			if (getPointY(con2a) == getPointY(con2b))
			{
				resCon2 = true;
			}
			
			assertTrue("Element Contrained Horizontal has moved Vertically", resCon2);
			
			//Constrained Horizontal ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			//Constrained Box ############################# 
			test.log(Status.DEBUG, "Constrained Box - Taking initial screenshot");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "constrained-box" + "before"));
			
			//Initial Point
			Point con3a = (dragablePage.returnConBox()).getLocation();
			test.log(Status.DEBUG, "Constrained Box - Inital points: " + con3a);
			
			test.log(Status.INFO, "Attempting to move Constrained box dragable element");
			builder.dragAndDropBy(dragablePage.returnConBox(), 2000, 2000).perform();
			
			test.log(Status.DEBUG, "Constrained Horizontal - Taking after screenshot");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "constrained-box" + "after"));
			
			//Final Point
			Point con3b= (dragablePage.returnConBox()).getLocation();
			test.log(Status.DEBUG, "Constrained Box - Final points: " + con3b);
			
			//Box container rectangle
			Dimension boxContainer = (dragablePage.returnConBoxContainer()).getSize();
				//Box container coordinates
				Point boxContainerInitial = (dragablePage.returnConBoxContainer()).getLocation();
				int boxContainerX1 = getPointX(boxContainerInitial);
				int boxContainerY1 = getPointY(boxContainerInitial);
				int boxContainerX2 = boxContainerX1 + getSizeX(boxContainer);
				int boxContainerY2 = boxContainerY1 + getSizeY(boxContainer);
				
				//ContrainBox coordinates
				int boxConX1 = getPointX(con3b);
				int boxConY1 = getPointY(con3b);
				
				int boxConX2 = getPointX(con3b) + getSizeX((dragablePage.returnConBox()).getSize());
				int boxConY2 = getPointY(con3b) + getSizeY((dragablePage.returnConBox()).getSize());;
			
			boolean resCon3 = false;
			if ((boxConX1 > boxContainerX2 || boxConX1 < boxContainerX1) || (boxConY1 > boxContainerY2 || boxConY1 < boxContainerY1)
					|| (boxConX2 > boxContainerX2 || boxConX2 < boxContainerX1) || (boxConY2 > boxContainerY2 || boxConY2 < boxContainerY1))
			{
				resCon3 = true;
			}
			
			assertFalse("Element Constrained Box has moved outside of its container", resCon3);	
			
			//Constrained Box ############################# 
			
			//Constrained Parent ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			test.log(Status.DEBUG, "Constrained Parent - Taking initial screenshot");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "constrained-parent" + "before"));
			
			//Initial Point
			Point con4a = (dragablePage.returnConParent()).getLocation();
			test.log(Status.DEBUG, "Constrained parent - Inital points: " + con4a);
			
			test.log(Status.INFO, "Attempting to move Constrained parent dragable element");
			builder.dragAndDropBy(dragablePage.returnConParent(), 2000, 2000).perform();
			
			test.log(Status.DEBUG, "Constrained Parent - Taking after screenshot");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "constrained-parent" + "after"));
			
			//Final Point
			Point con4b= (dragablePage.returnConParent()).getLocation();
			test.log(Status.DEBUG, "Constrained Parnet - Final points: " + con4b);
			
			//Parent container rectangle
			Dimension parentContainer = (dragablePage.returnConParentContainer()).getSize();
				//Box container coordinates
				Point parentContainerInitial = (dragablePage.returnConParentContainer()).getLocation();
				int parentContainerX1 = getPointX(parentContainerInitial);
				int parentContainerX2 = parentContainerX1 + getSizeX(parentContainer);
				
				//ContrainBox coordinates
				int parentBoxX1 = getPointX(con4b);
				
				int parentBoxX2 = getPointX(con4b) + getSizeX((dragablePage.returnConParent()).getSize());
			
				System.out.println(parentContainerX1);
				System.out.println(parentContainerX2);
				System.out.println(parentBoxX1);
				System.out.println(parentBoxX2);
				
				
			boolean resCon4 = false;
//			if ((parentBoxX1 > parentContainerX2 || parentBoxX1 < parentContainerX1)|| (parentBoxX2 > parentContainerX2 || parentBoxX2 < parentContainerX1));
//			//|| (parentBoxY1 > parentContainerY2 || parentBoxY1 < parentContainerY1)|| (parentBoxY2 > parentContainerY2 || parentBoxY2 < parentContainerY1))
//			{
//				resCon4 = true;
//			}
			
			assertFalse("Element Constrained Box has moved outside of its parent container", resCon4);	
			
			//Constrained Parent ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			

			test.log(Status.PASS, "Test 2 Successful");
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
	
	
	
	@Test
	public void testCursorStyle() throws Exception
	{
		//Test for report
		test = report.createTest("Test 3 - Cursor Styles");
		
		//Dragable page test1
		test.log(Status.INFO, "Test 3 - Cursor Styles");
		
		try 
		{
			webDriver.navigate().to(urlSty);
			test.log(Status.INFO, "Navigate to: " + urlSty);
			//Dragable page
			DragablePOM dragablePage = PageFactory.initElements(webDriver, DragablePOM.class);
			test.log(Status.INFO, "Navigation successful");
			
			//Cursor Style 1 - Centre #####################
			
				//get before and after points
			Point sty1a = (dragablePage.returnCurStyle1()).getLocation();
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "cursorStyle-1" + "before"));
			builder.moveToElement(dragablePage.returnCurStyle1(),0, 0).perform();
			builder.clickAndHold().moveByOffset(1, 1).release().perform();
			
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "cursorStyle-1" + "after"));
			Point sty1b = (dragablePage.returnCurStyle1()).getLocation();
			
			
			
				//get Size of element
			Dimension styDim1 = (dragablePage.returnCurStyle1()).getSize();
			int styDim1x = getSizeX(styDim1);
			int styDim1y = getSizeY(styDim1);
			
			int offsetSty1X = Math.abs(getPointX(sty1a) - getPointX(sty1a) - (styDim1x/2));
			int offsetSty1Y = Math.abs(getPointY(sty1b) - getPointY(sty1b) - (styDim1y/2));
			
			boolean resSty1 = false;
			if((offsetSty1X == 50) && (offsetSty1Y == 50))
			{
				resSty1 = true;
			}
			
			assertTrue("Cursor is not in centre", resSty1);
			
			//Cursor Style 1 - Centre #####################
			
			//Cursor Style 2 - 5 offset ~~~~~~~~~~~~~~~~~~~~
				
				//get before and after points
			Point sty2a = (dragablePage.returnCurStyle2()).getLocation();
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "cursorStyle-2" + "before"));
			builder.moveToElement(dragablePage.returnCurStyle2(),0, 0).perform();
			builder.clickAndHold().moveByOffset(1, 1).moveByOffset(-1, -1).release().perform();
			
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "cursorStyle-2" + "after"));
			Point sty2b = (dragablePage.returnCurStyle2()).getLocation();
			
			int offsetSty2X = getPointX(sty2b) - getPointX(sty2a);
			int offsetSty2Y = getPointY(sty2b) - getPointY(sty2a);
			
			boolean resSty2 = false;
			if((offsetSty2X == 5) && (offsetSty2Y == 5))
			{
				resSty2 = true;
			}
			
			assertTrue("Cursor moved by more than 5 offset", resSty2);
			
			//Cursor Style 2 - 5 offset ~~~~~~~~~~~~~~~~~~~~
			
			//Cursor Style 3 - Bottom ####################
			
			//get before and after points
			Point sty3a = (dragablePage.returnCurStyle3()).getLocation();
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "cursorStyle-3" + "before"));
			builder.moveToElement(dragablePage.returnCurStyle3(),0, 0).perform();
			builder.clickAndHold().moveByOffset(1, 1).moveByOffset(-1, -1).release().perform();
			
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "cursorStyle-3" + "after"));
			Point sty3b = (dragablePage.returnCurStyle3()).getLocation();
			
				//get Size of element
			Dimension styDim3 = (dragablePage.returnCurStyle3()).getSize();
			int styDim3y = getSizeY(styDim3);
			
			boolean resSty3 = false;
			if((getPointY(sty3a)-styDim3y) == (getPointY(sty3b)))
			{
				resSty3 = true;
			}
			
			assertTrue("Cursor is not at bottom", resSty3);
			
			//Cursor Style 3 - Bottom ####################
			
			
			
			test.log(Status.PASS, "Test 3 Successful");
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
	
	
	//Return Point of element.
	private int getPointX(Point pt)
	{
		return pt.getX();
	}
	
	private int getPointY(Point pt)
	{
		return pt.getY();
	}
	
	private int getSizeX(Dimension sz)
	{
		return sz.getWidth();
	}
	
	private int getSizeY(Dimension sz)
	{
		return sz.getHeight();
	}
	
	
}
