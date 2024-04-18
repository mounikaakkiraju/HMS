package Admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;

public class AddDoctor
{
	public static WebDriver driver;
	

	@Test
//	@Test(groups = {"smoke","functional"})
	public static void AddDoctor() throws IOException, InterruptedException
	{
		
		FileUtility fUtil= new FileUtility();
		ExcelUtility eUtil= new ExcelUtility();
		JavaUtility jUtil= new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		
	 FileInputStream file=new FileInputStream("./src\\test\\resources\\Admin_PropertyFile.properties");
//			
	 
	    String Browser = fUtil.readDatafromProperty("browser");
		String URL = fUtil.readDatafromProperty("url3");
		String USERNAME=fUtil.readDatafromProperty("UserName3");
		String Pass=fUtil.readDatafromProperty("Password3");
//	       Properties pro= new Properties();
//	       pro.load(file);
//	      String Browser=pro.getProperty("browser");
//	      String  URL=pro.getProperty("url3");
//	      String USERNAME= pro.getProperty("UserName3");
//	      String Pass=  pro.getProperty("Password3");
     
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
	      driver.findElement(By.xpath("//span[text()=' Add Doctor']")).click();
	    
	     String name= eUtil.readDataFromExcel("AddDoctor", 1, 1);
	     String Address= eUtil.readDataFromExcel("AddDoctor", 2, 1);
	     String fee= eUtil.readDataFromExcel("AddDoctor", 3, 1);
	     String con= eUtil.readDataFromExcel("AddDoctor", 4, 1);
	      
	     FileInputStream file1=new FileInputStream("C:\\Users\\mouni\\Downloads\\ProjectTY.xlsx");
	     Workbook book = WorkbookFactory.create(file1);
	     //String special = book.getSheet("AddDoctor").getRow(0).getCell(1).getStringCellValue();
//	     String name=book.getSheet("AddDoctor").getRow(1).getCell(1).getStringCellValue();
//	     String Address=book.getSheet("AddDoctor").getRow(2).getCell(1).getStringCellValue();
//	     String fee=book.getSheet("AddDoctor").getRow(3).getCell(1).getStringCellValue();
//	     String con=book.getSheet("AddDoctor").getRow(4).getCell(1).getStringCellValue();
	     

         int random = jUtil.getRandomNo();	     
//	     Random ran=new Random();	     
//	     int random = ran.nextInt(500);
	     
         String email= eUtil.readDataFromExcel("AddDoctor", 5, 1);
	     String pass= eUtil.readDataFromExcel("AddDoctor", 6, 1);
	      
//	     String email=book.getSheet("AddDoctor").getRow(5).getCell(1).getStringCellValue()+random;
//	     String pass=book.getSheet("AddDoctor").getRow(6).getCell(1).getStringCellValue();
	     
	     WebElement sp = driver.findElement(By.className("form-control"));
	     sp.click();
	     
	     wUtil.selectVtext(sp, "neurologist");
	     
//	     Select sle=new Select(sp);
//	     sle.selectByVisibleText("neurologist");
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//input[@name='docname']")).sendKeys(name);
	     driver.findElement(By.name("clinicaddress")).sendKeys(Address);
	     driver.findElement(By.name("docfees")).sendKeys(fee);
	     driver.findElement(By.name("doccontact")).sendKeys(con);
	     
	     String unique = jUtil.uniqueMail(email);
	     
	     driver.findElement(By.name("docemail")).sendKeys(unique);
	     System.out.println(unique);
	     Thread.sleep(4000);
	     driver.findElement(By.name("npass")).sendKeys(pass);
	     driver.findElement(By.name("cfpass")).sendKeys(pass);
	      
	      
	     driver.findElement(By.id("submit")).click();
	     
	     wUtil.acceptAlert(driver);
//	     driver.switchTo().alert().accept();
	     //driver.findElement(By.xpath("//span[text()=' Doctors ']")).click();
	      //Thread.sleep(1000);
	     
	     driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
	     driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
	     
	     driver.findElement(By.xpath("(//a[text()='Click Here'])[2]")).click();
	     
	    // System.out.println(email);
	     //System.out.println(pass);
	     
	     driver.findElement(By.name("username")).sendKeys(email);
	     driver.findElement(By.name("password")).sendKeys(pass);
	     driver.findElement(By.name("submit")).click();
	      
	      
	}

}
