package ApplitTools;

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
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;

import java.net.URISyntaxException;


public class LoggedOutStaticPages {

	
	private WebDriver driver;
	Eyes eyes = new Eyes();
	
	@Before
	public void setUp() throws Exception {
		

        
        // This is your api key, make sure you use it in all your tests.
        eyes.setApiKey("p2jIcZRF3lT5hbdjFGB2Fr4mDOIBgUunBNhVqukZOgQ110");
		
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
		    
		
		
			
		      try {
		            // Start visual testing with browser viewport set to 1024x768.
		            // Make sure to use the returned driver from this point on.
		            driver = eyes.open(driver, "Applitools", "Test Web Page", new RectangleSize(1024, 600));

		            driver.get("http://staging.devpost.com/opensesame/github");

		            // Visual validation point #1
		            eyes.checkWindow("Home Page");
		            
		            
		            driver.get("http://devpost:un813KtMaZKEdVvt@staging.devpost.com/teams");
		            
			         // Visual validation point #2
			            eyes.checkWindow("Jobs Page");
		            
		            	            
		            driver.get("https://secure.staging.devpost.com/users/register");
		            // Visual validation point #3
		            eyes.checkWindow("Sign Up page");
		            
		            
		            driver.get("https://secure.staging.devpost.com/users/login");
		         // Visual validation point #4
		            eyes.checkWindow("Sign In page");
		            		            
		            driver.get("http://devpost:d3814acfb@post.staging.devpost.com");
		            eyes.checkWindow("Post page");
		            
		            driver.get("http://devpost:d3814acfb@post.staging.devpost.com/hackathons");
		            eyes.checkWindow("In-Person Hackathons Post");
		            
		            driver.get("http://devpost:d3814acfb@post.staging.devpost.com/online_hackathons");
		            eyes.checkWindow("Online Hackathons Post");
		            
		            driver.get("http://devpost:d3814acfb@post.staging.devpost.com/app_contest_resources");
		            eyes.checkWindow("Hackathon Best Practices Guides");
		            
		            driver.get("http://devpost:d3814acfb@info.staging.devpost.com/about");
		            eyes.checkWindow("About Page");
		            
		            driver.get("http://devpost:d3814acfb@info.staging.devpost.com/careers");
		            eyes.checkWindow("Careers Page");
		            
		            driver.get("http://devpost:d3814acfb@info.staging.devpost.com/press");
		            eyes.checkWindow("Press");
		            
		        
		            // End visual testing. Validate visual correctness.
		            eyes.close();
		        } finally {
		            // Abort test in case of an unexpected error.
		            eyes.abortIfNotClosed();
		            driver.close();
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
