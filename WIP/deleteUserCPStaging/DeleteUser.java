package deleteUserCPStaging;

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


public class DeleteUser {

	
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
		
		driver.findElement(By.id("user_email")).sendKeys("jonathan.chu.cp+1@gmail.com");
		driver.findElement(By.id("user_password")).sendKeys("challenge2015");
		driver.findElement(By.name("commit")).click();
		System.out.println("Email - Logging In Successfully on FF"); 
	
		WebElement element = driver.findElement(By.id("global-nav-screen-name"));
		Actions action = new Actions(driver);
	    action.moveToElement(element).build().perform();
	    waitforelements(2000);
	    driver.findElement(By.linkText("Settings")).click();
		
		driver.findElement(By.linkText("Account")).click();  
		
		driver.findElement(By.linkText("Delete account")).click();
		
		driver.findElement(By.linkText("delete your account")).click();  
		
		driver.switchTo().alert().accept(); //modal pop up needs confirmation
		
		assertTrue("Verification Failed on deleting the user.", driver.getPageSource().contains("Your account has been deleted"));
		
		System.out.println("User Deleted Successfully"); 
		
		
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
