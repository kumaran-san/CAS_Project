package TestBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.*;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	
	public WebDriver driver;
	public static TakesScreenshot ts;
	
	@BeforeTest
	@Parameters({"browser","url"})
	public void setDriver(String br,String url) {
		if(br.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
		}
		else if(br.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(url);
		}
		else {
			System.out.println("No browser found!!!");
		}
		
		ts = (TakesScreenshot)driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
	}
	
	
	public static String captureScreen(String name) {

		

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

			File src=ts.getScreenshotAs(OutputType.FILE);

			String targetPath=System.getProperty("user.dir")+"\\screenshots\\"+name+"_"+timeStamp+".png";

			File target=new File(targetPath);

			src.renameTo(target);

			return targetPath;

		}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
