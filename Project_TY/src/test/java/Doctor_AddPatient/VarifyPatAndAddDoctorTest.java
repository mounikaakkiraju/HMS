package Doctor_AddPatient;

import java.io.FileInputStream;
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

public class VarifyPatAndAddDoctorTest {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = null;
		 FileInputStream file=new FileInputStream(".\\src\\test\\resources\\Admin_PropertyFile.properties");
		 
		Properties pro= new Properties();
	       pro.load(file);
	       String Browser=pro.getProperty("browser");
	      String  URL=pro.getProperty("url2");
	      String USERNAME= pro.getProperty("UserName2");
	      String Pass=  pro.getProperty("Password2");
	      
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
	      
	      Random ran=new Random();
	     int random = ran.nextInt(500);
	      FileInputStream file1=new FileInputStream("C:\\Users\\mouni\\Downloads\\ProjectTY.xlsx");
	      
	      Workbook book = WorkbookFactory.create(file1);
	      String name = book.getSheet("AddPatient").getRow(0).getCell(1).getStringCellValue()+random;
	      String contact=book.getSheet("AddPatient").getRow(1).getCell(1).getStringCellValue();
	      String email= book.getSheet("AddPatient").getRow(2).getCell(1).getStringCellValue();
	      String addr=book.getSheet("AddPatient").getRow(3).getCell(1).getStringCellValue();
	      String age=book.getSheet("AddPatient").getRow(4).getCell(1).getStringCellValue();
	      String history=book.getSheet("AddPatient").getRow(5).getCell(1).getStringCellValue();
	      
	   
	      
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
	        	js.executeScript("window.scrollBy(100,400)");
	        	Thread.sleep(2000);
	        }
	        
	      WebElement ele = driver.findElement(By.xpath("//table/tbody/tr[last()]/td[contains(text(),'"+name+"')]"));
	        
	      if(ele.equals(name))
	      {
	    	  System.out.println("-- patient verified --");
	      }
	      else {
			System.out.println("patient not created");
		}
	        
	         
	}
}
