package MLB.test;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import junit.framework.TestCase;

public class EbayTest 
    extends TestCase
{

	public WebDriver driver;
	EbayFlow ebay; 
	
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "/Users/jchubacca/Documents/workspace/Webdriver/chromedriver");
	    driver = new ChromeDriver();
	    ebay = new EbayFlow(driver);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://www.ebay.com/");
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();   
			   
	}

	@Test
	public void test() {
		    
		    ebay.enterSearchInput("Electric Guitar");
		    ebay.clickSearchButton();
			ebay.clickFirstResult();
		    
		    System.out.println("Price of the first result: " + ebay.getPrice());  //Price of the item on the console
		}		
}

