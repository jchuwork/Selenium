package signupNewsletterOptInCPStaging;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class SignUpNewsletterNotMakerOptIn {

	
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
			driver.findElement(By.id("signup-link")).click(); 
		
			driver.findElement(By.id("user_screen_name")).sendKeys("Selenium");
			
			driver.findElement(By.id("submit-name-button")).click();
			
			driver.findElement(By.id("not-maker")).click(); 
					
			waitforelements(3000);  
			
			assertTrue("Verification Failed on Orgaziner, manager, judge, or voter: The newsletter opt in is not checked.", driver.findElement(By.id("user_user_setting_attributes_receive_newsletter")).isSelected());
			
			System.out.println("Organizer, challenge manager, judge or voter is opted in.");  
						
		    waitforelements(5000);  
		    
		}		
	

		private void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
}
