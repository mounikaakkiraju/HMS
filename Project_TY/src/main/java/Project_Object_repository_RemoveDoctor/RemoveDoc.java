package Project_Object_repository_RemoveDoctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveDoc
{
    public RemoveDoc(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }
    
    @FindBy(xpath = "//table/tbody/tr/td[text()='\"+exd+\"']/following-sibling::td//a[@tooltip='Remove']") private WebElement remove;
	public void Remove() 
	{
		
		remove.click();
	}

}
