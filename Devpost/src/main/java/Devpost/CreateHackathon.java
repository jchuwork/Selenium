package Devpost;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreateHackathon {

	
	WebDriver driver;
	By title = By.id("challenge_title");
	By startdate = By.id("challenge_submissions_start_at");
	By save = By.name("commit");
	String baddate = "01/01/2016";
	String timestamp;  
	String url = "https://manage.devpost.com/hackathon/new";
	

	public CreateHackathon(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
    public String getTime() {
		
		timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return timestamp;
		
	}
	
	
	public void addHackathon() {
		
		driver.get(url);
		
		timestamp = getTime();
		
		driver.findElement(title).sendKeys(timestamp + " Automated Selenium Challenge");
		driver.findElement(startdate).sendKeys(timestamp);
		driver.findElement(startdate).sendKeys(Keys.RETURN);
		driver.findElement(save).click();  
		
		
	}
		
	public boolean enterInvalidDate() {
		
		Boolean exists;
		
		driver.get(url);
		timestamp = getTime();
		
		driver.findElement(title).sendKeys(timestamp + " Automated Selenium Challenge");
		driver.findElement(startdate).sendKeys(baddate);
		driver.findElement(startdate).sendKeys(Keys.RETURN);
		driver.findElement(save).click();  
		
		exists = driver.findElements(By.cssSelector("label.message.errors")).size() != 0;
		
		return exists; 
	}
		
	
	
}	
	
   