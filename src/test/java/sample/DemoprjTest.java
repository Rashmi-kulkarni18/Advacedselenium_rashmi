package sample;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


import Generic_utitiles.BaseClass;
import Generic_utitiles.Excel_utility;
import Generic_utitiles.Java_utility;
import POM_Repo.Home_Page;
import POM_Repo.OrganizationCreatePage;

public class DemoprjTest extends BaseClass{
	@Test(groups = "SmokeTest")
	public void createOrganizationTest() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException {
		
		
		
		//click on oragaization
		 Home_Page home= new  Home_Page(driver);
		 home.ClickOrganization();
		//driver.findElement(By.linkText("Organizations")).click();
		//click on + img
		 OrganizationCreatePage orgpage= new OrganizationCreatePage(driver);
		orgpage .clickOrganization();
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		
		Java_utility jlib= new Java_utility();
		int ranNum=jlib.getRanDomNum();
		
		
		//Fetching data from Excel
		Excel_utility elib=new Excel_utility();
		String orgName = elib.getExcelData("Organization", 0, 0)+ranNum;
		
		  
		  //add excel data
		orgpage.organizationName(orgName);
	
		//save
		orgpage.saveButton();
		
		//logout
		Thread.sleep(2000);
		
		String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actData.contains(orgName))
		{
			System.out.println("pass");
		}
		else {
			
			System.out.println("fail");
		}
	}
	

}
