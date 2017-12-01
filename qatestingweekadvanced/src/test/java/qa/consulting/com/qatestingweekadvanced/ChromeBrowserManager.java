package qa.consulting.com.qatestingweekadvanced;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserManager extends BrowserManager
{
	public void createDriver()
	{
		driver = new ChromeDriver();
	}
}
