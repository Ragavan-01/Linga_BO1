package epicList_Integrated;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Product_And_Item_1 {

	
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Product and Item 1");
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
	public void Department_method_openDepartments(WebDriver driver) throws Exception
	{
		Thread.sleep(15000);
		//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Departments']"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
		Thread.sleep(5000);
		//Click the Departments Option		
		driver.findElement(By.xpath("//span[.='Departments']")).click();
		Thread.sleep(5000);
		//Check Departments page opened or not
		if(driver.findElement(By.xpath("//a[.='Departments']")).getText().equalsIgnoreCase("Departments"))
		{
			test.log(LogStatus.PASS, "Departments page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Departments page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void Department_method_refreshDepartments_Page(WebDriver driver) throws InterruptedException
	{
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(8000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[1]/i")).click();
		Thread.sleep(5000);
		
		//Check Departments page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Departments"))
		{
			test.log(LogStatus.PASS, "Departments page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Departments page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=4)
	public void Department_method_add_Department(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(8000);
		//Click the Add department button
		driver.findElement(By.xpath("//button[@id='department']")).click();
		
		Thread.sleep(2000);
		//Check weather the new Department form loaded or not
		if(driver.findElement(By.xpath("//span[.='New Department']")).getText().equalsIgnoreCase("New Department"))
		{
			test.log(LogStatus.PASS, "New Department form Loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Department form Loaded Fail");
		}
		
		Thread.sleep(6000);
		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/input")).sendKeys(Utility.getProperty("Department_Name"));
		
		//Clear the description field
		driver.findElement(By.name("description")).clear();
		//Enter the required description field
		driver.findElement(By.name("description")).sendKeys("Department Description");
		
		//Clear the Department Code Option
		driver.findElement(By.name("departmentCode")).clear();
		//Enter the Department Code Option
		driver.findElement(By.name("departmentCode")).sendKeys(Utility.getProperty("Department_Code"));
		
		Thread.sleep(5000);
		//Click the save button
		driver.findElement(By.xpath("//button[@id='saveDepartment']")).click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.navigate().refresh();
		//Check weather the new department is saved or not
	//	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Department Saved Successfully"))
	//	{
		//	test.log(LogStatus.PASS, "New Department Saved successfully");
		//}
		//else
		//{
		//	test.log(LogStatus.FAIL, "New Department saved fail");
		//}
		Thread.sleep(5000);
		
	}
	
	@Test(priority=5)
	public void Department_method_edit_Department(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Department_Name")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(2000);
		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/input")).sendKeys(Utility.getProperty("Department_Name")+"1");

		//Clear the Department Code Option
		driver.findElement(By.name("departmentCode")).clear();
		//Enter the Department Code Option
		driver.findElement(By.name("departmentCode")).sendKeys(Utility.getProperty("Department_Code")+"1");

		
		Thread.sleep(1000);
		//Click the Update button
		driver.findElement(By.xpath("//button[@id='saveDepartment']")).click();
		
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.navigate().refresh();
		/////Check weather the new department is updated or not
		///if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Department Updated Successfully"))
		//{
		//	test.log(LogStatus.PASS, "New Department updated successfully");
		//}
		//else
		//{
		//	test.log(LogStatus.FAIL, "New Department updated fail");
		//}
		Thread.sleep(5000);
	}
	
	@Test(priority=6)
	public void Department_method_delete_Department(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Department_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check the menu item deleted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Department Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "New Department is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Department is deleted Failed");
		}
		Thread.sleep(3000);
		
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(5000);
		
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(5000);
		
		//Check the department activated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Department Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Department is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Department is activated Failed");
		}
		
		Thread.sleep(5000);		
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();

	}

	@Test(priority=7)
	public void Department_method_cancelDepartemnt(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Department_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(5000);
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		
		Thread.sleep(2000);
		//Check the department form is closed or not
		if(driver.findElement(By.xpath("//button[@id='department']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Department page is Closed after click the close button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Department page is displayed after click the close button");
		}
		
		Thread.sleep(5000);
	}
	
	@Test(priority=8)
	public void Department_method_inactiveAndActive_Button(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Active button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(1000);
		
		//Check the Page
		if(driver.findElement(By.cssSelector("i.fa.fa-check")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Inactive page is displayed after click the Active button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Inactive page is not displayed after click the Active button");
		}
		
		Thread.sleep(3000);
		//Click the InActive button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(1000);
		
		//Check the page
		if(driver.findElement(By.cssSelector("i.fa.fa-trash-o")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Active page is displayed after click the Inactive button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Active page is not displayed after click the Inactive button");
		}
		Thread.sleep(5000);
	}

	@Test(priority=21)
	public void Coursing_method_openCoursing(WebDriver driver) throws Exception
	{

		
		//Enter the Coursing URL
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"course");
		
		Thread.sleep(8000);
		//Check Coursing page opened or not
		if(driver.findElement(By.xpath("//a[.='Coursing']")).getText().equalsIgnoreCase("Coursing"))
		{
			test.log(LogStatus.PASS, "Coursing page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Coursing page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=22)
	public void Coursing_method_refreshCoursing_Page(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[1]/i")).click();
		Thread.sleep(5000);
		
		//Check Coursing page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Coursing"))
		{
			test.log(LogStatus.PASS, "Coursing page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Coursing page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=24)
	public void Coursing_method_add_Coursing(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(5000);
		//Click the Add coursing button
		driver.findElement(By.xpath("//button[@id='course']")).click();
		
		Thread.sleep(2000);
		//Check weather the new coursing form loaded or not
		if(driver.findElement(By.xpath("//span[.='New Coursing']")).getText().equalsIgnoreCase("New Coursing"))
		{
			test.log(LogStatus.PASS, "New Course form Loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Course form Loaded Fail");
		}
		
		Thread.sleep(6000);
		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/input")).sendKeys(Utility.getProperty("Coursing_Name"));
		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the required priority field
		driver.findElement(By.name("priority")).sendKeys("2");
		
		Thread.sleep(2000);
		//Click the save button
		driver.findElement(By.xpath("//button[@id='saveCourse']")).click();
		
		Thread.sleep(2000);
		//Check weather the new course is saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Course saved successfully"))
		{
			test.log(LogStatus.PASS, "New Course Saved successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Course saved fail");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=25)
	public void Coursing_method_edit_Coursing(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Coursing_Name")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(2000);
		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/input")).sendKeys(Utility.getProperty("Coursing_Name")+"1");

		Thread.sleep(1000);
		//Click the Update button
		driver.findElement(By.xpath("//button[@id='saveCourse']")).click();
		
		Thread.sleep(2000);
		//Check weather the new coursing is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Course updated successfully"))
		{
			test.log(LogStatus.PASS, "New Course updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Course updated fail");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=26)
	public void Coursing_method_delete_Coursing(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Coursing_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check the course	 deleted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Course inactivated successfully"))
		{
			test.log(LogStatus.PASS, "New Course is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Course is deleted Failed");
		}
		Thread.sleep(3000);
		
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(5000);
		
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the course activated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Course activated successfully"))
		{
			test.log(LogStatus.PASS, "Course is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Course is activated Failed");
		}
		
		Thread.sleep(5000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();

	}

	@Test(priority=27)
	public void Coursing_method_cancelCoursing(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Coursing_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(5000);
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		
		Thread.sleep(2000);
		//Check the course form is closed or not
		if(driver.findElement(By.xpath("//button[@id='course']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Course page is Closed after click the close button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Course page is displayed after click the close button");
		}
		
		Thread.sleep(5000);
	}
	
	@Test(priority=28)
	public void Coursing_method_inactiveAndActive_Button(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Active button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(1000);
		
		//Check the page
		if(driver.findElement(By.cssSelector("i.fa.fa-check")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Inactive page is displayed after click the Active button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Inactive page is not displayed after click the Active button");
		}
		
		Thread.sleep(3000);
		//Click the InActive button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(1000);
		
		//Check the page
		if(driver.findElement(By.cssSelector("i.fa.fa-trash-o")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Active page is displayed after click the Inactive button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Active page is not displayed after click the Inactive button");
		}
		Thread.sleep(5000);
	}

	@Test(priority=41)
	public void Serving_Size_Level_method_openServingSizeLevel(WebDriver driver) throws Exception
	{

		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"servingSizeLevel");
		Thread.sleep(5000);
		//Check Serving Size Level page opened or not
		if(driver.findElement(By.xpath("//a[.='Serving size levels']")).getText().equalsIgnoreCase("Serving size levels"))
		{
			test.log(LogStatus.PASS, "Serving Size Level page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Serving Size Level page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=42)
	public void Serving_Size_Level_method_refreshServingSizeLevel_Page(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[1]/i")).click();
		Thread.sleep(5000);
		
		//Check Coursing page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Serving Size Levels"))
		{
			test.log(LogStatus.PASS, "Serving Size Level page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Serving Size Level page loaded Failed");
		}
		Thread.sleep(3000);
	}

	@Test(priority=44)
	public void Serving_Size_Level_method_add_ServingSizeLevel(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		//Click the Add serving Size Level button
		driver.findElement(By.xpath("//button[@id='servingSizeLevel']")).click();
		
		Thread.sleep(2000);
		//Check weather the new Serving Size Level form loaded or not
		if(driver.findElement(By.xpath("//span[.='New Serving Size Level']")).getText().equalsIgnoreCase("New Serving Size Level"))
		{
			test.log(LogStatus.PASS, "New Serving Size Level form Loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Serving Size Level form Loaded Fail");
		}
		
		Thread.sleep(6000);
		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/input")).sendKeys(Utility.getProperty("ServingSizeLevel_Name"));
		
		//Clear the description field
		driver.findElement(By.name("description")).clear();
		//Enter the required description field
		driver.findElement(By.name("description")).sendKeys("New SSL Description");
		
		Thread.sleep(2000);
		//Click the save button
		driver.findElement(By.xpath("//button[@id='saveSSl']")).click();
		
		Thread.sleep(2000);
		//Check weather the new SSL is saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Serving size level saved successfully"))
		{
			test.log(LogStatus.PASS, "New Serving Size Level Saved successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Serving Size Level saved fail");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=45)
	public void Serving_Size_Level_method_edit_ServingSizeLevel(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("ServingSizeLevel_Name")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(2000);
		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/input")).sendKeys(Utility.getProperty("ServingSizeLevel_Name")+"1");

		Thread.sleep(1000);
		//Click the Update button
		driver.findElement(By.xpath("//button[@id='saveSSl']")).click();
		
		Thread.sleep(2000);
		//Check weather the new Serving Size Level is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Serving-size level updated successfully"))
		{
			test.log(LogStatus.PASS, "New Serving Size Level is updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Serving Size Level is updated fail");
		}
		Thread.sleep(5000);
	}
		
	@Test(priority=46)
	public void Serving_Size_Level_method_delete_ServingSizeLevel(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("ServingSizeLevel_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		Thread.sleep(2000);
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check the Serving Size Level deleted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Serving-size level inactivated successfully"))
		{
			test.log(LogStatus.PASS, "New Serving Size Level is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Serving Size Level is deleted Failed");
		}
		Thread.sleep(5000);
		
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the Serving Size Level activated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Serving-size level activated successfully"))
		{
			test.log(LogStatus.PASS, "Serving Size Level is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Serving Size Level is activated Failed");
		}
		
		Thread.sleep(5000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=47)
	public void Serving_Size_Level_method_cancelCoursing(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("ServingSizeLevel_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(5000);
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		
		Thread.sleep(2000);
		//Check the serving size level form is closed or not
		if(driver.findElement(By.xpath("//button[@id='servingSizeLevel']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Serving Size Level page is Closed after click the close button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Serving Size Level page is displayed after click the close button");
		}
		
		Thread.sleep(5000);
	}
	
	@Test(priority=48)
	public void Serving_Size_Level_method_inactiveAndActive_Button(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Active button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(1000);
		
		//Check the page
		if(driver.findElement(By.cssSelector("i.fa.fa-check")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Inactive page is displayed after click the Active button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Inactive page is not displayed after click the Active button");
		}
		
		Thread.sleep(3000);
		//Click the InActive button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(1000);
		
		//Check the page
		if(driver.findElement(By.cssSelector("i.fa.fa-trash-o")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Active page is displayed after click the Inactive button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Active page is not displayed after click the Inactive button");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=61)
	public void Tax_method_openTax_Page(WebDriver driver) throws Exception
	{
/*		//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Taxes']"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Taxes Option		
		driver.findElement(By.xpath("//span[.='Taxes']")).click();*/
		//driver.get(Utility.getURLProperty("PAI_Taxes"));
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"tax");

		Thread.sleep(5000);
		//Check tax page opened or not
		if(driver.findElement(By.xpath("//a[.='Taxes']")).getText().equalsIgnoreCase("Taxes"))
		{
			test.log(LogStatus.PASS, "Taxes page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Taxes page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=62)
	public void Tax_method_refreshTax_Page(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[1]/i")).click();
		Thread.sleep(5000);
		
		//Check Taxes page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/div/h3")).getText().equalsIgnoreCase("Taxes"))
		{
			test.log(LogStatus.PASS, "Taxes page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Taxes page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=64)
	public void Tax_method_add_Tax(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Click the Add Tax button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/button")).click();
		
		Thread.sleep(2000);
		//Check weather the new Tax form loaded or not
		if(driver.findElement(By.xpath("//span[.='New Tax']")).getText().equalsIgnoreCase("New Tax"))
		{
			test.log(LogStatus.PASS, "New Tax form Loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax form Loaded Fail");
		}
		
		Thread.sleep(2000);
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[1]/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[1]/input")).sendKeys(Utility.getProperty("Tax_Name"));
		
		Thread.sleep(5000);
		//Select the required Apply To option
		Select applyTo = new Select(driver.findElement(By.name("applyTo")));
		applyTo.selectByValue("Item");
		

		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Enable or Disable the Default Tax
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[3]/label/span")).click();
		
		Thread.sleep(3000);
		//Enable or Disable the Inclusive Tax
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[5]/label/span")).click();

		
		//Clear the percentage field
		driver.findElement(By.name("percentage")).clear();
		//Enter the required percentage field
		driver.findElement(By.name("percentage")).sendKeys("1112");
		
		//Clear the Tax Code
		driver.findElement(By.xpath("//input[@name='taxCode']")).clear();
		//Enter the Tax Code
		driver.findElement(By.xpath("//input[@name='taxCode']")).sendKeys(Utility.getProperty("Tax_Code"));
		
		Thread.sleep(2000);
		//Click the save button
		driver.findElement(By.xpath("//button[@id='saveTax']")).click();
		
		Thread.sleep(2000);
		//Check weather the new Tax is saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Tax saved successfully"))
		{
			test.log(LogStatus.PASS, "New Tax Saved successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax saved fail");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=65)
	public void Tax_method_edit_Tax_Item(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();Thread.sleep(2000);
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Tax_Name")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(2000);
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[1]/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[1]/input")).sendKeys(Utility.getProperty("Tax_Name")+"1");

		Thread.sleep(3000);
		//Enable or Disable the Default Tax
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[3]/label/span")).click();
					
		//Enable or Disable the Inclusive Tax
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[5]/label/span")).click();

		//Enable or Disable the Quantity Tax
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[4]/label/span")).click();

		//Click the Add Set Percentage option
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[5]/div[1]/div/a/i")).click();
		
		Thread.sleep(2000);
		//Clear the quantity field
		driver.findElement(By.name("quantity")).clear();
		//Enter the required Quantity
		driver.findElement(By.name("quantity")).sendKeys("3");
		
		//Clear the price field
		driver.findElement(By.name("price")).clear();
		//Enter the required price
		driver.findElement(By.name("price")).sendKeys("1450");
		
		Thread.sleep(3000);
		//Click the Add Set Percentage option
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[5]/div[1]/div/a/i")).click();

		Thread.sleep(3000);
		//Click the Close button of Last Set percentage option
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[5]/div[4]/ng-form/div/div[3]/a/i")).click();
		
		Thread.sleep(1000);
		//Click the Yes button in the popup
		driver.findElement(By.linkText("Yes")).click();
		
		Thread.sleep(1000);
		//Click the Update button
		driver.findElement(By.xpath("//button[@id='saveTax']")).click();
		
		Thread.sleep(2000);
		//Check weather the new Tax is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Tax updated successfully"))
		{
			test.log(LogStatus.PASS, "New Tax updated successfully for Item");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax updated fail for Item");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=66)
	public void Tax_method_edit_Tax_Check(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();Thread.sleep(2000);
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Tax_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();

		Thread.sleep(3000);
		//Select the required Apply To option
		Select applyTo = new Select(driver.findElement(By.name("applyTo")));
		applyTo.selectByVisibleText("CHECK");

		Thread.sleep(2000);
		//Enable or Disable the Apply on Total
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[3]/label/span")).click();
					
		Thread.sleep(2000);
		//Clear the check amount field
		driver.findElement(By.name("amount")).clear();
		//Enter the required check amount
		driver.findElement(By.name("amount")).sendKeys("155");
		
		//Clear the percentage field
		driver.findElement(By.name("percentage")).clear();
		//Enter the required percentage
		driver.findElement(By.name("percentage")).sendKeys("1450");
		
		Thread.sleep(1000);
		//Click the Update button
		driver.findElement(By.xpath("//button[@id='saveTax']")).click();
		
		Thread.sleep(2000);
		//Check weather the new Tax is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Tax updated successfully"))
		{
			test.log(LogStatus.PASS, "New Tax updated successfully for Check");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax updated fail for Check");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=67)
	public void Tax_method_edit_Tax_TaxOnItemTax(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();Thread.sleep(2000);
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Tax_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();

		Thread.sleep(3000);
		//Select the required Apply To option
		Select applyTo = new Select(driver.findElement(By.name("applyTo")));
		applyTo.selectByVisibleText("Tax On Item Tax");

		Thread.sleep(2000);
		//Clear the percentage field
		driver.findElement(By.name("percentage")).clear();
		//Enter the required percentage
		driver.findElement(By.name("percentage")).sendKeys("1450");
		
		Thread.sleep(2000);
		//Click the Apply For option
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[5]/div/ul")).click();
		//Enter the required apply for option
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[5]/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the enter button
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[5]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Update button
		driver.findElement(By.xpath("//button[@id='saveTax']")).click();
		
		Thread.sleep(2000);
		//Check weather the new Tax is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Tax updated successfully"))
		{
			test.log(LogStatus.PASS, "New Tax updated successfully for Tax On Item Tax");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax updated fail Tax On Item Tax");
		}
		Thread.sleep(5000);
	}

	@Test(priority=68)
	public void Tax_method_edit_Tax_TaxOnCheckTax(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();Thread.sleep(2000);
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Tax_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();

		Thread.sleep(3000);
		//Select the required Apply To option
		Select applyTo = new Select(driver.findElement(By.name("applyTo")));
		applyTo.selectByVisibleText("Tax On Check Tax");

		Thread.sleep(2000);
		//Clear the percentage field
		driver.findElement(By.name("percentage")).clear();
		//Enter the required percentage
		driver.findElement(By.name("percentage")).sendKeys("1450");
		
		Thread.sleep(2000);
		//Click the Apply For option
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[5]/div/ul")).click();
		
		//Enter the required apply for option
		//driver.findElement(By.xpath("//form[@name='taxCreation']/div[4]/div/ul/li/input")).sendKeys("Default");
		
		//Press the enter button
		driver.findElement(By.xpath("//form[@name='taxCreation']/div[5]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		//Click the Update button
		driver.findElement(By.xpath("//button[@id='saveTax']")).click();
		
		Thread.sleep(2000);
		//Check weather the new Tax is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Tax updated successfully"))
		{
			test.log(LogStatus.PASS, "New Tax updated successfully Tax On Check Tax");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax updated fail Tax On Check Tax");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=69)
	public void Tax_method_delete_Tax(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();Thread.sleep(2000);
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Tax_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(3000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		//Click the Yes button in the popup
		driver.findElement(By.linkText("Yes")).click();
		
		Thread.sleep(3000);
		//Check the Tax deleted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Tax Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "New Tax is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax is deleted Failed");
		}
		
		Thread.sleep(3000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		//Click the success button
		driver.findElement(By.cssSelector("i.fa.fa-check")).click();
		
		
		Thread.sleep(3000);
		//Click the Yes button in the popup
		driver.findElement(By.linkText("Yes")).click();
		
		Thread.sleep(3000);
		//Check the course activated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Tax Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Tax is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax is activated Failed");
		}
		
		Thread.sleep(5000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[2]/div[1]/div[1]/input")).click();

	}
	
	@Test(priority=70)
	public void Tax_method_cancelTax(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();Thread.sleep(2000);
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Tax_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(3000);
		//Click the Edit button
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(5000);
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		
		Thread.sleep(2000);
		//Check the Tax form is closed or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/button")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Tax page is Closed after click the close button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax page is displayed after click the close button");
		}
		
		Thread.sleep(5000);
	}
	
	@Test(priority=71)
	public void Tax_method_inactiveAndActive_Button(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();Thread.sleep(2000);
		Thread.sleep(1000);
		
		//Click the Active button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(1000);
		
		//Check the page
		if(driver.findElement(By.cssSelector("i.fa.fa-check")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Inactive page is displayed after click the Active button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Inactive page is not displayed after click the Active button");
		}
		
		Thread.sleep(3000);
		//Click the InActive button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		
		//Check the page
		if(driver.findElement(By.cssSelector("i.fa.fa-trash-o")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Active page is displayed after click the Inactive button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Active page is not displayed after click the Inactive button");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=81)
	public void Category_method_openCategory_Page(WebDriver driver) throws Exception
	{

		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"categories/1");
		Thread.sleep(5000);
		//Check Categories page opened or not
		if(driver.findElement(By.xpath("//a[.='Categories']")).getText().equalsIgnoreCase("Categories"))
		{
			test.log(LogStatus.PASS, "Categories page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Categories page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=82)
	public void Category_method_refreshCategory_Page(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/span[1]/a/i")).click();
		Thread.sleep(5000);
		
		//Check Categories page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[1]/h3/span")).getText().equalsIgnoreCase("Categories"))
		{
			test.log(LogStatus.PASS, "Category page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Category page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=84)
	public void Category_method_add_Category(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		//Click the Add category button
		driver.findElement(By.xpath("//a[@id='category']")).click();
		
		Thread.sleep(2000);
		//Check weather the New Category form loaded or not
		if(driver.findElement(By.xpath("//span[.='New Category']")).getText().equalsIgnoreCase("New Category"))
		{
			test.log(LogStatus.PASS, "New Category form Loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Category form Loaded Fail");
		}
		
		Thread.sleep(6000);
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div/div/div/input[@name='name']")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='categoryForm']/div/div/div/input[@name='name']")).sendKeys(Utility.getProperty("Category_Name"));
		
		//Click the Add Department button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[1]/div[2]/a/i")).click();
		
		Thread.sleep(2000);
		//Check weather the new department form loaded or not
		if(driver.findElement(By.xpath("//span[.='New department']")).getText().equalsIgnoreCase("New department"))
		{
			test.log(LogStatus.PASS, "New department form loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New department form loaded fail");
		}
		
		Thread.sleep(2000);
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='catDependForm']/div/div/input[@name='name']")).clear();
		//Enter the department name 
		driver.findElement(By.xpath("//form[@name='catDependForm']/div/div/input[@name='name']")).sendKeys(Utility.getProperty("Category_Add_Dept_Name"));
		
		//Clear the description field
		driver.findElement(By.name("description")).clear();
		//Enter the required description field
		driver.findElement(By.name("description")).sendKeys("New Department Description");
		
		Thread.sleep(1000);
		//Click the Save button
		driver.findElement(By.xpath("//form[@name='catDependForm']/div[3]/div/div/button")).click();
		
		Thread.sleep(2000);
		//click the role button option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[2]/div/div/ul")).click();
		//Enter the required role
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[2]/div/div/ul/li/input")).sendKeys("Driver");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Click the Add Coursing button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[3]/div[2]/a/i")).click();
		
		Thread.sleep(2000);
		//Check weather the new coursing form loaded or not
		if(driver.findElement(By.xpath("//span[.='New Coursing']")).getText().equalsIgnoreCase("New Coursing"))
		{
			test.log(LogStatus.PASS, "New coursing form loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New coursing form loaded fail");
		}
		
		Thread.sleep(2000);
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='catDependForm']/div/div/input[@name='name']")).clear();
		//Enter the course name 
		driver.findElement(By.xpath("//form[@name='catDependForm']/div/div/input[@name='name']")).sendKeys(Utility.getProperty("Category_Add_Course_Name"));
		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the required priority field
		driver.findElement(By.name("priority")).sendKeys("3");
		
		Thread.sleep(1000);
		//Click the Save button
		driver.findElement(By.xpath("//form[@name='catDependForm']/div[3]/div/div/button")).click();

		Thread.sleep(3000);
		//Click the Serving Size Level Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[4]/div/div/ul")).click();
		//Enter the required serving size level
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Click the Tare group Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[5]/div/div/a")).click();
		//Enter the required tare group
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[5]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);

		if(driver.findElement(By.xpath("//select[@name='defaultTare']")).isEnabled())
		{
			Thread.sleep(3000);
			//Click the default tare Option
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[6]/div/div/a")).click();
			//Enter the default tare
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
			//Press the Enter Key
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		}
		
		Thread.sleep(2000);
		//Enable or Disable the Hide in POS option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[7]/div/input")).click();
		
		Thread.sleep(2000);
		//Enable or Disable the Hide in ZenPepper option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[8]/div/input")).click();

		Thread.sleep(2000);
		//Enable or Disable the Is Conventional option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[9]/div/input")).click();

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		
		Thread.sleep(2000);
		//Enable or Disable the Tax option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[1]/div[1]/input")).click();
		
		Thread.sleep(2000);
		//Enable or Disable the Kitchen Printers option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[1]/div[2]/input")).click();

		Thread.sleep(2000);
		//Enable or Disable the Label Printers option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[1]/div[3]/input")).click();
		
		Thread.sleep(2000);
		//Enable or Disable the Restrict Printers option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[1]/div[4]/input")).click();

		Thread.sleep(2000);
		//Click the Add Tax button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[2]/div[2]/a/i")).click();
		
		Thread.sleep(2000);
		//Check weather the new tax form loaded or not
		if(driver.findElement(By.xpath("//span[.='New tax']")).getText().equalsIgnoreCase("New Tax"))
		{
			test.log(LogStatus.PASS, "New Tax form loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax form loaded fail");
		}
		
		Thread.sleep(2000);
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='catDependForm']/div/div/input[@name='name']")).clear();
		//Enter the tax name 
		driver.findElement(By.xpath("//form[@name='catDependForm']/div/div/input[@name='name']")).sendKeys(Utility.getProperty("Category_Add_Tax_Name"));
		
		
		Thread.sleep(2000);
		//Enable or Disable the Default Tax option
		//driver.findElement(By.xpath("//form[@name='catDependForm']/div[2]/div[1]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Enable or Disable the Inclusive option
		//driver.findElement(By.xpath("//form[@name='catDependForm']/div[2]/div[2]/div/label/span")).click();
		
		//Clear the percentage field
		driver.findElement(By.name("percentage")).clear();
		//Enter the required percentage field
		driver.findElement(By.name("percentage")).sendKeys("1230");
		
		Thread.sleep(1000);
		//Click the Save button
		driver.findElement(By.xpath("//form[@name='catDependForm']/div[3]/div/div/button")).click();

		Thread.sleep(3000);
		//Click the Kitchen Printers Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[3]/div/div/ul")).click();
		//Enter the required Kitchen Printers
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[3]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[3]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Click the Label Printers Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[4]/div/div/ul")).click();
		//Enter the required Label Printers
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		//Click the Restrict Printers Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[5]/div/div/ul")).click();
		//Enter the Restrict Printers
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys("BarTab");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(5000);
		//Select the image from disk
		driver.findElement(By.xpath("//input[@id='categoryImage']")).sendKeys(Utility.getProperty("Settings_Store_Information_Store_Image_Path"));
		
		Thread.sleep(5000);
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/a")).click();
		//Enter the required time period
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys("Always");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		//Click the save button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[3]/div/div/button")).click();
		
		Thread.sleep(2000);
		//Check weather the new course is saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Category saved successfully"))
		{
			test.log(LogStatus.PASS, "New Category Saved successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Category saved fail");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=85)
	public void Category_method_edit_Category_DaysOfWeek(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Category_Name")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(10000);
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div/div/div/input[@name='name']")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='categoryForm']/div/div/div/input[@name='name']")).sendKeys(Utility.getProperty("Category_Name")+"1");
		
		Thread.sleep(3000);
		//Click the Department Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[1]/div[1]/div/a")).click();
		//Enter the Department
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		//Click the Coursing Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[3]/div[1]/div/a")).click();
		//Enter the Coursing
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[3]/div[1]/div/div/div/input")).sendKeys("ENTREE");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[3]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		//Enable or Disable the Hide in POS option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[7]/div/input")).click();

		Thread.sleep(2000);
		//Enable or Disable the Hide in Zen pepper option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[8]/div/input")).click();
		
		Thread.sleep(2000);
		//Enable or Disable the is conventional option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[9]/div/input")).click();

		Thread.sleep(2000);
		//Enable or Disable the Tax option
		//driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[1]/div[1]/input")).click();
		
		Thread.sleep(2000);
		//Enable or Disable the Kitchen Printers option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[1]/div[2]/input")).click();

		Thread.sleep(2000);
		//Enable or Disable the Label Printers option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[1]/div[3]/input")).click();
		

		Thread.sleep(5000);
		//Click the Select image from gallery option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[6]/div/div/div[2]/div[2]/a[1]/i")).click();
		Thread.sleep(15000);
		//Click the required image from the option
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/form/div[2]/div/div/div[3]/div[1]/a/img")).click();
		Thread.sleep(3000);
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys("Days of Week");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Days of Week Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[8]/div/div/ul")).click();
		//Enter the required DAY for Searching
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[8]/div/div/ul/li/input")).sendKeys("WEDNESDAY");
		//Press the Enter key after enter the keyword
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[8]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Enable or disable the Restriction Time Period option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[9]/div/label/span")).click();
		Thread.sleep(2000);
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}


		Thread.sleep(3000);
		//Click the Update button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[3]/div/div/button")).click();
		
		Thread.sleep(2000);
		//Check weather the new category is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Category updated successfully"))
		{
			test.log(LogStatus.PASS, "New Category updated successfully for Days of Week");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Category updated fail for Days of Week");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=86)
	public void Category_method_edit_Category_DaysOfMonth(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Category_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();	

		Thread.sleep(2000);
		//Enable or Disable the Restrict Printers option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[1]/div[4]/input")).click();
		
		Thread.sleep(3000);
		//Click the Close Option in restrict printers option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[5]/div/div/ul/li/a")).click();
		

		Thread.sleep(3000);
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys("Days of Month");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Required Date form the Calendar
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[8]/div/table/tbody/tr[2]/td[7]/button")).click();
		Thread.sleep(2000);
		
		//Enable or Disable the Restriction Months option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[9]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the months field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div/ul")).click();
		//Enter the Required month
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div/ul/li/input")).sendKeys("MAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Restriction Time option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[11]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[12]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		Thread.sleep(3000);

		//Click the Update button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[3]/div/div/button")).click();
		
		Thread.sleep(2000);
		//Check weather the new category is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Category updated successfully"))
		{
			test.log(LogStatus.PASS, "New Category updated successfully for Days of Month");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Category updated fail for Days of Month");
		}
		Thread.sleep(5000);
	}

	@Test(priority=87)
	public void Category_method_edit_Category_DateRange(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Category_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();	

		Thread.sleep(3000);
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
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
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the Days of a Week option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[11]/div/div/ul")).click();
		//Enter the Required Date
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[11]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[11]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Enable or Disable the Restriction Time option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[12]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[13]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[13]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[13]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}

		
		Thread.sleep(3000);

		//Click the Update button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[3]/div/div/button")).click();
		
		Thread.sleep(2000);
		//Check weather the new category is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Category updated successfully"))
		{
			test.log(LogStatus.PASS, "New Category updated successfully for Date Range");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Category updated fail for Date Range");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=88)
	public void Category_method_edit_Category_SpecificDate(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Category_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();	

		Thread.sleep(3000);
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys("Specific date");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Clear the Date field
		driver.findElement(By.name("date")).clear();
		//Enter the required date
		driver.findElement(By.name("date")).sendKeys("15-May-2040");
		
		//Enable or Disable the Restriction Time option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[9]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}

		
		Thread.sleep(3000);

		//Click the Update button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[3]/div/div/button")).click();
		
		Thread.sleep(2000);
		//Check weather the new category is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Category updated successfully"))
		{
			test.log(LogStatus.PASS, "New Category updated successfully for Specific Date");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Category updated fail for Specific Date");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=89)
	public void Category_method_edit_Category_StartDateAndEndDate(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Category_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();	

		Thread.sleep(3000);
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys("Start date time & end date time");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
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
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the Days of a Week option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[11]/div/div/ul")).click();
		//Enter the Required Date
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[11]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[11]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[12]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}


		
		Thread.sleep(3000);

		//Click the Update button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[3]/div/div/button")).click();
		
		Thread.sleep(2000);
		//Check weather the new category is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Category updated successfully"))
		{
			test.log(LogStatus.PASS, "New Category updated successfully for Start Date and End Date");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Category updated fail for Start Date and End Date");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=90)
	public void Category_method_delete_Category(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Category_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check the course	 deleted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Category inactivated successfully"))
		{
			test.log(LogStatus.PASS, "New Category is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Category is deleted Failed");
		}
		Thread.sleep(3000);
		
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the course activated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Category activated successfully"))
		{
			test.log(LogStatus.PASS, "Category is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Category is activated Failed");
		}
		
		Thread.sleep(5000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
	}

	@Test(priority=91)
	public void Category_method_cancelCategory(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Category_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(5000);
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		
		Thread.sleep(2000);
		//Check the course form is closed or not
		if(driver.findElement(By.xpath("//a[.='Categories']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Category page is Closed after click the close button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Category page is displayed after click the close button");
		}
		
		Thread.sleep(5000);
	}
	
	@Test(priority=92)
	public void Category_method_inactiveAndActive_Button(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Active button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(1000);
		
		//Check the page
		if(driver.findElement(By.cssSelector("i.fa.fa-check")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Inactive page is displayed after click the Active button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Inactive page is not displayed after click the Active button");
		}
		
		Thread.sleep(3000);
		//Click the InActive button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(1000);
		
		//Check the page
		if(driver.findElement(By.cssSelector("i.fa.fa-trash-o")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Active page is displayed after click the Inactive button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Active page is not displayed after click the Inactive button");
		}
		Thread.sleep(5000);
	}

	@Test(priority=101)
	public void Subcategory_method_openSubCategory_Page(WebDriver driver) throws Exception
	{

		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"categories/2");
		Thread.sleep(5000);
		//Check Sub Categories page opened or not
		if(driver.findElement(By.xpath("//a[.='Sub Categories']")).getText().equalsIgnoreCase("Sub Categories"))
		{
			test.log(LogStatus.PASS, "Sub Categories page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Categories page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=102)
	public void Subcategory_method_refreshCategory_Page(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/span[1]/a/i")).click();
		Thread.sleep(5000);
		
		//Check Sub Categories page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[1]/h3/span")).getText().equalsIgnoreCase("Sub Categories"))
		{
			test.log(LogStatus.PASS, "Sub Category page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Category page loaded Failed");
		}
		Thread.sleep(3000);
	}

	@Test(priority=104)
	public void Subcategory_method_add_SubCategory(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		//Click the Add sub category button
		driver.findElement(By.xpath("//a[@id='SubCategory']")).click();
		
		Thread.sleep(2000);
		//Check weather the New Sub Category form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW SUB CATEGORY']")).getText().equalsIgnoreCase("NEW SUB CATEGORY"))
		{
			test.log(LogStatus.PASS, "New Sub Category form Loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Sub Category form Loaded Fail");
		}
		
		Thread.sleep(8000);
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("Sub_Category_Name"));
		
		Thread.sleep(3000);
		//Click the Coursing Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[1]/div[1]/div/a")).click();
		//Click the input filed of Coursing
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[1]/div[1]/div/div/div/input")).click();
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Category option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[2]/div/div/a")).click();
		//Enter the Category
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[2]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
		Thread.sleep(3000);
		//Click the Tare group Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[5]/div/div/a")).click();
		//Enter the required tare group
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[5]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);

		if(driver.findElement(By.xpath("//select[@name='defaultTare']")).isEnabled())
		{
			Thread.sleep(3000);
			//Click the default tare Option
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[6]/div/div/a")).click();
			//Enter the default tare
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
			//Press the Enter Key
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		}
		
		Thread.sleep(2000);
		//Enable or Disable the Hide in POS option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[7]/div/input")).click();
		
		Thread.sleep(2000);
		//Enable or Disable the Hide in ZenPepper option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[8]/div/input")).click();

		Thread.sleep(2000);
		//Enable or Disable the Tax option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[1]/div[1]/input")).click();
		
		Thread.sleep(2000);
		//Enable or Disable the Kitchen Printers option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[1]/div[2]/input")).click();

		Thread.sleep(2000);
		//Enable or Disable the Label Printers option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[1]/div[3]/input")).click();
		
		Thread.sleep(2000);
		//Enable or Disable the Restrict Printers option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[1]/div[4]/input")).click();

		Thread.sleep(2000);
		//Click the Add Tax button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[2]/div[2]/a/i")).click();
		
		Thread.sleep(2000);
		//Check weather the new tax form loaded or not
		if(driver.findElement(By.xpath("//span[.='New tax']")).getText().equalsIgnoreCase("New Tax"))
		{
			test.log(LogStatus.PASS, "New Tax form loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax form loaded fail");
		}
		
		Thread.sleep(2000);
		//Clear the name field
		driver.findElement(By.xpath("//input[@name='name']")).clear();
		//Enter the tax name 
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Utility.getProperty("Sub_Category_Add_Tax_Name"));
		
		
		Thread.sleep(2000);
		//Enable or Disable the Default Tax option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[2]/div[1]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Enable or Disable the Inclusive option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[2]/div[2]/div/label/span")).click();
		
		//Clear the percentage field
		driver.findElement(By.name("percentage")).clear();
		//Enter the required percentage field
		driver.findElement(By.name("percentage")).sendKeys("1230");
		
		Thread.sleep(1000);
		//Click the Save button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[3]/div/div/button")).click();

		Thread.sleep(3000);
		//Click the Kitchen Printers Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[3]/div/div/ul")).click();
		//Enter the required Kitchen Printers
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[3]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[3]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Click the Label Printers Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[4]/div/div/ul")).click();
		//Enter the required Label Printers
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		//Click the Restrict Printers Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[5]/div/div/ul")).click();
		//Enter the Restrict Printers
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys("BarTab");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		//Click any one display button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[6]/div/div/div[2]/div[1]/div[8]")).click();
		
		Thread.sleep(5000);
		//Select the image from disk
		driver.findElement(By.xpath("//input[@id='categoryImage']")).sendKeys(Utility.getProperty("Settings_Store_Information_Store_Image_Path"));
		
		Thread.sleep(5000);
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/a")).click();
		//Enter the required time period
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys("Always");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		//Click the save button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[3]/div/div/button")).click();
		
		Thread.sleep(2000);
		//Check weather the new sub category is saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub-category saved successfully"))
		{
			test.log(LogStatus.PASS, "New Sub Category Saved successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Sub Category saved fail");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=105)
	public void Subcategory_method_edit_SubCategory_DaysOfWeek(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Sub_Category_Name")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(10000);
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("Sub_Category_Name")+"1");
		
		Thread.sleep(3000);
		//Click the CAtegory Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[1]/div[1]/div/a")).click();
		Thread.sleep(1000);
		//Enter the Category
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[2]/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		//Click the Serving Size Level Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[4]/div/div/ul")).click();
		//Enter the Serving Size Level
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		//Enable or Disable the Hide in POS option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[7]/div/input")).click();
		
		Thread.sleep(2000);
		//Enable or Disable the Hide in ZenPepper option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[1]/div[8]/div/input")).click();

		Thread.sleep(2000);
		//Enable or Disable the Tax option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[1]/div[1]/input")).click();
		
		Thread.sleep(2000);
		//Enable or Disable the Kitchen Printers option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[1]/div[2]/input")).click();

		Thread.sleep(2000);
		//Enable or Disable the Label Printers option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[1]/div[3]/input")).click();
		
		Thread.sleep(3000);
		//Click the Taxes Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[2]/div[1]/div/ul")).click();
		//Enter the Taxes
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[2]/div[1]/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[2]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(5000);
		//Click the Select image from gallery option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[6]/div/div/div[2]/div[2]/a[1]/i")).click();
		Thread.sleep(5000);
		//Click the required image from the option
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/form/div[2]/div/div/div[12]/div[1]/a/img")).click();
		Thread.sleep(3000);
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys("Days of Week");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Days of Week Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[8]/div/div/ul")).click();
		//Enter the required DAY for Searching
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[8]/div/div/ul/li/input")).sendKeys("WEDNESDAY");
		//Press the Enter key after enter the keyword
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[8]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Enable or disable the Restriction Time Period option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[9]/div/label/span")).click();
		Thread.sleep(2000);
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}


		Thread.sleep(3000);
		//Click the Update button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[3]/div/div/button")).click();
		
		Thread.sleep(2000);
		//Check weather the new sub category is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub-Category Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Sub Category updated successfully for Days of Week");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Sub Category updated fail for Days of Week");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=106)
	public void Subcategory_method_edit_Sub_Category_DaysOfMonth(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Sub_Category_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();	

		Thread.sleep(2000);
		//Enable or Disable the Restrict Printers option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[1]/div[4]/input")).click();
		

		Thread.sleep(3000);
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys("Days of Month");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Required Date form the Calendar
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[8]/div/table/tbody/tr[2]/td[7]/button")).click();
		Thread.sleep(2000);
		
		//Enable or Disable the Restriction Months option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[9]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the months field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div/ul")).click();
		//Enter the Required month
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div/ul/li/input")).sendKeys("MAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Restriction Time option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[11]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[12]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		Thread.sleep(3000);

		Thread.sleep(3000);
		//Click the Update button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[3]/div/div/button")).click();
		
		Thread.sleep(2000);
		//Check weather the new sub category is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub-Category Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Sub Category updated successfully for Days of Month");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Sub Category updated fail for Days of Month");
		}
		Thread.sleep(5000);
	}

	@Test(priority=107)
	public void Subcategory_method_edit_Sub_Category_DateRange(WebDriver driver) throws Exception
	{

		Thread.sleep(5000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Sub_Category_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();	

		Thread.sleep(3000);
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
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
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the Days of a Week option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[11]/div/div/ul")).click();
		//Enter the Required Date
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[11]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[11]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Enable or Disable the Restriction Time option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[12]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[13]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[13]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[13]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}

		
		Thread.sleep(3000);

		Thread.sleep(3000);
		//Click the Update button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[3]/div/div/button")).click();
		
		Thread.sleep(2000);
		//Check weather the new sub category is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub-Category Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Sub Category updated successfully for Date Range");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Sub Category updated fail for Date Range");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=108)
	public void Subcategory_method_edit_Sub_Category_SpecificDate(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Sub_Category_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();	

		Thread.sleep(3000);
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys("Specific date");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Clear the Date field
		driver.findElement(By.name("date")).clear();
		//Enter the required date
		driver.findElement(By.name("date")).sendKeys("15-May-2040");
		
		//Enable or Disable the Restriction Time option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[9]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}

		


		Thread.sleep(3000);
		//Click the Update button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[3]/div/div/button")).click();
		
		Thread.sleep(2000);
		//Check weather the new sub category is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub-Category Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Sub Category updated successfully for Specific Date");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Sub Category updated fail for Specific Date");
		}
		Thread.sleep(5000);
	
	}
	
	@Test(priority=109)
	public void Subcategory_method_edit_Sub_Category_StartDateAndEndDate(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Sub_Category_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();	

		Thread.sleep(3000);
		
		//Click the Applicable Time Period field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/a")).click();
		//Enter the required time option from the given item list
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys("Start date time & end date time");
		//Press the Enter Key in the Applicable time period option field
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(3000);
		//Clear the From date field
		driver.findElement(By.name("fromDate")).clear();
		//Enter the required from Date
		driver.findElement(By.name("fromDate")).sendKeys("25-May-2049");
		//Clear the To Date field
		driver.findElement(By.name("endDate")).clear();
		//Enter the required To Date
		driver.findElement(By.name("endDate")).sendKeys("28-May-2049");
		
		//Enable or Disable the Restriction Days Option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[10]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the Days of a Week option
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[11]/div/div/ul")).click();
		//Enter the Required Date
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[11]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[11]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[12]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}


		
		Thread.sleep(3000);
		//Click the Update button
		driver.findElement(By.xpath("//form[@name='categoryForm']/div[3]/div/div/button")).click();
		
		Thread.sleep(2000);
		//Check weather the new sub category is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub-Category Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Sub Category updated successfully for Start Date and End Date");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Sub Category updated fail for Start Date and End Date");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=110)
	public void Subcategory_method_delete_Sub_Category(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Sub_Category_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check the sub	category deleted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub-category inactivated successfully"))
		{
			test.log(LogStatus.PASS, "New Sub Category is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Sub Category is deleted Failed");
		}
		Thread.sleep(3000);
		
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the sub category activated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub-category activated successfully"))
		{
			test.log(LogStatus.PASS, "Sub Category is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Category is activated Failed");
		}
		
		Thread.sleep(5000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
	}

	@Test(priority=111)
	public void Subcategory_method_cancelSubCategory(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Sub_Category_Name")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(5000);
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		
		Thread.sleep(2000);
		//Check the course form is closed or not
		if(driver.findElement(By.xpath("//a[.='Sub Categories']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Sub Category page is Closed after click the close button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Category page is displayed after click the close button");
		}
		
		Thread.sleep(5000);
	}
	
	@Test(priority=112)
	public void Subcategory_method_inactiveAndActive_Button(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Active button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(1000);
		
		//Check the page
		if(driver.findElement(By.cssSelector("i.fa.fa-check")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Inactive page is displayed after click the Active button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Inactive page is not displayed after click the Active button");
		}
		
		Thread.sleep(3000);
		//Click the InActive button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(1000);
		
		//Check the page
		if(driver.findElement(By.cssSelector("i.fa.fa-trash-o")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Active page is displayed after click the Inactive button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Active page is not displayed after click the Inactive button");
		}
		Thread.sleep(5000);
	}

	@Test(priority=121)
	public void Modifiers_method_openModifiers(WebDriver driver) throws Exception
	{
/*		//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Modifiers']"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Modifiers Option		
		driver.findElement(By.xpath("//span[.='Modifiers']")).click();*/
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"modifiers");
		Thread.sleep(5000);
		//Check Modifiers page opened or not
		if(driver.findElement(By.xpath("//a[.='Modifiers']")).getText().equalsIgnoreCase("Modifiers"))
		{
			test.log(LogStatus.PASS, "Modifiers page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifiers page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=122)
	public void Modifiers_method_refreshModifiers_Page(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[1]/i")).click();
		Thread.sleep(5000);
		
		//Check Modifiers page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Modifiers"))
		{
			test.log(LogStatus.PASS, "Modifiers page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifiers page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=124)
	public void Modifiers_method_add_Modifiers(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		//Click the Add Modifiers button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[2]")).click();
		
		Thread.sleep(2000);
		//Check weather the new Modifiers form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW MODIFIER']")).getText().equalsIgnoreCase("NEW MODIFIER"))
		{
			test.log(LogStatus.PASS, "New Modifiers form Loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifiers form Loaded Fail");
		}
		
		Thread.sleep(6000);
		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("Modifier_Name"));
		
		Thread.sleep(2000);
		//Enable or Disable the Include Default button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[2]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the Add Tax button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[3]/div[2]/a/i")).click();
		
		Thread.sleep(2000);
		//Check weather the new tax form is loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[1]/h3/span")).getText().equalsIgnoreCase("New tax"))
		{
			test.log(LogStatus.PASS, "New Tax form is loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax form loaded fail");
		}
		
		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[1]/div/input")).clear();
		//Enter the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("Modifier_Tax_Name"));
		
		//Enable or disable the Default tax option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[2]/div[1]/div/label/span")).click();
		
		//Enable or disable the Inclusive Tax
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[2]/div[2]/div/label/span")).click();

		Thread.sleep(2000);
		//Clear the percentage field
		driver.findElement(By.name("percentage")).clear();
		//Enter the required percentage field
		driver.findElement(By.name("percentage")).sendKeys("1230");
		
		Thread.sleep(2000);
		//Click the save button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[3]/div/div/button")).click();
		
		Thread.sleep(2000);
		//Add the Kitchen printer button   
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[4]/div[2]/a/i")).click();
		
		Thread.sleep(2000);
		//Check weather the new kitchen printer form is loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[1]/h3/span")).getText().equalsIgnoreCase("New kitchenPrinter"))
		{
			test.log(LogStatus.PASS, "New kitchen printer form is loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New kitchen printer form loaded fail");
		}
		
		Thread.sleep(3000);
		//Click the Type field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[1]/div/div/a")).click();
		//Enter the required input
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[1]/div/div/div/div/input")).sendKeys("KDS");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[2]/div/input")).clear();
		//Enter the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[2]/div/input")).sendKeys(Utility.getProperty("Modifier_Kitchen_Printer_Name"));

		//Clear the IP field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[3]/div/input")).clear();
		//Enter the IP field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[3]/div/input")).sendKeys(Utility.getProperty("Modifier_Kitchen_Printer_IP"));
		
		//Enable or disable the Enable Service Type Restriction option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[4]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the Service Type Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul")).click();
		//Enter the required service type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys("BarTab");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or disable the Apply to all categories
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[6]/div/label/span")).click();
		
		//Enable or disable to apply all menu item
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[7]/div/label/span")).click();		
		
		Thread.sleep(2000);
		//Click the save button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[8]/div/div/button")).click();

		Thread.sleep(2000);
		//CLeare the maximum number of time
		driver.findElement(By.name("maxNoOfTimes")).clear();
		//Enter the maximum number of time
		driver.findElement(By.name("maxNoOfTimes")).sendKeys("3");
		
		//Click the Modify With Option	
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[2]/div[2]/div/div/a")).click();
		//Enter the required option	//
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[2]/div[2]/div/div/div/div/input")).sendKeys("TOPPINGS");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[2]/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Enable or disable the Set Price Here Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[2]/div[3]/div/input")).click();
		
		Thread.sleep(3000);
		//Enable or disable the Show modifier
		driver.findElement(By.xpath("//label[.='Show Modifier']/../div/input")).click();

		Thread.sleep(3000);
		//Click the Next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(5000);
		//Click the Add Prefixes button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[2]/div/div/div[2]/button/span/i")).click();
		
		Thread.sleep(2000);
		//CLear the prefix name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[2]/div/div/div[1]/div/div/ng-form/div/div[1]/input")).clear();
		//Enter the required prefix name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[2]/div/div/div[1]/div/div/ng-form/div/div[1]/input")).sendKeys("Add");
		
		//Clear the price field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[2]/div/div/div[1]/div/div/ng-form/div/div[2]/input")).clear();
		//Enter the Price
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[2]/div/div/div[1]/div/div/ng-form/div/div[2]/input")).sendKeys("125");
		
		//Enable or disable the Override modifier price
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[2]/div/div/div[1]/div/div/ng-form/div/div[3]/input")).click();
		
		Thread.sleep(5000);
		//Click the Add Prefixes button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[2]/div/div/div[2]/button/span/i")).click();

		//Click the Close button of Last Added Prefix
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[2]/div/div/div[1]/div[2]/div/div/a/span/i")).click();
		
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Click the Add Serving Size Level
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[4]/div[1]/button")).click();
		
		Thread.sleep(3000);
		//Click the Serving Size Level Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[3]/div/table/tbody/tr/td[1]/ng-form/div/div/a")).click();
		//Enter the required Serving Size Level
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[3]/div/table/tbody/tr/td[1]/ng-form/div/div/div/div/input")).sendKeys("EACH");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[3]/div/table/tbody/tr/td[1]/ng-form/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Clear the Price Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[3]/div/table/tbody/tr/td[2]/ng-form/div/div/input")).clear();
		//Enter the Price
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[3]/div/table/tbody/tr/td[2]/ng-form/div/div/input")).sendKeys("125");
		
		Thread.sleep(2000);
		//Clear the Prefix Price Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[3]/div/table/tbody/tr/td[3]/div/input")).clear();
		//Enter the Prefix Price
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[3]/div/table/tbody/tr/td[3]/div/input")).sendKeys("125");

		Thread.sleep(3000);
		//Click the Add Serving Size Level
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[4]/div[1]/button")).click();

		//Click the Close button of Last Added SSL
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/ng-form/div[3]/div/table/tbody/tr[2]/td[4]/span/a/span/i")).click();
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();

		Thread.sleep(3000);
		//Click the previous button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-left")).click();
		
		Thread.sleep(3000);
		//Click the Next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div/div[2]/div/button")).click();
		
		Thread.sleep(2000);
		//Check weather the new modifier is saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Modifier saved successfully"))
		{
			test.log(LogStatus.PASS, "New Modifier Saved successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifier saved fail");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=125)
	public void Modifiers_method_edit_Modifiers(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Modifier_Name")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(2000);
		//Enable or Disable the Include default taxes option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[2]/div/label/span")).click();
		
		//Click the Taxes Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[3]/div[1]/div/ul")).click();
		//Enter the required Tax
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[3]/div[1]/div/ul/li/input")).sendKeys("GST");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[3]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		//Click the Kitchen Printer Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[4]/div[1]/div/ul")).click();
		Thread.sleep(1000);
		//Enter the Kitchen Printer
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[4]/div[1]/div/ul/li/input")).sendKeys("KitchenPrinter_1");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[4]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);

		
		Thread.sleep(1000);
		//Click the Update button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[3]/div[2]/div/button")).click();
		
		Thread.sleep(2000);
		//Check weather the new Modifier is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Modifier updated successfully"))
		{
			test.log(LogStatus.PASS, "New Modifier updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifier updated fail");
		}
		Thread.sleep(5000);
	}
		
	@Test(priority=126)
	public void Modifiers_method_delete_Modifier(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Modifier_Name")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check the modifier deleted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Modifier inactivated successfully"))
		{
			test.log(LogStatus.PASS, "New Modifier is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifier is deleted Failed");
		}
		Thread.sleep(3000);
		
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the modifier activated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Modifier activated successfully"))
		{
			test.log(LogStatus.PASS, "Modifier is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifier is activated Failed");
		}
		
		Thread.sleep(5000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=127)
	public void Modifiers_method_cancelModifier_BasicDetails(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Modifier_Name")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(5000);
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		
		Thread.sleep(2000);
		//Check the course form is closed or not
		if(driver.findElement(By.xpath("//a[.='Modifiers']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Modifiers page is Closed after click the close button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifiers page is displayed after click the close button");
		}
		
		Thread.sleep(5000);
	}
	
	@Test(priority=128)
	public void Modifiers_method_cancelModifier_Prefixes(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Modifier_Name")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(3000);
		//Click the Next button
		driver.findElement(By.cssSelector("i.fa.fa-arrow-right")).click();
		
		Thread.sleep(5000);
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		
		Thread.sleep(2000);
		//Check the course form is closed or not
		if(driver.findElement(By.xpath("//a[.='Modifiers']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Modifiers page is Closed after click the close button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifiers page is displayed after click the close button");
		}
		
		Thread.sleep(5000);
	}
	
	@Test(priority=129)
	public void Modifiers_method_add_Modifiers_Save_BasicDetails(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Click the Add Modifiers button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[2]")).click();
		
		Thread.sleep(2000);
		//Check weather the new Modifiers form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW MODIFIER']")).getText().equalsIgnoreCase("NEW MODIFIER"))
		{
			test.log(LogStatus.PASS, "New Modifiers form Loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifiers form Loaded Fail");
		}
		
		Thread.sleep(2000);
		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("Modifier_Name")+1);
		
		Thread.sleep(3000);
		//Enable or Disable the Include Default button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[2]/div/label/span")).click();
		
		//Click the Taxes Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[3]/div[1]/div/ul")).click();
		//Enter the required Tax
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[3]/div[1]/div/ul/li/input")).sendKeys("GST");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[3]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		//Click the Kitchen Printer Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[4]/div[1]/div/ul")).click();
		//Enter the Kitchen Printer
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[4]/div[1]/div/ul/li/input")).sendKeys("KitchenPrinter_1");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[4]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//CLeare the maximum number of time
		driver.findElement(By.name("maxNoOfTimes")).clear();
		//Enter the maximum number of time
		driver.findElement(By.name("maxNoOfTimes")).sendKeys("3");
		
		//Click the Modify With Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[2]/div[2]/div/div/a")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[2]/div[2]/div/div/div/div/input")).sendKeys("TOPPINGS");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[2]/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Enable or disable the Set Price Here Option
		driver.findElement(By.xpath("//label[.='Set Price Here']/../div/input")).click();
										
		//Enable or disable the Show modifier
		driver.findElement(By.xpath("//label[.='Show Modifier']/../div/input")).click();
		
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div/div[2]/div/button")).click();
		
		Thread.sleep(2000);
		//Check weather the new modifier is saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Modifier saved successfully"))
		{
			test.log(LogStatus.PASS, "New Modifier Saved successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifier saved fail");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=130)
	public void Modifiers_method_inactiveAndActive_Button(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Active button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(1000);
		
		//Check the page
		if(driver.findElement(By.cssSelector("i.fa.fa-check")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Inactive page is displayed after click the Active button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Inactive page is not displayed after click the Active button");
		}
		
		Thread.sleep(3000);
		//Click the InActive button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(1000);
		
		//Check the page
		if(driver.findElement(By.cssSelector("i.fa.fa-trash-o")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Active page is displayed after click the Inactive button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Active page is not displayed after click the Inactive button");
		}
		Thread.sleep(5000);
	}

	@Test(priority=141)
	public void Modifiers_Group_method_openModifier_Groups(WebDriver driver) throws Exception
	{
/*		//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Modifier Groups']"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Modifier groups Option		
		driver.findElement(By.xpath("//span[.='Modifier Groups']")).click();*/
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"modifierGroups");
		Thread.sleep(8000);
		//Check Modifier groups page opened or not
		if(driver.findElement(By.xpath("//a[.='Modifier groups']")).getText().equalsIgnoreCase("Modifier groups"))
		{
			test.log(LogStatus.PASS, "Modifier Groups page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifier Groups loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=142)
	public void Modifiers_Group_method_refreshModifier_Groups_Page(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[1]/i")).click();
		Thread.sleep(5000);
		
		//Check Modifier Groups page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Modifier Groups"))
		{
			test.log(LogStatus.PASS, "Modifier Groups page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifier Groups page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
@Test(priority=144)
	public void Modifiers_Group_method_add_Modifier_Groups(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		//Click the Add Modifier Groups button
		driver.findElement(By.xpath("//a[@id='modifierGroup']")).click();
		
		Thread.sleep(2000);
		//Check weather the new Modifiers Group form loaded or not
		if(driver.findElement(By.xpath("//span[.='NEW MODIFIER GROUP']")).getText().equalsIgnoreCase("NEW MODIFIER GROUP"))
		{
			test.log(LogStatus.PASS, "New Modifier Group form Loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifier Group form Loaded Fail");
		}
		
		Thread.sleep(6000);
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("Modifier_Group_Name"));
		
		Thread.sleep(2000);
		//Click the Modifiers option
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required modifier
		//driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Modifiers option
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required modifier
		//driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		//Click the Modifiers option
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required modifier
		//driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys("MUSHROOMS");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		//Click the Modifiers option
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required modifier
		//driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys("OLIVES");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		//Click the Modifiers option
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required modifier
		//driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys("PEPPERONI");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		//Click the Modifiers option
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul")).click();
		//Enter the required modifier
		//driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys("SAUSAGE");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		
		//Clear the priority field
		driver.findElement(By.name("priority")).clear();
		//Enter the priority
		driver.findElement(By.name("priority")).sendKeys("3");
		
		Thread.sleep(3000);
		//Enable or Disable the Pizza Topping Option
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[4]/div/label/span")).click();
		
		Thread.sleep(3000);
		//Enable or Disable the Set Price Here Option
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[5]/div/label/span")).click();
		
		Thread.sleep(3000);
		//Click the Add Serving Size Level
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[7]/button")).click();
		
		Thread.sleep(3000);
		//Click the Serving Size Level Option
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[6]/table/tbody/tr/td[1]/div/div/a")).click();
		//Enter the required Serving Size Level
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[6]/table/tbody/tr/td[1]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[6]/table/tbody/tr/td[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Clear the Price Option
		driver.findElement(By.name("price")).clear();
		//Enter the Price
		driver.findElement(By.name("price")).sendKeys("125");
		
		Thread.sleep(3000);
		//Click the Add Serving Size Level
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[7]/button")).click();

		//Click the Close button of Last Added SSL
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[6]/table/tbody/tr[2]/td[3]/span/a/span/i")).click();
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();

		Thread.sleep(5000);
		//Click the Sort Z-A button
		driver.findElement(By.xpath("//a[.='Sort Z-A']")).click();
		Thread.sleep(5000);
		
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[3]/div/div/button")).click();
		
		Thread.sleep(3500);
		//Check weather the new modifier group is saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Modifier group saved successfully"))
		{
			test.log(LogStatus.PASS, "New Modifier group Saved successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifier group saved fail");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=145)
	public void Modifiers_Group_method_edit_Modifier_Group(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Modifier_Group_Name")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(2000);
		//Enable or Disable the  Pizza Topping option
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[4]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Enable or Disable the Set Price Here option
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[5]/div/label/span")).click();

		Thread.sleep(5000);
		//Click the sort Option
		driver.findElement(By.xpath("//a[.='Sort A-Z']")).click();

		Thread.sleep(10000);
		//Click the Update button
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[3]/div/div/button")).click();
		
		Thread.sleep(3500);
		//Check weather the new Modifier Group is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Modifier group updated successfully"))
		{
			test.log(LogStatus.PASS, "New Modifier Group updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifier Group updated fail");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=146)
	public void Modifiers_Group_method_edit_Modifier_Group_Customer_Sort(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Modifier_Group_Name")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(2000);
		//Enable or Disable the  Pizza Topping option
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[1]/div[4]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the Taxes Option
		driver.findElement(By.xpath("//a[.='Custom sort']")).click();

		Thread.sleep(5000);
		// Element which needs to drag.
		WebElement From = driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[2]/div/div[2]/div/div/ol/li[3]/div"));
		// Element on which need to drop.
		WebElement To = driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[2]/div/div[2]/div/div/ol/li[1]/div"));
		Thread.sleep(2000);
		// Using Action class for drag and drop.
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		// Dragged and dropped.
		act.clickAndHold(From).moveToElement(To).release(To).build().perform();
		
		
		Thread.sleep(10000);
		//Click the Update button
		driver.findElement(By.xpath("//form[@name='modifierGroupCreation']/div[3]/div/div/button")).click();
		
		Thread.sleep(2000);
		//Check weather the new Modifier Group is updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Modifier group updated successfully"))
		{
			test.log(LogStatus.PASS, "New Modifier Group updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifier Group updated fail");
		}
		Thread.sleep(5000);
	}
		
	@Test(priority=147)
	public void Modifiers_Group_method_delete_Modifier(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Modifier_Group_Name")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check the modifier group deleted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Modifier group inactivated successfully"))
		{
			test.log(LogStatus.PASS, "New Modifier group is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifier group is deleted Failed");
		}
		Thread.sleep(3000);
		
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the modifier activated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Modifier group activated successfully"))
		{
			test.log(LogStatus.PASS, "Modifier Group is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifier Group is activated Failed");
		}
		
		Thread.sleep(5000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=148)
	public void Modifiers_Group_method_cancelModifier_Group(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Modifier_Group_Name")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(3000);
		//Click the Edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(5000);
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		
		Thread.sleep(2000);
		//Check the course form is closed or not
		if(driver.findElement(By.xpath("//a[.='Modifier groups']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Modifier Groups page is Closed after click the close button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifier Groups page is displayed after click the close button");
		}
		
		Thread.sleep(5000);
	}
		
	@Test(priority=149)
	public void Modifiers_Group_method_inactiveAndActive_Button(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Active button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(1000);
		
		//Check the page
		if(driver.findElement(By.cssSelector("i.fa.fa-check")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Inactive page is displayed after click the Active button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Inactive page is not displayed after click the Active button");
		}
		
		Thread.sleep(3000);
		//Click the InActive button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(1000);
		
		//Check the page
		if(driver.findElement(By.cssSelector("i.fa.fa-trash-o")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Active page is displayed after click the Inactive button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Active page is not displayed after click the Inactive button");
		}
		Thread.sleep(5000);
	}

}
