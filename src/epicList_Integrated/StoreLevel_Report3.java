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

import epicList_Chrome.Utility;



public class StoreLevel_Report3 {


		public WebDriver driver;
	
		ExtentReports rep = ExtentManager.getInstance();
		ExtentTest test = rep.startTest("Verify_StoreLevel_Report3");
	
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
		public void Driver_Report_Method_Openpage(WebDriver driver) throws Exception
		{
			Thread.sleep(15000);
			//Click the Reports option
			driver.findElement(By.xpath("//span[.='Reports']")).click();Thread.sleep(3000);
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Driver']"));Thread.sleep(3000);
			//Scroll the page till the Driver option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
		    //Click the Driver Option		
			driver.findElement(By.xpath("//span[.='Driver']")).click();
			Thread.sleep(5000);
			//Check Driver Report page opened or not
			if(driver.findElement(By.xpath("//a[.='Driver']")).getText().equalsIgnoreCase("Driver"))
			{
				test.log(LogStatus.PASS,"Driver Report page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Driver Report page loaded Failed");
			}
			Thread.sleep(3000);		
		}

		@Test(priority=3)
		public void Driver_Report_Method_verify(WebDriver driver) throws Exception
		{
			//Create the web element
		    WebElement html = driver.findElement(By.tagName("html"));
		  	//Zoom out the window
		  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			
			Thread.sleep(1000);
			//Select the Driver option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		    //Enter the required Driver
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    
		    Thread.sleep(3000);
		    //Select the Specific date Time Period option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		    //Enter the required Period of time
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Date Range");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    
		    Thread.sleep(1000);
		    //Clear the Date field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
		    //Enter the Date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

		    Thread.sleep(1000);
		    //Clear the Date field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
		    //Enter the Date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			  
			    //Click the Run
			    driver.findElement(By.xpath("//button[@type='submit']")).click();
			    Thread.sleep(1000);
			   
			    String total = "0.00";
			    
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[5]")).getText() == total)
				{
					test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
					
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
					
					//Get the amount Value
					String amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					System.out.println("Total Amount is : "+amount);
					
					test.log(LogStatus.INFO, "Total Amount is : "+amount);
					
					//Get the Owed Value
					String owed = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
					
					System.out.println("Total Owed is : "+owed);
					
					test.log(LogStatus.INFO, "Total Owed is : "+owed);
					
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
				}  
		}
		
		@Test(priority=4)
		public void Batch_Report_Method_OpenPage(WebDriver driver) throws Exception
		{
		/*	//Click the Reports option
			driver.findElement(By.xpath("//span[.='Reports']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Batch']"));
			//Scroll the page till the Batch option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
	        //Click the Batch Option		
			driver.findElement(By.xpath("//span[.='Batch']")).click(); */
			
			Thread.sleep(3000);
			//Enter the Users URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"batchReport");
			
			Thread.sleep(5000);
			//Check Batch page opened or not
			if(driver.findElement(By.xpath("//a[.='Batch']")).getText().equalsIgnoreCase("Batch"))
			{
				test.log(LogStatus.PASS,"Batch Report page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Batch Report page loaded Failed");
			}
			
			Thread.sleep(3000);
		}
		
		@Test(priority=5)
		public void Batch_Report_Method_verify(WebDriver driver) throws Exception
		{
			Thread.sleep(3000);
			//Click the Node Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/ul")).click();
			//Clear the node option
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/ul/li/input")).clear();
			//Enter the node
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Batch_Report_Node"));
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(3000);
			//Click the Employee Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/ul")).click();
			//Clear the Employee Option
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/ul/li/input")).clear();
			//Enter the Employee
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Batch_Report_Employee"));
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);

			//Select the Time Period option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		    //Enter the required Period of time for Specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    
		   //Clear the Date Field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		   //Enter the specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

			   //Clear the Date Field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		   //Enter the specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		    
		    Thread.sleep(3000);
		    //Click the Run
		    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		    
		    
		    Thread.sleep(3000);
			//Check weather the report is available for the selected time period
			if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Batch Report is not available for Specific Date");
			}
			
			else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[4]")).getText() != null)
			{
				
				test.log(LogStatus.PASS, "Batch Report is available for Specific Date");
				
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
				
				//Get the total records Value
				String total_Records = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[1]")).getText();
				
				System.out.println("Total Records is : "+total_Records);
				
				test.log(LogStatus.INFO, "Total Records is : "+total_Records);
				
				//Get the payments Value
				String payment = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[3]")).getText();
				
				System.out.println("Total Payment is : "+payment);
				
				test.log(LogStatus.INFO, "Total Payment is : "+payment);
				
				//Get the Refund Value
				String refund = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
				
				System.out.println("Total Refund is : "+refund);
				
				test.log(LogStatus.INFO, "Total Refund is : "+refund);
				
				//Get the Tips Value
				String tip = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
				
				System.out.println("Total Tip is : "+tip);
				
				test.log(LogStatus.INFO, "Total Tip is : "+tip);
				
				//Get the grand total value
				String grand_total = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
				
				System.out.println("Grand Total is : "+grand_total);
				
				test.log(LogStatus.INFO, "Grand Total is : "+grand_total);
				
			}
			
			else
			{
				test.log(LogStatus.FAIL, "Batch Report is not available for Specific Date");
			} 

		}
		
		@Test(priority=6)
		public void Refund_Report_Method_Openpage(WebDriver driver) throws Exception
		{
/*	//Click the Reports option
driver.findElement(By.xpath("//span[.='Reports']")).click();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
// Create instance of Java script executor
JavascriptExecutor je = (JavascriptExecutor) driver;
//Identify the WebElement which will appear after scrolling down
WebElement element = driver.findElement(By.xpath("//span[.='Refund']"));
//Scroll the page till the Daily Tender option present
je.executeScript("arguments[0].scrollIntoView(true);",element); 
//Click the Refund Option		
driver.findElement(By.xpath("//span[.='Refund']")).click();  */

Thread.sleep(3000);
//Enter the Users URL
driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"refundReport");

Thread.sleep(5000);
//Check Daily Tender page opened or not
if(driver.findElement(By.xpath("//a[.='Refund']")).getText().equalsIgnoreCase("Refund"))
{
	test.log(LogStatus.PASS,"Refund Report page loaded Successfully");
}
else
{
	test.log(LogStatus.FAIL,"Refund Report page loaded Failed");
}

Thread.sleep(3000);

}

		@Test(priority=7)
		public void Refund_Report_Method_verify_By_Payment_Type(WebDriver driver) throws Exception
		{
		
		Thread.sleep(5000);
		//Select the Employee option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		//Enter the required Employee
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		Select payment_Option = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/select")));
		payment_Option.selectByVisibleText("By Payment Type");
		
		Thread.sleep(5000);
		//Select the Payment Type option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the required Payment Type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		Thread.sleep(5000);
		//Select the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[4]/div/div/a")).click();
		//Enter the required Period of time for Specific date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[4]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Clear the Date Field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[5]/div/div/input[1]")).clear();
		//Enter the specific date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[5]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		   //Clear the Date Field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[5]/div/div/input[2]")).clear();
		//Enter the specific date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[5]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		//Click the Run
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Refund Report(By Payment Type) is not available for Specific Date");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[7]")).getText() != null)
		{
			
			test.log(LogStatus.PASS, "Refund Report(By Payment Type) is available for Specific Date");
			
			List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
			
		
				String amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[7]")).getText();
			
				System.out.println("Total Amount(By Payment Type) is : "+amount);
		
				test.log(LogStatus.INFO, "Total Amount(By Payment Type) is : "+amount);
			
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Refund Report(By Payment Type) is not available for Specific Date");
		}  
		Thread.sleep(2000);
		
		}
		
		@Test(priority=8)
		public void Refund_Report_Method_verify_By_Payment_Name(WebDriver driver) throws Exception
	{
	
	Thread.sleep(5000);
	//Select the Employee option
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
	//Enter the required Employee
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
	//Press the Enter key
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	
	Select payment_Option = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/select")));
	payment_Option.selectByVisibleText("By Payment Name");
	
	Thread.sleep(5000);
	//Select the Payment Type option
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/a")).click();
	//Enter the required Payment Type
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("All");
	//Press the Enter key
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	
	Thread.sleep(5000);
	//Select the Time Period option
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[4]/div/div/a")).click();
	//Enter the required Period of time for Specific date
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[4]/div/div/div/div/input")).sendKeys("Date Range");
	//Press the Enter key
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	
	//Clear the Date Field
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[5]/div/div/input[1]")).clear();
	//Enter the specific date
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[5]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
	   //Clear the Date Field
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[5]/div/div/input[2]")).clear();
	//Enter the specific date
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[5]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
	
	//Click the Run
	driver.findElement(By.cssSelector("button.btn.btn-success")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	
	//Check weather the report is available for the selected time period
	if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
	{
		test.log(LogStatus.FAIL, "Refund Report(By Payment Name) is not available for Specific Date");
	}
	
	else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[7]")).getText() != null)
	{
		
		test.log(LogStatus.PASS, "Refund Report(By Payment Name) is available for Specific Date");
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
		
	
			String amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[7]")).getText();
		
			System.out.println("Total Amount(By Payment Name) is : "+amount);
	
			test.log(LogStatus.INFO, "Total Amount(By Payment Name) is : "+amount);
		
	}
	
	else
	{
		test.log(LogStatus.FAIL, "Refund Report(By Payment Name) is not available for Specific Date");
	}  
	Thread.sleep(2000);
	
		}

	@Test(priority=9)
		public void Till_Report_Method_viewpage(WebDriver driver) throws Exception
		{
			/*	//Click the Reports option
			driver.findElement(By.xpath("//span[.='Reports']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Till']"));
			//Scroll the page till the Till option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
	        //Click the Till Option		
			driver.findElement(By.xpath("//span[.='Till']")).click(); */
	
			Thread.sleep(3000);
			//Enter the Users URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"tillReport");
	
			Thread.sleep(5000);
			//Check Till page opened or not
			if(driver.findElement(By.xpath("//a[.='Till']")).getText().equalsIgnoreCase("Till"))
			{
				test.log(LogStatus.PASS,"Till Report page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Till Report page loaded Failed");
			}
			Thread.sleep(3000);
	
			}
	
		@Test(priority=10)
		public void Till_Report_Method_verifyAll(WebDriver driver) throws Exception
		{
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	//Select the Employee option
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/a")).click();
	//Enter the required Employee
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
	//Press the Enter key
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
	//Select the Till type option
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/a")).click();
	//Enter the required Till type
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/div/div/input")).sendKeys("ALL");
	//Press the Enter key
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
	//Click the Time Period option
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/a")).click();
	//Enter the required Period of time for Specific date
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");	    
	//Press the Enter key
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	
	//Clear the date field
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[1]")).clear();
	//Select the required Specific date
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Till_Date_Range_From"));
	
	
	//Clear the date field
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[2]")).clear();
	//Select the required Specific date
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Till_Date_Range_To"));
	
	
	//Click the Run
	driver.findElement(By.cssSelector("button.btn.btn-success")).click();
	Thread.sleep(10000);
	
	List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr"));
	
	//Check weather the report is available for the selected time period
	if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
	{
		test.log(LogStatus.FAIL, "Till Report is not available for Specific Date");
	}
	
	else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr[2]/td[2]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr[2]/td[5]")).getText() != null)
	{
		
		test.log(LogStatus.PASS, "Till Report(All) is available for Specific Date");
	
		System.out.println("***** Till Report for All *****");
		
		test.log(LogStatus.INFO, "***** Till Report for All *****");
		
		
		//Get the Cash Expected Value
		String cash_Expected = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
		
		System.out.println("Total Cash Expected is : "+cash_Expected);
		
		test.log(LogStatus.INFO, "Total Cash Expected is : "+cash_Expected);
	
		
		//Get the amount Value
		String amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
		
		System.out.println("Total Amount is : "+amount);
		
		test.log(LogStatus.INFO, "Total Amount is : "+amount);
		
		//Get the Over/Shortage Value
		String over_Or_Shortage = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
		
		System.out.println("Total Over/Shortage is : "+over_Or_Shortage);
		
		test.log(LogStatus.INFO, "Total Over/Shortage is : "+over_Or_Shortage);
		
		
		Thread.sleep(2000);
		Thread.sleep(3000);
		for(int i=2; i < rows.size();i++)
		{
			String tillName = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText();
			
			String date = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[2]")).getText();
			
			String user = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[3]")).getText();
			
			String cashExpected = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[4]")).getText();
	
			String amount1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[5]")).getText();
	
			Thread.sleep(2000);
			
			test.log(LogStatus.INFO, "The Till("+tillName+") have the following details : ");
			
			test.log(LogStatus.INFO, "Date and Time is : "+date);
			
			test.log(LogStatus.INFO, "User name is : "+user);
			
			test.log(LogStatus.INFO, "Cash Expexted is : "+cashExpected);
			
			test.log(LogStatus.INFO, "Amount is : "+amount1);
			
			//Click the required Check
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]/a")).click();
	
			Thread.sleep(6000);
			
			test.log(LogStatus.INFO, "*******  TILL SUMMARY("+tillName+")  *******");
			
			test.log(LogStatus.INFO, "Total Starting Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[4]/div[2]")).getText());
			
			test.log(LogStatus.INFO, "Pay-Outs is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[6]/div[2]")).getText());
	
			test.log(LogStatus.INFO, "Pay-Ins is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[8]/div[2]")).getText());
	
			test.log(LogStatus.INFO, "Cash Drops is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[10]/div[2]")).getText());
	
			test.log(LogStatus.INFO, "Refund is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[12]/div[2]")).getText());
	
			test.log(LogStatus.INFO, "Void Cash Amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[14]/div[2]")).getText());
	
			test.log(LogStatus.INFO, "Cash Transactions is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[16]/div[2]")).getText());
	
			
			Thread.sleep(5000);
	    	//Replace all commo's with empty space
	    	String expected1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[18]/div[2]")).getText().replace(",", "");
	    	System.out.println("Expected Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[18]/div[2]")).getText());
	    	//Convert the String value of Expected Cash in Till Summary
	    	float expect1 = Float.parseFloat(expected1);
	    	
	    	//Get Cash Expected from the Till Table and Replace all commo's with empty space
	    	String actualText1 = cashExpected.replace(",", "");
	    	
	    	//Convert the String value of the Expected Cash element into float value
	    	float actual = Float.parseFloat(actualText1);
	    	
			
			if(expect1 == actual)
			{
				test.log(LogStatus.INFO, "Expected Cash in Till("+tillName+") is : "+cashExpected);
			}
			else
			{
				test.log(LogStatus.FAIL, "Expected Cash in Till("+tillName+") Summay and Cash Expected are different");
	        			        	
	        	//Get the different
	        	float different = actual - expect1;
	        	
	        	//Print the different value
	        	System.out.println("In Till("+tillName+"),  Expected Cash Value different is : "+different);
	        	
	        	test.log(LogStatus.FAIL, "In Till("+tillName+"),  Expected Cash Value different is : "+different);
	        	
	        	
			}
			
	    	//Replace all commo's with empty space
	    	String expected2 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[20]/div[2]")).getText().replace(",", "");
	    	
	    	//Convert the String value of Ending Cash Total Till Summary
	    	float expect2 = Float.parseFloat(expected2);  
	    	
	    	//Get Amount from the Till Table and Replace all commo's with empty space
	    	String actualText2 = amount1.replace(",", "");
	    	
	    	//Convert the String value of the amount element into float value
	    	float actual2 = Float.parseFloat(actualText2);
	    	
			if(expect2 == actual2)
			{
				test.log(LogStatus.INFO, "Expected Cash in Till is : "+amount1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Expected Cash in Till Summay and Cash Expected are different");
						        			        	
	        	//Get the different
	        	float different = actual2 - expect2;
	        	
	        	//Print the different value
	        	System.out.println("In Till("+tillName+"),  Amount Value different is : "+different);
	        	
	        	test.log(LogStatus.FAIL, "In Till("+tillName+"),  Amount Value different is : "+different);
	        	
	        	
			}
			
			test.log(LogStatus.INFO, "Differences is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[8]/div[2]")).getText());
	
			test.log(LogStatus.INFO, "Reason is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[9]/div[2]")).getText());
			
			Thread.sleep(2000);
			//Click the Load Transactions button
			driver.findElement(By.xpath("//a[.='Load Transactions']")).click();
			Thread.sleep(1000);
			
			try
			{
				//Check whether the Load Transaction details are available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr[2]/td[1]")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Load Transaction details are available");
					
					List<WebElement> loadTransactionRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr"));
					
						test.log(LogStatus.PASS, "Load Transactions amount total and Expected cash in Till amount are same then the Total in Load Transaction is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr["+loadTransactionRow.size()+"]/td[6]")).getText());
	
				}
			}
			catch(Exception e)
			{
				
				
					test.log(LogStatus.FAIL, "Load Transaction details are not available");
				
			}
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);	
			Thread.sleep(2000);Thread.sleep(1000);
			//Click the Back Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/a")).click();
			
			Thread.sleep(1000);
		}
	}
	
	else
	{
		test.log(LogStatus.FAIL, "Till Report is not available for Specific Date");
	}
	
	/*		String[] date = new String[rows.size()];
	
	String[] user = new String[rows.size()];*/
	
	
	}

		@Test(priority=11)
		public void Till_Report_Method_Global(WebDriver driver) throws Exception
		{
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(8000);   
		//Select the Employee option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/a")).click();
		//Enter the required Employee
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Select the Till type option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/a")).click();
		//Enter the required Till type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/div/div/input")).sendKeys("GLOBAL");
		//Press the Enter key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/a")).click();
		//Enter the required Period of time for Specific date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");	    
		//Press the Enter key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[1]")).clear();
		//Select the required Specific date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Till_Date_Range_From"));
		
		
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[2]")).clear();
		//Select the required Specific date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Till_Date_Range_To"));
		
		
		//Click the Run
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		Thread.sleep(10000);
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr"));
		
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Till Report is not available for Specific Date");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr[2]/td[2]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr[2]/td[5]")).getText() != null)
		{
			
			test.log(LogStatus.PASS, "Till Report(Global) is available for Specific Date");
		
			System.out.println("***** Till Report for Global *****");
			
			test.log(LogStatus.INFO, "***** Till Report for Global *****");
			
			
			//Get the Cash Expected Value
			String cash_Expected = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
			
			System.out.println("Total Cash Expected is : "+cash_Expected);
			
			test.log(LogStatus.INFO, "Total Cash Expected is : "+cash_Expected);
		
			
			//Get the amount Value
			String amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
			
			System.out.println("Total Amount is : "+amount);
			
			test.log(LogStatus.INFO, "Total Amount is : "+amount);
			
			//Get the Over/Shortage Value
			String over_Or_Shortage = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
			
			System.out.println("Total Over/Shortage is : "+over_Or_Shortage);
			
			test.log(LogStatus.INFO, "Total Over/Shortage is : "+over_Or_Shortage);
			
			
			Thread.sleep(3000);
			for(int i=2; i < rows.size();i++)
			{
				String tillName = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText();
				
				String date = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[2]")).getText();
				
				String user = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[3]")).getText();
				
				String cashExpected = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[4]")).getText();
		
				String amount1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[5]")).getText();
		
				Thread.sleep(1000);
				
				test.log(LogStatus.INFO, "The Till("+tillName+") have the following details : ");
				
				test.log(LogStatus.INFO, "Date and Time is : "+date);
				
				test.log(LogStatus.INFO, "User name is : "+user);
				
				test.log(LogStatus.INFO, "Cash Expexted is : "+cashExpected);
				
				test.log(LogStatus.INFO, "Amount is : "+amount1);
				
				//Click the required Check
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]/a")).click();
		
				Thread.sleep(6000);
				
				test.log(LogStatus.INFO, "*******  TILL SUMMARY("+tillName+")  *******");
				
				test.log(LogStatus.INFO, "Total Starting Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[4]/div[2]")).getText());
				
				test.log(LogStatus.INFO, "Pay-Outs is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[6]/div[2]")).getText());
		
				test.log(LogStatus.INFO, "Pay-Ins is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[8]/div[2]")).getText());
		
				test.log(LogStatus.INFO, "Cash Drops is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[10]/div[2]")).getText());
		
				test.log(LogStatus.INFO, "Refund is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[12]/div[2]")).getText());
		
				test.log(LogStatus.INFO, "Void Cash Amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[14]/div[2]")).getText());
		
				test.log(LogStatus.INFO, "Cash Transactions is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[16]/div[2]")).getText());
		
				
				Thread.sleep(5000);
		    	//Replace all commo's with empty space
		    	String expected1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[18]/div[2]")).getText().replace(",", "");
		    	
		    	//Convert the String value of Expected Cash in Till Summary
		    	float expect1 = Float.parseFloat(expected1);  
		    	
		    	//Get Cash Expected from the Till Table and Replace all commo's with empty space
		    	String actualText1 = cashExpected.replace(",", "");
		    	
		    	//Convert the String value of the Expected Cash element into float value
		    	float actual = Float.parseFloat(actualText1);
		    	
				
				if(expect1 == actual)
				{
					test.log(LogStatus.INFO, "Expected Cash in Till("+tillName+") is : "+cashExpected);
				}
				else
				{
					test.log(LogStatus.FAIL, "Expected Cash in Till("+tillName+") Summay and Cash Expected are different");
		        			        	
		        	//Get the different
		        	float different = actual - expect1;
		        	
		        	//Print the different value
		        	System.out.println("In Till("+tillName+"),  Expected Cash Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "In Till("+tillName+"),  Expected Cash Value different is : "+different);
		        	
		        	
				}
				
		    	//Replace all commo's with empty space
		    	String expected2 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[20]/div[2]")).getText().replace(",", "");
		    	
		    	//Convert the String value of Ending Cash Total Till Summary
		    	float expect2 = Float.parseFloat(expected2);  
		    	
		    	//Get Amount from the Till Table and Replace all commo's with empty space
		    	String actualText2 = amount1.replace(",", "");
		    	
		    	//Convert the String value of the amount element into float value
		    	float actual2 = Float.parseFloat(actualText2);
		    	
				if(expect2 == actual2)
				{
					test.log(LogStatus.INFO, "Expected Cash in Till is : "+amount1);
				}
				else
				{
					test.log(LogStatus.FAIL, "Expected Cash in Till Summay and Cash Expected are different");
							        			        	
		        	//Get the different
		        	float different = actual2 - expect2;
		        	
		        	//Print the different value
		        	System.out.println("In Till("+tillName+"),  Amount Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "In Till("+tillName+"),  Amount Value different is : "+different);
		        	
		        	
				}
				
				Thread.sleep(2000);
				
				test.log(LogStatus.INFO, "Differences is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[8]/div[2]")).getText());
		
				test.log(LogStatus.INFO, "Reason is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[9]/div[2]")).getText());
		
				Thread.sleep(2000);
				//Click the Load Transactions button
				driver.findElement(By.xpath("//a[.='Load Transactions']")).click();
				Thread.sleep(1000);
				
				//Check whether the Load Transaction details are available or not
				try
				{
					//Check whether the Load Transaction details are available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr[2]/td[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Load Transaction details are available");
						
						List<WebElement> loadTransactionRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr"));
						
							test.log(LogStatus.PASS, "Load Transactions amount total and Expected cash in Till amount are same then the Total in Load Transaction is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr["+loadTransactionRow.size()+"]/td[6]")).getText());
		
					}
				}
				catch(Exception e)
				{
					
					
						test.log(LogStatus.FAIL, "Load Transaction details are not available");
					
				}driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(3000);
				//Click the Back Button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/a")).click();
				
				Thread.sleep(1000);
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Till Report is not available for Specific Date");
		}
		
		
		}
		
		@Test(priority=12)
		public void Till_Report_Method_User(WebDriver driver) throws Exception
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(8000);
		    
			//Select the Employee option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/a")).click();
		    //Enter the required Employee
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		   
		    //Select the Till type option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/a")).click();
		    //Enter the required Till type
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/div/div/input")).sendKeys("USER");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    
		    //Click the Time Period option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/a")).click();
		    //Enter the required Period of time for Specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");	    
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    
		    //Clear the date field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[1]")).clear();
		    //Select the required Specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Till_Date_Range_From"));
		    
		
		    //Clear the date field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[2]")).clear();
		    //Select the required Specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Till_Date_Range_To"));
		    
		    Thread.sleep(1000);
		    //Click the Run
		    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		    Thread.sleep(10000);
		    
			List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr"));
			
			Thread.sleep(2000);
			//Check weather the report is available for the selected time period
			if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Till Report is not available for Specific Date");
			}
			
			else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr[2]/td[2]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr[2]/td[5]")).getText() != null)
			{
				
				test.log(LogStatus.PASS, "Till Report(User) is available for Specific Date");
		
				System.out.println("***** Till Report for User *****");
				
				test.log(LogStatus.INFO, "***** Till Report for User *****");
								
				//Get the Cash Expected Value
				String cash_Expected = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
				
				System.out.println("Total Cash Expected is : "+cash_Expected);
				
				test.log(LogStatus.INFO, "Total Cash Expected is : "+cash_Expected);
		
				
				//Get the amount Value
				String amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
				
				System.out.println("Total Amount is : "+amount);
				
				test.log(LogStatus.INFO, "Total Amount is : "+amount);
				
				//Get the Over/Shortage Value
				String over_Or_Shortage = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
				
				System.out.println("Total Over/Shortage is : "+over_Or_Shortage);
				
				test.log(LogStatus.INFO, "Total Over/Shortage is : "+over_Or_Shortage);
				
				Thread.sleep(3000);
				for(int i=2; i < rows.size();i++)
				{
					String tillName = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText();
					
					String date = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[2]")).getText();
					
					String user = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[3]")).getText();
					
					String cashExpected = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[4]")).getText();
		
					String amount1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[5]")).getText();
		
					Thread.sleep(1000);
					
					test.log(LogStatus.INFO, "The Till("+tillName+") have the following details : ");
					
					test.log(LogStatus.INFO, "Date and Time is : "+date);
					
					test.log(LogStatus.INFO, "User name is : "+user);
					
					test.log(LogStatus.INFO, "Cash Expexted is : "+cashExpected);
					
					test.log(LogStatus.INFO, "Amount is : "+amount1);
					
					//Click the required Check
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]/a")).click();
		
					Thread.sleep(6000);
					
					test.log(LogStatus.INFO, "*******  TILL SUMMARY("+tillName+")  *******");
					
					test.log(LogStatus.INFO, "Total Starting Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[4]/div[2]")).getText());
					
					test.log(LogStatus.INFO, "Pay-Outs is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[6]/div[2]")).getText());
		
					test.log(LogStatus.INFO, "Pay-Ins is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[8]/div[2]")).getText());
		
					test.log(LogStatus.INFO, "Cash Drops is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[10]/div[2]")).getText());
		
					test.log(LogStatus.INFO, "Refund is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[12]/div[2]")).getText());
		
					test.log(LogStatus.INFO, "Void Cash Amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[14]/div[2]")).getText());
		
					test.log(LogStatus.INFO, "Cash Transactions is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[16]/div[2]")).getText());
		
					
					Thread.sleep(5000);
		        	//Replace all commo's with empty space
		        	String expected1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[18]/div[2]")).getText().replace(",", "");
		        	
		        	//Convert the String value of Expected Cash in Till Summary
		        	float expect1 = Float.parseFloat(expected1);  
		        	
		        	//Get Cash Expected from the Till Table and Replace all commo's with empty space
		        	String actualText1 = cashExpected.replace(",", "");
		        	
		        	//Convert the String value of the Expected Cash element into float value
		        	float actual = Float.parseFloat(actualText1);
		        	
					
					if(expect1 == actual)
					{
						test.log(LogStatus.INFO, "Expected Cash in Till("+tillName+") is : "+cashExpected);
					}
					else
					{
						test.log(LogStatus.FAIL, "Expected Cash in Till("+tillName+") Summay and Cash Expected are different");
			        			        	
			        	//Get the different
			        	float different = actual - expect1;
			        	
			        	//Print the different value
			        	System.out.println("In Till("+tillName+"),  Expected Cash Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "In Till("+tillName+"),  Expected Cash Value different is : "+different);
			        	
			        	
					}
					
		        	//Replace all commo's with empty space
		        	String expected2 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[20]/div[2]")).getText().replace(",", "");
		        	
		        	//Convert the String value of Ending Cash Total Till Summary
		        	float expect2 = Float.parseFloat(expected2);  
		        	
		        	//Get Amount from the Till Table and Replace all commo's with empty space
		        	String actualText2 = amount1.replace(",", "");
		        	
		        	//Convert the String value of the amount element into float value
		        	float actual2 = Float.parseFloat(actualText2);
		        	
					if(expect2 == actual2)
					{
						test.log(LogStatus.INFO, "Expected Cash in Till is : "+amount1);
					}
					else
					{
						test.log(LogStatus.FAIL, "Expected Cash in Till Summay and Cash Expected are different");
								        			        	
			        	//Get the different
			        	float different = actual2 - expect2;
			        	
			        	//Print the different value
			        	System.out.println("In Till("+tillName+"),  Amount Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "In Till("+tillName+"),  Amount Value different is : "+different);
			        	
			        	
					}
					
					Thread.sleep(2000);
					
					test.log(LogStatus.INFO, "Differences is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[8]/div[2]")).getText());
		
					test.log(LogStatus.INFO, "Reason is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[9]/div[2]")).getText());
		
					Thread.sleep(2000);
					//Click the Load Transactions button
					driver.findElement(By.xpath("//a[.='Load Transactions']")).click();
					Thread.sleep(1000);
					
					try
					{
						//Check whether the Load Transaction details are available or not
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr[2]/td[1]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "Load Transaction details are available");
							
							List<WebElement> loadTransactionRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr"));
							
								test.log(LogStatus.PASS, "Load Transactions amount total and Expected cash in Till amount are same then the Total in Load Transaction is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr["+loadTransactionRow.size()+"]/td[6]")).getText());
		
						}
					}
					catch(Exception e)
					{
						
						
							test.log(LogStatus.FAIL, "Load Transaction details are not available");
						
					}
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);	
					Thread.sleep(3000);
					//Click the Back Button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/a")).click();
					
					Thread.sleep(1000);
				}
			}
			
			else
			{
				test.log(LogStatus.FAIL, "Till Report is not available for Specific Date");
			}
		    
		
		}
		
		@Test(priority=13)
		public void CashTransaction_Report_Method_OpenPage(WebDriver driver) throws Exception
		{
		/*	//Click the Reports option
			driver.findElement(By.xpath("//span[.='Reports']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Till']"));
			//Scroll the page till the Till option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
		    //Click the Till Option		
			driver.findElement(By.xpath("//span[.='Till']")).click(); */
			
			Thread.sleep(3000);
			//Enter the Users URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"cashTransactionReport");
			
			Thread.sleep(5000);
			
			//Check Cash Transaction page opened or not
			if(driver.findElement(By.xpath("//a[.='Cash Transaction']")).getText().equalsIgnoreCase("Cash Transaction"))
			{
				test.log(LogStatus.PASS,"Cash Transaction Report page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Cash Transaction Report page loaded Failed");
			}
			Thread.sleep(3000);
		}
		
		@Test(priority=14)
		public void CashTransaction_Report_Method_verifyAll(WebDriver driver) throws Exception
		{
			
			//Create the web element
		    WebElement html = driver.findElement(By.tagName("html"));
		  	//Zoom out the window
		  	html.sendKeys(Keys.HOME);
		  	html.sendKeys(Keys.HOME);
		/*	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));*/
		  	
			//Select the Employee option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/a")).click();
		    //Enter the required Employee
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    
		    //Select the Transaction type option (All)
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/a")).click();
		    //Enter the required Transaction type (All)
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/div/div/input")).sendKeys("All");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		    //Select the Time Period option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/a")).click();
		    //Enter the required Period of time (Specific date)
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    
		    //Clear the Date field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[1]")).clear();
		    //Enter the number of days
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		    //Clear the Date field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[2]")).clear();
		    //Enter the number of days
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		    
		    //Click the Run
		    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		    Thread.sleep(5000);
		
			//Check weather the report is available for the selected time period
			if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Cash Transaction Report is not available for Specific Date");
			}
			
			else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr[2]/td[6]")).getText() != null)
			{
				
				test.log(LogStatus.PASS, "Cash Transaction Report is available for Specific Date");
			
				
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr"));
				
				//Get the amount Value
				String amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
				
				System.out.println("Total Amount is : "+amount);
				
				test.log(LogStatus.INFO, "Total Amount is : "+amount);
				
			}
			
			else
			{
				test.log(LogStatus.FAIL, "Cash Transaction Report is not available for Specific Date");
			}  
		    
		}
		
		@Test(priority=15)
		public void Comparision_Report_Method_viewOpage(WebDriver driver) throws Exception
		{
		/*	//Click the Reports option
			driver.findElement(By.xpath("//span[.='Reports']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Comparision Report']"));
			//Scroll the page till the Comparision Report option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
		    //Click the Comparision Report Option		
			driver.findElement(By.xpath("//span[.='Comparision Report']")).click(); */
			
			Thread.sleep(3000);
			//Enter the Users URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"comparisionReport");
			
			Thread.sleep(5000);
			//Check Comparision Report page opened or not
			if(driver.findElement(By.xpath("//a[.='Comparision Report']")).getText().equalsIgnoreCase("Comparision Report"))
			{
				test.log(LogStatus.PASS,"Comparision Report page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Comparision Report page loaded Failed");
			}
			
			Thread.sleep(3000);
			
		}
		
		@Test(priority=16)
		public void Comparision_Report_Method_verify_By_Payment_Type(WebDriver driver) throws Exception
		{
			
		    Thread.sleep(5000);
			//Select the Time Period option   
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[1]/div/div/div/div/a")).click();
		    //Enter the required Period of time for Specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[1]/div/div/div/div/div/div/input")).sendKeys("Today");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[1]/div/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    
		    Thread.sleep(5000);
			//Select the Time Period option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[2]/div/div/div/div/a")).click();
		    //Enter the required Period of time for Specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[2]/div/div/div/div/div/div/input")).sendKeys("Yesterday");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[2]/div/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    
		    Thread.sleep(5000);
			//Select the Time Period option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[3]/div/div/div/div/a")).click();
		    //Enter the required Period of time for Specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[3]/div/div/div/div/div/div/input")).sendKeys("Last 'N' days");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[3]/div/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    
		    //Clear the number of day field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[3]/div[2]/div/div/input")).clear();
		    //Enter the required days
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[3]/div[2]/div/div/input")).sendKeys("100");
		    //Press the Enter Key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[3]/div[2]/div/div/input")).sendKeys(Keys.ENTER);
		    
		    Thread.sleep(5000);
			//Select the Time Period option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[4]/div/div/div/div/a")).click();
		    //Enter the required Period of time for Specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[4]/div/div/div/div/div/div/input")).sendKeys("This week");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[4]/div/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    
		    
		    Thread.sleep(3000);
		    //Click the Run
		    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		    
		    Thread.sleep(2000);
		    driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		    
		    String no_sale_amount = "₹0.00";
		    
		    Thread.sleep(3000);
			//Check weather the report is available for the selected time period
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[1]")).getText() == no_sale_amount && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[1]")).getText() == no_sale_amount && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[1]")).getText() == no_sale_amount && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[1]")).getText() == no_sale_amount)
			{
				test.log(LogStatus.FAIL, "Comparision Report is not available for Specific Date");
			}
			
			else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[1]")).getText() != no_sale_amount && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[1]")).getText() != no_sale_amount && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[1]")).getText() != no_sale_amount && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[1]")).getText() != no_sale_amount)
			{
				
				test.log(LogStatus.PASS, "Comparision Report is available for Specific Date");
				
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div"));
				rows.size();
		
				System.out.println("Date or Date Range is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[2]")).getText());
				
				test.log(LogStatus.INFO, "Date or Date Range is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[2]")).getText());
		
		
				for(int i = 1; i <= rows.size(); i++)
				{
					
					System.out.println(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div["+i+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div["+i+"]")).getText());
					
					test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div["+i+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div["+i+"]")).getText());
		
				}
				
		
				System.out.println("Date or Date Range is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[3]")).getText());
				
				test.log(LogStatus.INFO, "Date or Date Range is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[3]")).getText());
		
				for(int i = 1; i <= rows.size(); i++)
				{
					
		
					System.out.println(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div["+i+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div["+i+"]")).getText());
					
					test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div["+i+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div["+i+"]")).getText());
		
				}
		
				System.out.println("Date or Date Range is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[4]")).getText());
				
				test.log(LogStatus.INFO, "Date or Date Range is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[4]")).getText());
		
		
				for(int i = 1; i <= rows.size(); i++)
				{
					
					System.out.println(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div["+i+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div["+i+"]")).getText());
					
					test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div["+i+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div["+i+"]")).getText());
		
				}
				
				
				System.out.println("Date or Date Range is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[5]")).getText());
				
				test.log(LogStatus.INFO, "Date or Date Range is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[5]")).getText());
		
		
				for(int i = 1; i <= rows.size(); i++)
				{
					
					System.out.println(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div["+i+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div["+i+"]")).getText());
					
					test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div["+i+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div["+i+"]")).getText());
		
				}
				
				
				
		/*			
				
				
				
				
				System.out.println("Date or Date Range is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[2]")).getText());
				
				test.log(LogStatus.INFO, "Date or Date Range is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[2]")).getText());
				
				System.out.println("Net Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[1]")).getText());			
				
				test.log(LogStatus.INFO, "Net Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[1]")).getText());
				
				System.out.println("Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[2]")).getText());
				
				test.log(LogStatus.INFO, "Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[2]")).getText());
				
				System.out.println("Actual Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[3]")).getText());
				
				test.log(LogStatus.INFO, "Actual Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[3]")).getText());
				
				System.out.println("Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[4]")).getText());
				
				test.log(LogStatus.INFO, "Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[4]")).getText());
				
				System.out.println("Discounts is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[5]")).getText());			
				
				test.log(LogStatus.INFO, "Discounts is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[5]")).getText());
				
				System.out.println("Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[6]")).getText());
				
				test.log(LogStatus.INFO, "Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[6]")).getText());
				
				System.out.println("Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[7]")).getText());
				
				test.log(LogStatus.INFO, "Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[7]")).getText());
				
				System.out.println("Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[8]")).getText());
				
				test.log(LogStatus.INFO, "Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[8]")).getText());
				
				System.out.println("Payments is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[9]")).getText());
				
				test.log(LogStatus.INFO, "Payments is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[9]")).getText());
		
				System.out.println("Date or Date Range is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[3]")).getText());
				
				test.log(LogStatus.INFO, "Date or Date Range is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[3]")).getText());
				
				System.out.println("Net Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[1]")).getText());			
				
				test.log(LogStatus.INFO, "Net Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[1]")).getText());
				
				System.out.println("Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[2]")).getText());
				
				test.log(LogStatus.INFO, "Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[2]")).getText());
				
				System.out.println("Actual Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[3]")).getText());
				
				test.log(LogStatus.INFO, "Actual Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[3]")).getText());
				
				System.out.println("Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[4]")).getText());
				
				test.log(LogStatus.INFO, "Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[4]")).getText());
				
				System.out.println("Discounts is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[5]")).getText());			
				
				test.log(LogStatus.INFO, "Discounts is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[5]")).getText());
				
				System.out.println("Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[6]")).getText());
				
				test.log(LogStatus.INFO, "Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[6]")).getText());
				
				System.out.println("Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[7]")).getText());
				
				test.log(LogStatus.INFO, "Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[7]")).getText());
				
				System.out.println("Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[8]")).getText());
				
				test.log(LogStatus.INFO, "Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[8]")).getText());
				
				System.out.println("Payments is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[9]")).getText());
				
				test.log(LogStatus.INFO, "Payments is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[9]")).getText());
				
				System.out.println("Date or Date Range is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[4]")).getText());
				
				test.log(LogStatus.INFO, "Date or Date Range is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[4]")).getText());
				
				System.out.println("Net Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[1]")).getText());			
				
				test.log(LogStatus.INFO, "Net Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[1]")).getText());
				
				System.out.println("Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[2]")).getText());
				
				test.log(LogStatus.INFO, "Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[2]")).getText());
				
				System.out.println("Actual Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[3]")).getText());
				
				test.log(LogStatus.INFO, "Actual Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[3]")).getText());
				
				System.out.println("Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[4]")).getText());
				
				test.log(LogStatus.INFO, "Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[4]")).getText());
				
				System.out.println("Discounts is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[5]")).getText());			
				
				test.log(LogStatus.INFO, "Discounts is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[5]")).getText());
				
				System.out.println("Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[6]")).getText());
				
				test.log(LogStatus.INFO, "Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[6]")).getText());
				
				System.out.println("Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[7]")).getText());
				
				test.log(LogStatus.INFO, "Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[7]")).getText());
				
				System.out.println("Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[8]")).getText());
				
				test.log(LogStatus.INFO, "Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[8]")).getText());
				
				System.out.println("Payments is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[9]")).getText());
				
				test.log(LogStatus.INFO, "Payments is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[9]")).getText());
				
				System.out.println("Date or Date Range is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[5]")).getText());
				
				test.log(LogStatus.INFO, "Date or Date Range is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[5]")).getText());
				
				System.out.println("Net Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[1]")).getText());			
				
				test.log(LogStatus.INFO, "Net Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[1]")).getText());
				
				System.out.println("Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[2]")).getText());
				
				test.log(LogStatus.INFO, "Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[2]")).getText());
				
				System.out.println("Actual Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[3]")).getText());
				
				test.log(LogStatus.INFO, "Actual Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[3]")).getText());
				
				System.out.println("Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[4]")).getText());
				
				test.log(LogStatus.INFO, "Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[4]")).getText());
				
				System.out.println("Discounts is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[5]")).getText());			
				
				test.log(LogStatus.INFO, "Discounts is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[5]")).getText());
				
				System.out.println("Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[6]")).getText());
				
				test.log(LogStatus.INFO, "Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[6]")).getText());
				
				System.out.println("Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[7]")).getText());
				
				test.log(LogStatus.INFO, "Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[7]")).getText());
				
				System.out.println("Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[8]")).getText());
				
				test.log(LogStatus.INFO, "Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[8]")).getText());
				
				System.out.println("Payments is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[9]")).getText());
				
				test.log(LogStatus.INFO, "Payments is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[9]")).getText());
		*/		}
			
			else
			{
				test.log(LogStatus.FAIL, "Comparision Report is not available for Specific Date");
			}  
		    Thread.sleep(2000);
		    
		}
		
		@Test(priority=17)
		public void CustomerPerformance_Report_Method_viewpage(WebDriver driver) throws Exception
		{
			/*//Click the Reports option
			driver.findElement(By.xpath("//span[.='Reports']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Customer Preference']"));
			//Scroll the page till the Customer Preference Report option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
		    //Click the Customer Preference Report Option		
			driver.findElement(By.xpath("//span[.='Customer Preference']")).click();   */
			
			Thread.sleep(3000);
			//Enter the Users URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"customerPreferenceReport");
		
			Thread.sleep(5000);
			//Check Customer Preference Report page opened or not
			if(driver.findElement(By.xpath("//a[.='Customer Preference Report']")).getText().equalsIgnoreCase("Customer Preference Report"))
			{
				test.log(LogStatus.PASS,"Customer Preference Report page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Customer Preference Report page loaded Failed");
			}
			
			Thread.sleep(3000);
			
		}
		
		@Test(priority=18)
		public void CustomerPerformance_Report_Method_verify(WebDriver driver) throws Exception
		{
			
			
		    Thread.sleep(5000);
			//Select the Employee option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		    //Enter the required Employee
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    
		    Thread.sleep(5000);
			//Select the Time Period option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		    //Enter the required Period of time for Specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Date Range");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    
		    Thread.sleep(2000);
		    //Clear the Date field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
		    //Enter the required date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		    Thread.sleep(2000);
		    //Clear the Date field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
		    //Enter the required date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		    
		    //Click the Run
		    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		    Thread.sleep(8000);
		
		    driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		    	    
			//Check weather the report is available for the selected time period
			if(driver.findElement(By.xpath("//h3[.='No Sale for selected time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Customer Performance Report(With Category, Sub Category and Serving Size) is not available for Specific Date");
			}
			
			else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr[2]/th[1]")).getText() != null)
			{
				
				test.log(LogStatus.PASS, "Customer Performance Report(With Category, Sub Category and Serving Size) is available for Specific Date");
				
				System.out.println("Customer Performance Report(With Category, Sub Category and Serving Size) is available for Specific Date");
				
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr"));
				
				
				System.out.println("Quantity Sold is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[2]/span/span/b")).getText());
				
				test.log(LogStatus.INFO, "Quantity Sold is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[2]/span/span/b")).getText());
				
				System.out.println("Quantity Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[3]/span/span/b")).getText());			
				
				test.log(LogStatus.INFO, "Quantity Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[3]/span/span/b")).getText());
				
				System.out.println("Quantity Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[4]/span/span/b")).getText());
				
				test.log(LogStatus.INFO, "Quantity Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[4]/span/span/b")).getText());
				
				System.out.println("Quantity Group Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[5]/span/span/b")).getText());
				
				test.log(LogStatus.INFO, "Quantity Group Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[5]/span/span/b")).getText());
				
				System.out.println("Quantity Total Percntage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[6]/span/span/b")).getText());
				
				test.log(LogStatus.INFO, "Quantity Total Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[6]/span/span/b")).getText());
				
				System.out.println("Amount Sold is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[7]/span/span/b")).getText());			
				
				test.log(LogStatus.INFO, "Amount Sold is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[7]/span/span/b")).getText());
				
				System.out.println("Amount Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[8]/span/span/b")).getText());
				
				test.log(LogStatus.INFO, "Amount Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[8]/span/span/b")).getText());
				
				System.out.println("Amount Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[9]/span/span/b")).getText());
				
				test.log(LogStatus.INFO, "Amount Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[9]/span/span/b")).getText());
				
				System.out.println("Amount Group Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[10]/span/span/b")).getText());
				
				test.log(LogStatus.INFO, "Amount Group Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[10]/span/span/b")).getText());
				
				System.out.println("Amount Total Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[11]/span/span/b")).getText());
				
				test.log(LogStatus.INFO, "Amount Total Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[11]/span/span/b")).getText());
		
				
			}
			
			else
			{
				test.log(LogStatus.FAIL, "Customer Performance Report(With Category, Sub Category and Serving Size) is not available for Specific Date");
			}  
		    Thread.sleep(2000);
		    
		}
		
		@Test(priority=19)
		public void CustomerPerformance_Report_Method_WithoutCategorySubcategoryAdnServingSize(WebDriver driver) throws Exception
		{
			Thread.sleep(5000);
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			
		
			
		    Thread.sleep(5000);
			//Select the Employee option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		    //Enter the required Employee
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    
		    Thread.sleep(5000);
			//Select the Time Period option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		    //Enter the required Period of time for Specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Date Range");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    
		    Thread.sleep(2000);
		    //Clear the Date field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
		    //Enter the required date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		    Thread.sleep(2000);
		    //Clear the Date field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
		    //Enter the required date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		    
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/label[1]/span")).isEnabled())
			{
				//Disable the Category option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/label[1]/span")).click();
			}
			
			Thread.sleep(3000);
		
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/label[2]/span")).isEnabled())
			{
				//Disable the Sub Category option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/label[2]/span")).click();
			}
			
			Thread.sleep(3000);
			
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/label[3]/span")).isEnabled())
			{
				//Disable the Serving Size option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/label[3]/span")).click();
			}
		    
		    //Click the Run
		    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		    Thread.sleep(8000);
		
		    driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		    	    
			//Check weather the report is available for the selected time period
			if(driver.findElement(By.xpath("//h3[.='No Sale for selected time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Customer Performance Report(Without Category, Sub Category and Serving Size) is not available for Specific Date");
			}
			
			else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr[2]/th[1]")).getText() != null)
			{
				
				test.log(LogStatus.PASS, "Customer Performance Report(Without Category, Sub Category and Serving Size) is available for Specific Date");
				
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr"));
				
				System.out.println("Customer Performance Report(Without Category, Sub Category and Serving Size) is available for Specific Date");
				
				System.out.println("Quantity Sold is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[2]/span/span/b")).getText());
				
				test.log(LogStatus.INFO, "Quantity Sold is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[2]/span/span/b")).getText());
				
				System.out.println("Quantity Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[3]/span/span/b")).getText());			
				
				test.log(LogStatus.INFO, "Quantity Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[3]/span/span/b")).getText());
				
				System.out.println("Quantity Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[4]/span/span/b")).getText());
				
				test.log(LogStatus.INFO, "Quantity Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[4]/span/span/b")).getText());
				
				System.out.println("Quantity Group Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[5]/span/span/b")).getText());
				
				test.log(LogStatus.INFO, "Quantity Group Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[5]/span/span/b")).getText());
				
				System.out.println("Quantity Total Percntage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[6]/span/span/b")).getText());
				
				test.log(LogStatus.INFO, "Quantity Total Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[6]/span/span/b")).getText());
				
				System.out.println("Amount Sold is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[7]/span/span/b")).getText());			
				
				test.log(LogStatus.INFO, "Amount Sold is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[7]/span/span/b")).getText());
				
				System.out.println("Amount Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[8]/span/span/b")).getText());
				
				test.log(LogStatus.INFO, "Amount Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[8]/span/span/b")).getText());
				
				System.out.println("Amount Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[9]/span/span/b")).getText());
				
				test.log(LogStatus.INFO, "Amount Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[9]/span/span/b")).getText());
				
				System.out.println("Amount Group Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[10]/span/span/b")).getText());
				
				test.log(LogStatus.INFO, "Amount Group Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[10]/span/span/b")).getText());
				
				System.out.println("Amount Total Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[11]/span/span/b")).getText());
				
				test.log(LogStatus.INFO, "Amount Total Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/table/tbody/tr["+rows.size()+"]/td[11]/span/span/b")).getText());
		
				
			}
			
			else
			{
				test.log(LogStatus.FAIL, "Customer Performance Report(Without Category, Sub Category and Serving Size) is not available for Specific Date");
			}  
		    Thread.sleep(2000);
		    
		}
		
		@Test(priority=20)
		public void DailyTender_Report_Method_viewPage(WebDriver driver) throws Exception
		{
		/*	//Click the Reports option
			driver.findElement(By.xpath("//span[.='Reports']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Daily Tender']"));
			//Scroll the page till the Daily Tender option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
		    //Click the Daily Tender Option		
			driver.findElement(By.xpath("//span[.='Daily Tender']")).click();   */
			
			Thread.sleep(3000);
			//Enter the Users URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"dailyTenderReport");
			
			Thread.sleep(5000);
			//Check Daily Tender page opened or not
			if(driver.findElement(By.xpath("//a[.='Daily Tender']")).getText().equalsIgnoreCase("Daily Tender"))
			{
				test.log(LogStatus.PASS,"Daily Tender Report page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Daily Tender Report page loaded Failed");
			}
			
			Thread.sleep(3000);
			
		}
		
		@Test(priority=21)
		public void DailyTender_Report_Method_verify(WebDriver driver) throws Exception
		{
			Thread.sleep(5000);
			//Select the Time Period option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		    //Enter the required Period of time for Specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("Date Range");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    
		   //Clear the Date Field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/input[1]")).clear();
		   //Enter the specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		    Thread.sleep(2000);
		    
		   //Clear the Date Field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/input[2]")).clear();
		   //Enter the specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		    
		    //Click the Run
		    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		    Thread.sleep(2000);
		
		    driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		    
			//Check weather the report is available for the selected time period
			if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Daily Tender Report is not available for Specific Date");
			}
			
			else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
			{
				
				test.log(LogStatus.PASS, "Daily Tender Report is available for Specific Date");
				
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
				
				List<WebElement> columns = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[1]/th"));
			
				for(int i = 2; i <= columns.size();i++ )
				{
					String head = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[1]/th["+i+"]")).getText();
				
					String total = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td["+i+"]")).getText();
				
					System.out.println(head+" have the Total is : "+total);
			
					test.log(LogStatus.INFO, head+" have the Total is : "+total);
					
				}
				
			}
			
			else
			{
				test.log(LogStatus.FAIL, "Daily Tender Report is not available for Specific Date");
			}  
		    Thread.sleep(2000);
		    
		}
		    
		@Test(priority=22)
		public void Tax_Report_Method_viewPage(WebDriver driver) throws Exception
		{
		/*	//Click the Reports option
			driver.findElement(By.xpath("//span[.='Reports']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Tax Report']"));
			//Scroll the page till the Tax Report Report option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
		    //Click the Tax Report Option		
			driver.findElement(By.xpath("//span[.='Tax Report']")).click();*/
			
			Thread.sleep(3000);
			//Enter the Users URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"taxReport");
			
			
			Thread.sleep(5000);
			//Check Customer Preference Report page opened or not
			if(driver.findElement(By.xpath("//a[.='Tax Report']")).getText().equalsIgnoreCase("Tax Report"))
			{
				test.log(LogStatus.PASS,"Tax Report page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Tax Report page loaded Failed");
			}
			
			Thread.sleep(3000);
			
		}
		
		@Test(priority=23)
		public void Tax_Report_Method_verify(WebDriver driver) throws Exception
		{
			
			
		    Thread.sleep(5000);
			//Select the Time Period option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		    //Enter the required Period of time for Specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("Date Range");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    
		    Thread.sleep(3000);
		    //Clear the Date field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/input[1]")).clear();
		    //Enter the required date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		    
		    Thread.sleep(3000);
		    //Clear the Date field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/input[2]")).clear();
		    //Enter the required date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		    
		    //Click the Run
		    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		    Thread.sleep(8000);
		
		    driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		    
			List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
		
			//Check weather the report is available for the selected time period
			if(rows.size() == 2)
				
			{
				test.log(LogStatus.FAIL, "Tax is not available for Specific Date");
			}
			
			else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
			{
				
				test.log(LogStatus.PASS, "Tax is available for Specific Date");
		
				System.out.println("Total Tax Amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/th[4]")).getText());
				
				test.log(LogStatus.INFO, "Total Tax Amount is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/th[4]")).getText());
				
				System.out.println("Total Tax Exempt is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/th[5]")).getText());			
				
				test.log(LogStatus.INFO, "Total Tax Exempt is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/th[5]")).getText());
				
			}
			
			else
			{
				test.log(LogStatus.FAIL, "Tax is not available for Specific Date");
			}  
		    Thread.sleep(2000);
		    
		}
		
		@Test(priority=24)
		public void Revenue_Center_Report_Open_Page_Report(WebDriver driver) throws Exception
		{
/*				//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Revenue Center']"));
				//Scroll the page till the Revenue Center Report option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Tax Report Option		
				driver.findElement(By.xpath("//span[.='Revenue Center']")).click();*/
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"revenueCenterReport");
				Thread.sleep(5000);
				//Check Customer Preference Report page opened or not
				if(driver.findElement(By.xpath("//a[.='Revenue Center']")).getText().equalsIgnoreCase("Revenue Center"))
				{
					test.log(LogStatus.PASS,"Revenue Center Report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"Revenue Center Report page loaded Failed");
				}
				
				Thread.sleep(3000);
				
			}
	
		@Test(priority=25)
		public void Revenue_Center_Report_By_All_Options_Selected(WebDriver driver) throws Exception
		{
			    Thread.sleep(2000);
				//Select the Time Period option
			    driver.findElement(By.xpath("//form[@name='nodeSale']/div[2]/div/div/a")).click();
			    //Enter the required Period of time for Specific date
			    driver.findElement(By.xpath("//form[@name='nodeSale']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='nodeSale']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='nodeSale']/div[3]/div/div/input[1]")).clear();
			    //Enter the required date
			    driver.findElement(By.xpath("//form[@name='nodeSale']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='nodeSale']/div[3]/div/div/input[2]")).clear();
			    //Enter the required date
			    driver.findElement(By.xpath("//form[@name='nodeSale']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			    
			    //Click the Run
			    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
			    Thread.sleep(8000);
		
			    //Check whether the all options are displayed or not
			    if(driver.findElement(By.xpath("//span[contains(.,'No Of Guests')]")).isDisplayed()
			    		&&driver.findElement(By.xpath("//span[contains(.,'No Of Checks')]")).isDisplayed()
			    		&&driver.findElement(By.xpath("//span[contains(.,'Net Sales by Category')]")).isDisplayed()
			    		&&driver.findElement(By.xpath("//span[contains(.,'Net Sales by Shift')]")).isDisplayed()
			    		&&driver.findElement(By.xpath("//span[contains(.,'Net Sales by Revenue Center')]")).isDisplayed())
			    {
			    	test.log(LogStatus.PASS, "All the Options are displayed for All filters");
			    	
			    	//Others Total of - No Of Guests
			    	String NOG_Others_Total = driver.findElement(By.xpath("//span[contains(.,'No Of Guests')]/../table/tbody/tr/td[contains(.,'Total')]/../td[2]")).getText();
			    	
			    	//Grand Total of - No Of Guests
			    	String NOG_Grand_Total = driver.findElement(By.xpath("//span[contains(.,'No Of Guests')]/../table/tbody/tr/td[contains(.,'Total')]/../td[3]")).getText();
			    	
			    	//Others Total of - No Of Checks
			    	String NOC_Others_Total = driver.findElement(By.xpath("//span[contains(.,'No Of Checks')]/../table/tbody/tr/td[contains(.,'Total')]/../td[2]")).getText();
			    	
			    	//Grand Total of - No Of Checks
			    	String NOC_Grand_Total = driver.findElement(By.xpath("//span[contains(.,'No Of Checks')]/../table/tbody/tr/td[contains(.,'Total')]/../td[3]")).getText();

			    	//Others Total of - Net Sales by Category
			    	String NSBC_Others_Total = driver.findElement(By.xpath("//span[contains(.,'Net Sales by Category')]/../table/tbody/tr/td[contains(.,'Total')]/../td[2]")).getText();
			    	
			    	//Grand Total of - Net Sales by Category
			    	String NSBC_Grand_Total = driver.findElement(By.xpath("//span[contains(.,'Net Sales by Category')]/../table/tbody/tr/td[contains(.,'Total')]/../td[3]")).getText();

			    	//Others Total of - Net Sales by Shift
			    	String NSBS_Others_Total = driver.findElement(By.xpath("//span[contains(.,'Net Sales by Shift')]/../table/tbody/tr/td[contains(.,'Total')]/../td[2]")).getText();
			    	
			    	//Grand Total of - Net Sales by Shift
			    	String NSBS_Grand_Total = driver.findElement(By.xpath("//span[contains(.,'Net Sales by Shift')]/../table/tbody/tr/td[contains(.,'Total')]/../td[3]")).getText();
			    	
			    	//Others Total of - Net Sales by Revenue Center
			    	String NSBRC_Others_Total = driver.findElement(By.xpath("//span[contains(.,'Net Sales by Revenue Center')]/../table/tbody/tr/td[contains(.,'Total')]/../td[3]")).getText();
			    	
			    	//Grand Total of - Net Sales by Revenue Center
			    	String NSBRC_Grand_Total = driver.findElement(By.xpath("//span[contains(.,'Net Sales by Revenue Center')]/../table/tbody/tr/td[contains(.,'Total')]/../td[4]")).getText();

			    	test.log(LogStatus.INFO, "No Of Guests - Others Total Is : "+NOG_Others_Total);
			    	
			    	test.log(LogStatus.INFO, "No Of Guests - Grand Total Is : "+NOG_Grand_Total);
			    	
			    	test.log(LogStatus.INFO, "No Of Checks - Others Total Is : "+NOC_Others_Total);
			    	
			    	test.log(LogStatus.INFO, "No Of Checks - Grand Total Is : "+NOC_Grand_Total);
			    	
			    	test.log(LogStatus.INFO, "Net Sales by Category - Others Total Is : "+NSBC_Others_Total);
			    	
			    	test.log(LogStatus.INFO, "Net Sales by Category - Grand Total Is : "+NSBC_Grand_Total);
			    	
			    	test.log(LogStatus.INFO, "Net Sales by Shift - Others Total Is : "+NSBS_Others_Total);
			    	
			    	test.log(LogStatus.INFO, "Net Sales by Shift - Grand Total Is : "+NSBS_Grand_Total);
			    	
			    	test.log(LogStatus.INFO, "Net Sales by Revenue Center - Others Total Is : "+NSBRC_Others_Total);
			    	
			    	test.log(LogStatus.INFO, "Net Sales by Revenue Center - Grand Total Is : "+NSBRC_Grand_Total);
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "Required options are not displayed");
			    }
			    
			}

		@Test(priority=26)
		public void Revenue_Center_Report_By_Required_Options_Selected(WebDriver driver) throws Exception
		{
				for(int i = 1; i<= 5; i++)
				{
					//Click the Close button of Sales By Revenue Center Option
					driver.findElement(By.xpath("//a[@class='search-choice-close']")).click();
				}
				
				Thread.sleep(2000);
				//Click the Sales By Revenue Center option
				driver.findElement(By.xpath("//form[@name='nodeSale']/div[1]/div/div/ul")).click();
				//Enter the Required Option
				driver.findElement(By.xpath("//form[@name='nodeSale']/div[1]/div/div/ul/li/input")).sendKeys(Utility.getReportProperty("Sales_By_Revenue_Center"));
				//Press the Enter Button
				driver.findElement(By.xpath("//form[@name='nodeSale']/div[1]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
				
				//Select the Time Period option
			    driver.findElement(By.xpath("//form[@name='nodeSale']/div[2]/div/div/a")).click();
			    //Enter the required Period of time for Specific date
			    driver.findElement(By.xpath("//form[@name='nodeSale']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='nodeSale']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='nodeSale']/div[3]/div/div/input[1]")).clear();
			    //Enter the required date
			    driver.findElement(By.xpath("//form[@name='nodeSale']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='nodeSale']/div[3]/div/div/input[2]")).clear();
			    //Enter the required date
			    driver.findElement(By.xpath("//form[@name='nodeSale']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			    
			    //Click the Run
			    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
			    Thread.sleep(8000);
			    
/*			    Select Option = new Select(driver.findElement(By.xpath("//label[.='Sales By Revenue Center']/../select")));
			    Option.selectByValue(Utility.getReportProperty("Sales_By_Revenue_Center"));*/
			    
			    //Check Whether the Required option is displayed or not
			    if(Utility.getReportProperty("Sales_By_Revenue_Center").equalsIgnoreCase("Net sales for Revenue Center"))
			    {
				    //Check whether the all options are displayed or not
				    if(driver.findElement(By.xpath("//span[contains(.,'Net Sales by Revenue Center')]")).isDisplayed())
				    {
				    	test.log(LogStatus.PASS, "Net sales for Revenue Center Option is displayed for Net sales for Revenue Center filter");
				    	
				    	//Others Total of - Net Sales by Revenue Center
				    	String NSBRC_Others_Total = driver.findElement(By.xpath("//span[contains(.,'Net Sales by Revenue Center')]/../table/tbody/tr/td[contains(.,'Total')]/../td[3]")).getText();
				    	
				    	//Grand Total of - Net Sales by Revenue Center
				    	String NSBRC_Grand_Total = driver.findElement(By.xpath("//span[contains(.,'Net Sales by Revenue Center')]/../table/tbody/tr/td[contains(.,'Total')]/../td[4]")).getText();

				    	test.log(LogStatus.INFO, "Net Sales by Revenue Center - Others Total Is : "+NSBRC_Others_Total);
				    	
				    	test.log(LogStatus.INFO, "Net Sales by Revenue Center - Grand Total Is : "+NSBRC_Grand_Total);
				    }
				    else
				    {
				    	test.log(LogStatus.FAIL, "Net sales for Revenue Center Option is Not displayed for Net sales for Revenue Center filter");
				    }
			    }
			    else if(Utility.getReportProperty("Sales_By_Revenue_Center").equalsIgnoreCase("Net Sales by Shift"))
			    {
				    //Check whether the all options are displayed or not
				    if(driver.findElement(By.xpath("//span[contains(.,'Net Sales by Shift')]")).isDisplayed())
				    {
				    	test.log(LogStatus.PASS, "Net Sales by Shift Option is displayed for Net Sales by Shift filter");
				    	
				    	//Others Total of - Net Sales by Shift
				    	String NSBS_Others_Total = driver.findElement(By.xpath("//span[contains(.,'Net Sales by Shift')]/../table/tbody/tr/td[contains(.,'Total')]/../td[2]")).getText();
				    	
				    	//Grand Total of - Net Sales by Shift
				    	String NSBS_Grand_Total = driver.findElement(By.xpath("//span[contains(.,'Net Sales by Shift')]/../table/tbody/tr/td[contains(.,'Total')]/../td[3]")).getText();
				    	
				    	test.log(LogStatus.INFO, "Net Sales by Shift - Others Total Is : "+NSBS_Others_Total);
				    	
				    	test.log(LogStatus.INFO, "Net Sales by Shift - Grand Total Is : "+NSBS_Grand_Total);

				    }
				    else
				    {
				    	test.log(LogStatus.FAIL, "Net Sales by Shift Option is not displayed for Net Sales by Shift filter");
				    }
			    }
			    else if(Utility.getReportProperty("Sales_By_Revenue_Center").equalsIgnoreCase("Net sales by Category"))
			    {
				    //Check whether the all options are displayed or not
				    if(driver.findElement(By.xpath("//span[contains(.,'Net Sales by Category')]")).isDisplayed())
				    {
				    	test.log(LogStatus.PASS, "Net Sales by Category Option is displayed for Net Sales by Category filter");
				    	
				    	//Others Total of - Net Sales by Category
				    	String NSBC_Others_Total = driver.findElement(By.xpath("//span[contains(.,'Net Sales by Category')]/../table/tbody/tr/td[contains(.,'Total')]/../td[2]")).getText();
				    	
				    	//Grand Total of - Net Sales by Category
				    	String NSBC_Grand_Total = driver.findElement(By.xpath("//span[contains(.,'Net Sales by Category')]/../table/tbody/tr/td[contains(.,'Total')]/../td[3]")).getText();

				    	test.log(LogStatus.INFO, "Net Sales by Category - Others Total Is : "+NSBC_Others_Total);
				    	
				    	test.log(LogStatus.INFO, "Net Sales by Category - Grand Total Is : "+NSBC_Grand_Total);
				    	
				    }
				    else
				    {
				    	test.log(LogStatus.FAIL, "Net Sales by Category Option is not displayed for Net Sales by Category filter");
				    }
			    }
			    
			    else if(Utility.getReportProperty("Sales_By_Revenue_Center").equalsIgnoreCase("Number of checks"))
			    {
				    //Check whether the all options are displayed or not
				    if(driver.findElement(By.xpath("//span[contains(.,'No Of Checks')]")).isDisplayed())
				    {
				    	test.log(LogStatus.PASS, "No Of Checks Option is displayed for No Of Checks filter");
				    	
				    	//Others Total of - No Of Checks
				    	String NOC_Others_Total = driver.findElement(By.xpath("//span[contains(.,'No Of Checks')]/../table/tbody/tr/td[contains(.,'Total')]/../td[2]")).getText();
				    	
				    	//Grand Total of - No Of Checks
				    	String NOC_Grand_Total = driver.findElement(By.xpath("//span[contains(.,'No Of Checks')]/../table/tbody/tr/td[contains(.,'Total')]/../td[3]")).getText();
				    	
				    	test.log(LogStatus.INFO, "No Of Checks - Others Total Is : "+NOC_Others_Total);
				    	
				    	test.log(LogStatus.INFO, "No Of Checks - Grand Total Is : "+NOC_Grand_Total);
				    	
				    }
				    else
				    {
				    	test.log(LogStatus.FAIL, "No Of Checks Option is not displayed for No Of Checks filter");
				    }
			    }
			    
			    else if(Utility.getReportProperty("Sales_By_Revenue_Center").equalsIgnoreCase("Number of guests"))
			    {
				    //Check whether the all options are displayed or not
				    if(driver.findElement(By.xpath("//span[contains(.,'No Of Guests')]")).isDisplayed())
				    {
				    	test.log(LogStatus.PASS, "No Of Guests Option is displayed for No Of Guests filter");
				    	
				    	//Others Total of - No Of Guests
				    	String NOG_Others_Total = driver.findElement(By.xpath("//span[contains(.,'No Of Guests')]/../table/tbody/tr/td[contains(.,'Total')]/../td[2]")).getText();
				    	
				    	//Grand Total of - No Of Guests
				    	String NOG_Grand_Total = driver.findElement(By.xpath("//span[contains(.,'No Of Guests')]/../table/tbody/tr/td[contains(.,'Total')]/../td[3]")).getText();

				    	test.log(LogStatus.INFO, "No Of Guests - Others Total Is : "+NOG_Others_Total);
				    	
				    	test.log(LogStatus.INFO, "No Of Guests - Grand Total Is : "+NOG_Grand_Total);
				    	
				    }
				    else
				    {
				    	test.log(LogStatus.FAIL, "No Of Guests Option is not displayed for No Of Guests filter");
				    }
			    }
			    			    
			}

		@Test(priority=27)
		public void Account_Balance_Open_Account_Balance_Report(WebDriver driver) throws Exception
		{
/*				//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Account Balance']"));
				//Scroll the page till the Revenue Center Report option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Account Balance Option		
				driver.findElement(By.xpath("//span[.='Account Balance']")).click();*/
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"accountBalance");
				Thread.sleep(5000);
				//Check Customer Preference Report page opened or not
				if(driver.findElement(By.xpath("//a[.='Account Balance']")).getText().equalsIgnoreCase("Account Balance"))
				{
					test.log(LogStatus.PASS,"Account Balance Report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"Account Balance Report page loaded Failed");
				}
				
				Thread.sleep(3000);
				
			}
	
		@Test(priority=28)
		public void Account_Balance_Report_By_All_Options_Selected(WebDriver driver) throws Exception
		{
			    Thread.sleep(2000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//input[@name='date']")).clear();
			    //Enter the Required Date
			    driver.findElement(By.xpath("//input[@name='date']")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			    			
			    Thread.sleep(5000);
			    //Click the Run
			    driver.findElement(By.xpath("//span[.='Run']")).click();
			    Thread.sleep(8000);
			    
			    //Check whether the all options are displayed or not
			    if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
			    {
			    	test.log(LogStatus.FAIL, "Required Account Balance Report is missing");
			    }
			    else
			    {
			    	test.log(LogStatus.PASS, "Required Account Balance Report is Available");
			    	
			    	//List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr"));
			    	
			    	test.log(LogStatus.INFO, "Debit Balance is : "+driver.findElement(By.xpath("//th[.='Total']/../th[5]")));
			    	
			    	test.log(LogStatus.INFO, "Credit Balance is : "+driver.findElement(By.xpath("//th[.='Total']/../th[6]")));
			    }
			    
			}

}

