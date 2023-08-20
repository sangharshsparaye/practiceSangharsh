package cutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {
	
	//screenShot
	//wait
	//scrolldown
	//readfromexcel
	
	//commonmethod for screenshot
	public static void takingScreenShot(WebDriver driver,String fileNme) throws IOException
	{           
		
	         File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	         File des=new File("C:\\Users\\Hp\\eclipse-workspace\\PolicyBazaar\\screenshots\\"+fileNme+".png");
	         FileHandler.copy(src, des);
	         Reporter.log("taking Screen shot", true);
	         Reporter.log("screenshot location is"+des, true);
	}

	//common method for scrolldown
	 public static void scrollingMethod(WebDriver driver,WebElement element)
	 {
	Reporter.log("scrolling Into View", true);
		        JavascriptExecutor js = (JavascriptExecutor)driver;
		        js.executeScript("arguments[0].scrollIntoView(true)",element);
	 }
	 
	 // readfrom excel sheet
	 public static String readingfromexcel(int rowcount,int coloumcount) throws EncryptedDocumentException, IOException
	 {
		 Reporter.log("reading data from excel row num "+rowcount+" colunm num "+coloumcount+"  ", true);
		         FileInputStream file=new FileInputStream("C:\\Users\\Hp\\OneDrive\\Desktop\\BOOKLIST.xlsx");
		         
		           String value = WorkbookFactory.create(file).getSheet("Sheet2").getRow(rowcount).getCell(coloumcount).getStringCellValue();
		           return value;
	 }
	 //wait
	 public static void waiting(int waitTime ) throws InterruptedException
	 {
		 Reporter.log("Wai for "+waitTime+" mill sec", true);
		 Thread.sleep(waitTime);
		 
	 }
	 //properties class
	 public static String readDataFromPropertyFile(String key) throws IOException
	 {
		 Properties p=new Properties();
		 FileInputStream myfile=new FileInputStream("C:\\\\Users\\\\Hp\\\\eclipse-workspace\\\\feb18batchselenium\\\\myProperty.properties");
	      p.load(myfile);
	           String value = p.getProperty(key);
	           return value;
	 }
	 }
	 
	 

