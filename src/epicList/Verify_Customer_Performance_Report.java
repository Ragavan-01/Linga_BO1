package epicList;

import java.util.List;
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

public class Verify_Customer_Performance_Report {

	public WebDriver driver;

		ExtentReports rep = ExtentManager.getInstance();
		ExtentTest test = rep.startTest("Verify_Customer_Performance_Report");
		
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
		public void CustomerPerformance_Report_Method_viewpage() throws Exception
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
		public void CustomerPerformance_Report_Method_verify() throws Exception
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
		public void CustomerPerformance_Report_Method_WithoutCategorySubcategoryAdnServingSize() throws Exception
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
	
}
