package Admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;

public class RemoveDoctor 
{
	public static WebDriver driver;
	
	@Test
	public static void RemoveDoctor() throws IOException, InterruptedException
	{

		
		FileUtility fUtil= new FileUtility();
		ExcelUtility eUtil= new ExcelUtility();
		JavaUtility jUtil= new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		
		   FileInputStream file=new FileInputStream("./src\\test\\resources\\Admin_PropertyFile.properties");
			
		   String Browser = fUtil.readDatafromProperty("browser");
		   String URL = fUtil.readDatafromProperty("url3");
		   String USERNAME=fUtil.readDatafromProperty("UserName3");
		   String Pass=fUtil.readDatafromProperty("Password3");
//	       Properties pro= new Properties();
//	       pro.load(file);
//	       String Browser=pro.getProperty("browser");
//	       String  URL=pro.getProperty("url3");
//	       String USERNAME= pro.getProperty("UserName3");
//	       String Pass=  pro.getProperty("Password3");
//	      
	       if(Browser.equalsIgnoreCase("chrome"))
		     {
		    	driver= new ChromeDriver();
		     }
		     else if(Browser.equalsIgnoreCase("firefox"))
		     {
		    	 driver=new FirefoxDriver();
		     }
		     else
		     {
		    	 System.out.println("invalid browsers");
		     }
	      
	      driver.get(URL);
	      driver.findElement(By.name("username")).sendKeys(USERNAME);
	      driver.findElement(By.name("password")).sendKeys(Pass);
	      driver.findElement(By.name("submit")).click();
	      
	      driver.findElement(By.xpath("//span[text()=' Doctors ']")).click();
	      Thread.sleep(1000);
	      driver.findElement(By.xpath(" //span[text()=' Manage Doctors ']")).click();
	      
	     FileInputStream file1 = new FileInputStream("C:\\Users\\mouni\\Downloads\\ProjectTY.xlsx");
	    
	     eUtil.readDataFromExcel("AddDoctor", 0, 1); 
		 Workbook book = WorkbookFactory.create(file1);
		 String exd=book.getSheet("AddDoctor").getRow(0).getCell(1).getStringCellValue();
	     System.out.println(exd +"--->"+" doctor data was deleted successfully");
	      
	      
	      
	      driver.findElement(By.xpath("//table/tbody/tr/td[text()='"+exd+"']/following-sibling::td//a[@tooltip='Remove']")).click();
	      driver.switchTo().alert().accept();
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	     // List<WebElement> names = driver.findElements(By.xpath("//tr/td[text()='"+exd+"']"));
	      
//	      for(WebElement name:names)
//	      {
//	    	  if(exd.equals(name))
//	    	  {
//	    		  driver.findElement(By.xpath("//table/tbody/tr/td[text()='"+exd+"']/following-sibling::td//a[@tooltip='Remove']")).click();
//	    	  }
//	      }
	      
		
	}

}
