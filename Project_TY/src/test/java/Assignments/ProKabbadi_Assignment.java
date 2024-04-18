package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabbadi_Assignment 
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.prokabaddi.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='onetrust-reject-all-handler']")).click();
		
		//fetching all the data
		
		WebElement data = driver.findElement(By.xpath("//p[text()='Telugu Titans']/ancestor::div[@class='row-head']"));
		
		System.out.print(data.getText()+" ");
		
		
		System.out.println("-------------------------------");
		
		//fetching the only points
		
		List<WebElement> Data = driver.findElements(By.xpath("(//p[text()='Telugu Titans']/ancestor::div[@class='row-head']/div)[position()>=2 and position()<=7]"));

		for(WebElement dat:Data)
		{
			System.out.print(dat.getText()+" ");
		}

	}

}
