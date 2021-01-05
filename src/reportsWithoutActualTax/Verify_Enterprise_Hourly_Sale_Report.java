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

public class Verify_Enterprise_Hourly_Sale_Report {


	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Verify_Enterprise_Hourly_Sale_Report");

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
	public void open_Enterprise_Hourly_Report() throws Exception
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
		//Click the Hourly Sale option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/div/div/ul/li[7]/a/uib-tab-heading/span")).click();
		
		Thread.sleep(5000);
		//Check Hourly Report page opened or not
		if(driver.findElement(By.xpath("//li[@class='uib-tab nav-item ng-isolate-scope active']/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Hourly Sale"))
		{
			test.log(LogStatus.PASS, "Hourly Sale Report page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Hourly Sale Report page loaded Failed");
		}
		
		Thread.sleep(3000);
		
	}
	
	@Test(priority=4)
	public void view_Enterprise_Hourly_Sale_Report_Stores() throws Exception
	{

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
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Stores");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1500);
		//Click the Select Some Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Store"));
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1500);
		//Click the Time Period Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/a")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		try
		{
			Thread.sleep(3000);
			//Check weather the report is available for the selected time period
			if(!driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Hourly Sale Report available for Specific Date");
				
				Thread.sleep(3000);
				//Check Weather the Top 5 hourly sale available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Here Top 5 Hourly Sale Report available for Specific Date");
					
					Thread.sleep(2000);
					//Click the down arrow button of chart type
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
					Thread.sleep(1000);
					
					//Click the Pie chart option
					driver.findElement(By.xpath("//a[.='Pie']")).click();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, "There is Pie Chart available");
					Thread.sleep(3000);
					
					Thread.sleep(2000);
					//Click the down arrow button of chart type
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
					Thread.sleep(1000);

					//Click the Polar Area chart option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/ul/li[2]/a")).click();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, "There is Polar Area Chart available");
					Thread.sleep(3000);
					
					Thread.sleep(2000);
					//Click the down arrow button of chart type
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
					Thread.sleep(1000);

					//Click the Bar chart option
					driver.findElement(By.xpath("//a[.='Bar']")).click();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, "There is Bar Chart available");
					Thread.sleep(3000);
				}
				else
				{
					test.log(LogStatus.FAIL, "Here Top 5 Hourly Sale Report not available for Specific Date");
				}
				
				Thread.sleep(5000);
				//Check weather the report graph is available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
				{
					test.log(LogStatus.PASS, "There is Graphical type of Hourly sale report is available for Specific Date");
				}
				else
				{
					test.log(LogStatus.FAIL, "Graphical report is not available for Specific Date");
				}
				
				Thread.sleep(5000);
				//Check weather the table format report is available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
					
					Thread.sleep(3000);
			        //No.of rows
			        List<WebElement> rows = driver.findElements(By.xpath ("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr"));
			        
	/*		        //Print number of Rows
			        System.out.println("Number of Rows are : "+rows);*/
			        
					//Replace all commo's with empty space
					String expected1 = Utility.getReportProperty("Sale_Report_Net_Sale").replace(",", "");
					
					//Convert the String value of the Sale_Report_Net_Sale element into float value
					float expect1 = Float.parseFloat(expected1); 

					//Replace all commo's with empty space
					String expected2 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
					
					//Convert the String value of the Sale_Report_Tax element into float value
					float expect2 = Float.parseFloat(expected2);  

					//Replace all commo's with empty space
					String expected3 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
					
					//Convert the String value of the Sale_Report_Discount element into float value
					float expect3 = Float.parseFloat(expected3);     	

					//Replace all commo's with empty space
					String expected4 = Utility.getReportProperty("Sale_Report_Grand_Sale").replace(",", "");
							
					//Convert the String value of the Sale_Report_Grand_Sale element into float value
					float expect4= Float.parseFloat(expected4);  
			        
		        	//Replace all commo's with empty space
		        	String expected5 = Utility.getReportProperty("Hourly_Sale_Report_Number_Of_Customer").replace(",", "");
		        	
		        	//Convert the String value of the Hourly_Sale_Report_Number_Of_Customer element into float value
		        	float expect5 = Float.parseFloat(expected5);  
			        
			        //Check weather the Net Sale is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Sale Amount");
			        	
			        	//Get the Total value of Sale Amount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Net Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Net Sale Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Net Sale Value is : "+ actual);
			        }
			        
					else if(expect1 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Net Sale
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

			        	System.out.println("The Actual Net Sale value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Net Sale value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Sale Amount");
			        	
			        	//Get the Total value of Sale Amount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the net sale amount Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        			        	
			        	//Get the different
			        	float different = actual - expect1;
			        	
			        	//Print the different value
			        	System.out.println("Net Sale Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Net Sale Value different is : "+different);	
			        }
			        
			        //Check weather the Tax Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Tax");
			        	
			        	//Get the Total value of Tax
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Tax Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Tax Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
			        }
			        
					else if(expect2 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Tax
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

			        	System.out.println("The Actual Tax value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Tax");
			        	
			        	//Get the Total value of Tax
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Tax Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect2;
			        	
			        	//Print the different value
			        	System.out.println("Tax Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
			        }
			        
			        
			        //Check weather the Discount Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Discount");
			        	
			        	//Get the Total value of Discount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Discount Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Discount Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
			        }
			        
					else if(expect3 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Discount
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

			        	System.out.println("The Actual Discount value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Discount");
			        	
			        	//Get the Total value of Discount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Discount Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect3;
			        	
			        	//Print the different value
			        	System.out.println("Discount Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
			        }
			        
			        
			        //Check weather the Grand Sale Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Grand Sale");
			        	
			        	//Get the Total value of Grand Sale
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");   	

			        	//Convert the String value of the Grand Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Grand Sale Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Grand Sale Value is : "+ actual);
			        }
			        
					else if(expect4 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Sale Report
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

			        	System.out.println("The Actual Grand Sale value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Grand Sale value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Grand Sale");
			        	
			        	//Get the Total value of Grand Sale
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Grand Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect4;
			        	
			        	//Print the different value
			        	System.out.println("Grand Sale Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Grand Sale Value different is : "+different);	
			        }
			        
			        
			        //Check weather the Number of Customer Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText().equals(Utility.getReportProperty("Hourly_Sale_Report_Number_Of_Customer")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Number of Customer");
			        	
			        	//Get the Total value of Number of Customer
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Number of Customer Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Number of Customer Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Number of Customer Value is : "+ actual);
			        }
			        
					else if(expect5 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Number of Customer
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();

			        	System.out.println("The Actual Number of Customer value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Number of Customer value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Number of Customer");
			        	
			        	//Get the Total value of Number of Customer
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Number of Customer Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect5;
			        	
			        	//Print the different value
			        	System.out.println("Number of Customer Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Number of Customer Value different is : "+different);	
			        }
				}
				else
				{
					test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date");
				}
			}
		}
		
		catch(Exception e)
		{

			test.log(LogStatus.FAIL, "Hourly Sale Report is not available for Specific Date");

		}
				
		Thread.sleep(3000);
		System.out.println("********************* End of Store Report *************************");
		test.log(LogStatus.INFO, "********************* End of Store Report *************************");

		
	}
	
	@Test(priority=5)
	public void view_Enterprise_Hourly_Sale_Report_Group() throws Exception
	{

		Thread.sleep(3000);
		System.out.println("********************* View The Group Report *************************");
		test.log(LogStatus.INFO, "********************* View The Group Report *************************");
		
		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1500);
		//Click the Select Some Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys("TestGroup");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1500);
		//Click the Time Period Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/a")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		try
		{
			Thread.sleep(3000);
			//Check weather the report is available for the selected time period
			if(!driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Hourly Sale Report available for Specific Date");
				
				Thread.sleep(3000);
				//Check Weather the Top 5 hourly sale available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Here Top 5 Hourly Sale Report available for Specific Date");
					
					Thread.sleep(2000);
					//Click the down arrow button of chart type
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
					Thread.sleep(1000);
					
					//Click the Pie chart option
					driver.findElement(By.xpath("//a[.='Pie']")).click();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, "There is Pie Chart available");
					Thread.sleep(3000);
					
					Thread.sleep(2000);
					//Click the down arrow button of chart type
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
					Thread.sleep(1000);

					//Click the Polar Area chart option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/ul/li[2]/a")).click();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, "There is Polar Area Chart available");
					Thread.sleep(3000);
					
					Thread.sleep(2000);
					//Click the down arrow button of chart type
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
					Thread.sleep(1000);

					//Click the Bar chart option
					driver.findElement(By.xpath("//a[.='Bar']")).click();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, "There is Bar Chart available");
					Thread.sleep(3000);
				}
				else
				{
					test.log(LogStatus.FAIL, "Here Top 5 Hourly Sale Report not available for Specific Date");
				}
				
				Thread.sleep(5000);
				//Check weather the report graph is available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
				{
					test.log(LogStatus.PASS, "There is Graphical type of Hourly sale report is available for Specific Date");
				}
				else
				{
					test.log(LogStatus.FAIL, "Graphical report is not available for Specific Date");
				}
				
				Thread.sleep(5000);
				//Check weather the table format report is available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
					
					Thread.sleep(3000);
			        //No.of rows
			        List<WebElement> rows = driver.findElements(By.xpath ("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr"));
			        
	/*		        //Print number of Rows
			        System.out.println("Number of Rows are : "+rows);*/
			        
					//Replace all commo's with empty space
					String expected1 = Utility.getReportProperty("Sale_Report_Net_Sale").replace(",", "");
					
					//Convert the String value of the Sale_Report_Net_Sale element into float value
					float expect1 = Float.parseFloat(expected1); 

					//Replace all commo's with empty space
					String expected2 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
					
					//Convert the String value of the Sale_Report_Tax element into float value
					float expect2 = Float.parseFloat(expected2);  

					//Replace all commo's with empty space
					String expected3 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
					
					//Convert the String value of the Sale_Report_Discount element into float value
					float expect3 = Float.parseFloat(expected3);     	

					//Replace all commo's with empty space
					String expected4 = Utility.getReportProperty("Sale_Report_Grand_Sale").replace(",", "");
							
					//Convert the String value of the Sale_Report_Grand_Sale element into float value
					float expect4= Float.parseFloat(expected4);  
			        
		        	//Replace all commo's with empty space
		        	String expected5 = Utility.getReportProperty("Hourly_Sale_Report_Number_Of_Customer").replace(",", "");
		        	
		        	//Convert the String value of the Hourly_Sale_Report_Number_Of_Customer element into float value
		        	float expect5 = Float.parseFloat(expected5);  
			        
			        //Check weather the Net Sale is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Sale Amount");
			        	
			        	//Get the Total value of Sale Amount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Net Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Net Sale Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Net Sale Value is : "+ actual);
			        }
			        
					else if(expect1 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Net Sale
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

			        	System.out.println("The Actual Net Sale value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Net Sale value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Sale Amount");
			        	
			        	//Get the Total value of Sale Amount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the net sale amount Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        			        	
			        	//Get the different
			        	float different = actual - expect1;
			        	
			        	//Print the different value
			        	System.out.println("Net Sale Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Net Sale Value different is : "+different);	
			        }
			        
			        //Check weather the Tax Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Tax");
			        	
			        	//Get the Total value of Tax
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Tax Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Tax Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
			        }
			        
					else if(expect2 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Tax
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

			        	System.out.println("The Actual Tax value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Tax");
			        	
			        	//Get the Total value of Tax
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Tax Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect2;
			        	
			        	//Print the different value
			        	System.out.println("Tax Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
			        }
			        
			        
			        //Check weather the Discount Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Discount");
			        	
			        	//Get the Total value of Discount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Discount Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Discount Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
			        }
			        
					else if(expect3 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Discount
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

			        	System.out.println("The Actual Discount value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Discount");
			        	
			        	//Get the Total value of Discount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Discount Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect3;
			        	
			        	//Print the different value
			        	System.out.println("Discount Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
			        }
			        
			        
			        //Check weather the Grand Sale Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Grand Sale");
			        	
			        	//Get the Total value of Grand Sale
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");   	

			        	//Convert the String value of the Grand Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Grand Sale Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Grand Sale Value is : "+ actual);
			        }
			        
					else if(expect4 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Sale Report
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

			        	System.out.println("The Actual Grand Sale value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Grand Sale value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Grand Sale");
			        	
			        	//Get the Total value of Grand Sale
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Grand Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect4;
			        	
			        	//Print the different value
			        	System.out.println("Grand Sale Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Grand Sale Value different is : "+different);	
			        }
			        
			        
			        //Check weather the Number of Customer Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText().equals(Utility.getReportProperty("Hourly_Sale_Report_Number_Of_Customer")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Number of Customer");
			        	
			        	//Get the Total value of Number of Customer
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Number of Customer Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Number of Customer Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Number of Customer Value is : "+ actual);
			        }
			        
					else if(expect5 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Number of Customer
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();

			        	System.out.println("The Actual Number of Customer value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Number of Customer value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Number of Customer");
			        	
			        	//Get the Total value of Number of Customer
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Number of Customer Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect5;
			        	
			        	//Print the different value
			        	System.out.println("Number of Customer Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Number of Customer Value different is : "+different);	
			        }
				}
				else
				{
					test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date");
				}
			}
		}
		
		catch(Exception e)
		{

			test.log(LogStatus.FAIL, "Hourly Sale Report is not available for Specific Date");

		}
				
		
		Thread.sleep(3000);
		System.out.println("********************* End of Group Report *************************");
		test.log(LogStatus.INFO, "********************* End of Group Report *************************");
	}
	
	@Test(priority=6)
	public void view_Enterprise_Hourly_Sale_Report_City() throws Exception
	{

		Thread.sleep(3000);
		System.out.println("********************* View The City Report *************************");
		test.log(LogStatus.INFO, "********************* View The City Report *************************");

		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("City");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1500);
		//Click the Select Some Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys("Chennai");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1500);
		//Click the Time Period Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/a")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		try
		{
			Thread.sleep(3000);
			//Check weather the report is available for the selected time period
			if(!driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Hourly Sale Report available for Specific Date");
				
				Thread.sleep(3000);
				//Check Weather the Top 5 hourly sale available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Here Top 5 Hourly Sale Report available for Specific Date");
					
					Thread.sleep(2000);
					//Click the down arrow button of chart type
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
					Thread.sleep(1000);
					
					//Click the Pie chart option
					driver.findElement(By.xpath("//a[.='Pie']")).click();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, "There is Pie Chart available");
					Thread.sleep(3000);
					
					Thread.sleep(2000);
					//Click the down arrow button of chart type
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
					Thread.sleep(1000);

					//Click the Polar Area chart option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/ul/li[2]/a")).click();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, "There is Polar Area Chart available");
					Thread.sleep(3000);
					
					Thread.sleep(2000);
					//Click the down arrow button of chart type
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
					Thread.sleep(1000);

					//Click the Bar chart option
					driver.findElement(By.xpath("//a[.='Bar']")).click();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, "There is Bar Chart available");
					Thread.sleep(3000);
				}
				else
				{
					test.log(LogStatus.FAIL, "Here Top 5 Hourly Sale Report not available for Specific Date");
				}
				
				Thread.sleep(5000);
				//Check weather the report graph is available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
				{
					test.log(LogStatus.PASS, "There is Graphical type of Hourly sale report is available for Specific Date");
				}
				else
				{
					test.log(LogStatus.FAIL, "Graphical report is not available for Specific Date");
				}
				
				Thread.sleep(5000);
				//Check weather the table format report is available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
					
					Thread.sleep(3000);
			        //No.of rows
			        List<WebElement> rows = driver.findElements(By.xpath ("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr"));
			        
	/*		        //Print number of Rows
			        System.out.println("Number of Rows are : "+rows);*/
			        
					//Replace all commo's with empty space
					String expected1 = Utility.getReportProperty("Sale_Report_Net_Sale").replace(",", "");
					
					//Convert the String value of the Sale_Report_Net_Sale element into float value
					float expect1 = Float.parseFloat(expected1); 

					//Replace all commo's with empty space
					String expected2 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
					
					//Convert the String value of the Sale_Report_Tax element into float value
					float expect2 = Float.parseFloat(expected2);  

					//Replace all commo's with empty space
					String expected3 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
					
					//Convert the String value of the Sale_Report_Discount element into float value
					float expect3 = Float.parseFloat(expected3);     	

					//Replace all commo's with empty space
					String expected4 = Utility.getReportProperty("Sale_Report_Grand_Sale").replace(",", "");
							
					//Convert the String value of the Sale_Report_Grand_Sale element into float value
					float expect4= Float.parseFloat(expected4);  
			        
		        	//Replace all commo's with empty space
		        	String expected5 = Utility.getReportProperty("Hourly_Sale_Report_Number_Of_Customer").replace(",", "");
		        	
		        	//Convert the String value of the Hourly_Sale_Report_Number_Of_Customer element into float value
		        	float expect5 = Float.parseFloat(expected5);  
			        
			        //Check weather the Net Sale is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Sale Amount");
			        	
			        	//Get the Total value of Sale Amount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Net Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Net Sale Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Net Sale Value is : "+ actual);
			        }
			        
					else if(expect1 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Net Sale
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

			        	System.out.println("The Actual Net Sale value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Net Sale value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Sale Amount");
			        	
			        	//Get the Total value of Sale Amount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the net sale amount Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        			        	
			        	//Get the different
			        	float different = actual - expect1;
			        	
			        	//Print the different value
			        	System.out.println("Net Sale Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Net Sale Value different is : "+different);	
			        }
			        
			        //Check weather the Tax Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Tax");
			        	
			        	//Get the Total value of Tax
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Tax Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Tax Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
			        }
			        
					else if(expect2 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Tax
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

			        	System.out.println("The Actual Tax value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Tax");
			        	
			        	//Get the Total value of Tax
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Tax Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect2;
			        	
			        	//Print the different value
			        	System.out.println("Tax Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
			        }
			        
			        
			        //Check weather the Discount Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Discount");
			        	
			        	//Get the Total value of Discount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Discount Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Discount Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
			        }
			        
					else if(expect3 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Discount
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

			        	System.out.println("The Actual Discount value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Discount");
			        	
			        	//Get the Total value of Discount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Discount Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect3;
			        	
			        	//Print the different value
			        	System.out.println("Discount Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
			        }
			        
			        
			        //Check weather the Grand Sale Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Grand Sale");
			        	
			        	//Get the Total value of Grand Sale
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");   	

			        	//Convert the String value of the Grand Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Grand Sale Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Grand Sale Value is : "+ actual);
			        }
			        
					else if(expect4 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Sale Report
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

			        	System.out.println("The Actual Grand Sale value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Grand Sale value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Grand Sale");
			        	
			        	//Get the Total value of Grand Sale
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Grand Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect4;
			        	
			        	//Print the different value
			        	System.out.println("Grand Sale Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Grand Sale Value different is : "+different);	
			        }
			        
			        
			        //Check weather the Number of Customer Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText().equals(Utility.getReportProperty("Hourly_Sale_Report_Number_Of_Customer")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Number of Customer");
			        	
			        	//Get the Total value of Number of Customer
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Number of Customer Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Number of Customer Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Number of Customer Value is : "+ actual);
			        }
			        
					else if(expect5 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Number of Customer
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();

			        	System.out.println("The Actual Number of Customer value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Number of Customer value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Number of Customer");
			        	
			        	//Get the Total value of Number of Customer
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Number of Customer Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect5;
			        	
			        	//Print the different value
			        	System.out.println("Number of Customer Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Number of Customer Value different is : "+different);	
			        }
				}
				else
				{
					test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date");
				}
			}
		}
		
		catch(Exception e)
		{

			test.log(LogStatus.FAIL, "Hourly Sale Report is not available for Specific Date");

		}
				
		
		Thread.sleep(3000);
		System.out.println("********************* End of City Report *************************");
		test.log(LogStatus.INFO, "********************* End of City Report *************************");
	}
	
	
	@Test(priority=7)
	public void view_Enterprise_Hourly_Sale_Report_State() throws Exception
	{

		Thread.sleep(3000);
		System.out.println("********************* View The State Report *************************");
		test.log(LogStatus.INFO, "********************* View The State Report *************************");

		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("State");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1500);
		//Click the Select Some Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys("Tamil Nadu");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1500);
		//Click the Time Period Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/a")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		try
		{
			Thread.sleep(3000);
			//Check weather the report is available for the selected time period
			if(!driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Hourly Sale Report available for Specific Date");
				
				Thread.sleep(3000);
				//Check Weather the Top 5 hourly sale available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Here Top 5 Hourly Sale Report available for Specific Date");
					
					Thread.sleep(2000);
					//Click the down arrow button of chart type
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
					Thread.sleep(1000);
					
					//Click the Pie chart option
					driver.findElement(By.xpath("//a[.='Pie']")).click();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, "There is Pie Chart available");
					Thread.sleep(3000);
					
					Thread.sleep(2000);
					//Click the down arrow button of chart type
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
					Thread.sleep(1000);

					//Click the Polar Area chart option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/ul/li[2]/a")).click();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, "There is Polar Area Chart available");
					Thread.sleep(3000);
					
					Thread.sleep(2000);
					//Click the down arrow button of chart type
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
					Thread.sleep(1000);

					//Click the Bar chart option
					driver.findElement(By.xpath("//a[.='Bar']")).click();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, "There is Bar Chart available");
					Thread.sleep(3000);
				}
				else
				{
					test.log(LogStatus.FAIL, "Here Top 5 Hourly Sale Report not available for Specific Date");
				}
				
				Thread.sleep(5000);
				//Check weather the report graph is available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
				{
					test.log(LogStatus.PASS, "There is Graphical type of Hourly sale report is available for Specific Date");
				}
				else
				{
					test.log(LogStatus.FAIL, "Graphical report is not available for Specific Date");
				}
				
				Thread.sleep(5000);
				//Check weather the table format report is available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
					
					Thread.sleep(3000);
			        //No.of rows
			        List<WebElement> rows = driver.findElements(By.xpath ("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr"));
			        
	/*		        //Print number of Rows
			        System.out.println("Number of Rows are : "+rows);*/
			        
					//Replace all commo's with empty space
					String expected1 = Utility.getReportProperty("Sale_Report_Net_Sale").replace(",", "");
					
					//Convert the String value of the Sale_Report_Net_Sale element into float value
					float expect1 = Float.parseFloat(expected1); 

					//Replace all commo's with empty space
					String expected2 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
					
					//Convert the String value of the Sale_Report_Tax element into float value
					float expect2 = Float.parseFloat(expected2);  

					//Replace all commo's with empty space
					String expected3 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
					
					//Convert the String value of the Sale_Report_Discount element into float value
					float expect3 = Float.parseFloat(expected3);     	

					//Replace all commo's with empty space
					String expected4 = Utility.getReportProperty("Sale_Report_Grand_Sale").replace(",", "");
							
					//Convert the String value of the Sale_Report_Grand_Sale element into float value
					float expect4= Float.parseFloat(expected4);  
			        
		        	//Replace all commo's with empty space
		        	String expected5 = Utility.getReportProperty("Hourly_Sale_Report_Number_Of_Customer").replace(",", "");
		        	
		        	//Convert the String value of the Hourly_Sale_Report_Number_Of_Customer element into float value
		        	float expect5 = Float.parseFloat(expected5);  
			        
			        //Check weather the Net Sale is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Sale Amount");
			        	
			        	//Get the Total value of Sale Amount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Net Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Net Sale Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Net Sale Value is : "+ actual);
			        }
			        
					else if(expect1 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Net Sale
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

			        	System.out.println("The Actual Net Sale value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Net Sale value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Sale Amount");
			        	
			        	//Get the Total value of Sale Amount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the net sale amount Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        			        	
			        	//Get the different
			        	float different = actual - expect1;
			        	
			        	//Print the different value
			        	System.out.println("Net Sale Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Net Sale Value different is : "+different);	
			        }
			        
			        //Check weather the Tax Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Tax");
			        	
			        	//Get the Total value of Tax
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Tax Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Tax Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
			        }
			        
					else if(expect2 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Tax
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

			        	System.out.println("The Actual Tax value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Tax");
			        	
			        	//Get the Total value of Tax
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Tax Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect2;
			        	
			        	//Print the different value
			        	System.out.println("Tax Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
			        }
			        
			        
			        //Check weather the Discount Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Discount");
			        	
			        	//Get the Total value of Discount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Discount Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Discount Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
			        }
			        
					else if(expect3 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Discount
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

			        	System.out.println("The Actual Discount value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Discount");
			        	
			        	//Get the Total value of Discount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Discount Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect3;
			        	
			        	//Print the different value
			        	System.out.println("Discount Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
			        }
			        
			        
			        //Check weather the Grand Sale Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Grand Sale");
			        	
			        	//Get the Total value of Grand Sale
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");   	

			        	//Convert the String value of the Grand Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Grand Sale Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Grand Sale Value is : "+ actual);
			        }
			        
					else if(expect4 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Sale Report
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

			        	System.out.println("The Actual Grand Sale value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Grand Sale value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Grand Sale");
			        	
			        	//Get the Total value of Grand Sale
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Grand Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect4;
			        	
			        	//Print the different value
			        	System.out.println("Grand Sale Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Grand Sale Value different is : "+different);	
			        }
			        
			        
			        //Check weather the Number of Customer Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText().equals(Utility.getReportProperty("Hourly_Sale_Report_Number_Of_Customer")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Number of Customer");
			        	
			        	//Get the Total value of Number of Customer
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Number of Customer Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Number of Customer Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Number of Customer Value is : "+ actual);
			        }
			        
					else if(expect5 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Number of Customer
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();

			        	System.out.println("The Actual Number of Customer value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Number of Customer value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Number of Customer");
			        	
			        	//Get the Total value of Number of Customer
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Number of Customer Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect5;
			        	
			        	//Print the different value
			        	System.out.println("Number of Customer Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Number of Customer Value different is : "+different);	
			        }
				}
				else
				{
					test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date");
				}
			}
		}
		
		catch(Exception e)
		{

			test.log(LogStatus.FAIL, "Hourly Sale Report is not available for Specific Date");

		}
				
		
		Thread.sleep(3000);
		System.out.println("********************* End of State Report *************************");
		test.log(LogStatus.INFO, "********************* End of State Report *************************");
	}

	@Test(priority=8)
	public void view_Enterprise_Hourly_Sale_Report_ZipCode() throws Exception
	{

		Thread.sleep(3000);
		System.out.println("********************* View The Zip Code Report *************************");
		test.log(LogStatus.INFO, "********************* View The Zip Code Report *************************");
		
		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Zip Code");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1500);
		//Click the Select Some Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys("600106");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1500);
		//Click the Time Period Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/a")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		try
		{
			Thread.sleep(3000);
			//Check weather the report is available for the selected time period
			if(!driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Hourly Sale Report available for Specific Date");
				
				Thread.sleep(3000);
				//Check Weather the Top 5 hourly sale available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Here Top 5 Hourly Sale Report available for Specific Date");
					
					Thread.sleep(2000);
					//Click the down arrow button of chart type
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
					Thread.sleep(1000);
					
					//Click the Pie chart option
					driver.findElement(By.xpath("//a[.='Pie']")).click();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, "There is Pie Chart available");
					Thread.sleep(3000);
					
					Thread.sleep(2000);
					//Click the down arrow button of chart type
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
					Thread.sleep(1000);

					//Click the Polar Area chart option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/ul/li[2]/a")).click();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, "There is Polar Area Chart available");
					Thread.sleep(3000);
					
					Thread.sleep(2000);
					//Click the down arrow button of chart type
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
					Thread.sleep(1000);

					//Click the Bar chart option
					driver.findElement(By.xpath("//a[.='Bar']")).click();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, "There is Bar Chart available");
					Thread.sleep(3000);
				}
				else
				{
					test.log(LogStatus.FAIL, "Here Top 5 Hourly Sale Report not available for Specific Date");
				}
				
				Thread.sleep(5000);
				//Check weather the report graph is available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
				{
					test.log(LogStatus.PASS, "There is Graphical type of Hourly sale report is available for Specific Date");
				}
				else
				{
					test.log(LogStatus.FAIL, "Graphical report is not available for Specific Date");
				}
				
				Thread.sleep(5000);
				//Check weather the table format report is available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
					
					Thread.sleep(3000);
			        //No.of rows
			        List<WebElement> rows = driver.findElements(By.xpath ("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr"));
			        
	/*		        //Print number of Rows
			        System.out.println("Number of Rows are : "+rows);*/
			        
					//Replace all commo's with empty space
					String expected1 = Utility.getReportProperty("Sale_Report_Net_Sale").replace(",", "");
					
					//Convert the String value of the Sale_Report_Net_Sale element into float value
					float expect1 = Float.parseFloat(expected1); 

					//Replace all commo's with empty space
					String expected2 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
					
					//Convert the String value of the Sale_Report_Tax element into float value
					float expect2 = Float.parseFloat(expected2);  

					//Replace all commo's with empty space
					String expected3 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
					
					//Convert the String value of the Sale_Report_Discount element into float value
					float expect3 = Float.parseFloat(expected3);     	

					//Replace all commo's with empty space
					String expected4 = Utility.getReportProperty("Sale_Report_Grand_Sale").replace(",", "");
							
					//Convert the String value of the Sale_Report_Grand_Sale element into float value
					float expect4= Float.parseFloat(expected4);  
			        
		        	//Replace all commo's with empty space
		        	String expected5 = Utility.getReportProperty("Hourly_Sale_Report_Number_Of_Customer").replace(",", "");
		        	
		        	//Convert the String value of the Hourly_Sale_Report_Number_Of_Customer element into float value
		        	float expect5 = Float.parseFloat(expected5);  
			        
			        //Check weather the Net Sale is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Sale Amount");
			        	
			        	//Get the Total value of Sale Amount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Net Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Net Sale Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Net Sale Value is : "+ actual);
			        }
			        
					else if(expect1 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Net Sale
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

			        	System.out.println("The Actual Net Sale value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Net Sale value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Sale Amount");
			        	
			        	//Get the Total value of Sale Amount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the net sale amount Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        			        	
			        	//Get the different
			        	float different = actual - expect1;
			        	
			        	//Print the different value
			        	System.out.println("Net Sale Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Net Sale Value different is : "+different);	
			        }
			        
			        //Check weather the Tax Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Tax");
			        	
			        	//Get the Total value of Tax
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Tax Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Tax Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
			        }
			        
					else if(expect2 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Tax
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

			        	System.out.println("The Actual Tax value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Tax");
			        	
			        	//Get the Total value of Tax
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Tax Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect2;
			        	
			        	//Print the different value
			        	System.out.println("Tax Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
			        }
			        
			        
			        //Check weather the Discount Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Discount");
			        	
			        	//Get the Total value of Discount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Discount Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Discount Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
			        }
			        
					else if(expect3 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Discount
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

			        	System.out.println("The Actual Discount value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Discount");
			        	
			        	//Get the Total value of Discount
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Discount Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect3;
			        	
			        	//Print the different value
			        	System.out.println("Discount Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
			        }
			        
			        
			        //Check weather the Grand Sale Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Grand Sale");
			        	
			        	//Get the Total value of Grand Sale
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");   	

			        	//Convert the String value of the Grand Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Grand Sale Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Grand Sale Value is : "+ actual);
			        }
			        
					else if(expect4 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Sale Report
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

			        	System.out.println("The Actual Grand Sale value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Grand Sale value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Grand Sale");
			        	
			        	//Get the Total value of Grand Sale
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Grand Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect4;
			        	
			        	//Print the different value
			        	System.out.println("Grand Sale Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Grand Sale Value different is : "+different);	
			        }
			        
			        
			        //Check weather the Number of Customer Report is correct or not
			        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText().equals(Utility.getReportProperty("Hourly_Sale_Report_Number_Of_Customer")))
			        {
			        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Number of Customer");
			        	
			        	//Get the Total value of Number of Customer
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Number of Customer Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Number of Customer Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Number of Customer Value is : "+ actual);
			        }
			        
					else if(expect5 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Number of Customer
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();

			        	System.out.println("The Actual Number of Customer value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Number of Customer value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Number of Customer");
			        	
			        	//Get the Total value of Number of Customer
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Number of Customer Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect5;
			        	
			        	//Print the different value
			        	System.out.println("Number of Customer Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Number of Customer Value different is : "+different);	
			        }
				}
				else
				{
					test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date");
				}
			}
		}
		
		catch(Exception e)
		{

			test.log(LogStatus.FAIL, "Hourly Sale Report is not available for Specific Date");

		}
				
		
		Thread.sleep(3000);
		System.out.println("********************* End of Zip Code Report *************************");
		test.log(LogStatus.INFO, "********************* End of Zip Code Report *************************");

	}


}
