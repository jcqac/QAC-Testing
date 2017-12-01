package qa.consulting.com.qatestingintermediatereport;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoSiteHPage 
{
	@FindBy(css="body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)")
	WebElement addUserLink;
	
	@FindBy(css="body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")
	WebElement signInLink;
	
	public void clickAddUser()
	{
		addUserLink.click();
	}
	
	public void clickLoginUser()
	{
		signInLink.click();
	}
}
