package soniClasses.freeCrm.module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import soniClasses.freeCrm.po.FreeCrmHomePagePO;

public class HomePageModule {
	
	WebDriver driver;
	public HomePageModule(WebDriver driver) {
		this.driver=driver;
	}

	
	public void checkLog()
	{
		driver.switchTo().frame("mainpanel");
		FreeCrmHomePagePO fhome=PageFactory.initElements(driver, FreeCrmHomePagePO.class);
		fhome.islogoPresent();
	}

}
