package epicList;

import java.util.List;
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

public class Inventory_Low_Stacks {
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory_Low_Stacks");

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

		@Test(priority=39)
		public void Inventory_Low_stock_Openpage() throws Exception
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
		public void Inventory_Low_stock_Create_Purchase_Order() throws Exception
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
		public void Inventory_Low_stock_prepare_SubRecipe() throws Exception
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

}
