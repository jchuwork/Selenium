package portfolioCPStaging;

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


public class Portfolio {

	
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
			
			driver.get("http://staging.devpost.com/jcmixpanel");
					
			driver.findElement(By.xpath(".//*[@id='portfolio-navigation']/ul/li[1]/a")).click();
			System.out.println("Projects"); 
			
			driver.findElement(By.xpath(".//*[@id='portfolio-navigation']/ul/li[2]/a")).click();
			System.out.println("Hackathons"); 
			
			driver.findElement(By.xpath(".//*[@id='portfolio-navigation']/ul/li[3]/a")).click();
			System.out.println("Follower");
			
			driver.findElement(By.xpath(".//*[@id='portfolio-navigation']/ul/li[4]/a")).click();
			System.out.println("Following"); 
			
			driver.findElement(By.xpath(".//*[@id='portfolio-navigation']/ul/li[5]/a")).click();
			System.out.println("Likes"); 	
			
			waitforelements(2000);
		    
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
