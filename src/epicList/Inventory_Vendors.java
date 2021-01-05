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

public class Inventory_Vendors {
	
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory_Vendors");

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
		public void Inventory_Vendors_openpage() throws Exception
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
		public void Inventory_Vendors_refreshpage() throws InterruptedException
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
		public void Inventory_Vendors_add_Vendor() throws Exception
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
		public void Inventory_Vendors_edit_Invetory_Ingredient_Vendor() throws Exception
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
		public void Inventory_Vendors_delete() throws Exception
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
		public void Inventory_Vendors_closeButton() throws Exception
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
		public void Inventory_Vendors_verifyActive_InActiveButton() throws Exception
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

}
