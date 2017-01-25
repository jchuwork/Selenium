package MoatExam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MoatQuestion4 {

	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/portia/Documents/workspace/Webdriver/chromedriver");
	    
	    ChromeOptions options = new ChromeOptions(); 
	    options.addArguments("user-data-dir=/Users/portia/Library/Application Support/Google/Chrome/SeleniumProfile");
	    driver = new ChromeDriver(options);
	 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		   driver.quit();
		   
	}

	@Test
	public void test() {
		
		    driver.get("https://moat.com/advertiser/starbucks?report_type=display");   //opening any search results 
		   
		    WebElement element = driver.findElement(By.className("img-holder"));  //going to the first ad available
			Actions action = new Actions(driver);
		    action.moveToElement(element).build().perform();   //simulating mouse hover so the ad expands
		    waitforelements(2000);
		 
		    driver.findElement(By.linkText("Creative")).click();  //clicking on the Creative share
		    waitforelements(2000);
		    
		    WebElement shareURL = driver.findElement(By.xpath(".//*[@id='popup-template']/div/div[1]/div[2]/table/tbody/tr[5]/td[2]/div/div/input"));  //finding the URL
		    
		    System.out.println("Copied the shared URL: " +  shareURL.getAttribute("value"));
		    
		    waitforelements(2000);
		    
		    driver.get(shareURL.getAttribute("value"));  //driver going to copied URL.  
		    
		    System.out.println("Successfully went to the copied URL!");
		
		}		
	

		private void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
}
