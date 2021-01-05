package epicList_Integrated;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EnterpriseReport2 {
	
	
		public WebDriver driver;
		ExtentReports rep = ExtentManager.getInstance();
		ExtentTest test = rep.startTest("Verify_Enterprise_Report2");

		float unknownValue = 00;

		@AfterMethod
		public void tearDown(ITestResult result)
		{
			if(ITestResult.FAILURE == result.getStatus())
			{
				Utility.captureScreenshot(driver, result.getName());
			}
		}

		@AfterClass
		public void flushTest() throws Exception
		{
			Thread.sleep(2000);
			rep.endTest(test);
			rep.flush();
		}

		@Test(priority=1)
		public void login(WebDriver driver) throws Exception
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
		public void logout(WebDriver driver) throws Exception
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
		
		@Test(priority=2)
		public void Hourly_Enterprise_Report_Method_openpage(WebDriver driver) throws Exception
		{
			Thread.sleep(15000);
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
		
		@Test(priority=3)
		public void Hourly_Enterprise_Report_Method_Stores(WebDriver driver) throws Exception
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
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1500);
			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("Stores");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);

			
			Thread.sleep(5000);
			//Click the Select Some Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul")).click();	
			//Remove the Select Some Options
			//driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li[1]/a")).click();	
			
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).click();
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(1500);
			//Click the Time Period Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/a")).click();	
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
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
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date for store");
					}
				}
			}
			
			catch(Exception e)
			{

				test.log(LogStatus.FAIL, "Hourly Sale Report is not available for Specific Date for store");

			}
					
			Thread.sleep(3000);
			System.out.println("********************* End of Store Report *************************");
			test.log(LogStatus.INFO, "********************* End of Store Report *************************");

			
		}
		
		@Test(priority=4)
		public void Hourly_Enterprise_Report_Method_Group(WebDriver driver) throws Exception
		{

			Thread.sleep(3000);
			System.out.println("********************* View The Group Report *************************");
			test.log(LogStatus.INFO, "********************* View The Group Report *************************");
			
			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(1500);
			//Click the Select Some Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Group"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(1500);
			//Click the Time Period Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
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
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date for Group");
					}
				}
			}
			
			catch(Exception e)
			{

				test.log(LogStatus.FAIL, "Hourly Sale Report is not available for Specific Date for Group");

			}
					
			
			Thread.sleep(3000);
			System.out.println("********************* End of Group Report *************************");
			test.log(LogStatus.INFO, "********************* End of Group Report *************************");
		}
		
		@Test(priority=5)
		public void Hourly_Enterprise_Report_Method_City(WebDriver driver) throws Exception
		{

			Thread.sleep(3000);
			System.out.println("********************* View The City Report *************************");
			test.log(LogStatus.INFO, "********************* View The City Report *************************");

			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("City");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(1500);
			//Click the Select Some Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("City"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(1500);
			//Click the Time Period Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
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
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date for City");
					}
				}
			}
			
			catch(Exception e)
			{

				test.log(LogStatus.FAIL, "Hourly Sale Report is not available for Specific Date for City");

			}
					
			
			Thread.sleep(3000);
			System.out.println("********************* End of City Report *************************");
			test.log(LogStatus.INFO, "********************* End of City Report *************************");
		}
				
		@Test(priority=6)
		public void Hourly_Enterprise_Report_Method_State(WebDriver driver) throws Exception
		{

			Thread.sleep(3000);
			System.out.println("********************* View The State Report *************************");
			test.log(LogStatus.INFO, "********************* View The State Report *************************");

			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("State");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(1500);
			//Click the Select Some Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("State"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(1500);
			//Click the Time Period Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
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
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date for State");
					}
				}
			}
			
			catch(Exception e)
			{

				test.log(LogStatus.FAIL, "Hourly Sale Report is not available for Specific Date for State");

			}
					
			
			Thread.sleep(3000);
			System.out.println("********************* End of State Report *************************");
			test.log(LogStatus.INFO, "********************* End of State Report *************************");
		}

		@Test(priority=7)
		public void Hourly_Enterprise_Report_Method_ZipCode(WebDriver driver) throws Exception
		{

			Thread.sleep(3000);
			System.out.println("********************* View The Zip Code Report *************************");
			test.log(LogStatus.INFO, "********************* View The Zip Code Report *************************");
			
			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("Zip Code");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(1500);
			//Click the Select Some Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Zipcode"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(1500);
			//Click the Time Period Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
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
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date for Zip Code");
					}
				}
			}
			
			catch(Exception e)
			{

				test.log(LogStatus.FAIL, "Hourly Sale Report is not available for Specific Date for Zip Code");

			}
					
			
			Thread.sleep(3000);
			System.out.println("********************* End of Zip Code Report *************************");
			test.log(LogStatus.INFO, "********************* End of Zip Code Report *************************");

		}

		@Test(priority=8)
		public void Daily_Enterprise_Report_Method_OpenpageReport(WebDriver driver) throws Exception
		{
		/*	//Click the My Stores option
			driver.findElement(By.xpath("//span[.='My Stores']")).click();

			Thread.sleep(3000);
	        //Click the EnterPrise Reports Option		
			driver.findElement(By.xpath("//span[.='EnterPrise Reports']")).click();
			
			Thread.sleep(2000);
			//Click the Sale option
			driver.findElement(By.xpath("//span[.='Sale']")).click();	*/
			
			Thread.sleep(2000);
			//Enter the URl
			driver.get(Utility.getProperty("Enterprise_Base_URL")+"enterPriseReport/dailySaleSummary");

			Thread.sleep(5000);
			//Check Daily Report page opened or not
			if(driver.findElement(By.xpath("//li[@class='uib-tab nav-item ng-isolate-scope active']/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Daily Sale"))
			{
				test.log(LogStatus.PASS, "Daily Sale Report page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Daily Sale Report page loaded Failed");
			}
			
			Thread.sleep(3000);
			
		}
		
		@Test(priority=9)
		public void Daily_Enterprise_Report_Method_For_Stores(WebDriver driver) throws Exception
		{

			Thread.sleep(2000);
			WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

			Thread.sleep(5000);
			System.out.println("********************* View The Store Report *************************");
			test.log(LogStatus.INFO, "********************* View The Store Report *************************");

			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);

			Thread.sleep(1500);
			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("Stores");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);

			
			Thread.sleep(1500);
			//Click the Select Some Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul")).click();
			//Remove the store name
			//driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li[1]/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Store"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(1500);
			//Click the Time Period Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
			Thread.sleep(1000);
			//Click the Run button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			try
			{
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(!driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Daily Sale Report available for Specific Date");
					
					Thread.sleep(3000);
					//Check Weather the Top 5 Daily sale available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Here Top 5 Daily Sale Report available for Specific Date");
						
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
						test.log(LogStatus.FAIL, "Here Top 5 Daily Sale Report not available for Specific Date For Stores");
					}
					
					Thread.sleep(5000);
					//Check weather the report graph is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
					{
						test.log(LogStatus.PASS, "There is Graphical type of Daily sale report is available for Specific Date");
					}
					else
					{
						test.log(LogStatus.FAIL, "Graphical report is not available for Specific Date For Stores");
					}
					
					Thread.sleep(1000);
					//Scroll the web page
				    for(int i=1; i <= 15; i++)
				    {
				    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				    	Thread.sleep(1000);
				    }
				    
					Thread.sleep(8000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for Specific Date For Stores");
						
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
				        			        
				        //Check weather the Net Sale is correct or not
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Sale Amount For Stores");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();

				        	System.out.println("The Actual Net Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Net Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Sale Amount For Stores");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Grand Sale");
				        	
				        	//Get the Total value of Grand Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Grand Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Grand Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Grand Sale");
				        	
				        	//Get the Total value of Grand Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        
				        
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date For Stores");
					}
				}
			}
			
			catch(Exception e)
			{

				test.log(LogStatus.FAIL, "Daily Sale Report is not available for Specific Date For Stores");

			}
					
			Thread.sleep(3000);
			System.out.println("********************* End of Store Report *************************");
			test.log(LogStatus.INFO, "********************* End of Store Report *************************");

			Thread.sleep(1000);
			//Scroll the web page
		    for(int i=1; i <= 15; i++)
		    {
		    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		    	Thread.sleep(1000);
		    }
		}
		
		@Test(priority=10)
		public void Daily_Enterprise_Report_Method_For_Group(WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(3000);
			System.out.println("********************* View The Group Report *************************");
			test.log(LogStatus.INFO, "********************* View The Group Report *************************");
			
			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(1500);
			//Click the Select Some Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Group"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		

			//Click the Time Period Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
			Thread.sleep(1000);
			//Click the Run button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			try
			{
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(!driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Daily Sale Report available for Specific Date");
					
					Thread.sleep(3000);
					//Check Weather the Top 5 Daily sale available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Here Top 5 Daily Sale Report available for Specific Date");
						
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
						test.log(LogStatus.FAIL, "Here Top 5 Daily Sale Report not available for Specific Date");
					}
					
					Thread.sleep(5000);
					//Check weather the report graph is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
					{
						test.log(LogStatus.PASS, "There is Graphical type of Daily sale report is available for Specific Date");
					}
					else
					{
						test.log(LogStatus.FAIL, "Graphical report is not available for Specific Date");
					}
					
					Thread.sleep(1000);
					//Scroll the web page
				    for(int i=1; i <= 15; i++)
				    {
				    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				    	Thread.sleep(1000);
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
				        			        
				        //Check weather the Net Sale is correct or not
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();

				        	System.out.println("The Actual Net Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Net Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Grand Sale");
				        	
				        	//Get the Total value of Grand Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Grand Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Grand Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Grand Sale");
				        	
				        	//Get the Total value of Grand Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        
				        
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date For Group");
					}
				}
			}
			
			catch(Exception e)
			{

				test.log(LogStatus.FAIL, "Daily Sale Report is not available for Specific Date For Group");

			}
					
			
			Thread.sleep(3000);
			System.out.println("********************* End of Group Report *************************");
			Thread.sleep(1000);
			//Scroll the web page
		    for(int i=1; i <= 15; i++)
		    {
		    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		    	Thread.sleep(1000);
		    }	test.log(LogStatus.INFO, "********************* End of Group Report *************************");
		}
		
		@Test(priority=11)
		public void Daily_Enterprise_Report_Method_For_City(WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(3000);
			System.out.println("********************* View The City Report *************************");
			test.log(LogStatus.INFO, "********************* View The City Report *************************");

			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("City");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(1500);
			//Click the Select Some Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("City"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(1500);
			//Click the Time Period Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
			Thread.sleep(1000);
			//Click the Run button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			try
			{
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(!driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Daily Sale Report available for Specific Date");
					
					Thread.sleep(3000);
					//Check Weather the Top 5 Daily sale available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Here Top 5 Daily Sale Report available for Specific Date");
						
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
						test.log(LogStatus.FAIL, "Here Top 5 Daily Sale Report not available for Specific Date");
					}
					
					Thread.sleep(5000);
					//Check weather the report graph is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
					{
						test.log(LogStatus.PASS, "There is Graphical type of Daily sale report is available for Specific Date");
					}
					else
					{
						test.log(LogStatus.FAIL, "Graphical report is not available for Specific Date");
					}
					
					Thread.sleep(1000);
					//Scroll the web page
				    for(int i=1; i <= 15; i++)
				    {
				    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				    	Thread.sleep(1000);
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
				        			        
				        //Check weather the Net Sale is correct or not
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();

				        	System.out.println("The Actual Net Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Net Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Grand Sale");
				        	
				        	//Get the Total value of Grand Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Grand Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Grand Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Grand Sale");
				        	
				        	//Get the Total value of Grand Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        
				        
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date For City");
					}
				}
			}
			
			catch(Exception e)
			{

				test.log(LogStatus.FAIL, "Daily Sale Report is not available for Specific Date For City");

			}
					
			
			Thread.sleep(3000);
			System.out.println("********************* End of City Report *************************");
			Thread.sleep(1000);
			//Scroll the web page
		    for(int i=1; i <= 15; i++)
		    {
		    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		    	Thread.sleep(1000);
		    }	test.log(LogStatus.INFO, "********************* End of City Report *************************");
		}
				
		@Test(priority=12)
		public void Daily_Enterprise_Report_Method_For_State(WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(3000);
			System.out.println("********************* View The State Report *************************");
			test.log(LogStatus.INFO, "********************* View The State Report *************************");

			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("State");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(1500);
			//Click the Select Some Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("State"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(1500);
			//Click the Time Period Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
			Thread.sleep(1000);
			//Click the Run button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			try
			{
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(!driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Daily Sale Report available for Specific Date");
					
					Thread.sleep(3000);
					//Check Weather the Top 5 Daily sale available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Here Top 5 Daily Sale Report available for Specific Date");
						
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
						test.log(LogStatus.FAIL, "Here Top 5 Daily Sale Report not available for Specific Date");
					}
					
					Thread.sleep(5000);
					//Check weather the report graph is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
					{
						test.log(LogStatus.PASS, "There is Graphical type of Daily sale report is available for Specific Date");
					}
					else
					{
						test.log(LogStatus.FAIL, "Graphical report is not available for Specific Date");
					}
					
					Thread.sleep(1000);
					//Scroll the web page
				    for(int i=1; i <= 15; i++)
				    {
				    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				    	Thread.sleep(1000);
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
				        			        
				        //Check weather the Net Sale is correct or not
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();

				        	System.out.println("The Actual Net Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Net Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Grand Sale");
				        	
				        	//Get the Total value of Grand Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Grand Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Grand Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Grand Sale");
				        	
				        	//Get the Total value of Grand Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        
				        
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date For State ");
					}
				}
			}
			
			catch(Exception e)
			{

				test.log(LogStatus.FAIL, "Daily Sale Report is not available for Specific Date For State");

			}
					
			
			Thread.sleep(3000);
			System.out.println("********************* End of State Report *************************");
			test.log(LogStatus.INFO, "********************* End of State Report *************************");
			Thread.sleep(1000);
			//Scroll the web page
		    for(int i=1; i <= 15; i++)
		    {
		    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		    	Thread.sleep(1000);
		    }
		}

		@Test(priority=13)
		public void Daily_Enterprise_Report_Method_For_ZipCode(WebDriver driver) throws Exception
		{
			System.out.println("********************* View The Zip Code Report *************************");
			test.log(LogStatus.INFO, "********************* View The Zip Code Report *************************");
			
			Thread.sleep(3000);
			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("Zip Code");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(1500);
			//Click the Select Some Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Zipcode"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(1500);
			//Click the Time Period Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
			Thread.sleep(1000);
			//Click the Run button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			try
			{
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(!driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Daily Sale Report available for Specific Date");
					
					Thread.sleep(3000);
					//Check Weather the Top 5 Daily sale available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Here Top 5 Daily Sale Report available for Specific Date");
						
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
						test.log(LogStatus.FAIL, "Here Top 5 Daily Sale Report not available for Specific Date");
					}
					
					Thread.sleep(5000);
					//Check weather the report graph is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
					{
						test.log(LogStatus.PASS, "There is Graphical type of Daily sale report is available for Specific Date");
					}
					else
					{
						test.log(LogStatus.FAIL, "Graphical report is not available for Specific Date");
					}
					
					Thread.sleep(1000);
					//Scroll the web page
				    for(int i=1; i <= 15; i++)
				    {
				    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				    	Thread.sleep(1000);
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
				        			        
				        //Check weather the Net Sale is correct or not
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();

				        	System.out.println("The Actual Net Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Net Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Grand Sale");
				        	
				        	//Get the Total value of Grand Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Grand Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Grand Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Grand Sale");
				        	
				        	//Get the Total value of Grand Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        
				        
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date For Zip Code");
					}
				}
			}
			
			catch(Exception e)
			{

				test.log(LogStatus.FAIL, "Daily Sale Report is not available for Specific Date For Zip Code");

			}
					
			
			Thread.sleep(3000);
			System.out.println("********************* End of Zip Code Report *************************");
			test.log(LogStatus.INFO, "********************* End of Zip Code Report *************************");

		
		Thread.sleep(1000);
		//Scroll the web page
	    for(int i=1; i <= 15; i++)
	    {
	    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
	    	Thread.sleep(1000);
	    }
	}

		@Test(priority=14)
		public void SaleRecap_Enterprise_Report_Method_For_openpage(WebDriver driver) throws Exception
		{
		/*	//Click the My Stores option
			driver.findElement(By.xpath("//span[.='My Stores']")).click();

			Thread.sleep(3000);
	        //Click the EnterPrise Reports Option		
			driver.findElement(By.xpath("//span[.='EnterPrise Reports']")).click();
			
			Thread.sleep(2000);
			//Click the Sale option
			driver.findElement(By.xpath("//span[.='Sale']")).click();		*/
			
			Thread.sleep(2000);
			//Enter the URl
			driver.get(Utility.getProperty("Enterprise_Base_URL")+"enterPriseReport/saleRecapSummary");

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
			
			Thread.sleep(5000);
			
		}
		
		@Test(priority=15)
		public void SaleRecap_Enterprise_Report_Method_For_Non_Close_Sales(WebDriver driver) throws Exception
		{


			Thread.sleep(3000);
			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/input")).sendKeys(Utility.getReportProperty("Store"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(1500);
			//Click the Select reacp Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/input")).sendKeys("Non close sales");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(1500);
			//Click the Employee Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("All");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
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
				
				Thread.sleep(5000);
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
				
				
				
				Thread.sleep(5000);
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
				
		@Test(priority=16)
		public void SaleRecap_Enterprise_Report_Method_For_Timeperiod(WebDriver driver) throws Exception
		{


			Thread.sleep(3000);
			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/input")).sendKeys(Utility.getReportProperty("Store"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(1500);
			//Click the Select reacp Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/input")).sendKeys("Time period");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(1500);
			//Click the Employee Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("All");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(3000);
			//Click the Time Period option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/a")).click();
			//Enter the required Time Period
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter Key
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/input[1]")).clear();
			//Enter the date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

			Thread.sleep(2000);
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/input[2]")).clear();
			//Enter the date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));

			
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
				
				Thread.sleep(5000);
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
				
				
				
				Thread.sleep(5000);
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

		@Test(priority=17)
		public void CashierOut_Enterprise_Report_Method_For_openpage(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Enter the URl
			driver.get(Utility.getProperty("Enterprise_Base_URL")+"enterPriseReport/cashierOutSummary");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				
				
		Thread.sleep(5000);
		//Check CashierOut Report page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/div/div/ul/li[10]/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Cashier out"))
		{
			test.log(LogStatus.PASS, "CashierOut Sale Report page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "CashierOut Sale Report page loaded Failed");
		}
		
		Thread.sleep(3000);
		}
		
		@Test(priority=18)
		public void CashierOut_Enterprise_Report_Verify(WebDriver driver) throws Exception
		{
	
	
			Thread.sleep(3000);
			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/input")).sendKeys("Store 01");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(1500);
			//Click the Employee Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("All");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			
			Thread.sleep(3000);
			//Click the Time Period option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
			//Enter the required Time Period
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter Key
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
			//Enter the date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
			//Enter the date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
	
			
			Thread.sleep(1000);
			//Click the Run button
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
			
		}
				
		@Test(priority=19)
		public void Weekly_Summary_Enterprise_Report_Method_For_openpage(WebDriver driver) throws Exception
		{
			
		/*	//Click the My Stores option
			driver.findElement(By.xpath("//span[.='My Stores']")).click();
	
			Thread.sleep(3000);
	        //Click the EnterPrise Reports Option		
			driver.findElement(By.xpath("//span[.='EnterPrise Reports']")).click();
			
			Thread.sleep(2000);
			//Click the Sale option
			driver.findElement(By.xpath("//span[.='Sale']")).click();
			
			Thread.sleep(2000);
			// Create instance of Java script executor
	    	JavascriptExecutor je1 = (JavascriptExecutor) driver;
	    	//Identify the WebElement which will appear after scrolling down
			WebElement element1 = driver.findElement(By.xpath("//span[.='Weekly Summary']"));
			//Scroll the page till the Weekly Summary option present
			je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
				
			
			*/
			Thread.sleep(2000);
			//Enter the URl
			driver.get(Utility.getProperty("Enterprise_Base_URL")+"enterPriseReport/weeklySaleSummary");
	
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
			
			Thread.sleep(5000);
			//Check Weekly Report page opened or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/div/div/ul/li[11]/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Weekly Summary"))
			{
				test.log(LogStatus.PASS, "Weekly Sale Report page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Weekly Sale Report page loaded Failed");
			}
			
			Thread.sleep(5000);
			
		}
				
		@Test(priority=20)
		public void Weekly_Summary_Enterprise_Report_Method_For_This_Week(WebDriver driver) throws Exception
		{
			Thread.sleep(5000);
			List<WebElement> close = driver.findElements(By.xpath("//form[@name='saleReport']/div[1]/div/div/ul/li/a"));
			close.size();	
			for(int i = 1; i <= close.size(); i++)
			{
				//Click the Close button for all stores
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/ul/li[1]/a")).click();
			}
			Thread.sleep(3000);
			//Click the Store option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/ul/li/input")).click();
			//Enter the required Time Period
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/ul/li/input")).sendKeys(Utility.getReportProperty("Store"));
			//Press the Enter Key
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
	
			Thread.sleep(3000);
			//Click the Time Period option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
			//Enter the required Time Period
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("This week");
			//Press the Enter Key
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
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
		
		@Test(priority=21)
		public void Weekly_Summary_Enterprise_Report_Method_For_Last_Week(WebDriver driver) throws Exception
		{
			Thread.sleep(5000);
			List<WebElement> close = driver.findElements(By.xpath("//form[@name='saleReport']/div[1]/div/div/ul/li/a"));
			close.size();	
			for(int i = 1; i <= close.size(); i++)
			{
				//Click the Close button for all stores
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/ul/li[1]/a")).click();
			}
			Thread.sleep(3000);
			//Click the Store option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/ul/li/input")).click();
			//Enter the required Time Period
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/ul/li/input")).sendKeys(Utility.getReportProperty("Store"));
			//Press the Enter Key
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
	
			Thread.sleep(3000);
			//Click the Time Period option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
			//Enter the required Time Period
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("Last week");
			//Press the Enter Key
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
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
		
		@Test(priority=22)
		public void Weekly_Summary_Enterprise_Report_Method_For_Last7days(WebDriver driver) throws Exception
		{
			Thread.sleep(5000);
			List<WebElement> close = driver.findElements(By.xpath("//form[@name='saleReport']/div[1]/div/div/ul/li/a"));
			close.size();	
			for(int i = 1; i <= close.size(); i++)
			{
				//Click the Close button for all stores
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/ul/li[1]/a")).click();
			}
			Thread.sleep(3000);
			//Click the Store option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/ul/li/input")).click();
			//Enter the required Time Period
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/ul/li/input")).sendKeys(Utility.getReportProperty("Store"));
			//Press the Enter Key
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
	
			Thread.sleep(3000);
			//Click the Time Period option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
			//Enter the required Time Period
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("Last 7 days");
			//Press the Enter Key
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
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

		@Test(priority=23)
		public void Sale_Summary_Enterprise_Report_Method_For_openpage(WebDriver driver) throws Exception
		{
		/*	//Click the My Stores option
			driver.findElement(By.xpath("//span[.='My Stores']")).click();

			Thread.sleep(3000);
	        //Click the EnterPrise Reports Option		
			driver.findElement(By.xpath("//span[.='EnterPrise Reports']")).click();
			
			
			Thread.sleep(2000);
			//Click the Sale option
			driver.findElement(By.xpath("//span[.='Sale']")).click();	*/
			
			Thread.sleep(2000);
			//Enter the URl
			driver.get(Utility.getProperty("Enterprise_Base_URL")+"enterPriseReport/saleSummary");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@class='btn nav-button right-nav-button']")).click();
			driver.findElement(By.xpath("//button[@class='btn nav-button right-nav-button']")).click();
			driver.findElement(By.xpath("//button[@class='btn nav-button right-nav-button']")).click();
			driver.findElement(By.xpath("//button[@class='btn nav-button right-nav-button']")).click();
			driver.findElement(By.xpath("//button[@class='btn nav-button right-nav-button']")).click();
			driver.findElement(By.xpath("//button[@class='btn nav-button right-nav-button']")).click();
			driver.findElement(By.xpath("//button[@class='btn nav-button right-nav-button']")).click();
			
			Thread.sleep(3000);
			//Check Sale_Summary Report page opened or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/div/div/ul/li[12]/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Sale Summary"))
			{
				test.log(LogStatus.PASS, "Sale_Summary Report page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Sale_Summary Report page loaded Failed");
			}
			
			Thread.sleep(3000);
			
		}
		
		@Test(priority=24)
		public void Sale_Summary_Enterprise_Report_Method_For_Stores(WebDriver driver) throws Exception
		{


			Thread.sleep(3000);
			System.out.println("********************* View The Store Report *************************");
			test.log(LogStatus.INFO, "********************* View The Store Report *************************");

			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
	
			Thread.sleep(1500);
			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("Stores");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);

			
			Thread.sleep(1500);
			//Click the Select Some Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul")).click();
			//Remove the store name
			//driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li[1]/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Store"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(1500);
			//Click the Select Employee Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("All");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

			Thread.sleep(1500);
			//Click the Time Period Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
			Thread.sleep(3000);
			//Click the Service Type
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul")).click();
			//Enter the required Service type
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Utility.getReportProperty("Service_Type"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(3000);
			//Click the Run button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			try
			{
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(!driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Sale Summary Report available for Specific Date");
					
					Thread.sleep(5000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr"));
				        
		                 //Print number of Rows
				        System.out.println("Number of Rows are : "+rows);
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
				        
				        //Check weather the Net Sale Amount Report is correct or not
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Net Sale Amount");
				        	
				        	//Get the Total value of Net Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Net Sale Amount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Net Sale Amount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Net Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Tax reports are same for Quantity");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Tax");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Inclusive_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Inclusive Tax");
				        	
				        	//Get the Total value of Inclusive Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Inclusive Tax value is : "+actualText);		 
				        	
				        	test.log(LogStatus.INFO, "The Actual Inclusive Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Inclusive Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("CC_Service_Charge")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
				        	
				        	//Get the Total value of CC Service Charge
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

				        	System.out.println("The Actual CC Service Charge value is : "+actualText);	
				        	
				        	test.log(LogStatus.INFO, "The Actual CC Service Charge value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for CC Service Charge");
				        	
				        	//Get the Total value of CC Service Charge
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Discount");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText().equals(Utility.getReportProperty("Gross_Receipt")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Gross Receipt");
				        	
				        	//Get the Total value of Gross Receipt
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();

				        	System.out.println("The Actual Gross Receipt value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Gross Receipt value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Gross Receipt");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();
				        	
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
				        
				   //Get the Detail for Each and Every Check
				        for(int i = 1; i < rows.size(); i++)
				        {
				        	Thread.sleep(3000);
				        	//Click the required check
				        	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]/a")).click();
				        	
				        	
				        	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				        	Thread.sleep(3000);
				        	//Clear the mail field
				        	driver.findElement(By.xpath("//input[@ng-model='saleSummary.email']")).clear();
				        	//Enter the required mail
				        	driver.findElement(By.xpath("//input[@ng-model='saleSummary.email']")).sendKeys("test@mail.com");

				        	
				        	Thread.sleep(3000);
				        	System.out.println("The Check ("+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText()+") have the following details :");
				        	
				        	test.log(LogStatus.INFO, "The Check ("+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText()+") have the following details :");
				       
				        	System.out.println("Check Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Check Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText());
				        	
				        	System.out.println("Date is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[3]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Date is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[3]/td")).getText());

				        	System.out.println("Table is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[4]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Table is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[4]/td")).getText());

				        	System.out.println("Seat Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[5]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Seat Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[5]/td")).getText());

				        	System.out.println("Server Name is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[6]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Server Name is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[6]/td")).getText());

				        	System.out.println("Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[7]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[7]/td")).getText());

				        	System.out.println("Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[8]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[8]/td")).getText());

				        	System.out.println("CC Service Charge is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[9]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "CC Service Charge is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[9]/td")).getText());

				        	System.out.println("Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[10]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[10]/td")).getText());

				        	System.out.println("Total Tip is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[11]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Total Tip is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[11]/td")).getText());


				        	Thread.sleep(2000);
					    	//Check Whether the Send Receipt is enabled or not
					    	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/div/div[2]/button")).isEnabled())
					    	{
					    	Thread.sleep(3000);
					    	//Click the Send Receipt
					    	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/div/div[2]/button")).click();
					    	
							    	Thread.sleep(5000);
							    	//Check whether the receipt sent successfully or not
							    	if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Email receipt sent successfully"))
							    	{
							    		test.log(LogStatus.PASS, "Email Receipt sent successfully for store");
							    	}
							    	
							    	else
							    	{
							    		test.log(LogStatus.FAIL, "Email Receipt sent fail for store");
							    	}
					    	}
					    	
					    	//Get the row size of tax table
					    	List<WebElement> taxRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[1]/table/tbody/tr"));
					    	
					    		Thread.sleep(3000);
					    		System.out.println("Total Tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[1]/table/tbody/tr["+taxRow.size()+"]/td[2]")).getText());
					    		
					    		test.log(LogStatus.PASS, "Total Tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[1]/table/tbody/tr["+taxRow.size()+"]/td[2]")).getText());
					    	
					    	//Check whether the Payment summary is available or not
					    	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[2]/table/tbody/tr[3]/td[5]")) != null)
					    	{
					    		test.log(LogStatus.PASS, "Payment Summary report is available");
					    	}
					    	
					    	else
					    	{
					    		test.log(LogStatus.FAIL, "Payment Summary report is not available");
					    	}
					    	
					    	//Get the row size of order summary table
					    	List<WebElement> orderSummaryRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[2]/table/tbody/tr"));
					    	
					    		Thread.sleep(3000);
					    		System.out.println("Order Summary subtotal is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[2]/table/tbody/tr["+orderSummaryRow.size()+"]/td[2]")).getText());
					    		
					    		test.log(LogStatus.PASS, "Order Summary subtotal is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[2]/table/tbody/tr["+orderSummaryRow.size()+"]/td[2]")).getText());
				
					    		Thread.sleep(3000);
					    		
					    		//Click the Back button
					    		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/div/div[2]/a/i")).click();
					    		
					    		Thread.sleep(2000);
					    	
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

				test.log(LogStatus.FAIL, "Sale_Summary Sale Report is not available for Specific Date");

			}
					
			Thread.sleep(3000);
			System.out.println("********************* End of Store Report *************************");
			test.log(LogStatus.INFO, "********************* End of Store Report *************************");

			
		}
		
		@Test(priority=25)
		public void Sale_Summary_Enterprise_Report_Method_For_Group(WebDriver driver) throws Exception
		{

			Thread.sleep(3000);
			System.out.println("********************* View The Group Report *************************");
			test.log(LogStatus.INFO, "********************* View The Group Report *************************");
			
			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(1500);
			//Click the Select Some Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Group"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(1500);
			//Click the Select Employee Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("All");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

			Thread.sleep(1500);
			//Click the Time Period Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
			Thread.sleep(3000);
			//Click the Service Type
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul")).click();
			//Remove old the Service Type
		    driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li[1]/a")).click();
			//Enter the required Service type
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Utility.getReportProperty("Service_Type"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(3000);
			//Click the Run button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			try
			{
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(!driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Sale Summary Report available for Specific Date");
					
					Thread.sleep(5000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr"));
				        
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
				        
				        //Check weather the Net Sale Amount Report is correct or not
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Net Sale Amount");
				        	
				        	//Get the Total value of Net Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Net Sale Amount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Net Sale Amount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Net Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Tax reports are same for Quantity");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Tax");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Inclusive_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Inclusive Tax");
				        	
				        	//Get the Total value of Inclusive Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Inclusive Tax value is : "+actualText);		 
				        	
				        	test.log(LogStatus.INFO, "The Actual Inclusive Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Inclusive Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("CC_Service_Charge")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
				        	
				        	//Get the Total value of CC Service Charge
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

				        	System.out.println("The Actual CC Service Charge value is : "+actualText);	
				        	
				        	test.log(LogStatus.INFO, "The Actual CC Service Charge value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for CC Service Charge");
				        	
				        	//Get the Total value of CC Service Charge
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Discount");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText().equals(Utility.getReportProperty("Gross_Receipt")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Gross Receipt");
				        	
				        	//Get the Total value of Gross Receipt
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();

				        	System.out.println("The Actual Gross Receipt value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Gross Receipt value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Gross Receipt");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();
				        	
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
				        
						   //Get the Detail for Each and Every Check
				        for(int i = 1; i < rows.size(); i++)
				        {
				        	Thread.sleep(3000);
				        	//Click the required check
				        	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]/a")).click();
				        	
				        	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				        	Thread.sleep(3000);
				        	//Clear the mail field
				        	driver.findElement(By.xpath("//input[@ng-model='saleSummary.email']")).clear();
				        	//Enter the required mail
				        	driver.findElement(By.xpath("//input[@ng-model='saleSummary.email']")).sendKeys("test@mail.com");

				        	Thread.sleep(3000);
				        	System.out.println("The Check ("+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText()+") have the following details :");
				        	
				        	test.log(LogStatus.INFO, "The Check ("+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText()+") have the following details :");
				       
				        	System.out.println("Check Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Check Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText());
				        	
				        	System.out.println("Date is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[3]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Date is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[3]/td")).getText());

				        	System.out.println("Table is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[4]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Table is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[4]/td")).getText());

				        	System.out.println("Seat Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[5]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Seat Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[5]/td")).getText());

				        	System.out.println("Server Name is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[6]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Server Name is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[6]/td")).getText());

				        	System.out.println("Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[7]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[7]/td")).getText());

				        	System.out.println("Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[8]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[8]/td")).getText());

				        	System.out.println("CC Service Charge is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[9]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "CC Service Charge is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[9]/td")).getText());

				        	System.out.println("Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[10]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[10]/td")).getText());

				        	System.out.println("Total Tip is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[11]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Total Tip is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[11]/td")).getText());


				        	Thread.sleep(2000);
					    	//Check Whether the Send Receipt is enabled or not
					    	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/div/div[2]/button")).isEnabled())
					    	{
					    	Thread.sleep(3000);
					    	//Click the Send Receipt
					    	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/div/div[2]/button")).click();
					    	
							    	Thread.sleep(5000);
							    	//Check whether the receipt sent successfully or not
							    	if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Email receipt sent successfully"))
							    	{
							    		test.log(LogStatus.PASS, "Email Receipt sent successfully");
							    	}
							    	
							    	else
							    	{
							    		test.log(LogStatus.FAIL, "Email Receipt sent fail");
							    	}
					    	}
					    	
					    	//Get the row size of tax table
					    	List<WebElement> taxRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[1]/table/tbody/tr"));
					    	
					    		Thread.sleep(3000);
					    		System.out.println("Total Tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[1]/table/tbody/tr["+taxRow.size()+"]/td[2]")).getText());
					    		
					    		test.log(LogStatus.PASS, "Total Tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[1]/table/tbody/tr["+taxRow.size()+"]/td[2]")).getText());
					    	
					    	//Check whether the Payment summary is available or not
					    	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[2]/table/tbody/tr[3]/td[5]")) != null)
					    	{
					    		test.log(LogStatus.PASS, "Payment Summary report is available");
					    	}
					    	
					    	else
					    	{
					    		test.log(LogStatus.FAIL, "Payment Summary report is not available");
					    	}
					    	
					    	//Get the row size of order summary table
					    	List<WebElement> orderSummaryRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[2]/table/tbody/tr"));
					    	
					    		Thread.sleep(3000);
					    		System.out.println("Order Summary subtotal is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[2]/table/tbody/tr["+orderSummaryRow.size()+"]/td[2]")).getText());
					    		
					    		test.log(LogStatus.PASS, "Order Summary subtotal is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[2]/table/tbody/tr["+orderSummaryRow.size()+"]/td[2]")).getText());
				
					    		Thread.sleep(3000);
					    		
					    		//Click the Back button
					    		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/div/div[2]/a/i")).click();
					    		
					    		Thread.sleep(2000);
					    	
				        }
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date for Group");
					}
				}
			}
			
			catch(Exception e)
			{

				test.log(LogStatus.FAIL, "Sale_Summary Sale Report is not available for Specific Date for Group");

			}
					
			
			Thread.sleep(3000);
			System.out.println("********************* End of Group Report *************************");
			test.log(LogStatus.INFO, "********************* End of Group Report *************************");
		}
		
		@Test(priority=26)
		public void Sale_Summary_Enterprise_Report_Method_For_City(WebDriver driver) throws Exception
		{

			Thread.sleep(3000);
			System.out.println("********************* View The City Report *************************");
			test.log(LogStatus.INFO, "********************* View The City Report *************************");

			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("City");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(1500);
			//Click the Select Some Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("City"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(1500);
			//Click the Select Employee Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("All");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

			Thread.sleep(1500);
			//Click the Time Period Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
			Thread.sleep(3000);
			//Click the Service Type
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul")).click();
			//Remove old the Service Type
		    driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li[1]/a")).click();
			//Enter the required Service type
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Utility.getReportProperty("Service_Type"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(3000);
			//Click the Run button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			try
			{
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(!driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Sale Summary Report available for Specific Date");
					
					Thread.sleep(5000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr"));
				        
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
				        
				        //Check weather the Net Sale Amount Report is correct or not
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Net Sale Amount");
				        	
				        	//Get the Total value of Net Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Net Sale Amount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Net Sale Amount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Net Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Tax reports are same for Quantity");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Tax");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Inclusive_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Inclusive Tax");
				        	
				        	//Get the Total value of Inclusive Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Inclusive Tax value is : "+actualText);		 
				        	
				        	test.log(LogStatus.INFO, "The Actual Inclusive Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Inclusive Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("CC_Service_Charge")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
				        	
				        	//Get the Total value of CC Service Charge
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

				        	System.out.println("The Actual CC Service Charge value is : "+actualText);	
				        	
				        	test.log(LogStatus.INFO, "The Actual CC Service Charge value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for CC Service Charge");
				        	
				        	//Get the Total value of CC Service Charge
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Discount");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText().equals(Utility.getReportProperty("Gross_Receipt")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Gross Receipt");
				        	
				        	//Get the Total value of Gross Receipt
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();

				        	System.out.println("The Actual Gross Receipt value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Gross Receipt value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Gross Receipt");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();
				        	
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
				        
						   //Get the Detail for Each and Every Check
				        for(int i = 1; i < rows.size(); i++)
				        {
				        	Thread.sleep(3000);
				        	//Click the required check
				        	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]/a")).click();
				        	
				        	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				        	Thread.sleep(3000);
				        	//Clear the mail field
				        	driver.findElement(By.xpath("//input[@ng-model='saleSummary.email']")).clear();
				        	//Enter the required mail
				        	driver.findElement(By.xpath("//input[@ng-model='saleSummary.email']")).sendKeys("test@mail.com");

				        	Thread.sleep(3000);
				        	System.out.println("The Check ("+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText()+") have the following details :");
				        	
				        	test.log(LogStatus.INFO, "The Check ("+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText()+") have the following details :");
				       
				        	System.out.println("Check Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Check Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText());
				        	
				        	System.out.println("Date is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[3]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Date is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[3]/td")).getText());

				        	System.out.println("Table is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[4]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Table is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[4]/td")).getText());

				        	System.out.println("Seat Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[5]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Seat Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[5]/td")).getText());

				        	System.out.println("Server Name is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[6]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Server Name is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[6]/td")).getText());

				        	System.out.println("Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[7]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[7]/td")).getText());

				        	System.out.println("Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[8]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[8]/td")).getText());

				        	System.out.println("CC Service Charge is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[9]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "CC Service Charge is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[9]/td")).getText());

				        	System.out.println("Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[10]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[10]/td")).getText());

				        	System.out.println("Total Tip is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[11]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Total Tip is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[11]/td")).getText());


				        	Thread.sleep(2000);
					    	//Check Whether the Send Receipt is enabled or not
					    	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/div/div[2]/button")).isEnabled())
					    	{
					    	Thread.sleep(3000);
					    	//Click the Send Receipt
					    	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/div/div[2]/button")).click();
					    	
							    	Thread.sleep(5000);
							    	//Check whether the receipt sent successfully or not
							    	if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Email receipt sent successfully"))
							    	{
							    		test.log(LogStatus.PASS, "Email Receipt sent successfully");
							    	}
							    	
							    	else
							    	{
							    		test.log(LogStatus.FAIL, "Email Receipt sent fail");
							    	}
					    	}
					    	
					    	//Get the row size of tax table
					    	List<WebElement> taxRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[1]/table/tbody/tr"));
					    	
					    		Thread.sleep(3000);
					    		System.out.println("Total Tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[1]/table/tbody/tr["+taxRow.size()+"]/td[2]")).getText());
					    		
					    		test.log(LogStatus.PASS, "Total Tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[1]/table/tbody/tr["+taxRow.size()+"]/td[2]")).getText());
					    	
					    	//Check whether the Payment summary is available or not
					    	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[2]/table/tbody/tr[3]/td[5]")) != null)
					    	{
					    		test.log(LogStatus.PASS, "Payment Summary report is available");
					    	}
					    	
					    	else
					    	{
					    		test.log(LogStatus.FAIL, "Payment Summary report is not available");
					    	}
					    	
					    	//Get the row size of order summary table
					    	List<WebElement> orderSummaryRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[2]/table/tbody/tr"));
					    	
					    		Thread.sleep(3000);
					    		System.out.println("Order Summary subtotal is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[2]/table/tbody/tr["+orderSummaryRow.size()+"]/td[2]")).getText());
					    		
					    		test.log(LogStatus.PASS, "Order Summary subtotal is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[2]/table/tbody/tr["+orderSummaryRow.size()+"]/td[2]")).getText());
				
					    		Thread.sleep(3000);
					    		
					    		//Click the Back button
					    		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/div/div[2]/a/i")).click();
					    		
					    		Thread.sleep(2000);
					    	
				        }
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date for City");
					}
				}
			}
			
			catch(Exception e)
			{

				test.log(LogStatus.FAIL, "Sale_Summary Sale Report is not available for Specific Date for City");

			}
					
			
			Thread.sleep(3000);
			System.out.println("********************* End of City Report *************************");
			test.log(LogStatus.INFO, "********************* End of City Report *************************");
		}
			
		@Test(priority=27)
		public void Sale_Summary_Enterprise_Report_Method_For_State(WebDriver driver) throws Exception
		{

			Thread.sleep(3000);
			System.out.println("********************* View The State Report *************************");
			test.log(LogStatus.INFO, "********************* View The State Report *************************");

			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("State");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(1500);
			//Click the Select Some Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("State"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(1500);
			//Click the Select Employee Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("All");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

			Thread.sleep(1500);
			//Click the Time Period Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
			Thread.sleep(3000);
			//Click the Service Type
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul")).click();
			//Remove old the Service Type
		    driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li[1]/a")).click();
			//Enter the required Service type
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Utility.getReportProperty("Service_Type"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(3000);
			//Click the Run button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			try
			{
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(!driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Sale Summary Report available for Specific Date");
					
					Thread.sleep(5000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr"));
				        
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
				        
				        //Check weather the Net Sale Amount Report is correct or not
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Net Sale Amount");
				        	
				        	//Get the Total value of Net Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Net Sale Amount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Net Sale Amount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Net Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Tax reports are same for Quantity");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Tax");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Inclusive_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Inclusive Tax");
				        	
				        	//Get the Total value of Inclusive Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Inclusive Tax value is : "+actualText);		 
				        	
				        	test.log(LogStatus.INFO, "The Actual Inclusive Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Inclusive Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("CC_Service_Charge")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
				        	
				        	//Get the Total value of CC Service Charge
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

				        	System.out.println("The Actual CC Service Charge value is : "+actualText);	
				        	
				        	test.log(LogStatus.INFO, "The Actual CC Service Charge value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for CC Service Charge");
				        	
				        	//Get the Total value of CC Service Charge
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Discount");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText().equals(Utility.getReportProperty("Gross_Receipt")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Gross Receipt");
				        	
				        	//Get the Total value of Gross Receipt
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();

				        	System.out.println("The Actual Gross Receipt value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Gross Receipt value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Gross Receipt");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();
				        	
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
				        
						   //Get the Detail for Each and Every Check
				        for(int i = 1; i < rows.size(); i++)
				        {
				        	Thread.sleep(3000);
				        	//Click the required check
				        	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]/a")).click();
				        	
				        	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				        	Thread.sleep(3000);
				        	//Clear the mail field
				        	driver.findElement(By.xpath("//input[@ng-model='saleSummary.email']")).clear();
				        	//Enter the required mail
				        	driver.findElement(By.xpath("//input[@ng-model='saleSummary.email']")).sendKeys("test@mail.com");
				        	
				        	Thread.sleep(3000);
				        	System.out.println("The Check ("+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText()+") have the following details :");
				        	
				        	test.log(LogStatus.INFO, "The Check ("+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText()+") have the following details :");
				       
				        	System.out.println("Check Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Check Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText());
				        	
				        	System.out.println("Date is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[3]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Date is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[3]/td")).getText());

				        	System.out.println("Table is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[4]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Table is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[4]/td")).getText());

				        	System.out.println("Seat Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[5]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Seat Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[5]/td")).getText());

				        	System.out.println("Server Name is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[6]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Server Name is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[6]/td")).getText());

				        	System.out.println("Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[7]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[7]/td")).getText());

				        	System.out.println("Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[8]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[8]/td")).getText());

				        	System.out.println("CC Service Charge is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[9]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "CC Service Charge is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[9]/td")).getText());

				        	System.out.println("Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[10]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[10]/td")).getText());

				        	System.out.println("Total Tip is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[11]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Total Tip is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[11]/td")).getText());


				        	Thread.sleep(2000);
					    	//Check Whether the Send Receipt is enabled or not
					    	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/div/div[2]/button")).isEnabled())
					    	{
					    	Thread.sleep(3000);
					    	//Click the Send Receipt
					    	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/div/div[2]/button")).click();
					    	
							    	Thread.sleep(5000);
							    	//Check whether the receipt sent successfully or not
							    	if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Email receipt sent successfully"))
							    	{
							    		test.log(LogStatus.PASS, "Email Receipt sent successfully");
							    	}
							    	
							    	else
							    	{
							    		test.log(LogStatus.FAIL, "Email Receipt sent fail");
							    	}
					    	}
					    	
					    	//Get the row size of tax table
					    	List<WebElement> taxRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[1]/table/tbody/tr"));
					    	
					    		Thread.sleep(3000);
					    		System.out.println("Total Tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[1]/table/tbody/tr["+taxRow.size()+"]/td[2]")).getText());
					    		
					    		test.log(LogStatus.PASS, "Total Tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[1]/table/tbody/tr["+taxRow.size()+"]/td[2]")).getText());
					    	
					    	//Check whether the Payment summary is available or not
					    	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[2]/table/tbody/tr[3]/td[5]")) != null)
					    	{
					    		test.log(LogStatus.PASS, "Payment Summary report is available");
					    	}
					    	
					    	else
					    	{
					    		test.log(LogStatus.FAIL, "Payment Summary report is not available");
					    	}
					    	
					    	//Get the row size of order summary table
					    	List<WebElement> orderSummaryRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[2]/table/tbody/tr"));
					    	
					    		Thread.sleep(3000);
					    		System.out.println("Order Summary subtotal is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[2]/table/tbody/tr["+orderSummaryRow.size()+"]/td[2]")).getText());
					    		
					    		test.log(LogStatus.PASS, "Order Summary subtotal is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[2]/table/tbody/tr["+orderSummaryRow.size()+"]/td[2]")).getText());
				
					    		Thread.sleep(3000);
					    		
					    		//Click the Back button
					    		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/div/div[2]/a/i")).click();
					    		
					    		Thread.sleep(2000);
					    	
				        }
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date for State");
					}
				}
			}
			
			catch(Exception e)
			{

				test.log(LogStatus.FAIL, "Sale_Summary Sale Report is not available for Specific Date for State");

			}
					
			
			Thread.sleep(3000);
			System.out.println("********************* End of State Report *************************");
			test.log(LogStatus.INFO, "********************* End of State Report *************************");
		}

		@Test(priority=28)
		public void Sale_Summary_Enterprise_Report_Method_For_ZipCode(WebDriver driver) throws Exception
		{

			Thread.sleep(3000);
			System.out.println("********************* View The Zip Code Report *************************");
			test.log(LogStatus.INFO, "********************* View The Zip Code Report *************************");
			
			//Click the Select option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/a")).click();
			//Enter the required filter
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys("Zip Code");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(1500);
			//Click the Select Some Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Zipcode"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(1500);
			//Click the Select Employee Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("All");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

			Thread.sleep(1500);
			//Click the Time Period Options
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/a")).click();
			//Enter the required option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
			//Enter the required date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
			Thread.sleep(3000);
			//Click the Service Type
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul")).click();
			
			//Remove old the Service Type
		    driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li[1]/a")).click();
			
			//Enter the required Service type  
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Utility.getReportProperty("Service_Type"));
			//Press the Enter button
			driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			
			Thread.sleep(3000);
			//Click the Run button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			try
			{
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(!driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Sale Summary Report available for Specific Date");
					
					Thread.sleep(5000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr"));
				        
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
				        
				        //Check weather the Net Sale Amount Report is correct or not
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Net Sale Amount");
				        	
				        	//Get the Total value of Net Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Net Sale Amount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Net Sale Amount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Net Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Tax reports are same for Quantity");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Tax");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Inclusive_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Inclusive Tax");
				        	
				        	//Get the Total value of Inclusive Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Inclusive Tax value is : "+actualText);		 
				        	
				        	test.log(LogStatus.INFO, "The Actual Inclusive Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Inclusive Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("CC_Service_Charge")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
				        	
				        	//Get the Total value of CC Service Charge
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

				        	System.out.println("The Actual CC Service Charge value is : "+actualText);	
				        	
				        	test.log(LogStatus.INFO, "The Actual CC Service Charge value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for CC Service Charge");
				        	
				        	//Get the Total value of CC Service Charge
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Discount");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText().equals(Utility.getReportProperty("Gross_Receipt")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Gross Receipt");
				        	
				        	//Get the Total value of Gross Receipt
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();

				        	System.out.println("The Actual Gross Receipt value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Gross Receipt value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Gross Receipt");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[8]/span")).getText();
				        	
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
				        
						   //Get the Detail for Each and Every Check
				        for(int i = 1; i < rows.size(); i++)
				        {
				        	
				        	
				        	Thread.sleep(3000);
				        	//Click the required check
				        	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]/a")).click();
				        	
				        	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				        	Thread.sleep(3000);
				        	//Clear the mail field
				        	driver.findElement(By.xpath("//input[@ng-model='saleSummary.email']")).clear();
				        	//Enter the required mail
				        	driver.findElement(By.xpath("//input[@ng-model='saleSummary.email']")).sendKeys("test@mail.com");
				        	
				        	Thread.sleep(3000);
				        	System.out.println("The Check ("+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText()+") have the following details :");
				        	
				        	test.log(LogStatus.INFO, "The Check ("+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText()+") have the following details :");
				       
				        	System.out.println("Check Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Check Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText());
				        	
				        	System.out.println("Date is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[3]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Date is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[3]/td")).getText());

				        	System.out.println("Table is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[4]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Table is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[4]/td")).getText());

				        	System.out.println("Seat Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[5]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Seat Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[5]/td")).getText());

				        	System.out.println("Server Name is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[6]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Server Name is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[6]/td")).getText());

				        	System.out.println("Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[7]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[7]/td")).getText());

				        	System.out.println("Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[8]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[8]/td")).getText());

				        	System.out.println("CC Service Charge is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[9]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "CC Service Charge is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[9]/td")).getText());

				        	System.out.println("Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[10]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[10]/td")).getText());

				        	System.out.println("Total Tip is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[11]/td")).getText());
				        	
				        	test.log(LogStatus.INFO, "Total Tip is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[1]/table/tbody/tr[11]/td")).getText());


				        	Thread.sleep(5000);
					    	//Check Whether the Send Receipt is enabled or not
					    	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/div/div[2]/button")).isEnabled())
					    	{
					    	Thread.sleep(5000);
					    	//Click the Send Receipt
					    	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/div/div[2]/button")).click();
					    	
							    	Thread.sleep(5000);
							    	//Check whether the receipt sent successfully or not
							    	if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Email receipt sent successfully"))
							    	{
							    		test.log(LogStatus.PASS, "Email Receipt sent successfully");
							    	}
							    	
							    	else
							    	{
							    		test.log(LogStatus.FAIL, "Email Receipt sent fail");
							    	}
					    	}
					    	
					    	//Get the row size of tax table
					    	List<WebElement> taxRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[1]/table/tbody/tr"));
					    	
					    		Thread.sleep(3000);
					    		System.out.println("Total Tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[1]/table/tbody/tr["+taxRow.size()+"]/td[2]")).getText());
					    		
					    		test.log(LogStatus.PASS, "Total Tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[1]/table/tbody/tr["+taxRow.size()+"]/td[2]")).getText());
					    	
					    	//Check whether the Payment summary is available or not
					    	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[3]/div/div[2]/table/tbody/tr[3]/td[5]")) != null)
					    	{
					    		test.log(LogStatus.PASS, "Payment Summary report is available");
					    	}
					    	
					    	else
					    	{
					    		test.log(LogStatus.FAIL, "Payment Summary report is not available");
					    	}
					    	
					    	//Get the row size of order summary table
					    	List<WebElement> orderSummaryRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[2]/table/tbody/tr"));
					    	
					    		Thread.sleep(3000);
					    		System.out.println("Order Summary subtotal is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[2]/table/tbody/tr["+orderSummaryRow.size()+"]/td[2]")).getText());
					    		
					    		test.log(LogStatus.PASS, "Order Summary subtotal is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/div[2]/table/tbody/tr["+orderSummaryRow.size()+"]/td[2]")).getText());
				
					    		Thread.sleep(3000);
					    		
					    		//Click the Back button
					    		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/div/div[2]/a/i")).click();
					    		
					    		Thread.sleep(2000);
					    	
				        }
					}
					else
					{
						Thread.sleep(3000);
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date for Zip Code");
					}
				}
			}
			
			catch(Exception e)
			{
				Thread.sleep(3000);
				test.log(LogStatus.FAIL, "Sale_Summary Sale Report is not available for Specific Date for Zip Code");

			}
					
			
			Thread.sleep(3000);
			System.out.println("********************* End of Zip Code Report *************************");
			test.log(LogStatus.INFO, "********************* End of Zip Code Report *************************");

		}
	}
