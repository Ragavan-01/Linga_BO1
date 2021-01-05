package epicList_Integrated;

import java.text.DecimalFormat;
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

import epicList_Chrome.Utility;


public class Enterprise1 {

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise1");

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
	public void My_Enterprise_Report_open_(WebDriver driver) throws Exception
	{
		Thread.sleep(15000);
		
		//Enter the URL
		driver.get(Utility.getProperty("Enterprise_Base_URL")+"myEnterprise");
		
		Thread.sleep(5000);
		//Check My Enterprise Report page opened or not
		if(driver.findElement(By.xpath("//a[.='My Enterprise']")).getText().equalsIgnoreCase("My Enterprise"))
		{
			test.log(LogStatus.PASS, "My Enterprise report page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "My Enterprise report page loaded Failed");
		}
		
		Thread.sleep(3000);
		
	}
	
	@Test(priority=3)
	public void My_Enterprise_Report_Stores(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
/*		//Click the my Enterprise Report
		driver.findElement(By.id("myEnterprise")).click();
*/		
		Thread.sleep(3000);
		//Click the Specific date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[1]/ul/li[11]/a")).click();

		Thread.sleep(1000);
		//Clear the input option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[1]/ul/li[11]/div/div/div/div/input[1]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[1]/ul/li[11]/div/div/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

		Thread.sleep(1000);
		//Clear the input option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[1]/ul/li[11]/div/div/div/div/input[2]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[1]/ul/li[11]/div/div/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(3000);
		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/div/div/input")).sendKeys("Group");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/div/div/input")).sendKeys("Stores");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1500);
		//Click the Select Some Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Store"));
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		//Click the Apply Button
		driver.findElement(By.xpath("//button[.='Apply']")).click();
		
		
		Thread.sleep(2000);
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

		Thread.sleep(3000);
		System.out.println("********************* View The Store Report *************************");
		test.log(LogStatus.INFO, "********************* View The Store Report *************************");
		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/div/div/input")).sendKeys("Stores");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1500);
		//Click the Select Some Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Store"));
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1000);
		//Click the Load Data button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[3]/button")).click();
		
		try
		{
			//Check whether the Net sale is available or not
			if(driver.findElement(By.xpath("//div[.='Net sale']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Net Sale report is avilable for the selected Time Period");
				
				System.out.println("Net Sale is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[1]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Net Sale is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[1]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Net Sale is not available");
		}
		
		try
		{
			//Check whether the Tax is available or not
			if(driver.findElement(By.xpath("//div[.='Tax']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Tax report is avilable for the selected Time Period");
				
				System.out.println("Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Tax is not available");
		}
		
		try
		{
			//Check whether the Discount is available or not
			if(driver.findElement(By.xpath("//div[.=' Discount']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Discount report is avilable for the selected Time Period");
				
				System.out.println("Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[3]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[3]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Discount is not available");
		}
		
		try
		{
			//Check whether the Net Void is available or not
			if(driver.findElement(By.xpath("//div[.='Net Void']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Net Void report is avilable for the selected Time Period");
				
				System.out.println("Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[4]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[4]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Net Void is not available");
		}
		
		try
		{
			//Check whether the AVG CHECK is available or not
			if(driver.findElement(By.xpath("//div[.='AVG CHECK']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "AVG CHECK report is avilable for the selected Time Period");
				
				System.out.println("AVG CHECK is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[5]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "AVG CHECK is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[5]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "AVG CHECK is not available");
		}
		
		try
		{
			//Check whether the Customer Count is available or not
			if(driver.findElement(By.xpath("//div[.='Customer Count']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Customer Count report is avilable for the selected Time Period");
				
				System.out.println("Customer Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Customer Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Customer Count is not available");
		}
		
		try
		{
			//Check whether the Refunds is available or not
			if(driver.findElement(By.xpath("//div[.='Refunds']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Refunds report is avilable for the selected Time Period");
				
				System.out.println("Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Refunds is not available");
		}
		
		try
		{
			//Check whether the COGS is available or not
			if(driver.findElement(By.xpath("//div[.='COGS']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "COGS report is avilable for the selected Time Period");
				
				System.out.println("COGS is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[3]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "COGS is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[3]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "COGS is not available");
		}
		
		try
		{
			//Check whether the Labor is available or not
			if(driver.findElement(By.xpath("//div[.='Labor']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Labor report is avilable for the selected Time Period");
				
				System.out.println("Labor is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[4]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Labor is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[4]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Labor is not available");
		}
		
		try
		{
			//Check whether the SPLH is available or not
			if(driver.findElement(By.xpath("//div[.='SPLH']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "SPLH report is avilable for the selected Time Period");
				
				System.out.println("SPLH is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[5]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "SPLH is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[5]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "SPLH is not available");
		}

		try
		{
			//Check whether the NET SALES BY HOUR is available or not
			if(driver.findElement(By.xpath("//div[.='NET SALES BY HOUR']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "NET SALES BY HOUR report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "NET SALES BY HOUR is not available");
		}
		
		try
		{
			//Check whether the SALES BY STORE is available or not
			if(driver.findElement(By.xpath("//div[.='SALES BY STORE']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "SALES BY STORE report is avilable for the selected Time Period");
				
				Thread.sleep(1000);
			
				//Get the rows count
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr"));
				rows.size();
				
				//Get the columns count
				List<WebElement> columns = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr[2]/td"));
				columns.size();
				
				for(int i = 2; i <= rows.size() ; i++)
				{
					for(int j = 2; j <= columns.size() ; j++)
					{
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr["+i+"]/td[1]")).getText()+" contain the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr[1]/th["+j+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr["+i+"]/td["+j+"]")).getText());
					}
				}
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "SALES BY STORE is not available");
		}
		
		try
		{
			//Check whether the TOP 5 STORES is available or not
			if(driver.findElement(By.xpath("//div[.='TOP 5 STORES']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "TOP 5 STORES report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "TOP 5 STORES is not available");
		}
		
		try
		{
			//Check whether the TOP 5 CATEGORIES is available or not
			if(driver.findElement(By.xpath("//div[.='TOP 5 CATEGORIES']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "TOP 5 CATEGORIES report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "TOP 5 CATEGORIES is not available");
		}
		
		try
		{
			//Check whether the TOP 5 MENU ITEMS is available or not
			if(driver.findElement(By.xpath("//div[.='Net sale']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "TOP 5 MENU ITEMS report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "TOP 5 MENU ITEMS is not available");
		}
		
		try
		{
			//Check whether the SALE PER ORDER TYPE is available or not
			if(driver.findElement(By.xpath("//div[.='SALE PER ORDER TYPE']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "SALE PER ORDER TYPE report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "SALE PER ORDER TYPE is not available");
		}
		
		Thread.sleep(3000);
		System.out.println("********************* End of Store Report *************************");
		test.log(LogStatus.INFO, "********************* End of Store Report *************************");

		
	}
	
	@Test(priority=4)
	public void My_Enterprise_Report_Group(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		System.out.println("********************* View The Group Report *************************");
		test.log(LogStatus.INFO, "********************* View The Store Report *************************");
		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/div/div/input")).sendKeys("Group");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1500);
		//Click the Select Some Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Group"));
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1000);
		//Click the Load Data button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[3]/button")).click();
		
		try
		{
			//Check whether the Net sale is available or not
			if(driver.findElement(By.xpath("//div[.='Net sale']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Net Sale report is avilable for the selected Time Period");
				
				System.out.println("Net Sale is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[1]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Net Sale is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[1]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Net Sale is not available");
		}
		
		try
		{
			//Check whether the Tax is available or not
			if(driver.findElement(By.xpath("//div[.='Tax']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Tax report is avilable for the selected Time Period");
				
				System.out.println("Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Tax is not available");
		}
		
		try
		{
			//Check whether the Discount is available or not
			if(driver.findElement(By.xpath("//div[.=' Discount']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Discount report is avilable for the selected Time Period");
				
				System.out.println("Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[3]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[3]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Discount is not available");
		}
		
		try
		{
			//Check whether the Net Void is available or not
			if(driver.findElement(By.xpath("//div[.='Net Void']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Net Void report is avilable for the selected Time Period");
				
				System.out.println("Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[4]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[4]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Net Void is not available");
		}
		
		try
		{
			//Check whether the AVG CHECK is available or not
			if(driver.findElement(By.xpath("//div[.='AVG CHECK']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "AVG CHECK report is avilable for the selected Time Period");
				
				System.out.println("AVG CHECK is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[5]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "AVG CHECK is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[5]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "AVG CHECK is not available");
		}
		
		try
		{
			//Check whether the Customer Count is available or not
			if(driver.findElement(By.xpath("//div[.='Customer Count']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Customer Count report is avilable for the selected Time Period");
				
				System.out.println("Customer Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Customer Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Customer Count is not available");
		}
		
		try
		{
			//Check whether the Refunds is available or not
			if(driver.findElement(By.xpath("//div[.='Refunds']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Refunds report is avilable for the selected Time Period");
				
				System.out.println("Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Refunds is not available");
		}
		
		try
		{
			//Check whether the COGS is available or not
			if(driver.findElement(By.xpath("//div[.='COGS']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "COGS report is avilable for the selected Time Period");
				
				System.out.println("COGS is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[3]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "COGS is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[3]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "COGS is not available");
		}
		
		try
		{
			//Check whether the Labor is available or not
			if(driver.findElement(By.xpath("//div[.='Labor']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Labor report is avilable for the selected Time Period");
				
				System.out.println("Labor is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[4]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Labor is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[4]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Labor is not available");
		}
		
		try
		{
			//Check whether the SPLH is available or not
			if(driver.findElement(By.xpath("//div[.='SPLH']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "SPLH report is avilable for the selected Time Period");
				
				System.out.println("SPLH is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[5]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "SPLH is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[5]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "SPLH is not available");
		}

		try
		{
			//Check whether the NET SALES BY HOUR is available or not
			if(driver.findElement(By.xpath("//div[.='NET SALES BY HOUR']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "NET SALES BY HOUR report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "NET SALES BY HOUR is not available");
		}
		
		try
		{
			//Check whether the SALES BY STORE is available or not
			if(driver.findElement(By.xpath("//div[.='SALES BY STORE']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "SALES BY STORE report is avilable for the selected Time Period");
				
				Thread.sleep(1000);
			
				//Get the rows count
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr"));
				rows.size();
				
				//Get the columns count
				List<WebElement> columns = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr[2]/td"));
				columns.size();
				
				for(int i = 2; i <= rows.size() ; i++)
				{
					for(int j = 2; j <= columns.size() ; j++)
					{
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr["+i+"]/td[1]")).getText()+" contain the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr[1]/th["+j+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr["+i+"]/td["+j+"]")).getText());
					}
				}
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "SALES BY STORE is not available");
		}
		
		try
		{
			//Check whether the TOP 5 STORES is available or not
			if(driver.findElement(By.xpath("//div[.='TOP 5 STORES']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "TOP 5 STORES report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "TOP 5 STORES is not available");
		}
		
		try
		{
			//Check whether the TOP 5 CATEGORIES is available or not
			if(driver.findElement(By.xpath("//div[.='TOP 5 CATEGORIES']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "TOP 5 CATEGORIES report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "TOP 5 CATEGORIES is not available");
		}
		
		try
		{
			//Check whether the TOP 5 MENU ITEMS is available or not
			if(driver.findElement(By.xpath("//div[.='Net sale']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "TOP 5 MENU ITEMS report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "TOP 5 MENU ITEMS is not available");
		}
		
		try
		{
			//Check whether the SALE PER ORDER TYPE is available or not
			if(driver.findElement(By.xpath("//div[.='SALE PER ORDER TYPE']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "SALE PER ORDER TYPE report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "SALE PER ORDER TYPE is not available");
		}
		
		Thread.sleep(3000);
		System.out.println("********************* End of Group Report *************************");
		test.log(LogStatus.INFO, "********************* End of Group Report *************************");
	}
	
	@Test(priority=5)
	public void My_Enterprise_Report_City(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		System.out.println("********************* View The City Report *************************");
		test.log(LogStatus.INFO, "********************* View The City Report *************************");
		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/div/div/input")).sendKeys("City");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1500);
		//Click the Select Some Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("City"));
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1000);
		//Click the Load Data button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[3]/button")).click();
		
		try
		{
			//Check whether the Net sale is available or not
			if(driver.findElement(By.xpath("//div[.='Net sale']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Net Sale report is avilable for the selected Time Period");
				
				System.out.println("Net Sale is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[1]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Net Sale is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[1]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Net Sale is not available");
		}
		
		try
		{
			//Check whether the Tax is available or not
			if(driver.findElement(By.xpath("//div[.='Tax']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Tax report is avilable for the selected Time Period");
				
				System.out.println("Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Tax is not available");
		}
		
		try
		{
			//Check whether the Discount is available or not
			if(driver.findElement(By.xpath("//div[.=' Discount']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Discount report is avilable for the selected Time Period");
				
				System.out.println("Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[3]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[3]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Discount is not available");
		}
		
		try
		{
			//Check whether the Net Void is available or not
			if(driver.findElement(By.xpath("//div[.='Net Void']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Net Void report is avilable for the selected Time Period");
				
				System.out.println("Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[4]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[4]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Net Void is not available");
		}
		
		try
		{
			//Check whether the AVG CHECK is available or not
			if(driver.findElement(By.xpath("//div[.='AVG CHECK']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "AVG CHECK report is avilable for the selected Time Period");
				
				System.out.println("AVG CHECK is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[5]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "AVG CHECK is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[5]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "AVG CHECK is not available");
		}
		
		try
		{
			//Check whether the Customer Count is available or not
			if(driver.findElement(By.xpath("//div[.='Customer Count']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Customer Count report is avilable for the selected Time Period");
				
				System.out.println("Customer Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Customer Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Customer Count is not available");
		}
		
		try
		{
			//Check whether the Refunds is available or not
			if(driver.findElement(By.xpath("//div[.='Refunds']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Refunds report is avilable for the selected Time Period");
				
				System.out.println("Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Refunds is not available");
		}
		
		try
		{
			//Check whether the COGS is available or not
			if(driver.findElement(By.xpath("//div[.='COGS']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "COGS report is avilable for the selected Time Period");
				
				System.out.println("COGS is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[3]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "COGS is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[3]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "COGS is not available");
		}
		
		try
		{
			//Check whether the Labor is available or not
			if(driver.findElement(By.xpath("//div[.='Labor']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Labor report is avilable for the selected Time Period");
				
				System.out.println("Labor is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[4]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Labor is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[4]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Labor is not available");
		}
		
		try
		{
			//Check whether the SPLH is available or not
			if(driver.findElement(By.xpath("//div[.='SPLH']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "SPLH report is avilable for the selected Time Period");
				
				System.out.println("SPLH is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[5]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "SPLH is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[5]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "SPLH is not available");
		}

		try
		{
			//Check whether the NET SALES BY HOUR is available or not
			if(driver.findElement(By.xpath("//div[.='NET SALES BY HOUR']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "NET SALES BY HOUR report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "NET SALES BY HOUR is not available");
		}
		
		try
		{
			//Check whether the SALES BY STORE is available or not
			if(driver.findElement(By.xpath("//div[.='SALES BY STORE']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "SALES BY STORE report is avilable for the selected Time Period");
				
				Thread.sleep(1000);
			
				//Get the rows count
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr"));
				rows.size();
				
				//Get the columns count
				List<WebElement> columns = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr[2]/td"));
				columns.size();
				
				for(int i = 2; i <= rows.size() ; i++)
				{
					for(int j = 2; j <= columns.size() ; j++)
					{
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr["+i+"]/td[1]")).getText()+" contain the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr[1]/th["+j+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr["+i+"]/td["+j+"]")).getText());
					}
				}
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "SALES BY STORE is not available");
		}
		
		try
		{
			//Check whether the TOP 5 STORES is available or not
			if(driver.findElement(By.xpath("//div[.='TOP 5 STORES']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "TOP 5 STORES report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "TOP 5 STORES is not available");
		}
		
		try
		{
			//Check whether the TOP 5 CATEGORIES is available or not
			if(driver.findElement(By.xpath("//div[.='TOP 5 CATEGORIES']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "TOP 5 CATEGORIES report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "TOP 5 CATEGORIES is not available");
		}
		
		try
		{
			//Check whether the TOP 5 MENU ITEMS is available or not
			if(driver.findElement(By.xpath("//div[.='Net sale']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "TOP 5 MENU ITEMS report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "TOP 5 MENU ITEMS is not available");
		}
		
		try
		{
			//Check whether the SALE PER ORDER TYPE is available or not
			if(driver.findElement(By.xpath("//div[.='SALE PER ORDER TYPE']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "SALE PER ORDER TYPE report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "SALE PER ORDER TYPE is not available");
		}
		
		Thread.sleep(3000);
		System.out.println("********************* End of City Report *************************");
		test.log(LogStatus.INFO, "********************* End of City Report *************************");
	}
	
	@Test(priority=6)
	public void My_Enterprise_Report_State(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		System.out.println("********************* View The State Report *************************");
		test.log(LogStatus.INFO, "********************* View The State Report *************************");
		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/div/div/input")).sendKeys("State");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1500);
		//Click the Select Some Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("State"));
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1000);
		//Click the Load Data button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[3]/button")).click();
		
		try
		{
			//Check whether the Net sale is available or not
			if(driver.findElement(By.xpath("//div[.='Net sale']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Net Sale report is avilable for the selected Time Period");
				
				System.out.println("Net Sale is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[1]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Net Sale is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[1]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Net Sale is not available");
		}
		
		try
		{
			//Check whether the Tax is available or not
			if(driver.findElement(By.xpath("//div[.='Tax']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Tax report is avilable for the selected Time Period");
				
				System.out.println("Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Tax is not available");
		}
		
		try
		{
			//Check whether the Discount is available or not
			if(driver.findElement(By.xpath("//div[.=' Discount']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Discount report is avilable for the selected Time Period");
				
				System.out.println("Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[3]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[3]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Discount is not available");
		}
		
		try
		{
			//Check whether the Net Void is available or not
			if(driver.findElement(By.xpath("//div[.='Net Void']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Net Void report is avilable for the selected Time Period");
				
				System.out.println("Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[4]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[4]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Net Void is not available");
		}
		
		try
		{
			//Check whether the AVG CHECK is available or not
			if(driver.findElement(By.xpath("//div[.='AVG CHECK']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "AVG CHECK report is avilable for the selected Time Period");
				
				System.out.println("AVG CHECK is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[5]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "AVG CHECK is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[5]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "AVG CHECK is not available");
		}
		
		try
		{
			//Check whether the Customer Count is available or not
			if(driver.findElement(By.xpath("//div[.='Customer Count']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Customer Count report is avilable for the selected Time Period");
				
				System.out.println("Customer Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Customer Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Customer Count is not available");
		}
		
		try
		{
			//Check whether the Refunds is available or not
			if(driver.findElement(By.xpath("//div[.='Refunds']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Refunds report is avilable for the selected Time Period");
				
				System.out.println("Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Refunds is not available");
		}
		
		try
		{
			//Check whether the COGS is available or not
			if(driver.findElement(By.xpath("//div[.='COGS']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "COGS report is avilable for the selected Time Period");
				
				System.out.println("COGS is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[3]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "COGS is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[3]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "COGS is not available");
		}
		
		try
		{
			//Check whether the Labor is available or not
			if(driver.findElement(By.xpath("//div[.='Labor']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Labor report is avilable for the selected Time Period");
				
				System.out.println("Labor is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[4]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Labor is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[4]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Labor is not available");
		}
		
		try
		{
			//Check whether the SPLH is available or not
			if(driver.findElement(By.xpath("//div[.='SPLH']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "SPLH report is avilable for the selected Time Period");
				
				System.out.println("SPLH is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[5]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "SPLH is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[5]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "SPLH is not available");
		}

		try
		{
			//Check whether the NET SALES BY HOUR is available or not
			if(driver.findElement(By.xpath("//div[.='NET SALES BY HOUR']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "NET SALES BY HOUR report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "NET SALES BY HOUR is not available");
		}
		
		try
		{
			//Check whether the SALES BY STORE is available or not
			if(driver.findElement(By.xpath("//div[.='SALES BY STORE']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "SALES BY STORE report is avilable for the selected Time Period");
				
				Thread.sleep(1000);
			
				//Get the rows count
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr"));
				rows.size();
				
				//Get the columns count
				List<WebElement> columns = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr[2]/td"));
				columns.size();
				
				for(int i = 2; i <= rows.size() ; i++)
				{
					for(int j = 2; j <= columns.size() ; j++)
					{
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr["+i+"]/td[1]")).getText()+" contain the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr[1]/th["+j+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr["+i+"]/td["+j+"]")).getText());
					}
				}
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "SALES BY STORE is not available");
		}
		
		try
		{
			//Check whether the TOP 5 STORES is available or not
			if(driver.findElement(By.xpath("//div[.='TOP 5 STORES']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "TOP 5 STORES report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "TOP 5 STORES is not available");
		}
		
		try
		{
			//Check whether the TOP 5 CATEGORIES is available or not
			if(driver.findElement(By.xpath("//div[.='TOP 5 CATEGORIES']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "TOP 5 CATEGORIES report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "TOP 5 CATEGORIES is not available");
		}
		
		try
		{
			//Check whether the TOP 5 MENU ITEMS is available or not
			if(driver.findElement(By.xpath("//div[.='Net sale']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "TOP 5 MENU ITEMS report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "TOP 5 MENU ITEMS is not available");
		}
		
		try
		{
			//Check whether the SALE PER ORDER TYPE is available or not
			if(driver.findElement(By.xpath("//div[.='SALE PER ORDER TYPE']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "SALE PER ORDER TYPE report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "SALE PER ORDER TYPE is not available");
		}
		
		Thread.sleep(3000);
		System.out.println("********************* End of State Report *************************");
		test.log(LogStatus.INFO, "********************* End of State Report *************************");
	}
	
	@Test(priority=7)
	public void My_Enterprise_Report_ZipCode(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		System.out.println("********************* View The Zip Code Report *************************");
		test.log(LogStatus.INFO, "********************* View The Zip Code Report *************************");
		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/div/div/input")).sendKeys("Zip Code");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1500);
		//Click the Select Some Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Zipcode"));
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1000);
		//Click the Load Data button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]/div[3]/button")).click();
		
		try
		{
			//Check whether the Net sale is available or not
			if(driver.findElement(By.xpath("//div[.='Net sale']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Net Sale report is avilable for the selected Time Period");
				
				System.out.println("Net Sale is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[1]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Net Sale is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[1]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Net Sale is not available");
		}
		
		try
		{
			//Check whether the Tax is available or not
			if(driver.findElement(By.xpath("//div[.='Tax']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Tax report is avilable for the selected Time Period");
				
				System.out.println("Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Tax is not available");
		}
		
		try
		{
			//Check whether the Discount is available or not
			if(driver.findElement(By.xpath("//div[.=' Discount']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Discount report is avilable for the selected Time Period");
				
				System.out.println("Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[3]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[3]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Discount is not available");
		}
		
		try
		{
			//Check whether the Net Void is available or not
			if(driver.findElement(By.xpath("//div[.='Net Void']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Net Void report is avilable for the selected Time Period");
				
				System.out.println("Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[4]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[4]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Net Void is not available");
		}
		
		try
		{
			//Check whether the AVG CHECK is available or not
			if(driver.findElement(By.xpath("//div[.='AVG CHECK']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "AVG CHECK report is avilable for the selected Time Period");
				
				System.out.println("AVG CHECK is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[5]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "AVG CHECK is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[5]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "AVG CHECK is not available");
		}
		
		try
		{
			//Check whether the Customer Count is available or not
			if(driver.findElement(By.xpath("//div[.='Customer Count']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Customer Count report is avilable for the selected Time Period");
				
				System.out.println("Customer Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Customer Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Customer Count is not available");
		}
		
		try
		{
			//Check whether the Refunds is available or not
			if(driver.findElement(By.xpath("//div[.='Refunds']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Refunds report is avilable for the selected Time Period");
				
				System.out.println("Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Refunds is not available");
		}
		
		try
		{
			//Check whether the COGS is available or not
			if(driver.findElement(By.xpath("//div[.='COGS']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "COGS report is avilable for the selected Time Period");
				
				System.out.println("COGS is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[3]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "COGS is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[3]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "COGS is not available");
		}
		
		try
		{
			//Check whether the Labor is available or not
			if(driver.findElement(By.xpath("//div[.='Labor']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Labor report is avilable for the selected Time Period");
				
				System.out.println("Labor is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[4]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "Labor is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[4]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Labor is not available");
		}
		
		try
		{
			//Check whether the SPLH is available or not
			if(driver.findElement(By.xpath("//div[.='SPLH']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "SPLH report is avilable for the selected Time Period");
				
				System.out.println("SPLH is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[5]/div[2]/span[1]")).getText());
				
				test.log(LogStatus.INFO, "SPLH is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[5]/div[2]/span[1]")).getText());
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "SPLH is not available");
		}

		try
		{
			//Check whether the NET SALES BY HOUR is available or not
			if(driver.findElement(By.xpath("//div[.='NET SALES BY HOUR']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "NET SALES BY HOUR report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "NET SALES BY HOUR is not available");
		}
		
		try
		{
			//Check whether the SALES BY STORE is available or not
			if(driver.findElement(By.xpath("//div[.='SALES BY STORE']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "SALES BY STORE report is avilable for the selected Time Period");
				
				Thread.sleep(1000);
			
				//Get the rows count
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr"));
				rows.size();
				
				//Get the columns count
				List<WebElement> columns = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr[2]/td"));
				columns.size();
				
				for(int i = 2; i <= rows.size() ; i++)
				{
					for(int j = 2; j <= columns.size() ; j++)
					{
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr["+i+"]/td[1]")).getText()+" contain the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr[1]/th["+j+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/table/tbody/tr["+i+"]/td["+j+"]")).getText());
					}
				}
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "SALES BY STORE is not available");
		}
		
		try
		{
			//Check whether the TOP 5 STORES is available or not
			if(driver.findElement(By.xpath("//div[.='TOP 5 STORES']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "TOP 5 STORES report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "TOP 5 STORES is not available");
		}
		
		try
		{
			//Check whether the TOP 5 CATEGORIES is available or not
			if(driver.findElement(By.xpath("//div[.='TOP 5 CATEGORIES']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "TOP 5 CATEGORIES report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "TOP 5 CATEGORIES is not available");
		}
		
		try
		{
			//Check whether the TOP 5 MENU ITEMS is available or not
			if(driver.findElement(By.xpath("//div[.='Net sale']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "TOP 5 MENU ITEMS report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "TOP 5 MENU ITEMS is not available");
		}
		
		try
		{
			//Check whether the SALE PER ORDER TYPE is available or not
			if(driver.findElement(By.xpath("//div[.='SALE PER ORDER TYPE']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "SALE PER ORDER TYPE report is avilable for the selected Time Period");
				
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "SALE PER ORDER TYPE is not available");
		}
		
		Thread.sleep(3000);
		System.out.println("********************* End of Zip Code Report *************************");
		test.log(LogStatus.INFO, "********************* End of Zip Code Report *************************");

	}

	@Test(priority=8)
	public void Enterprice_Royalty_Franchise_Settings_method_open_Enterprice_Royalty_Franchise_Settings(WebDriver driver) throws Exception
	{
		/*driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		//Click the My Stores option
		driver.findElement(By.xpath("//span[.='My Stores']")).click();

		
		Thread.sleep(3000);
        //Click the Royalty/Franchise Option		
		driver.findElement(By.xpath("//span[.='Royalty/Franchise']")).click();
		

		*/
		//Enter the Coursing URL
		driver.get(Utility.getProperty("Enterprise_Base_URL")+"royalty");
		Thread.sleep(5000);
		//Check Royalty/Franchise page opened or not
		if(driver.findElement(By.xpath("//a[.='Royalty/Franchise']")).getText().equalsIgnoreCase("Royalty/Franchise"))
		{
			test.log(LogStatus.PASS, "Royalty/Franchise Settings page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Royalty/Franchise Settings page loaded Failed");
		}
		
	}

	@Test(priority=9)
	public void Enterprice_Royalty_Franchise_Settings_method_Pagination(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Pagination option as 10
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/div/div/div/ul/li[2]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Royalty/Franchise");
		//Create the web element for Account Users Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Royalty/Franchise, When user click 10");
		}
		Thread.sleep(4000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/div/div/div/ul/li[3]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Royalty/Franchise");
		//Create the web element for Account Users Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Royalty/Franchise, When user click 15");
		}
		Thread.sleep(4000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/div/div/div/ul/li[4]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20 Fran");
		//Create the web element for Account Users Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Royalty/Franchise, When user click 20");
		}
		Thread.sleep(4000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/div/div/div/ul/li[1]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Royalty/Franchise");
		//Create the web element for Account Users Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Royalty/Franchise, When user click 5");
		}
		Thread.sleep(4000);
	}

	@Test(priority=10)
	public void Enterprice_Royalty_Franchise_Settings_method_Update_Settings(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		//Search the required store
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Store"));
		
		Thread.sleep(8000);
		//Click Royalty/Franchise button is enabled or disabled
		driver.findElement(By.xpath("//td[2]/div/div/label/span")).click();
		
		Thread.sleep(1500);
		//Check whether the Royalty/Franchise button is enabled or not
		if(driver.findElement(By.xpath("//td[2]/div/div/label/input")).isSelected())
		{}
		else
		{
			Thread.sleep(2500);
			
			//Click Royalty/Franchise button is enabled or disabled
			driver.findElement(By.xpath("//td[2]/div/div/label/span")).click();
		}

		Thread.sleep(1500);
		//Enter the Bank Details
		//Clear the routing field
		driver.findElement(By.xpath("//td[3]/div[1]/input")).clear();
		//Enter the required routing name
		driver.findElement(By.xpath("//td[3]/div[1]/input")).sendKeys("Test");
		
		Thread.sleep(1500);
		//Clear the Bank Name
		driver.findElement(By.xpath("//td[3]/div[2]/input")).clear();
		//Enter the Bank Name
		driver.findElement(By.xpath("//td[3]/div[2]/input")).sendKeys("Standard");
		
		Thread.sleep(1500);
		//Clear the Account Number
		driver.findElement(By.xpath("//td[3]/div[3]/input")).clear();
		//Enter the Required Account Number
		driver.findElement(By.xpath("//td[3]/div[3]/input")).sendKeys("7458962531");
		
		//System.out.println("Per : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[4]/div/div[3]/ng-form/div/div/div[2]/div/input")).getText());
		
		Thread.sleep(2000);
		//Click the Add Percentage button
		driver.findElement(By.xpath("//td[4]/div/div[1]/div/a/i")).click();
		
		//Clear the name of percentage
		driver.findElement(By.xpath("//td[4]/div/div[3]/ng-form/div/div/div[1]/div/input")).clear();
		//Enter the name of Percentage
		driver.findElement(By.xpath("//td[4]/div/div[3]/ng-form/div/div/div[1]/div/input")).sendKeys("Employee");
	
		Thread.sleep(1500);
		//Clear the percentage
		driver.findElement(By.xpath("//td[4]/div/div[3]/ng-form/div/div/div[2]/div/input")).clear();
		//Enter the percentage
		driver.findElement(By.xpath("//td[4]/div/div[3]/ng-form/div/div/div[2]/div/input")).sendKeys("5");
		
		Thread.sleep(1000);
		//Enable or Disable the Set Default in the newly add percentage option
		driver.findElement(By.xpath("//td[4]/div/div[3]/ng-form/div/div/div[3]/label/span")).click();

		Thread.sleep(2000);
		//Click the Add Percentage button
		driver.findElement(By.xpath("//td[4]/div/div[1]/div/a/i")).click();
		
		Thread.sleep(1000);
		//Clear the name of percentage
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[1]/div/input")).clear();
		//Enter the name of Percentage
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[1]/div/input")).sendKeys("Employee");
		
		//Clear the percentage
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[2]/div/input")).clear();
		//Enter the percentage
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[2]/div/input")).sendKeys("50");
		
		Thread.sleep(1000);
		//Enable or Disable the Set Default in the newly add percentage option
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[3]/label/span")).click();
		
		Thread.sleep(3000);
		//Check whether the error or warning message displayed or not
		if(driver.findElement(By.xpath("//p[.='Select only one as default']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Error message showed successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Error message showed fail");
		}
		Thread.sleep(1000);
		//Enable or Disable the Set Default in the newly add percentage option
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[3]/label/span")).click();

		Thread.sleep(2000);
		//Click the Add Percentage button
		driver.findElement(By.xpath("//td[4]/div/div[1]/div/a/i")).click();

		Thread.sleep(2000);
		//Click the Close button of newly added one
		driver.findElement(By.xpath("//td[4]/div/div[5]/ng-form/div/div/div[3]/a/i")).click();
		
		Thread.sleep(1000);
		//Click the Yes button
		driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
		
		Thread.sleep(2000);
		//Click the Save button in Controls field
		driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
		
		Thread.sleep(2500);
		//Check whether the account user is saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Royalty details updated successfully."))
		{
			test.log(LogStatus.PASS, "Royalty/Franchise updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Royalty/Franchise updated fail");
		}
		
		Thread.sleep(3000);
		
		Thread.sleep(2000);
		//Click the Close button of newly added one
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[3]/a/i")).click();
		
		Thread.sleep(1000);
		//Click the Yes button
		driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
		
		Thread.sleep(2000);
		//Click the Save button in Controls field
		driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
		Thread.sleep(3000);
		
		
	}
	
	@Test(priority=11)
	public void Enterprice_Royalty_Franchise_Settings_method_Close_Button(WebDriver driver) throws Exception
	{

		Thread.sleep(3500);
		//Enter the Bank Details
		//Clear the routing field
		driver.findElement(By.xpath("//td[3]/div[1]/input")).clear();
		//Enter the required routing name
		driver.findElement(By.xpath("//td[3]/div[1]/input")).sendKeys("Test");
		
		Thread.sleep(1500);
		//Clear the Bank Name
		driver.findElement(By.xpath("//td[3]/div[2]/input")).clear();
		//Enter the Bank Name
		driver.findElement(By.xpath("//td[3]/div[2]/input")).sendKeys("Standard");
		
		Thread.sleep(1500);
		//Clear the Account Number
		driver.findElement(By.xpath("//td[3]/div[3]/input")).clear();
		//Enter the Required Account Number
		driver.findElement(By.xpath("//td[3]/div[3]/input")).sendKeys("7458962531");
		
		Thread.sleep(2000);
		//Click the Add Percentage button
		driver.findElement(By.xpath("//td[4]/div/div[1]/div/a/i")).click();
		
		Thread.sleep(3000);
		//Clear the name of percentage
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[1]/div/input")).clear();
		//Enter the name of Percentage
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[1]/div/input")).sendKeys("Employee");
		
		//Clear the percentage
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[2]/div/input")).clear();
		//Enter the percentage
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[2]/div/input")).sendKeys("50");
		
		//Click the Close button in Controls field
		driver.findElement(By.xpath("//a[@class='btn btn-small btn-danger']")).click();
		Thread.sleep(5000);
		
		int close = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[4]/div/div/ng-form/div/div/div[3]/a")).size();
		//Check whether the Closed or not
		if( close == 1)
		{
			test.log(LogStatus.PASS, "Close button working fine");
		}
		else
		{
			test.log(LogStatus.FAIL, "Close button not working");
		}
		Thread.sleep(2000);
		//Click Royalty/Franchise button is enabled or disabled
		driver.findElement(By.xpath("//td[2]/div/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the Save button in Controls field
		driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=12)
	public void Enterprice_Royalty_Franchise_Settings_method_open_Enterprice_Royalty_Franchise_ACH_ettings(WebDriver driver) throws Exception
	{
		/*driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		//Click the My Stores option
		driver.findElement(By.xpath("//span[.='My Stores']")).click();

		//Enter the Coursing URL
		driver.get(Utility.getProperty("Enterprise_Base_URL")+("Royalty_Franchise_Settings"));
				
		Thread.sleep(3000);
        //Click the Royalty/Franchise Option		
		driver.findElement(By.xpath("//span[.='Royalty/Franchise']")).click();
		
		Thread.sleep(5000);
		//Check Royalty/Franchise page opened or not
		if(driver.findElement(By.xpath("//a[.='Royalty/Franchise']")).getText().equalsIgnoreCase("Royalty/Franchise"))
		{
			test.log(LogStatus.PASS, "Royalty/Franchise Settings page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Royalty/Franchise Settings page loaded Failed");
		}
		*/
		Thread.sleep(3000);
		//Enter the Coursing URL
		driver.get(Utility.getProperty("Enterprise_Base_URL")+"royalty");
		//Click the ACH Settings
		driver.findElement(By.xpath("//span[contains(.,'ACH Settings')]")).click();
		Thread.sleep(2500);
		
		//Check ACH Settings page opened or not
		if(driver.findElement(By.xpath("//a[.='ACH Settings']")).getText().equalsIgnoreCase("ACH Settings"))
		{
			test.log(LogStatus.PASS, "ACH Settings page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "ACH Settings page loaded Failed");
		}
		Thread.sleep(3000);
	}

	@Test(priority=13)
	public void Enterprice_Royalty_Franchise_Settings_method_Update_ACH_Settings(WebDriver driver) throws Exception
	{
		Thread.sleep(4000);
		//Clear the Destination Name
		driver.findElement(By.xpath("//input[@name='destinationName']")).clear();
		//Enter the Destination name
		driver.findElement(By.xpath("//input[@name='destinationName']")).sendKeys("Dest_Test");
		
		Thread.sleep(1500);
		//Clear the Destination Routing number
		driver.findElement(By.xpath("//input[@name='routingNumber']")).clear();
		//Enter the Destination Routing number
		driver.findElement(By.xpath("//input[@name='routingNumber']")).sendKeys("2224222");
		
		Thread.sleep(1500);
		//Clear the Immediate Origin name
		driver.findElement(By.xpath("//input[@name='originName']")).clear();
		//Enter the Immediate Origin Name
		driver.findElement(By.xpath("//input[@name='originName']")).sendKeys("Org_Test");
		
		Thread.sleep(1500);
		//Clear the Immediate Origin number
		driver.findElement(By.xpath("//input[@name='originNumber']")).clear();
		//Enter the Immediate Origin number
		driver.findElement(By.xpath("//input[@name='originNumber']")).sendKeys("4545");
		
		Thread.sleep(1500);
		//Clear the Company name
		driver.findElement(By.xpath("//input[@name='companyName']")).clear();
		//Enter the Company Name
		driver.findElement(By.xpath("//input[@name='companyName']")).sendKeys("Comp_Test");
		
		Thread.sleep(1500);
		//Clear the Company entry description
		driver.findElement(By.xpath("//input[@name='companyEntryDescription']")).clear();
		//Enter the Company entry description
		driver.findElement(By.xpath("//input[@name='companyEntryDescription']")).sendKeys("Desc_Test");
		
		Thread.sleep(1500);
		//Clear the Effective Entry Date
		driver.findElement(By.xpath("//input[@name='effectiveDate']")).clear();
		//Enter the Effective Entry Date
		driver.findElement(By.xpath("//input[@name='effectiveDate']")).sendKeys("02-Jan-2020");
		
		Thread.sleep(1500);
		//Clear the Company Discretionary Data
		driver.findElement(By.xpath("//input[@name='companyDiscretionData']")).clear();
		//Enter the Company Discretionary Data
		driver.findElement(By.xpath("//input[@name='companyDiscretionData']")).sendKeys("Disc_Data");
		
		Thread.sleep(1500);
		//Clear the Company Identification Number
		driver.findElement(By.xpath("//input[@name='companyIdentificationNumber']")).clear();
		//Enter the Company Identification Number
		driver.findElement(By.xpath("//input[@name='companyIdentificationNumber']")).sendKeys("2552");
		
		Thread.sleep(1500);
		//Clear the Originating DFI Identification
		driver.findElement(By.xpath("//input[@name='originatingDFIIdentification']")).clear();
		//Enter the Originating DFI Identification
		driver.findElement(By.xpath("//input[@name='originatingDFIIdentification']")).sendKeys("5555");

		Thread.sleep(3000);
		//Click the Update button
		driver.findElement(By.xpath("//span[.='Update']")).click();
		
		Thread.sleep(3000);
		//Check whether the account user is saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Saved Successfully"))
		{
			test.log(LogStatus.PASS, "ACH Settings updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "ACH Settings updated fail");
		}
		
		Thread.sleep(3000);
	}
	
	@Test(priority=14)
	public void Enterprice_Royalty_Franchise_Settings_method_open_Enterprice_Royalty_Franchise_Royalty_Report(WebDriver driver) throws Exception
	{
		/*driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		//Click the My Stores option
		driver.findElement(By.xpath("//span[.='My Stores']")).click();
		

		Thread.sleep(3000);
        //Click the Royalty/Franchise Option		
		driver.findElement(By.xpath("//span[.='Royalty/Franchise']")).click();
		
		Thread.sleep(5000);
		//Check Royalty/Franchise page opened or not
		if(driver.findElement(By.xpath("//a[.='Royalty/Franchise']")).getText().equalsIgnoreCase("Royalty/Franchise"))
		{
			test.log(LogStatus.PASS, "Royalty/Franchise Settings page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Royalty/Franchise Settings page loaded Failed");
		}
		*/
		Thread.sleep(3000);
		//Enter the Coursing URL
		driver.get(Utility.getProperty("Enterprise_Base_URL")+"royaltyReport");

		Thread.sleep(2500);
		
		//Check Royalty Report page opened or not
		if(driver.findElement(By.xpath("//a[.='Royalty Report']")).getText().equalsIgnoreCase("Royalty Report"))
		{
			test.log(LogStatus.PASS, "Royalty Report page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report page loaded Failed");
		}
		Thread.sleep(3000);
	}

	@Test(priority=15)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_Store(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Stores");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Store"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Store");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Store");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount(Store) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount(Store) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee(Store) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee(Store) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee(Store) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee(Store) is Incorrect");
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Store");
		}
		
	}
	
	@Test(priority=16)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_Group(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Group"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Group");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Group");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount(Group) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount(Group) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee(Group) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee(Group) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee(Group) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee(Group) is Incorrect");
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Group");
		}
		Thread.sleep(3000);
	}

	@Test(priority=17)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_City(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("City");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("City"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for City");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for City");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount(City) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount(City) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee(City) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee(City) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee(City) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee(City) is Incorrect");
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for City");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=18)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_State(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("State");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("State"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for State");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for State");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount(State) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount(State) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee(State) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee(State) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee(State) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee(State) is Incorrect");
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for State");
		}
		Thread.sleep(3000);
	}
		
	@Test(priority=19)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_Zipcode(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Zip Code");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Zipcode"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Zipcode");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Zipcode");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount(Zipcode) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount(Zipcode) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee(Zipcode) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee(Zipcode) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee(Zipcode) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee(Zipcode) is Incorrect");
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Zipcode");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=21)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_Store_With_ExcludeLoyaltyRedemtion(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Stores");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Store"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1500);
		//Enable the ExcludeLoyaltyRedemtion button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[5]/div/div/input")).click();
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Store");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Store(With Exclude Loyalty Redemtion)");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount for Store(With Exclude Loyalty Redemtion) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount for Store(With Exclude Loyalty Redemtion) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee for Store(With Exclude Loyalty Redemtion) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee for Store(With Exclude Loyalty Redemtion) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee for Store(With Exclude Loyalty Redemtion) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee for Store(With Exclude Loyalty Redemtion) is Incorrect");
			}
				
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Store");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=22)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_Group_With_ExcludeLoyaltyRedemtion(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Group"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1500);
		//Enable the ExcludeLoyaltyRedemtion button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[5]/div/div/input")).click();
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Group");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Group(With Exclude Loyalty Redemtion)");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount for Group(With Exclude Loyalty Redemtion) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount for Group(With Exclude Loyalty Redemtion) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee for Group(With Exclude Loyalty Redemtion) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee for Group(With Exclude Loyalty Redemtion) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee for Group(With Exclude Loyalty Redemtion) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee for Group(With Exclude Loyalty Redemtion) is Incorrect");
			}
				
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Group");
		}
		Thread.sleep(3000);
	}

	@Test(priority=23)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_City_With_ExcludeLoyaltyRedemtion(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("City");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("City"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1500);
		//Enable the ExcludeLoyaltyRedemtion button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[5]/div/div/input")).click();
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for City");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for City(With Exclude Loyalty Redemtion)");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount for City(With Exclude Loyalty Redemtion) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount for City(With Exclude Loyalty Redemtion) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee for City(With Exclude Loyalty Redemtion) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee for City(With Exclude Loyalty Redemtion) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee for City(With Exclude Loyalty Redemtion) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee for City(With Exclude Loyalty Redemtion) is Incorrect");
			}
				
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for City");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=24)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_State_With_ExcludeLoyaltyRedemtion(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("State");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("State"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1500);
		//Enable the ExcludeLoyaltyRedemtion button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[5]/div/div/input")).click();
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for State");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for State(With Exclude Loyalty Redemtion)");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount for State(With Exclude Loyalty Redemtion) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount for State(With Exclude Loyalty Redemtion) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee for State(With Exclude Loyalty Redemtion) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee for State(With Exclude Loyalty Redemtion) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee for State(With Exclude Loyalty Redemtion) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee for State(With Exclude Loyalty Redemtion) is Incorrect");
			}
				
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for state");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=25)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_Zipcode_With_ExcludeLoyaltyRedemtion(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Zip code");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Zipcode"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1500);
		//Enable the ExcludeLoyaltyRedemtion button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[5]/div/div/input")).click();
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available  for Zipcode");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Zipcode(With Exclude Loyalty Redemtion)");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount for Zipcode(With Exclude Loyalty Redemtion) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount for Zipcode(With Exclude Loyalty Redemtion) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee for Zipcode(With Exclude Loyalty Redemtion) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee for Zipcode(With Exclude Loyalty Redemtion) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee for Zipcode(With Exclude Loyalty Redemtion) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee for Zipcode(With Exclude Loyalty Redemtion) is Incorrect");
			}
				
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Zipcode");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=27)
	public void Enterprice_Royalty_Franchise_Settings_method_open_Enterprice_Royalty_Franchise_ACH_Report(WebDriver driver) throws Exception
	{
		/*driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		//Click the My Stores option
		driver.findElement(By.xpath("//span[.='My Stores']")).click();

		Thread.sleep(3000);
        //Click the Royalty/Franchise Option		
		driver.findElement(By.xpath("//span[.='Royalty/Franchise']")).click();
		
		Thread.sleep(5000);
		//Check Royalty/Franchise page opened or not
		if(driver.findElement(By.xpath("//a[.='Royalty/Franchise']")).getText().equalsIgnoreCase("Royalty/Franchise"))
		{
			test.log(LogStatus.PASS, "Royalty/Franchise Settings page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Royalty/Franchise Settings page loaded Failed");
		}
		*/
		Thread.sleep(3000);
		//Click the Royalty/Franchise Option		
		driver.findElement(By.xpath("//span[.='Royalty/Franchise']")).click();
		
		//Click the Royalty Report
		driver.findElement(By.xpath("//span[contains(.,'ACH Report')]")).click();
		Thread.sleep(2500);
		
		//Check Royalty Report page opened or not
		if(driver.findElement(By.xpath("//a[.='Royalty Report']")).getText().equalsIgnoreCase("Royalty Report"))
		{
			test.log(LogStatus.PASS, "ACH Report page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "ACH Report page loaded Failed");
		}
		Thread.sleep(3000);
	}

	@Test(priority=28)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_ACH_Report_Store(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Stores");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Store"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1000);
		//Click the Standard Entry Class Code Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/a")).click();
		//Enter the Required option of Standard Entry Class Code
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys("PPD");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the	Credit/Debit option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/a")).click();
		//Enter the Required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys("Both");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Store");
		}
											 
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Store");
			
			Thread.sleep(3000);//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[3]/td[7]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount(Store) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount(Store) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee(Store) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee(Store) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee(Store) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee(Store) is Incorrect");
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Store");
		}
		
	}
	
	@Test(priority=29)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_ACH_Report_Group(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Group"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1000);
		//Click the Standard Entry Class Code Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/a")).click();
		//Enter the Required option of Standard Entry Class Code
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys("PPD");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the	Credit/Debit option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/a")).click();
		//Enter the Required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys("Credit");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);

		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Group");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Group");
			
			Thread.sleep(3000);//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[3]/td[7]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount(Group) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount(Group) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee(Group) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee(Group) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee(Group) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee(Group) is Incorrect");
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Group");
		}
		Thread.sleep(3000);
	}

	@Test(priority=30)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_ACH_Report_City(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("City");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("City"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1000);
		//Click the Standard Entry Class Code Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/a")).click();
		//Enter the Required option of Standard Entry Class Code
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys("PPD");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the	Credit/Debit option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/a")).click();
		//Enter the Required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys("Debit");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for City");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for City");
			
			Thread.sleep(3000);//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[3]/td[7]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount(City) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount(City) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee(City) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee(City) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee(City) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee(City) is Incorrect");
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for City");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=31)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_ACH_Report_State(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("State");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("State"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1000);
		//Click the Standard Entry Class Code Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/a")).click();
		//Enter the Required option of Standard Entry Class Code
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys("CCD");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the	Credit/Debit option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/a")).click();
		//Enter the Required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys("Both");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for State");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for State");
			
			Thread.sleep(3000);//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[3]/td[7]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount(State) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount(State) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee(State) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee(State) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee(State) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee(State) is Incorrect");
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for State");
		}
		Thread.sleep(3000);
	}
		
	@Test(priority=32)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_ACH_Report_Zipcode(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Zip Code");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Zipcode"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1000);
		//Click the Standard Entry Class Code Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/a")).click();
		//Enter the Required option of Standard Entry Class Code
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys("CCD");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the	Credit/Debit option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/a")).click();
		//Enter the Required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys("Credit");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Zipcode");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Zipcode");
			
			Thread.sleep(3000);//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[3]/td[7]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount(Zipcode) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount(Zipcode) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee(Zipcode) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee(Zipcode) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee(Zipcode) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee(Zipcode) is Incorrect");
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Zipcode");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=33)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_ACH_Zipcode_CCD_Debit(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Zip Code");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Zipcode"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1000);
		//Click the Standard Entry Class Code Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/a")).click();
		//Enter the Required option of Standard Entry Class Code
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys("CCD");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the	Credit/Debit option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/a")).click();
		//Enter the Required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys("Debit");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Zipcode");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Zipcode");
			
			Thread.sleep(3000);//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[3]/td[7]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount(Zipcode) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount(Zipcode) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee(Zipcode) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee(Zipcode) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee(Zipcode) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee(Zipcode) is Incorrect");
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Zipcode");
		}
		Thread.sleep(3000);
	}
		
	@Test(priority=34)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_ACH_Report_Store_With_ExcludeLoyaltyRedemtion(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Stores");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Store"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1500);
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input")).isSelected()){}
		else
		{
		//Enable the ExcludeLoyaltyRedemtion button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input")).click();
		}
		
		Thread.sleep(1000);
		//Click the Standard Entry Class Code Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/a")).click();
		//Enter the Required option of Standard Entry Class Code
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys("CCD");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the	Credit/Debit option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/a")).click();
		//Enter the Required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys("Debit");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Store");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Store(With Exclude Loyalty Redemtion)");
			
			Thread.sleep(3000);//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[3]/td[7]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount for Store(With Exclude Loyalty Redemtion) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount for Store(With Exclude Loyalty Redemtion) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee for Store(With Exclude Loyalty Redemtion) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee for Store(With Exclude Loyalty Redemtion) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee for Store(With Exclude Loyalty Redemtion) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee for Store(With Exclude Loyalty Redemtion) is Incorrect");
			}
				
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Store");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=35)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_ACH_Report_Group_With_ExcludeLoyaltyRedemtion(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Group"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1500);
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input")).isSelected()){}
		else
		{
		//Enable the ExcludeLoyaltyRedemtion button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input")).click();
		}
		
		Thread.sleep(1000);
		//Click the Standard Entry Class Code Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/a")).click();
		//Enter the Required option of Standard Entry Class Code
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys("CCD");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the	Credit/Debit option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/a")).click();
		//Enter the Required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys("Credit");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
				
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Group");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Group(With Exclude Loyalty Redemtion)");
			
			Thread.sleep(3000);//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[3]/td[7]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount for Group(With Exclude Loyalty Redemtion) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount for Group(With Exclude Loyalty Redemtion) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee for Group(With Exclude Loyalty Redemtion) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee for Group(With Exclude Loyalty Redemtion) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee for Group(With Exclude Loyalty Redemtion) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee for Group(With Exclude Loyalty Redemtion) is Incorrect");
			}
				
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Group");
		}
		Thread.sleep(3000);
	}

	@Test(priority=36)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_ACH_Report_City_With_ExcludeLoyaltyRedemtion(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("City");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("City"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1500);
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input")).isSelected()){}
		else
		{
		//Enable the ExcludeLoyaltyRedemtion button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input")).click();
		}
		
		Thread.sleep(1000);
		//Click the Standard Entry Class Code Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/a")).click();
		//Enter the Required option of Standard Entry Class Code
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys("CCD");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the	Credit/Debit option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/a")).click();
		//Enter the Required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys("Both");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for City");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for City(With Exclude Loyalty Redemtion)");
			
			Thread.sleep(3000);//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[3]/td[7]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount for City(With Exclude Loyalty Redemtion) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount for City(With Exclude Loyalty Redemtion) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee for City(With Exclude Loyalty Redemtion) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee for City(With Exclude Loyalty Redemtion) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee for City(With Exclude Loyalty Redemtion) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee for City(With Exclude Loyalty Redemtion) is Incorrect");
			}
				
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for City");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=37)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_ACH_Report_State_With_ExcludeLoyaltyRedemtion(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("State");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("State"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1500);
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input")).isSelected()){}
		else
		{
		//Enable the ExcludeLoyaltyRedemtion button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input")).click();
		}
		
		Thread.sleep(1000);
		//Click the Standard Entry Class Code Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/a")).click();
		//Enter the Required option of Standard Entry Class Code
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys("PPD");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the	Credit/Debit option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/a")).click();
		//Enter the Required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys("Debit");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for State");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for State(With Exclude Loyalty Redemtion)");
			
			Thread.sleep(2000);
			Thread.sleep(3000);//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[3]/td[7]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount for State(With Exclude Loyalty Redemtion) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount for State(With Exclude Loyalty Redemtion) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee for State(With Exclude Loyalty Redemtion) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee for State(With Exclude Loyalty Redemtion) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee for State(With Exclude Loyalty Redemtion) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee for State(With Exclude Loyalty Redemtion) is Incorrect");
			}
				
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for state");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=38)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_ACH_Report_Zipcode_With_ExcludeLoyaltyRedemtion(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Zip code");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Zipcode"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1500);
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input")).isSelected()){}
		else
		{
		//Enable the ExcludeLoyaltyRedemtion button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input")).click();
		}
		
		Thread.sleep(1000);
		//Click the Standard Entry Class Code Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/a")).click();
		//Enter the Required option of Standard Entry Class Code
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys("PPD");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the	Credit/Debit option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/a")).click();
		//Enter the Required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys("Credit");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available  for Zipcode");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Zipcode(With Exclude Loyalty Redemtion)");
			
			Thread.sleep(3000);//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[3]/td[7]")).getText();
			//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[3]/td[7]
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount for Zipcode(With Exclude Loyalty Redemtion) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount for Zipcode(With Exclude Loyalty Redemtion) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee for Zipcode(With Exclude Loyalty Redemtion) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee for Zipcode(With Exclude Loyalty Redemtion) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee for Zipcode(With Exclude Loyalty Redemtion) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee for Zipcode(With Exclude Loyalty Redemtion) is Incorrect");
			}
				
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Zipcode");
		}
		Thread.sleep(3000);
	}

	@Test(priority=39)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_ACH_Report_Zipcode_With_ExcludeLoyaltyRedemtion_PPD_Both(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Zip code");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Zipcode"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1500);
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input")).isSelected()){}
		else
		{
		//Enable the ExcludeLoyaltyRedemtion button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input")).click();
		}
		
		Thread.sleep(1000);
		//Click the Standard Entry Class Code Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/a")).click();
		//Enter the Required option of Standard Entry Class Code
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys("PPD");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the	Credit/Debit option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/a")).click();
		//Enter the Required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys("Both");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available  for Zipcode");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Zipcode(With Exclude Loyalty Redemtion)");
			
			Thread.sleep(3000);//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[3]/td[7]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount for Zipcode(With Exclude Loyalty Redemtion) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount for Zipcode(With Exclude Loyalty Redemtion) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee for Zipcode(With Exclude Loyalty Redemtion) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee for Zipcode(With Exclude Loyalty Redemtion) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee for Zipcode(With Exclude Loyalty Redemtion) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee for Zipcode(With Exclude Loyalty Redemtion) is Incorrect");
			}
				
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Zipcode");
		}
		Thread.sleep(3000);
	}
}
