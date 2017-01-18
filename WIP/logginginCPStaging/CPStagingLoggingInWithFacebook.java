package logginginCPStaging;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.*;

import static org.junit.Assert.*;
import static org.junit.ComparisonFailure.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CPStagingLoggingInWithFacebook {

	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "/Users/portia/Documents/workspace/Webdriver/geckodriver");
		
		
		ProfilesIni profile = new ProfilesIni();  
		FirefoxProfile myprofile = profile.getProfile("CPStagingFFProfile");
		
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		capabilities.setCapability(FirefoxDriver.PROFILE, myprofile);
		driver = new FirefoxDriver(capabilities);
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
			
			driver.findElement(By.className("blue")).click();
			waitforelements(2000);
			
			
			driver.findElement(By.id("email")).clear(); //clear out the field if pre-populating the field
			
			driver.findElement(By.id("email")).sendKeys("myrecipes004@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("recipes004");
			driver.findElement(By.id("loginbutton")).click();
			System.out.println("Facebook - Logging In Successfully on FF"); 
		
			waitforelements(3000);
			
			WebElement element = driver.findElement(By.id("global-nav-user-dropdown"));
			Actions action = new Actions(driver);
		    action.moveToElement(element).build().perform();
		    waitforelements(2000);
		    driver.findElement(By.linkText("Log out")).click();
			System.out.println("Facebook - Logged Out Successfully on FF"); 
		    
		  	   
		
		}		
	

		private void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
}
