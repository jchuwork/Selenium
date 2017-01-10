package newsubmissionflowsubmitToChallengeCPSStaging;

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


public class CreateSoftwareProject {

	
	
	
	public static void test(FirefoxDriver string) {
	
		    System.out.println("Starting to add the project");	
		
		    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		    WebDriver driver = string;
		    
		   
		    
		    System.out.println(driver.getCurrentUrl());	
		    
		    waitforelements(3000);
		    
			driver.findElement(By.id("software_name")).sendKeys(timeStamp + "  Automated Selenium Project - FF");
			driver.findElement(By.id("software_name_save_button")).click(); 
			System.out.println("Adding a project to your portfolio.");  
			
			driver.findElement(By.id("software_tagline")).sendKeys("Tagline");
			System.out.println("Adding a tagline.");
			
			
			/*driver.findElement(By.id("software-thumbnail-button")).click();
			
			driver.findElement(By.id("software-thumbnail-button")).sendKeys("/Users/portia/Documents/workspace/Webdriver/seleniumimage.jpg");
			waitforelements(5000);
			System.out.println("Thumbnail uploaded successfully");
			*/
			
			driver.findElement(By.id("email")).sendKeys("jonathan.chu.cp+3@gmail.com");
			driver.findElement(By.className("attach-on-right")).click(); 
			
			waitforelements(2000);  
					
			driver.findElement(By.id("software_description")).sendKeys("Description");
			System.out.println("Adding a description.");  
			
			driver.findElement(By.id("s2id_autogen1")).sendKeys("selenium");
			waitforelements(1000);  //Need this pause so the enter key works to select the skill
			driver.findElement(By.id("s2id_autogen1")).sendKeys(Keys.RETURN);
			System.out.println("Adding a skill.");  
			
			driver.findElement(By.id("software_urls_attributes_0_url")).sendKeys("http://staging.challengepost.com");
			System.out.println("Adding software URL");  
			
			driver.findElement(By.id("software_video_url")).sendKeys("https://www.youtube.com/watch?v=YroljNRBy6Q"); 
			System.out.println("Adding video URL");  
			
			JavascriptExecutor click = (JavascriptExecutor)driver;  //Javascript is needed to upload the image.  
			WebElement fileInput = driver.findElement(By.id("software_photo_data")); 
			String js = "arguments[0].style.display ='block';";
			// String js = "$('#software_photo_data').css(display: 'block');";   jquery version
    		click.executeScript(js, fileInput);
    		driver.findElement(By.id("software_photo_data")).sendKeys("/Users/portia/Documents/workspace/Webdriver/seleniumimage.jpg");
    		System.out.println("Image uploaded successfully");
			
			
			waitforelements(2000);
			
			driver.findElement(By.id("software-save")).click();
															
			System.out.println("Successfully created a software project!"); 
			
			waitforelements(3000);
			
		}		
	

		private static void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
}
