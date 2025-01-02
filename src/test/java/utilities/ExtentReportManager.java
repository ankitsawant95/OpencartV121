package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test; // creating test test case entries in the report and updating status of the methods
	String repName;
	
	public void onStart(ITestContext context) {
	  /* SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	   Date dt=new Date();
	   String currentdatetimestamp = df.format(dt);  */
	   
	   String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	   
	   repName="Test-Report-"+ timestamp+ ".html";
	   sparkReporter=new ExtentSparkReporter(".\\reports\\"+ repName);//specify location of the report
	   
	   sparkReporter.config().setDocumentTitle("OpenCart Automation Report");//title of the report
	   sparkReporter.config().setReportName("OpenCart Functional Testing"); //name of the report
	   sparkReporter.config().setTheme(Theme.DARK);
	   
	   extent=new ExtentReports();
	   extent.attachReporter(sparkReporter);
	   extent.setSystemInfo("Application", "Opencart");
	   extent.setSystemInfo("Module", "Admin");
	   extent.setSystemInfo("Sub_Module", "Customer");
	   extent.setSystemInfo("User Name", System.getProperty("user.name"));
	   extent.setSystemInfo("Environment", "QA");
	   
	   String os = context.getCurrentXmlTest().getParameter("os");
	   extent.setSystemInfo("Operating System", "os");
	   
	   context.getCurrentXmlTest().getParameter("browser");
	   extent.setSystemInfo("Browser", "browser");
	   
	    List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
	    if(!includedGroups.isEmpty()) {
	    	extent.setSystemInfo("Groups", includedGroups.toString());
	    	
	    }
	   
	   
	   }
	
	public void onTestSuccess(ITestResult result) {
	    test=extent.createTest(result.getTestClass().getName());//to get className
	    test.assignCategory(result.getMethod().getGroups());//to display group in report
	    test.log(Status.PASS, result.getName()+"Got scuccessfully Executed-------");
	  }
	
	public void onTestFailure(ITestResult result) {
		 test=extent.createTest(result.getTestClass().getName());//to get className
		 test.assignCategory(result.getMethod().getGroups());//to display group in report
		 test.log(Status.FAIL, result.getName()+"Got failed-------");
		 test.log(Status.INFO, result.getThrowable().getMessage());
		 
		 try {
			 /*BaseClass bs=new BaseClass();
			 String imgpath = bs.captureScreen(result.getName());
			 test.addScreenCaptureFromPath(imgpath);*/
			 
			 String imgpath=new BaseClass().captureScreen(result.getName());
			 test.addScreenCaptureFromPath(imgpath);
		 }
		 
		 catch(Exception e1) {
			 e1.printStackTrace();
		 }
		 
		  }
	
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+"Got Skeeped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	  }
	
	public void onFinish(ITestContext context) {
		  extent.flush();
		  }
	
	
	
	
	
	
	
	
	
	

}
