package epicList;

import java.util.List;
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

public class Inventory_Reports_COGS_Report {
	
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory_COGS_Report");

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

	@Test(priority=53)
	public void Inventory_Reports_COGS_Report_openpage() throws Exception
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
	public void Inventory_Reports_COGS_verify_All_report() throws Exception
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
	public void Inventory_Reports_COGS_Report_verify_MenuItem() throws Exception
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
	public void Inventory_Reports_COGS_Report_verify_Modifier() throws Exception
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

}
