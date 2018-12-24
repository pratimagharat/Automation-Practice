package basicframework.AutomationBase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import SoniClassess.utility.ExcelReadingData;




public class BaseTest {

	static String sourceFolder;
	static ConfigfileReader configfilereader;
	protected static WebDriver driver;
	protected static String currentDateTime;
	protected static String reportingDirectory;
	protected static  String htmlReportName;
	protected static ExcelReadingData datareader;


	static{

		// fetch current date and time from calendar
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat formater= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		currentDateTime = formater.format(calendar.getTime());


		if(System.getProperty("user.dir").contains("target"))
			sourceFolder = System.getProperty("user.dir").replace("/target", "");
		else

			sourceFolder=System.getProperty("user.dir");

		//reading config file

		configfilereader=new ConfigfileReader();
		configfilereader.loadPropertiesFile();




		// fetch applicatmon Name
		String appName= configfilereader.getApplicationName();

		// load excel data

		// load excel Data
		try {
			datareader = new ExcelReadingData(sourceFolder);
			datareader.readData(configfilereader.getInputExcelFile());
		} catch (Exception e) {
			e.printStackTrace();
		}


		// creating reporting structure
		reportingDirectory = CreateDirectoryStructure.getReportingDirectory(
				appName,
				sourceFolder,currentDateTime);

		htmlReportName = reportingDirectory+appName+"_"+currentDateTime+".html";

		//		//initialise extent report
		ExtentManager.createInstance(htmlReportName, appName, configfilereader.getEnvironment());


	}


	//invoke browser
	public void invokeBrowser()
	{
		if(configfilereader.getBrowserName().equalsIgnoreCase("Chrome"))
		{

			System.setProperty("webdriver.chrome.driver",sourceFolder+"/Drivers/chromedriver.exe");
			driver=new ChromeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

	}


	/*public void browserClose()
	{
		driver.close();
	}*/

	@AfterClass(alwaysRun=true)
	public void endClasses(){
		ExtentManager.getInstance().flush();
	}

	@AfterTest(alwaysRun=true)
	public void endTest(){
		try{
			driver.close();
		}catch(Exception e){
			System.out.println(e.getCause());
		}
	}
}
