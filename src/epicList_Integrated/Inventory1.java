package epicList_Integrated;

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

public class Inventory1 {
public WebDriver driver;
		
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory1");
	
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
		public void Inventory_Home_openpage(WebDriver driver) throws Exception
		{
			Thread.sleep(15000);
			//Click the Inventory option
			driver.findElement(By.xpath("//span[.='Inventory']")).click();
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Inventory Home']"));
			//Scroll the page till the Inventory Home option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
	        //Click the Inventory Home Option		
			driver.findElement(By.xpath("//span[.='Inventory Home']")).click();
			Thread.sleep(4000);
			//Check Inventory Home page opened or not
			if(driver.findElement(By.xpath("//a[.='Inventory Home']")).getText().equalsIgnoreCase("Inventory Home"))
			{
				test.log(LogStatus.PASS, "Inventory Home page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Inventory Home page loaded Failed");
			}
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
		
	   @Test(priority=3)
		public void Inventory_Home_refresh_Page(WebDriver driver) throws InterruptedException
		{
			Thread.sleep(4000);
			//Click the refresh button
			driver.findElement(By.xpath("//button[@class='btn btn-md btn-border time-filter btn-refresh']")).click();
			Thread.sleep(4000);
			//Check Inventory Home page opened or not
			if(driver.findElement(By.xpath("//span[.='Live Updates']")).getText().equalsIgnoreCase("Live Updates"))
			{
				test.log(LogStatus.PASS, "Inventory Home page refreshed Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Inventory Home page refreshed Failed");
			}
		}
			
		@Test(priority=4)
		public void Inventory_Home_Verify_Reports(WebDriver driver) throws Exception
		{
			Thread.sleep(4000);
			//Check the Total Value On Hand value
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[2]/div[1]/div/div[1]/div/div[1]")).getText().equalsIgnoreCase("Total Value On Hand"))
			{
				test.log(LogStatus.PASS, "Total Value On Hand report is available");
				
				test.log(LogStatus.INFO, "Total Value On Hand amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/span")).getText());
				
			}
		
			else
			{
				test.log(LogStatus.FAIL, "Total Value On Hand report is not available");
			}
			
			Thread.sleep(4000);
			//Check the COGS value
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[2]/div[1]/div/div[2]/div/div[1]")).getText().equalsIgnoreCase("COGS"))
			{
				test.log(LogStatus.PASS, "COGS report is available");
				
				test.log(LogStatus.INFO, "Total COGS value is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/span")).getText());
				
			}
		
			else
			{
				test.log(LogStatus.FAIL, "COGS report is not available");
			}
			
			Thread.sleep(4000);
			//Check the LOW STOCKS value
			if(driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/uib-accordion/div/div[1]/div[1]/h4/a/span/span[2]"))!=null)
			{
				test.log(LogStatus.PASS, "LOW STOCKS report is available");
				
				test.log(LogStatus.INFO, "Total LOW STOCKS value is : "+driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/uib-accordion/div/div[1]/div[1]/h4/a/span/span[2]")).getText());
				
				driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/uib-accordion/div/div[1]/div[1]/h4/a/span/span[1]")).click();
				
				List<WebElement> rows = driver.findElements(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/uib-accordion/div/div[1]/div[2]/div/div[2]/div[1]/div/table/tbody/tr"));
				
				for(int i = 1; i <= rows.size(); i++)
				{
					
				test.log(LogStatus.INFO, driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/uib-accordion/div/div[1]/div[2]/div/div[2]/div[1]/div/table/tbody/tr["+i+"]/td[1]")).getText()+" available quantity is "+driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/uib-accordion/div/div[1]/div[2]/div/div[2]/div[1]/div/table/tbody/tr["+i+"]/td[3]")).getText()+" but the minimum quantity is "+driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/uib-accordion/div/div[1]/div[2]/div/div[2]/div[1]/div/table/tbody/tr["+i+"]/td[2]")).getText());
				
				}
			}
		
			else
			{
				test.log(LogStatus.FAIL, "LOW STOCKS report is not available");
			}
			
			
			Thread.sleep(4000);
			//Check the Non Consume Orders value
			if(driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/uib-accordion/div/div[3]/div[1]/h4/a/span/span[2]"))!=null)
			{
				test.log(LogStatus.PASS, "Non Consume Orders report is available");
				
				test.log(LogStatus.INFO, "Total Non Consume Order is : "+driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/uib-accordion/div/div[3]/div[1]/h4/a/span/span[2]")).getText());
				
				Thread.sleep(3000);
				//Click the Non Consume Orders option 
				driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/uib-accordion/div/div[3]/div[1]/h4/a/span/span[1]")).click();
				
				Thread.sleep(3000);
				
				if(driver.findElement(By.xpath("//td[contains(.,'No Records Found')]")).getText().equalsIgnoreCase("No Records Found"))
				{
					test.log(LogStatus.FAIL, "No Records Found for Consume order");
				}
				
				else
				{
					Thread.sleep(2000);
					//Click the Consume Order Option
					driver.findElement(By.xpath("//button[@ng-click='consumeOrder()']")).click();
					Thread.sleep(2000);
				
						Thread.sleep(3000);
					//Check Consume order finished or not
					if(driver.findElement(By.xpath("//sFpan[.='Consume finished successfully']")).getText().equalsIgnoreCase("Consume finished successfully"))
					{
						test.log(LogStatus.PASS, "Consume order finished Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Consume order finished Failed");
					}
				}
			
			}
			else
			{
				test.log(LogStatus.FAIL, "Non Consume Orders is not available");
				
			}
			
			}
			
		@Test(priority=5)
		public void Inventory_Ingredient_Categories_openpage(WebDriver driver) throws Exception
		{
			
			Thread.sleep(4000);
			//Get the URl
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"masters/category");

			
			Thread.sleep(4000);
			//Check Ingredient Categories page opened or not
			if(driver.findElement(By.xpath("//a[.='Category']")).getText().equalsIgnoreCase("Category"))
			{
				test.log(LogStatus.PASS, "Ingredient Categories page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Ingredient Categories page loaded Failed");
			}
			
			Thread.sleep(4000);
			
		}
				
		@Test(priority=6)
		public void Inventory_Ingredient_Categories_refresh_page(WebDriver driver) throws InterruptedException
		{
			Thread.sleep(4000);
			//Click the refresh button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[1]/i")).click();
			Thread.sleep(4000);
			//Check Inventory Categories page opened or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Category"))
			{
				test.log(LogStatus.PASS, "Inventory Categories page refreshed Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Inventory Categories page refreshed Failed");
			}
			Thread.sleep(4000);
		
		}
			
		@Test(priority=7)
		public void Inventory_Ingredient_Categories_add_Invetory_Category(WebDriver driver) throws Exception
		{
			Thread.sleep(4000);
			//Click on the Add Category option
			driver.findElement(By.id("createCategory")).click();
			Thread.sleep(3000);
			
			//Check whether the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New Category']")).getText().equalsIgnoreCase("New Category"))
			{
				test.log(LogStatus.PASS, "New Category form loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Category form loaded Failed");
			}
		
			Thread.sleep(3000);
			//Clear the name field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/input")).clear();
			Thread.sleep(3000);
			//Enter the Name
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/input")).sendKeys(Utility.getProperty("Inventory_Ingredient_Category"));
			Thread.sleep(2000);
			
			Thread.sleep(4000);
			//Clear the description field
			driver.findElement(By.name("description")).clear();
			//Enter the description
			driver.findElement(By.name("description")).sendKeys("Inventory Ingredient Category");
			Thread.sleep(2000);
				
			//Click the Save button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			
			//Check whether the new category saved or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("category saved sucessfully!."))
			{
				test.log(LogStatus.PASS, "New Ingredient Category Saved Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Ingredient Category Save Failed");
			}
		
			Thread.sleep(4000);
		}
		
		@Test(priority=8)
		public void Inventory_Ingredient_Categories_edit_Invetory_Category(WebDriver driver) throws Exception
		{
			Thread.sleep(4000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(3000);
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_Ingredient_Category"));
			Thread.sleep(4000);
			//Click the Edit icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			Thread.sleep(4000);
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Inventory_Ingredient_Category")+"1");
			
		
			Thread.sleep(4000);
			//Click the update
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
		
			//Check whether the category updated successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Category updated successfully."))
			{
				test.log(LogStatus.PASS, "New Ingredient Category updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Ingredient Category updated Failed");
			}
		
			Thread.sleep(4000);
		
		}
		
		@Test(priority=9)
		public void Inventory_Ingredient_Categories_delete_Invetory_Category(WebDriver driver) throws Exception
		{
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(4000);
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_Ingredient_Category")+"1");
			
			Thread.sleep(4000);
			//Click the Delete button
			driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
			
			Thread.sleep(2000);
			//Click the Yes button in the popup
			driver.findElement(By.linkText("Yes")).click();
			Thread.sleep(3000);			
			//Check the category deleted or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Category InActivated Sucessfully"))
			{
				test.log(LogStatus.PASS, "New Ingredient Category deleted Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Ingredient Category deleted Failed");
			}
		}
		
		@Test(priority=10)
		public void Inventory_Ingredient_Categories_closeButton(WebDriver driver) throws Exception
		{
				
			//Click the Active Button			
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/input")).click();

			Thread.sleep(4000);
			//Click the success button
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
			Thread.sleep(1000);		
			//Click the Yes button in the popup
			driver.findElement(By.linkText("Yes")).click();
			Thread.sleep(3000);
			
			//Check the category activated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Category activated Sucessfully"))
			{
				test.log(LogStatus.PASS, "Ingredient Category is activated Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Ingredient Category is activated Failed");
			}
			
			Thread.sleep(4000);
			//Click on the Add Category option
			driver.findElement(By.id("createCategory")).click();
			Thread.sleep(3000);
			
			//Check whether the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New Category']")).getText().equalsIgnoreCase("New Category"))
			{
				test.log(LogStatus.PASS, "New Category form loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Category form loaded Failed");
			}
		
			Thread.sleep(3000);
			
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Inventory_Ingredient_Category"));
			Thread.sleep(2000);
				
			//Click the Cancel button
			driver.findElement(By.xpath("//a[.='Close']")).click();
			
			Thread.sleep(3000);
			//Check whether the new Ingredient Category canceled or not
			if(driver.findElement(By.id("createCategory")).isDisplayed())
			{
				test.log(LogStatus.PASS, "New Ingredient Category Canceled Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Ingredient Category Canceled Failed");
			}
		
			Thread.sleep(4000);
		}
				
		@Test(priority=11)
		public void Inventory_Ingredient_Categories_verifyActive_InActiveButton(WebDriver driver) throws Exception
		{
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			
			Thread.sleep(4000);
			//Click Active or In Active Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/input")).click();
		
			Thread.sleep(4000);
			//Check the Inactive page is loaded or not
			if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Deleted categories are here, we are in InActive Page");
				Thread.sleep(10000);
				//Click Active or In Active Button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/input")).click();
				}
			else 
				
			if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Deleted Category are not here, we are in Active Page");
			}
			Thread.sleep(4000);
		}
		
		@Test(priority=12)
		public void Inventory_Storage_Locations_openpage(WebDriver driver) throws Exception
		{
			
			//Get the URl
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"masters/storageLocation");

			Thread.sleep(4000);
			//Check Storage Locations page opened or not
			if(driver.findElement(By.xpath("//a[.='Storage Location']")).getText().equalsIgnoreCase("Storage Location"))
			{
				test.log(LogStatus.PASS, "Storage Locations page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Storage Locations page loaded Failed");
			}
			
			Thread.sleep(4000);
			
		}
		
		@Test(priority=14)
		public void Inventory_Storage_Locations_refresh(WebDriver driver) throws InterruptedException
		{
			Thread.sleep(4000);
			//Click the refresh button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[1]/i")).click();
			Thread.sleep(4000);
			//Check Storage Locations page opened or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Storage Location"))
			{
				test.log(LogStatus.PASS, "Storage Locations page refreshed Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Storage Locations page refreshed Failed");
			}
			Thread.sleep(4000);

		}

		@Test(priority=15)
		public void Inventory_Storage_Locations_add_Invetory_Storage(WebDriver driver) throws Exception
		{
			  //Scroll the web page
		    for(int i=1; i <= 20; i++)
		    {
		    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		    	Thread.sleep(1000);
		    } 
		    
			Thread.sleep(4000);
			//Click on the Add Storage Location option
			driver.findElement(By.id("storageLocation")).click();
			Thread.sleep(3000);
			
			//Check whether the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New Storage Location']")).getText().equalsIgnoreCase("New Storage Location"))
			{
				test.log(LogStatus.PASS, "New Storage Location form loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Storage Location form loaded Failed");
			}

			Thread.sleep(3000);
			
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Inventory_Storage_Locations"));
			Thread.sleep(2000);
			
			//Clear the description field
			driver.findElement(By.name("description")).clear();
			//Enter the description
			driver.findElement(By.name("description")).sendKeys("Inventory Storage Location");
			Thread.sleep(2000);
				
			//Click the Save button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			
			//Check whether the new storage location saved or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("StorageLocation updated successfully!."))
			{
				test.log(LogStatus.PASS, "New Storage Location Saved Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Storage Location Save Failed");
			}

			Thread.sleep(4000);
		}
		
		@Test(priority=17)
		public void Inventory_Storage_Locations_edit_Storage_Locations(WebDriver driver) throws Exception
		{
			Thread.sleep(4000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(4000);
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_Storage_Locations"));
			Thread.sleep(4000);
			//Click the Edit icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			Thread.sleep(4000);
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Inventory_Storage_Locations")+"1");
			Thread.sleep(4000);
			//Click the update
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(4000);
			//Check whether the storage locations updated successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("StorageLocation updated successfully!."))
			{
				test.log(LogStatus.PASS, "New Storage Location updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Storage Location updated Failed");
			}

			Thread.sleep(4000);

		}
		
		@Test(priority=18)
		public void Inventory_Storage_Locations_delete_Invetory_Storage(WebDriver driver) throws Exception
		{
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_Storage_Locations")+"1");
			Thread.sleep(5000);
			//Click the Delete button
			driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
			Thread.sleep(3000);
			//Click the Yes button in the popup
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
			Thread.sleep(3000);
			
			//Check the storage locations deleted or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Storage Location InActivated successfully!."))
			{
				test.log(LogStatus.PASS, "New Storage Location deleted Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Storage Location deleted Failed");
			}

			Thread.sleep(4000);
		

			//Click the Active Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
			Thread.sleep(3000);
			
			//Click the success button
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
			Thread.sleep(1000);
			
			//Click the Yes button in the popup
			driver.findElement(By.linkText("Yes")).click();
			Thread.sleep(3000);
			
			//Check the Storage Location activated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Storage Location Activated successfully"))
			{
				test.log(LogStatus.PASS, "Storage Location is activated Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Storage Location is activated Failed");
			}
			
			Thread.sleep(4000);
		}

		@Test(priority=19)
		public void Inventory_Storage_Locations_closeButton(WebDriver driver) throws Exception
		{
			Thread.sleep(4000);
			//Click on the Add storage locations option
			driver.findElement(By.id("storageLocation")).click();
			Thread.sleep(3000);
			
			//Check whether the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New Storage Location']")).getText().equalsIgnoreCase("New Storage Location"))
			{
				test.log(LogStatus.PASS, "New Storage Location form loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Storage Location form loaded Failed");
			}

			Thread.sleep(3000);
			
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Inventory_Storage_Locations"));
			Thread.sleep(2000);
				
			//Click the Cancel button
			driver.findElement(By.xpath("//a[.='Close']")).click();
			
			Thread.sleep(3000);
			//Check whether the new Storage Location canceled or not
			if(driver.findElement(By.id("storageLocation")).isDisplayed())
			{
				test.log(LogStatus.PASS, "New Storage Location Canceled Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Storage Location Canceled Failed");
			}

			Thread.sleep(4000);
		}
				
		@Test(priority=20)
		public void Inventory_Storage_Locations_verifyActive_InActiveButton(WebDriver driver) throws Exception
		{
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			
			Thread.sleep(4000);
			//Click Active or In Active Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();

			Thread.sleep(4000);
			//Check the Inactive page is loaded or not
			if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Deleted storage locations are here, we are in InActive Page");
				Thread.sleep(10000);
				//Click Active or In Active Button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();

			}
			else if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Deleted storage locations are not here, we are in Active Page");
			}
			Thread.sleep(4000);
		}
			
		@Test(priority=21)
		public void Inventory_Vendors_openpage(WebDriver driver) throws Exception
		{
			
			//Get the URl
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"vendors");

			Thread.sleep(4000);
			//Check Vendors page opened or not
			if(driver.findElement(By.xpath("//a[.='Vendors']")).getText().equalsIgnoreCase("Vendors"))
			{
				test.log(LogStatus.PASS, "Vendors page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Vendors page loaded Failed");
			}
			
			Thread.sleep(4000);
			
		}
		
		@Test(priority=22)
		public void Inventory_Vendors_refreshpage(WebDriver driver) throws InterruptedException
		{
			Thread.sleep(4000);
			//Click the refresh button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[1]/i")).click();
			Thread.sleep(4000);
			//Check Vendors page opened or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Vendor"))
			{
				test.log(LogStatus.PASS, "Vendors page refreshed Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Vendors page refreshed Failed");
			}
			Thread.sleep(4000);

		}
		
		@Test(priority=23)
		public void Inventory_Vendors_add_Vendor(WebDriver driver) throws Exception
		{   //Scroll the web page
		    for(int i=1; i <= 15; i++)
		    {
		    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		    	Thread.sleep(1000);
		    }
		    
		    Thread.sleep(3000);
			//Check the search button is displayed
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-border-black.btn-inverse.btn--icon.ng-binding")).isDisplayed();
			Thread.sleep(4000);
			//Click on the Add Vendor option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[2]")).click();
			Thread.sleep(3000);
			
			//Check whether the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New Vendor']")).getText().equalsIgnoreCase("New Vendor"))
			{
				test.log(LogStatus.PASS, "New Vendor form loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Vendor form loaded Failed");
			}

			Thread.sleep(3000);
			
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Inventory_Vendor"));
			Thread.sleep(2000);
			
			//Clear the description field
			driver.findElement(By.name("description")).clear();
			//Enter the description
			driver.findElement(By.name("description")).sendKeys("Inventory Vendor");
			Thread.sleep(2000);
			
			//Clear the phoneNumber field
			driver.findElement(By.name("phoneNumber")).clear();
			//Enter the phoneNumber
			driver.findElement(By.name("phoneNumber")).sendKeys("1234567899");
			Thread.sleep(2000);
			
			//Clear the emailId field
			driver.findElement(By.name("emailId")).clear();
			//Enter the emailId
			driver.findElement(By.name("emailId")).sendKeys("testset@mail.com");
			Thread.sleep(2000);
			
			//Clear the contactName field
			driver.findElement(By.name("contactName")).clear();
			//Enter the contactName
			driver.findElement(By.name("contactName")).sendKeys("Testset");
			Thread.sleep(2000);
			
			//Clear the contactNumber field
			driver.findElement(By.name("contactNumber")).clear();
			//Enter the contactNumber
			driver.findElement(By.name("contactNumber")).sendKeys("1234567899");
			Thread.sleep(2000);
			
			//Clear the addressLine1 field
			driver.findElement(By.name("addressLine1")).clear();
			//Enter the addressLine1
			driver.findElement(By.name("addressLine1")).sendKeys("38/21_Navalar_Street");
			Thread.sleep(2000);
			
			//Clear the addressLine2 field
			driver.findElement(By.name("addressLine2")).clear();
			//Enter the addressLine2
			driver.findElement(By.name("addressLine2")).sendKeys("Arumbakkam");
			Thread.sleep(2000);
			
			//Clear the city field
			driver.findElement(By.name("city")).clear();
			//Enter the city
			driver.findElement(By.name("city")).sendKeys("Chennai");
			Thread.sleep(2000);
			
			//Clear the state field
			driver.findElement(By.name("state")).clear();
			//Enter the state
			driver.findElement(By.name("state")).sendKeys("Tamil Nadu");
			Thread.sleep(2000);
			
			//Clear the zipCode field
			driver.findElement(By.name("zipCode")).clear();
			//Enter the zipCode
			driver.findElement(By.name("zipCode")).sendKeys("123456");
			Thread.sleep(2000);
				
			//Click the Save button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			
			//Check whether the new Vendor saved or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Vendor saved successfully"))
			{
				test.log(LogStatus.PASS, "New Vendor Saved Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Vendor Save Failed");
			}

			Thread.sleep(4000);
		}
		
		@Test(priority=25)
		public void Inventory_Vendors_edit_Invetory_Ingredient_Vendor(WebDriver driver) throws Exception
		{
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(4000);
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_Vendor"));
		
			Thread.sleep(5000);
			//Click the Edit icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			Thread.sleep(4000);
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Inventory_Vendor")+"1");
			Thread.sleep(2000);

			
			//Clear the description field
			driver.findElement(By.name("description")).clear();
			//Enter the description
			driver.findElement(By.name("description")).sendKeys("Inventory Vendor1");
			Thread.sleep(2000);
			
			//Clear the phoneNumber field
			driver.findElement(By.name("phoneNumber")).clear();
			//Enter the phoneNumber
			driver.findElement(By.name("phoneNumber")).sendKeys("1234567898");
			Thread.sleep(2000);
			
			//Clear the emailId field
			driver.findElement(By.name("emailId")).clear();
			//Enter the emailId
			driver.findElement(By.name("emailId")).sendKeys("testset1@mail.com");
			Thread.sleep(2000);
			
			//Clear the contactName field
			driver.findElement(By.name("contactName")).clear();
			//Enter the contactName
			driver.findElement(By.name("contactName")).sendKeys("Testset1");
			Thread.sleep(2000);
			
			//Clear the contactNumber field
			driver.findElement(By.name("contactNumber")).clear();
			//Enter the contactNumber
			driver.findElement(By.name("contactNumber")).sendKeys("1234567898");
			Thread.sleep(2000);
			
			//Clear the addressLine1 field
			driver.findElement(By.name("addressLine1")).clear();
			//Enter the addressLine1
			driver.findElement(By.name("addressLine1")).sendKeys("38/22_Navalar_Street");
			Thread.sleep(2000);
			
			//Clear the addressLine2 field
			driver.findElement(By.name("addressLine2")).clear();
			//Enter the addressLine2
			driver.findElement(By.name("addressLine2")).sendKeys("MMDA");
			Thread.sleep(2000);
			
			//Clear the city field
			driver.findElement(By.name("city")).clear();
			//Enter the city
			driver.findElement(By.name("city")).sendKeys("Chennai");
			Thread.sleep(2000);
			
			//Clear the state field
			driver.findElement(By.name("state")).clear();
			//Enter the state
			driver.findElement(By.name("state")).sendKeys("Tamil Nadu");
			Thread.sleep(2000);
			
			//Clear the zipCode field
			driver.findElement(By.name("zipCode")).clear();
			//Enter the zipCode
			driver.findElement(By.name("zipCode")).sendKeys("123455");
			Thread.sleep(2000);
				

			//Click the update
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);

			//Check whether the Vendor updated successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Vendor updated successfully"))
			{
				test.log(LogStatus.PASS, "New Vendor updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Vendor updated Failed");
			}

			Thread.sleep(4000);

		}
		
		@Test(priority=26)
		public void Inventory_Vendors_delete(WebDriver driver) throws Exception
		{
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(4000);
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_Vendor")+"1");
			Thread.sleep(4000);
			//Click the Delete button
			driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
			
			Thread.sleep(3000);
			//Click the Yes button in the popup
			driver.findElement(By.linkText("Yes")).click();
			Thread.sleep(3000);
			
			//Check the Vendor deleted or not
			if(driver.findElement(By.xpath("//span[.='Vendor InActivated successfully']")).getText().equalsIgnoreCase("Vendor InActivated successfully"))
			{
				test.log(LogStatus.PASS, "New Vendor deleted Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Vendor deleted Failed");
			}

			Thread.sleep(4000);
		

			//Click the Active Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[1]/input")).click();
			Thread.sleep(3000);
			
			//Click the success button
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
			Thread.sleep(1000);
			
			//Click the Yes button in the popup
			driver.findElement(By.linkText("Yes")).click();
			Thread.sleep(3000);
			
			//Check the Vendor activated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Vendor Activated successfully"))
			{
				test.log(LogStatus.PASS, "Vendor is activated Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Vendor is activated Failed");
			}
			
			Thread.sleep(4000);
		}

		@Test(priority=27)
		public void Inventory_Vendors_closeButton(WebDriver driver) throws Exception
		{
			Thread.sleep(4000);
			//Click on the Add Vendor option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[2]")).click();
			Thread.sleep(3000);
			
			//Check whether the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New Vendor']")).getText().equalsIgnoreCase("New Vendor"))
			{
				test.log(LogStatus.PASS, "New Vendor form loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Vendor form loaded Failed");
			}

			Thread.sleep(3000);
			
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Inventory_Vendor"));
			Thread.sleep(2000);
				
			//Click the Cancel button
			driver.findElement(By.xpath("//a[.='Cancel']")).click();
			
			Thread.sleep(3000);
			//Check whether the new Vendor canceled or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[2]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "New Vendor Canceled Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Vendor Canceled Failed");
			}

			Thread.sleep(4000);
		}
				
		@Test(priority=28)
		public void Inventory_Vendors_verifyActive_InActiveButton(WebDriver driver) throws Exception
		{
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			
			Thread.sleep(4000);
			//Click Active or In Active Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[1]/input")).click();

			Thread.sleep(4000);
			//Check the Inactive page is loaded or not
			if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Deleted categories are here, we are in InActive Page");
				Thread.sleep(10000);
				//Click Active or In Active Button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[1]/input")).click();

			}
			else if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Deleted Vendor are not here, we are in Active Page");
			}
			Thread.sleep(4000);
		}
		
		@Test(priority=29)
		public void Inventory_In_HouseUnits_openpage(WebDriver driver) throws Exception
		{
			
			//Get the URl
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"masters/inHouseUnit");

			Thread.sleep(4000);
			//Check In House Units page opened or not
			if(driver.findElement(By.xpath("//a[.='InHouse units']")).getText().equalsIgnoreCase("InHouse units"))
			{
				test.log(LogStatus.PASS, "In House Units page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "In House Units page loaded Failed");
			}
			
			Thread.sleep(4000);
			
		}
		
		@Test(priority=30)
		public void Inventory_In_HouseUnits_refresh(WebDriver driver) throws InterruptedException
		{
			Thread.sleep(4000);
			//Click the refresh button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[1]/i")).click();
			Thread.sleep(4000);
			//Check In House Units page opened or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("InHouse units"))
			{
				test.log(LogStatus.PASS, "In House Units page refreshed Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "In House Units page refreshed Failed");
			}
			Thread.sleep(4000);

		}
	
		@Test(priority=31)
		public void Inventory_In_HouseUnits_add_InHouseUnits(WebDriver driver) throws Exception
		{
			Thread.sleep(4000);
			//Click on the Add In House Units option
			driver.findElement(By.id("houseUnit")).click();
			Thread.sleep(3000);
			
			//Check whether the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New InHouse units']")).getText().equalsIgnoreCase("New InHouse units"))
			{
				test.log(LogStatus.PASS, "New In House Units form loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New In House Units form loaded Failed");
			}

			Thread.sleep(3000);
			
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Inventory_In_House_Units"));
			Thread.sleep(2000);
			
			//Check whether the measure type is Weight or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[2]/input[1]")).isSelected())
			{
				//Click the Volume measure type
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[2]/input[2]")).click();
			}
			
			//Check whether the measure type is Volume or not
			else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[2]/input[2]")).isSelected())
			{
				//Click the Weight measure type
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[2]/input[1]")).click();
			}
			
			
			Thread.sleep(2000);
			//Click the Add Conversions option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span[2]/a/i")).click();
			
			Thread.sleep(2000);
			//Clear the number field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/div/div/input")).clear();
			//Enter the required amount
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/div/div/input")).sendKeys("3");
			
			Thread.sleep(2000);
			//Click the Select an Option button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/div/div/div/a")).click();
			//Enter the Required option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/div/div/div/div/div/input")).sendKeys("Liter");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Add Conversions option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span[2]/a/i")).click();
			
			Thread.sleep(2000);
			//Clear the number field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/div[2]/div/input")).clear();
			//Enter the required amount
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/div[2]/div/input")).sendKeys("2");
			
			Thread.sleep(2000);
			//Click the Select an Option button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/div[2]/div/div/a")).click();
			//Enter the Required option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/div[2]/div/div/div/div/input")).sendKeys("Liter");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(2000);
			//Click the Add Conversions option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span[2]/a/i")).click();
			
			Thread.sleep(2000);
			//Click the Close button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/div[3]/div/a")).click();
			Thread.sleep(1000);
			
			//Click the Save button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			
			//Check whether the new In House Units saved or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Unit saved successfully"))
			{
				test.log(LogStatus.PASS, "New In House Units Saved Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New In House Units Save Failed");
			}

			Thread.sleep(4000);
		}
		
		@Test(priority=33)
		public void Inventory_In_HouseUnits_edit_Ingredient_In_House_Units(WebDriver driver) throws Exception
		{
			Thread.sleep(5000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_In_House_Units"));
			Thread.sleep(5000);
			//Click the Edit icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			Thread.sleep(5000);
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Inventory_In_House_Units")+"1");
			Thread.sleep(3000);

			
			//Check whether the measure type is Weight or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[2]/input[1]")).isSelected())
			{
				//Click the Volume measure type
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[2]/input[2]")).click();
			}
			
			//Check whether the measure type is Volume or not
			else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[2]/input[2]")).isSelected())
			{
				//Click the Weight measure type
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[2]/input[1]")).click();
			}
			Thread.sleep(2000);

			//Click the update
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);

			//Check whether the In House Units updated successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Unit updated successfully"))
			{
				test.log(LogStatus.PASS, "New In House Units updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New In House Units updated Failed");
			}

			Thread.sleep(4000);

		}
		
		@Test(priority=34)
		public void Inventory_In_HouseUnits_delete(WebDriver driver) throws Exception
		{
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_In_House_Units")+"1");
			Thread.sleep(3000);
			//Click the Delete button
			driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
			Thread.sleep(3000);
			//Click the Yes button in the popup
			driver.findElement(By.linkText("Yes")).click();
			
			Thread.sleep(3000);
			//Check the In House Units deleted or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Unit inactivated successfully"))
			{
				test.log(LogStatus.PASS, "New In House Units deleted Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New In House Units deleted Failed");
			}

			Thread.sleep(4000);
		

			//Click the Active Button
			driver.findElement(By.xpath("//input[@ng-model='activeStatus']")).click();
			Thread.sleep(3000);
			
			//Click the success button
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
			Thread.sleep(1000);
			
			//Click the Yes button in the popup
			driver.findElement(By.linkText("Yes")).click();
			Thread.sleep(3000);
			
			//Check the In House Units activated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Unit activated successfully"))
			{
				test.log(LogStatus.PASS, "In House Units is activated Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "In House Units is activated Failed");
			}
			
			Thread.sleep(4000);
		}

		@Test(priority=35)
		public void Inventory_In_HouseUnits_closeButton(WebDriver driver) throws Exception
		{
			Thread.sleep(4000);
			//Click on the Add In House Units option
			driver.findElement(By.id("houseUnit")).click();
			Thread.sleep(3000);
			
			//Check whether the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New InHouse units']")).getText().equalsIgnoreCase("New InHouse units"))
			{
				test.log(LogStatus.PASS, "New In House Units form loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New In House Units form loaded Failed");
			}

			Thread.sleep(3000);
			
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Inventory_In_House_Units"));
			Thread.sleep(2000);
				
			//Click the Cancel button
			driver.findElement(By.xpath("//a[.='Close']")).click();
			
			Thread.sleep(3000);
			//Check whether the new In House Units canceled or not
			if(driver.findElement(By.id("houseUnit")).isDisplayed())
			{
				test.log(LogStatus.PASS, "New In House Units Canceled Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New In House Units Canceled Failed");
			}

			Thread.sleep(4000);
		}
				
		@Test(priority=36)
		public void Inventory_In_HouseUnits_verifyActive_InActiveButton(WebDriver driver) throws Exception
		{
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			
			Thread.sleep(4000);
			//Click Active or In Active Button
			driver.findElement(By.xpath("//input[@ng-model='activeStatus']")).click();

			Thread.sleep(4000);
			//Check the Inactive page is loaded or not
			if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Deleted categories are here, we are in InActive Page");
				Thread.sleep(10000);
				//Click Active or In Active Button
				driver.findElement(By.xpath("//input[@ng-model='activeStatus']")).click();

			}
			else if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Deleted In House Units are not here, we are in Active Page");
			}
			Thread.sleep(4000);
		}
				
		@Test(priority=37)
		public void Inventory_Items_openpage(WebDriver driver) throws Exception
		{
			
			//Get the URl
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"inventoryItems");

			Thread.sleep(4000);
			//Check Inventory Items page opened or not
			if(driver.findElement(By.xpath("//span[.='Inventory Item']")).getText().equalsIgnoreCase("Inventory Item"))
			{
				test.log(LogStatus.PASS, "Inventory Items page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Inventory Items page loaded Failed");
			}
			
			Thread.sleep(4000);
			
		}
		
		@Test(priority=38)
		public void Inventory_Items_refresh(WebDriver driver) throws InterruptedException
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(5000);
			//Click the refresh button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/a[2]/i")).click();
			Thread.sleep(5000);
			//Check Inventory Items page opened or not
			if(driver.findElement(By.xpath("//span[.='Inventory Item']")).getText().equalsIgnoreCase("Inventory Item"))
			{
				test.log(LogStatus.PASS, "Inventory Items page refreshed Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Inventory Items page refreshed Failed");
			}
			Thread.sleep(5000);

		}

		@Test(priority=39)
		public void Inventory_item_pagination(WebDriver driver) throws InterruptedException
		{
			
			WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
					
			Thread.sleep(10000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(1000);
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			Thread.sleep(2000);
			//Click the Pagination option as 15
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[3]/div/div/div/ul[1]/li[2]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 15");
			//Create the web element for Inventory Items Table
			List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[3]/table"));
			for (WebElement result : results){						
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available");
			}
			Thread.sleep(8000);
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			Thread.sleep(2000);
			//Click the Pagination option as 20
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[3]/div/div/div/ul[1]/li[3]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 20");
			//Create the web element for Inventory Items Table
			List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[3]/table"));
			for (WebElement result : results1){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available");
			}
			Thread.sleep(8000);
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			Thread.sleep(2000);
			//Click the Pagination option as 25
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[3]/div/div/div/ul[1]/li[4]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 25");
			//Create the web element for Inventory Items Table
			List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[3]/table"));
			for (WebElement result : results2){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available");
			}
			Thread.sleep(8000);
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			Thread.sleep(2000);
			//Click the Pagination option as 10
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[3]/div/div/div/ul[1]/li[1]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 10");
			//Create the web element for Inventory Items Table
			List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[3]/table"));
			for (WebElement result : results3){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available");
			}
			Thread.sleep(8000);
		}
		
		@Test(priority=40)
		public void Inventory_Items_add(WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(5000);
			//Click on the Add Inventory Items option
			driver.findElement(By.id("inventoryItem")).click();
			Thread.sleep(3000);
			
			//Check whether the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New Inventory Item']")).getText().equalsIgnoreCase("New Inventory Item"))
			{
				test.log(LogStatus.PASS, "New Inventory Items form loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Inventory Items form loaded Failed");
			}

			Thread.sleep(3000);
			
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Inventory_Items_Name"));
			Thread.sleep(2000);
			
			
			//Click the Add Category button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[1]/div/div[1]/div[2]/div[2]/a/i")).click();
			Thread.sleep(1000);
			
			//Check Whether the new Category form loaded
			if(driver.findElement(By.xpath("//span[.='New Category']")).getText().equalsIgnoreCase("New Category"))
			{
				test.log(LogStatus.PASS, "New Category form loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Category form loaded fail");
			}
			Thread.sleep(2000);
			
			//Clear the name field
			driver.findElement(By.name("masterName")).clear();
			//Enter the required name
			driver.findElement(By.name("masterName")).sendKeys(Utility.getProperty("Inventory_Category_Name"));
			
			//Clear the description box
			driver.findElement(By.name("description")).clear();
			//Enter the Description
			driver.findElement(By.name("description")).sendKeys("Desc of Inventory Category");
			
			Thread.sleep(2000);
			//Click the Save button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[3]/div/div/button")).click();
			
			
			Thread.sleep(2000);
			//Click the Add primary storage button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[1]/div/div[1]/div[3]/div[2]/a/i")).click();
			Thread.sleep(2000);
			
			//Check whether the new primary storage location form loaded or not
			if(driver.findElement(By.xpath("//span[.='New Storage']")).getText().equalsIgnoreCase("New Storage"))
			{
				test.log(LogStatus.PASS, "Primary Storage form loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Primary Storage form loaded fail");
			}
			Thread.sleep(2000);
			
			//Clear the name field
			driver.findElement(By.name("masterName")).clear();
			//Enter the required name
			driver.findElement(By.name("masterName")).sendKeys(Utility.getProperty("Inventory_Primary_Storage_Name"));
			
			//Clear the description field
			driver.findElement(By.name("description")).clear();
			//Enter the required information
			driver.findElement(By.name("description")).sendKeys("Desc of Inventory Primary Storage");
			
			Thread.sleep(2000);
			//Click the Save button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/form/div[3]/div/div/button")).click();
			
			Thread.sleep(2000);
			//Click the Inventory Unit Option
			driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/a")).click();
			//Enter the required Inventory unit
			driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/div/div/input")).sendKeys("Liter");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='inventoryUnit_chosen']/div/div/input")).sendKeys(Keys.ENTER);
			
			//Clear the Par level option
			driver.findElement(By.name("minInventoryCount")).clear();
			//Enter the required amount of Par level
			driver.findElement(By.name("minInventoryCount")).sendKeys("1");
			
			//Click the secondary storage field
			driver.findElement(By.xpath("//div[@id='ssl_chosen']/a")).click();
			//Enter the storage location
			driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys("Freezer");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys(Keys.ENTER);
			
			//Click the Vendor unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[2]/ng-form/div/div/div[1]/div[1]/div/div/a")).click();
			//Enter the required vendor
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[2]/ng-form/div/div/div[1]/div[1]/div/div/div/div/input")).sendKeys("Sysco Food");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[2]/ng-form/div/div/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
			//Clear the Bar code option
			driver.findElement(By.name("barcode")).clear();
			//Enter the required Bar Code
			driver.findElement(By.name("barcode")).sendKeys(Utility.getProperty("Inventory_Sku_OR_Bar_Code"));
			
			//Clear the Brand Name
			driver.findElement(By.name("brandName")).clear();
			//Enter the required Brand Name
			driver.findElement(By.name("brandName")).sendKeys("Brand");
			
			//Click the purchase unit option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[2]/ng-form/div/div/div[1]/div[4]/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[2]/ng-form/div/div/div[1]/div[4]/div/div/div/div/input")).sendKeys("Liter");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[2]/ng-form/div/div/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
			//Clear the unit multiplier option
			driver.findElement(By.name("purchaseUnitMultiplier")).clear();
			//Enter the required unit multipliuer
			driver.findElement(By.name("purchaseUnitMultiplier")).sendKeys("1");
			
			//Clear the Quantity option
			driver.findElement(By.name("receivingQuantity")).clear();
			//Enter the required Quantity
			driver.findElement(By.name("receivingQuantity")).sendKeys("1");
			
			//Clear the price option
			driver.findElement(By.name("price")).clear();
			//Enter the required price
			driver.findElement(By.name("price")).sendKeys("115");
			
			//Clear the yield option
			driver.findElement(By.name("yield")).clear();
			//Enter the required yield
			driver.findElement(By.name("yield")).sendKeys("11");
			
			//Clear the pricePerUnit option
			driver.findElement(By.name("pricePerUnit")).clear();
			//Enter the required pricePerUnit
			driver.findElement(By.name("pricePerUnit")).sendKeys("75");
			
			Thread.sleep(2000);
			//Click the Add new vendor option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/ul/li[2]/a/uib-tab-heading/a")).click();
			
			//Click the Vendor unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[1]/div/div/a")).click();
		/*	//Enter the required vendor  
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[1]/div/div/div/div/input")).sendKeys("IV_NameAA1");*/
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Clear the Bar code option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[2]/div/input")).clear();
			//Enter the required Bar Code
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("Inventory_Sku_OR_Bar_Code")+"NEW");
			
			Thread.sleep(2000);
			//Clear the Brand Name
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[3]/div/input")).clear();
			//Enter the required Brand Name
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[3]/div/input")).sendKeys("Brand");
			
			Thread.sleep(2000);
			//Click the purchase unit option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[4]/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[4]/div/div/div/div/input")).sendKeys("liter");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Clear the unit multiplier option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[4]/div/input[1]")).clear();
			//Enter the required unit multipliuer
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[4]/div/input[1]")).sendKeys("1000");
			
			Thread.sleep(2000);
			//Clear the Quantity option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[1]/div/input[1]")).clear();
			//Enter the required Quantity
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[1]/div/input[1]")).sendKeys("1");
			
			Thread.sleep(2000);
			//Clear the price option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[2]/div/input")).clear();
			//Enter the required price
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[2]/div/input")).sendKeys("115");
			
			Thread.sleep(2000);
			//Clear the yield option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[3]/div/input")).clear();
			//Enter the required yield
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[3]/div/input")).sendKeys("10");
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[4]/div/input")).click();
			//Clear the pricePerUnit option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[4]/div/input")).clear();
			//Enter the required pricePerUnit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[2]/div[4]/div/input")).sendKeys("75");
			
			Thread.sleep(2000);
			//Click the New Vendor Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/ul/li[3]/a/uib-tab-heading/a/i")).click();
			
			Thread.sleep(2000);
			//Click the Close Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/ul/li[3]/a/uib-tab-heading/a/i")).click();
										 //div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/ul/li[3]/a/uib-tab-heading/a/i
			//Click the Yes button in the popup
			driver.findElement(By.linkText("Yes")).click();
			Thread.sleep(3000);
			
			//Clear the Equal field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div/ng-form/div/div/div[2]/input")).clear();
			//Enter the required number
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div/ng-form/div/div/div[2]/input")).sendKeys("1");
			
			Thread.sleep(2000);
			//Click the Select an Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div/ng-form/div/div/div[3]/div/a")).click();
			//Enter the required unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div/ng-form/div/div/div[3]/div/div/div/input")).sendKeys("Liter");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div/ng-form/div/div/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			/*Thread.sleep(7000);
			driver.findElement(By.name("pricePerUnit")).click();
			//Clear the Price Option
			driver.findElement(By.name("pricePerUnit")).clear();
			//Enter the required price per unit
			driver.findElement(By.name("pricePerUnit")).sendKeys("123");*/
			
			Thread.sleep(5000);
			//Click the Add Recipe Unit Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[2]/a/i")).click();
			
			Thread.sleep(1000);
			//Clear the Equal field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[2]/input")).clear();
			//Enter the required number
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[2]/input")).sendKeys("1000");
			
			Thread.sleep(2000);
			//Click the Select an Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[3]/div/a")).click();
			//Enter the required unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[3]/div/div/div/input")).sendKeys("liter");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[4]/div/input")).click();
			//Clear the Price Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[4]/div/input")).clear();
			//Enter the required price per unit
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[2]/ng-form/div/div/div[4]/div/input")).sendKeys("123");

			Thread.sleep(2000);
			//Click the Add Recipe Unit Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[2]/a/i")).click();

			Thread.sleep(2000);
			//Click the Close Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[3]/div/div/div/div[1]/div/div[3]/ng-form/div/div/div[4]/div/a/i")).click();
			
			Thread.sleep(2000);
			//Click the Yes button in the popup
			driver.findElement(By.linkText("Yes")).click();
			Thread.sleep(3000);
					
			//Click the Save button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[4]/div/div/button")).click();
			Thread.sleep(2000);
			
			//Check whether the new Inventory Items saved or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Inventory item saved successfully!."))
			{
				test.log(LogStatus.PASS, "New Inventory Items Saved Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Inventory Items Save Failed");
			}

			Thread.sleep(5000);
			}
		
		@Test(priority=41)
		public void Inventory_Items_edit_Inventory_Items(WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(4000);
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_Items_Name"));
			Thread.sleep(4000);
			driver.findElement(By.cssSelector("i.fa.fa-search")).click();

			Thread.sleep(4000);
			//Click the Edit icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Inventory_Items_Name")+"1");
			Thread.sleep(2000);

			Thread.sleep(6000);
			//Click the Category Option
			driver.findElement(By.xpath("//div[@id='category_chosen']/a")).click();
			Thread.sleep(2000);
			Thread.sleep(2000);
			//Enter the Required Category
			driver.findElement(By.xpath("//div[@id='category_chosen']/div/div/input")).sendKeys("FOOD");
			Thread.sleep(2000);
			//Press the Enter Key
			driver.findElement(By.xpath("//div[@id='category_chosen']/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(5000);
			//Click the Primary Storage Option
			driver.findElement(By.xpath("//div[@id='psl_chosen']/a")).click();
			Thread.sleep(3000);
			//Enter the Required Storage
			driver.findElement(By.xpath("//div[@id='psl_chosen']/div/div/input")).sendKeys("Freezer");
			Thread.sleep(2000);
			//Press the Enter Key
			driver.findElement(By.xpath("//div[@id='psl_chosen']/div/div/input")).sendKeys(Keys.ENTER);

			Thread.sleep(5000);
			//Click the secondary storage field
			driver.findElement(By.xpath("//div[@id='ssl_chosen']/a")).click();
			//Enter the storage location
			driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys("Syncc");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(3000);
			//Click the first vendor
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/ul/li[1]/a/uib-tab-heading/span")).click();
			//Clear the Barcode option
			driver.findElement(By.name("barcode")).clear();
			//Enter the new Barcode
			driver.findElement(By.name("barcode")).sendKeys(Utility.getProperty("Inventory_Sku_OR_Bar_Code")+"1");
			
			Thread.sleep(3000);
			//Click the second vendor
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/ul/li[2]/a/uib-tab-heading/span")).click();
			//Clear the Barcode option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[2]/div/input")).clear();
			//Enter the new Barcode
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[3]/ng-form/div/div/div[1]/div[2]/div/input")).sendKeys(Utility.getProperty("Inventory_Sku_OR_Bar_Code")+"NEW1");
				
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(4000);
			//Click the update
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/form/div[4]/div/div/button")).click();
			
			Thread.sleep(2000);
			//Check whether the Inventory Items updated successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Inventory item updated."))
			{
				test.log(LogStatus.PASS, "New Inventory Items updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Inventory Items updated Failed");
			}

			Thread.sleep(5000);

		}
		
		@Test(priority=42)
		public void Inventory_Items_delete(WebDriver driver) throws Exception
		{

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//Enter the required keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_Items_Name")+"1");
			
			Thread.sleep(2000);
			//Click the Delete button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[3]/table/tbody/tr/td[8]/span[1]/a[2]/i")).click();
			
			Thread.sleep(1000);
			//Click the yes button			
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();

			Thread.sleep(3000);
			//Check the Inventory Items deleted or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Inventory item inactivated."))
			{
				test.log(LogStatus.PASS, "New Inventory Items deleted Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Inventory Items deleted Failed");
			}

			Thread.sleep(4000);
			//Click the Active Button
			driver.findElement(By.xpath("//input[@ng-model='activeStatus']")).click();
			Thread.sleep(3000);
			
			//Click the success button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[3]/table/tbody/tr/td[8]/span[2]/a/i")).click();
			Thread.sleep(1000);
			
			//Click the Yes button in the popup
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
			Thread.sleep(3000);
			
			//Check the Inventory Items activated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Inventory item activated."))
			{
				test.log(LogStatus.PASS, "Inventory Items is activated Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Inventory Items is activated Failed");
			}
			
			Thread.sleep(4000);
		}

		@Test(priority=43)
		public void Inventory_Items_closeButton(WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(3000);
			//Click on the Add Inventory Items option
			driver.findElement(By.id("inventoryItem")).click();
			Thread.sleep(3000);
			
			//Check whether the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New Inventory Item']")).getText().equalsIgnoreCase("New Inventory Item"))
			{
				test.log(LogStatus.PASS, "New Inventory Items form loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Inventory Items form loaded Failed");
			}

			Thread.sleep(3000);
			
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the Name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Inventory_Items_Name"));
			Thread.sleep(2000);
				
			//Click the Cancel button
			driver.findElement(By.xpath("//a[.='Cancel']")).click();
			
			Thread.sleep(3000);
			//Check whether the new Inventory Items canceled or not
			if(driver.findElement(By.id("inventoryItem")).isDisplayed())
			{
				test.log(LogStatus.PASS, "New Inventory Items Canceled Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Inventory Items Canceled Failed");
			}

			Thread.sleep(5000);
		}
				
		@Test(priority=44)
		public void Inventory_Items_verifyActive_InActiveButton(WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			
			Thread.sleep(5000);
			//Click Active or In Active Button
			driver.findElement(By.xpath("//input[@ng-model='activeStatus']")).click();

			Thread.sleep(5000);
			//Check the Inactive page is loaded or not
			if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Deleted categories are here, we are in InActive Page");
				Thread.sleep(10000);
				//Click Active or In Active Button
				driver.findElement(By.xpath("//input[@ng-model='activeStatus']")).click();

			}
			else if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Deleted Inventory Items are not here, we are in Active Page");
			}
			Thread.sleep(5000);
			}
		
		@Test(priority=45)
		public void Inventory_Sub_Recipes_openpage(WebDriver driver) throws Exception
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
		public void Inventory_Sub_Recipes_refresh(WebDriver driver) throws InterruptedException
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
		public void Inventory_Sub_Recipes_add_Invetory_Sub_Recipes(WebDriver driver) throws Exception
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
		public void Inventory_Sub_Recipes_edit_Invetory_Sub_Recipe(WebDriver driver) throws Exception
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
		public void Inventory_Sub_Recipes_edit_Invetory_Sub_Recipe_InvITEM_InvITEM(WebDriver driver) throws Exception
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
		public void Inventory_Sub_Recipes_edit_Invetory_Sub_Recipe_InvITEM_SubRecipe(WebDriver driver) throws Exception
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
		public void Inventory_Sub_Recipes_edit_Invetory_Sub_Recipe_InvITEM_Manual(WebDriver driver) throws Exception
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
		public void Inventory_Sub_Recipes_edit_Invetory_Sub_Recipe_SubRecipe_Manual(WebDriver driver) throws Exception
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
		public void Inventory_Sub_Recipes_edit_Invetory_Sub_Recipe_SubRecipe_SubRecipe(WebDriver driver) throws Exception
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
		public void Inventory_Sub_Recipes_edit_Invetory_Sub_Recipe_Manual_Manual(WebDriver driver) throws Exception
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
		public void Inventory_Sub_Recipes_delete_Invetory_Sub_Recipe(WebDriver driver) throws Exception
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
		public void Inventory_Sub_Recipes_closeButton_Sub_Recipe(WebDriver driver) throws Exception
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
		public void Inventory_Sub_Recipes_verifyActive_InActiveButton_Sub_Recipe(WebDriver driver) throws Exception
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
