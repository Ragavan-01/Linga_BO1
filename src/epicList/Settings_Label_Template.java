package epicList;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import epicList_Integrated.Utility;

public class Settings_Label_Template {

	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Label_Template");
	
	float unknownValue = 00;
	
	@AfterClass
	public void flushTest() throws Exception
	{
		Thread.sleep(2000);
		rep.endTest(test);
		rep.flush();
	}
	
	@Test(priority=1)
	public void login() throws Exception
	{
		if(Utility.getProperty("Product").equalsIgnoreCase("UPOS"))
		{
			Thread.sleep(2000);
			//Call the chrome driver
			System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
			//Open the Chrome window
			driver = new ChromeDriver();
			//Wait for 30 seconds
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//Maximize the Chrome window
			driver.manage().window().maximize();
			Thread.sleep(1000);
			//Launch the URL
			driver.get(Utility.getProperty("appURL"));
			//Clear the text from the user name text box
			driver.findElement(By.name("emailId")).clear();
			//Enter the user name
			driver.findElement(By.name("emailId")).sendKeys(Utility.getProperty("userName"));
			Thread.sleep(1000);
			//Clear the password from the password text box
			driver.findElement(By.name("password")).clear();
			//Enter the password
			driver.findElement(By.name("password")).sendKeys(Utility.getProperty("password"));
			Thread.sleep(3000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
			//Click the login button
			driver.findElement(By.id("round1")).click();
			//Check if we logged in or not
			if(driver.findElement(By.xpath("//div[@id='navigation']/ul[1]/li/a")).getText().equalsIgnoreCase("My Stores"))
			{
				test.log(LogStatus.PASS, "User Logged in Successfully for Dealer Enterprise ");
			}
			else
			{
				test.log(LogStatus.FAIL, "User Logged in Failed for Dealer Enterprise ");
			}
			Thread.sleep(5000);
			//Click the refresh button 
			driver.findElement(By.cssSelector("button.btn.btn-sm.btn-primary")).click();
			
			Thread.sleep(2000);
			//Clear the search field 
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//Enter the search field 
		     driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Store"));
			
			//Click the Entered store Dashboard page
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[4]/div/div/div[2]/div/div[1]/a/h5")).click();
			
			//Check if we logged in or not
			if(driver.findElement(By.xpath("//span[.='Live Updates']")).getText().equalsIgnoreCase("Live Updates"))
			{
				test.log(LogStatus.PASS, "Dealer Store level Dashboard page loaded sucessfully ");
			}
			else
			{
				test.log(LogStatus.FAIL, "Dealer Store level Dashboard page loaded failed ");
			}
			Thread.sleep(5000);
	}
		
		
		else 
		
		{		
			Thread.sleep(2000);
			//Call the chrome driver
			System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
			//Open the Chrome window
			driver = new ChromeDriver();
			//Wait for 30 seconds
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//Maximize the Chrome window
			driver.manage().window().maximize();
			//Launch the URL
			driver.get(Utility.getProperty("appURL"));
			//Clear the text from the user name text box
			driver.findElement(By.name("txtusername")).clear();
			//Enter the user name
			driver.findElement(By.name("txtusername")).sendKeys(Utility.getProperty("userName"));
			//Clear the password from the password text box
			driver.findElement(By.name("txtpassword")).clear();
			//Enter the password
			driver.findElement(By.name("txtpassword")).sendKeys(Utility.getProperty("password"));
			Thread.sleep(4000);

			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		
			//Click the login button
			driver.findElement(By.name("submitlogin")).click();
			//Check if we logged in or not
			if(driver.findElement(By.xpath("//div[@id='navigation']/ul[1]/li/a")).getText().equalsIgnoreCase("My Stores"))
			{
				test.log(LogStatus.PASS, "User Logged in Successfully for Linga Enterprise ");
			}
			else
			{
				test.log(LogStatus.FAIL, "User Logged in Failed for Linga Enterprise ");
			}
			Thread.sleep(5000);
			//Click the refresh button 
			driver.findElement(By.cssSelector("button.btn.btn-sm.btn-primary")).click();
			
			Thread.sleep(2000);
			//Clear the search field 
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//Enter the search field 
		     driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Store"));
			
			//Click the Entered store Dashboard page
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[4]/div/div/div[2]/div/div[1]/a/h5")).click();
			
			//Check if we logged in or not
			if(driver.findElement(By.xpath("//span[.='Live Updates']")).getText().equalsIgnoreCase("Live Updates"))
			{
				test.log(LogStatus.PASS, "Linga Store level Dashboard page loaded sucessfully ");
			}
			else
			{
				test.log(LogStatus.FAIL, "Linga Store level Dashboard page loaded failed ");
			}
			Thread.sleep(5000);
	}	
		}
		
	@Test(priority=700)
	public void logout() throws Exception
	{
		if(Utility.getProperty("Product").equalsIgnoreCase("UPOS"))
		{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[1]/div[2]/div/div/div/div[4]/a/i"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
		//Wait for 30 seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Click on Logout button
		driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[1]/div[2]/div/div/div/div[4]/a/i")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		//Check whether user get logged out or not
		if(driver.findElement(By.xpath("//b[.='User Login']")).getText().equalsIgnoreCase("User Login"))
		{
	    	test.log(LogStatus.PASS, "User Logged out Successfully for Dealer App");
		}
		else
		{
			test.log(LogStatus.FAIL, "User Logged out Failed for Dealer App");
		}
		Thread.sleep(3000);
		//Close the Browser
		driver.close();
	}
	else
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[1]/div[2]/div/div/div/div[4]/a/i"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
		//Wait for 30 seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Click on Logout button
		driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[1]/div[2]/div/div/div/div[4]/a/i")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		//Check whether user get logged out or not
		if(driver.findElement(By.xpath("//div[@id='x-content-band-1']/div/div[2]/h2")).getText().equalsIgnoreCase("Account Login"))
		{
	    	test.log(LogStatus.PASS, "User Logged out Successfully LingaPOs");
		}
		else
		{
			test.log(LogStatus.FAIL, "User Logged out Failed LingaPos");
		}
		Thread.sleep(3000);
		//Close the Browser
		driver.close();
	}
	}

	@Test(priority=3, enabled=false)
	public void watchTutorial() throws Exception
	{
		Thread.sleep(2000);
		//Click the Watch Tutorial Option
		driver.findElement(By.xpath("//span[.='Watch Tutorial']")).click();
		WebElement iframe = driver.findElement(By.xpath("//div[@class='modal-content']/span/iframe"));
		driver.switchTo().frame(iframe);
		Thread.sleep(3500);
		try
		{
			if(driver.findElement(By.xpath("//button/div[.='Watch later']")).isDisplayed()&&driver.findElement(By.xpath("//button/div[.='Share']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Watch Tutorial Video Played Well");
				Thread.sleep(2500);
			}
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Watch Tutorial Video not Played");
		}
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		//Click the Close button
		driver.findElement(By.xpath("//span[.='x' and @title='close']")).click();
	}
	
	@Test(priority=35,enabled = true)
	public void Label_Template_method_open_Label_Template() throws Exception
	{
/*		//Click the Settings option
		driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[5]/a/span[1]")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Printer Configuration']"));
		//Scroll the page till the Printer Configuration option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Store Option		
		driver.findElement(By.xpath("//span[.='Printer Configuration']")).click();*/
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"labelTemplate");
		Thread.sleep(5000);		
		//Click Right Home arrow button
		//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/scrollable-tabset/div/button[2]")).click();
/*		driver.findElement(By.xpath("//div[@class='ui-tabs-scrollable']/button[2]")).click();
		driver.findElement(By.xpath("//div[@class='ui-tabs-scrollable']/button[2]")).click();*/

		//Check Label Template page opened or not
		if(driver.findElement(By.xpath("//a[.='Label Template']")).getText().equalsIgnoreCase("Label Template"))
		{
			test.log(LogStatus.PASS, "Label Template page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Label Template page loaded Failed");
		}
		Thread.sleep(3000);
	}	
		
	@Test(priority=36,enabled = true)
	public void Label_Template_method_update_Label_Template() throws Exception
	{
		Thread.sleep(5000);
		Select template = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.position']")));
		template.selectByVisibleText("Template#0");
	
		//Clear the Width Field
		driver.findElement(By.xpath("//input[@ng-model='settings.width']")).clear();
		//Enter the required Width Field
		driver.findElement(By.xpath("//input[@ng-model='settings.width']")).sendKeys("3");
		
		
		//Clear the Height field
		driver.findElement(By.xpath("//input[@ng-model='settings.height']")).clear();
		//Enter the required Height field
		driver.findElement(By.xpath("//input[@ng-model='settings.height']")).sendKeys("3");
				
		Thread.sleep(3000);
		Select headerFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeH']")));
		headerFontSize.selectByVisibleText("2 width");
		
		Thread.sleep(3000);
		Select customerFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeC']")));
		customerFontSize.selectByVisibleText("Normal");
		
		//Scroll the web page
	    for(int i=1; i <= 10; i++)
	    {
	    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	    }
		Thread.sleep(3000);
		Select menuFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeMenu']")));
		menuFontSize.selectByVisibleText("Normal");
		
		Thread.sleep(3000);
		Select modifierFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeM']")));
		modifierFontSize.selectByVisibleText("Normal");
		
		Thread.sleep(2000);
		Select FontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSize']")));
		FontSize.selectByVisibleText("2 width");
			
		//Check Whether the Autocut is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.enableAutoCut']")).isSelected())
		{
			
		}
		else
		{
			Thread.sleep(3000);
			//Check whether the Autocut is enabled or not
			driver.findElement(By.xpath("//input[@ng-model='settings.enableAutoCut']/../span")).click();
		}
		
		Thread.sleep(3000);
		//Click the update button
		driver.findElement(By.xpath("//button[@id='UpdateLabelT']")).click();
		
		Thread.sleep(3000);
		//Check weather the new Label Template updated or not
				if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Delivery label template saved successfully"))
				{
					test.log(LogStatus.PASS, "Label template Updated successfully for Template#0");
				}
				else
				{
					test.log(LogStatus.FAIL, "Label template Updated fail for Template#0");
				}
				Thread.sleep(3000);
							
		
	}
	
	@Test(priority=37,enabled = true)
	public void Label_Template_method_update_Label_Template1() throws Exception
	{
		Thread.sleep(5000);
		Select template = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.position']")));
		template.selectByVisibleText("Template#1");
	
		//Clear the Width Field
		driver.findElement(By.xpath("//input[@ng-model='settings.width']")).clear();
		//Enter the required Width Field
		driver.findElement(By.xpath("//input[@ng-model='settings.width']")).sendKeys("2.5");
		
		
		//Clear the Height field
		driver.findElement(By.xpath("//input[@ng-model='settings.height']")).clear();
		//Enter the required Height field
		driver.findElement(By.xpath("//input[@ng-model='settings.height']")).sendKeys("2");
				
		Thread.sleep(2000);
		Select headerFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeH']")));
		headerFontSize.selectByVisibleText("Normal");
		
		Thread.sleep(2000);
		Select customerFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeC']")));
		customerFontSize.selectByVisibleText("Normal");
		
		Thread.sleep(2000);
		Select menuFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeMenu']")));
		menuFontSize.selectByVisibleText("Normal");
		
		Thread.sleep(2000);
		Select modifierFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeM']")));
		modifierFontSize.selectByVisibleText("Normal");
		
		//Scroll the web page
	    for(int i=1; i <= 10; i++)
	    {
	    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	    }
	    
		Thread.sleep(2000);
		Select addressFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeA']")));
		addressFontSize.selectByVisibleText("Normal");
		
		Thread.sleep(2000);
		Select deliveryNoteFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeH']")));
		deliveryNoteFontSize.selectByVisibleText("Normal");
		
		//Check Whether the Autocut is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.enableAutoCut']")).isSelected())
		{
			
		}
		else
		{
			Thread.sleep(3000);
			//Check whether the Autocut is enabled or not
			driver.findElement(By.xpath("//input[@ng-model='settings.enableAutoCut']/../span")).click();
		}
		
		Thread.sleep(5000);
		//Click the update button
		driver.findElement(By.xpath("//button[@id='UpdateLabelT']")).click();
		
		
		Thread.sleep(4000);
		//Check weather the new Label Template updated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Delivery label template saved successfully"))
		{
			test.log(LogStatus.PASS, "Label template Updated successfully for Template#1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Label template Updated fail for Template#1");
		}
		Thread.sleep(3000);
		
				
	}
	
	@Test(priority=38,enabled = true)
	public void Label_Template_method_update_Label_Template2() throws Exception
	{
		Thread.sleep(5000);
		Select template = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.position']")));
		template.selectByVisibleText("Template#2");
	
		//Clear the Width Field
		driver.findElement(By.xpath("//input[@ng-model='settings.width']")).clear();
		//Enter the required Width Field
		driver.findElement(By.xpath("//input[@ng-model='settings.width']")).sendKeys("2.5");
		
		
		//Clear the Height field
		driver.findElement(By.xpath("//input[@ng-model='settings.height']")).clear();
		//Enter the required Height field
		driver.findElement(By.xpath("//input[@ng-model='settings.height']")).sendKeys("3");
				
		Thread.sleep(2000);
		Select headerFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeH']")));
		headerFontSize.selectByVisibleText("2 width");
		
		Thread.sleep(2000);
		Select customerFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeC']")));
		customerFontSize.selectByVisibleText("2 width");
		
		Thread.sleep(2000);
		Select menuFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeMenu']")));
		menuFontSize.selectByVisibleText("Normal");
		
		Thread.sleep(2000);
		Select modifierFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeM']")));
		modifierFontSize.selectByVisibleText("Emphasis");
		
		 //Scroll the web page
	    for(int i=1; i <= 10; i++)
	    {
	    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	    }
	    
		
		Thread.sleep(2000);
		Select addressFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeA']")));
		addressFontSize.selectByVisibleText("Normal");
		
		Thread.sleep(2000);
		Select deliveryNoteFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeH']")));
		deliveryNoteFontSize.selectByVisibleText("2 width");
		
		//Check Whether the Autocut is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.enableAutoCut']")).isSelected())
		{
			
		}
		else
		{
			Thread.sleep(3000);
			//Check whether the Autocut is enabled or not
			driver.findElement(By.xpath("//input[@ng-model='settings.enableAutoCut']/../span")).click();
		}	
		
		Thread.sleep(5000);
		//Click the update button
		driver.findElement(By.xpath("//button[@id='UpdateLabelT']")).click();
		
		Thread.sleep(4000);
		//Check weather the new Label Template updated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Delivery label template saved successfully"))
		{
			test.log(LogStatus.PASS, "Label template Updated successfully for Template#2");
		}
		else
		{
			test.log(LogStatus.FAIL, "Label template Updated fail for Template#2");
		}
		Thread.sleep(3000);
		
				
	}
}
