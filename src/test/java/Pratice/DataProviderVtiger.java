package Pratice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utitiles.Property_utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderVtiger {
	
	@Test(dataProvider="dataProvider_test")
	public void companyDetails(String name,String phonenum,String Email) throws IOException
	{
		Property_utility plib= new Property_utility();
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
		}
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
			driver.findElement(By.name("accountname")).sendKeys(name);
			driver.findElement(By.id("phone")).sendKeys(phonenum);
			driver.findElement(By.id("email1")).sendKeys(Email);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			driver.quit();
	}
			@DataProvider
			public Object[][] dataProvider_test() throws Throwable
			{
	
				Random ran= new Random();
				int randmn = ran.nextInt(1000);
				Object[][] objArr=new Object[3][3];
				objArr[0][0]="AAA";
				objArr[0][1]="9876543210";
				objArr[0][2]="aaa@gmail.com";
				
				Thread.sleep(1000);
				objArr[1][0]="BBB";
				objArr[1][1]="8901234560";
				objArr[1][2]="bbb@gmail.com";
				
				Thread.sleep(1000);

				objArr[2][0]="CCC";
				objArr[2][1]="7678982321";
				objArr[2][2]="ccc@gmail.com";
				return objArr;
				/*FileInputStream fis1= new FileInputStream("src\\main\\resources\\Exceldata.xlsx");
				Workbook book = WorkbookFactory.create(fis1);
				
				Sheet sheet = book.getSheet("DataProvider");
				int numrow =sheet.getPhysicalNumberOfRows();//num of rows
				int numcell = sheet.getRow(0).getLastCellNum();
				
				Object[][] obj= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				for(int i=0;i<sheet.getLastRowNum();i++)
				{
					for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
					{
						obj[i][j]=sheet.getRow(i+1).getCell(j).toString();
					}
				}
				return obj;*/
					}
				
				
			}


