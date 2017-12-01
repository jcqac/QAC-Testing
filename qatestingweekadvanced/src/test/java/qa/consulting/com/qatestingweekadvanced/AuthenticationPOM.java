package qa.consulting.com.qatestingweekadvanced;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPOM 
{
	@FindBy(id="email_create")
	WebElement signUpEmailField;
	
	@FindBy(id="SubmitCreate")
	WebElement createAccountLink;
	
	@FindBy(id="email")
	WebElement loginEmailField;
	
	@FindBy(id="passwd")
	WebElement loginPwdField;
	
	@FindBy(id="SubmitLogin")
	WebElement loginLink;
	
	@FindBy(css=".lost_password > a:nth-child(1)")
	WebElement forgotPwdLink;
	
	//title~~~~~~~
	@FindBy(css="#id_gender1")
	WebElement sFormMale;
	
	@FindBy(css="#id_gender2")
	WebElement sFormFemale;
	//title~~~~~~~
	
	@FindBy(css="#customer_firstname")
	WebElement custFName;
	
	@FindBy(css="#customer_lastname")
	WebElement custLName;
	
	@FindBy(css="#company")
	WebElement sFormCompany;
	
	@FindBy(css="#address1")
	WebElement sFormAddrLine1;
	
	@FindBy(css="#address2")
	WebElement sFormAddrLine2;
	
	@FindBy(css="#city")
	WebElement sFormCity;
	
	@FindBy(css="#id_state")
	WebElement sFormState;
	
	@FindBy(css="#postcode")
	WebElement sFormPostCode;
	
	@FindBy(css="#id_country")
	WebElement sFormCountry;
	
	@FindBy(css="#other")
	WebElement sFormAdInfo;
	
	@FindBy(css="#phone")
	WebElement sFormHPhone;
	
	@FindBy(css="#phone_mobile")
	WebElement sFormMPhone;
	
	@FindBy(css="#alias")
	WebElement sFormAdAlias;
	
	@FindBy(css="#submitAccount")
	WebElement sFormSubmitLink;
	
	
	public WebElement returnEmailCreate()
	{
		return signUpEmailField;
	}
	
	public WebElement returnAccountSubmit()
	{
		return createAccountLink;
	}
	
	public WebElement returnEmailLogin()
	{
		return loginEmailField;
	}
	
	public WebElement returnPwdLogin()
	{
		return loginPwdField;
	}
	
	public WebElement returnLoginLink()
	{
		return loginLink;
	}
	
	public WebElement returnForgotLink()
	{
		return forgotPwdLink;
	}
	
	//Gender ~~~~~~~~~~
	public WebElement returnSFormMale()
	{
		return sFormMale;
	}
	
	public WebElement returnSFormFemale()
	{
		return sFormFemale;
	}
	//Gender ~~~~~~~~~~
	
	public WebElement returnSFormFirstName()
	{
		return custFName;
	}
	
	public WebElement returnSFormLastName()
	{
		return custLName;
	}
	
	public WebElement returnSFormCompany()
	{
		return sFormCompany;
	}
	
	public WebElement returnSFormAddr1()
	{
		return sFormAddrLine1;
	}
	
	public WebElement returnSFormAddr2()
	{
		return sFormAddrLine2;
	}
	
	public WebElement returnSFormCity()
	{
		return sFormCity;
	}
	
	public WebElement returnSFormState()
	{
		return sFormState;
	}
	
	public WebElement returnSFormPostCode()
	{
		return sFormPostCode;
	}

	public WebElement returnSFormCountry()
	{
		return sFormCountry;
	}
	
	public WebElement returnSFormAdInfo()
	{
		return sFormAdInfo;
	}
	
	public WebElement returnSFormHPhone()
	{
		return sFormHPhone;
	}
	
	public WebElement returnSFormMPhone()
	{
		return sFormMPhone;
	}
	
	public WebElement returnSFormAlias()
	{
		return sFormAdAlias;
	}
	
	public WebElement returnSFormSubmitLink()
	{
		return sFormSubmitLink;
	}
	
}
