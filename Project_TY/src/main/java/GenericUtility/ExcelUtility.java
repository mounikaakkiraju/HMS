package GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility
{
	public String readDataFromExcel(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream(IpathConstant.ExcelPath);
		Workbook book = WorkbookFactory.create(file);
		 Sheet sheet = book.getSheet(sheetName);
		 String value=sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
		 return value;
	}
	
	public int getTotalRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream(IpathConstant.ExcelPath);
		Workbook book = WorkbookFactory.create(file);
		 Sheet sheet = book.getSheet(sheetName);
		 int LastRow = sheet.getLastRowNum();
		 return LastRow;
		 
	}
	
	public void writeDataIntoExcel(String sheetName,int rowNo,int cellNo,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(IpathConstant.ExcelPath);
		Workbook book = WorkbookFactory.create(file);
		 Sheet sheet = book.getSheet(sheetName);
		 sheet.createRow(rowNo).createCell(cellNo).setCellValue(data);
		 
		 FileOutputStream file1=new FileOutputStream(IpathConstant.ExcelPath);
		 book.write(file1);
		 book.close();	
	}
	
	public HashMap<String, String>readMultipleData(String sheetName,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(IpathConstant.ExcelPath);
		Workbook book = WorkbookFactory.create(file);
		 Sheet sheet = book.getSheet(sheetName);
		 int Lrow=sheet.getLastRowNum();
		
		 HashMap<String, String> map=new HashMap<String, String>();
		 
		 for(int i=0;i<=Lrow;i++)
		 {
			 String key=sheet.getRow(i).getCell(cellNo).getStringCellValue();
			 String value=sheet.getRow(i).getCell(cellNo+1).getStringCellValue();
			 map.put(key, value);
		 }
		 return map;
	}
	
	

}
