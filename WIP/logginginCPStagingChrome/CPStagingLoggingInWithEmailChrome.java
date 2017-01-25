package logginginCPStagingChrome;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.ComparisonFailure.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CPStagingLoggingInWithEmailChrome {

	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/jchubacca/Documents/workspace/Webdriver/chromedriver");
	    
	    ChromeOptions options = new ChromeOptions(); 
	    options.addArguments("user-data-dir=/Users/jchubacca/Library/Application Support/Google/Chrome/SeleniumProfile");
	    driver = new ChromeDriver(options);
	 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		   driver.quit();
		   
	}

	@Test
	public void test() {
		
		    driver.get("http://staging.devpost.com/opensesame/github");
			waitforelements(3000);
			driver.findElement(By.linkText("Log in")).click();
			
	
			waitforelements(2000);
			
			driver.findElement(By.id("user_email")).sendKeys("jonathan.chu.cp@gmail.com");
			driver.findElement(By.id("user_password")).sendKeys("challenge2015");
			driver.findElement(By.id("submit-form")).click();
			System.out.println("Email - Logging In Successfully"); 
		
			waitforelements(1000);
			
			WebElement element = driver.findElement(By.id("global-nav-user-dropdown"));
			Actions action = new Actions(driver);
		    action.moveToElement(element).build().perform();
		    waitforelements(2000);
		    driver.findElement(By.linkText("Log out")).click();
			System.out.println("Email - Logged Out Successfully"); 
		    
			waitforelements(3000);     
		
		}		
	

		private void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
}
