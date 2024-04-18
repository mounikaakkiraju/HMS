package Project_Object_repository_AddDoctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class Admin_loginPage
{
	public  Admin_loginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="username")private WebElement UserName;
	
	@FindBy(name="password")private WebElement Password;
	
	@FindBy(name="submit") private WebElement submit;
	
	
	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassWord() {
		return Password;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	public void LogInAsAdmin(String name,String pass)
	{
		UserName.sendKeys(name);
		Password.sendKeys(pass);
		submit.click();
	}



}