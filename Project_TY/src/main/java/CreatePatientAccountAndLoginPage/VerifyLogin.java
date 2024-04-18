package CreatePatientAccountAndLoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyLogin 
{
	public VerifyLogin(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "username")private WebElement name;
	
	@FindBy(name = "password")private WebElement pass;
	
	@FindBy(name = "submit")private WebElement submit;
	
	public void login(String UserName,String Pass)
	{
		name.sendKeys(UserName);
		pass.sendKeys(Pass);
		
		submit.click();
	}

}
