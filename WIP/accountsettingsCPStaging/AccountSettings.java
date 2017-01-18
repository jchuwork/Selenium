package accountsettingsCPStaging;

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

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class AccountSettings {

	
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
		    driver.findElement(By.linkText("Settings")).click();
			System.out.println("Info Section"); 
			
			//driver.findElement(By.id("change_photo_label")).click();
			
			assertEquals("Jonathan", driver.findElement(By.id("user_first_name")).getAttribute("value"));
			driver.findElement(By.id("user_first_name")).clear();
			driver.findElement(By.id("user_first_name")).sendKeys("Jonathan");
			
			assertEquals("C - Automation", driver.findElement(By.id("user_last_name")).getAttribute("value"));
			driver.findElement(By.id("user_last_name")).clear();
			driver.findElement(By.id("user_last_name")).sendKeys("C - Automation");
			
			assertEquals("Flushing, Queens, NY, USA", driver.findElement(By.id("user_address")).getAttribute("value"));
			driver.findElement(By.id("user_address")).clear();
			driver.findElement(By.id("user_address")).sendKeys("Flushing, Queens, NY, USA");
			
			assertEquals("Bio for Automation", driver.findElement(By.id("user_user_setting_attributes_tagline")).getAttribute("value"));
			driver.findElement(By.id("user_user_setting_attributes_tagline")).clear();
			driver.findElement(By.id("user_user_setting_attributes_tagline")).sendKeys("Bio for Automation");
			
			assertEquals("Twitter", driver.findElement(By.id("user_user_setting_attributes_twitter")).getAttribute("value"));
			driver.findElement(By.id("user_user_setting_attributes_twitter")).clear();
			driver.findElement(By.id("user_user_setting_attributes_twitter")).sendKeys("Twitter");
			
			assertEquals("jcmixpanel", driver.findElement(By.id("user_user_setting_attributes_github_login")).getAttribute("value"));
			driver.findElement(By.id("user_user_setting_attributes_github_login")).clear();
			driver.findElement(By.id("user_user_setting_attributes_github_login")).sendKeys("jcmixpanel");		
			
			assertEquals("http://linkedin.com", driver.findElement(By.id("user_user_setting_attributes_linkedin")).getAttribute("value"));
			driver.findElement(By.id("user_user_setting_attributes_linkedin")).clear();
			driver.findElement(By.id("user_user_setting_attributes_linkedin")).sendKeys("http://linkedin.com");	
			
			assertEquals("http://www.google.com", driver.findElement(By.id("user_user_setting_attributes_website")).getAttribute("value"));
			driver.findElement(By.id("user_user_setting_attributes_website")).clear();
			driver.findElement(By.id("user_user_setting_attributes_website")).sendKeys("http://www.google.com");
	
			assertEquals("selenium", driver.findElement(By.className("select2-search-choice")).getText());
			driver.findElement(By.className("select2-search-choice-close")).click();
			driver.findElement(By.id("s2id_autogen1")).sendKeys("selenium");
			waitforelements(1000);  //Need this pause so the enter key works to select the skill
			driver.findElement(By.id("s2id_autogen1")).sendKeys(Keys.RETURN);
			
			assertTrue("Full-stack Developer is checked.",driver.findElement(By.id("user_specialization_ids_2")).isSelected());
			driver.findElement(By.id("user_specialization_ids_2")).click();
			driver.findElement(By.id("user_specialization_ids_2")).click();
			
			assertTrue("Back-end Developer is checked.",driver.findElement(By.id("user_specialization_ids_2")).isSelected());
			driver.findElement(By.id("user_specialization_ids_32")).click(); 
			driver.findElement(By.id("user_specialization_ids_32")).click();
			
			assertTrue("Front-end Developer is checked.",driver.findElement(By.id("user_specialization_ids_2")).isSelected());
			driver.findElement(By.id("user_specialization_ids_31")).click();
			driver.findElement(By.id("user_specialization_ids_31")).click(); 
			
			assertTrue("Mobile Developer is checked.",driver.findElement(By.id("user_specialization_ids_2")).isSelected());
			driver.findElement(By.id("user_specialization_ids_33")).click();
			driver.findElement(By.id("user_specialization_ids_33")).click();
			
			assertTrue("Game Developer is checked.",driver.findElement(By.id("user_specialization_ids_2")).isSelected());
			driver.findElement(By.id("user_specialization_ids_34")).click();
			driver.findElement(By.id("user_specialization_ids_34")).click(); 
			
			assertTrue("Designer is checked.",driver.findElement(By.id("user_specialization_ids_2")).isSelected());
			driver.findElement(By.id("user_specialization_ids_1")).click(); 
			driver.findElement(By.id("user_specialization_ids_1")).click(); 
			
			assertTrue("Other is checked.",driver.findElement(By.id("user_specialization_ids_2")).isSelected());
			driver.findElement(By.id("user_specialization_ids_3")).click(); 
			driver.findElement(By.id("user_specialization_ids_3")).click(); 
			
			driver.findElement(By.name("commit")).click();
			
			System.out.println("Info Section Completed");
			
			driver.findElement(By.linkText("Account")).click();
			System.out.println("Account Section");
			
			assertEquals("jcmixpanel", driver.findElement(By.id("user_screen_name")).getAttribute("value"));
			driver.findElement(By.id("user_screen_name")).clear();
			driver.findElement(By.id("user_screen_name")).sendKeys("JCMixpanel");	
			
			assertEquals("jonathan.chu.cp@gmail.com", driver.findElement(By.id("user_email")).getAttribute("value"));
			driver.findElement(By.id("user_email")).clear();
			driver.findElement(By.id("user_email")).sendKeys("jonathan.chu.cp@gmail.com");	
			driver.findElement(By.name("commit"));
			
			System.out.println("Account Section Completed");
			
			driver.findElement(By.linkText("Password")).click();
			System.out.println("Password Section");
			driver.findElement(By.id("old_password"));
			driver.findElement(By.id("user_password"));
			driver.findElement(By.id("user_password_confirmation"));
			System.out.println("Password Section Completed");
			
			
			driver.findElement(By.linkText("Notifications")).click();
			System.out.println("Notifications Section");
			assertTrue("Receive weekly newsletter",driver.findElement(By.id("user_user_setting_attributes_receive_newsletter")).isSelected());
			driver.findElement(By.id("user_user_setting_attributes_receive_newsletter")).click(); 
			driver.findElement(By.id("user_user_setting_attributes_receive_newsletter")).click(); 
			System.out.println("Notfications Section Completed");
			
			waitforelements(3000);
		    
			System.out.println("Account Settings Completed!");
		  	   
		
		}		
	

		private void assertTrue(String string, boolean selected) {
		// TODO Auto-generated method stub
		
	}

		private void assertTrue(String string, String text) {
		// TODO Auto-generated method stub
		
	}

		private void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
}
