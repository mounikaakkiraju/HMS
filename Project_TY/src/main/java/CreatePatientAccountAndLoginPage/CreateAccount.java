package CreatePatientAccountAndLoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount 
{
	public CreateAccount(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Create an account")private WebElement create;
	
	public void Create()
	{
		create.click();
	}

}
