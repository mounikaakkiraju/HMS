package Doctor_AddPatient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;

public class AddPatient
{
	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		FileUtility fUtil= new FileUtility();
		ExcelUtility eUtil= new ExcelUtility();
		JavaUtility jUtil= new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		
		 FileInputStream file=new FileInputStream(".\\src\\test\\resources\\Admin_PropertyFile.properties");

		 
		 String Browser = fUtil.readDatafromProperty("browser");
			String URL = fUtil.readDatafromProperty("url2");
			String USERNAME=fUtil.readDatafromProperty("UserName2");
			String Pass=fUtil.readDatafromProperty("Password2");
//	       Properties pro= new Properties();
//	       pro.load(file);
//	       String Browser=pro.getProperty("browser");
//	      String  URL=pro.getProperty("url2");
//	      String USERNAME= pro.getProperty("UserName2");
//	      String Pass=  pro.getProperty("Password2");
	      
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
	      
	      driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//span[text()=' Add Patient']")).click();
	      
	      int random = jUtil.getRandomNo();	    
	      
//	      Random ran=new Random();
//	     int random = ran.nextInt(500);
	      FileInputStream file1=new FileInputStream("C:\\Users\\mouni\\Downloads\\ProjectTY.xlsx");
	      
	      String name = eUtil.readDataFromExcel("AddPatient", 0, 1);
	      String contact = eUtil.readDataFromExcel("AddPatient", 1, 1);
	      String email = eUtil.readDataFromExcel("AddPatient", 2, 1);
	      String addr = eUtil.readDataFromExcel("AddPatient", 3, 1);
	      String age=eUtil.readDataFromExcel("AddPatient", 4, 1);
	      String history=eUtil.readDataFromExcel("AddPatient", 5, 1);
	      
//	      Workbook book = WorkbookFactory.create(file1);
//	      String name = book.getSheet("AddPatient").getRow(0).getCell(1).getStringCellValue()+random;
//	      String contact=book.getSheet("AddPatient").getRow(1).getCell(1).getStringCellValue();
//	      String email= book.getSheet("AddPatient").getRow(2).getCell(1).getStringCellValue();
//	      String addr=book.getSheet("AddPatient").getRow(3).getCell(1).getStringCellValue();
//	      String age=book.getSheet("AddPatient").getRow(4).getCell(1).getStringCellValue();
//	      String history=book.getSheet("AddPatient").getRow(5).getCell(1).getStringCellValue();
	      
	   
	      
	      driver.findElement(By.name("patname")).sendKeys(name);
	      
	      driver.findElement(By.name("patcontact")).sendKeys(contact);
	      driver.findElement(By.name("patemail")).sendKeys(email+random);
	      driver.findElement(By.xpath("//label[@for='rg-female']")).click();
	      driver.findElement(By.name("pataddress")).sendKeys(addr);
	      driver.findElement(By.name("patage")).sendKeys(age);
	      driver.findElement(By.name("medhis")).sendKeys(history);
	      Thread.sleep(1000);
	      driver.findElement(By.name("submit")).click();
	      
	      driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//span[text()=' Manage Patient ']")).click();
	      
	      
	      
	      JavascriptExecutor js = (JavascriptExecutor)driver;
	        
	        for(int i=0;i<=3;i++)
	        {
//	        	js.executeScript("window.scrollBy(100,400)");
//	        	Thread.sleep(2000);
	        	
	        	wUtil.scrollBarAction(driver);
	        }
	        
	       // WebElement ele = driver.findElement(By.xpath("//table[@id='sample-table-1']//tr/td[text()='"+name+"']"));
	      
	         List<WebElement> ele = driver.findElements(By.xpath("//tr/td[2]"));
	         
	         for(WebElement EachName:ele)
	         {   
	        	 if(EachName.equals(ele))
	    	   {
	    		 System.out.println("Patient was added successfully");
	    	   }
	    	  
	         }	      
	      //[text()='"+name+"']
	    //tr[text()='"+name+"']/td[2]

		//thank you
	         
	         System.out.println("raji");
	}

}
