package epicList_Chrome_Xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AddEditDelete_Category {
	
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete Category");

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
			if(Utility.getProperty("Product").equalsIgnoreCase("UPOS"))
			{
				Browser a = new Browser();
				a.UPOS_login(driver, test);
			}
			else 			
			{
				Browser a = new Browser();
				a.Linga_login(driver, test);
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
	
		@Test(priority = 100)
		public void calling() throws Exception
		{
			Thread.sleep(10000);
			try
			{
					Thread.sleep(1000);System.out.println("Minimize Chat Icon");
					driver.findElement(By.id("zsiq_minimize")).click();			
			}
			catch(Exception e)
			{
				System.out.println("Minimize Chat Icon Missing");
			}
			//ViewDashBoardReports a = new ViewDashBoardReports();
			Thread.sleep(1000);
			Category_method_openCategory_Page(driver);
			Category_method_refreshCategory_Page(driver);
			Category_method_add_Category(driver);
			Category_method_edit_Category_DaysOfWeek(driver);
			Category_method_edit_Category_DaysOfMonth(driver);
			Category_method_edit_Category_DateRange(driver);
			Category_method_edit_Category_SpecificDate(driver);
			Category_method_edit_Category_StartDateAndEndDate(driver);
			Category_method_delete_Category(driver);
			Category_method_cancelCategory(driver);
			Category_method_inactiveAndActive_Button(driver);
			Thread.sleep(1500);
		}

		@Test(enabled = false,priority=81)
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
		
		@Test(enabled = false,priority=82)
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
		
		@Test(enabled = false,priority=84)
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
			if(driver.findElement(By.xpath("//span[.='New Tax']")).getText().equalsIgnoreCase("New Tax"))
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
			driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Utility.getProperty("Category_Add_Tax_Name"));
			
			
			Thread.sleep(2000);
			//Select the required Apply To option
			Select applyTo = new Select(driver.findElement(By.name("applyTo")));
			applyTo.selectByValue("Item");
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
			driver.findElement(By.xpath("//span[.='Save']")).click();

			Thread.sleep(8000);
			try
			{
				if(driver.findElement(By.xpath("//p[.='Select taxes.']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Newly Add Tax(Add in Category Page) is not ");
					
					Thread.sleep(2000);
					//Click the tax box field
					driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[2]/div[1]/div/ul")).click();
					//Click the input field
					driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[2]/div[1]/div/ul/li/input")).click();
					//Click the Enter button
					driver.findElement(By.xpath("//form[@name='categoryForm']/div[2]/div[2]/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);
				}
			}
			catch(Exception e)
			{
				
			}
			
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
		
		@Test(enabled = false,priority=85)
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
		
		@Test(enabled = false,priority=86)
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

		@Test(enabled = false,priority=87)
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
		
		@Test(enabled = false,priority=88)
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
		
		@Test(enabled = false,priority=89)
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
		
		@Test(enabled = false,priority=90)
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

		@Test(enabled = false,priority=91)
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
		
		@Test(enabled = false,priority=92)
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
			if(Utility.getProperty("Product").equalsIgnoreCase("UPOS")){}else{Thread.sleep(5000);watchTutorial(driver);Thread.sleep(5000);}
		}
		@Test(priority=3, enabled=false)
		public void watchTutorial(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Click the Watch Tutorial Option
			driver.findElement(By.xpath("//span[.='Watch Tutorial']")).click();
			WebElement iframe = driver.findElement(By.xpath("//div[@class='modal-content']/span/iframe"));
			driver.switchTo().frame(iframe);
			Thread.sleep(3500);
			try
			{
				if(driver.findElement(By.xpath("//button/div[.='Watch later']")).isDisplayed()&&driver.findElement(By.xpath("//button/div[.='Share']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Watch Tutorial Video Played Well");
					Thread.sleep(2500);
				}
			}
			catch(Exception e)
			{
				test.log(LogStatus.FAIL, "Watch Tutorial Video not Played");
			}
			driver.switchTo().defaultContent();
			
			Thread.sleep(2000);
			//Click the Close button
			driver.findElement(By.xpath("//span[.='x' and @title='close']")).click();
		}
}
