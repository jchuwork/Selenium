package Devpost.test;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import Devpost.CreateSoftwareProject;
import Devpost.LoggingIn;
import junit.framework.TestCase;

public class EditSoftwareProjectTest
    extends TestCase
{

	public WebDriver driver;
	CreateSoftwareProject csp;
	LoggingIn login;  
	String logintype = "email";
	String error = "Something isn't right — please fix the errors outlined below.";
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
		    
		driver.get("https://devpost.com/software/automation-test/edit");
		
		csp.addTagline();
		csp.addTeamMembers();
		csp.addDescription();
		csp.addURL();
		csp.addSkill();
		csp.addImage();
		csp.addYoutube();
		csp.saveSoftwareLongForm();
		
		}		
	
	@Test
	
	public void testSavingNoDesc() {
		
		By desc = By.id("software_description");
		String actualerror;
	
		login.clickLogIn();
		login.enterUsername(logintype);
		login.enterPassword(logintype);
		login.submit(logintype);
		    
		driver.get("https://devpost.com/software/automation-test/edit");
		
		csp.addTagline();
		csp.addTeamMembers();
		csp.clearField(driver.findElement(desc)); //clear out desc field
		csp.addURL();
		csp.addSkill();
		csp.addImage();
		csp.addYoutube();
		csp.saveSoftwareLongForm();
		
		actualerror = driver.findElement(By.className("alert-box")).getText();
		
		assertEquals(error, actualerror);
		
	}
	
	@Test
	
		public void testSavingNoTagline() {
	
			By tagline = By.id("software_tagline");
			String actualerror;
	
			login.clickLogIn();
			login.enterUsername(logintype);
			login.enterPassword(logintype);
			login.submit(logintype);
		    
			driver.get("https://devpost.com/software/automation-test/edit");
			
			csp.clearField(driver.findElement(tagline));
			csp.addTeamMembers();
			csp.addDescription();
			csp.addURL();
			csp.addSkill();
			csp.addImage();
			csp.addYoutube();
			csp.saveSoftwareLongForm();
			
			actualerror = driver.findElement(By.className("alert-box")).getText();
			
			assertEquals(error, actualerror);
		
		}
		
		@Test
		public void testSavingNoName() {
			
			By name = By.id("software_name");
			String actualerror;
		
			login.clickLogIn();
			login.enterUsername(logintype);
			login.enterPassword(logintype);
			login.submit(logintype);
			    
			driver.get("https://devpost.com/software/automation-test/edit");
			
			csp.clearField(driver.findElement(name));
			csp.addTagline();
			csp.addTeamMembers();
			csp.addDescription();
			csp.addURL();
			csp.addSkill();
			csp.addImage();
			csp.addYoutube();
			csp.saveSoftwareLongForm();
			
			actualerror = driver.findElement(By.className("alert-box")).getText();
			
			assertEquals(error, actualerror);
			
		}
	
	
}

