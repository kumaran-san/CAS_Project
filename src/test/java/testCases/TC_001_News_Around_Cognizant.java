package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import TestBase.BaseClass;
import TestBase.Scroll_To_Element;
import pageObject.first_Page;
import pageObject.second_Page;
import utilities.Excel_Utility;

public class TC_001_News_Around_Cognizant extends BaseClass{

	first_Page fp;
	Scroll_To_Element ste;
	second_Page sp;
	
	
	List<WebElement> news = new ArrayList<WebElement>();
	List<String> first_Page_News=new ArrayList<String>();
	List<String> first_Page_News_Tooltip = new ArrayList<String>();

	List<String> secondNewsHeaders=new ArrayList<String>();
	JavascriptExecutor js;

	List<String> NEWS = new ArrayList<String>();
	List<String>  secondNewsToolTips= new ArrayList<String>();

	@Test(priority=1)
	public void validateUser()  {
		try {
		first_Page fp = new first_Page(driver);
		
		Thread.sleep(3000);
		fp.ClickUser();
		
		
		//get the name
		Thread.sleep(3000);
		String name = fp.getUsername();
		System.out.println("The Name is: "+name);
		
		
		//Validating name
		Assert.assertEquals(name, "Selvaraj, Kumaran (Contractor)");
		
		
		Thread.sleep(3000);
		
		//get the email
		
		String email = fp.getUserEmail();
		System.out.println("The Email is: "+email);
		
		//Validating email
		Assert.assertEquals(email, "2318580@cognizant.com");}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test(priority=2)
	public void validationOfAroundCognizant() throws IOException, InterruptedException {
		ste = new Scroll_To_Element(driver);
		fp = new first_Page(driver);

		ste.Scroll(fp.getAroundCog());
		Thread.sleep(3000);

		System.out.println("Scrolled to Around Cognizant");

		String aroundCognizant =fp.VerifyAroundCog();

		Assert.assertEquals(aroundCognizant,"Around Cognizant");
	}
	@Test(priority=3)
	public void newsAroundCognizantFirstPage() throws IOException, InterruptedException {
		ste = new Scroll_To_Element(driver);
		fp = new first_Page(driver);
//		WebElement firstPageNews = driver.findElement(By.xpath("//*[@id='5d7d4eec-cbe0-4c55-ae2e-f38d926d82a0']/div/div/div/p/span/strong"));
		WebElement firstPageNews=fp.getFirstPageNewsEle();
		ste.Scroll(firstPageNews);
		Thread.sleep(5000);
		
		
		//WebElement loc = driver.findElement(By.xpath("//*[@id='6a300658-3c93-45bc-8746-5964a4379bbf']"));
		
		news=fp.first();
		//news = loc.findElements(By.xpath("//div[@id='vpc_WebPart.NewsWebPart.internal.6a300658-3c93-45bc-8746-5964a4379bbf']//a[@id='news_text_title']"));
		first_Page_News = new ArrayList<String>();
		
		for(WebElement e:news) {
			String header = e.getText();
			String toolTip = e.getAttribute("title");
			System.out.println("The News Header is: "+header+" \nThe ToolTip is: "+toolTip);
			if(header.equals(toolTip)) {
				System.out.println("The news header and its tooltip are same...");
				Assert.assertEquals(header, toolTip);
			}
			else {
				System.out.println("The news header and its tooltip are not same...");
				
			}
			first_Page_News.add(header);
			first_Page_News_Tooltip.add(toolTip);
			System.out.println();
		}
		System.out.println(first_Page_News.size());
		int i =1;
		for(String s:first_Page_News) {
			System.out.println(i+": "+s);
			i++;
		}
		
		Excel_Utility.enterData(first_Page_News, first_Page_News_Tooltip);

		
	}
	@Test(priority = 4)

	public void clickSeeAll() throws IOException, InterruptedException {

		ste = new Scroll_To_Element(driver);
		fp = new first_Page(driver);
		ste.Scroll(fp.getSeeAll());
		
		Thread.sleep(4000);
		fp.ClickSeeAll();
		
		Thread.sleep(5000);
		
	}
	@Test(priority = 5)
	public void SecondPage() throws InterruptedException, IOException

	{
		ste = new Scroll_To_Element(driver);
		
		fp = new first_Page(driver);
		
		sp = new second_Page(driver);
		
		Thread.sleep(5000);

		List<WebElement> SecondNews = sp.SecondNews();

	    System.out.println("First 5 News Headers of Second Page are : ");

	     for(int k=0;k<SecondNews.size();k++) {

	    	 String SecondPageNews =SecondNews.get(k).getText();
	    	 
	    	 String tooltip = SecondNews.get(k).getAttribute("title");

	    	 System.out.println(k+1+": "+SecondPageNews);
	    	 
	    	 secondNewsHeaders.add(SecondPageNews);
	   
	    	 secondNewsToolTips.add(tooltip);

	     }	     
		
}
	@Test(priority=6)
	public void top5News() throws InterruptedException, IOException {
		
		ste = new Scroll_To_Element(driver);
		
		fp = new first_Page(driver);
		
		sp = new second_Page(driver);
		
		for (int i=1;i<6;i++) {
			
			js = (JavascriptExecutor)driver;
			
			WebElement SecondNews = driver.findElement(By.xpath("(//a[@data-automation-id='newsItemTitle'][1])["+i+"]"));
			
			ste.Scroll(SecondNews);
			
			Thread.sleep(1000);
			

			String href = SecondNews.getAttribute("href");
			
			// Open a new tab
			js.executeScript("window.open()");

			// Switch to new tab
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));

			// Navigate to news URL
			driver.get(href);

			Thread.sleep(10000);//For loading the news content

			String News = driver.findElement(By.xpath("//*[@data-automation-id='textBox']")).getText();

			System.out.println(i+News);
			System.out.println();
//			System.out.println("=======================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================");

			NEWS.add(News);

			driver.close();
			
			driver.switchTo().window(tabs.get(0));
			

			Thread.sleep(10000);

			}
		
		Excel_Utility.enterContent(secondNewsHeaders,NEWS);

		

	}
	
}
