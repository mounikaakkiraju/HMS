package General;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccCheckTheCountryIsFound
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='onetrust-reject-all-handler']")).click();
		
		WebElement SL = driver.findElement(By.xpath("//span[text()='Sri Lanka']"));
		List<WebElement> AllCon = driver.findElements(By.xpath("//span[@class='si-fname si-text']"));
	
		
		boolean b=true;
		
		for(WebElement con:AllCon)
		{
			if(con.equals(SL))
			{
				b=true;
				break;
			}	
		}
		if(b==true)
		{
			System.out.println("Sri Lanka is found");
		}
		else
		{
			System.out.println("Sri Lanka is not found");
		}
		
	}

}
