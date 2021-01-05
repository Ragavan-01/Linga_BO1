package epicList;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import epicList_Integrated.ExtentManager;
import epicList_Integrated.Utility;

public class Enterprise_Loyalty_Settings {
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise_Loyalty_Settings");

	float unknownValue = 00;
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScreenshot(driver, result.getName());
		}
	}
	
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
				Thread.sleep(2000);
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
				Thread.sleep(2000);
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
			
		@Test(priority=500)
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

		@Test(priority=11)
		public void Loyalty_page_Setting() throws Exception
		{
			/*//Click the My Stores option
			driver.findElement(By.xpath("//span[.='My Stores']")).click();
			JavascriptExecutor je1 = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element1 = driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[8]/a/span"));
			//Scroll the page till the Reason option present
			je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
			//Wait for 30 seconds
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(3000);
		    //Click the Loyalty Option		
			driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[8]/a/span")).click();
			*/
			Thread.sleep(3000);	
			//Enter the Coursing URL
			driver.get(Utility.getProperty("Enterprise_Base_URL")+"loyalty");
				
			Thread.sleep(5000);
			//Check Loyalty page opened or not
			if(driver.findElement(By.xpath("//a[.='Loyalty']")).getText().equalsIgnoreCase("Loyalty"))
	
			{
				test.log(LogStatus.PASS, "Loyalty page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Loyalty page loaded Failed");
			}
			
			Thread.sleep(3000);
			
		}
	
		@Test(priority=12)
		public void Loyalty_Settingpage() throws Exception
		{
			Thread.sleep(2000);
			
			//Check whether the Loyalty Account button is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='loyalty.enableLoyalty']")).isSelected()){}
			
			else
			{
				//Enable the Loyalty Account button Option
				driver.findElement(By.xpath("//input[@ng-model='loyalty.enableLoyalty']")).click();
			}
			
			
			Thread.sleep(3000);
			//Clear the Points For Customer Enrollment
			driver.findElement(By.name("customerEnrollment")).clear();
			//Enter the Customer Enrollment value
			driver.findElement(By.name("customerEnrollment")).sendKeys(Utility.getProperty("customerEnrollment_Value"));
			
			//Clear the Points for Every Visit
			driver.findElement(By.name("visit")).clear();
			//Enter the Points For Every Visit
			driver.findElement(By.name("visit")).sendKeys(Utility.getProperty("Loyalty_visitPrice"));
			
			Thread.sleep(2000);
			//Actions act = new Actions(driver);
			//act.moveToElement(driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[5]/div[1]/input"))).click().build().perform();
			
			//Clear the Points for the Cash Payment
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[5]/div[1]/input")).clear();
			//Enter the Points for the Cash Payment
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[5]/div[1]/input")).sendKeys(Utility.getProperty("Loyalty_purchasePoint"));
			
			//Clear the Points for the Cash Payment
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[5]/div[2]/input")).clear();
			//Enter the Points for the Cash Payment
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[5]/div[2]/input")).sendKeys(Utility.getProperty("Loyalty_purchasePoint"));
	
			//Clear the Points for the Non Cash Payment
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[6]/div[1]/input")).clear();
			//Enter the Points for the Non Cash Payment
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[6]/div[1]/input")).sendKeys(Utility.getProperty("Loyalty_purchasePoint"));
			
			//Clear the Points for the Non Cash Payment
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[6]/div[2]/input")).clear();
			//Enter the Points for the Non Cash Payment
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[6]/div[2]/input")).sendKeys(Utility.getProperty("Loyalty_purchasePoint"));
	
			//Click Add Menu item Based
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[7]/div/div/div/a/i")).click();
			
			//Click the Menu Item Option
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[7]/div/div[2]/ng-form/div/div[1]/div/a")).click();
			//Press the Enter Button
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[7]/div/div[2]/ng-form/div/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			//Clear the Quantity Option
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[7]/div/div[2]/ng-form/div/div[2]/div/input")).clear();
			//Enter the Quantity
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[7]/div/div[2]/ng-form/div/div[2]/div/input")).sendKeys("5");
			
			//Clear the Points
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[7]/div/div[2]/ng-form/div/div[3]/div/input")).clear();
			//Enter the Points
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[7]/div/div[2]/ng-form/div/div[3]/div/input")).sendKeys("10");
			
			
			//Click the Add Button
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[7]/div/div/div/a/i")).click();
			
			
			//Click the Close Button of newly added option
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[7]/div/div[3]/ng-form/div/div[3]/div/a")).click();
			
			Thread.sleep(2000);
			//Click the Yes Button
			driver.findElement(By.partialLinkText("Yes")).click();
			
			//Click Add Category Based
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div/div/a")).click();
			
			//Click the Category Option
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div[2]/ng-form/div/div[1]/div/a")).click();
			//Press the Enter Button
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div[2]/ng-form/div/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			//Clear the Quantity Option
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div[2]/ng-form/div/div[2]/div/input")).clear();
			//Enter the Quantity
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div[2]/ng-form/div/div[2]/div/input")).sendKeys("5");
			
			//Clear the Points
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div[2]/ng-form/div/div[3]/div/input")).clear();
			//Enter the Points
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div[2]/ng-form/div/div[3]/div/input")).sendKeys("8");
			
			//Click the Add Button
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div/div/a")).click();
			
			Thread.sleep(5000);
			//Click the Close Button of newly added option
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div[3]/ng-form/div/div[3]/div/a")).click();
			
			Thread.sleep(2000);
			//Click the Yes Button
			driver.findElement(By.partialLinkText("Yes")).click();
			
			Thread.sleep(2000);
			//Enter the Redeem points
			driver.findElement(By.xpath("//input[@name='exchangeRate']")).clear();
			//Enter the Redeem points
			driver.findElement(By.xpath("//input[@name='exchangeRate']")).sendKeys("2.00");
	
			Thread.sleep(2000);
			//Enter the Minimum points required for redemption option
			driver.findElement(By.xpath("//input[@name='minPoints']")).clear();
			//Enter the Minimum points required for redemption option
			driver.findElement(By.xpath("//input[@name='minPoints']")).sendKeys("2");
	
			
			Thread.sleep(3000);
			//Click the update button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(3000);
			//Check Loyalty updated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("loyalty Saved successfully"))
	
			{
				test.log(LogStatus.PASS, "Loyalty updated Successfully ");
			}
			else
			{
				test.log(LogStatus.FAIL, "Loyalty updated Failed");
			}
			Thread.sleep(3000);
			}
	
		@Test(priority=13)
		public void Loyalty_SettingpageDisable() throws Exception
		{
	
			Thread.sleep(2000);
	
			//Check whether the Loyalty Account button is enabled or not
			if(!driver.findElement(By.xpath("//input[@ng-model='loyalty.enableLoyalty']")).isEnabled())
			{}
			else
			{
				//Enable the Loyalty Account button Option
				driver.findElement(By.xpath("//input[@ng-model='loyalty.enableLoyalty']")).click();
			}
	
			//Click the Close Button of newly added option - Menu Item
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[7]/div/div[2]/ng-form/div/div[3]/div/a")).click();
			
			Thread.sleep(2000);
			//Click the Yes Button
			driver.findElement(By.partialLinkText("Yes")).click();
			
			//Click the Close Button of newly added option - Category
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div[2]/ng-form/div/div[3]/div/a")).click();	
			
			Thread.sleep(2000);
			//Click the Yes Button
			driver.findElement(By.partialLinkText("Yes")).click();
			
			Thread.sleep(3000);
			//Click the update button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(5000);
			//Check Loyalty updated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("loyalty Saved successfully"))
	
			{
				test.log(LogStatus.PASS, "Loyalty updated Successfully for disabled option");
			}
			else
			{
				test.log(LogStatus.FAIL, "Loyalty updated Failed for disabled option");
			}
			
			Thread.sleep(3000);
		}

}
