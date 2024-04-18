package BookAppointment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage
{
	public AppointmentPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(name = "Doctorspecialization")private WebElement special;
	 
	@FindBy(name = "doctor")private WebElement doc;
	
	@FindBy(name="appdate")private WebElement date;
	
	@FindBy(xpath = "//div[@class='datepicker-days']//tr[5]//td[6]")private WebElement chooseDate;
	
	@FindBy(name = "submit")private WebElement submit;
	
	public void book() throws InterruptedException
	{
		special.click();
		Select slc=new Select(special);
	    slc.selectByValue("General Doctor");
	    
	    doc.click();
	    
	    Select sl=new Select(doc);
	    sl.selectByVisibleText("Samrudh");
	     
	    date.click();
	    
	    Thread.sleep(1000);
	    
	    chooseDate.click();
	    
	    submit.click();
	    
	    
	      
	}

}
