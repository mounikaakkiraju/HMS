package CreatePatientAccountAndLoginPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsOfPatientPage
{
	public DetailsOfPatientPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "full_name")private WebElement name;
	
	@FindBy(name = "address")private WebElement add;
	
	@FindBy(name = "city" )private WebElement city;
	
	@FindBy(name = "email")private WebElement email;
	
	@FindBy(name = "password")private WebElement pass;
	
	@FindBy(name = "password_again")private WebElement passAgain;
	
	@FindBy(xpath = "//button[@type='submit']")private WebElement submit;
	
	
	public void Details(String FullName,String Add,String City,String Email,String Pass,String PassAgain) throws InterruptedException
	{
		name.sendKeys(FullName);
		add.sendKeys(Add);
		city.sendKeys(City);
		email.sendKeys(Email);
		pass.sendKeys(Pass);
		passAgain.sendKeys(Pass);

	}
	
	public void submit()
	{
		submit.click();
	}
	

	

	
}
