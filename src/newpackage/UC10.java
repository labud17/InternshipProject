package newpackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.Keys;
public class UC10 {

	//Managing favorite items allow users to remove some products from “Favorites”.
	
	public static void main(String[] args) {
		
		WebDriver firefoxDriver = new FirefoxDriver();
		
		firefoxDriver.get(" https://www.etsy.com/listing/237843790/origami-turtle-earrings-in-sterling?ga_order=most_relevant&ga_search_type=all&ga_view_type=gallery&ga_search_query=&ref=sc_gallery-1-4&plkey=e48170509918641348c24750d9ea81a97fe0332f%3A237843790&bes=1");

		firefoxDriver.manage().window().maximize();
		firefoxDriver.findElement(By.xpath("/html/body/div[4]/header/div[4]/nav/ul/li[1]/button")).click();
		firefoxDriver.findElement(By.id("join_neu_email_field")).sendKeys("rakadam607@emailhost99.com");
		firefoxDriver.findElement(By.id("join_neu_password_field")).sendKeys("123456789");
		firefoxDriver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div/div/div/div/div/div[2]/form/div[1]/div/div[5]/div/button")).click();
		fluentWait(firefoxDriver,By.xpath("//*[@id=\"gnav-header-inner\"]/div[4]/ul/li[2]/a"));
		firefoxDriver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/div/div/div[1]/div[1]/div/div/div/button")).click();
		firefoxDriver.findElement(By.xpath("//*[@id=\"gnav-header-inner\"]/div[4]/ul/li[2]/a")).click();
		fluentWait(firefoxDriver,By.xpath("/html/body/div[5]/div/div[3]/div/div[1]/div[2]/div[2]/div/div[1]/ul/li[1]/div/button"));
		firefoxDriver.findElement(By.xpath("/html/body/div[5]/div/div[3]/div/div[1]/div[2]/div[2]/div/div[1]/ul/li[1]/div/button")).click();
		firefoxDriver.navigate().refresh();
		fluentWait(firefoxDriver,By.xpath("/html/body/div[5]/div/div[3]/div/div[1]/div/div[2]"));
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
