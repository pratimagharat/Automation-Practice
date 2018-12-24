package soniClasses.freeCrm.TestScenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import basicframework.AutomationBase.BaseTest;
import basicframework.AutomationBase.ExtentTestManager;
import basicframework.AutomationBase.Reporter;
import soniClasses.freeCrm.module.HomePageModule;
import soniClasses.freeCrm.po.FreeCrmHomePagePO;
import soniClasses.freeCrm.po.FreeCrmLoginPO;

public class FreeCRMHomePageTest extends BaseTest {
	
	@Test
	public void homePage()
	{
		
		HomePageModule hpg=new HomePageModule(driver);
		hpg.checkLog();
		ExtentTest test=ExtentTestManager.createTest("HomePageTestCase", "This test Case is responsible to validate login functionality", "homepage");
		Reporter.passTestStepWithOutScreenShot(test, "Logo is displayed successfully");
	}
	
	
	
	
}
