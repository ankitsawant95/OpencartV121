package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	public HomePage(WebDriver driver)
	{
		
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnk_MyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login_lnk;
	
	
	public void clickMyAccount() {
		
		lnk_MyAccount.click();
		
	}
	
	public void clickRegister() {
		
		lnkRegister.click();
		
	}
	
   public void clickLogin() {
		
	   login_lnk.click();		
	}
	
	

}
