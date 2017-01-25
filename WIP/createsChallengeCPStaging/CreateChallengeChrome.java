package createsChallengeCPStaging;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CreateChallengeChrome {

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
	public void test() {
	
		    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
			driver.get("http://staging.devpost.com/opensesame/github");
			waitforelements(3000);
			driver.findElement(By.linkText("Log in")).click();
			
	        waitforelements(2000);
			
			driver.findElement(By.id("user_email")).sendKeys("jonathan.chu.cp@gmail.com");
			driver.findElement(By.id("user_password")).sendKeys("challenge2015");
			driver.findElement(By.id("submit-form")).click();
			System.out.println("Logging In Successfully on Chrome"); 
		
			driver.get("https://manage.staging.devpost.com/hackathon/new");
						
			driver.findElement(By.id("challenge_title")).sendKeys(timeStamp + " Automated Selenium Challenge");
			
			timeStamp =  new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
			
			driver.findElement(By.id("challenge_submissions_start_at")).sendKeys(timeStamp);
			driver.findElement(By.id("challenge_submissions_start_at")).sendKeys(Keys.RETURN);
			driver.findElement(By.name("commit")).click();  
			
			System.out.println("Successfully created a new challenge!"); 
			waitforelements(10000);
			
		}		
	
		private void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
}
