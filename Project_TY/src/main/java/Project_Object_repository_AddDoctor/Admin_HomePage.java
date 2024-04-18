package Project_Object_repository_AddDoctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_HomePage
{
	public Admin_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//span[text()=' Doctors ']" )private WebElement doctor;
	
	@FindBy(xpath = "//span[text()=' Add Doctor']")private WebElement addDoctor;
	
	
	public void AdminHomePage() 
	{
		doctor.click();
		
		
	}
	
	public void addDoc()
	{
		addDoctor.click();
	}

}
