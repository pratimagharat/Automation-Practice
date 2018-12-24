package SoniClassess.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutor {

	public void scrollingTo(WebDriver driver){

		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}

	public static void scrollingToView(WebDriver driver, WebElement element){

		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}


	public static void highlightElement(WebDriver driver, WebElement element){

		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','border: 2px solid red;');",element);
	}
	
	public static void typeUsingJavaScript(WebDriver driver, WebElement element,String valueToType){

		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value ='"+valueToType+"';",element);
	}
	
	public static void clickUsingJavaScript(WebDriver driver, WebElement element){

		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	
	public static String getTitleUsingJavaScript(WebDriver driver){

		JavascriptExecutor js =(JavascriptExecutor)driver;
		String text=js.executeScript("return document.title;").toString();
		return text;
	}
}
