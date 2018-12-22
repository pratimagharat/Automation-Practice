package soniClasses.freeCrm.po;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.gargoylesoftware.htmlunit.javascript.host.html.Enumerator;

import SoniClassess.utility.JavaScriptExecutor;
import basicframework.AutomationBase.BasePageObject;

public class FreeCrmAddContactPagePO extends BasePageObject {
	
	public FreeCrmAddContactPagePO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contactlink;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkbox;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newcontactlink;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement surName;
	
	
	@FindBy(xpath="//form[@id='contactForm']//input[@value='Save']")
	WebElement saveButton;
	
	//@FindBy(xpath="")
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contact;
	
	
	public void onmousehover()
	{
		Actions action =new Actions(driver);
		action.moveToElement(contactlink).build().perform();
		System.out.println("contact hover");
		newcontactlink.click();
		
	}
	
	
	public void enterValueOnFirstName(String fname){
		clickToButton(firstName);
		System.out.println(fname);
		enterValueOn(firstName,fname);
	}
	
	public void enterValueOnSurName(String lname){
		enterValueOn(surName,lname);
	}
	
	public void clickOnSaveButton(){
		JavaScriptExecutor.highlightElement(driver, saveButton);
		clickToButton(saveButton);
	}
	
	
	public boolean checkboxpresent()
	{
		if(isElementVisible(checkbox).isDisplayed()){
		return true;
		}
		
		else{
			return false;
		}
	}
	
	/*public void addContact(,String lname)
	{
		
		
		
		
		clickToButton(contact, "click");
			firstName.sendKeys(fname);
		surName.sendKeys(lname);
		saveButton.click();
		
	}*/
	
	public void selectCheckbox()
	{
		
		List <WebElement> tr=driver.findElements(By.xpath("//input[@type='checkbox' and @name='contact_id']"));
	System.out.println(tr);
	
		
	}

}
