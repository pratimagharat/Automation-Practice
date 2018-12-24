package soniClasses.freeCrm.module;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import basicframework.AutomationBase.Reporter;
import soniClasses.freeCrm.po.FreeCrmAddContactPagePO;

public class AddContactModule {

	WebDriver driver;
	FreeCrmAddContactPagePO contctpo;
	ExtentTest test;
	String reportingDirectory;

	public AddContactModule(WebDriver driver, ExtentTest test, String reportingDirectory) {

		this.driver=driver;
		this.test=test;
		this.reportingDirectory=reportingDirectory;
		contctpo=PageFactory.initElements(driver, FreeCrmAddContactPagePO.class);
	}


	
	public void movetoContactPage()
	{
		contctpo.onmousehover();
	}

	public void addContactModule(LinkedHashMap<String, String> testCaseData) throws IOException
	{

		movetoContactPage();
		contctpo.enterValueOnFirstName(testCaseData.get("UserName"));
		contctpo.enterValueOnSurName(testCaseData.get("Password"));
		contctpo.clickOnSaveButton();

		/*if(contctpo.checkboxpresent())0./
		{
			System.out.println("correct checkbox");
			Reporter.passTestStepWithScreenShot(driver, test, "checkbox is resent", reportingDirectory, "contactcheckbox");
		}
		else{
			System.out.println("incorrect checkbox");

			Reporter.failTestStepWithException(driver, test, "checkbx is not present", reportingDirectory, "nocheckBocPResent");
		}*/

	}

	/*public void selectAllcontact()
	{
		contctpo.selectCheckbox();
	}
*/
}
