package General;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintAllTheCountries 
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='onetrust-reject-all-handler']")).click();
		
		
		List<WebElement> AllCon = driver.findElements(By.xpath("//span[@class='si-fname si-text']"));
	
		for(WebElement con:AllCon)
		{
			System.out.println(con.getText());
		}
		
		System.out.println("---if we want to print only first five countries-------");
		
		List<WebElement> FirstFiveCon = driver.findElements(By.xpath("(//span[@class='si-fname si-text'])[position()<=5]"));
		
		for(WebElement FiveCon:FirstFiveCon)
		{
			System.out.println(FiveCon.getText());
		}
		
		System.out.println("---if we want last or last but one will use the last()");
		
		WebElement Last = driver.findElement(By.xpath("(//span[@class='si-fname si-text'])[last()]"));
		System.out.println(Last.getText()+"--->"+"lastOne");
		
		WebElement LastButOne = driver.findElement(By.xpath("(//span[@class='si-fname si-text'])[last()-1]"));
		System.out.println(LastButOne.getText()+"--->"+"Last but one");
	}


}
