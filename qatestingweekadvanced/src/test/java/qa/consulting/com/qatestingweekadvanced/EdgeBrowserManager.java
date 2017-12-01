package qa.consulting.com.qatestingweekadvanced;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowserManager extends BrowserManager
{
	public void createDriver()
	{
		driver = new EdgeDriver();
	}
}
