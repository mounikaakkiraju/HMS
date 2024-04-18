package Project_ObjectRepository;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import Project_Object_repository_AddDoctor.Admin_HomePage;
import Project_Object_repository_AddDoctor.Admin_loginPage;
import Project_Object_repository_RemoveDoctor.Manage_Doctors;
import Project_Object_repository_RemoveDoctor.RemoveDoc;

public class RemoveDoctor 
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
        WebDriver driver = null;
		
		FileUtility fUtil= new FileUtility();
		ExcelUtility eUtil= new ExcelUtility();
		JavaUtility jUtil= new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		
		   FileInputStream file=new FileInputStream("./src\\test\\resources\\Admin_PropertyFile.properties");
			
		   String Browser = fUtil.readDatafromProperty("browser");
		   String URL = fUtil.readDatafromProperty("url3");
		   String USERNAME=fUtil.readDatafromProperty("UserName3");
		   String Pass=fUtil.readDatafromProperty("Password3");

		   
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
	      
	      Admin_loginPage Admin = new Admin_loginPage(driver);
	      Admin.LogInAsAdmin(USERNAME, Pass);
	      
	      Manage_Doctors man = new Manage_Doctors(driver);
	      man.ManageDoc();
	      Thread.sleep(2000);
	      
	     FileInputStream file1 = new FileInputStream("C:\\Users\\mouni\\Downloads\\ProjectTY.xlsx");
	    
	     eUtil.readDataFromExcel("AddDoctor", 0, 1); 
		 Workbook book = WorkbookFactory.create(file1);
		 String exd=book.getSheet("AddDoctor").getRow(0).getCell(1).getStringCellValue();
	     System.out.println(exd +"--->"+" doctor data was deleted successfully");
	      
	      
//          RemoveDoc rem = new RemoveDoc(driver);
//	      rem.Remove();
	      
	      driver.findElement(By.xpath("//table/tbody/tr/td[text()='"+exd+"']/following-sibling::td//a[@tooltip='Remove']")).click();
	      //driver.switchTo().alert().accept();
	      
	       wUtil.acceptAlert(driver);
	      
	}  
	      
	      
	      

}
