package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility 
{

	/**
	 * wait for page to load before elements has to be found in GUI
	 * @param driver
	 * @author mouni
	 */
		public void waitForPageToLoad(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		/**
		 * After every action it will wait for next action to perform
		 * @author mouni
		 * @param driver
		 */
		public WebDriverWait webDriverWaitObj(WebDriver driver,int sec)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			return wait;
		}
		public void waitUntilEleToBeVisible(WebDriver driver,int  sec,WebElement element)
		{
			webDriverWaitObj(driver, sec).until(ExpectedConditions.visibilityOf(element));
		}
		public void waitUntilEleToBeClickable(WebDriver driver,int sec,WebElement element)
		{
			webDriverWaitObj(driver, sec).until(ExpectedConditions.elementToBeClickable(element));
		}
		public void waitUntilToGetTitle(WebDriver driver,int sec, String title)
		
		{
			webDriverWaitObj(driver, sec).until(ExpectedConditions.titleIs(title));
		}
		
		
		public void scriptTimeOut(WebDriver driver)
		{
			driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
			
		}
		/**
		 * used to wait for element to be clickable in GUI and check for specific element for every 500 milliseconds
		 * @param driver
		 * @param element
		 * @param pollingTime
		 */
		public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement element,int pollingTime)
		{
			FluentWait wait = new FluentWait(driver);
			wait.pollingEvery(Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		/**
		 * used to switch to any window based on window title
		 * @param driver
		 * @param partialWindowTitle
		 */
		public void switchToWindow(WebDriver driver,String partialWindowTitle)
		{
			Set<String> allId = driver.getWindowHandles();
			Iterator<String> it = allId.iterator();
			while(it.hasNext())
			{
				String wid = it.next();
				driver.switchTo().window(wid);
				if(driver.getTitle().contains(partialWindowTitle))
				{
					break;
				}
			}
		}
		/**
		 * used to switch to alert window and accept
		 * @param driver
		 */
		public void switchToAlertAndAccept(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		
		 /**
		  * used to switch to alert window and dismiss
		  * @param driver
		  */
		public void switchToAlertAndDismiss(WebDriver driver)
		{
    		driver.switchTo().alert().dismiss();
		}
		/**
		 * used to switch to frame window based on index
		 * @param driver
		 */
		public void switchtoFrame(WebDriver driver)
		{
			driver.switchTo().frame(0);
		}
		/**
		 * used to switch to frame window based on id or name attribute
		 * @param driver
		 * @param ID_name_Attr
		 */
		public void switchToFrame(WebDriver driver,String ID_name_Attr)
		{
			driver.switchTo().frame(ID_name_Attr);
		}
		/**
		 * used to select the value from the dropdown on index
		 * @param element
		 * @param index
		 */
		public void selectIndex(WebElement element,int index)
		{
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}
		/**
		 * used to select the value from the dropdown on visibleText
		 * @param element
		 * @param visibleText
		 */
		public void selectVtext(WebElement element,String visibleText)
		{
			Select sel = new Select(element);
			sel.selectByVisibleText(visibleText);
		}
		/**
		 *  used to select the value from drop down based on value
		 * @param element
		 * @param value
		 */
		public void selectValue(WebElement element,int value)
		{
			Select sel = new Select(element);
			sel.selectByIndex(value);
		}
		/**
		 * used to place the mouse cursoe on specified element
		 * @param driver
		 * @param element
		 */
		public void ActionClass(WebDriver driver,WebElement element)
		{
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}
		public void ActionDoubleClick(WebDriver driver,WebElement element)
		{
			Actions act = new Actions(driver);
			act.doubleClick(element).perform();
		}
		public void ActionSendKeys(WebDriver driver,WebElement element)
		{
			Actions act = new Actions(driver);
			act.sendKeys(null).perform();
		}
		public void DragAndDrop(WebDriver driver,WebElement element)
		{
			Actions act = new Actions(driver);
			act.dragAndDrop(element, element);
		}
		public void ClickAndHold(WebDriver driver,WebElement element)
		{
			Actions act = new Actions(driver);
			act.clickAndHold(null);
		}
		/**
		 * used to handle the unwanted popups
		 * @param driver
		 * @param element
		 */
		
		public void moveByOffset(WebDriver driver,int x,int y)
		{
			Actions act = new Actions(driver);
			act.moveByOffset(x, y).click().perform();
		}
		
		
		public void acceptAlert(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		
		public void dismissAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
		public void switchToFrameByIndex(WebDriver driver,int index)
		{
			driver.switchTo().frame(index);
		}
		
		public void switchToFrameByUsingNameOrID(WebDriver driver,String nameOrID)
		{
			driver.switchTo().frame(nameOrID);
		}
		
		public static String getScreenshot(WebDriver driver,String screnShotName) throws IOException
		{
			JavaUtility jLIb = new JavaUtility();
			TakesScreenshot event = (TakesScreenshot)driver;
			File src = event.getScreenshotAs(OutputType.FILE);
			String path=".\\screenshot\\"+screnShotName+" "+jLIb.getSystemDateFormat()+".png";
			File dst= new File(path);
			String scrpath=dst.getAbsolutePath();
		    FileUtils.copyFile(src, dst);
		    return scrpath;
			
		}
		
		public void scrollBarAction(WebDriver driver)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,800)");
		}
		
		
		/**
		 * This method will scroll until specified element is found
		 * @param driver
		 * @param element
		 */
		public void scrollAction(WebDriver driver, WebElement element)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			int y = element.getLocation().getY();
			jse.executeScript("window.scrollBy(0,"+y+")", element);
		}
		
		/**
		 * scrollDown till the bottom of the page
		 * @param driver
		 */
		public void scrollDownTillBottomOfThePage(WebDriver driver)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		}
	
		/**
		 *scroll Till Element To Be Visisble
		 * @param driver
		 * @param element
		 */
		
		public void scrollTillEleToBeVisisble(WebDriver driver, WebElement element)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView()",element);
		}
		
		public void clickOnElement(WebDriver driver, WebElement element)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", element);
		}
		
		public void jseUsingSendKeys(WebDriver driver, WebElement element, String expData)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].value=arguments[1]", element, expData);
		}
		
		public void scrollUpTillElementToBeVisisble(WebDriver driver, WebElement element)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			 Point loc = element.getLocation();
			int x = loc.getX();
			int y = loc.getY();
			jse.executeScript("window.scrollBy("+x+","+y+")");
		}
		
		
		
		
		
		
}
