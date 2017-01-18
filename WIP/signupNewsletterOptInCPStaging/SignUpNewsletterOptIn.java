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


public class SignUpNewsletterOptIn {

	
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
		
		    String[] makerarray = { 
	
		    		".//*[@id='makertype-section']/div/div/div/label[1]", 
		    		".//*[@id='makertype-section']/div/div/div/label[2]", 
		    		".//*[@id='makertype-section']/div/div/div/label[3]", 
		    		".//*[@id='makertype-section']/div/div/div/label[4]", 
		    		".//*[@id='makertype-section']/div/div/div/label[5]",
		    		".//*[@id='makertype-section']/div/div/div/label[6]", 
		    		".//*[@id='makertype-section']/div/div/div/label[7]"
		    	
		    };
		    
		    String[] descarray =  { 
	
		    		"Full-stack Developer", 
		    		"Back-end Developer", 
		    		"Front-end Developer", 
		    		"Mobile Developer", 
		    		"Game Developer",
		    		"Designer", 
		    		"Other"
		    	
		    };
		    
		    int count = 0;  
		    
		    while (count <=6) {
		    
			driver.get("http://staging.devpost.com/opensesame/github");
			waitforelements(3000);
			driver.findElement(By.id("signup-link")).click(); 
		
			driver.findElement(By.id("user_screen_name")).sendKeys("Selenium");
			
			driver.findElement(By.id("submit-name-button")).click();
			
			driver.findElement(By.xpath(makerarray[count])).click();  //picking the maker type from the array
			
			waitforelements(3000);  
			
			driver.findElement(By.id("submit-makertype-button")).click();
			
			waitforelements(1000);
			
			driver.findElement(By.xpath(".//*[@id='tags-section']/div/div[1]/div/label[1]")).click();  
			
			waitforelements(1000);
			
			driver.findElement(By.id("submit-tag-button")).click(); 
			
			waitforelements(1000);
			
			driver.findElement(By.id("user_address")).sendKeys("New York");
			waitforelements(1000);
			driver.findElement(By.id("submit-location-button")).click(); 
			waitforelements(1000);
			assertTrue("Verification Failed on " + descarray[count] + ": The newsletter opt in is not checked.", driver.findElement(By.id("user_user_setting_attributes_receive_newsletter")).isSelected());
			
			System.out.println(descarray[count] + " is opted in.");  
						
		    count = count + 1;  
						
			waitforelements(2000);  
		    }
		}		
	

		private void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
}
