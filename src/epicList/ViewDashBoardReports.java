package epicList;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;





import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import epicList_Integrated.Utility;

public class ViewDashBoardReports {
	
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Dash Board");

	@AfterClass
	public void flushTest() throws Exception
	{

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
			
		@Parameters({"driver"})@Test(priority=500)
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
		}}
		
		@Parameters({"driver"})@Test(priority=2)
		public void refreshTheDashBoard_Sales() throws InterruptedException
		{
			WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			
			Thread.sleep(5000);
			//Click the Refresh button      
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[3]")).click();
	
			//Check whether the dashboard page refreshed or not
			if(driver.findElement(By.xpath("//a[.='Sale Dashboard']")).getText().equalsIgnoreCase("Sale Dashboard"))
			{
				test.log(LogStatus.PASS, "Sale Dashboard refreshed Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Sale Dashboard refreshed Failed");
			}
	
		}
	
		@Parameters({"driver"})@Test(priority=3)
		public void viewDashboardElementsForToday_Sales() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Today button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[1]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Sales Reports for Today *****");
			
			Thread.sleep(5000);
		    //Check Whether the Net Sale Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='Net sale']")).getText().equalsIgnoreCase("Net sale"))
		    {
		    	test.log(LogStatus.PASS, "Net sale field is available");
		    	
		    	test.log(LogStatus.INFO, "Void amount from total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[1]")).getText());
		    	
		    	test.log(LogStatus.INFO, "Total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Net sale field is not available");
		    }
		    
		    
		    //Check Whether the Tax Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]")).getText().equalsIgnoreCase("Tax"))
		    {
		    	test.log(LogStatus.PASS, "Tax field is available");
		    	
		    	test.log(LogStatus.INFO, "Void tax amount from total tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Tax amount is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Tax field is not available");
		    }
		    
		    
		    //Check Whether the Transactions Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]")).getText().equalsIgnoreCase("Transactions"))
		    {
		    	test.log(LogStatus.PASS, "Transactions field is available");
		    	
		    	test.log(LogStatus.INFO, "Number of Void transaction from total transaction is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Transaction is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Transactions field is not available");
		    }
		    
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[1]")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    	test.log(LogStatus.INFO, "Total number of customer(s) is/are : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Discount Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[1]")).getText().equalsIgnoreCase("Discount"))
		    {
		    	test.log(LogStatus.PASS, "Discount field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Discount amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Discount field is not available");
		    }
		    
		    
		    //Check Whether the Refunds Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[1]")).getText().equalsIgnoreCase("Refunds"))
		    {
		    	test.log(LogStatus.PASS, "Refunds field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Refund amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Refunds field is not available");
		    }
		    
		    
		    //Check Whether the Labour Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[1]")).getText().equalsIgnoreCase("Labour"))
		    {
		    	test.log(LogStatus.PASS, "Labour field is available");
		    	
		    	test.log(LogStatus.INFO, "Labour Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour field is not available");
		    }
		    
		    
		    //Check Whether the COGS Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[1]")).getText().equalsIgnoreCase("COGS"))
		    {
		    	test.log(LogStatus.PASS, "COGS field is available");
		    	
		    	test.log(LogStatus.INFO, "Cost Of Goods Sold percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "COGS field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[1]")).getText().equalsIgnoreCase("SPLH"))
		    {
		    	test.log(LogStatus.PASS, "SPLH field is available");
		    	
		    	test.log(LogStatus.INFO, "Sales Per Labour Hour is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SPLH field is not available");
		    }
		    
		    
	
		    
		    //Check Whether the NET SALES BY HOUR Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='NET SALES BY HOUR']")).getText().equalsIgnoreCase("NET SALES BY HOUR"))
		    {
		    	test.log(LogStatus.PASS, "NET SALES BY HOUR field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "NET SALES BY HOUR field is not available");
		    }
		    
		    
		    //Check Whether the SALE PER ORDER TYPE Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE PER ORDER TYPE']")).getText().equalsIgnoreCase("SALE PER ORDER TYPE"))
		    {
		    	test.log(LogStatus.PASS, "SALE PER ORDER TYPE field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE PER ORDER TYPE field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE BY TENDER']")).getText().equalsIgnoreCase("SALE BY TENDER"))
		    {
		    	test.log(LogStatus.PASS, "SALE BY TENDER field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE BY TENDER field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Todays Sale Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=4)
		public void viewDashboardElementsForYesterday_Sales() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Yesterday button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[2]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Sales Reports for Yesterday *****");
			
			Thread.sleep(5000);
		    //Check Whether the Net Sale Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='Net sale']")).getText().equalsIgnoreCase("Net sale"))
		    {
		    	test.log(LogStatus.PASS, "Net sale field is available");
		    	
		    	test.log(LogStatus.INFO, "Void amount from total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[1]")).getText());
		    	
		    	test.log(LogStatus.INFO, "Total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Net sale field is not available");
		    }
		    
		    
		    //Check Whether the Tax Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]")).getText().equalsIgnoreCase("Tax"))
		    {
		    	test.log(LogStatus.PASS, "Tax field is available");
		    	
		    	test.log(LogStatus.INFO, "Void tax amount from total tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Tax amount is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Tax field is not available");
		    }
		    
		    
		    //Check Whether the Transactions Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]")).getText().equalsIgnoreCase("Transactions"))
		    {
		    	test.log(LogStatus.PASS, "Transactions field is available");
		    	
		    	test.log(LogStatus.INFO, "Number of Void transaction from total transaction is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Transaction is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Transactions field is not available");
		    }
		    
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[1]")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    	test.log(LogStatus.INFO, "Total number of customer(s) is/are : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Discount Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[1]")).getText().equalsIgnoreCase("Discount"))
		    {
		    	test.log(LogStatus.PASS, "Discount field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Discount amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Discount field is not available");
		    }
		    
		    
		    //Check Whether the Refunds Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[1]")).getText().equalsIgnoreCase("Refunds"))
		    {
		    	test.log(LogStatus.PASS, "Refunds field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Refund amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Refunds field is not available");
		    }
		    
		    
		    //Check Whether the Labour Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[1]")).getText().equalsIgnoreCase("Labour"))
		    {
		    	test.log(LogStatus.PASS, "Labour field is available");
		    	
		    	test.log(LogStatus.INFO, "Labour Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour field is not available");
		    }
		    
		    
		    //Check Whether the COGS Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[1]")).getText().equalsIgnoreCase("COGS"))
		    {
		    	test.log(LogStatus.PASS, "COGS field is available");
		    	
		    	test.log(LogStatus.INFO, "Cost Of Goods Sold percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "COGS field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[1]")).getText().equalsIgnoreCase("SPLH"))
		    {
		    	test.log(LogStatus.PASS, "SPLH field is available");
		    	
		    	test.log(LogStatus.INFO, "Sales Per Labour Hour is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SPLH field is not available");
		    }
		    
		    
		    
	
		    //Check Whether the NET SALES BY HOUR Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='NET SALES BY HOUR']")).getText().equalsIgnoreCase("NET SALES BY HOUR"))
		    {
		    	test.log(LogStatus.PASS, "NET SALES BY HOUR field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "NET SALES BY HOUR field is not available");
		    }
		    
		    
		    //Check Whether the SALE PER ORDER TYPE Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE PER ORDER TYPE']")).getText().equalsIgnoreCase("SALE PER ORDER TYPE"))
		    {
		    	test.log(LogStatus.PASS, "SALE PER ORDER TYPE field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE PER ORDER TYPE field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE BY TENDER']")).getText().equalsIgnoreCase("SALE BY TENDER"))
		    {
		    	test.log(LogStatus.PASS, "SALE BY TENDER field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE BY TENDER field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Yesterdays Sale Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=5)
		public void viewDashboardElementsForLastNday_Sales() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Today button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[3]/a")).click();
			//Enter the required day
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[3]/div/div/div/input")).sendKeys("100");
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Sales Reports for Last N day *****");
			
			Thread.sleep(5000);
		    //Check Whether the Net Sale Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='Net sale']")).getText().equalsIgnoreCase("Net sale"))
		    {
		    	test.log(LogStatus.PASS, "Net sale field is available");
		    	
		    	test.log(LogStatus.INFO, "Void amount from total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[1]")).getText());
		    	
		    	test.log(LogStatus.INFO, "Total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Net sale field is not available");
		    }
		    
		    
		    //Check Whether the Tax Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]")).getText().equalsIgnoreCase("Tax"))
		    {
		    	test.log(LogStatus.PASS, "Tax field is available");
		    	
		    	test.log(LogStatus.INFO, "Void tax amount from total tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Tax amount is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Tax field is not available");
		    }
		    
		    
		    //Check Whether the Transactions Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]")).getText().equalsIgnoreCase("Transactions"))
		    {
		    	test.log(LogStatus.PASS, "Transactions field is available");
		    	
		    	test.log(LogStatus.INFO, "Number of Void transaction from total transaction is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Transaction is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Transactions field is not available");
		    }
		    
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[1]")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    	test.log(LogStatus.INFO, "Total number of customer(s) is/are : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Discount Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[1]")).getText().equalsIgnoreCase("Discount"))
		    {
		    	test.log(LogStatus.PASS, "Discount field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Discount amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Discount field is not available");
		    }
		    
		    
		    //Check Whether the Refunds Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[1]")).getText().equalsIgnoreCase("Refunds"))
		    {
		    	test.log(LogStatus.PASS, "Refunds field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Refund amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Refunds field is not available");
		    }
		    
		    
		    //Check Whether the Labour Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[1]")).getText().equalsIgnoreCase("Labour"))
		    {
		    	test.log(LogStatus.PASS, "Labour field is available");
		    	
		    	test.log(LogStatus.INFO, "Labour Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour field is not available");
		    }
		    
		    
		    //Check Whether the COGS Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[1]")).getText().equalsIgnoreCase("COGS"))
		    {
		    	test.log(LogStatus.PASS, "COGS field is available");
		    	
		    	test.log(LogStatus.INFO, "Cost Of Goods Sold percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "COGS field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[1]")).getText().equalsIgnoreCase("SPLH"))
		    {
		    	test.log(LogStatus.PASS, "SPLH field is available");
		    	
		    	test.log(LogStatus.INFO, "Sales Per Labour Hour is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SPLH field is not available");
		    }
		    
		    
	
		    
		    //Check Whether the NET SALES BY HOUR Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='NET SALES BY HOUR']")).getText().equalsIgnoreCase("NET SALES BY HOUR"))
		    {
		    	test.log(LogStatus.PASS, "NET SALES BY HOUR field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "NET SALES BY HOUR field is not available");
		    }
		    
		    
		    //Check Whether the SALE PER ORDER TYPE Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE PER ORDER TYPE']")).getText().equalsIgnoreCase("SALE PER ORDER TYPE"))
		    {
		    	test.log(LogStatus.PASS, "SALE PER ORDER TYPE field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE PER ORDER TYPE field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE BY TENDER']")).getText().equalsIgnoreCase("SALE BY TENDER"))
		    {
		    	test.log(LogStatus.PASS, "SALE BY TENDER field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE BY TENDER field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Last N Days Sale Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=6)
		public void viewDashboardElementsForThisWeek_Sales() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the This Week option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[4]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Sales Reports for This Week *****");
			
			Thread.sleep(5000);
		    //Check Whether the Net Sale Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='Net sale']")).getText().equalsIgnoreCase("Net sale"))
		    {
		    	test.log(LogStatus.PASS, "Net sale field is available");
		    	
		    	test.log(LogStatus.INFO, "Void amount from total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[1]")).getText());
		    	
		    	test.log(LogStatus.INFO, "Total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Net sale field is not available");
		    }
		    
		    
		    //Check Whether the Tax Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]")).getText().equalsIgnoreCase("Tax"))
		    {
		    	test.log(LogStatus.PASS, "Tax field is available");
		    	
		    	test.log(LogStatus.INFO, "Void tax amount from total tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Tax amount is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Tax field is not available");
		    }
		    
		    
		    //Check Whether the Transactions Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]")).getText().equalsIgnoreCase("Transactions"))
		    {
		    	test.log(LogStatus.PASS, "Transactions field is available");
		    	
		    	test.log(LogStatus.INFO, "Number of Void transaction from total transaction is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Transaction is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Transactions field is not available");
		    }
		    
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[1]")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    	test.log(LogStatus.INFO, "Total number of customer(s) is/are : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Discount Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[1]")).getText().equalsIgnoreCase("Discount"))
		    {
		    	test.log(LogStatus.PASS, "Discount field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Discount amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Discount field is not available");
		    }
		    
		    
		    //Check Whether the Refunds Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[1]")).getText().equalsIgnoreCase("Refunds"))
		    {
		    	test.log(LogStatus.PASS, "Refunds field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Refund amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Refunds field is not available");
		    }
		    
		    
		    //Check Whether the Labour Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[1]")).getText().equalsIgnoreCase("Labour"))
		    {
		    	test.log(LogStatus.PASS, "Labour field is available");
		    	
		    	test.log(LogStatus.INFO, "Labour Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour field is not available");
		    }
		    
		    
		    //Check Whether the COGS Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[1]")).getText().equalsIgnoreCase("COGS"))
		    {
		    	test.log(LogStatus.PASS, "COGS field is available");
		    	
		    	test.log(LogStatus.INFO, "Cost Of Goods Sold percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "COGS field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[1]")).getText().equalsIgnoreCase("SPLH"))
		    {
		    	test.log(LogStatus.PASS, "SPLH field is available");
		    	
		    	test.log(LogStatus.INFO, "Sales Per Labour Hour is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SPLH field is not available");
		    }
		    
		    
	
		    
		    //Check Whether the NET SALES BY HOUR Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='NET SALES BY HOUR']")).getText().equalsIgnoreCase("NET SALES BY HOUR"))
		    {
		    	test.log(LogStatus.PASS, "NET SALES BY HOUR field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "NET SALES BY HOUR field is not available");
		    }
		    
		    
		    //Check Whether the SALE PER ORDER TYPE Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE PER ORDER TYPE']")).getText().equalsIgnoreCase("SALE PER ORDER TYPE"))
		    {
		    	test.log(LogStatus.PASS, "SALE PER ORDER TYPE field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE PER ORDER TYPE field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE BY TENDER']")).getText().equalsIgnoreCase("SALE BY TENDER"))
		    {
		    	test.log(LogStatus.PASS, "SALE BY TENDER field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE BY TENDER field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of This Week Sale Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=7)
		public void viewDashboardElementsForLastWeek_Sales() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Last Week option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[5]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Sales Reports for Last Week *****");
			
			Thread.sleep(5000);
		    //Check Whether the Net Sale Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='Net sale']")).getText().equalsIgnoreCase("Net sale"))
		    {
		    	test.log(LogStatus.PASS, "Net sale field is available");
		    	
		    	test.log(LogStatus.INFO, "Void amount from total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[1]")).getText());
		    	
		    	test.log(LogStatus.INFO, "Total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Net sale field is not available");
		    }
		    
		    
		    //Check Whether the Tax Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]")).getText().equalsIgnoreCase("Tax"))
		    {
		    	test.log(LogStatus.PASS, "Tax field is available");
		    	
		    	test.log(LogStatus.INFO, "Void tax amount from total tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Tax amount is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Tax field is not available");
		    }
		    
		    
		    //Check Whether the Transactions Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]")).getText().equalsIgnoreCase("Transactions"))
		    {
		    	test.log(LogStatus.PASS, "Transactions field is available");
		    	
		    	test.log(LogStatus.INFO, "Number of Void transaction from total transaction is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Transaction is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Transactions field is not available");
		    }
		    
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[1]")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    	test.log(LogStatus.INFO, "Total number of customer(s) is/are : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Discount Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[1]")).getText().equalsIgnoreCase("Discount"))
		    {
		    	test.log(LogStatus.PASS, "Discount field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Discount amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Discount field is not available");
		    }
		    
		    
		    //Check Whether the Refunds Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[1]")).getText().equalsIgnoreCase("Refunds"))
		    {
		    	test.log(LogStatus.PASS, "Refunds field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Refund amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Refunds field is not available");
		    }
		    
		    
		    //Check Whether the Labour Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[1]")).getText().equalsIgnoreCase("Labour"))
		    {
		    	test.log(LogStatus.PASS, "Labour field is available");
		    	
		    	test.log(LogStatus.INFO, "Labour Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour field is not available");
		    }
		    
		    
		    //Check Whether the COGS Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[1]")).getText().equalsIgnoreCase("COGS"))
		    {
		    	test.log(LogStatus.PASS, "COGS field is available");
		    	
		    	test.log(LogStatus.INFO, "Cost Of Goods Sold percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "COGS field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[1]")).getText().equalsIgnoreCase("SPLH"))
		    {
		    	test.log(LogStatus.PASS, "SPLH field is available");
		    	
		    	test.log(LogStatus.INFO, "Sales Per Labour Hour is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SPLH field is not available");
		    }
		    
		    
	
		    
		    //Check Whether the NET SALES BY HOUR Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='NET SALES BY HOUR']")).getText().equalsIgnoreCase("NET SALES BY HOUR"))
		    {
		    	test.log(LogStatus.PASS, "NET SALES BY HOUR field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "NET SALES BY HOUR field is not available");
		    }
		    
		    
		    //Check Whether the SALE PER ORDER TYPE Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE PER ORDER TYPE']")).getText().equalsIgnoreCase("SALE PER ORDER TYPE"))
		    {
		    	test.log(LogStatus.PASS, "SALE PER ORDER TYPE field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE PER ORDER TYPE field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE BY TENDER']")).getText().equalsIgnoreCase("SALE BY TENDER"))
		    {
		    	test.log(LogStatus.PASS, "SALE BY TENDER field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE BY TENDER field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Last Week Sale Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=8)
		public void viewDashboardElementsForLast7Days_Sales() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Last 7 Days option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[6]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Sales Reports for Last 7 Days  *****");
		
			
			Thread.sleep(5000);
		    //Check Whether the Net Sale Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='Net sale']")).getText().equalsIgnoreCase("Net sale"))
		    {
		    	test.log(LogStatus.PASS, "Net sale field is available");
		    	
		    	test.log(LogStatus.INFO, "Void amount from total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[1]")).getText());
		    	
		    	test.log(LogStatus.INFO, "Total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Net sale field is not available");
		    }
		    
		    
		    //Check Whether the Tax Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]")).getText().equalsIgnoreCase("Tax"))
		    {
		    	test.log(LogStatus.PASS, "Tax field is available");
		    	
		    	test.log(LogStatus.INFO, "Void tax amount from total tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Tax amount is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Tax field is not available");
		    }
		    
		    
		    //Check Whether the Transactions Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]")).getText().equalsIgnoreCase("Transactions"))
		    {
		    	test.log(LogStatus.PASS, "Transactions field is available");
		    	
		    	test.log(LogStatus.INFO, "Number of Void transaction from total transaction is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Transaction is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Transactions field is not available");
		    }
		    
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[1]")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    	test.log(LogStatus.INFO, "Total number of customer(s) is/are : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Discount Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[1]")).getText().equalsIgnoreCase("Discount"))
		    {
		    	test.log(LogStatus.PASS, "Discount field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Discount amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Discount field is not available");
		    }
		    
		    
		    //Check Whether the Refunds Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[1]")).getText().equalsIgnoreCase("Refunds"))
		    {
		    	test.log(LogStatus.PASS, "Refunds field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Refund amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Refunds field is not available");
		    }
		    
		    
		    //Check Whether the Labour Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[1]")).getText().equalsIgnoreCase("Labour"))
		    {
		    	test.log(LogStatus.PASS, "Labour field is available");
		    	
		    	test.log(LogStatus.INFO, "Labour Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour field is not available");
		    }
		    
		    
		    //Check Whether the COGS Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[1]")).getText().equalsIgnoreCase("COGS"))
		    {
		    	test.log(LogStatus.PASS, "COGS field is available");
		    	
		    	test.log(LogStatus.INFO, "Cost Of Goods Sold percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "COGS field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[1]")).getText().equalsIgnoreCase("SPLH"))
		    {
		    	test.log(LogStatus.PASS, "SPLH field is available");
		    	
		    	test.log(LogStatus.INFO, "Sales Per Labour Hour is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SPLH field is not available");
		    }
		    
		    
		    
		    
		    //Check Whether the NET SALES BY HOUR Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='NET SALES BY HOUR']")).getText().equalsIgnoreCase("NET SALES BY HOUR"))
		    {
		    	test.log(LogStatus.PASS, "NET SALES BY HOUR field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "NET SALES BY HOUR field is not available");
		    }
		    
		    
		    //Check Whether the SALE PER ORDER TYPE Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE PER ORDER TYPE']")).getText().equalsIgnoreCase("SALE PER ORDER TYPE"))
		    {
		    	test.log(LogStatus.PASS, "SALE PER ORDER TYPE field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE PER ORDER TYPE field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE BY TENDER']")).getText().equalsIgnoreCase("SALE BY TENDER"))
		    {
		    	test.log(LogStatus.PASS, "SALE BY TENDER field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE BY TENDER field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Last 7 Days Sale Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=9)
		public void viewDashboardElementsForThisMonth_Sales() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the This Month option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[7]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Sales Reports for This Month  *****");
		
			
			Thread.sleep(5000);
		    //Check Whether the Net Sale Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='Net sale']")).getText().equalsIgnoreCase("Net sale"))
		    {
		    	test.log(LogStatus.PASS, "Net sale field is available");
		    	
		    	test.log(LogStatus.INFO, "Void amount from total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[1]")).getText());
		    	
		    	test.log(LogStatus.INFO, "Total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Net sale field is not available");
		    }
		    
		    
		    //Check Whether the Tax Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]")).getText().equalsIgnoreCase("Tax"))
		    {
		    	test.log(LogStatus.PASS, "Tax field is available");
		    	
		    	test.log(LogStatus.INFO, "Void tax amount from total tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Tax amount is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Tax field is not available");
		    }
		    
		    
		    //Check Whether the Transactions Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]")).getText().equalsIgnoreCase("Transactions"))
		    {
		    	test.log(LogStatus.PASS, "Transactions field is available");
		    	
		    	test.log(LogStatus.INFO, "Number of Void transaction from total transaction is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Transaction is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Transactions field is not available");
		    }
		    
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[1]")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    	test.log(LogStatus.INFO, "Total number of customer(s) is/are : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Discount Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[1]")).getText().equalsIgnoreCase("Discount"))
		    {
		    	test.log(LogStatus.PASS, "Discount field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Discount amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Discount field is not available");
		    }
		    
		    
		    //Check Whether the Refunds Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[1]")).getText().equalsIgnoreCase("Refunds"))
		    {
		    	test.log(LogStatus.PASS, "Refunds field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Refund amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Refunds field is not available");
		    }
		    
		    
		    //Check Whether the Labour Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[1]")).getText().equalsIgnoreCase("Labour"))
		    {
		    	test.log(LogStatus.PASS, "Labour field is available");
		    	
		    	test.log(LogStatus.INFO, "Labour Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour field is not available");
		    }
		    
		    
		    //Check Whether the COGS Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[1]")).getText().equalsIgnoreCase("COGS"))
		    {
		    	test.log(LogStatus.PASS, "COGS field is available");
		    	
		    	test.log(LogStatus.INFO, "Cost Of Goods Sold percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "COGS field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[1]")).getText().equalsIgnoreCase("SPLH"))
		    {
		    	test.log(LogStatus.PASS, "SPLH field is available");
		    	
		    	test.log(LogStatus.INFO, "Sales Per Labour Hour is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SPLH field is not available");
		    }
		    
		    
	
		    
		    //Check Whether the NET SALES BY HOUR Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='NET SALES BY HOUR']")).getText().equalsIgnoreCase("NET SALES BY HOUR"))
		    {
		    	test.log(LogStatus.PASS, "NET SALES BY HOUR field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "NET SALES BY HOUR field is not available");
		    }
		    
		    
		    //Check Whether the SALE PER ORDER TYPE Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE PER ORDER TYPE']")).getText().equalsIgnoreCase("SALE PER ORDER TYPE"))
		    {
		    	test.log(LogStatus.PASS, "SALE PER ORDER TYPE field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE PER ORDER TYPE field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE BY TENDER']")).getText().equalsIgnoreCase("SALE BY TENDER"))
		    {
		    	test.log(LogStatus.PASS, "SALE BY TENDER field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE BY TENDER field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of This Month Sale Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=10)
		public void viewDashboardElementsForLastMonth_Sales() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Last Month option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[8]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Sales Reports for Last Month  *****");
		
			
			Thread.sleep(5000);
		    //Check Whether the Net Sale Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='Net sale']")).getText().equalsIgnoreCase("Net sale"))
		    {
		    	test.log(LogStatus.PASS, "Net sale field is available");
		    	
		    	test.log(LogStatus.INFO, "Void amount from total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[1]")).getText());
		    	
		    	test.log(LogStatus.INFO, "Total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Net sale field is not available");
		    }
		    
		    
		    //Check Whether the Tax Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]")).getText().equalsIgnoreCase("Tax"))
		    {
		    	test.log(LogStatus.PASS, "Tax field is available");
		    	
		    	test.log(LogStatus.INFO, "Void tax amount from total tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Tax amount is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Tax field is not available");
		    }
		    
		    
		    //Check Whether the Transactions Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]")).getText().equalsIgnoreCase("Transactions"))
		    {
		    	test.log(LogStatus.PASS, "Transactions field is available");
		    	
		    	test.log(LogStatus.INFO, "Number of Void transaction from total transaction is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Transaction is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Transactions field is not available");
		    }
		    
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[1]")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    	test.log(LogStatus.INFO, "Total number of customer(s) is/are : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Discount Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[1]")).getText().equalsIgnoreCase("Discount"))
		    {
		    	test.log(LogStatus.PASS, "Discount field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Discount amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Discount field is not available");
		    }
		    
		    
		    //Check Whether the Refunds Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[1]")).getText().equalsIgnoreCase("Refunds"))
		    {
		    	test.log(LogStatus.PASS, "Refunds field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Refund amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Refunds field is not available");
		    }
		    
		    
		    //Check Whether the Labour Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[1]")).getText().equalsIgnoreCase("Labour"))
		    {
		    	test.log(LogStatus.PASS, "Labour field is available");
		    	
		    	test.log(LogStatus.INFO, "Labour Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour field is not available");
		    }
		    
		    
		    //Check Whether the COGS Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[1]")).getText().equalsIgnoreCase("COGS"))
		    {
		    	test.log(LogStatus.PASS, "COGS field is available");
		    	
		    	test.log(LogStatus.INFO, "Cost Of Goods Sold percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "COGS field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[1]")).getText().equalsIgnoreCase("SPLH"))
		    {
		    	test.log(LogStatus.PASS, "SPLH field is available");
		    	
		    	test.log(LogStatus.INFO, "Sales Per Labour Hour is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SPLH field is not available");
		    }
		    
		    
		    
		    //Check Whether the NET SALES BY HOUR Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='NET SALES BY HOUR']")).getText().equalsIgnoreCase("NET SALES BY HOUR"))
		    {
		    	test.log(LogStatus.PASS, "NET SALES BY HOUR field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "NET SALES BY HOUR field is not available");
		    }
		    
		    
		    //Check Whether the SALE PER ORDER TYPE Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE PER ORDER TYPE']")).getText().equalsIgnoreCase("SALE PER ORDER TYPE"))
		    {
		    	test.log(LogStatus.PASS, "SALE PER ORDER TYPE field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE PER ORDER TYPE field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE BY TENDER']")).getText().equalsIgnoreCase("SALE BY TENDER"))
		    {
		    	test.log(LogStatus.PASS, "SALE BY TENDER field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE BY TENDER field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Last Month Sale Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=11)
		public void viewDashboardElementsForLast30Days_Sales() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Last 30 Days option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[9]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Sales Reports for Last 30 Days  *****");
		
			
			Thread.sleep(5000);
		    //Check Whether the Net Sale Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='Net sale']")).getText().equalsIgnoreCase("Net sale"))
		    {
		    	test.log(LogStatus.PASS, "Net sale field is available");
		    	
		    	test.log(LogStatus.INFO, "Void amount from total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[1]")).getText());
		    	
		    	test.log(LogStatus.INFO, "Total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Net sale field is not available");
		    }
		    
		    
		    //Check Whether the Tax Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]")).getText().equalsIgnoreCase("Tax"))
		    {
		    	test.log(LogStatus.PASS, "Tax field is available");
		    	
		    	test.log(LogStatus.INFO, "Void tax amount from total tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Tax amount is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Tax field is not available");
		    }
		    
		    
		    //Check Whether the Transactions Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]")).getText().equalsIgnoreCase("Transactions"))
		    {
		    	test.log(LogStatus.PASS, "Transactions field is available");
		    	
		    	test.log(LogStatus.INFO, "Number of Void transaction from total transaction is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Transaction is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Transactions field is not available");
		    }
		    
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[1]")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    	test.log(LogStatus.INFO, "Total number of customer(s) is/are : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Discount Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[1]")).getText().equalsIgnoreCase("Discount"))
		    {
		    	test.log(LogStatus.PASS, "Discount field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Discount amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Discount field is not available");
		    }
		    
		    
		    //Check Whether the Refunds Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[1]")).getText().equalsIgnoreCase("Refunds"))
		    {
		    	test.log(LogStatus.PASS, "Refunds field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Refund amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Refunds field is not available");
		    }
		    
		    
		    //Check Whether the Labour Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[1]")).getText().equalsIgnoreCase("Labour"))
		    {
		    	test.log(LogStatus.PASS, "Labour field is available");
		    	
		    	test.log(LogStatus.INFO, "Labour Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour field is not available");
		    }
		    
		    
		    //Check Whether the COGS Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[1]")).getText().equalsIgnoreCase("COGS"))
		    {
		    	test.log(LogStatus.PASS, "COGS field is available");
		    	
		    	test.log(LogStatus.INFO, "Cost Of Goods Sold percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "COGS field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[1]")).getText().equalsIgnoreCase("SPLH"))
		    {
		    	test.log(LogStatus.PASS, "SPLH field is available");
		    	
		    	test.log(LogStatus.INFO, "Sales Per Labour Hour is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SPLH field is not available");
		    }
		    
		    
	
		    
		    //Check Whether the NET SALES BY HOUR Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='NET SALES BY HOUR']")).getText().equalsIgnoreCase("NET SALES BY HOUR"))
		    {
		    	test.log(LogStatus.PASS, "NET SALES BY HOUR field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "NET SALES BY HOUR field is not available");
		    }
		    
		    
		    //Check Whether the SALE PER ORDER TYPE Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE PER ORDER TYPE']")).getText().equalsIgnoreCase("SALE PER ORDER TYPE"))
		    {
		    	test.log(LogStatus.PASS, "SALE PER ORDER TYPE field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE PER ORDER TYPE field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE BY TENDER']")).getText().equalsIgnoreCase("SALE BY TENDER"))
		    {
		    	test.log(LogStatus.PASS, "SALE BY TENDER field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE BY TENDER field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Last 30 Days Sale Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=12)
		public void viewDashboardElementsForSpecificDate_Sales() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Specific Date option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[10]/a")).click();
			//Enter the specific Date
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[10]/div/div/div/div/input")).sendKeys("30-Apr-2018");
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Sales Reports for Specific Date  *****");
		
			
			Thread.sleep(5000);
		    //Check Whether the Net Sale Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='Net sale']")).getText().equalsIgnoreCase("Net sale"))
		    {
		    	test.log(LogStatus.PASS, "Net sale field is available");
		    	
		    	test.log(LogStatus.INFO, "Void amount from total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[1]")).getText());
		    	
		    	test.log(LogStatus.INFO, "Total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Net sale field is not available");
		    }
		    
		    
		    //Check Whether the Tax Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]")).getText().equalsIgnoreCase("Tax"))
		    {
		    	test.log(LogStatus.PASS, "Tax field is available");
		    	
		    	test.log(LogStatus.INFO, "Void tax amount from total tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Tax amount is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Tax field is not available");
		    }
		    
		    
		    //Check Whether the Transactions Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]")).getText().equalsIgnoreCase("Transactions"))
		    {
		    	test.log(LogStatus.PASS, "Transactions field is available");
		    	
		    	test.log(LogStatus.INFO, "Number of Void transaction from total transaction is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Transaction is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Transactions field is not available");
		    }
		    
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[1]")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    	test.log(LogStatus.INFO, "Total number of customer(s) is/are : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Discount Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[1]")).getText().equalsIgnoreCase("Discount"))
		    {
		    	test.log(LogStatus.PASS, "Discount field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Discount amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Discount field is not available");
		    }
		    
		    
		    //Check Whether the Refunds Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[1]")).getText().equalsIgnoreCase("Refunds"))
		    {
		    	test.log(LogStatus.PASS, "Refunds field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Refund amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Refunds field is not available");
		    }
		    
		    
		    //Check Whether the Labour Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[1]")).getText().equalsIgnoreCase("Labour"))
		    {
		    	test.log(LogStatus.PASS, "Labour field is available");
		    	
		    	test.log(LogStatus.INFO, "Labour Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour field is not available");
		    }
		    
		    
		    //Check Whether the COGS Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[1]")).getText().equalsIgnoreCase("COGS"))
		    {
		    	test.log(LogStatus.PASS, "COGS field is available");
		    	
		    	test.log(LogStatus.INFO, "Cost Of Goods Sold percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "COGS field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[1]")).getText().equalsIgnoreCase("SPLH"))
		    {
		    	test.log(LogStatus.PASS, "SPLH field is available");
		    	
		    	test.log(LogStatus.INFO, "Sales Per Labour Hour is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SPLH field is not available");
		    }
		    
		    
		    
		    //Check Whether the NET SALES BY HOUR Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='NET SALES BY HOUR']")).getText().equalsIgnoreCase("NET SALES BY HOUR"))
		    {
		    	test.log(LogStatus.PASS, "NET SALES BY HOUR field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "NET SALES BY HOUR field is not available");
		    }
		    
		    
		    //Check Whether the SALE PER ORDER TYPE Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE PER ORDER TYPE']")).getText().equalsIgnoreCase("SALE PER ORDER TYPE"))
		    {
		    	test.log(LogStatus.PASS, "SALE PER ORDER TYPE field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE PER ORDER TYPE field is not available");
		    }
		    
		    
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE BY TENDER']")).getText().equalsIgnoreCase("SALE BY TENDER"))
		    {
		    	test.log(LogStatus.PASS, "SALE BY TENDER field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE BY TENDER field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Specific Date Sale Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=13)
		public void viewDashboardElementsForDateRange_Sales() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Specific Date option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[11]/a")).click();
			//Clear the start date field
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[11]/div/div/div/div/input[1]")).clear();
			//Enter the start Date
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[11]/div/div/div/div/input[1]")).sendKeys("30-Apr-2018");
			Thread.sleep(3000);
			//Clear the End Date
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[11]/div/div/div/div/input[2]")).clear();
			//Enter the End Date
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[11]/div/div/div/div/input[2]")).sendKeys("20-Jun-2018");
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Sales Reports for Date Range Sale  *****");
		
			
			Thread.sleep(5000);
		    //Check Whether the Net Sale Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='Net sale']")).getText().equalsIgnoreCase("Net sale"))
		    {
		    	test.log(LogStatus.PASS, "Net sale field is available");
		    	
		    	test.log(LogStatus.INFO, "Void amount from total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[1]")).getText());
		    	
		    	test.log(LogStatus.INFO, "Total Net Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Net sale field is not available");
		    }
		    
	
		    //Check Whether the Tax Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]")).getText().equalsIgnoreCase("Tax"))
		    {
		    	test.log(LogStatus.PASS, "Tax field is available");
		    	
		    	test.log(LogStatus.INFO, "Void tax amount from total tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Tax amount is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Tax field is not available");
		    }
		    
	
		    //Check Whether the Transactions Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]")).getText().equalsIgnoreCase("Transactions"))
		    {
		    	test.log(LogStatus.PASS, "Transactions field is available");
		    	
		    	test.log(LogStatus.INFO, "Number of Void transaction from total transaction is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[1]")).getText());
	
		    	test.log(LogStatus.INFO, "Total Transaction is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Transactions field is not available");
		    }
		    
	
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[1]")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    	test.log(LogStatus.INFO, "Total number of customer(s) is/are : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
	
		    //Check Whether the Discount Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[1]")).getText().equalsIgnoreCase("Discount"))
		    {
		    	test.log(LogStatus.PASS, "Discount field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Discount amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Discount field is not available");
		    }
		    
	
		    //Check Whether the Refunds Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[1]")).getText().equalsIgnoreCase("Refunds"))
		    {
		    	test.log(LogStatus.PASS, "Refunds field is available");
		    	
		    	test.log(LogStatus.INFO, "Total Refund amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[6]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Refunds field is not available");
		    }
		    
	
		    //Check Whether the Labour Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[1]")).getText().equalsIgnoreCase("Labour"))
		    {
		    	test.log(LogStatus.PASS, "Labour field is available");
		    	
		    	test.log(LogStatus.INFO, "Labour Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[7]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour field is not available");
		    }
		    
	
		    //Check Whether the COGS Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[1]")).getText().equalsIgnoreCase("COGS"))
		    {
		    	test.log(LogStatus.PASS, "COGS field is available");
		    	
		    	test.log(LogStatus.INFO, "Cost Of Goods Sold percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[8]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "COGS field is not available");
		    }
		    
	
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[1]")).getText().equalsIgnoreCase("SPLH"))
		    {
		    	test.log(LogStatus.PASS, "SPLH field is available");
		    	
		    	test.log(LogStatus.INFO, "Sales Per Labour Hour is "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[9]/div/div[2]/div[2]/span")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SPLH field is not available");
		    }
		    
	
		    
		    //Check Whether the NET SALES BY HOUR Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='NET SALES BY HOUR']")).getText().equalsIgnoreCase("NET SALES BY HOUR"))
		    {
		    	test.log(LogStatus.PASS, "NET SALES BY HOUR field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "NET SALES BY HOUR field is not available");
		    }
		    
	
		    //Check Whether the SALE PER ORDER TYPE Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE PER ORDER TYPE']")).getText().equalsIgnoreCase("SALE PER ORDER TYPE"))
		    {
		    	test.log(LogStatus.PASS, "SALE PER ORDER TYPE field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE PER ORDER TYPE field is not available");
		    }
		    
	
		    //Check Whether the SPLH Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[.='SALE BY TENDER']")).getText().equalsIgnoreCase("SALE BY TENDER"))
		    {
		    	test.log(LogStatus.PASS, "SALE BY TENDER field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "SALE BY TENDER field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Date Range Sale Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=14)
		public void refreshTheDashBoard_Customer() throws InterruptedException
		{
			Thread.sleep(3000);
			//Click the Customer dashboard option
			driver.findElement(By.id("customerDashboard")).click();
	
			
			//Check weather the Customers dashboard page is opened or not
			if(driver.findElement(By.xpath("//a[.='Customer Dashboard']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Customer Dashboard page opened successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Customer Dashboard page opened Fail");
			}
			
			Thread.sleep(5000);
			//Click the Refresh button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[3]")).click();
	
			//Check whether the dashboard page refreshed or not
			if(driver.findElement(By.xpath("//a[.='Customer Dashboard']")).getText().equalsIgnoreCase("Customer Dashboard"))
			{
				test.log(LogStatus.PASS, "Customer Dashboard refreshed Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Customer Dashboard refreshed Failed");
			}
			Thread.sleep(5000);
		}
	
		@Parameters({"driver"})@Test(priority=15)
		public void viewDashboardElementsForToday_Customer() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Today button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[1]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Customer Reports for Today *****");
			
			Thread.sleep(5000);
		    //Check Whether the TOTAL ENROLLMENTS Available in Dashboard or not 
		    if(driver.getPageSource().contains("TOTAL ENROLLMENTS"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL ENROLLMENTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Total Enrollments are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL ENROLLMENTS field is not available");
		    }
		    
		    //Check Whether the REWARD POINTS Available in Dashboard or not driver.getPageSource().contains("REWARD POINTS")
		    if(driver.getPageSource().contains("REWARD POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REWARD POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Reward Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REWARD POINTS field is not available");
		    }
		    
		    //Check Whether the VALUE POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("VALUE POINTS"))
		    {
		    	test.log(LogStatus.PASS, "VALUE POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Value Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "VALUE POINTS field is not available");
		    }
		    
		    //Check Whether the ACCUMULATION POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("ACCUMULATION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "ACCUMULATION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Accumulation Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "ACCUMULATION POINTS field is not available");
		    }
		    
		    //Check Whether the Redemption Points Available in Dashboard or not
		    if(driver.getPageSource().contains("REDEMPTION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REDEMPTION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Redemption Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REDEMPTION POINTS field is not available");
		    }
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Top 5 Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Top 5 Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Customers field is not available");
		    }
		    
		    //Check Whether the Top 5 Returning Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//span[.='Top 5 Returning Customers']")).getText().equalsIgnoreCase("Top 5 Returning Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Returning Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Returning Customers field is not available");
		    }
	
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Sale(Feedback) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[3]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Feedback Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[4]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Positive Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/h5/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Negative Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[2]/h5/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
		    	    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Todays Customer Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=16)
		public void viewDashboardElementsForYesterday_Customer() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Yesterday button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[2]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Customer Reports for Yesterday *****");
			
			Thread.sleep(5000);
		    //Check Whether the TOTAL ENROLLMENTS Available in Dashboard or not
		    if(driver.getPageSource().contains("TOTAL ENROLLMENTS"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL ENROLLMENTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Total Enrollments are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL ENROLLMENTS field is not available");
		    }
		    
		    //Check Whether the REWARD POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("REWARD POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REWARD POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Reward Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REWARD POINTS field is not available");
		    }
		    
		    //Check Whether the VALUE POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("VALUE POINTS"))
		    {
		    	test.log(LogStatus.PASS, "VALUE POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Value Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "VALUE POINTS field is not available");
		    }
		    
		    //Check Whether the ACCUMULATION POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("ACCUMULATION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "ACCUMULATION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Accumulation Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "ACCUMULATION POINTS field is not available");
		    }
		    
		    //Check Whether the Redemption Points Available in Dashboard or not
		    if(driver.getPageSource().contains("REDEMPTION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REDEMPTION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Redemption Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REDEMPTION POINTS field is not available");
		    }
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Top 5 Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Top 5 Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Customers field is not available");
		    }
		    
		    //Check Whether the Top 5 Returning Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//span[.='Top 5 Returning Customers']")).getText().equalsIgnoreCase("Top 5 Returning Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Returning Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Returning Customers field is not available");
		    }
	
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Sale(Feedback) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[3]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Feedback Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[4]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Positive Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/h5/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Negative Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[2]/h5/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
	    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Yesterdays Customer Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=17)
		public void viewDashboardElementsForLastNday_Customer() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Today button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[3]/a")).click();
			//Enter the required day
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[3]/div/div/div/input")).sendKeys("100");
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Customer Reports for Last N day *****");
			
			Thread.sleep(5000);
		    //Check Whether the TOTAL ENROLLMENTS Available in Dashboard or not
		    if(driver.getPageSource().contains("TOTAL ENROLLMENTS"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL ENROLLMENTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Total Enrollments are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL ENROLLMENTS field is not available");
		    }
		    
		    //Check Whether the REWARD POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("REWARD POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REWARD POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Reward Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REWARD POINTS field is not available");
		    }
		    
		    //Check Whether the VALUE POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("VALUE POINTS"))
		    {
		    	test.log(LogStatus.PASS, "VALUE POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Value Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "VALUE POINTS field is not available");
		    }
		    
		    //Check Whether the ACCUMULATION POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("ACCUMULATION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "ACCUMULATION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Accumulation Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "ACCUMULATION POINTS field is not available");
		    }
		    
		    //Check Whether the Redemption Points Available in Dashboard or not
		    if(driver.getPageSource().contains("REDEMPTION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REDEMPTION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Redemption Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REDEMPTION POINTS field is not available");
		    }
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Top 5 Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Top 5 Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Customers field is not available");
		    }
		    
		    //Check Whether the Top 5 Returning Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//span[.='Top 5 Returning Customers']")).getText().equalsIgnoreCase("Top 5 Returning Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Returning Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Returning Customers field is not available");
		    }
	
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Sale(Feedback) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[3]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Feedback Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[4]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Positive Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/h5/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Negative Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[2]/h5/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
	    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Last N Days Customer Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=18)
		public void viewDashboardElementsForThisWeek_Customer() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the This Week option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[4]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Customer Reports for This Week *****");
			
			Thread.sleep(5000);
		    //Check Whether the TOTAL ENROLLMENTS Available in Dashboard or not
		    if(driver.getPageSource().contains("TOTAL ENROLLMENTS"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL ENROLLMENTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Total Enrollments are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL ENROLLMENTS field is not available");
		    }
		    
		    //Check Whether the REWARD POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("REWARD POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REWARD POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Reward Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REWARD POINTS field is not available");
		    }
		    
		    //Check Whether the VALUE POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("VALUE POINTS"))
		    {
		    	test.log(LogStatus.PASS, "VALUE POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Value Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "VALUE POINTS field is not available");
		    }
		    
		    //Check Whether the ACCUMULATION POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("ACCUMULATION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "ACCUMULATION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Accumulation Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "ACCUMULATION POINTS field is not available");
		    }
		    
		    //Check Whether the Redemption Points Available in Dashboard or not
		    if(driver.getPageSource().contains("REDEMPTION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REDEMPTION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Redemption Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REDEMPTION POINTS field is not available");
		    }
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Top 5 Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Top 5 Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Customers field is not available");
		    }
		    
		    //Check Whether the Top 5 Returning Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//span[.='Top 5 Returning Customers']")).getText().equalsIgnoreCase("Top 5 Returning Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Returning Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Returning Customers field is not available");
		    }
	
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Sale(Feedback) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[3]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Feedback Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[4]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Positive Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/h5/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Negative Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[2]/h5/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
	   	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of This Week Customer Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=19)
		public void viewDashboardElementsForLastWeek_Customer() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Last Week option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[5]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Customer Reports for Last Week *****");
			
			Thread.sleep(5000);
		    //Check Whether the TOTAL ENROLLMENTS Available in Dashboard or not
		    if(driver.getPageSource().contains("TOTAL ENROLLMENTS"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL ENROLLMENTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Total Enrollments are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL ENROLLMENTS field is not available");
		    }
		    
		    //Check Whether the REWARD POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("REWARD POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REWARD POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Reward Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REWARD POINTS field is not available");
		    }
		    
		    //Check Whether the VALUE POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("VALUE POINTS"))
		    {
		    	test.log(LogStatus.PASS, "VALUE POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Value Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "VALUE POINTS field is not available");
		    }
		    
		    //Check Whether the ACCUMULATION POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("ACCUMULATION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "ACCUMULATION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Accumulation Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "ACCUMULATION POINTS field is not available");
		    }
		    
		    //Check Whether the Redemption Points Available in Dashboard or not
		    if(driver.getPageSource().contains("REDEMPTION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REDEMPTION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Redemption Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REDEMPTION POINTS field is not available");
		    }
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Top 5 Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Top 5 Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Customers field is not available");
		    }
		    
		    //Check Whether the Top 5 Returning Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//span[.='Top 5 Returning Customers']")).getText().equalsIgnoreCase("Top 5 Returning Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Returning Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Returning Customers field is not available");
		    }
	
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Sale(Feedback) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[3]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Feedback Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[4]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Positive Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/h5/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Negative Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[2]/h5/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
	    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Last Week Customer Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=20)
		public void viewDashboardElementsForLast7Days_Customer() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Last 7 Days option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[6]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Customer Reports for Last 7 Days  *****");
		
			
			Thread.sleep(5000);
		    //Check Whether the TOTAL ENROLLMENTS Available in Dashboard or not
		    if(driver.getPageSource().contains("TOTAL ENROLLMENTS"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL ENROLLMENTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Total Enrollments are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL ENROLLMENTS field is not available");
		    }
		    
		    //Check Whether the REWARD POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("REWARD POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REWARD POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Reward Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REWARD POINTS field is not available");
		    }
		    
		    //Check Whether the VALUE POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("VALUE POINTS"))
		    {
		    	test.log(LogStatus.PASS, "VALUE POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Value Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "VALUE POINTS field is not available");
		    }
		    
		    //Check Whether the ACCUMULATION POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("ACCUMULATION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "ACCUMULATION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Accumulation Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "ACCUMULATION POINTS field is not available");
		    }
		    
		    //Check Whether the Redemption Points Available in Dashboard or not
		    if(driver.getPageSource().contains("REDEMPTION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REDEMPTION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Redemption Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REDEMPTION POINTS field is not available");
		    }
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Top 5 Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Top 5 Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Customers field is not available");
		    }
		    
		    //Check Whether the Top 5 Returning Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//span[.='Top 5 Returning Customers']")).getText().equalsIgnoreCase("Top 5 Returning Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Returning Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Returning Customers field is not available");
		    }
	
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Sale(Feedback) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[3]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Feedback Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[4]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Positive Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/h5/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Negative Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[2]/h5/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Last 7 Days Customer Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=21)
		public void viewDashboardElementsForThisMonth_Customer() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the This Month option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[7]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Customer Reports for This Month  *****");
		
			
			Thread.sleep(5000);
		    //Check Whether the TOTAL ENROLLMENTS Available in Dashboard or not
		    if(driver.getPageSource().contains("TOTAL ENROLLMENTS"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL ENROLLMENTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Total Enrollments are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL ENROLLMENTS field is not available");
		    }
		    
		    //Check Whether the REWARD POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("REWARD POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REWARD POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Reward Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REWARD POINTS field is not available");
		    }
		    
		    //Check Whether the VALUE POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("VALUE POINTS"))
		    {
		    	test.log(LogStatus.PASS, "VALUE POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Value Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "VALUE POINTS field is not available");
		    }
		    
		    //Check Whether the ACCUMULATION POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("ACCUMULATION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "ACCUMULATION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Accumulation Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "ACCUMULATION POINTS field is not available");
		    }
		    
		    //Check Whether the Redemption Points Available in Dashboard or not
		    if(driver.getPageSource().contains("REDEMPTION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REDEMPTION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Redemption Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REDEMPTION POINTS field is not available");
		    }
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Top 5 Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Top 5 Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Customers field is not available");
		    }
		    
		    //Check Whether the Top 5 Returning Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//span[.='Top 5 Returning Customers']")).getText().equalsIgnoreCase("Top 5 Returning Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Returning Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Returning Customers field is not available");
		    }
	
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Sale(Feedback) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[3]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Feedback Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[4]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Positive Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/h5/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Negative Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[2]/h5/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of This Month Customer Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=22)
		public void viewDashboardElementsForLastMonth_Customer() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Last Month option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[8]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Customer Reports for Last Month  *****");
		
			
			Thread.sleep(5000);
		    //Check Whether the TOTAL ENROLLMENTS Available in Dashboard or not
		    if(driver.getPageSource().contains("TOTAL ENROLLMENTS"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL ENROLLMENTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Total Enrollments are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL ENROLLMENTS field is not available");
		    }
		    
		    //Check Whether the REWARD POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("REWARD POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REWARD POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Reward Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REWARD POINTS field is not available");
		    }
		    
		    //Check Whether the VALUE POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("VALUE POINTS"))
		    {
		    	test.log(LogStatus.PASS, "VALUE POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Value Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "VALUE POINTS field is not available");
		    }
		    
		    //Check Whether the ACCUMULATION POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("ACCUMULATION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "ACCUMULATION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Accumulation Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "ACCUMULATION POINTS field is not available");
		    }
		    
		    //Check Whether the Redemption Points Available in Dashboard or not
		    if(driver.getPageSource().contains("REDEMPTION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REDEMPTION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Redemption Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REDEMPTION POINTS field is not available");
		    }
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Top 5 Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Top 5 Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Customers field is not available");
		    }
		    
		    //Check Whether the Top 5 Returning Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//span[.='Top 5 Returning Customers']")).getText().equalsIgnoreCase("Top 5 Returning Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Returning Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Returning Customers field is not available");
		    }
	
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Sale(Feedback) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[3]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Feedback Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[4]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Positive Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/h5/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Negative Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[2]/h5/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
	   	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Last Month Customer Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=23)
		public void viewDashboardElementsForLast30Days_Customer() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Last 30 Days option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[9]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Customer Reports for Last 30 Days  *****");
		
			
			Thread.sleep(5000);
		    //Check Whether the TOTAL ENROLLMENTS Available in Dashboard or not
		    if(driver.getPageSource().contains("TOTAL ENROLLMENTS"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL ENROLLMENTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Total Enrollments are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL ENROLLMENTS field is not available");
		    }
		    
		    //Check Whether the REWARD POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("REWARD POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REWARD POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Reward Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REWARD POINTS field is not available");
		    }
		    
		    //Check Whether the VALUE POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("VALUE POINTS"))
		    {
		    	test.log(LogStatus.PASS, "VALUE POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Value Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "VALUE POINTS field is not available");
		    }
		    
		    //Check Whether the ACCUMULATION POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("ACCUMULATION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "ACCUMULATION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Accumulation Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "ACCUMULATION POINTS field is not available");
		    }
		    
		    //Check Whether the Redemption Points Available in Dashboard or not
		    if(driver.getPageSource().contains("REDEMPTION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REDEMPTION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Redemption Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REDEMPTION POINTS field is not available");
		    }
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Top 5 Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Top 5 Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Customers field is not available");
		    }
		    
		    //Check Whether the Top 5 Returning Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//span[.='Top 5 Returning Customers']")).getText().equalsIgnoreCase("Top 5 Returning Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Returning Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Returning Customers field is not available");
		    }
	
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Sale(Feedback) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[3]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Feedback Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[4]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Positive Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/h5/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Negative Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[2]/h5/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
	 	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Last 30 Days Customer Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=24)
		public void viewDashboardElementsForSpecificDate_Customer() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Specific Date option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[10]/a")).click();
			//Enter the specific Date
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[10]/div/div/div/div/input")).sendKeys("30-Apr-2018");
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Customer Reports for Specific Date  *****");
		
			Thread.sleep(5000);
		    //Check Whether the TOTAL ENROLLMENTS Available in Dashboard or not
		    if(driver.getPageSource().contains("TOTAL ENROLLMENTS"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL ENROLLMENTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Total Enrollments are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL ENROLLMENTS field is not available");
		    }
		    
		    //Check Whether the REWARD POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("REWARD POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REWARD POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Reward Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REWARD POINTS field is not available");
		    }
		    
		    //Check Whether the VALUE POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("VALUE POINTS"))
		    {
		    	test.log(LogStatus.PASS, "VALUE POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Value Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "VALUE POINTS field is not available");
		    }
		    
		    //Check Whether the ACCUMULATION POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("ACCUMULATION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "ACCUMULATION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Accumulation Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "ACCUMULATION POINTS field is not available");
		    }
		    
		    //Check Whether the Redemption Points Available in Dashboard or not
		    if(driver.getPageSource().contains("REDEMPTION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REDEMPTION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Redemption Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REDEMPTION POINTS field is not available");
		    }
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Top 5 Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Top 5 Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Customers field is not available");
		    }
		    
		    //Check Whether the Top 5 Returning Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//span[.='Top 5 Returning Customers']")).getText().equalsIgnoreCase("Top 5 Returning Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Returning Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Returning Customers field is not available");
		    }
	
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Sale(Feedback) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[3]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Feedback Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[4]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Positive Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/h5/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Negative Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[2]/h5/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
	    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Specific Date Customer Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=25)
		public void viewDashboardElementsForDateRange_Customer() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Specific Date option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[11]/a")).click();
			//Clear the start date field
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[11]/div/div/div/div/input[1]")).clear();
			//Enter the start Date
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[11]/div/div/div/div/input[1]")).sendKeys("30-Apr-2018");
			Thread.sleep(3000);
			//Clear the End Date
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[11]/div/div/div/div/input[2]")).clear();
			//Enter the End Date
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[11]/div/div/div/div/input[2]")).sendKeys("20-Jun-2018");
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Customer Reports for Date Range Sale  *****");
		
			
			Thread.sleep(5000);
		    //Check Whether the TOTAL ENROLLMENTS Available in Dashboard or not
		    if(driver.getPageSource().contains("TOTAL ENROLLMENTS"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL ENROLLMENTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Total Enrollments are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL ENROLLMENTS field is not available");
		    }
		    
		    //Check Whether the REWARD POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("REWARD POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REWARD POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Reward Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REWARD POINTS field is not available");
		    }
		    
		    //Check Whether the VALUE POINTS Available in Dashboard or not 
		    if(driver.getPageSource().contains("VALUE POINTS"))
		    {
		    	test.log(LogStatus.PASS, "VALUE POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Value Points are/is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "VALUE POINTS field is not available");
		    }
		    
		    //Check Whether the ACCUMULATION POINTS Available in Dashboard or not
		    if(driver.getPageSource().contains("ACCUMULATION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "ACCUMULATION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Accumulation Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "ACCUMULATION POINTS field is not available");
		    }
		    
		    //Check Whether the Redemption Points Available in Dashboard or not
		    if(driver.getPageSource().contains("REDEMPTION POINTS"))
		    {
		    	test.log(LogStatus.PASS, "REDEMPTION POINTS field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Redemption Points is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "REDEMPTION POINTS field is not available");
		    }
		    
		    //Check Whether the Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customers"))
		    {
		    	test.log(LogStatus.PASS, "Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customers field is not available");
		    }
		    
		    
		    //Check Whether the Top 5 Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Top 5 Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Customers field is not available");
		    }
		    
		    //Check Whether the Top 5 Returning Customers Available in Dashboard or not
		    if(driver.findElement(By.xpath("//span[.='Top 5 Returning Customers']")).getText().equalsIgnoreCase("Top 5 Returning Customers"))
		    {
		    	test.log(LogStatus.PASS, "Top 5 Returning Customers field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Top 5 Returning Customers field is not available");
		    }
	
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
		    	
		    	test.log(LogStatus.INFO, "Customer - Sale(Feedback) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[3]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Feedback Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[4]/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Positive Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/h5/span")).getText());
	
		    	test.log(LogStatus.INFO, "Customer - Negative Feedback Count(Percentage) is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[2]/h5/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    
		    //Check Whether the Customer Feedback Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Feedback"))
		    {
		    	test.log(LogStatus.PASS, "Customer Feedback field is available");
	 	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Feedback field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Date Range Customer Report *****");
			
			Thread.sleep(5000);
		}
		
		@Parameters({"driver"})@Test(priority=26)
		public void refreshTheDashBoard_Employee() throws InterruptedException
		{
			Thread.sleep(3000);
			//Click the Customer dashboard option
			driver.findElement(By.id("employeeDashboard")).click();
	
			
			//Check weather the Customers dashboard page is opened or not
			if(driver.findElement(By.xpath("//a[.='Employee Dashboard']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Employee Dashboard page opened successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Employee Dashboard page opened Fail");
			}
			Thread.sleep(5000);
			//Click the Refresh button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[3]")).click();
	
			//Check whether the dashboard page refreshed or not
			if(driver.findElement(By.xpath("//a[.='Employee Dashboard']")).getText().equalsIgnoreCase("Employee Dashboard"))
			{
				test.log(LogStatus.PASS, "Employee Dashboard refreshed Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Employee Dashboard refreshed Failed");
			}
	
		}
	
		@Parameters({"driver"})@Test(priority=27)
		public void viewDashboardElementsForToday_Employee() throws Exception
	
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Today button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[1]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Employee Reports for Today *****");
			
			Thread.sleep(8000);
		    //Check Whether the TOTAL SALES Available in Dashboard or not
		    if(driver.getPageSource().contains("Total Sales"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL SALES field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Total Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL SALES field is not available");
		    }
		    
		    //Check Whether the Labour Cost Available in Dashboard or not
		    if(driver.getPageSource().contains("Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Labour Cost field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Labour Cost is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour Cost field is not available");
		    }
		    
		    //Check Whether the Average Amount Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Amount Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Amount Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Amount Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Amount Per Check field is not available");
		    }
		    
		    //Check Whether the Average Time Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Time Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Time Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Time Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Time Per Check field is not available");
		    }
		    
		    //Check Whether the Avg Check Vs Employee Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Avg Check Vs Employee"))
		    {
		    	test.log(LogStatus.PASS, "Avg Check Vs Employee field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Avg Check Vs Employee field is not available");
		    }
		    
		    //Check Whether the Sales Vs Labour Cost Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Sales Vs Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Sales Vs Labour Cost field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Sales Vs Labour Cost field is not available");
		    }
		    
		    
		    //Check Whether the Employee Vs Tip Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Tip"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Tip field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Tip field is not available");
		    }
		    
		    //Check Whether the Employee Vs Net Sales Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Net Sales"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Net Sales field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Net Sales field is not available");
		    }
	
		    //Check Whether the Customer Retention Ration Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Retention Ration"))
		    {
		    	test.log(LogStatus.PASS, "Customer Retention Ration field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Retention Ration field is not available");
		    }
		    
		    //Check Whether the Open To Close Check Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Open To Close Check"))
		    {
		    	test.log(LogStatus.PASS, "Open To Close Check field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Open To Close Check field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Todays Employee Report *****");
			
			Thread.sleep(5000);
		}
			
		@Parameters({"driver"})@Test(priority=28)
		public void viewDashboardElementsForYesterday_Employee() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Yesterday button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[2]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Employee Reports for Yesterday *****");
			
			Thread.sleep(8000);
		    //Check Whether the TOTAL SALES Available in Dashboard or not
		    if(driver.getPageSource().contains("Total Sales"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL SALES field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Total Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL SALES field is not available");
		    }
		    
		    //Check Whether the Labour Cost Available in Dashboard or not
		    if(driver.getPageSource().contains("Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Labour Cost field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Labour Cost is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour Cost field is not available");
		    }
		    
		    //Check Whether the Average Amount Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Amount Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Amount Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Amount Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Amount Per Check field is not available");
		    }
		    
		    //Check Whether the Average Time Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Time Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Time Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Time Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Time Per Check field is not available");
		    }
		    
		    //Check Whether the Avg Check Vs Employee Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Avg Check Vs Employee"))
		    {
		    	test.log(LogStatus.PASS, "Avg Check Vs Employee field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Avg Check Vs Employee field is not available");
		    }
		    
		    //Check Whether the Sales Vs Labour Cost Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Sales Vs Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Sales Vs Labour Cost field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Sales Vs Labour Cost field is not available");
		    }
		    
		    
		    //Check Whether the Employee Vs Tip Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Tip"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Tip field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Tip field is not available");
		    }
		    
		    //Check Whether the Employee Vs Net Sales Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Net Sales"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Net Sales field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Net Sales field is not available");
		    }
	
		    //Check Whether the Customer Retention Ration Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Retention Ration"))
		    {
		    	test.log(LogStatus.PASS, "Customer Retention Ration field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Retention Ration field is not available");
		    }
		    
		    //Check Whether the Open To Close Check Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Open To Close Check"))
		    {
		    	test.log(LogStatus.PASS, "Open To Close Check field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Open To Close Check field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Yesterdays Employee Report *****");
			
			Thread.sleep(5000);
		}
			
		@Parameters({"driver"})@Test(priority=29)
		public void viewDashboardElementsForLastNday_Employee() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Today button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[3]/a")).click();
			//Enter the required day
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[3]/div/div/div/input")).sendKeys("100");
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Employee Reports for Last N day *****");
			
			Thread.sleep(8000);
		    //Check Whether the TOTAL SALES Available in Dashboard or not
		    if(driver.getPageSource().contains("Total Sales"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL SALES field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Total Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL SALES field is not available");
		    }
		    
		    //Check Whether the Labour Cost Available in Dashboard or not
		    if(driver.getPageSource().contains("Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Labour Cost field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Labour Cost is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour Cost field is not available");
		    }
		    
		    //Check Whether the Average Amount Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Amount Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Amount Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Amount Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Amount Per Check field is not available");
		    }
		    
		    //Check Whether the Average Time Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Time Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Time Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Time Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Time Per Check field is not available");
		    }
		    
		    //Check Whether the Avg Check Vs Employee Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Avg Check Vs Employee"))
		    {
		    	test.log(LogStatus.PASS, "Avg Check Vs Employee field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Avg Check Vs Employee field is not available");
		    }
		    
		    //Check Whether the Sales Vs Labour Cost Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Sales Vs Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Sales Vs Labour Cost field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Sales Vs Labour Cost field is not available");
		    }
		    
		    
		    //Check Whether the Employee Vs Tip Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Tip"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Tip field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Tip field is not available");
		    }
		    
		    //Check Whether the Employee Vs Net Sales Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Net Sales"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Net Sales field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Net Sales field is not available");
		    }
	
		    //Check Whether the Customer Retention Ration Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Retention Ration"))
		    {
		    	test.log(LogStatus.PASS, "Customer Retention Ration field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Retention Ration field is not available");
		    }
		    
		    //Check Whether the Open To Close Check Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Open To Close Check"))
		    {
		    	test.log(LogStatus.PASS, "Open To Close Check field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Open To Close Check field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Last N Days Employee Report *****");
			
			Thread.sleep(5000);
		}
			
		@Parameters({"driver"})@Test(priority=30)
		public void viewDashboardElementsForThisWeek_Employee() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the This Week option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[4]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Employee Reports for This Week *****");
			
			Thread.sleep(8000);
		    //Check Whether the TOTAL SALES Available in Dashboard or not
		    if(driver.getPageSource().contains("Total Sales"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL SALES field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Total Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL SALES field is not available");
		    }
		    
		    //Check Whether the Labour Cost Available in Dashboard or not
		    if(driver.getPageSource().contains("Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Labour Cost field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Labour Cost is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour Cost field is not available");
		    }
		    
		    //Check Whether the Average Amount Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Amount Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Amount Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Amount Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Amount Per Check field is not available");
		    }
		    
		    //Check Whether the Average Time Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Time Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Time Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Time Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Time Per Check field is not available");
		    }
		    
		    //Check Whether the Avg Check Vs Employee Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Avg Check Vs Employee"))
		    {
		    	test.log(LogStatus.PASS, "Avg Check Vs Employee field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Avg Check Vs Employee field is not available");
		    }
		    
		    //Check Whether the Sales Vs Labour Cost Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Sales Vs Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Sales Vs Labour Cost field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Sales Vs Labour Cost field is not available");
		    }
		    
		    
		    //Check Whether the Employee Vs Tip Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Tip"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Tip field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Tip field is not available");
		    }
		    
		    //Check Whether the Employee Vs Net Sales Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Net Sales"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Net Sales field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Net Sales field is not available");
		    }
	
		    //Check Whether the Customer Retention Ration Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Retention Ration"))
		    {
		    	test.log(LogStatus.PASS, "Customer Retention Ration field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Retention Ration field is not available");
		    }
		    
		    //Check Whether the Open To Close Check Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Open To Close Check"))
		    {
		    	test.log(LogStatus.PASS, "Open To Close Check field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Open To Close Check field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of This Week Employee Report *****");
			
			Thread.sleep(5000);
		}
		
			
		@Parameters({"driver"})@Test(priority=31)
		public void viewDashboardElementsForLastWeek_Employee() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Last Week option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[5]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Employee Reports for Last Week *****");
			
			Thread.sleep(8000);
		    //Check Whether the TOTAL SALES Available in Dashboard or not
		    if(driver.getPageSource().contains("Total Sales"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL SALES field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Total Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL SALES field is not available");
		    }
		    
		    //Check Whether the Labour Cost Available in Dashboard or not
		    if(driver.getPageSource().contains("Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Labour Cost field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Labour Cost is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour Cost field is not available");
		    }
		    
		    //Check Whether the Average Amount Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Amount Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Amount Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Amount Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Amount Per Check field is not available");
		    }
		    
		    //Check Whether the Average Time Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Time Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Time Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Time Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Time Per Check field is not available");
		    }
		    
		    //Check Whether the Avg Check Vs Employee Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Avg Check Vs Employee"))
		    {
		    	test.log(LogStatus.PASS, "Avg Check Vs Employee field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Avg Check Vs Employee field is not available");
		    }
		    
		    //Check Whether the Sales Vs Labour Cost Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Sales Vs Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Sales Vs Labour Cost field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Sales Vs Labour Cost field is not available");
		    }
		    
		    
		    //Check Whether the Employee Vs Tip Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Tip"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Tip field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Tip field is not available");
		    }
		    
		    //Check Whether the Employee Vs Net Sales Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Net Sales"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Net Sales field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Net Sales field is not available");
		    }
	
		    //Check Whether the Customer Retention Ration Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Retention Ration"))
		    {
		    	test.log(LogStatus.PASS, "Customer Retention Ration field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Retention Ration field is not available");
		    }
		    
		    //Check Whether the Open To Close Check Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Open To Close Check"))
		    {
		    	test.log(LogStatus.PASS, "Open To Close Check field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Open To Close Check field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Last Week Employee Report *****");
			
			Thread.sleep(5000);
		}
		
			
		@Parameters({"driver"})@Test(priority=32)
		public void viewDashboardElementsForLast7Days_Employee() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Last 7 Days option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[6]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Employee Reports for Last 7 Days  *****");
		
			
			Thread.sleep(8000);
		    //Check Whether the TOTAL SALES Available in Dashboard or not
		    if(driver.getPageSource().contains("Total Sales"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL SALES field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Total Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL SALES field is not available");
		    }
		    
		    //Check Whether the Labour Cost Available in Dashboard or not
		    if(driver.getPageSource().contains("Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Labour Cost field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Labour Cost is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour Cost field is not available");
		    }
		    
		    //Check Whether the Average Amount Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Amount Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Amount Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Amount Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Amount Per Check field is not available");
		    }
		    
		    //Check Whether the Average Time Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Time Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Time Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Time Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Time Per Check field is not available");
		    }
		    
		    //Check Whether the Avg Check Vs Employee Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Avg Check Vs Employee"))
		    {
		    	test.log(LogStatus.PASS, "Avg Check Vs Employee field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Avg Check Vs Employee field is not available");
		    }
		    
		    //Check Whether the Sales Vs Labour Cost Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Sales Vs Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Sales Vs Labour Cost field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Sales Vs Labour Cost field is not available");
		    }
		    
		    
		    //Check Whether the Employee Vs Tip Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Tip"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Tip field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Tip field is not available");
		    }
		    
		    //Check Whether the Employee Vs Net Sales Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Net Sales"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Net Sales field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Net Sales field is not available");
		    }
	
		    //Check Whether the Customer Retention Ration Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Retention Ration"))
		    {
		    	test.log(LogStatus.PASS, "Customer Retention Ration field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Retention Ration field is not available");
		    }
		    
		    //Check Whether the Open To Close Check Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Open To Close Check"))
		    {
		    	test.log(LogStatus.PASS, "Open To Close Check field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Open To Close Check field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Last 7 Days Employee Report *****");
			
			Thread.sleep(5000);
		}
		
			
		@Parameters({"driver"})@Test(priority=33)
		public void viewDashboardElementsForThisMonth_Employee() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the This Month option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[7]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Employee Reports for This Month  *****");
		
			Thread.sleep(8000);
		    //Check Whether the TOTAL SALES Available in Dashboard or not
		    if(driver.getPageSource().contains("Total Sales"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL SALES field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Total Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL SALES field is not available");
		    }
		    
		    //Check Whether the Labour Cost Available in Dashboard or not
		    if(driver.getPageSource().contains("Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Labour Cost field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Labour Cost is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour Cost field is not available");
		    }
		    
		    //Check Whether the Average Amount Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Amount Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Amount Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Amount Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Amount Per Check field is not available");
		    }
		    
		    //Check Whether the Average Time Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Time Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Time Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Time Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Time Per Check field is not available");
		    }
		    
		    //Check Whether the Avg Check Vs Employee Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Avg Check Vs Employee"))
		    {
		    	test.log(LogStatus.PASS, "Avg Check Vs Employee field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Avg Check Vs Employee field is not available");
		    }
		    
		    //Check Whether the Sales Vs Labour Cost Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Sales Vs Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Sales Vs Labour Cost field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Sales Vs Labour Cost field is not available");
		    }
		    
		    
		    //Check Whether the Employee Vs Tip Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Tip"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Tip field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Tip field is not available");
		    }
		    
		    //Check Whether the Employee Vs Net Sales Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Net Sales"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Net Sales field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Net Sales field is not available");
		    }
	
		    //Check Whether the Customer Retention Ration Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Retention Ration"))
		    {
		    	test.log(LogStatus.PASS, "Customer Retention Ration field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Retention Ration field is not available");
		    }
		    
		    //Check Whether the Open To Close Check Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Open To Close Check"))
		    {
		    	test.log(LogStatus.PASS, "Open To Close Check field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Open To Close Check field is not available");
		    }
	
		    		
			test.log(LogStatus.INFO, "***** End of This Month Employee Report *****");
			
			Thread.sleep(5000);
		}
		
			
		@Parameters({"driver"})@Test(priority=34)
		public void viewDashboardElementsForLastMonth_Employee() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Last Month option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[8]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Employee Reports for Last Month  *****");
		
			Thread.sleep(8000);
		    //Check Whether the TOTAL SALES Available in Dashboard or not
		    if(driver.getPageSource().contains("Total Sales"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL SALES field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Total Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL SALES field is not available");
		    }
		    
		    //Check Whether the Labour Cost Available in Dashboard or not
		    if(driver.getPageSource().contains("Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Labour Cost field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Labour Cost is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour Cost field is not available");
		    }
		    
		    //Check Whether the Average Amount Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Amount Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Amount Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Amount Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Amount Per Check field is not available");
		    }
		    
		    //Check Whether the Average Time Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Time Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Time Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Time Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Time Per Check field is not available");
		    }
		    
		    //Check Whether the Avg Check Vs Employee Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Avg Check Vs Employee"))
		    {
		    	test.log(LogStatus.PASS, "Avg Check Vs Employee field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Avg Check Vs Employee field is not available");
		    }
		    
		    //Check Whether the Sales Vs Labour Cost Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Sales Vs Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Sales Vs Labour Cost field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Sales Vs Labour Cost field is not available");
		    }
		    
		    
		    //Check Whether the Employee Vs Tip Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Tip"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Tip field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Tip field is not available");
		    }
		    
		    //Check Whether the Employee Vs Net Sales Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Net Sales"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Net Sales field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Net Sales field is not available");
		    }
	
		    //Check Whether the Customer Retention Ration Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Retention Ration"))
		    {
		    	test.log(LogStatus.PASS, "Customer Retention Ration field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Retention Ration field is not available");
		    }
		    
		    //Check Whether the Open To Close Check Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Open To Close Check"))
		    {
		    	test.log(LogStatus.PASS, "Open To Close Check field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Open To Close Check field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Last Month Employee Report *****");
			
			Thread.sleep(5000);
		}
		
		
		@Parameters({"driver"})@Test(priority=35)
		public void viewDashboardElementsForLast30Days_Employee() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Last 30 Days option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[9]/a")).click();
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Employee Reports for Last 30 Days  *****");
		
			Thread.sleep(8000);
		    //Check Whether the TOTAL SALES Available in Dashboard or not
		    if(driver.getPageSource().contains("Total Sales"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL SALES field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Total Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL SALES field is not available");
		    }
		    
		    //Check Whether the Labour Cost Available in Dashboard or not
		    if(driver.getPageSource().contains("Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Labour Cost field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Labour Cost is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour Cost field is not available");
		    }
		    
		    //Check Whether the Average Amount Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Amount Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Amount Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Amount Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Amount Per Check field is not available");
		    }
		    
		    //Check Whether the Average Time Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Time Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Time Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Time Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Time Per Check field is not available");
		    }
		    
		    //Check Whether the Avg Check Vs Employee Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Avg Check Vs Employee"))
		    {
		    	test.log(LogStatus.PASS, "Avg Check Vs Employee field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Avg Check Vs Employee field is not available");
		    }
		    
		    //Check Whether the Sales Vs Labour Cost Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Sales Vs Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Sales Vs Labour Cost field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Sales Vs Labour Cost field is not available");
		    }
		    
		    
		    //Check Whether the Employee Vs Tip Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Tip"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Tip field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Tip field is not available");
		    }
		    
		    //Check Whether the Employee Vs Net Sales Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Net Sales"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Net Sales field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Net Sales field is not available");
		    }
	
		    //Check Whether the Customer Retention Ration Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Retention Ration"))
		    {
		    	test.log(LogStatus.PASS, "Customer Retention Ration field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Retention Ration field is not available");
		    }
		    
		    //Check Whether the Open To Close Check Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Open To Close Check"))
		    {
		    	test.log(LogStatus.PASS, "Open To Close Check field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Open To Close Check field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Last 30 Days Employee Report *****");
			
			Thread.sleep(5000);
		}
		
		
		@Parameters({"driver"})@Test(priority=36)
		public void viewDashboardElementsForSpecificDate_Employee() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Specific Date option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[10]/a")).click();
			//Enter the specific Date
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[10]/div/div/div/div/input")).sendKeys("30-Apr-2018");
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Employee Reports for Specific Date  *****");
		
			Thread.sleep(8000);
		    //Check Whether the TOTAL SALES Available in Dashboard or not
		    if(driver.getPageSource().contains("Total Sales"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL SALES field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Total Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL SALES field is not available");
		    }
		    
		    //Check Whether the Labour Cost Available in Dashboard or not
		    if(driver.getPageSource().contains("Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Labour Cost field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Labour Cost is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour Cost field is not available");
		    }
		    
		    //Check Whether the Average Amount Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Amount Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Amount Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Amount Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Amount Per Check field is not available");
		    }
		    
		    //Check Whether the Average Time Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Time Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Time Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Time Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Time Per Check field is not available");
		    }
		    
		    //Check Whether the Avg Check Vs Employee Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Avg Check Vs Employee"))
		    {
		    	test.log(LogStatus.PASS, "Avg Check Vs Employee field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Avg Check Vs Employee field is not available");
		    }
		    
		    //Check Whether the Sales Vs Labour Cost Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Sales Vs Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Sales Vs Labour Cost field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Sales Vs Labour Cost field is not available");
		    }
		    
		    
		    //Check Whether the Employee Vs Tip Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Tip"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Tip field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Tip field is not available");
		    }
		    
		    //Check Whether the Employee Vs Net Sales Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Net Sales"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Net Sales field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Net Sales field is not available");
		    }
	
		    //Check Whether the Customer Retention Ration Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Retention Ration"))
		    {
		    	test.log(LogStatus.PASS, "Customer Retention Ration field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Retention Ration field is not available");
		    }
		    
		    //Check Whether the Open To Close Check Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Open To Close Check"))
		    {
		    	test.log(LogStatus.PASS, "Open To Close Check field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Open To Close Check field is not available");
		    }
		    		
			test.log(LogStatus.INFO, "***** End of Specific Date Employee Report *****");
			
			Thread.sleep(5000);
		}
		
		
		@Parameters({"driver"})@Test(priority=37)
		public void viewDashboardElementsForDateRange_Employee() throws Exception
		{
			Thread.sleep(3000);
			//Click the Date button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[2]")).click();
			Thread.sleep(3000);
			//Click the Specific Date option button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[11]/a")).click();
			//Clear the start date field
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[11]/div/div/div/div/input[1]")).clear();
			//Enter the start Date
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[11]/div/div/div/div/input[1]")).sendKeys("30-Apr-2018");
			Thread.sleep(3000);
			//Clear the End Date
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[11]/div/div/div/div/input[2]")).clear();
			//Enter the End Date
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[11]/div/div/div/div/input[2]")).sendKeys("20-Jun-2018");
			Thread.sleep(3000);
			//Click the apply button
			driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/ul/li[12]/div/button")).click();
			
			test.log(LogStatus.INFO, "***** The below Employee Reports for Date Range Sale  *****");
		
			Thread.sleep(8000);
		    //Check Whether the TOTAL SALES Available in Dashboard or not
		    if(driver.getPageSource().contains("Total Sales"))
		    {
		    	test.log(LogStatus.PASS, "TOTAL SALES field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Total Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "TOTAL SALES field is not available");
		    }
		    
		    //Check Whether the Labour Cost Available in Dashboard or not
		    if(driver.getPageSource().contains("Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Labour Cost field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Labour Cost is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/section[2]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Labour Cost field is not available");
		    }
		    
		    //Check Whether the Average Amount Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Amount Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Amount Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Amount Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Amount Per Check field is not available");
		    }
		    
		    //Check Whether the Average Time Per Check Available in Dashboard or not
		    if(driver.getPageSource().contains("Average Time Per Check"))
		    {
		    	test.log(LogStatus.PASS, "Average Time Per Check field is available");
		    	
		    	test.log(LogStatus.INFO, "Employees - Average Time Per Check is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/div/div[1]/span")).getText());
	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Average Time Per Check field is not available");
		    }
		    
		    //Check Whether the Avg Check Vs Employee Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Avg Check Vs Employee"))
		    {
		    	test.log(LogStatus.PASS, "Avg Check Vs Employee field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Avg Check Vs Employee field is not available");
		    }
		    
		    //Check Whether the Sales Vs Labour Cost Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Sales Vs Labour Cost"))
		    {
		    	test.log(LogStatus.PASS, "Sales Vs Labour Cost field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Sales Vs Labour Cost field is not available");
		    }
		    
		    
		    //Check Whether the Employee Vs Tip Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Tip"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Tip field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Tip field is not available");
		    }
		    
		    //Check Whether the Employee Vs Net Sales Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div[1]/span")).getText().equalsIgnoreCase("Employee Vs Net Sales"))
		    {
		    	test.log(LogStatus.PASS, "Employee Vs Net Sales field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Employee Vs Net Sales field is not available");
		    }
	
		    //Check Whether the Customer Retention Ration Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[1]/span")).getText().equalsIgnoreCase("Customer Retention Ration"))
		    {
		    	test.log(LogStatus.PASS, "Customer Retention Ration field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Customer Retention Ration field is not available");
		    }
		    
		    //Check Whether the Open To Close Check Available in Dashboard or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[3]/div/div[1]/span")).getText().equalsIgnoreCase("Open To Close Check"))
		    {
		    	test.log(LogStatus.PASS, "Open To Close Check field is available");
		    	
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Open To Close Check field is not available");
		    }
	
		    		
			test.log(LogStatus.INFO, "***** End of Date Range Employee Report *****");
			
			Thread.sleep(5000);
		}

}
