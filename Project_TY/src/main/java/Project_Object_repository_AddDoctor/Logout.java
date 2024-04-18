package Project_Object_repository_AddDoctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout
{
	public Logout(WebDriver driver)
	{
		PageFactory.initElements(driver , this);
	}
	
	@FindBy(xpath ="//i[@class='ti-angle-down']" )private WebElement dropDown;
	
	@FindBy(xpath = "//a[contains(text(),'Log Out')]" )private WebElement logout;
	
	@FindBy(xpath = "(//a[text()='Click Here'])[2]")private WebElement ClickLogout;
	
	public void LogOut()
	{
		dropDown.click();
		logout.click();
	}
	

}
