package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver){
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_Email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_Password;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement Btn_Login;
	
	
	public void setEmail(String email) {
		
		txt_Email.sendKeys(email);
	}
	
    public void setPassword(String password) {
		
    	txt_Password.sendKeys(password);
	}

   public void clickLogin() {
		
	   Btn_Login.click();
	}

}
