package newpackage;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class UC06 {

	public static void main(String[] args) {
		//Searching products should allow filtering by size, clothing style and color.
		
		
			WebDriver firefoxDriver = new FirefoxDriver();
		
		firefoxDriver.get("https://www.etsy.com");

		firefoxDriver.manage().window().maximize();
		
		firefoxDriver.findElement(By.id("global-enhancements-search-query")).click();
		firefoxDriver.findElement(By.id("global-enhancements-search-query")).sendKeys("swimsuit women");
		firefoxDriver.findElement(By.xpath("/html/body/div[4]/header/div[2]/div/form/div/div[1]/button")).click();
		fluentWait(firefoxDriver,By.partialLinkText("Athletic"));
		firefoxDriver.findElement(By.partialLinkText("Athletic")).click();
		fluentWait(firefoxDriver,By.partialLinkText("Black"));
		firefoxDriver.findElement(By.partialLinkText("Black")).click();
		fluentWait(firefoxDriver,By.partialLinkText("XXS"));
		firefoxDriver.findElement(By.partialLinkText("XXS")).click();
		fluentWait(firefoxDriver,By.partialLinkText("FREE shipping"));
		String bodyText = firefoxDriver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/div/div[2]/div[2]/div[1]/div[1]/div/span[3]")).getText();
		Assert.assertTrue("Text not found!", bodyText.contains("(6 Results)"));
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


