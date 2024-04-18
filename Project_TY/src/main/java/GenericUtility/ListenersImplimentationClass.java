package GenericUtility;



import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.ReporterConfigurable;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ListenersImplimentationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	
	
	
	public void onTestStart(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log("execution starts from here", true);
	
	}
	
	public void onTestSuccess(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName);
		Reporter.log(MethodName+"----> executed successfully");
	}
	
	public void onTestFailure(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		
	    try 
	    {
			String screenshot=  GenericUtility.WebDriverUtility.getScreenshot(BaseClass.sdriver, MethodName);
			test.log(Status.FAIL, MethodName+"---failed");
			test.log(Status.FAIL, result.getThrowable());
			
			test.addScreenCaptureFromPath(screenshot);
			
			Reporter.log(MethodName+"---->failed");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void onStart(ITestContext context)
	{
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/Report.html");
		htmlreport.config().setDocumentTitle("Vtiger");
		htmlreport.config().setReportName("SDET-55");
		htmlreport.config().setTheme(Theme.DARK);
		
		 report= new ExtentReports();
		 report.attachReporter(htmlreport);
		 report.setSystemInfo("Base-platform", "windows");
		 report.setSystemInfo("Base-Browser", "chrome");
		 report.setSystemInfo("Base-Url", "http://localhost:8888");
		 report.setSystemInfo("ReporterName", "Mounika");
		
		
	}
	
	public void onTestSkipped(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		
		test.log(Status.SKIP, MethodName+"--->skipped");
		test.log(Status.SKIP,result.getThrowable());
		Reporter.log(MethodName+"---> Skipped");
	}
	
	public void onFinish(ITestContext context)
	{
		report.flush();
	}

}
