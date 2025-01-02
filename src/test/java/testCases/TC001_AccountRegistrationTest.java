package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	@Test(groups={"regression","master"})
	public void verify_AccountRegistration() throws InterruptedException {
		
		logger.info("Testcase Execution is started");
		
		try {
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("click on my account link");
			hp.clickRegister();
			logger.info("click on my register link");
			
			RegistrationPage rgpage=new RegistrationPage(driver);
			logger.info("Providing customer details");
			rgpage.setFirstName(randomString().toUpperCase());
			rgpage.setLasttName(randomString().toUpperCase());
			rgpage.setEmail(randomString()+"@gmail.com");
			rgpage.setPassword(randomAlphaNumeric());
			Thread.sleep(3000);
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
			
			Thread.sleep(3000);
			rgpage.setPrivacyPolicy();
			rgpage.clickContinue();
			
			logger.info("validating expected result");
			
			String confmsg = rgpage.getConfirmationMsg();
			if(confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}
			else {
				logger.error("test case failed");
				logger.debug("Debug logs");
				Assert.assertTrue(false);
			}
			
		}
		catch(Exception e) {
			
			Assert.fail();
			
		}
		
		logger.info("Exection finish");
		
	}
	

}
