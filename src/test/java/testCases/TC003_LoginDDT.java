package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.Dataprovider;

public class TC003_LoginDDT extends BaseClass{
	@Test(dataProvider="logindata", dataProviderClass=Dataprovider.class, groups="datadriven")
	public void verify_LoginDDT(String email, String password, String exp) {
		
		logger.info("*****Starting TC003_LoginDDT*****");
		try {
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();
			
			 MyAccountPage mp=new  MyAccountPage (driver);
			 boolean targetPage= mp.isMyAccountPageExist();
			 
			
			 
			 if(exp.equalsIgnoreCase("Valid")) {
				 
				 if(targetPage==true) {
					 mp.clickOnLogOut();
					 Assert.assertTrue(true);
				 }
				 else {
					 Assert.assertTrue(false);
				 }
				 
				if(exp.equalsIgnoreCase("Invalid")) {
					if(targetPage==true) {
						mp.clickOnLogOut();
						
						
						Assert.assertTrue(false);
					}
					
					else {
						Assert.assertTrue(true);
					}
					
				} 
				 
				 
				 
			 }
		}
		catch(Exception e){
			Assert.fail();
		}
		 
		 logger.info("*****Finished TC003_LoginDDT*****");
		 
		 
		 	 
		
	}
	
}
	

	
