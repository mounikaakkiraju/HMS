package BookAppointment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDashboardPage 
{
	public UserDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "(//p[@class='links cl-effect-1'])[2]")private WebElement sepDD;
	
	public void Dashboard()
	{
		sepDD.click();
		
	}

}
