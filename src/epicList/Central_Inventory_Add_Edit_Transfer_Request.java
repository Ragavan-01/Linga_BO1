package epicList;

import java.util.List;
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

public class Central_Inventory_Add_Edit_Transfer_Request {
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Central_Inventory_Add_Edit_Transfer_Request");

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

	@Test(priority=19)
	public void Central_Transfer_Request_openpage() throws Exception
	{
		/*//Click the My Stores option
		driver.findElement(By.xpath("//span[.='My Stores']")).click();

		Thread.sleep(3000);
        //Click the Central Inventory Reports Option		
		driver.findElement(By.xpath("//span[.='Central Inventory']")).click();
		
		Thread.sleep(2000);
		//Click the Central WareHouse option
		driver.findElement(By.xpath("//span[contains(.,'Transfer Request')]")).click();
*/
		Thread.sleep(3000);	
		//Enter the Coursing URL
		driver.get(Utility.getProperty("Enterprise_Base_URL")+"centralStores/transferRequest");
		
		Thread.sleep(3000);
		//Check Central Warehouse page opened or not
		if(driver.findElement(By.xpath("//a[.='Transfer Requests']")).getText().equalsIgnoreCase("Transfer Requests"))
		{
			test.log(LogStatus.PASS, "Central Transfer Requests page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Central Transfer Requests page loaded Failed");
		}
		
		Thread.sleep(3000);
		
	}
	
	/*@Test(priority=3)
	public void Central_Transfer_Request_pagination() throws InterruptedException
	{
						
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Pagination option as 10
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div/div/div/div/ul/li[2]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Central Transfer Request");
		//Create the web element for Central Transfer Request Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div/table"));
		for (WebElement result : results){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Central Transfer Request");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div/div/div/div/ul/li[3]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Central Transfer Request");
		//Create the web element for Central Transfer Request Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div/table"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Central Transfer Request");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div/div/div/div/ul/li[4]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for Central Transfer Request");
		//Create the web element for Central Transfer Request Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div/table"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Central Transfer Request");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div/div/div/div/ul/li[1]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Central Transfer Request");
		//Create the web element for Central Transfer Request Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div/table"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Central Transfer Request");
		}
		
		 Thread.sleep(3000);
		  
	}*/
	@Test(priority=20)
	public void Central_Transfer_Request_Cancle() throws Exception
	{
		
	Thread.sleep(2000);
	//Click refresh button
	driver.findElement(By.cssSelector("a.btn.btn-md.btn-border.btn-refresh")).click();
	Thread.sleep(3000);
	//Click Transfer Request button
	driver.findElement(By.cssSelector("a.btn.btn-small.btn-inverse.btn--icon.ng-binding")).click();Thread.sleep(3000);
	//Check Central Warehouse page opened or not
			if(driver.findElement(By.xpath("//span[.='New Transfer Request']")).getText().equalsIgnoreCase("New Transfer Request"))
			{
				test.log(LogStatus.PASS, "New Transfer Request page Successfully loaded ");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Transfer Request page Successfully loaded is failed");
			}
			
			Thread.sleep(2000);
		//Click From field to select store
		driver.findElement(By.xpath("//form[@name='createForm']/div[1]/div[1]/div[1]/div/div/div/a")).click();
		
		Thread.sleep(1000);
		//Click From field to select store
		//driver.findElement(By.xpath("//form[@name='createForm']/div[1]/div[1]/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Central_Transfer_from"));
		
		Thread.sleep(1000);
		//Click From field to select store
		driver.findElement(By.xpath("//form[@name='createForm']/div[1]/div[1]/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click TO field to select store
		driver.findElement(By.xpath("//form[@name='createForm']/div[1]/div[1]/div[2]/div/div/div/a")).click();
		
		Thread.sleep(1000);
		//Click To field to select store
		driver.findElement(By.xpath("//form[@name='createForm']/div[1]/div[1]/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		
		Thread.sleep(1000);
		//Click To field to select store
		driver.findElement(By.xpath("//form[@name='createForm']/div[1]/div[1]/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		//Click new Inventory item button
		driver.findElement(By.cssSelector("i.fa.fa-plus-circle.ng-binding")).click();
		
		Thread.sleep(2000);
		//Select Inventory item 
		driver.findElement(By.xpath("//select[@name='inventoryItem']/../div/a")).click();
		//Enter the Required Inventory Item
		driver.findElement(By.xpath("//select[@name='inventoryItem']/../div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Clear the quantity value
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[4]/input")).clear();
		//Enter the quantity value
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[4]/input")).sendKeys("1");
		Thread.sleep(1000);
		//Click remove button for inventory item
		driver.findElement(By.cssSelector("i.fa.fa-times")).click();
		Thread.sleep(2000);
		//Cancel button for inventory item
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=21)
	public void Central_Transfer_Request_Request() throws Exception
	{
			
			Thread.sleep(2000);
			//Click refresh button
			driver.findElement(By.cssSelector("a.btn.btn-md.btn-border.btn-refresh")).click();
			Thread.sleep(3000);
			//Click Transfer Request button
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-inverse.btn--icon.ng-binding")).click();Thread.sleep(3000);
			//Check Central Warehouse page opened or not
					if(driver.findElement(By.xpath("//span[.='New Transfer Request']")).getText().equalsIgnoreCase("New Transfer Request"))
					{
						test.log(LogStatus.PASS, "New Transfer Request page Successfully loaded ");
					}
					else
					{
						test.log(LogStatus.FAIL, "New Transfer Request page Successfully loaded is failed");
					}
					
					Thread.sleep(2000);
				//Click From field to select store
				driver.findElement(By.xpath("//form[@name='createForm']/div[1]/div[1]/div[1]/div/div/div/a")).click();
				
				Thread.sleep(1000);
				//Click From field to select store
				//driver.findElement(By.xpath("//form[@name='createForm']/div[1]/div[1]/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Central_Transfer_from"));
				
				Thread.sleep(1000);
				//Click From field to select store
				driver.findElement(By.xpath("//form[@name='createForm']/div[1]/div[1]/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Click TO field to select store
				driver.findElement(By.xpath("//form[@name='createForm']/div[1]/div[1]/div[2]/div/div/div/a")).click();
				
				Thread.sleep(1000);
				//Click To field to select store
				driver.findElement(By.xpath("//form[@name='createForm']/div[1]/div[1]/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
				
				Thread.sleep(1000);
				//Click To field to select store
				driver.findElement(By.xpath("//form[@name='createForm']/div[1]/div[1]/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Click new Inventory item button
				driver.findElement(By.cssSelector("i.fa.fa-plus-circle.ng-binding")).click();
				
				Thread.sleep(2000);
				//Select Inventory item 
				driver.findElement(By.xpath("//select[@name='inventoryItem']/../div/a")).click();
				//Enter the Required Inventory Item
				driver.findElement(By.xpath("//select[@name='inventoryItem']/../div/div/div/input")).sendKeys(Keys.ENTER);

				Thread.sleep(1000);
				//Clear the quantity value
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[4]/input")).clear();
				//Enter the quantity value
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[4]/input")).sendKeys("1");
				Thread.sleep(1000);
			
			//Click Request button for inventory item
			driver.findElement(By.xpath("//a[.='Cancel']/../button")).click();
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
		}

	@Test(priority=22)
	public void Central_Transfer_Request_QuantityNotAvailable() throws Exception
	{
		Thread.sleep(3000);
		//Click the yes button
		List<WebElement> min = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div/table/tbody/tr/td[6]/span/a[2]/i"));
		min.size();
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div/table/tbody/tr["+min.size()+"]/td[6]/span/a[2]/i")).click();
		Thread.sleep(2000);
		//Click that Transfer item button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.btn-border-green.ng-binding")).click();

		Thread.sleep(1000);
		try
		{
			//Check whether the Received Items are Loaded Or not
			if(driver.findElement(By.xpath("//span[.='*Requested Inventory Items / Sub Recipes not found in this store.Hence Transfer count field is disabled.']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Requested Inventory Items / Sub Recipes not found in this store.Hence Transfer count field is disabled.");
			}
		}
		catch(Exception e)		
		{
			test.log(LogStatus.PASS, "Requested Inventory Items / Sub Recipes not found in this store.Hence Transfer count field is Enabled.");
						
			List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div/table/tbody/tr/td[4]"));
			for(int i = 1; i <= rows.size(); i++)
			{
			 //Get the store status
			Thread.sleep(3000);
			test.log(LogStatus.PASS,"The source of the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[1]")).getText()+" store status is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[2]")).getText()+ " Updated");
						
			test.log(LogStatus.PASS,"The Destination of the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[3]")).getText()+" store status is" +driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[4]")).getText()+ " Updated");
			}
		}
		Thread.sleep(2000);	
		
	}

}
