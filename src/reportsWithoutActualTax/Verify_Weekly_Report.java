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

public class Verify_Weekly_Report {
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Verify_Weekly_Report");
	
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
	public void open_Weekly_Report() throws Exception
	{
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
		
		Thread.sleep(4000);
		
/*		// Create instance of Java script executor
		JavascriptExecutor je1 = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element1 = driver.findElement(By.xpath("//span[.=' Weekly Summary ']"));
		//Scroll the page till the Weekly Summary option present
		je1.executeScript("arguments[0].scrollIntoView(true);",element1); */
		
		//Click the Weekly Summary Report
		driver.findElement(By.xpath("//span[.=' Weekly Summary ']")).click();
		Thread.sleep(3000);
		
		//Check weather the Weekly Summary Report page is loaded or not
		if(driver.findElement(By.xpath("//li[@class='uib-tab nav-item ng-isolate-scope active']/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Weekly Summary"))
		{
			test.log(LogStatus.PASS, "Weekly Summary Report page loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Weekly Summary Report page loaded fail");
		}

		Thread.sleep(5000);
		
	}
	
	@Test(priority=3)
	public void weekly_Summary_Report_This_Week() throws Exception
	{

		Thread.sleep(3000);
		//Click the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("This week");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		//Check weather the Table Type report available or not for This Week
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Table format reprot is available for This Week");
						
			
			List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr/td[1]"));
			for(int i = 2; i <= rows.size(); i++)
			{
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Gross Sales"))
				{
					
					List<WebElement> Column = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
					
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("This_Weekly_Gross_Sale").replace("[,\\₹]", "");
		        	
		        	//Convert the String value of the This_Weekly_Gross_Sale element into float value
		        	float expect1 = Float.parseFloat(expected1);  
		        	
		        	//Get the Total value of Check Count
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replaceAll("[,\\₹]", "");
		        	
					Thread.sleep(2000);
					//Check the Gross Sale
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Gross_Sale")))
					{
						test.log(LogStatus.PASS, "Actual and Expected Gross Sale is same");
							        	
			        	//Convert the String value of the Gross Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Gross Sale Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Gross Sale Value is : "+ actual);

					}
					
					else if(expect1 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	System.out.println("The Actual Gross Sale value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Gross Sale value is : "+actualText);
					}
					
					else
					{
						test.log(LogStatus.FAIL, "Actual and Expected Gross Sale is different");
			        	
			        	//Convert the String value of the Gross Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect1;
			        	
			        	//Print the different value
			        	System.out.println("Gross Sale different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Gross Sale different is : "+different);	

					}
					
				}
			}
			
			for(int i = 2; i <= rows.size(); i++)
			{
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Net Sales"))
				{
					
					List<WebElement> Column1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
					
		        	//Replace all commo's with empty space
		        	String expected2 = Utility.getReportProperty("This_Weekly_Net_Sale").replace("[,\\₹]", "");
		        	
		        	//Convert the String value of the This_Weekly_Net_Sale element into float value
		        	float expect2 = Float.parseFloat(expected2);  
		        	
		        	//Get the Total value of Check Count
		        	String actualText3 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText2 = actualText3.replaceAll("[,\\₹]", "");
						
					Thread.sleep(2000);
					//Check the Net Sale
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Net_Sale")))
					{
						test.log(LogStatus.PASS, "Actual and Expected Net Sale is same");
							        	
			        	//Convert the String value of the Net Sale Total element into float value
			        	float actual = Float.parseFloat(actualText2);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Net Sale Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Net Sale Value is : "+ actual);

					}
					
					else if(expect2 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	System.out.println("The Actual Net Sale value is : "+actualText2);
			        	
			        	test.log(LogStatus.INFO, "The Actual Net Sale value is : "+actualText2);
					}
					
					else
					{
						test.log(LogStatus.FAIL, "Actual and Expected Net Sale is different");
			        	
			        	//Convert the String value of the Gross Sale Total element into float value
			        	float actual = Float.parseFloat(actualText2);
			        			        	
			        	//Get the different
			        	float different = actual - expect2;
			        	
			        	//Print the different value
			        	System.out.println("Net Sale different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Net Sale different is : "+different);	

					}

					}

			}

		}
		else
		{
			test.log(LogStatus.FAIL, "Table format report is not available for This Week");
		}
	}
	
	@Test(priority=4)
	public void weekly_Summary_Report_Last_Week() throws Exception
	{

		Thread.sleep(3000);
		//Click the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("Last week");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		//Check weather the Table Type report available or not for Last Week
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Table format reprot is available for Last Week");
						
			List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr/td[1]"));
			for(int i = 2; i <= rows.size(); i++)
			{
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Gross Sales"))
				{
					
					List<WebElement> Column = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
					
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("This_Weekly_Gross_Sale").replace("[,\\₹]", "");
		        	
		        	//Convert the String value of the This_Weekly_Gross_Sale element into float value
		        	float expect1 = Float.parseFloat(expected1);  
		        	
		        	//Get the Total value of Check Count
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replaceAll("[,\\₹]", "");
		        	
					Thread.sleep(2000);
					//Check the Gross Sale
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Gross_Sale")))
					{
						test.log(LogStatus.PASS, "Actual and Expected Gross Sale is same");
							        	
			        	//Convert the String value of the Gross Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Gross Sale Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Gross Sale Value is : "+ actual);

					}
					
					else if(expect1 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	System.out.println("The Actual Gross Sale value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Gross Sale value is : "+actualText);
					}
					
					else
					{
						test.log(LogStatus.FAIL, "Actual and Expected Gross Sale is different");
			        	
			        	//Convert the String value of the Gross Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect1;
			        	
			        	//Print the different value
			        	System.out.println("Gross Sale different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Gross Sale different is : "+different);	

					}
					
				}
			}
			
			for(int i = 2; i <= rows.size(); i++)
			{
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Net Sales"))
				{
					
					List<WebElement> Column1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
					
		        	//Replace all commo's with empty space
		        	String expected2 = Utility.getReportProperty("This_Weekly_Net_Sale").replace("[,\\₹]", "");
		        	
		        	//Convert the String value of the This_Weekly_Net_Sale element into float value
		        	float expect2 = Float.parseFloat(expected2);  
		        	
		        	//Get the Total value of Check Count
		        	String actualText3 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText2 = actualText3.replaceAll("[,\\₹]", "");
						
					Thread.sleep(2000);
					//Check the Net Sale
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Net_Sale")))
					{
						test.log(LogStatus.PASS, "Actual and Expected Net Sale is same");
							        	
			        	//Convert the String value of the Net Sale Total element into float value
			        	float actual = Float.parseFloat(actualText2);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Net Sale Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Net Sale Value is : "+ actual);

					}
					
					else if(expect2 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	System.out.println("The Actual Net Sale value is : "+actualText2);
			        	
			        	test.log(LogStatus.INFO, "The Actual Net Sale value is : "+actualText2);
					}
					
					else
					{
						test.log(LogStatus.FAIL, "Actual and Expected Net Sale is different");
			        	
			        	//Convert the String value of the Gross Sale Total element into float value
			        	float actual = Float.parseFloat(actualText2);
			        			        	
			        	//Get the different
			        	float different = actual - expect2;
			        	
			        	//Print the different value
			        	System.out.println("Net Sale different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Net Sale different is : "+different);	

					}

					}

			}
		}
		else
		{
			test.log(LogStatus.FAIL, "Table format report is not available for Last Week");
		}
	}
	
	@Test(priority=5)
	public void weekly_Summary_Report_Last7days() throws Exception
	{

		Thread.sleep(3000);
		//Click the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("Last 7 days");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		//Check weather the Table Type report available or not for Last 7 days
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Table format reprot is available for Last 7 Days");
						
			List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr/td[1]"));
			for(int i = 2; i <= rows.size(); i++)
			{
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Gross Sales"))
				{
					
					List<WebElement> Column = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
					
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("This_Weekly_Gross_Sale").replace("[,\\₹]", "");
		        	
		        	//Convert the String value of the This_Weekly_Gross_Sale element into float value
		        	float expect1 = Float.parseFloat(expected1);  
		        	
		        	//Get the Total value of Check Count
		        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText= actualText1.replaceAll("[,\\₹]", "");
		        	
					Thread.sleep(2000);
					//Check the Gross Sale
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Gross_Sale")))
					{
						test.log(LogStatus.PASS, "Actual and Expected Gross Sale is same");
							        	
			        	//Convert the String value of the Gross Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Gross Sale Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Gross Sale Value is : "+ actual);

					}
					
					else if(expect1 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	System.out.println("The Actual Gross Sale value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Gross Sale value is : "+actualText);
					}
					
					else
					{
						test.log(LogStatus.FAIL, "Actual and Expected Gross Sale is different");
			        	
			        	//Convert the String value of the Gross Sale Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect1;
			        	
			        	//Print the different value
			        	System.out.println("Gross Sale different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Gross Sale different is : "+different);	

					}
					
				}
			}
			
			for(int i = 2; i <= rows.size(); i++)
			{
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Net Sales"))
				{
					
					List<WebElement> Column1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
					
		        	//Replace all commo's with empty space
		        	String expected2 = Utility.getReportProperty("This_Weekly_Net_Sale").replace("[,\\₹]", "");
		        	
		        	//Convert the String value of the This_Weekly_Net_Sale element into float value
		        	float expect2 = Float.parseFloat(expected2);  
		        	
		        	//Get the Total value of Check Count
		        	String actualText3 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText();
		        	
		        	//Replace all commo's with empty space
		        	String actualText2 = actualText3.replaceAll("[,\\₹]", "");
						
					Thread.sleep(2000);
					//Check the Net Sale
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Net_Sale")))
					{
						test.log(LogStatus.PASS, "Actual and Expected Net Sale is same");
							        	
			        	//Convert the String value of the Net Sale Total element into float value
			        	float actual = Float.parseFloat(actualText2);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Net Sale Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Net Sale Value is : "+ actual);

					}
					
					else if(expect2 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	System.out.println("The Actual Net Sale value is : "+actualText2);
			        	
			        	test.log(LogStatus.INFO, "The Actual Net Sale value is : "+actualText2);
					}
					
					else
					{
						test.log(LogStatus.FAIL, "Actual and Expected Net Sale is different");
			        	
			        	//Convert the String value of the Gross Sale Total element into float value
			        	float actual = Float.parseFloat(actualText2);
			        			        	
			        	//Get the different
			        	float different = actual - expect2;
			        	
			        	//Print the different value
			        	System.out.println("Net Sale different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Net Sale different is : "+different);	

					}

					}

			}
		}
		else
		{
			test.log(LogStatus.FAIL, "Table format report is not available for Last 7 Days");
		}
	}
}
