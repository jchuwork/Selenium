package strangestringsCPStaging;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.*;

import static org.junit.Assert.*;
import static org.junit.ComparisonFailure.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class StrangeStrings {

	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		ProfilesIni profile = new ProfilesIni();  
		FirefoxProfile myprofile = profile.getProfile("CPStagingFFProfile");
		 
		driver = new FirefoxDriver(myprofile);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		   driver.quit();
		   
	}

	@Test
	public void test() {
	
		    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		    String arrayOfStrings[] = {"Ω≈ç√∫˜µ≤≥÷åß∂ƒ©˙∆˚¬…æœ∑´®†¥¨ˆøπ“‘¡™£¢∞§¶•ªº–≠¸˛Ç◊ı˜Â¯˘¿ÅÍÎÏ˝ÓÔÒÚÆ☃Œ„´‰ˇÁ¨ˆØ∏”’`⁄€‹›ﬁﬂ‡°·‚—±", 
					"⁰⁴⁵₀₁₂⁰⁴⁵₀₁₂",
					"0xabad1dea", 
					//"田中さんにあげて下さいパーティーへ行かないか和製漢語部落格사회과학원어학연구소社會科學院語學研究所울란바토르𠜎𠜱𠝹𠱓𠱸𠲖𠳏", 
					",。・:*:・゜’( ☻ ω ☻ )。・:*:・゜’(╯°□°）╯︵ ┻━┻)(ﾉಥ益ಥ）ﾉ﻿ ┻━┻", 
					//"💘 💝 💟",
					"١٢٣",  
					"ملة بولندا، الإطلاق عل إيو.בְּרֵאשִׁית, בָּרָא אֱלֹהִים, אֵת הַשָּׁמַיִם, וְאֵת הָאָרֶץ", 
					"Ṱ̺̺̕o͞ ̷i̲̬͇̪͙n̝̗͕v̟̜̘̦͟o̶̙̰̠k",
					"⁧ ␢␡", 
					"˙ɐnbᴉlɐ ɐuƃɐɯ ǝɹolop", 
					//"𝕿𝖍𝖊 𝖖𝖚𝖎𝖈𝖐 𝖇𝖗𝖔𝖜𝖓 𝖋𝖔𝖝 𝖏𝖚𝖒𝖕𝖘 𝖔𝖛𝖊𝖗 𝖙𝖍𝖊 𝖑𝖆𝖟𝖞 𝖉𝖔𝖌", 
					"<script>alert(123)</script>", 
					"1;DROP TABLE users", 
					"--help", 
					"Kernel.exit(1)",
					"$HOME", 
					"() { 0; }; touch /tmp/blns.shellshock1.fail;", 
					"Powerلُلُصّبُلُلصّبُررً ॣ ॣh ॣ ॣ冗"
		    } ;
		
			driver.get("http://staging.devpost.com/opensesame/github");
			waitforelements(3000);
			driver.findElement(By.linkText("Log in")).click();
			
	        waitforelements(2000);
			
			driver.findElement(By.id("user_email")).sendKeys("jonathan.chu.cp@gmail.com");
			driver.findElement(By.id("user_password")).sendKeys("challenge2015");
			driver.findElement(By.name("commit")).click();
			System.out.println("Logging In Successfully on FF"); 
		
			waitforelements(1000);
			
			driver.findElement(By.linkText("Start a project")).click();
			driver.findElement(By.id("software_name")).sendKeys(timeStamp + "  Automated Selenium Project - FF");
			driver.findElement(By.id("software_name_save_button")).click(); 
			System.out.println("Adding a project to your portfolio.");  
			
			driver.findElement(By.id("software_tagline")).sendKeys("Tagline");
			System.out.println("Adding a tagline.");
			
			waitforelements(2000);  
					
			driver.findElement(By.id("software_description")).sendKeys("Description");
			System.out.println("Adding a description.");  
			
			waitforelements(2000);
			
			driver.findElement(By.id("software-save")).click();
															
			System.out.println("Successfully created a software project!"); 
			
			int i = 0;
			
			while (i < arrayOfStrings.length)	{
				
				driver.findElement(By.linkText("Edit project")).click();   
				
				driver.findElement(By.id("software_description")).clear();
				
				driver.findElement(By.id("software_description")).sendKeys(arrayOfStrings[i]);
				
				System.out.println(arrayOfStrings[i]);  
				
				i = i+1;  
				
				driver.findElement(By.id("software-save")).click();
				
				waitforelements(5000);
				
			}
			
			WebElement element = driver.findElement(By.id("global-nav-screen-name"));
			Actions action = new Actions(driver);
		    action.moveToElement(element).build().perform();
		    waitforelements(2000);
		    driver.findElement(By.linkText("Log out")).click();
			System.out.println("Email - Logged Out Successfully on FF"); 
			
			
			waitforelements(3000);
			
		}		
	

		private void waitforelements(int time) {
		
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException ie){
			
		}
		
		
	}
	
}
