package soniClasses.freeCrm.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FreeCrmLogin_SimpleImplemetation {

	By userName=By.name("username");
	By passWord=By.name("password");
	By loginButton=By.xpath("//input[@value='Login']");
	WebDriver driver;

	public FreeCrmLogin_SimpleImplemetation(WebDriver driver)
	{
		this.driver=driver;
	}

	public void enterUserName(String uname)
	{
		driver.findElement(userName).sendKeys(uname);

	}

	public void enterPassword(String password)
	{
		driver.findElement(passWord).sendKeys(password);

	}

	public void login()
	{
		driver.findElement(loginButton).click();
	}


}
