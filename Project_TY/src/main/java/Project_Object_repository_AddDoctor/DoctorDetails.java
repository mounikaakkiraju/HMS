package Project_Object_repository_AddDoctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorDetails
{
	public DoctorDetails(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='docname']")private WebElement name;
	
	@FindBy(name = "clinicaddress")private WebElement clinic;
	
	@FindBy(name = "docfees")private WebElement fee;
	
	@FindBy(name = "doccontact")private WebElement contact;
	
    @FindBy(name = "docemail")private WebElement email;
    
    @FindBy(name = "npass")private WebElement pass;
    
    @FindBy(name = "cfpass")private WebElement cpass;
    
    @FindBy(id = "submit")private WebElement submit;
    
    
    
    
    
    
    public WebElement getEmail() {
		return email;
	}






	public void Doctordetails(String Name,String Clinic,String Fee,String Contact,String Email,String Pass,String Cpass) throws InterruptedException
    {
    	name.sendKeys(Name);
    	clinic.sendKeys(Clinic);
    	fee.sendKeys(Fee);
    	contact.sendKeys(Contact);
    	email.sendKeys(Email);
    	pass.sendKeys(Pass);
    	cpass.sendKeys(Cpass);
        submit.click();  
        Thread.sleep(3000);
    	
    }
   
}
