package epicList_Integrated;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Inventory3 {
public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory3");

			@AfterClass
			public void flushTest() throws Exception
			{
				Thread.sleep(2000);
				rep.endTest(test);
				rep.flush();
				//SendMail.snedMailWithAttachment();
			}
			
			@AfterMethod
			public void tearDown(ITestResult result)
			{
				if(ITestResult.FAILURE == result.getStatus())
				{
					Utility.captureScreenshot(driver, result.getName());
				}
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
			public void Inventory_Purchase_Purchase_Template_openPAGE(WebDriver driver) throws Exception
			{
				Thread.sleep(15000);
				//Click the Inventory option
				driver.findElement(By.xpath("//span[.='Inventory']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[contains(.,'Purchases')]"));
				//Scroll the page till the Inventory Menu Items option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Purchases Option		
				driver.findElement(By.xpath("//span[contains(.,'Purchases')]")).click();
				Thread.sleep(5000);
				
		        //Click the Purchases Order Option		
				driver.findElement(By.xpath("//span[contains(.,'Purchase Templates')]")).click();
				Thread.sleep(5000);
				
				//Check Storage Locations page opened or not
				if(driver.findElement(By.xpath("//a[.='Purchase order templates']")).getText().equalsIgnoreCase("Purchase order templates"))
				{
					test.log(LogStatus.PASS, "Purchase order template page Successfully loaded");
				}
				else
				{
					test.log(LogStatus.FAIL, "Purchase order template page loaded Failed");
				}
				
				Thread.sleep(5000);
				
			}
			
			@Test(priority=4)
			public void Inventory_Purchase_Purchase_Template_add_new(WebDriver driver) throws Exception
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(5000);
				//Click the Purchase Order Template
				driver.findElement(By.id("purchaseTemplates")).click();
				
				Thread.sleep(2000);
				//Check whether the new form is loaded or not
				if(driver.findElement(By.xpath("//span[contains(.,'New Purchase Order Template')]")).isDisplayed())
				{
					test.log(LogStatus.PASS, "New Purchase Order Template form loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "New Purchase Order Template form loaded Fail");
				}
				Thread.sleep(2000);
				
				//Clear the name field
				driver.findElement(By.id("name")).clear();
				//Enter the Required Name
				driver.findElement(By.id("name")).sendKeys(Utility.getProperty("Inventory_Purchase_Order_Template_Name"));
				
				Thread.sleep(1500);
				//Click the Vendor Name
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div/div[2]/div/div/div/a")).click();
				//Enter the Required Vendor
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div/div[2]/div/div/div/div/div/input")).sendKeys("Sysco Food");
				//Press the Enter button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Add Inventory Item
				driver.findElement(By.xpath("//i[@class='fa fa-plus-circle ng-binding']")).click();
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(10000);
				//Click the Inventory Item Option
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/a")).click();
				//Enter the Required Inventory Option
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/div/div/input")).click();
				//Press the Enter button
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(1000);
				//Clear the Quantity
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/input")).clear();
				//Enter the Required Quantity
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/input")).sendKeys("2");
				
				Thread.sleep(5000);
				//Add Inventory Item
				driver.findElement(By.xpath("//i[@class='fa fa-plus-circle ng-binding']")).click();
				
				//Click the Close button
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[6]/a/i")).click();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.END);
				Thread.sleep(2000);
				//Click the Place Order Option
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(2500);
				//Check whether the order is placed or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Purchase template Saved Successfully!."))
				{
					test.log(LogStatus.PASS, "Purchase order template saved Sucessfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Purchase order template saved Failed");
				}
				Thread.sleep(5000);
		
			}
			
			@Test(priority=5)
			public void Inventory_Purchase_Purchase_Template_edit(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Clear the Search Field
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
				//Enter the required Keyword
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_Purchase_Order_Template_Name"));
				
				Thread.sleep(1000);
				//Click the Edit button
				driver.findElement(By.xpath("//i[@class='fa fa-pencil']")).click();
				
				Thread.sleep(2000);
				Thread.sleep(1000);
				//Clear the Quantity
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/input")).clear();
				//Enter the Required Quantity
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/input")).sendKeys("3");
		
				
				Thread.sleep(2000);
				//Add Inventory Item
				driver.findElement(By.xpath("//i[@class='fa fa-plus-circle ng-binding']")).click();
				
				Thread.sleep(7500);
				//Click the Inventory Item Option
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[1]/div/a")).click();
				//Enter the Required Inventory Option
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[1]/div/div/div/input")).sendKeys("Inve Item");
				//Press the Enter button
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(1000);
				//Clear the Quantity
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[3]/input")).clear();
				//Enter the Required Quantity
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[3]/input")).sendKeys("2");
				
				Thread.sleep(3000);
				//Click the Update button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(2500);
				//Check whether the order is placed or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Purchase template updated successfully!."))
				{
					test.log(LogStatus.PASS, "Purchase order template updated Sucessfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Purchase order template updated Failed");
				}
				Thread.sleep(5000);
				
			}
			
			@Test(priority=7)
			public void Inventory_Purchase_Purchase_Template_verify_Purchase_Order_Button(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Clear the Search Field
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
				//Enter the required Keyword
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_Purchase_Order_Template_Name"));
				
				Thread.sleep(1000);
				//Click the purchase order button
				driver.findElement(By.xpath("//i[@class='fa fa-file-archive-o']")).click();
				
				Thread.sleep(8000);
				Thread.sleep(1500);
				//Clear the Expecting Date
				driver.findElement(By.name("expectingDate")).clear();
				//Enter the Required Date
				driver.findElement(By.name("expectingDate")).sendKeys("21-Dec-2020");
				
				Thread.sleep(5000);
				//Select the required placed order via option
				Select placeOrederVia = new Select(driver.findElement(By.name("placedVia")));
				placeOrederVia.selectByVisibleText("Email");
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
				Thread.sleep(3000);
				//Click the Place Order Option
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(2500);
				//Check whether the order is placed or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Purchase order saved successfully!."))
				{
					test.log(LogStatus.PASS, "Purchase order saved Sucessfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Purchase order saved Failed");
				}
				Thread.sleep(5000);
				
		        //Click the Purchases Order Template Option		
				driver.findElement(By.xpath("//span[contains(.,'Purchase Templates')]")).click();
			}
			
			@Test(priority=6)
			public void Inventory_Purchase_Purchase_Template_delete(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Clear the Search Field
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
				//Enter the required Keyword
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Inventory_Purchase_Order_Template_Name"));
				
				Thread.sleep(1000);
				//Click the delete purchase order button
				driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
				
				Thread.sleep(2000);
				//Click the Yes button
				driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
				
				Thread.sleep(2500);
				//Check whether the order is placed or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("purchase template InActivated successfully"))
				{
					test.log(LogStatus.PASS, "Purchase order deleted Sucessfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Purchase order deleted Failed");
				}
				Thread.sleep(5000);
				
				//Click the Active button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[1]/input")).click();
				
				Thread.sleep(3000);
				//Click the active symbol
				driver.findElement(By.xpath("//i[@class='fa fa-check']")).click();
				
				Thread.sleep(2000);
				//Click the Yes button
				driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
				
				Thread.sleep(2500);
				//Check whether the order is placed or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("purchase template Activated successfully"))
				{
					test.log(LogStatus.PASS, "Purchase order activated Sucessfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Purchase order activated Failed");
				}
				Thread.sleep(5000);
			}
			
			@Test(priority=8)
			public void Inventory_Purchase_Purchase_Template_verifyActive_InActiveButton_Sub_Recipe(WebDriver driver) throws Exception
			{
				Thread.sleep(8000);
				//Clear the search field
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
				
				Thread.sleep(5000);
				//Click Active or In Active Button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[1]/input")).click();
		
				Thread.sleep(5000);
				//Check the Inactive page is loaded or not
				if(driver.findElement(By.xpath("//i[@class='fa fa-check']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "We are in InActive Page");
					Thread.sleep(10000);
					//Click Active or In Active Button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[1]/input")).click();
		
				}
				else
				{
					test.log(LogStatus.FAIL, "We are in Active Page but User Click the Inactive Page");
				}
				Thread.sleep(5000);
			}
			
			@Test(priority=9)
			public void Inventory_Purchase_Purchase_Order_Openpage(WebDriver driver) throws Exception
			{
				/*//Click the Inventory option
				driver.findElement(By.xpath("//span[.='Inventory']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[contains(.,'Purchases')]"));
				//Scroll the page till the Inventory Menu Items option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Purchases Option		
				driver.findElement(By.xpath("//span[contains(.,'Purchases')]")).click();
				Thread.sleep(5000);*/
				
				//Get the URl
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"purchaseOrders");
		
		        //Click the Purchases Order Option		
				driver.findElement(By.xpath("//span[contains(.,'Purchase Orders')]")).click();
				Thread.sleep(5000);
				
				//Check Storage Locations page opened or not
				if(driver.findElement(By.xpath("//a[.='Purchase orders']")).getText().equalsIgnoreCase("Purchase orders"))
				{
					test.log(LogStatus.PASS, "Purchase orders page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Purchase orders page loaded Failed");
				}
				
				Thread.sleep(5000);
				
			}
			
			@Test(priority=10)
			public void Inventory_Purchase_Purchase_Order_Purchase_Orders_new_Print_add(WebDriver driver) throws Exception
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			    
				Thread.sleep(5000);
				//Click the add purchase order option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/span/a")).click();
				
				Thread.sleep(2000);
				//Click the Vendor Option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[1]/div[1]/div/div/a")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[1]/div[1]/div/div/div/div/input")).sendKeys("Sysco Food");
				//Press the Enter button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(1500);
				//Clear the Expecting Date
				driver.findElement(By.name("expectingDate")).clear();
				//Enter the Required Date
				driver.findElement(By.name("expectingDate")).sendKeys("21-Dec-2030");
				
				Thread.sleep(5000);
				//Select the required placed order via option
				Select placeOrederVia = new Select(driver.findElement(By.name("placedVia")));
				placeOrederVia.selectByVisibleText("Email");
				
		/*		Thread.sleep(1500);
				//Clear the CC Option
				driver.findElement(By.name("storePoEmails")).clear();
				//Enter the required mail id to send the mail
				driver.findElement(By.name("storePoEmails")).sendKeys("testpurchaseorder@mail.com");
		*/		
				Thread.sleep(2000);
				//Add Inventory Item
				driver.findElement(By.xpath("//i[@class='fa fa-plus-circle ng-binding']")).click();
				
				Thread.sleep(1500);
				//Click the Inventory Item Option
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/a")).click();Thread.sleep(1500);
				//Enter the Required Inventory Option
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/div/div/input")).click();
				//Press the Enter button
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(1000);
				//Clear the Quantity
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/input")).clear();
				//Enter the Required Quantity
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/input")).sendKeys("2");
				
				Thread.sleep(2000);
				//Add Inventory Item
				driver.findElement(By.xpath("//i[@class='fa fa-plus-circle ng-binding']")).click();
				
				//Click the Close button
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[6]/a/i")).click();
		
				
				Thread.sleep(5000);
				//Click the Place Order Option
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				
				Thread.sleep(2500);
				//Check whether the order is placed or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Purchase order saved successfully!."))
				{
					test.log(LogStatus.PASS, "Purchase order saved Sucessfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Purchase order saved Failed");
				}
				Thread.sleep(5000);
				
				
				//Clear the Search Field
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
				//Enter the Required Keyword
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Sysco Food");
				
				Thread.sleep(5000);
				//Click the Cancel Order Option
				driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]/a[3]")).click();
				
				Thread.sleep(2000);
				//Click the Yes Button
				driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
				
				Thread.sleep(2500);
				//Check whether the Receive information updated or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Purchase order updated."))
				{
					test.log(LogStatus.PASS, "Purchase order updated Sucessfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Purchase order updated Failed");
				}
				Thread.sleep(5000);
				
				//Clear the Search Field
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
				//Enter the Required Keyword
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Sysco Food");
				
				Thread.sleep(1500);
				//Check whether the order is canceled or not
				if(driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText().equalsIgnoreCase("CANCELED"))
				{
					test.log(LogStatus.PASS, "Purchase order CANCELED Sucessfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Purchase order CANCELED Failed");
				}
				Thread.sleep(5000);
			}
			
			@Test(priority=11)
			public void Inventory_Purchase_Purchase_Order_add_new_Purchase_Orders_email(WebDriver driver) throws Exception
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			    
				Thread.sleep(5000);
				//Click the add purchase order option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/span/a")).click();
				
				Thread.sleep(2000);
				//Click the Vendor Option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[1]/div[1]/div/div/a")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[1]/div[1]/div/div/div/div/input")).sendKeys("Sysco Food");
				//Press the Enter button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(1500);
				//Clear the Expecting Date
				driver.findElement(By.name("expectingDate")).clear();
				//Enter the Required Date
				driver.findElement(By.name("expectingDate")).sendKeys("21-Dec-2020");
				
				Thread.sleep(5000);
				//Select the required placed order via option
				Select placeOrederVia = new Select(driver.findElement(By.name("placedVia")));
				placeOrederVia.selectByVisibleText("Email");
				
				Thread.sleep(1500);
				//Clear the CC Option
				driver.findElement(By.name("storePoEmails")).clear();
				//Enter the required mail id to send the mail
				driver.findElement(By.name("storePoEmails")).sendKeys("testpurchaseorder@mail.com");
				
				Thread.sleep(2000);
				//Add Inventory Item
				driver.findElement(By.xpath("//i[@class='fa fa-plus-circle ng-binding']")).click();
				
				Thread.sleep(1500);
				//Click the Inventory Item Option
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/a")).click();
				//Enter the Required Inventory Option
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/div/div/input")).click();
				//Press the Enter button
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(1000);
				//Clear the Quantity
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/input")).clear();
				//Enter the Required Quantity
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]/input")).sendKeys("2");
				
				Thread.sleep(2000);
				//Add Inventory Item
				driver.findElement(By.xpath("//i[@class='fa fa-plus-circle ng-binding']")).click();
				
				//Click the Close button
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[6]/a/i")).click();
				
				Thread.sleep(2000);
				//Click the Place Order Option
				driver.findElement(By.xpath("//button[@class='btn btn-small btn-success ng-binding']")).click();
				
				Thread.sleep(2500);
				//Check whether the order is placed or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Purchase order saved successfully!."))
				{
					test.log(LogStatus.PASS, "Purchase order saved Sucessfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Purchase order saved Failed");
				}
				Thread.sleep(5000);
				
				//Clear the Search Field
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
				//Enter the Required Keyword
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Sysco Food");
				
				Thread.sleep(1500);
				//Click the Receiving Order Option
				driver.findElement(By.cssSelector("i.fa.fa-recycle")).click();
				
				Thread.sleep(2000);
				//Clear the value of Price/Unit option
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[5]/input")).clear();
				//Enter the required amount
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[5]/input")).sendKeys("1500");
				
				//CLear the Received Quantity Option
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[6]/input")).clear();
				//Enter the Required Quantity
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[6]/input")).sendKeys("3");
				
				Thread.sleep(1000);
				//Click the Cancel Button
				driver.findElement(By.xpath("//a[.='Cancel']")).click();
				
				Thread.sleep(4000);
				//Clear the Search Field
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
				//Enter the Required Keyword
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Sysco Food");
				
				Thread.sleep(1500);
				//Click the Receiving Order Option
				driver.findElement(By.cssSelector("i.fa.fa-recycle")).click();
				
				Thread.sleep(2000);
				//Clear the value of Price/Unit option
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[5]/input")).clear();
				//Enter the required amount
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[5]/input")).sendKeys("1500");
				
				//Clear the Received Quantity Option
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[6]/input")).clear();
				//Enter the Required Quantity
				driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[6]/input")).sendKeys("3");
		
				Thread.sleep(2000);
				//Click the Submit button
				driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
				
				Thread.sleep(2500);
				//Check whether the Receive information updated or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Receive information updated."))
				{
					test.log(LogStatus.PASS, "Receive information updated Sucessfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Receive information updated Failed");
				}
				Thread.sleep(5000);
				//Clear the Search Field
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
				//Enter the Required Keyword
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Sysco Food");
				
				Thread.sleep(1500);
				//Check whether the order is canceled or not
				if(driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText().equalsIgnoreCase("RECEIVED"))
				{
					test.log(LogStatus.PASS, "Purchase order RECEIVED Sucessfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Purchase order RECEIVED Failed");
				}
				Thread.sleep(5000);
				
				Thread.sleep(5000);
				//Clear the Search Field
				driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			}
			
			@Test(priority=12)
			public void Inventory_Purchase_Purchase_Order_cancelButton(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Click the add purchase order option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/span/a")).click();
				
				Thread.sleep(2000);
				//Click the Vendor Option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[1]/div[1]/div/div/a")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[1]/div[1]/div/div/div/div/input")).sendKeys("Sysco Food");
				//Press the Enter button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(1500);
				//Clear the Expecting Date
				driver.findElement(By.name("expectingDate")).clear();
				//Enter the Required Date
				driver.findElement(By.name("expectingDate")).sendKeys("21-Dec-2020");
				
				//Select the required placed order via option
				Select placeOrederVia = new Select(driver.findElement(By.name("placedVia")));
				placeOrederVia.selectByVisibleText("Email");
				
				Thread.sleep(2000);
				//Click the Cancel button
				driver.findElement(By.xpath("//a[.='Cancel']")).click();
				
				Thread.sleep(3000);
				//Check whether the add purchase order option is present or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/span/a")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Cancel button works fine");
				}
				else
				{
					test.log(LogStatus.FAIL, "Cancel button works fail");
				}
				
			}
		
			@Test(priority=13)
			public void Inventory_Purchase_Receive_Inventory_Item_Openpage(WebDriver driver) throws Exception
			{
				/*//Click the Inventory option
				driver.findElement(By.xpath("//span[.='Inventory']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[contains(.,'Purchases')]"));
				//Scroll the page till the Inventory Items option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Inventory Items Option		
				driver.findElement(By.xpath("//span[contains(.,'Purchases')]")).click();
				 //driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[4]/ul/li[11]/a/i")).click();
				*/
				//Get the URl
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"receivedLogs");
				
				Thread.sleep(5000);
				//Check Inventory Items page opened or not
				if(driver.findElement(By.xpath("//a[.='Received Log']")).getText().equalsIgnoreCase("Received Log"))
				{
					test.log(LogStatus.PASS, "Purchase page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Purchase Inventory page loaded Failed");
				}
				
				Thread.sleep(5000);
				
			}
		
			@Test(priority=14)
			public void Inventory_Purchase_Receive_Inventory_Item_Update(WebDriver driver) throws Exception
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(3000);
				//Click Receive Inventory
				driver.findElement(By.xpath("//span[contains(.,'Receive Inventory Item')]")).click();
				
		/*		Thread.sleep(2000);
				//Clear the Barcode option
				driver.findElement(By.name("name")).clear();
				//Enter the Barcode option
			    driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Receive_Barcode"));*/
			  
			    //Click Inventory item
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div[2]/div/div[2]/form/div[1]/div[1]/div[2]/div/div/a")).click();Thread.sleep(1000);
				//Click the inventory item, input field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div[2]/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/input")).click();
				//Press the Enter button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div[2]/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			   
			    
		/*	    Thread.sleep(3000);
			    //Change the quantity
			    driver.findElement(By.name("quantity")).clear();
			    //Enter the quantity
			    driver.findElement(By.name("quantity")).sendKeys("2");*/
					    
			   
			    Thread.sleep(5000);
			    //Click save and continue button
			    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div[2]/div/div[2]/form/div[3]/div/div/button")).click();
				
			    Thread.sleep(5000);
				//Check Receive Inventory saved or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("purchase item saved successfully"))
				{
					test.log(LogStatus.PASS, "purchase item saved successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "purchase item saved Failed");
				}
				
				Thread.sleep(5000);
			}
			
			@Test(priority=15)
			public void Inventory_Purchase_Prepare_Subrecipe_Openpage(WebDriver driver) throws Exception
			{
		/*		//Click the Inventory option
				driver.findElement(By.xpath("//span[.='Inventory']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[contains(.,'Purchases')]"));
				//Scroll the page till the Inventory Items option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Inventory Items Option		
				driver.findElement(By.xpath("//span[contains(.,'Purchases')]")).click();
				 //driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[4]/ul/li[11]/a/i")).click();
				*/
				//Get the URl
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"receivedLogs");
				Thread.sleep(5000);
				//Check Inventory Items page opened or not
				if(driver.findElement(By.xpath("//a[.='Received Log']")).getText().equalsIgnoreCase("Received Log"))
				{
					test.log(LogStatus.PASS, "Purchase page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Purchase Inventory page loaded Failed");
				}
				
				Thread.sleep(5000);
				
			}
		
			@Test(priority=16)
			public void Inventory_Purchase_Prepare_Subrecipe_Update(WebDriver driver) throws Exception
			{
				Thread.sleep(3000);
				//Click Prepare SubRecipe
				driver.findElement(By.xpath("//span[contains(.,'Prepare SubRecipe')]")).click();
				
				Thread.sleep(8000);
				//Click the SubRecipe option
				driver.findElement(By.xpath("//div[@id='subRecipe_chosen']/a")).click();
				Thread.sleep(6000);
				//Enter the SubRecipe option
			    driver.findElement(By.xpath("//div[@id='subRecipe_chosen']/div/div/input")).sendKeys(Utility.getProperty("subRecipe_name"));
			  //Enter the SubRecipe option
			   driver.findElement(By.xpath("//div[@id='subRecipe_chosen']/div/div/input")).sendKeys(Keys.ENTER);
			    
			   Thread.sleep(2000);
				//Clear the quantity option
				driver.findElement(By.name("quantity")).clear();
				Thread.sleep(2000);
				//Enter the quantity option
			    driver.findElement(By.name("quantity")).sendKeys("2");
		
			    
				//Thread.sleep(4000);
						//Click the primary storage
						//driver.findElement(By.xpath("//div[@id='psl_chosen']/a")).click();
						//Thread.sleep(2000);
						//Enter the primary storage
					   // driver.findElement(By.xpath("//div[@id='psl_chosen']/div/div/input")).sendKeys(Utility.getProperty("Inventory_Primary_Storage_Name"));
					  //Enter the primary storage
					   //driver.findElement(By.xpath("//div[@id='psl_chosen']/div/div/input")).sendKeys(Keys.ENTER);
				
			    Thread.sleep(2000);
			 //Click New primary storage
			 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[2]/form/div[1]/div[2]/div[2]/a/i")).click();
							
						Thread.sleep(2000);
						//Check New primary storage	page loaded successfully or not
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Storage"))
						{
							test.log(LogStatus.PASS, "New primary storage page loaded successfully");
						}
						else
						{
							test.log(LogStatus.FAIL, "New primary storage page loaded Failed");
						}
						
					 
						Thread.sleep(2000);
					 //Click the New primary storage
					driver.findElement(By.name("masterName")).clear();
					Thread.sleep(2000);
					//Enter the New primary storage	    
					driver.findElement(By.name("masterName")).sendKeys(Utility.getProperty("Inventory_Primary_Storage_Name"));	  
			
					 	
					Thread.sleep(4000);
					//Click the New primary storage
						driver.findElement(By.name("description")).clear();
						Thread.sleep(2000);
						//Enter the New primary storage	    
						driver.findElement(By.name("description")).sendKeys("Need a place to keep");	  
					
						 
						Thread.sleep(3000);
						//Click the Save button
						driver.findElement(By.cssSelector("button.btn.btn-success.btn-small.ng-binding")).click();
								
				
					Thread.sleep(2000);
					//Check New primary storage	page loaded successfully or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/h3/span/span")).getText().equalsIgnoreCase("Prepare SubRecipe"))
					{
						test.log(LogStatus.PASS, "Prepare SubRecipe page loaded successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Prepare SubRecipe page loaded Failed");
					}
					
					Thread.sleep(4000);
					//Click the Secondary storage
					driver.findElement(By.xpath("//div[@id='ssl_chosen']/a")).click();
					Thread.sleep(2000);
					//Enter the Secondary storage
				    driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys(Utility.getProperty("Inventory_Secondary_Storage_Name"));
				  //Enter the Secondary storage
				   driver.findElement(By.xpath("//div[@id='ssl_chosen']/div/div/input")).sendKeys(Keys.ENTER);
				   
		/*		 //Click New Secondary storage
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[2]/form/div[1]/div[3]/div[2]/a/i")).click();
						
					Thread.sleep(2000);
					//Check New Secondary storage	page loaded successfully or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Storage"))
					{
						test.log(LogStatus.PASS, "New Secondary storage page loaded successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "New Secondary storage page loaded Failed");
					}
					
				 
					Thread.sleep(2000);
				 //Click the New Secondary storage
				driver.findElement(By.name("masterName")).clear();
				Thread.sleep(2000);
				//Enter the New Secondary storage	    
				driver.findElement(By.name("masterName")).sendKeys(Utility.getProperty("Inventory_Primary_Storage_Name")+"1");	  
				//Enter the New Secondary storage 	                          
				driver.findElement(By.name("masterName")).sendKeys(Keys.ENTER);
				 	
				Thread.sleep(2000);
				//Click the New Secondary storage
					driver.findElement(By.name("description")).clear();
					Thread.sleep(2000);
					//Enter the New Secondary storage	    
					driver.findElement(By.name("description")).sendKeys("Need a place to keep");	  
					//Enter the New Secondary storage 	                          
					driver.findElement(By.name("description")).sendKeys(Keys.ENTER);
					 
					Thread.sleep(3000);
					//Click the Save button
						driver.findElement(By.xpath("//button[@type='submit']")).click();
							
				
				Thread.sleep(2000);
				//Check New Secondary storage page loaded successfully or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Storage"))
				{
					test.log(LogStatus.PASS, "New Secondary storage page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "New Secondary storage page loaded Failed");
				}*/
		
				
			
			   
			  //Click the Save button
			 //driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[2]/form/div[2]/div/div/button")).click();
				 Thread.sleep(5000);
			 driver.findElement(By.xpath("//span[.='Save and Continue']")).click();
			
			  Thread.sleep(5000);
				//Check Receive Inventory saved or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub recipe prepared successfully"))
				{
					test.log(LogStatus.PASS, "Sub recipe prepared successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Sub recipe prepared Failed");
				}
				
				Thread.sleep(8000);
			}
		
			@Test(priority=17)
			public void Inventory_Purchase_Received_Logs_openpage(WebDriver driver) throws Exception
			{
				/*//Click the Inventory option
				driver.findElement(By.xpath("//span[.='Inventory']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[contains(.,'Purchases')]"));
				//Scroll the page till the Inventory Menu Items option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Purchases Option		
				driver.findElement(By.xpath("//span[contains(.,'Purchases')]")).click();
				Thread.sleep(5000);
				
		        //Click the Purchases Order Option		
				driver.findElement(By.xpath("//span[contains(.,'Received Logs')]")).click();
				Thread.sleep(5000);
				*/
				Thread.sleep(5000);
				//Get the URl
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"receivedLogs");
						
						
				//Check Storage Locations page opened or not
				if(driver.findElement(By.xpath("//a[.='Received Log']")).getText().equalsIgnoreCase("Received Log"))
				{
					test.log(LogStatus.PASS, "Received Log page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Received Log page loaded Failed");
				}
				
				Thread.sleep(5000);
			}
			
			@Test(priority=18)
			public void Inventory_Purchase_Received_Logs_verify_All_All(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Select the Required Type
				Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
				type.selectByVisibleText("All");
				
				Thread.sleep(2000);
				//Select the Consumption Option
				Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[2]/div/div/select")));
				consumptionStatus.selectByVisibleText("All");
				
				Thread.sleep(2000);
				//Select the Time Period Option
				Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(1500);
				//Clear the Date Range from Option
				driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));
		
				Thread.sleep(1500);
				//Clear the Date Range To Option
				driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
				
				Thread.sleep(1000);
				//Click the Search button
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				Thread.sleep(10000);
				try
				{
					//Check whether the Received Items are Loaded Or not
					if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for All(All)");
					}
				}
				catch(Exception e)//else// if(driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr/td[1]")) != null)
				{
					test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for All(All)");
					test.log(LogStatus.INFO, "**********   The below is for All filter data   **********");
					List<WebElement> data = driver.findElements(By.xpath("//table[@ng-table='tableParams']/tbody/tr/td[1]"));
					data.size();
					
					for(int i=1;i<=data.size();i++)
					{
						test.log(LogStatus.INFO, "Name : "+driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[1]")).getText()+", Type : "+driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[2]")).getText());
					}
					
				}
		/*		else
				{
					test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for All(All)");
				}*/
							
			}
			
			@Test(priority=19)
			public void Inventory_Purchase_Received_Logs_verify_All_NotStarted(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Select the Required Type
				Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
				type.selectByVisibleText("All");
				
				Thread.sleep(2000);
				//Select the Consumption Option
				Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[2]/div/div/select")));
				consumptionStatus.selectByVisibleText("Not Started");
				
				Thread.sleep(2000);
				//Select the Time Period Option
				Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(1500);
				//Clear the Date Range from Option
				driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));
		
				Thread.sleep(1500);
				//Clear the Date Range To Option
				driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
				
				Thread.sleep(1000);
				//Click the Search button
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				Thread.sleep(10000);
				//Check whether the Received Items are Loaded Or not
				try
				{
					if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Not Started(All)");
					}
				}
				catch (Exception e)
				{
				
					test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Not Started(All)");			
				
				}
		
							
			}
			
			@Test(priority=20)
			public void Inventory_Purchase_Received_Logs_verify_All_Progress(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Select the Required Type
				Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
				type.selectByVisibleText("All");
				
				Thread.sleep(2000);
				//Select the Consumption Option
				Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[2]/div/div/select")));
				consumptionStatus.selectByVisibleText("Progress");
				
				Thread.sleep(2000);
				//Select the Time Period Option
				Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(1500);
				//Clear the Date Range from Option
				driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));
		
				Thread.sleep(1500);
				//Clear the Date Range To Option
				driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
				
				Thread.sleep(1000);
				//Click the Search button
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				Thread.sleep(10000);
				//Check whether the Received Items are Loaded Or not
				try
				{
					if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Progress(All)");
					}
				}
				catch (Exception e)
				{
				
					test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Progress(All)");			
				
				}
							
			}
			
			@Test(priority=21)
			public void Inventory_Purchase_Received_Logs_verify_All_Finished(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Select the Required Type
				Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
				type.selectByVisibleText("All");
				
				Thread.sleep(2000);
				//Select the Consumption Option
				Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[2]/div/div/select")));
				consumptionStatus.selectByVisibleText("Finished");
				
				Thread.sleep(2000);
				//Select the Time Period Option
				Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(1500);
				//Clear the Date Range from Option
				driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));
		
				Thread.sleep(1500);
				//Clear the Date Range To Option
				driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
				
				Thread.sleep(1000);
				//Click the Search button
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				Thread.sleep(10000);
				//Check whether the Received Items are Loaded Or not
				try
				{
					if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Finished(All)");
					}
				}
				catch (Exception e)
				{
					test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Finished(All)");			
				}
		
							
			}
			
			@Test(priority=22)
			public void Inventory_Purchase_Received_Logs_verify_All_NotFinished(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Select the Required Type
				Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
				type.selectByVisibleText("All");
				
				Thread.sleep(2000);
				//Select the Consumption Option
				Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[2]/div/div/select")));
				consumptionStatus.selectByVisibleText("Not Finished");
				
				Thread.sleep(2000);
				//Select the Time Period Option
				Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(1500);
				//Clear the Date Range from Option
				driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));
		
				Thread.sleep(1500);
				//Clear the Date Range To Option
				driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
				
				Thread.sleep(1000);
				//Click the Search button
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				Thread.sleep(10000);
				//Check whether the Received Items are Loaded Or not
				try
				{
					if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Not Finished(All)");
					}
				}
				catch (Exception e)
				{
					test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Not Finished(All)");			
				}
		
							
			}
			
			@Test(priority=23)
			public void Inventory_Purchase_Received_Logs_verify_Inv_All(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Select the Required Type
				Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
				type.selectByVisibleText("Inventory Item");
				
				Thread.sleep(1000);
				//Click the Category Option
				driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
				//Enter the required Keyword
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(1000);
				//Click the Inventory Item Option
				driver.findElement(By.xpath("//form/div[3]/div/div/div/a")).click();
				//Enter the required Keyword
				driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Select the Consumption Option
				Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
				consumptionStatus.selectByVisibleText("All");
				
				Thread.sleep(2000);
				//Select the Time Period Option
				Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[5]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(1500);
				//Clear the Date Range from Option
				driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));
		
				Thread.sleep(1500);
				//Clear the Date Range To Option
				driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
				
				Thread.sleep(1000);
				//Click the Search button
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				Thread.sleep(10000);
				//Check whether the Received Items are Loaded Or not
				try
				{
					if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for All(Inventory Item)");
					}
				}
				catch (Exception e)
				{
					test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for All(Inventory Item)");			
				}
		
							
			}
			
			@Test(priority=24)
			public void Inventory_Purchase_Received_Logs_verify_Inv_NotStarted(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Select the Required Type
				Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
				type.selectByVisibleText("Inventory Item");
				
				Thread.sleep(1000);
				//Click the Category Option
				driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
				//Enter the required Keyword
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(1000);
				//Click the Inventory Item Option
				driver.findElement(By.xpath("//form/div[3]/div/div/div/a")).click();
				//Enter the required Keyword
				driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Select the Consumption Option
				Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
				consumptionStatus.selectByVisibleText("Not Started");
				
				Thread.sleep(2000);
				//Select the Time Period Option
				Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[5]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(1500);
				//Clear the Date Range from Option
				driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));
		
				Thread.sleep(1500);
				//Clear the Date Range To Option
				driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
				
				Thread.sleep(1000);
				//Click the Search button
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				Thread.sleep(10000);
				//Check whether the Received Items are Loaded Or not
				try
				{
					if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Not Started(Inventory Item)");
					}
				}
				catch (Exception e)
				{
					test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Not Started(Inventory Item)");			
				}
		
							
			}
			
			@Test(priority=25)
			public void Inventory_Purchase_Received_Logs_verify_Inv_Progress(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Select the Required Type
				Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
				type.selectByVisibleText("Inventory Item");
				
				Thread.sleep(1000);
				//Click the Category Option
				driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
				//Enter the required Keyword
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(1000);
				//Click the Inventory Item Option
				driver.findElement(By.xpath("//form/div[3]/div/div/div/a")).click();
				//Enter the required Keyword
				driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Select the Consumption Option
				Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
				consumptionStatus.selectByVisibleText("Progress");
				
				Thread.sleep(2000);
				//Select the Time Period Option
				Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[5]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(1500);
				//Clear the Date Range from Option
				driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));
		
				Thread.sleep(1500);
				//Clear the Date Range To Option
				driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
				
				Thread.sleep(1000);
				//Click the Search button
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				Thread.sleep(10000);
				//Check whether the Received Items are Loaded Or not
				try
				{
					if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Progress(Inventory Item)");
					}
				}
				catch (Exception e)
				{
					test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Progress(Inventory Item)");			
				}
		
							
			}
			
			@Test(priority=26)
			public void Inventory_Purchase_Received_Logs_verify_Inv_Finished(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Select the Required Type
				Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
				type.selectByVisibleText("Inventory Item");
				
				Thread.sleep(1000);
				//Click the Category Option
				driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
				//Enter the required Keyword
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(1000);
				//Click the Inventory Item Option
				driver.findElement(By.xpath("//form/div[3]/div/div/div/a")).click();
				//Enter the required Keyword
				driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Select the Consumption Option
				Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
				consumptionStatus.selectByVisibleText("Finished");
				
				Thread.sleep(2000);
				//Select the Time Period Option
				Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[5]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(1500);
				//Clear the Date Range from Option
				driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));
		
				Thread.sleep(1500);
				//Clear the Date Range To Option
				driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
				
				Thread.sleep(1000);
				//Click the Search button
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				Thread.sleep(10000);
				//Check whether the Received Items are Loaded Or not
				try
				{
					if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Finished(Inventory Item)");
					}
				}
				catch (Exception e)
				{
					test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Finished(Inventory Item)");			
				}
		
							
			}
			
			@Test(priority=27)
			public void Inventory_Purchase_Received_Logs_verify_Inv_NotFinished(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Select the Required Type
				Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
				type.selectByVisibleText("Inventory Item");
				
				Thread.sleep(1000);
				//Click the Category Option
				driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
				//Enter the required Keyword
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(1000);
				//Click the Inventory Item Option
				driver.findElement(By.xpath("//form/div[3]/div/div/div/a")).click();
				//Enter the required Keyword
				driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Select the Consumption Option
				Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
				consumptionStatus.selectByVisibleText("Not Finished");
				
				Thread.sleep(2000);
				//Select the Time Period Option
				Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[5]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(1500);
				//Clear the Date Range from Option
				driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));
		
				Thread.sleep(1500);
				//Clear the Date Range To Option
				driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
				
				Thread.sleep(1000);
				//Click the Search button
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				Thread.sleep(10000);
				//Check whether the Received Items are Loaded Or not
				try
				{
					if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Not Finished(Inventory Item)");
					}
				}
				catch (Exception e)
				{
					test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Not Finished(Inventory Item)");			
				}
							
			}
			
			@Test(priority=28)
			public void Inventory_Purchase_Received_Logs_verify_SubRecipe_All(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Select the Required Type
				Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
				type.selectByVisibleText("Sub Recipe");
				
				Thread.sleep(1000);
				//Click the Sub Recipe Option
				driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
				//Enter the required Keyword
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
					
				Thread.sleep(2000);
				//Select the Consumption Option
				Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
				consumptionStatus.selectByVisibleText("All");
				
				Thread.sleep(2000);
				//Select the Time Period Option
				Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(1500);
				//Clear the Date Range from Option
				driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));
		
				Thread.sleep(1500);
				//Clear the Date Range To Option
				driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
				
				Thread.sleep(1000);
				//Click the Search button
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				Thread.sleep(10000);
				//Check whether the Received Items are Loaded Or not
				try
				{
					if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for All(Sub Recipe)");
					}
				}
				catch (Exception e)
				{
					test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for All(Sub Recipe)");			
				}
		
							
			}
			
			@Test(priority=29)
			public void Inventory_Purchase_Received_Logs_verify_SubRecipe_NotStarted(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Select the Required Type
				Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
				type.selectByVisibleText("Sub Recipe");
				
				Thread.sleep(1000);
				//Click the Sub Recipe Option
				driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
				//Enter the required Keyword
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
					
				Thread.sleep(2000);
				//Select the Consumption Option
				Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
				consumptionStatus.selectByVisibleText("Not Started");
				
				Thread.sleep(2000);
				//Select the Time Period Option
				Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(1500);
				//Clear the Date Range from Option
				driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));
		
				Thread.sleep(1500);
				//Clear the Date Range To Option
				driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
				
				Thread.sleep(1000);
				//Click the Search button
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				Thread.sleep(10000);
				//Check whether the Received Items are Loaded Or not
				try
				{
					if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Not Started(Sub Recipe)");
					}
				}
				catch (Exception e)
				{
					test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Not Started(Sub Recipe)");			
				}
		
							
			}
			
			@Test(priority=30)
			public void Inventory_Purchase_Received_Logs_verify_SubRecipe_Progress(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Select the Required Type	
				Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
				type.selectByVisibleText("Sub Recipe");
				
				Thread.sleep(1000);
				//Click the Sub Recipe Option
				driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
				//Enter the required Keyword
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
					
				Thread.sleep(2000);
				//Select the Consumption Option
				Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
				consumptionStatus.selectByVisibleText("Progress");
				
				Thread.sleep(2000);
				//Select the Time Period Option
				Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(1500);
				//Clear the Date Range from Option
				driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));
		
				Thread.sleep(1500);
				//Clear the Date Range To Option
				driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
				
				Thread.sleep(1000);
				//Click the Search button
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				Thread.sleep(10000);
				//Check whether the Received Items are Loaded Or not
				try
				{
					if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Progress(Sub Recipe)");
					}
				}
				catch (Exception e)
				{
					test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Progress(Sub Recipe)");			
				}
							
			}
			
			@Test(priority=31)
			public void Inventory_Purchase_Received_Logs_verify_SubRecipe_Finished(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Select the Required Type	
				Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
				type.selectByVisibleText("Sub Recipe");
				
				Thread.sleep(1000);
				//Click the Sub Recipe Option
				driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
				//Enter the required Keyword
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
					
				Thread.sleep(2000);
				//Select the Consumption Option
				Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
				consumptionStatus.selectByVisibleText("Finished");
				
				Thread.sleep(2000);
				//Select the Time Period Option
				Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(1500);
				//Clear the Date Range from Option
				driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));
		
				Thread.sleep(1500);
				//Clear the Date Range To Option
				driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
				
				Thread.sleep(1000);
				//Click the Search button
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				Thread.sleep(10000);
				//Check whether the Received Items are Loaded Or not
				try
				{
					if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Finished(Sub Recipe)");
					}
				}
				catch (Exception e)
				{
					test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Finished(Sub Recipe)");			
				}
		
							
			}
			
			@Test(priority=32)
			public void Inventory_Purchase_Received_Logs_verify_SubRecipe_NotFinished(WebDriver driver) throws Exception
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(5000);
				//Select the Required Type	
				Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
				type.selectByVisibleText("Sub Recipe");
				
				Thread.sleep(1000);
				//Click the Sub Recipe Option
				driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
				//Enter the required Keyword
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
					
				Thread.sleep(2000);
				//Select the Consumption Option
				Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
				consumptionStatus.selectByVisibleText("Not Finished");
				
				Thread.sleep(2000);
				//Select the Time Period Option
				Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(1500);
				//Clear the Date Range from Option
				driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));
		
				Thread.sleep(1500);
				//Clear the Date Range To Option
				driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).clear();
				//Enter the required
				driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
				
				Thread.sleep(1000);
				//Click the Search button
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				Thread.sleep(10000);
				//Check whether the Received Items are Loaded Or not
				try
				{
					if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Not Finished(Sub Recipe)");
					}
				}
				catch (Exception e)
				{
					test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Not Finished(Sub Recipe)");			
				}
			}	
				
			@Test(priority=33)
			public void Inventory_Reports_Purchased_Items_openpage(WebDriver driver) throws Exception
			{
					/*//Click the Inventory option
					driver.findElement(By.xpath("//span[.='Inventory']")).click();
					// Create instance of Java script executor
					JavascriptExecutor je = (JavascriptExecutor) driver;
					//Identify the WebElement which will appear after scrolling down
					WebElement element = driver.findElement(By.xpath("//span[.='Reports ']"));
					//Scroll the page till the Inventory Items option present
					je.executeScript("arguments[0].scrollIntoView(true);",element); 
			        //Click the Inventory Reports Option		
					driver.findElement(By.xpath("//span[.='Reports ']")).click();
					Thread.sleep(5000);
					*/
					
					Thread.sleep(5000);
					//Get the URl
					driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"purchaseItems");
					Thread.sleep(2000);
					//driver.findElement(By.xpath("//span[.=' Purchased Items ']")).click();
					//Check Inventory Items page opened or not
					if(driver.findElement(By.xpath("//a[.='Purchased Items']")).getText().equalsIgnoreCase("Purchased Items"))
					{
						test.log(LogStatus.PASS, "Inventory Reports page loaded Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Inventory Reports page loaded Failed");
					}
					
					Thread.sleep(5000);
					
				}
				
			@Test(priority=34)
			public void Inventory_Reports_Purchased_Items_verify_Purchased_Items_Report_For_All(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Select the particular Type
				Select types = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/select")));
				types.selectByVisibleText("All");
				
				//Select the required Time period option
				Select timePeriod = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(2000);
				//Clear the From date check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/input[1]")).clear();
				//Enter the required date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
				
				Thread.sleep(1000);
				//Clear the To date check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/input[2]")).clear();
				//Enter the required date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
	
				Thread.sleep(2000);
				//Click the Search
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				try {
					if(!driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr/td")).getText().equalsIgnoreCase("No purchase record for selected item or time period"))
					{
						List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr"));
						rows.size();
								
						Thread.sleep(5000);
						for(int i = 1; i <= rows.size(); i++)
						{
					    	//Replace all commo's with empty space
					    	String expected = Utility.getReportProperty("Purchesed_Item_Price"+i).replace(",", "");
					    	
					    	//Convert the String value of the purchasedItemCounts element into int value
					    	float expects = Float.parseFloat(expected);
					    	
					    	String actual_Price1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr["+i+"]/td[5]")).getText();
					    	
					    	String actual_Price = actual_Price1.replaceAll("[a-zA-Z $ ₹ ,]", "");
					    	
					    	float price = Float.parseFloat(actual_Price);
					    	
					    	float unknownValue = Float.parseFloat(actual_Price);
							if(expects == price)
					    	{
					    		test.log(LogStatus.PASS, "Purchased Item("+i+") Report and Received Log Items are Same");
					    		
					    		test.log(LogStatus.INFO, "Purchased Item("+i+") aoumnt is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr["+i+"]/td[5]")).getText());
					    	}
					    	else if(expects == unknownValue)
					    	{
								test.log(LogStatus.PASS, "Here we don't have the exact expected value");
								
					        	//Get the Total value of Check Count
					        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr["+i+"]/td[5]")).getText();
	
					        	System.out.println("The Actual Purchased Item("+i+") Amount value is : "+actualText);
					        	
					        	test.log(LogStatus.INFO, "The Actual Purchased Item("+i+") Amount value is : "+actualText);
					    	}
					    	else
					    	{
					    		test.log(LogStatus.FAIL, "Purchased Item("+i+") Report and Received Log Items are different");
					    		
					    		float diff = price - expects;
					    		
					    		test.log(LogStatus.FAIL, "Different is : "+diff);
					    	}
						}
					}
				} catch (Exception e) {
				
					test.log(LogStatus.FAIL, "There is no Report available for Purchased Items");
				}
				
				
	
			}
			
			@Test(priority=35)
			public void Inventory_Reports_Purchased_Items_verify_Purchased_Items_Report_For_Inventory_Item(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Select the particular Type
				Select types = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/select")));
				types.selectByVisibleText("Inventory Item");
				
				//Click the Category filed
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/a")).click();
				//Enter the required Category
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				//Click the Inventory Item
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/div/a")).click();
				//Enter the required Inventory Item
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				//Select the required Time period option
				Select timePeriod = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(2000);
				//Clear the From date check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[5]/div/div/input[1]")).clear();
				//Enter the required date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[5]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
				
				Thread.sleep(1000);
				//Clear the To date check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[5]/div/div/input[2]")).clear();
				//Enter the required date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[5]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
	
				Thread.sleep(2000);
				//Click the Search
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				Thread.sleep(3000);
				
				try {
					if(!driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr/td")).getText().equalsIgnoreCase("No purchase record for selected item or time period"))
					{
						List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr"));
						rows.size();
								
						Thread.sleep(5000);
						for(int i = 1; i <= rows.size(); i++)
						{
							System.out.println("Purchased Item("+i+") aoumnt is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr["+i+"]/td[5]")).getText());
							
							test.log(LogStatus.INFO, "Purchased Item("+i+") aoumnt is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr["+i+"]/td[5]")).getText());
						}
					}
			
				}catch(Exception e)
				{
					test.log(LogStatus.FAIL, "There is no Report available for Purchased Items(Inventory Item)");
				}
			}
			
			@Test(priority=36)
			public void Inventory_Reports_Purchased_Items_verify_Purchased_Items_Report_For_Sub_Recipe(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Select the particular Type
				Select types = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/select")));
				types.selectByVisibleText("Sub Recipe");
				
				//Click the Sub Recipe filed
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/a")).click();
				//Enter the required Category
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys("All");
				//Press the Enter button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				
				//Select the required Time period option
				Select timePeriod = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/select")));
				timePeriod.selectByVisibleText("Date Range");
				
				Thread.sleep(2000);
				//Clear the From date check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/input[1]")).clear();
				//Enter the required date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
				
				Thread.sleep(1000);
				//Clear the To date check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/input[2]")).clear();
				//Enter the required date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
	
				Thread.sleep(2000);
				//Click the Search
				driver.findElement(By.xpath("//button[.='Search']")).click();
				
				Thread.sleep(3000);
				
				try {
					if(!driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr/td")).getText().equalsIgnoreCase("No purchase record for selected item or time period"))
					{
						List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr"));
						rows.size();
								
						Thread.sleep(5000);
						for(int i = 1; i <= rows.size(); i++)
						{
							System.out.println("Purchased Item("+i+") aoumnt is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr["+i+"]/td[5]")).getText());
							
							test.log(LogStatus.INFO, "Purchased Item("+i+") aoumnt is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr["+i+"]/td[5]")).getText());
						}
					}
			
				}catch(Exception e)
				{
					test.log(LogStatus.FAIL, "There is no Report available for Purchased Items(Sub Recipe)");
				}
			}
			
			@Test(priority=37)
			public void Inventory_Reports_ConsumptionLog_Reports_Openpage(WebDriver driver) throws Exception
			{
				/*//Click the Inventory option
				driver.findElement(By.xpath("//span[.='Inventory']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[contains(.,'Reports')]"));
				//Scroll the page till the Inventory Reports option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Inventory Reports Option		
				driver.findElement(By.xpath("//span[contains(.,'Reports')]")).click();
				 //driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[4]/ul/li[11]/a/i")).click();
				*/
				Thread.sleep(5000);
				//Get the URl
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"compareInventory");
				Thread.sleep(2000);
				//Check Compare Inventory page opened or not
				if(driver.findElement(By.xpath("//a[.='Compare Inventory']")).getText().equalsIgnoreCase("Compare Inventory"))
				{
					test.log(LogStatus.PASS, "Compare Inventory page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Compare Inventory Inventory page loaded Failed");
				}
				
				Thread.sleep(5000);
				
			}
			
			@Test(priority=38)
			public void Inventory_Reports_ConsumptionLog_Openpage(WebDriver driver) throws Exception
			{
				
				Thread.sleep(2000);
				//Click Consumption Log page
				driver.findElement(By.xpath("//span[contains(.,'Consumption Log')]")).click();
				
				Thread.sleep(3000);
				//Check Inventory Items page opened or not
				if(driver.findElement(By.xpath("//a[.='Consumption Log']")).getText().equalsIgnoreCase("Consumption Log"))
				{
					test.log(LogStatus.PASS, "Consumption Log page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Consumption Log page loaded Failed");
				}
			}
			
			@Test(priority=39)
			public void Inventory_Reports_ConsumptionLog_Inventory_All(WebDriver driver) throws Exception
			{
			
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(2000);	
			//Select inventory Type 
			 Select inventorytype = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/select")));
			 inventorytype.selectByVisibleText("Inventory Item"); 
		 	
			 
			Thread.sleep(3000);	
			//Select the inventory Category
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/a")).click();
			Thread.sleep(1000);		
			//Select the inventory Category
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Inventory_Ingredient_Category"));
			Thread.sleep(2000);		
			//Enter the inventory Category
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);

			Thread.sleep(3000);	
			//Select the inventory Category
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/div/a")).click();
			Thread.sleep(1000);		
			//Select the inventory Category
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Inventory_Items_Name"));
			Thread.sleep(2000);		
			//Enter the inventory Category
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);

			Thread.sleep(2000);	
			//Select Consumption Type as "ALL"
			 Select Alltype = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/select")));
			 Alltype.selectByVisibleText("All"); 
		 	
			Thread.sleep(3000);	
			//Select Time period option 
			 Select DateRangetype = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[5]/div/div/select")));
			 DateRangetype.selectByVisibleText("Date Range"); 
		 	
			Thread.sleep(3000);	
			//Select the From Date range 
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[6]/div/div/input[1]")).clear();
			Thread.sleep(1000);		
			//Enter the From Date range 
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[6]/div/div/input[1]")).sendKeys(Utility.getReportProperty("ConsumptionLog_FromDate"));
			
			Thread.sleep(2000);	
			//Select the To Date range 
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[6]/div/div/input[2]")).clear();
			Thread.sleep(1000);		
			//Enter the To Date range 
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[6]/div/div/input[2]")).sendKeys(Utility.getReportProperty("ConsumptionLog_ToDate"));
			
			Thread.sleep(2000);	
			 //Click the Show Log button
			 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[7]/div/div/button")).click();
				
			 Thread.sleep(3000);		
			//Check whether the consumption log are Loaded Or not		
			try		
			{			
			if(driver.findElement(By.xpath("//td[.='No consumption log for selected time period']")).isDisplayed())			
			{				
			test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Not Finished(consumption log for inventory item)");			
			}		
			}		
			catch (Exception e)		
			{			
			test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Not Finished(consumption log)");					
			 
			List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[2]"));
				for(int i = 2; i <= rows.size(); i++)
				{
				 //Get the Consumption Log Quantity value
				Thread.sleep(5000);
				test.log(LogStatus.PASS,"Purchasing inventory item : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[4]")).getText()+" for this reason quantity taken by "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[2]")).getText()+" level and this is done by "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[5]")).getText() + "level");
				
				}
			}
			//print the table
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table")).isDisplayed();
			Thread.sleep(5000);
		}
			
			@Test(priority=40)
			public void Inventory_Reports_ConsumptionLog_Inventory_System(WebDriver driver) throws Exception
			{	
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(3000);
			//Click Consumption Type button
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/select")).click();
			
			Thread.sleep(3000);	
			//Click Consumption Type as System	
			 Select Systemtype = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/select")));
			 Systemtype.selectByVisibleText("System"); 
		 	
			Thread.sleep(2000);	
			 //Click the Show Log button
			 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[2]")).click();
			
		
			}
			
			@Test(priority=41)
			public void Inventory_Reports_ConsumptionLog_Inventory_Manual(WebDriver driver) throws Exception
			{		
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(3000);
			//Click Consumption Type button
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/select")).click();
			
			Thread.sleep(3000);	
			//Click Consumption Type as Manual
			 Select Manualtype = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/select")));
			 Manualtype.selectByVisibleText("Manual"); 
		 	
			Thread.sleep(2000);	
			 //Click the Show Log button
			 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[2]")).click();
			
			}
			
			@Test(priority=42)
			public void Inventory_Reports_ConsumptionLog_Subrecipe_All(WebDriver driver) throws Exception
			{		
				Thread.sleep(2000);	
				//Select the Sub recipe Type
				 Select Subrecipetype = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/select")));
				 Subrecipetype.selectByVisibleText("Sub Recipe"); 
			 	
				 
				Thread.sleep(3000);	
				//Select the Sub recipe
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/a")).click();
				Thread.sleep(1000);		
				//Select the Sub recipe
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("subRecipe_name"));
				Thread.sleep(2000);		
				//Enter the Sub recipe
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);

				//Click Consumption Type as "ALL"
				 Select Alltype = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/select")));
				 Alltype.selectByVisibleText("All"); 
			 		
				
				Thread.sleep(3000);	
				//Select Time period option 
				 Select DateRangetype = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/select")));
				 DateRangetype.selectByVisibleText("Date Range"); 
			 	
				Thread.sleep(3000);	
				//Select the From Date range 
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[5]/div/div/input[1]")).clear();
				Thread.sleep(1000);		
				//Enter the From Date range 
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[5]/div/div/input[1]")).sendKeys(Utility.getReportProperty("ConsumptionLog_FromDate"));
				
				Thread.sleep(2000);	
				//Select the To Date range 
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[5]/div/div/input[2]")).clear();
				Thread.sleep(1000);		
				//Enter the To Date range 
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[5]/div/div/input[2]")).sendKeys(Utility.getReportProperty("ConsumptionLog_ToDate"));
				
				Thread.sleep(2000);	
				 //Click the Show Log button
				 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[6]/div/div/button")).click();
					
				 Thread.sleep(3000);		
				//Check whether the consumption log are Loaded Or not		
				try		
				{			
				if(driver.findElement(By.xpath("//td[.='No consumption log for selected time period']")).isDisplayed())			
				{				
				test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Not Finished(consumption log)");			
				}		
				}		
				catch (Exception e)		
				{			
				test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Not Finished(consumption log)");					
				}
				
				 List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[2]"));
					for(int i = 1; i <= rows.size(); i++)
					{
					 //Get the Consumption Log Quantity value
					test.log(LogStatus.PASS,"Purchasing Sub Recipe : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[4]")).getText()+" for this reason quantity taken by "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[2]")).getText()+" level and this is done by "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[5]")).getText() + "level");
					
					}
			}
					
			@Test(priority=43)
			public void Inventory_Reports_ConsumptionLog_Subrecipe_System(WebDriver driver) throws Exception
			{		
						Thread.sleep(2000);	
						//Select the Sub recipe Type
						 Select Subrecipetype = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/select")));
						 Subrecipetype.selectByVisibleText("Sub Recipe"); 
				
						 Thread.sleep(2000);	
				//Click Consumption Type as "System"
				 Select Systemtype = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/select")));
				 Systemtype.selectByVisibleText("System"); 
					
					Thread.sleep(2000);	
					 //Click the Show Log button
					 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[2]")).click();
					
					}
					
			@Test(priority=44)
			public void Inventory_Reports_ConsumptionLog_Subrecipe_Manual(WebDriver driver) throws Exception
			{		
						Thread.sleep(2000);	
						//Select the Sub recipe Type
						 Select Subrecipetype = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/select")));
						 Subrecipetype.selectByVisibleText("Sub Recipe"); 
					
						 Thread.sleep(2000);	
					//Click Consumption Type as "Manual"
					 Select Manualtype = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/select")));
					 Manualtype.selectByVisibleText("Manual"); 
						
					Thread.sleep(2000);	
					 //Click the Show Log button
					 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[2]")).click();
					 Thread.sleep(5000);	
					}
					
			@Test(priority=45) 
			public void Inventory_Reports_Compare_Inventory_Openpage(WebDriver driver) throws Exception
			{
						/*//Click the Inventory option
						driver.findElement(By.xpath("//span[.='Inventory']")).click();
						// Create instance of Java script executor
						JavascriptExecutor je = (JavascriptExecutor) driver;
						//Identify the WebElement which will appear after scrolling down
						WebElement element = driver.findElement(By.xpath("//span[contains(.,'Reports')]"));
						//Scroll the page till the Inventory Reports option present
						je.executeScript("arguments[0].scrollIntoView(true);",element); 
				        //Click the Inventory Reports Option		
						driver.findElement(By.xpath("//span[contains(.,'Reports')]")).click();
						 //driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[4]/ul/li[11]/a/i")).click();
						*/
						Thread.sleep(5000);
						//Get the URl
						driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"compareInventory");
						
						Thread.sleep(2000);
						//Check Compare Inventory page opened or not
						if(driver.findElement(By.xpath("//a[.='Compare Inventory']")).getText().equalsIgnoreCase("Compare Inventory"))
						{
							test.log(LogStatus.PASS, "Compare Inventory page loaded Successfully");
						}
						else
						{
							test.log(LogStatus.FAIL, "Compare Inventory Inventory page loaded Failed");
						}
						
						Thread.sleep(5000);
						
					}
					
			@Test(priority=46) 
			public void Inventory_Reports_Compare_Inventory_ALL(WebDriver driver) throws Exception
			{
						Thread.sleep(3000);
					//Select type as ALL 
					Select ALL = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/select")));
					ALL.selectByVisibleText("All"); 
				 	
					Thread.sleep(3000);
					//Select type as Time period
					Select Timeperiod= new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/select")));
					Timeperiod.selectByVisibleText("Date Range"); 
				 	
					//Select the From Date Range
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/input[1]")).clear();
					//Enter the required From Date Range
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
							
					//Select the TO Date Range
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/input[2]")).clear();
					//Enter the  required TO Date Range
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
					
					Thread.sleep(1000);
					//Click the Run Comparison button
					driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.ng-binding")).click();
					
					 List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[2]"));
					for(int i = 1; i <= rows.size(); i++)
					{
						//Get the Consumption Log Quantity value
						test.log(LogStatus.PASS,"In Compare inventory " +driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[1]")).getText() +" "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[9]")).getText()+ " purchased  this much "+" "+  driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[3]")).getText());
							
					}
						
					Thread.sleep(3000);
					//Check Consumption Log page opened or not
					if(driver.findElement(By.xpath("//span[.='Compare Inventory']")).getText().equalsIgnoreCase("Compare Inventory"))
					{
						test.log(LogStatus.PASS, "Consumption Log Inventory report loaded Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Compare Inventory Inventory report loaded Failed");
					}
					

						Thread.sleep(3000);
					}
					
			@Test(priority=47) 
			public void Inventory_Reports_Compare_Inventory_Item(WebDriver driver) throws Exception
			{
						Thread.sleep(3000);
						//Select type as ALL 
						Select Inventory = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/select")));
						Inventory.selectByVisibleText("Inventory Item"); 
					 	
						//Select Category 
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/a")).click();
						//Send the category 
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Search_Inventory_Category_Name"));
						//Enter the category
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);

						//Select Inventory Item
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/div/a")).click();
						//Send the Inventory Item
						//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Search_Inventory_Items_Name"));
						//Enter the Inventory Item
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);

						Thread.sleep(3000);
						//Select type as Time period
						Select Timeperiod= new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/select")));
						Timeperiod.selectByVisibleText("Date Range"); 
					 	
						//Select the From Date Range
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[5]/div/div/input[1]")).clear();
						//Enter the required From Date Range
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[5]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
								
						//Select the TO Date Range
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[5]/div/div/input[2]")).clear();
						//Enter the  required TO Date Range
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[5]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
						
						Thread.sleep(1000);
						//Click the Run Comparison button
						driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.ng-binding")).click();
						
						Thread.sleep(2000);
						//Check Consumption Log page opened or not
						if(driver.findElement(By.xpath("//span[.='Compare Inventory']")).getText().equalsIgnoreCase("Compare Inventory"))
						{
							test.log(LogStatus.PASS, "Consumption Log Inventory item report loaded Successfully");
						}
						else
						{
							test.log(LogStatus.FAIL, "Compare Inventory Inventory item report loaded Failed");
						}
						
					}
					
			@Test(priority=48) 
			public void Inventory_Reports_Compare_SubRecipe(WebDriver driver) throws Exception
			{
						Thread.sleep(3000);
						//Select type as ALL 
						Select Sub = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/select")));
						Sub.selectByVisibleText("Sub Recipe"); 
					 	
						//Select Sub Recipe 
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/a")).click();
						//Send the Sub Recipe
						//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("subRecipe_name"));
						//Enter the Sub Recipe
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);

						Thread.sleep(3000);
						//Select type as Time period
						Select Timeperiod= new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/select")));
						Timeperiod.selectByVisibleText("Date Range"); 
					 	
						//Select the From Date Range
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/input[1]")).clear();
						//Enter the required From Date Range
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
								
						//Select the TO Date Range
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/input[2]")).clear();
						//Enter the  required TO Date Range
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
						
						Thread.sleep(1000);
						//Click the Run Comparison button
						driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.ng-binding")).click();
						
						Thread.sleep(2000);
						//Check Consumption Log page opened or not
						if(driver.findElement(By.xpath("//span[.='Compare Inventory']")).getText().equalsIgnoreCase("Compare Inventory"))
						{
							test.log(LogStatus.PASS, "Consumption Log Sub Recipe report loaded Successfully");
						}
						else
						{
							test.log(LogStatus.FAIL, "Compare Inventory Sub Recipe report loaded Failed");
						}
						
						Thread.sleep(2000);
					
					}
					
			@Test(priority=49) 
			public void Inventory_Reports_Countsheet_Openpage(WebDriver driver) throws Exception
			{
						/*//Click the Inventory option
						driver.findElement(By.xpath("//span[.='Inventory']")).click();
						// Create instance of Java script executor
						JavascriptExecutor je = (JavascriptExecutor) driver;
						//Identify the WebElement which will appear after scrolling down
						WebElement element = driver.findElement(By.xpath("//span[contains(.,'Reports')]"));
						//Scroll the page till the Inventory Reports option present
						je.executeScript("arguments[0].scrollIntoView(true);",element); 
				        //Click the Inventory Reports Option		
						driver.findElement(By.xpath("//span[contains(.,'Reports')]")).click();
						 //driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[4]/ul/li[11]/a/i")).click();
						*/
						Thread.sleep(5000);
						//Get the URl
						driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"countSheet");
						
						//Thread.sleep(3000);
						//Click the count sheet
						//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/scrollable-tabset/div/div/div/ul/li[4]/a/uib-tab-heading/span")).click();
						
						Thread.sleep(3000);
						//Check Count Sheet page opened or not
						if(driver.findElement(By.xpath("//a[.='Count Sheet']")).getText().equalsIgnoreCase("Count Sheet"))
						{
							test.log(LogStatus.PASS, "Count Sheet page loaded Successfully");
						}
						else
						{
							test.log(LogStatus.FAIL, "Count Sheet page loaded Failed");
						}
						
						
						Thread.sleep(5000);
						
					}
					
			@Test(priority=50) 
			public void Inventory_Reports_Count_Sheet_Inventory(WebDriver driver) throws Exception
			{
						
					Thread.sleep(2000);
					//Select type as ALL 
					Select ALL = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/select")));
					ALL.selectByVisibleText("All"); 
				 	
					//Select Storage Location 
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/a")).click();
					//Send the Storage Location
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Search_Inventory_Storage"));
					//Enter the Storage Location
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);

					Thread.sleep(1000);
					//Click the Get Count Sheet button
					driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.ng-binding")).click();
					
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr/td[2]"));
						for(int i = 1; i <= rows.size(); i++)
						{
							//Get the Consumption Log Quantity value
							test.log(LogStatus.PASS,"In Count sheet " +driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[1]")).getText() +" "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[6]")).getText()+ " hand on quantity value is  "+" "+  driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[3]")).getText());
								
						}
							
						
					Thread.sleep(3000);
					//Check Count Sheet page opened or not
					if(driver.findElement(By.xpath("//span[.='Count Sheet']")).getText().equalsIgnoreCase("Count Sheet"))
					{
						test.log(LogStatus.PASS, "Count Sheet report loaded Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Count Sheet report loaded Failed");
					}
					

						Thread.sleep(1000);
					}
					
			@Test(priority=51) 
			public void Inventory_Reports_Count_Inventory_Item(WebDriver driver) throws Exception
			{
						Thread.sleep(3000);
						//Select type as ALL 
						Select Inventory = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/select")));
						Inventory.selectByVisibleText("Inventory Item"); 
					 	
						//Select Storage Location 
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/a")).click();
						//Send the Storage Location
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Search_Inventory_Category_Name"));
						//Enter the Storage Location
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);

						//Select Category
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/div/a")).click();
						//Send the Category
						//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Inventory_Ingredient_Category"));
						//Enter the Category
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);

						//Select Inventory Item
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/div/a")).click();
						//Send the Inventory Item
						//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Inventory_Ingredient_Category"));
						//Enter the Inventory Item
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[4]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);

						Thread.sleep(1000);
						//Click the Get Count Sheet button
						driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.ng-binding")).click();
						
						Thread.sleep(3000);
						//Check Count Sheet page opened or not
						if(driver.findElement(By.xpath("//span[.='Count Sheet']")).getText().equalsIgnoreCase("Count Sheet"))
						{
							test.log(LogStatus.PASS, "Count Sheet Inventory report loaded Successfully");
						}
						else
						{
							test.log(LogStatus.FAIL, "Count Sheet Inventory report loaded Failed");
						}
						
						
					}
					
			@Test(priority=52) 
			public void Inventory_Reports_Count_SubRecipe(WebDriver driver) throws Exception
			{
						Thread.sleep(3000);
						//Select type as ALL 
						Select Sub = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/select")));
						Sub.selectByVisibleText("Sub Recipe"); 
					 	
						//Select Storage Location 
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/a")).click();
						//Send the Storage Location
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("Search_Inventory_Category_Name"));
						//Enter the Storage Location
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);

						//Select Sub Recipe 
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/div/a")).click();
						//Send the Sub Recipe
						//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/div/div/div/input")).sendKeys(Utility.getProperty("subRecipe_name"));
						//Enter the Sub Recipe
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
						
						Thread.sleep(1000);
						//Click the Get Count Sheet button
						driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.ng-binding")).click();
						
						Thread.sleep(3000);
						//Check Count Sheet page opened or not
						if(driver.findElement(By.xpath("//span[.='Count Sheet']")).getText().equalsIgnoreCase("Count Sheet"))
						{
							test.log(LogStatus.PASS, "Count Sheet SubRecipe report loaded Successfully");
						}
						else
						{
							test.log(LogStatus.FAIL, "Count Sheet SubRecipe report loaded Failed");
						}
						
						Thread.sleep(4000);
					
					}
					
			@Test(priority=53)
			public void Inventory_Reports_COGS_Report_openpage(WebDriver driver) throws Exception
			{
						/*//Click the Inventory option
						driver.findElement(By.xpath("//span[.='Inventory']")).click();
						// Create instance of Java script executor
						JavascriptExecutor je = (JavascriptExecutor) driver;
						//Identify the WebElement which will appear after scrolling down
						WebElement element = driver.findElement(By.xpath("//span[contains(.,'Reports')]"));
						//Scroll the page till the Inventory Reports option present
						je.executeScript("arguments[0].scrollIntoView(true);",element); 
				        //Click the Inventory Reports Option		
						driver.findElement(By.xpath("//span[contains(.,'Reports')]")).click();
						 //driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[4]/ul/li[11]/a/i")).click();
						*/
						Thread.sleep(5000);
						//Get the URl
						driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"cogs");
						
						Thread.sleep(5000);
						//Check COGS page opened or not
						if(driver.findElement(By.xpath("//a[.='COGS']")).getText().equalsIgnoreCase("COGS"))
						{
							test.log(LogStatus.PASS, "COGS page loaded Successfully");
						}
						else
						{
							test.log(LogStatus.FAIL, "COGS page loaded Failed");
						}
						
						Thread.sleep(5000);
					}
					
			@Test(priority=54)
			public void Inventory_Reports_COGS_verify_All_report(WebDriver driver) throws Exception
			{
						Thread.sleep(5000);
						//Select the Required Type
						Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/div/select")));
						type.selectByVisibleText("All");
								
						Thread.sleep(2000);
						//Select the Time Period Option
						Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[2]/div/div/select")));
						timePeriod.selectByVisibleText("Date Range");
						
						Thread.sleep(1500);
						//Clear the Date Range from Option
						driver.findElement(By.xpath("//form/div[3]/div/div/input[1]")).clear();
						//Enter the required
						driver.findElement(By.xpath("//form/div[3]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

						Thread.sleep(1500);
						//Clear the Date Range To Option
						driver.findElement(By.xpath("//form/div[3]/div/div/input[2]")).clear();
						//Enter the required
						driver.findElement(By.xpath("//form/div[3]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
						
						Thread.sleep(1000);
						//Click the Search button
						driver.findElement(By.xpath("//button[.='Get cogs']")).click();
						
						Thread.sleep(10000);
						try
						{
							//Check whether the Received Items are Loaded Or not
							if(driver.findElement(By.xpath("//td[.='No records found']")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for All");
							}
						}
						catch(Exception e)		
						{
							test.log(LogStatus.PASS, "COGS Report is available for the Selected time period for All");
							test.log(LogStatus.INFO, "**********   The below is for All filter data   **********");
							
							List<WebElement> data = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[3]/table/tbody/tr"));
							data.size();
							
							for(int i=1;i<=data.size();i++)
							{
								test.log(LogStatus.INFO, "Sold the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[3]/table/tbody/tr["+i+"]/td[1]")).getText()+" for "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[3]/table/tbody/tr["+i+"]/td[3]")).getText()+" with "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[3]/table/tbody/tr["+i+"]/td[2]")).getText()+" quantity");
								
							}		

						}
								
					}
					
			@Test(priority=55)
			public void Inventory_Reports_COGS_Report_verify_MenuItem(WebDriver driver) throws Exception
			{
						Thread.sleep(5000);
						//Select the Required Type
						Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/div/select")));
						type.selectByVisibleText("Menu Item");
								
						Thread.sleep(2000);
						//Select the Time Period Option
						Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[2]/div/div/select")));
						timePeriod.selectByVisibleText("Date Range");
						
						Thread.sleep(1500);
						//Clear the Date Range from Option
						driver.findElement(By.xpath("//form/div[3]/div/div/input[1]")).clear();
						//Enter the required
						driver.findElement(By.xpath("//form/div[3]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

						Thread.sleep(1500);
						//Clear the Date Range To Option
						driver.findElement(By.xpath("//form/div[3]/div/div/input[2]")).clear();
						//Enter the required
						driver.findElement(By.xpath("//form/div[3]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
						
						Thread.sleep(1000);
						//Click the Search button
						driver.findElement(By.xpath("//button[.='Get cogs']")).click();
						
						Thread.sleep(10000);
						try
						{
							//Check whether the Received Items are Loaded Or not
							if(driver.findElement(By.xpath("//td[.='No records found']")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Menu Item");
							}
						}
						catch(Exception e)		
						{
							test.log(LogStatus.PASS, "COGS Report is available for the Selected time period for Menu Item");
										
							List<WebElement> data = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[3]/table/tbody/tr"));
							data.size();
							
							//Get the Value of total value of Sold
							String actual = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/span")).getText();
							
							//Replace the alphabets
							String actual1 = actual.replaceAll("[a-zA-Z $ ₹ , :]", "");
							
							float actualF = Float.parseFloat(actual1);
										

								String temp = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[3]/table/tbody/tr[1]/td[1]")).getText();
								
								// Create instance of Java script executor
								JavascriptExecutor je = (JavascriptExecutor) driver;
								//Identify the WebElement which will appear after scrolling down
								WebElement element = driver.findElement(By.xpath("//span[contains(.,'Inventory Menu Items')]"));
								//Scroll the page till the Reports option present
								je.executeScript("arguments[0].scrollIntoView(true);",element); 
						        //Click the Reports Option		
								driver.findElement(By.xpath("//span[contains(.,'Inventory Menu Items')]")).click();
								Thread.sleep(10000);
							
								//Clear the search field
								driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
								//Enter the search field
								driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(temp);
								
								Thread.sleep(2000);
								//Click the sync icon
								driver.findElement(By.xpath("//a[@class='btn btn-small btn-primary']")).click();
								
								Thread.sleep(8000);
								//Click the right arrow
								driver.findElement(By.xpath("//i[@class='pull-right fa ng-scope fa-chevron-right']")).click();
								
							String expect = driver.findElement(By.xpath("//div[@class='panel-collapse in collapse']/div/div[3]/div/table/tbody/tr[2]/td[2]")).getText();
								
							//Replace the alphabets
							String expect1 = expect.replaceAll("[a-zA-Z $ ₹ ,]", "");
							
							float expectF = Float.parseFloat(expect1);
							
							if(expectF == actualF)
							{
								test.log(LogStatus.PASS, "Total value and Menu Item price are equal, the value is :"+expectF);
							}
							else
							{
								test.log(LogStatus.PASS, "Total value and Menu Item price are not equal");
								
								float diff =  expectF-actualF;
								
								test.log(LogStatus.FAIL, "Total difference is : "+diff);
							}
							
							// Create instance of Java script executor
							JavascriptExecutor je1 = (JavascriptExecutor) driver;
							//Identify the WebElement which will appear after scrolling down
							WebElement element1 = driver.findElement(By.xpath("//span[contains(.,'Reports')]"));
							//Scroll the page till the Reports option present
							je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
					        //Click the Reports Option		
							driver.findElement(By.xpath("//span[contains(.,'Reports')]")).click();
							Thread.sleep(5000);
							
					        //Click the COGS Option		
							driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/scrollable-tabset/div/div/div/ul/li[5]/a")).click();
							Thread.sleep(5000);
							
						}

						
									
					}
					
			@Test(priority=56)
			public void Inventory_Reports_COGS_Report_verify_Modifier(WebDriver driver) throws Exception
			{
						Thread.sleep(5000);
						//Select the Required Type
						Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/div/select")));
						type.selectByVisibleText("Modifier");
								
						Thread.sleep(2000);
						//Select the Time Period Option
						Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[2]/div/div/select")));
						timePeriod.selectByVisibleText("Date Range");
						
						Thread.sleep(1500);
						//Clear the Date Range from Option
						driver.findElement(By.xpath("//form/div[3]/div/div/input[1]")).clear();
						//Enter the required
						driver.findElement(By.xpath("//form/div[3]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

						Thread.sleep(1500);
						//Clear the Date Range To Option
						driver.findElement(By.xpath("//form/div[3]/div/div/input[2]")).clear();
						//Enter the required
						driver.findElement(By.xpath("//form/div[3]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
						
						Thread.sleep(1000);
						//Click the Search button
						driver.findElement(By.xpath("//button[.='Get cogs']")).click();
						
						Thread.sleep(10000);
						try
						{
							//Check whether the Received Items are Loaded Or not
							if(driver.findElement(By.xpath("//td[.='No records found']")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Modifier");
							}
						}
						catch(Exception e)		
						{
							test.log(LogStatus.PASS, "COGS Report is available for the Selected time period for Modifier");
							test.log(LogStatus.INFO, "**********   The below is for Modifier filter data   **********");
							
							List<WebElement> data = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[3]/table/tbody/tr"));
							data.size();
							
							for(int i=1;i<=data.size();i++)
							{
								test.log(LogStatus.INFO, "Sold the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[3]/table/tbody/tr["+i+"]/td[1]")).getText()+" for "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[3]/table/tbody/tr["+i+"]/td[3]")).getText()+" with "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[3]/table/tbody/tr["+i+"]/td[2]")).getText()+" quantity");
								
							}		

						}
								
					}
					
			@Test(priority=57) 
			public void Inventory_Reports_Adjust_Inventory_Report_Openpage(WebDriver driver) throws Exception
			{
						/*//Click the Inventory option
						driver.findElement(By.xpath("//span[.='Inventory']")).click();
						// Create instance of Java script executor
						JavascriptExecutor je = (JavascriptExecutor) driver;
						//Identify the WebElement which will appear after scrolling down
						WebElement element = driver.findElement(By.xpath("//span[contains(.,'Reports')]"));
						//Scroll the page till the Inventory Reports option present
						je.executeScript("arguments[0].scrollIntoView(true);",element); 
				        //Click the Inventory Reports Option		
						driver.findElement(By.xpath("//span[contains(.,'Reports')]")).click();
						 //driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[4]/ul/li[11]/a/i")).click();
						*/
						Thread.sleep(5000);
						//Get the URl
						driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"compareInventory");
						
						Thread.sleep(3000);
						//Click the Adjust Inventory
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/scrollable-tabset/div/div/div/ul/li[6]/a/uib-tab-heading/span")).click();
						
						Thread.sleep(4000);
						//Check Adjust Inventory page opened or not
						if(driver.findElement(By.xpath("//a[.='Adjust Inventory']")).getText().equalsIgnoreCase("Adjust Inventory"))
						{
							test.log(LogStatus.PASS, "Adjust Inventoryt page loaded Successfully");
						}
						else
						{
							test.log(LogStatus.FAIL, "Adjust Inventory page loaded Failed");
						}
					}
					
			@Test(priority=58) 
			public void Inventory_Reports_Adjust_Inventory_Report(WebDriver driver) throws Exception
			{
					//Click the Reason type
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/ul")).click();
					
					Thread.sleep(3000);	
					//Select Time period option 
					 Select DateRangetype = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[2]/div/div/select")));
					 DateRangetype.selectByVisibleText("Date Range"); 
				 	
					Thread.sleep(3000);	
					//Select the From Date range 
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/input[1]")).clear();
					Thread.sleep(1000);		
					//Enter the From Date range 
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("ConsumptionLog_FromDate"));
					
					Thread.sleep(2000);	
					//Select the To Date range 
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/input[2]")).clear();
					Thread.sleep(1000);		
					//Enter the To Date range 
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("ConsumptionLog_ToDate"));
					
					Thread.sleep(2000);	
					 //Click the Get Adjust Inventory Report button
					driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.ng-binding")).click();
					
					//Scroll the web page
				    for(int i=1; i <= 15; i++)
				    {
				    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				    	Thread.sleep(1000);
				    }
				    
					/*List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div/div/table/tbody/tr[2]/td[1]"));
					for(int i = 1; i <= rows.size(); i++)
					{
					//Get print on the reason type(type wise)
					 //tr[@style='background-color:#b4dde9']
						//Get the Adjust Inventory 
						test.log(LogStatus.PASS,"In Adjust Inventory " +driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[1]")).getText() +" "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[6]")).getText()+ " hand on quantity value is  "+" "+  driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[3]")).getText());
							
					}*/
					
					
				Thread.sleep(2000);
				//Check Adjust Inventory page opened or not
				if(driver.findElement(By.xpath("//a[.='Adjust Inventory']")).getText().equalsIgnoreCase("Adjust Inventory"))
				{
					test.log(LogStatus.PASS, "Adjust Inventory reason report loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Adjust Inventory report reason report loaded Failed");
				}

					}
					
			@Test(priority=59) 
			public void Inventory_Reports_Adjust_Inventory_SingleReport(WebDriver driver) throws Exception
			{
						//Scroll the web page
					    for(int i=1; i <= 25; i++)
					    {
					    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
					    	Thread.sleep(1000);
					    }
						Thread.sleep(3000);
						
						//Click the Reason type
						//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/ul")).click();
					
						List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/ul/li/a"));
						for(int i = 1; i <= rows.size(); i++)
						{
							//Click remove all reason
							Thread.sleep(5000);
							driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/ul/li[1]/a")).click();
							}
						
						//Click the reason type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/ul")).click();
					Thread.sleep(2000);	

					//Send the reason type
					//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/ul/li/input")).sendKeys("waste");
				   // Thread.sleep(2000);	

					//Enter the reason type
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/ng-include/div/form/div[1]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
				    Thread.sleep(2000);	

					 //Click the Get Adjust Inventory Report button
					driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.ng-binding")).click();
					
					Thread.sleep(3000);
					//Check Adjust Inventory page opened or not
					if(driver.findElement(By.xpath("//a[.='Adjust Inventory']")).getText().equalsIgnoreCase("Adjust Inventory"))
					{
						test.log(LogStatus.PASS, "Adjust Inventory single type reason report loaded Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Adjust Inventory single type  reason report loaded Failed");
					}
					Thread.sleep(1000);
					}

}
