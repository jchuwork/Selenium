package MLB.test;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import junit.framework.TestCase;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)  //so the tests run in order by name
public class GmailTest 
    extends TestCase
{

	public WebDriver driver;
	GmailFlow gmail; 
	String myemail = "jonathan.chu.test@gmail.com";
	String mypass = "automationtest";
	String falsepassword = "blahblah";
	String email;
	String myimageURL = "url(\"https://lh3.googleusercontent.com/-VC0_51Envqw/AAAAAAAAAAI/AAAAAAAAAAA/ADPlhfKlR9t8hS9FM57bcunFnC_YU1PrVQ/s32-c-mo/photo.jpg\")";
	String image;
	Boolean error;
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "/Users/jchubacca/Documents/workspace/Webdriver/chromedriver");
	    driver = new ChromeDriver();
	    gmail = new GmailFlow(driver);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://www.gmail.com/");
		
	}

	@After
	public void tearDown() throws Exception {
		
			driver.quit();
			   
	}

	@Test
	public void test() {
		    
		gmail.enterEmail(myemail);	
		gmail.clickNext();
		gmail.enterPassword(mypass);
	    gmail.clickSignin();
	    
	    email = gmail.getUser();
	    
	    assertEquals(myemail, email);  //Assert that the email address from the Gmail icon matches the email address entered.  
	    System.out.println(email + " matches " + myemail);
	     
	}		
		
	@Test
	
	public void test2() {
		
		gmail.enterEmail(myemail);	
		gmail.clickNext();
		gmail.enterPassword(mypass);
	    gmail.clickSignin();
	    
	    image = gmail.getImageURL();
	    
	    assertEquals(myimageURL, image);  //Assert that the image matches the image saved during profile creation  
	    System.out.println(image + " matches " + myimageURL);
		
	}
	
	@Test
	public void testneg1() {  //Negative test case 1 - Putting a false password and checking if an error message shows.  
		    
		gmail.enterEmail(myemail);	
		gmail.clickNext();
		gmail.enterPassword(falsepassword);
	    gmail.clickSignin();
	    
	    error = gmail.existsErrorMsg();
	    
	    assertTrue(error);   //Assert that error is displayed.  
	     
	}	
	
	@Test
	public void testneg2() {  //Negative test case 2 - Putting a valid password and checking that the error message does NOT show.  
		    
		gmail.enterEmail(myemail);	
		gmail.clickNext();
		gmail.enterPassword(mypass);
	    gmail.clickSignin();
	    
	    error = gmail.existsErrorMsg();
	    assertFalse(error);   //Assert that the error does not display.  
	}	
	
	
			
}
