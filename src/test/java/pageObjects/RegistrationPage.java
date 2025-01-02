package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
	public RegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkd_policy;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btn_continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement mssgConfirmation;

	
	public void setFirstName(String firstname) {
		txt_firstname.sendKeys(firstname);
	}
	
	public void setLasttName(String lastname) {
		txt_lastname.sendKeys(lastname);
	}
	
	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void setPrivacyPolicy() {
		chkd_policy.click();
		
	}
	
	public void clickContinue() {
		btn_continue.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return mssgConfirmation.getText();
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}

}
