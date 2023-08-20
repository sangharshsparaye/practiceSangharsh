package abase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import cutility.*;

public class Base {
	
	  protected  static  WebDriver driver;
	/*public void launchBrowser()
	{
		 driver=new ChromeDriver();
		  driver.get("https://www.policybazaar.com/");
		  driver.manage().window().maximize();
		  Reporter.log("opening the Broewser", true);
	}*/
	
	
	public void launchBrowserPropertyFile() throws IOException
	{
		 driver=new ChromeDriver();
		  driver.get(Utility.readDataFromPropertyFile("url"));
		  driver.manage().window().maximize();
		  Reporter.log("opening the Broewser", true);
	}
	public void closeBrowser() throws InterruptedException
	{
		Utility.waiting(1000);
		Reporter.log("closing the Browser", true);
		driver.quit();
	
	}
	}

	


