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

public class Verify_SaleSummary_Report {

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Verify_Sale_Summary_Report");

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
	public void open_Sale_Summary_Report() throws Exception
	{
	
		Thread.sleep(2000);
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
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
		
		Thread.sleep(2000);
		
		//Click the Sale Summary Report
		driver.findElement(By.xpath("//span[.=' Sale Summary ']")).click();
		
		Thread.sleep(3000);
		//Check weather the Sale Summary page is opened or not
		if(driver.findElement(By.xpath("//li[@class='uib-tab nav-item ng-isolate-scope active']/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Sale Summary"))
		{
			test.log(LogStatus.PASS, "Sale Summary Report Page Loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sale Summary Report Page Loaded Fail");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void sale_Saummary_Report_For_Specific_Date() throws Exception
	{

		Thread.sleep(5000);
		//Click the Employee option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		//Enter the required employee
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(3000);
		//Click the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
		Thread.sleep(2000);
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Sale Summary Report is not available for Specific Date");
		}
		else
		{
			test.log(LogStatus.PASS, "Sale Summary Report available for Specific Date");
					
			Thread.sleep(5000);
			//Check weather the table format report is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
				
				Thread.sleep(3000);
		        //No.of rows
		        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr"));
		        
/*	        //Print number of Rows
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
	        	String expected3 = Utility.getReportProperty("Sale_Report_Inclusive_Tax").replace(",", "");
	        	
	        	//Convert the String value of the Sale_Report_Inclusive_Tax element into float value
	        	float expect3 = Float.parseFloat(expected3);  

	        	//Replace all commo's with empty space
	        	String expected4 = Utility.getReportProperty("CC_Service_Charge").replace(",", "");
	        	
	        	//Convert the String value of the CC_Service_Charge element into float value
	        	float expect4 = Float.parseFloat(expected4);  
	        	
	        	//Replace all commo's with empty space
	        	String expected5 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
	        	
	        	//Convert the String value of the Sale_Report_Discount element into float value
	        	float expect5 = Float.parseFloat(expected5);  
	        	
	        	//Replace all commo's with empty space
	        	String expected6 = Utility.getReportProperty("Gross_Receipt").replace(",", "");
	        	
	        	//Convert the String value of the Gross_Receipt element into float value
	        	float expect6 = Float.parseFloat(expected6); 
		        
		        //Check weather the Sale Amount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Net Sale Amount");
		        	
		        	//Get the Total value of Net Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Net Sale Amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Net Sale Amount Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Net Sale Amount Value is : "+ actual);
		        }
		        
				else if(expect1 == unknownValue)
				{
					test.log(LogStatus.PASS, "Here we don't have the exact expected value");
					
		        	//Get the Total value of Check Count
		        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

		        	System.out.println("The Actual Net Sale Amount value is : "+actualText);
		        	
		        	test.log(LogStatus.INFO, "The Actual Net Sale Amount value is : "+actualText);
				}
		        
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Net Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the net sale amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        			        	
		        	//Get the different
		        	float different = actual - expect1;
		        	
		        	//Print the different value
		        	System.out.println("Net Sale Amount Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "Net Sale Amount Value different is : "+different);	
		        }
		        
		        //Check weather the Tax Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Tax reports are same for Quantity");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
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
					
		        	//Get the Total value of Quantity
		        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

		        	System.out.println("The Actual Tax value is : "+actualText);
		        	
		        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
				}
		        
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Tax");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
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
		        
		        //Check weather the Inclusive Tax Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Inclusive_Tax")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Inclusive Tax");
		        	
		        	//Get the Total value of Inclusive Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");   	

		        	//Convert the String value of the Inclusive Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Inclusive Tax Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Inclusive Tax Value is : "+ actual);
		        }
		        
				else if(expect3 == unknownValue)
				{
					test.log(LogStatus.PASS, "Here we don't have the exact expected value");
					
		        	//Get the Total value of Tax
		        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

		        	System.out.println("The Actual Inclusive Tax value is : "+actualText);		 
		        	
		        	test.log(LogStatus.INFO, "The Actual Inclusive Tax value is : "+actualText);
				}
		        
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Inclusive Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        			        	
		        	//Get the different
		        	float different = actual - expect3;
		        	
		        	//Print the different value
		        	System.out.println("Tax Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
		        }
		        
		        //Check weather the CC Service Charge Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("CC_Service_Charge")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
		        	
		        	//Get the Total value of CC Service Charge
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the CC Service Charge Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual CC Service Charge Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual CC Service Charge Value is : "+ actual);
		        }
		        
				else if(expect4 == unknownValue)
				{
					test.log(LogStatus.PASS, "Here we don't have the exact expected value");
					
		        	//Get the Total value of CC Service Charge
		        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

		        	System.out.println("The Actual CC Service Charge value is : "+actualText);	
		        	
		        	test.log(LogStatus.INFO, "The Actual CC Service Charge value is : "+actualText);
				}
		        
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for CC Service Charge");
		        	
		        	//Get the Total value of CC Service Charge
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the CC Service Charge Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        			        	
		        	//Get the different
		        	float different = actual - expect4;
		        	
		        	//Print the different value
		        	System.out.println("CC Service Charge Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "CC Service Charge Value different is : "+different);	
		        }
		        
		        //Check weather the Discount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Discount Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
		        }
		        
				else if(expect5 == unknownValue)
				{
					test.log(LogStatus.PASS, "Here we don't have the exact expected value");
					
		        	//Get the Total value of Discount
		        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();

		        	System.out.println("The Actual Discount value is : "+actualText);
		        	
		        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
				}
		        
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Discount");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        			        	
		        	//Get the different
		        	float different = actual - expect5;
		        	
		        	//Print the different value
		        	System.out.println("Discount Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
		        }
		        
		        //Check weather the Gross Receipt Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText().equals(Utility.getReportProperty("Gross_Receipt")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Gross Receipt");
		        	
		        	//Get the Total value of Gross Receipt
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Gross Receipt Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Gross Receipt Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Gross Receipt Value is : "+ actual);
		        }
		        
				else if(expect6 == unknownValue)
				{
					test.log(LogStatus.PASS, "Here we don't have the exact expected value");
					
		        	//Get the Total value of Percentage Of Sale
		        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();

		        	System.out.println("The Actual Gross Receipt value is : "+actualText);
		        	
		        	test.log(LogStatus.INFO, "The Actual Gross Receipt value is : "+actualText);
				}
		        
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Gross Receipt");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/div/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage Of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        			        	
		        	//Get the different
		        	float different = actual - expect5;
		        	
		        	//Print the different value
		        	System.out.println("Gross Receipt Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "Gross Receipt Value different is : "+different);	
		        }
			}
			else
			{
				test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date");
			}
		}
	}
}
