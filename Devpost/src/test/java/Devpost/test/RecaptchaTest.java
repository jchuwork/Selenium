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

import Devpost.CreateSoftwareProject;
import Devpost.LoggingIn;
import junit.framework.TestCase;

public class RecaptchaTest
    extends TestCase
{

	public WebDriver driver;
	CreateSoftwareProject csp;
	LoggingIn login;  
	String logintype = "email";
	String error = "Please complete the reCAPTCHA to submit this form.";
	String message;
	Boolean notexists; 
	
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "/Users/jchubacca/Documents/workspace/Webdriver/chromedriver");
	    driver = new ChromeDriver();
	    csp = new CreateSoftwareProject(driver);
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
		login.enterUsername(logintype);
		login.enterPassword(logintype);
		login.submit(logintype);
		    
		driver.get("http://www.devpost.com/software");
		
		csp.addSoftware();
		csp.addSoftwareName(csp.getTime());
		
		notexists = driver.findElements(By.className("alert")).size() == 0;
		
		assertTrue(notexists == true);
		System.out.println("Error message does not exist prior to clicking save.");
		
		csp.saveSoftwareShortForm();
		
		message = driver.findElement(By.className("alert")).getText();	
				
		assertEquals(error, message);
		
		System.out.println("Recaptcha validation works.");
		
	    
		}		
	
	
}

