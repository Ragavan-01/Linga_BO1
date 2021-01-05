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

public class Inventory_Transfer_Request {
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory_Transfer_Request");

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

		@Test(priority=44)
		public void Inventory_Transfer_Requests_Pageopen() throws Exception
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
		public void Inventory_TransferRequest_Refresh() throws InterruptedException
		{
			Thread.sleep(2000);
			//Click refresh the button for Transfer request
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a/i")).click();
		
		}
	
		@Test(priority=47)
		public void Inventory_TransferRequest_addCancel() throws Exception
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
		public void Inventory_TransferRequest_add() throws Exception
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
		public void Inventory_Centralwarehouse_Pageopen() throws Exception
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
		public void Inventory_Centralwarehouse_openTransfer_Centrallevel() throws Exception
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
		public void Inventory_Centralwarehouse_Backbutton() throws Exception		
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
		public void Inventory_Centralwarehouse_Click_Transferbutton_Errormessage() throws Exception		
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

}
