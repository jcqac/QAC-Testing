package qa.consulting.com.qatestingweekadvanced;

public class BrowserFactory 
{
	public static BrowserManager getBrowser(BrowserType type)
	{
		BrowserManager browserManager = null;
		
		switch (type)
		{
		case CHROME:
			browserManager = new ChromeBrowserManager();
			break;
		case FIREFOX:
			browserManager = new FirefoxBrowserManager();
			break;
		case EDGE:
			browserManager = new EdgeBrowserManager();
			break;
		}
		return browserManager;
	}
}
