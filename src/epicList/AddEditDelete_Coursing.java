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

public class AddEditDelete_Coursing {
	
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete Coursing");

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
	
		@Test(priority=21)
		public void Coursing_method_openCoursing() throws Exception
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
		public void Coursing_method_refreshCoursing_Page() throws Exception
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
		public void Coursing_method_add_Coursing() throws Exception
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
		public void Coursing_method_edit_Coursing() throws Exception
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
		public void Coursing_method_delete_Coursing() throws Exception
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
		public void Coursing_method_cancelCoursing() throws Exception
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
		public void Coursing_method_inactiveAndActive_Button() throws Exception
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
}
