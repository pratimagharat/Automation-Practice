package soniClasses.freeCrm.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import basicframework.AutomationBase.BasePageObject;

public class FreeCrmLoginPO extends BasePageObject {
	
	public FreeCrmLoginPO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;
	
	@FindBy(name="username")
	WebElement userName;
	
	
	@FindBy(name="password")
	WebElement passWord;
	
	@FindBy(how=How.XPATH,using="//input[contains(@class,'btn-small')]")
	WebElement loginButton;
	
	
	public void enterUserName(String uname)
	{
		enterValueOn(userName,uname);
	
		/*userName.sendKeys(uname);*/

	}

	public void enterPassword(String password)
	{
		
		enterValueOn(passWord,password);
		//passWord.sendKeys(password);

	}

	public void login()
	{
		isElementClickable(loginButton);
		loginButton.click();
	}
	

}
