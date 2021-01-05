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

public class Settings_Store_Hours {


	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings_Store_Hours");
	
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

	@Test(priority=7)
	public void Store_Hours_Setting_Method_pageopen() throws Exception
	{

		
		//Enter the URl
		Thread.sleep(3000);
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"timings");
		
		Thread.sleep(3000);

		
		//Check weather the Store Hours page is loaded or not
		if(driver.findElement(By.xpath("//a[.='Store Hours']")).getText().equalsIgnoreCase("Store Hours"))
		{
			test.log(LogStatus.PASS, "Store Hours page loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Hours page loaded fail");
		}

		Thread.sleep(3000);

	}	
	
	@Test(priority=8)
	public void StoreHours_Setting_Method_process() throws Exception
	{

		Thread.sleep(2000);
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.HOME);
		html.sendKeys(Keys.HOME);
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(2000);

		if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[2]/div/input")).isSelected())
		{}
		else
		{
			driver.findElement(By.xpath("//form[@name='storeCreation']/div[2]/div/input")).click();
			
			//Click the Yes button
			driver.findElement(By.partialLinkText("Yes")).click();
		}
		
		
		Thread.sleep(2000);
		//Click Reset button
		driver.findElement(By.xpath("//a[.='Reset']")).click();
		Thread.sleep(2000);
		
		
		// THE BELOW FOR SUNDAY
		//Click the Up Hour button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a/span")).click();
									     
		//Click the Up minute button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[1]/div/table/tbody/tr[1]/td[3]/a/span")).click();
										
		//Click the Up Hour button of End time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of End Time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[2]/div/table/tbody/tr[1]/td[3]/a/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}


		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
										
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}
		}
		
		
		
		// THE BELOW FOR MONDAY
		//Click the Up Hour button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a/span")).click();
										
		//Click the Up minute button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[1]/div/table/tbody/tr[1]/td[3]/a/span")).click();
										
		//Click the Up Hour button of End time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of End Time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[3]/a/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}


		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
										
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}
		}
		
		
		
		
		// THE BELOW FOR TUESDAY
		//Click the Up Hour button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[1]/div/table/tbody/tr[1]/td[3]/a/span")).click();
										
		//Click the Up Hour button of End time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of End Time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[2]/div/table/tbody/tr[1]/td[3]/a/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Options
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}


		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
										
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}
		}
		
		
		
		// THE BELOW FOR WEDNESDAY
		//Click the Up Hour button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[1]/div/table/tbody/tr[1]/td[3]/a/span")).click();
										
		//Click the Up Hour button of End time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of End Time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[2]/div/table/tbody/tr[1]/td[3]/a/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}


		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
										
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}
		}
		
		
		
		// THE BELOW FOR THURSDAY
		//Click the Up Hour button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[1]/div/table/tbody/tr[1]/td[3]/a/span")).click();
										
		//Click the Up Hour button of End time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of End Time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[2]/div/table/tbody/tr[1]/td[3]/a/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}


		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
										
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}
		}
		
		
		// THE BELOW FOR FRIDAY
		//Click the Up Hour button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[1]/div/table/tbody/tr[1]/td[3]/a/span")).click();
										
		//Click the Up Hour button of End time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of End Time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[2]/div/table/tbody/tr[1]/td[3]/a/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		
			}


		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
										
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		
			}
		}
		
		// THE BELOW FOR SATURDAY
		//Click the Up Hour button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[1]/div/table/tbody/tr[1]/td[3]/a/span")).click();
										
		//Click the Up Hour button of End time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of End Time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[2]/div/table/tbody/tr[1]/td[3]/a/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}


		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
										
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		
				//form[@name='storeCreation']
			}
		}
		
			Thread.sleep(3000);
		//Click the update button
		driver.findElement(By.xpath("//span[.='Update']")).click();
		
		Thread.sleep(5000);watchTutorial();Thread.sleep(5000);
	}

	@Test(priority=9)
	public void StoreHours_DayPart() throws Exception
	{
		//Enter the URl
		Thread.sleep(3000);
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"timings");
		
		Thread.sleep(3000);
/*		//Check Store Information page opened or not
		if(driver.findElement(By.xpath("//a[.='Store Information']")).getText().equalsIgnoreCase("Store Information"))
		{
			test.log(LogStatus.PASS, "Store Information page loaded Successfully for Day part");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Information page loaded Failed for Day part");
		}
		 
		Thread.sleep(3000);*/
		
		//Click the Store Hours Option
		//driver.findElement(By.xpath("//span[@id='timing']")).click();
		Thread.sleep(3000);
		
		//Check weather the Store Hours page is loaded or not
		if(driver.findElement(By.xpath("//a[.='Store Hours']")).getText().equalsIgnoreCase("Store Hours"))
		{
			test.log(LogStatus.PASS, "Store Hours page loaded successfully for Day part");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Hours page loaded fail for Day part");
		}

		
		Thread.sleep(2000);
	//Click Day Part option 
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/span/scrollable-tabset/div/div/div/ul/li[2]/a/uib-tab-heading/span")).click();
		
	try		
	{
	Thread.sleep(4000);
	//Click remove button
	if(driver.findElement(By.cssSelector("i.fa.fa-trash-o")).isDisplayed())
	{
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[3]/a/i")).click();
	Thread.sleep(2000);
	//Click yes button
	driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
	}
	else
	{
		
	}
	}
	catch (Exception e)		
	{
	Thread.sleep(3000);
	//Click ADD button to create meals type to update
	driver.findElement(By.cssSelector("button.btn.btn-medium.ng-binding")).click();
	Thread.sleep(3000);
	//Clear the day part meal box
	driver.findElement(By.name("mealType")).clear();
	//Enter the day part meal box
	driver.findElement(By.name("mealType")).sendKeys("Food");
	Thread.sleep(3000);
	//Click the Up Hour button of Start time
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a/span")).click();
	Thread.sleep(2000);
	//Click the Up minute button of Start time
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[1]/div/table/tbody/tr[1]/td[3]/a/span")).click();
	Thread.sleep(3000);							
	//Click the Up Hour button of End time
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a/span")).click();
	
	//Click the Up minute button of End Time
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[2]/div/table/tbody/tr[1]/td[3]/a/span")).click();
	Thread.sleep(2000);
	//Check it is AM or PM in the Start Time Option
	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
	{
		Thread.sleep(2000);
		//Check it is AM or PM in the End Time Option
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}

	}
	else
	{
		Thread.sleep(2000);
		//Click the AM or PM option in the Start Time
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
									
		Thread.sleep(2000);
		//Check it is AM or PM in the End Time Option
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
	

		}
		Thread.sleep(3000);
		//Click the update button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		//Check Store Information page opened or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Shift Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Shift Saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Shift Saved Failed");
		}
		Thread.sleep(4000);
		//Clear the day part meal box
		driver.findElement(By.name("mealType")).clear();
		//Enter the day part meal box
		driver.findElement(By.name("mealType")).sendKeys("Foodie");
		
		Thread.sleep(4000);
		//Click remove button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[3]/a/i")).click();
		
		Thread.sleep(2000);
		//Click yes button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();	
		Thread.sleep(3000);
		//Check Store Information page opened or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Shift Removed Successfully"))
		{
			test.log(LogStatus.PASS, "Shift Removed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Shift Removed Failed");
		}
	}}	
	
	}
}
