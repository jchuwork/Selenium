package createsChallengeCPStaging;

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


public class CreateChallenge {

	
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
	
		    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		
			driver.get("http://staging.devpost.com/opensesame/github");
			waitforelements(3000);
			driver.findElement(By.linkText("Log in")).click();
			
	        waitforelements(2000);
			
			driver.findElement(By.id("user_email")).sendKeys("jonathan.chu.cp@gmail.com");
			driver.findElement(By.id("user_password")).sendKeys("challenge2015");
			driver.findElement(By.name("commit")).click();
			System.out.println("Logging In Successfully on FF"); 
		
			waitforelements(3000);
			
			driver.findElement(By.linkText("Find a hackathon")).click();
			
			driver.findElement(By.partialLinkText("Post")).click();
	
			driver.findElement(By.linkText("Start your in-person hackathon")).click(); 
						
			driver.findElement(By.id("challenge_title")).sendKeys(timeStamp + " Automated Selenium Challenge");
			
			timeStamp =  new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
			
			driver.findElement(By.id("challenge_submissions_start_at")).sendKeys(timeStamp);
						
			driver.findElement(By.name("commit")).click();  
			
			System.out.println("Successfully created a new challenge!"); 
			
			
			/*
			driver.findElement(By.xpath("//div[@id='ember898']/button")).click(); 
			
			driver.findElement(By.xpath(".//*[@id='ember734']/div")).sendKeys("Description");  
			
			driver.findElement(By.xpath(".//*[@id='ember796']/div/p")).sendKeys("New York");  
			
			
			driver.findElement(By.linkText("Essentials")).click();  
			
			driver.findElement(By.name("commit")).click();  
			
			driver.findElement(By.cssSelector("html..firepath-matching-node")).sendKeys("Rules");
			
			
			driver.findElement(By.id("challenge_subdomain")).sendKeys("AutomatedTest");
			
			driver.findElement(By.linkText("Homepage")).click();  
			
			*/
			
			
			
			waitforelements(10000);
			
		}		
	

		private void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
}
