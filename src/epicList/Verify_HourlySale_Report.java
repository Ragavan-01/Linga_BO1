package epicList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import epicList_Chrome.Utility;

public class Verify_HourlySale_Report {

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Verify_HourlySale_Report");

	float unknownValue = 00;
	
	@AfterClass
	public void flushTest() throws Exception
	{
		Thread.sleep(2000);
		rep.endTest(test);
		rep.flush();
		
		//SendMail.snedMailWithAttachment();
	}

	@Test(priority=1)
			public void login() throws Exception
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
			public void logout() throws Exception
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
	
			@Test(priority=100,enabled = true)
			public void Hourly_Sale_method_openpage_Sale_Report() throws Exception
			{
				/*//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Sale']"));
				//Scroll the page till the Sale option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Sale Option		
				driver.findElement(By.xpath("//span[.='Sale']")).click(); */
				
				Thread.sleep(3000);
				//Enter the Categories Url
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/hourlySale");
				
				Thread.sleep(3000);
				
				//Check weather the Modifier Sale Report page is loaded or not
				if(driver.findElement(By.xpath("//li[@class='uib-tab nav-item ng-isolate-scope active']/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Hourly Sale"))
				{
					test.log(LogStatus.PASS, "Hourly Sale Report page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Hourly Sale Report page loaded fail");
				}

				Thread.sleep(3000);

			}
			
			@Test(priority=101,enabled = true)
			public void Hourly_Sale_method_Report_For_Specific_Date() throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Hourly Sale Report is not available for Specific Date");
				}
				else
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
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath ("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				        
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
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		
				        	System.out.println("The Actual Net Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Net Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		
				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		
				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Grand Sale");
				        	
				        	//Get the Total value of Grand Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
		
				        	System.out.println("The Actual Grand Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Grand Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Grand Sale");
				        	
				        	//Get the Total value of Grand Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]/span")).getText().equals(Utility.getReportProperty("Hourly_Sale_Report_Number_Of_Customer")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Number of Customer");
				        	
				        	//Get the Total value of Number of Customer
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
		
				        	System.out.println("The Actual Number of Customer value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Number of Customer value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Number of Customer");
				        	
				        	//Get the Total value of Number of Customer
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
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
		
			@Test(priority=102,enabled = true)
			public void Hourly_Sale_method_Report_For_Specific_Date_With_Dynamic_Report() throws Exception
		{
			Thread.sleep(2000);
			WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	
			Thread.sleep(3000);
			//Click the Time Period option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
			//Enter the required Time Period
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter Key
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[1]")).clear();
			//Enter the date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
			Thread.sleep(2000);
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[2]")).clear();
			//Enter the date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
			Thread.sleep(2000);
			//Click the Run Button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(3000);
			for(int i = 1; i <= 8; i++)
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}Thread.sleep(3000);
			//Check Whether all the field is selected or not
			if(driver.findElement(By.xpath("//span[contains(.,'Net Sale')]/../input")).isSelected()
					&&driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected()
					&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
					&&driver.findElement(By.xpath("//span[contains(.,'Grand Sale')]/../input")).isSelected()
					&&driver.findElement(By.xpath("//span[contains(.,'Number Of Customer')]/../input")).isSelected())
			{
				//Check weather the table format report is available or not
				if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
					
					//Check whether all the filed is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net Sale')]")).isDisplayed()
							&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed()
							&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
							&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Grand Sale')]")).isDisplayed()
							&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Number Of Customer')]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
					}
					else
					{
						test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
					}
					
					//Change the option from enable to Disable the Net Sale Option
					if(driver.findElement(By.xpath("//span[contains(.,'Net Sale')]/../input")).isSelected())
					{
						//Click the Enabled Net Sale Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net Sale')]"))).click().build().perform();
						try
						{
							//Check whether the Net Sale Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net Sale')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Net Sale is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Net Sale is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Net Sale Option is Disabled When user enter the required date for date range");
					}
					
					//Change the option from enable to Disable the Tax Option
					if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
					{
						//Click the Enabled Tax Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
						try
						{
							//Check whether the Tax Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Tax is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Tax is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Tax Option is Disabled When user enter the required date for date range");
					}
									
					//Change the option from enable to Disable the Discount Option
					if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
					{
						//Click the Enabled Discount Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
						try
						{
							//Check whether the Discount Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Discount is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Discount is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Discount Option is Disabled When user enter the required date for date range");
					}
					
					//Change the option from enable to Disable the Grand Sale Option
					if(driver.findElement(By.xpath("//span[contains(.,'Grand Sale')]/../input")).isSelected())
					{
						//Click the Enabled Grand Sale Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Grand Sale')]"))).click().build().perform();
						try
						{
							//Check whether the Grand Sale Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Grand Sale')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Grand Sale is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Grand Sale is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Grand Sale Option is Disabled When user enter the required date for date range");
					}
					
					//Change the option from enable to Disable the Number Of Customer Option
					if(driver.findElement(By.xpath("//span[contains(.,'Number Of Customer')]/../input")).isSelected())
					{
						//Click the Enabled Number Of Customer Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Number Of Customer')]"))).click().build().perform();
						try
						{
							//Check whether the Number Of Customer Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Number Of Customer')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Number Of Customer is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Number Of Customer is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Number Of Customer Option is Disabled When user enter the required date for date range");
					}
					
					//Enable the Net Sale Option if it is in disabled status
					if(driver.findElement(By.xpath("//span[contains(.,'Net Sale')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Net Sale Option is Enabled after user click(Disable) the Net Sale option");
	
					}
					else
					{
						//Click the Enabled Net Sale Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net Sale')]"))).click().build().perform();
						try
						{
							//Check whether the Net Sale Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net Sale')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Net Sale is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Net Sale is not displayed");
						}				
					}
					
					//Enable the Tax Option if it is in disabled status
					if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Tax Option is Enabled after user click(Disable) the Tax option");
	
					}
					else
					{
						//Click the Enabled Tax Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
						try
						{
							//Check whether the Tax Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Tax is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Tax is not displayed");
						}				
					}
					
											
					//Disable the required option from enable to disable Discount Option
					if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Discount Option is Enabled after user click(Disable) the Discount option");
	
					}
					else
					{
	
						//Click the Enabled Discount Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
						try
						{
							//Check whether the Discount Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Discount is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Discount is not displayed");
						}
					}
					
					//Disable the required option from enable to disable Grand Sale Option
					if(driver.findElement(By.xpath("//span[contains(.,'Grand Sale')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Grand Sale Option is Enabled after user click(Disable) the Grand Sale option");
	
					}
					else
					{
	
						//Click the Enabled Grand Sale Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Grand Sale')]"))).click().build().perform();
						try
						{
							//Check whether the Grand Sale Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Grand Sale')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Grand Sale is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Grand Sale is not displayed");
						}
					}
	
					//Disable the required option from enable to disable Number Of Customer Option
					if(driver.findElement(By.xpath("//span[contains(.,'Number Of Customer')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Number Of Customer Option is Enabled after user click(Disable) the Number Of Customer option");
	
					}
					else
					{
	
						//Click the Enabled Number Of Customer Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Number Of Customer')]"))).click().build().perform();
						try
						{
							//Check whether the Number Of Customer Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Number Of Customer')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Number Of Customer is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Number Of Customer is not displayed");
						}
					}
				}
				else
				{
					test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
				}
				
			}
			else
			{
				test.log(LogStatus.FAIL, "All dynamic option is not selected");
			}
		}

}
