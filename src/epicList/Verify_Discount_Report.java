package epicList;

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

public class Verify_Discount_Report {

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Verify_Discount_Report");

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
		
			@Test(priority=12,enabled = true)
			public void Discount_Report_Method_OpenPage() throws Exception
			{
			
				/*Thread.sleep(2000);
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
				WebElement element = driver.findElement(By.xpath("//span[.='Discount']"));
				//Scroll the page till the Discount option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Discount Option		
				driver.findElement(By.xpath("//span[.='Discount']")).click(); */
				
				Thread.sleep(3000);
				//Enter the Users URL
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/discountReport");
				
				Thread.sleep(5000);
				//Check Discount Report page opened or not
				if(driver.findElement(By.xpath("//a[.='Discount Report']")).getText().equalsIgnoreCase("Discount Report"))
				{
					test.log(LogStatus.PASS, "Discount report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Discount report page loaded Failed");
				}
				
				Thread.sleep(2000);
		
		
			}
			
			@Test(priority=13,enabled = true)
			public void Discount_Report_Method_For_Summary() throws Exception
			{
				Thread.sleep(3000);
				//Click the Report Type option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[1]/div/div/a")).click();
				//Enter the required Report Type
				driver.findElement(By.xpath("//form[@name='discountReport']/div[1]/div/div/div/div/input")).sendKeys("Summary");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
				//Click the Discount option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[2]/div/div/a")).click();
				//Enter the required Discount
				driver.findElement(By.xpath("//form[@name='discountReport']/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[3]/div/div/a")).click();
				//Enter the required Employee
				driver.findElement(By.xpath("//form[@name='discountReport']/div[3]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
				//Click the Discount Coupon Type option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[4]/div/div/a")).click();
				//Enter the Required Coupon Type
				driver.findElement(By.xpath("//form[@name='discountReport']/div[4]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[5]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='discountReport']/div[5]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='discountReport']/div[6]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='discountReport']/div[6]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='discountReport']/div[6]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='discountReport']/div[6]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Discount Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[2]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[4]")).getText() != null)
				{
					test.log(LogStatus.INFO, "******* The Below is Summary Report of Discount *******");
					
					System.out.println("******* The Below is Summary Report of Discount *******");
					
					test.log(LogStatus.PASS, "Discount Report available for Specific Date");
					
					//Get the Total discount value
					String total_Discount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[2]")).getText();
					
					//Print the Total
					System.out.println("Total Discount is : "+total_Discount);
					
					test.log(LogStatus.INFO, "Total Discount is : "+total_Discount);
					
					//Get the Percentage of Total discount
					String percentage_Of_Total = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[3]")).getText();
					
					//Print the percentage_Of_Total
					System.out.println("Percentage Of Total Discount is : "+percentage_Of_Total);
					
					test.log(LogStatus.INFO, "Percentage Of Total Discount is : "+percentage_Of_Total);
					
					//Get the Count value
					String count = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[4]")).getText();
					
					//Print the count
					System.out.println("Total number of count is : "+count);
					
					test.log(LogStatus.INFO, "Total number of count is : "+count);
					
					//Get the Average discount value
					String average = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[5]")).getText();
					
					//Print the Average
					System.out.println("Average Discount is : "+average);
					
					test.log(LogStatus.INFO, "Average Discount is : "+average);
					
					//Get the number of rows
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
					
					//Get the Total Checks
					String total_Checks = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[1]")).getText();
					
					//Print the Total Checks
					System.out.println("Total Checks count is : "+total_Checks);
					
					test.log(LogStatus.INFO, "Total Checks count is : "+total_Checks);
					
					//Get the Percentage of Checks discounted
					String percentage_Of_Checks_discounted = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[2]")).getText();
					
					//Print the percentage_Of_Checks_discounted
					System.out.println("Percentage of Checks discounted is : "+percentage_Of_Checks_discounted);
					
					test.log(LogStatus.INFO, "Percentage of Checks discounted is : "+percentage_Of_Checks_discounted);
					
					//Get the Gross Sales
					String gross_Sales = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[3]")).getText();
					
					//Print the Gross Sales
					System.out.println("Total Gross Sales is : "+gross_Sales);
					
					test.log(LogStatus.INFO, "Total Gross Sales is : "+gross_Sales);
					
					//Get the percentage discount of gross sales
					String percentage_Discount_Of_Gross_Sales = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
					
					//Print the percentage discount of gross sales
					System.out.println("Percentage of Gross Sales is : "+percentage_Discount_Of_Gross_Sales);
					
					test.log(LogStatus.INFO, "Percentage of Gross Sales is : "+percentage_Discount_Of_Gross_Sales);
					
					//Get the Checks Discounted
					String checks_Discounted = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					//Print the Checks Discounted
					System.out.println("Total Checks discounted is : "+checks_Discounted);
					
					test.log(LogStatus.INFO, "Total Checks discounted is : "+checks_Discounted);
					
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Discount Report is not available for Specific Date");
				}
			}
			
			@Test(priority=14,enabled = true)
			public void Discount_Report_Method_For_ByEmployee() throws Exception
			{
				Thread.sleep(2000);
				//Click the Report Type option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[1]/div/div/a")).click();
				//Enter the required Report Type
				driver.findElement(By.xpath("//form[@name='discountReport']/div[1]/div/div/div/div/input")).sendKeys("By Employee");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
				//Click the Discount option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[2]/div/div/a")).click();
				//Enter the required Discount
				driver.findElement(By.xpath("//form[@name='discountReport']/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[3]/div/div/a")).click();
				//Enter the required Employee
				driver.findElement(By.xpath("//form[@name='discountReport']/div[3]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				//Click the Discount Coupon Type option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[4]/div/div/a")).click();
				//Enter the Required Coupon Type
				driver.findElement(By.xpath("//form[@name='discountReport']/div[4]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[5]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='discountReport']/div[5]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='discountReport']/div[6]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='discountReport']/div[6]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='discountReport']/div[6]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='discountReport']/div[6]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Discount Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[3]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[7]")).getText() != null)
				{
					test.log(LogStatus.INFO, "******* The Below is By Employee Report of Discount *******");
					
					System.out.println("******* The Below is By Employee Report of Discount *******");
					
					test.log(LogStatus.PASS, "Discount Report available for Specific Date");
					
		/*				//Get the number of rows
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
					
					//Get the Total discount value
					String total_Discount_amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[7]")).getText();
					
					//Print the Total
					System.out.println("Total Discount Amount is : "+total_Discount_amount);
					
					test.log(LogStatus.INFO, "Total Discount Amount is : "+total_Discount_amount);
					
					//Get the Quantity
					String quantity = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[8]")).getText();
					
					//Print the percentage_Of_Total
					System.out.println("Quantity is : "+quantity);
					
					test.log(LogStatus.INFO, "Quantity is : "+quantity);*/
									
					Discount_Report_Search_Field_Discount_Report();
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Discount Report is not available for Specific Date");
				}
			}
			
			@Test(priority=15,enabled = true)
			public void Discount_Report_Method_For_ByDiscount() throws Exception
			{
				Thread.sleep(2000);
				//Click the Report Type option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[1]/div/div/a")).click();
				//Enter the required Report Type
				driver.findElement(By.xpath("//form[@name='discountReport']/div[1]/div/div/div/div/input")).sendKeys("By Discount");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
				//Click the Discount option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[2]/div/div/a")).click();
				//Enter the required Discount
				driver.findElement(By.xpath("//form[@name='discountReport']/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[3]/div/div/a")).click();
				//Enter the required Employee
				driver.findElement(By.xpath("//form[@name='discountReport']/div[3]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				//Click the Discount Coupon Type option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[4]/div/div/a")).click();
				//Enter the Required Coupon Type
				driver.findElement(By.xpath("//form[@name='discountReport']/div[4]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[5]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='discountReport']/div[5]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='discountReport']/div[6]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='discountReport']/div[6]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='discountReport']/div[6]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='discountReport']/div[6]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Discount Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[7]")).getText() != null)
				{
					test.log(LogStatus.INFO, "******* The Below is By Discount Report of Discount *******");
					
					test.log(LogStatus.INFO, "By Discount Report is available");
						
					test.log(LogStatus.PASS, "Discount Report available for Specific Date");
					
					Discount_Report_Search_Field_Discount_Report();
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Discount Report is not available for Specific Date");
				}
			}
			
			@Test(priority=16,enabled = true)
			public void Discount_Report_Method_For_ByDiscountType() throws Exception
			{
				Thread.sleep(2000);
				//Click the Report Type option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[1]/div/div/a")).click();
				//Enter the required Report Type
				driver.findElement(By.xpath("//form[@name='discountReport']/div[1]/div/div/div/div/input")).sendKeys("By Discount Type");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
				//Click the Discount option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[2]/div/div/a")).click();
				//Enter the required Discount
				driver.findElement(By.xpath("//form[@name='discountReport']/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[3]/div/div/a")).click();
				//Enter the required Employee
				driver.findElement(By.xpath("//form[@name='discountReport']/div[3]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				//Click the Discount Coupon Type option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[4]/div/div/a")).click();
				//Enter the Required Coupon Type
				driver.findElement(By.xpath("//form[@name='discountReport']/div[4]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='discountReport']/div[5]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='discountReport']/div[5]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='discountReport']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='discountReport']/div[6]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='discountReport']/div[6]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='discountReport']/div[6]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='discountReport']/div[6]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Discount Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[7]")).getText() != null)
				{
					test.log(LogStatus.INFO, "******* The Below is By Discount Type Report of Discount *******");
					
					test.log(LogStatus.INFO, "By Discount Type Report is available");
						
					test.log(LogStatus.PASS, "Discount Report available for Specific Date");
										
					Discount_Report_Search_Field_Discount_Report();
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Discount Report is not available for Specific Date");
				}
			}
			
			@Test(priority = 16,enabled=false)
			public void Discount_Report_Search_Field_Discount_Report() throws Exception
			{
				//Get the number of rows
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
		
				int row = rows.size()- 1;
				
				//Get the Date
				String date = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+row+"]/td[1]/span")).getText();
		
				Thread.sleep(2000);
				//Clear the Date field
				driver.findElement(By.xpath("//input[@name='date']")).clear();
				//Enter the Required Date
				driver.findElement(By.xpath("//input[@name='date']")).sendKeys(date);
				Thread.sleep(1000);
				
				//Check whether the required filter is working or not
				try
				{
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[1]/td[1]/span")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Filter show the required data for date filter");
						
						//Get the number of rows
						List<WebElement> filter_Rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
						
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+filter_Rows.size()+"]/td[1]/span")).getText().equals(date))
						{}
						else
						{
							test.log(LogStatus.FAIL, "Unwanted data found for date filter");
						}
						
						Thread.sleep(2000);
						//Clear the date from the field
						driver.findElement(By.xpath("//input[@name='date']")).clear();
					}
				}
				catch(Exception e)
				{
					test.log(LogStatus.FAIL, "Filter not show the required data for date filter");
				}
				
				//Get the Check
				String check = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+row+"]/td[2]/span")).getText();
		
				Thread.sleep(2000);
				//Clear the Check field
				driver.findElement(By.xpath("//input[@name='check']")).clear();
				//Enter the Required Check
				driver.findElement(By.xpath("//input[@name='check']")).sendKeys(check);
				Thread.sleep(1000);
				
				//Check whether the required filter is working or not
				try
				{
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[1]/td[1]/span")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Filter show the required data for Check filter");
						
						//Get the number of rows
						List<WebElement> filter_Rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
						
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+filter_Rows.size()+"]/td[2]/span")).getText().equals(check))
						{}
						else
						{
							test.log(LogStatus.FAIL, "Unwanted data found for Check filter");
						}
						
						Thread.sleep(2000);
						//Clear the date from the field
						driver.findElement(By.xpath("//input[@name='check']")).clear();
					}
				}
				catch(Exception e)
				{
					test.log(LogStatus.FAIL, "Filter not show the required data for check filter");
				}
				
				//Get the Employee
				String emp = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+row+"]/td[3]/a")).getText();
		
				Thread.sleep(2000);
				//Clear the Employee field
				driver.findElement(By.xpath("//input[@name='employee']")).clear();
				//Enter the Required Employee
				driver.findElement(By.xpath("//input[@name='employee']")).sendKeys(emp);
				Thread.sleep(1000);
				
				//Check whether the required filter is working or not
				try
				{				
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[1]/td[1]/span")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Filter show the required data for employee filter");
						
						//Get the number of rows
						List<WebElement> filter_Rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr/td/a"));
						
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+filter_Rows.size()+"]/td[3]/a")).getText().equals(emp))
						{
							Thread.sleep(1000);
							//Click the First Employee from the user
							driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[1]/td[3]/a")).click();
							
							Thread.sleep(2000);
							
							//Get the number of check presents below the Employee
							List<WebElement> empCheck = driver.findElements(By.xpath("//div[@class='row']/table/tbody/tr/td[2]"));
							
							//Get the Check Number 
							String checkNum = driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr["+empCheck.size()+"]/td[1]/a")).getText();
							
							//Get the Transaction Date
							String transactionDate = driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr["+empCheck.size()+"]/td[2]/span")).getText();
		
							//Get the Net sales
							String netSales = driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr["+empCheck.size()+"]/td[3]/span")).getText();
		
							//Get the Total Tax amount
							String totalTaxAmount = driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr["+empCheck.size()+"]/td[4]/span")).getText();
		
							//Get the Inclusive Tax Amount
							String incTaxAmount = driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr["+empCheck.size()+"]/td[5]/span")).getText();
		
							//Get the CC Service Charge
							String ccServiceCharge = driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr["+empCheck.size()+"]/td[6]/span")).getText();
		
							//Get the Discount
							String disc = driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr["+empCheck.size()+"]/td[7]/span")).getText();
		
							//Get the Gross Receipt
							String grossRecipt = driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr["+empCheck.size()+"]/td[8]/span")).getText();
		
							Thread.sleep(1000);
							//Clear the Check Number
							driver.findElement(By.xpath("//input[@name='ticketNo']")).clear();
							//Enter the Check Number
							driver.findElement(By.xpath("//input[@name='ticketNo']")).sendKeys(checkNum);
							
							//Check whether the required filter is working or not
							try
							{
								if(driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr/td[2]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Filter show the required data for Check Number filter");
									
									//Get the number of rows
									List<WebElement> filter_Row = driver.findElements(By.xpath("//div[@class='row']/table/tbody/tr/td[2]"));
									
									if(driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr["+filter_Row.size()+"]/td[1]/a")).getText().equals(checkNum))
									{
										//Click the First Check
										//driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr[1]/td[1]/a")).click();
										
										Discount_Report_Method_Check_View();
										
									}
									else
									{
										test.log(LogStatus.FAIL, "Unwanted data found for Check Number filter");
									}
									
									Thread.sleep(2000);
									//Clear the Check Number from the field
									driver.findElement(By.xpath("//input[@name='ticketNo']")).clear();
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Filter not show the required data for Check Number filter");
		
							}
								
							Thread.sleep(1000);
							//Clear the Transaction Date
							driver.findElement(By.xpath("//input[@name='saleOpenDate']")).clear();
							//Enter the Check Number
							driver.findElement(By.xpath("//input[@name='saleOpenDate']")).sendKeys(transactionDate);
							
							//Check whether the required filter is working or not
							try
							{
								if(driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr/td[2]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Filter show the required data for Transaction Date filter");
									
									//Get the number of rows
									List<WebElement> filter_Row = driver.findElements(By.xpath("//div[@class='row']/table/tbody/tr/td[2]"));
									
									if(driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr["+filter_Row.size()+"]/td[2]/span")).getText().equals(transactionDate))
									{}
									else
									{
										test.log(LogStatus.FAIL, "Unwanted data found for Transaction Date filter");
									}
									
									Thread.sleep(2000);
									//Clear the Transaction Date from the field
									driver.findElement(By.xpath("//input[@name='saleOpenDate']")).clear();
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Filter not show the required data for Transaction Date filter");
							}
							
							Thread.sleep(1000);
							//Clear the NetSales
							driver.findElement(By.xpath("//input[@name='netSales']")).clear();
							//Enter the netSales
							driver.findElement(By.xpath("//input[@name='netSales']")).sendKeys(netSales);
							
							//Check whether the required filter is working or not
							try
							{
								if(driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr/td[2]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Filter show the required data for NetSales filter");
									
									//Get the number of rows
									List<WebElement> filter_Row = driver.findElements(By.xpath("//div[@class='row']/table/tbody/tr/td[2]"));
									
									if(driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr["+filter_Row.size()+"]/td[3]/span")).getText().equals(netSales))
									{}
									else
									{
										test.log(LogStatus.FAIL, "Unwanted data found for NetSales filter");
									}
									
									Thread.sleep(2000);
									//Clear the NetSales from the field
									driver.findElement(By.xpath("//input[@name='netSales']")).clear();
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Filter not show the required data for NetSales filter");
							}
									
							Thread.sleep(1000);
							//Clear the Total Tax Amount
							driver.findElement(By.xpath("//input[@name='totalTaxAmount']")).clear();
							//Enter the Total Tax Amount
							driver.findElement(By.xpath("//input[@name='totalTaxAmount']")).sendKeys(totalTaxAmount);
							
							//Check whether the required filter is working or not
							try
							{
								if(driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr/td[2]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Filter show the required data for Total Tax Amount filter");
									
									//Get the number of rows
									List<WebElement> filter_Row = driver.findElements(By.xpath("//div[@class='row']/table/tbody/tr/td[2]"));
									
									if(driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr["+filter_Row.size()+"]/td[4]/span")).getText().equals(totalTaxAmount))
									{}
									else
									{
										test.log(LogStatus.FAIL, "Unwanted data found for Total Tax Amount filter");
									}
									
									Thread.sleep(2000);
									//Clear the Total Tax Amount from the field
									driver.findElement(By.xpath("//input[@name='totalTaxAmount']")).clear();
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Filter not show the required data for Total Tax Amount filter");
							}
							
							Thread.sleep(1000);
							//Clear the Inclusive Tax Amount
							driver.findElement(By.xpath("//input[@name='inclusiveTaxAmount']")).clear();
							//Enter the Inclusive Tax Amount
							driver.findElement(By.xpath("//input[@name='inclusiveTaxAmount']")).sendKeys(incTaxAmount);
							
							//Check whether the required filter is working or not
							try
							{
								if(driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr/td[2]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Filter show the required data for Inclusive Tax Amount filter");
									
									//Get the number of rows
									List<WebElement> filter_Row = driver.findElements(By.xpath("//div[@class='row']/table/tbody/tr/td[2]"));
									
									if(driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr["+filter_Row.size()+"]/td[5]/span")).getText().equals(incTaxAmount))
									{}
									else
									{
										test.log(LogStatus.FAIL, "Unwanted data found for Inclusive Tax Amount filter");
									}
									
									Thread.sleep(2000);
									//Clear the Inclusive Tax Amount from the field
									driver.findElement(By.xpath("//input[@name='inclusiveTaxAmount']")).clear();
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Filter not show the required data for Inclusive Tax Amount filter");
							}
							
							Thread.sleep(1000);
							//Clear the CC Service Charge
							driver.findElement(By.xpath("//input[@name='cardServiceCharge']")).clear();
							//Enter the CC Service Charge
							driver.findElement(By.xpath("//input[@name='cardServiceCharge']")).sendKeys(ccServiceCharge);
							
							//Check whether the required filter is working or not
							try
							{
								if(driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr/td[2]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Filter show the required data for CC Service Charge filter");
									
									//Get the number of rows
									List<WebElement> filter_Row = driver.findElements(By.xpath("//div[@class='row']/table/tbody/tr/td[2]"));
									
									if(driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr["+filter_Row.size()+"]/td[6]/span")).getText().equals(ccServiceCharge))
									{}
									else
									{
										test.log(LogStatus.FAIL, "Unwanted data found for CC Service Charge filter");
									}
									
									Thread.sleep(2000);
									//Clear the CC Service Charge from the field
									driver.findElement(By.xpath("//input[@name='cardServiceCharge']")).clear();
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Filter not show the required data for CC Service Charge filter");
							}
							
							Thread.sleep(1000);
							//Clear the Discount
							driver.findElement(By.xpath("//input[@name='discounts']")).clear();
							//Enter the Discount
							driver.findElement(By.xpath("//input[@name='discounts']")).sendKeys(disc);
							
							//Check whether the required filter is working or not
							try
							{
								if(driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr/td[2]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Filter show the required data for Discount filter");
									
									//Get the number of rows
									List<WebElement> filter_Row = driver.findElements(By.xpath("//div[@class='row']/table/tbody/tr/td[2]"));
									
									if(driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr["+filter_Row.size()+"]/td[7]/span")).getText().equals(disc))
									{}
									else
									{
										test.log(LogStatus.FAIL, "Unwanted data found for Discount filter");
									}
									
									Thread.sleep(2000);
									//Clear the Discount from the field
									driver.findElement(By.xpath("//input[@name='discounts']")).clear();
								}
								
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Filter not show the required data for Discount filter");
							}
							
							Thread.sleep(1000);
							//Clear the Gross Receipt
							driver.findElement(By.xpath("//input[@name='grossReceipt']")).clear();
							//Enter the Gross Receipt
							driver.findElement(By.xpath("//input[@name='grossReceipt']")).sendKeys(grossRecipt);
							
							//Check whether the required filter is working or not
							try
							{
								if(driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr/td[2]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Filter show the required data for Gross Receipt filter");
									
									//Get the number of rows
									List<WebElement> filter_Row = driver.findElements(By.xpath("//div[@class='row']/table/tbody/tr/td[2]"));
									
									if(driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr["+filter_Row.size()+"]/td[8]/span")).getText().equals(grossRecipt))
									{}
									else
									{
										test.log(LogStatus.FAIL, "Unwanted data found for Gross Receipt filter");
									}
									
									Thread.sleep(2000);
									//Clear the Gross Receipt from the field
									driver.findElement(By.xpath("//input[@name='grossReceipt']")).clear();
								}
								
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Filter not show the required data for Gross Receipt filter");
							}
							
							Thread.sleep(5000);
							//Click the Back button
							driver.findElement(By.xpath("//form[@name='discountReport']/../../../div[4]/div/a/i")).click();
							Thread.sleep(3000);
													
						}
						else
						{
							test.log(LogStatus.FAIL, "Unwanted data found for Employee filter");
						}
											
						Thread.sleep(2000);
						//Clear the date from the field
						driver.findElement(By.xpath("//input[@name='employee']")).clear();
					}
				
				}
				catch(Exception e)
				{
					test.log(LogStatus.FAIL, "Filter not show the required data for employee filter");
				}
				
				//Get the Reason
				String reason = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+row+"]/td[4]/span")).getText();
				//System.out.println(reason);
				Thread.sleep(2000);
				//Clear the reason field
				driver.findElement(By.xpath("//input[@name='reason']")).clear();
				//Enter the Required reason
				driver.findElement(By.xpath("//input[@name='reason']")).sendKeys(reason);
				Thread.sleep(1000);
				
				//Check whether the required filter is working or not
				try
				{
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[1]/td[1]/span")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Filter show the required data for reason filter");
						
						//Get the number of rows
						List<WebElement> filter_Rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
						
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+filter_Rows.size()+"]/td[4]/span")).getText().equals(reason))
						{}
						else
						{
							test.log(LogStatus.FAIL, "Unwanted data found for reason filter");
						}
						
						Thread.sleep(2000);
						//Clear the reason from the field
						driver.findElement(By.xpath("//input[@name='reason']")).clear();
					}
				}
				catch(Exception e)
				{
					test.log(LogStatus.FAIL, "Filter not show the required data for reason filter");
				}
				
				//Get the Discount Name
				String discName = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+row+"]/td[5]/span")).getText();
		
				Thread.sleep(2000);
				//Clear the Discount Name field
				driver.findElement(By.xpath("//input[@name='discountName']")).clear();
				//Enter the Required Discount Name
				driver.findElement(By.xpath("//input[@name='discountName']")).sendKeys(discName);
				Thread.sleep(1000);
				
				//Check whether the required filter is working or not
				try
				{
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[1]/td[1]/span")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Filter show the required data for Discount Name filter");
						
						//Get the number of rows
						List<WebElement> filter_Rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
						
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+filter_Rows.size()+"]/td[5]/span")).getText().equals(discName))
						{}
						else
						{
							test.log(LogStatus.FAIL, "Unwanted data found for Discount Name filter");
						}
						
						Thread.sleep(2000);
						//Clear the Discount name from the field
						driver.findElement(By.xpath("//input[@name='discountName']")).clear();
					}
				}
				catch(Exception e)
				{
					test.log(LogStatus.FAIL, "Filter not show the required data for Discount Name filter");
				}
				
				//Get the Discount Type
				String discType = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+row+"]/td[6]/span")).getText();
		
				Thread.sleep(2000);
				//Clear the Discount Type field
				driver.findElement(By.xpath("//input[@name='discountType']")).clear();
				//Enter the Required Discount Type
				driver.findElement(By.xpath("//input[@name='discountType']")).sendKeys(discType);
				Thread.sleep(1000);
				
				//Check whether the required filter is working or not
				try
				{
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[1]/td[1]/span")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Filter show the required data for Discount Type filter");
						
						//Get the number of rows
						List<WebElement> filter_Rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
						
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+filter_Rows.size()+"]/td[6]/span")).getText().equals(discType))
						{}
						else
						{
							test.log(LogStatus.FAIL, "Unwanted data found for Discount Type filter");
						}
						
						Thread.sleep(2000);
						//Clear the Discount Type from the field
						driver.findElement(By.xpath("//input[@name='discountType']")).clear();
					}
				}
				catch(Exception e)
				{
					test.log(LogStatus.FAIL, "Filter not show the required data for Discount Type filter");
				}
				
				//Get the Amount
				String amt = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+row+"]/td[7]/span")).getText();
		
				Thread.sleep(2000);
				//Clear the Amount field
				driver.findElement(By.xpath("//input[@name='discountAmtStr']")).clear();
				//Enter the Required Amount
				driver.findElement(By.xpath("//input[@name='discountAmtStr']")).sendKeys(amt);
				Thread.sleep(1000);
				
				//Check whether the required filter is working or not
				try
				{
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[1]/td[1]/span")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Filter show the required data for Amount filter");
						
						//Get the number of rows
						List<WebElement> filter_Rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
						
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+filter_Rows.size()+"]/td[7]/span")).getText().equals(amt))
						{}
						else
						{
							test.log(LogStatus.FAIL, "Unwanted data found for Amount filter");
						}
						
						Thread.sleep(2000);
						//Clear the Amount from the field
						driver.findElement(By.xpath("//input[@name='discountAmtStr']")).clear();
					}
				}
				catch(Exception e)
				{
					test.log(LogStatus.FAIL, "Filter not show the required data for Amount filter");
				}
				
				//Get the Quantity
				String quan = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+row+"]/td[8]/span")).getText();
		
				Thread.sleep(2000);
				//Clear the Quantity field
				driver.findElement(By.xpath("//input[@name='quantity']")).clear();
				//Enter the Required Quantity
				driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(quan);
				Thread.sleep(1000);
				
				//Check whether the required filter is working or not
				try
				{
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[1]/td[1]/span")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Filter show the required data for Quantity filter");
						
						//Get the number of rows
						List<WebElement> filter_Rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
						
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+filter_Rows.size()+"]/td[8]/span")).getText().equals(quan))
						{}
						else
						{
							test.log(LogStatus.FAIL, "Unwanted data found for Quantity filter");
						}
						
						Thread.sleep(2000);
						//Clear the Quantity from the field
						driver.findElement(By.xpath("//input[@name='quantity']")).clear();
					}
				}
				catch(Exception e)
				{
					test.log(LogStatus.FAIL, "Filter not show the required data for Quantity filter");
				}
			}
		
			@Test(priority = 17,enabled=false)
			public void Discount_Report_Method_Check_View() throws Exception
		{
	
			//Get the Check Number for particular User
			String ticketNum = driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr[1]/td[1]/a")).getText();
			//System.out.println("ticketNum"+ticketNum);
			
			//Get the Transaction date for particular User
			String trandate = driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr[1]/td[2]/span")).getText();
			//System.out.println("trandate"+trandate);
			
			//Get the Total Tax Amount for particular User
			String tTaxAmt = driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr[1]/td[4]/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double atTaxAmt = Double.parseDouble(tTaxAmt);
			//System.out.println("atTaxAmt"+atTaxAmt);
			
			//Get the CC Service Charge for particular User
			String ccSCharge = driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr[1]/td[6]/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double accSCharge = Double.parseDouble(ccSCharge);
			//System.out.println("accSCharge"+accSCharge);
	
			//Get the Discount for particular User
			String disco = driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr[1]/td[7]/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double adisco = Double.parseDouble(disco);
			//System.out.println("adisco"+adisco);
			
			//Get the Gross Receipt for particular User
			String gRecipt = driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr[1]/td[8]/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double agRecipt = Double.parseDouble(gRecipt);
			//System.out.println("agRecipt"+agRecipt);
			Thread.sleep(2000);
			
			
			//Click the Check
			driver.findElement(By.xpath("//div[@class='row']/table/tbody/tr[1]/td[1]/a")).click();
			
			Thread.sleep(2000);
	
			//Get the Check Number for particular User
			String eticketNum = driver.findElement(By.xpath("//th[.='Check Number']/../td")).getText();
			
			//Get the Transaction date for particular User
			String etrandate = driver.findElement(By.xpath("//th[.='Date']/../td")).getText();
			
			//Get the Total Tax Amount for particular User
			String etTaxAmt = driver.findElement(By.xpath("//td[contains(.,'Tax Total')]/../td[2]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double aetTaxAmt = Double.parseDouble(etTaxAmt);
			
			//Get the CC Service Charge for particular User
			String eccSCharge = driver.findElement(By.xpath("//th[contains(.,'CC Service Charge')]/../td")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double aeccSCharge = Double.parseDouble(eccSCharge);
			
			//Get the Discount for particular User
			String edisco = driver.findElement(By.xpath("//th[contains(.,'Discount')]/../td")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double aedisco = Double.parseDouble(edisco);
			
			//Get the Gross Receipt for particular User
			String egRecipt = driver.findElement(By.xpath("//tr[contains(.,'Amount')]/../tr[3]/td[5]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double aegRecipt = Double.parseDouble(egRecipt);
			
			//Check Whether the Check Number is correct or not
			if(ticketNum.equals(eticketNum))
			{
				
			}
			else
			{
				test.log(LogStatus.FAIL, "Check Number is different between the user view screen and customer view screen");
			}
			
			//Check Whether the Transaction Date is correct or not
			if(trandate.equals(etrandate))
			{
				
			}
			else
			{
				test.log(LogStatus.FAIL, "Transaction is different between the user view screen and customer view screen");
			}
			
			//Check Whether the Total Tax Amount is correct or not
			if(atTaxAmt == aetTaxAmt)
			{
				
			}
			else
			{
				test.log(LogStatus.FAIL, "Total Tax Amount is different between the user view screen and customer view screen");
			}
			
			//Check Whether the CC Service Charge is correct or not
			if(accSCharge == aeccSCharge)
			{
				
			}
			else
			{
				test.log(LogStatus.FAIL, "CC Service Charge is different between the user view screen and customer view screen");
			}
			
			//Check Whether the Discount is correct or not
			if(adisco == aedisco)
			{
				
			}
			else
			{
				test.log(LogStatus.FAIL, "Discount is different between the user view screen and customer view screen");
			}
			
			//Check Whether the Gross Receipt is correct or not
			if(agRecipt == aegRecipt)
			{
				
			}
			else
			{
				test.log(LogStatus.FAIL, "Gross Receipt is different between the user view screen and customer view screen");
			}
		
			//Clear the mail Field
			driver.findElement(By.xpath("//input[@ng-model='saleSummary.email']")).clear();
			//Enter the email
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
			
			Thread.sleep(5000);
			//Click the Back button
			driver.findElement(By.xpath("//div[@ng-show='showDetailSummary']/div/a/i")).click();
			Thread.sleep(3000);
		}
}
