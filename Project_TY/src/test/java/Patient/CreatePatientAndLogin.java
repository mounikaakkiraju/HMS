package Patient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreatePatientAndLogin 
{
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException
	{
		
		

       FileInputStream file=new FileInputStream("./src\\test\\resources\\Admin_PropertyFile.properties");
		
       Properties pro= new Properties();
       pro.load(file);
       String Browser=pro.getProperty("browser");
      String  URL=pro.getProperty("url");
      String USERNAME= pro.getProperty("UserName");
      String Pass=  pro.getProperty("Password");
      
      if(Browser.equalsIgnoreCase("chrome"))
	     {
	    	driver= new ChromeDriver();
	     }
	     else if(Browser.equalsIgnoreCase("firefowx"))
	     {
	    	 driver=new FirefoxDriver();
	     }
	     else
	     {
	    	 System.out.println("invalid browsers");
	     }
      
      driver.get(URL);
      Thread.sleep(3000);
      driver.findElement(By.linkText("Create an account")).click();
      
      FileInputStream file1= new FileInputStream("C:\\Users\\mouni\\Downloads\\ProjectTY.xlsx");
       Workbook book = WorkbookFactory.create(file1);
       String FullName = book.getSheet("CreateAccount").getRow(0).getCell(1).getStringCellValue();
        String Add= book.getSheet("CreateAccount").getRow(1).getCell(1).getStringCellValue();
        String city= book.getSheet("CreateAccount").getRow(2).getCell(1).getStringCellValue();
        String email=book.getSheet("CreateAccount").getRow(3).getCell(1).getStringCellValue();
        String pass=  book.getSheet("CreateAccount").getRow(4).getCell(1).getStringCellValue();
        
        
        driver.findElement(By.name("full_name")).sendKeys(FullName);
        driver.findElement(By.name("address")).sendKeys(Add);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.name("password_again")).sendKeys(pass);
        //driver.findElement(By.id("agree")).click();
        
        
        JavascriptExecutor js = (JavascriptExecutor)driver;
        
        for(int i=0;i<=3;i++)
        {
        	js.executeScript("window.scrollBy(100,400)");
        	Thread.sleep(2000);
        }
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        Thread.sleep(1000);
        Alert alt = driver.switchTo().alert();
        alt.accept();
        
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("(//a)[2]")).click();
        
      driver.findElement(By.name("username")).sendKeys(email);
      driver.findElement(By.name("password")).sendKeys(pass);
      driver.findElement(By.name("submit")).click();
		
		
	}

}
