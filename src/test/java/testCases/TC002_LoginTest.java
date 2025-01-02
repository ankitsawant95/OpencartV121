package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups={"sanity","master"})
	public void Verify_Login() {
		logger.info("Execution Start");
		try {
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			 MyAccountPage mp=new  MyAccountPage (driver);
			 boolean targetPage= mp.isMyAccountPageExist();
			 
			 Assert.assertTrue(targetPage); //Assert.assertEquals(targetPage, true,"login failed");
		}
		catch(Exception e) {
			Assert.fail();
			
		}
		 
		
		
		
		
	}

}
