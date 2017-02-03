package MLB.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailFlow {

	WebDriver driver;
	By myemail = By.id("Email");
	By next = By.id("next");
    By password = By.id("Passwd");
    By signin =By.id("signIn");
    By userdata = By.cssSelector("div.gb_wb");
    By icon = By.cssSelector("span.gb_9a.gbii");
    By error = By.className("error-msg");
	
    public GmailFlow (WebDriver driver) {
    	
    	this.driver = driver;
    }
    
    
    public void enterEmail(String email) {
    	
    	WebElement element  = driver.findElement(myemail);	
    	element.sendKeys(email);
    	
    }
	
    public void clickNext() {
    	
    	WebElement element = driver.findElement(next);
    	element.click();
    	
    }
    
    public void enterPassword (String pass)   {
    	
        WebElement element = driver.findElement(password);
        element.sendKeys(pass);
        
    }

	public void clickSignin () {
		
		WebElement element = driver.findElement(signin);
		element.click();
		
	}
	
	public void clickIcon() {
		
		WebElement element = driver.findElement(icon);
		
		element.click();
	}
	
	public String getUser() {
	
		clickIcon();  //Need to click the icon so we can grab the User's email address.  
		String email = driver.findElement(userdata).getText();
				
		return email;
		
	}
	
	public String getImageURL() {
		
		 String image = driver.findElement(By.className("gbii")).getCssValue("background-image");
		
		 return image;
	}
	
	public boolean existsErrorMsg() {
		
		boolean message = driver.findElements(error).size() > 0;
		
		return message;
	}
	
}



