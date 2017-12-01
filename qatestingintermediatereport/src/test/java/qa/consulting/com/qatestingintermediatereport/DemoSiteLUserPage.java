package qa.consulting.com.qatestingintermediatereport;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoSiteLUserPage 
{
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
	WebElement username;
	
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
	WebElement password;
	
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
	WebElement submitBtn;
	
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b")
	WebElement status;
	
	public void setUsername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickBtn()
	{
		submitBtn.click();
	}
	
	public WebElement returnStatus()
	{
		return status;
	}
}
