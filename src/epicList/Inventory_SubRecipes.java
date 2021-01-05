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

public class Inventory_SubRecipes {
	
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory_SubRecipes");

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
	
		@Test(priority=45)
		public void Inventory_Sub_Recipes_openpage() throws Exception
		{
	
			//Get the URl
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"subRecipes");

			Thread.sleep(4000);
			//Check Storage Locations page opened or not
			if(driver.findElement(By.xpath("//a[.='Sub Recipes']")).getText().equalsIgnoreCase("Sub Recipes"))
			{
				test.log(LogStatus.PASS, "Sub Recipes page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Sub Recipes page loaded Failed");
			}
			
			Thread.sleep(4000);
			
		}
		
		@Test(priority=46)
		public void Inventory_Sub_Recipes_refresh() throws InterruptedException
		{
			Thread.sleep(5000);
			//Click the refresh button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/a[2]/i")).click();
			Thread.sleep(5000);
			
			//Check Sub Recipes page opened or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Sub Recipe"))
			{
				test.log(LogStatus.PASS, "Sub Recipes page refreshed Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Sub Recipes page refreshed Failed");
			}
			Thread.sleep(5000);


		}
		
		@Test(priority=47)
		public void Inventory_Sub_Recipes_add_Invetory_Sub_Recipes() throws Exception
		{
			  //Scroll the web page
		    for(int i=1; i <= 20; i++)
		    {
		    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		    	Thread.sleep(1000);
		    } 
		    
			Thread.sleep(5000);
			//Click on the Add Sub Recipe option
			driver.findElement(By.id("subRecipe")).click();
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
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[1]/div/div/div/input")).click();
			//EPress the Enter button
			Thread.sleep(1000);driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);

			Thread.sleep(10000);
			//Click the Item
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
			Thread.sleep(1000);
			//Enter the Required Item
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/div/div/input")).click();
			//Press the Enter button
			Thread.sleep(2000);driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[3]/div/a")).click();
			//Enter the Required Recipe Unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[3]/div/div/div/input")).click();
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
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[2]/div/div/div/input")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[3]/div/a")).click();
			//Enter the Required Recipe Unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[3]/div/div/div/input")).click();
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
			Thread.sleep(1500);
			
			Thread.sleep(2000);
			//Add Sub Recipe
			driver.findElement(By.xpath("//i[contains(.,'Sub Recipe')]")).click();
			Thread.sleep(1500);
			//Click the Close button for Sub Recipe
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[4]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			Thread.sleep(2000);
			//Add Manual Entry
			driver.findElement(By.xpath("//i[contains(.,'Manual Entry')]")).click();
			Thread.sleep(1500);
			//Click the Close button for Manual Entry
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[4]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			
			
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
			//driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/div/div/input")).sendKeys("Liter");
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
			{
				test.log(LogStatus.FAIL, "New Storage form Loaded Failed");
			}
			Thread.sleep(2000);
			
			//Clear the name field
			driver.findElement(By.id("masterName")).clear();
			//Enter the name
			driver.findElement(By.id("masterName")).sendKeys(Utility.getProperty("Inventory_SubRecipe_Primary_Storage_Name"));
			
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
			//driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys("Freezer");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys(Keys.ENTER);
			
	/*		Thread.sleep(1000);
			//Clear the Input field
			driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-valid ng-touched']")).clear();
			//Enter the required Input
			driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-valid ng-touched']")).sendKeys("2");
	*/		
			Thread.sleep(1000);
			//Click the Required option
			driver.findElement(By.xpath("//a[@class='chosen-single chosen-default']")).click();
			Thread.sleep(1000);
			//Enter the Required Option
			//driver.findElement(By.xpath("//div[@class='chosen-container chosen-container-single chosen-with-drop chosen-container-active']/div/div/input")).sendKeys("Liter");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@class='chosen-container chosen-container-single chosen-with-drop chosen-container-active']/div/div/input")).sendKeys(Keys.ENTER);
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			Thread.sleep(5000);
			//Click the Save button
			driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
			Thread.sleep(2500);
			
			//Check whether the new storage location saved or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub Recipe saved successfully!."))
			{
				test.log(LogStatus.PASS, "New Sub Recipe Saved Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Sub Recipe Save Failed");
			}

			Thread.sleep(5000);
		}
		
		@Test(priority=48)
		public void Inventory_Sub_Recipes_edit_Invetory_Sub_Recipe() throws Exception
		{
			Thread.sleep(5000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(5000);
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_SubRecipe_Name"));
			Thread.sleep(5000);
			//Click the Edit icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			Thread.sleep(5000);
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Inventory_SubRecipe_Name")+"1");
			Thread.sleep(2000);

			//Enable the Calculate COGS On Cost Price button
			driver.findElement(By.name("costPriceBasedCOGS")).click();
			
			Thread.sleep(1500);
			//Click the Close button for Sub Recipe
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			Thread.sleep(1500);
			//Click the Close button for Sub Recipe
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			Thread.sleep(1500);
			//Click the Close button for Sub Recipe
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			//Clear the Price Per Unit Option
			driver.findElement(By.name("pricePerUnit")).clear();
			//Enter the Price Per Unit
			driver.findElement(By.name("pricePerUnit")).sendKeys("2000");
			
	/*		Thread.sleep(1500);
			//Clear the Recipe Units
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[4]/div/div/div/div[1]/div/div[1]/ng-form/div/div/div[4]/div/input")).clear();
			//Enter the Required amount
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[4]/div/div/div/div[1]/div/div[1]/ng-form/div/div/div[4]/div/input")).sendKeys("1500");
	*/		
			Thread.sleep(1000);
			//Click the add recipe unit option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[4]/div/div/div/div[2]/a/i")).click();
			Thread.sleep(1000);
			
	/*		Thread.sleep(1000);
			//Clear the Input field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[4]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[2]/input")).clear();
			//Enter the required Input
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[4]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[2]/input")).sendKeys("2");
	*/		
			Thread.sleep(1000);
			//Click the Required option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[4]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[3]/div/a")).click();
			Thread.sleep(1000);
			//Enter the Required Option
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[4]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[3]/div/div/div/input")).sendKeys("Milli liter");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[4]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);

			Thread.sleep(1500);
			//Clear the Recipe Units
//			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[4]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[4]/div/input")).clear();
			//Enter the Required amount
//			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[4]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[4]/div/input")).sendKeys("1500");

			Thread.sleep(1000);
			//Click the add recipe unit option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[4]/div/div/div/div[2]/a/i")).click();
			Thread.sleep(1000);
			
			//Click the Close Button of Recipe Unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[4]/div/div/div/div[1]/div/div[3]/ng-form/div/div/div[4]/div/a")).click();
			Thread.sleep(2000);
			
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			//Click the update
			driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
			Thread.sleep(2500);

			//Check whether the storage locations updated successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub Recipe updated successfully!."))
			{
				test.log(LogStatus.PASS, "New Sub Recipe updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Sub Recipe updated Failed");
			}

			Thread.sleep(5000);

		}

		@Test(priority=49)
		public void Inventory_Sub_Recipes_edit_Invetory_Sub_Recipe_InvITEM_InvITEM() throws Exception
		{
			Thread.sleep(5000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(5000);
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_SubRecipe_Name")+"1");
			Thread.sleep(5000);
			//Click the Edit icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			Thread.sleep(2000);
			//Add Inventory Item
			driver.findElement(By.xpath("//i[contains(.,'Inventory Item')]")).click();
			
			Thread.sleep(5000);
			//Click the Category Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[1]/div/a")).click();
			//Enter the required input
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys("FOOD");
			//EPress the Enter button
			Thread.sleep(1000);driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);

			Thread.sleep(2000);
			//Click the Item
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
			//Enter the Required Item
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys("Parotta");
			//Press the Enter button
			Thread.sleep(2000);driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[3]/div/a")).click();
			//Enter the Required Recipe Unit
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[3]/div/div/div/input")).sendKeys("Kilo gram");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[3]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[5]/input")).sendKeys("3");

			Thread.sleep(2000);
			//Add Inventory Item
			driver.findElement(By.xpath("//i[contains(.,'Inventory Item')]")).click();
			
			Thread.sleep(1000);
			//Click the Category Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[1]/div/a")).click();
			//Enter the required input
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys("FOOD");
			//EPress the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);

			Thread.sleep(1000);
			//Click the Item
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[2]/div/a")).click();
			//Enter the Required Item
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys("Parotta");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[3]/div/a")).click();
			//Enter the Required Recipe Unit
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[3]/div/div/div/input")).sendKeys("Kilo gram");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[3]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[5]/input")).sendKeys("3");

			
			//Click the update
			driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
			Thread.sleep(2500);

			//Check whether the storage locations updated successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub Recipe updated successfully!."))
			{
				test.log(LogStatus.PASS, "New Sub Recipe updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Sub Recipe updated Failed");
			}

			Thread.sleep(5000);

		}
		
		@Test(priority=50)
		public void Inventory_Sub_Recipes_edit_Invetory_Sub_Recipe_InvITEM_SubRecipe() throws Exception
		{
			Thread.sleep(5000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(5000);
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_SubRecipe_Name")+"1");
			Thread.sleep(5000);
			//Click the Edit icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			Thread.sleep(1500);
			//Click the Close button for Sub Recipe
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			Thread.sleep(1500);
			//Click the Close button for Sub Recipe
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			Thread.sleep(2000);
			//Add Inventory Item
			driver.findElement(By.xpath("//i[contains(.,'Inventory Item')]")).click();
			
			Thread.sleep(1000);
			//Click the Category Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[1]/div/a")).click();
			//Enter the required input
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys("FOOD");
			//EPress the Enter button
			Thread.sleep(1000);driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);

			Thread.sleep(2000);
			//Click the Item
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
			//Enter the Required Item
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys("Parotta");
			//Press the Enter button
			Thread.sleep(2000);driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[3]/div/a")).click();
			//Enter the Required Recipe Unit
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[3]/div/div/div/input")).sendKeys("Kilo gram");
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

			
			//Click the update
			driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
			Thread.sleep(2500);

			//Check whether the storage locations updated successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub Recipe updated successfully!."))
			{
				test.log(LogStatus.PASS, "New Sub Recipe updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Sub Recipe updated Failed");
			}

			Thread.sleep(5000);

		}
		
		@Test(priority=51)
		public void Inventory_Sub_Recipes_edit_Invetory_Sub_Recipe_InvITEM_Manual() throws Exception
		{
			Thread.sleep(5000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(5000);
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_SubRecipe_Name")+"1");
			Thread.sleep(5000);
			//Click the Edit icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			Thread.sleep(1500);
			//Click the Close button for Sub Recipe
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			Thread.sleep(1500);
			//Click the Close button for Sub Recipe
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			Thread.sleep(2000);
			//Add Inventory Item
			driver.findElement(By.xpath("//i[contains(.,'Inventory Item')]")).click();
			
			Thread.sleep(1000);
			//Click the Category Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[1]/div/a")).click();
			//Enter the required input
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys("FOOD");
			//EPress the Enter button
			Thread.sleep(1000);driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);

			Thread.sleep(2000);
			//Click the Item
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
			//Enter the Required Item
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys("Parotta");
			//Press the Enter button
			Thread.sleep(2000);driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[3]/div/a")).click();
			//Enter the Required Recipe Unit
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[3]/div/div/div/input")).sendKeys("Kilo gram");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[3]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[5]/input")).sendKeys("3");

			Thread.sleep(2000);
			//Add Manual Entry
			driver.findElement(By.xpath("//i[contains(.,'Manual Entry')]")).click();

			Thread.sleep(1000);
			//clear the Required Item
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[2]/input")).clear();
			//Enter the required Item
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[2]/input")).sendKeys("Test");
			
			Thread.sleep(1000);
			//clear the Price per Unit Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[4]/input")).clear();
			//Enter the Price per Unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[4]/input")).sendKeys("500");
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[5]/input")).sendKeys("2");
			Thread.sleep(2000);
			
			//Click the update
			driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
			Thread.sleep(2500);

			//Check whether the storage locations updated successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub Recipe updated successfully!."))
			{
				test.log(LogStatus.PASS, "New Sub Recipe updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Sub Recipe updated Failed");
			}

			Thread.sleep(5000);

		}

		@Test(priority=52)
		public void Inventory_Sub_Recipes_edit_Invetory_Sub_Recipe_SubRecipe_Manual() throws Exception
		{
			Thread.sleep(5000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(5000);
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_SubRecipe_Name")+"1");
			Thread.sleep(5000);
			//Click the Edit icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			Thread.sleep(1500);
			//Click the Close button for Sub Recipe
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			Thread.sleep(1500);
			//Click the Close button for Sub Recipe
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			
			Thread.sleep(2000);
			//Add Sub Recipe
			driver.findElement(By.xpath("//i[contains(.,'Sub Recipe')]")).click();

			Thread.sleep(1000);
			//Click the Item
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
			//Enter the Required Item
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[2]/div/div/div/input")).sendKeys("pizza base");
			//Press the Enter button
			Thread.sleep(2000);driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[3]/div/a")).click();
			//Enter the Required Recipe Unit
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[3]/div/div/div/input")).sendKeys("Kilo gram");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[3]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[5]/input")).sendKeys("3");

			Thread.sleep(2000);
			//Add Manual Entry
			driver.findElement(By.xpath("//i[contains(.,'Manual Entry')]")).click();

			Thread.sleep(1000);
			//clear the Required Item
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[2]/input")).clear();
			//Enter the required Item
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[2]/input")).sendKeys("Test");
			
			Thread.sleep(1000);
			//clear the Price per Unit Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[4]/input")).clear();
			//Enter the Price per Unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[4]/input")).sendKeys("500");
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[5]/input")).sendKeys("2");

			
			//Click the update
			driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
			Thread.sleep(2500);

			//Check whether the storage locations updated successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub Recipe updated successfully!."))
			{
				test.log(LogStatus.PASS, "New Sub Recipe updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Sub Recipe updated Failed");
			}

			Thread.sleep(5000);

		}

		@Test(priority=53)
		public void Inventory_Sub_Recipes_edit_Invetory_Sub_Recipe_SubRecipe_SubRecipe() throws Exception
		{
			Thread.sleep(5000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(5000);
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_SubRecipe_Name")+"1");
			Thread.sleep(5000);
			//Click the Edit icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			Thread.sleep(1500);
			//Click the Close button for Sub Recipe
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			Thread.sleep(1500);
			//Click the Close button for Sub Recipe
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			Thread.sleep(2000);
			//Add Sub Recipe
			driver.findElement(By.xpath("//i[contains(.,'Sub Recipe')]")).click();

			Thread.sleep(1000);
			//Click the Item
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
			//Enter the Required Item
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[2]/div/div/div/input")).sendKeys("pizza base");
			//Press the Enter button
			Thread.sleep(2000);driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Recipe Unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[3]/div/a")).click();
			//Enter the Required Recipe Unit
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[3]/div/div/div/input")).sendKeys("Kilo gram");
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
			
			//Click the update
			driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
			Thread.sleep(2500);

			//Check whether the storage locations updated successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub Recipe updated successfully!."))
			{
				test.log(LogStatus.PASS, "New Sub Recipe updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Sub Recipe updated Failed");
			}

			Thread.sleep(5000);

		}

		@Test(priority=54)
		public void Inventory_Sub_Recipes_edit_Invetory_Sub_Recipe_Manual_Manual() throws Exception
		{
			Thread.sleep(5000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(5000);
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_SubRecipe_Name")+"1");
			Thread.sleep(5000);
			//Click the Edit icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			Thread.sleep(1500);
			//Click the Close button for Sub Recipe
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			Thread.sleep(1500);
			//Click the Close button for Sub Recipe
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[7]/a/i")).click();
			Thread.sleep(1000);
			//Click the Yes Button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(1500);
			
			Thread.sleep(2000);
			//Add Manual Entry
			driver.findElement(By.xpath("//i[contains(.,'Manual Entry')]")).click();

			Thread.sleep(1000);
			//clear the Required Item
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/input")).clear();
			//Enter the required Item
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[2]/input")).sendKeys("Test");
			
			Thread.sleep(1000);
			//clear the Price per Unit Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[4]/input")).clear();
			//Enter the Price per Unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[4]/input")).sendKeys("500");
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[5]/input")).sendKeys("2");

			Thread.sleep(2000);
			//Add Manual Entry
			driver.findElement(By.xpath("//i[contains(.,'Manual Entry')]")).click();

			Thread.sleep(1000);
			//clear the Required Item
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[2]/input")).clear();
			//Enter the required Item
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[2]/input")).sendKeys("Test");
			
			Thread.sleep(1000);
			//clear the Price per Unit Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[4]/input")).clear();
			//Enter the Price per Unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[4]/input")).sendKeys("500");
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[5]/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div/table/tbody/tr[2]/td[5]/input")).sendKeys("2");

			
			//Click the update
			driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
			Thread.sleep(2500);

			//Check whether the storage locations updated successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub Recipe updated successfully!."))
			{
				test.log(LogStatus.PASS, "New Sub Recipe updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Sub Recipe updated Failed");
			}

			Thread.sleep(5000);

		}

		@Test(priority=55)
		public void Inventory_Sub_Recipes_delete_Invetory_Sub_Recipe() throws Exception
		{
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(5000);
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_SubRecipe_Name")+"1");
			Thread.sleep(6000);		
			//Click the Delete button
			driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
			Thread.sleep(1500);
			
			//Click the Yes button in the popup
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(3000);
			
			//Check the storage locations deleted or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub Recipe inactivated successfully"))
			{
				test.log(LogStatus.PASS, "New Sub Recipe deleted Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Sub Recipe deleted Failed");
			}

			Thread.sleep(5000);
		

			//Click the Active Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/div[1]/input")).click();
			Thread.sleep(4000);
			
			//Click the success button
			driver.findElement(By.cssSelector("i.fa.fa-check")).click();
			Thread.sleep(2000);
			
			//Click the Yes button in the popup
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			Thread.sleep(3000);
			
			//Check the Storage Location activated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub recipe activated successfully"))
			{
				test.log(LogStatus.PASS, "Sub recipe activated Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Sub recipe activated Failed");
			}
			
			Thread.sleep(5000);
		}

		@Test(priority=56)
		public void Inventory_Sub_Recipes_closeButton_Sub_Recipe() throws Exception
		{
			Thread.sleep(5000);
			//Click on the Add Sub Recipe option
			driver.findElement(By.id("subRecipe")).click();
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
			
				
			//Click the Cancel button
			driver.findElement(By.xpath("//a[.='Cancel']")).click();
			
			Thread.sleep(3000);
			//Check whether the new Storage Location canceled or not
			if(driver.findElement(By.id("subRecipe")).isDisplayed())
			{
				test.log(LogStatus.PASS, "New Sub Recipe Canceled Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Sub Recipe Canceled Failed");
			}

			Thread.sleep(5000);
		}
				
		@Test(priority=56)
		public void Inventory_Sub_Recipes_verifyActive_InActiveButton_Sub_Recipe() throws Exception
		{
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			
			Thread.sleep(5000);
			//Click Active or In Active Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/div[1]/input")).click();

			Thread.sleep(5000);
			//Check the Inactive page is loaded or not
			if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Deleted Sub Recipes are here, we are in InActive Page");
				Thread.sleep(10000);
				//Click Active or In Active Button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/div[1]/input")).click();

			}
			else if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Deleted Sub Recipes are not here, we are in Active Page");
			}
			Thread.sleep(5000);
		}
	
}
