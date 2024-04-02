package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;



public class second_Page extends BaseClass{
	
	   //constructor
	public second_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

//	   public second_Page(WebDriver driver){
//
//		  super(driver);
//
//	   }
	
	   @FindBy(xpath="//*[@data-automation-id='textBox']")
	   public WebElement news;
	   

	By second_Page_News = By.xpath("//*[@data-automation-id='newsItemTitle']");

	   public List<WebElement> SecondNews(){

		   return driver.findElements(second_Page_News);
	   
	   }
}
