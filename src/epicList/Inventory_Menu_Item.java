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

public class Inventory_Menu_Item {
	
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory_Menu_Item");

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
			Thread.sleep(3000);
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
		public void Inventory_Menu_Items_OpenPage() throws Exception
		{
		//Get the URl
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"inventory_menuItems");
	
			Thread.sleep(5000);
			//Check Storage Locations page opened or not
			if(driver.findElement(By.xpath("//a[.='Inventory Menu Items']")).getText().equalsIgnoreCase("Inventory Menu Items"))
			{
				test.log(LogStatus.PASS, "Inventory Menu Items page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Inventory Menu Items page loaded Failed");
			}
			
			Thread.sleep(5000);
			
		}
		
		@Test(priority=12)
		public void Inventory_Menu_Items_refresh_page() throws InterruptedException
		{
			Thread.sleep(5000);
			//Click the refresh button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/a[1]/i")).click();
			Thread.sleep(5000);
			
			//Check Inventory Menu Items page opened or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Inventory Menu Items"))
			{
				test.log(LogStatus.PASS, "Inventory Menu Items page refreshed Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Inventory Menu Items page refreshed Failed");
			}
			Thread.sleep(5000);
	
		}
	
		@Test(priority=14)
		public void Inventory_Menu_Items_verify_UnLinked_TO_Linked() throws Exception
		{
			  //Scroll the web page
		    for(int i=1; i <= 20; i++)
		    {
		    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		    } 
		    
			Thread.sleep(3000);
			//Click the filter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/button")).click();
			
			Thread.sleep(1500);
			//Choose the Option as linked Items
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/ul/li[3]/a")).click();
			
			Thread.sleep(1000);
	
			
			//Click the Link Option
			driver.findElement(By.xpath("//i[@class='fa fa-arrows-h']")).click();
			
			Thread.sleep(4500);
			//Click the Right arrow
			driver.findElement(By.xpath("//i[@class='pull-right fa ng-scope fa-chevron-right']")).click();
			
			Thread.sleep(2000);
			//Add Inventory Item
			driver.findElement(By.xpath("//i[contains(.,'Inventory Item')]")).click();
			
			Thread.sleep(5000);
			//Click the Category Option
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/a")).click();
			//Press the Enter button
			Thread.sleep(1000);driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/div/div/input")).click();
			Thread.sleep(1000);driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);
	
			Thread.sleep(5000);
			//Click the Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]/div/a")).click();
			//Press the Enter button
			Thread.sleep(5000);
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]/div/div/div/input")).click();
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/div/a")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]/input")).sendKeys("1");
			
			Thread.sleep(2000);
			//Add Sub Recipe
			driver.findElement(By.xpath("//i[contains(.,'Sub Recipe')]")).click();
	
			Thread.sleep(1000);
			//Click the Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]/div/a")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[3]/div/a")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[3]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[5]/input")).sendKeys("3");
	
			Thread.sleep(2000);
			//Add Manual Entry
			driver.findElement(By.xpath("//i[contains(.,'Manual Entry')]")).click();
	
			Thread.sleep(1000);
			//clear the Required Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[3]/td[2]/input")).clear();
			//Enter the required Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[3]/td[2]/input")).sendKeys("Test");
			
			Thread.sleep(1000);
			//clear the Price per Unit Option
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[3]/td[4]/input")).clear();
			//Enter the Price per Unit
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[3]/td[4]/input")).sendKeys("500");
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[3]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[3]/td[5]/input")).sendKeys("2");
	
			Thread.sleep(2000);
			//Add Inventory Item
			driver.findElement(By.xpath("//i[contains(.,'Inventory Item')]")).click();
			Thread.sleep(1500);
			//Click the Close button for Inventory Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[4]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			Thread.sleep(2000);
			//Add Sub Recipe
			driver.findElement(By.xpath("//i[contains(.,'Sub Recipe')]")).click();
			Thread.sleep(1500);
			//Click the Close button for Sub Recipe
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[4]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			Thread.sleep(2000);
			//Add Manual Entry
			driver.findElement(By.xpath("//i[contains(.,'Manual Entry')]")).click();
			Thread.sleep(1500);
			//Click the Close button for Manual Entry
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[4]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			
			Thread.sleep(3000);
			//Click the Update and Go Button
			driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
			
			Thread.sleep(2500);
			
			//Check whether the inventory item updated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Menu item Updated"))
			{
				test.log(LogStatus.PASS, "Menu item Updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Menu item Updated Failed");
			}
	
			Thread.sleep(10000);
			
			//Click the filter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/button")).click();
			
			Thread.sleep(1500);
			//Choose the Option as linked Items
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/ul/li[2]/a")).click();
			
			Thread.sleep(1000);
			//Check whether the Linked Items are displayed or not
			if(driver.findElement(By.xpath("//span[@class='fa fa-check text-success']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Unlinked Inventory Menu Item is Changed to Linked Menu Item was Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Unlinked Inventory Menu Item is Changed to Linked Menu Item was Fail");
			}
			Thread.sleep(2000);
			
		}
		
		@Test(priority=15)
		public void Inventory_Menu_Items_edit_Linked_Type_of_Menu_Item_Inv() throws Exception
		{
			Thread.sleep(8000);
			//Click the filter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/button")).click();
			
			Thread.sleep(1500);
			//Choose the Option as linked Items
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/ul/li[2]/a")).click();
			
			//Click the Link Option
			driver.findElement(By.xpath("//i[@class='fa fa-arrows-h']")).click();
			
			Thread.sleep(4500);
			//Click the Right arrow
			driver.findElement(By.xpath("//i[@class='pull-right fa ng-scope fa-chevron-right']")).click();
			
			Thread.sleep(1500);
			//Click the Close button for first
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			//Click the Close button for first
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			//Click the Close button for first
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			Thread.sleep(2000);
			//Add Inventory Item
			driver.findElement(By.xpath("//i[contains(.,'Inventory Item')]")).click();
			
			Thread.sleep(1000);
			//Click the Category Option
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/a")).click();
			//Press the Enter button
			Thread.sleep(1000);driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);
	
			Thread.sleep(1000);
			//Click the Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]/div/a")).click();
			//Press the Enter button
			Thread.sleep(2000);driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/div/a")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]/input")).sendKeys("1");
	
			Thread.sleep(2000);
			//Add Inventory Item
			driver.findElement(By.xpath("//i[contains(.,'Inventory Item')]")).click();
			
			Thread.sleep(1000);
			//Click the Category Option
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[1]/div/a")).click();
			//Press the Enter button
			Thread.sleep(1000);driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);
	
			Thread.sleep(1000);
			//Click the Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]/div/a")).click();
			//Press the Enter button
			Thread.sleep(2000);driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[3]/div/a")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[3]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[5]/input")).sendKeys("1");
	
			Thread.sleep(3000);
			//Click the Update and Go Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			
			Thread.sleep(2500);
			
			//Check whether the inventory item updated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Menu item Updated"))
			{
				test.log(LogStatus.PASS, "Menu item Updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Menu item Updated Failed");
			}
	
			Thread.sleep(5000);
			//Click the Cancel button
			driver.findElement(By.xpath("//a[.='Cancel']")).click();
			
			Thread.sleep(2000);
		}
		
		@Test(priority=16)
		public void Inventory_Menu_Items_edit_Linked_Type_of_Menu_Item_Inv_Sub() throws Exception
		{
			Thread.sleep(8000);
			//Click the filter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/button")).click();
			
			Thread.sleep(1500);
			//Choose the Option as linked Items
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/ul/li[2]/a")).click();
			
			//Click the Link Option
			driver.findElement(By.xpath("//i[@class='fa fa-arrows-h']")).click();
			
			Thread.sleep(4500);
			//Click the Right arrow
			driver.findElement(By.xpath("//i[@class='pull-right fa ng-scope fa-chevron-right']")).click();
			
			Thread.sleep(1500);
			//Click the Close button for first
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			//Click the Close button for first
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
				
			Thread.sleep(2000);
			//Add Inventory Item
			driver.findElement(By.xpath("//i[contains(.,'Inventory Item')]")).click();
			
			Thread.sleep(1000);
			//Click the Category Option
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/a")).click();
			//Press the Enter button
			Thread.sleep(1000);driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);
	
			Thread.sleep(1000);
			//Click the Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]/div/a")).click();
			//Press the Enter button
			Thread.sleep(2000);driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/div/a")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]/input")).sendKeys("1");
	
			Thread.sleep(2000);
			//Add Sub Recipe
			driver.findElement(By.xpath("//i[contains(.,'Sub Recipe')]")).click();
	
			Thread.sleep(1000);
			//Click the Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]/div/a")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[3]/div/a")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[3]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[5]/input")).sendKeys("3");
	
			Thread.sleep(3000);
			//Click the Update and Go Button
			driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
			
			Thread.sleep(2500);
			
			//Check whether the inventory item updated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Menu item Updated"))
			{
				test.log(LogStatus.PASS, "Menu item Updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Menu item Updated Failed");
			}
	
			Thread.sleep(5000);
		}
		
		@Test(priority=17)
		public void Inventory_Menu_Items_edit_Linked_Type_of_Menu_Item_Inv_Manual() throws Exception
		{
			Thread.sleep(8000);
			//Click the filter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/button")).click();
			
			Thread.sleep(1500);
			//Choose the Option as linked Items
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/ul/li[2]/a")).click();
			
			//Click the Link Option
			driver.findElement(By.xpath("//i[@class='fa fa-arrows-h']")).click();
			
			Thread.sleep(4500);
			//Click the Right arrow
			driver.findElement(By.xpath("//i[@class='pull-right fa ng-scope fa-chevron-right']")).click();
			
			Thread.sleep(1500);
			//Click the Close button for first
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			//Click the Close button for first
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
				
			Thread.sleep(2000);
			//Add Inventory Item
			driver.findElement(By.xpath("//i[contains(.,'Inventory Item')]")).click();
			
			Thread.sleep(1000);
			//Click the Category Option
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/a")).click();
			//Press the Enter button
			Thread.sleep(1000);driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);
	
			Thread.sleep(1000);
			//Click the Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]/div/a")).click();
			//Press the Enter button
			Thread.sleep(2000);driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/div/a")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]/input")).sendKeys("1");
	
			Thread.sleep(2000);
			//Add Manual Entry
			driver.findElement(By.xpath("//i[contains(.,'Manual Entry')]")).click();
	
			Thread.sleep(1000);
			//clear the Required Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]/input")).clear();
			//Enter the required Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]/input")).sendKeys("Test");
			
			Thread.sleep(1000);
			//clear the Price per Unit Option
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[4]/input")).clear();
			//Enter the Price per Unit
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[4]/input")).sendKeys("500");
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[5]/input")).sendKeys("2");
	
			Thread.sleep(3000);
			//Click the Update and Go Button
			driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
			
			Thread.sleep(2500);
			
			//Check whether the inventory item updated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Menu item Updated"))
			{
				test.log(LogStatus.PASS, "Menu item Updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Menu item Updated Failed");
			}
	
			Thread.sleep(5000);
		}
		
		@Test(priority=18)
		public void Inventory_Menu_Items_edit_Linked_Type_of_Menu_Item_Sub_Manual() throws Exception
		{
			Thread.sleep(8000);
			//Click the filter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/button")).click();
			
			Thread.sleep(1500);
			//Choose the Option as linked Items
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/ul/li[2]/a")).click();
			
			//Click the Link Option
			driver.findElement(By.xpath("//i[@class='fa fa-arrows-h']")).click();
			
			Thread.sleep(4500);
			//Click the Right arrow
			driver.findElement(By.xpath("//i[@class='pull-right fa ng-scope fa-chevron-right']")).click();
			
			Thread.sleep(1500);
			//Click the Close button for first
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			//Click the Close button for first
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
				
			Thread.sleep(2000);
			//Add Sub Recipe
			driver.findElement(By.xpath("//i[contains(.,'Sub Recipe')]")).click();
	
			Thread.sleep(1000);
			//Click the Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]/div/a")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/div/a")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]/input")).sendKeys("3");
	
			Thread.sleep(2000);
			//Add Manual Entry
			driver.findElement(By.xpath("//i[contains(.,'Manual Entry')]")).click();
	
			Thread.sleep(1000);
			//clear the Required Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]/input")).clear();
			//Enter the required Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]/input")).sendKeys("Test");
			
			Thread.sleep(1000);
			//clear the Price per Unit Option
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[4]/input")).clear();
			//Enter the Price per Unit
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[4]/input")).sendKeys("500");
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[5]/input")).sendKeys("2");
	
			Thread.sleep(3000);
			//Click the Update and Go Button
			driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
			
			Thread.sleep(2500);
			
			//Check whether the inventory item updated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Menu item Updated"))
			{
				test.log(LogStatus.PASS, "Menu item Updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Menu item Updated Failed");
			}
	
			Thread.sleep(5000);
		}
		
		@Test(priority=19)
		public void Inventory_Menu_Items_edit_Linked_Type_of_Menu_Item_Sub_Sub() throws Exception
		{
			Thread.sleep(8000);
			//Click the filter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/button")).click();
			
			Thread.sleep(1500);
			//Choose the Option as linked Items
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/ul/li[2]/a")).click();
			
			//Click the Link Option
			driver.findElement(By.xpath("//i[@class='fa fa-arrows-h']")).click();
			
			Thread.sleep(4500);
			//Click the Right arrow
			driver.findElement(By.xpath("//i[@class='pull-right fa ng-scope fa-chevron-right']")).click();
			
			Thread.sleep(1500);
			//Click the Close button for first
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			//Click the Close button for first
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
				
			Thread.sleep(2000);
			//Add Sub Recipe
			driver.findElement(By.xpath("//i[contains(.,'Sub Recipe')]")).click();
	
			Thread.sleep(1000);
			//Click the Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]/div/a")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/div/a")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]/input")).sendKeys("3");
	
			Thread.sleep(2000);
			//Add Sub Recipe
			driver.findElement(By.xpath("//i[contains(.,'Sub Recipe')]")).click();
	
			Thread.sleep(1000);
			//Click the Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]/div/a")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[3]/div/a")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[3]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[5]/input")).sendKeys("3");
	
			Thread.sleep(3000);
			//Click the Update and Go Button
			driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
			
			Thread.sleep(2500);
			
			//Check whether the inventory item updated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Menu item Updated"))
			{
				test.log(LogStatus.PASS, "Menu item Updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Menu item Updated Failed");
			}
	
			Thread.sleep(5000);
		}
		
		@Test(priority=20)
		public void Inventory_Menu_Items_edit_Linked_Type_of_Menu_Item_Manual_Manual() throws Exception
		{
			Thread.sleep(8000);
			//Click the filter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/button")).click();
			
			Thread.sleep(1500);
			//Choose the Option as linked Items
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/ul/li[2]/a")).click();
			
			//Click the Link Option
			driver.findElement(By.xpath("//i[@class='fa fa-arrows-h']")).click();
			
			Thread.sleep(4500);
			//Click the Right arrow
			driver.findElement(By.xpath("//i[@class='pull-right fa ng-scope fa-chevron-right']")).click();
			
			Thread.sleep(1500);
			//Click the Close button for first
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			//Click the Close button for first
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
				
			Thread.sleep(2000);
			//Add Manual Entry
			driver.findElement(By.xpath("//i[contains(.,'Manual Entry')]")).click();
	
			Thread.sleep(1000);
			//clear the Required Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]/input")).clear();
			//Enter the required Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]/input")).sendKeys("Test");
			
			Thread.sleep(1000);
			//clear the Price per Unit Option
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[4]/input")).clear();
			//Enter the Price per Unit
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[4]/input")).sendKeys("500");
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]/input")).sendKeys("2");
	
			Thread.sleep(2000);
			//Add Manual Entry
			driver.findElement(By.xpath("//i[contains(.,'Manual Entry')]")).click();
	
			Thread.sleep(1000);
			//clear the Required Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]/input")).clear();
			//Enter the required Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]/input")).sendKeys("Test");
			
			Thread.sleep(1000);
			//clear the Price per Unit Option
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[4]/input")).clear();
			//Enter the Price per Unit
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[4]/input")).sendKeys("500");
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[5]/input")).sendKeys("2");
	
			Thread.sleep(3000);
			//Click the Update and Go Button
			driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
			
			Thread.sleep(2500);
			
			//Check whether the inventory item updated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Menu item Updated"))
			{
				test.log(LogStatus.PASS, "Menu item Updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Menu item Updated Failed");
			}
	
			Thread.sleep(5000);
		}
		
		@Test(priority=21)
		public void Inventory_Menu_Items_verify_Linked_Type_of_Menu_Items_TO_UnLinked_Type_of_Menu_Items() throws Exception
		{
			Thread.sleep(8000);
			//Click the filter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/button")).click();
			
			Thread.sleep(1500);
			//Choose the Option as linked Items
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div[2]/div/ul/li[2]/a")).click();
			
			Thread.sleep(1000);
			//Check whether the Linked Items are displayed or not
			if(driver.findElement(By.xpath("//span[@class='fa fa-check text-success']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Linked Inventory Menu Items are displayed");
			}
			else
			{
				test.log(LogStatus.FAIL, "Linked Inventory Menu Items are not displayed");
			}
			Thread.sleep(2000);	
			
			//Click the Link Option
			driver.findElement(By.xpath("//i[@class='fa fa-arrows-h']")).click();
			
			Thread.sleep(4500);
			//Click the Right arrow
			driver.findElement(By.xpath("//i[@class='pull-right fa ng-scope fa-chevron-right']")).click();
			
	
			Thread.sleep(3500);
			//Click the Close button for Inventory Item
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			//Click the Close button for Sub Recipe
			driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			
			Thread.sleep(3000);
			//Click the Update and Go Button
			driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
			
			Thread.sleep(2500);
			
			//Check whether the inventory item updated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Menu item Updated"))
			{
				test.log(LogStatus.PASS, "Menu item Updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Menu item Updated Failed");
			}
	
			Thread.sleep(5000);
		}
		
		@Test(priority=22)
		public void Inventory_Menu_Items_verifyActive_InActiveButton_Sub_Recipe() throws Exception
		{
			Thread.sleep(8000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			
			Thread.sleep(5000);
			//Click Active or In Active Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/input")).click();
	
			Thread.sleep(5000);
			//Check the Inactive page is loaded or not
			if(!driver.findElement(By.cssSelector("i.fa.fa-arrows-h")).isDisplayed())
			{
				test.log(LogStatus.PASS, "We are in InActive Page");
				Thread.sleep(10000);
				//Click Active or In Active Button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/input")).click();
	
			}
			else
			{
				test.log(LogStatus.FAIL, "We are in Active Page but User Click the Inactive Page");
			}
			Thread.sleep(5000);
		}
}
