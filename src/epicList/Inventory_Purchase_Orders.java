package epicList;

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

import epicList_Integrated.Utility;

public class Inventory_Purchase_Orders {
	
			public WebDriver driver;
			
			ExtentReports rep = ExtentManager.getInstance();
			ExtentTest test = rep.startTest("Inventory_Purchase_Orders");
		
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
	
			@Test(priority=9)
			public void Inventory_Purchase_Purchase_Order_Openpage() throws Exception
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
			public void Inventory_Purchase_Purchase_Order_Purchase_Orders_new_Print_add() throws Exception
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
			public void Inventory_Purchase_Purchase_Order_add_new_Purchase_Orders_email() throws Exception
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
			public void Inventory_Purchase_Purchase_Order_cancelButton() throws Exception
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
}
