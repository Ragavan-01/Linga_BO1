package epicList;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import epicList_Integrated.Utility;


public class AddEditDelete_HouseAccounts {

	public WebDriver driver;
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete_HouseAccounts");

		@AfterClass
		public void flushTest() throws Exception
		{
			Thread.sleep(2000);
			rep.endTest(test);
			rep.flush();
		}
		
		@AfterMethod
		public void tearDown(ITestResult result)
		{
			if(ITestResult.FAILURE == result.getStatus())
			{
				Utility.captureScreenshot(driver, result.getName());
			}
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

		@Test(priority=3)
		public void HouseAccount_Method_OpenPage() throws Exception
		{
			/*//Click the Customers option
			driver.findElement(By.xpath("//span[.='Customers']")).click();
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='House Account']"));
			//Scroll the page till the House Account option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
		    //Click the House Account Option		
			driver.findElement(By.xpath("//span[.='House Account']")).click();  */
			
			//Enter the URL 
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"houseAccount");
			Thread.sleep(5000);
			//Check House Account page opened or not
			if(driver.findElement(By.xpath("//a[.='HouseAccount']")).getText().equalsIgnoreCase("HouseAccount"))
			{
				test.log(LogStatus.PASS,"House Account page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"House Account page loaded Failed");
			}
			
		}

		@Test(priority=4)
		public void HouseAccount_Method_refresh() throws InterruptedException
		{
			Thread.sleep(2000);
			//Click the refresh button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a/i")).click();
			Thread.sleep(2000);
			//Check House Account page opened or not
			if(driver.findElement(By.xpath("//a[.='HouseAccount']")).getText().equalsIgnoreCase("HouseAccount"))
			{
				test.log(LogStatus.PASS,"House Account page refresh  Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"House Account page refresh  Successfully is Failed");
			}
			
		}
		
		@Test(priority=5)
		public void HouseAccount_Method_CreateNewHouseAccounts() throws Exception
		{
			Thread.sleep(2000);
			//Click the Add House Account or Create new House Account button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/button")).click();
			Thread.sleep(2000);
			//Check  New House Account form page loaded or not
			if(driver.findElement(By.xpath("//span[.='New House Account']")).getText().equalsIgnoreCase("New House Account"))
			{
				test.log(LogStatus.PASS,"New House Account form loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"New House Account form loaded Failed");
			}
		}
				
		@Test(priority=6)
		public void HouseAccount_Method_addHouseAccountsfor_Daily() throws Exception
		{
				Thread.sleep(5000);
			//Click the Customer Field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[1]/div/div/a")).click();
			//Enter the required Customer name in the Corresponding field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[1]/div/div/div/div/input")).sendKeys(Utility.getProperty("HA_Customer_Name"));
			//Press the Enter Key
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
			//Clear the Account number field
			driver.findElement(By.name("accountNumber")).clear();
			//Enter the required name
			driver.findElement(By.name("accountNumber")).sendKeys(Utility.getProperty("HA_Account_Number"));
			//Click the Allow Credits Check box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[3]/div[1]/label[2]/span")).click();
			//Click the Enable Limit Check box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[3]/div[2]/label[2]/span")).click();
			//Click the Enable Max Limit button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[3]/div[3]/label[2]/span")).click();
			//Select the Limit Period as Daily
			Select limitPeriod = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[2]/div[1]/div/select")));
			limitPeriod.selectByVisibleText("Daily");
			//Enter the minimum Limit
			driver.findElement(By.name("limit")).clear();
			//Enter the minimum Limit
			driver.findElement(By.name("limit")).sendKeys("1500");
			//Enter the Maximum Limit
			driver.findElement(By.name("maxAmount")).clear();
			//Enter the Maximum Limit
			driver.findElement(By.name("maxAmount")).sendKeys("2000");
			//Enter the Balance amount
			driver.findElement(By.name("amount")).clear();
			//Enter the Balance amount
			driver.findElement(By.name("amount")).sendKeys("2500");
			Thread.sleep(2000);
			//Click the Save button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(5000);
			//Check weather the new House Account saved successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("HouseAccount saved successfully"))
			{										
				test.log(LogStatus.PASS,"House Account Daily Saved  Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"House Account Daily Save Failed");
			}
		
		}
			
		@Test(priority=7)
		public void HouseAccount_Method_EditHouseAccountsfor_Weekly() throws Exception
		{
			
			Thread.sleep(5000);
			//Clear the search field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/label/input")).clear();
			//Enter the required keyword
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("HA_Customer_Name"));
			//Click the Edit icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			Thread.sleep(5000);
				//Click the Allow Credits Check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[3]/div[1]/label[2]/span")).click();
				//Click the Enable Limit Check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[3]/div[2]/label[2]/span")).click();
				//Click the Enable Max Limit button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[3]/div[3]/label[2]/span")).click();
				//Select the Limit Period as Weekly
				Select limitPeriod = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[2]/div[1]/div/select")));
				limitPeriod.selectByVisibleText("Weekly");
				Thread.sleep(2000);
				//Select the Start Day option
				Select startDay = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[2]/div[2]/div/select")));
				startDay.selectByVisibleText("WEDNESDAY");
				Thread.sleep(2000);
				//Clear the limit field
				driver.findElement(By.name("limit")).clear();
				//Enter the minimum Limit
				driver.findElement(By.name("limit")).sendKeys("1600");
				//Clear the Maximum Limit
				driver.findElement(By.name("maxAmount")).clear();
				//Enter the Maximum Limit
				driver.findElement(By.name("maxAmount")).sendKeys("2100");
				//Click the Save button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(5000);
				
				//Check weather the new House Account saved successfully or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("House account updated successfully"))
				{
					test.log(LogStatus.PASS,"House account Weekly updated successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"House account Weekly updated successfully is Failed");
				}
			
		}
				
		@Test(priority=8)
		public void HouseAccount_Method_EditHouseAccountsfor_Monthly() throws Exception
		{
			Thread.sleep(5000);
			//Clear the search field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/label/input")).clear();
			//Enter the required keyword
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("HA_Customer_Name"));
			//Click the Edit icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			Thread.sleep(5000);
			//Select the Limit Period as Monthly
			Select limitPeriod = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[2]/div[1]/div/select")));
			limitPeriod.selectByVisibleText("Monthly");
			//Clear the limit field
			driver.findElement(By.name("limit")).clear();
			//Enter the minimum Limit
			driver.findElement(By.name("limit")).sendKeys("1700");
			//Clear the Maximum Limit
			driver.findElement(By.name("maxAmount")).clear();
			//Enter the Maximum Limit
			driver.findElement(By.name("maxAmount")).sendKeys("2200");
			//Click the Save button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(5000);
		
			//Check weather the new House Account saved successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("House account updated successfully"))
			{
				test.log(LogStatus.PASS,"House account Monthly updated successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"House account Monthly updated successfully is Failed");
			}
			Thread.sleep(5000);
		}
		
		@Test(priority=9)
		public void HouseAccount_Method_deleteHouseAccounts() throws Exception
		{	
			Thread.sleep(5000);
		     //Clear the search field       
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/label/input")).clear();
			//Enter the required keyword
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("HA_Customer_Name"));
			Thread.sleep(5000);		
			//Click the delete button
			driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
			
			Thread.sleep(5000);
			//Click the yes button on popup
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
			
			Thread.sleep(5000);
			//Check weather the House Account deleted or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("House account inactivated successfully"))
			{									
				test.log(LogStatus.PASS,"House account  inactivated successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"House Account inactivated Failed");
			}
			Thread.sleep(5000);
		}
			
		@Test(priority=10)
		public void HouseAccount_Method_DeActivestatus () throws Exception
		{
			Thread.sleep(4000);
			//Check Deactivate course
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/input")).click();
			//Clear the search field
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/label/input")).clear();
				//Enter the required keyword
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("HA_Customer_Name"));
				Thread.sleep(5000);
				//Click the activate button
			driver.findElement(By.cssSelector("i.fa.fa-check")).click();
			Thread.sleep(5000);
			//Click the Yes button in the popup
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();  
		    
			Thread.sleep(4000);
			//Check if we Deactivate or not///House account  activated successfully
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("House account activated successfully"))
			{
				test.log(LogStatus.PASS,"House account  activated successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"House account  activated successfully is Failed");
			}
			Thread.sleep(4000);
			//Check Deactivate course
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/input")).click();
			//Clear the search field
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/label/input")).clear();
			}
	
}



