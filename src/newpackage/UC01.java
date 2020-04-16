package newpackage;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import org.junit.Assert;
import org.openqa.selenium.*;	
public class UC01 {
	
	//User is trying to sign in with invalid password.
	public static void main(String[] args) {
		
		
		WebDriver firefoxDriver = new FirefoxDriver();
		
		firefoxDriver.get("https://www.etsy.com");
	
		firefoxDriver.manage().window().maximize();
		firefoxDriver.findElement(By.xpath("/html/body/div[4]/header/div[4]/nav/ul/li[1]/button")).click();
		firefoxDriver.findElement(By.id("join_neu_email_field")).sendKeys("email@email.com");
		firefoxDriver.findElement(By.id("join_neu_password_field")).sendKeys("password");
		firefoxDriver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div/div/div/div/div/div[2]/form/div[1]/div/div[5]/div/button")).click();
		fluentWait(firefoxDriver,By.xpath("//*[@id=\"aria-join_neu_password_field-error\"]"));
		String bodyText = firefoxDriver.findElement(By.xpath("//*[@id=\"aria-join_neu_password_field-error\"]")).getText();
		Assert.assertTrue("Text not found!", bodyText.contains("Email or password are not correct"));
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