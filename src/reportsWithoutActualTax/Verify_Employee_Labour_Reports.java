package reportsWithoutActualTax;

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

import epicList_Chrome.Utility;

public class Verify_Employee_Labour_Reports{
	
	public WebDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Verify_Employee_Labour_Reports");
	
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

	@Test(priority=40)
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
		Thread.sleep(1000);
	   //Check whether user get logged out or not
		if(driver.findElement(By.xpath("//div[@id='x-content-band-1']/div/div[2]/h2")).getText().equalsIgnoreCase("Account Login"))
		{
			test.log(LogStatus.PASS,"User Logged out Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"User Logged out Failed");			
		}
		Thread.sleep(1000);
		//Close the Browser
		driver.close();
	}

	@Test(priority=2)
	public void viewEmployeeLabourDailyReport() throws Exception
	{
		//Click the Reports option
		driver.findElement(By.xpath("//span[.='Reports']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Employee']"));
		//Scroll the page till the Transaction option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Employee Option		
		driver.findElement(By.xpath("//span[.='Employee']")).click();
		Thread.sleep(1000);
		//Check Labour Report page opened or not
		if(driver.findElement(By.xpath("//a[.='Attendance']")).getText().equalsIgnoreCase("Attendance"))
		{
			test.log(LogStatus.PASS,"Attendance Report page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"Attendance Report page loaded Failed");
		}
		Thread.sleep(3000);
		//Click the Labour option
		driver.findElement(By.xpath("//span[.=' Labour']")).click();
		
		//Check Labour Report page opened or not
		if(driver.findElement(By.xpath("//a[.='Labour']")).getText().equalsIgnoreCase("Labour"))
		{
			test.log(LogStatus.PASS,"Labour Report page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"Labour Report page loaded Failed");
		}
		
	}
	
	@Test(priority=3)
	public void verifyEmployeeLabourDailyReport() throws Exception
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
		//Select the Employee option
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
	    //Enter the required Employee
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
	    //Press the Enter key
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(3000);
	    //Select the Process as Daily
		Select process = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/select")));
		process.selectByVisibleText("Daily");                               
	    
  	    //Thread.sleep(1000);
	    //Select the Specific date Time Period option
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/a")).click();
	    //Enter the required Period of time
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
	    //Press the Enter key
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(1000);
	    //Clear the Date field
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
	    //Enter the Date
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

	    Thread.sleep(1000);
	    //Clear the Date field
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
	    //Enter the Date
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		  
		    //Select the Format option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/a")).click();
		    //Enter the required Format
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/div/div/input")).sendKeys("In Time");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		  
		    
		    //Click the Run
		    driver.findElement(By.xpath("//button[@type='submit']")).click();
		    Thread.sleep(1000);
		   
			//Check weather the report is available for the selected time period
			if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Employee Labour Report is not available for Specific Date");
			}
			
			else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[2]")).getText() != null)
			{
				
				test.log(LogStatus.PASS, "Employee Labour Report(In Time and Daily) is available for Specific Date");
				
				System.out.println("******* The Below is Employee Labour Report for In Time(Daily) *******");
				
				test.log(LogStatus.INFO, "******* The Below is Employee Labour Report for In Time(Daily) *******");
				
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
				
				//Get the Net Sales Value
				String net_Sales = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[2]")).getText();
				
				System.out.println("Total Net Sales is : "+net_Sales);
				
				test.log(LogStatus.INFO, "Total Net Sales is : "+net_Sales);
				
				//Get the Hours Value
				String hours = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[3]")).getText();
				
				System.out.println("Total Hours is : "+hours);
				
				test.log(LogStatus.INFO, "Total Hours is : "+hours);
				
				//Get the Labour Value
				String labour = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
				
				System.out.println("Total Labour is : "+labour);
				
				test.log(LogStatus.INFO, "Total Labour is : "+labour);
				
				//Get the Percentage of Net Sales Value
				String percentage_Of_Net_Sales = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
				
				System.out.println("Total Percentage of Net Sales is : "+percentage_Of_Net_Sales);
				
				test.log(LogStatus.INFO, "Total Percentage of Net Sales is : "+percentage_Of_Net_Sales);
				
				//Get the Labour Percentage
				String labour_Percentage = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
				
				System.out.println("Total Labour Percentage is : "+labour_Percentage);
				
				test.log(LogStatus.INFO, "Total Labour Percentage is : "+labour_Percentage);
			}
			
			else
			{
				test.log(LogStatus.FAIL, "Employee Labour Report is not available for Specific Date");
			}  
	  	    	
			
			Thread.sleep(1000);
			//Select the Employee option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		    //Enter the required Employee
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    
		    Thread.sleep(3000);
		    //Select the Process as Daily
			Select process1 = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/select")));
			process1.selectByVisibleText("Daily");                               
		    
	  	    //Thread.sleep(1000);
	    //Select the Specific date Time Period option
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/a")).click();
	    //Enter the required Period of time
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
	    //Press the Enter key
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(1000);
	    //Clear the Date field
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
	    //Enter the Date
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

	    Thread.sleep(1000);
	    //Clear the Date field
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
	    //Enter the Date
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			  
			    //Select the Format option
			    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/div/div/input")).sendKeys("In Hours");
			    //Press the Enter key
			    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			  
			    
			    //Click the Run
			    driver.findElement(By.xpath("//button[@type='submit']")).click();
			    Thread.sleep(1000);
			   
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Employee Labour Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[2]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "Employee Labour Report(In Hours and Daily) is available for Specific Date");
					
					System.out.println("******* The Below is Employee Labour Report for In Hours(Daily) *******");
					
					test.log(LogStatus.INFO, "******* The Below is Employee Labour Report for In Hours(Daily) *******");
					
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
					
					//Get the Net Sales Value
					String net_Sales = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[2]")).getText();
					
					System.out.println("Total Net Sales is : "+net_Sales);
					
					test.log(LogStatus.INFO, "Total Net Sales is : "+net_Sales);
					
					//Get the Hours Value
					String hours = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[3]")).getText();
					
					System.out.println("Total Hours is : "+hours);
					
					test.log(LogStatus.INFO, "Total Hours is : "+hours);
					
					//Get the Labour Value
					String labour = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
					
					System.out.println("Total Labour is : "+labour);
					
					test.log(LogStatus.INFO, "Total Labour is : "+labour);
					
					//Get the Percentage of Net Sales Value
					String percentage_Of_Net_Sales = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					System.out.println("Total Percentage of Net Sales is : "+percentage_Of_Net_Sales);
					
					test.log(LogStatus.INFO, "Total Percentage of Net Sales is : "+percentage_Of_Net_Sales);
					
					//Get the Labour Percentage
					String labour_Percentage = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
					
					System.out.println("Total Labour Percentage is : "+labour_Percentage);
					
					test.log(LogStatus.INFO, "Total Labour Percentage is : "+labour_Percentage);
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Employee Labour Report is not available for Specific Date");
				}  
	}

	@Test(priority=4)
	public void viewEmployeeLabourWeeklyReport() throws Exception
	{

		
		Thread.sleep(1000);
		//Select the Employee option
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
	    //Enter the required Employee
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
	    //Press the Enter key
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	  
	    //Select the Process as Daily
		Select process = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/select")));
		process.selectByVisibleText("Weekly");
			
  	    //Thread.sleep(1000);
	    //Select the Specific date Time Period option
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/a")).click();
	    //Enter the required Period of time
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
	    //Press the Enter key
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(1000);
	    //Clear the Date field
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
	    //Enter the Date
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

	    Thread.sleep(1000);
	    //Clear the Date field
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
	    //Enter the Date
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
	    
	    //Select the Format option
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/a")).click();
	    //Enter the required Format
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/div/div/input")).sendKeys("In Hours");
	    //Press the Enter key
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(1000);
	     //Click the Run
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(1000);

		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Employee Labour Report is not available for Specific Date");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[2]")).getText() != null)
		{
			
			test.log(LogStatus.PASS, "Employee Labour Report(In Hours and Weekly) is available for Specific Date");
			
			System.out.println("******* The Below is Employee Labour Report for In Hours(Weekly) *******");
			
			test.log(LogStatus.INFO, "******* The Below is Employee Labour Report for In Hours(Weekly) *******");
			
			List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
			
			//Get the Net Sales Value
			String net_Sales = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[2]")).getText();
			
			System.out.println("Total Net Sales is : "+net_Sales);
			
			test.log(LogStatus.INFO, "Total Net Sales is : "+net_Sales);
			
			//Get the Hours Value
			String hours = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[3]")).getText();
			
			System.out.println("Total Hours is : "+hours);
			
			test.log(LogStatus.INFO, "Total Hours is : "+hours);
			
			//Get the Labour Value
			String labour = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
			
			System.out.println("Total Labour is : "+labour);
			
			test.log(LogStatus.INFO, "Total Labour is : "+labour);
			
			//Get the Percentage of Net Sales Value
			String percentage_Of_Net_Sales = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
			
			System.out.println("Total Percentage of Net Sales is : "+percentage_Of_Net_Sales);
			
			test.log(LogStatus.INFO, "Total Percentage of Net Sales is : "+percentage_Of_Net_Sales);
			
			//Get the Labour Percentage
			String labour_Percentage = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
			
			System.out.println("Total Labour Percentage is : "+labour_Percentage);
			
			test.log(LogStatus.INFO, "Total Labour Percentage is : "+labour_Percentage);
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Employee Labour Report is not available for Specific Date");
		}  
		
		Thread.sleep(1000);
		//Select the Employee option
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
	    //Enter the required Employee
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
	    //Press the Enter key
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	  
	    //Select the Process as Daily
		Select process1 = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/select")));
		process1.selectByVisibleText("Weekly");
			
	    Thread.sleep(1000);
	    //Select the Specific date Time Period option
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/a")).click();
	    //Enter the required Period of time
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
	    //Press the Enter key
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(1000);
	    //Clear the Date field
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
	    //Enter the Date
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

	    Thread.sleep(1000);
	    //Clear the Date field
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
	    //Enter the Date
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
	    
	    //Select the Format option
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/a")).click();
	    //Enter the required Format
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/div/div/input")).sendKeys("In Time");
	    //Press the Enter key
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(1000);
	     //Click the Run
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(1000);
	    
	    
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Employee Labour Report is not available for Specific Date");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[2]")).getText() != null)
		{
			
			test.log(LogStatus.PASS, "Employee Labour Report(In Time and Weekly) is available for Specific Date");
			
			System.out.println("******* The Below is Employee Labour Report for In Time(Weekly) *******");
			
			test.log(LogStatus.INFO, "******* The Below is Employee Labour Report for In Time(Weekly) *******");
			
			List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
			
			//Get the Net Sales Value
			String net_Sales = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[2]")).getText();
			
			System.out.println("Total Net Sales is : "+net_Sales);
			
			test.log(LogStatus.INFO, "Total Net Sales is : "+net_Sales);
			
			//Get the Hours Value
			String hours = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[3]")).getText();
			
			System.out.println("Total Hours is : "+hours);
			
			test.log(LogStatus.INFO, "Total Hours is : "+hours);
			
			//Get the Labour Value
			String labour = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
			
			System.out.println("Total Labour is : "+labour);
			
			test.log(LogStatus.INFO, "Total Labour is : "+labour);
			
			//Get the Percentage of Net Sales Value
			String percentage_Of_Net_Sales = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
			
			System.out.println("Total Percentage of Net Sales is : "+percentage_Of_Net_Sales);
			
			test.log(LogStatus.INFO, "Total Percentage of Net Sales is : "+percentage_Of_Net_Sales);
			
			//Get the Labour Percentage
			String labour_Percentage = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
			
			System.out.println("Total Labour Percentage is : "+labour_Percentage);
			
			test.log(LogStatus.INFO, "Total Labour Percentage is : "+labour_Percentage);
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Employee Labour Report is not available for Specific Date");
		} 

	}

}
