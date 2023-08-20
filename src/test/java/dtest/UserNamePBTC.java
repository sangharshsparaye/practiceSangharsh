package dtest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import abase.Base;
import bpom.LoginPage;
import bpom.myAccountPage;
import cutility.Utility;
   // @Listeners(testPackagePolicyBazar.Listener.class)
public class UserNamePBTC extends Base {
	 
	 LoginPage login;
	 myAccountPage myAcc;
	 String TCID="PB_TC1234";
	
	@BeforeClass
	public void launchPolicyBazar() throws InterruptedException, IOException
	{
		Utility.waiting(2000);
		launchBrowserPropertyFile();
		login=new LoginPage(driver);
		myAcc=new myAccountPage(driver);
        
			}
	
	
	@BeforeMethod
	public void signIntoPolicyBazar () throws InterruptedException, EncryptedDocumentException, IOException
	{
		Utility.waiting(4000);
	     login.ClickonSignInButton();
	     Utility.waiting(4000);
	     login.EnterMobNum(Utility.readDataFromPropertyFile("mobNu"));
	     Utility.waiting(4000);
	     login.clickonSignInPass();
	     Utility.waiting(4000);
	     login.enterPassWordField(Utility.readDataFromPropertyFile("pwd"));
	     Utility.waiting(4000);
	     login.clickOnSignButton1();
	     Utility.waiting(4000);
	     login.cilckOnMyAccount();
	     Utility.waiting(4000);
	     login.clickOnMyProfile();
	     
	            Set<String> allPageID = driver.getWindowHandles();
	           List<String>l=new ArrayList<String>(allPageID);
	                     String mainPageId = l.get(0);
	                       String childPageId = l.get(1);
	                       driver.switchTo().window(childPageId);
	                      Utility.waiting(3000);
	}
	
		
	@Test
 public void validateUsNm() throws EncryptedDocumentException, IOException 
	{
		    String actualUN = myAcc.getActualUserName();
		           String expectedUN = Utility.readDataFromPropertyFile("UserNM");
		           Assert.assertEquals(actualUN, expectedUN,"if values are not match then TC is fail");
		           Utility.takingScreenShot(driver, actualUN+" "+TCID);		
 }
	
	@AfterMethod
	public void logInPolicyBazar() throws InterruptedException
	{
		Utility.waiting(3000);
		myAcc.clickOnLogoutButton();
	}
	@AfterClass
	public void closeApplication() throws InterruptedException
	{
		//Utility.waiting(3000);
		closeBrowser();
	}
	
	
	}

