package epicList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import epicList_Integrated.Utility;

public class AddEditDelete_ProductItems_RetailItem_NEW {
	
	public WebDriver driver;
		
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete_Product_Retail_Items");

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

	@Test(priority=151)
	public void Retail_Item_Open_Retail_Item_Page() throws Exception
	{
/*		//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[3]/ul/li[10]/a/span"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Products/Items Option		
		driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[3]/ul/li[10]/a/span")).click();
*/		
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"menus");
		Thread.sleep(5000);
		//Check Menu items page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Menu Items"))
		{
			test.log(LogStatus.PASS, "Menu Items page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Items page loaded Failed");
		}
	}
	
	@Test(priority=152,enabled=true)
	public void Retail_Item_Refresh_Page() throws InterruptedException
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a[1]/i")).click();
		
		//Check Menu Items page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Menu Items"))
		//if(driver.findElement(By.xpath("//i[@class='fa fa-spinner fa-spin fa-md']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Menu Items page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Items page refreshed Failed");
		}
	}
	
	@Test(priority=153,enabled=true)
	public void Retail_Item_Pagination() throws InterruptedException
	{
		
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Pagination option as 10
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div/ul[1]/li[2]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10");
		//Create the web element for menu item Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div/ul[1]/li[3]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15");
		//Create the web element for menu item Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div/ul[1]/li[4]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20");
		//Create the web element for menu item Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div/ul[1]/li[1]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5");
		//Create the web element for menu item Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available");
		}
		Thread.sleep(8000);
	}
	
	@Test(priority=154,enabled=true)
	public void Retail_Item_add_Retail_Item() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click on the Add Retail Item option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a[4]/i")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW RETAIL ITEM']")).getText().equalsIgnoreCase("NEW RETAIL ITEM"))
		{
			test.log(LogStatus.PASS, "New Retail Items form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Retail Items form loaded Failed");
		}
				
		
		Thread.sleep(3000);
		//Clear the Name field		 
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Name"));
		Thread.sleep(2000);
		//Clear the Secondary Name field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[3]/div/input")).clear();
		//Enter the Secondary Name
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[3]/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_SecName"));
		Thread.sleep(1000);
		
		//Select the required Level
		Select level = new Select(driver.findElement(By.xpath("//select[@name='categoryLevel']")));
		level.selectByVisibleText("Category");
		
		//Click the Category option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[5]/div/div/a")).click();
		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[5]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Clear the SKU code
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[7]/div/div[3]/ng-form/div/div/input")).clear();
		//Enter the SKU code
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[7]/div/div[3]/ng-form/div/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_SKUcode"));
		
		//Click the Add SKU button
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[7]/div/div[1]/a/i")).click();
		//Clear the SKU code of newly added one
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[7]/div/div[4]/ng-form/div/div/input")).clear();
		//Enter the SKU code of newly added one
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[7]/div/div[4]/ng-form/div/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_SKUcode")+"new");		
		
		//Click the Add SKU button
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[7]/div/div[1]/a/i")).click();
		List<WebElement> rows = driver.findElements(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[7]/div/div/ng-form/div/div/a/i"));
		rows.size();
		int row = rows.size() + 2;
		//Click the Close button of newly added button of SKU code
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[7]/div/div["+row+"]/ng-form/div/div/a/i")).click();
		
		//Switch the control to the alert pouup
		Alert x = driver.switchTo().alert();
		//Capture the alert message									
		String alertMessage = driver.switchTo().alert().getText();
		//Print the alert message
		System.out.println(alertMessage);
		//Accept the alert
		x.accept();
		
		Thread.sleep(3000);
		
		//Click the Serving Size Level Option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[8]/div/div/table/tbody/tr/td[1]/ng-form/div/div/a")).click();
		//Enter the required Serving size Level
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[8]/div/div/table/tbody/tr/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[8]/div/div/table/tbody/tr/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
		//Clear the Price option
		driver.findElement(By.name("price")).clear();
		//Enter the required price
		driver.findElement(By.name("price")).sendKeys("125");
		
		Thread.sleep(1000);
		//Clear the margin percentage
		driver.findElement(By.name("marginPercentage")).clear();
		//Enter the required percentage
		driver.findElement(By.name("marginPercentage")).sendKeys("3");
		
		Thread.sleep(1000);
		//Clear the Cost Price
		//driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[10]/div/input")).clear();
		//Enter the Cost Price
		//driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[10]/div/input")).sendKeys("600");
		
		//Click the Add new Tax Button
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[2]/div[2]/a/i")).click();
		
		Thread.sleep(5000);
		//Check weather new tax form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Tax"))
		{
			test.log(LogStatus.PASS, "New Tax Form Loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax Form Loaded Fail");
		}
		Thread.sleep(1000);
		
		//Clear the new tax name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div[2]/form/div[1]/div/input")).clear();
		//Enter the required new tax Name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_TaxName"));
				
		//Enable or Disable the Default Tax button
		//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div[2]/form/div[2]/div[1]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Enable or disable the Inclusive Tax button
		//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div[2]/form/div[2]/div[2]/div/label/span")).click();
		
		Thread.sleep(1000);
		//Clear the percentage field
		driver.findElement(By.name("percentage")).clear();
		//Enter the required percentage
		driver.findElement(By.name("percentage")).sendKeys("5000");
		
		Thread.sleep(1000);
		//click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-success.btn-small")).click();		
		Thread.sleep(10000);

		//Enable or disable the Do not show Button on POS
		driver.findElement(By.xpath("//input[@ng-model='menu.doNotShowButton']")).click();
		
		Thread.sleep(1000);
		//Enable or disable the Hide MenuItem in Online Order
		driver.findElement(By.xpath("//input[@ng-model='menu.hideMenuItemInZenpepper']")).click();

		Thread.sleep(3000);
		//Enable or Disable the EBT menu item option
		driver.findElement(By.xpath("//input[@ng-model='menu.ebtMenuItem']")).click();
		
		Thread.sleep(1000);
		//Click the any one display button from the given buttons
		driver.findElement(By.xpath("//div[@class='email-template-color color-swatch ng-scope'][8]")).click();

		Thread.sleep(5000);
		//Choose the image from the disk
		driver.findElement(By.xpath("//input[@id='retailItemImage']")).sendKeys(Utility.getProperty("Product_Retail_Items_User_Img"));
		
		Thread.sleep(3000);
		//Click the Applicable Time Period option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/div/div/input")).sendKeys("Always");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(10000);
		//Click the Next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(10000);
		//Click the Add new Inventory Category Button
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div/div[1]/div[1]/div[2]/a/i")).click();
		
		Thread.sleep(5000);
		//Check weather new Inventory Category form loaded or not
		if(driver.findElement(By.xpath("//span[.='New Category']")).getText().equalsIgnoreCase("New Category"))
		{
			test.log(LogStatus.PASS, "New Inventory Category Form Loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Inventory Category Form Loaded Fail");
		}
		Thread.sleep(1000);

		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div[2]/form/div[1]/div/input")).clear();
		//Enter the Category name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Inventory_CategoryName"));
		
		//CLear the description field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div[2]/form/div[2]/div/textarea")).clear();
		//Enter the required description
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div[2]/form/div[2]/div/textarea")).sendKeys("NewCategory Description");
		
		Thread.sleep(2000);
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-success.btn-small")).click();
		
		Thread.sleep(5000);
		//Click the Add new Primary Storage Button
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div/div[1]/div[2]/div[2]/a/i")).click();
									 
		Thread.sleep(5000);
		//Check weather new Primary Storage form loaded or not
		if(driver.findElement(By.xpath("//span[.=' New Storage Location ']")).getText().equalsIgnoreCase("New Storage Location"))
		{
			test.log(LogStatus.PASS, "New Primary Storage Location Form Loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Primary Storage Location Form Loaded Fail");
		}
		Thread.sleep(1000);

		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div[2]/form/div[1]/div/input")).clear();
		//Enter the name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Storage_Name"));
		
		//CLear the description field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div[2]/form/div[2]/div/textarea")).clear();
		//Enter the required description
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div[2]/form/div[2]/div/textarea")).sendKeys("New Storage Description");
		
		Thread.sleep(2000);
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-success.btn-small")).click();
		
		Thread.sleep(5000);
		//Click the Secondary storage option
		driver.findElement(By.xpath("//div[@id='ssl_chosen']/a")).click();
		Thread.sleep(2000);
		//Enter the required storage location
		driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		//Press the Enter key
		driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys(Keys.ENTER);
		
		if(driver.findElement(By.xpath("//label[.='Calculate COGS On Cost Price']/../div/label/input")).isEnabled())
		{
			//Enable the Calculate COGS on Cost Prise
			driver.findElement(By.xpath("//label[@class='label-checkbox inline']/span")).click();
		}
		
		//Click the Add new Vendor Button
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div/div[2]/div[1]/div[2]/a/i")).click();
		
		Thread.sleep(5000);
		//Check weather new vendor form loaded or not
		if(driver.findElement(By.xpath("//span[.=' New Vendor ']")).getText().equalsIgnoreCase("New Vendor"))
		{
			test.log(LogStatus.PASS, "New Vendor Form Loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Vendor Form Loaded Fail");
		}
		Thread.sleep(1000);

		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div[2]/form/div[1]/div/input")).clear();
		//Enter the Category name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Vendor_Name"));
		
		Thread.sleep(2000);
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-success.btn-small")).click();

		Thread.sleep(2000);
		//Clear the Brand Name
		driver.findElement(By.name("brandName")).clear(); 
		//Enter the Brand Name
		driver.findElement(By.name("brandName")).sendKeys("Retail_Brand");
		
		
		//Click the Selling Unit Option
		driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/a")).click();
		//Enter the required Selling Unit Option
		driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/div/div/input")).sendKeys(Keys.ENTER);
		
		//Clear the Par Level
		driver.findElement(By.name("minInventoryCount")).clear();
		//Enter the Par Level
		driver.findElement(By.name("minInventoryCount")).sendKeys("4");
		
		//Clear the cost option
		//driver.findElement(By.name("price")).clear();
		//Enter the cost option
		//driver.findElement(By.name("price")).sendKeys("165");
		
		
		Thread.sleep(5000);
		//Press the Previous button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-left")).click();
		
		Thread.sleep(3000);
		//Click the Next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
			
		Thread.sleep(10000);
		//Click the Save and Next button
		driver.findElement(By.xpath("//a[contains(.,'Save & Next')]")).click();

		//Check Childs page is opened or not
		try
		{
			/*		//Click the Childs option
			driver.findElement(By.xpath("//span[.='Childs']")).click();*/
			
			Thread.sleep(20000);
		
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//Click the Add button
				driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/div[1]/div/div/div/a[2]")).click();
							
				Thread.sleep(8000);
				//Check weather new child form loaded or not
				if(driver.findElement(By.xpath("//h4[.='Add child']")).getText().equalsIgnoreCase("Add child"))
				{
					test.log(LogStatus.PASS, "Add child Form Loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Add child Form Loaded Fail");
				}
				Thread.sleep(1000);
				
				//Clear the name field
				driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[1]/div[1]/div/div/input")).clear();
				//Enter the name field
				driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[1]/div[1]/div/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Child_Name"));

				//Clear the Secondary name field
				driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[1]/div[2]/div/div/input")).clear();
				//Enter the Secondary name field
				driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[1]/div[2]/div/div/input")).sendKeys("Sec_Name");
				
				//Clear the SKU code field
				driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[2]/div[1]/div[1]/div/div[2]/ng-form/div/div/input")).clear();
				//Enter the SKU code field
				driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[2]/div[1]/div[1]/div/div[2]/ng-form/div/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Child_SKUCode"));
				
				//Click the new SKU code option
				driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[2]/div[1]/div[1]/label/a/i")).click();
				//Clear the SKU code field
				driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[2]/div[1]/div[1]/div/div[3]/ng-form/div/div/input")).clear();
				//Enter the SKU code field
				driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[2]/div[1]/div[1]/div/div[3]/ng-form/div/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Child_SKUCode")+"new");
				
				//Click the Add SKU button
				driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[2]/div[1]/div[1]/label/a/i")).click();
				//Click the Close button of newly added button of SKU code
				driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[2]/div[1]/div[1]/div/div[4]/ng-form/div/div/a/i")).click();
				
				//Switch the control to the alert pouup
				Alert x1 = driver.switchTo().alert();
				//Capture the alert message									
				String alertMessage1 = driver.switchTo().alert().getText();
				//Print the alert message
				System.out.println(alertMessage1);
				//Accept the alert
				x1.accept();
				
				Thread.sleep(3000);
				
				//CLear the description
				driver.findElement(By.name("description")).clear();
				//Enter the description
				driver.findElement(By.name("description")).sendKeys("Description");
				
				//Clear the Selling ratio
				driver.findElement(By.name("sellingRatio")).clear();
				//Enter the Selling ratio
				driver.findElement(By.name("sellingRatio")).sendKeys("3");
				
				//Clear the Cost field
				//driver.findElement(By.name("cost")).clear();
				//Enter the cost
				//driver.findElement(By.name("cost")).sendKeys("185");

				//Enable or Disable the Override price option
				driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[5]/div/label/span")).click();
				
				//Enable or disable the Do not show Button on POS
				driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[2]/div[2]/div[1]/div/input")).click();
				
				//Click the any one Display button
				driver.findElement(By.xpath("//div[@class='email-template-color color-swatch ng-scope'][4]")).click();
				
				Thread.sleep(5000);
				//Click the Select image from disk option
				driver.findElement(By.xpath("//input[@id='retailItemImage']")).sendKeys("C:\\Users\\hariprasanth_j\\Desktop\\RetailItem.jpg");
				
				Thread.sleep(3000);
				//Click the Selling Unit Option
				driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/a")).click();
				//Enter the required Selling Unit
				driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/div/div/input")).sendKeys(Keys.ARROW_DOWN);
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(3000);
				//Clear the Price Option
				//driver.findElement(By.name("price")).clear();
				//Enter the required price
				//driver.findElement(By.name("price")).sendKeys("225");
				
				Thread.sleep(3000);
				//Click the OK button
				driver.findElement(By.xpath("//form[@name='childForm']/div[2]/button")).click();
				Thread.sleep(3000);
				
				//Check whether the child saved or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Child item saved successfully"))
				{
					test.log(LogStatus.PASS, "New Child is saved Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "New Child is saved Failed");
				}
				Thread.sleep(3000);
		
			//Click the Add button
			driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/div[1]/div/div/div/a[2]")).click();
			
			Thread.sleep(2000);
			//Check weather new child form loaded or not
			if(driver.findElement(By.xpath("//h4[.='Add child']")).getText().equalsIgnoreCase("Add child"))
			{
				test.log(LogStatus.PASS, "Add child Form Loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Add child Form Loaded Fail");
			}
			Thread.sleep(1000);
			
			//Clear the name field
			driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[1]/div[1]/div/div/input")).clear();
			//Enter the name field
			driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[1]/div[1]/div/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Child_Name")+"10");

			//Clear the Secondary name field
			driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[1]/div[2]/div/div/input")).clear();
			//Enter the Secondary name field
			driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[1]/div[2]/div/div/input")).sendKeys("Sec_Name");
			
			//Clear the SKU code field
			driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[2]/div[1]/div[1]/div/div[2]/ng-form/div/div/input")).clear();
			//Enter the SKU code field
			driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[2]/div[1]/div[1]/div/div[2]/ng-form/div/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Child_SKUCode")+"12");
					
			
			Thread.sleep(3000);
			
			//CLear the description
			driver.findElement(By.name("description")).clear();
			//Enter the description
			driver.findElement(By.name("description")).sendKeys("Description");
			
			//Clear the Selling ratio
			driver.findElement(By.name("sellingRatio")).clear();
			//Enter the Selling ratio
			driver.findElement(By.name("sellingRatio")).sendKeys("3");
			
			//Clear the Cost field
			//driver.findElement(By.name("cost")).clear();
			//Enter the cost
			//driver.findElement(By.name("cost")).sendKeys("185");

			//Enable or Disable the Override price option
			driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[5]/div/label/span")).click();
			
			//Enable or disable the Do not show Button on POS
			driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[2]/div[2]/div[1]/div/input")).click();
			
			//Click the any one Display button
			driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[10]")).click();
			
			Thread.sleep(5000);
			//Click the Select image from gallery option
			driver.findElement(By.xpath("//form[@name='childForm']/div[1]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/a[1]/i")).click();
			
			Thread.sleep(15000);
			//Select the required image
			driver.findElement(By.xpath("//form[@name='imageform']/div[2]/div/div/div[3]/div[1]/a/img")).click();
			
			Thread.sleep(8000);
			//Click the Selling Unit Option
			driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/a")).click();
			//Enter the required Selling Unit
			driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/div/div/input")).sendKeys("Each");
			//Press the Enter Key
			driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(3000);
			//Clear the Price Option
			//driver.findElement(By.name("price")).clear();
			//Enter the required price
			//driver.findElement(By.name("price")).sendKeys("225");
			
			Thread.sleep(3000);
			//Click the OK button
			driver.findElement(By.xpath("//form[@name='childForm']/div[2]/button")).click();
			Thread.sleep(3000);
			
			//Check whether the child saved or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Child item saved successfully"))
			{
				test.log(LogStatus.PASS, "New Child is saved Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Child is saved Failed");
			}
			Thread.sleep(3000);
			//Click the Unlink Option
			driver.findElement(By.cssSelector("i.fa.fa-chain-broken")).click();
			Thread.sleep(3000);
			
			//Check whether the new form loaded or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Menu item un-linked successfully"))
			{
				test.log(LogStatus.PASS, "New Menu Item is un-linked Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Menu Item is un-linked Failed");
			}
			Thread.sleep(3000);
			//Click the Link Item Option
			driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/div[1]/div/div/div/a[1]")).click();
			
			Thread.sleep(3000);
			//Click the menu option
			driver.findElement(By.xpath("//form[@name='linkForm']/div[1]/div/div/div/div/div/a")).click();
			Thread.sleep(2000);
			//Enter the required input
			driver.findElement(By.xpath("//form[@name='linkForm']/div[1]/div/div/div/div/div/div/div/input")).click();
			Thread.sleep(2000);
			//Press the Enter Key
			driver.findElement(By.xpath("//form[@name='linkForm']/div[1]/div/div/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Link Option
			driver.findElement(By.xpath("//form[@name='linkForm']/div[2]/button")).click();
			
			
			Thread.sleep(5000);
			//Click the SKU code field
			driver.findElement(By.xpath("//input[@name='skuCode']")).click();
			//Press the Backspace key
			driver.findElement(By.xpath("//input[@name='skuCode']")).sendKeys(Keys.BACK_SPACE);
			//Enter new code
			driver.findElement(By.xpath("//input[@name='skuCode']")).sendKeys("1");

			Thread.sleep(3000);
			//Click the Update button
			driver.findElement(By.xpath("//form[@name='childForm']/div[2]/button")).click();
			
			//Check whether the child is updated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Child item updated successfully"))
			{
				test.log(LogStatus.PASS, "New Child is updated Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Child is updated Failed");
			}
			
			Thread.sleep(5000);
			
			//Click the Cancel button
			driver.findElement(By.xpath("//a[.='Cancel']")).click();
			Thread.sleep(8000);
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Retail Item Create page opened when user click the Save & Next option");
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			//Click the Cancel button
			driver.findElement(By.xpath("//a[.='Cancel']")).click();
			Thread.sleep(8000);
		}
	
	}
	
	@Test(priority=155,enabled=true)
	public void Retail_Item_Edit_Retail_Item() throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"1");
		Thread.sleep(3000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Search button
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		
		Thread.sleep(8000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
	
		Thread.sleep(3000);
		//Clear the Name field		 
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).clear();
		//Enter the Name			 
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"1");
				
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(3000);
		//Select the required level
		Select level = new Select(driver.findElement(By.name("categoryLevel")));
		level.selectByVisibleText("Sub Category");
		
		//Click the Category option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[5]/div/div/a")).click();
		//Enter the required category
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[5]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		//Click the Sub Category option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[6]/div/div/a")).click();
		//Enter the required Sub category
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[6]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		//System.out.println("Test 1");
		Thread.sleep(8000);
		//Click the Serving Size option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[9]/div/div/table/tbody/tr/td[1]/ng-form/div/div/a")).click();
		//Enter the required serving size level
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[9]/div/div/table/tbody/tr/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[9]/div/div/table/tbody/tr/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Clear the price option
		driver.findElement(By.name("price")).clear();
		//Enter the price
		driver.findElement(By.name("price")).sendKeys("255");
		//System.out.println("Test 2");
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click the Include sub-category taxes
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[1]/div/label/span")).click();
		
		Thread.sleep(3000);
		//Click the taxes option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[2]/div[1]/div/ul")).click();
		//Enter the required tax
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[2]/div[1]/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[2]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		if(driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[5]/div/input")).isEnabled())
		{
		Thread.sleep(3000);
		//Enable or disable the EBT menu item
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[5]/div/input")).click();
		}
		
		//Click the Select the image from gallery option
		driver.findElement(By.xpath("//i[@class='fa fa-image']")).click();
		
		Thread.sleep(15000);
		//Click the required image
		driver.findElement(By.xpath("//form[@name='imageform']/div[2]/div/div/div[3]/div[1]/a/img")).click();
		Thread.sleep(5000);
			
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/div/div/input")).sendKeys("Days of Week");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Days of Week Option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[8]/div/div/ul")).click();
		//Enter the required DAY for Searching
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[8]/div/div/ul/li/input")).sendKeys("WEDNESDAY");
		//Press the Enter key after enter the keyword
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[8]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Enable or disable the Restriction Time Period option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[9]/div/label/span")).click();
		Thread.sleep(2000);
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[10]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}

		Thread.sleep(3000);
		//Click the update and publish button
		driver.findElement(By.xpath("//span[contains(.,'Update And Publish')]")).click();
		Thread.sleep(2000);
		
		//Check whether the Retail Item updated successfully or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Retail item updated and published successfully"))
		{
			test.log(LogStatus.PASS, "New Retail item updated and Published successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Retail Item is updated and Published Failed");
		}
		Thread.sleep(3000);

	}
		
	@Test(priority=156,enabled=true)
	public void Retail_Item_Delete_Retail_Item() throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"11");
		Thread.sleep(3000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Search button
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		Thread.sleep(8000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		//Click the Yes button in the popup
		driver.findElement(By.linkText("Yes")).click();
		Thread.sleep(3000);
		//Check the menu item deleted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Retail item inactivated successfully"))
		{
			test.log(LogStatus.PASS, "New Retail Item is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Retail Item is deleted Failed");
		}
		Thread.sleep(3000);
		
		//Click the Active Button
		driver.findElement(By.xpath("//input[@ng-model='activeStatus']")).click();
		Thread.sleep(3000);
		
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		//Click the Yes button in the popup
		driver.findElement(By.linkText("Yes")).click();
		Thread.sleep(3000);
		
		//Check the menu item activated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Retail item activated successfully"))
		{
			test.log(LogStatus.PASS, "Retail Item is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Retail Item is activated Failed");
		}
		
		Thread.sleep(3000);
		
		//Click the Active Button
		driver.findElement(By.xpath("//input[@ng-model='activeStatus']")).click();
		Thread.sleep(3000);
	
	}
		
	@Test(priority=157)
	public void Retail_Item_Add_RetailItem_By_Copy_RetailItem() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click on the Add Retail Item option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a[4]/i")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW RETAIL ITEM']")).getText().equalsIgnoreCase("NEW RETAIL ITEM"))
		{
			test.log(LogStatus.PASS, "New Retail Items form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Retail Items form loaded Failed");
		}
		
		//Click the Retail Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();
		//Enter the REquired retail Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"1");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
		
		Thread.sleep(2000);
		//Click the Clear Option  
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/span/a")).click();
		
		//Click the Menu Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();
		//Enter the REquired menu Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"1");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
	
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"10");
		
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		//Select the required level
		Select level = new Select(driver.findElement(By.name("categoryLevel")));
		level.selectByVisibleText("Category");
		
		//Click the Category option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[5]/div/div/a")).click();
		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[5]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the enter button
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Clear the PLU CODE
		driver.findElement(By.name("skuCode")).clear();
		//Enter the required PLU CODE
		driver.findElement(By.name("skuCode")).sendKeys(Utility.getProperty("Product_Retail_Items_SKUcode")+"2");
			
		//Click the Serving Size level option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[8]/div/div/table/tbody/tr/td[1]/ng-form/div/div/a")).click();
		//Enter the required serving size level
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[8]/div/div/table/tbody/tr/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[8]/div/div/table/tbody/tr/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Clear the Price field
		driver.findElement(By.name("price")).clear();
		//Enter the required price
		driver.findElement(By.name("price")).sendKeys("215");
		
		//Enable or disable the Include Category Taxes option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[1]/div/label/span")).click();
	
		Thread.sleep(3000);
		//Click the tax option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[2]/div[1]/div/ul")).click();
		//Enter the required tax
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[2]/div[1]/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[2]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/div/div/input")).sendKeys("Days of Month");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Required Date form the Calendar
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[8]/div/table/tbody/tr[2]/td[7]/button")).click();
		Thread.sleep(2000);
		
		//Enable or Disable the Restriction Months option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[9]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the months field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[10]/div/div/ul")).click();
		//Enter the Required month
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[10]/div/div/ul/li/input")).sendKeys("MAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[10]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Restriction Time option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[11]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[12]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		Thread.sleep(5000);

		//Click the Save button
		driver.findElement(By.xpath("//span[.='Save']")).click();
		Thread.sleep(3000);
		
		//Check whether the new Retail saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Retail item saved successfully"))
		{
			test.log(LogStatus.PASS, "New Retail Item is saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Retail Item is saved Failed");
		}
		Thread.sleep(8000);
	}
	
	@Test(priority=159)
	public void Retail_Item_cancelRetailItemByCopyRetailItem_MenuDetails() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click on the Add Retail Item option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a[4]/i")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW RETAIL ITEM']")).getText().equalsIgnoreCase("NEW RETAIL ITEM"))
		{
			test.log(LogStatus.PASS, "New Retail Items form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Retail Items form loaded Failed");
		}
			
		Thread.sleep(3000);
		//Click the Retail Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();
		Thread.sleep(1000);
		//Enter the REquired retail Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"1");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
			
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"10");

		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(3000);
		
		//Check whether the new menu item page loaded or not
		if(driver.findElement(By.xpath("//a[.='Menu items']")).getText().equalsIgnoreCase("Menu items"))
		{
			test.log(LogStatus.PASS, "New Retail Item is cancelled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Retail Item is cancelled Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=158)
	public void Retail_Item_cancelRetailItemByCopyRetailItem_Inventory_Details() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click on the Add Retail Item option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a[4]/i")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW RETAIL ITEM']")).getText().equalsIgnoreCase("NEW RETAIL ITEM"))
		{
			test.log(LogStatus.PASS, "New Retail Items form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Retail Items form loaded Failed");
		}
			
		Thread.sleep(3000);
		//Click the Retail Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();
		Thread.sleep(1500);
		//Enter the REquired retail Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"1");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
			
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"10");

		Thread.sleep(3000);
		//Clear the sku code
		driver.findElement(By.name("skuCode")).clear();Thread.sleep(3000);
		Thread.sleep(3000);
		//Enter the SKU COde
		driver.findElement(By.name("skuCode")).sendKeys(Utility.getProperty("Product_Retail_Items_SKUcode")+"31");
		
		Thread.sleep(3000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		Thread.sleep(3000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(3000);
		
		//Check whether the new retail item cancelled or not
		if(driver.findElement(By.xpath("//a[.='Menu items']")).getText().equalsIgnoreCase("Menu items"))
		{
			test.log(LogStatus.PASS, "New Retail Item is cancelled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Retail Item is cancelled Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=160)
	public void Retail_Item_cancelRetailItemByCopyRetailItem_Childs() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click on the Add Retail Item option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a[4]/i")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW RETAIL ITEM']")).getText().equalsIgnoreCase("NEW RETAIL ITEM"))
		{
			test.log(LogStatus.PASS, "New Retail Items form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Retail Items form loaded Failed");
		}
		
		Thread.sleep(2000);
		//Click the Retail Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();
		//Enter the REquired retail Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"1");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
			
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"10");

		Thread.sleep(2000);
		//Clear the sku code
		driver.findElement(By.name("skuCode")).clear();Thread.sleep(2000);
		Thread.sleep(2000);
		//Enter the SKU COde
		driver.findElement(By.name("skuCode")).sendKeys(Utility.getProperty("Product_Retail_Items_SKUcode")+"3e");
		
		
		Thread.sleep(3000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(3000);
		//Click the Childs Circle option
		driver.findElement(By.xpath("//span[.='3']")).click();
		
		Thread.sleep(2000);
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(3000);
		
		//Check whether the new retail item cancelled or not
		if(driver.findElement(By.xpath("//a[.='Menu items']")).getText().equalsIgnoreCase("Menu items"))
		{
			test.log(LogStatus.PASS, "New Retail Item is cancelled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Retail Item is cancelled Failed");
		}
		Thread.sleep(3000);
	}
		
	@Test(priority=161)
	public void Retail_Item_saveAndContinueRetailItemByCopyRetailItem() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click on the Add Retail Item option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a[4]/i")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW RETAIL ITEM']")).getText().equalsIgnoreCase("NEW RETAIL ITEM"))
		{
			test.log(LogStatus.PASS, "New Retail Items form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Retail Items form loaded Failed");
		}
		Thread.sleep(2000);
		//Click the Retail Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();
		//Enter the REquired retail Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"1");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
			
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"11");

		Thread.sleep(2000);
		//Clear the sku code
		driver.findElement(By.name("skuCode")).clear();
		Thread.sleep(2000);
		//Enter the SKU COde
		driver.findElement(By.name("skuCode")).sendKeys(Utility.getProperty("Product_Retail_Items_SKUcode")+"3");
		Thread.sleep(2000);
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/div/div/input")).sendKeys("Always");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
		Thread.sleep(3000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(8000);
		//Click the Inventory Category option
		driver.findElement(By.xpath("//div[@id='inventoryCategory_chosen']/a")).click();
		//Enter the required inventory category
		driver.findElement(By.xpath("//div[@id='inventoryCategory_chosen']/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='inventoryCategory_chosen']/div/div/input")).sendKeys(Keys.ENTER);
				
		Thread.sleep(3000);
		//Click the Primary Storage option
		driver.findElement(By.xpath("//div[@id='psl_chosen']/a")).click();
		//Enter the required primary storage
		driver.findElement(By.xpath("//div[@id='psl_chosen']/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='psl_chosen']/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Click the Secondary Storage option
		driver.findElement(By.xpath("//div[@id='ssl_chosen']/a")).click();
		//Enter the required Secondary storage
		driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		//Click the Vendor option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div/div[2]/div[1]/div[1]/div/a")).click();
		//Enter the required vendor option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div/div[2]/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div/div[2]/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Save And Continue button
		driver.findElement(By.xpath("//span[.='Save And Continue']")).click();
		Thread.sleep(3000);
		
		//Check whether the new retail item saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Retail item saved successfully"))
		{
			test.log(LogStatus.PASS, "New Retail Item is saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Retail Item is saved Failed");
		}
		Thread.sleep(10000);
		
		
		//Click the Retail Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();
		//Enter the REquired retail Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"11");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
			
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"12");

		Thread.sleep(3000);
		//Clear the sku code
		driver.findElement(By.name("skuCode")).clear();Thread.sleep(3000);
		//Enter the SKU COde
		driver.findElement(By.name("skuCode")).sendKeys(Utility.getProperty("Product_Retail_Items_SKUcode")+"4");
		
		Thread.sleep(3000);
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/div/div/input")).sendKeys("Specific date");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Clear the Date field
		driver.findElement(By.name("date")).clear();
		//Enter the required date
		driver.findElement(By.name("date")).sendKeys("15-May-2040");
		
		//Enable or Disable the Restriction Time option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[9]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[10]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		
		//Click the save and continue button
		driver.findElement(By.xpath("//span[.='Save And Continue']")).click();
		Thread.sleep(3000);
		
		//Check whether the new retail item saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Retail item saved successfully"))
		{
			test.log(LogStatus.PASS, "New Retail Item is saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Retail Item is saved Failed");
		}
		Thread.sleep(10000);
		
		//Click the Retail Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();
		//Enter the REquired retail Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"12");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
			
		Thread.sleep(3000);
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("Product_Retail_Items_Name")+"13");
		
		Thread.sleep(3000);
		//Clear the sku code
		driver.findElement(By.name("skuCode")).clear();
		//Enter the SKU COde
		driver.findElement(By.name("skuCode")).sendKeys(Utility.getProperty("Product_Retail_Items_SKUcode")+"5");
		
		Thread.sleep(3000);
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/div/div/input")).sendKeys("Start date time & end date time");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Clear the From date field
		driver.findElement(By.name("fromDate")).clear();
		//Enter the required from Date
		driver.findElement(By.name("fromDate")).sendKeys("25-May-2050");Thread.sleep(3000);
		//Clear the To Date field
		driver.findElement(By.name("endDate")).clear();
		//Enter the required To Date
		driver.findElement(By.name("endDate")).sendKeys("28-May-2050");
		
		//Enable or Disable the Restriction Days Option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[10]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the Days of a Week option
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[11]/div/div/ul")).click();
		//Enter the Required Date
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[11]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[11]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[12]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='menuItemCreation']/div/ng-form/div[2]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		Thread.sleep(5000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();

		//Click the Save button
		driver.findElement(By.xpath("//span[.='Save']")).click();
		Thread.sleep(3000);
		
		//Check whether the new Retail saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Retail item saved successfully"))
		{
			test.log(LogStatus.PASS, "New Retail Item is saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Retail Item is saved Failed");
		}
		Thread.sleep(8000);
		
	}
	
}