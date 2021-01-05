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
	
			@Test(priority=200)
			public void Sale_Summary_Sale_method_Report_open_Page() throws Exception
			{
			
				/*Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				*/
				
			/*	//Click the Reports option
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
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/saleSummary");
				
				Thread.sleep(4000);
				//Click the right arrow button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();

				//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				
				Thread.sleep(3000);
				//Check weather the Sale Summary page is opened or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/div/div/ul/li[11]/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Sale Summary"))
				{
					test.log(LogStatus.PASS, "Sale Summary Report Page Loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Sale Summary Report Page Loaded Fail");
				}
				Thread.sleep(3000);
			}
			
			@Test(priority=201)
			public void Sale_Saummary_Sale_method_Report_For_Specific_Date() throws Exception
			{

				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
				/*Thread.sleep(3000);
				//Click the Check Number Search option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
				//Enter the Check Number
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).sendKeys("0-007");
				*/
				
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
			
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Sale Summary Report is not available for the Required Date Range");
				}
				else
				{
					test.log(LogStatus.PASS, "Sale Summary Report available for the Required Date Range");
							
					Thread.sleep(3000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				        
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
				        
				        //Check weather the Transaction Date Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Net Transaction Date");
				        	
				        	//Get the Total value of Net Transaction Date
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Net Transaction Date Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Net Transaction Date Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Net Transaction Date Value is : "+ actual);
				        }
				        
						else if(expect1 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Check Count
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Net Transaction Date value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Net Transaction Date value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Net Transaction Date");
				        	
				        	//Get the Total value of Transaction Date
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the net Transaction Date Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect1;
				        	
				        	//Print the different value
				        	System.out.println("Net Transaction Date Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Net Transaction Date Value different is : "+different);	
				        }
				        
				        //Check weather the Tax Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Tax reports are same for Quantity");
				        	
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
							
				        	//Get the Total value of Quantity
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Tax");
				        	
				        	//Get the Total value of Quantity
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
				        
				        //Check weather the Inclusive Tax Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Inclusive_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Inclusive Tax");
				        	
				        	//Get the Total value of Inclusive Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Inclusive Tax value is : "+actualText);		 
				        	
				        	test.log(LogStatus.INFO, "The Actual Inclusive Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Inclusive Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("CC_Service_Charge")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
				        	
				        	//Get the Total value of CC Service Charge
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

				        	System.out.println("The Actual CC Service Charge value is : "+actualText);	
				        	
				        	test.log(LogStatus.INFO, "The Actual CC Service Charge value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for CC Service Charge");
				        	
				        	//Get the Total value of CC Service Charge
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Discount");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
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
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]/span")).getText().equals(Utility.getReportProperty("Gross_Receipt")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Gross Receipt");
				        	
				        	//Get the Total value of Gross Receipt
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]/span")).getText();
				        	
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
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]/span")).getText();

				        	System.out.println("The Actual Gross Receipt value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Gross Receipt value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Gross Receipt");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage Of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect6;
				        	
				        	//Print the different value
				        	System.out.println("Gross Receipt Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Gross Receipt Value different is : "+different);	
				        }
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
				}
			}

			@Test(priority=202)
			public void Sale_Saummary_Sale_method_Report_For_Specific_Date_WithService_Type() throws Exception
			{

				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
				/*Thread.sleep(3000);
				//Click the Check Number Search option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
				//Enter the Check Number
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).sendKeys("0-007");
				*/
				
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
			
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(3000);
				//Click the OrderType 		
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul")).click();
				Thread.sleep(3000);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Utility.getReportProperty("Service_Type"));
				
				Thread.sleep(1000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Sale Summary Report is not available for the Required Date Range and Required Service Type");
				}
				else
				{
					test.log(LogStatus.PASS, "Sale Summary Report available for the Required Date Range and Required Service Type");
				}
				
				Thread.sleep(5000);
				//Close the Service Type
				driver.findElement(By.xpath("//li[@class='search-choice']/a")).click();
			}

			@Test(priority=203)
			public void Sale_Saummary_Sale_method_Report_For_Specific_Date_WithSearch() throws Exception
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);	
				
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
			
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
						
				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(3000);
				//Get the value of first cell of table
				String check = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[10]/td[1]/a")).getText();
				
				Thread.sleep(3000);
				//Click the Check Number Search option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
				//Enter the Check Number
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).sendKeys(check);

				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Sale Summary Report is not available for the Required Date Range");
				}
				else
				{
					test.log(LogStatus.PASS, "Sale Summary Report available for the Required Date Range");
				}
				
				Thread.sleep(3000);
				//Click the Check Number Search option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
			}

			@Test(priority=204)
			public void Sale_Saummary_Sale_method_Report_For_Specific_Date_WithSearchAndServiceType() throws Exception
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);	
				
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
			
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
						
				Thread.sleep(3000);
				//Click the OrderType 		
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul")).click();
				Thread.sleep(3000);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys("QSR");
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys("Phone - DELIVERY");
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys("Web - DELIVERY");
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

				
				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Sale Summary Report is not available for the Required Date Range");
				}
				else
				{
					Thread.sleep(3000);
					//Get the value of first cell of table
					String check = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[1]/td[1]/a")).getText();
					
					Thread.sleep(3000);
					//Click the Check Number Search option
					driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
					//Enter the Check Number
					driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).sendKeys(check);

					Thread.sleep(3000);
					//Click the Run Button
					driver.findElement(By.xpath("//button[@type='submit']")).click();
					
					test.log(LogStatus.PASS, "Sale Summary Report available for the Required Date Range");
					
/*					String netSales = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[1]/td[3]/span")).getText();
					double netSalesAmt = Double.parseDouble(netSales);*/
					
					String totTax = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[1]/td[4]/span")).getText();
					double totTaxAmt = Double.parseDouble(totTax);
					
/*					String incTax = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[1]/td[5]/span")).getText();
					double inclusiveTaxAmt = Double.parseDouble(incTax);*/
					
					String ccServiceCharge = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[1]/td[6]/span")).getText();
					double ccServiceChargeAmt = Double.parseDouble(ccServiceCharge);
					
					String disc = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[1]/td[7]/span")).getText();
					double discAmt = Double.parseDouble(disc);
					
					String grossReceipt = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[1]/td[8]/span")).getText();
					double grossReceiptAmt = Double.parseDouble(grossReceipt);
					
					//Click the Required Check
					driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[1]/td[1]/a")).click();
					
					Thread.sleep(3000);
					//Get the Total Value
					String gross = driver.findElement(By.xpath("//th[.='Total']/../td")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double grossAmt = Double.parseDouble(gross);
				
					//Get the Tax Value
					String tx =  driver.findElement(By.xpath("//td[text()[normalize-space()='Tax Total']]/../td[2]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double txAmt = Double.parseDouble(tx);
				
					//Get the CC Service Charge Value
					String ccs =  driver.findElement(By.xpath("//th[contains(.,'CC Service')]/../..//tr[3]/td[4]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double ccsAmt = Double.parseDouble(ccs);
					
					//Get the Discount Value
					String dis =  driver.findElement(By.xpath("//th[.='Discount']/../td")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double disAmt = Double.parseDouble(dis);

					//Check whether the Gross Receipt value is correct or not 
					if(grossReceiptAmt == grossAmt)
					{
						test.log(LogStatus.PASS, "Gross Recipt value is correct");
					}
					else
					{
						double diff = grossReceiptAmt - grossAmt;
						test.log(LogStatus.FAIL, "Gross Recipt value is different : "+diff);
					}
					
					//Check whether the Total Tax is correct or not
					if(totTaxAmt == txAmt)
					{
						test.log(LogStatus.PASS, "Total Tax value is correct");
					}
					else
					{
						double diff = totTaxAmt - txAmt;
						test.log(LogStatus.FAIL, "Total Tax value is different : "+diff);
					}
					
					//Check whether the CC Service Charge is correct or not
					if(ccServiceChargeAmt == ccsAmt)
					{
						test.log(LogStatus.PASS, "CC Service Charge value is correct");
					}
					else
					{
						double diff = ccServiceChargeAmt - ccsAmt;
						test.log(LogStatus.FAIL, "CC Service Charge value is different : "+diff);
					}
					
					//Check Whether the Discount is Correct or not
					if(discAmt == disAmt)
					{
						test.log(LogStatus.PASS, "Discount value is correct");
					}
					else
					{
						double diff = discAmt - disAmt;
						test.log(LogStatus.FAIL, "Discount value is different : "+diff);
					}
					
					//Clear the email field
					driver.findElement(By.xpath("//input[@ng-model='saleSummary.email']")).clear();
					//Enter the Required mail id
					driver.findElement(By.xpath("//input[@ng-model='saleSummary.email']")).sendKeys("sappanimuthub@benseron.com");
					
					Thread.sleep(2000);
					//Click the Send Receipt button
					driver.findElement(By.xpath("//button[contains(.,'Send Receipt')]")).click();
					
					Thread.sleep(1500);
					if(driver.findElement(By.xpath("//span[contains(.,'Email receipt sent successfully')]")).getText().equalsIgnoreCase("Email receipt sent successfully"))
					{
						test.log(LogStatus.PASS, "Email receipt sent successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Email receipt sent fail");
					}
					
					
					Thread.sleep(2000);
					//Click the Send Receipt button
					driver.findElement(By.xpath("//i[@class='fa fa-file-pdf-o']/../../button/i")).click();
					
					Thread.sleep(2000);
					if(driver.findElement(By.xpath("//span[contains(.,'Payment Receipt sent successfully')]")).getText().equalsIgnoreCase("Payment Receipt sent successfully"))
					{
						test.log(LogStatus.PASS, "Payment receipt sent successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Payment receipt sent fail");
					}
					Thread.sleep(3000);
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
					Thread.sleep(5000);
					//Click the Back button
					driver.findElement(By.xpath("//button[@class='btn btn-small btn-blue ng-binding']/../a")).click();
					Thread.sleep(3000);
				}
				
				Thread.sleep(3000);
				//Click the Check Number Search option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
				
				//Close the Service Type
				driver.findElement(By.xpath("//li[@class='search-choice']/a")).click();
			}

			@Test(priority=205)
			public void Sale_Saummary_Sale_method_Report_For_Specific_Date_With_Dynamic_Report() throws Exception
			{

				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
				/*Thread.sleep(3000);
				//Click the Check Number Search option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
				//Enter the Check Number
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).sendKeys("0-007");
				*/
				
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
			
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				for(int i = 1; i <= 8; i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}Thread.sleep(3000);
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Change the option from enable to Disable the Transaction Date Option
						if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected())
						{
							//Click the Enabled Transaction Date Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Transaction Date')]"))).click().build().perform();
							try
							{
								//Check whether the Transaction Date Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Transaction Date is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Transaction Date is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Transaction Date Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Net sales Option
						if(driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected())
						{
							//Click the Enabled Net sales Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net sales')]"))).click().build().perform();
							try
							{
								//Check whether the Net sales Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Net sales is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Net sales is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Net sales Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Total tax amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected())
						{
							//Click the Enabled Total tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Total tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Total tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Total tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Total tax amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Total tax amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Inclusive tax amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected())
						{
							//Click the Enabled Inclusive tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Inclusive tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Inclusive tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Inclusive tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Inclusive tax amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Inclusive tax amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the CC Service Charge Option
						if(driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected())
						{
							//Click the Enabled CC Service Charge Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'CC Service Charge')]"))).click().build().perform();
							try
							{
								//Check whether the CC Service Charge Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "CC Service Charge is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "CC Service Charge is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "CC Service Charge Option is Disabled When user enter the required date for date range");
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
						
						//Change the option from enable to Disable the Gross Receipt Option
						if(driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
						{
							//Click the Enabled Gross Receipt Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Gross Receipt')]"))).click().build().perform();
							try
							{
								//Check whether the Gross Receipt Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Gross Receipt is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Gross Receipt is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Gross Receipt Option is Disabled When user enter the required date for date range");
						}
						
						//Enable the Transaction Date Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Transaction Date Option is Enabled after user click(Disable) the Transaction Date option");

						}
						else
						{
							//Click the Enabled Transaction Date Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Transaction Date')]"))).click().build().perform();
							try
							{
								//Check whether the Transaction Date Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Transaction Date is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Transaction Date is not displayed");
							}				
						}
						
						//Enable the Net sales Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Net sales Option is Enabled after user click(Disable) the Net Sales option");

						}
						else
						{
							//Click the Enabled Net sales Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net sales')]"))).click().build().perform();
							try
							{
								//Check whether the Net sales Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Net sales is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Net sales is not displayed");
							}				
						}
						
						//Enable the Total tax amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Total tax amount Option is Enabled after user click(Disable) the Total tax amount option");

						}
						else
						{
							//Click the Enabled Total tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Total tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Total tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Total tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Total tax amount is not displayed");
							}				
						}
						
						//Enable the Inclusive tax amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Inclusive tax amount Option is Enabled after user click(Disable) the Inclusive tax amount option");

						}
						else
						{
							//Click the Enabled Inclusive tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Inclusive tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Inclusive tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Inclusive tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Inclusive tax amount is not displayed");
							}				
						}
						
						//Enable the CC Service Charge Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "CC Service Charge Option is Enabled after user click(Disable) the CC Service Charge option");

						}
						else
						{
							//Click the Enabled CC Service Charge Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'CC Service Charge')]"))).click().build().perform();
							try
							{
								//Check whether the CC Service Charge Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "CC Service Charge is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "CC Service Charge is not displayed");
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
						
						//Disable the required option from enable to disable Gross Receipt Option
						if(driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Gross Receipt Option is Enabled after user click(Disable) the Gross Receipt option");

						}
						else
						{

							//Click the Enabled Gross Receipt Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Gross Receipt')]"))).click().build().perform();
							try
							{
								//Check whether the Gross Receipt Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Gross Receipt is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Gross Receipt is not displayed");
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

			@Test(priority=206)
			public void Sale_Saummary_Sale_method_Report_For_Specific_Date_WithService_Type_And_Dynamic_Report() throws Exception
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
				/*Thread.sleep(3000);
				//Click the Check Number Search option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
				//Enter the Check Number
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).sendKeys("0-007");
				*/
				
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
			
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(3000);
				//Click the OrderType 		
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul")).click();
				Thread.sleep(3000);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Utility.getReportProperty("Service_Type"));
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
				
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys("QSR");
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys("Web - DELIVERY");
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				for(int i = 1; i <= 8; i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}Thread.sleep(3000);
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Change the option from enable to Disable the Transaction Date Option
						if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected())
						{
							//Click the Enabled Transaction Date Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Transaction Date')]"))).click().build().perform();
							try
							{
								//Check whether the Transaction Date Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Transaction Date is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Transaction Date is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Transaction Date Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Net sales Option
						if(driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected())
						{
							//Click the Enabled Net sales Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net sales')]"))).click().build().perform();
							try
							{
								//Check whether the Net sales Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Net sales is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Net sales is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Net sales Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Total tax amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected())
						{
							//Click the Enabled Total tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Total tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Total tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Total tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Total tax amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Total tax amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Inclusive tax amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected())
						{
							//Click the Enabled Inclusive tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Inclusive tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Inclusive tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Inclusive tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Inclusive tax amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Inclusive tax amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the CC Service Charge Option
						if(driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected())
						{
							//Click the Enabled CC Service Charge Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'CC Service Charge')]"))).click().build().perform();
							try
							{
								//Check whether the CC Service Charge Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "CC Service Charge is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "CC Service Charge is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "CC Service Charge Option is Disabled When user enter the required date for date range");
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
						
						//Change the option from enable to Disable the Gross Receipt Option
						if(driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
						{
							//Click the Enabled Gross Receipt Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Gross Receipt')]"))).click().build().perform();
							try
							{
								//Check whether the Gross Receipt Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Gross Receipt is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Gross Receipt is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Gross Receipt Option is Disabled When user enter the required date for date range");
						}
						
						//Enable the Transaction Date Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Transaction Date Option is Enabled after user click(Disable) the Transaction Date option");

						}
						else
						{
							//Click the Enabled Transaction Date Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Transaction Date')]"))).click().build().perform();
							try
							{
								//Check whether the Transaction Date Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Transaction Date is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Transaction Date is not displayed");
							}				
						}
						
						//Enable the Net sales Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Net sales Option is Enabled after user click(Disable) the Net Sales option");

						}
						else
						{
							//Click the Enabled Net sales Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net sales')]"))).click().build().perform();
							try
							{
								//Check whether the Net sales Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Net sales is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Net sales is not displayed");
							}				
						}
						
						//Enable the Total tax amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Total tax amount Option is Enabled after user click(Disable) the Total tax amount option");

						}
						else
						{
							//Click the Enabled Total tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Total tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Total tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Total tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Total tax amount is not displayed");
							}				
						}
						
						//Enable the Inclusive tax amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Inclusive tax amount Option is Enabled after user click(Disable) the Inclusive tax amount option");

						}
						else
						{
							//Click the Enabled Inclusive tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Inclusive tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Inclusive tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Inclusive tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Inclusive tax amount is not displayed");
							}				
						}
						
						//Enable the CC Service Charge Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "CC Service Charge Option is Enabled after user click(Disable) the CC Service Charge option");

						}
						else
						{
							//Click the Enabled CC Service Charge Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'CC Service Charge')]"))).click().build().perform();
							try
							{
								//Check whether the CC Service Charge Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "CC Service Charge is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "CC Service Charge is not displayed");
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
						
						//Disable the required option from enable to disable Gross Receipt Option
						if(driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Gross Receipt Option is Enabled after user click(Disable) the Gross Receipt option");

						}
						else
						{

							//Click the Enabled Gross Receipt Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Gross Receipt')]"))).click().build().perform();
							try
							{
								//Check whether the Gross Receipt Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Gross Receipt is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Gross Receipt is not displayed");
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
				
				Thread.sleep(3000);
				//Close the Service Type
				driver.findElement(By.xpath("//li[@class='search-choice']/a")).click();

			}

			@Test(priority=207)
			public void Sale_Saummary_Sale_method_Report_For_Specific_Date_WithSearch_And_Dynamic_Report() throws Exception
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);	
				
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
			
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
						
				List<WebElement> close = driver.findElements(By.xpath("//label[.='Service Type']/../div/ul/li/a"));
				for(int i = 1; i <= close.size(); i++)
				{
					driver.findElement(By.xpath("//label[.='Service Type']/../div/ul/li["+i+"]/a")).click();
				}
				
				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				for(int i = 1; i <= 8; i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}Thread.sleep(3000);
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Change the option from enable to Disable the Transaction Date Option
						if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected())
						{
							//Click the Enabled Transaction Date Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Transaction Date')]"))).click().build().perform();
							try
							{
								//Check whether the Transaction Date Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Transaction Date is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Transaction Date is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Transaction Date Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Net sales Option
						if(driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected())
						{
							//Click the Enabled Net sales Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net sales')]"))).click().build().perform();
							try
							{
								//Check whether the Net sales Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Net sales is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Net sales is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Net sales Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Total tax amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected())
						{
							//Click the Enabled Total tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Total tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Total tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Total tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Total tax amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Total tax amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Inclusive tax amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected())
						{
							//Click the Enabled Inclusive tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Inclusive tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Inclusive tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Inclusive tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Inclusive tax amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Inclusive tax amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the CC Service Charge Option
						if(driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected())
						{
							//Click the Enabled CC Service Charge Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'CC Service Charge')]"))).click().build().perform();
							try
							{
								//Check whether the CC Service Charge Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "CC Service Charge is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "CC Service Charge is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "CC Service Charge Option is Disabled When user enter the required date for date range");
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
						
						//Change the option from enable to Disable the Gross Receipt Option
						if(driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
						{
							//Click the Enabled Gross Receipt Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Gross Receipt')]"))).click().build().perform();
							try
							{
								//Check whether the Gross Receipt Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Gross Receipt is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Gross Receipt is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Gross Receipt Option is Disabled When user enter the required date for date range");
						}
						
						//Enable the Transaction Date Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Transaction Date Option is Enabled after user click(Disable) the Transaction Date option");

						}
						else
						{
							//Click the Enabled Transaction Date Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Transaction Date')]"))).click().build().perform();
							try
							{
								//Check whether the Transaction Date Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Transaction Date is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Transaction Date is not displayed");
							}				
						}
						
						//Enable the Net sales Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Net sales Option is Enabled after user click(Disable) the Net Sales option");

						}
						else
						{
							//Click the Enabled Net sales Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net sales')]"))).click().build().perform();
							try
							{
								//Check whether the Net sales Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Net sales is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Net sales is not displayed");
							}				
						}
						
						//Enable the Total tax amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Total tax amount Option is Enabled after user click(Disable) the Total tax amount option");

						}
						else
						{
							//Click the Enabled Total tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Total tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Total tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Total tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Total tax amount is not displayed");
							}				
						}
						
						//Enable the Inclusive tax amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Inclusive tax amount Option is Enabled after user click(Disable) the Inclusive tax amount option");

						}
						else
						{
							//Click the Enabled Inclusive tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Inclusive tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Inclusive tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Inclusive tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Inclusive tax amount is not displayed");
							}				
						}
						
						//Enable the CC Service Charge Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "CC Service Charge Option is Enabled after user click(Disable) the CC Service Charge option");

						}
						else
						{
							//Click the Enabled CC Service Charge Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'CC Service Charge')]"))).click().build().perform();
							try
							{
								//Check whether the CC Service Charge Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "CC Service Charge is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "CC Service Charge is not displayed");
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
						
						//Disable the required option from enable to disable Gross Receipt Option
						if(driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Gross Receipt Option is Enabled after user click(Disable) the Gross Receipt option");

						}
						else
						{

							//Click the Enabled Gross Receipt Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Gross Receipt')]"))).click().build().perform();
							try
							{
								//Check whether the Gross Receipt Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Gross Receipt is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Gross Receipt is not displayed");
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
				
				Thread.sleep(3000);
				//Click the Check Number Search option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
				
				Thread.sleep(3000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);Thread.sleep(3000);
			}

			@Test(priority=208)
			public void Sale_Saummary_Sale_method_Report_For_Specific_Date_WithSearchAndServiceType_And_Dynamic_Report() throws Exception
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);	
				
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
			
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
						
				Thread.sleep(3000);
				//Click the OrderType 		
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul")).click();
				Thread.sleep(3000);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys("QSR");
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys("Phone - DELIVERY");
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys("Web - DELIVERY");
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				for(int i = 1; i <= 8; i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}Thread.sleep(3000);
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Change the option from enable to Disable the Transaction Date Option
						if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected())
						{
							//Click the Enabled Transaction Date Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Transaction Date')]"))).click().build().perform();
							try
							{
								//Check whether the Transaction Date Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Transaction Date is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Transaction Date is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Transaction Date Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Net sales Option
						if(driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected())
						{
							//Click the Enabled Net sales Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net sales')]"))).click().build().perform();
							try
							{
								//Check whether the Net sales Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Net sales is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Net sales is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Net sales Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Total tax amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected())
						{
							//Click the Enabled Total tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Total tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Total tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Total tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Total tax amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Total tax amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Inclusive tax amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected())
						{
							//Click the Enabled Inclusive tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Inclusive tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Inclusive tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Inclusive tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Inclusive tax amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Inclusive tax amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the CC Service Charge Option
						if(driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected())
						{
							//Click the Enabled CC Service Charge Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'CC Service Charge')]"))).click().build().perform();
							try
							{
								//Check whether the CC Service Charge Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "CC Service Charge is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "CC Service Charge is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "CC Service Charge Option is Disabled When user enter the required date for date range");
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
						
						//Change the option from enable to Disable the Gross Receipt Option
						if(driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
						{
							//Click the Enabled Gross Receipt Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Gross Receipt')]"))).click().build().perform();
							try
							{
								//Check whether the Gross Receipt Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Gross Receipt is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Gross Receipt is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Gross Receipt Option is Disabled When user enter the required date for date range");
						}
						
						//Enable the Transaction Date Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Transaction Date Option is Enabled after user click(Disable) the Transaction Date option");

						}
						else
						{
							//Click the Enabled Transaction Date Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Transaction Date')]"))).click().build().perform();
							try
							{
								//Check whether the Transaction Date Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Transaction Date is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Transaction Date is not displayed");
							}				
						}
						
						//Enable the Net sales Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Net sales Option is Enabled after user click(Disable) the Net Sales option");

						}
						else
						{
							//Click the Enabled Net sales Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net sales')]"))).click().build().perform();
							try
							{
								//Check whether the Net sales Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Net sales is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Net sales is not displayed");
							}				
						}
						
						//Enable the Total tax amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Total tax amount Option is Enabled after user click(Disable) the Total tax amount option");

						}
						else
						{
							//Click the Enabled Total tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Total tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Total tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Total tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Total tax amount is not displayed");
							}				
						}
						
						//Enable the Inclusive tax amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Inclusive tax amount Option is Enabled after user click(Disable) the Inclusive tax amount option");

						}
						else
						{
							//Click the Enabled Inclusive tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Inclusive tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Inclusive tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Inclusive tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Inclusive tax amount is not displayed");
							}				
						}
						
						//Enable the CC Service Charge Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "CC Service Charge Option is Enabled after user click(Disable) the CC Service Charge option");

						}
						else
						{
							//Click the Enabled CC Service Charge Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'CC Service Charge')]"))).click().build().perform();
							try
							{
								//Check whether the CC Service Charge Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "CC Service Charge is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "CC Service Charge is not displayed");
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
						
						//Disable the required option from enable to disable Gross Receipt Option
						if(driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Gross Receipt Option is Enabled after user click(Disable) the Gross Receipt option");

						}
						else
						{

							//Click the Enabled Gross Receipt Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Gross Receipt')]"))).click().build().perform();
							try
							{
								//Check whether the Gross Receipt Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Gross Receipt is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Gross Receipt is not displayed");
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
				
				Thread.sleep(3000);
				//Click the Check Number Search option
				//driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
				
				//Close the Service Type
				//driver.findElement(By.xpath("//li[@class='search-choice']/a")).click();
				Thread.sleep(3000);
			}

}
