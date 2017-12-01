package qa.consulting.com.qatestingweekadvanced;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowserManager extends BrowserManager
{
	public void createDriver()
	{
		driver = new FirefoxDriver();
	}
}
