package Project_Object_repository_AddDoctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class App_Homepage 
{
	public App_Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = ("(//a[text()='Click Here'])[2]")) private WebElement appHomePage;

	public WebElement getAppHomePage() {
		return appHomePage;
	}

	public void HomePage()
	{
		appHomePage.click();
	}
}
