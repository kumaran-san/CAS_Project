package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

 
public class first_Page extends BaseClass{

	//Constructor
	public first_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		//Locate the User Information element
	   @FindBy(id="O365_MainLink_Me")

	   WebElement User;

	   public void ClickUser() throws InterruptedException {

		   User.click();
		   Thread.sleep(5000);
		   User.click();

	   }
	   //Locate the name of the user
	   @FindBy(id="mectrl_currentAccount_primary")

	   WebElement Name;

	   public String getUsername() {

		   return Name.getText();

	   }
	   //Locate the email of the user
	   @FindBy(id="mectrl_currentAccount_secondary")

	   WebElement Email;

	   public String getUserEmail() {

		   return Email.getText();

	   }
	   //Locate the Around Cognizant text
	   @FindBy(xpath="//*[@id='5d7d4eec-cbe0-4c55-ae2e-f38d926d82a0']/div/div/div/p/span/strong")
	   private WebElement aroundCog;

	   public WebElement getAroundCogzEle() {
		   return getAroundCog();
	   }
	   
	   public String VerifyAroundCog()

	   {
		   return getAroundCog().getText();

	   }
	   
	   @FindBy(xpath="//*[@id='5d7d4eec-cbe0-4c55-ae2e-f38d926d82a0']/div/div/div/p/span/strong")
	   WebElement FirstPageNews;
	   
	   public WebElement getFirstPageNewsEle() {
		   return FirstPageNews;
	   }

	   
	   @FindBy(xpath="//div[@id='vpc_WebPart.NewsWebPart.internal.6a300658-3c93-45bc-8746-5964a4379bbf']//a[@id='news_text_title']")
	   List<WebElement> First;
	   
	   public List<WebElement> first(){
		   return First;
	   }

	   @FindBy(xpath="//div[@id='c24ff0ed-b166-42e5-b7d5-57c9a9e573cb']//p/a[@href]")
	   private
	   WebElement SeeAll;

	   public WebElement getSeeAllEle() {
		   return getSeeAll();
	   }
	   public void ClickSeeAll() {

		   getSeeAll().click();

	   }

	public WebElement getAroundCog() {
		return aroundCog;
	}

	public void setAroundCog(WebElement aroundCog) {
		this.aroundCog = aroundCog;
	}

	public WebElement getSeeAll() {
		return SeeAll;
	}

	public void setSeeAll(WebElement seeAll) {
		SeeAll = seeAll;
	}
	   
//	   public void Scroll(WebElement element)
//
//		{
//		   
//		   
//		   new Actions(driver).scrollToElement(element).perform();
//		}
//	   
	   

}