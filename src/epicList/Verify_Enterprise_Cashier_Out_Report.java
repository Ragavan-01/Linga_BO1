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

import epicList_Chrome.Utility;

public class Verify_Enterprise_Cashier_Out_Report {

	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Verify_Enterprise_Cashier_Out_Report");

	float unknownValue = 00;
	
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
	 
		@Test(priority=17)
		public void CashierOut_Enterprise_Report_Method_For_openpage() throws Exception
		{
			Thread.sleep(2000);
			//Enter the URl
			driver.get(Utility.getProperty("Enterprise_Base_URL")+"enterPriseReport/cashierOutSummary");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				
				
		Thread.sleep(5000);
		//Check CashierOut Report page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/div/div/ul/li[10]/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Cashier out"))
		{
			test.log(LogStatus.PASS, "CashierOut Sale Report page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "CashierOut Sale Report page loaded Failed");
		}
		
		Thread.sleep(3000);
		}
		
		@Test(priority=18)
		public void CashierOut_Enterprise_Report_Verify() throws Exception
		{
	
	
			Thread.sleep(3000);
			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/input")).sendKeys("Store 01");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(1500);
			//Click the Employee Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("All");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			
			Thread.sleep(3000);
			//Click the Time Period option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
			//Enter the required Time Period
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter Key
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
			//Enter the date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
			//Enter the date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
	
			
			Thread.sleep(1000);
			//Click the Run button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(5000);
			//Check weather the Check Status 
			if(driver.getPageSource().contains("CHECK STATS"))
			{
				test.log(LogStatus.PASS, "Check Stats field is available");
				
	        	//Replace all commo's with empty space
	        	String expected1 = Utility.getReportProperty("Check_Count").replace(",", "");
	        	
	        	//Convert the String value of the Check_Count element into float value
	        	float expect1 = Float.parseFloat(expected1);  
	
				
				Thread.sleep(2000);
				//Check the Check Count
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText().equals(Utility.getReportProperty("Check_Count")))
				{
					test.log(LogStatus.PASS, "Actual and Expected check counts are same");
					
		        	//Get the Total value of Check Count
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Check Count Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Check Count Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Check Count Value is : "+ actual);
	
				}
				
				else if(expect1 == unknownValue)
				{
					test.log(LogStatus.PASS, "Here we don't have the exact expected value");
					
		        	//Get the Total value of Check Count
		        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText();
	
		        	System.out.println("The Actual Check Count value is : "+actualText);
		        	
		        	test.log(LogStatus.INFO, "The Actual Check Count value is : "+actualText);
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Actual and Expected Check counts are different");
					
		        	//Get the Total value of Check Count
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Check Count Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        			        	
		        	//Get the different
		        	float different = actual - expect1;
		        	
		        	//Print the different value
		        	System.out.println("Check Count Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "Check Count Value different is : "+different);	
	
				}
				
				Thread.sleep(8000);
				//Check the SALES
				if(driver.getPageSource().contains("SALES"))
				{
					test.log(LogStatus.INFO, "SALES is available");
					
					System.out.println("SALES is available");
					
		        	//Replace all commo's with empty space
		        	String expecte1 = Utility.getReportProperty("Gross_Sales").replace(",", "");
		        	
		        	//Convert the String value of the Gross_Sales element into float value
		        	float expects1 = Float.parseFloat(expecte1);  
		        	
		        	//Replace all commo's with empty space
		        	String expected2 = Utility.getReportProperty("Sale_Report_Net_Sale").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Net_Sale element into float value
		        	float expect2 = Float.parseFloat(expected2);
		        	
		        	//Replace all commo's with empty space
		        	String expected3 = Utility.getReportProperty("Sale_Report_Grand_Sale").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Grand_Sale element into float value
		        	float expect3 = Float.parseFloat(expected3);
		        	
		        	//Check weather the Gross Sales total is same or not
		        	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[2]/span")).getText().equals(Utility.getReportProperty("Gross_Sales")))
		        	{
			        	test.log(LogStatus.PASS, "Actual and Expected Gross Sales Values are same");
			        	
			        	//Get the Total value of Gross Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[2]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Gross Sales element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Gross Sales Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Gross Sales Value is : "+ actual);
			        }
			        
					else if(expects1 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Gross Sales
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[2]/span")).getText();
	
			        	System.out.println("The Actual Gross Sales value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Gross Sales value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Gross Sales values are different");
			        	
			        	//Get the Total value of Gross Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[2]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Gross Sales Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expects1;
			        	
			        	//Print the different value
			        	System.out.println("Gross Sales Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Gross Sales Value different is : "+different);	
			        }
		        	
		        	//Check weather the Net Sales total is same or not
		        	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
		        	{
			        	test.log(LogStatus.PASS, "Actual and Expected Net Sales Values are same");
			        	
			        	//Get the Total value of Net Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Net Sales element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Net Sales Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Net Sales Value is : "+ actual);
			        }
			        
					else if(expect2 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Net Sales
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/span")).getText();
	
			        	System.out.println("The Actual Net Sales value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Net Sales value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Net Sales values are different");
			        	
			        	//Get the Total value of Gross Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Net Sales Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect2;
			        	
			        	//Print the different value
			        	System.out.println("Net Sales Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Net Sales Value different is : "+different);	
			        }
		        	
		        	//Check weather the Grand Sales total is same or not
		        	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
		        	{
			        	test.log(LogStatus.PASS, "Actual and Expected Grand Sales Values are same");
			        	
			        	//Get the Total value of Grand Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[4]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Grand Sales element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Grand Sales Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Grand Sales Value is : "+ actual);
			        }
			        
					else if(expect3 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Grand Sales
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[4]/span")).getText();
	
			        	System.out.println("The Actual Grand Sales value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Grand Sales value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Grand Sales values are different");
			        	
			        	//Get the Total value of Grand Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[4]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Net Sales Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect3;
			        	
			        	//Print the different value
			        	System.out.println("Grand Sales Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Grand Sales Value different is : "+different);	
			        }
		        	
				}
				else
				{
					test.log(LogStatus.INFO, "Sales is not available");
					
					System.out.println("Sales is not available");
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "Check Stats field is not available");
				
				
				
				Thread.sleep(8000);
				//Check the SALES
				if(driver.getPageSource().contains("SALES"))
				{
					test.log(LogStatus.INFO, "SALES is available");
					
					System.out.println("SALES is available");
					
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Gross_Sales").replace(",", "");
		        	
		        	//Convert the String value of the Gross_Sales element into float value
		        	float expect1 = Float.parseFloat(expected1);  
		        	
		        	//Replace all commo's with empty space
		        	String expected2 = Utility.getReportProperty("Sale_Report_Net_Sale").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Net_Sale element into float value
		        	float expect2 = Float.parseFloat(expected2);
		        	
		        	//Replace all commo's with empty space
		        	String expected3 = Utility.getReportProperty("Sale_Report_Grand_Sale").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Grand_Sale element into float value
		        	float expect3 = Float.parseFloat(expected3);
		        	
		        	//Check weather the Gross Sales total is same or not
		        	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText().equals(Utility.getReportProperty("Gross_Sales")))
		        	{
			        	test.log(LogStatus.PASS, "Actual and Expected Gross Sales Values are same");
			        	
			        	//Get the Total value of Gross Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Gross Sales element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Gross Sales Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Gross Sales Value is : "+ actual);
			        }
			        
					else if(expect1 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Gross Sales
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText();
	
			        	System.out.println("The Actual Gross Sales value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Gross Sales value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Gross Sales values are different");
			        	
			        	//Get the Total value of Gross Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Gross Sales Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect1;
			        	
			        	//Print the different value
			        	System.out.println("Gross Sales Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Gross Sales Value different is : "+different);	
			        }
		        	
		        	//Check weather the Net Sales total is same or not
		        	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
		        	{
			        	test.log(LogStatus.PASS, "Actual and Expected Net Sales Values are same");
			        	
			        	//Get the Total value of Net Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[3]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Net Sales element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Net Sales Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Net Sales Value is : "+ actual);
			        }
			        
					else if(expect2 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Net Sales
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[3]/span")).getText();
	
			        	System.out.println("The Actual Net Sales value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Net Sales value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Net Sales values are different");
			        	
			        	//Get the Total value of Gross Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[3]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Net Sales Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect2;
			        	
			        	//Print the different value
			        	System.out.println("Net Sales Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Net Sales Value different is : "+different);	
			        }
		        	
		        	//Check weather the Grand Sales total is same or not
		        	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
		        	{
			        	test.log(LogStatus.PASS, "Actual and Expected Grand Sales Values are same");
			        	
			        	//Get the Total value of Grand Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[4]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Grand Sales element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Grand Sales Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Grand Sales Value is : "+ actual);
			        }
			        
					else if(expect3 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Grand Sales
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[4]/span")).getText();
	
			        	System.out.println("The Actual Grand Sales value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Grand Sales value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Grand Sales values are different");
			        	
			        	//Get the Total value of Grand Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[4]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Net Sales Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect3;
			        	
			        	//Print the different value
			        	System.out.println("Grand Sales Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Grand Sales Value different is : "+different);	
			        }
		        	
				}
				else
				{
					test.log(LogStatus.INFO, "Sales is not available");
					
					System.out.println("Sales is not available");
				}
				
	
			}
			
		}
	
}
