package epicList;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
		
			@Test(priority=28,enabled=true)
			public void Employee_Payroll_Report_Method_DailyReport_Openpage() throws Exception
			{
			/*	//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Employee']"));
				//Scroll the page till the Transaction option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
			    //Click the Employee Option		
				driver.findElement(By.xpath("//span[.='Employee']")).click(); */
				
				Thread.sleep(3000); 
				//Enter the Users URL
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"payroll");
				
				Thread.sleep(5000);
				
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

			@Test(priority=29,enabled=true)
			public void Employee_Payroll_Report_Method_verifyDailyReport() throws Exception
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
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    Thread.sleep(1000);
			    //Select the Process as Daily
				Select process = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[2]/div/select")));
				process.selectByVisibleText("Daily");                               
			    
		  	    //Thread.sleep(1000);
			    //Select the Specific date Time Period option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Payroll_Date_Range_From"));

			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Payroll_Date_Range_To"));
				  
				    //Select the Format option
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/a")).click();
				    //Enter the required Format
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys("In Time");
				    //Press the Enter key
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				  
				    //Select the Active/Inactive option
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/a")).click();
				    //Enter the required Format
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys("All");
				    //Press the Enter key
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);

				    Thread.sleep(1000);
				    //Select the Process as Daily
					Select sort1 = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/select")));
					sort1.selectByVisibleText("A-Z FirstName");
					
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
						
						ArrayList<String> obtainedList = new ArrayList<>(); 
						List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
						for(int i = 1; i <= elementList.size(); i++)
						{
							String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
							
							String[] name = namess.split(" ");
							System.out.println("TEST A-Z First : "+name[0]);
							obtainedList.add(name[0]);
						}
						ArrayList<String> sortedList = new ArrayList<>();
						for(String s:obtainedList)
						{
							sortedList.add(s);
						}
						Collections.sort(sortedList);
						
						for(int i = 0; i < elementList.size(); i++)
						{								
							if(sortedList.equals(obtainedList))
							{
								
							}else
							{
								test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
							}
						}
					}
					
					else
					{
						test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
					}  
			  	    	
					
					Thread.sleep(1000);
					//Select the Employee option
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/a")).click();
				    //Enter the required Employee
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys("All");
				    //Press the Enter key
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				    
				    Thread.sleep(1000);
				    //Select the Process as Daily
					Select process1 = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[2]/div/select")));
					process1.selectByVisibleText("Daily");                               
				    
			  	    //Thread.sleep(1000);
				    //Select the Specific date Time Period option
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/a")).click();
				    //Enter the required Period of time
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				    //Press the Enter key
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				    
				    Thread.sleep(1000);
				    //Clear the Date field
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).clear();
				    //Enter the Date
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Payroll_Date_Range_From"));

				    Thread.sleep(1000);
				    //Clear the Date field
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).clear();
				    //Enter the Date
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Payroll_Date_Range_To"));
					  
					    //Select the Format option
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/a")).click();
					    //Enter the required Format
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys("In Hours");
					    //Press the Enter key
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
					  
					    //Select the Active/Inactive option
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/a")).click();
					    //Enter the required Format
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys("All");
					    //Press the Enter key
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);

					    Thread.sleep(1000);
					    //Select the Process as Daily
						Select sort = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/select")));
						sort.selectByVisibleText("Z-A FirstName");   
					    
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
						
							ArrayList<String> obtainedList = new ArrayList<>(); 
							List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
							for(int i = 1; i <= elementList.size(); i++)
							{
								String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
								
								String[] name = namess.split(" ");
								System.out.println("TEST Z-A FIRST : "+name[0]);
								obtainedList.add(name[0]);
							}
							ArrayList<String> sortedList = new ArrayList<>();
							for(String s:obtainedList)
							{
								sortedList.add(s);
							}
							Collections.reverse(sortedList);
							
							for(int i = 0; i < elementList.size(); i++)
							{								
								if(sortedList.equals(obtainedList))
								{
									
								}else
								{
									test.log(LogStatus.FAIL, "Name sort is not working  for Z-A First Name");
								}
							}
							
/*							ArrayList<String> obtainedList = new ArrayList<>(); 
							List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
							for(WebElement we:elementList){
							   obtainedList.add(we.getText());
							}
							ArrayList<String> sortedList = new ArrayList<>();   
							for(String s:obtainedList){
							sortedList.add(s);
							}
							Collections.sort(sortedList);
							Assert.assertTrue(sortedList.equals(obtainedList));*/
						
						}
						
						else
						{
							test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
						}  
			}
			
			@Test(priority=30,enabled=true)
			public void Employee_Payroll_Report_Method_verifyWeeklyReport() throws Exception
			{
			
				
				Thread.sleep(1000);
				//Select the Employee option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			  
			    //Select the Process as Daily
				Select process = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[2]/div/select")));
				process.selectByVisibleText("Weekly");
					
		  	    //Thread.sleep(1000);
			    //Select the Specific date Time Period option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    

				
				
			    Thread.sleep(3000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Payroll_Date_Range_From"));

			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Payroll_Date_Range_To"));
			    Thread.sleep(1000);
			    
			    //Select the Format option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys("In Hours");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    //Select the Active/Inactive option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);

			    Thread.sleep(1000);
			    //Select the Process as Daily
				Select sort1 = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/select")));
				sort1.selectByVisibleText("A-Z LastName");
				
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
					
					ArrayList<String> obtainedList = new ArrayList<>(); 
					List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
					for(int i = 1; i <= elementList.size(); i++)
					{
						String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
						
						String[] name = namess.split(" ");
						System.out.println("TEST A-Z LAST : "+name[1]);
						obtainedList.add(name[1]);
					}
					ArrayList<String> sortedList = new ArrayList<>();
					for(String s:obtainedList)
					{
						sortedList.add(s);
					}
					Collections.sort(sortedList);
					
					for(int i = 0; i < elementList.size(); i++)
					{								
						if(sortedList.equals(obtainedList))
						{
							
						}else
						{
							test.log(LogStatus.FAIL, "Name sort is not working for A-Z Last Name");
						}
					}
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
				}  
				
				Thread.sleep(1000);
				//Select the Employee option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			  
			    //Select the Process as Daily
				Select process1 = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[2]/div/select")));
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
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Payroll_Date_Range_From"));

			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Payroll_Date_Range_To_Weekly"));
			    Thread.sleep(1000);
			    
			    //Select the Format option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys("In Time");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    //Select the Active/Inactive option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);

			    Thread.sleep(1000);
			    //Select the Process as Daily
				Select sort = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/select")));
				sort.selectByVisibleText("Z-A LastName");
				
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
					
					
					ArrayList<String> obtainedList = new ArrayList<>(); 
					List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
					for(int i = 1; i <= elementList.size(); i++)
					{
						String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
						
						String[] name = namess.split(" ");
						System.out.println("TEST Z-A LAST : "+name[1]);
						obtainedList.add(name[1]);
					}
					ArrayList<String> sortedList = new ArrayList<>();
					for(String s:obtainedList)
					{
						sortedList.add(s);
					}
					Collections.reverse(sortedList);
					
					for(int i = 0; i < elementList.size(); i++)
					{								
						if(sortedList.equals(obtainedList))
						{
							
						}else
						{
							test.log(LogStatus.FAIL, "Name sort is not working for Z-A Last Name");
						}
					}
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
				} 
			
			}

			@Test(priority=29)
			public void Employee_Payroll_Report_Method_verifyDailyReport_With_Dynamic_Report() throws Exception
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
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    Thread.sleep(1000);
			    //Select the Process as Daily
				Select process = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[2]/div/select")));
				process.selectByVisibleText("Daily");                               
			    
		  	    //Thread.sleep(1000);
			    //Select the Specific date Time Period option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Payroll_Date_Range_From"));

			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Payroll_Date_Range_To"));
				  
				    //Select the Format option
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/a")).click();
				    //Enter the required Format
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys("In Time");
				    //Press the Enter key
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				  
				    //Select the Active/Inactive option
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/a")).click();
				    //Enter the required Format
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys("All");
				    //Press the Enter key
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);

				    Thread.sleep(1000);
				    //Select the Process as Daily
					Select sort1 = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/select")));
					sort1.selectByVisibleText("A-Z FirstName");
					
				    //Click the Run
				    driver.findElement(By.xpath("//button[@type='submit']")).click();
				    Thread.sleep(5000);
				   
					//Check Whether all the field is selected or not
					if(driver.findElement(By.xpath("//span[contains(.,'Hours')]/../input")).isSelected()
							&&driver.findElement(By.xpath("//span[contains(.,'Check Out')]/../input")).isSelected()
							&&driver.findElement(By.xpath("//span[contains(.,'Hours')]/../input")).isSelected()
							&&driver.findElement(By.xpath("//span[contains(.,'Job Code')]/../input")).isSelected()
							&&driver.findElement(By.xpath("//span[contains(.,'Check Out')]/../input")).isSelected()
							&&driver.findElement(By.xpath("//span[contains(.,'Hours')]/../input")).isSelected()
							&&driver.findElement(By.xpath("//span[contains(.,'Job Code')]/../input")).isSelected())
					{
						//Check weather the table format report is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
						{
							test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
							
							//Check whether all the filed is available or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Check In')]")).isDisplayed()
									&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Check Out')]")).isDisplayed()
									&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Hours')]")).isDisplayed()
									&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Job Code')]")).isDisplayed()
									&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Check Out')]")).isDisplayed()
									&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Hours')]")).isDisplayed()
									&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Job Code')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
							}
							else
							{
								test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
							}
							
							//Disable the required option from enable to disable Check In Option
							if(driver.findElement(By.xpath("//span[contains(.,'Check In')]/../input")).isSelected())
							{
								//Click the Enabled Check In Option
								Actions act = new Actions(driver);
								act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Check In')]"))).click().build().perform();
								try
								{
									//Check whether the Check In Option is displayed or not
									if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Check In')]")).isDisplayed())
									{
										test.log(LogStatus.FAIL, "Check In is displayed");
									}
								}
								catch(Exception e)
								{
									test.log(LogStatus.PASS, "Check In is not displayed");
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "Check In Option is Disabled When user enter the required date for date range");
							}
							
							//Disable the required option from enable to disable Check Out Option
							if(driver.findElement(By.xpath("//span[contains(.,'Check Out')]/../input")).isSelected())
							{
								//Click the Enabled Check Out Option
								Actions act = new Actions(driver);
								act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Check Out')]"))).click().build().perform();
								try
								{
									//Check whether the Check Out Option is displayed or not
									if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Check Out')]")).isDisplayed())
									{
										test.log(LogStatus.FAIL, "Check Out is displayed");
									}
								}
								catch(Exception e)
								{
									test.log(LogStatus.PASS, "Check Out is not displayed");
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "Check Out Option is Disabled When user enter the required date for date range");
							}
							
							//Disable the required option from enable to disable Hours Option
							if(driver.findElement(By.xpath("//span[contains(.,'Hours')]/../input")).isSelected())
							{
								//Click the Enabled Hours Option
								Actions act = new Actions(driver);
								act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Hours')]"))).click().build().perform();
								try
								{
									//Check whether the Hours Option is displayed or not
									if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Hours')]")).isDisplayed())
									{
										test.log(LogStatus.FAIL, "Hours is displayed");
									}
								}
								catch(Exception e)
								{
									test.log(LogStatus.PASS, "Hours is not displayed");
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "Hours Option is Disabled When user enter the required date for date range");
							}
							
							//Disable the required option from enable to disable Job Code Option
							if(driver.findElement(By.xpath("//span[contains(.,'Job Code')]/../input")).isSelected())
							{
								//Click the Enabled Job Code Option
								Actions act = new Actions(driver);
								act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Job Code')]"))).click().build().perform();
								try
								{
									//Check whether the Job Code Option is displayed or not
									if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Job Code')]")).isDisplayed())
									{
										test.log(LogStatus.FAIL, "Job Code is displayed");
									}
								}
								catch(Exception e)
								{
									test.log(LogStatus.PASS, "Job Code is not displayed");
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "Job Code Option is Disabled When user enter the required date for date range");
							}
							
							//Disable the required option from enable to disable Job Code Option
							if(driver.findElement(By.xpath("//span[contains(.,'Job Code')]/../input")).isSelected())
							{
								//Click the Enabled Job Code Option
								Actions act = new Actions(driver);
								act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Job Code')]"))).click().build().perform();
								try
								{
									//Check whether the Job Code Option is displayed or not
									if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Job Code')]")).isDisplayed())
									{
										test.log(LogStatus.FAIL, "Job Code is displayed");
									}
								}
								catch(Exception e)
								{
									test.log(LogStatus.PASS, "Job Code is not displayed");
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "Job Code Option is Disabled When user enter the required date for date range");
							}
							
							//Disable the required option from enable to disable Job Code Option
							if(driver.findElement(By.xpath("//span[contains(.,'Job Code')]/../input")).isSelected())
							{
								//Click the Enabled Job Code Option
								Actions act = new Actions(driver);
								act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Job Code')]"))).click().build().perform();
								try
								{
									//Check whether the Job Code Option is displayed or not
									if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Job Code')]")).isDisplayed())
									{
										test.log(LogStatus.FAIL, "Job Code is displayed");
									}
								}
								catch(Exception e)
								{
									test.log(LogStatus.PASS, "Job Code is not displayed");
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "Job Code Option is Disabled When user enter the required date for date range");
							}
							
							//Disable the required option from enable to disable Job Code Option
							if(driver.findElement(By.xpath("//span[contains(.,'Job Code')]/../input")).isSelected())
							{
								//Click the Enabled Job Code Option
								Actions act = new Actions(driver);
								act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Job Code')]"))).click().build().perform();
								try
								{
									//Check whether the Job Code Option is displayed or not
									if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Job Code')]")).isDisplayed())
									{
										test.log(LogStatus.FAIL, "Job Code is displayed");
									}
								}
								catch(Exception e)
								{
									test.log(LogStatus.PASS, "Job Code is not displayed");
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "Job Code Option is Disabled When user enter the required date for date range");
							}
												
							//Enable the Check In Option if it is in disabled status
							if(driver.findElement(By.xpath("//span[contains(.,'Check In')]/../input")).isSelected())
							{
								test.log(LogStatus.FAIL, "Check In Option is Enabled after user click(Disable) the Check In option");

							}
							else
							{
								//Click the Enabled Check In Option
								Actions act = new Actions(driver);
								act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Check In')]"))).click().build().perform();
								try
								{
									//Check whether the Check In Option is displayed or not
									if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Check In')]")).isDisplayed())
									{
										test.log(LogStatus.PASS, "Check In is displayed");
									}
								}
								catch(Exception e)
								{
									test.log(LogStatus.FAIL, "Check In is not displayed");
								}				
							}
							
							//Disable the required option from enable to disable Check Out Option
							if(driver.findElement(By.xpath("//span[contains(.,'Check Out')]/../input")).isSelected())
							{
								test.log(LogStatus.FAIL, "Check Out Option is Enabled after user click(Disable) the Check Out option");
							}
							else
							{
								//Click the Enabled Check Out Option
								Actions act = new Actions(driver);
								act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Check Out')]"))).click().build().perform();
								try
								{
									//Check whether the Check Out Option is displayed or not
									if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Check Out')]")).isDisplayed())
									{
										test.log(LogStatus.PASS, "Check Out is displayed");
									}
								}
								catch(Exception e)
								{
									test.log(LogStatus.FAIL, "Check Out is not displayed");
								}

							}
							
							//Disable the required option from enable to disable Hours Option
							if(driver.findElement(By.xpath("//span[contains(.,'Hours')]/../input")).isSelected())
							{
								test.log(LogStatus.FAIL, "Hours Option is Enabled after user click(Disable) the Hours option");
							}
							else
							{

								//Click the Enabled Hours Option
								Actions act = new Actions(driver);
								act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Hours')]"))).click().build().perform();
								try
								{
									//Check whether the Hours Option is displayed or not
									if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Hours')]")).isDisplayed())
									{
										test.log(LogStatus.PASS, "Hours is displayed");
									}
								}
								catch(Exception e)
								{
									test.log(LogStatus.FAIL, "Hours is not displayed");
								}

							}
							
							//Disable the required option from enable to disable Job Code Option
							if(driver.findElement(By.xpath("//span[contains(.,'Job Code')]/../input")).isSelected())
							{
								test.log(LogStatus.FAIL, "Job Code Option is Enabled after user click(Disable) the Job Code option");

							}
							else
							{

								//Click the Enabled Job Code Option
								Actions act = new Actions(driver);
								act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Job Code')]"))).click().build().perform();
								try
								{
									//Check whether the Job Code Option is displayed or not
									if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Job Code')]")).isDisplayed())
									{
										test.log(LogStatus.PASS, "Job Code is displayed");
									}
								}
								catch(Exception e)
								{
									test.log(LogStatus.FAIL, "Job Code is not displayed");
								}
							}
							
							//Disable the required option from enable to disable Job Code Option
							if(driver.findElement(By.xpath("//span[contains(.,'Job Code')]/../input")).isSelected())
							{
								test.log(LogStatus.FAIL, "Job Code Option is Enabled after user click(Disable) the Job Code option");

							}
							else
							{

								//Click the Enabled Job Code Option
								Actions act = new Actions(driver);
								act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Job Code')]"))).click().build().perform();
								try
								{
									//Check whether the Job Code Option is displayed or not
									if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Job Code')]")).isDisplayed())
									{
										test.log(LogStatus.PASS, "Job Code is displayed");
									}
								}
								catch(Exception e)
								{
									test.log(LogStatus.FAIL, "Job Code is not displayed");
								}
							}
							
							//Disable the required option from enable to disable Job Code Option
							if(driver.findElement(By.xpath("//span[contains(.,'Job Code')]/../input")).isSelected())
							{
								test.log(LogStatus.FAIL, "Job Code Option is Enabled after user click(Disable) the Job Code option");

							}
							else
							{

								//Click the Enabled Job Code Option
								Actions act = new Actions(driver);
								act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Job Code')]"))).click().build().perform();
								try
								{
									//Check whether the Job Code Option is displayed or not
									if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Job Code')]")).isDisplayed())
									{
										test.log(LogStatus.PASS, "Job Code is displayed");
									}
								}
								catch(Exception e)
								{
									test.log(LogStatus.FAIL, "Job Code is not displayed");
								}
							}
							
							//Disable the required option from enable to disable Job Code Option
							if(driver.findElement(By.xpath("//span[contains(.,'Job Code')]/../input")).isSelected())
							{
								test.log(LogStatus.FAIL, "Job Code Option is Enabled after user click(Disable) the Job Code option");

							}
							else
							{

								//Click the Enabled Job Code Option
								Actions act = new Actions(driver);
								act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Job Code')]"))).click().build().perform();
								try
								{
									//Check whether the Job Code Option is displayed or not
									if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Job Code')]")).isDisplayed())
									{
										test.log(LogStatus.PASS, "Job Code is displayed");
									}
								}
								catch(Exception e)
								{
									test.log(LogStatus.FAIL, "Job Code is not displayed");
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
			  	    	
					
					Thread.sleep(1000);
					//Select the Employee option
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/a")).click();
				    //Enter the required Employee
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys("All");
				    //Press the Enter key
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				    
				    Thread.sleep(1000);
				    //Select the Process as Daily
					Select process1 = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[2]/div/select")));
					process1.selectByVisibleText("Daily");                               
				    
			  	    //Thread.sleep(1000);
				    //Select the Specific date Time Period option
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/a")).click();
				    //Enter the required Period of time
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				    //Press the Enter key
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				    
				    Thread.sleep(1000);
				    //Clear the Date field
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).clear();
				    //Enter the Date
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Payroll_Date_Range_From"));

				    Thread.sleep(1000);
				    //Clear the Date field
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).clear();
				    //Enter the Date
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Payroll_Date_Range_To"));
					  
					    //Select the Format option
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/a")).click();
					    //Enter the required Format
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys("In Hours");
					    //Press the Enter key
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
					  
					    //Select the Active/Inactive option
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/a")).click();
					    //Enter the required Format
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys("All");
					    //Press the Enter key
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);

					    Thread.sleep(1000);
					    //Select the Process as Daily
						Select sort = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/select")));
						sort.selectByVisibleText("Z-A FirstName");   
					    
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
						
							ArrayList<String> obtainedList = new ArrayList<>(); 
							List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
							for(int i = 1; i <= elementList.size(); i++)
							{
								String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
								
								String[] name = namess.split(" ");
								//System.out.println("TEST Z-A FIRST : "+name[0]);
								obtainedList.add(name[0]);
							}
							ArrayList<String> sortedList = new ArrayList<>();
							for(String s:obtainedList)
							{
								sortedList.add(s);
							}
							Collections.reverse(sortedList);
							
							for(int i = 0; i < elementList.size(); i++)
							{								
								if(sortedList.equals(obtainedList))
								{
									
								}else
								{
									test.log(LogStatus.FAIL, "Name sort is not working  for Z-A First Name");
								}
							}
							
/*							ArrayList<String> obtainedList = new ArrayList<>(); 
							List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
							for(WebElement we:elementList){
							   obtainedList.add(we.getText());
							}
							ArrayList<String> sortedList = new ArrayList<>();   
							for(String s:obtainedList){
							sortedList.add(s);
							}
							Collections.sort(sortedList);
							Assert.assertTrue(sortedList.equals(obtainedList));*/
						
						}
						
						else
						{
							test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
						}  
			}
			
			@Test(priority=30)
			public void Employee_Payroll_Report_Method_verifyWeeklyReport_With_Dynamic_Report() throws Exception
			{
			
				
				Thread.sleep(1000);
				//Select the Employee option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			  
			    //Select the Process as Daily
				Select process = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[2]/div/select")));
				process.selectByVisibleText("Weekly");
					
		  	    //Thread.sleep(1000);
			    //Select the Specific date Time Period option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    

				
				
			    Thread.sleep(3000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Payroll_Date_Range_From"));

			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Payroll_Date_Range_To"));
			    Thread.sleep(1000);
			    
			    //Select the Format option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys("In Hours");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    //Select the Active/Inactive option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);

			    Thread.sleep(1000);
			    //Select the Process as Daily
				Select sort1 = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/select")));
				sort1.selectByVisibleText("A-Z LastName");
				
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
					
					ArrayList<String> obtainedList = new ArrayList<>(); 
					List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
					for(int i = 1; i <= elementList.size(); i++)
					{
						String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
						
						String[] name = namess.split(" ");
						//System.out.println("TEST A-Z LAST : "+name[1]);
						obtainedList.add(name[1]);
					}
					ArrayList<String> sortedList = new ArrayList<>();
					for(String s:obtainedList)
					{
						sortedList.add(s);
					}
					Collections.sort(sortedList);
					
					for(int i = 0; i < elementList.size(); i++)
					{								
						if(sortedList.equals(obtainedList))
						{
							
						}else
						{
							test.log(LogStatus.FAIL, "Name sort is not working for A-Z Last Name");
						}
					}
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
				}  
				
				Thread.sleep(1000);
				//Select the Employee option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			  
			    //Select the Process as Daily
				Select process1 = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[2]/div/select")));
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
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Payroll_Date_Range_From"));

			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Payroll_Date_Range_To_Weekly"));
			    Thread.sleep(1000);
			    
			    //Select the Format option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys("In Time");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    //Select the Active/Inactive option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);

			    Thread.sleep(1000);
			    //Select the Process as Daily
				Select sort = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/select")));
				sort.selectByVisibleText("Z-A LastName");
				
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
					
					
					ArrayList<String> obtainedList = new ArrayList<>(); 
					List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
					for(int i = 1; i <= elementList.size(); i++)
					{
						String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
						
						String[] name = namess.split(" ");
						//System.out.println("TEST Z-A LAST : "+name[1]);
						obtainedList.add(name[1]);
					}
					ArrayList<String> sortedList = new ArrayList<>();
					for(String s:obtainedList)
					{
						sortedList.add(s);
					}
					Collections.reverse(sortedList);
					
					for(int i = 0; i < elementList.size(); i++)
					{								
						if(sortedList.equals(obtainedList))
						{
							
						}else
						{
							test.log(LogStatus.FAIL, "Name sort is not working for Z-A Last Name");
						}
					}
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
				} 
			
			}

	}
