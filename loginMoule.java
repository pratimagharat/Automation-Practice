package soniClasses.freeCrm.module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import basicframework.AutomationBase.ExtentTestManager;
import basicframework.AutomationBase.Reporter;
import soniClasses.freeCrm.po.FreeCrmLoginPO;

public class loginMoule {
	
	
	WebDriver driver;
	public loginMoule(WebDriver driver) {
		this.driver=driver;
	}

	public void loginToFreeCRMApplication() throws InterruptedException{
		
		FreeCrmLoginPO fpo=PageFactory.initElements(driver, FreeCrmLoginPO.class);
		
		fpo.enterUserName("Pratima_Gharat");
		fpo.enterPassword("abc123");
		//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
	
		Thread.sleep(10000);
		fpo.login();
		
	}

}
