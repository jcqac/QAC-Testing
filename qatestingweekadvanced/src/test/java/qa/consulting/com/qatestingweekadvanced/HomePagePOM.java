package qa.consulting.com.qatestingweekadvanced;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePagePOM 
{
	@FindBy(css=".login")
	WebElement signIn;
	
	@FindBy(css=".logout")
	WebElement signOut;
	
	@FindBy(css=".account")
	WebElement accountLink;
	
	public WebElement returnLoginLink()
	{
		return signIn;
	}
	
	public WebElement returnLogoutLink()
	{
		return signOut;
	}
	
	public WebElement AccountLink()
	{
		return accountLink;
	}
	
}
