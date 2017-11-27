package qa.consulting.com.qatestingweek1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClassyMcClassface 
{
	@BeforeClass
	public static void init()
	{
		System.out.println("init");
	}
	
	@Before
	public void setUp()
	{
		System.out.println("Set Up");
	}
	
	@Test
	public void test()
	{
		System.out.println("test");
	}
	
	@After
	public void tearDown()
	{
		System.out.println("Tear Down");
	}
	
	@AfterClass
	public static void destroy()
	{
		System.out.println("Destroy");
	}
}
