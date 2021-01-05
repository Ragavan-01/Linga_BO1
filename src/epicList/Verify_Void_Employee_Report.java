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

public class Verify_Void_Employee_Report {

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Verify_Void_Employee_Report");

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
	
			@Test(priority=19,enabled=true)
			public void Void_Node_Report_Method_Openpage () throws Exception
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
				WebElement element = driver.findElement(By.xpath("//span[.='Void']"));
				//Scroll the page till the Discount option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		       
				//Click the Void Option		
				driver.findElement(By.xpath("//span[.='Void']")).click(); */
				
				Thread.sleep(3000);
				//Enter the Users URL
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/empSale");
			
				Thread.sleep(5000);
				//Check Employee Report page opened or not
				if(driver.findElement(By.xpath("//label[.='Employee']")).getText().equalsIgnoreCase("Employee"))
				{
					test.log(LogStatus.PASS, "Employee report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Employee report page loaded Failed");
				}
				
				Thread.sleep(2000);
	
			}
		
			@Test(priority=20,enabled=true)
			public void Void_Node_Report_Method_Employees() throws Exception
			{
				Thread.sleep(5000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='empSale']/div[1]/div/div/a")).click();
				//Enter the required Employee
				driver.findElement(By.xpath("//form[@name='empSale']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='empSale']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='empSale']/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='empSale']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='empSale']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='empSale']/div[3]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='empSale']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='empSale']/div[3]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='empSale']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(5000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(5000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Void Employee Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[2]/td[5]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "Void Employee Report is available for Specific Date");
					
					//Get the number of rows
					List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr"));
					
					//Get the Quantity value
					String quantity = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+rows.size()+"]/td[4]")).getText();
					
					//Print the Total
					System.out.println("Total Quantity is : "+quantity);
					
					test.log(LogStatus.INFO, "Total Quantity is : "+quantity);
					
					//Get the amount value
					String amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					//Print the amount
					System.out.println("Total amount is : "+amount);
					
					test.log(LogStatus.INFO, "Total amount is : "+amount);
					
					//Get the Tax value
					String tax = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+rows.size()+"]/td[6]")).getText();
					
					//Print the Tax
					System.out.println("Total Tax is : "+tax);
					
					test.log(LogStatus.INFO, "Total Tax is : "+tax);
					
					//Get the discount value
					String discount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+rows.size()+"]/td[7]")).getText();
					
					//Print the discount
					System.out.println("Total Discount is : "+discount);
					
					test.log(LogStatus.INFO, "Total Discount is : "+discount);
					
					Thread.sleep(1000);
					int row = rows.size() - 1;
					
					//Click the Last Check Number
					driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+row+"]/td[1]/a")).click();
					
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
					driver.findElement(By.xpath("//i[@class='fa fa-arrow-left']")).click();
					Thread.sleep(3000);					
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Void Employee Report is not available for Specific Date");
				}
			}
}
