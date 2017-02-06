package Devpost.test;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Devpost.CreateHackathon;
import Devpost.LoggingIn;
import junit.framework.TestCase;

public class CreateHackathonTest
    extends TestCase
{

	public WebDriver driver;
	CreateHackathon ch;
	LoggingIn login;  
	String logintype = "email";
	String error = "Something isn't right — please fix the errors outlined below.";
	String message;
	Boolean notexists; 
	
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "/Users/jchubacca/Documents/workspace/Webdriver/chromedriver");
	    driver = new ChromeDriver();
	    ch = new CreateHackathon(driver);
	    login = new LoggingIn(driver);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://www.devpost.com/");
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();   
			   
	}

	@Test 
	public void test() {  //verify creating a new hackathon
		
		login.clickLogIn();
		login.enterUsername(logintype);
		login.enterPassword(logintype);
		login.submit(logintype);
		ch.addHackathon();
		System.out.println("Successfully created a new challenge!"); 
		
		}		
	
	
	@Test
	public void testBadDate() {   //negative test
		
		
		login.clickLogIn();
		login.enterUsername(logintype);
		login.enterPassword(logintype);
		login.submit(logintype);
		
		assertTrue(ch.enterInvalidDate());  //verify that the error message exists
		System.out.println("Error message exists on invalid date.");
		
	}
	
	
				
	
	
}

