package epicList_Integrated;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Product_And_Item_2 {
	
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Product and Items 2");
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
	public void Product_And_Item_method_openProductsItems(WebDriver driver) throws Exception
	{
		Thread.sleep(15000);
		//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[3]/ul/li[10]/a/span"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Products/Items Option		
		driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[3]/ul/li[10]/a/span")).click();
		Thread.sleep(5000);
		//Check Menu items page opened or not
		if(driver.findElement(By.xpath("//a[.='Menu items']")).getText().equalsIgnoreCase("Menu items"))
		{
			test.log(LogStatus.PASS, "Menu Items page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Items page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void Product_And_Item_method_refreshMenuItemPage(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(10000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a[1]/i")).click();
		Thread.sleep(5000);
		//Check Menu Items page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Menu Items"))
		{
			test.log(LogStatus.PASS, "Menu Items page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Items page refreshed Failed");
		}
	}
	
	@Test(priority=3)
	public void Product_And_Item_method_pagination(WebDriver driver) throws InterruptedException
	{
						
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Pagination option as 10
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div/ul[1]/li[2]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Product and Item(Menu Item)");
		//Create the web element for menu item Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Product and Item(Menu Item)");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div/ul[1]/li[3]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Product and Item(Menu Item)");
		//Create the web element for menu item Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Product and Item(Menu Item)");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div/ul[1]/li[4]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for Product and Item(Menu Item)");
		//Create the web element for menu item Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Product and Item(Menu Item)");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div/ul[1]/li[1]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Product and Item(Menu Item)");
		//Create the web element for menu item Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Product and Item(Menu Item)");
		}
		
		 Thread.sleep(3000);
		  
	}
	
/*	@Test(priority=4)
	public void Product_And_Item_method_addMenuItem(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		Thread.sleep(5000);
		//Click on the Add Menu Item option
		driver.findElement(By.id("menuItem")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW MENU ITEM']")).getText().equalsIgnoreCase("NEW MENU ITEM"))
		{
			test.log(LogStatus.PASS, "New Menu Items form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Items form loaded Failed");
		}
				
		
		Thread.sleep(3000);
		//Clear the Name field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name"));
		Thread.sleep(2500);
		//Clear the Secondary Name field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[3]/div/input")).clear();
		//Enter the Secondary Name
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[3]/div/input")).sendKeys(Utility.getProperty("ProductsItems_SecName"));
		Thread.sleep(1000);
		
		//Clear the Description field
		driver.findElement(By.name("description")).clear();
		//Enter the required description
		driver.findElement(By.name("description")).sendKeys("TESTING DESCRIPTION");
		
		//Clear the Chit Name field
		driver.findElement(By.name("chitName")).clear();
		//Enter the required Chit Name
		driver.findElement(By.name("chitName")).sendKeys("TEST CHIT NAME");
		
		//Clear the Kitchen Print Name field
		driver.findElement(By.name("chitName")).clear();
		//Enter the required Kitchen Print Name
		driver.findElement(By.name("chitName")).sendKeys("Kitchen Print");
		
		//Clear the PLU CODE
		driver.findElement(By.name("pluCode")).clear();
		//Enter the required PLU CODE
		driver.findElement(By.name("pluCode")).sendKeys(Utility.getProperty("ProductsItems_PLU_Code"));
	
		//Scroll the page
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("window.scrollBy(0,250)", "");
		
		//Create the Object
		Select level = new Select(driver.findElement(By.name("level")));
		level.selectByVisibleText("Category");
		
		//Scroll the page
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	
		//Click the Category Field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[8]/div[1]/div/a")).click();
		//Enter the required category
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[8]/div[1]/div/div/div/input")).click();
		//Press the Enter key
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[8]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);	
		
		Thread.sleep(2500);
		//Click the Add Category Symbol
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[8]/div[2]/a/i")).click();
		
		Thread.sleep(2500);
		//Check weather new Category form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[1]/h3/span")).getText().equalsIgnoreCase("New category"))
		{
			test.log(LogStatus.PASS, "New Category Form Loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Category Form Loaded Fail");
		}
		Thread.sleep(1000);
		
		//Clear the new Category name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[1]/div/input")).clear();
		//Enter the required new Category Name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Add_Category_Name"));
		
		Thread.sleep(1000);
		//Click the Add Department button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[2]/div[1]/div[2]/a/i")).click();
		
		Thread.sleep(2500);
		//Check weather new department form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[1]/h3/span")).getText().equalsIgnoreCase("New department"))
		{
			test.log(LogStatus.PASS, "New Department Form Loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Department Form Loaded Fail");
		}
		Thread.sleep(1000);
		
		//Clear the Add Department Name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/form/div[1]/div/input")).clear();
		//Enter the required new Department Name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Add_Department_Name"));
		
		Thread.sleep(1000);
		//Clear the description field of New Department
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/input")).clear();
		//Enter the description
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/input")).sendKeys("NewDept Desc");
		
		Thread.sleep(1000);
		//click the Save button
		driver.findElement(By.cssSelector("a.btn.btn-success.btn-small.ng-binding")).click();
		
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Click the New Course Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[2]/div[2]/div[2]/a/i")).click();
		
		Thread.sleep(2500);
		//Check weather the new course form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[1]/h3/span")).getText().equalsIgnoreCase("New course"))
		{
			test.log(LogStatus.PASS, "New Course Form Loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Course Form Loaded Fail");
		}
		Thread.sleep(1000);
		
		//Clear the Add Course Name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/form/div[1]/div/input")).clear();
		//Enter the required new Course Name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Add_Course_Name"));
		
		Thread.sleep(1000);
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority field
		driver.findElement(By.name("priority")).sendKeys("3");
		
		Thread.sleep(1000);
		//click the Save button
		driver.findElement(By.cssSelector("a.btn.btn-success.btn-small.ng-binding")).click();
		
		Thread.sleep(15000);
		//Click the Serving Size Levels Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[2]/a/i")).click();

		Thread.sleep(2500);
		//Check weather the Serving Size Levels form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[1]/h3/span")).getText().equalsIgnoreCase("New servingSizeLevel"))
		{
			test.log(LogStatus.PASS, "New Serving Size Levels Form Loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Serving Size Levels Form Loaded Fail");
		}
		Thread.sleep(1000);
		
		
		
		//Clear the Serving Size Levels Name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/form/div[1]/div/input")).clear();
		//Enter the required new Serving Size Levels Name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name"));
		
		Thread.sleep(1000);
		//Clear the description field of New Serving Size Levels
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/input")).clear();
		//Enter the description
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/input")).sendKeys("SerSizeLeve Desc");
		
		Thread.sleep(1000);
		//click the Save button
		driver.findElement(By.cssSelector("a.btn.btn-success.btn-small.ng-binding")).click();
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div/ul/li/input")).click();
		//Enter another serving size level
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div/ul/li/input")).sendKeys("EACH");
		Thread.sleep(1000);
		//Press Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Enter another serving size level
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div/ul/li/input")).sendKeys("gm");
		Thread.sleep(1000);
		//Press Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Enter another serving size level
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div/ul/li/input")).sendKeys("kg");
		Thread.sleep(1000);
		//Press Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Enter another serving size level
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div/ul/li/input")).sendKeys("lb");
		Thread.sleep(1000);
		//Press Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Enter another serving size level
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div/ul/li/input")).sendKeys("MEDIUM");
		Thread.sleep(1000);
		//Press Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Enter another serving size level
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div/ul/li/input")).sendKeys("SMALL");
		Thread.sleep(1000);
		//Press Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(4000);
		//Click the Taxes Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[4]/div[1]/div[2]/a/i")).click();

		Thread.sleep(2500);
		//Check weather the New Taxes form loaded or not
		if(driver.findElement(By.xpath("//span[.='New Tax']")).getText().equalsIgnoreCase("New Tax"))
		{
			test.log(LogStatus.PASS, "New Tax Form Loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax Form Loaded Fail");
		}
		Thread.sleep(1000);
		
		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/form/div[1]/div/input")).clear();
		//Enter the required Tax name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Add_Tax_Name"));
		
		//Enable or Disable the Default Tax button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/form/div[4]/div[1]/div/label/span")).click();
		
		Thread.sleep(2500);
		//Enable or disable the Inclusive Tax button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/form/div[4]/div[2]/div/label/span")).click();
		
		Thread.sleep(1000);
		//Clear the percentage field
		driver.findElement(By.name("percentage")).clear();
		//Enter the required percentage
		driver.findElement(By.name("percentage")).sendKeys("5000");
		
		Thread.sleep(1000);
		//click the Save button
		driver.findElement(By.cssSelector("a.btn.btn-success.btn-small.ng-binding")).click();
		
		Thread.sleep(10000);
		//click the Save button
		driver.findElement(By.cssSelector("a.btn.btn-success.btn-small.ng-binding")).click();
		Thread.sleep(5000);
		
		//Enable or Disable the isConventional option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[9]/div/label/span")).click();

		//Enable or Disable the cut and modify option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[10]/div/label/span")).click();

		//Clear the Number of Slices Option
		driver.findElement(By.name("maxNumOfSlices")).clear();
		//Enter the number of pieces
		driver.findElement(By.name("maxNumOfSlices")).sendKeys("3");
		
		Thread.sleep(1000);
		//Select the required measure type
		Select measureType = new Select(driver.findElement(By.name("measureType")));
		measureType.selectByVisibleText("Serving Size");
		
		Thread.sleep(3000);
		//Click the add Serving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[2]/td/a")).click();
		      
		Thread.sleep(1000);
		//Click the select an Option field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[2]/td[1]/ng-form/div/div/a")).click();
		//Enter the required Serving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[2]/td[1]/ng-form/div/div/div/div/input")).sendKeys("gm");
		//Press the Enter Key
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[2]/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Clear the Serial number field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[2]/td[2]/ng-form/div/input[2]")).clear();
		//Enter the required serial number
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[2]/td[2]/ng-form/div/input[2]")).sendKeys("1");
		
		Thread.sleep(1000);
		//Clear the price field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[2]/td[3]/ng-form/div/input")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[2]/td[3]/ng-form/div/input")).sendKeys("111");
		
		Thread.sleep(1000);
		//Click the add Serving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[3]/td/a")).click();
		//Click the select an Option field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[3]/td[1]/ng-form/div/div/a")).click();
		//Enter the required Serving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[3]/td[1]/ng-form/div/div/div/div/input")).sendKeys("EACH");
		//Press the Enter Key
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[3]/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Clear the Serial number field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[3]/td[2]/ng-form/div/input[2]")).clear();
		//Enter the required serial number
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[3]/td[2]/ng-form/div/input[2]")).sendKeys("3");
		
		Thread.sleep(1000);
		//Clear the price field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[3]/td[3]/ng-form/div/input")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[3]/td[3]/ng-form/div/input")).sendKeys("113");
		
		Thread.sleep(1000);
		//Click the add Serving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[4]/td/a")).click();
		//Click the select an Option field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[4]/td[1]/ng-form/div/div/a")).click();
		//Enter the required Serving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[4]/td[1]/ng-form/div/div/div/div/input")).sendKeys("kg");
		//Press the Enter Key
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[4]/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Clear the Serial number field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[4]/td[2]/ng-form/div/input[2]")).clear();
		//Enter the required serial number
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[4]/td[2]/ng-form/div/input[2]")).sendKeys("4");
		
		Thread.sleep(1000);
		//Clear the price field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[4]/td[3]/ng-form/div/input")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[4]/td[3]/ng-form/div/input")).sendKeys("114");
		
		Thread.sleep(1000);
		//Click the add Serving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[5]/td/a")).click();
		//Click the select an Option field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[5]/td[1]/ng-form/div/div/a")).click();
		//Enter the required Serving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[5]/td[1]/ng-form/div/div/div/div/input")).sendKeys("SMALL");
		//Press the Enter Key
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[5]/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Clear the Serial number field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[5]/td[2]/ng-form/div/input[2]")).clear();
		//Enter the required serial number
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[5]/td[2]/ng-form/div/input[2]")).sendKeys("2");
		
		Thread.sleep(1000);
		//Clear the price field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[5]/td[3]/ng-form/div/input")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[5]/td[3]/ng-form/div/input")).sendKeys("112");
		
		Thread.sleep(1000);
		//Click the close button of first option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[1]/td[4]/a")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		//Enable or disable the Kitchen printer
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div[2]/label/span")).click();
		//Enable or disable the Label printer
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div[3]/label/span")).click();
		//Enable or disable the Restrict printer
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div[4]/label/span")).click();
		
		Thread.sleep(1000);
		//Click the Tax option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[2]/div[1]/div/ul")).click();
		//Enter the required tax
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[2]/div[1]/div/ul/li/input")).sendKeys("2Default2");
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[2]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//click the Add kitchen printer icon
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[3]/div[2]/a/i")).click();
		
		Thread.sleep(2500);
		//Check weather the New Taxes form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[1]/h3/span")).getText().equalsIgnoreCase("New kitchenPrinter"))
		{
			test.log(LogStatus.PASS, "New Kitchen Printer Form Loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Kitchen Printer Form Loaded Fail");
		}
		Thread.sleep(1000);
		
		//Click the Type field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[1]/div/div/a")).click();
		//Enter the required Type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[1]/div/div/div/div/input")).sendKeys("KDS");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the name field
		driver.findElement(By.name("name")).clear();
		//Enter the name
		driver.findElement(By.name("name")).sendKeys(Utility.getProperty("ProductsItems_Add_KitchenPrinter_Name"));
		
		Thread.sleep(1000);
		//Clear the IP address field
		driver.findElement(By.name("IPAddress")).clear();
		//Enter the IP address
		driver.findElement(By.name("IPAddress")).sendKeys(Utility.getProperty("ProductsItems_Add_IPAddress_KitchenPrinter"));
		
		//Enable or disable the Service Type Restriction
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[4]/div/label/span")).click();
		
		Thread.sleep(2500);
		//Click the Service Type field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul")).click();
		//Enter the required service type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys("BarTab");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Enter the required service type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys("DELIVERY");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Enter the required service type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys("FORHERE");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Enter the required service type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys("PHONEORDER");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Enter the required service type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys("QSR");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Enter the required service type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys("TABLESERVICE");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Enter the required service type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys("ToGo");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Enter the required service type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys("WEBORDER");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		//Enable or disable the Apply to all categories field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/label/span")).click();
		Thread.sleep(1000);
		
		//Enable or disable the Apply to all menu items field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[7]/div/label/span")).click();
		Thread.sleep(1000);
		
		Thread.sleep(3000);
		//click the Save button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[8]/div/div/div/button")).click();
		
		Thread.sleep(3000);
		//Click the add button of Label Printer button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[4]/div[2]/a/i")).click();
		
		Thread.sleep(2500);
		//Check weather the New Label Printer form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[1]/h3/span")).getText().equalsIgnoreCase("New labelPrinter"))
		{
			test.log(LogStatus.PASS, "New Label Printer Form Loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Label Printer Form Loaded Fail");
		}
		Thread.sleep(1000);
		
		//Click the Type field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[1]/div/div/a")).click();
		//Enter the required Type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[1]/div/div/div/div/input")).sendKeys("Address");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the name field
		driver.findElement(By.name("name")).clear();
		//Enter the name
		driver.findElement(By.name("name")).sendKeys(Utility.getProperty("ProductsItems_Add_LabelPrinter_Name"));
		
		Thread.sleep(1000);
		//Click the Printer Model Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[3]/div/div/a")).click();
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the IP address field
		driver.findElement(By.name("IPAddress")).clear();
		//Enter the IP address
		driver.findElement(By.name("IPAddress")).sendKeys(Utility.getProperty("ProductsItems_Add_IPAddress_LabelPrinter"));
		
		//Enable or disable the Service Type Restriction
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[5]/div/label/span")).click();
		
		Thread.sleep(2500);
		//Click the Service Type field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/div/ul")).click();
		//Enter the required service type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/div/ul/li/input")).sendKeys("BarTab");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Enter the required service type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/div/ul/li/input")).sendKeys("DELIVERY");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Enter the required service type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/div/ul/li/input")).sendKeys("FORHERE");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Enter the required service type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/div/ul/li/input")).sendKeys("PHONEORDER");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Enter the required service type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/div/ul/li/input")).sendKeys("QSR");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Enter the required service type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/div/ul/li/input")).sendKeys("TABLESERVICE");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Enter the required service type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/div/ul/li/input")).sendKeys("ToGo");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Enter the required service type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/div/ul/li/input")).sendKeys("WEBORDER");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[6]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		//Enable or disable the Apply to all categories field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[7]/div/label/span")).click();
		Thread.sleep(3000);
		
		//Enable or disable the Apply to all menu items field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[8]/div/label/span")).click();
		Thread.sleep(1000);
		
		
		
		Thread.sleep(3000);
		//click the Save button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div[9]/div/div/div/button")).click();
		Thread.sleep(3000);
		
		//Click the Restrict Service Types option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[5]/div/div/ul")).click();
		//Enter the required service type
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[5]/div/div/ul/li/input")).sendKeys("BarTab");
		//Press Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2500);
		//Enable or disable the Do not show Button on POS field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[6]/div/input")).click();
		
		Thread.sleep(2500);
		//Enable or disable the EBT MenuItem field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[7]/div/input")).click();

		Thread.sleep(1000);
		//Click the required display button
		driver.findElement(By.xpath("//div[@class='email-template-color color-swatch ng-scope'][9]")).click();
		
		Thread.sleep(5000);
		//Choose the image from the disk
		driver.findElement(By.xpath("//input[@id='menuImage']")).sendKeys(Utility.getProperty("DisplayGroupImage1"));
		
		//Click the Applicable Time Period option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[9]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[9]/div/div/div/div/input")).sendKeys("Always");
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[9]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(20000);
		//Click the Next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
			
		Thread.sleep(10000);
		//Click the plus or add symbol
		driver.findElement(By.cssSelector("i.fa.fa-plus-circle")).click();
				
		Thread.sleep(2500);
		//Click the modifier group field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div/div/div[2]/div[1]/div[1]/div/a")).click();
		//Enter the required modifier group
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div/div/div[2]/div[1]/div[1]/div/div/div/input")).sendKeys("TOPPINGS");
		//Press the Enter key
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div/div/div[2]/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Click the modifier option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/a")).click();
		//Enter the required modifier
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div/div/input")).sendKeys("CHEESE");
		//Press the Enter key
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);	
		
		Thread.sleep(2500);
		//Click the Alternate Modifier group
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div/div/div[2]/div[2]/label/span")).click();
		
		Thread.sleep(1000);
		//Select the alternate modifier group option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div/div/div[2]/div[3]/div/div/a")).click();
		//Enter the required modifier
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div/div/div[2]/div[3]/div/div/div/div/input")).sendKeys("Modifier Group2");
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div/div/div[2]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Override prefix up-charges
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div/div/div[2]/div[4]/label/span")).click();
		
		Thread.sleep(1000);
		//Clear the price of prefix amount
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div/div/div[2]/div[5]/table/tbody/tr[2]/td[2]/div[2]/input")).clear();
		//Give the required amount
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div/div/div[2]/div[5]/table/tbody/tr[2]/td[2]/div[2]/input")).sendKeys("120");
		
		Thread.sleep(5000);
		//Click the plus or add symbol
		driver.findElement(By.cssSelector("i.fa.fa-plus-circle")).click();

		//Click the close button of Additional modifier group
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div[2]/div/div[1]/a/i")).click();
		
		Thread.sleep(1000);
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();

		Thread.sleep(5000);
		//Click the plus or add symbol
		driver.findElement(By.cssSelector("i.fa.fa-plus-circle")).click();
		
		Thread.sleep(1000);
		//Click the another one modifier group
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div[2]/div/div[2]/div[1]/div[1]/div/a")).click();
		//Enter the required modifier group name
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div[2]/div/div[2]/div[1]/div[1]/div/div/div/input")).sendKeys("TOPPINGS");
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div[2]/div/div[2]/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the modifier option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/div/a")).click();
		//Enter the required modifier name
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/div/div/div/input")).sendKeys("PEPPERONI");
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2500);
		//Press the Previous button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-left")).click();
		
		Thread.sleep(3000);
		//Click the Next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(3000);
		//Click the Next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		//Click the add Optional Modifier option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/ul/li/a/uib-tab-heading/a")).click();
		
		Thread.sleep(2500);
		//Click the modifier group option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div/div[1]/div/div/div/a")).click();
		//Enter the required modifier group option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div/div[1]/div/div/div/div/div/input")).sendKeys("TOPPINGS");
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Check weather the Override price check box is enabled or not
		if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[1]/div[2]/div[1]/div/input")).isEnabled())
		{
		//Click the Override price option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[1]/div[2]/div[1]/div/input")).click();
		}

		//Clear the Display Order option
		driver.findElement(By.name("ordinal")).clear();
		//Enter the required number option
		driver.findElement(By.name("ordinal")).sendKeys("3");
		
		//Clear the Price option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]/div[1]/input")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]/div[1]/input")).sendKeys("250");
		
		//Click the Set Tiered Price Check box
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[3]/div/div/div/input")).click();
		
		Thread.sleep(2500);
		//Click the Set Tiered option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/ul/li/a/uib-tab-heading/a")).click();
		
		//Click the Serving Size Level Option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[1]/div[1]/div/div[1]/div/a")).click();
		//Enter the required serving size level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys("EACH");
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Add Tiered price option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr/td/a")).click();
		
		//Clear the Quantity option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[2]/ng-form/div/input")).clear();
		//Give the required quantity
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[2]/ng-form/div/input")).sendKeys("1");
		
		Thread.sleep(2500);
		//Select the required option to set the price
		Select setPrice = new Select(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[3]/ng-form/div/select")));
		setPrice.selectByVisibleText("Each");
		
		//Clear the price option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[4]/ng-form/div/input")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[4]/ng-form/div/input")).sendKeys("350");
		
		Thread.sleep(1000);
		//Click the Add Tiered price option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td[1]/a")).click();
		
		//Clear the Quantity option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td[2]/ng-form/div/input")).clear();
		//Give the required quantity
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td[2]/ng-form/div/input")).sendKeys("2");
		
		Thread.sleep(2500);
		//Select the required option to set the price
		Select setPrice1 = new Select(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td[3]/ng-form/div/select")));
		setPrice1.selectByVisibleText("All");
		
		//Clear the price option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td[4]/ng-form/div/input")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td[4]/ng-form/div/input")).sendKeys("250");
		
		Thread.sleep(1000);
		//Click the Add Tiered price option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[3]/td/a")).click();

		Thread.sleep(1000);
		//Click the delete option of last added one
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[3]/td/a")).click();
		
		//Click the add Set Tiered Price option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/ul/li[2]/a/uib-tab-heading/a")).click();
		
		Thread.sleep(1000);
		//Click the delete Tiered Price option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/ul/li[2]/a/uib-tab-heading/a")).click();
		
		//Click the add Set Tiered Price option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/ul/li[2]/a/uib-tab-heading/a")).click();

		Thread.sleep(2500);
		//Click the Select Serving Size Level Option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[1]/div[1]/div/div[1]/div/a")).click();
		//Enter the required serving size level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys("gm");
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Click the Add tiered price option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr/td/a")).click();
		
		//Clear the quantity field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]/td[2]/ng-form/div/input")).clear();
		//Enter the quantity
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]/td[2]/ng-form/div/input")).sendKeys("4");
		
		Thread.sleep(2500);
		//Select the required option to set the price
		Select setPrice2 = new Select(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]/td[3]/ng-form/div/select")));
		setPrice2.selectByVisibleText("Each");
		
		//Clear the price field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]/td[4]/ng-form/div/input")).clear();
		//Enter the price
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]/td[4]/ng-form/div/input")).sendKeys("212");
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		//Click the Optional modifier option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/ul/li[2]/a/uib-tab-heading/a")).click();
		
		//Click the Modifier Group Option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div/div[1]/div/div/div/a")).click();
		//Enter the required modifier group
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div/div[1]/div/div/div/div/div/input")).sendKeys("Group3");
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Check weather the Override price check box is enabled or not
		if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[1]/div[2]/div[1]/div/input")).isEnabled())
		{
			//Click the Override Price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[1]/div[2]/div[1]/div/input")).click();
		}
		
		//Clear the Display order option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[1]/div[2]/div[2]/div/input")).clear();
		//Enter the required number of order
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[1]/div[2]/div[2]/div/input")).sendKeys("3");
			
		//Check weather the override price is enabled or not for first option
		if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[2]/input")).isEnabled())
		{
			//Click the override price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[2]/input")).click();
			
			Thread.sleep(3000);
			
			//Clear the price for first option
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[3]/div[1]/input")).clear();
			//Enter the required price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[3]/div[1]/input")).sendKeys("111");
			
			//Clear the price for first option
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[4]/div[1]/input")).clear();
			//Enter the required price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[4]/div[1]/input")).sendKeys("111");

			//Clear the price for first option
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[5]/div[1]/input")).clear();
			//Enter the required price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[5]/div[1]/input")).sendKeys("111");

			//Clear the price for first option
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[6]/div[1]/input")).clear();
			//Enter the required price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[6]/div[1]/input")).sendKeys("111");

			
			//Check weather the override price is enabled or not for second option
			if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[3]/td[2]/input")).isEnabled())
			{
				//Click the override price
				driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[3]/td[2]/input")).click();
				
				//Check weather the override price is enabled or not for second option
				if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[4]/td[2]/input")).isEnabled())
				{
					//Click the override price
					driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[4]/td[2]/input")).click();
				}
			}
		}
		
		//Check weather the override price is enabled or not for second option
		else if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[3]/td[2]/input")).isEnabled())
		{
			//Click the override price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[3]/td[2]/input")).click();
			
			//Check weather the override price is enabled or not for second option
			if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[4]/td[2]/input")).isEnabled())
			{
				//Click the override price
				driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[4]/td[2]/input")).click();
			}
		}
		
		//Check weather the override price is enabled or not for second option
		else
		{
			//Click the override price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[4]/td[2]/input")).click();
		}
		
		
		Thread.sleep(2500);
		//Press the Previous button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-left")).click();
		
		Thread.sleep(3000);
		//Click the Next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(3000);
		//Click the Next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		//Click the Add Mandatory Modifier option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/ul/li/a/uib-tab-heading/a")).click();
		
		//Click the Modifier Group option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div/div[1]/div[1]/div/div/a")).click();
		//Enter the required modifier
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div/div[1]/div[1]/div/div/div/div/input")).sendKeys("TOPPINGS");
		//Press the Enter key
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);	
		
		//Check weather the Override price is enabled or not
		if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/input")).isEnabled())
		{
			Thread.sleep(1000);
			//Click the Override price option
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/input")).click();
		}
		
		//Clear the minimum Quantity field
		driver.findElement(By.name("minQuantity")).clear();
		//Enter the minimum Quantity
		driver.findElement(By.name("minQuantity")).sendKeys("5");
		
		//Clear the maximum Quantity field
		driver.findElement(By.name("maxQuantity")).clear();
		//Enter the maximum Quantity
		driver.findElement(By.name("maxQuantity")).sendKeys("6");
		
		//Clear the Display order field
		driver.findElement(By.name("ordinal")).clear();
		//Enter the Display order
		driver.findElement(By.name("ordinal")).sendKeys("2");
		
		Thread.sleep(2500);
		//Clear the Price Option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]/div[1]/input")).clear();
		//Enter the price
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]/div[1]/input")).sendKeys("150");
		
		//Click the Set Tiered price Check box
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[3]/div/div/div/input")).click();
		
		//Click the Add Set Tiered price
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/ul/li/a/uib-tab-heading/a")).click();
		
		Thread.sleep(1000);
		//Click the Serving Size Level field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[1]/div[1]/div/div[1]/div/a")).click();
		//Enter the required SErving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys("EACH");
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Add tiered price option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr/td/a")).click();
		
		//Clear the Quantity field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[2]/ng-form/div/input")).clear();
		//Enter the Quantity field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[2]/ng-form/div/input")).sendKeys("2");
		
		Thread.sleep(1000);
		//Select the required Price option
		Select setPrice3 = new Select(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[3]/ng-form/div/select")));
		setPrice3.selectByVisibleText("Each");
		
		//Clear the price field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[4]/ng-form/div/input")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[4]/ng-form/div/input")).sendKeys("215");
		
		Thread.sleep(1000);
		//Click the Add tiered price option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td/a")).click();
		
		//Clear the Quantity field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td[2]/ng-form/div/input")).clear();
		//Enter the Quantity field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td[2]/ng-form/div/input")).sendKeys("3");
		
		Thread.sleep(1000);
		//Select the required Price option
		Select setPrice4 = new Select(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td[3]/ng-form/div/select")));
		setPrice4.selectByVisibleText("All");
		
		//Clear the price field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td[4]/ng-form/div/input")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td[4]/ng-form/div/input")).sendKeys("115");
		
		//Click the Add Tiered Price
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[3]/td/a")).click();
		
		Thread.sleep(3000);
		//Click the close or delete button of last added tiered price option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[3]/td/a")).click();
		
		//Add the another one Set Tiered Price Option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/ul/li[2]/a/uib-tab-heading/a")).click();
		
		Thread.sleep(1000);
		//Click the Select Serving Size Level Option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[1]/div[1]/div/div[1]/div/a")).click();
		//Enter the required Serving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys("gm");
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Add tiered price option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr/td/a")).click();
		
		//Clear the Quantity field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]/td[2]/ng-form/div/input")).clear();
		//Enter the required quantity
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]/td[2]/ng-form/div/input")).sendKeys("3");
		
		Select setPrice5 = new Select(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]/td[3]/ng-form/div/select")));
		setPrice5.selectByVisibleText("Each");
		
		//Clear the Price field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]/td[4]/ng-form/div/input")).clear();
		//Enter the Price
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]/td[4]/ng-form/div/input")).sendKeys("145");
		
		Thread.sleep(3000);
		//Click the Add Set tiered Price option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/ul/li[3]/a/uib-tab-heading/a")).click();
		
		Thread.sleep(3000);
		//Delete the last added Set tiered price option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[2]/div[4]/div/ul/li[3]/a/uib-tab-heading/a")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2500);
		//Click the Add Mandatory Modifier field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/ul/li[2]/a/uib-tab-heading/a")).click();
		
		//Click the Modifier group option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div/div[1]/div[1]/div/div/a")).click();
		//Enter the required modifier group
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div/div[1]/div[1]/div/div/div/div/input")).sendKeys("Group3");
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Check weather the Override price is enabled or not
		if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[1]/div[1]/div[2]/div/input")).isEnabled())
		{
			Thread.sleep(1000);
			//Click the override price check box option
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[1]/div[1]/div[2]/div/input")).click();
		}
		
		//Clear the minimum Quantity field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div/div[2]/div[1]/div/input")).clear();
		//Enter the minimum Quantity
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div/div[2]/div[1]/div/input")).sendKeys("2");
		
		//Clear the maximum Quantity field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div/div[2]/div[2]/div/input")).clear();
		//Enter the maximum Quantity
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div/div[2]/div[2]/div/input")).sendKeys("4");
		
		//Clear the Display order field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div/div[2]/div[3]/div/input")).clear();
		//Enter the Display order
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div/div[2]/div[3]/div/input")).sendKeys("3");
		
		Thread.sleep(3000);
		//Check weather the override price is enabled or not for first option
		if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[1]/input")).isEnabled())
		{
			//Click the override price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[1]/input")).click();
			
			Thread.sleep(3000);
			
			//Clear the price for first option
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[2]/div[1]/input")).clear();
			//Enter the required price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[2]/div[1]/input")).sendKeys("111");
			
			//Clear the price for first option
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[3]/div[1]/input")).clear();
			//Enter the required price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[3]/div[1]/input")).sendKeys("111");

			//Clear the price for first option
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[4]/div[1]/input")).clear();
			//Enter the required price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[4]/div[1]/input")).sendKeys("111");

			//Clear the price for first option
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[5]/div[1]/input")).clear();
			//Enter the required price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[5]/div[1]/input")).sendKeys("111");

			//Check weather the override price is enabled or not for second option
			if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[3]/td[1]/input")).isEnabled())
			{
				//Click the override price
				driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[3]/td[1]/input")).click();
				
				//Check weather the override price is enabled or not for second option
				if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[4]/td[1]/input")).isEnabled())
				{
					//Click the override price
					driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[4]/td[1]/input")).click();
				}
			}
		}
		
		//Check weather the override price is enabled or not for second option
		else if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[3]/td[1]/input")).isEnabled())
		{
			//Click the override price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[3]/td[1]/input")).click();
			
			//Check weather the override price is enabled or not for second option
			if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[4]/td[1]/input")).isEnabled())
			{
				//Click the override price
				driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[4]/td[1]/input")).click();
			}
		}
		
		//Check weather the override price is enabled or not for second option
		else
		{
			//Click the override price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[4]/td[1]/input")).click();
		}
		

		//Click the add mandatory modifier field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/ul/li[3]/a/uib-tab-heading/a")).click();
		
		Thread.sleep(2500);
		//Delete the last added mandatory modifier field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/ul/li[3]/a/uib-tab-heading/a")).click();

		Thread.sleep(2500);
		//Press the Previous button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-left")).click();
		
		Thread.sleep(3000);
		//Click the Next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Menu item saved successfully"))s
		{
			test.log(LogStatus.PASS, "New Menu Item is saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item is saved Failed");
		}
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")a).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")a).sendKeys(Utility.getProperty("ProductsItems_Name"));

		String menuItemName = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]")).getText();
		
		Thread.sleep(3000);
		if(menuItemName == Utility.getProperty("ProductsItems_Name")+" (EBT)")
		{
			test.log(LogStatus.PASS, "EBT is added successfully after the required menu item name");
		}
		else
		{
			test.log(LogStatus.FAIL, "EBT is added fail after the required menu item name");
		}
		Thread.sleep(3000);
	}
*/
	@Test(priority=4)
	public void Product_And_Item_method_addMenuItem(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		Thread.sleep(5000);
		//Click on the Add Menu Item option
		driver.findElement(By.id("menuItem")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW MENU ITEM']")).getText().equalsIgnoreCase("NEW MENU ITEM"))
		{
			test.log(LogStatus.PASS, "New Menu Items form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Items form loaded Failed");
		}
				
		
		Thread.sleep(3000);
		//Clear the Name field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name"));
		Thread.sleep(2500);
		//Clear the Secondary Name field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[3]/div/input")).clear();
		//Enter the Secondary Name
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[3]/div/input")).sendKeys(Utility.getProperty("ProductsItems_SecName"));
		Thread.sleep(1000);
		
		//Clear the Description field
		driver.findElement(By.name("description")).clear();
		//Enter the required description
		driver.findElement(By.name("description")).sendKeys("TESTING DESCRIPTION");
		
/*		//Clear the Chit Name field
		driver.findElement(By.name("chitName")).clear();
		//Enter the required Chit Name
		driver.findElement(By.name("chitName")).sendKeys("TEST CHIT NAME");*/
		
		//Clear the Kitchen Print Name field
		driver.findElement(By.name("chitName")).clear();
		//Enter the required Kitchen Print Name
		driver.findElement(By.name("chitName")).sendKeys("Kitchen Print");
		
		//Clear the PLU CODE
		driver.findElement(By.name("pluCode")).clear();
		//Enter the required PLU CODE
		driver.findElement(By.name("pluCode")).sendKeys(Utility.getProperty("ProductsItems_PLU_Code"));
	
		//Scroll the page
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("window.scrollBy(0,250)", "");
		
		//Create the Object
		Select level = new Select(driver.findElement(By.name("level")));
		level.selectByVisibleText("Category");
		
		//Scroll the page
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	
		//Click the Category Field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[8]/div[1]/div/a")).click();
		//Enter the required category
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[8]/div[1]/div/div/div/input")).click();
		//Press the Enter key
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[8]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);	
		
		Thread.sleep(3000);
		//Enable the Cut and Modify option
		driver.findElement(By.xpath("//span[contains(.,'conversational')]/../../../../div/div/label/span[contains(.,'Cut And Modify')]")).click();Thread.sleep(5000);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);Thread.sleep(2500);
		//Enable the Cut and Modify option
		driver.findElement(By.xpath("//span[contains(.,'Price Level Settings')]")).click();
		Thread.sleep(2500);
		//Enable the Is concventional option
		driver.findElement(By.xpath("//span[contains(.,'conversational')]")).click();Thread.sleep(5000);

		//Clear the Number of Slices option
		driver.findElement(By.xpath("//label[.='Number of slices']/../div/input")).clear();
		//Enter the required input
		driver.findElement(By.xpath("//label[.='Number of slices']/../div/input")).sendKeys("3");
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		Thread.sleep(2500);
		//Select the required measure type
		Select measureType = new Select(driver.findElement(By.name("measureType")));
		measureType.selectByVisibleText("Serving Size");
	
		Thread.sleep(2500);
		//Click the add Serving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[2]/td/a")).click();
		      
		Thread.sleep(1000);
		//Click the select an Option field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[2]/td[1]/ng-form/div/div/a")).click();
		//Enter the required Serving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[2]/td[1]/ng-form/div/div/div/div/input")).click();
		//Press the Enter Key
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[2]/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Clear the Serial number field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[2]/td[2]/ng-form/div/input[2]")).clear();
		//Enter the required serial number
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[2]/td[2]/ng-form/div/input[2]")).sendKeys("1");
		
		Thread.sleep(1000);
		//Clear the price field
		driver.findElement(By.xpath("//label[.='Prices']/../div/div/table/tbody/tr[2]/td[3]/table/tbody/tr/td[2]/ng-form/div/input")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//label[.='Prices']/../div/div/table/tbody/tr[2]/td[3]/table/tbody/tr/td[2]/ng-form/div/input")).sendKeys("111");
		
		Thread.sleep(1000);
		//Click the add Serving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[3]/td/a")).click();
		//Click the select an Option field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[3]/td[1]/ng-form/div/div/a")).click();
		//Enter the required Serving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[3]/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[3]/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Clear the Serial number field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[3]/td[2]/ng-form/div/input[2]")).clear();
		//Enter the required serial number
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[3]/td[2]/ng-form/div/input[2]")).sendKeys("3");
		
		Thread.sleep(1000);
		//Clear the price field
		driver.findElement(By.xpath("//label[.='Prices']/../div/div/table/tbody/tr[3]/td[3]/table/tbody/tr/td[2]/ng-form/div/input")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//label[.='Prices']/../div/div/table/tbody/tr[3]/td[3]/table/tbody/tr/td[2]/ng-form/div/input")).sendKeys("113");
		
		Thread.sleep(1000);
		//Click the add Serving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[4]/td/a")).click();
		//Click the select an Option field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[4]/td[1]/ng-form/div/div/a")).click();
		//Enter the required Serving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[4]/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(1000);
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[4]/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[4]/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[4]/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Clear the Serial number field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[4]/td[2]/ng-form/div/input[2]")).clear();
		//Enter the required serial number
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[4]/td[2]/ng-form/div/input[2]")).sendKeys("4");
		
		Thread.sleep(1000);
		//Clear the price field
		driver.findElement(By.xpath("//label[.='Prices']/../div/div/table/tbody/tr[4]/td[3]/table/tbody/tr/td[2]/ng-form/div/input")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//label[.='Prices']/../div/div/table/tbody/tr[4]/td[3]/table/tbody/tr/td[2]/ng-form/div/input")).sendKeys("114");
		
		Thread.sleep(1000);
		//Click the add Serving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[5]/td/a")).click();
		//Click the select an Option field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[5]/td[1]/ng-form/div/div/a")).click();
		//Enter the required Serving Size Level
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[5]/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[5]/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[5]/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[5]/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Clear the Serial number field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[5]/td[2]/ng-form/div/input[2]")).clear();
		//Enter the required serial number
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[15]/div/div/table/tbody/tr[5]/td[2]/ng-form/div/input[2]")).sendKeys("2");
		
		Thread.sleep(1000);
		//Clear the price field
		driver.findElement(By.xpath("//label[.='Prices']/../div/div/table/tbody/tr[5]/td[3]/table/tbody/tr/td[2]/ng-form/div/input")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//label[.='Prices']/../div/div/table/tbody/tr[5]/td[3]/table/tbody/tr/td[2]/ng-form/div/input")).sendKeys("112");
		
		Thread.sleep(3000);
		for(int i = 1; i <= 4; i++){driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);}
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);Thread.sleep(3000);
		//Click the close button of first option
		driver.findElement(By.xpath("//label[.='Prices']/../div/div/table/tbody/tr[1]/td[3]/table/tbody/tr/th[4]/a/i")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		//Enable or disable the Kitchen printer
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div[2]/label/span")).click();
		//Enable or disable the Label printer
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div[3]/label/span")).click();
		//Enable or disable the Restrict printer
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div[4]/label/span")).click();
		
		Thread.sleep(1000);
		//Click the Tax option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[2]/div[1]/div/ul")).click();
		//Enter the required tax
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[2]/div[1]/div/ul/li/input")).click();
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[2]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Kitchen Printer option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[3]/div[1]/div/ul")).click();
		//Click the input field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[3]/div[1]/div/ul/li/input")).click();
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[3]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Click the Label Printer option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[4]/div[1]/div/ul")).click();
		//Click the input field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[4]/div[1]/div/ul/li/input")).click();
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[4]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Click the Restrict Service Types option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[5]/div/div/ul")).click();
		//Enter the required service type
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[5]/div/div/ul/li/input")).sendKeys("BarTab");
		//Press Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Enable or disable the Do not show Button on POS field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[6]/div/input")).click();
		
		Thread.sleep(1000);
		//Enable or disable the Hide MenuItem in Zenpepper on POS field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[7]/div/input")).click();

		Thread.sleep(1000);
		//Enable or disable the EBT MenuItem field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[8]/div/input")).click();

		Thread.sleep(1000);
		//Click the required display button
		driver.findElement(By.xpath("//div[@class='email-template-color color-swatch ng-scope'][2]")).click();
		
		Thread.sleep(5000);
		//Choose the image from the disk
		driver.findElement(By.xpath("//input[@id='menuImage']")).sendKeys(Utility.getProperty("DisplayGroupImage1"));
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(3000);
		//Click the Applicable Time Period option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/div/div/input")).sendKeys("Always");
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(15000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		Thread.sleep(2500);
		//Click the Next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
			
		Thread.sleep(10000);
		//Click the plus or add symbol
		driver.findElement(By.cssSelector("i.fa.fa-plus-circle")).click();
				
		Thread.sleep(2500);
		//Click the modifier group field
		driver.findElement(By.xpath("//select[@name='modGroup']/../div/a")).click();
		//Enter the required modifier group
		driver.findElement(By.xpath("//select[@name='modGroup']/../div/div/div/input")).click();
		//Press the Enter key
		driver.findElement(By.xpath("//select[@name='modGroup']/../div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Click the modifier option
		driver.findElement(By.xpath("//select[@name='includedModifier']/../div/a")).click();
		//Enter the required modifier
		driver.findElement(By.xpath("//select[@name='includedModifier']/../div/div/div/input")).click();
		//Press the Enter key
		driver.findElement(By.xpath("//select[@name='includedModifier']/../div/div/div/input")).sendKeys(Keys.ENTER);	
		
		Thread.sleep(2500);
		//Click the Alternate Modifier group
		driver.findElement(By.xpath("//span[contains(.,'Alternate modifier group')]")).click();
		
		Thread.sleep(1000);
		//Select the alternate modifier group option
		driver.findElement(By.xpath("//select[@name='alternateGroup']/../div/a")).click();
		//Enter the required modifier
		driver.findElement(By.xpath("//select[@name='alternateGroup']/../div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//select[@name='alternateGroup']/../div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Override prefix up-charges
		driver.findElement(By.xpath("//span[contains(.,'Override prefix up-charges')]")).click();
		
		Thread.sleep(1000);
		//Clear the price of prefix amount
		driver.findElement(By.xpath("//th[.='Prefix']/../../tr/td[2]/div/input")).clear();
		//Give the required amount
		driver.findElement(By.xpath("//th[.='Prefix']/../../tr/td[2]/div/input")).sendKeys("120");
		
		Thread.sleep(5000);
		//Click the plus or add symbol
		driver.findElement(By.cssSelector("i.fa.fa-plus-circle")).click();

		//Click the close button of Additional modifier group
		driver.findElement(By.xpath("//p[.='Select included modifiers.']/../../div[2]/div/div/a/i")).click();
		
		Thread.sleep(1000);
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();

		Thread.sleep(5000);
		//Click the plus or add symbol
		driver.findElement(By.cssSelector("i.fa.fa-plus-circle")).click();
		
		for(int i = 1; i <= 6; i++)
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		Thread.sleep(1000);
		//Click the another one modifier group
		driver.findElement(By.xpath("//select[@name='modGroup']/../../../../../../div[2]/div/div[2]/div/div[1]/div/a")).click();
		//Enter the required modifier group name
		driver.findElement(By.xpath("//select[@name='modGroup']/../../../../../../div[2]/div/div[2]/div/div[1]/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//select[@name='modGroup']/../../../../../../div[2]/div/div[2]/div/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the modifier option
		driver.findElement(By.xpath("//select[@name='modGroup']/../../../../../../div[2]/div/div[2]/div/div[2]/div/a")).click();
		//Enter the required modifier name
		driver.findElement(By.xpath("//select[@name='modGroup']/../../../../../../div[2]/div/div[2]/div/div[2]/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//select[@name='modGroup']/../../../../../../div[2]/div/div[2]/div/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2500);
		//Press the Previous button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-left")).click();
		
		Thread.sleep(3000);
		//Click the Next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(3000);
		//Click the Next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		//Click the add Optional Modifier option
		driver.findElement(By.xpath("//a[contains(.,'Optional Modifier')]/i")).click();
		
		Thread.sleep(2500);
		//Click the modifier group option
		driver.findElement(By.xpath("//select[@name='modGroup']/../div/a")).click();
		//Enter the required modifier group option
		driver.findElement(By.xpath("//select[@name='modGroup']/../div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//select[@name='modGroup']/../div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//select[@name='modGroup']/../div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//select[@name='modGroup']/../div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Check weather the Override price check box is enabled or not
		if(driver.findElement(By.xpath("//label[.='Override Price']/../div/input")).isEnabled())
		{
		//Click the Override price option
		driver.findElement(By.xpath("//label[.='Override Price']/../div/input")).click();
		}

		//Clear the Display Order option
		driver.findElement(By.name("ordinal")).clear();
		//Enter the required number option
		driver.findElement(By.name("ordinal")).sendKeys("3");
		
/*		//Clear the Price option
		driver.findElement(By.xpath("//td/div/input")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//td/div/input")).sendKeys("250");*/
		
		//Click the Set Tiered Price Check box
		driver.findElement(By.xpath("//label[contains(.,'Set Tiered')]/../div/input")).click();
		
		for(int i = 1; i <= 8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(5000);
		//Click the Set Tiered option
		driver.findElement(By.xpath("//a[contains(.,'Set Tiered')]/i")).click();Thread.sleep(2500);
		
		for(int i = 1; i <= 5; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(5000);
		//Click the Serving Size Level Option
		driver.findElement(By.xpath("//label[.='Serving Level']/../div/div/a")).click();
		//Enter the required serving size level
		driver.findElement(By.xpath("//label[.='Serving Level']/../div/div/div/div/input")).click();
		//Press the Enter button
		driver.findElement(By.xpath("//label[.='Serving Level']/../div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Add Tiered price option
		driver.findElement(By.xpath("//a[contains(.,'Add tiered price')]")).click();
		
		//Clear the Quantity option
		driver.findElement(By.xpath("//ng-form[@name='tieredQtyForm']/div/input")).clear();
		//Give the required quantity
		driver.findElement(By.xpath("//ng-form[@name='tieredQtyForm']/div/input")).sendKeys("1");
		
		Thread.sleep(2500);
		//Select the required option to set the price
		Select setPrice = new Select(driver.findElement(By.xpath("//select[@name='setPriceFor']")));
		setPrice.selectByVisibleText("Each");
		
		//Clear the price option
		driver.findElement(By.xpath("//ng-form/div/input[@name='price']")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//ng-form/div/input[@name='price']")).sendKeys("350");
		
		Thread.sleep(1000);
		//Click the Add Tiered price option
		driver.findElement(By.xpath("//a[contains(.,'Add tiered price')]")).click();
		
		//Clear the Quantity option
		driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/ng-form/div/input")).clear();
		//Give the required quantity
		driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/ng-form/div/input")).sendKeys("2");
		
		Thread.sleep(2500);
		//Select the required option to set the price
		Select setPrice1 = new Select(driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]/ng-form/div/select")));
		setPrice1.selectByVisibleText("All");
		
		//Clear the price option
		driver.findElement(By.xpath("//table/tbody/tr[2]/td[4]/ng-form/div/input")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//table/tbody/tr[2]/td[4]/ng-form/div/input")).sendKeys("250");
		
		Thread.sleep(1000);
		//Click the Add Tiered price option
		driver.findElement(By.xpath("//a[contains(.,'Add tiered price')]")).click();

		Thread.sleep(1000);
		//Click the delete option of last added one
		driver.findElement(By.xpath("//table/tbody/tr[3]/td[5]/a/i")).click();
		
		//Click the add Set Tiered Price option
		driver.findElement(By.xpath("//a[contains(.,'Set Tiered')]/i")).click();
		
		Thread.sleep(1000);
		//Click the delete Tiered Price option
		driver.findElement(By.xpath("//span[contains(.,'Add Tiered')]/../a/i")).click();
		
		//Click the add Set Tiered Price option
		driver.findElement(By.xpath("//a[contains(.,'Set Tiered')]/i")).click();

		Thread.sleep(2500);
		//Click the Select Serving Size Level Option
		driver.findElement(By.xpath("//span[contains(.,'Add Tiered')]/../../../../../div/div[3]/div/div/div/div/div/a")).click();
		//Enter the required serving size level
		driver.findElement(By.xpath("//span[contains(.,'Add Tiered')]/../../../../../div/div[3]/div/div/div/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//span[contains(.,'Add Tiered')]/../../../../../div/div[3]/div/div/div/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//span[contains(.,'Add Tiered')]/../../../../../div/div[3]/div/div/div/div/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Click the Add tiered price option
		driver.findElement(By.xpath("//div[@class]/div[3]/div[2]/div/div/table/tbody/tr/td/a[contains(.,'Add tiered price')]")).click();
		
		//Clear the quantity field
		driver.findElement(By.xpath("//div[@class]/div[3]/div[2]/div/div/table/tbody/tr[1]/td[2]/ng-form/div/input")).clear();
		//Enter the quantity
		driver.findElement(By.xpath("//div[@class]/div[3]/div[2]/div/div/table/tbody/tr[1]/td[2]/ng-form/div/input")).sendKeys("4");
		
		Thread.sleep(2500);
		//Select the required option to set the price
		Select setPrice2 = new Select(driver.findElement(By.xpath("//div[@class]/div[3]/div[2]/div/div/table/tbody/tr[1]/td[3]/ng-form/div/select")));
		setPrice2.selectByVisibleText("Each");
		
		//Clear the price field
		driver.findElement(By.xpath("//div[@class]/div[3]/div[2]/div/div/table/tbody/tr[1]/td[4]/ng-form/div/input")).clear();
		//Enter the price
		driver.findElement(By.xpath("//div[@class]/div[3]/div[2]/div/div/table/tbody/tr[1]/td[4]/ng-form/div/input")).sendKeys("212");
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		Thread.sleep(3000);
/*		//Click the Optional modifier option
		driver.findElement(By.xpath("//a[contains(.,'Optional Modifier')]/i")).click();
		
		//Click the Modifier Group Option
		driver.findElement(By.xpath("//ng-form[@name='menuOptionalModifiers']/div[2]/div/div[3]/div/div[1]/div/div/div/a")).click();
		//Enter the required modifier group
		driver.findElement(By.xpath("//ng-form[@name='menuOptionalModifiers']/div[2]/div/div[3]/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//ng-form[@name='menuOptionalModifiers']/div[2]/div/div[3]/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//ng-form[@name='menuOptionalModifiers']/div[2]/div/div[3]/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//ng-form[@name='menuOptionalModifiers']/div[2]/div/div[3]/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuOptionalModifiers']/div[2]/div/div[3]/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Check weather the Override price check box is enabled or not
		if(driver.findElement(By.xpath("//ng-form[@name='menuOptionalModifiers']/div[2]/div/div[3]/div/div[2]/div[1]/div/input")).isEnabled())
		{
			//Click the Override Price
			driver.findElement(By.xpath("//ng-form[@name='menuOptionalModifiers']/div[2]/div/div[3]/div/div[2]/div[1]/div/input")).click();
		}
		
		//Clear the Display order option
		driver.findElement(By.xpath("//ng-form[@name='menuOptionalModifiers']/div[2]/div/div[3]/div/div[2]/div[2]/div/input")).clear();
		//Enter the required number of order
		driver.findElement(By.xpath("//ng-form[@name='menuOptionalModifiers']/div[2]/div/div[3]/div/div[2]/div[2]/div/input")).sendKeys("3");
			
		//Check weather the override price is enabled or not for first option
		if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[2]/input")).isEnabled())
		{
			//Click the override price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[2]/input")).click();
			
			Thread.sleep(3000);
			
			//Clear the price for first option
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[3]/div[1]/input")).clear();
			//Enter the required price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[3]/div[1]/input")).sendKeys("111");
			
			//Clear the price for first option
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[4]/div[1]/input")).clear();
			//Enter the required price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[4]/div[1]/input")).sendKeys("111");

			//Clear the price for first option
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[5]/div[1]/input")).clear();
			//Enter the required price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[5]/div[1]/input")).sendKeys("111");

			//Clear the price for first option
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[6]/div[1]/input")).clear();
			//Enter the required price
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[6]/div[1]/input")).sendKeys("111");

			
		}*/
		
		Thread.sleep(2500);
		//Press the Previous button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-left")).click();
		
		Thread.sleep(3000);
		//Click the Next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(3000);
		//Click the Next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		//Click the Add Mandatory Modifier option
		driver.findElement(By.xpath("//a[contains(.,'Mandatory')]/i")).click();
		
		//Click the Modifier Group option
		driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div/div[1]/div[1]/div/div/a")).click();
		//Enter the required modifier
		driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter key
		driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);	
		
		//Check weather the Override price is enabled or not
		if(driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/input")).isEnabled())
		{
			Thread.sleep(1000);
			//Click the Override price option
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/input")).click();
			
			Thread.sleep(2500);
			//Clear the Price Option
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]/div[1]/input")).clear();
			//Enter the price
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]/div[1]/input")).sendKeys("150");
			
			//Click the Set Tiered price Check box
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[3]/div/div/div/input")).click();
			
			//Click the Add Set Tiered price
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/ul/li/a")).click();
			
			Thread.sleep(1000);
			//Click the Serving Size Level field
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[1]/div[1]/div/div[1]/div/a")).click();
			//Enter the required SErving Size Level
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
			//Press the Enter button
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Add tiered price option
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr/td/a")).click();
			
			//Clear the Quantity field
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[2]/ng-form/div/input")).clear();
			//Enter the Quantity field
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[2]/ng-form/div/input")).sendKeys("2");
			
			Thread.sleep(1000);
			//Select the required Price option
			Select setPrice3 = new Select(driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[3]/ng-form/div/select")));
			setPrice3.selectByVisibleText("Each");
			
			//Clear the price field
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[4]/ng-form/div/input")).clear();
			//Enter the required price
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[4]/ng-form/div/input")).sendKeys("215");
			
			Thread.sleep(1000);
			//Click the Add tiered price option
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td/a")).click();
			
			//Clear the Quantity field
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td[2]/ng-form/div/input")).clear();
			//Enter the Quantity field
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td[2]/ng-form/div/input")).sendKeys("3");
			
			Thread.sleep(1000);
			//Select the required Price option
			Select setPrice4 = new Select(driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td[3]/ng-form/div/select")));
			setPrice4.selectByVisibleText("All");
			
			//Clear the price field
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td[4]/ng-form/div/input")).clear();
			//Enter the required price
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td[4]/ng-form/div/input")).sendKeys("115");
			
			//Click the Add Tiered Price
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[3]/td/a")).click();
			
			Thread.sleep(3000);
			//Click the close or delete button of last added tiered price option
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/div/table/tbody/tr[3]/td/a")).click();
			
			//Add the another one Set Tiered Price Option
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/ul/li[2]/a/uib-tab-heading/a")).click();
			
			Thread.sleep(1000);
			//Click the Select Serving Size Level Option
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[1]/div[1]/div/div[1]/div/a")).click();
			//Enter the required Serving Size Level
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
			//Press the Enter button
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Add tiered price option
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr/td/a")).click();
			
			//Clear the Quantity field
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]/td[2]/ng-form/div/input")).clear();
			//Enter the required quantity
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]/td[2]/ng-form/div/input")).sendKeys("3");
			
			Select setPrice5 = new Select(driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]/td[3]/ng-form/div/select")));
			setPrice5.selectByVisibleText("Each");
			
			//Clear the Price field
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]/td[4]/ng-form/div/input")).clear();
			//Enter the Price
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]/td[4]/ng-form/div/input")).sendKeys("145");
			
			Thread.sleep(3000);
			//Click the Add Set tiered Price option
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/ul/li[3]/a/uib-tab-heading/a")).click();
			
			Thread.sleep(3000);
			//Delete the last added Set tiered price option
			driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/div/div[2]/div[4]/div/ul/li[3]/a/uib-tab-heading/a")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(2500);

		}
		
		//Clear the minimum Quantity field
		driver.findElement(By.name("minQuantity")).clear();
		//Enter the minimum Quantity
		driver.findElement(By.name("minQuantity")).sendKeys("5");
		
		//Clear the maximum Quantity field
		driver.findElement(By.name("maxQuantity")).clear();
		//Enter the maximum Quantity
		driver.findElement(By.name("maxQuantity")).sendKeys("6");
		
		//Clear the Display order field
		driver.findElement(By.name("ordinal")).clear();
		//Enter the Display order
		driver.findElement(By.name("ordinal")).sendKeys("2");
		
		for(int i = 1;i <= 3;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.END);}
		Thread.sleep(3500);
		//Click the Set Tiered price Check box
		driver.findElement(By.xpath("//label[contains(.,'Set Tiered Price')]/../div/input")).click();
		
		//Click the Add Set Tiered price
		driver.findElement(By.xpath("//a[contains(.,'Set Tiered Price')]/../a/i")).click();
		
		Thread.sleep(1000);
		//Click the Serving Size Level field
		driver.findElement(By.xpath("//ul/../div/div[2]/div/div/div/div/div/a/span[.='Select serving Level']")).click();
		//Enter the required SErving Size Level
		driver.findElement(By.xpath("//ul/../div/div[2]/div/div/div/div/div/a/span[.='Select serving Level']/../../div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//ul/../div/div[2]/div/div/div/div/div/a/span[.='Select serving Level']/../../div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Add tiered price option
		driver.findElement(By.xpath("//a[contains(.,'Add tiered price')]")).click();
		
		//Clear the Quantity field
		driver.findElement(By.xpath("//a[contains(.,'Add tiered price')]/../../../tr[1]/td[2]/ng-form/div/input")).clear();
		//Enter the Quantity field
		driver.findElement(By.xpath("//a[contains(.,'Add tiered price')]/../../../tr[1]/td[2]/ng-form/div/input")).sendKeys("2");
		
		Thread.sleep(1000);
		//Select the required Price option
		Select setPrice3 = new Select(driver.findElement(By.xpath("//a[contains(.,'Add tiered price')]/../../../tr[1]/td[3]/ng-form/div/select")));
		setPrice3.selectByVisibleText("Each");
		
		//Clear the price field
		driver.findElement(By.xpath("//a[contains(.,'Add tiered price')]/../../../tr[1]/td[4]/ng-form/div/input")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//a[contains(.,'Add tiered price')]/../../../tr[1]/td[4]/ng-form/div/input")).sendKeys("215");
		
		
		//Click the Add Tiered Price
		driver.findElement(By.xpath("//a[contains(.,'Add tiered price')]")).click();
		
		Thread.sleep(3000);
		//Click the close or delete button of last added tiered price option
		driver.findElement(By.xpath("//a[contains(.,'Add tiered price')]/../../../tr[2]/td/a")).click();
		
		
		Thread.sleep(3000);
		//Click the Add Set tiered Price option
		driver.findElement(By.xpath("//a[contains(.,'Set Tiered Price')]/../a/i")).click();
		
		Thread.sleep(3000);
		//Delete the last added Set tiered price option
		driver.findElement(By.xpath("//span[contains(.,'Add Tiered')]/../a/i")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2500);


		//Click the add mandatory modifier field
		driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/ul/li[2]/a/uib-tab-heading/a")).click();
		
		Thread.sleep(2500);
		//Delete the last added mandatory modifier field
		driver.findElement(By.xpath("//ng-form[@name='menuMandatoryModifiers']/div[2]/ul/li[2]/a/uib-tab-heading/a")).click();

		Thread.sleep(2500);
		//Press the Previous button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-left")).click();
		
		Thread.sleep(3000);
		//Click the Next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4501);
		String s1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText();System.out.println(s1);
		//Check whether the new form loaded or not
		if(s1.equalsIgnoreCase("Menu item saved successfully"))
		{
			test.log(LogStatus.PASS, "New Menu Item is saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item is saved Failed");
		}
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("ProductsItems_Name"));
		driver.findElement(By.xpath("//label[contains(.,'Search')]/../a/span")).click();
		
		String menuItemName = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]")).getText();
		String tempStr = Utility.getProperty("ProductsItems_Name")+" (EBT)";
		Thread.sleep(3000);
		if(menuItemName.equalsIgnoreCase(tempStr) )
		{
			test.log(LogStatus.PASS, "EBT is added successfully after the required menu item name");
		}
		else
		{
			test.log(LogStatus.FAIL, "EBT is added fail after the required menu item name");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=5)
	public void Product_And_Item_method_editMenuItem(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("ProductsItems_Name"));
		driver.findElement(By.xpath("//label[contains(.,'Search')]/../a/span")).click();
		
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
	
		Thread.sleep(3000);
		//Clear the Name field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).clear();
		//Enter the Name			 
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"1");
				
		Thread.sleep(2500);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(3000);
		
		//Clear the PLU CODE
		driver.findElement(By.name("pluCode")).clear();
		//Enter the required PLU CODE
		driver.findElement(By.name("pluCode")).sendKeys(Utility.getProperty("ProductsItems_PLU_Code")+"1");
		
		//Click the Category Option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div/div[1]/div/a")).click();
		//Enter the required Category
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div/div[1]/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Cut and Modify option
		driver.findElement(By.xpath("//label/span[contains(.,'Cut And Modify')]")).click();
		
		Select measureType =  new Select(driver.findElement(By.name("measureType")));
		measureType.selectByVisibleText("Menu Item");
		
		Thread.sleep(2500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		//Click the Serving size Level on the price field
		driver.findElement(By.xpath("//ng-form[@name='menuSizeForm']/div/div/a")).click();
		//Enter the required serving size level
		driver.findElement(By.xpath("//ng-form[@name='menuSizeForm']/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuSizeForm']/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Clear the Price option
		driver.findElement(By.name("price")).clear();
		//Enter the required price
		driver.findElement(By.name("price")).sendKeys("250");
		
		Thread.sleep(3000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		//Enable or disable the Kitchen Printer
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div[2]/label/span")).click();
		Thread.sleep(1000);
		//Enable or disable the Label Printer
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div[3]/label/span")).click();
		Thread.sleep(1000);
		//Enable or disable the Restrict printer
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[1]/div[4]/label/span")).click();
		

		Thread.sleep(2500);
		//Check whether the EBT menu item is enabled or not
		if(driver.findElement(By.xpath("//ng-form/div[2]/div[7]/div/input")).isSelected())
		{
			test.log(LogStatus.PASS, "EBT menu item is in enabled status");
		}

		else
		{
			test.log(LogStatus.FAIL, "EBT menu item is in disabled status");
		}
		
		Thread.sleep(3000);driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		//Click the Select image from gallery option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[9]/div/div/div[2]/div[2]/a[1]/i")).click();
		
		Thread.sleep(15000);
		//Click the required image from the Gallery
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/form/div[2]/div/div/div[2]/div[1]/a/img")).click();
		Thread.sleep(3000);
		
		Thread.sleep(2500);
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/div/div/input")).sendKeys("Days of Week");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Days of Week Option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[11]/div/div/ul")).click();
		//Enter the required DAY for Searching
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[11]/div/div/ul/li/input")).sendKeys("WEDNESDAY");
		//Press the Enter key after enter the keyword
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[11]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Enable or disable the Restriction Time Period option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[12]/div/label/span")).click();
		Thread.sleep(2500);
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[13]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2500);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[13]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2500);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[13]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}

		
		//Click the update
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Menu item updated successfully"))
		{
			test.log(LogStatus.PASS, "New Menu Item is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item is updated Failed");
		}
		Thread.sleep(3000);

		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("ProductsItems_Name")+"1");
		driver.findElement(By.xpath("//label[contains(.,'Search')]/../a/span")).click();
		
		String menuItemName = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]")).getText();
		String tempSTR = Utility.getProperty("ProductsItems_Name")+"1 (EBT)";
		Thread.sleep(3000);
		if(menuItemName.equalsIgnoreCase(tempSTR))
		{
			test.log(LogStatus.PASS, "EBT is added successfully after the required menu item name");
		}
		else
		{
			test.log(LogStatus.FAIL, "EBT is added fail after the required menu item name");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=6)
	public void Product_And_Item_method_deleteMenuItem(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("ProductsItems_Name")+"1");
		driver.findElement(By.xpath("//label[contains(.,'Search')]/../a/span")).click();
		
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		//Check the menu item deleted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Menu item inactivated successfully"))
		{
			test.log(LogStatus.PASS, "New Menu Item is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item is deleted Failed");
		}
		Thread.sleep(3000);
		
		//Click the Active Button
		driver.findElement(By.xpath("//input[@ng-model='activeStatus']")).click();
		Thread.sleep(6000);
		
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the menu item activated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Menu item activated successfully"))
		{
			test.log(LogStatus.PASS, "Menu Item is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Item is activated Failed");
		}
		
		Thread.sleep(5000);
		//Click the Active Button
		driver.findElement(By.xpath("//input[@ng-model='activeStatus']")).click();
		Thread.sleep(3000);
	}
		
	@Test(priority=7)
	public void Product_And_Item_method_addMenuItemByCopyMenuItem(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(8000);
		//Click on the Add Menu Item option
		driver.findElement(By.id("menuItem")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW MENU ITEM']")).getText().equalsIgnoreCase("NEW MENU ITEM"))
		{
			test.log(LogStatus.PASS, "New Menu Items form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Items form loaded Failed");
		}
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		//Click the Menu Item field
		driver.findElement(By.xpath("//label[contains(.,'Menu Items')]/../div/a")).click();Thread.sleep(3000);
		//Enter the REquired menu Item
		driver.findElement(By.xpath("//label[contains(.,'Menu Items')]/../div/div/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"1");
		//Press the Enter Key
		driver.findElement(By.xpath("//label[contains(.,'Menu Items')]/../div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2500);
		
		//Press the Copy button
		driver.findElement(By.xpath("//a[contains(.,'Copy')]")).click();
		
		Thread.sleep(2500);
		//Click the Clear Option  
		driver.findElement(By.xpath("//a[contains(.,'Clear')]")).click();
		
		//Click the Menu Item field
		driver.findElement(By.xpath("//label[contains(.,'Menu Items')]/../div/a")).click();
		//Enter the REquired menu Item
		driver.findElement(By.xpath("//label[contains(.,'Menu Items')]/../div/div/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"1");
		//Press the Enter Key
		driver.findElement(By.xpath("//label[contains(.,'Menu Items')]/../div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2500);
		
		//Press the Copy button
		driver.findElement(By.xpath("//a[contains(.,'Copy')]")).click();
	
		//Clear the Name field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"10");
		
		Thread.sleep(2500);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		Thread.sleep(3000);
		//Clear the PLU CODE
		driver.findElement(By.name("pluCode")).clear();
		//Enter the required PLU CODE
		driver.findElement(By.name("pluCode")).sendKeys(Utility.getProperty("ProductsItems_PLU_Code")+"2");
		
		Thread.sleep(3000);
		//Select the required Level Option
		Select level = new Select(driver.findElement(By.name("level")));
		level.selectByVisibleText("Sub Category");
		
		Thread.sleep(2500);
		//Click the Category Field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[8]/div/div/a")).click();
		//Enter the required category
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[8]/div[1]/div/div/div/input")).click();
		//Press the Enter key
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[8]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);	
		Thread.sleep(2500);
		
		//Click the add sub category button
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[9]/div[2]/a/i")).click();
		
		Thread.sleep(3000);
		//Check weather the new Sub Category form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[1]/h3")).getText().equalsIgnoreCase("New sub-category"))
		{
			test.log(LogStatus.PASS, "New Sub Category form loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Sub Category form loaded Failed");
		}
		
		Thread.sleep(2500);
		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[1]/div/input")).clear();
		//Enter the new sub Category name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Add_Sub_Category_Name"));

		Thread.sleep(2500);
		//Click the Serving Size Level Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[2]/div/div/ul")).click();
		//Enter the Serving size level
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[2]/div/div/ul/li/input")).click();
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2500);
		//Click the Serving Size Level Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[2]/div/div/ul")).click();
		//Enter the Serving size level
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2500);
		//Click the Serving Size Level Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[2]/div/div/ul")).click();
		//Enter the Serving size level
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2500);
		//Click the Serving Size Level Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[2]/div/div/ul")).click();
		//Enter the Serving size level
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
				
		Thread.sleep(2500);
		//Click the Taxes option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div[1]/div/ul")).click();
		//Enter the required tax
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div[1]/div/ul/li/input")).click();
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Click the Taxes option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div[1]/div/ul")).click();
		//Enter the required tax
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div[1]/div/ul/li/input")).click();
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[2]/form/div[3]/div[1]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2500);
		//Click the Save button
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-small ng-binding']")).click();
		
		Thread.sleep(8000);
		Select measureType= new Select(driver.findElement(By.name("measureType")));
		measureType.selectByVisibleText("Open Item");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(3000);
		//Click the Serving size Level on the price field
		driver.findElement(By.xpath("//ng-form[@name='menuSizeForm']/div/div/a")).click();
		//Enter the required serving size level
		driver.findElement(By.xpath("//ng-form[@name='menuSizeForm']/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuSizeForm']/div/div/div/div/input")).sendKeys(Keys.ENTER);		Thread.sleep(3000);
		
		//Clear the price field
		driver.findElement(By.xpath("//input[@name='price']")).clear();
		//Enter the required price
		driver.findElement(By.xpath("//input[@name='price']")).sendKeys("120");
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/div/div/input")).sendKeys("Days of Month");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Required Date form the Calendar
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[11]/div/table/tbody/tr[2]/td[7]/button")).click();
		Thread.sleep(2500);
		
		//Enable or Disable the Restriction Months option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[12]/div/label/span")).click();
		
		Thread.sleep(2500);
		//Click the months field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[13]/div/div/ul")).click();
		//Enter the Required month
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[13]/div/div/ul/li/input")).sendKeys("MAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[13]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Restriction Time option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[14]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[15]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2500);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[15]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2500);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[15]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		Thread.sleep(2500);
		
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(3000);

		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4501);
		String s1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText();System.out.println(s1);
		//Check whether the new form loaded or not
		if(s1.equalsIgnoreCase("Menu item saved successfully"))
		{
			test.log(LogStatus.PASS, "New Menu Item is saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item is saved Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=8)
	public void Product_And_Item_method_cancelMenuItemByCopyMenuItem_Basic(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click on the Add Menu Item option
		driver.findElement(By.id("menuItem")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW MENU ITEM']")).getText().equalsIgnoreCase("NEW MENU ITEM"))
		{
			test.log(LogStatus.PASS, "New Menu Items form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Items form loaded Failed");
		}
				
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(3000);
		//Click the Menu Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();Thread.sleep(2500);
		//Enter the REquired menu Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys("COKE");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2500);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
			
		//Clear the Name field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"10");
				
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(3000);
		
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//a[.='Menu items']")).getText().equalsIgnoreCase("Menu items"))
		{
			test.log(LogStatus.PASS, "New Menu Item is cancelled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item is cancelled Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=9)
	public void Product_And_Item_method_cancelMenuItemByCopyMenuItem_Included_Modifiers(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click on the Add Menu Item option
		driver.findElement(By.id("menuItem")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW MENU ITEM']")).getText().equalsIgnoreCase("NEW MENU ITEM"))
		{
			test.log(LogStatus.PASS, "New Menu Items form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Items form loaded Failed");
		}
				
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(3000);
		//Click the Menu Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();Thread.sleep(1000);
		//Enter the REquired menu Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys("COKE");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2500);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
			
		//Clear the Name field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"10");
		
		Thread.sleep(3000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(3000);
		
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//a[.='Menu items']")).getText().equalsIgnoreCase("Menu items"))
		{
			test.log(LogStatus.PASS, "New Menu Item is cancelled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item is cancelled Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=10)
	public void Product_And_Item_method_cancelMenuItemByCopyMenuItem_Optional_Modifier_Groups(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click on the Add Menu Item option
		driver.findElement(By.id("menuItem")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW MENU ITEM']")).getText().equalsIgnoreCase("NEW MENU ITEM"))
		{
			test.log(LogStatus.PASS, "New Menu Items form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Items form loaded Failed");
		}
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(10000);
		//Click the Menu Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();Thread.sleep(2500);
		//Enter the REquired menu Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys("COKE");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2500);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
			
		//Clear the Name field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"10");
		
		Thread.sleep(3000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(3000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(3000);
		
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//a[.='Menu items']")).getText().equalsIgnoreCase("Menu items"))
		{
			test.log(LogStatus.PASS, "New Menu Item is cancelled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item is cancelled Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=11)
	public void Product_And_Item_method_cancelMenuItemByCopyMenuItem_Mandatory_Modifier(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click on the Add Menu Item option
		driver.findElement(By.id("menuItem")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW MENU ITEM']")).getText().equalsIgnoreCase("NEW MENU ITEM"))
		{
			test.log(LogStatus.PASS, "New Menu Items form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Items form loaded Failed");
		}
				
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(3000);
		//Click the Menu Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();Thread.sleep(2500);
		//Enter the REquired menu Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys("COKE");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2500);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
			
		//Clear the Name field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"10");
		
		Thread.sleep(3000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(3000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(3000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(3000);
		
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//a[.='Menu items']")).getText().equalsIgnoreCase("Menu items"))
		{
			test.log(LogStatus.PASS, "New Menu Item is cancelled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item is cancelled Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=12)
	public void Product_And_Item_method_saveMenuItemByCopyMenuItem(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click on the Add Menu Item option
		driver.findElement(By.id("menuItem")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW MENU ITEM']")).getText().equalsIgnoreCase("NEW MENU ITEM"))
		{
			test.log(LogStatus.PASS, "New Menu Items form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Items form loaded Failed");
		}
				
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(3000);
		//Click the Menu Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();Thread.sleep(2500);
		//Enter the REquired menu Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"10");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2500);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
			
		//Clear the Name field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"11");
		
		Thread.sleep(3000);
		//Clear the PLU CODE
		driver.findElement(By.name("pluCode")).clear();
		//Enter the required PLU CODE
		driver.findElement(By.name("pluCode")).sendKeys(Utility.getProperty("ProductsItems_PLU_Code")+"3");
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Clear the From date field
		driver.findElement(By.name("fromDate")).clear();
		//Enter the required from Date
		driver.findElement(By.name("fromDate")).sendKeys("25-May-2030");
		//Clear the To Date field
		driver.findElement(By.name("endDate")).clear();
		//Enter the required To Date
		driver.findElement(By.name("endDate")).sendKeys("28-May-2030");

		//Enable or Disable the Restriction Days Option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[13]/div/label/span")).click();
		
		Thread.sleep(2500);
		//Click the Days of a Week option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[14]/div/div/ul")).click();
		//Enter the Required Date
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[14]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[14]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Enable or Disable the Restriction Time option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[15]/div/label/span")).click();
		for(int i = 1; i <= 6; i++){driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);}
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[16]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2500);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[16]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2500);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[16]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		
		//Click the Cancel button
		driver.findElement(By.xpath("//button[@type='submit']")).click();driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4501);
		String s1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText();System.out.println(s1);
		//Check whether the new form loaded or not
		if(s1.equalsIgnoreCase("Menu item saved successfully"))
		{
			test.log(LogStatus.PASS, "New Menu Item is saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item is saved Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=13)
	public void Product_And_Item_method_saveAndContinueMenuItemByCopyMenuItem(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click on the Add Menu Item option
		driver.findElement(By.id("menuItem")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW MENU ITEM']")).getText().equalsIgnoreCase("NEW MENU ITEM"))
		{
			test.log(LogStatus.PASS, "New Menu Items form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Items form loaded Failed");
		}
			
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(3000);
		//Click the Menu Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();Thread.sleep(2500);
		//Enter the REquired menu Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"11");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2500);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
			
		//Clear the Name field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"12");
				
		Thread.sleep(3000);
		//Clear the PLU CODE
		driver.findElement(By.name("pluCode")).clear();
		//Enter the required PLU CODE
		driver.findElement(By.name("pluCode")).sendKeys(Utility.getProperty("ProductsItems_PLU_Code")+"4");
		
		Thread.sleep(3000);
		//Select the required measure type
		Select measureType = new Select(driver.findElement(By.name("measureType")));
		measureType.selectByVisibleText("SCALE");
		
		Thread.sleep(5000);
		//Click the taregroup option
		driver.findElement(By.xpath("//select[@name='tareGroup']/../div/a")).click();
		//Enter the required Taregroup
		driver.findElement(By.xpath("//select[@name='tareGroup']/../div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//select[@name='tareGroup']/../div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2500);
		//Check weather the Default tare is selected or not
		if (driver.findElement(By.xpath("//select[@name='defaultTare']")).isEnabled()) {
			
			Thread.sleep(2500);
			//Click the Default tare option
			driver.findElement(By.xpath("//select[@name='defaultTare']/../div/a")).click();
			//Enter the required tare
			driver.findElement(By.xpath("//select[@name='defaultTare']/../div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
			//Press the Enter button
			driver.findElement(By.xpath("//select[@name='defaultTare']/../div/div/div/input")).sendKeys(Keys.ENTER);
		}
		
		Thread.sleep(3000);
		//Click the Serving size Level on the price field
		driver.findElement(By.xpath("//ng-form[@name='menuSizeForm']/div/div/a")).click();
		//Enter the required serving size level
		driver.findElement(By.xpath("//ng-form[@name='menuSizeForm']/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//ng-form[@name='menuSizeForm']/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2500);
		
		//Clear the price option
		driver.findElement(By.name("price")).clear();
		//Enter the required price
		driver.findElement(By.name("price")).sendKeys("155");
		
		Thread.sleep(3000);
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/div/div/input")).sendKeys("Specific date");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Clear the Date field
		driver.findElement(By.name("date")).clear();
		//Enter the required date
		driver.findElement(By.name("date")).sendKeys("15-May-2030");
		
		//Enable or Disable the Restriction Time option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[12]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[13]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2500);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[13]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2500);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[13]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		
		//Click the save and continue button
		driver.findElement(By.xpath("//span[.='Save And Continue']")).click();driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4501);
		String s1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText();System.out.println(s1);
		//Check whether the new form loaded or not
		if(s1.equalsIgnoreCase("Menu item saved successfully"))
		{
			test.log(LogStatus.PASS, "New Menu Item is saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item is saved Failed");
		}
		Thread.sleep(10000);
		
		//Click the Menu Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();
		//Enter the REquired menu Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"12");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2500);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
			
		//Clear the Name field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"13");
		
		
		Thread.sleep(2500);
		//Clear the PLU CODE
		driver.findElement(By.name("pluCode")).clear();
		//Enter the required PLU CODE
		driver.findElement(By.name("pluCode")).sendKeys(Utility.getProperty("ProductsItems_PLU_Code")+"5");
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/div/div/input")).sendKeys("Start date time & end date time");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[10]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Clear the From date field
		driver.findElement(By.name("fromDate")).clear();
		//Enter the required from Date
		driver.findElement(By.name("fromDate")).sendKeys("25-May-2019");
		//Clear the To Date field
		driver.findElement(By.name("endDate")).clear();
		//Enter the required To Date
		driver.findElement(By.name("endDate")).sendKeys("28-May-2019");
		
		//Enable or Disable the Restriction Days Option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[13]/div/label/span")).click();
		
		Thread.sleep(2500);
		//Click the Days of a Week option
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[14]/div/div/ul")).click();
		//Enter the Required Date
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[14]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[14]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[15]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2500);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[15]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2500);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[2]/div[15]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}

		Thread.sleep(3000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(8000);
		//Click the Save And Continue button
		driver.findElement(By.xpath("//span[.='Save And Continue']")).click();driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4501);
		String s2 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText();System.out.println(s2);
		//Check whether the new form loaded or not
		if(s2.equalsIgnoreCase("Menu item saved successfully"))
		{
			test.log(LogStatus.PASS, "New Menu Item is saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item is saved Failed");
		}
		Thread.sleep(10000);
		
		//Click the Menu Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();
		//Enter the REquired menu Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"13");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2500);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
			
		//Clear the Name field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"14");
				
		Thread.sleep(3000);
		//Clear the PLU CODE
		driver.findElement(By.name("pluCode")).clear();
		//Enter the required PLU CODE
		driver.findElement(By.name("pluCode")).sendKeys(Utility.getProperty("ProductsItems_PLU_Code")+"6");
		
		Thread.sleep(5000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(5000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(8000);
		//Click the Save And Continue button
		driver.findElement(By.xpath("//span[.='Save And Continue']")).click();driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4501);
		String s3 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText();System.out.println(s3);
		//Check whether the new form loaded or not
		if(s3.equalsIgnoreCase("Menu item saved successfully"))
		{
			test.log(LogStatus.PASS, "New Menu Item is saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item is saved Failed");
		}
		Thread.sleep(10000);
		
		//Click the Menu Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();
		//Enter the REquired menu Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"14");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2500);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
			
		//Clear the Name field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"15");
			
		Thread.sleep(3000);
		//Clear the PLU CODE
		driver.findElement(By.name("pluCode")).clear();
		//Enter the required PLU CODE
		driver.findElement(By.name("pluCode")).sendKeys(Utility.getProperty("ProductsItems_PLU_Code")+"7");
		
		Thread.sleep(3000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(3000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(3000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(8000);
		//Click the Save And Continue button
		driver.findElement(By.xpath("//span[.='Save And Continue']")).click();driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4501);
		String s4 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText();System.out.println(s4);
		//Check whether the new form loaded or not
		if(s4.equalsIgnoreCase("Menu item saved successfully"))
		{
			test.log(LogStatus.PASS, "New Menu Item is saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item is saved Failed");
		}
		Thread.sleep(10000);

		//Click the Menu Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/a")).click();
		//Enter the REquired menu Item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"15");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2500);
		
		//Press the Copy button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/span/div/a")).click();
			
		//Clear the Name field
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//ng-form[@name='menuBasicInfo']/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("ProductsItems_Name")+"16");
				
		Thread.sleep(2500);
		//Clear the PLU CODE
		driver.findElement(By.name("pluCode")).clear();
		//Enter the required PLU CODE
		driver.findElement(By.name("pluCode")).sendKeys(Utility.getProperty("ProductsItems_PLU_Code")+"8");
		
		Thread.sleep(3000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
				
		Thread.sleep(3000);
		//Click the next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(8000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4501);
		String s5 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText();System.out.println(s5);
		//Check whether the new form loaded or not
		if(s5.equalsIgnoreCase("Menu item saved successfully"))
		{
			test.log(LogStatus.PASS, "New Menu Item is saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item is saved Failed");
		}
		Thread.sleep(10000);
		
	}
			
	@Test(priority=14)
	public void Bulk_Update_open_Bulk_Update(WebDriver driver) throws Exception
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
		Thread.sleep(3000);
		
		//Click the Bulk Update
		driver.findElement(By.xpath("//span[.=' Bulk Update ']")).click();*/
		
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"bulkMenuUpdate");
		
		Thread.sleep(5000);
		//Check Bulk Update page opened or not
		if(driver.findElement(By.xpath("//span[.='Bulk Menu Update']")).getText().equalsIgnoreCase("Bulk Menu Update"))
		{
			test.log(LogStatus.PASS, "Bulk Update page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Bulk Update page loaded Failed");
		}
	}
	
	@Test(priority=15)
	public void Bulk_Update_refresh_Bulk_Update_Page(WebDriver driver) throws InterruptedException
	{
		for(int i = 1; i <= 10; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/a")).click();
		Thread.sleep(5000);
		//Check Bulk Update page opened or not
		if(driver.findElement(By.xpath("//span[.='Bulk Menu Update']")).getText().equalsIgnoreCase("Bulk Menu Update"))
		{
			test.log(LogStatus.PASS, "Bulk Update page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Bulk Update page refreshed Failed");
		}
	}
	
	@Test(priority=16)
	public void Bulk_Update_pagination(WebDriver driver) throws InterruptedException
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
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div/div/ul[1]/li[2]/a/span")).click();Thread.sleep(3000);
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Bulk Update");
		//Create the web element for menu item Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table"));
		for (WebElement result : results){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Bulk Update, when we click 10");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div/div/ul[1]/li[3]/a/span")).click();Thread.sleep(3000);
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Bulk Update");
		//Create the web element for menu item Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Bulk Update, when we click 15");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div/div/ul[1]/li[4]/a/span")).click();Thread.sleep(3000);
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for Bulk Update");
		//Create the web element for menu item Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Bulk Update, when we click 20");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div/div/ul[1]/li[1]/a/span")).click();Thread.sleep(3000);
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Bulk Update");
		//Create the web element for menu item Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Bulk Update, when we click 5");
		}
		
		 Thread.sleep(3000);
		  
	}
	
	@Test(priority=17)
	public void Bulk_Update_edit_menu_Item_Price_SingleServing_Size(WebDriver driver) throws Exception
	{
		for(int i = 0; i <= 20; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		//Click the pagination option as 20
		driver.findElement(By.xpath("//a/span[.='20']")).click();
		Thread.sleep(3000);
		for(int i = 1; i <= 20; i++)
		{
			List<WebElement> inp = driver.findElements(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[4]/div/input"));
			if(inp.size() == 1)
			{
				//Get the Menu Item name from Bulk update page
				String mname = driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[1]")).getText();

				//Click the Price field of 3rd Row
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[4]/div/input")).click();
				//Get the Price of the Menu item, and store it into WebElement 
				WebElement amt = driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[4]/div[1]/input"));
				//Store the value of menu item as string
				String amtVal = amt.getAttribute("value");
				//Change the value of menu item from sting to double
				double changingAmt = Double.parseDouble(amtVal);
				//Add 1 to the menu item price
				changingAmt = changingAmt + 1;changingAmt = Math.round(changingAmt * 100D) / 100D;
				String change = new DecimalFormat("0.00").format(changingAmt);	
				
				//Clear the amount
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[4]/div[1]/input")).clear();
				
				//Enter the new amount
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[4]/div[1]/input")).sendKeys(change);
				Thread.sleep(10000);
				
				//Click the Update Menu Items Button
				driver.findElement(By.xpath("//span[.='Update Menu Items']")).click();
				Thread.sleep(3000);
				
				//Check whether the menu item price is increase or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Updated successfully"))
				{
					test.log(LogStatus.PASS, "Menu Item Price Update Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Menu Item Price Update Fail");
				}
				Thread.sleep(3000);//span[contains(.,'Menu Item')]
				//Click the Menu Item tab Option
				driver.findElement(By.xpath("//ul/li/a/uib-tab-heading/span[contains(.,'Menu Item')]")).click();
				Thread.sleep(25000);
				
				//Clear the Search field
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
				//Enter the required menuitem
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(mname);
				//Click the Search Button
				driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
				Thread.sleep(10000);
				
				//Replace all commo's with empty space
				String expected1 = amtVal;
				
				//Convert the String value of the Sale_Report_Net_Sale element into double value
				double expect1 = Double.parseDouble(expected1); expect1 = expect1+1;
				
				String actual = driver.findElement(By.xpath("//span[@class='badge badge-success ng-binding']")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
				
				double actual1 = Double.parseDouble(actual);
				
				System.out.println("AMT in BULK UPDATE : "+changingAmt);
				
				System.out.println("AMT in MENU ITEM : "+actual1);
				
				if(changingAmt == actual1)
				{
					test.log(LogStatus.PASS, "Updated value, reflected in menu item Correctly, Current Price is : "+actual1);
				}
				else
				{
					double diff = expect1 - actual1;
					test.log(LogStatus.FAIL, "Updated value, reflected in menu item Wrongly, Difference is : "+diff);
				}
				break;
			}
		}
			
	}
	
	@Test(priority=18)
	public void Bulk_Update_edit_menu_Item_Price_MultipleServing_Size(WebDriver driver) throws Exception
	{
		Thread.sleep(1000);
		//Click the Bulk Update
		driver.findElement(By.xpath("//span[contains(.,'Bulk Update')]")).click();
		Thread.sleep(3000);
		for(int i = 0; i <= 10; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		//Click the pagination option as 20
		driver.findElement(By.xpath("//a/span[.='20']")).click();
		Thread.sleep(3000);
		for(int i = 1; i <= 20; i++)
		{
			//Get the Menu Item name from Bulk update page
			String mname = driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[1]")).getText();

			List<WebElement> inp = driver.findElements(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[4]/div/input"));
			if(inp.size() > 1)
			{
				// FOR FIRST SERVING SIZE LEVEL
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[4]/div[1]/input")).click();
				//Clear the amount
				WebElement amt1 = driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[4]/div[1]/input"));
				String amtVal1 = amt1.getAttribute("value");
				double changingAmt1 = Double.parseDouble(amtVal1);
				changingAmt1 = changingAmt1 + 1;changingAmt1 = Math.round(changingAmt1 * 100D) / 100D;
				String change = new DecimalFormat("0.00").format(changingAmt1);
				
				//Enter the amount
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[4]/div[1]/input")).clear();
				
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[4]/div[1]/input")).sendKeys(change);
				Thread.sleep(10000);
				
				// FOR SECOND SERVING SIZE LEVEL
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[4]/div[2]/input")).click();
				//Clear the amount
				WebElement amt2 = driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[4]/div[2]/input"));
				String amtVal2 = amt2.getAttribute("value");
				double changingAmt2 = Double.parseDouble(amtVal2);
				changingAmt2 = changingAmt2 + 1;changingAmt2 = Math.round(changingAmt2 * 100D) / 100D;
				String change1 = new DecimalFormat("0.00").format(changingAmt2);
				
				//Enter the amount
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[4]/div[2]/input")).clear();
				
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[4]/div[2]/input")).sendKeys(change1);
				Thread.sleep(10000);driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);Thread.sleep(3000);
				
				//Click the Update Menu Items Button
				driver.findElement(By.xpath("//span[.='Update Menu Items']")).click();
				Thread.sleep(3000);
				
				//Check whether the menu item price is increase or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Updated successfully"))
				{
					test.log(LogStatus.PASS, "Menu Item Price Update Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Menu Item Price Update Fail");
				}
				Thread.sleep(3000);//span[contains(.,'Menu Item')]
				//Click the Menu Item tab Option
				driver.findElement(By.xpath("//ul/li/a/uib-tab-heading/span[contains(.,'Menu Item')]")).click();
				Thread.sleep(25000);
				
				//Clear the Search field
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
				//Enter the required menuitem
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(mname);
				//Click the Search Button
				driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
				Thread.sleep(10000);
				
				//Replace all commo's with empty space
				String expected12 = amtVal1;
				
				//Convert the String value of the Sale_Report_Net_Sale element into double value
				double expect12 = Double.parseDouble(expected12); expect12 = expect12 + 1;
				
				String actual2 = driver.findElement(By.xpath("//div[@class='ng-binding ng-scope'][1]/div/span")).getText().replaceAll("[a-zA-Z $ â‚¹ , :]", "");
				
				double actual12 = Double.parseDouble(actual2);
				
				if(expect12 == actual12)
				{
					test.log(LogStatus.PASS, "Updated value, reflected in menu item Correctly for 1st Serving Size Level, Current Price is : "+actual12);
				}
				else
				{
					double diff = expect12 - actual12;
					test.log(LogStatus.FAIL, "Updated value, reflected in menu item Wrongly for 1st Serving Size Level, Difference is : "+diff);
				}
			
			
				//Replace all commo's with empty space
				String expected13 = amtVal2;
				
				//Convert the String value of the Sale_Report_Net_Sale element into double value
				double expect13 = Double.parseDouble(expected13);  expect13 = expect13 + 1 ;
				
				String actual3 = driver.findElement(By.xpath("//div[@class='ng-binding ng-scope'][2]/div/span")).getText().replaceAll("[a-zA-Z $ â‚¹ , :]", "");
				
				double actual13 = Double.parseDouble(actual3);
				
				if(expect13 == actual13)
				{
					test.log(LogStatus.PASS, "Updated value, reflected in menu item Correctly for 2nd Serving Size Level, Current Price is : "+actual13);
				}
				else
				{
					double diff = expect13 - actual13;
					test.log(LogStatus.FAIL, "Updated value, reflected in menu item Wrongly for 2nd Serving Size Level, Difference is : "+diff);
				}
				
				break;
			}
		}

		
	}
	
	@Test(priority=19)
	public void Bulk_Update_edit_menu_Item_Price_Many_SingleServing_Size(WebDriver driver) throws Exception
	{
		Thread.sleep(1000);
		//Click the Bulk Update
		driver.findElement(By.xpath("//span[contains(.,'Bulk Update')]")).click();
		Thread.sleep(3000);
		for(int i = 0; i <= 20; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);


				//Click the Price field of 1st Row
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr[1]/td[4]/div/input")).click();
				//Get the Price of the Menu item, and store it into WebElement 
				WebElement amt = driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr[1]/td[4]/div[1]/input"));
				//Store the value of menu item as string
				String amtVal = amt.getAttribute("value");
				//Change the value of menu item from sting to double
				double changingAmt = Double.parseDouble(amtVal);
				//Add 1 to the menu item price
				changingAmt = changingAmt + 1; changingAmt = Math.round(changingAmt * 100D) / 100D;
				String change = new DecimalFormat("0.00").format(changingAmt);
				
				//Clear the amount
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr[1]/td[4]/div[1]/input")).clear();
				
				//Enter the new amount
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr[1]/td[4]/div[1]/input")).sendKeys(change);
				
				//Click the Price field of 2nd Row
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr[2]/td[4]/div/input")).click();
				//Get the Price of the Menu item, and store it into WebElement 
				WebElement amt2 = driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr[2]/td[4]/div[1]/input"));
				//Store the value of menu item as string
				String amtVal2 = amt2.getAttribute("value");
				//Change the value of menu item from sting to double
				double changingAmt2 = Double.parseDouble(amtVal2);
				//Add 1 to the menu item price
				changingAmt2 = changingAmt2 + 1;changingAmt2 = Math.round(changingAmt2 * 100D) / 100D;
				String change2 = new DecimalFormat("0.00").format(changingAmt2);
				
				//Clear the amount
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr[2]/td[4]/div[1]/input")).clear();
				
				//Enter the new amount
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr[2]/td[4]/div[1]/input")).sendKeys(change2);

				//Click the Price field of 3rd Row
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr[3]/td[4]/div/input")).click();
				//Get the Price of the Menu item, and store it into WebElement 
				WebElement amt3 = driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr[3]/td[4]/div[1]/input"));
				//Store the value of menu item as string
				String amtVal3 = amt3.getAttribute("value");
				//Change the value of menu item from sting to double
				double changingAmt3 = Double.parseDouble(amtVal3);
				//Add 1 to the menu item price
				changingAmt3 = changingAmt3 + 1;changingAmt3 = Math.round(changingAmt3 * 100D) / 100D;
				String change3 = new DecimalFormat("0.00").format(changingAmt3);
				
				//Clear the amount
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr[3]/td[4]/div[1]/input")).clear();
				
				//Enter the new amount
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr[3]/td[4]/div[1]/input")).sendKeys(change3);

				//Click the Price field of 4th Row
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr[4]/td[4]/div/input")).click();
				//Get the Price of the Menu item, and store it into WebElement 
				WebElement amt4 = driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr[4]/td[4]/div[1]/input"));
				//Store the value of menu item as string
				String amtVal4 = amt4.getAttribute("value");
				//Change the value of menu item from sting to double
				double changingAmt4 = Double.parseDouble(amtVal4);
				//Add 1 to the menu item price
				changingAmt4 = changingAmt4 + 1;changingAmt4 = Math.round(changingAmt4 * 100D) / 100D;
				String change4 = new DecimalFormat("0.00").format(changingAmt4);
				
				//Clear the amount
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr[4]/td[4]/div[1]/input")).clear();
				
				//Enter the new amount
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr[4]/td[4]/div[1]/input")).sendKeys(change4);

				//Click the Price field of 3rd Row
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr[5]/td[4]/div/input")).click();
				//Get the Price of the Menu item, and store it into WebElement 
				WebElement amt5 = driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr[5]/td[4]/div[1]/input"));
				//Store the value of menu item as string
				String amtVal5 = amt5.getAttribute("value");
				//Change the value of menu item from sting to double
				double changingAmt5 = Double.parseDouble(amtVal5);
				//Add 1 to the menu item price
				changingAmt5 = changingAmt5 + 1;changingAmt5 = Math.round(changingAmt5 * 100D) / 100D;
				String change5 = new DecimalFormat("0.00").format(changingAmt5);
				
				//Clear the amount
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr[5]/td[4]/div[1]/input")).clear();
				
				//Enter the new amount
				driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr[5]/td[4]/div[1]/input")).sendKeys(change5);
				
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(10000);
				
				//Click the Update Menu Items Button
				driver.findElement(By.xpath("//span[.='Update Menu Items']")).click();
				Thread.sleep(3000);
				
				//Check whether the menu item price is increase or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Updated successfully"))
				{
					test.log(LogStatus.PASS, "Menu Item Price Update Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Menu Item Price Update Fail");
				}
				Thread.sleep(3000);//span[contains(.,'Menu Item')]
				//Click the Menu Item tab Option
				driver.findElement(By.xpath("//ul/li/a/uib-tab-heading/span[contains(.,'Menu Item')]")).click();
				Thread.sleep(25000);

				
				//Replace all commo's with empty space
				String expected1 = amtVal;
				
				//Convert the String value of the Sale_Report_Net_Sale element into double value
				double expect1 = Double.parseDouble(expected1); expect1 = expect1+1;
				
				String actual = driver.findElement(By.xpath("//tr[1]/td/div/div/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
				
				double actual1 = Double.parseDouble(actual);
				
				System.out.println("AMT in BULK UPDATE : "+changingAmt);
				
				System.out.println("AMT in MENU ITEM : "+actual1);
				
				if(changingAmt == actual1)
				{
					test.log(LogStatus.PASS, "Updated value, reflected in menu item Correctly, Current Price is : "+actual1);
				}
				else
				{
					double diff = expect1 - actual1;
					test.log(LogStatus.FAIL, "Updated value, reflected in menu item Wrongly, Difference is : "+diff);
				}
				
				//Replace all commo's with empty space
				String expected2 = amtVal2;
				
				//Convert the String value of the Sale_Report_Net_Sale element into double value
				double expect12 = Double.parseDouble(expected2); expect12 = expect12+1;
				
				String actual2 = driver.findElement(By.xpath("//tr[2]/td/div/div/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
				
				double actual12 = Double.parseDouble(actual2);
				
				System.out.println("AMT in BULK UPDATE : "+changingAmt2);
				
				System.out.println("AMT in MENU ITEM : "+actual12);
				
				if(changingAmt2 == actual12)
				{
					test.log(LogStatus.PASS, "Updated value, reflected in menu item Correctly, Current Price is : "+actual12);
				}
				else
				{
					double diff = expect12 - actual12;
					test.log(LogStatus.FAIL, "Updated value, reflected in menu item Wrongly, Difference is : "+diff);
				}
				
				//Replace all commo's with empty space
				String expected13 = amtVal3;
				
				//Convert the String value of the Sale_Report_Net_Sale element into double value
				double expect13 = Double.parseDouble(expected13); expect13 = expect13+1;
				
				String actual3 = driver.findElement(By.xpath("//tr[3]/td/div/div/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
				
				double actual13 = Double.parseDouble(actual3);
				
				System.out.println("AMT in BULK UPDATE : "+changingAmt3);
				
				System.out.println("AMT in MENU ITEM : "+actual13);
				
				if(changingAmt3 == actual13)
				{
					test.log(LogStatus.PASS, "Updated value, reflected in menu item Correctly, Current Price is : "+actual13);
				}
				else
				{
					double diff = expect13 - actual13;
					test.log(LogStatus.FAIL, "Updated value, reflected in menu item Wrongly, Difference is : "+diff);
				}
				
				//Replace all commo's with empty space
				String expected14 = amtVal4;
				
				//Convert the String value of the Sale_Report_Net_Sale element into double value
				double expect14 = Double.parseDouble(expected14); expect14 = expect14+1;
				
				String actual4 = driver.findElement(By.xpath("//tr[4]/td/div/div/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
				
				double actual14 = Double.parseDouble(actual4);
				
				System.out.println("AMT in BULK UPDATE : "+changingAmt4);
				
				System.out.println("AMT in MENU ITEM : "+actual14);
				
				if(changingAmt4 == actual14)
				{
					test.log(LogStatus.PASS, "Updated value, reflected in menu item Correctly, Current Price is : "+actual14);
				}
				else
				{
					double diff = expect14 - actual14;
					test.log(LogStatus.FAIL, "Updated value, reflected in menu item Wrongly, Difference is : "+diff);
				}
				
				//Replace all commo's with empty space
				String expected15 = amtVal5;
				
				//Convert the String value of the Sale_Report_Net_Sale element into double value
				double expect15 = Double.parseDouble(expected15); expect15 = expect15+1;
				
				String actual5 = driver.findElement(By.xpath("//tr[5]/td/div/div/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
				
				double actual15 = Double.parseDouble(actual5);
				
				System.out.println("AMT in BULK UPDATE : "+changingAmt5);
				
				System.out.println("AMT in MENU ITEM : "+actual15);
				
				if(changingAmt5 == actual15)
				{
					test.log(LogStatus.PASS, "Updated value, reflected in menu item Correctly, Current Price is : "+actual15);
				}
				else
				{
					double diff = expect15 - actual15;
					test.log(LogStatus.FAIL, "Updated value, reflected in menu item Wrongly, Difference is : "+diff);
				}
	
	}

	@Test(priority=21)
	public void Display_Groups_method_openDisplayGroups(WebDriver driver) throws Exception
	{
/*		//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Display Groups']"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Display Groups Option		
		driver.findElement(By.xpath("//span[.='Display Groups']")).click();*/
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"displayGroups");
		Thread.sleep(5000);
		//Check Menu items page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Display Group"))
		{
			test.log(LogStatus.PASS, "Display Group page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Display Group page loaded Failed");
		}

	}
	
	@Test(priority=23)
	public void Display_Groups_method_addDisplayGroup_TimePeriod_AS_Always(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		//Click Add Display Group Icon or button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[1]")).click();
		Thread.sleep(3000);
		//Check the New Display Group form is loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW DISPLAY GROUP']")).getText().equalsIgnoreCase("NEW DISPLAY GROUP"))
		{
			test.log(LogStatus.PASS, "New Display Group form opened Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group form opened Failed");
		}

		//Clear the name field
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).clear();
		//Enter the name
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DisplayGroupName"));
		
		Thread.sleep(15000);
		//Click the MenuItems Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).click();
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the MenuItems Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).click();
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		//Click the MenuItems Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).click();
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		//Click the MenuItems Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).click();
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		//Click the MenuItems Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).click();
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		//Click the MenuItems Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).click();
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		//Click the MenuItems Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).click();
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		//Click the MenuItems Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).click();
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		if(driver.findElement(By.xpath("//select[@name='priceChoosen']")).isEnabled())
		{
			Thread.sleep(20000);
			//Click the Price Level option
			driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[3]/div/div/a")).click();
			//Click the input field
			driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[3]/div/div/div/div/input")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		}
		
		Thread.sleep(1000);
		//Click Any One of the Color for Display button
		driver.findElement(By.xpath("//div[@class='email-template-color color-swatch ng-scope'][5]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("displayGroupImage")).sendKeys(Utility.getProperty("DisplayGroupImage1"));
		
		Thread.sleep(3000);
		//Click the Sort Z-A button
		driver.findElement(By.xpath("//a[.='Sort Z-A']")).click();
		//Create the Log
		test.log(LogStatus.PASS, "Menu items are arranged in descending(Sort Z to A) order");
		
		Thread.sleep(2000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//Check the New Display Group saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("DisplayGroup Saved Successfully"))
		{
			test.log(LogStatus.PASS, "New Display Group added Successfully for Applicable time period as Always");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group added Failed for Applicable time period as Always");
		}

		

	}
	
	@Test(priority=24)
	public void Display_Groups_method_editDisplayGroup(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DisplayGroupName")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(3000);
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).clear();
		//Enter the name
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DisplayGroupName")+"1");
		
		Thread.sleep(2000);
		//Click the MenuItems Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).click();
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		
		Thread.sleep(2000);
		//Click the Close button of required menu item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li[1]/a")).click();
					
		Thread.sleep(2000);
		//Change the Display group icon
		driver.findElement(By.id("displayGroupImage")).sendKeys(Utility.getProperty("DisplayGroupImage"));
		
		Thread.sleep(1000);
		//Click the Sort A-Z button
		driver.findElement(By.xpath("//a[.='Sort A-Z']")).click();
		
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//Check the New Display Group saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("DisplayGroup Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Display Group updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group updated Failed");
		}
		Thread.sleep(5000);
		
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DisplayGroupName")+"1");
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);
		
		//Check weather name changes are updated or not
		if(driver.getPageSource().contains(Utility.getProperty("DisplayGroupName")+"1"))
		{
			test.log(LogStatus.PASS, "Edited name is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Edits name is updated Failed");
		}
		
		Thread.sleep(2000);
		//Check weather the sorting order is correct or not
		if(driver.findElement(By.xpath("//a[@class='btn btn-small btn-inverse active']")).getText().equalsIgnoreCase("Sort A-Z"))
		{
			test.log(LogStatus.PASS, "Edited sorting is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Edits sorting is updated Failed");
		}
		Thread.sleep(5000);
		//Click the display image remove button
		driver.findElement(By.xpath("//i[@class='fa fa-remove']")).click();
		Thread.sleep(5000);
		
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=25)
	public void Display_Groups_method_deleteDisplayGroup(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DisplayGroupName")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Delete button
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		//Switch the control to the alert pouup
		Alert x = driver.switchTo().alert();
		//Capture the alert message									
		String alertMessage = driver.switchTo().alert().getText();
		//Print the alert message
		System.out.println(alertMessage);
		//Accept the alert
		x.accept();
		Thread.sleep(3000);
		//Check the menu item deleted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("DisplayGroup inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "New Display Group deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group deleted Failed");
		}
		Thread.sleep(5000);
		
		
		//Click the Active button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/input")).click();
		
		Thread.sleep(3000);
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		//Switch the control to the alert pouup
		Alert x1 = driver.switchTo().alert();
		//Capture the alert message									
		String alertMessage1= driver.switchTo().alert().getText();
		//Print the alert message
		System.out.println(alertMessage1);
		//Accept the alert
		x1.accept();
		Thread.sleep(4500);
		
		//Check the menu item activated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("DisplayGroup Activated Successfully"))
		{
			test.log(LogStatus.PASS, "New Display Group activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group activated Failed");
		}
		Thread.sleep(5000);
		
		
		//Click the In-Active button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/input")).click();

		Thread.sleep(5000);
	}
	
	@Test(priority=26)
	public void Display_Groups_method_editDisplayGroup_TimePeriod_AS_DaysOfWeek(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DisplayGroupName")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);


		//Clear the name field
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).clear();
		//Enter the name
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DisplayGroupName")+"10");
		Thread.sleep(15000);

		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[4]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[4]/div/div/div/div/input")).sendKeys("Days of Week");
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		//Click the Days of a week Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[5]/div/div/ul")).click();
		//Enter the required Day
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[5]/div/div/ul/li/input")).sendKeys("WEDNESDAY");
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Restriction Time
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[6]/div/label/span")).click();

		Thread.sleep(1000);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[7]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		//Click Any One of the Color
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[8]/div/div/div[2]/div[1]/div[7]")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		//Click the Sort Z-A button
		//driver.findElement(By.xpath("//a[.='Sort Z-A']")).click();
		//Create the Log
		//test.log(LogStatus.PASS, "Menu items are arranged in descending(Sort Z to A) order");
		
		Thread.sleep(3000);
		//Click the Sort A-Z button
		//driver.findElement(By.xpath("//a[.='Sort A-Z']")).click();
		//Create the Log
		//test.log(LogStatus.PASS, "Menu items are arranged in ascending(Sort A to Z) order");
		
		//Thread.sleep(3000);
		//Click the Custom Sort
		//driver.findElement(By.xpath("//a[.='Custom sort']")).click();
		// Element which needs to drag.
		//WebElement From = driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[2]/div/div[2]/div/div/ol/li[3]/div"));
		// Element on which need to drop.
		//WebElement To = driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[2]/div/div[2]/div/div/ol/li[1]/div"));
		// Using Action class for drag and drop.
		//Actions act = new Actions(driver);
		// Dragged and dropped.
		//act.dragAndDrop(From, To).build().perform();
		//Create the Log
		//test.log(LogStatus.PASS, "Menu items are arranged by Custom Sort");

		
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3500);
		//Check the New Display Group saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("DisplayGroup Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Display Group updated Successfully for Applicable time period as Days of Week");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group updated Failed for Applicable time period as Days of Week");
		}

		Thread.sleep(5000);
		
	}
	
	@Test(priority=27)
	public void Display_Groups_method_editDisplayGroup_TimePeriod_AS_DaysOfMonth(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DisplayGroupName")+"101");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);


		//Clear the name field
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).clear();
		//Enter the name
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DisplayGroupName")+"11");
		Thread.sleep(3000);
/*		//Click the MenuItems Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys("COKE");
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
*/
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[4]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[4]/div/div/div/div/input")).sendKeys("Days of Month");
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		//Click the Required Date from the Days of a Month
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[5]/div/table/tbody/tr[2]/td[3]/button")).click();

		Thread.sleep(3000);
		//Enable or Disable Restriction Methods
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[6]/div/label/span")).click();
		//Click the Months OIption
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[7]/div/div/ul")).click();
		//Enter the Required Month
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[7]/div/div/ul/li/input")).sendKeys("MAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[7]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Restriction Time
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[8]/div/label/span")).click();

		Thread.sleep(1000);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[9]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[9]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[9]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}

		
		//Click Any One of the Color
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[10]/div/div/div[2]/div[1]/div[7]")).click();
		
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3500);
		//Check the New Display Group saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("DisplayGroup Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Display Group updated Successfully for Applicable time period as Days of Month");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group updated Failed for Applicable time period as Days of Month");
		}

		Thread.sleep(5000);
		
	}
	
	@Test(priority=28)
	public void Display_Groups_method_editDisplayGroup_TimePeriod_AS_DateRange(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DisplayGroupName")+"111");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);


		//Clear the name field
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).clear();
		//Enter the name
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DisplayGroupName")+"12");
		Thread.sleep(3000);
/*		//Click the MenuItems Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys("COKE");
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
*/
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[4]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[4]/div/div/div/div/input")).sendKeys("Date Range");
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		//Clear the From Date Field
		driver.findElement(By.name("fromDate")).clear();
		//Enter the From Date
		driver.findElement(By.name("fromDate")).sendKeys("16-May-2020");
		//Clear the To Date Field
		driver.findElement(By.name("endDate")).clear();
		//Enter the To Date
		driver.findElement(By.name("endDate")).sendKeys("20-May-2020");
	
	
		Thread.sleep(3000);
		//Enable or Disable Restriction days
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[7]/div/label/span")).click();
		//Click the DAys of a week
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[8]/div/div/ul")).click();
		//Enter the Required Day
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[8]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[8]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Restriction Time
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[9]/div/label/span")).click();

		Thread.sleep(1000);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[10]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		//Click Any One of the Color
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[11]/div/div/div[2]/div[1]/div[7]")).click();
		
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3500);
		//Check the New Display Group saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("DisplayGroup Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Display Group updated Successfully for Applicable time period as Date Range");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group updated Failed for Applicable time period as Date Range");
		}

		Thread.sleep(5000);
		
	}
	
	@Test(priority=29)
	public void Display_Groups_method_editDisplayGroup_TimePeriod_AS_SpecificDate(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DisplayGroupName")+"121");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);


		//Clear the name field
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).clear();
		//Enter the name
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DisplayGroupName")+"13");
		Thread.sleep(3000);
/*		//Click the MenuItems Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys("COKE");
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
*/
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[4]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[4]/div/div/div/div/input")).sendKeys("Specific date");
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		//Clear the Date Field
		driver.findElement(By.name("date")).clear();
		//Enter the Date
		driver.findElement(By.name("date")).sendKeys("16-May-2020");

		//Enable or Disable the Restriction Time
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[6]/div/label/span")).click();

		Thread.sleep(1000);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[7]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		//Click Any One of the Color
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[8]/div/div/div[2]/div[1]/div[7]")).click();
		
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3500);
		//Check the New Display Group saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("DisplayGroup Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Display Group updated Successfully for Applicable time period as Specific Date");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group updated Failed for Applicable time period as Specific Date");
		}

		Thread.sleep(5000);
		
	}
	
	@Test(priority=30)
	public void Display_Groups_method_editDisplayGroup_TimePeriod_AS_StartDateAndEndDateTime(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DisplayGroupName")+"131");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);


		//Clear the name field
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).clear();
		//Enter the name
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DisplayGroupName")+"14");
		Thread.sleep(2000);
/*		//Click the MenuItems Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys("COKE");
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
*/
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[4]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[4]/div/div/div/div/input")).sendKeys("Start date time & end date time");
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		//Clear the From Date Field
		driver.findElement(By.name("fromDate")).clear();
		//Enter the From Date
		driver.findElement(By.name("fromDate")).sendKeys("16-May-2040");
		//Clear the To Date Field
		driver.findElement(By.name("endDate")).clear();
		//Enter the To Date
		driver.findElement(By.name("endDate")).sendKeys("20-May-2040");
		
		//Enable or Disable the Restriction days option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[7]/div/label/span")).click();
		
		//Click the Days of a Week Function
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[8]/div/div/ul")).click();
		//Enter the Required day
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[8]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[8]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[9]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[9]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[9]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		//Click Any One of the Color
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[10]/div/div/div[2]/div[1]/div[7]")).click();
		
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3500);
		//Check the New Display Group saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("DisplayGroup Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Display Group updated Successfully for Applicable time period as Start date time & end date time");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group updated Failed for Applicable time period as Start date time & end date time");
		}

		Thread.sleep(5000);
		
	}
	
	@Test(priority=31)
	public void Display_Groups_method_verifyCancelButton(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Click Add Display Group Icon or button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[1]")).click();
		

		Thread.sleep(5000);
		//Check the New Display Group form is loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW DISPLAY GROUP']")).getText().equalsIgnoreCase("NEW DISPLAY GROUP"))
		{
			test.log(LogStatus.PASS, "New Display Group form opened Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group form opened Failed");
		}
		
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).clear();
		//Enter the name
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DisplayGroupName")+"14");
		
		Thread.sleep(3000);
		//Click the Cancel button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger.ng-binding")).click();
		
		//Check the New Display Group saved or not
		if(driver.findElement(By.xpath("//a[.='Display Groups']")).getText().equalsIgnoreCase("Display Groups"))
		{
			test.log(LogStatus.PASS, "Cancel button working fine");
		}
		else
		{
			test.log(LogStatus.FAIL, "Cancel button not worked");
		}

		Thread.sleep(5000);
		
	}

/*	@Test(priority=22)
	public void Display_Groups_method_pagination(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Pagination option as 10
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div/ul[1]/li[2]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Display Group");
		//Create the web element for Display Group Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]"));
		for (WebElement result : results){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" available for Display Group");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div/ul[1]/li[3]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Display Group");
		//Create the web element for Display Group Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" available for Display Group");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div/ul[1]/li[4]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for Display Group");
		//Create the web element for Display Group Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" available for Display Group");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div/ul[1]/li[1]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Display Group");
		//Create the web element for Display Group Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" available for Display Group");
		}
		Thread.sleep(8000);
	}
*/	
	@Test(priority=33)
	public void Display_Groups_method_addSameName(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		//Click Add Display Group Icon or button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[1]")).click();
		Thread.sleep(3000);


		//Clear the name field
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).clear();
		//Enter the name
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DisplayGroupName")+"14");
		Thread.sleep(15000);
		//Click the MenuItems Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).click();
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Click the MenuItems Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).click();
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Click the MenuItems Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).click();
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Click the MenuItems Option
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).click();
		//Press Enter Key
		driver.findElement(By.xpath("//form[@name='displayGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		//Check the New Display Group saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Error in validation"))
		{
			test.log(LogStatus.PASS, "New Display Group added Fail, User cannot be able to give the same group name");
			Thread.sleep(3000);
			//Find the validation message for the name field
			if(driver.findElement(By.xpath("//p[@class='help-block ng-binding']")).getText().equalsIgnoreCase("Name already exists"))
			{
				test.log(LogStatus.PASS, "Group name is already exist");
			}

			
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group added success, User can be able to give the same group name");
		}

		Thread.sleep(5000);
		
	}
	
	@Test(priority=41)
	public void Item_Based_Discount_method_openDiscountsPage(WebDriver driver) throws Exception
	{
/*		//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Discounts']"));
		//Scroll the page till the Discount option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Discounts Option		
		driver.findElement(By.xpath("//span[.='Discounts']")).click();*/
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"item_based/discount/list");
		
		Thread.sleep(5000);
		//Check items page opened or not
		if(driver.findElement(By.xpath("//span[.='Item Based']")).getText().equalsIgnoreCase("Item Based"))
		{
			test.log(LogStatus.PASS, "Item Based discount page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Based discount page loaded Failed");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=42)
	public void Item_Based_Discount_method_refreshDiscountsPage(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/a/i")).click();
		Thread.sleep(5000);
		//Check Menu items page opened or not
		if(driver.findElement(By.xpath("//span[.='Item Based']")).getText().equalsIgnoreCase("Item Based"))
		{
			test.log(LogStatus.PASS, "Item Based discount page Refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Based discount page Refreshed Failed");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=44)
	public void Item_Based_Discount_method_addDiscount_ItemBased_ApplicableTimePeriodAsDaysOfWeek(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		Thread.sleep(5000);
		//Click on the Add Menu Item option
		driver.findElement(By.id("newDiscount")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/h3")).getText().equalsIgnoreCase("Discounts"))
		{
			test.log(LogStatus.PASS, "New Discounts Item form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Discounts Item form loaded Failed");
		}

		
		//Clear the Name field
		driver.findElement(By.xpath("//input[@name='name']")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		Thread.sleep(5000);
		
		//Click the Coupon Only Option
		driver.findElement(By.xpath("//span[contains(.,'Coupon Only')]")).click();
		Thread.sleep(2000);
		
		//Click the Auto discount option
		driver.findElement(By.xpath("//span[contains(.,'Auto Discount')]")).click();
		Thread.sleep(3000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		
		//Click the Level Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/a")).click();
		//Enter the required Level
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/div/div/input")).sendKeys("Menu item");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Click the Menu Item Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter keys
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);	
		Thread.sleep(2000);
		
		//Check whether the All Serving Size in Menu Item
		if(driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/input")).isSelected())
		{}
		else
		{
			driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/input")).click();
		}
		
		//Clear the minimum Quantity field
		driver.findElement(By.name("minQuantity")).clear();
		//Enter the minimum Quantity
		driver.findElement(By.name("minQuantity")).sendKeys("100");
		
		//Select the required Discount Type
		Select discType = new Select(driver.findElement(By.name("discountCouponType")));
		discType.selectByVisibleText("Promo");
		
		//Click the Discount option
		driver.findElement(By.xpath("//div/button[@aria-haspopup='true']")).click();
		//Click the required option
		driver.findElement(By.xpath("//a[.='amount']"))	.click();
		
		//Clear the Discount Field DropDown Option
		driver.findElement(By.name("offer")).clear();
		//Enter the required amount
		driver.findElement(By.name("offer")).sendKeys("200");

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		
		Thread.sleep(3000);
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Days of Week");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Days if Week Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/div/ul")).click();
		//Enter the required DAY for Searching
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/div/ul/li/input")).sendKeys("WEDNESDAY");
		//Press the Enter key after enter the keyword
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Restriction Time
		driver.findElement(By.xpath("//span[contains(.,'Restriction time')]")).click();
		Thread.sleep(2000);
	
		Thread.sleep(1000);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("Before Tax");

		//Enable or Disable the Include Additional Modifier Option
		//driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div[2]/div/label/span")).click();
		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		
		//Click the Role field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div[4]/div/div/ul")).click();
		//Enter the required role
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div[4]/div/div/ul/li/input")).sendKeys("Driver");
		//Press the Enter buttom
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Clear the Discount name
		driver.findElement(By.name("discountCode")).clear();
		//Enter the Required name
		driver.findElement(By.name("discountCode")).sendKeys(Utility.getProperty("ItemBased_Discount_Code"));
		
		//Enable or Disable the Attach Customer Option
		driver.findElement(By.name("isCustomerAttach")).click();
		
		//Click the required display button
		driver.findElement(By.xpath("//div[@class='email-template-color color-swatch ng-scope'][5]")).click();
		
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Check whether the new discount saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Saved successfully"))
		{
			test.log(LogStatus.PASS, "New Item Based discount saved Successfully for Days of Week");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Item Based discount saved Failed for Days of Week");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=43, enabled = false)
	public void Item_Based_Discount_method_pagination(WebDriver driver) throws InterruptedException
	{
		
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

		
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Pagination option as 10
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[2]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Item Based Discount");
		//Create the web element for Display Group Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]"));
		for (WebElement result : results){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" available(Discount Item Based) When click the Pagination option as 10");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[3]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Item Based Discount");
		//Create the web element for Display Group Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" available(Discount Item Based) When click the Pagination option as 15");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[4]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for Item Based Discount");
		//Create the web element for Display Group Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" available(Discount Item Based) When click the Pagination option as 20");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[1]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Item Based Discount");
		//Create the web element for Display Group Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" available(Discount Item Based) When click the Pagination option as 5");
		}
		Thread.sleep(8000);
	}
	
	@Test(priority=45)
	public void Item_Based_Discount_method_editDiscount_ItemBased(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(5000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(3000);
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"10");

		
		//Click the Level Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/a")).click();
		//Enter the Level Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/div/div/input")).sendKeys("Category");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Click the Category Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);	
		Thread.sleep(2000);
		
		//Click the Category Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		//Enable or Disable the Serving Size Level check box
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/input")).click();
		
		Thread.sleep(3000);
		//Remove the Serving Size level
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[4]/div/div/ul/li[1]/a")).click();
	
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		
		//Click the Discount Option Button
		driver.findElement(By.xpath("//div/button[@aria-haspopup='true']")).click();
		//Choose the Option
		driver.findElement(By.xpath("//a[.='percentage']")).click();
		//Clear the Offer Filed
		driver.findElement(By.name("offer")).clear();
		//Enter the required offer
		driver.findElement(By.name("offer")).sendKeys("1000");
		
		Thread.sleep(2000);
		//Enable or Disable the Include Additional Modifier Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div[2]/div/label/span")).click();

		Thread.sleep(3000);
		//Click the update
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New discount Item is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Item is updated Failed");
		}

		Thread.sleep(5000);
		
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"101");Thread.sleep(5000);
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);
		
		//Check weather name changes are updated or not
		if(driver.getPageSource().contains(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"10"))
		{
			test.log(LogStatus.PASS, "Edited name is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Edits name is updated Failed");
		}
		Thread.sleep(5000);
		
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
	}
	
	@Test(priority=46)
	public void Item_Based_Discount_method_deleteDiscount_ItemBased(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		
		Thread.sleep(3000);
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"101");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(5000);
		//Click the Delete button
		driver.findElement(By.xpath("//div//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[2]/span[1]/a[2]/i")).click();
		
		Thread.sleep(3000);
		//Click the Yes button in the popup
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		
		Thread.sleep(3000);
		//Check the item deleted or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Discount Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "New discount Item is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Item is deleted Failed");
		}

		Thread.sleep(5000);
		
		//Click the Active or Inactive button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[1]/input")).click();
		
		Thread.sleep(2000);
		//Click the success button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[2]/span[2]/a/i")).click();
		Thread.sleep(1000);
		
		//Click the Yes button in the popup
				driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
				Thread.sleep(3000);

		//Check the item activated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Discount activated Successfully"))
		{
			test.log(LogStatus.PASS, "New discount Item is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Item is activated Failed");
		}
	
		Thread.sleep(5000);
	}

	@Test(priority=47)
	public void Item_Based_Discount_method_cancelButton(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click on the Add Menu Item option
		driver.findElement(By.id("newDiscount")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/h3")).getText().equalsIgnoreCase("Discounts"))
		{
			test.log(LogStatus.PASS, "New Discounts Item form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Discounts Item form loaded Failed");
		}

		
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		Thread.sleep(5000);
		
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger.ng-binding"));
		//Scroll the page till the Cancel option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
		
		//Click the Cancel button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger.ng-binding")).click();
		Thread.sleep(3000);
		//Check whether the new discount saved or not
		if(driver.findElement(By.xpath("//a[.='Item based discounts']")).getText().equalsIgnoreCase("Item based discounts"))
		{
			test.log(LogStatus.PASS, "New Item Based discount canceled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Item Based discount canceled Failed");
		}

		Thread.sleep(8000);
	}
	
	@Test(priority=48)
	public void Item_Based_Discount_method_editDiscount_ItemBased_ApplicableTimePeriodAsAlways_SaveAndPublish(WebDriver driver) throws Exception
	{
		
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"101");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(5000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(3000);
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"20");

		//Click the Coupon Only Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[2]/div/label/span")).click();
		Thread.sleep(2000);
		
		//Click the Auto discount option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[3]/div/label/span")).click();
		Thread.sleep(3000);

		//Click the Level Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/a")).click();
		//Enter the required Level
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/div/div/input")).sendKeys("Sub category");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Menu Item Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);	
		Thread.sleep(2000);
		
		//Clear the minimum Quantity field
		driver.findElement(By.name("minQuantity")).clear();
		//Enter the minimum Quantity
		driver.findElement(By.name("minQuantity")).sendKeys("2");
		
		Thread.sleep(2000);		
		//Click the Discount Field DropDown Option
		driver.findElement(By.xpath("//div/button[@aria-haspopup='true']")).click();
		//Click the Free Item Field
		driver.findElement(By.xpath("//a[.='free item']")).click();

		Thread.sleep(2000);
		//Click the Add free item option
		driver.findElement(By.xpath("//i[@class='fa fa-plus-circle']")).click();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(5000);
		//Click the Menu Item option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[7]/div/div[4]/div[2]/div[1]/div/ng-form/div[1]/div/a")).click();
		//Press the enter button
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[7]/div/div[4]/div[2]/div[1]/div/ng-form/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(8000);
		//Click the Serving Size Level option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[7]/div/div[4]/div[2]/div[1]/div/ng-form/div[2]/div/div/a")).click();
		//Enter the required serving size level
		//driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[5]/div/div[4]/div[2]/div[1]/div/ng-form/div[2]/div/div/div/div/input")).sendKey("EACH");
		//Press the enter button
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[7]/div/div[4]/div[2]/div[1]/div/ng-form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the quantity of free item
		driver.findElement(By.name("freeQty")).clear();
		//Enter the quantity
		driver.findElement(By.name("freeQty")).sendKeys("2");
		
		Thread.sleep(1000);
		//Clear the price of free quantity
		driver.findElement(By.name("freeItemOffer")).clear();
		//Enter the price
		driver.findElement(By.name("freeItemOffer")).sendKeys("225");
		
		Thread.sleep(2000);
		//Click the Add button
		//driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[5]/div/div[4]/div[2]/div[1]/div/ng-form/div[6]/a")).click();
		
		Thread.sleep(2000);
		//Click the Add free item option
		driver.findElement(By.xpath("//i[.='Add']")).click();
		
		Thread.sleep(3000);
		//Click the Add free item option
		driver.findElement(By.xpath("//i[@class='fa fa-plus-circle']")).click();
		
		Thread.sleep(4000);
		//Click the Menu Item option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[7]/div/div[4]/div[2]/div[1]/div/ng-form/div[1]/div/a")).click();
		//Enter the required menu Item
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[7]/div/div[4]/div[2]/div[1]/div/ng-form/div[1]/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the enter button
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[7]/div/div[4]/div[2]/div[1]/div/ng-form/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(12000);
		//Click the Serving Size Level option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[7]/div/div[4]/div[2]/div[1]/div/ng-form/div[2]/div/div/a")).click();
		//Enter the required serving size level
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[7]/div/div[4]/div[2]/div[1]/div/ng-form/div[2]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the enter button
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[7]/div/div[4]/div[2]/div[1]/div/ng-form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the quantity of free item
		driver.findElement(By.name("freeQty")).clear();
		//Enter the quantity
		driver.findElement(By.name("freeQty")).sendKeys("2");
		
		Thread.sleep(1000);
		//Clear the price of free quantity
		driver.findElement(By.name("freeItemOffer")).clear();
		//Enter the price
		driver.findElement(By.name("freeItemOffer")).sendKeys("225");
		
		Thread.sleep(2000);
		//Click the Add button
		driver.findElement(By.xpath("//i[.='Add']")).click();
		
		 	WebElement element = driver.findElement(By.xpath("//div[@class='no-padding langScroll']/div[2]/a"));
		 
	        Actions action = new Actions(driver);
	 
	        action.moveToElement(element).moveToElement(driver.findElement(By.xpath("//div[@class='no-padding langScroll']/div[2]/a"))).click().build().perform();
		
			
		Thread.sleep(2000);
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		
		Thread.sleep(5000);
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Always");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("After Tax");

		Thread.sleep(1000);
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("4");
		
		Thread.sleep(3000);
		//Clear the role field
		driver.findElement(By.xpath("//input[@value='Select roles']")).clear();Thread.sleep(2000);
		//Enter the required role
		driver.findElement(By.xpath("//input[@value='Select roles']")).sendKeys("Server");
		Thread.sleep(3000);
		//Press the Enter Key
		driver.findElement(By.xpath("//input[@value='Select roles']")).sendKeys(Keys.ENTER);driver.findElement(By.tagName("html")).sendKeys(Keys.END);

		//Select the Color from the list
		//driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div[7]/div/div/div[2]/div/div[8]")).click();
			
		//form[@name='discountForm']/div[2]/div[2]/div[6]/div/div/div[2]/div/div[8]
		Thread.sleep(3000);
		//Click the Save and Publish button
		driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")));
		
//		Thread.sleep(7000);driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String s1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText();Thread.sleep(3000);
		System.out.println("Required String  is : "+s1);
		//Check whether the Product Item updated successfully or not
		if(s1.equalsIgnoreCase("Saved and published successfully"))
		{
			test.log(LogStatus.PASS, "New discount Item is saved and published Successfully for Time Period as Always");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Item is saved and published Failed for Time Priod as Always");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=49)
	public void Item_Based_Discount_method_editDiscount_ItemBased_ApplicableTimePeriodAsDaysOfMonth(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"201");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(5000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);
		
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"21");
		
		Thread.sleep(5000);
		
		//Click the Coupon Only Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[2]/div/label/span")).click();
		Thread.sleep(2000);
		
		//Click the Auto discount option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[3]/div/label/span")).click();
		Thread.sleep(3000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		
/*		//Click the Level Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/a")).click();
		//Enter the required Level
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/div/div/input")).sendKey("Menu item");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/div/div/input")).sendKey(Keys.ENTER);
		
		//Click the Menu Item Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKey("COKE");
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKey(Keys.ENTER);	*/
		Thread.sleep(2000);
		
		//Clear the minimum Quantity field
		driver.findElement(By.name("minQuantity")).clear();
		//Enter the minimum Quantity
		driver.findElement(By.name("minQuantity")).sendKeys("5");
		
		Thread.sleep(3000);
		//Click the Discount Field DropDown Option
		driver.findElement(By.xpath("//div/button[@aria-haspopup='true']")).click();
		//Click the Free Item Field
		driver.findElement(By.xpath("//a[.='set price']")).click();
		//Clear the Offer field
		driver.findElement(By.name("offer")).clear();
		//Enter the Offer
		driver.findElement(By.name("offer")).sendKeys("250");
		
		Thread.sleep(3000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		
		Thread.sleep(3000);
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Days of Month");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Required Days of a Month
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/table/tbody/tr[2]/td[7]/button")).click();
		
		//Enable or Disable the Restriction months
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[3]/div/label/span")).click();
		
		
		Thread.sleep(2000);
		//Click the Months Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div/ul")).click();
		//Enter the Required Month
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div/ul/li/input")).sendKeys("MAY");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		//Enable or Disable theRestriction Time
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/label/span")).click();
		
		Thread.sleep(1000);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		Thread.sleep(2000);
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("Before Tax");

		Thread.sleep(2000);
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		
		Thread.sleep(2000);
		//Enable or Disable the Attach Customer
		driver.findElement(By.name("isCustomerAttach")).click();
		
		Thread.sleep(1000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New discount Item is updated Successfully for Time Period as Days of Month");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Item is updated Failed for Time Priod as Days Of Month");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=50)
	public void Item_Based_Discount_method_editDiscount_ItemBased_ApplicableTimePeriodAsDateRange(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"211");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(5000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);

		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"22");
		Thread.sleep(5000);
		
		//Click the Coupon Only Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[2]/div/label/span")).click();
		Thread.sleep(2000);
		
		//Click the Auto discount option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[3]/div/label/span")).click();
		Thread.sleep(3000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		
/*		//Click the Level Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/a")).click();
		//Enter the required Level
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/div/div/input")).sendKey("Menu item");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/div/div/input")).sendKey(Keys.ENTER);
		
		//Click the Menu Item Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKey("COKE");
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKey(Keys.ENTER);	*/
		Thread.sleep(2000);
		Thread.sleep(1000);
		//Clear the minimum Quantity field
		driver.findElement(By.name("minQuantity")).clear();
		//Enter the minimum Quantity
		driver.findElement(By.name("minQuantity")).sendKeys("5");
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);Thread.sleep(1000);
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Clear the From date field
		driver.findElement(By.name("fromDate")).clear();
		//Enter the required from Date
		driver.findElement(By.name("fromDate")).sendKeys("25-May-2040");
		//Clear the To Date field
		driver.findElement(By.name("endDate")).clear();
		//Enter the required To Date
		driver.findElement(By.name("endDate")).sendKeys("28-May-2040");
		
		Thread.sleep(2000);
		//Enable or Disable the Restriction Days field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/label/span")).click();
		
		//Click the Days of a Week field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul")).click();
		//Enter the Required Day to the Days of a Week field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Enable or Disable the restriction time period option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/label/span")).click();
		
		Thread.sleep(1000);Thread.sleep(1000);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[7]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		Thread.sleep(1000);
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("Before Tax");

		Thread.sleep(1000);Thread.sleep(1000);
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New discount Item is updated Successfully for Time Period as Date Range");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Item is updated Failed for Time Priod as Date Range");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=51)
	public void Item_Based_Discount_method_editDiscount_ItemBased_ApplicableTimePeriodAsSpecificDate(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"221");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(5000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);
		
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"23");
		Thread.sleep(5000);
		
		//Click the Coupon Only Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[2]/div/label/span")).click();
		Thread.sleep(2000);
		
		//Click the Auto discount option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[3]/div/label/span")).click();
		Thread.sleep(3000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		
/*		//Click the Level Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/a")).click();
		//Enter the required Level
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/div/div/input")).sendKey("Menu item");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/div/div/input")).sendKey(Keys.ENTER);
		
		//Click the Menu Item Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKey("COKE");
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKey(Keys.ENTER);	*/
		Thread.sleep(2000);
		Thread.sleep(1000);
		//Clear the minimum Quantity field
		driver.findElement(By.name("minQuantity")).clear();
		//Enter the minimum Quantity
		driver.findElement(By.name("minQuantity")).sendKeys("5");
		
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Specific date");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Clear the Date field
		driver.findElement(By.name("date")).clear();
		//Enter the required date
		driver.findElement(By.name("date")).sendKeys("18-May-2040");
		
		Thread.sleep(2000);
		//Enable or Disable the restriction time period option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[3]/div/label/span")).click();
		
		Thread.sleep(1000);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		Thread.sleep(1000);
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("Before Tax");

		Thread.sleep(1000);Thread.sleep(1000);
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New discount Item is updated Successfully for Time Period as Specific Date");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Item is updated Failed for Time Priod as Specific Date");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=52)
	public void Item_Based_Discount_method_editDiscount_ItemBased_ApplicableTimePeriodAs_StartDateAndEndDate(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"231");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(5000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);

		
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"24");
		Thread.sleep(5000);
		
		//Click the Coupon Only Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[2]/div/label/span")).click();
		Thread.sleep(2000);
		
		//Click the Auto discount option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[3]/div/label/span")).click();
		Thread.sleep(3000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		
/*		//Click the Level Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/a")).click();
		//Enter the required Level
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/div/div/input")).sendKey("Menu item");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/div/div/input")).sendKey(Keys.ENTER);
		
		//Click the Menu Item Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKey("COKE");
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKey(Keys.ENTER);*/	
		Thread.sleep(2000);
		Thread.sleep(1000);
		//Clear the minimum Quantity field
		driver.findElement(By.name("minQuantity")).clear();
		//Enter the minimum Quantity
		driver.findElement(By.name("minQuantity")).sendKeys("5");
		
		
		Thread.sleep(2000);
		//Click the Discount Field DropDown Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[7]/div/div[2]/div/div/button")).click();
		//Click the Percentage Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[7]/div/div[2]/div/div/ul/li[2]/a")).click();
		//Clear the percentage option
		driver.findElement(By.name("offer")).clear();
		//Enter the percentage
		driver.findElement(By.name("offer")).sendKeys("525");
		
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Start date time & end date time");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Clear the From date field
		driver.findElement(By.name("fromDate")).clear();
		//Enter the required from Date
		driver.findElement(By.name("fromDate")).sendKeys("25-May-2040");
		//Clear the To Date field
		driver.findElement(By.name("endDate")).clear();
		//Enter the required To Date
		driver.findElement(By.name("endDate")).sendKeys("28-May-2040");

		Thread.sleep(2000);
		//Enable or Disable the Restriction Days option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/label/span")).click();
		
		Thread.sleep(1000);
		//Click the Days of a week option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul")).click();
		//Enter the required day
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("After Tax");

		Thread.sleep(2000);
		//Enable or Disable the Include Additional Modifiers
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[7]/div[2]/div/label/span")).click();
		
		Thread.sleep(1000);
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		Thread.sleep(1000);
		//Click the Save button
		driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")));

		//Thread.sleep(7000);driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String s1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText();Thread.sleep(3000);
		System.out.println("Required String  is : "+s1);
		//Check whether the Product Item updated successfully or not
		if(s1.equalsIgnoreCase("Updated and published successfully"))
		{
			test.log(LogStatus.PASS, "New discount Item is update and published Successfully for Time Period as Strat Date and End Date");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Item is update and published Failed for Time Priod as Start Date and End Date");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=53)
	public void Item_Based_Discount_method_verifyActive_InActiveButton(WebDriver driver) throws Exception
	{
		Thread.sleep(10000);
		//Click Active or In Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[1]/input")).click();

		Thread.sleep(2000);
		try
		{
		//Check the New Display Group form is loaded or not
		if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Deleted groups are here, we are in InActive Page");
				Thread.sleep(10000);
				//Click the Reactivate button(Green)
				driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
				Thread.sleep(1000);
				Thread.sleep(1000);
				//Click the Yes button in the popup
				Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
	
				Thread.sleep(2000);
				
				//Check weather the Group is activate or not
				if(driver.findElement(By.xpath("//span[.='Discount activated Successfully']")).getText().equalsIgnoreCase("Discount activated Successfully"))
				{
					test.log(LogStatus.PASS, "Discount is activated successfully");
					//Click Active or In Active Button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[1]/input")).click();
	
				}
				else
				{
					test.log(LogStatus.FAIL, "Discount is activated Failed");
				}
			}
		}
		catch(Exception e)
		{
		if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Deleted groups are not here, we are in Active Page");
				//Click Active or In Active Button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/input")).click();
				Thread.sleep(10000);
				//Click the Reactivate button(Green)
				driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
				Thread.sleep(1000);
				//Click the Yes button in the popup
				Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
				Thread.sleep(3000);
	
				//Check weather the Group is activate or not
				if(driver.findElement(By.xpath("//span[.='Discount activated Successfully']")).getText().equalsIgnoreCase("Discount activated Successfully"))
				{
					test.log(LogStatus.PASS, "Discount is activated successfully");
					//Click Active or In Active Button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[1]/input")).click();
	
				}
				else
				{
					test.log(LogStatus.FAIL, "Discount is activated Failed");
				}
				
			}
		}
	}
	
	@Test(priority=54)
	public void Item_Based_Discount_method_addSameName(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click on the Add Menu Item option
		driver.findElement(By.id("newDiscount")).click();
				
		Thread.sleep(5000);
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		Thread.sleep(1000);
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"24");
		Thread.sleep(5000);
		
		//Click the Coupon Only Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[2]/div/label/span")).click();
		Thread.sleep(2000);
		
		//Click the Auto discount option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[3]/div/label/span")).click();
		Thread.sleep(3000);
		
	
		
		Thread.sleep(1000);
		//Click the Level Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/a")).click();
		//Enter the required Level
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/div/div/input")).sendKeys("Menu item");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);Thread.sleep(1000);
		//Click the Menu Item Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Clear the minimum Quantity field
		driver.findElement(By.name("minQuantity")).clear();
		//Enter the minimum Quantity
		driver.findElement(By.name("minQuantity")).sendKeys("5");
		
		Thread.sleep(2000);
		//Click the Discount Field DropDown Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[6]/div/div[2]/div/div/button")).click();
		//Click the Free Item Field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[6]/div/div[2]/div/div/ul/li[4]/a")).click();
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);Thread.sleep(1000);
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Days of Week");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);Thread.sleep(1000);
		//Click the Days if Week Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/div/ul")).click();
		//Enter the required DAY for Searching
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/div/ul/li/input")).sendKeys("WEDNESDAY");
		//Press the Enter key after enter the keyword
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("Before Tax");

		Thread.sleep(1000);
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Check the New Display Group saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Validation Error(s)"))
		{
			test.log(LogStatus.PASS, "New Discount added Fail, User cannot be able to give the same group name");
			Thread.sleep(3000);
			//Find the validation message for the name field
			if(driver.findElement(By.xpath("//p[@class='help-block ng-binding']")).getText().equalsIgnoreCase("Name already exists"))
			{
				test.log(LogStatus.PASS, "Discount name is already exist");
			}

			
		}
		else
		{
			test.log(LogStatus.FAIL, "New Discount added success, User can be able to give the same group name");
		}

		Thread.sleep(5000);
		
	}

	@Test(priority=61)
	public void Check_Based_Discount_method_openDiscount_CheckBasedPage(WebDriver driver) throws Exception
	{
/*		//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Discounts']"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Discounts Option		
		driver.findElement(By.xpath("//span[.='Discounts']")).click();*/
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"check_based/discount/list");

		Thread.sleep(5000);
		//Check Check based discount page opened or not
		if(driver.findElement(By.xpath("//span[.='Check Based']")).getText().equalsIgnoreCase("Check Based"))
		{
			test.log(LogStatus.PASS, "Check Based discount page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Check Based discount page loaded Failed");
		}
		
		Thread.sleep(5000);

	}
	
	@Test(priority=62)
	public void Check_Based_Discount_method_refreshDiscount_CheckBasedPage(WebDriver driver) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/a/i")).click();
		Thread.sleep(5000);
		//Check Check based discount page opened or not
		if(driver.findElement(By.xpath("//span[.='Check Based']")).getText().equalsIgnoreCase("Check Based"))
		{
			test.log(LogStatus.PASS, "Check Based discount page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Check Based discount page refreshed Failed");
		}
		Thread.sleep(5000);

	}
	
	@Test(priority=64)
	public void Check_Based_Discount_method_addDiscount_CheckBased(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(5000);
		//Click on the Add Menu Item option
		driver.findElement(By.id("newDiscount")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//h3[.='Discounts']")).getText().equalsIgnoreCase("Discounts"))
		{
			test.log(LogStatus.PASS, "New Discounts Item form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Discounts Item form loaded Failed");
		}

		
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_CheckBased_Amount"));
		Thread.sleep(5000);
		
		//Enable or Disable the Coupon only check box button
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[2]/div/label/span")).click();
		Thread.sleep(5000);
		
		//Click the Auto discount option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[3]/div/label/span")).click();
		Thread.sleep(3000);
		
		//Click the Add symbol for adding offers
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[1]/a/i")).click();
		Thread.sleep(5000);
		
		//Click the button field for selecting the required field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/button")).click();
		//Click the amount option from the given list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/ul/li[1]/a")).click();

		
		//Clear the amount field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[1]/input")).clear();
		//Enter the amount When it is applicable
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[1]/input")).sendKeys("1000000");
		//Clear the amount field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/input")).clear();
		//Enter how much of amount is discount for the particular product
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/input")).sendKeys("500");
		
		//Click the Exclude Category field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the Exclude Category field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		//Click the Exclude Menu Item field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul")).click();
		//Enter the Exclude Menu Item field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		//Select the Discount type
		Select discType = new Select(driver.findElement(By.name("discountCouponType")));
		discType.selectByVisibleText("Promo");
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Days of Week");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Days of Week Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/div/ul")).click();
		//Enter the required DAY for Searching
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/div/ul/li/input")).sendKeys("WEDNESDAY");
		//Press the Enter key after enter the keyword
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Restriction Time Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[3]/div/label/span")).click();
		
		Thread.sleep(1000);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(5000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(5000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("Before Tax");

		for(int i = 1; i <= 5;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);}Thread.sleep(3000);
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		
		Thread.sleep(5000);
		//CLick the Roles Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div[4]/div/div/ul")).click();
		//Enter the required Role
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div[4]/div/div/ul/li/input")).sendKeys("Driver");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Clear the Discount Code Name
		driver.findElement(By.name("discountCode")).clear();
		//Enter the Discount Code
		driver.findElement(By.name("discountCode")).sendKeys(Utility.getProperty("CheckBased_Discount_Code"));
		
		Thread.sleep(5000);
		//click the attach customer option
		driver.findElement(By.name("isCustomerAttach")).click();
		
		//Choose any one color from the given
		driver.findElement(By.xpath("//div[@class='email-template-color color-swatch ng-scope'][6]")).click(); 	
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		//Check whether the new discount saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Saved successfully"))
		{
			test.log(LogStatus.PASS, "New Item based(CheckBased_Amount) discount saved Successfully for Time Period as Days of Month");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Item based(CheckBased_Amount) discount saved Failed for Time Period as Days of Month");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=65)
	public void Check_Based_Discount_method_editDiscount_CheckBased(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_CheckBased_Amount")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(5000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(3000);
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_CheckBased_Amount")+"1");

		//Click the button field for selecting the required field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/button")).click();
		//Click the amount option from the given list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/ul/li[2]/a")).click();

		
		//Clear the Percentage field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[1]/input")).clear();
		//Enter the Percentage When it is applicable
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[1]/input")).sendKeys("1000000");
		//Clear the Percentage discount field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/input")).clear();
		//Enter how much of amount is discount for the particular product
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/input")).sendKeys("200");
		
		Select discType = new Select(driver.findElement(By.name("discountCouponType")));
		discType.selectByVisibleText("Comp");
		
		Thread.sleep(5000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(3000);
		//Click the update
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(3500);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New discount Item is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Item is updated Failed");
		}

		Thread.sleep(5000);
		
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_CheckBased_Amount")+"11");Thread.sleep(5000);
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);
		
		//Check weather name changes are updated or not
		if(driver.getPageSource().contains(Utility.getProperty("DiscountName_CheckBased_Amount")+"1"))
		{
			test.log(LogStatus.PASS, "Edited name is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Edits name is updated Failed");
		}
		Thread.sleep(5000);
		
		//Click the Close button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
	}
	
	@Test(priority=66)
	public void Check_Based_Discount_method_deleteDiscount_CheckBased(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_CheckBased_Amount")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(4500);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		//Click the Yes button in the popup
		Thread.sleep(2500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3500);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Check the menu item deleted or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Discount Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "New discount Item is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Item is deleted Failed");
		}

		Thread.sleep(5000);		
		//Click the Active or Inactive button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[1]/input")).click();
		
		Thread.sleep(5000);
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);

		//Check the menu item activated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Discount activated Successfully"))
		{
			test.log(LogStatus.PASS, "New discount Item is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Item is activated Failed");
		}
		
		Thread.sleep(3000);
		//Click the Active or Inactive button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[1]/input")).click();

	}

	@Test(priority=67)
	public void Check_Based_Discount_method_cancelButton(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click on the Add Menu Item option
		driver.findElement(By.id("newDiscount")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//h3[.='Discounts']")).getText().equalsIgnoreCase("Discounts"))
		{
			test.log(LogStatus.PASS, "New Discounts Item form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Discounts Item form loaded Failed");
		}

		
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_CheckBased_Amount")+"2");
		Thread.sleep(5000);
			
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(3500);
		//Check whether the new discount canceled or not
		if(driver.findElement(By.xpath("//a[.='Check based discounts']")).getText().equalsIgnoreCase("Check based discounts"))
		{
			test.log(LogStatus.PASS, "New Item based discount Canceled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Item based discount Canceled Failed");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=68)
	public void Check_Based_Discount_method_editDiscount_CheckBased_TimePeriodAsAlways_SaveAndPublish(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_CheckBased_Amount")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(5000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(3000);
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_CheckBased_Amount")+"20");
		Thread.sleep(5000);
		
		//Enable or Disable the Coupon only check box button
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[2]/div/label/span")).click();
		Thread.sleep(5000);
		
		//Click the Auto discount option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[3]/div/label/span")).click();
		Thread.sleep(3000);
		
		//Click the Add symbol for adding offers
		//driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[1]/a/i")).click();
		Thread.sleep(5000);
		
		//Click the button field for selecting the required field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/button")).click();
		//Click the amount option from the given list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/ul/li[3]/a")).click();

		
		//Clear the amount field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[1]/input")).clear();
		//Enter the amount When it is applicable
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[1]/input")).sendKeys("1000000");
		//Clear the amount field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/input")).clear();
		//Enter how much of amount is discount for the particular product
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/input")).sendKeys("500");
		
		//Click the Exclude Category field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the Exclude Category field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		//Click the Exclude Menu Item field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul")).click();
		//Enter the Exclude Menu Item field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		Select discType = new Select(driver.findElement(By.name("discountCouponType")));
		discType.selectByVisibleText("Donation");
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Always");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("After Tax");

		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		
		Thread.sleep(5000);
		//click the attach customer option
		driver.findElement(By.name("isCustomerAttach")).click();
		
		//Choose any one color from the given 
		//driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div[6]/div/div/div[2]/div/div[6]")).click(); 	
		Thread.sleep(3000);
		//Click the update
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(3500);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New discount Item is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Item is updated Failed");
		}

		Thread.sleep(5000);

	}
	
	@Test(priority=69)
	public void Check_Based_Discount_method_editDiscount_CheckBased_TimePeriodAsDaysOfMonth(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_CheckBased_Amount")+"201");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(5000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(5000);

		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_CheckBased_Amount")+"21");
		Thread.sleep(5000);
		
		//Enable or Disable the Coupon only check box button
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[2]/div/label/span")).click();
		Thread.sleep(5000);
		
		//Click the Auto discount option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[3]/div/label/span")).click();
		Thread.sleep(3000);
		
/*		//Click the Add symbol
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[1]/a/i")).click();
		Thread.sleep(5000);
		//Enter the amount When it is applicable
		driver.findElement(By.name("offers")).sendKeys("500.00");
		//Enter how much of amount is discount for the particular product
		driver.findElement(By.name("offDis")).sendKeys("50.00");
		//Click the button field for selecting the required field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/button")).click();
		//Click the amount option from the given list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/ul/li[1]/a")).click();
*/		
/*		//Click the Exclude Category field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the Exclude Category field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys("PIZZA");
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		//Click the Exclude Menu Item field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul")).click();
		//Enter the Exclude Menu Item field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul/li/input")).sendKeys("COKE");
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);*/
		
		//Click the button field for selecting the required field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/button")).click();
		//Click the amount option from the given list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/ul/li[4]/a")).click();

		
		//Clear the amount field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[1]/input")).clear();
		//Enter the amount When it is applicable
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[1]/input")).sendKeys("1000000");

		//Click the add Free Item Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[4]/div/div/div/label/span[2]/a/i")).click();
		
		//Click the Items Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[4]/div/div/div/div/div/div[1]/a")).click();
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[4]/div/div/div/div/div/div[1]/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Click the Items Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[4]/div/div/div/div/div/div[2]/div/a")).click();
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[4]/div/div/div/div/div/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(5000);
		//Clear the Free Item Offer Price
		driver.findElement(By.name("freeItemSingleOffer")).clear();
		//Enter the Free Item Amount
		driver.findElement(By.name("freeItemSingleOffer")).sendKeys("1000000");
		
		Thread.sleep(1000);
		//Clear the Quantity field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[4]/div/div/div/div/div/div[5]/input")).clear();
		//Enter the Quantity
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[4]/div/div/div/div/div/div[5]/input")).sendKeys("1");
		
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Days of Month");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Required Date form the Calendar
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/table/tbody/tr[2]/td[7]/button")).click();
		Thread.sleep(5000);
		
		//Enable or Disable the Restriction Months option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[3]/div/label/span")).click();
		
		Thread.sleep(5000);
		//Click the months field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div/ul")).click();
		//Enter the Required month
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div/ul/li/input")).sendKeys("MAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Restriction Time option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/label/span")).click();
		
		Thread.sleep(1000);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(5000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(5000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("Before Tax");

		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		
		Thread.sleep(5000);
		//Enable or Disable the Attach Customer option
		driver.findElement(By.name("isCustomerAttach")).click();
		
		//Click the Save button
		driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")));
		
//		Thread.sleep(7000);driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String s1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText();Thread.sleep(3000);
		//System.out.println("Required String  is : "+s1);
		//Check whether the Product Item updated successfully or not
		if(s1.equalsIgnoreCase("Updated and published successfully"))
		{
			test.log(LogStatus.PASS, "New discount Item is updated and Published Successfully for Time Period as Days of Month");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Item is updated and Published Failed for Time Period as Days of Month");
		}

		Thread.sleep(3000);
	}
	
	@Test(priority=70)
	public void Check_Based_Discount_method_editDiscount_CheckBased_TimePeriodasDateRange(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_CheckBased_Amount")+"211");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(5000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(5000);
		
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_CheckBased_Amount")+"22");
		Thread.sleep(5000);
		
		//Click the Auto discount option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[3]/div/label/span")).click();
		Thread.sleep(3000);
		
/*		//Click the Add symbol
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[1]/a/i")).click();
		Thread.sleep(5000);
		//Enter the amount When it is applicable
		driver.findElement(By.name("offers")).sendKeys("500.00");
		//Enter how much of amount is discount for the particular product
		driver.findElement(By.name("offDis")).sendKeys("50.00");
		//Click the button field for selecting the required field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/button")).click();
		//Click the amount option from the given list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/ul/li[1]/a")).click();
*/		
/*		//Click the Exclude Category field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the Exclude Category field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys("PIZZA");
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		//Click the Exclude Menu Item field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul")).click();
		//Enter the Exclude Menu Item field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul/li/input")).sendKeys("COKE");
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);*/
				
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Clear the From date field
		driver.findElement(By.name("fromDate")).clear();
		//Enter the required from Date
		driver.findElement(By.name("fromDate")).sendKeys("25-May-2040");
		//Clear the To Date field
		driver.findElement(By.name("endDate")).clear();
		//Enter the required To Date
		driver.findElement(By.name("endDate")).sendKeys("28-May-2040");

		//Enable or Disable the Restriction Days Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/label/span")).click();
		
		Thread.sleep(5000);
		//Click the Days of a Week option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul")).click();
		//Enter the Required Date
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Restriction Time Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/label/span")).click();
		Thread.sleep(5000);
	
		Thread.sleep(1000);
		//Check it is AM or PM i	n the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(5000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[7]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(5000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("Before Tax");

		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		
		
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3500);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New discount Item is updated Successfully for Time Period as Date Range");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Item is updated Failed for Time Period as Date Range");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=71)
	public void Check_Based_Discount_method_editDiscount_CheckBased_TimePeriodAsSpecificDate(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_CheckBased_Amount")+"221");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(5000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(5000);
		
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_CheckBased_Amount")+"23");
		Thread.sleep(5000);
		
		//Click the Auto discount option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[3]/div/label/span")).click();
		Thread.sleep(3000);
		
/*		//Click the Add symbol
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[1]/a/i")).click();
		Thread.sleep(5000);
		//Enter the amount When it is applicable
		driver.findElement(By.name("offers")).sendKeys("500.00");
		//Enter how much of amount is discount for the particular product
		driver.findElement(By.name("offDis")).sendKeys("50.00");
		//Click the button field for selecting the required field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/button")).click();
		//Click the amount option from the given list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/ul/li[1]/a")).click();
*/		
/*		//Click the Exclude Category field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the Exclude Category field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys("PIZZA");
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Click the Exclude Menu Item field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul")).click();
		//Enter the Exclude Menu Item field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul/li/input")).sendKeys("COKE");
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);*/
		
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Specific date");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Clear the Date field
		driver.findElement(By.name("date")).clear();
		//Enter the required date
		driver.findElement(By.name("date")).sendKeys("15-May-2040");
		
		//Enable or Disable the Restriction Time Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[3]/div/label/span")).click();
		Thread.sleep(5000);
		
		Thread.sleep(1000);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(5000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(5000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("Before Tax");
		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3500);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New discount Item is updated Successfully for Time Period as Specific Date");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Item is updated Failed for Time Period as Specific Date");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=72)
	public void Check_Based_Discount_method_editDiscount_CheckBased_TimePeriodAsStartDateTimeAndEndDateTime(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_CheckBased_Amount")+"231");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(5000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(5000);
		
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_CheckBased_Amount")+"24");
		Thread.sleep(5000);
		
		//Click the Auto discount option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[3]/div/label/span")).click();
		Thread.sleep(3000);
		
/*		//Click the Add symbol
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[1]/a/i")).click();
		Thread.sleep(5000);
		//Enter the amount When it is applicable
		driver.findElement(By.name("offers")).sendKeys("500.00");
		//Enter how much of amount is discount for the particular product
		driver.findElement(By.name("offDis")).sendKeys("50.00");
		//Click the button field for selecting the required field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/button")).click();
		//Click the amount option from the given list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/ul/li[1]/a")).click();
*/		
/*		//Click the Exclude Category field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the Exclude Category field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys("PIZZA");
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		//Click the Exclude Menu Item field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul")).click();
		//Enter the Exclude Menu Item field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul/li/input")).sendKeys("COKE");
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);*/
		
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Start date time & end date time");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Clear the From date field
		driver.findElement(By.name("fromDate")).clear();
		//Enter the required from Date
		driver.findElement(By.name("fromDate")).sendKeys("25-May-2040");
		//Clear the To Date field
		driver.findElement(By.name("endDate")).clear();
		//Enter the required To Date
		driver.findElement(By.name("endDate")).sendKeys("28-May-2040");
		
		//Enable or Disable the Restriction Days Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/label/span")).click();
		Thread.sleep(5000);
		
		//Click the Days of a week option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul")).click();
		//Enter the required day
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		Thread.sleep(1000);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(5000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(5000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("Before Tax");

		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		
	
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3500);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New discount Item is updated Successfully for Time Period as Start Date and End Date");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Item is updated Failed for Time Period as Start Date and End Date");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=73)
	public void Check_Based_Discount_method_verifyActive_InActiveButton(WebDriver driver) throws Exception
	{
		Thread.sleep(15000);
		//Click Active or In Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[1]/input")).click();

		Thread.sleep(5000);
		//Check the New Display Group form is loaded or not
		if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Deleted groups are here, we are in InActive Page");
			
			Thread.sleep(15000);
			//Click Active or In Active Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[1]/input")).click();
			
			Thread.sleep(5000);
			if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Deleted groups are not here, we are in Active Page");
			}

		}
		else if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Deleted groups are not here, we are in Active Page");
			//Click Active or In Active Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/input")).click();			
		}
		
	}
	
/*	@Test(priority=63)
	public void Check_Based_Discount_method_pagination(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
		//Click the Pagination option as 10
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[2]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Check Based Discount");
		//Create the web element for Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]"));
		for (WebElement result : results){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" discounts are available(Discount_Check_Based) When Click the Pagination option as 10");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[3]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Check Based Discount");
		//Create the web element for Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" discounts are available(Discount_Check_Based) When Click the Pagination option as 15");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[4]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for Check Based Discount");
		//Create the web element for Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" discounts are available(Discount_Check_Based) When Click the Pagination option as 20");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[1]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Check Based Discount");
		//Create the web element for Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" discounts are available(Discount_Check_Based) When Click the Pagination option as 5");
		}
		Thread.sleep(8000);
	}
*/	
	@Test(priority=74)
	public void Check_Based_Discount_method_addSameName(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click on the Add Menu Item option
		driver.findElement(By.id("newDiscount")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//h3[.='Discounts']")).getText().equalsIgnoreCase("Discounts"))
		{
			test.log(LogStatus.PASS, "New Discounts Item form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Discounts Item form loaded Failed");
		}

		
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_CheckBased_Amount")+"24");
		Thread.sleep(5000);
		
		//Enable or Disable the Coupon only check box button
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[2]/div/label/span")).click();
		Thread.sleep(5000);
		
		//Click the Auto discount option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[3]/div/label/span")).click();
		Thread.sleep(3000);
		
		//Click the Add symbol for adding offers
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[1]/a/i")).click();
		Thread.sleep(5000);
		

		//Click the button field for selecting the required field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/button")).click();
		//Click the amount option from the given list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div[3]/ng-form/div/div[3]/div/div[1]/ul/li[2]/a")).click();
		
		//Enter the amount When it is applicable
		driver.findElement(By.name("offers")).sendKeys("1000000");
		//Enter how much of amount is discount for the particular product
		driver.findElement(By.name("offDis")).sendKeys("500");
		
		//Click the Exclude Category field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the Exclude Category field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		//Click the Exclude Menu Item field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul")).click();
		//Enter the Exclude Menu Item field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Days of Week");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Days of Week Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/div/ul")).click();
		//Enter the required DAY for Searching
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/div/ul/li/input")).sendKeys("WEDNESDAY");
		//Press the Enter key after enter the keyword
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Restriction Time Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[3]/div/label/span")).click();
		
		Thread.sleep(1000);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(5000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(5000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("Before Tax");

		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3500);

		//Check the New Display Group saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Validation Error(s)"))
		{
			test.log(LogStatus.PASS, "New Discount added Fail, User cannot be able to give the same group name");
			Thread.sleep(3000);
			//Find the validation message for the name field
			if(driver.findElement(By.xpath("//p[@class='help-block ng-binding']")).getText().equalsIgnoreCase("Name already exists"))
			{
				test.log(LogStatus.PASS, "Discount name is already exist");
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "New Discount added success, User can be able to give the same group name");
		}

		Thread.sleep(5000);
		
	}

	@Test(priority=81)
	public void Open_Item_Discount_method_editDiscount_OpenItem(WebDriver driver) throws Exception
	{
/*		//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Discounts']"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Discounts Option		
		driver.findElement(By.xpath("//span[.='Discounts']")).click();*/
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"open_item/openDiscount");
		Thread.sleep(5000);
		//Check Check based discount page opened or not
		if(driver.findElement(By.cssSelector("h3.ng-binding")).getText().equalsIgnoreCase("Discounts"))
		{
			test.log(LogStatus.PASS, "Open Item page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Open Item page loaded Failed");
		}
		
		Thread.sleep(8000);
		//Click edit button
		driver.findElement(By.id("editOpen")).click();Thread.sleep(3000);
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_OpenItemAMT"));
		
		//Enable or Disable the Coupon only option
		driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[2]/div/label/span")).click();
		Thread.sleep(2000);
		
		if(driver.findElement(By.name("isPercentage")).isSelected())
		{
			Thread.sleep(2000);
			//Clear the minimum percentage option
			driver.findElement(By.name("minPercentage")).clear();
			//Enter the required minimum value in minimum percentage
			driver.findElement(By.name("minPercentage")).sendKeys("4");
			//Clear the maximum percentage option
			driver.findElement(By.name("maxPercentage")).clear();
			//Enter the required maximum value in maximum percentage
			driver.findElement(By.name("maxPercentage")).sendKeys("5");

		}
		else
		{
			Thread.sleep(2000);
			//Click the Discount in percentage button
			driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[3]/div/label/span")).click();
			Thread.sleep(3000);
			//Clear the minimum percentage option
			driver.findElement(By.name("minPercentage")).clear();
			//Enter the required minimum value in minimum percentage
			driver.findElement(By.name("minPercentage")).sendKeys("4");
			//Clear the maximum percentage option
			driver.findElement(By.name("maxPercentage")).clear();
			//Enter the required maximum value in maximum percentage
			driver.findElement(By.name("maxPercentage")).sendKeys("7");
			Thread.sleep(2000);
		}

		Thread.sleep(2000);
		if(driver.findElement(By.name("isAmount")).isSelected())
		{
			
			Thread.sleep(3000);
			//Clear the minimum amount option
			driver.findElement(By.name("minAmount")).clear();
			//Enter the required minimum value in minimum amount
			driver.findElement(By.name("minAmount")).sendKeys("5.00");
			//Clear the maximum amount option
			driver.findElement(By.name("maxAmount")).clear();
			//Enter the required maximum value in maximum amount
			driver.findElement(By.name("maxAmount")).sendKeys("7.00");

		}
		else
		{
			Thread.sleep(2000);
			//Click the Discount in Amount button
			driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[6]/div/label/span")).click();
			Thread.sleep(3000);
			//Clear the minimum amount option
			driver.findElement(By.name("minAmount")).clear();
			//Enter the required minimum value in minimum amount
			driver.findElement(By.name("minAmount")).sendKeys("4.00");
			//Clear the maximum amount option
			driver.findElement(By.name("maxAmount")).clear();
			//Enter the required maximum value in maximum amount
			driver.findElement(By.name("maxAmount")).sendKeys("5.00");
		}

		Select discType = new Select(driver.findElement(By.name("discountCouponType")));
		discType.selectByVisibleText("Donation");
		
		//Clear the Safety Limit Percentage text box
		driver.findElement(By.name("safetyLimitPercentage")).clear();
		//Enter the required percentage
		driver.findElement(By.name("safetyLimitPercentage")).sendKeys("10");
	
		//Select the any one tax from the give list
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("After Tax");
		
		//Enable or Disable the Include Additional Modifiers
		driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[2]/div[3]/div/label/span")).click();
		Thread.sleep(3000);
		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		
		//CLick the Roles Option
		driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[2]/div[6]/div/div/ul")).click();
		//Enter the required Role
		driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[2]/div[6]/div/div/ul/li/input")).sendKeys("Driver");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[2]/div[6]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the isCustomer Attach
		driver.findElement(By.name("isCustomerAttach")).click();
		
		//Clear the Discount Code
		driver.findElement(By.name("discountCode")).clear();
		//Enter the Discount Code
		driver.findElement(By.name("discountCode")).sendKeys(Utility.getProperty("OpenItem_Discount_Code"));
		
		//Choose any one color from the given
		driver.findElement(By.xpath("//div[@class='email-template-color color-swatch ng-scope'][6]")).click(); 	
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(3000);
		//Click the update
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(2000);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New discount Open Item is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Open Item is updated Failed");
		}
		Thread.sleep(5000);

		//Click edit button
		driver.findElement(By.id("editOpen")).click();
		Thread.sleep(3000);
		
		//Check weather name changes are updated or not
		if(driver.getPageSource().contains(Utility.getProperty("DiscountName_OpenItemAMT")))
		{
			test.log(LogStatus.PASS, "Edited name is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Edits name is updated Failed");
		}
		
		Thread.sleep(1000);
		//Check the coupon only is enable or not
		if(driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[2]/div/label/span")).isEnabled())
		{
			test.log(LogStatus.PASS, "Coupon only field is enabled");
		}
		else
		{
			test.log(LogStatus.PASS, "Coupon only field is disabled");
		}
		Thread.sleep(1000);
		//Check the discount in percentage is enable or not
		if(driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[3]/div/label/span")).isEnabled())
		{
			test.log(LogStatus.PASS, "Discount in percentage field is enabled");
		}
		else
		{
			test.log(LogStatus.PASS, "Discount in percentage field is disabled");
		}
		Thread.sleep(1000);
		//Check the discount in amount is enable or not
		if(driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[6]/div/label/span")).isEnabled())
		{
			test.log(LogStatus.PASS, "Discount in amount field is enabled");
		}
		else
		{
			test.log(LogStatus.PASS, "Discount in amount field is disabled");
		}
		
		Thread.sleep(3000);
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=82)
	public void Open_Item_Discount_method_deleteOrActiveDiscount_OpenItem(WebDriver driver) throws Exception
	{
		Thread.sleep(10000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);Thread.sleep(3000);
				//Click the Active/InActive button
				driver.findElement(By.xpath("//a[@id='editOpen']/../a[2]")).click();
				//Click the Yes button in the popup
				Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
			
				Thread.sleep(3000);
				//Check the menu item deleted/Activated or not
				if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Discount activated Successfully"))
				{
					test.log(LogStatus.PASS, "New discount Open Item is Activated Successfully");
				}
				else
				{
					test.log(LogStatus.PASS, "New discount Open Item is Inactivated Successfully");
				}

	}
	
	@Test(priority=83)
	public void Open_Item_Discount_method_cancelButton(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Click edit button
		driver.findElement(By.id("editOpen")).click();
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_OpenItemAMT")+"1");
		
		Thread.sleep(3000);
		//Click the update
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger.ng-binding")).click();
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.xpath("//a[.='Show open item discount']")).getText().equalsIgnoreCase("Show open item discount"))
		{
			test.log(LogStatus.PASS, "New discount Open Item is canceled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Open Item is canceled Failed");
		}
		Thread.sleep(3000);

	}

	@Test(priority=91)
	public void Open_Check_Discount_method_editDiscount_OpenCheck(WebDriver driver) throws Exception
	{
		/*		//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Discounts']"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Discounts Option		
		driver.findElement(By.xpath("//span[.='Discounts']")).click();*/
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"open_check/openDiscount");
		Thread.sleep(5000);
		//Check Check based discount page opened or not
		if(driver.findElement(By.cssSelector("h3.ng-binding")).getText().equalsIgnoreCase("Discounts"))
		{
			test.log(LogStatus.PASS, "Open Check(OpenCheckAmount) page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Open Check(OpenCheckAmount) page loaded Failed");
		}
		
		Thread.sleep(8000);
		//Click edit button
		driver.findElement(By.id("editOpen")).click();Thread.sleep(2500);
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_OpenCheckAMT"));
		
		//Enable or Disable the Coupon only option
		driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[2]/div/label/span")).click();
		Thread.sleep(2000);
		
		if(driver.findElement(By.name("isPercentage")).isSelected())
		{
			Thread.sleep(2000);
			//Clear the minimum percentage option
			driver.findElement(By.name("minPercentage")).clear();
			//Enter the required minimum value in minimum percentage
			driver.findElement(By.name("minPercentage")).sendKeys("4");
			//Clear the maximum percentage option
			driver.findElement(By.name("maxPercentage")).clear();
			//Enter the required maximum value in maximum percentage
			driver.findElement(By.name("maxPercentage")).sendKeys("8");

		}
		else
		{
			Thread.sleep(2000);
			//Click the Discount in percentage button
			driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[3]/div/label/span")).click();
			Thread.sleep(3000);
			//Clear the minimum percentage option
			driver.findElement(By.name("minPercentage")).clear();
			//Enter the required minimum value in minimum percentage
			driver.findElement(By.name("minPercentage")).sendKeys("2");
			//Clear the maximum percentage option
			driver.findElement(By.name("maxPercentage")).clear();
			//Enter the required maximum value in maximum percentage
			driver.findElement(By.name("maxPercentage")).sendKeys("7");
			Thread.sleep(2000);
		}

		Thread.sleep(2000);
		if(driver.findElement(By.name("isAmount")).isSelected())
		{
			
			Thread.sleep(3000);
			//Clear the minimum amount option
			driver.findElement(By.name("minAmount")).clear();
			//Enter the required minimum value in minimum amount
			driver.findElement(By.name("minAmount")).sendKeys("8.00");
			//Clear the maximum amount option
			driver.findElement(By.name("maxAmount")).clear();
			//Enter the required maximum value in maximum amount
			driver.findElement(By.name("maxAmount")).sendKeys("10.00");

		}
		else
		{
			Thread.sleep(4000);
			//Click the Discount in Amount button
			driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[6]/div/label/span")).click();
			Thread.sleep(3000);
			//Clear the minimum amount option
			driver.findElement(By.name("minAmount")).clear();
			//Enter the required minimum value in minimum amount
			driver.findElement(By.name("minAmount")).sendKeys("4.00");
			//Clear the maximum amount option
			driver.findElement(By.name("maxAmount")).clear();
			//Enter the required maximum value in maximum amount
			driver.findElement(By.name("maxAmount")).sendKeys("5.00");
		}

		Select discType = new Select(driver.findElement(By.name("discountCouponType")));
		discType.selectByVisibleText("Comp");
		
		//Clear the Safety Limit Percentage option
		driver.findElement(By.name("safetyLimitPercentage")).clear();
		//Enter the required percentage
		driver.findElement(By.name("safetyLimitPercentage")).sendKeys("10");
		
		//Select the any one tax from the give list
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("After Tax");
		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		
		//CLick the Roles Option
		driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[2]/div[5]/div/div/ul")).click();
		//Enter the required Role
		driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys("Driver");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Enable or Disable the isCustomer Attach
		driver.findElement(By.name("isCustomerAttach")).click();
		
		//Choose any one color from the given
		driver.findElement(By.xpath("//div[@class='email-template-color color-swatch ng-scope'][5]")).click(); 	
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(3000);
		
		//Click the update
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New discount Open Item(OpenCheckAmount) is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Open Item(OpenCheckAmount) is updated Failed");
		}
		
		Thread.sleep(5000);
		
		//Click edit button
		driver.findElement(By.id("editOpen")).click();
		Thread.sleep(3000);
		
		//Check weather name changes are updated or not
		if(driver.getPageSource().contains(Utility.getProperty("DiscountName_OpenCheckAMT")))
		{
			test.log(LogStatus.PASS, "Edited name is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Edits name is updated Failed");
		}
		
		Thread.sleep(1000);
		//Check the coupon only is enable or not
		if(driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[2]/div/label/span")).isSelected())
		{
			test.log(LogStatus.PASS, "Coupon only field is enabled");
		}
		else
		{
			test.log(LogStatus.PASS, "Coupon only field is disabled");
		}
		Thread.sleep(1000);
		//Check the discount in percentage is enable or not
		if(driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[3]/div/label/span")).isSelected())
		{
			test.log(LogStatus.PASS, "Discount in percentage field is enabled");
		}
		else
		{
			test.log(LogStatus.PASS, "Discount in percentage field is disabled");
		}
		Thread.sleep(1000);
		//Check the discount in amount is enable or not
		if(driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[6]/div/label/span")).isSelected())
		{
			test.log(LogStatus.PASS, "Discount in amount field is enabled");
		}
		else
		{
			test.log(LogStatus.PASS, "Discount in amount field is disabled");
		}
		
		Thread.sleep(3000);
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=92)
	public void Open_Check_Discount_method_deleteOrActiveDiscount_OpenCheck(WebDriver driver) throws Exception
	{
		Thread.sleep(10000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);Thread.sleep(3000);
				//Click the Active/InActive button
				driver.findElement(By.xpath("//a[@id='editOpen']/../a[2]")).click();				//Click the Yes button in the popup
				Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
			
				Thread.sleep(3000);
				//Check the menu item deleted/Activated or not
				if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Discount activated Successfully"))
				{
					test.log(LogStatus.PASS, "New discount Open Check is Activated Successfully");
				}
				else
				{
					test.log(LogStatus.PASS, "New discount Open Check is Inactivated Successfully");
				}

	}

	@Test(priority=93)
	public void Open_Check_Discount_method_cancelButton(WebDriver driver) throws Exception
	{
	
		Thread.sleep(3000);
		//Click edit button
		driver.findElement(By.id("editOpen")).click();
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='openDiscountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_OpenCheckPer")+"1");
		
		Thread.sleep(3000);
		//Click the update
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		//Check whether the Product Item canceled successfully or not
		if(driver.findElement(By.xpath("//a[.='Show open check discount']")).getText().equalsIgnoreCase("Show open check discount"))
		{
			test.log(LogStatus.PASS, "New discount Open Item(OpenCheckAmount) is canceled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New discount Open Item(OpenCheckAmount) is canceled Failed");
		}

		Thread.sleep(3000);

	}

	@Test(priority=101)
	public void Mix_And_Match_method_open_And_refreshMixandMatch(WebDriver driver) throws Exception
	{
/*		// Create instance of Java script executor
		JavascriptExecutor je1 = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element1 = driver.findElement(By.xpath("//span[.='Products/Items']"));
		//Scroll the page till the Reason option present
		je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
		//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Discounts']"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Discounts Option		
		driver.findElement(By.xpath("//span[.='Discounts']")).click();*/
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"mix_and_match/discount/list");
		Thread.sleep(5000);
		//Check Check based discount page opened or not
		if(driver.findElement(By.xpath("//span[.='Mix And Match']")).getText().equalsIgnoreCase("Mix And Match"))
		{
			test.log(LogStatus.PASS, "Mix And Match page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Mix And Match page loaded Failed");
		}

		
		Thread.sleep(8000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/a/i")).click();
		
		Thread.sleep(3000);
		//Check whether the Mix and Match was refreshed successfully or not
		if(driver.findElement(By.xpath("//a[.='Mix and match discounts']")).getText().equalsIgnoreCase("Mix and match discounts"))
		{
			test.log(LogStatus.PASS, "Mix and Match was refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Mix and Match was refreshed Failed");
		}

		Thread.sleep(3000);
	}

	@Test(priority=103)
	public void Mix_And_Match_method_addMixandMatch_ApplicableTimePeriodAsAlways(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(5000);
		//Click the Add new discount option
		driver.findElement(By.id("newDiscount")).click();Thread.sleep(2500);
		
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name    
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_MixAndMatch"));
		
		Thread.sleep(2000);
		//Enable or Disable the Coupon Only
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[2]/div/label/span")).click();
		
		//Click the Auto Discount button
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[3]/div/label/span")).click();
		
		Thread.sleep(3000);
		//Choose or Click the Category List box
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul")).click();
		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key from the keyboard
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Choose or Click the Menu Items List box
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key from the keyboard
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Select the Required Discount Type
		Select discountType = new Select(driver.findElement(By.xpath("//select[@name='discountCouponType']")));
		discountType.selectByVisibleText("Comp");
		
		//Click the Add symbol for Set Prize Option1
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[5]/div/div[1]/a/i")).click();
		//Clear the Quantity field
		driver.findElement(By.name("quantity")).clear();
		//Enter the Quantity
		driver.findElement(By.name("quantity")).sendKeys("200");
		//Clear the amount field
		driver.findElement(By.name("price")).clear();
		//Enter the amount for that item
		driver.findElement(By.name("price")).sendKeys("500");
		
		Thread.sleep(2000);
		//Click the Add symbol for Set Prize Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[5]/div/div[1]/a/i")).click();
		//Click the Close button of latest added option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[5]/div/div[4]/ng-form/div/div[3]/a/i")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);Thread.sleep(3000);
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Always");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Choose the Apply field
		//driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div[1]/div/select")).click();
		Thread.sleep(2000);
		//Select the any one tax from the give list
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("After Tax");
		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		
		//Click the Roles Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div[4]/div/div/ul")).click();
		//Enter the required Role
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div[4]/div/div/ul/li/input")).sendKeys("Driver");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Clear the Discount Code
		driver.findElement(By.name("discountCode")).clear();
		//Enter the Discount Code
		driver.findElement(By.name("discountCode")).sendKeys(Utility.getProperty("MixAndMatch_Discount_Code"));
		
		//Enable or Disable the isCustomer Attach
		driver.findElement(By.name("isCustomerAttach")).click();
		
		//Choose the required color
		driver.findElement(By.xpath("//div[@class='email-template-color color-swatch ng-scope'][6]")).click();
		
		Thread.sleep(2000);
		//Click the save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(2000);
		//Check whether the Mix and Match was saved successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Saved successfully"))
		{
			test.log(LogStatus.PASS, "Mix and Match saved Successfully for applicable time period as Always");
		}
		else
		{
			test.log(LogStatus.FAIL, "Mix and Match saved Failed for applicable time period as Always");
		}

		Thread.sleep(3000);
	}

	@Test(priority=104)
	public void Mix_And_Match_method_editMixandMatch(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_MixAndMatch")+"1");Thread.sleep(4000);
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);
		//Clear the Name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the Name
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_MixAndMatch")+"1");
		
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(3000);
		
		//Click the option as Set Each Item Price from the given option
		driver.findElement(By.xpath("//input[@name='isSetEachItemPrice']/../span")).click();
		
		//Select the Recquired Discount Type
		Select discountType = new Select(driver.findElement(By.xpath("//select[@name='discountCouponType']")));
		discountType.selectByVisibleText("Promo");
		
		//Click the Add symbol for Set Prize Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[5]/div/div[1]/a/i")).click();
		//Clear the Quantity field
		driver.findElement(By.name("quantity")).clear();
		//Enter the Quantity
		driver.findElement(By.name("quantity")).sendKeys("2");
		//Clear the amount field
		driver.findElement(By.name("price")).clear();
		//Enter the amount for that item
		driver.findElement(By.name("price")).sendKeys("500");
		Thread.sleep(1000);
		
		//Click the update
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(2000);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Mix and Match is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Mix and Match is updated Failed");
		}

		Thread.sleep(5000);
		
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_MixAndMatch")+"1");Thread.sleep(4000);
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);
		
		//Check weather name changes are updated or not
		if(driver.getPageSource().contains(Utility.getProperty("DiscountName_MixAndMatch")+"1"))
		{
			test.log(LogStatus.PASS, "Edited name is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Edits name is updated Failed");
		}
		Thread.sleep(5000);
		
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
	Thread.sleep(5000);	
				
	}
	
/*	@Test(priority=102)
	public void Mix_And_Match_method_pagination(WebDriver driver) throws InterruptedException
	{
		
			
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		//driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Pagination option as 10
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[2]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Mix and Match");
		//Create the web element for Mix and Match Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Mix and Match");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[3]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Mix and Match");
		//Create the web element for Mix and Match Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Mix and Match");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[4]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for Mix and Match");
		//Create the web element for Mix and Match Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Mix and Match");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[1]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Mix and Match");
		//Create the web element for Mix and Match Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Mix and Match");
		}
		Thread.sleep(8000);
	}
*/	
	@Test(priority=105)
	public void Mix_And_Match_method_deleteAndActivated_MixandMatch(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_MixAndMatch")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Delete button
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		//Check the menu item deleted or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Discount Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "New Mix and Match Item is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Mix and Match Item is deleted Failed");
		}

		Thread.sleep(6000);

		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		Thread.sleep(2000);
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the menu item activated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Discount activated Successfully"))
		{
			test.log(LogStatus.PASS, "New Mix and Match Item is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Mix and Match Item is activated Failed");
		}
		
		Thread.sleep(5000);
	}
	
	@Test(priority=106)
	public void Mix_And_Match_method_cancelButton(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Click the Add new discount option
		driver.findElement(By.id("newDiscount")).click();
		
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name    
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_MixAndMatch")+"11");
		
		Thread.sleep(3000);
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(3000);
		//Check whether the Mix and Match was cancel successfully or not
		if(driver.findElement(By.xpath("//a[.='Mix and match discounts']")).getText().equalsIgnoreCase("Mix and match discounts"))
		{
			test.log(LogStatus.PASS, "Mix and Match cancel Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Mix and Match cancel Failed");
		}

		Thread.sleep(5000);
	}

	@Test(priority=107)
	public void Mix_And_Match_method_editMixandMatch_ApplicableTimePeriodAsDaysofWeek(WebDriver driver) throws Exception
	{
		
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_MixAndMatch")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(3000);
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name    
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_MixAndMatch")+"20");
		
		Thread.sleep(2000);
		//Enable or Disable the Coupon Only
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[2]/div/label/span")).click();		
		
		Thread.sleep(3000);
		//Choose or Click the Category List box
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul")).click();
		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key from the keyboard
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Choose or Click the Menu Items List box
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key from the keyboard
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Clear the Quantity field
		driver.findElement(By.name("quantity")).clear();
		//Enter the Quantity
		driver.findElement(By.name("quantity")).sendKeys("100");
		//Clear the amount field
		driver.findElement(By.name("price")).clear();
		//Enter the amount for that item
		driver.findElement(By.name("price")).sendKeys("540");
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);Thread.sleep(4000);
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Days of Week");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Days of Week Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/div/ul")).click();
		//Enter the required DAY for Searching
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/div/ul/li/input")).sendKeys("WEDNESDAY");
		//Press the Enter key after enter the keyword
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Enable or disable the Restriction Time Period option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[3]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		//Choose the Apply field
		//driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div[1]/div/select")).click();
		Thread.sleep(2000);
		
		//Select the any one tax from the give list
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("After Tax");
		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		
		Thread.sleep(2000);
		//Enable or Disable the isCustomer Attach
		driver.findElement(By.name("isCustomerAttach")).click();
		
		
		Thread.sleep(3000);
		//Click the save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(4000);
		//Check whether the Mix and Match was saved successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "Mix and Match updated Successfully for applicable time period as Days of Week");
		}
		else
		{
			test.log(LogStatus.FAIL, "Mix and Match updated Failed for applicable time period as Days of Week");
		}

		Thread.sleep(3000);
	}
	
	@Test(priority=108)
	public void Mix_And_Match_method_editMixandMatch_ApplicableTimePeriodAsDaysOfMonth(WebDriver driver) throws Exception
	{
		
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_MixAndMatch")+"201");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);
		
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name    
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_MixAndMatch")+"21");
		
		Thread.sleep(2000);
		//Enable or Disable the Coupon Only
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[2]/div/label/span")).click();
			
		Thread.sleep(2000);
		//Choose or Click the Category List box
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul")).click();
		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).click();
		//Press the Enter Key from the keyboard
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Choose or Click the Menu Items List box
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).click();
		//Press the Enter Key from the keyboard
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		//Click the Set Each Item Price
		driver.findElement(By.xpath("//input[@name='isSetEachItemPrice']/../span")).click();
		Thread.sleep(1000);
		
		//Clear the Quantity field
		driver.findElement(By.name("quantity")).clear();
		//Enter the Quantity
		driver.findElement(By.name("quantity")).sendKeys("150");
		//Clear the amount field
		driver.findElement(By.name("price")).clear();
		//Enter the amount for that item
		driver.findElement(By.name("price")).sendKeys("400");
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);Thread.sleep(4000);
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Days of Month");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Required Date form the Calendar
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div/table/tbody/tr[2]/td[7]/button")).click();
		Thread.sleep(2000);
		
		//Enable or Disable the Restriction Months option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[3]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the months field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div/ul")).click();
		//Enter the Required month
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div/ul/li/input")).sendKeys("MAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Restriction Time option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		//Choose the Apply field
		//driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div[1]/div/select")).click();
		Thread.sleep(2000);
		//Select the any one tax from the give list
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("Before Tax");
		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
	
		//Enable or Disable the isCustomer Attach
		driver.findElement(By.name("isCustomerAttach")).click();
		
		for(int i=1; i<=5; i++){
			Thread.sleep(1000);
		//scroll the page 
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		Thread.sleep(3000);
		//Click the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		//Check whether the Mix and Match was updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "Mix and Match updated Successfully for applicable time period as Days of Month");
		}
		else
		{
			test.log(LogStatus.FAIL, "Mix and Match updated Failed for applicable time period as Days of Month");
			
		}

		Thread.sleep(3000);
	}
	
	@Test(priority=109)
	public void Mix_And_Match_method_editMixandMatch_ApplicableTimePeriodAsDateRange(WebDriver driver) throws Exception
	{
		
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_MixAndMatch")+"211");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);
		
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name    
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_MixAndMatch")+"22");
		
		Thread.sleep(3000);
		//Choose or Click the Category List box
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul")).click();
		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key from the keyboard
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Choose or Click the Menu Items List box
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key from the keyboard
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		//Click the Set Percentage Option
		driver.findElement(By.xpath("//input[@name='setPercentage']/../span")).click();
		
		Thread.sleep(2000);
		//Click the Add symbol for Set Prize Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[5]/div/div[1]/a/i")).click();

		
		Thread.sleep(1000);
		//Clear the Quantity field
		driver.findElement(By.name("quantity")).clear();
		//Enter the Quantity
		driver.findElement(By.name("quantity")).sendKeys("3");
		Thread.sleep(1000);
		//Clear the Discount Quantity field
		driver.findElement(By.name("discountQuantity")).clear();
		//Enter the Discount Quantity
		driver.findElement(By.name("discountQuantity")).sendKeys("2");
		Thread.sleep(1000);
		//Clear the Discount Percentage field
		driver.findElement(By.name("price")).clear();
		//Enter the Discount Percentage for that item
		driver.findElement(By.name("price")).sendKeys("250");
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);Thread.sleep(3000);
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Clear the From date field
		driver.findElement(By.name("fromDate")).clear();
		//Enter the required from Date
		driver.findElement(By.name("fromDate")).sendKeys("25-May-2050");
		//Clear the To Date field
		driver.findElement(By.name("endDate")).clear();
		//Enter the required To Date
		driver.findElement(By.name("endDate")).sendKeys("28-May-2050");

		//Enable or Disable the Restriction Days Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the Days of a Week option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul")).click();
		//Enter the Required Date
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Enable or Disable the Restriction Time option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[7]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		//Choose the Apply field
		//driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div[1]/div/select")).click();
		Thread.sleep(2000);
		//Select the any one tax from the give list
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("After Tax");
		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
	
		//Enable or Disable the isCustomer Attach
		driver.findElement(By.name("isCustomerAttach")).click();
		
		Thread.sleep(3000);
		//Click the save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(2000);
		//Check whether the Mix and Match was updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "Mix and Match updated Successfully for applicable time period as Date Range");
		}
		else
		{
			test.log(LogStatus.FAIL, "Mix and Match updated Failed for applicable time period as DAte Range");
		}

		Thread.sleep(3000);
	}
	
	@Test(priority=110)
	public void Mix_And_Match_method_editMixandMatch_ApplicableTimePeriodAsSpecificDate(WebDriver driver) throws Exception
	{
		
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_MixAndMatch")+"221");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);
		
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name    
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_MixAndMatch")+"23");
		
		Thread.sleep(3000);
		//Choose or Click the Category List box
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul")).click();
		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
/*		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
*/		//Press the Enter Key from the keyboard
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Choose or Click the Menu Items List box
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
/*		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
*/		//Press the Enter Key from the keyboard
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
/*		//Click the Set Percentage Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[3]/div/div[3]/label/span")).click();
		Thread.sleep(1000);*/
		
		//Click the Most Expensive option
		driver.findElement(By.xpath("//input[@name='mostExpensive']/../span")).click();
		Thread.sleep(2000);
		
/*		Thread.sleep(2000);
		//Click the Add symbol for Set Prize Option
		driver.findElement(By.xpath(//form[@name='discountForm']/div[1]/div[4]/div[5]/div/div[1]/a/i")).click();
		Thread.sleep(2000);
		
		//Clear the Quantity field
		driver.findElement(By.name("quantity")).clear();
		//Enter the Quantity
		driver.findElement(By.name("quantity")).sendKeys("3");
		Thread.sleep(1000);
		//Clear the Discount Quantity field
		driver.findElement(By.name("discountQuantity")).clear();
		//Enter the Discount Quantity
		driver.findElement(By.name("discountQuantity")).sendKeys("2");
		Thread.sleep(1000);
		//Clear the Discount Percentage field
		driver.findElement(By.name("price")).clear();
		//Enter the Discount Percentage for that item
		driver.findElement(By.name("price")).sendKeys("250");*/
		Thread.sleep(2000);

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);Thread.sleep(3000);
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Specific date");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Clear the Date field
		driver.findElement(By.name("date")).clear();
		//Enter the required date
		driver.findElement(By.name("date")).sendKeys("15-May-2050");
		
		//Enable or Disable the Restriction Time option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[3]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		//Choose the Apply field
		//driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[2]/div[1]/div/select")).click();
		Thread.sleep(2000);
		//Select the any one tax from the give list
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("After Tax");
		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		
		//Enable or Disable the isCustomer Attach
		driver.findElement(By.name("isCustomerAttach")).click();
		
		Thread.sleep(3000);
		//Click the save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(2000);
		//Check whether the Mix and Match was updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "Mix and Match updated Successfully for applicable time period as Specific Date");
		}
		else
		{
			test.log(LogStatus.FAIL, "Mix and Match updated Failed for applicable time period as Specific Date");
		}

		Thread.sleep(3000);
	}
	
	@Test(priority=111)
	public void Mix_And_Match_method_editMixandMatch_ApplicableTimePeriodAsStartDateTimeAndEndDateTime(WebDriver driver) throws Exception
	{
		
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("DiscountName_MixAndMatch")+"231");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);
		
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name    
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("DiscountName_MixAndMatch")+"24");
		
		Thread.sleep(2000);
		//Enable or Disable the Coupon Only
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[2]/div/label/span")).click();
		
		Thread.sleep(3000);
		//Choose or Click the Category List box
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul")).click();
		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
/*		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
*/		//Press the Enter Key from the keyboard
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[1]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Choose or Click the Menu Items List box
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul")).click();
		//Enter the required Menu Item
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
/*		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
*/		//Press the Enter Key from the keyboard
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Select the Recquired Discount Type
		Select discountType = new Select(driver.findElement(By.xpath("//select[@name='discountCouponType']")));
		discountType.selectByVisibleText("Donation");
		

		Thread.sleep(1000);
		//Click the Set Price option
		driver.findElement(By.xpath("//span[contains(.,'Set Price')]")).click();

		Thread.sleep(2000);
		//Click the Add symbol for Set Prize Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[1]/div[4]/div[5]/div/div[1]/a/i")).click();
		Thread.sleep(2000);
		
		Thread.sleep(3000);
		//Clear the Quantity field
		driver.findElement(By.name("quantity")).clear();
		//Enter the Quantity
		driver.findElement(By.name("quantity")).sendKeys("200");
		//Clear the amount field
		driver.findElement(By.name("price")).clear();
		//Enter the amount for that item
		driver.findElement(By.name("price")).sendKeys("500");
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);Thread.sleep(3000);
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys("Start date time & end date time");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Clear the From date field
		driver.findElement(By.name("fromDate")).clear();
		//Enter the required from Date
		driver.findElement(By.name("fromDate")).sendKeys("25-May-2050");
		//Clear the To Date field
		driver.findElement(By.name("endDate")).clear();
		//Enter the required To Date
		driver.findElement(By.name("endDate")).sendKeys("28-May-2050");
		
		//Enable or Disable the Restriction Days Option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[4]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the Days of a Week option
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul")).click();
		//Enter the Required Date
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='discountForm']/div[2]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		Thread.sleep(2000);
		//Select the any one tax from the give list
		Select applyDiscount = new Select(driver.findElement(By.name("adjustAmount")));
		applyDiscount.selectByVisibleText("After Tax");
		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		
		//Enable or Disable the isCustomer Attach
		driver.findElement(By.name("isCustomerAttach")).click();
		
		Thread.sleep(3000);
		//Click the save button
		driver.findElement(By.xpath("//span[.=' Update And Publish']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")));
		
//		Thread.sleep(7000);driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String s1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText();Thread.sleep(3000);
		//System.out.println("Required String  is : "+s1);
		//Check whether the Product Item updated successfully or not
		if(s1.equalsIgnoreCase("Updated and published successfully"))
		{
			test.log(LogStatus.PASS, "Mix and Match updated and published Successfully for applicable time period as Start Date Time And End Date Time");
		}
		else
		{
			test.log(LogStatus.FAIL, "Mix and Match updated and published Failed for applicable time period as Start Date Time And End Date Time");
		}

		Thread.sleep(3000);
	}

	@Test(priority=121)
	public void Upcharges_method_openUpchargesPage(WebDriver driver) throws Exception
	{
/*		//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Upcharges']"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Discounts Option		
		driver.findElement(By.xpath("//span[.='Upcharges']")).click();*/
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"upcharge/list");
		Thread.sleep(5000);
		//Check Up Charges page opened or not
		if(driver.findElement(By.xpath("//span[.='Up Charges']")).getText().equalsIgnoreCase("Up Charges"))
		{
			test.log(LogStatus.PASS, "Up Charges page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Up Charges page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=122)
	public void Upcharges_method_refreshUpchargesPage(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div/a/i")).click();
		Thread.sleep(5000);
		//Check Up charges page opened or not
		if(driver.findElement(By.xpath("//span[.='Up Charges']")).getText().equalsIgnoreCase("Up Charges"))
		{
			test.log(LogStatus.PASS, "Up Charges page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Up Charges page refreshed Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=124)
	public void Upcharges_method_addUpCharges_ApplicableTimePeriodAsAlways(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(5000);
		//Click the Add or new up charge button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div/button")).click();
		Thread.sleep(2000);
		//Check whether the new up charges form loaded or not
		if(driver.findElement(By.xpath("//h3[.='UpCharge']")).getText().equalsIgnoreCase("UpCharge"))
		{
			test.log(LogStatus.PASS, "New Up Charges page or form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Up Charges page or form loaded Failed");
		}
		
		Thread.sleep(3000);
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("UpChargeName_Category"));
		
		Thread.sleep(2000);
		//Select Level as a Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/a/div/b")).click();
		//Enter the Required Level
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys("Category");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Click the Category Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul")).click();
		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Choose the option as Percentage and amount option button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/div")).click();
		//Choose the percentage option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		//Enter the Up Charge Amount
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/input")).sendKeys("500");
		
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/a")).click();
		//Enter the required Applicable Time Period
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys("Always");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Enable the include Additional Modifier
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[7]/div/label/span")).click();
		
			Thread.sleep(2000);
		//Click the Roles option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[8]/div/div/ul")).click();
		//Enter the required role
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[8]/div/div/ul/li/input")).sendKeys("Driver");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[8]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(3500);
		
		//Check whether the new up charges form loaded or not
		if(driver.findElement(By.xpath("//span[.='Saved successfully']")).getText().equalsIgnoreCase("Saved successfully"))
		{
			test.log(LogStatus.PASS, "New Up Charges page saved Successfully for Applicable Time Period as Always");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Up Charges page saved Failed for Applicable Time Period as Always");
		}
		Thread.sleep(3000);
	
	}

/*	@Test(priority=123)
	public void Upcharges_method_pagination(WebDriver driver) throws InterruptedException
	{
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Pagination option as 10
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[2]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Upcharges");
		//Create the web element for Upcharges Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]"));
		for (WebElement result : results){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Upcharges");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[3]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Upcharges");
		//Create the web element for Upcharges Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Upcharges");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[4]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for Upcharges");
		//Create the web element for Upcharges Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Upcharges");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[1]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Upcharges");
		//Create the web element for Upcharges Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Upcharges");
		}
		Thread.sleep(8000);
	}
*/	
	@Test(priority=125)
	public void Upcharges_method_editUpCharges(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("UpChargeName_Category")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);
		
		//Clear the Name field
		driver.findElement(By.name("name")).clear();
		//Enter the Name
		driver.findElement(By.name("name")).sendKeys(Utility.getProperty("UpChargeName_Category")+"1");

		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(3000);
		//Click the update
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(3500);
		
		//Check whether the Upcharges updated successfully or not
		if(driver.findElement(By.xpath("//div[@role='alert']/span/span")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "Upcharge is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Upcharge is updated Failed");
		}

		Thread.sleep(5000);

	
	}
	
	@Test(priority=126)
	public void Upcharges_method_deleteUpCharges(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("UpChargeName_Category")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Delete button
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		//Check the menu item deleted or not
		if(driver.findElement(By.xpath("//span[.='Up-Charge Inactivated Successfully']")).getText().equalsIgnoreCase("Up-Charge Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "New UpChrages Item is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New UpChrages Item is deleted Failed");
		}

		Thread.sleep(5000);
	
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the menu item activated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Up-Charge activated Successfully"))
		{
			test.log(LogStatus.PASS, "New UpChrages Item is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New UpChrages Item is activated failed");
		}
	}
	
	@Test(priority=127)
	public void Upcharges_method_cancelButton(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Click the Add or new up charge button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div/button")).click();

		Thread.sleep(3000);
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("UpChargeName_Category"));
	
		Thread.sleep(3000);
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(3000);
		//Check whether the new up charges form loaded or not
		if(driver.findElement(By.xpath("//a[.='Up Charges']")).getText().equalsIgnoreCase("Up Charges"))
		{
			test.log(LogStatus.PASS, "New Up Charges page canceled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Up Charges page canceled Failed");
		}
		Thread.sleep(3000);
	
	}
	
	@Test(priority=128)
	public void Upcharges_method_editUpCharges_ApplicableTimePeriodAsDaysOfWeek(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("UpChargeName_Category")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);

		//Clear the name field
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("UpChargeName_Category")+"20");
		Thread.sleep(2000);
		
		//Select Level as a Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/a/div/b")).click();
		//Enter the Required Level
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys("Sub category");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		//Click the Category Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/ul")).click();

		//Enter the required Sub Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);			 
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Choose the option as Percentage and amount option button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/button")).click();
		//Choose the amount option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/ul/li[1]/a")).click();
		Thread.sleep(2000);
		//Clear the Upcharge amount field
		driver.findElement(By.name("offer")).clear();
		//Enter the Up Charge Amount
		driver.findElement(By.name("offer")).sendKeys("5000");
		
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[7]/div/div/a")).click();
		//Enter the required Applicable Time Period
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[7]/div/div/div/div/input")).sendKeys("Days of Week");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the DAy of a Week Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[8]/div/div/ul")).click();
		//Enter the Required Day
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[8]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[8]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Restriction Time check box
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[9]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//Check whether the Upcharges updated successfully or not
		if(driver.findElement(By.xpath("//span[.='Updated successfully']")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Up Charges page updated Successfully for Applicable Time Period as Days of week");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Up Charges page updated Failed for Applicable Time Period as Days of Week");
		}
		Thread.sleep(3000);
	
	}
	
	@Test(priority=129)
	public void Upcharges_method_editUpCharges_ApplicableTimePeriodAsDaysOfMonth(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("UpChargeName_Category")+"201");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);

		//Clear the name field
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("UpChargeName_Category")+"21");
		
		Thread.sleep(2000);
		//Select Level as a Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/a/div/b")).click();
		//Enter the Required Level
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys("Menu item");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Click the Category Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/ul")).click();
		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Choose the option as Percentage and amount option button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/button")).click();
		//Choose the percentage option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		//Clear the offer field
		driver.findElement(By.name("offer")).clear();
		//Enter the Up Charge Amount
		driver.findElement(By.name("offer")).sendKeys("5000");
		
		Thread.sleep(2000);
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[7]/div/div/a")).click();
		//Enter the required Applicable Time Period
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[7]/div/div/div/div/input")).sendKeys("Days of Month");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Required date from the calendar
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[8]/div/table/tbody/tr[2]/td[7]/button")).click();
		
		//Enable or Disable the Restriction Months
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[9]/div/label/span")).click();
		
		//Click the Months field
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul")).click();
		//Enter the Required month
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul/li/input")).sendKeys("MAY");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Restriction Time Period option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[11]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[12]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		//Enable the include Additional Modifier
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[13]/div/label/span")).click();
		Thread.sleep(2000);
		
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		//Check whether the Upcharges updated successfully or not
		if(driver.findElement(By.xpath("//span[.='Updated successfully']")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Up Charges page updated Successfully for Applicable Time Period as Days of Month");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Up Charges page updated Failed for Applicable Time Period as Days of Month");
		}
		Thread.sleep(3000);
	
	}
	
	@Test(priority=130)
	public void Upcharges_method_editUpCharges_ApplicableTimePeriodAsDateRange(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("UpChargeName_Category")+"211");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);

		//Clear the name field
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("UpChargeName_Category")+"22");
		
		Thread.sleep(2000);
		//Select Level as a Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/a/div/b")).click();
		//Enter the Required Level
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys("Category");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Click the Category Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul")).click();

		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Choose the option as Percentage and amount option button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/div")).click();
		//Choose the percentage option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		//Clear the amount field
		driver.findElement(By.name("offer")).clear();
		//Enter the Up Charge Amount
		driver.findElement(By.name("offer")).sendKeys("500");
		
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/a")).click();
		//Enter the required Applicable Time Period
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Clear the From date field
		driver.findElement(By.name("fromDate")).clear();
		//Enter the required from Date
		driver.findElement(By.name("fromDate")).sendKeys("25-May-2020");
		//Clear the To Date field
		driver.findElement(By.name("endDate")).clear();
		//Enter the required To Date
		driver.findElement(By.name("endDate")).sendKeys("28-May-2020");

		//Enable or Disable the Restriction Days Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[9]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the Days of a Week option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul")).click();
		//Enter the Required Date
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Enable or Disable the Restriction time period
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[11]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[12]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}

		//Enable the include Additional Modifier
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[13]/div/label/span")).click();
		Thread.sleep(2000);
	
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		//Check whether the Upcharges updated successfully or not
		if(driver.findElement(By.xpath("//div[@role='alert']/span/span")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Up Charges page updated Successfully for Applicable Time Period as Date Range");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Up Charges page updated Failed for Applicable Time Period as Date Range");
		}
		Thread.sleep(3000);
	
	}
	
	@Test(priority=131)
	public void Upcharges_method_editUpCharges_ApplicableTimePeriodAsSpecificDate(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("UpChargeName_Category")+"221");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);

		//Clear the name field
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("UpChargeName_Category")+"23");
		Thread.sleep(2000);
		
		//Select Level as a Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/a/div/b")).click();
		//Enter the Required Level
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys("Category");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Category Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul")).click();

		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Choose the option as Percentage and amount option button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/div")).click();
		//Choose the percentage option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		//Clear the upcharge amount field
		driver.findElement(By.name("offer")).clear();
		//Enter the Up Charge Amount
		driver.findElement(By.name("offer")).sendKeys("500");
		
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/a")).click();
		//Enter the required Applicable Time Period
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys("Specific date");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Clear the Date field
		driver.findElement(By.name("date")).click();
		//Enter the required date
		driver.findElement(By.name("date")).sendKeys("05-May-2020");
		
		//Enable or Disable the Restriction Time Period
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[8]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[9]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[9]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[9]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}

		//Enable the include Additional Modifier
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/label/span")).click();
		Thread.sleep(2000);
		
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3500);
		
		//Check whether the Upcharges updated successfully or not
		if(driver.findElement(By.xpath("//div[@role='alert']/span/span")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Up Charges page updated Successfully for Applicable Time Period as Specific Date");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Up Charges page updated Failed for Applicable Time Period as Specific Date");
		}
		Thread.sleep(3000);
	
	}
	
	@Test(priority=132)
	public void Upcharges_method_editUpCharges_ApplicableTimePeriodAsStartDateTimeAndEndDateTime(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("UpChargeName_Category")+"231");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);
		
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("UpChargeName_Category")+"24");
		
		Thread.sleep(2000);
		//Select Level as a Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/a/div/b")).click();
		//Enter the Required Level
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys("Category");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Category Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul")).click();
		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Choose the option as Percentage and amount option button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/div")).click();
		//Choose the percentage option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/div/ul/li[1]/a")).click();
		Thread.sleep(2000);
		//Clear the upcharge amount field
		driver.findElement(By.name("offer")).clear();
		//Enter the Up Charge Amount
		driver.findElement(By.name("offer")).sendKeys("5000");
		
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/a")).click();
		//Enter the required Applicable Time Period
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys("Start date time & end date time");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Clear the From date field
		driver.findElement(By.name("fromDate")).clear();
		//Enter the required from Date
		driver.findElement(By.name("fromDate")).sendKeys("25-May-2020");
		//Clear the To Date field
		driver.findElement(By.name("endDate")).clear();
		//Enter the required To Date
		driver.findElement(By.name("endDate")).sendKeys("28-May-2020");

		//Enable or Disable the Restriction Days
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[9]/div/label/span")).click();
		
		//Click the Days of Week Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul")).click();
		//Enter the required date from the given option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[11]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[11]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[11]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}

		driver.findElement(By.tagName("html")).sendKeys(Keys.END);Thread.sleep(3000);
		Thread.sleep(2000);
		
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3500);
		
		//Check whether the Upcharges updated successfully or not
		if(driver.findElement(By.xpath("//div[@role='alert']/span/span")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Up Charges page updated Successfully for Applicable Time Period as Start Date Time And End Date Time");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Up Charges page updated Failed for Applicable Time Period as Start Date Time And End Date Time");
		}
		Thread.sleep(3000);
	
	}

	@Test(priority=151)
	public void Retail_Item_Open_Retail_Item_Page(WebDriver driver) throws Exception
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
	public void Retail_Item_Refresh_Page(WebDriver driver) throws InterruptedException
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
	public void Retail_Item_Pagination(WebDriver driver) throws InterruptedException
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
	public void Retail_Item_add_Retail_Item(WebDriver driver) throws Exception
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
	public void Retail_Item_Edit_Retail_Item(WebDriver driver) throws Exception
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
	public void Retail_Item_Delete_Retail_Item(WebDriver driver) throws Exception
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
	public void Retail_Item_Add_RetailItem_By_Copy_RetailItem(WebDriver driver) throws Exception
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
	public void Retail_Item_cancelRetailItemByCopyRetailItem_MenuDetails(WebDriver driver) throws Exception
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
	public void Retail_Item_cancelRetailItemByCopyRetailItem_Inventory_Details(WebDriver driver) throws Exception
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
	public void Retail_Item_cancelRetailItemByCopyRetailItem_Childs(WebDriver driver) throws Exception
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
	public void Retail_Item_saveAndContinueRetailItemByCopyRetailItem(WebDriver driver) throws Exception
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
