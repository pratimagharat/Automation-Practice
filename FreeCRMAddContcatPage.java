package soniClasses.freeCrm.TestScenarios;


import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import SoniClassess.utility.ExcelReadingData;
import basicframework.AutomationBase.BaseTest;
import basicframework.AutomationBase.ExtentTestManager;
import basicframework.AutomationBase.Reporter;
import soniClasses.freeCrm.module.AddContactModule;

public class FreeCRMAddContcatPage extends BaseTest{

	
/*@Test
public void addConactPage() throws IOException
{	
	System.out.println("Execute Contact Page");
	
	LinkedHashMap<String, String> testCaseData=datareader.getTestCaseData("GuruDemoExcel", "1.1.3");
	
	ExtentTest test=ExtentTestManager.createTest("contactpage", "This test Case is responsible to validate login functionality", "contact");
	
	AddContactModule addcon=new AddContactModule(driver,test,reportingDirectory);
	addcon.addContactModule(testCaseData);
	Reporter.passTestStepWithScreenShot(driver, test, "contact is added successfully", reportingDirectory, "New contact");
	
	addcon.selectAllcontact();
	Reporter.failTestStepWithOutException(driver, test, "element not found", reportingDirectory, "NoContactSelected");
	
	}*/
	
	
	@Test
	public void addConactPage() throws IOException
	{	
		System.out.println("Execute Contact Page");
		
		//LinkedHashMap<String, LinkedHashMap<String, String>> testCaseData=datareader.getsheetData("GuruDemoExcel");
		
		Set<String> keyset=datareader.getsheetData("GuruDemoExcel").keySet();
		Iterator<String> key= keyset.iterator();

		while(key.hasNext()){
			String TC_ID=key.next().toString();
			LinkedHashMap<String, String> testCaseData=datareader.getsheetData("GuruDemoExcel").get(TC_ID);
			
			ExtentTest test=ExtentTestManager.createTest("contactpage", "This test Case is responsible to validate login functionality", "contact");
			
			AddContactModule addcon=new AddContactModule(driver,test,reportingDirectory);
			addcon.addContactModule(testCaseData);
			Reporter.passTestStepWithScreenShot(driver, test, "contact is added successfully", reportingDirectory, "New contact");
			
			//addcon.movetoContactPage();
		/*	addcon.selectAllcontact();
			Reporter.failTestStepWithOutException(driver, test, "element not found", reportingDirectory, "NoContactSelected");*/
			
		}
		
		
		}
	

}
