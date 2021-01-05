package reportsWithoutActualTax;

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

public class Verify_DailyTender_Report {

	public WebDriver driver;

		ExtentReports rep = ExtentManager.getInstance();
		ExtentTest test = rep.startTest("Verify_DailyTender_Report");
		
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
		//Click the login button
		driver.findElement(By.name("submitlogin")).click();
		//Check if we logged in or not
		if(driver.findElement(By.xpath("//span[.='Live Updates']")).getText().equalsIgnoreCase("Live Updates"))
		{
			test.log(LogStatus.PASS, "User Logged in Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "User Logged in Failed");
		}
		Thread.sleep(5000);
	}

	@Test(priority=30)
	public void logout() throws InterruptedException
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
		Thread.sleep(5000);
	   //Check whether user get logged out or not
		if(driver.findElement(By.xpath("//div[@id='x-content-band-1']/div/div[2]/h2")).getText().equalsIgnoreCase("Account Login"))
		{
	    	test.log(LogStatus.PASS,"User Logged out Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"User Logged out Failed");
		}
		Thread.sleep(5000);
		//Close the Browser
		driver.close();
	}

	@Test(priority=2)
	public void viewDailyTenderReport() throws Exception
	{
		//Click the Reports option
		driver.findElement(By.xpath("//span[.='Reports']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Daily Tender']"));
		//Scroll the page till the Daily Tender option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Daily Tender Option		
		driver.findElement(By.xpath("//span[.='Daily Tender']")).click();
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
	
	@Test(priority=3)
	public void verifyDailyTenderReport() throws Exception
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
	    
//The Below Code is for Customer Store in Live URL of Daily Tender Report of Last N Days - 1000
	
	
/*		@Test(priority=1)
		public void login() throws Exception
		{
			//Open the Firefox Browser
			driver = new FirefoxDriver();
			//Wait for 30 seconds
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//Maximize the Firefox window
			driver.manage().window().maximize();
			//Launch the URL
			driver.get("https://www.lingapos.com/signin/");
			
			//Create the web element
		    WebElement html = driver.findElement(By.tagName("html"));
		  	//Zoom out the window
		  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			
			//Clear the text from the user name text box
			driver.findElement(By.name("txtusername")).clear();
			//Enter the user name
			driver.findElement(By.name("txtusername")).sendKeys("customerstore@mail.com");
			//Clear the password from the password text box
			driver.findElement(By.name("txtpassword")).clear();
			//Enter the password
			driver.findElement(By.name("txtpassword")).sendKeys("customer1");
			//Click the login button
			driver.findElement(By.name("submitlogin")).click();
			
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[4]/div/div[1]/div[2]/div/div[1]/a/h5")).click();

		}

		@Test(priority=30)
		public void logout() throws InterruptedException
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
			Thread.sleep(5000);
		   //Check whether user get logged out or not
			if(driver.findElement(By.xpath("//div[@id='x-content-band-1']/div/div[2]/h2")).getText().equalsIgnoreCase("Account Login"))
			{
		    	test.log(LogStatus.PASS,"User Logged out Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"User Logged out Failed");
			}
			Thread.sleep(5000);
			//Close the Browser
			driver.close();
		}

		@Test(priority=2)
		public void viewDailyTenderReport() throws Exception
		{
			//Click the Reports option
			driver.findElement(By.xpath("//span[.='Reports']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Daily Tender']"));
			//Scroll the page till the Daily Tender option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
	        //Click the Daily Tender Option		
			driver.findElement(By.xpath("//span[.='Daily Tender']")).click();
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
		
		@Test(priority=3)
		public void verifyDailyTenderReport() throws Exception
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
		  	
			Thread.sleep(5000);
			//Select the Time Period option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		    //Enter the required Period of time for Specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("Last 'N' days");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    
		   //Clear the Date Field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/input")).clear();
		   //Enter the specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/input")).sendKeys("1000");
		    
		    //Click the Run
		    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		    Thread.sleep(8000);

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
		    
		}*/
	}
