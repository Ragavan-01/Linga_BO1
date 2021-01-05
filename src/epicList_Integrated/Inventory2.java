package epicList_Integrated;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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


public class Inventory2 {
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory2");

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
		public void login(WebDriver driver) throws Exception
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
		public void logout(WebDriver driver) throws Exception
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
		
		@Test(priority=2)
		public void Inventory_Modifier_HomePage(WebDriver driver) throws Exception
		{
			Thread.sleep(15000);
			//Click the Inventory option
			driver.findElement(By.xpath("//span[.='Inventory']")).click();
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Inventory Modifiers ']"));
			//Scroll the page till the Inventory Items option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
	        //Click the Inventory Items Option		
			driver.findElement(By.xpath("//span[.='Inventory Modifiers ']")).click();
			Thread.sleep(5000);
			//Check Inventory Items page opened or not
			if(driver.findElement(By.xpath("//a[.='Modifiers']")).getText().equalsIgnoreCase("Modifiers"))
			{
				test.log(LogStatus.PASS, "Inventory Modifiers page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Inventory Modifiers page loaded Failed");
			}
			
			Thread.sleep(5000);
			
		}
		
		@Test(priority=4)
		public void Inventory_Modifier(WebDriver driver) throws Exception
		{
		Thread.sleep(3000);
		//Clear the Search 
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).clear();
		Thread.sleep(3000);
		//Enter the modifier
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Serach_Inventory_modifiers"));
		Thread.sleep(3000);
		//Enter the modifier
	 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).sendKeys(Keys.ENTER);
		
	 	Thread.sleep(3000);
	 	//Click the modifiers
	 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/a/i")).click();
		
	 	Thread.sleep(3000);
	 	//Check whether link modifiers page opened or not
		if(driver.findElement(By.xpath("//a[.='Link Modifier']")).getText().equalsIgnoreCase("Link Modifier"))
		{
			test.log(LogStatus.PASS, "Link Modifier page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Link Modifier page loaded Failed");
		}
					
		Thread.sleep(3000);	
		}
		
		@Test(priority=5)
		public void Inventory_Modifier_Item_Update(WebDriver driver) throws Exception
		{
			Thread.sleep(3000);
			//Click the Item Type
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[1]/div/select")).click();
			Thread.sleep(3000);
		
			/*
			 //Select the Item Type
			 Select temp = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div/div/select/option[2]")));
			 Thread.sleep(3000);
			 temp.selectByVisibleText("Item");  
			 Thread.sleep(2000);*/
			 //Select modifier item option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div/div/select/option[2]")).click();
			
			Thread.sleep(3000);
			 //Click Category for Link Modifer
			 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[2]/div/div/a")).click();
			 Thread.sleep(3000);
			 
			 //Click the Input field
			 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div/input")).click();
			 
			 //Enter Category for Link Modifer
			 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			 Thread.sleep(3000);
			//Enter Category for Link Modifer
			 //driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
			 //Click Category for Link Modifer
			 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[3]/div[1]/div/a")).click();
			 Thread.sleep(3000);
			 
			 //Enter Category for Link Modifer
			 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/input")).click();
		
			 Thread.sleep(3000);
			 
			 //Enter Category for Link Modifer
			 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
			 Thread.sleep(5000);
			 //Click update button						
				driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.ng-binding")).click();
				Thread.sleep(2000);
		
		
		}
		
		@Test(priority=6)
		public void Inventory_Modifier_new_item_modifiers_Update(WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(3000);
			//Clear the Search 
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).clear();
			Thread.sleep(3000);
			//Enter the modifier
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Serach_Inventory_modifiers"));
			Thread.sleep(3000);
			//Enter the modifier
		 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).sendKeys(Keys.ENTER);
			
		 	Thread.sleep(3000);
		 	//Click the modifiers
		 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/a/i")).click();
			
		 	Thread.sleep(3000);
		 	//Check whether link modifiers page opened or not
			if(driver.findElement(By.xpath("//a[.='Link Modifier']")).getText().equalsIgnoreCase("Link Modifier"))
			{
				test.log(LogStatus.PASS, "Link Modifier page loaded Successfully for modifier level item");
			}
			else
			{
				test.log(LogStatus.FAIL, "Link Modifier page loaded Failed for modifier level item");
			}
						
			
			Thread.sleep(3000);
			//Click the Item Type
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[1]/div/select")).click();
		/*	Thread.sleep(3000);
			//Select the Item Type
			 Select temp = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div/div/select/option[2]")));
			 temp.selectByVisibleText("Item");  */
			 Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div/div/select/option[2]")).click();
			 Thread.sleep(3000);
			 //Click Category for Link Modifer
			 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[2]/div/div/a")).click();
			 Thread.sleep(3000);
			 
			 //Enter Category for Link Modifer
			 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div/input")).sendKeys("FOOD");
		
			 Thread.sleep(3000);
			//Enter Category for Link Modifer
			 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			 Thread.sleep(3000);
			 
			 
			//Click new item creation button
			 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[3]/div[2]/a/i")).click();
			 
				
					//Check whether the new form loaded or not
					if(driver.findElement(By.xpath("//span[.='New Inventory Item']")).getText().equalsIgnoreCase("New Inventory Item"))
					{
						test.log(LogStatus.PASS, "New Inventory Items form loaded Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "New Inventory Items form loaded Failed");
					}
	
					Thread.sleep(3000);
					
					//Clear the name field
					driver.findElement(By.name("name")).clear();
					//Enter the Name
					driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Inventory_Items_Name"));
					Thread.sleep(2000);
					
					
					//Click the Add Category button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[1]/div/div[1]/div[2]/div[2]/a/i")).click();
					Thread.sleep(1000);
					
					//Check Whether the new Category form loaded
					if(driver.findElement(By.xpath("//span[.='New Category']")).getText().equalsIgnoreCase("New Category"))
					{
						test.log(LogStatus.PASS, "New Category form loaded successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "New Category form loaded fail");
					}
					Thread.sleep(2000);
					
					//Clear the name field
					driver.findElement(By.name("masterName")).clear();
					//Enter the required name
					driver.findElement(By.name("masterName")).sendKeys(Utility.getProperty("Inventory_Category_Name_ForModifiers"));
					
					//Clear the description box
					driver.findElement(By.name("description")).clear();
					//Enter the Description
					driver.findElement(By.name("description")).sendKeys("Desc of Inventory Category");
					
					Thread.sleep(2000);
					//Click the Save button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[3]/div/div/button")).click();
					
					Thread.sleep(2000);
					//Click the Category field
					driver.findElement(By.xpath("//div[@id='category_chosen']/a")).click();
					Thread.sleep(2000);
					//Enter the Category location
					driver.findElement(By.xpath("//div[@id='category_chosen']/div/div/input")).click();
					Thread.sleep(2000);
					//Press the Enter button
					driver.findElement(By.xpath("//div[@id='category_chosen']/div/div/input")).sendKeys(Keys.ENTER);
					
					Thread.sleep(3000);
					//Click the Add primary storage button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[1]/div/div[1]/div[3]/div[2]/a/i")).click();
					Thread.sleep(2000);
					
					/*//Click the primary storage field
					driver.findElement(By.xpath("//div[@id='psl_chosen']/a")).click();
					//Enter the storage location
					driver.findElement(By.xpath("//div[@id='psl_chosen']/div/div/input")).sendKeys("Freezer");
					//Press the Enter button
					driver.findElement(By.xpath("//div[@id='psl_chosen']/div/div/input")).sendKeys(Keys.ENTER);
					
					Thread.sleep(3000);
					 //Click the new storage 
				     driver.findElement(By.xpath("//i[@class='fa fa-plus-circle']")).click();
					*/
				     //Check whether the new primary storage location form loaded or not
					if(driver.findElement(By.xpath("//span[.='New Storage']")).getText().equalsIgnoreCase("New Storage"))
					{
						test.log(LogStatus.PASS, "Primary Storage form loaded successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Primary Storage form loaded fail");
					}
					Thread.sleep(2000);
					
					//Clear the name field
					driver.findElement(By.name("masterName")).clear();
					//Enter the required name
					driver.findElement(By.name("masterName")).sendKeys(Utility.getProperty("Inventory_Primary_Storage_Name_ForModifiers"));
					
					//Clear the description field
					driver.findElement(By.name("description")).clear();
					//Enter the required information
					driver.findElement(By.name("description")).sendKeys("Desc of Inventory Primary Storage");
					
					Thread.sleep(2000);
					//Click the Save button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[3]/div/div/button")).click();
							
					Thread.sleep(2000);
					//Click the Inventory Unit Option
					driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/a")).click();
					Thread.sleep(2000);
					//Enter the required Inventory unit
					driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/div/div/input")).sendKeys("Liter");
					Thread.sleep(2000);
					//Press the Enter button
					driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/div/div/input")).sendKeys(Keys.ENTER);
					
					Thread.sleep(2000);
					//Clear the Par level option
					driver.findElement(By.name("minInventoryCount")).clear();
					
					Thread.sleep(2000);
					//Enter the required amount of Par level
					driver.findElement(By.name("minInventoryCount")).sendKeys("1");
					
					Thread.sleep(2000);
					//Click the secondary storage field
					driver.findElement(By.xpath("//div[@id='ssl_chosen']/a")).click();
					Thread.sleep(2000);
					//Enter the storage location
					driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys("Freezer");
					
					Thread.sleep(2000);
					//Press the Enter button
					driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys(Keys.ENTER);
					
					Thread.sleep(2000);
					//Click the Vendor unit
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[2]/ng-form/div/div/div[1]/div[1]/div/div/a")).click();
					//Enter the required vendor
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[2]/ng-form/div/div/div[1]/div[1]/div/div/div/div/input")).sendKeys("Sysco Food");
					//Press the Enter button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[2]/ng-form/div/div/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
					
					
					Thread.sleep(2000);//Clear the Bar code option
					driver.findElement(By.name("barcode")).clear();
					//Enter the required Bar Code
					driver.findElement(By.name("barcode")).sendKeys(Utility.getProperty("Inventory_Sku_OR_Bar_Code_ForModifiers"));
					
					//Clear the Brand Name
					driver.findElement(By.name("brandName")).clear();
					//Enter the required Brand Name
					driver.findElement(By.name("brandName")).sendKeys("Brand");
					
					Thread.sleep(2000);
					//Click the purchase unit option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[2]/ng-form/div/div/div[1]/div[4]/div/div/a")).click();
					Thread.sleep(2000);
					//Enter the required option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[2]/ng-form/div/div/div[1]/div[4]/div/div/div/div/input")).sendKeys("Liter");
					//Press the Enter button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[2]/ng-form/div/div/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
					
					Thread.sleep(2000);
					//Clear the unit multiplier option
					driver.findElement(By.name("purchaseUnitMultiplier")).clear();
					//Enter the required unit multipliuer
					driver.findElement(By.name("purchaseUnitMultiplier")).sendKeys("1");
					
					Thread.sleep(2000);
					//Clear the Quantity option
					driver.findElement(By.name("receivingQuantity")).clear();
					//Enter the required Quantity
					driver.findElement(By.name("receivingQuantity")).sendKeys("1");
					
					
					Thread.sleep(2000);
					//Clear the price option
					driver.findElement(By.name("price")).clear();
					//Enter the required price
					driver.findElement(By.name("price")).sendKeys("115");
					
					Thread.sleep(2000);
					//Clear the yield option
					driver.findElement(By.name("yield")).clear();
					//Enter the required yield
					driver.findElement(By.name("yield")).sendKeys("11");
					
					Thread.sleep(2000);
					//Clear the pricePerUnit option
					driver.findElement(By.name("pricePerUnit")).clear();
					//Enter the required pricePerUnit
					driver.findElement(By.name("pricePerUnit")).sendKeys("75");
					
					Thread.sleep(2000);
					Thread.sleep(2000);
					//Click the Add new vendor option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/ul/li[2]/a/uib-tab-heading/a")).click();
					
					//Click the Vendor unit
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[1]/div/div/a")).click();
					/*//Enter the required vendor  
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[1]/div/div/div/div/input")).sendKeys("Krishna butcher shop");
				*/	//Press the Enter button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
					Thread.sleep(2000);
					Thread.sleep(2000);
					//Clear the Bar code option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[2]/div/input")).clear();
					//Enter the required Bar Code
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("Inventory_Sku_OR_Bar_Code")+"NEW");
					Thread.sleep(2000);
					Thread.sleep(2000);
					//Clear the Brand Name
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[3]/div/input")).clear();
					//Enter the required Brand Name
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[3]/div/input")).sendKeys("Brand");
					
					Thread.sleep(2000);
					//Click the purchase unit option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[4]/div/div/a")).click();
					
					Thread.sleep(2000);//Enter the required option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[4]/div/div/div/div/input")).sendKeys("liter");
					Thread.sleep(2000);//Press the Enter button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
					
					Thread.sleep(2000);
					//Clear the unit multiplier option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[4]/div/input[1]")).clear();
					Thread.sleep(2000);//Enter the required unit multiplier
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[4]/div/input[1]")).sendKeys("1000");
					
					Thread.sleep(2000);
					//Clear the Quantity option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[1]/div/input[1]")).clear();
					//Enter the required Quantity
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[1]/div/input[1]")).sendKeys("1");
					
					Thread.sleep(2000);
					//Clear the price option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[2]/div/input")).clear();
					//Enter the required price
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[2]/div/input")).sendKeys("115");
					
					Thread.sleep(2000);
					//Clear the yield option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[3]/div/input")).clear();
					//Enter the required yield
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[3]/div/input")).sendKeys("10");
					
					Thread.sleep(3000);
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[4]/div/input")).click();
					//Clear the pricePerUnit option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[4]/div/input")).clear();
					//Enter the required pricePerUnit
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[4]/div/input")).sendKeys("75");
					
					Thread.sleep(2000);
					//Click the New Vendor Option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/ul/li[3]/a/uib-tab-heading/a/i")).click();
					
					Thread.sleep(2000);
					//Click the Close Button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/ul/li[3]/a/uib-tab-heading/a/i")).click();
												 
					//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/ul/li[3]/a/uib-tab-heading/a/i
					
					//Click the Yes button in the popup
					driver.findElement(By.linkText("Yes")).click();
					Thread.sleep(3000);
					
					//Clear the Equal field
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div/ng-form/div/div/div[2]/input")).clear();
					//Enter the required number
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div/ng-form/div/div/div[2]/input")).sendKeys("1");
					
					Thread.sleep(2000);
					//Click the Select an Option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div/ng-form/div/div/div[3]/div/a")).click();
					//Enter the required unit
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div/ng-form/div/div/div[3]/div/div/div/input")).sendKeys("Liter");
					//Press the Enter button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div/ng-form/div/div/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
	
					//click price option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[1]/ng-form/div/div/div[4]/div/input")).click();
					//Clear the Price Option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[1]/ng-form/div/div/div[4]/div/input")).clear();
					//Enter the required price per unit
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[1]/ng-form/div/div/div[4]/div/input")).sendKeys("123");
	
					Thread.sleep(3000);
					//Click the Add Recipe Unit Option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[2]/a/i")).click();
					
					Thread.sleep(1000);
					//Clear the Equal field
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[2]/input")).clear();
					//Enter the required number
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[2]/input")).sendKeys("1000");
					
					Thread.sleep(2000);
					//Click the Select an Option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[3]/div/a")).click();
					//Enter the required unit
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[3]/div/div/div/input")).sendKeys("Liter");
					//Press the Enter button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
	
					//click price option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[4]/div/input")).click();
					//Clear the Price Option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[4]/div/input")).clear();
					//Enter the required price per unit
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[4]/div/input")).sendKeys("123");
	
					Thread.sleep(2000);
					//Click the Add Recipe Unit Option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[2]/a/i")).click();
	
					Thread.sleep(2000);
					//Click the Close Button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[3]/ng-form/div/div/div[4]/div/a/i")).click();
					
					Thread.sleep(2000);
					//Click the Yes button in the popup
					driver.findElement(By.linkText("Yes")).click();
					
					//Click the Save button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[4]/div/div/button")).click();
					Thread.sleep(2000);
					
					Thread.sleep(4000);
					//Check whether the new Inventory Items saved or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Inventory item saved successfully!."))
					{
						test.log(LogStatus.PASS, "New Inventory Items Saved Sucessfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "New Inventory Items Save Failed");
					}
	
					Thread.sleep(3000);
				
					Thread.sleep(8000);
		 //Click update button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.ng-binding")).click();
		Thread.sleep(5000);
		
	}
		
		@Test(priority=7)
		public void Inventory_Modifier_SubRecipe_Update(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Clear the Search 
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).clear();
			Thread.sleep(3000);
			//Enter the modifier
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Serach_Inventory_modifiers"));
			Thread.sleep(3000);
			//Enter the modifier
		 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).sendKeys(Keys.ENTER);
			
		 	Thread.sleep(3000);
		 	//Click the modifiers
		 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/a/i")).click();
			
		 	Thread.sleep(3000);
		 	//Check whether link modifiers page opened or not
			if(driver.findElement(By.xpath("//a[.='Link Modifier']")).getText().equalsIgnoreCase("Link Modifier"))
			{
				test.log(LogStatus.PASS, "Link Modifier page loaded Successfully for sub recipe");
			}
			else
			{
				test.log(LogStatus.FAIL, "Link Modifier page loaded Failed for sub recipe");
			}
			
			Thread.sleep(3000);
			//Click the Item Type
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[1]/div/select")).click();
		/*
			Thread.sleep(3000);
			//Select the Item Type
			 Select temp = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[1]/div/select/option[3]")));
			 temp.selectByVisibleText("Sub Recipe");  
			*/
			
			Thread.sleep(6000);
			//Select modifier sub recipe option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[1]/div/select/option[3]")).click();
			Thread.sleep(3000);
			
			 //Click item field 
			 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[2]/div[1]/div/a")).click();
			 Thread.sleep(2000);
			 //Select sub recipe
			 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[2]/div[1]/div/div/div/input")).sendKeys("carrot");
			 Thread.sleep(2000);
			//Enter the selected sub recipe
			 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[2]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			 
			 Thread.sleep(6000);
			 //Click update button
			driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.ng-binding")).click();
				
		
		}
		
		@Test(priority=8)	
		public void Inventory_Modifier__Add_Invetory_Sub_Recipe(WebDriver driver) throws Exception	
		
			{
			Thread.sleep(2000);
				//Clear the Search 
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).clear();
				Thread.sleep(3000);
				//Enter the modifier
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Serach_Inventory_modifiers"));
				Thread.sleep(3000);
				//Enter the modifier
			 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).sendKeys(Keys.ENTER);
				
			 	Thread.sleep(3000);
			 	//Click the modifiers
			 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/a/i")).click();
				
			 	Thread.sleep(3000);
			 	//Check whether link modifiers page opened or not
				if(driver.findElement(By.xpath("//a[.='Link Modifier']")).getText().equalsIgnoreCase("Link Modifier"))
				{
					test.log(LogStatus.PASS, "Link Modifier page loaded Successfully for sub recipe");
				}
				else
				{
					test.log(LogStatus.FAIL, "Link Modifier page loaded Failed for sub recipe");
				}
				
				
				Thread.sleep(3000);
				//Click the Item Type
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[1]/div/select")).click();
			
				Thread.sleep(3000);
				//Select the Item Type
				 Select temp = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div/div/select/option[2]")));
				 temp.selectByVisibleText("Item");  
				
				Thread.sleep(3000);
				//Select modifier subreceipe option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[1]/div/select/option[3]")).click();
				 
				
				Thread.sleep(3000);
				 //Click new sub recipe creation button
				 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[2]/div[2]/a/i")).click();
				 
				 Thread.sleep(3000);				
				 //Check whether the new form loaded or not		
				 if(driver.findElement(By.xpath("//span[.='New SubRecipe']")).getText().equalsIgnoreCase("New SubRecipe"))	
				 {		
					 test.log(LogStatus.PASS, "New SubRecipe form loaded Successfully");	
				 }		
				 else		
				 {			
					 test.log(LogStatus.FAIL, "New SubRecipe form loaded Failed");		
				 }		
				 
				 Thread.sleep(3000);				
				 //Clear the name field		
				 driver.findElement(By.name("name")).clear();		
				 //Enter the Name		
				 driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Inventory_SubRecipe_Name"));		
				 Thread.sleep(2000);			
				 //Enable the Calculate COGS On Cost Price button		
				 driver.findElement(By.name("costPriceBasedCOGS")).click();				
				 Thread.sleep(2000);		
				 //Add Inventory Item		
				 driver.findElement(By.xpath("//i[contains(.,'Inventory Item')]")).click();				
				 Thread.sleep(1000);		
				 //Click the Category Option		
				 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[1]/div/a")).click();		
				 //Enter the required input		
				// driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys("FOOD");		
				 //EPress the Enter button	
				 Thread.sleep(1000);
				 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);	
				 	
				 Thread.sleep(3000);		
				 	//Click the Item		
				 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();		
				//Enter the Required Item		
				//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys("dh");		
				//Press the Enter button		
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);			
				
				Thread.sleep(1000);		
				//Click the Recipe Unit		
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[3]/div/a")).click();		
				//Enter the Required Recipe Unit		
				//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[3]/div/div/div/input")).sendKeys("Pound");	
				//Press the Enter button		
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[3]/div/div/div/input")).sendKeys(Keys.ENTER);				
				
				Thread.sleep(1000);		
				//Clear the Quantity		
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[5]/input")).clear();
				//Enter the required quantity	
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[5]/input")).sendKeys("3");				
				Thread.sleep(2000);
				
				//Add Sub Recipe	
				driver.findElement(By.xpath("//i[contains(.,'Sub Recipe')]")).click();	
				Thread.sleep(1000);	
				//Click the Item	
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[2]/div/a")).click();
				//Enter the Required Item	
				//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[2]/div/div/div/input")).sendKeys("pizza base");	
				//Press the Enter button		
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);	
				Thread.sleep(1000);	
				
				//Click the Recipe Unit	
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[3]/div/a")).click();	
				//Enter the Required Recipe Unit	
				//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[3]/div/div/div/input")).sendKeys("Kilo gram");	
				//Press the Enter button	
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[3]/div/div/div/input")).sendKeys(Keys.ENTER);	
				
				Thread.sleep(1000);	
				//Clear the Quantity		
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[5]/input")).clear();		
				//Enter the required quantity	
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[5]/input")).sendKeys("3");	
				Thread.sleep(2000);	
				
				//Add Manual Entry	
				driver.findElement(By.xpath("//i[contains(.,'Manual Entry')]")).click();	
				Thread.sleep(1000);	
				//clear the Required Item	
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[3]/td[2]/input")).clear();		
				//Enter the required Item		
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[3]/td[2]/input")).sendKeys("Test");	
				Thread.sleep(1000);	
				
				//clear the Price per Unit Option		
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[3]/td[4]/input")).clear();	
				//Enter the Price per Unit
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[3]/td[4]/input")).sendKeys("500");	
				Thread.sleep(1000);		
				
				//Clear the Quantity	
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[3]/td[5]/input")).clear();	
				//Enter the required quantity	
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[3]/td[5]/input")).sendKeys("2");	
				Thread.sleep(2000);	
				
				//Add Inventory Item		
				driver.findElement(By.xpath("//i[contains(.,'Inventory Item')]")).click();	
				Thread.sleep(1500);	
				//Click the Close button for Inventory Item	
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[4]/td[7]/a/i")).click();	
				Thread.sleep(1000);	
				//Click the Yes Button	
				driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();	
				Thread.sleep(3000);					
				//Add Sub Recipe
				driver.findElement(By.xpath("//i[contains(.,'Sub Recipe')]")).click();		
				Thread.sleep(1500);	
				//Click the Close button for Sub Recipe	
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[4]/td[7]/a/i")).click();	
				Thread.sleep(1000);		
				//Click the Yes Button		
				driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();	
				Thread.sleep(1500);				
				
				//Add Manual Entry	
				//Thread.sleep(2000);	
				//driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-valid ng-touched']")).sendKeys("2");
				
					Thread.sleep(2000);		
					//Clear the notes field		
					driver.findElement(By.name("notes")).clear();	
					//Enter the notes	
					driver.findElement(By.name("notes")).sendKeys("Inventory Sub Recipe Notes");	
					Thread.sleep(2000);					
					//Clear the Quantity Field	
					driver.findElement(By.name("receivingQuantity")).clear();	
					//Enter the Quantity		
					driver.findElement(By.name("receivingQuantity")).sendKeys("2");		
					Thread.sleep(1000);				
					//Click the Inventory Unit	
					driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/a")).click();		
					//Enter the Required Inventory Unit		
					driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/div/div/input")).sendKeys("Liter");	
					//Press the Enter button		
					driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/div/div/input")).sendKeys(Keys.ENTER);				
					Thread.sleep(1000);		
					//Clear the Par Level Option		
					driver.findElement(By.id("minInventoryCount")).clear();		
					//Enter the Par Level		
					driver.findElement(By.id("minInventoryCount")).sendKeys("1");				
					Thread.sleep(1000);		
					//Clear the Yield field		
					driver.findElement(By.name("yield")).clear();		
					//Enter the Required Yield		
					driver.findElement(By.name("yield")).sendKeys("20");				
					//Click Add Primary Storage Location		
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[3]/div/div[2]/div[6]/div[2]/a/i")).click();			
					Thread.sleep(1500);	
					//Check whether the New Storage form loaded or not		
					if(driver.findElement(By.xpath("//span[.='New Storage']")).getText().equalsIgnoreCase("New Storage"))	
					{			
						test.log(LogStatus.PASS, "New Storage form Loaded Successfully");	
						}		
					else	
						{			test.log(LogStatus.FAIL, "New Storage form Loaded Failed");		
						}		
					
					Thread.sleep(2000);			
						
						
						//Clear the name field		
						driver.findElement(By.id("masterName")).clear();		
						//Enter the name		
						driver.findElement(By.id("masterName")).sendKeys(Utility.getProperty("Inventory_SubRecipe_Primary_Storage_Name_ForModifier"));				
						Thread.sleep(1000);		
						//Clear the Description		
						driver.findElement(By.id("description")).clear();		
						//Enter the Description		
						driver.findElement(By.id("description")).sendKeys("Desc of Primary Storage");				
						//Click the Save button		
						driver.findElement(By.xpath("//button[@type='submit']")).click();		
						
						Thread.sleep(2500);			
						//Click the Secondary Storage Location		
						driver.findElement(By.xpath("//div[@id='ssl_chosen']/a")).click();		
						//Enter the Secondary Storage Location		
						driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys("Freezer");		
						//Press the Enter button		
						driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys(Keys.ENTER);		
						
						Thread.sleep(1000);		
						//Clear the Input field		
						driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-valid ng-touched']")).clear();		
						//Enter the required Input	
					 	driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-valid ng-touched']")).sendKeys("2");
					 	
					
						Thread.sleep(1000);		
						//Click the Required option				
						driver.findElement(By.xpath("//a[@class='chosen-single chosen-default']")).click();		
						Thread.sleep(1000);		
						//Enter the Required Option		
						driver.findElement(By.xpath("//div[@class='chosen-container chosen-container-single chosen-with-drop chosen-container-active']/div/div/input")).sendKeys("Liter");	
						//Press the Enter button	
						driver.findElement(By.xpath("//div[@class='chosen-container chosen-container-single chosen-with-drop chosen-container-active']/div/div/input")).sendKeys(Keys.ENTER);			
						driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
						
						Thread.sleep(5000);		
						//Click the Save button		
						driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();		
						
					Thread.sleep(7000);
				
					//Click update button
					driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.ng-binding")).click();
				
				 	Thread.sleep(5000);
				  	//Check whether the new Inventory Items saved or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Modifier updated sucessfully!."))
					{
						test.log(LogStatus.PASS, "Modifier updated sucessfully for sub recipe");
					}
					else
					{
						test.log(LogStatus.FAIL, "Modifier updated Failed for sub recipe");
					}
				Thread.sleep(3000);
				}
			
		@Test(priority=9)	
		public void Inventory_Modifier__Add_Invetory_Menu_Item(WebDriver driver) throws Exception	
		
			{
				//Clear the Search 
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).clear();
				Thread.sleep(3000);
				//Enter the modifier
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Serach_Inventory_modifiers"));
				Thread.sleep(3000);
				//Enter the modifier
			 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).sendKeys(Keys.ENTER);
				
			 	Thread.sleep(3000);
			 	//Click the modifiers
			 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/a/i")).click();
				
			 	Thread.sleep(3000);
			 	//Check whether link modifiers page opened or not
				if(driver.findElement(By.xpath("//a[.='Link Modifier']")).getText().equalsIgnoreCase("Link Modifier"))
				{
					test.log(LogStatus.PASS, "Link Modifier page loaded Successfully for Menu Item");
				}
				else
				{
					test.log(LogStatus.FAIL, "Link Modifier page loaded Failed for Menu Item");
				}
				
				
				Thread.sleep(3000);
				//Click the Item Type
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[1]/div/select")).click();
			
				Thread.sleep(3000);
				//Select the Item Type
				 Select temp = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div/div/select/option[2]")));
				 temp.selectByVisibleText("Item");  
				
				Thread.sleep(3000);
				//Select modifier level Menu item option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[1]/div/select/option[4]")).click();
				 
				Thread.sleep(3000);
				 //Click new item creation button
				 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[2]/div/div/a")).click();
				//Select new item creation button
				 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div/input")).sendKeys("CHEE LATTU");
				//Enter new item creation button
				 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				 
				 Thread.sleep(2000);
				   //Click update button
					driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.ng-binding")).click();
					
			
					Thread.sleep(5000);
				  	//Check whether the new Inventory Items saved or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Modifier updated sucessfully!."))
					{
						test.log(LogStatus.PASS, "Modifier updated sucessfully for Menu item");
					}
					else
					{
						test.log(LogStatus.FAIL, "Modifier updated Failed for Menu item");
					}
				Thread.sleep(3000);
				}	
				 	
		@Test(priority=10)	
		public void Inventory_Modifier__Add_Not_an_InventoryItem(WebDriver driver) throws Exception	
		
			{
				//Clear the Search 
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).clear();
				Thread.sleep(3000);
				//Enter the modifier
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Serach_Inventory_modifiers"));
				Thread.sleep(3000);
				//Enter the modifier
			 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/div[2]/label/input")).sendKeys(Keys.ENTER);
				
			 	Thread.sleep(3000);
			 	//Click the modifiers
			 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/a/i")).click();
				
			 	Thread.sleep(3000);
			 	//Check whether link modifiers page opened or not
				if(driver.findElement(By.xpath("//a[.='Link Modifier']")).getText().equalsIgnoreCase("Link Modifier"))
				{
					test.log(LogStatus.PASS, "Link Modifier page loaded Successfully for Menu Item");
				}
				else
				{
					test.log(LogStatus.FAIL, "Link Modifier page loaded Failed for Menu Item");
				}
				
				
				Thread.sleep(3000);
				//Click the Item Type
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div[1]/div/select")).click();
			
				Thread.sleep(3000);
				//Select the Item Type
				 Select temp = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div/div/select/option[2]")));
				 temp.selectByVisibleText("Item");  
				
				Thread.sleep(3000);
				//Select modifier level Menu item option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div[1]/div/div/div/div[2]/div/div/div/div/div/select/option[5]")).click();
				 
				Thread.sleep(2000);
				//Click update button
					driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.ng-binding")).click();
					
			
					Thread.sleep(5000);
				  	//Check whether the new Inventory Items saved or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Modifier updated sucessfully!."))
					{
						test.log(LogStatus.PASS, "Modifier updated sucessfully for Menu item");
					}
					else
					{
						test.log(LogStatus.FAIL, "Modifier updated Failed for Menu item");
					}
				Thread.sleep(3000);
				}
		
		@Test(priority=11)
		public void Inventory_Menu_Items_OpenPage(WebDriver driver) throws Exception
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
		public void Inventory_Menu_Items_refresh_page(WebDriver driver) throws InterruptedException
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
		public void Inventory_Menu_Items_verify_UnLinked_TO_Linked(WebDriver driver) throws Exception
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
		public void Inventory_Menu_Items_edit_Linked_Type_of_Menu_Item_Inv(WebDriver driver) throws Exception
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
		public void Inventory_Menu_Items_edit_Linked_Type_of_Menu_Item_Inv_Sub(WebDriver driver) throws Exception
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
		public void Inventory_Menu_Items_edit_Linked_Type_of_Menu_Item_Inv_Manual(WebDriver driver) throws Exception
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
		public void Inventory_Menu_Items_edit_Linked_Type_of_Menu_Item_Sub_Manual(WebDriver driver) throws Exception
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
		public void Inventory_Menu_Items_edit_Linked_Type_of_Menu_Item_Sub_Sub(WebDriver driver) throws Exception
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
		public void Inventory_Menu_Items_edit_Linked_Type_of_Menu_Item_Manual_Manual(WebDriver driver) throws Exception
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
		public void Inventory_Menu_Items_verify_Linked_Type_of_Menu_Items_TO_UnLinked_Type_of_Menu_Items(WebDriver driver) throws Exception
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
		public void Inventory_Menu_Items_verifyActive_InActiveButton_Sub_Recipe(WebDriver driver) throws Exception
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
		
		@Test(priority=23)
		public void Adjust_Inventory_Reasons_openpage (WebDriver driver) throws Exception
		{
			Thread.sleep(5000);
			
			//Get the URl
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"adjustInventoryItemReasons");
					
			//Check In Adjust Inventory Reasons page opened or not
			if(driver.findElement(By.xpath("//a[.='Adjust Inventory Reasons']")).getText().equalsIgnoreCase("Adjust Inventory Reasons"))
			{
				test.log(LogStatus.PASS, "Adjust Inventory Reasons page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Adjust Inventory Reasons page loaded Failed");
			}
			
			Thread.sleep(5000);
			
		}
		
		@Test(priority=24)
		public void Adjust_Inventory_Reasons_refresh(WebDriver driver) throws InterruptedException
		{
			Thread.sleep(3000);
			//Click the refresh button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a/i")).click();
			Thread.sleep(3000);
			//Check In Adjust Inventory Reasons page opened or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Reasons"))
			{
				test.log(LogStatus.PASS, "Adjust Inventory Reasons page refreshed Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Adjust Inventory Reasons page refreshed Failed");
			}
			Thread.sleep(3000);
	
		}
	
		@Test(priority=26)
		public void Adjust_Inventory_Reasons_add_PAge(WebDriver driver) throws Exception
		{
			Thread.sleep(5000);
			//Click on the Add  Adjust Inventory Reasons  option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/button")).click();
			Thread.sleep(3000);
			
			Thread.sleep(3000);
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("New_InventoryReason_name_ForModifier"));
							
			Thread.sleep(2000);
			//Select the Increase button
			Select Type1 = new Select(driver.findElement(By.xpath("//select[@ng-model='reason.reasonType']")));
			Type1.selectByVisibleText("Increase");
			
			//Click the Save button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			
			//Check whether the new In House Units saved or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Reason saved successfully!."))
			{
				test.log(LogStatus.PASS, "Reason saved successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Reason saved Failed");
			}
	
			Thread.sleep(5000);
		}
		
		@Test(priority=27)
		public void Adjust_Inventory_Reasons_edit(WebDriver driver) throws Exception
		{
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("New_InventoryReason_name_ForModifier"));
			//Click the Edit icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			Thread.sleep(5000);
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("New_InventoryReason_name_ForModifier")+"1");
			Thread.sleep(3000);
			
			Thread.sleep(2000);
			//Select the Increase button
			Select Type1 = new Select(driver.findElement(By.xpath("//select[@ng-model='reason.reasonType']")));
			Type1.selectByVisibleText("Decrease");
			
			
			//Click the update
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
	
			//Check whether the In House Units updated successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Reason updated successfully."))
			{
				test.log(LogStatus.PASS, "Reason updated successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Reason updated Failed");
			}
	
			Thread.sleep(5000);
	
		}
		
		@Test(priority=28)
		public void Adjust_Inventory_Reasons_delete(WebDriver driver) throws Exception
		{
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("New_InventoryReason_name_ForModifier")+"1");
			
			//Click the Delete button
			driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
			
			//Click the Yes button in the popup
			driver.findElement(By.linkText("Yes")).click();
			Thread.sleep(3000);
			
			//Check the In House Units deleted or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Reason InActivated Successfully"))
			{
				test.log(LogStatus.PASS, "Reason InActivated Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Reason InActivated Failed");
			}
	
			Thread.sleep(5000);
		
	
			//Click the Active Button
			driver.findElement(By.xpath("//input[@ng-model='activeStatus']")).click();
			Thread.sleep(3000);
			
			//Click the success button
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
			Thread.sleep(1000);
			
			//Click the Yes button in the popup
			driver.findElement(By.linkText("Yes")).click();
			Thread.sleep(3000);
			
			//Check the In House Units activated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Reason Activated Successfully"))
			{
				test.log(LogStatus.PASS, "Reason Activated Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Reason Activated Failed");
			}
			
			Thread.sleep(5000);
		}
	
		@Test(priority=29)
		public void Adjust_Inventory_Reasons_closeButton(WebDriver driver) throws Exception
		{
			Thread.sleep(3000);
			//Click on the Add  Adjust Inventory Reasons  option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/button")).click();
										
			Thread.sleep(3000);
			//Check whether the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New Reason']")).getText().equalsIgnoreCase("New Reason"))
			{
				test.log(LogStatus.PASS, "New Reason loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Reason form loaded Failed");
			}
	
			Thread.sleep(3000);
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("New_InventoryReason_name_ForModifier"));
			
			Thread.sleep(3000);
			//Click the Cancel button
			driver.findElement(By.xpath("//a[.='Close']")).click();
			
			
			Thread.sleep(5000);
			//Check whether the new New Reason canceled or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/button")).isDisplayed())
			{
				test.log(LogStatus.PASS, "New Reason Canceled Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Reason Canceled Failed");
			}
	
			Thread.sleep(3000);
		}
		
		@Test(priority=30)
		public void Adjust_Inventory_Reasons_verifyActive_InActiveButton(WebDriver driver) throws Exception
		{
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			
			Thread.sleep(5000);
			//Click Active or In Active Button
			driver.findElement(By.xpath("//input[@ng-model='activeStatus']")).click();
	
			Thread.sleep(5000);
			//Check the Inactive page is loaded or not
			if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Deleted categories are here, we are in InActive Page");
				Thread.sleep(10000);
				//Click Active or In Active Button
				driver.findElement(By.xpath("//input[@ng-model='activeStatus']")).click();
	
			}
			else if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Deleted In House Units are not here, we are in Active Page");
			}
			Thread.sleep(5000);
		}
	
		@Test(priority=31)
		public void Adjust_Inventory_Openpage(WebDriver driver) throws Exception
		{
		
			//Get the URl
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"adjustInventoryItem");
		
			Thread.sleep(5000);
			//Check Inventory Items page opened or not
			if(driver.findElement(By.xpath("//a[.='Adjust Inventory']")).getText().equalsIgnoreCase("Adjust Inventory"))
			{
				test.log(LogStatus.PASS, "Adjust Inventory page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Adjust Inventory page loaded Failed");
			}
			
			Thread.sleep(5000);
			
		}
		
		@Test(priority=33)
		public void  Adjust_Inventory_item_Close_button(WebDriver driver) throws Exception
		{
		
		Thread.sleep(3000);
		//Clear the Search 
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div/label/input")).clear();
		Thread.sleep(3000);
		//Enter the Adjust Inventory item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div/label/input")).sendKeys(Utility.getProperty("Inventory_Items_Name"));
		Thread.sleep(3000);
		//Enter the Adjust Inventory item
	 	//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div/label/input")).sendKeys(Keys.ENTER);
	 	Thread.sleep(3000);
	 	//Click the Adjust Inventory item
	 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/table/tbody/tr/td[4]/span/a/i")).click();
		
	 	Thread.sleep(3000);
	 	//Check whether  Adjust Inventory item page opened or not
		if(driver.findElement(By.xpath("//a[.='Adjust Inventory']")).getText().equalsIgnoreCase("Adjust Inventory"))
		{
			test.log(LogStatus.PASS, " New Adjust Inventory item page loaded Successfully for close button");
		}
		else
		{
			test.log(LogStatus.FAIL, " New Adjust Inventory item page loaded Failed for close button");
		}
		Thread.sleep(3000);			
		//Create new reason type for increase method
	 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[2]/span/a/i")).click();
	 	
	 	Thread.sleep(3000);
	 	//Clear the new reason name
	 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[1]/div/input")).clear();
	 	//Enter the new reason name
	 	 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("Increase_Inventory_Reason_name_ForModifier"));
	
	 	Thread.sleep(3000);
	  	//Click the new reason name
	  	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[2]/div/select")).click();
	  	
	  	Thread.sleep(3000);
	  	//Click increase button
	  	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[2]/div/select/option[1]")).click();
	  	
	  	//Thread.sleep(3000);
		 //Select reasontype = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[2]/div/select/option[1]")));
		// reasontype.selectByVisibleText("Item"); 
	 	
		 Thread.sleep(5000);
	 	// Click close button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[3]/div/div/div/a[1]")).click();		
	 	
	 	    Thread.sleep(3000);
	 	    //Click close button for new adjust inventory 
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div/div/a")).click();
			Thread.sleep(5000);
			//Check Inventory Items page opened or not
			if(driver.findElement(By.xpath("//a[.='Adjust Inventory']")).getText().equalsIgnoreCase("Adjust Inventory"))
			{
				test.log(LogStatus.PASS, "Adjust Inventory page loaded Successfully for close button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Adjust Inventory page loaded Failed for close button");
			}
	 	Thread.sleep(5000);	
		}
		
		@Test(priority=34)
		public void  Adjust_Inventory_item_Update_button_Increase(WebDriver driver) throws Exception
		{
		
		Thread.sleep(3000);
		//Clear the Search 
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div/label/input")).clear();
		Thread.sleep(3000);
		//Enter the Adjust Inventory item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div/label/input")).sendKeys(Utility.getProperty("Inventory_Items_Name"));
		Thread.sleep(3000);
		//Enter the Adjust Inventory item
	 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div/label/input")).sendKeys(Keys.ENTER);
	 	Thread.sleep(3000);
	 	//Click the Adjust Inventory item
	 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/table/tbody/tr/td[4]/span/a/i")).click();
		
	 	Thread.sleep(3000);
	 	//Check whether  Adjust Inventory item page opened or not
		if(driver.findElement(By.xpath("//a[.='Adjust Inventory']")).getText().equalsIgnoreCase("Adjust Inventory"))
		{
			test.log(LogStatus.PASS, " Increase reason ,Adjust Inventory item page loaded Successfully for update button");
		}
		else
		{
			test.log(LogStatus.FAIL, " Increase reason ,Adjust Inventory item page loaded Failed for update button");
		}
		Thread.sleep(3000);			
		//Create new reason type for increase method
	 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[2]/span/a/i")).click();
	 	
	 	Thread.sleep(3000);
	 	//Clear the new reason name
	 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[1]/div/input")).clear();
	 	//Enter the new reason name
	 	 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("Increase_Inventory_Reason_name"));
	
	 	Thread.sleep(3000);
	  	//Click the new reason name
	  	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[2]/div/select")).click();
	  	
	  	Thread.sleep(3000);
	  	//Click increase button
	  	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[2]/div/select/option[1]")).click();
	  	Thread.sleep(3000);
	  	//Thread.sleep(3000);
		 //Select reasontype = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[2]/div/select/option[1]")));
		// reasontype.selectByVisibleText("Item"); 
	 	
		 Thread.sleep(5000);
	 	// Click save button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[3]/div/div/div/a[2]")).click();		
		
		Thread.sleep(3000);
		//Clear the increase inventory Vendor option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[4]/div/ng-form/input[2]")).clear();
		//Enter the increase inventory Vendor Quantity
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[4]/div/ng-form/input[2]")).sendKeys("70000");
		//Enter the increase inventory Vendor Quantity
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[4]/div/ng-form/input[2]")).sendKeys(Keys.ENTER);
			
		Thread.sleep(3000);
		//Clear the inventory notes option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[5]/textarea")).clear();
		//Enter the inventory notes
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[5]/textarea")).sendKeys("Needed more");
		//Enter the inventory notes
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[5]/textarea")).sendKeys(Keys.ENTER);
					
		
	 	Thread.sleep(3000);
	 	//Click Adjust button for new adjust inventory 
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[6]/div/button")).click();
			Thread.sleep(3000);
			//Check new adjust inventory button update successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Stock adjusted successfully"))
			{
				test.log(LogStatus.PASS, "Stock adjusted successfully for Increase reason");
			}
			else
			{
				test.log(LogStatus.FAIL, "Stock adjusted successfully for Increase reason");
			}
			
	 	Thread.sleep(5000);	
		}
			
		@Test(priority=35)
		public void  Adjust_Inventory_item_Update_button_Decrease(WebDriver driver) throws Exception
		{
		
		Thread.sleep(3000);
		//Clear the Search 
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div/label/input")).clear();
		Thread.sleep(3000);
		//Enter the Adjust Inventory item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div/label/input")).sendKeys(Utility.getProperty("Inventory_Items_Name"));
		Thread.sleep(3000);
		//Enter the Adjust Inventory item
	 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div/label/input")).sendKeys(Keys.ENTER);
	 	Thread.sleep(3000);
	 	//Click the Adjust Inventory item
	 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/table/tbody/tr/td[4]/span/a/i")).click();
		
	 	Thread.sleep(3000);
	 	//Check whether  Adjust Inventory item page opened or not
		if(driver.findElement(By.xpath("//a[.='Adjust Inventory']")).getText().equalsIgnoreCase("Adjust Inventory"))
		{
			test.log(LogStatus.PASS, " Decrease reason ,Adjust Inventory item page loaded Successfully for update button");
		}
		else
		{
			test.log(LogStatus.FAIL, " Decrease reason ,Adjust Inventory item page loaded Failed for update button");
		}
		Thread.sleep(3000);			
		//Create new reason type for increase method
	 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[2]/span/a/i")).click();
	 	
	 	Thread.sleep(3000);
	 	//Clear the new reason name
	 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[1]/div/input")).clear();
	 	//Enter the new reason name
	 	 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("Decrease_Inventory_Reason_name"));
	
	 	Thread.sleep(3000);
	  	//Click the new reason name
	  	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[2]/div/select")).click();
	  	
	  	Thread.sleep(3000);
	  	//Click Decrease button
	  	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[2]/div/select/option[2]")).click();
	  	Thread.sleep(3000);
	  	//Thread.sleep(3000);
		 //Select reasontype = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[2]/div/select/option[1]")));
		// reasontype.selectByVisibleText("Item"); 
	 	
		 Thread.sleep(5000);
	 	// Click save button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[3]/div/div[2]/form/div[3]/div/div/div/a[2]")).click();		
		
		Thread.sleep(3000);
		//Clear the inventory count option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[4]/div/ng-form/input[2]")).clear();
		//Enter the inventory count Quantity
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[4]/div/ng-form/input[2]")).sendKeys("6000");
		//Enter the inventory count Quantity
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[4]/div/ng-form/input[2]")).sendKeys(Keys.ENTER);
			
		Thread.sleep(3000);
		//Clear the inventory notes option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div/textarea")).clear();
		//Enter the inventory notes
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div/textarea")).sendKeys("Needed Less");
		//Enter the inventory notes
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div/textarea")).sendKeys(Keys.ENTER);
					
	 	Thread.sleep(3000);
	 	//Click Adjust button for update new adjust inventory 
		driver.findElement(By.xpath("//span[.='Adjust']")).click();
		Thread.sleep(5000);
		//Check new adjust inventory button update successfully or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Stock adjusted successfully"))
		{
			test.log(LogStatus.PASS, "Stock adjusted successfully for Decrease reason");
		}
		else
		{
			test.log(LogStatus.FAIL, "Stock adjusted successfully for Decrease reason");
		}
		
		
	 	Thread.sleep(5000);	
		}
	
		@Test(priority=36)
		public void  Adjust_Inventory_item_Bulk_update(WebDriver driver) throws Exception
		{
			Thread.sleep(3000);
			//Click bulk update button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[2]")).click();
		
			Thread.sleep(2000);
			//Click refresh button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a[1]/i")).click();
	
			Thread.sleep(4000);
			//clear the search box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/label/input")).clear();
			//Search the  Adjust Inventory Item option	
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/label/input")).sendKeys(Utility.getProperty("Inventory_Items_Name"));
			
			Thread.sleep(2000);
			//Click the reason type
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[5]/div/a")).click();
			//Enter the required reason type
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[5]/div/div/div/input")).sendKeys(Utility.getProperty("Decrease_Inventory_Reason_name"));
			//Enter the required reason type
	    	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[5]/div/div/div/input")).sendKeys(Keys.ENTER);
					
			Thread.sleep(2000);
			//clear the notes for bulk updates
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[8]")).clear();
			//Enter the reason
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[8]")).sendKeys("Adengappa");
					
			Thread.sleep(4000);
			//clear the search box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[6]/div/input")).clear();
			//Search the  Adjust Inventory Item option	
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[6]/div/input")).sendKeys("0");
			
			Thread.sleep(4000);
			//click Apply Changes button
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success.btn-border-green.ng-binding")).click();
			
		}
	
		@Test(priority=37)
		public void  Adjust_Subrecipe_Bulk_update(WebDriver driver) throws Exception
		{
			Thread.sleep(6000);
			//Click bulk update button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[2]")).click();
		
			Thread.sleep(4000);
			//clear the search box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/label/input")).clear();
			//Search the  Adjust Inventory Item option	
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/label/input")).sendKeys(Utility.getProperty("Search_Subrecipe"));
			
			Thread.sleep(2000);
			//Click the reason type
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[5]/div/a")).click();
			//Enter the required reason type
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[5]/div/div/div/input")).sendKeys("INC1");
			//Enter the reason
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[5]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(4000);
			//clear the search box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[6]/div/input")).clear();
			//Search the  Adjust Inventory Item option	
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[6]/div/input")).sendKeys("0");
			
			Thread.sleep(4000);
			//click update button
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success.btn-border-green.ng-binding")).click();
			
		}
	
		@Test(priority=38)
		public void  Adjust_Bulk_update_Backbutton(WebDriver driver) throws Exception
		{
			Thread.sleep(5000);
			//Click bulk update button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[2]")).click();
		
			Thread.sleep(3000);
			//Click back button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a[3]/span")).click();
			
			Thread.sleep(5000);
			//Check Inventory Items page opened or not
			if(driver.findElement(By.xpath("//a[.='Adjust Inventory']")).getText().equalsIgnoreCase("Adjust Inventory"))
			{
				test.log(LogStatus.PASS, "Adjust Inventory page loaded Successfully after click bulk update back button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Adjust Inventory page loaded Failed after click bulk update back button");
			}
			
			Thread.sleep(5000);
		}
	
		@Test(priority=39)
		public void Inventory_Low_stock_Openpage(WebDriver driver) throws Exception
		{
	
			Thread.sleep(5000);
			//Get the URl
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"lowStock");
	
			
			//Check Low stock management page opened or not
			if(driver.findElement(By.xpath("//a[.='Low stock management']")).getText().equalsIgnoreCase("Low stock management"))
			{
				test.log(LogStatus.PASS, "Low stock management page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Low stock management page loaded Failed");
			}
			
			Thread.sleep(5000);
		}
		
	/*	@Test(priority=40)
		public void Inventory_Low_stock_Create_Purchase_Order(WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(5000);
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//div[@id='createPurchaseOrder']"));
			//Scroll the page till the Inventory Menu Items option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
			
			//Scroll the web page
		    for(int i=1; i <= 20; i++)
		    {
		    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		    	Thread.sleep(1000);
		    }
		    
			Thread.sleep(5000);
			//Check whether the Create Purchase Order Available
			if(driver.findElement(By.xpath("//div[@ng-if='lowStock.vendorId']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Create Purchase Order is available in Low Stocks");
				List<WebElement> purchaseOrder = driver.findElements(By.xpath("//div[@ng-if='lowStock.vendorId']"));
				purchaseOrder.size();
				
				System.out.println("Count :"+purchaseOrder.size());
				
				// Create instance of Java script executor
				JavascriptExecutor je2 = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element2 = driver.findElement(By.xpath("//div[@ng-if='lowStock.vendorId']"));
				//Scroll the page till the Inventory Menu Items option present
				je2.executeScript("arguments[0].scrollIntoView(true);",element2); 
		       //To identify the Element
				System.out.println("gettext : "+driver.findElement(By.xpath("//div[@ng-if='lowStock.vendorId']/a")).getText());
				
				//Click the createPurchaseOrder Option		
				driver.findElement(By.xpath("//div[@ng-if='lowStock.vendorId']")).click();
				Thread.sleep(3000);
				
				//Scroll the web page
			    for(int i=1; i <= 30; i++)
			    {
			    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
			    	Thread.sleep(1000);
			    }
				//Click the Calendar icon
				driver.findElement(By.xpath("//span[@class='input-group-btn']")).click();
				//Enter the Current Date
				driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm active']")).click();
				
				Thread.sleep(5000);
				//Select the required placed order via option
				Select placeOrederVia = new Select(driver.findElement(By.name("placedVia")));
				placeOrederVia.selectByVisibleText("Email");
	
				Thread.sleep(2000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.END);
				driver.findElement(By.tagName("html")).sendKeys(Keys.END);
				
				Thread.sleep(5000);
				//Click the Place Order Option
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				
				Thread.sleep(2000);
				//Check whether the order is placed or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Purchase order saved successfully!."))
				{
					test.log(LogStatus.PASS, "Purchase order saved Sucessfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Purchase order saved Failed");
				}
				Thread.sleep(5000);
				
				
				//Click the Receiving Order Option
				driver.findElement(By.cssSelector("i.fa.fa-recycle")).click();
				
				Thread.sleep(4000);
				//Click the Submit button
				driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
				
				Thread.sleep(2000);
				//Check whether the Receive information updated or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Receive information updated."))
				{
					test.log(LogStatus.PASS, "Receive information updated Sucessfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Receive information updated Failed");
				}
				Thread.sleep(5000);
				
				// Create instance of Java script executor
				JavascriptExecutor je1 = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element1 = driver.findElement(By.xpath("//span[contains(.,'Low Stocks')]"));
				//Scroll the page till the Inventory Menu Items option present
				je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
		      
				//Click the Purchases Option		
				driver.findElement(By.xpath("//span[contains(.,'Low Stocks')]")).click();
				Thread.sleep(5000);
			}
			else
			{
				test.log(LogStatus.FAIL, "There is no Low Stocks Available for Purchase Order");
			}
		}
	*/
		@Test(priority=41)
		public void Inventory_Low_stock_prepare_SubRecipe(WebDriver driver) throws Exception
		{
			Thread.sleep(5000);
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//div[@id='prepareSubRecipe']"));
			//Scroll the page till the Inventory Menu Items option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
			
			Thread.sleep(5000);
			//Check whether the Create Purchase Order Available
			if(driver.findElement(By.xpath("//div[@ng-if='!lowStock.vendorId']")).isDisplayed())
				
			{
				test.log(LogStatus.PASS, "Prepare Subrecipe is available in Low Stocks");
				List<WebElement> prepareSubRecipe = driver.findElements(By.xpath("//div[@ng-if='!lowStock.vendorId']"));
				prepareSubRecipe.size();											
				
				// Create instance of Java script executor
				JavascriptExecutor je2 = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element2 = driver.findElement(By.xpath("//div[@ng-if='!lowStock.vendorId']"));
				//Scroll the page till the Inventory Menu Items option present
				je2.executeScript("arguments[0].scrollIntoView(true);",element2);
		        
				Thread.sleep(2000);
				 //To identify the Element
				System.out.println("gettext : "+driver.findElement(By.xpath("//div[@ng-if='!lowStock.vendorId']/a")).getText());
				
				Thread.sleep(2000);
				//Click the prepareSubRecipe Option		
				driver.findElement(By.xpath("//div[@ng-if='!lowStock.vendorId']")).click();
				Thread.sleep(4000);
				
				Thread.sleep(6000);
				//Click the SubRecipe option
				driver.findElement(By.xpath("//div[@id='subRecipe_chosen']/a")).click();
				Thread.sleep(2000);
				//Enter the SubRecipe option
			    driver.findElement(By.xpath("//div[@id='subRecipe_chosen']/div/div/input")).sendKeys(Utility.getProperty("subRecipe_name"));
			  //Enter the SubRecipe option
			   driver.findElement(By.xpath("//div[@id='subRecipe_chosen']/div/div/input")).sendKeys(Keys.ENTER);
			   
				Thread.sleep(2000);
				//Clear the quantity option
				driver.findElement(By.name("quantity")).clear();
				Thread.sleep(2000);
				//Enter the quantity option
			    driver.findElement(By.name("quantity")).sendKeys("1");
			    Thread.sleep(2000);
	
				Thread.sleep(4000);
						//Click the primary storage
						driver.findElement(By.xpath("//div[@id='psl_chosen']/a")).click();
						//Thread.sleep(2000);
						//Enter the primary storage
					   //driver.findElement(By.xpath("//div[@id='psl_chosen']/div/div/input")).sendKeys(Utility.getProperty("Inventory_Primary_Storage_Name"));
					  //Enter the primary storage
			driver.findElement(By.xpath("//div[@id='psl_chosen']/div/div/input")).sendKeys(Keys.ENTER);
				
						Thread.sleep(4000);
						//Click the Secondary storage
						driver.findElement(By.xpath("//div[@id='ssl_chosen']/a")).click();
						Thread.sleep(2000);
						//Enter the Secondary storage
					    driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys(Utility.getProperty("Inventory_Secondary_Storage_Name"));
					  //Enter the Secondary storage
					   driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys(Keys.ENTER);
					   
			    Thread.sleep(5000);
				driver.findElement(By.xpath("//span[.='Save and Continue']")).click();
				
				Thread.sleep(5000);
				//Check Receive Inventory saved or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub recipe prepared successfully"))
				{
					test.log(LogStatus.PASS, "Sub recipe prepared successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Sub recipe prepared Failed");
				}
				Thread.sleep(5000);
				
				// Create instance of Java script executor
				JavascriptExecutor je1 = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element1 = driver.findElement(By.xpath("//span[contains(.,'Low Stocks')]"));
				//Scroll the page till the Inventory Menu Items option present
				je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
		        //Click the Purchases Option		
				driver.findElement(By.xpath("//span[contains(.,'Low Stocks')]")).click();
				Thread.sleep(5000);	
				
			}
			else
			{
				test.log(LogStatus.FAIL, "There is no Low Stocks Available for Prepare Subrecipe");
			}
		}
	
		@Test(priority=42)
		public void Inventory_Store_setting_Pageopen(WebDriver driver) throws Exception
		{
	
			
			//Get the URl
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"storeSetting");
					
		
			Thread.sleep(5000);
			//Check Inventory Items page opened or not
			if(driver.findElement(By.xpath("//a[.='Store setting']")).getText().equalsIgnoreCase("Store setting"))
			{
				test.log(LogStatus.PASS, " Store setting page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, " Store setting page loaded Failed");
			}
			
			Thread.sleep(5000);
			
		}
	
		@Test(priority=43)
		public void Inventory_Store_setting_Process(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Clear the Business Date
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/form/div[1]/div/div/input")).clear();
			//Enter the Business Date
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/form/div[1]/div/div/input")).sendKeys(Utility.getProperty("Inventory_Business_Date"));
			
			// Create object of SimpleDateFormat class and decide the format
			 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
	
			 //get current date time with Date()
			 Date date = new Date(0);
	
			 // Now format the date
		 String date1= dateFormat.format(date);
	
			 // Print the Date
		 System.out.println(date1);
			
			Thread.sleep(2000);
			//Check whether the Summary Alert field is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='item.lowStockSummary']")).isSelected()){}
			
			else
			{
				//Enable the Summary Alert Option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/form/div[2]/div/div/input")).click();
			}
			
	
		Thread.sleep(3000);
		//Clear the EmailID's Summary Alert
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/form/div[3]/div/div/textarea")).clear();
		//Enter the EmailID's Summary Alert
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/form/div[3]/div/div/textarea")).sendKeys(Utility.getProperty("Inventory_SummaryEmailID"));
	
		Thread.sleep(3000);
		//Clear the Vendor's CC Alert
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/form/div[4]/div/div/textarea")).clear();
		//Enter the Vendor's CC
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/form/div[4]/div/div/textarea")).sendKeys(Utility.getProperty("Inventory_VendorEmailID"));
		
		Thread.sleep(2000);	
		//Click Update Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/form/div[5]/div/button")).click();
		
		Thread.sleep(3000);
		//Check Inventory Items page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Settings updated successfully"))
		{
			test.log(LogStatus.PASS, " Store setting updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, " Store setting updated Failed");
		}
		Thread.sleep(3000);
		}	
	
		@Test(priority=44)
		public void Inventory_Transfer_Requests_Pageopen(WebDriver driver) throws Exception
		{
	
			//Get the URl
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"transfer");
			
			Thread.sleep(3000);
			//Check Inventory Items page opened or not
			if(driver.findElement(By.xpath("//div[@id='navigation']/ul[1]/li/a")).getText().equalsIgnoreCase("Transfer Requests"))
			{
				test.log(LogStatus.PASS, " Transfer Requests page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, " Transfer Requests page loaded Failed");
			}
			
			Thread.sleep(3000);
			
		}
	
		@Test(priority=45)
		public void Inventory_TransferRequest_Refresh(WebDriver driver) throws InterruptedException
		{
			Thread.sleep(2000);
			//Click refresh the button for Transfer request
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a/i")).click();
		
		}
			
		@Test(priority=47)
		public void Inventory_TransferRequest_addCancel(WebDriver driver) throws Exception
		{
			
		Thread.sleep(3000);
		//Click Transfer Request button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-inverse.btn--icon.ng-binding")).click();
		//Check New Transfer Request page opened or not
		if(driver.findElement(By.xpath("//span[.='New Transfer Request']")).getText().equalsIgnoreCase("New Transfer Request"))
		{
			test.log(LogStatus.PASS, "New Transfer Request page Successfully loaded ");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Transfer Request page Successfully loaded is failed");
		}
		Thread.sleep(2000);
		//Click Destination field to select store
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[1]/div/div/div/a")).click();
		
		Thread.sleep(1000);
		//Click Destination field to select store
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Inventory_Menuconfic_From_CentralWareHouse"));
		
		Thread.sleep(1000);
		//Click Destination field to select store
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
	
		Thread.sleep(2000);
		//Click new Inventory item button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/div/a/i")).click();
		
		Thread.sleep(2000);
		//Select new Inventory item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[1]/div/a")).click();
		
		
		Thread.sleep(1000);
		//select Inventory item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys(Utility.getProperty("Transfer_Inventory_item"));
		Thread.sleep(1000);
	
		//select Inventory item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		//Clear the quantity value
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[4]/input")).clear();
		//Enter the quantity value
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[4]/input")).sendKeys("1");
	
	
						Thread.sleep(1000);
						//Click remove inventory item button
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[6]/a/i")).click();
						
						Thread.sleep(3000);
						//Click cancel the inventory item
						driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger.ng-binding")).click();
						
						Thread.sleep(3000);
						
		}	
		
		@Test(priority=48)
		public void Inventory_TransferRequest_add(WebDriver driver) throws Exception
		{
						
		Thread.sleep(3000);
		//Click Transfer Request button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-inverse.btn--icon.ng-binding")).click();
		//Check New Transfer Request page opened or not
				if(driver.findElement(By.xpath("//span[.='New Transfer Request']")).getText().equalsIgnoreCase("New Transfer Request"))
				{
					test.log(LogStatus.PASS, "New Transfer Request page Successfully loaded ");
				}
				else
				{
					test.log(LogStatus.FAIL, "New Transfer Request page Successfully loaded is failed");
				}
				Thread.sleep(2000);
				//Click Destination field to select store
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[1]/div/div/div/a")).click();
				
				Thread.sleep(1000);
				//Click Destination field to select store
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Inventory_Menuconfic_From_CentralWareHouse"));
				
				Thread.sleep(1000);
				//Click Destination field to select store
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
			
				Thread.sleep(2000);
				//Click new Inventory item button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/div/a/i")).click();
				
				Thread.sleep(2000);
				//Select new Inventory item
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[1]/div/a")).click();
				
				
				Thread.sleep(1000);
				//select Inventory item
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys(Utility.getProperty("Transfer_Inventory_item"));
				Thread.sleep(1000);
			
				//select Inventory item
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				
				//Clear the quantity value
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[4]/input")).clear();
				//Enter the quantity value
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[4]/input")).sendKeys("1");
	
	
				Thread.sleep(2000);
				//Click new Inventory item button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/div/a/i")).click();
				
				Thread.sleep(2000);
				//Select new Inventory item
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[1]/div/a")).click();
				
				
				Thread.sleep(1000);
				//select Inventory item		
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[1]/div/div/div/input")).sendKeys(Utility.getProperty("Transfer_Inventory_item2"));
				Thread.sleep(1000);
			
				//select Inventory item
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				
				//Clear the quantity value
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[4]/input")).clear();
				//Enter the quantity value
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[4]/input")).sendKeys("1");
	
			
			//Click Request button for inventory item
			driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.ng-binding")).click();
			Thread.sleep(3000);	
			//Check Central Warehouse page opened or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Transfer request created successfully!."))
			{
				test.log(LogStatus.PASS, "Transfer request created successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Transfer request created is Failed");
			}
			try		
			{			
			if(driver.findElement(By.xpath("//td[.='No Records Found']")).isDisplayed())			
			{				
			test.log(LogStatus.FAIL, "There is no record available for Transfer Requests(store level inventory)");			
			}		
			}		
			catch (Exception e)		
			{			
			test.log(LogStatus.PASS, "Record available for Transfer Requests(store level inventory)");					
			 
			List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[1]"));
				for(int i = 2; i <= rows.size(); i++)
				{
				 //Get the Transfer request
				test.log(LogStatus.PASS,"Source of the  "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[1]")).getText()+"  "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[3]")).getText()+" to "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[2]")).getText()+" on " +driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[4]")).getText());
				}
			}
			}
		
		@Test(priority=49)
		public void Inventory_Centralwarehouse_Pageopen(WebDriver driver) throws Exception
		{
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[4]/a/span[1]"));
			//Scroll the page till the Reason option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
			Thread.sleep(3000);
			//Click the Inventory option
			driver.findElement(By.xpath("//span[.='Inventory']")).click();
			//Click the My Stores option
			driver.findElement(By.xpath("//span[.='My Stores']")).click();
			Thread.sleep(3000);
			
		}
		
		@Test(priority=50)
		public void Inventory_Centralwarehouse_openTransfer_Centrallevel(WebDriver driver) throws Exception
		{
			Thread.sleep(1000);
	        //Click the Central Inventory Reports Option		
			driver.findElement(By.xpath("//span[.='Central Inventory']")).click();
			
			Thread.sleep(2000);
			//Click the Central WareHouse option
			driver.findElement(By.xpath("//span[.='Central WareHouse']")).click();
			
				Thread.sleep(5000);
				if(driver.findElement(By.xpath("//div[.='"+Utility.getProperty("Inventory_Menuconfic_From_CentralWareHouse")+"']")).isDisplayed())
				{
					driver.findElement(By.xpath("//div[.='"+Utility.getProperty("Inventory_Menuconfic_From_CentralWareHouse")+"']")).click();				
					
					JavascriptExecutor je = (JavascriptExecutor) driver;
					//Identify the WebElement which will appear after scrolling down
					WebElement element = driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[2]/ul/li[12]/a/span"));
					//Scroll the page till the Reason option present
					je.executeScript("arguments[0].scrollIntoView(true);",element); 
					//Wait for 30 seconds
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					//Click the  Transfer Option		
					driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[2]/ul/li[12]/a/span")).click();
				}
		}
				
		@Test(priority=51)
		public void Inventory_Centralwarehouse_Backbutton(WebDriver driver) throws Exception		
		{	
				Thread.sleep(2000);
				//Click Accept button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[5]/span/a[2]/i")).click();//NEED TO CHECK
				//Clear the search field
			//	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/label/input")).clear();
				//Enter the search field
			//	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/label/input")).sendKeys(Utility.getProperty("Inventory_Menuconfic_From_CentralWareHouse"));
				
				Thread.sleep(2000);
				//Clear the Transfer Count
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[6]/input")).clear();
				Thread.sleep(2000);

				//Enter the Transfer Count
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[6]/input")).sendKeys("3");
				Thread.sleep(2000);

				//Click back button after entering the values
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/button")).click();
				
				}
				
		@Test(priority=52)
		public void Inventory_Centralwarehouse_Click_Transferbutton_Errormessage(WebDriver driver) throws Exception		
		{	
				{
				Thread.sleep(2000);
				//Click Accept button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[5]/span/a[2]/i")).click();//NEED TO CHECK
				//Clear the search field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/label/input")).clear();
				//Enter the search field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/label/input")).sendKeys(Utility.getProperty("Inventory_Menuconfic_From_CentralWareHouse"));
				
				Thread.sleep(2000);
				//Clear the Transfer Count
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[6]/input")).clear();
				Thread.sleep(2000);

				//Enter the Transfer Count
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[6]/input")).sendKeys("1");
				Thread.sleep(2000);
				//Click Transfer Items button
				driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.btn-border-green.ng-binding")).click();
				
				//Check Central Warehouse page opened or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("item(s) are not transferred"))
				{
					test.log(LogStatus.PASS, "Transfer request accepted successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Transfer request accepted is Failed");
				}
				}
				}
				
		@Test(priority=53)
		public void Inventory_Transfer_Logs_Pageopen(WebDriver driver) throws Exception
		{
					Thread.sleep(3000);
					
					//Get the URl
					driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"transfer/transferLogs");
					
					//Check Inventory Items page opened or not
					if(driver.findElement(By.xpath("//div[@id='navigation']/ul[1]/li/a")).getText().equalsIgnoreCase("Transfer Logs"))
					{
						test.log(LogStatus.PASS, " Transfer Logs report loaded Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, " Transfer Logs report loaded Failed");
					}
					
					Thread.sleep(1000);
				}
				
		@Test(priority=54) 
		public void Inventory_Transfer_Logs_ALL(WebDriver driver) throws Exception
		{
					Thread.sleep(3000);
				//Select type as ALL 
				Select ALL = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[1]/div/div/select")));
				ALL.selectByVisibleText("All"); 
			 	
				Thread.sleep(3000);
				//Select type as Time period
				Select Timeperiod= new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[2]/div/div/select")));
				Timeperiod.selectByVisibleText("Date Range"); 
			 	
				//Select the From Date Range
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[3]/div/div/input[1]")).clear();
				//Enter the required From Date Range
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
						
				//Select the TO Date Range
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[3]/div/div/input[2]")).clear();
				//Enter the  required TO Date Range
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Select type as Time period
				Select TransferStatus = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[4]/div/select")));
				TransferStatus.selectByVisibleText("Received"); 
				Thread.sleep(1000);
				//Click the Search button
				driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
				
				//Check weather data's available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td")).getText().equalsIgnoreCase("No transfer record for selected item or time period"))
				{
					test.log(LogStatus.PASS, "No transfer record for selected item or time period for received status for recieved (ALL)");
				}
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[7]")).getText() != null)
				{
					test.log(LogStatus.PASS, "Transaction Report(By Received ) available for Specific Date status Recieved(ALL)");
					
					//Get the number of rows
					 List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[2]"));
					for(int i = 1; i <= rows.size(); i++)
					{
						//Get the Consumption Log Quantity value
						test.log(LogStatus.PASS,"In Transfer Logs source of the " +driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[1]")).getText() +" store "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[3]")).getText()+ " item is "+" "+  driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[6]")).getText()+ " Quantity");
					}		
					}		
				Thread.sleep(3000);
				
				}
				
		@Test(priority=55) 
		public void Inventory_Transfer_Logs_ALL_Transferred(WebDriver driver) throws Exception
		{
					Thread.sleep(3000);
					//Select type as Time period
					Select TransferStatus = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[4]/div/select")));
					TransferStatus.selectByVisibleText("Transferred"); 
					
					Thread.sleep(1000);
					//Click the search button
					
					driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
					
					//Check weather data's available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td")).getText().equalsIgnoreCase("No transfer record for selected item or time period"))
					{
						test.log(LogStatus.PASS, "No transfer record for selected item or time period for Transdfered status (ALL)");
					}
					else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[7]")).getText() != null)
					{
						test.log(LogStatus.PASS, "Transaction Report available for Specific Date Transferred(ALL)");
						
						//Get the number of rows
						 List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[2]"));
						for(int i = 1; i <= rows.size(); i++)
						{
							//Get the Consumption Log Quantity value
							test.log(LogStatus.PASS,"In Transfer Logs source of the " +driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[1]")).getText() +" store "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[3]")).getText()+ " item is "+" "+  driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[6]")).getText()+ " Quantity");
						}	
					}
				}
				
		@Test(priority=56) 
		public void Inventory_Transfer_Logs_InventoryItem(WebDriver driver) throws Exception
		{
					Thread.sleep(3000);
				//Select type as ALL 
				Select ALL = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[1]/div/div/select")));
				ALL.selectByVisibleText("Inventory Item"); 
			 	
				//Click the Search 
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[2]/div/div/div/a")).click();
				Thread.sleep(3000);
				//Enter the Adjust Inventory item
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[2]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Search_Inventory_Category_Name"));
				Thread.sleep(3000);
				//Enter the Adjust Inventory item
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				//Click the Search 
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[3]/div/div/div/a")).click();
				Thread.sleep(3000);
				//Enter the Adjust Inventory item
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[3]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Inventory_Items_Name"));
				Thread.sleep(3000);
				//Enter the Adjust Inventory item
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);	 	
				 	
				Thread.sleep(3000);
				//Select type as Time period
				Select Timeperiod= new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[4]/div/div/select")));
				Timeperiod.selectByVisibleText("Date Range"); 
			 
				//Select the From Date Range
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[5]/div/div/input[1]")).clear();
				//Enter the required From Date Range
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[5]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
						
				//Select the TO Date Range
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[5]/div/div/input[2]")).clear();
				//Enter the  required TO Date Range
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[5]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Select type as Time period
				Select TransferStatus = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[6]/div/select")));
				TransferStatus.selectByVisibleText("Received"); 
					
				Thread.sleep(1000);
				//Click the Search button
				driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
				
				//Check weather data's available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td")).getText().equalsIgnoreCase("No transfer record for selected item or time period"))
					{
						test.log(LogStatus.PASS, "No transfer record for selected item or time period for received status InventoryItem_Recieved");
					}
					else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[7]")).getText() != null)
					{
						test.log(LogStatus.PASS, "Transaction Report(By Received ) available for Specific Date");
						
						//Get the number of rows
						 List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[2]"));
						for(int i = 1; i <= rows.size(); i++)
						{
							//Get the Consumption Log Quantity value
							test.log(LogStatus.PASS,"In Transfer Logs source of the " +driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[1]")).getText() +" store "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[3]")).getText()+ " item is "+" "+  driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[6]")).getText()+ " Quantity");
						}		
				
					}}
				
		@Test(priority=57) 
		public void Inventory_Transfer_Logs_InventoryItem_Transferred(WebDriver driver) throws Exception
		{
					Thread.sleep(3000);
					//Select type as Time period
					Select TransferStatus = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[6]/div/select")));
					TransferStatus.selectByVisibleText("Transferred"); 
						
					Thread.sleep(1000);
					//Click the Search button
					driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
					
					//Check weather data's available or not
							if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td")).getText().equalsIgnoreCase("No transfer record for selected item or time period"))
							{
								test.log(LogStatus.PASS, "No transfer record for selected item or time period for received status InventoryItem_Transfered");
							}
							else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[7]")).getText() != null)
							{
								test.log(LogStatus.PASS, "Transaction Report(By Transfered status) available for Specific Date");
								
								//Get the number of rows
								 List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[2]"));
								for(int i = 1; i <= rows.size(); i++)
								{
									//Get the Consumption Log Quantity value
									test.log(LogStatus.PASS,"In Transfer Logs source of the " +driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[1]")).getText() +" store "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[3]")).getText()+ " item is "+" "+  driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[6]")).getText()+ " Quantity");
								}	
							}
					}	
				
		@Test(priority=58) 
		public void Inventory_Transfer_Logs_SubRecipe(WebDriver driver) throws Exception
		{
					Thread.sleep(3000);
				//Select type as ALL 
				Select ALL = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[1]/div/div/select")));
				ALL.selectByVisibleText("Sub Recipe"); 
			 	
				//Click the Sub recipe
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[2]/div/div/div/a")).click();
				Thread.sleep(3000);
				//Enter the Adjust Inventory item
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[2]/div/div/div/div/div/input")).sendKeys("ALL");
				Thread.sleep(3000);
				//Enter the Adjust Inventory item
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(3000);
				//Select type as Time period
				Select Timeperiod= new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[3]/div/div/select")));
				Timeperiod.selectByVisibleText("Date Range"); 
			 
				//Select the From Date Range
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[4]/div/div/input[1]")).clear();
				//Enter the required From Date Range
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
						
				//Select the TO Date Range
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[4]/div/div/input[2]")).clear();
				//Enter the  required TO Date Range
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Select type as Time period
				Select TransferStatus = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[5]/div/select")));
				TransferStatus.selectByVisibleText("Received"); 

				//Check weather data's available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td")).getText().equalsIgnoreCase("No transfer record for selected item or time period"))
					{
						test.log(LogStatus.PASS, "No transfer record for selected item or time period for received status SubRecipe_Recieved");
					}
					else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[7]")).getText() != null)
					{
						test.log(LogStatus.PASS, "Transaction Report(By Received ) available for Specific Date");
						
						//Get the number of rows
						 List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[2]"));
						for(int i = 1; i <= rows.size(); i++)
						{
							//Get the Consumption Log Quantity value
							test.log(LogStatus.PASS,"In Transfer Logs source of the " +driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[1]")).getText() +" store "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[3]")).getText()+ " item is "+" "+  driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[6]")).getText()+ " Quantity");
						}	}		
				
					}
				
		@Test(priority=59) 
		public void Inventory_Transfer_Logs_SubRecipe_Transferred(WebDriver driver) throws Exception
		{
					Thread.sleep(3000);
					//Select type as Time period
					Select TransferStatus = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/form/div[5]/div/select")));
					TransferStatus.selectByVisibleText("Transferred"); 
					
					//Click the Search button
							driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
							
							//Check weather data's available or not
									if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td")).getText().equalsIgnoreCase("No transfer record for selected item or time period"))
									{
										test.log(LogStatus.PASS, "No transfer record for selected item or time period for received status SubRecipe_Transferred");
									}
									else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[7]")).getText() != null)
									{
										test.log(LogStatus.PASS, "Transaction Report(By Transfered status) available for Specific Date");
										
										//Get the number of rows
										 List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[2]"));
										for(int i = 1; i <= rows.size(); i++)
										{
											//Get the Consumption Log Quantity value
											test.log(LogStatus.PASS,"In Transfer Logs source of the " +driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[1]")).getText() +" store "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[3]")).getText()+ " item is "+" "+  driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[6]")).getText()+ " Quantity");
										}}}
				
		@Test(priority=60)
		public void Inventory_open_Sync_Inventory (WebDriver driver) throws Exception
		{					
					//Get the URl
					driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"syncToInventory");
					
					
					Thread.sleep(5000);
					//Check In Sync Inventory page opened or not
					if(driver.findElement(By.xpath("//a[.='Sync Inventory']")).getText().equalsIgnoreCase("Sync Inventory"))
					{
						test.log(LogStatus.PASS, "Sync Inventory page loaded Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Sync Inventory page loaded Failed");
					}
					
					Thread.sleep(5000);
					
				}
					
		@Test(priority=61)
		public void Inventory_update_Sync_Inventory(WebDriver driver) throws Exception
		{	
					Thread.sleep(1000);
					//Click the Sync Data to Sync Inventory button
					driver.findElement(By.xpath("//span[.='Sync Data to Inventory']")).click();
					
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
					//Check weather the Store synced or not
					if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Your iventory data are not sync properly"))
					{
						test.log(LogStatus.FAIL, "Your iventory data are not sync properly");
					}
					else
					{
						test.log(LogStatus.PASS, "Your iventory data are successfully synced");
					}
					Thread.sleep(5000);
				}
	}				
