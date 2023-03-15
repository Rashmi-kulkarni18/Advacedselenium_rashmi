package Product;

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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteProduct {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException {
		String key="webdriver.chrome.driver";
		//String value="./src/main/resourceschromedriver.exe";
		String value="C:\\Users\\sachin joshi\\eclipse-workspace\\Framework\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
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
		//delete
		driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		
		Alert alt =driver.switchTo().alert();
		alt.accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();

		


	}

}
