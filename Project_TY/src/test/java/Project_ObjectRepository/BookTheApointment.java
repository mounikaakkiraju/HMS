package Project_ObjectRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import BookAppointment.AppointmentPage;
import BookAppointment.HistoryAppointment;
import BookAppointment.PatientLogin;
import BookAppointment.UserDashboardPage;
import GenericUtility.WebDriverUtility;

public class BookTheApointment 
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		WebDriver driver = null;
		
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
		     else if(Browser.equalsIgnoreCase("firefox"))
		     {
		    	 driver=new FirefoxDriver();
		     }
		     else
		     {
		    	 System.out.println("invalid browsers");
		     }
	      
	      driver.get(URL);
	      PatientLogin login = new PatientLogin(driver);
	      login.login(USERNAME, Pass);
//	      driver.findElement(By.name("username")).sendKeys(USERNAME);
//	      driver.findElement(By.name("password")).sendKeys(Pass);
//	      driver.findElement(By.name("submit")).click();
	  	     
	      Thread.sleep(2000);
	      UserDashboardPage dash = new UserDashboardPage(driver);
	      dash.Dashboard();
	      
	      Thread.sleep(2000);
	      AppointmentPage appoint = new AppointmentPage(driver);
	      appoint.book();
	     
//	      driver.findElement(By.xpath("(//p[@class='links cl-effect-1'])[2]")).click();
//	      
//	      WebElement sp = driver.findElement(By.name("Doctorspecialization"));
//	      
//	      Select slc=new Select(sp);
//	      slc.selectByValue("General Doctor");
//	      
//	     WebElement doc = driver.findElement(By.name("doctor"));
//	     doc.click();
//	     Select sl=new Select(doc);
//	     sl.selectByVisibleText("BUNNY_M2");
//	     
//	     driver.findElement(By.name("appdate")).click();
//	     Thread.sleep(1000);
//	     driver.findElement(By.xpath("//div[@class='datepicker-days']//tr[5]//td[6]")).click();
//	     
//	     driver.findElement(By.name("submit")).click();
//	     
	     
	      WebDriverUtility wUtil= new WebDriverUtility();
	      wUtil.acceptAlert(driver);
	     
//	     driver.switchTo().alert().accept();
	     
	     HistoryAppointment his = new HistoryAppointment(driver);
	     his.History();
//	     driver.findElement(By.xpath("//span[text()=' Appointment History ']")).click();
	     
	     System.out.println("--Appoitment was booked successfully--");
	     
	     
	     
		
		
	}

}
