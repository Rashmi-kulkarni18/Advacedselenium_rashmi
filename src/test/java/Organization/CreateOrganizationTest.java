package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_utitiles.BaseClass;
import Generic_utitiles.Excel_utility;
import Generic_utitiles.Java_utility;
import Generic_utitiles.Property_utility;
import Generic_utitiles.Webdriver_utility;
import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import POM_Repo.OrganizationCreatePage;
import POM_Repo.Validation;
import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(Generic_utitiles.Listener.java.class)
public class CreateOrganizationTest extends BaseClass {

	//@Test(groups = "SmokeTest")
	@Test(retryAnalyzer= Generic_utitiles.RetryAnalayser.class)
	public void createOrganizationTest() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException {
		//Property_utility plib= new Property_utility();
		
		
		//WebDriverManager.chromedriver().setup();
		//ChromeDriver driver=new ChromeDriver();
		//String key="webdriver.chrome.driver";
		//String value="./src/main/resourceschromedriver.exe";
		//String value="C:\\Users\\sachin joshi\\eclipse-workspace\\Framework\\src\\main\\resources\\chromedriver.exe";
		//System.setProperty(key, value);
	//	WebDriver driver = new ChromeDriver();
	//	Webdriver_utility wlib=new Webdriver_utility();
		//driver.manage().window().maximize();
		//wlib.window_mode(driver, maximize);
		
		
		//String URL = plib.getKeyValue("url");
		//String USERNAME = plib.getKeyValue("username");
		//String PASSWORD = plib.getKeyValue("password");
		/*FileInputStream fis= new FileInputStream("./src/test/resources/Commondata.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url"); 
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
		
		//Login vtiger Application
		//driver.get(URL);
		//Login_Page login=new Login_Page(driver);
		//login.loginToApp(USERNAME, PASSWORD);
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		//click on oragaization
		 Home_Page home= new  Home_Page(driver);
		 home.ClickOrganization();
		 Assert.assertEquals(true, false);
		//driver.findElement(By.linkText("Organizations")).click();
		//click on + img
		 OrganizationCreatePage orgpage= new OrganizationCreatePage(driver);
		orgpage .clickOrganization();
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		
		Java_utility jlib= new Java_utility();
		int ranNum=jlib.getRanDomNum();
		//Random ran =new Random();
		//int ranNum = ran.nextInt(1000);
		
		
		//Fetching data from Excel
		Excel_utility elib=new Excel_utility();
		String orgName = elib.getExcelData("Organization", 0, 0)+ranNum;
		/*FileInputStream fes= new FileInputStream("C:\\Users\\sachin joshi\\eclipse-workspace\\Framework\\src\\main\\resources\\Exceldata.xlsx");
		Workbook book =WorkbookFactory.create(fes);
		 Sheet sheetname = book.getSheet("Organization");
		 Row rownum = sheetname.getRow(0);
		 Cell cellnum = rownum.getCell(0);
		  String  orgName = cellnum.getStringCellValue()+ranNum;*/
		  
		  //add excel data
		orgpage.organizationName(orgName);
		//driver.findElement(By.name("accountname")).sendKeys(orgName);
		//save
		orgpage.saveButton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//logout
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		//String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		Validation val= new Validation(driver);
		String actData=val.orgvalidate(driver, orgName);
		Assert.assertEquals(orgName, actData);
		/*if(actData.contains(orgName))
		{
			System.out.println("pass");
		}
		else {
			
			System.out.println("fail");
		}*/
	
		//home.logout(driver);
		
	}
	//@Test
	//public void m1()
	//{
	//	System.out.println("M1 running");
	//}

}
