package Devpost;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CreateSoftwareProject {

	
	WebDriver driver;
	By addsoftware = By.id("add-your-software");  //click on add software
	By addsoftwarename = By.id("software_name");  //add software name
	By saveshortform = By.id("software_name_save_button");  //Save short form
	By button = By.linkText("Log in");  //Click login button in the header
	By globalnav = By.id("global-nav-user-dropdown");  //Global Menu
	By logout = By.linkText("Log out");  //Log out button in the menu
	By tagline = By.id("software_tagline"); //tagline field
	By desc = By.id("software_description"); //description field
	By email = By.id("email");  //email field
	By addmember = By.className("attach-on-right");  //add member button
	By addskill = By.className("select2-search-choice-close");  //add skill
	By addskillfield = By.id("s2id_autogen1"); //add skill 
	By url = By.id("software_urls_attributes_0_url"); //url
	By remove = By.linkText("Remove");  //removing existing team mate
	By youtube = By.id("software_video_url"); //youtube
	By savelongform = By.id("software-save"); //save software long form
	By softwarephotodata = By.id("software_photo_data");  //used for saving photo
	By hackathonrespondno = By.className("option-no");  //clicking No after adding a software
	String filelocation = "/Users/jchubacca/Documents/workspace/Webdriver/seleniumimage.jpg";
	String video = "https://www.youtube.com/watch?v=YroljNRBy6Q";
	String sampleURL = "https://www.youtube.com/watch?v=YroljNRBy6Q";
	String sampleskill = "selenium";
	String sampledesc = "description";

	public CreateSoftwareProject(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void clearField(WebElement field) {
		
		field.clear();
		
	}
	
	public String getTime() {
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return timeStamp;
		
	}
	
	
	public void addSoftware() {
		
		driver.findElement(addsoftware).click();
		
	}
	
	public void addSoftwareName(String timeStamp) {
	
		driver.findElement(addsoftwarename).sendKeys(timeStamp + "  Automated Selenium Project - FF");
	
	}
	
	
	public void saveSoftwareShortForm() {
		
		driver.findElement(saveshortform).click();
		
	}
	
	public void addTagline() {
		
		clearField(driver.findElement(tagline));
		driver.findElement(tagline).sendKeys("Tagline");
		System.out.println("Adding a tagline.");  
		
	}
		
	public void addTeamMembers() {
		
		Boolean exists = driver.findElements(remove).size() != 0;
		
		if (exists == true) {
			driver.findElement(remove).click();
		}
		
		driver.findElement(email).sendKeys("jonathan.chu.cp+3@gmail.com");
		driver.findElement(addmember).click();
		System.out.println("Adding a team member.");  
		
	}

	
	public void addDescription() {
		
		
		clearField(driver.findElement(desc));
		driver.findElement(desc).sendKeys(sampledesc);
		System.out.println("Adding a description.");  
	}
	
	public void addSkill() {
		
		driver.findElement(addskill).click();
		driver.findElement(addskillfield).sendKeys(sampleskill);
		waitforelements(2000);  //Need this pause so the enter key works to select the skill
		driver.findElement(addskillfield).sendKeys(Keys.RETURN);
		System.out.println("Adding a skill.");  
		
	}
		
	public void addURL() {
		
		clearField(driver.findElement(url));
		driver.findElement(url).sendKeys(sampleURL);
		System.out.println("Adding software URL"); 
		
	}

		
	public void addYoutube() {
	
		clearField(driver.findElement(youtube));
		driver.findElement(youtube).sendKeys(video); 
		System.out.println("Adding video URL"); 
	
    }
	
	 
	public void addImage() {
	
		/*
		Boolean exists = driver.findElements(By.cssSelector("a.ss-icon.ss-delete")).size() != 0;
		
		
		if (exists == true) {
			driver.findElement(By.cssSelector("a.ss-icon.ss-delete")).click();
		}
		*/
		
	JavascriptExecutor click = (JavascriptExecutor)driver;  //Javascript is needed to upload the image.  
	WebElement fileInput = driver.findElement(softwarephotodata); 
	String js = "arguments[0].style.display ='block';";
	// String js = "$('#software_photo_data').css(display: 'block');";   jquery version
	click.executeScript(js, fileInput);
	driver.findElement(softwarephotodata).sendKeys(filelocation);
	System.out.println("Image uploaded successfully");
		
	}
	
	public void saveSoftwareLongForm() {
		
		driver.findElement(savelongform).click();
		System.out.println("Saved project!");
		
	}
		
	
	public void respondNoHackathon() {
	
	driver.findElement(hackathonrespondno).click();
	 
	}    
	
	
    public void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
	
	
	
	
}	
	
   