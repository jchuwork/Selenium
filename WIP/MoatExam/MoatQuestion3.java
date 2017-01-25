package MoatExam;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MoatQuestion3 {

	
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
		
		    driver.get("https://moat.com/advertiser/arby-s?report_type=display");   //pull up search results page
		    waitforelements(3000);  //I added in a pause so the page can finish loading before looking for the Load More button.  
		    
		    String style = driver.findElement(By.id("paginate-button")).getAttribute("style");  //Looking for attribute style which doesn't exist at this point. 
		
		    WebElement loadmore = driver.findElement(By.id("paginate-button"));  //locate the Load More button

			while (!"display: none;".equals(style)) {   //It will continue clicking the Load More button until the style attribute displays "display: none;"
			      
			    	  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loadmore); 
			    	  waitforelements(3000);
			    	  style = driver.findElement(By.id("paginate-button")).getAttribute("style");
			  } 
	
			int count = driver.findElements(By.className("img-holder")).size();  //This counts all the creatives loaded on the page.
				
			String creativecount = driver.findElement(By.className("creative-count")).getText();   //grabbing the total creative count in the top left corner.
			creativecount = creativecount.replaceAll("[,]", "");   //stripping out commas
			int creative = Integer.parseInt(creativecount.split(" ")[0]);   //grabbing only the 1st word and casting it to Int so we can compare.
			
			assertEquals(creative, count);  //asserting comparing creative total against the count of creatives.
		
			System.out.println("Creative ad count matches the count.");  //If it makes it past the assertion, it will display the success message.
			
	}

		private void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
}
