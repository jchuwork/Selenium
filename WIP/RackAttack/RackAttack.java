package RackAttack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.junit.*;

import static org.junit.Assert.*;
import static org.junit.ComparisonFailure.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;


public class RackAttack {

	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
	
		   System.setProperty("webdriver.chrome.driver", "/Users/jchubacca/Documents/workspace/Webdriver/chromedriver");
		    
		   ChromeOptions options = new ChromeOptions(); 
		   options.addArguments("user-data-dir=/Users/jchubacca/Library/Application Support/Google/Chrome/SeleniumProfile");
		   driver = new ChromeDriver(options);
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}

	@After
	public void tearDown() throws Exception {
		   driver.quit();
		   
	}

	@Test
	public void test() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		
		    int count = 0; 
		    
			
			while (count < 5000) {
			
				
			WebClient client = new WebClient();
			int code = client.getPage("http://presubmissions.staging.devpost.com/").getWebResponse().getStatusCode();
		    System.out.println(code);
		   
			System.out.println(count);
			
			count = count + 1; 
			
			}
			
		    
			System.out.println("Tests Completed!");
		  	   
		
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
