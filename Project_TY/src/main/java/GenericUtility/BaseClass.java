package GenericUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import Project_Object_repository_AddDoctor.Admin_loginPage;
import Project_Object_repository_AddDoctor.Logout;


public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver  sdriver;
	public WebDriverUtility wUtils;
	public DatabaseUtility dUtils = new DatabaseUtility();
	public FileUtility fUtils = new FileUtility();
	public ExcelUtility eUtils = new ExcelUtility();
	public JavaUtility jUtils = new JavaUtility();
	
//	@BeforeSuite(alwaysRun = true)
//	public void connectToDb() throws SQLException {
//		dUtils.connectToDB();
//		Reporter.log("--Db connected--",true);
//	}
	
	@Parameters("Browser") //it is only used for cross browser exe in testNG xml file
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(String Browser) throws Throwable { //used for cross browser exe -->will parametermize (String Browser) 
//		public void launchBrowser() throws Throwable {
		String Browser1 = fUtils.readDatafromProperty("browser"); //we have to comment it while we are parameterize for the cross browser exe
		String URL = fUtils.readDatafromProperty("url3");
//		String Browser = System.getProperty("browser"); //this line used only for Maven exe
//       String URL = System.getProperty("url3"); //this also used only for the Maven Exe
		
		if(Browser1.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			Reporter.log("--CHROME BROWSSER LAUNCHED SUCCESSFULLY--");
		}
		else if (Browser1.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(Browser1.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			Reporter.log("--INVALID BROWSER--", true);
		}
		sdriver = driver;
		wUtils = new WebDriverUtility();
		//wUtils.maximizeWindow();
		//wUtils.waitForEleImplicitly(5);
		wUtils.waitForPageToLoad(driver);
		driver.get(URL);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void login() throws Throwable {
		String USERNAME=fUtils.readDatafromProperty("UserName3");
		String Pass=fUtils.readDatafromProperty("Password3");
	      Admin_loginPage Admin = new Admin_loginPage(driver);
	      Admin.LogInAsAdmin(USERNAME, Pass);
	      

		Reporter.log("--LOGGED IN TO APPLICATION--", true);
	}
	
	@AfterMethod(alwaysRun = true)//it is used to run the group exe
	public void logout() {
		 Logout log = new Logout(driver);
	     log.LogOut();
	    
		Reporter.log("--LOGGED OUT THE APPLICATION--", true);
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		Reporter.log("--BROWSER CLOSED--", true);
	}
	
	@AfterSuite(alwaysRun = true)
	public void closeDb() throws SQLException {
		dUtils.closeDB();
		Reporter.log("--DB CLOSED--", true);
	}
}
 

	


