package Pratice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utitiles.Excel_utility;

public class DataProviderExcel {
	@Test(dataProvider = "getData")
	public void readData(String from,String to)
	{
		System.out.println(from+"----------"+to);
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Excel_utility elib= new Excel_utility();
		Object[][] value= elib.readMultipleData("getdata");
		return value;
	}
	

}
