package MoatExam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class MoatQuestion1 {

	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/jchubacca/Documents/workspace/Webdriver 3/chromedriver");
	    
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
		
		    String status;
		    WebElement first, second, third;
		    
		    int count = 0;
		    List<String> brands = new ArrayList<String>();  //creating an array to store brands from previous screens
		    driver.get("https://www.moat.com");    //Opens Moat Homepage
		    
		    while (count < 10)    //this loop probably isn't the ideal way to look for randoms but I set it at refreshing the page 10 times
			
		    {
		    	
			first = driver.findElement(By.xpath(".//*[@id='search-bar']/div/div[1]/span/a[1]"));  //grab 1st link
			second = driver.findElement(By.xpath(".//*[@id='search-bar']/div/div[1]/span/a[2]")); //grab 2nd link
			third = driver.findElement(By.xpath(".//*[@id='search-bar']/div/div[1]/span/a[3]"));  //grab 3rd link
						
	        status = URLStatus(first.getAttribute("href"));  //grab the url of the 1st link
	        assertEquals(status, "OK");    //asserting that the link is responding with a 200
	        System.out.println(first.getText() + status);  
	        status = URLStatus(second.getAttribute("href"));  //grab the url of the 2nd link
	        assertEquals(status, "OK");   //asserting that the link is responding with a 200
	        System.out.println(second.getText() + status);
	        status = URLStatus(third.getAttribute("href"));  //grab the url of the 3rd link
	        assertEquals(status, "OK");   //asserting that the link is responding with a 200
	        System.out.println(third.getText() + status);  
	        
	        assertThat("Brand duplicate found", brands, not(hasItem(first.getText())));  //checking that the brand doesn't exist already in the array.  This solution is not perfect depending on how many brands you have.  
	        
	        brands.add(first.getText());  //adding the brand to the array before refreshing the page.
	        brands.add(second.getText());
	        brands.add(third.getText());
	        
	        System.out.println(brands);  //just a check to see the array is growing correctly.  
	       
		    driver.navigate().refresh();   //refreshes the page so we get the brands.
		    
	        count = count + 1;
	        
		    }
	        
	        System.out.println("Sample brands are random and links are working!");  //If it makes it this far passing the assertions.  
	        
		}		
	
	    public String URLStatus (String incoming) {    //method is needed to check the status of the URL.  
           
	    	String response = "";
	    	
	    	try {
	    	URL url = new URL(incoming);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			
			    connection.connect();
			    response = connection.getResponseMessage();	        
			    connection.disconnect();
			    return response;
           }
	 
			catch(Exception e) {
				
				return response;
			}
			
					
	    } 
	

		
	
}
