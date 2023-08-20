package bpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class myAccountPage {
  
	//variable
		@FindBy(xpath = "//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']")private WebElement userName;
       @FindBy(xpath = "//div[@title=\"Logout\"]")private WebElement logout;
		//constructor
		public myAccountPage(WebDriver driver)
		{
		PageFactory.initElements(driver, this);
		}
		
		//methods
		public  String getActualUserName()
		{
			  String actualUN = userName.getText();
			          return actualUN;
		}
		public void clickOnLogoutButton()
		{
			logout.click();
		}
		}

