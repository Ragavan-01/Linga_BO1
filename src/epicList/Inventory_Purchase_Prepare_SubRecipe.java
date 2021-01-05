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

public class Inventory_Purchase_Prepare_SubRecipe {
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory_Purchase_Prepare_SubRecipe");

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

	@Test(priority=15)
	public void Inventory_Purchase_Prepare_Subrecipe_Openpage() throws Exception
	{
/*		//Click the Inventory option
		driver.findElement(By.xpath("//span[.='Inventory']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[contains(.,'Purchases')]"));
		//Scroll the page till the Inventory Items option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Inventory Items Option		
		driver.findElement(By.xpath("//span[contains(.,'Purchases')]")).click();
		 //driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[4]/ul/li[11]/a/i")).click();
		*/
		//Get the URl
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"receivedLogs");
		Thread.sleep(5000);
		//Check Inventory Items page opened or not
		if(driver.findElement(By.xpath("//a[.='Received Log']")).getText().equalsIgnoreCase("Received Log"))
		{
			test.log(LogStatus.PASS, "Purchase page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Purchase Inventory page loaded Failed");
		}
		
		Thread.sleep(5000);
		
	}

	@Test(priority=16)
	public void Inventory_Purchase_Prepare_Subrecipe_Update() throws Exception
	{
		Thread.sleep(3000);
		//Click Prepare SubRecipe
		driver.findElement(By.xpath("//span[contains(.,'Prepare SubRecipe')]")).click();
		
		Thread.sleep(8000);
		//Click the SubRecipe option
		driver.findElement(By.xpath("//div[@id='subRecipe_chosen']/a")).click();
		Thread.sleep(6000);
		//Enter the SubRecipe option
	    driver.findElement(By.xpath("//div[@id='subRecipe_chosen']/div/div/input")).sendKeys(Utility.getProperty("subRecipe_name"));
	  //Enter the SubRecipe option
	   driver.findElement(By.xpath("//div[@id='subRecipe_chosen']/div/div/input")).sendKeys(Keys.ENTER);
	    
	   Thread.sleep(2000);
		//Clear the quantity option
		driver.findElement(By.name("quantity")).clear();
		Thread.sleep(2000);
		//Enter the quantity option
	    driver.findElement(By.name("quantity")).sendKeys("2");

	    
		//Thread.sleep(4000);
				//Click the primary storage
				//driver.findElement(By.xpath("//div[@id='psl_chosen']/a")).click();
				//Thread.sleep(2000);
				//Enter the primary storage
			   // driver.findElement(By.xpath("//div[@id='psl_chosen']/div/div/input")).sendKeys(Utility.getProperty("Inventory_Primary_Storage_Name"));
			  //Enter the primary storage
			   //driver.findElement(By.xpath("//div[@id='psl_chosen']/div/div/input")).sendKeys(Keys.ENTER);
		
	    Thread.sleep(2000);
	 //Click New primary storage
	 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[2]/form/div[1]/div[2]/div[2]/a/i")).click();
					
				Thread.sleep(2000);
				//Check New primary storage	page loaded successfully or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Storage"))
				{
					test.log(LogStatus.PASS, "New primary storage page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "New primary storage page loaded Failed");
				}
				
			 
				Thread.sleep(2000);
			 //Click the New primary storage
			driver.findElement(By.name("masterName")).clear();
			Thread.sleep(2000);
			//Enter the New primary storage	    
			driver.findElement(By.name("masterName")).sendKeys(Utility.getProperty("Inventory_Primary_Storage_Name"));	  
	
			 	
			Thread.sleep(4000);
			//Click the New primary storage
				driver.findElement(By.name("description")).clear();
				Thread.sleep(2000);
				//Enter the New primary storage	    
				driver.findElement(By.name("description")).sendKeys("Need a place to keep");	  
			
				 
				Thread.sleep(3000);
				//Click the Save button
				driver.findElement(By.cssSelector("button.btn.btn-success.btn-small.ng-binding")).click();
						
		
			Thread.sleep(2000);
			//Check New primary storage	page loaded successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/h3/span/span")).getText().equalsIgnoreCase("Prepare SubRecipe"))
			{
				test.log(LogStatus.PASS, "Prepare SubRecipe page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Prepare SubRecipe page loaded Failed");
			}
			
			Thread.sleep(4000);
			//Click the Secondary storage
			driver.findElement(By.xpath("//div[@id='ssl_chosen']/a")).click();
			Thread.sleep(2000);
			//Enter the Secondary storage
		    driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys(Utility.getProperty("Inventory_Secondary_Storage_Name"));
		  //Enter the Secondary storage
		   driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys(Keys.ENTER);
		   
/*		 //Click New Secondary storage
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[2]/form/div[1]/div[3]/div[2]/a/i")).click();
				
			Thread.sleep(2000);
			//Check New Secondary storage	page loaded successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Storage"))
			{
				test.log(LogStatus.PASS, "New Secondary storage page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Secondary storage page loaded Failed");
			}
			
		 
			Thread.sleep(2000);
		 //Click the New Secondary storage
		driver.findElement(By.name("masterName")).clear();
		Thread.sleep(2000);
		//Enter the New Secondary storage	    
		driver.findElement(By.name("masterName")).sendKeys(Utility.getProperty("Inventory_Primary_Storage_Name")+"1");	  
		//Enter the New Secondary storage 	                          
		driver.findElement(By.name("masterName")).sendKeys(Keys.ENTER);
		 	
		Thread.sleep(2000);
		//Click the New Secondary storage
			driver.findElement(By.name("description")).clear();
			Thread.sleep(2000);
			//Enter the New Secondary storage	    
			driver.findElement(By.name("description")).sendKeys("Need a place to keep");	  
			//Enter the New Secondary storage 	                          
			driver.findElement(By.name("description")).sendKeys(Keys.ENTER);
			 
			Thread.sleep(3000);
			//Click the Save button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
					
		
		Thread.sleep(2000);
		//Check New Secondary storage page loaded successfully or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Storage"))
		{
			test.log(LogStatus.PASS, "New Secondary storage page loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Secondary storage page loaded Failed");
		}*/

		
	
	   
	  //Click the Save button
	 //driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[2]/form/div[2]/div/div/button")).click();
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
		
		Thread.sleep(8000);
	}

}
