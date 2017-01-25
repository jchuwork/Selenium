package MoatExam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.hamcrest.Matchers;
import static org.junit.Assert.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MoatQuestion2 {

	
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
		
		    driver.get("https://www.moat.com");    //Opens Moat Homepage
			
			String time1 = driver.findElement(By.xpath(".//*[@id='search-bar']/div/div[2]/ul/li[1]/h4")).getText();
			String time2 = driver.findElement(By.xpath(".//*[@id='search-bar']/div/div[2]/ul/li[2]/h4")).getText();
			String time3 = driver.findElement(By.xpath(".//*[@id='search-bar']/div/div[2]/ul/li[3]/h4")).getText();
			String time4 = driver.findElement(By.xpath(".//*[@id='search-bar']/div/div[2]/ul/li[4]/h4")).getText();
			
			int first = Integer.parseInt(time1.split(" ")[0]);  //strip out the time and convert to integer so we can compare
			int second = Integer.parseInt(time2.split(" ")[0]);
			int third = Integer.parseInt(time3.split(" ")[0]);
			int fourth = Integer.parseInt(time4.split(" ")[0]);
			
	        System.out.println("1st ad time: " + first);
	        System.out.println("2nd ad time: " + second);
	        System.out.println("3rd ad time: " + third);
	        System.out.println("4th ad time: " + fourth);
			
            assertThat(first, Matchers.lessThan(30));  //check that each ad's time is less than 30 minutes
            assertThat(second, Matchers.lessThan(30));
            assertThat(third, Matchers.lessThan(30));
            assertThat(fourth, Matchers.lessThan(30));
		
			System.out.println("All recent ads are less than 30 minutes old!");  //If it makes it past the assertions, then it's a success.
		
		}		
	
	
}
