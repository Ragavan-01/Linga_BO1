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

public class Verify_DepartmentSale_Report {
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Verify_DepartmentSale_Report");

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
	public void open_Department_Sale_Report() throws Exception
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
		
		Thread.sleep(6000);

	}
/*	
	@Test(priority=3)
	public void department_Sale_Report_For_Today() throws Exception
	{
		
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
		Thread.sleep(5000);
		//Click the Department option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		//Enter the required department
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(3000);
		//Click the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Today");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Department Sale Report is not available for Today");
		}
		else
		{
			test.log(LogStatus.PASS, "Department Sale Report available for Today");
			
			Thread.sleep(3000);
			//Check Weather the Top 5 department sale available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Here Top 5 Department Sale Report available for Today");
				
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
				test.log(LogStatus.FAIL, "Here Top 5 Department Sale Report not available for Today");
			}
			
			Thread.sleep(5000);
			//Check weather the report graph is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
			{
				test.log(LogStatus.PASS, "There is Graphical type of department sale report is available for Today");
			}
			else
			{
				test.log(LogStatus.FAIL, "Graphical report is not available for Today");
			}
			
			Thread.sleep(5000);
			//Check weather the table format report is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Table Format Report is available for Today");
				
				Thread.sleep(3000);
		        //No.of rows
		        List<WebElement> rows = driver.findElements(By.xpath (".//*[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr"));
		        
		        //Check weather the Sale Amount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Sale Amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the sale amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Sale_Amount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Sale_Amount element into float value
		        	float expected = Float.parseFloat(expected1);  
		        			        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Quantity Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Quantity")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Quantity").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Quantity element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Tax Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");   	

		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Tax element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Discount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Discount element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Percentage Of Sale Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Percentage_Of_Sale")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage Of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Percentage_Of_Sale").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Percentage_Of_Sale element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
			}
			else
			{
				test.log(LogStatus.FAIL, "Table Format Report is not available for Today");
			}
		}
	}
	
	@Test(priority=4)
	public void department_Sale_Report_For_YesterDay() throws Exception
	{
		
		Thread.sleep(5000);
		//Click the Department option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		//Enter the required department
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(3000);
		//Click the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Yesterday");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Department Sale Report is not available for Yesterday");
		}
		else
		{
			test.log(LogStatus.PASS, "Department Sale Report available for Yesterday");
			
			Thread.sleep(3000);
			//Check Weather the Top 5 department sale available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Here Top 5 Department Sale Report available for Yesterday");
				
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
				test.log(LogStatus.FAIL, "Here Top 5 Department Sale Report not available for Yesterday");
			}
			
			Thread.sleep(5000);
			//Check weather the report graph is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
			{
				test.log(LogStatus.PASS, "There is Graphical type of department sale report is available for Yesterday");
			}
			else
			{
				test.log(LogStatus.FAIL, "Graphical report is not available for Yesterday");
			}
			
			Thread.sleep(5000);
			//Check weather the table format report is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Table Format Report is available for Yesterday");
				
				Thread.sleep(3000);
		        //No.of rows
		        List<WebElement> rows = driver.findElements(By.xpath (".//*[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr"));
		        
		        //Check weather the Sale Amount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Sale Amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the sale amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Sale_Amount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Sale_Amount element into float value
		        	float expected = Float.parseFloat(expected1);  
		        			        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Quantity Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Quantity")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Quantity").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Quantity element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Tax Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");   	

		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Tax element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Discount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Discount element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Percentage Of Sale Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Percentage_Of_Sale")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage Of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Percentage_Of_Sale").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Percentage_Of_Sale element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
			}
			else
			{
				test.log(LogStatus.FAIL, "Table Format Report is not available for Yesterday");
			}
		}
	}
	
	@Test(priority=5)
	public void department_Sale_Report_For_LastNdays() throws Exception
	{

		
		Thread.sleep(5000);
		//Click the Department option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		//Enter the required department
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(3000);
		//Click the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Last 'N' days");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//clear the number of days field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input")).clear();
		//Enter the number of days
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input")).sendKeys("100");
		
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Department Sale Report is not available for Last N Days");
		}
		else
		{
			test.log(LogStatus.PASS, "Department Sale Report available for Last N Days");
			
			Thread.sleep(3000);
			//Check Weather the Top 5 department sale available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Here Top 5 Department Sale Report available for Last N Days");
				
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
				test.log(LogStatus.FAIL, "Here Top 5 Department Sale Report not available for Last N Days");
			}
			
			Thread.sleep(5000);
			//Check weather the report graph is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
			{
				test.log(LogStatus.PASS, "There is Graphical type of department sale report is available for Last N Days");
			}
			else
			{
				test.log(LogStatus.FAIL, "Graphical report is not available for Last N Days");
			}
			
			Thread.sleep(5000);
			//Check weather the table format report is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Table Format Report is available for Last N Days");
				
				Thread.sleep(3000);
		        //No.of rows
		        List<WebElement> rows = driver.findElements(By.xpath (".//*[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr"));
		        
		        //Check weather the Sale Amount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Sale Amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the sale amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Sale_Amount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Sale_Amount element into float value
		        	float expected = Float.parseFloat(expected1);  
		        			        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Quantity Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Quantity")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Quantity").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Quantity element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Tax Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");   	

		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Tax element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Discount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Discount element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Percentage Of Sale Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Percentage_Of_Sale")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage Of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Percentage_Of_Sale").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Percentage_Of_Sale element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
			}
			else
			{
				test.log(LogStatus.FAIL, "Table Format Report is not available for Last N Days");
			}
		}
	}
	
	@Test(priority=6)
	public void department_Sale_Report_For_ThisWeek() throws Exception
	{

		
		Thread.sleep(5000);
		//Click the Department option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		//Enter the required department
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(3000);
		//Click the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("This week");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Department Sale Report is not available for This Week");
		}
		else
		{
			test.log(LogStatus.PASS, "Department Sale Report available for This Week");
			
			Thread.sleep(3000);
			//Check Weather the Top 5 department sale available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Here Top 5 Department Sale Report available for This Week");
				
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
				test.log(LogStatus.FAIL, "Here Top 5 Department Sale Report not available for This Week");
			}
			
			Thread.sleep(5000);
			//Check weather the report graph is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
			{
				test.log(LogStatus.PASS, "There is Graphical type of department sale report is available for This Week");
			}
			else
			{
				test.log(LogStatus.FAIL, "Graphical report is not available for This Week");
			}
			
			Thread.sleep(5000);
			//Check weather the table format report is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Table Format Report is available for This Week");
				
				Thread.sleep(3000);
		        //No.of rows
		        List<WebElement> rows = driver.findElements(By.xpath (".//*[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr"));
		        
		        //Check weather the Sale Amount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Sale Amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the sale amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Sale_Amount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Sale_Amount element into float value
		        	float expected = Float.parseFloat(expected1);  
		        			        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Quantity Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Quantity")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Quantity").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Quantity element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Tax Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");   	

		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Tax element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Discount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Discount element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Percentage Of Sale Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Percentage_Of_Sale")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage Of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Percentage_Of_Sale").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Percentage_Of_Sale element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
			}
			else
			{
				test.log(LogStatus.FAIL, "Table Format Report is not available for This Week");
			}
		}
	}
	
	@Test(priority=7)
	public void department_Sale_Report_For_Last_Week() throws Exception
	{
		
		Thread.sleep(5000);
		//Click the Department option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		//Enter the required department
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(3000);
		//Click the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Last week");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Department Sale Report is not available for Last Week");
		}
		else
		{
			test.log(LogStatus.PASS, "Department Sale Report available for Last Week");
			
			Thread.sleep(3000);
			//Check Weather the Top 5 department sale available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Here Top 5 Department Sale Report available for Last Week");
				
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
				test.log(LogStatus.FAIL, "Here Top 5 Department Sale Report not available for Last Week");
			}
			
			Thread.sleep(5000);
			//Check weather the report graph is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
			{
				test.log(LogStatus.PASS, "There is Graphical type of department sale report is available for Last Week");
			}
			else
			{
				test.log(LogStatus.FAIL, "Graphical report is not available for Last Week");
			}
			
			Thread.sleep(5000);
			//Check weather the table format report is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Table Format Report is available for Last Week");
				
				Thread.sleep(3000);
		        //No.of rows
		        List<WebElement> rows = driver.findElements(By.xpath (".//*[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr"));
		        
		        //Check weather the Sale Amount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Sale Amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the sale amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Sale_Amount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Sale_Amount element into float value
		        	float expected = Float.parseFloat(expected1);  
		        			        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Quantity Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Quantity")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Quantity").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Quantity element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Tax Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");   	

		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Tax element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Discount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Discount element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Percentage Of Sale Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Percentage_Of_Sale")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage Of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Percentage_Of_Sale").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Percentage_Of_Sale element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
			}
			else
			{
				test.log(LogStatus.FAIL, "Table Format Report is not available for Last Week");
			}
		}
	}
	
	@Test(priority=8)
	public void department_Sale_Report_For_Last_7_Days() throws Exception
	{
		
		Thread.sleep(5000);
		//Click the Department option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		//Enter the required department
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(3000);
		//Click the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Last 7 days");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Department Sale Report is not available for Last 7 days");
		}
		else
		{
			test.log(LogStatus.PASS, "Department Sale Report available for Last 7 days");
			
			Thread.sleep(3000);
			//Check Weather the Top 5 department sale available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Here Top 5 Department Sale Report available for Last 7 days");
				
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
				test.log(LogStatus.FAIL, "Here Top 5 Department Sale Report not available for Last 7 days");
			}
			
			Thread.sleep(5000);
			//Check weather the report graph is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
			{
				test.log(LogStatus.PASS, "There is Graphical type of department sale report is available for Last 7 days");
			}
			else
			{
				test.log(LogStatus.FAIL, "Graphical report is not available for Last 7 days");
			}
			
			Thread.sleep(5000);
			//Check weather the table format report is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Table Format Report is available for Last 7 days");
				
				Thread.sleep(3000);
		        //No.of rows
		        List<WebElement> rows = driver.findElements(By.xpath (".//*[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr"));
		        
		        //Check weather the Sale Amount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Sale Amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the sale amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Sale_Amount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Sale_Amount element into float value
		        	float expected = Float.parseFloat(expected1);  
		        			        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Quantity Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Quantity")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Quantity").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Quantity element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Tax Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");   	

		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Tax element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Discount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Discount element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Percentage Of Sale Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Percentage_Of_Sale")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage Of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Percentage_Of_Sale").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Percentage_Of_Sale element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
			}
			else
			{
				test.log(LogStatus.FAIL, "Table Format Report is not available for Last 7 days");
			}
		}
	}
	
	@Test(priority=9)
	public void department_Sale_Report_For_ThisMonth() throws Exception
	{
		
		Thread.sleep(5000);
		//Click the Department option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		//Enter the required department
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(3000);
		//Click the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("This month");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Department Sale Report is not available for This Month");
		}
		else
		{
			test.log(LogStatus.PASS, "Department Sale Report available for This Month");
			
			Thread.sleep(3000);
			//Check Weather the Top 5 department sale available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Here Top 5 Department Sale Report available for This Month");
				
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
				test.log(LogStatus.FAIL, "Here Top 5 Department Sale Report not available for This Month");
			}
			
			Thread.sleep(5000);
			//Check weather the report graph is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
			{
				test.log(LogStatus.PASS, "There is Graphical type of department sale report is available for This Month");
			}
			else
			{
				test.log(LogStatus.FAIL, "Graphical report is not available for This Month");
			}
			
			Thread.sleep(5000);
			//Check weather the table format report is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Table Format Report is available for This Month");
				
				Thread.sleep(3000);
		        //No.of rows
		        List<WebElement> rows = driver.findElements(By.xpath (".//*[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr"));
		        
		        //Check weather the Sale Amount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Sale Amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the sale amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Sale_Amount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Sale_Amount element into float value
		        	float expected = Float.parseFloat(expected1);  
		        			        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Quantity Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Quantity")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Quantity").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Quantity element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Tax Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");   	

		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Tax element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Discount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Discount element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Percentage Of Sale Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Percentage_Of_Sale")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage Of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Percentage_Of_Sale").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Percentage_Of_Sale element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
			}
			else
			{
				test.log(LogStatus.FAIL, "Table Format Report is not available for This Month");
			}
		}
	}
	
	@Test(priority=10)
	public void department_Sale_Report_For_Last_Month() throws Exception
	{

		
		Thread.sleep(5000);
		//Click the Department option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		//Enter the required department
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(3000);
		//Click the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Last month");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Department Sale Report is not available for Last Month");
		}
		else
		{
			test.log(LogStatus.PASS, "Department Sale Report available for Last Month");
			
			Thread.sleep(3000);
			//Check Weather the Top 5 department sale available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Here Top 5 Department Sale Report available for Last Month");
				
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
				test.log(LogStatus.FAIL, "Here Top 5 Department Sale Report not available for Last Month");
			}
			
			Thread.sleep(5000);
			//Check weather the report graph is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
			{
				test.log(LogStatus.PASS, "There is Graphical type of department sale report is available for Last Month");
			}
			else
			{
				test.log(LogStatus.FAIL, "Graphical report is not available for Last Month");
			}
			
			Thread.sleep(5000);
			//Check weather the table format report is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Table Format Report is available for Last Month");
				
				Thread.sleep(3000);
		        //No.of rows
		        List<WebElement> rows = driver.findElements(By.xpath (".//*[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr"));
		        
		        //Check weather the Sale Amount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Sale Amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the sale amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Sale_Amount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Sale_Amount element into float value
		        	float expected = Float.parseFloat(expected1);  
		        			        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Quantity Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Quantity")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Quantity").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Quantity element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Tax Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");   	

		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Tax element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Discount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Discount element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Percentage Of Sale Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Percentage_Of_Sale")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage Of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Percentage_Of_Sale").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Percentage_Of_Sale element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
			}
			else
			{
				test.log(LogStatus.FAIL, "Table Format Report is not available for Last Month");
			}
		}
	}
	
	@Test(priority=11)
	public void department_Sale_Report_For_Last_30_Days() throws Exception
	{
		
		Thread.sleep(5000);
		//Click the Department option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		//Enter the required department
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(3000);
		//Click the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Last 30 days");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Department Sale Report is not available for Last 30 Days");
		}
		else
		{
			test.log(LogStatus.PASS, "Department Sale Report available for Last 30 Days");
			
			Thread.sleep(3000);
			//Check Weather the Top 5 department sale available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Here Top 5 Department Sale Report available for Last 30 Days");
				
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
				test.log(LogStatus.FAIL, "Here Top 5 Department Sale Report not available for Last 30 Days");
			}
			
			Thread.sleep(5000);
			//Check weather the report graph is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
			{
				test.log(LogStatus.PASS, "There is Graphical type of department sale report is available for Last 30 Days");
			}
			else
			{
				test.log(LogStatus.FAIL, "Graphical report is not available for Last 30 Days");
			}
			
			Thread.sleep(5000);
			//Check weather the table format report is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Table Format Report is available for Last 30 Days");
				
				Thread.sleep(3000);
		        //No.of rows
		        List<WebElement> rows = driver.findElements(By.xpath (".//*[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr"));
		        
		        //Check weather the Sale Amount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Sale Amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the sale amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Sale_Amount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Sale_Amount element into float value
		        	float expected = Float.parseFloat(expected1);  
		        			        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Quantity Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Quantity")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Quantity").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Quantity element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Tax Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");   	

		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Tax element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Discount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Discount element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Percentage Of Sale Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Percentage_Of_Sale")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage Of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Percentage_Of_Sale").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Percentage_Of_Sale element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
			}
			else
			{
				test.log(LogStatus.FAIL, "Table Format Report is not available for Last 30 Days");
			}
		}
	}*/
	
	@Test(priority=12)
	public void department_Sale_Report_For_Specific_Date() throws Exception
	{
		Thread.sleep(2000);
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

		Thread.sleep(5000);
		//Click the Department option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		//Enter the required department
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
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Department Sale Report is not available for Specific Date");
		}
		else
		{
			test.log(LogStatus.PASS, "Department Sale Report available for Specific Date");
			
			Thread.sleep(3000);
			//Check Weather the Top 5 department sale available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Here Top 5 Department Sale Report available for Specific Date");
				
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
				test.log(LogStatus.FAIL, "Here Top 5 Department Sale Report not available for Specific Date");
			}
			
			Thread.sleep(5000);
			//Check weather the report graph is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
			{
				test.log(LogStatus.PASS, "There is Graphical type of department sale report is available for Specific Date");
			}
			else
			{
				test.log(LogStatus.FAIL, "Graphical report is not available for Specific Date");
			}
			
			Thread.sleep(5000);
			//Check weather the table format report is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
				
				Thread.sleep(3000);
		        //No.of rows
		        List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr"));
		        
/*	        //Print number of Rows
		        System.out.println("Number of Rows are : "+rows);*/
		        
	        	
	        	//Replace all commo's with empty space
	        	String expected1 = Utility.getReportProperty("Sale_Report_Sale_Amount").replace(",", "");
	        	
	        	//Convert the String value of the Sale_Report_Sale_Amount element into float value
	        	float expect1 = Float.parseFloat(expected1);  
	        		        	
	        	//Replace all commo's with empty space
	        	String expected2 = Utility.getReportProperty("Sale_Report_Quantity").replace(",", "");
	        	
	        	//Convert the String value of the Sale_Report_Quantity element into float value
	        	float expect2 = Float.parseFloat(expected2);  
	        	
	        	//Replace all commo's with empty space
	        	String expected3 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
	        	
	        	//Convert the String value of the Sale_Report_Tax element into float value
	        	float expect3 = Float.parseFloat(expected3);  

	        	//Replace all commo's with empty space
	        	String expected4 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
	        	
	        	//Convert the String value of the Sale_Report_Discount element into float value
	        	float expect4 = Float.parseFloat(expected4);  
	        	
	        	//Replace all commo's with empty space
	        	String expected5 = Utility.getReportProperty("Sale_Report_Percentage_Of_Sale").replace(",", "");
	        	
	        	//Convert the String value of the Sale_Report_Percentage_Of_Sale element into float value
	        	float expect5 = Float.parseFloat(expected5);                              
		        
		        //Check weather the Sale Amount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Sale Amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Sale Amount Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Sale Amount Value is : "+ actual);
		        }
		        
				else if(expect1 == unknownValue)
				{
					test.log(LogStatus.PASS, "Here we don't have the exact expected value");
					
		        	//Get the Total value of Check Count
		        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();

		        	System.out.println("The Actual Sale Amount value is : "+actualText);
		        	
		        	test.log(LogStatus.INFO, "The Actual Sale Amount value is : "+actualText);
				}
		        
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the sale amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        			        	
		        	//Get the different
		        	float different = actual - expect1;
		        	
		        	//Print the different value
		        	System.out.println("Sale Amount Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "Sale Amount Value different is : "+different);	
		        }
		        
		        //Check weather the Quantity Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Quantity")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Quantity Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Quantity Value is : "+ actual);
		        }
		        
				else if(expect2 == unknownValue)
				{
					test.log(LogStatus.PASS, "Here we don't have the exact expected value");
					
		        	//Get the Total value of Quantity
		        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

		        	System.out.println("The Actual Quantity value is : "+actualText);
		        	
		        	test.log(LogStatus.INFO, "The Actual Quantity value is : "+actualText);
				}
		        
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Get the different
		        	float different = actual - expect2;
		        	
		        	//Print the different value
		        	System.out.println("Quantity Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "Quantity Value different is : "+different);	
		        }
		        
		        //Check weather the Tax Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");   	

		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Tax Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
		        }
		        
				else if(expect3 == unknownValue)
				{
					test.log(LogStatus.PASS, "Here we don't have the exact expected value");
					
		        	//Get the Total value of Tax
		        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

		        	System.out.println("The Actual Tax value is : "+actualText);		 
		        	
		        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
				}
		        
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
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
		        
		        //Check weather the Discount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Discount Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
		        }
		        
				else if(expect4 == unknownValue)
				{
					test.log(LogStatus.PASS, "Here we don't have the exact expected value");
					
		        	//Get the Total value of Discount
		        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

		        	System.out.println("The Actual Discount value is : "+actualText);	
		        	
		        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
				}
		        
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        			        	
		        	//Get the different
		        	float different = actual - expect4;
		        	
		        	//Print the different value
		        	System.out.println("Discount Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
		        }
		        
		        //Check weather the Percentage Of Sale Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Percentage_Of_Sale")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Percentage Of Sale Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Percentage Of Sale Value is : "+ actual);
		        }
		        
				else if(expect5 == unknownValue)
				{
					test.log(LogStatus.PASS, "Here we don't have the exact expected value");
					
		        	//Get the Total value of Percentage Of Sale
		        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

		        	System.out.println("The Actual Percentage Of Sale value is : "+actualText);
		        	
		        	test.log(LogStatus.INFO, "The Actual Percentage Of Sale value is : "+actualText);
				}
		        
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage Of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        			        	
		        	//Get the different
		        	float different = actual - expect5;
		        	
		        	//Print the different value
		        	System.out.println("Percentage Of Sale Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "Percentage Of Sale Value different is : "+different);	
		        }
			}
			else
			{
				test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date");
			}
		}
	}
	
	
	
/*	
	@Test(priority=13)
	public void department_Sale_Report_For_Date_Range() throws Exception
	{

		Thread.sleep(5000);
		//Click the Department option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		//Enter the required department
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
		//Clear the from date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(2000);
		//Clear the To date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));

		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Department Sale Report is not available for Date Range");
		}
		else
		{
			test.log(LogStatus.PASS, "Department Sale Report available for Date Range");
			
			Thread.sleep(3000);
			//Check Weather the Top 5 department sale available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Here Top 5 Department Sale Report available for Date Range");
				
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
				test.log(LogStatus.FAIL, "Here Top 5 Department Sale Report not available for Date Range");
			}
			
			Thread.sleep(5000);
			//Check weather the report graph is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
			{
				test.log(LogStatus.PASS, "There is Graphical type of department sale report is available for Date Range");
			}
			else
			{
				test.log(LogStatus.FAIL, "Graphical report is not available for Date Range");
			}
			
			Thread.sleep(5000);
			//Check weather the table format report is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Table Format Report is available for Date Range");
				
				Thread.sleep(3000);
		        //No.of rows
		        List<WebElement> rows = driver.findElements(By.xpath (".//*[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr"));
		        
		        //Check weather the Sale Amount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Sale Amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Sale Amount");
		        	
		        	//Get the Total value of Sale Amount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the sale amount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Sale_Amount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Sale_Amount element into float value
		        	float expected = Float.parseFloat(expected1);  
		        			        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Quantity Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Quantity")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Quantity");
		        	
		        	//Get the Total value of Quantity
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Quantity Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Quantity").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Quantity element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Tax Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");   	

		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Tax");
		        	
		        	//Get the Total value of Tax
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Tax Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Tax element into float value
		        	float expected = Float.parseFloat(expected1);  
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Discount Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Discount");
		        	
		        	//Get the Total value of Discount
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Discount Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Discount element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
		        
		        //Check weather the Percentage Of Sale Report is correct or not
		        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Percentage_Of_Sale")))
		        {
		        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Print the actual value
		        	System.out.println("The Actual Value is : "+actual);
		        	
		        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Percentage Of Sale");
		        	
		        	//Get the Total value of Percentage Of Sale
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replace(",", "");
		        	
		        	//Convert the String value of the Percentage Of Sale Total element into float value
		        	float actual = Float.parseFloat(actualText);
		        	
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Sale_Report_Percentage_Of_Sale").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Percentage_Of_Sale element into float value
		        	float expected = Float.parseFloat(expected1);     	
		        	
		        	//Get the different
		        	float different = actual - expected;
		        	
		        	//Print the different value
		        	System.out.println("The Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "The Value different is : "+different);	
		        }
			}
			else
			{
				test.log(LogStatus.FAIL, "Table Format Report is not available for Date Range");
			}
		}
	}*/
	
}
