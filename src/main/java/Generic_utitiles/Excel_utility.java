package Generic_utitiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility {
	/**
	 * this method is used for fetch data from excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author sachin joshi
	 */
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fes= new FileInputStream("C:\\Users\\sachin joshi\\eclipse-workspace\\Framework\\src\\main\\resources\\Exceldata.xlsx");
		Workbook book =WorkbookFactory.create(fes);
		 Sheet sheetname = book.getSheet(sheetName);
		 Row rownum = sheetname.getRow(rowNum);
		 Cell cellnum = rownum.getCell(cellNum);
		  String  Value = cellnum.getStringCellValue();
		return  Value;
	}
		
		/*DataFormatter format=new DataFormatter();
		 
		String data = format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		return data;*/
		
		/**
		 * Fetching data from excel by using DataFormatter
		 * @param sheetName
		 * @param rowNum
		 * @param cellNum
		 * @return
		 * @throws IOException 
		 * @throws InvalidFormatException 
		 * @throws EncryptedDocumentException 
		 * @throws Throwable
		 */
		public String getExcelUsingDataFormatter(String sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, InvalidFormatException, IOException
		{
			FileInputStream fes= new FileInputStream("C:\\Users\\sachin joshi\\eclipse-workspace\\Framework\\src\\main\\resources\\Exceldata.xlsx");
			Workbook book =WorkbookFactory.create(fes);
			DataFormatter format=new DataFormatter();
			String data = format.formatCellValue(book.getSheet(sheetname).getRow(rowNum).getCell(cellNum));			
			
			return data;
		}
			
			public Object[][] readMultipleData(String SheetName) throws EncryptedDocumentException, InvalidFormatException, IOException
			{
				FileInputStream fes1= new FileInputStream("C:\\Users\\sachin joshi\\eclipse-workspace\\Framework\\src\\main\\resources\\Exceldata.xlsx");
				Workbook book1 =WorkbookFactory.create(fes1);
				
				Sheet sh=book1.getSheet(SheetName);
				int lastRow =sh.getLastRowNum()+1;
				int lastCell=sh.getRow(0).getLastCellNum();
				
			//	Sheet sheet=book1.getSheet(SheetName);
				////int numrow =sheet.getPhysicalNumberOfRows();
			//	int numcell=sheet.getRow(0).getLastCellNum();
			
				
				
				
			Object[][] obj= new Object[lastRow][lastCell];
				
				for(int i=0;i<lastRow;i++)
				{
					for(int j=0;j<lastCell;j++)
					{
						obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
					}
				}
				return obj;
				
			}
		
		
	}


