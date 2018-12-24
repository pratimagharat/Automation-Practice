package soniClasses.freeCrm.TestScenarios;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.beust.jcommander.Parameter;

import basicframework.AutomationBase.BaseTest;
import basicframework.AutomationBase.ExtentTestManager;
import basicframework.AutomationBase.Reporter;
import soniClasses.freeCrm.module.AddContactModule;
import soniClasses.freeCrm.module.HomePageModule;
import soniClasses.freeCrm.module.loginMoule;
import soniClasses.freeCrm.po.FreeCrmAddContactPagePO;
import soniClasses.freeCrm.po.FreeCrmHomePagePO;
import soniClasses.freeCrm.po.FreeCrmLoginPO;


public class FreeCRMLoginPageTest extends BaseTest {

	
	@Parameters("typeOfTestCase")
	@Test
	public void loginPage(String category) throws InterruptedException, IOException
	{
/*
		String rootFolder=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", rootFolder+"/Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();*/
		//driver.get("http://www.freecrm.com/index.html");


		/*FreeCrmLogin_SimpleImplemetation simplelogin=new FreeCrmLogin_SimpleImplemetation(driver);
		simplelogin.enterUserName("Pratima_Gharat");
		simplelogin.enterPassword("abc123");
		simplelogin.login();
		driver.quit();*/


		//using Page object model
		invokeBrowser();
		
		
		driver.get("https://www.freecrm.com/index.html");
		
		loginMoule l = new loginMoule(driver);
		
		//test.log(Status.PASS, "sucessfull loged in application");
		ExtentTest test=ExtentTestManager.createTest("LoginToApplication", "This test Case is responsible to validate login functionality", category);
		Reporter.passTestStepWithScreenShot(driver, test, "sucessfull loged in application",reportingDirectory , "logncrm");
			
		
		l.loginToFreeCRMApplication();
		
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("CRMPRO"))
			
		{
			Reporter.passTestStepWithScreenShot(driver, test, "naviated to home page and title of the page is  CRMRO", reportingDirectory, "homepage");
		}
        
		
		
		
		//browserClose();
	

	}





}
