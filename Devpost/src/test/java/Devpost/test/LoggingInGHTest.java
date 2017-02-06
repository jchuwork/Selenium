package Devpost.test;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Devpost.LoggingIn;
import junit.framework.TestCase;

public class LoggingInGHTest 
    extends TestCase
{

	public WebDriver driver;
	LoggingIn login; 
	String logintype = "github";
	
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "/Users/jchubacca/Documents/workspace/Webdriver/chromedriver");
	    driver = new ChromeDriver();
	    login = new LoggingIn(driver);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://www.devpost.com/");
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();   
			   
	}

	@Test
	public void test() {
		    
		login.clickLogIn();
		login.clickSocialButton(logintype);
		login.enterUsername(logintype);
		login.enterPassword(logintype);
		login.submit(logintype);
		
		System.out.println("GH - Logging In Successfully"); 
	
		login.waitforelements(1000);
		
		login.logout();
		
		System.out.println("GH - Logged Out Successfully"); 
	    
		}		
}

