package qa.consulting.com.qatestingweekadvanced;

import org.openqa.selenium.WebDriver;

public abstract class BrowserManager 
{
	protected WebDriver driver;
	
	public WebDriver getDriver()
	{
		if (driver == null)
		{
			createDriver();
		}
		return driver;
	}
	
	public abstract void createDriver();
}
