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

public class Verify_Revenue_Center_Report {

	public WebDriver driver;

		ExtentReports rep = ExtentManager.getInstance();
		ExtentTest test = rep.startTest("Verify_Revenue_Center_Report");
		
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

		@Test(priority=24)
		public void Revenue_Center_Report_Open_Page_Report() throws Exception
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
		public void Revenue_Center_Report_By_All_Options_Selected() throws Exception
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
		public void Revenue_Center_Report_By_Required_Options_Selected() throws Exception
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

}
