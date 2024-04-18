package Project_Object_repository_AddDoctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Verify_DocLogin 
{
	public Verify_DocLogin(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "username")private WebElement user;
	@FindBy(name = "password")private WebElement pass;
	@FindBy(name = "submit")private WebElement submit;
	
	public void DocLogin(String username,String password)
	{
		user.sendKeys(username);
		pass.sendKeys(password);
		submit.click();
		
	}

}
