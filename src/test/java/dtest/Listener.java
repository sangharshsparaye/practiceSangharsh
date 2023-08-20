package dtest;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import abase.Base;
import cutility.Utility;

public class Listener extends Base implements ITestListener {
	
	
	//@Override
	public void onTestFailure(ITestResult result) {
		try {
			Utility.takingScreenShot(driver,result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("This "+result.getName()+" is succesfully completed", true);
	}
	
	//@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("This "+result.getName()+" is succesfully skipped", true);
	}
	
	//@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("This "+result.getName()+" is succesfully completed", true);
	}

}
