package Project_Object_repository_RemoveDoctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Manage_Doctors
{
	public Manage_Doctors(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()=' Doctors ']")private WebElement doc;
	
	@FindBy(xpath = "//span[text()=' Manage Doctors ']")private WebElement manage;
	

	public void ManageDoc() throws InterruptedException
	{
		doc.click();
		Thread.sleep(2000);
		manage.click();
		
	}

}
