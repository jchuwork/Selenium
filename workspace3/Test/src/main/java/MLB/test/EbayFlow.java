package MLB.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayFlow {

	
	WebDriver driver;
	
	By searchinput = By.id("gh-ac");
    By searchbutton = By.id("gh-btn");
    By firstresult = By.cssSelector("#ListViewInner li.sresult a");  //grabbing the first item li with class sresult that falls under ListViewInner.  I could have also used class = VIP, and it would grab the first one it came across.   
    By price = By.id("prcIsum");
	
    public EbayFlow (WebDriver driver) {
    	
    	this.driver = driver;
    }
	
	public void enterSearchInput(String searchterms) {
		
			WebElement element = driver.findElement(searchinput);  
			
			element.sendKeys(searchterms);  //entering the search input
	}
	
	public void clickSearchButton() {
			
		    WebElement element = driver.findElement(searchbutton);

		    element.click();  //clicking search button
	}
	
	public void clickFirstResult() {
		
		    WebElement element = driver.findElement(firstresult);
		    
		    element.click();  //clicking the first result
		    
		}		
	
	public String getPrice() {
		
	       String amount = driver.findElement(price).getText();
		
		   return amount;   //returning the amount of the item
	}

	
}

