package Project_ObjectRepository;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import Project_Object_repository_AddDoctor.Admin_HomePage;
import Project_Object_repository_AddDoctor.Admin_loginPage;
import Project_Object_repository_AddDoctor.App_Homepage;
import Project_Object_repository_AddDoctor.DoctorDetails;
import Project_Object_repository_AddDoctor.Logout;
import Project_Object_repository_AddDoctor.Verify_DocLogin;

@Listeners(GenericUtility.ListenersImplimentationClass.class)
public class Add_DoctorTest extends BaseClass
{
	
	//	public static WebDriver driver;
		

	@Test
//	@Test(groups = {"smoke","functional"})//it is for group exe
		public  void add_Doctor() throws IOException, InterruptedException
		{
			
//			FileUtility fUtil= new FileUtility();
//			ExcelUtility eUtil= new ExcelUtility();
//			JavaUtility jUtil= new JavaUtility();
//			WebDriverUtility wUtil=new WebDriverUtility();
			
			
//		 FileInputStream file=new FileInputStream("./src\\test\\resources\\Admin_PropertyFile.properties");
//				
//		 
//		    String Browser = fUtils.readDatafromProperty("browser");
//			String URL = fUtils.readDatafromProperty("url3");
//			String USERNAME=fUtils.readDatafromProperty("UserName3");
//			String Pass=fUtils.readDatafromProperty("Password3");
//
//	     
//		      if(Browser.equalsIgnoreCase("chrome"))
//			     {
//			    	driver= new ChromeDriver();
//			     }
//			     else if(Browser.equalsIgnoreCase("firefox"))
//			     {
//			    	 driver=new FirefoxDriver();
//			     }
//			     else
//			     {
//			    	 System.out.println("invalid browsers");
//			     }
//		      
//		      
//		      
//		      driver.get(URL);
//		      
//		      Admin_loginPage Admin = new Admin_loginPage(driver);
//		      Admin.LogInAsAdmin(USERNAME, Pass);
		      
//		      driver.findElement(By.name("username")).sendKeys(USERNAME);
//		      driver.findElement(By.name("password")).sendKeys(Pass);
//		      driver.findElement(By.name("submit")).click();
		      
		      Admin_HomePage home = new Admin_HomePage(driver);
		      home.AdminHomePage();
		      
		      Thread.sleep(2000);
		      
		      Admin_HomePage home1= new Admin_HomePage(driver);
		      home1.addDoc();
		      
//		      driver.findElement(By.xpath("//span[text()=' Doctors ']")).click();
//		      Thread.sleep(1000);
//		      driver.findElement(By.xpath("//span[text()=' Add Doctor']")).click();
		    
		     String name= eUtils.readDataFromExcel("AddDoctor", 1, 1);
		     String Address= eUtils.readDataFromExcel("AddDoctor", 2, 1);
		     String fee= eUtils.readDataFromExcel("AddDoctor", 3, 1);
		     String con= eUtils.readDataFromExcel("AddDoctor", 4, 1);
		      
		     FileInputStream file1=new FileInputStream("C:\\Users\\mouni\\Downloads\\ProjectTY.xlsx");
		     Workbook book = WorkbookFactory.create(file1);
		     //String special = book.getSheet("AddDoctor").getRow(0).getCell(1).getStringCellValue();


	         int random = jUtils.getRandomNo();	     

		     
	         String email= eUtils.readDataFromExcel("AddDoctor", 5, 1);
		     String pass= eUtils.readDataFromExcel("AddDoctor", 6, 1);
		      

		     WebElement sp = driver.findElement(By.className("form-control"));
		     sp.click();
		     
		     wUtils.selectVtext(sp, "neurologist");
		     

		      Thread.sleep(1000);
		      String unique = jUtils.uniqueMail(email);
		      DoctorDetails DD = new DoctorDetails(driver);
		      DD.Doctordetails(name, Address, fee, con, unique, pass, pass);
		      wUtils.acceptAlert(driver);
		      
//		     driver.findElement(By.xpath("//input[@name='docname']")).sendKeys(name);
//		     driver.findElement(By.name("clinicaddress")).sendKeys(Address);
//		     driver.findElement(By.name("docfees")).sendKeys(fee);
//		     driver.findElement(By.name("doccontact")).sendKeys(con);
		     
		     //String unique = jUtil.uniqueMail(email);
		  //   DD.getEmail().sendKeys(unique);
		  //   driver.findElement(By.name("docemail")).sendKeys(unique);
		  //   System.out.println(unique);
		  //   Thread.sleep(4000);
//		     driver.findElement(By.name("npass")).sendKeys(pass);
//		     driver.findElement(By.name("cfpass")).sendKeys(pass);
		      
		      
//		     driver.findElement(By.id("submit")).click();
		     
		 //    Thread.sleep(2000);
		     
		  //   wUtil.acceptAlert(driver);

		     Logout log = new Logout(driver);
		     log.LogOut();
		    
//		     driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
//		     Thread.sleep(1000);
//		     driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
		     
		     App_Homepage appHomePage = new App_Homepage(driver);
		     appHomePage.HomePage();
//		     driver.findElement(By.xpath("(//a[text()='Click Here'])[2]")).click();
//		     
//
		     Thread.sleep(2000);
		     Verify_DocLogin DocLogin = new Verify_DocLogin(driver);
		     DocLogin.DocLogin(email, pass);
//		     driver.findElement(By.name("username")).sendKeys(email);
//		     driver.findElement(By.name("password")).sendKeys(pass);
//		     driver.findElement(By.name("submit")).click();
		      
		      
		
	}

}
