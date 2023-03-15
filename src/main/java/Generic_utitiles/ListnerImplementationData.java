package Generic_utitiles;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementationData implements ITestListener {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		/* Step:3 Create a test method during the test execution start*/
		test=report.createTest(result.getMethod().getMethodName());
		}
		
	
	public void onTestSuccess(ITestResult result) {
		 /*Step:4 Log the pass method*/
		test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
	
	}
		
	public void onTestSkipped(ITestResult result) {
		
/*step:6 Log the skip method()*/
		
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
		
	
	}
	public void onStart(ITestContext context) {
		
/*Step:1 Extent report configuration*/
		
		Date d = new Date();
		
		String date = d.toString().replace(" ", "-").replace(":", "-");
		System.out.println(date);
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(new File("extentreport.html"));				
        htmlReport.config().setDocumentTitle("Extent Report");
        htmlReport.config().setTheme(Theme.STANDARD);
        htmlReport.config().setReportName("Functional Test");
        
/*Step:2 Attach the physical report and do the system configuration*/
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("Environment", "Testing Environment");
		report.setSystemInfo("URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Shobha");
		}

			
	public void onTestFailure(ITestResult result) {
		String testData = result.getMethod().getMethodName();
		
		 System.out.println("------execute-----");
			
		  EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		  File src= edriver.getScreenshotAs(OutputType.FILE);
		 
		  try
		  {
			 // FileUtils.copyFile(src,new File("./ScreenShot/"+testName+".png"));
			  FileUtils.copyFile(src,new File("./ScreenShot/"+testData+".png")); 
		  }
		  catch (Exception e) {
		e.printStackTrace();
		}
	}


	public void onFinish(ITestContext context) {
		report.flush();
		
			}
	
	

}
