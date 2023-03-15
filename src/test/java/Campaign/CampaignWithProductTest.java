package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.*;

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
import org.testng.annotations.Test;

import Generic_utitiles.BaseClass;
import Generic_utitiles.Property_utility;
import Generic_utitiles.Webdriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CampaignWithProductTest extends BaseClass {
	
	@Test(groups = {"SmokeTest","RegressionTest"})
	public  void campaignWithProductTest()  throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		/*Property_utility plib= new Property_utility();
		String BROWSER = plib.getKeyValue("browser");
		
		
		WebDriver driver;
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
		}*/
		//String key="webdriver.chrome.driver";
		//String value="./src/main/resourceschromedriver.exe";
		//String value="C:\\Users\\sachin joshi\\eclipse-workspace\\Framework\\src\\main\\resources\\chromedriver.exe";
		//System.setProperty(key, value);
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream fis= new FileInputStream("./src/test/resources/Commondata.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url"); 
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		//Login vtiger Application
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//click on product
		driver.findElement(By.linkText("Products")).click();
		//click on + img
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		Random ran =new Random();
		int ranNum = ran.nextInt(1000);
		
		
		//Fetching data from Excel
		FileInputStream fes= new FileInputStream("C:\\Users\\sachin joshi\\eclipse-workspace\\Framework\\src\\main\\resources\\Exceldata.xlsx");
		Workbook book =WorkbookFactory.create(fes);
		 Sheet sheetname = book.getSheet("Products");
		 Row rownum = sheetname.getRow(0);
		 Cell cellnum = rownum.getCell(0);
		  String  prdName = cellnum.getStringCellValue()+ranNum;
		  
		  //add excel data
		driver.findElement(By.name("productname")).sendKeys(prdName);
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//click on more option
		driver.findElement(By.linkText("More")).click();
		
		//click on campaign
		driver.findElement(By.linkText("Campaigns")).click();
		//click on + img
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		Random ran1 =new Random();
		int ranNum1= ran1.nextInt(1000);
		
		
		//Fetching data from Excel
		FileInputStream fies= new FileInputStream("C:\\Users\\sachin joshi\\eclipse-workspace\\Framework\\src\\main\\resources\\Exceldata.xlsx");
		Workbook book1 =WorkbookFactory.create(fies);
		 Sheet sheetname1 = book1.getSheet("Campaigns");
		 Row rownum1 = sheetname1.getRow(0);
		 Cell cellnum1 = rownum1.getCell(0);
		  String campName1 = cellnum1.getStringCellValue()+ranNum1;
		  
		  //add excel data
		driver.findElement(By.name("campaignname")).sendKeys(campName1);
		
		//getwindowhandle parent window
		String parentwin= driver.getWindowHandle();
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		//getwindowhandles child window
		Webdriver_utility wlib=new Webdriver_utility();
		wlib.switchWindow(driver, parentwin);
		/*Set<String> all_windows=driver.getWindowHandles();
		//Iterator<String> it=all_windows.iterator();
		
		
		System.out.println(all_windows);
		
		for(String win:all_windows)
		{	
			System.out.println(driver.switchTo().window(win).getTitle());  //swicthed to new window
		}*/
		//enter search text
		driver.findElement(By.name("search_text")).sendKeys(prdName);
		//click on search know
		driver.findElement(By.xpath("//input[@name='search']")).click();
		//click on searched text
		
		//waiting fr some time before clicking on results
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[contains(text(),'"+prdName+"')]")).click();
		System.out.println("clicked on product name "+prdName);
		
		Thread.sleep(3000);
		
		//switch to parent window
		driver.switchTo().window(parentwin).getTitle();
		
		Thread.sleep(2000);
		//save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//logout button		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();

		
		
		
		
		
	
		
		


	}

}
