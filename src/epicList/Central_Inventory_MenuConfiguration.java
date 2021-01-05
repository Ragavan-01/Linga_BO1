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

public class Central_Inventory_MenuConfiguration {
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Central_Inventory_MenuConfiguration");

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

	@Test(priority=12)
	public void Inventory_MenuConfiguration_openpage() throws Exception
	{
		/*//Click the My Stores option
		driver.findElement(By.xpath("//span[.='My Stores']")).click();

		Thread.sleep(3000);
        //Click the Central Inventory Reports Option		
		driver.findElement(By.xpath("//span[.='Central Inventory']")).click();
		
		Thread.sleep(2000);
		//Click the Central WareHouse option
		driver.findElement(By.xpath("//span[contains(.,'Menu Configuration ')]")).click();
*/
		Thread.sleep(3000);	
		//Enter the Coursing URL
		driver.get(Utility.getProperty("Enterprise_Base_URL")+"centralStores/menuConfig");
		
		Thread.sleep(5000);
		//Check Central Warehouse page opened or not
		if(driver.findElement(By.xpath("//a[.='Menu Configuration']")).getText().equalsIgnoreCase("Menu Configuration"))
		{
			test.log(LogStatus.PASS, "Central Menu Configuration page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Central Menu Configuration page loaded Failed");
		}
		
		Thread.sleep(3000);
		
	}
	
	@Test(priority=13)
	public void Inventory_MenuConfiguration_Store_option() throws Exception
	{
	
		Thread.sleep(2000);
		//Click the From Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/a")).click();
		//Enter the From Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/div/div/input")).sendKeys("Stores");
		//Send the From Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
							
		Thread.sleep(2000);
		//Click the Select Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/a")).click();
		//Enter the Required Store
		//driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/div/div/input")).sendKeys(Utility.getProperty("Inventory_Menuconfic_From_Store"));
		//Send the selected Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
				
		Thread.sleep(2000);
		//Click the To Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/a")).click();
		//Enter the To Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/div/div/input")).sendKeys("Stores");
		//Send the To Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Select Stores for To field
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/a")).click();
		//Enter the Select Stores for To field
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Send the Select Stores for To field
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		//Click the Pull Menu Configuration button
		//driver.findElement(By.cssSelector("button.btn.btn-success")).click();
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		//Check Central Warehouse page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Data pulled successfully"))
		{
			test.log(LogStatus.PASS, "Data pulled successfully for store");
		}
		else
		{
			test.log(LogStatus.FAIL, "Data pulled Failed for store");
		}
		Thread.sleep(5000);	
	}
	
	@Test(priority=14)
	public void Inventory_MenuConfiguration_Centralwarehouse_option() throws Exception
	{
	
		Thread.sleep(2000);
		//Click the From Central warehouse
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/a")).click();
		//Enter the From Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/div/div/input")).sendKeys("Central WareHouse");
		//Send the From Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
							
		Thread.sleep(2000);
		//Click the Select Central warehouse
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/a")).click();
		//Enter the Required Store
		//driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/div/div/input")).sendKeys(Utility.getProperty("Inventory_Menuconfic_From_CentralWareHouse"));
		//Send the selected Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
				
		Thread.sleep(2000);
		//Click the To Central warehouse
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/a")).click();
		//Enter the To Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/div/div/input")).sendKeys("Central WareHouse");
		//Send the To Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Select Stores for To field
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/a")).click();
		//Enter the Select Stores for To field
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Send the Select Stores for To field
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Pull Menu Configuration button
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);Thread.sleep(2500);
		//Check Central Warehouse page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Data pulled successfully"))
		{
			test.log(LogStatus.PASS, "Data pulled successfully for Central warehouse");
		}
		else
		{
			test.log(LogStatus.FAIL, "Data pulled Failed for Central warehouse");
		}
		Thread.sleep(5000);	
	}
				
	@Test(priority=15)
	public void Inventory_MenuConfiguration_CentralKitchen_option() throws Exception
	{
	
		Thread.sleep(2000);
		//Click the From Central Kitchen
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/a")).click();
		//Enter the From Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/div/div/input")).sendKeys("Central Kitchen");
		//Send the From Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
							
		Thread.sleep(2000);
		//Click the Select Central Kitchen
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/a")).click();
		//Enter the Required Store
		//driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/div/div/input")).sendKeys(Utility.getProperty("Inventory_Menuconfic_From_CentralKitchen"));
		//Send the selected Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
				
		Thread.sleep(2000);
		//Click the To Central Kitchen
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/a")).click();
		//Enter the To Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/div/div/input")).sendKeys("Central Kitchen");
		//Send the To Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Select Stores for To field
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/a")).click();
		//Enter the Select Stores for To field
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Send the Select Stores for To field
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Pull Menu Configuration button
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);Thread.sleep(2500);
		//Check Central Warehouse page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Data pulled successfully"))
		{
			test.log(LogStatus.PASS, "Data pulled successfully for Central Kitchen");
		}
		else
		{
			test.log(LogStatus.FAIL, "Data pulled Failed for Central Kitchen");
		}
		Thread.sleep(5000);	
	}	
	
	@Test(priority=16)
	public void Inventory_MenuConfig_Store_To_Centralware() throws Exception
	{
	
		Thread.sleep(2000);
		//Click the From Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/a")).click();
		//Enter the From Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/div/div/input")).sendKeys("Stores");
		//Send the From Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
							
		Thread.sleep(2000);
		//Click the Select Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/a")).click();
		//Enter the Required Store
		//driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/div/div/input")).sendKeys(Utility.getProperty("Inventory_Menuconfic_From_Store"));
		//Send the selected Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
				
		Thread.sleep(2000);
		//Click the To Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/a")).click();
		//Enter the To Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/div/div/input")).sendKeys("Central WareHouse");
		//Send the To Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Select Stores for To field
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/a")).click();
		//Enter the Select Stores for To field
		//driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/div/div/input")).sendKeys(Utility.getProperty("Inventory_Menuconfic_To_CentralWareHouse"));
		//Send the Select Stores for To field
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Pull Menu Configuration button
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		//Check Central Warehouse page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Data pulled successfully"))
		{
			test.log(LogStatus.PASS, "Data pulled successfully for Store To Centralware");
		}
		else
		{
			test.log(LogStatus.FAIL, "Data pulled Failed for Store To Centralware");
		}
		Thread.sleep(5000);	
	}
	
	@Test(priority=17)
	public void Inventory_MenuConfig_Centralware_To_Centralkitchen() throws Exception
	{
	
		Thread.sleep(2000);
		//Click the From Central warehouse
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/a")).click();
		//Enter the From Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/div/div/input")).sendKeys("Central WareHouse");
		//Send the From Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
							
		Thread.sleep(2000);
		//Click the Select Central warehouse
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/a")).click();
		//Enter the Required Store
		//driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/div/div/input")).sendKeys(Utility.getProperty("Inventory_Menuconfic_From_CentralWareHouse"));
		//Send the selected Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
				
		Thread.sleep(2000);
		//Click the To Central warehouse
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/a")).click();
		//Enter the To Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/div/div/input")).sendKeys("Central Kitchen");
		//Send the To Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Select Stores for To field
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/a")).click();
		//Enter the Select Stores for To field
		//driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/div/div/input")).sendKeys(Utility.getProperty("Inventory_Menuconfic_To_CentralKitchen"));
		//Send the Select Stores for To field
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Pull Menu Configuration button
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);Thread.sleep(2500);
		//Check Central Warehouse page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Data pulled successfully"))
		{
			test.log(LogStatus.PASS, "Data pulled successfully for Centralware To Centralkitchen");
		}
		else
		{
			test.log(LogStatus.FAIL, "Data pulled Failed for Centralware To Centralkitchen");
		}
		Thread.sleep(5000);	
	}
	
	@Test(priority=18)
	public void Inventory_MenuConfig_CentralKitchen_To_Store() throws Exception
	{
	
		Thread.sleep(2000);
		//Click the From Central Kitchen
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/a")).click();
		//Enter the From Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/div/div/input")).sendKeys("Central Kitchen");
		//Send the From Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
							
		Thread.sleep(2000);
		//Click the Select Central Kitchen
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/a")).click();
		//Enter the Required Store
		//driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/div/div/input")).sendKeys(Utility.getProperty("Inventory_Menuconfic_From_CentralKitchen"));
		//Send the selected Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
				
		Thread.sleep(2000);
		//Click the To Central Kitchen
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/a")).click();
		//Enter the To Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/div/div/input")).sendKeys("Stores");
		//Send the To Store
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Select Stores for To field
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/a")).click();
		//Enter the Select Stores for To field
		//driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/div/div/input")).sendKeys(Utility.getProperty("Inventory_Menuconfic_To_Store"));
		//Send the Select Stores for To field
		driver.findElement(By.xpath("//form[@name='pullItem']/div[1]/div[4]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Pull Menu Configuration button
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		//Check Central Warehouse page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Data pulled successfully"))
		{
			test.log(LogStatus.PASS, "Data pulled successfully for CentralKitchen To Store");
		}
		else
		{
			test.log(LogStatus.FAIL, "Data pulled Failed for CentralKitchen To Store");
		}
		Thread.sleep(5000);	
	}

}
