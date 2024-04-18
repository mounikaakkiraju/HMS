package Assignments;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EMI_Calculator 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://emicalculator.net/#google_vignette");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(int i=0;i<=3;i++)
		{
			js.executeScript("window.scrollBy(100,400)");
		}
		
	}

}
