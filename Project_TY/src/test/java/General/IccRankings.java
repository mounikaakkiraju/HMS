package General;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccRankings
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='onetrust-reject-all-handler']")).click();
		
		WebElement rank = driver.findElement(By.xpath("//span[text()='IND']/ancestor::div[@class='si-table-row']/descendant::div[@class='si-table-data si-rating']"));
		System.out.println(rank.getText());
		
	}

}
