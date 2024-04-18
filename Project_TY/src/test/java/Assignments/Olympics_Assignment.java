package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Olympics_Assignment
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='No, manage settings']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='ot-pc-refuse-all-handler']")).click();
		
	}

}
