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

public class Verify_Enterprise_SaleRecap_Report {



	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Verify_Enterprise_SaleRecap_Report");

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
	public void open_Enterprise_SaleRecap_Report() throws Exception
	{
		//Click the My Stores option
		driver.findElement(By.xpath("//span[.='My Stores']")).click();

		Thread.sleep(3000);
        //Click the EnterPrise Reports Option		
		driver.findElement(By.xpath("//span[.='EnterPrise Reports']")).click();
		
		Thread.sleep(2000);
		//Click the Sale option
		driver.findElement(By.xpath("//span[.='Sale']")).click();
		
		Thread.sleep(2000);
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
		Thread.sleep(2000);
		//Click the SaleRecap Sale option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/div/div/ul/li[9]/a/uib-tab-heading/span")).click();
		
		Thread.sleep(5000);
		//Check SaleRecap Report page opened or not
		if(driver.findElement(By.xpath("//li[@class='uib-tab nav-item ng-isolate-scope active']/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Sale Recap"))
		{
			test.log(LogStatus.PASS, "SaleRecap Sale Report page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "SaleRecap Sale Report page loaded Failed");
		}
		
		Thread.sleep(3000);
		
	}
	
	@Test(priority=4)
	public void view_Enterprise_SaleRecap_Report_Non_Close_Sales() throws Exception
	{


		Thread.sleep(3000);
		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/input")).sendKeys("Store 01");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1500);
		//Click the Select reacp Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/a")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/input")).sendKeys("Non close sales");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1500);
		//Click the Employee Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("******************** Sale Recap Type as Non Close Sales ********************************");
		test.log(LogStatus.INFO, "******************** Sale Recap Type as Non Close Sales ********************************");
		
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
		System.out.println("******************** End of Sale Recap Type as Non Close Sales ********************************");
		test.log(LogStatus.INFO, "******************** End of Sale Recap Type as Non Close Sales ********************************");
	}
	
	
	@Test(priority=4)
	public void view_Enterprise_SaleRecap_Report_Timeperiod() throws Exception
	{


		Thread.sleep(3000);
		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/input")).sendKeys("Store 01");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1500);
		//Click the Select reacp Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/a")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/input")).sendKeys("Time period");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1500);
		//Click the Employee Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(3000);
		//Click the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/input[1]")).clear();
		//Enter the date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

		Thread.sleep(2000);
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/input[2]")).clear();
		//Enter the date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));

		
		Thread.sleep(1000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("******************** Sale Recap Type as Time Period ********************************");
		test.log(LogStatus.INFO, "******************** Sale Recap Type as Time Period ********************************");
		
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
		
		System.out.println("******************** End of Sale Recap Type as Time Period ********************************");
		test.log(LogStatus.INFO, "******************** End of Sale Recap Type as Time Period ********************************");
		
	}
	

}
