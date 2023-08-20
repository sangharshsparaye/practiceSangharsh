package bpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {
  
	

		// 1.variable
		@FindBy(xpath = "//a[@class=\"sign-in\"]") private WebElement  SignInButton;
		@FindBy(xpath ="(//input[@type=\"number\"])[2]" )  private  WebElement  MobNum;
		@FindBy(xpath = "(//a[@id=\"central-loggin-with-pwd\"])[2]")private WebElement SignInPass;
		@FindBy(xpath = "//input[@id='central-login-password']")  private     WebElement PassWordField;
	     @FindBy(xpath = "//a[@id='login-in-with-password']")   private   WebElement SignButton1;
	     @FindBy(xpath = "//a[@class='signed signed-desk']") private      WebElement myAccount;
	     @FindBy(xpath = "//span[text()=' My profile ']") private  WebElement  myProfile;
		
	     // 2.Constructor
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this );
		}
		
		// 3.Methods
		public void ClickonSignInButton()
		{ 
			SignInButton.click();
			}
		public void EnterMobNum(String mobNu)
		{
			MobNum.sendKeys(mobNu);
		}
		public void clickonSignInPass()
		{
			SignInPass.click();
		}
		
		public void  enterPassWordField(String pwd)
		{
			 PassWordField.sendKeys(pwd);
		}
		public void clickOnSignButton1()
		{
			SignButton1.click();
		}
		public void cilckOnMyAccount()
		{
			 myAccount.click();
		}
		public void clickOnMyProfile()
		{
			myProfile.click();
  }
}
