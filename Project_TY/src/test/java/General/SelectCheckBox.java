package General;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectCheckBox 
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in");
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("phones");
		search.submit();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='p_89-title']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='brandsRefinements']//input[@type='checkbox']")).click();
	}

}
