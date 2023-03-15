package Generic_utitiles;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public Property_utility plib= new Property_utility();
	
	@BeforeSuite(groups = {"SmokeTest","RegressionTest"})
	public void Bs()
	{
		System.out.println("DataBase connection");
	}
	@BeforeTest(groups = {"SmokeTest","RegressionTest"})
	public void BT()
	{
		System.out.println("Parallel Execution");
		
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"SmokeTest","RegressionTest"})
	public void BC() throws IOException {
	
		//Property_utility plib= new Property_utility();
		String BROWSER = plib.getKeyValue("browser");
		
		
		
		//WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		Webdriver_utility wlib=new Webdriver_utility();
		Boolean maximize = true;
		wlib.window_mode(driver, maximize);
		System.out.println("Launching Browser");
		sdriver=driver;
	}
	@BeforeMethod(groups = {"SmokeTest","RegressionTest"})
	public void BM() throws Throwable
	{
		//Property_utility plib= new Property_utility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		driver.get(URL);
		Login_Page login=new Login_Page(driver);
		login.loginToApp(USERNAME, PASSWORD);

		System.out.println("Login Application");
	}
	@AfterMethod(groups = {"SmokeTest","RegressionTest"})
	public void AM()
	{
		 Home_Page home= new  Home_Page(driver);
			home.logout(driver);

		System.out.println("Logout Application");
		
	}
	@AfterClass(groups = {"SmokeTest","RegressionTest"})
	public void AC()
	{
		System.out.println("Close the Browser");
	}
	@AfterTest(groups = {"SmokeTest","RegressionTest"})
	public void AT()
	{
		System.out.println("Parallel Excution done");
	}
	@AfterSuite(groups = {"SmokeTest","RegressionTest"})
	public void AS()
	{
		System.out.println("DataBase Closed");
	}

}
