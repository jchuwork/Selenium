package createsoftwareprojectCPStaging;

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
import org.openqa.selenium.interactions.Actions;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChromeCreateSoftwareProject {

	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		
	        System.setProperty("webdriver.chrome.driver", "/Users/jchuwork/Documents/workspace/Webdriver/chromedriver");
		    
   		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("user-data-dir=/Users/jchuwork/Library/Application Support/Google/Chrome/SeleniumProfile");
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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("user_email")).sendKeys("jonathan.chu.cp@gmail.com");
	        driver.findElement(By.id("user_password")).sendKeys("challenge2015");
		driver.findElement(By.id("submit-form")).click();
		System.out.println("Logging In Successfully on FF"); 
		
		driver.get("https://staging.devpost.com/software");
		driver.findElement(By.id("add-your-software")).click();
		driver.findElement(By.id("software_name")).sendKeys(timeStamp + "  Automated Selenium Project - FF");
		driver.findElement(By.id("software_name_save_button")).click();
		driver.getTitle();
		System.out.println(driver.getTitle());
		assertEquals("Devpost", driver.getTitle());  //assertion page title test
			
		System.out.println("Adding a project to your portfolio.");  
		
		driver.findElement(By.id("software_tagline")).sendKeys("Tagline");
		System.out.println("Adding a tagline.");
	
		driver.findElement(By.id("email")).sendKeys("jonathan.chu.cp+3@gmail.com");
		driver.findElement(By.className("attach-on-right")).click(); 
		driver.findElement(By.id("software_description")).sendKeys("Description");
		System.out.println("Adding a description.");  
			
		driver.findElement(By.id("s2id_autogen1")).sendKeys("selenium");
		waitforelements(1000);  //Need this pause so the enter key works to select the skill
		driver.findElement(By.id("s2id_autogen1")).sendKeys(Keys.RETURN);
		System.out.println("Adding a skill.");  
			
		driver.findElement(By.id("software_urls_attributes_0_url")).sendKeys("http://staging.devpost.com");
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
			
			
		driver.findElement(By.id("software-save")).click();
		driver.findElement(By.className("option-no")).click();
		WebElement element = driver.findElement(By.id("global-nav-user-dropdown"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		waitforelements(2000);
		driver.findElement(By.linkText("Log out")).click();
		System.out.println("Logged Out Successfully on Chrome"); 
		    
		waitforelements(3000);     
															
		System.out.println("Successfully created a software project!"); 
			
		}		
	

		private void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
				
	}
	
}
