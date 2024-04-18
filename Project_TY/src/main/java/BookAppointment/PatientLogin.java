package BookAppointment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLogin 
{
	public PatientLogin(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "username")private WebElement name;
	
	@FindBy(name = "password")private WebElement pass;
	
	@FindBy(name = "submit")private WebElement submit;
	
	public void login(String username,String password)
	{
		name.sendKeys(username);
		pass.sendKeys(password);
		submit.click();
	}
	
	

}
