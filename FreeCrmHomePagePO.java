package soniClasses.freeCrm.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basicframework.AutomationBase.BasePageObject;

public class FreeCrmHomePagePO extends BasePageObject{
	public FreeCrmHomePagePO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	@FindBy(xpath="//td[@class='logo_text']")
	WebElement logotext;
	
	
	public void islogoPresent()
	{
		logotext.isDisplayed();
		System.out.println("logo is present");
	}
	
	
	
	

}
