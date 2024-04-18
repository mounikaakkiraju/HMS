package General;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MobilePrize 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in");
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("vivomobile");
		search.submit();
		
		//WebElement prize = driver.findElement(By.xpath("//span[text()='Vivo Y16 (Stellar Black, 4GB RAM, 64GB Storage) with No Cost EMI/Additional Exchange Offers']/ancestor::div[@class='puisg-col-inner']/descendant::span[@class='a-price-whole']"));
		
		//or
		
		WebElement prize2 = driver.findElement(By.xpath("//span[contains(text(),'Vivo Y16 (S')]/ancestor::div[@class='puisg-col-inner']/descendant::span[@class='a-price-whole']"));
		
		//WebElement MobileName = driver.findElement(By.xpath("//span[@class='a-price-whole']/ancestor::div[@class='puisg-col-inner']/descendant::span[text()='Vivo Y16 (Stellar Black, 4GB RAM, 64GB Storage) with No Cost EMI/Additional Exchange Offers']"));
		//or
		WebElement MobileName=driver.findElement(By.xpath("//span[@class='a-price-whole']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[contains(text(),'Vivo Y16 (S')]"));
		
		System.out.println(MobileName.getText()+"--->"+prize2.getText());
		
		System.out.println(MobileName.getText().substring(0, 8)+"---->"+prize2.getText());
	}

}
