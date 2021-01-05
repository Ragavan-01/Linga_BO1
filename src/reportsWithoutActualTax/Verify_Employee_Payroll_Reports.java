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


public class Verify_Employee_Payroll_Reports {
public WebDriver driver;

ExtentReports rep = ExtentManager.getInstance();
ExtentTest test = rep.startTest("Verify_Employee_Payroll_Reports");

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
public void viewEmployeePayrollDailyReport() throws Exception
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
	Thread.sleep(5000);
	//Check Attendance Report page opened or not
	if(driver.findElement(By.xpath("//a[.='Attendance']")).getText().equalsIgnoreCase("Attendance"))
	{
		test.log(LogStatus.PASS,"Attendance Report page loaded Successfully");
	}
	else
	{
		test.log(LogStatus.FAIL,"Attendance Report page loaded Failed");
	}
	Thread.sleep(3000);
	//Click the Payroll option
	driver.findElement(By.xpath("//span[.=' Payroll ']")).click();
	
	//Check Payroll Report page opened or not
	if(driver.findElement(By.xpath("//a[.='Payroll']")).getText().equalsIgnoreCase("Payroll"))
	{
		test.log(LogStatus.PASS,"Payroll Report page loaded Successfully");
	}
	else
	{
		test.log(LogStatus.FAIL,"Payroll Report page loaded Failed");
	}
	
}

	@Test(priority=3)
	public void verifyEmployeePayrollDailyReport() throws Exception
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
				test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
			}
			
			else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
			{
				
				test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
				
				System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
				
				test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");
				
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
				
				//Get the hours Value
				String hours = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[3]")).getText();
				
				System.out.println("Total Hours is : "+hours);
				
				test.log(LogStatus.INFO, "Total Hours is : "+hours);
				
				//Get the OT Hours Value
				String ot_hours = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
				
				System.out.println("Total OT Hours is : "+ot_hours);
				
				test.log(LogStatus.INFO, "Total OT Hours is : "+ot_hours);
				
				//Get the Reg Pay Value
				String reg_Pay = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
				
				System.out.println("Total Reg Pay is : "+reg_Pay);
				
				test.log(LogStatus.INFO, "Total Reg Pay is : "+reg_Pay);
				
				//Get the TTL Pay Value
				String ttl_Pay = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
				
				System.out.println("Total TTL PAY is : "+ttl_Pay);
				
				test.log(LogStatus.INFO, "Total TTL PAY is : "+ttl_Pay);
				
				//Get the expected tip value
				String expected_Tip = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[7]")).getText();
				
				System.out.println("Total Expected is : "+expected_Tip);
				
				test.log(LogStatus.INFO, "Total Expected is : "+expected_Tip);
				
				//Get the non_Cash Tip
				String non_Cash_Tip = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[8]")).getText();
				
				System.out.println("Total Non Cash Tip is : "+non_Cash_Tip);
				
				test.log(LogStatus.INFO, "Total Non Cash Tip is : "+non_Cash_Tip);
				
				//Get the Declared Cash Tip
				String declared_Cash_Tip = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[9]")).getText();
				
				System.out.println("Total Declared Cash Tip is : "+declared_Cash_Tip);
				
				test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declared_Cash_Tip);
			}
			
			else
			{
				test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
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
					test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "Employee Payroll Report(In Hours and Daily) is available for Specific Date");
					
					System.out.println("******* The Below is Employee Payroll Report for In Hours(Daily) *******");
					
					test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Daily) *******");
					
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
					
					//Get the hours Value
					String hours = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[3]")).getText();
					
					System.out.println("Total Hours is : "+hours);
					
					test.log(LogStatus.INFO, "Total Hours is : "+hours);
					
					//Get the OT Hours Value
					String ot_hours = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
					
					System.out.println("Total OT Hours is : "+ot_hours);
					
					test.log(LogStatus.INFO, "Total OT Hours is : "+ot_hours);
					
					//Get the Reg Pay Value
					String reg_Pay = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					System.out.println("Total Reg Pay is : "+reg_Pay);
					
					test.log(LogStatus.INFO, "Total Reg Pay is : "+reg_Pay);
					
					//Get the TTL Pay Value
					String ttl_Pay = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
					
					System.out.println("Total TTL PAY is : "+ttl_Pay);
					
					test.log(LogStatus.INFO, "Total TTL PAY is : "+ttl_Pay);
					
					//Get the expected tip value
					String expected_Tip = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[7]")).getText();
					
					System.out.println("Total Expected is : "+expected_Tip);
					
					test.log(LogStatus.INFO, "Total Expected is : "+expected_Tip);
					
					//Get the non_Cash Tip
					String non_Cash_Tip = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[8]")).getText();
					
					System.out.println("Total Non Cash Tip is : "+non_Cash_Tip);
					
					test.log(LogStatus.INFO, "Total Non Cash Tip is : "+non_Cash_Tip);
					
					//Get the Declared Cash Tip
					String declared_Cash_Tip = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[9]")).getText();
					
					System.out.println("Total Declared Cash Tip is : "+declared_Cash_Tip);
					
					test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declared_Cash_Tip);
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
				}  
	}
	
	@Test(priority=4)
	public void viewEmployeePayrollWeeklyReport() throws Exception
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
	    

		
		
	    Thread.sleep(3000);
	    //Clear the Date field
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
	    //Enter the Date
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

	    Thread.sleep(1000);
	    //Clear the Date field
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
	    //Enter the Date
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
	    Thread.sleep(1000);
	    
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
			test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			
			test.log(LogStatus.PASS, "Employee Payroll Report(In Hours and Weekly) is available for Specific Date");
			
			System.out.println("******* The Below is Employee Payroll Report for In Hours(Weekly) *******");
			
			test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Weekly) *******");
			
			List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
			
			//Get the Reg Pay Value
			String reg_Pay = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[2]")).getText();
			
			System.out.println("Total Reg Pay is : "+reg_Pay);
			
			test.log(LogStatus.INFO, "Total Reg Pay is : "+reg_Pay);
			
			//Get the TTL Pay Value
			String ttl_Pay = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[3]")).getText();
			
			System.out.println("Total TTL PAY is : "+ttl_Pay);
			
			test.log(LogStatus.INFO, "Total TTL PAY is : "+ttl_Pay);
			
			//Get the Working Hours Value
			String working_Hours = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
			
			System.out.println("Total Working Hours is : "+working_Hours);
			
			test.log(LogStatus.INFO, "Total Working Hours is : "+working_Hours);
			
			//Get the OT Hours Value
			String ot_Hours = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
			
			System.out.println("Total OT Hours is : "+ot_Hours);
			
			test.log(LogStatus.INFO, "Total OT Hours is : "+ot_Hours);
			
			//Get the expected tip value
			String expected_Tip = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
			
			System.out.println("Total Expected Cash Tip is : "+expected_Tip);
			
			test.log(LogStatus.INFO, "Total Expected Cash Tip is : "+expected_Tip);
			
			//Get the credit card cash Tip
			String credit_Card_Cash_Tip = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[7]")).getText();
			
			System.out.println("Total Credit Card Cash Tip is : "+credit_Card_Cash_Tip);
			
			test.log(LogStatus.INFO, "Total Credit Card Cash Tip is : "+credit_Card_Cash_Tip);
			
			//Get the Declared Cash Tip
			String declared_Cash_Tip = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[8]")).getText();
			
			System.out.println("Total Declared Cash Tip is : "+declared_Cash_Tip);
			
			test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declared_Cash_Tip);
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
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
			
	    for(int i = 1; i <= 4; i++)
	    {
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(3000);
	    }
	    
	    Thread.sleep(1000);
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
	    Thread.sleep(1000);
	    
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
			test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			
			test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Weekly) is available for Specific Date");
			
			System.out.println("******* The Below is Employee Payroll Report for In Time(Weekly) *******");
			
			test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Weekly) *******");
			
			List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
			
			//Get the Reg Pay Value
			String reg_Pay = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[2]")).getText();
			
			System.out.println("Total Reg Pay is : "+reg_Pay);
			
			test.log(LogStatus.INFO, "Total Reg Pay is : "+reg_Pay);
			
			//Get the TTL Pay Value
			String ttl_Pay = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[3]")).getText();
			
			System.out.println("Total TTL PAY is : "+ttl_Pay);
			
			test.log(LogStatus.INFO, "Total TTL PAY is : "+ttl_Pay);
			
			//Get the Working Hours Value
			String working_Hours = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
			
			System.out.println("Total Working Hours is : "+working_Hours);
			
			test.log(LogStatus.INFO, "Total Working Hours is : "+working_Hours);
			
			//Get the OT Hours Value
			String ot_Hours = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
			
			System.out.println("Total OT Hours is : "+ot_Hours);
			
			test.log(LogStatus.INFO, "Total OT Hours is : "+ot_Hours);
			
			//Get the expected tip value
			String expected_Tip = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
			
			System.out.println("Total Expected Cash Tip is : "+expected_Tip);
			
			test.log(LogStatus.INFO, "Total Expected Cash Tip is : "+expected_Tip);
			
			//Get the credit card cash Tip
			String credit_Card_Cash_Tip = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[7]")).getText();
			
			System.out.println("Total Credit Card Cash Tip is : "+credit_Card_Cash_Tip);
			
			test.log(LogStatus.INFO, "Total Credit Card Cash Tip is : "+credit_Card_Cash_Tip);
			
			//Get the Declared Cash Tip
			String declared_Cash_Tip = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[8]")).getText();
			
			System.out.println("Total Declared Cash Tip is : "+declared_Cash_Tip);
			
			test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declared_Cash_Tip);
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
		} 
	
	}

	}
