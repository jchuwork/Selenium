package Devpost;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.*;

import static org.junit.Assert.*;
import static org.junit.ComparisonFailure.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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


public class CreateSoftwareProject {

	
	WebDriver driver;
	By button = By.linkText("Log in");  //Click login button in the header
	By globalnav = By.id("global-nav-user-dropdown");  //Global Menu
	By logout = By.linkText("Log out");  //Log out button in the menu
	
	//Email
	
	By username = By.id("user_email");
	By password = By.id("user_password");
	By submit = By.id("submit-form");
	String name = "jonathan.chu.cp@gmail.com";
	String pass = "challenge2015";
	
	//Facebook
	By facebook = By.className("blue");
	By fbusername = By.id("email");
	By fbpassword = By.id("pass");
	By fblogin = By.id("loginbutton");
	String fbname = "myrecipes004@gmail.com";
	String fbpass = "recipes004";

	//GitHub
	By github = By.className("primary");
	By ghusername = By.id("login_field");
	By ghpassword = By.id("password");
	By ghlogin = By.name("commit");
	String ghname = "jchubacca";
	String ghpass = "challenge2015";
	
	//LinkedIn
	By linkedin = By.className("linkedin-blue");
	By liusername = By.name("session_key");
	By lipassword = By.name("session_password");
	By lilogin = By.name("authorize");
	String liname = "jonathan.chu.test@gmail.com";
	String lipass = "automationtest";

	public CreateSoftwareProject(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
    public void clickSocialButton(String logintype) {
    	
    	if (logintype == "facebook") {
    		
    		driver.findElement(facebook).click();	
    			
    		}
    	else if (logintype == "github"){
    		driver.findElement(github).click();
    	}
    	
    	else if (logintype == "linkedin"){
    		driver.findElement(linkedin).click();
    	}
		
    	else if (logintype == "linkedin"){
    		driver.findElement(linkedin).click();
    	}
		
			
	}		
		
	public void clickLogIn() {	    
		
		driver.findElement(button).click();
		  	   
		
		}		
	
	public void enterUsername(String logintype) {
		
		if (logintype == "email") {
		
		driver.findElement(username).sendKeys(name);
		
		}
		else if (logintype == "facebook") {
		
		driver.findElement(fbusername).sendKeys(fbname);	
			
		}
		else if (logintype == "github"){
		
		driver.findElement(ghusername).sendKeys(ghname);
			
		}
		else if (logintype == "linkedin"){
			
			driver.findElement(liusername).sendKeys(liname);
				
			}	
		
	}
	
	public void enterPassword(String logintype) {
		
		if (logintype == "email") {
			
			driver.findElement(password).sendKeys(pass);
			
			}
			else if (logintype == "facebook") {
			
			driver.findElement(fbpassword).sendKeys(fbpass);	
				
			}
			else if (logintype == "github"){
			
			driver.findElement(ghpassword).sendKeys(ghpass);
				
			}
			else if (logintype == "linkedin"){
				
				driver.findElement(lipassword).sendKeys(lipass);
					
			}
		
	}
	
	public void submit(String logintype) {
		
            if (logintype == "email") {
			
            	driver.findElement(submit).click();
			
			}
			else if (logintype == "facebook") {
			
				driver.findElement(fblogin).click();	
				
			}
			else if (logintype == "github"){
			
				driver.findElement(ghlogin).click();
			}
			else if (logintype == "linkedin"){
				
				driver.findElement(lilogin).click();
			}
	}
	
	
	public void logout() {
		
		WebElement element = driver.findElement(globalnav);
		Actions action = new Actions(driver);
	    action.moveToElement(element).build().perform();
	    waitforelements(2000);
	    		    
	    driver.findElement(logout).click();
		
	}
	
	
	
	public void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
}
