package followCPStaging;

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


public class Follow {

	
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
		
			waitforelements(1000);
			
			driver.get("http://staging.challengepost.com/jchuwork");
			
			driver.findElement(By.className("follow-btn")).click(); 
			waitforelements(2000);
			assertEquals("UNFOLLOW", driver.findElement(By.className("follow-btn")).getText());
			System.out.println("Portfolio:  User is followed.");  
			
			waitforelements(3000);
			
			driver.findElement(By.className("follow-btn")).click();
			waitforelements(2000);
			assertEquals("FOLLOW", driver.findElement(By.className("follow-btn")).getText());
			System.out.println("Portfolio:  User is unfollowed.");  
			
			
			driver.get("http://staging.challengepost.com/software/jonathan-s-1st-software-project");
			
			driver.findElement(By.className("follow-btn")).click(); 
			waitforelements(2000);
			assertEquals("button follow-btn radius unfollow secondary tiny", driver.findElement(By.className("follow-btn")).getAttribute("class"));
			System.out.println("Software Project:  User is followed.");  
			
			driver.findElement(By.className("follow-btn")).click(); 
			waitforelements(2000);
			assertEquals("button follow-btn radius tiny follow tip-top has-tip", driver.findElement(By.className("follow-btn")).getAttribute("class"));
			System.out.println("Software Project:  User is unfollowed.");  
			
			WebElement element = driver.findElement(By.id("global-nav-user-dropdown"));
			Actions action = new Actions(driver);
		    action.moveToElement(element).build().perform();
		    waitforelements(2000);
		    driver.findElement(By.linkText("Log out")).click();
		    System.out.println("Email - Logged Out Successfully on FF"); 
		    
		  	   
		
		}		
	

		private void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
}
