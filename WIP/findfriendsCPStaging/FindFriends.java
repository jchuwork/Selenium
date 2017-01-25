package findfriendsCPStaging;

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

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class FindFriends {

	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		ProfilesIni profile = new ProfilesIni();  
		FirefoxProfile myprofile = profile.getProfile("CPStagingFFProfile");
		 
		driver = new FirefoxDriver(myprofile);
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
			driver.findElement(By.name("commit")).click();
			System.out.println("Email - Logging In Successfully on FF"); 
		
			waitforelements(2000);
			
			WebElement element = driver.findElement(By.id("global-nav-user-dropdown"));
			Actions action = new Actions(driver);
		    action.moveToElement(element).build().perform();
		    waitforelements(2000);
		    driver.findElement(By.linkText("Find friends")).click();
			System.out.println("Facebook"); 
			driver.findElement(By.className("facebook-login")).isDisplayed();  
			
			
			driver.findElement(By.linkText("Twitter")).click();
			System.out.println("Twitter");
			driver.findElement(By.className("twitter-login")).isDisplayed(); 
			
			driver.findElement(By.linkText("GitHub")).click();
			System.out.println("GitHub");
			assertTrue("Verification Failed on GitHub",driver.getPageSource().contains("None of your GitHub friends are using Devpost yet.") );
			
			driver.findElement(By.linkText("Recommended")).click();
			System.out.println("Recommended");
			assertTrue("Verification Failed on Recommended users", driver.getPageSource().contains("Recommended people to follow"));  
			
			waitforelements(3000);
			
			System.out.println("Find Friends tabs exist along with the correct data.");
		    
		  	   
		
		}		
	

		private void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
}
