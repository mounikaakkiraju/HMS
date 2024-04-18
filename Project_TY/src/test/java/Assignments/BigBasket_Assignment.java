package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasket_Assignment
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.bigbasket.com");
		
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for Products...']"));
		Thread.sleep(2000);
		search.sendKeys("apple"+Keys.ENTER);
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(int i=0;i<=5;i++)
		{
			js.executeScript("window.scrollBy(100,400)");
		}

		WebElement add = driver.findElement(By.xpath("//h3[text()='Apple - Royal Gala Economy']/ancestor::li[@class='PaginateItems___StyledLi-sc-1yrbjdr-0 dDBqny']/descendant::button[@pattern='outline']"));
	   
		Actions act= new Actions(driver);
		act.moveToElement(add).perform();
		Thread.sleep(2000);
		
		int quan=3;
		
		
		for(int i=0;i<=quan;i++)
		{
			act.click().perform();
		}
		
	
		
		
	}

}
