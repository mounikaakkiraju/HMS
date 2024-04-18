package Project_ObjectRepository;

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

import CreatePatientAccountAndLoginPage.CreateAccount;
import CreatePatientAccountAndLoginPage.DetailsOfPatientPage;
import CreatePatientAccountAndLoginPage.RegistrationPage;
import CreatePatientAccountAndLoginPage.VerifyLogin;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;

public class CreatePatientAccountAndLogin
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		WebDriver driver=null;
		
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
	      CreateAccount create = new CreateAccount(driver);
	      create.Create();
//	      driver.findElement(By.linkText("Create an account")).click();
	      
	      FileInputStream file1= new FileInputStream("C:\\Users\\mouni\\Downloads\\ProjectTY.xlsx");
	       Workbook book = WorkbookFactory.create(file1);
	       String FullName = book.getSheet("CreateAccount").getRow(0).getCell(1).getStringCellValue();
	        String Add= book.getSheet("CreateAccount").getRow(1).getCell(1).getStringCellValue();
	        String city= book.getSheet("CreateAccount").getRow(2).getCell(1).getStringCellValue();
	        String email=book.getSheet("CreateAccount").getRow(3).getCell(1).getStringCellValue();
	        String pass=  book.getSheet("CreateAccount").getRow(4).getCell(1).getStringCellValue();
	        
	        JavaUtility ja = new JavaUtility();
	        //ja.getRandomNo();
	        DetailsOfPatientPage det = new DetailsOfPatientPage(driver);
	        det.Details(FullName, Add, city, email+ja.getRandomNo(), Pass, Pass);
//	        driver.findElement(By.name("full_name")).sendKeys(FullName);
//	        driver.findElement(By.name("address")).sendKeys(Add);
//	        driver.findElement(By.name("city")).sendKeys(city);
//	        driver.findElement(By.name("email")).sendKeys(email);
//	        driver.findElement(By.name("password")).sendKeys(pass);
//	        driver.findElement(By.name("password_again")).sendKeys(pass);
//	        //driver.findElement(By.id("agree")).click();
	        
	        
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	        
	        for(int i=0;i<=3;i++)
	        {
	        	js.executeScript("window.scrollBy(100,400)");
	        	Thread.sleep(2000);
	        }
	        
	        Thread.sleep(1000);
	        det.submit();
//	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	        
	        Thread.sleep(1000);
	        
	        WebDriverUtility wb = new WebDriverUtility();
	        wb.acceptAlert(driver);
//	        Alert alt = driver.switchTo().alert();
//	        alt.accept();
	        
	       
	        
	       RegistrationPage reg = new RegistrationPage(driver);
	        reg.Login();
//	        driver.findElement(By.xpath("(//a)[2]")).click();
	        
	        Thread.sleep(2000);
	        VerifyLogin log = new VerifyLogin(driver);
	        log.login(USERNAME, pass);
//	      driver.findElement(By.name("username")).sendKeys(email);
//	      driver.findElement(By.name("password")).sendKeys(pass);
//	      driver.findElement(By.name("submit")).click();
			
			
		
	}

}
