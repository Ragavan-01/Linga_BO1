package reportsWithoutActualTax;

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

public class Verify_Cashier_Report {
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Verify_Cashier_Report");
	
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
	    	test.log(LogStatus.PASS, "User Logged out Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "User Logged out Failed");
		}
		Thread.sleep(5000);
		//Close the Browser
		driver.close();
	}
	
	@Test(priority=2)
	public void open_Cashier_Out_Report() throws Exception
	{
		//Click the Reports option
		driver.findElement(By.xpath("//span[.='Reports']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Sale']"));
		//Scroll the page till the Sale option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Sale Option		
		driver.findElement(By.xpath("//span[.='Sale']")).click();
		Thread.sleep(5000);
		//Check Sale Report page opened or not
		if(driver.findElement(By.xpath("//a[.='Sale report']")).getText().equalsIgnoreCase("Sale report"))
		{
			test.log(LogStatus.PASS, "Sale report page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sale report page loaded Failed");
		}
		
		Thread.sleep(4000);
		
		//Click the Cashier Out Report
		driver.findElement(By.xpath("//span[.=' Cashier out ']")).click();
		Thread.sleep(3000);
		
		//Check weather the Cashier Out Report page is loaded or not
		if(driver.findElement(By.xpath("//li[@class='uib-tab nav-item ng-isolate-scope active']/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Cashier out"))
		{
			test.log(LogStatus.PASS, "Cashier Out Report page loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Cashier Out Report page loaded fail");
		}

		Thread.sleep(5000);

	}	
	
	@Test(priority=3)
	public void cashier_Out_Report() throws Exception
	{

		Thread.sleep(3000);
		//Click the Employee option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		//Enter the required employee
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Click the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
		//Enter the date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		

		Thread.sleep(2000);
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
		//Enter the date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(2000);
		//Click the Run Button
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
		}
		else
		{
			test.log(LogStatus.FAIL, "Check Stats field is not available");
		}

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
	        
			else if(expect1 == unknownValue)
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
	        	float different = actual - expect1;
	        	
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
}
