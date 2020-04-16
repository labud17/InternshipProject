package newpackage;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
public class UC05 {

	//Searching products should support filtering by country.

	public static void main(String[] args) {
		
		WebDriver firefoxDriver = new FirefoxDriver();
	
		firefoxDriver.get("https://www.etsy.com");

		firefoxDriver.manage().window().maximize();
		
		firefoxDriver.findElement(By.id("global-enhancements-search-query")).click();
		firefoxDriver.findElement(By.id("global-enhancements-search-query")).sendKeys("wedding diamond ring");
		firefoxDriver.findElement(By.xpath("/html/body/div[4]/header/div[2]/div/form/div/div[1]/button")).click();
		fluentWait(firefoxDriver,By.partialLinkText("Serbia"));
		firefoxDriver.findElement(By.partialLinkText("Serbia")).click();
		fluentWait(firefoxDriver,By.xpath("/html/body/div[6]/div/div[1]/div/div/div[2]/div[2]/ul/li/div/div[1]"));
		String bodyText = firefoxDriver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/div/div[2]/div[2]/div[1]/div[1]")).getText();
		Assert.assertTrue("Text not found!", bodyText.contains("(4 Results)"));
		firefoxDriver.quit();
	}

	public static WebElement fluentWait(final WebDriver driver, final By locator) {
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(30))
	            .pollingEvery(Duration.ofSeconds(5))
	            .ignoring(NoSuchElementException.class);

	    WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver driver) {
	            return driver.findElement(locator);
	        }
	    });

	    return  foo;
	};
}