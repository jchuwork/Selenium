package deletesoftwareprojectCPStaging;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.*;

import static org.junit.Assert.*;
import static org.junit.ComparisonFailure.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class DeleteSoftwareProjectChrome {

	
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
			System.out.println("Logging In Successfully on Chrome"); 
		
			waitforelements(2000);
			
			WebElement screenname = driver.findElement(By.id("global-nav-user-dropdown"));
			Actions action = new Actions(driver);
			action.moveToElement(screenname).build().perform();
		    waitforelements(2000);
		    driver.findElement(By.linkText("Portfolio")).click();
			
		   	driver.findElement(By.xpath(".//*[starts-with(@id, 'software_')]/figure/img")).click();  //chooses the 1st software package it comes across
			driver.findElement(By.linkText("Edit project")).click(); 
			waitforelements(2000);
			
			driver.findElement(By.linkText("Delete project")).click();
			
			waitforelements(2000);
								
			driver.switchTo().alert().accept(); //modal pop up needs confirmation
		
			waitforelements(3000);
			
			System.out.println("Successfully deleted the latest software package!"); 
			
			waitforelements(3000);
			
			screenname = driver.findElement(By.id("global-nav-user-dropdown"));
		    action.moveToElement(screenname).build().perform();
		    waitforelements(2000);
			
		    driver.findElement(By.linkText("Log out")).click();
		    
		    waitforelements(2000);
		    System.out.println("Logged Out Successfully"); 
			
		}		
	

		private void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
}
