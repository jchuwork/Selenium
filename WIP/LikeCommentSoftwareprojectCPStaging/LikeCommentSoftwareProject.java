package LikeCommentSoftwareprojectCPStaging;

import org.openqa.selenium.Alert;
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
import org.openqa.selenium.Keys;




public class LikeCommentSoftwareProject {

	
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
			
			driver.get("http://staging.challengepost.com/software/automation-project-do-not-delete");
			
			
			driver.findElement(By.className("like-button")).click();
			System.out.println("Liked the Project");			
			waitforelements(3000);
			
			boolean exists = driver.findElements(By.className("liked-button") ).size() != 0;
			assertTrue("The Like button still exists.", exists);
			
			driver.findElement(By.className("liked-button")).click();
			System.out.println("Unliked the Project"); 
			waitforelements(3000);  
		
			exists = driver.findElements( By.className("like-button") ).size() != 0;
			assertTrue("The Liked button still exists.", exists);
			
			driver.findElement(By.id("software-comment-button")).click(); 
			driver.findElement(By.id("comment_body")).sendKeys("Test Comment");
			driver.findElement(By.className("btn")).click();
			System.out.println("Successfully added a comment.");
			
			driver.findElement(By.className("ss-trash")).click();  
			waitforelements(2000);  
			Alert alert = driver.switchTo().alert();   //This is needed to handle the modal dialog pop up.  
			alert.accept();
			assertFalse("Comment was not deleted.", driver.getPageSource().contains("Test Comment"));		
						
			System.out.println("Successfully deleted a comment.");
			
			waitforelements(3000);
						
			System.out.println("Successfully Liked, Unliked, Commented, and Deleted a Comment on a Project!"); 
			waitforelements(3000);
			
		}		
	

		private void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
}
