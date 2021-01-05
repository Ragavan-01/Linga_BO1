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

public class Settings_SaleRecapReportSettings {

	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings_SaleRecapReportSettings");
	
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

	@Test(priority=30)
	public void Sale_Recap_Settings_Method_openpage() throws Exception
		{
			
			Thread.sleep(3000);
			//Enter the URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"saleRecapReportSettings");
			
				
			Thread.sleep(3000);
		
			//Check whether the Sale recap Report Settings page is loaded or not
			if(driver.findElement(By.xpath("//a[.='Sale recap Report Settings']")).getText().equalsIgnoreCase("Sale recap Report Settings"))
			{
				test.log(LogStatus.PASS, " Sale recap Report Settings page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, " Sale recap Report Settings page loaded fail");
			}

			Thread.sleep(3000);

		}	
		
	@Test(priority=31)
	public void Sale_Recap_Settings_Method_edit() throws Exception
	{
			Thread.sleep(2000);
			Thread.sleep(1000);
			//Enable the Guests/Checks check box
			driver.findElement(By.name("guestOrCheck")).click();
			Thread.sleep(2000);
			//Check weather the Guests/Checks check box is enabled or not
			if(driver.findElement(By.name("guestOrCheck")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the Guests/Checks check box
				driver.findElement(By.name("guestOrCheck")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the grandSales check box is enabled or not
			if(driver.findElement(By.name("grandSales")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the grandSales check box
				driver.findElement(By.name("grandSales")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the grossReceipt check box is enabled or not
			if(driver.findElement(By.name("grossReceipt")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the grossReceipt check box
				driver.findElement(By.name("grossReceipt")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the grossVoid check box is enabled or not
			if(driver.findElement(By.name("grossVoid")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the grossVoid check box
				driver.findElement(By.name("grossVoid")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the netVoid check box is enabled or not
			if(driver.findElement(By.name("netVoid")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the netVoid check box
				driver.findElement(By.name("netVoid")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the creditCardSplitUps check box is enabled or not
			if(driver.findElement(By.name("creditCardSplitUp")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the creditCardSplitUp check box
				driver.findElement(By.name("creditCardSplitUp")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the otherPayments check box is enabled or not
			if(driver.findElement(By.name("otherPayments")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the otherPayments check box
				driver.findElement(By.name("otherPayments")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the taxes check box is enabled or not
			if(driver.findElement(By.name("taxes")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the taxes check box
				driver.findElement(By.name("taxes")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the taxExempt check box is enabled or not
			if(driver.findElement(By.name("taxExempt")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the taxExempt check box
				driver.findElement(By.name("taxExempt")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the departmentSummary check box is enabled or not
			if(driver.findElement(By.name("departmentSummary")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the departmentSummary check box
				driver.findElement(By.name("departmentSummary")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the categorySummary check box is enabled or not
			if(driver.findElement(By.name("categorySummary")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the categorySummary check box
				driver.findElement(By.name("categorySummary")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the hourlySummary check box is enabled or not
			if(driver.findElement(By.name("hourlySummary")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the hourlySummary check box
				driver.findElement(By.name("hourlySummary")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the openingBalance check box is enabled or not
			if(driver.findElement(By.name("openingBalance")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the openingBalance check box
				driver.findElement(By.name("openingBalance")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the paid check box is enabled or not
			if(driver.findElement(By.name("paid")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the paid check box
				driver.findElement(By.name("paid")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the Cash drop check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='store.saleRecapReport.cashDrop']")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the Cash drop check box
				driver.findElement(By.xpath("//input[@ng-model='store.saleRecapReport.cashDrop']")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the cashExpected check box is enabled or not
			if(driver.findElement(By.name("cashExpected")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the cashExpected check box
				driver.findElement(By.name("cashExpected")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the Over Shortage check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='store.saleRecapReport.overShortage']")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the Over Shortage check box
				driver.findElement(By.xpath("//input[@ng-model='store.saleRecapReport.overShortage']")).click();
				Thread.sleep(1000);
			}
			Thread.sleep(2000);
			//Check weather the Exclude Opening Balance Calculation is enabled or not
			if(driver.findElement(By.xpath("//input[@name= 'excludeOpeningBalance']")).isSelected()) {}
			else
			{
				Thread.sleep(3000);
				//Enable the Exclude Opening Balance Calculation
				driver.findElement(By.xpath("//input[@name= 'excludeOpeningBalance']")).click();
			}
			
			Thread.sleep(1000);
			//Check whether the User defined name is selected or not
			if(driver.findElement(By.xpath("//input[@ng-model='store.saleRecapReport.paymentMethodOrType']/../../../div[contains(.,'User')]/div/input")).isSelected()){}
			else
			{
				//Click the user defined name check box
				driver.findElement(By.xpath("//input[@ng-model='store.saleRecapReport.paymentMethodOrType']/../../../div[contains(.,'User')]/div/input")).click();
			}
			
			Thread.sleep(1000);
			//Click the update button
			driver.findElement(By.xpath("//span[.='Update']")).click();
			Thread.sleep(3000);
			
			//Check weather theSale recap Report Settings is updated or not
			if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("SaleRecap Report Settings updated successsfully"))
			{
				test.log(LogStatus.PASS, "Sale recap Report Settings updated successfully");
			}
			
			else{
				test.log(LogStatus.FAIL, "Sale recap Report Settings updated fail");
			}
			Thread.sleep(5000);watchTutorial();Thread.sleep(5000);
		}
}
