package qa.consulting.com.qatestingintermediatemouse;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragablePOM 
{
	//Default functionality
	@FindBy(id="draggable")
	WebElement defFunc;
	
	//Constrain movement #########
	@FindBy(id="draggabl")
	WebElement conV;
	
	@FindBy(id="draggabl2")
	WebElement conH;
	
	@FindBy(id="draggabl3")
	WebElement conBox;
	
	@FindBy(id="containment-wrapper")
	WebElement conBoxContainer;
	
	@FindBy(id="draggabl5")
	WebElement conParent;
	
	@FindBy(xpath="/html/body/div[1]/div/div[1]/main/article/div/div/div/div[2]/div/div[3]/div[2]")
	WebElement conParentContainer;
	//Constrain movement ############
	
	//Cursor style
	@FindBy(id="drag")
	WebElement style1;
	
	@FindBy(id="drag2")
	WebElement style2;
	
	@FindBy(id="drag3")
	WebElement style3;
	
	public WebElement returnDefFunc()
	{
		return defFunc;
	}
	
	public WebElement returnConV()
	{
		return conV;
	}
	
	public WebElement returnConH()
	{
		return conH;
	}
	
	public WebElement returnConBox()
	{
		return conBox;
	}
	
	public WebElement returnConBoxContainer()
	{
		return conBoxContainer;
	}
	
	public WebElement returnConParent()
	{
		return conParent;
	}
	
	public WebElement returnCurStyle1()
	{
		return style1;
	}
	
	public WebElement returnCurStyle2()
	{
		return style2;
	}
	
	public WebElement returnCurStyle3()
	{
		return style3;
	}
	
	public WebElement returnConParentContainer()
	{
		return conParentContainer;
	}
	
	
	
}
