package TestBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
 
public class Scroll_To_Element /* extends BasePage */{
	WebDriver driver;

	public Scroll_To_Element(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public Scroll_To_Element(WebDriver driver){ super(driver); }
	 */
	public void Scroll(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",e);
	}
 
//	public void executeScript(String string) {
//		// TODO Auto-generated method stub
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("windows.open()");
//	}
 
}