package basicframework.AutomationBase;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

	protected WebDriver driver;

	public BasePageObject(WebDriver driver)
	{
		this.driver=driver;
	}



	public WebElement isElementClickable(By locator){

		WebDriverWait wait=new WebDriverWait(driver,60);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));	
	}

	public WebElement isElementClickable(WebElement elm){

		WebDriverWait wait=new WebDriverWait(driver,60);
		return wait.until(ExpectedConditions.elementToBeClickable(elm));	
	}

	public WebElement isElementVisible(By locator){


		WebDriverWait wait=new WebDriverWait(driver,60);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	
	
	public WebElement isElementVisible(WebElement elm){


		WebDriverWait wait=new WebDriverWait(driver,60);
		return wait.until(ExpectedConditions.visibilityOf(elm));

	}
	
	

	public Boolean isElementInVisible(By locator){

		WebDriverWait wait=new WebDriverWait(driver,60);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));


	}
	
	public WebElement findElementsafely(final By locator){
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(180, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(StaleElementReferenceException.class,NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver){
				return driver.findElement(locator);
			}
		});
		return foo;
	}
	
	public WebElement findElementsafely(final WebElement element){
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(180, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(StaleElementReferenceException.class,NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver){
				return element;
			}
		});
		return foo;
	}
	
	public void enterValueOn(By locator,String value)
	{
		findElementsafely(locator).sendKeys(value);
		
		
	}
	
	public void enterValueOn(WebElement elem,String value)
	{
		findElementsafely(elem)	.sendKeys(value);
		
	}
	
	
	
	public void clickToButton(By locator,String value)
	{
		findElementsafely(locator).click();
		
	}
	
	public void clickToButton(WebElement elem)
	{
		findElementsafely(elem).click();
		
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	
	
	public String getElementText(By locator){
		return findElementsafely(locator).getText();
	}
	
	public String getElementText(WebElement element){
		return findElementsafely(element).getText();
	}
	
	
	public String getElementAttributeValue(By locator,String attributeName){
		return findElementsafely(locator).getAttribute(attributeName);
	}
	
	public String getElementAttributeValue(WebElement element,String attributeName){
		return findElementsafely(element).getAttribute(attributeName);
	}
	
	public String getElementCssValue(By locator,String CssPropertyName){
		return findElementsafely(locator).getCssValue(CssPropertyName);
	}
	
	public String getElementCssValue(WebElement element,String CssPropertyName){
		return findElementsafely(element).getCssValue(CssPropertyName);
	}





}
