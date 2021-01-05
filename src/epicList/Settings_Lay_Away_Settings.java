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

public class Settings_Lay_Away_Settings {


	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings_Lay_Away_Settings");
	
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
		Thread.sleep(3000);

		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		//Click the login button
		driver.findElement(By.name("submitlogin")).click();
		//Check if we logged in or not
		if(driver.findElement(By.xpath("//span[.='Live Updates']")).getText().equalsIgnoreCase("Live Updates"))
		{
			test.log(LogStatus.PASS, "User Logged in Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "User Logged in Failed");
		}
		Thread.sleep(5000);

	}
		
	@Test(priority=40)
	public void logout() throws InterruptedException
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
		Thread.sleep(5000);
	   //Check whether user get logged out or not
		if(driver.findElement(By.xpath("//div[@id='x-content-band-1']/div/div[2]/h2")).getText().equalsIgnoreCase("Account Login"))
		{
	    	test.log(LogStatus.PASS, "User Logged out Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "User Logged out Failed");
		}
		Thread.sleep(5000);
		//Close the Browser
		driver.close();
	}
	
	@Test(priority=2)
	public void open_Lay_Away_Settings() throws Exception
	{
		//Click the Settings option
		driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[5]/a/span[1]")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Store']"));
		//Scroll the page till the Store option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Store Option		
		driver.findElement(By.xpath("//span[.='Store']")).click();
		Thread.sleep(5000);
		//Check Store Information page opened or not
		if(driver.findElement(By.xpath("//a[.='Store Information']")).getText().equalsIgnoreCase("Store Information"))
		{
			test.log(LogStatus.PASS, "Store Information page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Information page loaded Failed");
		}
				
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		Thread.sleep(5000);
		
		//Click the rightside button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/scrollable-tabset/div/button[2]")).click();
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/scrollable-tabset/div/button[2]")).click();
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/scrollable-tabset/div/button[2]")).click();
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/scrollable-tabset/div/button[2]")).click();
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/scrollable-tabset/div/button[2]")).click();
		// Create instance of Java script executor
		JavascriptExecutor je1 = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element1 = driver.findElement(By.xpath("//span[contains(.,'Lay Away Settings')]"));
		//Scroll the page till the Store option present
		je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
		
		Thread.sleep(3000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		//Click the Lay Away Settings Option
		driver.findElement(By.xpath("//span[contains(.,'Lay Away Settings')]")).click();
		Thread.sleep(3000);
		
		//Check whether the Lay Away Settings page is loaded or not
		if(driver.findElement(By.xpath("//a[.='Lay Away Settings']")).getText().equalsIgnoreCase("Lay Away Settings"))
		{
			test.log(LogStatus.PASS, "Lay Away Settings page loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Lay Away Settings page loaded fail");
		}

		Thread.sleep(5000);

	}	
	
	@Test(priority=3)
	public void edit_Lay_Away_Settings_Percentage_Percentage() throws Exception
	{
		Thread.sleep(2000);
		//Check weather the Enable Lay Away Settings check box is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.isLayAwaySettingsEnable']")).isSelected()){}
		else
		{
			Thread.sleep(1000);
			//Enable the Enable Lay Away Settings check box
			driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.isLayAwaySettingsEnable']")).click();
			Thread.sleep(1000);
		}
		
		Thread.sleep(2000);
		//Select the required minimum deposit
		Select min_Deposit = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div/select")));
		min_Deposit.selectByVisibleText("Percentage");
		
		Thread.sleep(2000);
		//Clear the Percentage option
		driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.minimumDeposit.depositInPercentage']")).clear();
		//Enter the Percentage
		driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.minimumDeposit.depositInPercentage']")).sendKeys("500");
		
		//Select the required minimum deposit
		Select min_Cancellation = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[4]/div/select")));
		min_Cancellation.selectByVisibleText("Percentage");
	
		Thread.sleep(2000);
		//Clear the Percentage option
		driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.cancellationCharge.cancellationInPercentage']")).clear();
		//Enter the Percentage
		driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.cancellationCharge.cancellationInPercentage']")).sendKeys("500");

		Thread.sleep(2000);
		//Check weather the Net sale Radio button is enabled or not
		if(driver.findElement(By.xpath("//input[@value='NetSale']")).isSelected())
		{
			Thread.sleep(1000);
			//Enable the Depsit Radio button is enabled or not
			driver.findElement(By.xpath("//input[@value='Deposit']")).click();
			Thread.sleep(1000);
		}
		else
		{
			Thread.sleep(1000);
			//Enable the Net sale Radio button is enabled or not
			driver.findElement(By.xpath("//input[@value='NetSale']")).click();
			Thread.sleep(1000);
		}
		
		Thread.sleep(2000);
		//Click the Update button
		driver.findElement(By.xpath("//span[.='Update']")).click();
		
		Thread.sleep(2500);
		//Check whether the Lay away settings is updated or not
		if(driver.findElement(By.xpath("//div[@class='content']/div/div/div/div/span/span")).getText().equalsIgnoreCase("Lay Away Settings updated successfully"))
		{
			test.log(LogStatus.PASS, "Lay Away Settings page updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Lay Away Settings page updated fail");
		}
		Thread.sleep(3000);
	}
	
	
	@Test(priority=4)
	public void edit_Lay_Away_Settings_Percentage_Amount() throws Exception
	{
		Thread.sleep(2000);
		//Check weather the Enable Lay Away Settings check box is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.isLayAwaySettingsEnable']")).isSelected()){}
		else
		{
			Thread.sleep(1000);
			//Enable the Enable Lay Away Settings check box
			driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.isLayAwaySettingsEnable']")).click();
			Thread.sleep(1000);
		}
		
		Thread.sleep(2000);
		//Select the required minimum deposit
		Select min_Deposit = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div/select")));
		min_Deposit.selectByVisibleText("Percentage");
		
		Thread.sleep(2000);
		//Clear the Percentage option
		driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.minimumDeposit.depositInPercentage']")).clear();
		//Enter the Percentage
		driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.minimumDeposit.depositInPercentage']")).sendKeys("500");
		
		//Select the required minimum deposit
		Select min_Cancellation = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[4]/div/select")));
		min_Cancellation.selectByVisibleText("Amount");
	
		Thread.sleep(2000);
		//Clear the Amount option
		driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.cancellationCharge.cancellationInAmount']")).clear();
		//Enter the Amount
		driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.cancellationCharge.cancellationInAmount']")).sendKeys("500");

		Thread.sleep(2000);
		//Check weather the Net sale Radio button is enabled or not
		if(driver.findElement(By.xpath("//input[@value='NetSale']")).isSelected())
		{
			Thread.sleep(1000);
			//Enable the Depsit Radio button is enabled or not
			driver.findElement(By.xpath("//input[@value='Deposit']")).click();
			Thread.sleep(1000);
		}
		else
		{
			Thread.sleep(1000);
			//Enable the Net sale Radio button is enabled or not
			driver.findElement(By.xpath("//input[@value='NetSale']")).click();
			Thread.sleep(1000);
		}
		
		Thread.sleep(2000);
		//Click the Update button
		driver.findElement(By.xpath("//span[.='Update']")).click();
		
		Thread.sleep(2500);
		//Check whether the Lay away settings is updated or not
		if(driver.findElement(By.xpath("//div[@class='content']/div/div/div/div/span/span")).getText().equalsIgnoreCase("Lay Away Settings updated successfully"))
		{
			test.log(LogStatus.PASS, "Lay Away Settings page updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Lay Away Settings page updated fail");
		}
		Thread.sleep(3000);
	}
	

	
	@Test(priority=5)
	public void edit_Lay_Away_Settings_Amount_Percentage() throws Exception
	{
		Thread.sleep(2000);
		//Check weather the Enable Lay Away Settings check box is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.isLayAwaySettingsEnable']")).isSelected()){}
		else
		{
			Thread.sleep(1000);
			//Enable the Enable Lay Away Settings check box
			driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.isLayAwaySettingsEnable']")).click();
			Thread.sleep(1000);
		}
		
		Thread.sleep(2000);
		//Select the required minimum deposit
		Select min_Deposit = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div/select")));
		min_Deposit.selectByVisibleText("Amount");
		
		Thread.sleep(2000);
		//Clear the Percentage option
		driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.minimumDeposit.depositInAmount']")).clear();
		//Enter the Percentage
		driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.minimumDeposit.depositInAmount']")).sendKeys("500");
		
		//Select the required minimum deposit
		Select min_Cancellation = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[4]/div/select")));
		min_Cancellation.selectByVisibleText("Percentage");
	
		Thread.sleep(2000);
		//Clear the Percentage option
		driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.cancellationCharge.cancellationInPercentage']")).clear();
		//Enter the Percentage
		driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.cancellationCharge.cancellationInPercentage']")).sendKeys("500");

		Thread.sleep(2000);
		//Check weather the Net sale Radio button is enabled or not
		if(driver.findElement(By.xpath("//input[@value='NetSale']")).isSelected())
		{
			Thread.sleep(1000);
			//Enable the Depsit Radio button is enabled or not
			driver.findElement(By.xpath("//input[@value='Deposit']")).click();
			Thread.sleep(1000);
		}
		else
		{
			Thread.sleep(1000);
			//Enable the Net sale Radio button is enabled or not
			driver.findElement(By.xpath("//input[@value='NetSale']")).click();
			Thread.sleep(1000);
		}
		
		Thread.sleep(2000);
		//Click the Update button
		driver.findElement(By.xpath("//span[.='Update']")).click();
		
		Thread.sleep(2500);
		//Check whether the Lay away settings is updated or not
		if(driver.findElement(By.xpath("//div[@class='content']/div/div/div/div/span/span")).getText().equalsIgnoreCase("Lay Away Settings updated successfully"))
		{
			test.log(LogStatus.PASS, "Lay Away Settings page updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Lay Away Settings page updated fail");
		}
		Thread.sleep(3000);
	}
	
	
	@Test(priority=6)
	public void edit_Lay_Away_Settings_Amount_Amount() throws Exception
	{
		Thread.sleep(2000);
		//Check weather the Enable Lay Away Settings check box is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.isLayAwaySettingsEnable']")).isSelected()){}
		else
		{
			Thread.sleep(1000);
			//Enable the Enable Lay Away Settings check box
			driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.isLayAwaySettingsEnable']")).click();
			Thread.sleep(1000);
		}
		
		Thread.sleep(2000);
		//Select the required minimum deposit
		Select min_Deposit = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div/select")));
		min_Deposit.selectByVisibleText("Amount");
		
		Thread.sleep(2000);
		//Clear the Percentage option
		driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.minimumDeposit.depositInAmount']")).clear();
		//Enter the Percentage
		driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.minimumDeposit.depositInAmount']")).sendKeys("500");
		
		//Select the required minimum deposit
		Select min_Cancellation = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[4]/div/select")));
		min_Cancellation.selectByVisibleText("Amount");
	
		Thread.sleep(2000);
		//Clear the Percentage option
		driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.cancellationCharge.cancellationInAmount']")).clear();
		//Enter the Percentage
		driver.findElement(By.xpath("//input[@ng-model='layAwaySettings.cancellationCharge.cancellationInAmount']")).sendKeys("500");

		Thread.sleep(2000);
		//Check weather the Net sale Radio button is enabled or not
		if(driver.findElement(By.xpath("//input[@value='NetSale']")).isSelected())
		{
			Thread.sleep(1000);
			//Enable the Depsit Radio button is enabled or not
			driver.findElement(By.xpath("//input[@value='Deposit']")).click();
			Thread.sleep(1000);
		}
		else
		{
			Thread.sleep(1000);
			//Enable the Net sale Radio button is enabled or not
			driver.findElement(By.xpath("//input[@value='NetSale']")).click();
			Thread.sleep(1000);
		}
		
		Thread.sleep(2000);
		//Click the Update button
		driver.findElement(By.xpath("//span[.='Update']")).click();
		
		Thread.sleep(2500);
		//Check whether the Lay away settings is updated or not
		if(driver.findElement(By.xpath("//div[@class='content']/div/div/div/div/span/span")).getText().equalsIgnoreCase("Lay Away Settings updated successfully"))
		{
			test.log(LogStatus.PASS, "Lay Away Settings page updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Lay Away Settings page updated fail");
		}
		Thread.sleep(3000);
	}
		
}
