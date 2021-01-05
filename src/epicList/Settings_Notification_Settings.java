package epicList;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import epicList_Integrated.Utility;

public class Settings_Notification_Settings {

	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings_Notification_Settings");
	
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
	
	@Test(priority=28)
	public void Notification_Settings_Method_open() throws Exception
		{
			
			Thread.sleep(3000);
			//Enter the URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"notificationSettings");
			
			Thread.sleep(3000);
			
			
			
			Thread.sleep(3000);
			
			WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
			//Check weather the notification Settings page is loaded or not
			if(driver.findElement(By.xpath("//a[.='Notification Settings']")).getText().equalsIgnoreCase("Notification Settings"))
			{
				test.log(LogStatus.PASS, "Notification Settings page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Notification Settings page loaded fail");
			}

			Thread.sleep(3000);

		}	
		
	@Test(priority=29)
	public void Notification_Settings_Method_edit() throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(5000);
			//Clear the Discount amount
			driver.findElement(By.name("discountAmount")).clear();
			//Enter the required Discount amount
			driver.findElement(By.name("discountAmount")).sendKeys("125");
			
			Thread.sleep(2000);
			//Clear the Void amount
			driver.findElement(By.name("voidAmount")).clear();
			//Enter the required Void amount
			driver.findElement(By.name("voidAmount")).sendKeys("110");
			
			Thread.sleep(2000);
			//Clear the Max No Cash Drawer Accessed For No Sale 
			driver.findElement(By.name("noSale")).clear();
			//Enter the required Max No Cash Drawer Accessed For No Sale 
			driver.findElement(By.name("noSale")).sendKeys("2");
			
			Thread.sleep(3000);
			//Check weather the Discount mail check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.discount.enableEmail']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[1]/div/textarea")).sendKeys("test1@mail.com");
				
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[1]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[1]/div/textarea")).sendKeys("test1@mail.com");
			
			
			}
			
			//Check weather the Discount text check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.discount.enableText']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[2]/div/textarea")).sendKeys("7485961425");
				
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[2]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[2]/div/textarea")).sendKeys("7485961425");
				
			}
			
			
			//Check weather the Void mail check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.void.enableEmail']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[1]/div/textarea")).sendKeys("test2@mail.com");
					
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[1]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[1]/div/textarea")).sendKeys("test2@mail.com");
				
			}
			
			//Check weather the Void text check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.void.enableText']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[2]/div/textarea")).sendKeys("7485961426");
				
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[2]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[2]/div/textarea")).sendKeys("7485961426");
				
			}
			
			//Check weather the Max No Cash Drawer Accessed For No Sale mail check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.noSale.enableEmail']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[1]/div/textarea")).sendKeys("test3@mail.com");
					
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[1]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[1]/div/textarea")).sendKeys("test3@mail.com");
				
			}
			
			//Check weather the Max No Cash Drawer Accessed For No Sale text check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.noSale.enableText']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[2]/div/textarea")).sendKeys("7485961427");
				
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[2]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[2]/div/textarea")).sendKeys("7485961427");
				
			}
			
			//Check weather the Time Clock mail check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.timeClock.enableEmail']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[1]/div/textarea")).sendKeys("test4@mail.com");
					
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[1]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[1]/div/textarea")).sendKeys("test4@mail.com");
				
			}
			
			//Check weather the Time Clock text check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.timeClock.enableText']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[2]/div/textarea")).sendKeys("7485961428");
				
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[2]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[2]/div/textarea")).sendKeys("7485961428");
				
			}
			
			//Check weather the Daily KPI mail check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.dailyKPI.enableEmail']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[1]/div/textarea")).sendKeys("test5@mail.com");
					
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[1]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[1]/div/textarea")).sendKeys("test5@mail.com");
				
			}
			
			//Check weather the Daily KPI text check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.dailyKPI.enableText']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[2]/div/textarea")).sendKeys("7485961429");
				
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[2]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[2]/div/textarea")).sendKeys("7485961429");
				
			}
			
			//Check weather the End Of the Day Alert  mail check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.closeTheDay.enableEmail']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[1]/div/textarea")).sendKeys("test6@mail.com");
					
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[1]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[1]/div/textarea")).sendKeys("test6@mail.com");
				
			}
			
			//Check weather the End Of the Day Alert text check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.closeTheDay.enableText']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[2]/div/textarea")).sendKeys("7485961430");
				
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[2]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[2]/div/textarea")).sendKeys("7485961430");
				
			}
			
			
			Thread.sleep(1000);
			//CLear the first text are
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[10]/div[1]/div/textarea")).clear();
			//Enter the required test mail
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[10]/div[1]/div/textarea")).sendKeys("test7@mail.com");
			
		
		
		//Check weather the End Of the Day Alert text check box is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.waitlist.enableText']")).isSelected())
		{

			Thread.sleep(1000);
			//CLear the first text are
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[10]/div[2]/div/textarea")).clear();
			//Enter the required test mail
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[10]/div[2]/div/textarea")).sendKeys("7485961431");
			
		}
		else
		{

			Thread.sleep(1000);
			//Enable or disable the first email check box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[10]/div[2]/input")).click();
			
			Thread.sleep(1000);
			//CLear the first text are
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[10]/div[2]/div/textarea")).clear();
			//Enter the required test mail
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[10]/div[2]/div/textarea")).sendKeys("7485961431");
			
		}
			
			Thread.sleep(3000);
			//Click the update button
			driver.findElement(By.xpath("//span[.='Update']")).click();
			Thread.sleep(3000);
			
			//Check weather the notification setting is updated or not  Notification Settings updated successfully
			if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Notification Settings updated successfully"))
			{
				test.log(LogStatus.PASS, "Notification Settings updated successfully");
			}
			
			else{
				test.log(LogStatus.FAIL, "Notification Settings updated fail");
			}
			Thread.sleep(5000);watchTutorial();Thread.sleep(5000);
		}


}
