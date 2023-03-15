package Generic_utitiles;



import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listener implements ITestListener {
	
	
	

	public void onTestFailure(ITestResult result) {
		String testData =result.getMethod().getMethodName();
		
		System.out.println("------execute-------");
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src =edriver.getScreenshotAs(OutputType.FILE);
		
		try
		{
			FileUtils.copyFile(src, new File("./ScreenShot"+testData+".png"));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	
	}

	
	
	
	

	

}
