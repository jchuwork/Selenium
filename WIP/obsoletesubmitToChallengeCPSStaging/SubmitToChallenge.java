package obsoletesubmitToChallengeCPSStaging;

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


public class SubmitToChallenge {

	
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
		
			waitforelements(1000);
			
			driver.get("http://automation.staging.challengepost.com/");  
			driver.findElement(By.linkText("or start another submission")).click();  
			System.out.println("Starting submission"); 
			
			driver.findElement(By.id("submission_title")).sendKeys(timeStamp + "  Automated Selenium Project - FF");
			
			waitforelements(1000);
			
			driver.findElement(By.id("submission_tagline")).sendKeys("Tagline - Automated");  
			
			waitforelements(1000);
			
			driver.findElement(By.id("submission_description")).sendKeys("Description - Automated"); 
			
			waitforelements(1000);
			
			/*
			JavascriptExecutor click = (JavascriptExecutor)driver;  //Javascript is needed to upload the image.  
			WebElement fileInput = driver.findElement(By.id("solution_photo_data")); 
			String js = "arguments[0].style.display ='block';";
			//String js = "$('#software_photo_data').css(display: 'block');";   //jquery version
    		click.executeScript(js, fileInput);
    		waitforelements(1000);
    		driver.findElement(By.id("solution_photo_data")).sendKeys("/Users/portia/Documents/workspace/Webdriver/seleniumimage.jpg");
    		System.out.println("Image uploaded successfully");
    		waitforelements(2000);
    		*/
			
    		driver.findElement(By.id("submission_video")).sendKeys("https://www.youtube.com/watch?v=YroljNRBy6Q"); 
			System.out.println("Adding video URL");  
								
			driver.findElement(By.id("submission_website")).sendKeys("http://staging.challengepost.com");
			System.out.println("Adding software URL");  
			
			driver.findElement(By.id("s2id_autogen1")).sendKeys("selenium");
			waitforelements(1000);  //Need this pause so the enter key works to select the skill
			driver.findElement(By.id("s2id_autogen1")).sendKeys(Keys.RETURN);
			System.out.println("Adding a skill.");  
			
			driver.findElement(By.id("submission_custom_data_data_required_checkbox_terms")).click();
			waitforelements(2000);
						
			driver.findElement(By.name("commit")).click();  
						
			System.out.println("Successfully created a software package!"); 
			
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
