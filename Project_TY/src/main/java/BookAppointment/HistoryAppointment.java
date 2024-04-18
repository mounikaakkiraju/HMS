package BookAppointment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HistoryAppointment
{
	public HistoryAppointment(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[text()=' Appointment History ']")private WebElement history;
	
	public void History()
	{
		history.click();
	}

}
