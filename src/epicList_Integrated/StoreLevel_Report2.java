package epicList_Integrated;

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
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import epicList_Chrome.Utility;


public class StoreLevel_Report2 {

		public WebDriver driver;
		
		
		ExtentReports rep = ExtentManager.getInstance();
		ExtentTest test = rep.startTest("Verify_StoreLevel_Report2");

		float unknownValue = 00;
		
			@AfterClass
			public void flushTest() throws Exception
			{
				Thread.sleep(2000);
				rep.endTest(test);
				rep.flush();
			}
	
			@AfterMethod
			public void tearDown(ITestResult result)
			{
				if(ITestResult.FAILURE == result.getStatus())
				{
					Utility.captureScreenshot(driver, result.getName());
				}
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
				Thread.sleep(3000);
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
			
			@Test(priority=2,enabled = true)
			public void Transaction_Report_Method_openpage(WebDriver driver) throws Exception
			{
			
				Thread.sleep(12000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				
				//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();Thread.sleep(2000);
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Transactions']"));Thread.sleep(2000);
				//Scroll the page till the Transactions option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Transactions Option		
				driver.findElement(By.xpath("//span[.='Transactions']")).click();
				Thread.sleep(5000);
				//Check Transactions Report page opened or not
				if(driver.findElement(By.xpath("//a[.='Transaction Sale']")).getText().equalsIgnoreCase("Transaction Sale"))
				{
					test.log(LogStatus.PASS, "Transactions report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Transactions report page loaded Failed");
				}
				
				Thread.sleep(2000);
	
			}
			
			@Test(priority=3,enabled = true)
			public void Transaction_Report_Method_For_Tender_Type(WebDriver driver) throws Exception
			{
	
				Thread.sleep(2000);
				//Select the Tender option
				Select tenderOption = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/select")));
				tenderOption.selectByVisibleText("By Tender Type");
				
				Thread.sleep(5000);
				//Click the Tender Type option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
				//Enter the required Tender Type
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
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
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Transaction Report(By Tender Type) is not available for Specific Date");
				}
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[2]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[10]")).getText() != null)
				{
					test.log(LogStatus.PASS, "Transaction Report(By Tender Type) available for Specific Date");
					
					//Get the number of rows
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
					
					//Get the Total amount value
					String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[10]")).getText();
					
					//Print the Total_Amount value
					System.out.println("Transaction report(By Tender Type) Total Amount is : "+Total_Amount);
					
					test.log(LogStatus.INFO, "Transaction report(By Tender Type) Total Amount is : "+Total_Amount);
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Transaction Report(By Tender Type) is not available for Specific Date");
				}
			}
			
			@Test(priority=4,enabled = true)
			public void Transaction_Report_Method_For_Tender_Name(WebDriver driver) throws Exception
			{
	
				Thread.sleep(2000);
				//Select the Tender option
				Select tenderOption = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/select")));
				tenderOption.selectByVisibleText("By Tender Name");
				
				Thread.sleep(5000);
				//Click the Tender Name option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
				//Enter the required Tender Name
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
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
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Transaction Report(By Tender Name) is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[2]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[10]")).getText() != null)
				{
					test.log(LogStatus.PASS, "Transaction Report(By Tender Name) available for Specific Date");
					
					//Get the number of rows
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
					
					//Get the Total amount value
					String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[10]")).getText();
								
					//Print the Total_Amount value
					System.out.println("Transaction report(By Tender Name) Total Amount is : "+Total_Amount);
					
					test.log(LogStatus.INFO, "Transaction report(By Tender Name) Total Amount is : "+Total_Amount);
					
						
			/*					String netSales = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[1]/td[3]/span")).getText();
						double netSalesAmt = Double.parseDouble(netSales);*/
						
						//driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[1]/td[1]/a")).click();
	
						int rowco = rows.size() - 1;
						//Get Amount Value
						String totAmt = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rowco+"]/td[10]")).getText();
						double totalAmt = Double.parseDouble(totAmt);
							
						//Get CC SErvice Charge
						String ccServiceCharge = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rowco+"]/td[9]")).getText();
						double ccServiceChargeAmt = Double.parseDouble(ccServiceCharge);
										
						//Get the Tip Amount
						String tip = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rowco+"]/td[11]")).getText();
						double tipAmt = Double.parseDouble(tip);
						
						//Click the Required Check
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rowco+"]/td[1]/a")).click();
						
						Thread.sleep(3000);
						//Get the Total Value
						String tot = driver.findElement(By.xpath("//th[.='Total']/../td")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
						double totaAmt = Double.parseDouble(tot);
							
						//Get the CC Service Charge Value
						String ccs =  driver.findElement(By.xpath("//th[.='CC Service Charge']/../td")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
						double ccsAmt = Double.parseDouble(ccs);
						
						//Get the Tip Value
						String tips =  driver.findElement(By.xpath("//th[.='Total Tip']/../td")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
						double tipsAmt = Double.parseDouble(tips);
	
						//Check whether the Total Amount value is correct or not 
						if(totalAmt == totaAmt)
						{
							test.log(LogStatus.PASS, "Total Amount value is correct");
						}
						else
						{
							double diff = totalAmt - totaAmt;
							test.log(LogStatus.FAIL, "Total Amount value is different : "+diff);
						}
						
						//Check whether the Total Tax is correct or not
						if(tipAmt == tipsAmt)
						{
							test.log(LogStatus.PASS, "Tip value is correct");
						}
						else
						{
							double diff = tipAmt - tipsAmt;
							test.log(LogStatus.FAIL, "Tip value is different : "+diff);
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
						
						
/*						Thread.sleep(2000);
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
						}*/
						Thread.sleep(3000);
						driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
						Thread.sleep(5000);
						//Click the Back button
						driver.findElement(By.xpath("//button[@class='btn btn-small btn-blue ng-binding']/../a")).click();
						Thread.sleep(3000);
					
				}		
				else
				{
					test.log(LogStatus.FAIL, "Transaction Report(By Tender Name) is not available for Specific Date");
				}
				
			}
			
			@Test(priority=5,enabled = true)
			public void Void_Transaction_Report_Method_openpage(WebDriver driver) throws Exception
			{
				/*
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
				WebElement element = driver.findElement(By.xpath("//span[.='Transactions']"));
				//Scroll the page till the Transactions option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Transactions Option		
				driver.findElement(By.xpath("//span[.='Transactions']")).click(); */
				
				Thread.sleep(3000);
				//Enter the Users URL
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/voidTransactionSale");
				
				Thread.sleep(5000);
	
				//Check weather the Void Transaction page is loaded or not
				if(driver.findElement(By.xpath("//li[@class='uib-tab nav-item ng-isolate-scope active']/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Void Transaction"))
				{
					test.log(LogStatus.PASS, "Void Transaction Report page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Void Transaction Report page loaded fail");
				}
	
				Thread.sleep(5000);
			}
			
			@Test(priority=6,enabled = true)
			public void Void_Transaction_Report_Method__For_Tender_Type(WebDriver driver) throws Exception
			{
	
				Thread.sleep(2000);
				//Select the Tender option
				Select tenderOption = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/select")));
				tenderOption.selectByVisibleText("By Tender Type");
				
				Thread.sleep(5000);
				//Click the Tender Type option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
				//Enter the required Tender Type
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
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
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Transaction Report(By Tender Type) is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[2]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[10]")).getText() != null)
				{
					test.log(LogStatus.PASS, "Void Transaction Report(By Tender Type) available for Specific Date");
					
					//Get the number of rows
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
					
					//Get the Total amount value
					String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[10]")).getText();
					
					//Print the Total_Amount value
					System.out.println("Void Transaction report(By Tender Type) Total Amount is : "+Total_Amount);
					
					test.log(LogStatus.INFO, "Void Transaction report(By Tender Type) Total Amount is : "+Total_Amount);
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Void Transaction Report(By Tender Type) is not available for Specific Date");
				}
			}
			
			@Test(priority=7,enabled = true)
			public void Void_Transaction_Report_Method__For_Tender_Name(WebDriver driver) throws Exception
			{
	
				Thread.sleep(2000);
				//Select the Tender option
				Select tenderOption = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/select")));
				tenderOption.selectByVisibleText("By Tender Name");
				
				Thread.sleep(5000);
				//Click the Tender Name option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
				//Enter the required Tender Name
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
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
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Transaction Report(By Tender name) is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[2]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[10]")).getText() != null)
				{
					test.log(LogStatus.PASS, "Void Transaction Report(By Tender Name) available for Specific Date");
					
					//Get the number of rows
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
					
					//Get the Total amount value
					String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[10]")).getText();
					
					//Print the Total_Amount value
					System.out.println("Void Transaction report(By Tender Name) Total Amount is : "+Total_Amount);
					
					test.log(LogStatus.INFO, "Void Transaction report(By Tender Name) Total Amount is : "+Total_Amount);
				
					int rowco = rows.size() - 1;
					//Get Amount Value
					String totAmt = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rowco+"]/td[10]")).getText();
					double totalAmt = Double.parseDouble(totAmt);
						
					//Get CC SErvice Charge
					String ccServiceCharge = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rowco+"]/td[9]")).getText();
					double ccServiceChargeAmt = Double.parseDouble(ccServiceCharge);
									
					//Get the Tip Amount
					String tip = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rowco+"]/td[11]")).getText();
					double tipAmt = Double.parseDouble(tip);
					
					//Click the Required Check
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rowco+"]/td[1]/a")).click();
					
					Thread.sleep(3000);
					//Get the Total Value
					String tot = driver.findElement(By.xpath("//th[.='Total']/../td")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double totaAmt = Double.parseDouble(tot);
						
					//Get the CC Service Charge Value
					String ccs =  driver.findElement(By.xpath("//th[.='CC Service Charge']/../td")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double ccsAmt = Double.parseDouble(ccs);
					
					//Get the Tip Value
					String tips =  driver.findElement(By.xpath("//th[.='Total Tip']/../td")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double tipsAmt = Double.parseDouble(tips);
	
					//Check whether the Total Amount value is correct or not 
					if(totalAmt == totaAmt)
					{
						test.log(LogStatus.PASS, "Total Amount value is correct");
					}
					else
					{
						double diff = totalAmt - totaAmt;
						test.log(LogStatus.FAIL, "Total Amount value is different : "+diff);
					}
					
					//Check whether the Total Tax is correct or not
					if(tipAmt == tipsAmt)
					{
						test.log(LogStatus.PASS, "Tip value is correct");
					}
					else
					{
						double diff = tipAmt - tipsAmt;
						test.log(LogStatus.FAIL, "Tip value is different : "+diff);
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
					
					Thread.sleep(3000);
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
					Thread.sleep(5000);
					//Click the Back button
					driver.findElement(By.xpath("//button[@class='btn btn-small btn-blue ng-binding']/../a")).click();
					Thread.sleep(3000);
				
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Void Transaction Report(By Tender Name) is not available for Specific Date");
				}
			}
			
			@Test(priority=8)
			public void Gift_Card_Report_openpage(WebDriver driver) throws Exception
			{
				/*
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
				WebElement element = driver.findElement(By.xpath("//span[.='Gift Card']"));
				//Scroll the page till the Gift Card option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Gift Card Option		
				driver.findElement(By.xpath("//span[.='Gift Card']")).click();*/
				
				Thread.sleep(3000);
				//Enter the Users URL
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/giftcardSale");
				
				Thread.sleep(5000);
				//Check Gift Card Report page opened or not
				if(driver.findElement(By.xpath("//a[.='Gift Card ']")).getText().equalsIgnoreCase("Gift Card"))
				{
					test.log(LogStatus.PASS, "Gift Card report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Gift Card report page loaded Failed");
				}
				
				Thread.sleep(2000);
	
	
			}
			
			@Test(priority=9)
			public void Gift_Card_Report_Verify(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Click the Activity Type option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
				//Enter the required Activity Type
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
				Thread.sleep(5000);
				//Click the Employee option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/a")).click();
				//Enter the required Employee
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Gift Card is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[7]")).getText() != null)
				{
					test.log(LogStatus.PASS, "Gift Card Report available for Specific Date");
					
					//Get the number of rows
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
					
					Thread.sleep(2000);
					//Print the Gift Card, Amount and Balance
					for(int i = 2; i <= rows.size(); i++)
					{
						//Get the Card_Number value
						String Card_Number = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+i+"]/td[1]")).getText();
						
						//Print the Card_Number value
						System.out.println("Gift Card number is : "+Card_Number);
						
						test.log(LogStatus.INFO, "Gift Card number is : "+Card_Number);
						
						//Get the Amount value
						String Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+i+"]/td[7]")).getText();
						
						//Print the Amount value
						System.out.println("Amount of "+Card_Number+" is : "+Amount);
						
						test.log(LogStatus.INFO, "Amount of "+Card_Number+" is : "+Amount);
						
						//Get the Balance value
						String Balance = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+i+"]/td[8]")).getText();
						
						//Print the Balance value
						System.out.println("Balance of "+Card_Number+" is : "+Balance);
						
						test.log(LogStatus.INFO, "Balance of "+Card_Number+" is : "+Balance);
	
					}
					
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Gift Card is not available for Specific Date");
				}
			}
	
			@Test(priority=9)
			public void Gift_Card_Report_Verify_Card_Search(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				//Click the Activity Type option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
				//Enter the required Activity Type
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
				
				//Click the Employee option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/a")).click();
				//Enter the required Employee
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(2000);
				//Click the Time Period option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
				
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				//Get the number of rows
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
	
				//Get the Card_Number value
				String Card = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[1]")).getText();
				
				//Clear the Card Input field
				driver.findElement(By.xpath("//input[@name='cardNumber']")).clear();
				//Enter the required card number
				driver.findElement(By.xpath("//input[@name='cardNumber']")).sendKeys(Card);
				
				Thread.sleep(2000);
				//Click the Activity Type option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
				//Enter the required Activity Type
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
				Thread.sleep(2000);
				//Click the Employee option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/a")).click();
				//Enter the required Employee
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				
				//Click the Time Period option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
				
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[5]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Gift Card is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[7]")).getText() != null)
				{
					test.log(LogStatus.PASS, "Gift Card Report available for Specific Date");
					
					Thread.sleep(2000);

						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText().equals(Card))
						{}
						
						else
						{
							test.log(LogStatus.FAIL, "Unwanted Card is available for the required search");
						}
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Gift Card is not available for Specific Date");
				}
			}
			
			@Test(priority=10,enabled = true)
			public void GiveX_Card_Report_Method_openpage(WebDriver driver) throws Exception
			{
			/*
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
				WebElement element = driver.findElement(By.xpath("//span[.='Gift Card']"));
				//Scroll the page till the Gift Card option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Gift Card Option		
				driver.findElement(By.xpath("//span[.='Gift Card']")).click();	*/
				
				Thread.sleep(3000);
				//Enter the Users URL
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/giveXReprot");
				
				Thread.sleep(5000);
				
				Thread.sleep(3000);
				//Check weather the GiveX page is loaded or not
				if(driver.findElement(By.xpath("//li[@class='uib-tab nav-item ng-isolate-scope active']/a/uib-tab-heading/span")).getText().equalsIgnoreCase("GiveX"))
				{
					test.log(LogStatus.PASS, "GiveX Card Report page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "GiveX Card Report page loaded fail");
				}
	
				Thread.sleep(5000);
			}
			
			@Test(priority=11,enabled = true)
			public void GiveX_Card_Report_Method_Verify(WebDriver driver) throws Exception
			{
	
				Thread.sleep(2000);
				//Click the Employee option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
				//Enter the required Employee
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				
				//Click the Time Period option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
				
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "GiveX Card is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[7]")).getText() != null)
				{
					test.log(LogStatus.PASS, "GiveX Card Report available for Specific Date");
					
					//Get the number of rows
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
					
					Thread.sleep(2000);
					//Print the Gift Card, Amount and Balance
					for(int i = 2; i <= rows.size(); i++)
					{
						//Get the Card_Number value
						String Card_Number = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+i+"]/td[1]")).getText();
						
						//Print the Card_Number value
						System.out.println("GiveX Card number is : "+Card_Number);
						
						test.log(LogStatus.INFO, "GiveX Card number is : "+Card_Number);
						
						//Get the Amount value
						String Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+i+"]/td[7]")).getText();
						
						//Print the Amount value
						System.out.println("Amount of "+Card_Number+" is : "+Amount);
						
						test.log(LogStatus.INFO, "Amount of "+Card_Number+" is : "+Amount);
	
					}
					
				}
				
				else
				{
					test.log(LogStatus.FAIL, "GiveX Card is not available for Specific Date");
				}
			}
	
			@Test(priority=11,enabled = true)
			public void GiveX_Card_Report_Method_Verify_Card_Search(WebDriver driver) throws Exception
			{
	
				Thread.sleep(2000);
				//Click the Employee option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
				//Enter the required Employee
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				
				//Click the Time Period option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
				
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				//Get the number of rows
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
	
				//Get the Card_Number value
				String Card_Number = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[1]")).getText();
	
				//Clear the Search field of card
				driver.findElement(By.xpath("//input[@name='cardNumber']")).clear();
				//Enter the card number
				driver.findElement(By.xpath("//input[@name='cardNumber']")).sendKeys(Card_Number);
				
				Thread.sleep(2000);
				//Click the Employee option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
				//Enter the required Employee
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				
				//Click the Time Period option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
				
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "GiveX Card is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[7]")).getText() != null)
				{
					test.log(LogStatus.PASS, "GiveX Card Report available for Specific Date");
					
					
					Thread.sleep(2000);
					//Print the Gift Card, Amount and Balance
					for(int i = 2; i <= rows.size(); i++)
					{
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+i+"]/td[1]")).getText().equals(Card_Number))
						{}
						
						else
						{
							test.log(LogStatus.FAIL, "Unwanted Card is available for the required search");
						}
					}
					
				}
				
				else
				{
					test.log(LogStatus.FAIL, "GiveX Card is not available for Specific Date");
				}
			}
				
			@Test(priority=12,enabled = true)
			public void Discount_Report_Method_OpenPage(WebDriver driver) throws Exception
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
			public void Discount_Report_Method_For_Summary(WebDriver driver) throws Exception
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
			public void Discount_Report_Method_For_ByEmployee(WebDriver driver) throws Exception
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
									
					Discount_Report_Search_Field_Discount_Report(driver);
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Discount Report is not available for Specific Date");
				}
			}
			
			@Test(priority=15,enabled = true)
			public void Discount_Report_Method_For_ByDiscount(WebDriver driver) throws Exception
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
					
					Discount_Report_Search_Field_Discount_Report(driver);
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Discount Report is not available for Specific Date");
				}
			}
			
			@Test(priority=16,enabled = true)
			public void Discount_Report_Method_For_ByDiscountType(WebDriver driver) throws Exception
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
										
					Discount_Report_Search_Field_Discount_Report(driver);
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Discount Report is not available for Specific Date");
				}
			}
			
			@Test(priority = 16,enabled=false)
			public void Discount_Report_Search_Field_Discount_Report(WebDriver driver) throws Exception
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
										
										Discount_Report_Method_Check_View(driver);
										
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
			public void Discount_Report_Method_Check_View(WebDriver driver) throws Exception
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
		
			@Test(priority=17,enabled=true)
			public void Node_Report_Method_Openpage(WebDriver driver) throws Exception
			{
			
			/*	Thread.sleep(2000);
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
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/void");
				
				Thread.sleep(5000);
				//Check Node Report page opened or not
				if(driver.findElement(By.xpath("//label[.='Node']")).getText().equalsIgnoreCase("Node"))
				{
					test.log(LogStatus.PASS, "Node report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Node report page loaded Failed");
				}
				
				Thread.sleep(2000);
	
			}
			
			@Test(priority=18,enabled=true)
			public void Node_Report_Method_Verify(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Click the Node option
				driver.findElement(By.xpath("//form[@name='nodeSale']/div[1]/div/div/a")).click();
				//Enter the required node
				driver.findElement(By.xpath("//form[@name='nodeSale']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='nodeSale']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='nodeSale']/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='nodeSale']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='nodeSale']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='nodeSale']/div[3]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='nodeSale']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='nodeSale']/div[3]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='nodeSale']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(5000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(5000);
				//Check weather the report is available for the selected time period
				if(driver.getPageSource().contains("No transaction for selected time period"))
				{
					test.log(LogStatus.FAIL, "Void Node Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[2]/td[6]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "Void Node Report is available for Specific Date");
					
					//Get the number of rows
					List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr"));
					
					//Get the Quantity value
					String quantity = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					//Print the Total
					System.out.println("Total Quantity is : "+quantity);
					
					test.log(LogStatus.INFO, "Total Quantity is : "+quantity);
					
					//Get the amount value
					String amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+rows.size()+"]/td[6]")).getText();
					
					//Print the amount
					System.out.println("Total amount is : "+amount);
					
					test.log(LogStatus.INFO, "Total amount is : "+amount);
					
					//Get the Tax value
					String tax = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+rows.size()+"]/td[7]")).getText();
					
					//Print the Tax
					System.out.println("Total Tax is : "+tax);
					
					test.log(LogStatus.INFO, "Total Tax is : "+tax);
					
					//Get the discount value
					String discount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+rows.size()+"]/td[9]")).getText();
					
					//Print the discount
					System.out.println("Total Discount is : "+discount);
					
					test.log(LogStatus.INFO, "Total Discount is : "+discount);
					
					int row = rows.size() - 1;
					
					//Click the Last Check Number
					driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+row+"]/td[2]/a")).click();
					
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
					test.log(LogStatus.FAIL, "Void Node Report is not available for Specific Date");
				}
			}
			
			@Test(priority=19,enabled=true)
			public void Void_Node_Report_Method_Openpage (WebDriver driver) throws Exception
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
			public void Void_Node_Report_Method_Employees(WebDriver driver) throws Exception
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
		
			@Test(priority=21,enabled=true)
			public void PaidIn_Or_PaidOut_Report_Method_openpage(WebDriver driver) throws Exception
			{
			/*
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
				WebElement element = driver.findElement(By.xpath("//span[.='Paid In/Paid Out']"));
				//Scroll the page till the Discount option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Paid In/Paid Out Option		
				driver.findElement(By.xpath("//span[.='Paid In/Paid Out']")).click(); */
				
				Thread.sleep(3000);
				//Enter the Users URL
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/paid");
				
				Thread.sleep(5000);
				//Check Paid In/Paid Out Report page opened or not
				if(driver.findElement(By.xpath("//a[.='Paid In/Paid Out']")).getText().equalsIgnoreCase("Paid In/Paid Out"))
				{
					test.log(LogStatus.PASS, "Paid In/Paid Out report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Paid In/Paid Out report page loaded Failed");
				}
				
				Thread.sleep(2000);
	
	
			}
			
			@Test(priority=22,enabled=true)
			public void PaidIn_Or_PaidOut_Report_Method_paidIn_VerifyALL(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Click the Paid Type option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
				//Enter the required Paid Type
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No Record for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Paid In/Paid Out Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[5]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "Paid In/Paid Out Report available for Specific Date");
					
					//Get the number of rows
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
					
					//Get the Total amount value
					String total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					//Print the Total amount
					System.out.println("Total Paid In/Paid Out Amount is : "+total_Amount);
					
					test.log(LogStatus.INFO, "Total Paid In/Paid Out Amount is : "+total_Amount);
					
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Paid In/Paid Out Report is not available for Specific Date");
				}
			}
			
			@Test(priority=23,enabled=true)
			public void PaidIn_Report_Method(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Click the Paid Type option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
				//Enter the required Paid Type
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("Paid In");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No Record for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Paid In Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[5]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "Paid In Report available for Specific Date");
					
					//Get the number of rows
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
					
					//Get the Total amount value
					String total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					//Print the Total amount
					System.out.println("Total Paid In Amount is : "+total_Amount);
					
					test.log(LogStatus.INFO, "Total Paid In Amount is : "+total_Amount);
					
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Paid In Report is not available for Specific Date");
				}
			}
			
			@Test(priority=24,enabled=true)
			public void PaidOut_Report_Method(WebDriver driver) throws Exception
			{
				Thread.sleep(5000);
				//Click the Paid Type option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
				//Enter the required Paid Type
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("Paid Out");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No Record for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Paid Out Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr[2]/td[5]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "Paid Out Report available for Specific Date");
					
					//Get the number of rows
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr"));
					
					//Get the Total amount value
					String total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					//Print the Total amount
					System.out.println("Total Paid Out Amount is : "+total_Amount);
					
					test.log(LogStatus.INFO, "Total Paid Out Amount is : "+total_Amount);	
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Paid Out Report is not available for Specific Date");
				}
			}	
	
			@Test(priority=25,enabled=true)
			public void Employee_Attendance_Report_Method_OpenPage(WebDriver driver) throws Exception
			{
				/*//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Employee']"));
				//Scroll the page till the Transaction option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Employee Option		
				driver.findElement(By.xpath("//span[.='Employee']")).click();*/
				
				Thread.sleep(3000);
				//Enter the Users URL
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/attendance");
				
				Thread.sleep(5000);
				//Check Attendance Report page opened or not
				if(driver.findElement(By.xpath("//a[.='Attendance']")).getText().equalsIgnoreCase("Attendance"))
				{
					test.log(LogStatus.PASS,"Attendance Report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"Attendance Report page loaded Failed");
				}
				
				Thread.sleep(3000);
			}
			
			@Test(priority=26,enabled=true)
			public void Employee_Attendance_Report_Method_For_InTime(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				//Select the Employee option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
			    
				  //Select the Specific date Time Period option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			   
			    
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
			   
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
	
			    //Select the Format option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/div/div/input")).sendKeys("In Time");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
			    //Select the Format option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[5]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='attendance']/div[5]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    Thread.sleep(2000);
			  //Click the Run
			    driver.findElement(By.xpath("//button[@type='submit']")).click();
			    Thread.sleep(3000);
			     
	
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Employee Attendance Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[3]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "Employee Attendance Report is available for Specific Date");
					
					//Get the number of rows
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
					
					//Get the total hours value
					String hours = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					//Print the Total
					System.out.println("Total Hours for In Time is : "+hours);
					
					test.log(LogStatus.INFO, "Total Hours for In Time is : "+hours);
											
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Employee Attendance Report is not available for Specific Date");
				}
			}
	
			@Test(priority=27,enabled=true)
			public void Employee_Attendance_Report_Method_For_InHours(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				//Select the Employee option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
			    
				  //Select the Specific date Time Period option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			   
			    
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
			    
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
	
			    //Select the Format option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/div/div/input")).sendKeys("In Hours");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
			    //Select the Format option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[5]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='attendance']/div[5]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
			    Thread.sleep(3000);
			    //Click the Run
			    driver.findElement(By.xpath("//button[@type='submit']")).click();
			    
			    Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Employee Attendance Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr[2]/td[3]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "Employee Attendance Report is available for Specific Date");
					
					//Get the number of rows
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
					
					//Get the total hours value
					String hours = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					//Print the Total
					System.out.println("Total Hours for In Hours is : "+hours);
					Thread.sleep(3000);
				     test.log(LogStatus.INFO, "Total Hours for In Hours is : "+hours);
											
				}
				
				else
				{
					Thread.sleep(3000);
				     
					test.log(LogStatus.FAIL, "Employee Attendance Report is not available for Specific Date");
				}
			}
			
			@Test(priority=26)
			public void Employee_Attendance_Report_Method_For_InTime_With_Dynamic_Report(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				//Select the Employee option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
			    
				  //Select the Specific date Time Period option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			   
			    
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
			   
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
	
			    //Select the Format option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/div/div/input")).sendKeys("In Time");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
			    //Select the Format option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[5]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='attendance']/div[5]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    Thread.sleep(2000);
			  //Click the Run
			    driver.findElement(By.xpath("//button[@type='submit']")).click();
			    Thread.sleep(5000);
			     
	
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Check In')]/../input")).isSelected()
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
	
			@Test(priority=27)
			public void Employee_Attendance_Report_Method_For_InHours_With_Dynamic_Report(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				//Select the Employee option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
			    
				  //Select the Specific date Time Period option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			   
			    
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
			    
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
	
			    //Select the Format option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/div/div/input")).sendKeys("In Hours");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
			    //Select the Format option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[5]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='attendance']/div[5]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
			    Thread.sleep(3000);
			    //Click the Run
			    driver.findElement(By.xpath("//button[@type='submit']")).click();
			    Thread.sleep(5000);
			     
	
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Check In')]/../input")).isSelected()
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

			@Test(priority=28,enabled=true)
			public void Employee_Payroll_Report_Method_DailyReport_Openpage(WebDriver driver) throws Exception
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
			public void Employee_Payroll_Report_Method_verifyDailyReport(WebDriver driver) throws Exception
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
			public void Employee_Payroll_Report_Method_verifyWeeklyReport(WebDriver driver) throws Exception
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
			public void Employee_Payroll_Report_Method_verifyDailyReport_With_Dynamic_Report(WebDriver driver) throws Exception
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
			public void Employee_Payroll_Report_Method_verifyWeeklyReport_With_Dynamic_Report(WebDriver driver) throws Exception
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

			@Test(priority=31)
			public void Employee_Labour_Report_Method_DailyReport_Openpage(WebDriver driver) throws Exception
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
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"labour");
				
				Thread.sleep(5000);
				
				//Check Labour Report page opened or not
				if(driver.findElement(By.xpath("//a[.='Labour']")).getText().equalsIgnoreCase("Labour"))
				{
					test.log(LogStatus.PASS,"Labour Report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"Labour Report page loaded Failed");
				}
				
			}
			
			@Test(priority=32)
			public void Employee_Labour_Report_Method_verifyDailyReport(WebDriver driver) throws Exception
			{
				
				Thread.sleep(1000);
				//Select the Employee option
			    driver.findElement(By.xpath("//form[@name='labour']/div[1]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='labour']/div[1]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='labour']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    Thread.sleep(1000);
			    //Select the Process as Daily
				Select process = new Select(driver.findElement(By.xpath("//form[@name='labour']/div[2]/div/select")));
				process.selectByVisibleText("Daily");                               
			    
		  	    //Thread.sleep(1000);
			    //Select the Specific date Time Period option
			    driver.findElement(By.xpath("//form[@name='labour']/div[3]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='labour']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='labour']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='labour']/div[4]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='labour']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='labour']/div[4]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='labour']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				  
				    //Select the Format option
				    driver.findElement(By.xpath("//form[@name='labour']/div[5]/div/div/a")).click();
				    //Enter the required Format
				    driver.findElement(By.xpath("//form[@name='labour']/div[5]/div/div/div/div/input")).sendKeys("In Time");
				    //Press the Enter key
				    driver.findElement(By.xpath("//form[@name='labour']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				  
				    //Select the Active/Inactive option
				    driver.findElement(By.xpath("//form[@name='labour']/div[6]/div/div/a")).click();
				    //Enter the required Active/Inactive
				    driver.findElement(By.xpath("//form[@name='labour']/div[6]/div/div/div/div/input")).sendKeys("All");
				    //Press the Enter key
				    driver.findElement(By.xpath("//form[@name='labour']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				    
				    //Click the Run
				    driver.findElement(By.xpath("//button[@type='submit']")).click();
				    Thread.sleep(1000);
				   
					//Check weather the report is available for the selected time period
					if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "Employee Labour Report is not available for Specific Date");
					}
					
					else if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText() != null && driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText() != null)
					{
						
						test.log(LogStatus.PASS, "Employee Labour Report(In Time and Daily) is available for Specific Date");
						
						System.out.println("******* The Below is Employee Labour Report for In Time(Daily) *******");
						
						test.log(LogStatus.INFO, "******* The Below is Employee Labour Report for In Time(Daily) *******");
						
						List<WebElement> rows = driver.findElements(By.xpath("//table[@class]/tbody/tr"));
						
						//Get the Net Sales Value
						String net_Sales = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[2]")).getText();
						
						System.out.println("Total Net Sales is : "+net_Sales);
						
						test.log(LogStatus.INFO, "Total Net Sales is : "+net_Sales);
						
						//Get the Hours Value
						String hours = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[3]")).getText();
						
						System.out.println("Total Hours is : "+hours);
						
						test.log(LogStatus.INFO, "Total Hours is : "+hours);
						
						//Get the Labour Value
						String labour = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[4]")).getText();
						
						System.out.println("Total Labour is : "+labour);
						
						test.log(LogStatus.INFO, "Total Labour is : "+labour);
						
						//Get the Percentage of Net Sales Value
						String percentage_Of_Net_Sales = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[5]")).getText();
						
						System.out.println("Total Percentage of Net Sales is : "+percentage_Of_Net_Sales);
						
						test.log(LogStatus.INFO, "Total Percentage of Net Sales is : "+percentage_Of_Net_Sales);
						
						//Get the Labour Percentage
						String labour_Percentage = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[6]")).getText();
						
						System.out.println("Total Labour Percentage is : "+labour_Percentage);
						
						test.log(LogStatus.INFO, "Total Labour Percentage is : "+labour_Percentage);
					}
					
					else
					{
						test.log(LogStatus.FAIL, "Employee Labour Report is not available for Specific Date");
					}  
			  	    	
					
					Thread.sleep(1000);
					//Select the Employee option
				    driver.findElement(By.xpath("//form[@name='labour']/div[1]/div/div/a")).click();
				    //Enter the required Employee
				    driver.findElement(By.xpath("//form[@name='labour']/div[1]/div/div/div/div/input")).sendKeys("All");
				    //Press the Enter key
				    driver.findElement(By.xpath("//form[@name='labour']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				    
				    Thread.sleep(3000);
				    //Select the Process as Daily
					Select process1 = new Select(driver.findElement(By.xpath("//form[@name='labour']/div[2]/div/select")));
					process1.selectByVisibleText("Daily");                               
				    
			  	    //Thread.sleep(1000);
			    //Select the Specific date Time Period option
			    driver.findElement(By.xpath("//form[@name='labour']/div[3]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='labour']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='labour']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='labour']/div[4]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='labour']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='labour']/div[4]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='labour']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
					  
					    //Select the Format option
					    driver.findElement(By.xpath("//form[@name='labour']/div[5]/div/div/a")).click();
					    //Enter the required Format
					    driver.findElement(By.xpath("//form[@name='labour']/div[5]/div/div/div/div/input")).sendKeys("In Hours");
					    //Press the Enter key
					    driver.findElement(By.xpath("//form[@name='labour']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
					  
					    //Select the Active/Inactive option
					    driver.findElement(By.xpath("//form[@name='labour']/div[6]/div/div/a")).click();
					    //Enter the required Active/Inactive
					    driver.findElement(By.xpath("//form[@name='labour']/div[6]/div/div/div/div/input")).sendKeys("All");
					    //Press the Enter key
					    driver.findElement(By.xpath("//form[@name='labour']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
					    
					    //Click the Run
					    driver.findElement(By.xpath("//button[@type='submit']")).click();
					    Thread.sleep(1000);
					   
						//Check weather the report is available for the selected time period
						if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
						{
							test.log(LogStatus.FAIL, "Employee Labour Report is not available for Specific Date");
						}
						
						else if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText() != null && driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText() != null)
						{
							
							test.log(LogStatus.PASS, "Employee Labour Report(In Hours and Daily) is available for Specific Date");
							
							System.out.println("******* The Below is Employee Labour Report for In Hours(Daily) *******");
							
							test.log(LogStatus.INFO, "******* The Below is Employee Labour Report for In Hours(Daily) *******");
							
							List<WebElement> rows = driver.findElements(By.xpath("//table[@class]/tbody/tr"));
							
							//Get the Net Sales Value
							String net_Sales = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[2]")).getText();
							
							System.out.println("Total Net Sales is : "+net_Sales);
							
							test.log(LogStatus.INFO, "Total Net Sales is : "+net_Sales);
							
							//Get the Hours Value
							String hours = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[3]")).getText();
							
							System.out.println("Total Hours is : "+hours);
							
							test.log(LogStatus.INFO, "Total Hours is : "+hours);
							
							//Get the Labour Value
							String labour = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[4]")).getText();
							
							System.out.println("Total Labour is : "+labour);
							
							test.log(LogStatus.INFO, "Total Labour is : "+labour);
							
							//Get the Percentage of Net Sales Value
							String percentage_Of_Net_Sales = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[5]")).getText();
							
							System.out.println("Total Percentage of Net Sales is : "+percentage_Of_Net_Sales);
							
							test.log(LogStatus.INFO, "Total Percentage of Net Sales is : "+percentage_Of_Net_Sales);
							
							//Get the Labour Percentage
							String labour_Percentage = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[6]")).getText();
							
							System.out.println("Total Labour Percentage is : "+labour_Percentage);
							
							test.log(LogStatus.INFO, "Total Labour Percentage is : "+labour_Percentage);
						}
						
						else
						{
							test.log(LogStatus.FAIL, "Employee Labour Report is not available for Specific Date");
						}  
			}

			@Test(priority=33)
			public void Employee_Labour_Report_Method_verifyWeeklyReport(WebDriver driver) throws Exception
			{

				
				Thread.sleep(1000);
				//Select the Employee option
			    driver.findElement(By.xpath("//form[@name='labour']/div[1]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='labour']/div[1]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='labour']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			  
			    //Select the Process as Daily
				Select process = new Select(driver.findElement(By.xpath("//form[@name='labour']/div[2]/div/select")));
				process.selectByVisibleText("Weekly");
					
		  	    //Thread.sleep(1000);
			    //Select the Specific date Time Period option
			    driver.findElement(By.xpath("//form[@name='labour']/div[3]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='labour']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='labour']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='labour']/div[4]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='labour']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='labour']/div[4]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='labour']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			    
			    //Select the Format option
			    driver.findElement(By.xpath("//form[@name='labour']/div[5]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='labour']/div[5]/div/div/div/div/input")).sendKeys("In Hours");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='labour']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    //Select the Active/Inactive option
			    driver.findElement(By.xpath("//form[@name='labour']/div[6]/div/div/a")).click();
			    //Enter the required Active/Inactive
			    driver.findElement(By.xpath("//form[@name='labour']/div[6]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='labour']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);

			    Thread.sleep(1000);
			     //Click the Run
			    driver.findElement(By.xpath("//button[@type='submit']")).click();
			    Thread.sleep(1000);

				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Employee Labour Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText() != null && driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "Employee Labour Report(In Hours and Weekly) is available for Specific Date");
					
					System.out.println("******* The Below is Employee Labour Report for In Hours(Weekly) *******");
					
					test.log(LogStatus.INFO, "******* The Below is Employee Labour Report for In Hours(Weekly) *******");
					
					List<WebElement> rows = driver.findElements(By.xpath("//table[@class]/tbody/tr"));
					
					//Get the Net Sales Value
					String net_Sales = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[2]")).getText();
					
					System.out.println("Total Net Sales is : "+net_Sales);
					
					test.log(LogStatus.INFO, "Total Net Sales is : "+net_Sales);
					
					//Get the Hours Value
					String hours = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[3]")).getText();
					
					System.out.println("Total Hours is : "+hours);
					
					test.log(LogStatus.INFO, "Total Hours is : "+hours);
					
					//Get the Labour Value
					String labour = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[4]")).getText();
					
					System.out.println("Total Labour is : "+labour);
					
					test.log(LogStatus.INFO, "Total Labour is : "+labour);
					
					//Get the Percentage of Net Sales Value
					String percentage_Of_Net_Sales = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					System.out.println("Total Percentage of Net Sales is : "+percentage_Of_Net_Sales);
					
					test.log(LogStatus.INFO, "Total Percentage of Net Sales is : "+percentage_Of_Net_Sales);
					
					//Get the Labour Percentage
					String labour_Percentage = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[6]")).getText();
					
					System.out.println("Total Labour Percentage is : "+labour_Percentage);
					
					test.log(LogStatus.INFO, "Total Labour Percentage is : "+labour_Percentage);
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Employee Labour Report is not available for Specific Date");
				}  
				
				Thread.sleep(1000);
				//Select the Employee option
			    driver.findElement(By.xpath("//form[@name='labour']/div[1]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='labour']/div[1]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='labour']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			  
			    //Select the Process as Daily
				Select process1 = new Select(driver.findElement(By.xpath("//form[@name='labour']/div[2]/div/select")));
				process1.selectByVisibleText("Weekly");
					
			    Thread.sleep(1000);
			    //Select the Specific date Time Period option
			    driver.findElement(By.xpath("//form[@name='labour']/div[3]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='labour']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='labour']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='labour']/div[4]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='labour']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='labour']/div[4]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='labour']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			    
			    //Select the Format option
			    driver.findElement(By.xpath("//form[@name='labour']/div[5]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='labour']/div[5]/div/div/div/div/input")).sendKeys("In Time");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='labour']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    //Select the Active/Inactive option
			    driver.findElement(By.xpath("//form[@name='labour']/div[6]/div/div/a")).click();
			    //Enter the required Active/Inactive
			    driver.findElement(By.xpath("//form[@name='labour']/div[6]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='labour']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);

			    Thread.sleep(1000);
			     //Click the Run
			    driver.findElement(By.xpath("//button[@type='submit']")).click();
			    Thread.sleep(1000);
			    
			    
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Employee Labour Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText() != null && driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "Employee Labour Report(In Time and Weekly) is available for Specific Date");
					
					System.out.println("******* The Below is Employee Labour Report for In Time(Weekly) *******");
					
					test.log(LogStatus.INFO, "******* The Below is Employee Labour Report for In Time(Weekly) *******");
					
					List<WebElement> rows = driver.findElements(By.xpath("//table[@class]/tbody/tr"));
					
					//Get the Net Sales Value
					String net_Sales = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[2]")).getText();
					
					System.out.println("Total Net Sales is : "+net_Sales);
					
					test.log(LogStatus.INFO, "Total Net Sales is : "+net_Sales);
					
					//Get the Hours Value
					String hours = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[3]")).getText();
					
					System.out.println("Total Hours is : "+hours);
					
					test.log(LogStatus.INFO, "Total Hours is : "+hours);
					
					//Get the Labour Value
					String labour = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[4]")).getText();
					
					System.out.println("Total Labour is : "+labour);
					
					test.log(LogStatus.INFO, "Total Labour is : "+labour);
					
					//Get the Percentage of Net Sales Value
					String percentage_Of_Net_Sales = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					System.out.println("Total Percentage of Net Sales is : "+percentage_Of_Net_Sales);
					
					test.log(LogStatus.INFO, "Total Percentage of Net Sales is : "+percentage_Of_Net_Sales);
					
					//Get the Labour Percentage
					String labour_Percentage = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[6]")).getText();
					
					System.out.println("Total Labour Percentage is : "+labour_Percentage);
					
					test.log(LogStatus.INFO, "Total Labour Percentage is : "+labour_Percentage);
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Employee Labour Report is not available for Specific Date");
				} 

			}

			@Test(priority=34,enabled=true)
			public void Employee_Gratuity_Report_Method_OpenPage(WebDriver driver) throws Exception
			{
			/*	//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Employee']"));
				//Scroll the page till the Transaction option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the void Option		
				driver.findElement(By.xpath("//span[.='Employee']")).click(); */
				
				Thread.sleep(3000);
				//Enter the Users URL
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/gratuity");
				
				Thread.sleep(5000);		 
				
				//Check Gratuity Report page opened or not
				if(driver.findElement(By.xpath("//a[.='Gratuity']")).getText().equalsIgnoreCase("Gratuity"))
				{
					test.log(LogStatus.PASS,"Gratuity Report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"Gratuity Report page loaded Failed");
				}	
			}
			
			@Test(priority=35,enabled=true)
			public void Employee_Gratuity_Report_Method_Verify(WebDriver driver) throws Exception
			{
			    Thread.sleep(3000);
			    //Select the Employee
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			   
			    //Select the Time Period option(Specific date)
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			   
			    Thread.sleep(1000);
			    //Clear the Date
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

			    Thread.sleep(1000);
			    //Clear the Date
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			   
			    //Select the Active/Inactive
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/a")).click();
			    //Enter the required Active/Inactive
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);

			    Thread.sleep(1000);
			    //Click the Run
			    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
			    Thread.sleep(10000);

				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Employee Gratuity Report is not available for Specific Date");
				}
				else
				{
					test.log(LogStatus.PASS, "Employee Gratuity Report is available for Specific Date");
				}
			}

			@Test(priority=36)
			public void Employee_CashTip_Report_Method_OpenPage(WebDriver driver) throws Exception
			{
				/*//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Employee']"));
				//Scroll the page till the Transaction option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
			    //Click the void Option		
				driver.findElement(By.xpath("//span[.='Employee']")).click(); */
				
				Thread.sleep(3000);
				//Enter the Users URL
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"cashTip");
				
				Thread.sleep(5000);
				
				//Check Cash Tip Report page opened or not
				if(driver.findElement(By.xpath("//a[.='Cash Tip']")).getText().equalsIgnoreCase("Cash Tip"))
				{
					test.log(LogStatus.PASS,"Cash Tip Report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"Cash Tip Report page loaded Failed");
				}
			}
		
			@Test(priority=37)
			public void Employee_CashTip_Report_Method_verify(WebDriver driver) throws Exception
				{
			    
			    //Select the Employee option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    //Select the Time Period option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/a")).click();
			    //Enter the required Period of time "Specific date"
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    
			    //Clear the date field
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[1]")).clear();
			    //Select the required Specific date
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
			    //Clear the date field
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[2]")).clear();
			    //Select the required Specific date
			    driver.findElement(By.xpath("//form[@name='attendance']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			      
			    //Select the Active/Inactive option
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/a")).click();
			    //Enter the required Active/Inactive
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='attendance']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			    //Click the Run
			    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
			    Thread.sleep(10000);
		
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Employee Cash Tip Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "Employee Cash Tip Report(In Time and Daily) is available for Specific Date");
					
					System.out.println("******* The Below is Employee Cash Tip Report for In Time(Daily) *******");
					
					test.log(LogStatus.INFO, "******* The Below is Employee Cash Tip Report for In Time(Daily) *******");
					
					List<WebElement> rows = driver.findElements(By.xpath("//table[@class]/tbody/tr"));
					
					//Get the net sales Value
					String net_Sales = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[3]")).getText();
					
					System.out.println("Total Net Sales is : "+net_Sales);
					
					test.log(LogStatus.INFO, "Total Net Sales is : "+net_Sales);
					
					//Get the non cash Value
					String non_Cash = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					System.out.println("Total Non Cash is : "+non_Cash);
					
					test.log(LogStatus.INFO, "Total Non Cash is : "+non_Cash);
					
					//Get the expected cash Value
					String expected_Cash = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[6]")).getText();
					
					System.out.println("Total Expected Cash is : "+expected_Cash);
					
					test.log(LogStatus.INFO, "Total Expected Cash is : "+expected_Cash);
					
					//Get the declared cash value
					String declared_Cash = driver.findElement(By.xpath("//table[@class]/tbody/tr["+rows.size()+"]/td[7]")).getText();
					
					System.out.println("Total Declared Cash is : "+declared_Cash);
					
					test.log(LogStatus.INFO, "Total Declared Cash is : "+declared_Cash);
					
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Employee Cash Tip Report is not available for Specific Date");
				}  
			     
			}
			
			@Test(priority=38,enabled=true)
			public void Employee_HAActivity_Repor_Method_Openpage(WebDriver driver) throws Exception
			{
			/*	//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    // Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[9]/ul/li[8]/a/span"));
				//Scroll the page till the House Account option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
			
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				
				Thread.sleep(5000);
				//Click the House Account Option		
				driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[9]/ul/li[8]/a")).click();   */
				
			    Thread.sleep(3000);
				//Enter the Users URL
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"houseAccountReport");
			 
			 	Thread.sleep(5000);
				//Check House Account page opened or not
				if(driver.findElement(By.xpath("//a[.='House Account']")).getText().equalsIgnoreCase("House Account"))
				{
					test.log(LogStatus.PASS,"House Account Report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"House Account Report page loaded Failed");
				}
		   		
			}
		 
		   @Test(priority=39,enabled=true)
			public void Employee_HAActivity_Repor_Method_verify(WebDriver driver) throws Exception
			{
				Thread.sleep(3000);
				//Select the Activity type option
			    driver.findElement(By.xpath("//form[@name='haSale']/div[2]/div/div/a")).click();
			    //Enter the required Activity type
			    driver.findElement(By.xpath("//form[@name='haSale']/div[2]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='haSale']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			    //Select the Employee option
			    driver.findElement(By.xpath("//form[@name='haSale']/div[3]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='haSale']/div[3]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='haSale']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    //Select the Time Period option(Specific date)
			    driver.findElement(By.xpath("//form[@name='haSale']/div[4]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='haSale']/div[4]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='haSale']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			   
			    
			    //Clear the Date
			    driver.findElement(By.xpath("//form[@name='haSale']/div[5]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='haSale']/div[5]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		
			    //Clear the Date
			    driver.findElement(By.xpath("//form[@name='haSale']/div[5]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='haSale']/div[5]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			    
			    //Click the Run
			    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
			    Thread.sleep(10000);
		
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "House Account Activity Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[2]/td[7]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "House Account Activity Report is available for Specific Date");
					
					List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr"));
					
					for(int i = 2; i <= rows.size(); i++)
					{
						String customer = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+i+"]/td[3]")).getText();
						
						String amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+i+"]/td[7]")).getText();
						
						String balance = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+i+"]/td[8]")).getText();
					
						String check_number = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+i+"]/td[4]")).getText();
		
						System.out.println("The Card number is : "+customer+"(Check number is : "+check_number+")");
						
						test.log(LogStatus.INFO, "The Card number is : "+customer+"(Check number is : "+check_number+")");
						
						System.out.println(customer+"("+check_number+") have the Amount is : "+amount);
						
						test.log(LogStatus.INFO, customer+"("+check_number+") have the Amount is : "+amount);
						
						System.out.println(customer+"("+check_number+") have the Balance is : "+balance);
						
						test.log(LogStatus.INFO, customer+"("+check_number+") have the Balance is : "+balance);
					}
					
				}
				
				else
				{
					test.log(LogStatus.FAIL, "House Account Activity Report is not available for Specific Date");
				}  
			}
		
		    @Test(priority=39,enabled=true)
			public void Employee_HAActivity_Repor_Method_verify_Card_Number(WebDriver driver) throws Exception
			{
				Thread.sleep(3000);
				//Select the Activity type option
			    driver.findElement(By.xpath("//form[@name='haSale']/div[2]/div/div/a")).click();
			    //Enter the required Activity type
			    driver.findElement(By.xpath("//form[@name='haSale']/div[2]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='haSale']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			    //Select the Employee option
			    driver.findElement(By.xpath("//form[@name='haSale']/div[3]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='haSale']/div[3]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='haSale']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    //Select the Time Period option(Specific date)
			    driver.findElement(By.xpath("//form[@name='haSale']/div[4]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='haSale']/div[4]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='haSale']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			    //Clear the Date
			    driver.findElement(By.xpath("//form[@name='haSale']/div[5]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='haSale']/div[5]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
			    //Clear the Date
			    driver.findElement(By.xpath("//form[@name='haSale']/div[5]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='haSale']/div[5]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
			    
			    //Click the Run
			    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
			    Thread.sleep(10000);
			    
				List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr"));
		
				String cardNum = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+rows.size()+"]/td[3]")).getText();
				//System.out.println("CARD NUMBER : "+cardNum);
				
				Thread.sleep(1000);
				//Clear the Card Number Field
				driver.findElement(By.name("cardNumber")).clear();
				//Enter the Required Card Number
				driver.findElement(By.name("cardNumber")).sendKeys(cardNum);
				
				Thread.sleep(1000);
				//Select the Activity type option
			    driver.findElement(By.xpath("//form[@name='haSale']/div[2]/div/div/a")).click();
			    //Enter the required Activity type
			    driver.findElement(By.xpath("//form[@name='haSale']/div[2]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='haSale']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			    //Select the Employee option
			    driver.findElement(By.xpath("//form[@name='haSale']/div[3]/div/div/a")).click();
			    //Enter the required Employee
			    driver.findElement(By.xpath("//form[@name='haSale']/div[3]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='haSale']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    //Select the Time Period option(Specific date)
			    driver.findElement(By.xpath("//form[@name='haSale']/div[4]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='haSale']/div[4]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='haSale']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			   
			    
			    //Clear the Date
			    driver.findElement(By.xpath("//form[@name='haSale']/div[5]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='haSale']/div[5]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
			    
			    //Clear the Date
			    driver.findElement(By.xpath("//form[@name='haSale']/div[5]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='haSale']/div[5]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
			    Thread.sleep(2000);
			    
			    //Click the Run
			    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
			    Thread.sleep(10000);
		
				
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "House Account Activity Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[2]/td[7]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "House Account Activity Report is available for Specific Date");
								
					for(int i = 2; i <= rows.size(); i++)
					{
						String cNum = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+i+"]/td[3]")).getText();
						
						if(cardNum.equals(cNum))
						{
						}
						else
						{
							test.log(LogStatus.FAIL, "Card Filter details displayed fail");
						}
					}
					
				}
				
				else
				{
					test.log(LogStatus.FAIL, "House Account Activity Report is not available for Specific Date");
				}  
			}
		
			@Test(priority=40,enabled=true)
			public void Employee_HAStatement_Report_Method_Openpage(WebDriver driver) throws Exception
		{
			/* //Click the Reports option
			driver.findElement(By.xpath("//span[.='Reports']")).click();
			//Time Limit
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   	    // Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[9]/ul/li[8]/a/span"));
			//Scroll the page till the House Account option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
			
			/*WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			*/
			//Thread.sleep(3000);
	        //Click the House Account Option		
			//driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[9]/ul/li[8]/a/span")).click();    */
			
			Thread.sleep(3000);
			//Enter the Users URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"haStatementReport");
				
			Thread.sleep(5000);
			//Check House Account page opened or not
			if(driver.findElement(By.xpath("//li[@class='uib-tab nav-item ng-isolate-scope active']/a/uib-tab-heading/span")).getText().equalsIgnoreCase("HA Statement"))
			{
				test.log(LogStatus.PASS,"House Account Statement Report page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"House Account Statement Report page loaded Failed");
			}
		}
	    
		    @Test(priority=41,enabled=true)
			public void Employee_HAStatement_Report_Method_verifyALL(WebDriver driver) throws Exception
			{
				Thread.sleep(3000);
				//Select the Customer option
			    driver.findElement(By.xpath("//form[@name='haSale']/div[1]/div/div/a")).click();
			    //Enter the required Customer
			    driver.findElement(By.xpath("//form[@name='haSale']/div[1]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='haSale']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			   	  
			    //Select the Time Period option(Specific date)
			    driver.findElement(By.xpath("//form[@name='haSale']/div[2]/div/div/a")).click();
			    //Enter the required Period of time
			    driver.findElement(By.xpath("//form[@name='haSale']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='haSale']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			   
			    Thread.sleep(2000);
			    //Clear the number of day field
			    driver.findElement(By.xpath("//form[@name='haSale']/div[3]/div/div/input[1]")).clear();
			    //Enter the number of days
			    driver.findElement(By.xpath("//form[@name='haSale']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
			    Thread.sleep(2000);
			    //Clear the number of day field
			    driver.findElement(By.xpath("//form[@name='haSale']/div[3]/div/div/input[2]")).clear();
			    //Enter the number of days
			    driver.findElement(By.xpath("//form[@name='haSale']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			    
			    //Click the Run
			    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
			    Thread.sleep(10000);
	
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "House Account Statement Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[2]/td[1]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "House Account Statement Report is available for Specific Date");
					
				}
				
				else
				{
					test.log(LogStatus.FAIL, "House Account Statement Report is not available for Specific Date");
				}  
			    Thread.sleep(5000);
			}
	
		    @Test(priority=50,enabled=true)
			public void Employee_Role_Based_Payroll_Report_Method_Page_Open(WebDriver driver) throws Exception
		{
	/*		//Click the Reports option
			driver.findElement(By.xpath("//span[.='Reports']")).click();
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Employee']"));
			//Scroll the page till the Transaction option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
		    //Click the Employee Option		
			driver.findElement(By.xpath("//span[.='Employee']")).click();
			Thread.sleep(5000);
			//Check Attendance Report page opened or not
			if(driver.findElement(By.xpath("//a[.='Attendance']")).getText().equalsIgnoreCase("Attendance"))
			{
				test.log(LogStatus.PASS,"Attendance Report page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Attendance Report page loaded Failed");
			}*/
			Thread.sleep(3000);
			//Click the Payroll option
			//driver.findElement(By.xpath("//span[text()[normalize-space()='Role Based Payroll']]")).click();
			//Enter the Users URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"roleBasedPayroll");
	
			
			//Check Payroll Report page opened or not
			if(driver.findElement(By.xpath("//a[.='RoleBasedPayroll']")).getText().equalsIgnoreCase("RoleBasedPayroll"))
			{
				test.log(LogStatus.PASS,"Role Based Payroll Report page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Role Based Payroll Report page loaded Failed");
			}
			
		}
	
			@Test(priority=51,enabled=true)
			public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport(WebDriver driver) throws Exception
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
					
				    //Select the Role option
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[8]/div/div/a")).click();
				    //Enter the required Role
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[8]/div/div/div/div/input")).sendKeys("All");
				    //Press the Enter key
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[8]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
				    //Click the Run
				    driver.findElement(By.xpath("//button[@type='submit']")).click();
				    Thread.sleep(1000);
				   
					//Check weather the report is available for the selected time period
					if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
					}
					
					else if(driver.findElement(By.xpath("//span[@class='lbl ng-binding ng-scope']")).getText() != null)
					{
						
						test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
						
						System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
						
						test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");
						
						List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
						
						//Get Per Rate value
						String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
						
						System.out.println("Total Per Rate is : "+perRate);
						
						test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
						
						//Get Reg Hours
						String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();
						
						System.out.println("Total Reg Hours is : "+regHours);
						
						test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
						
						//Get Reg Pay
						String regPay = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();
						
						System.out.println("Total Reg Pay is : "+regPay);
						
						test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
						
						//Get OT Hours
						String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]")).getText();
						
						System.out.println("Total OT Hours is : "+otHours);
						
						test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);
						
						//Get OT Pay
						String otPay = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
						
						System.out.println("Total OT Pay is : "+otPay);
						
						test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);
						
						//Get Total Hours
						String hours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[9]")).getText();
						
						System.out.println("Total Hours is : "+hours);
						
						test.log(LogStatus.INFO, "Total Hours is : "+hours);
						
						//Get TTL Pay
						String ttlPay = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[10]")).getText();
						
						System.out.println("Total TTL Pay is : "+ttlPay);
						
						test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
						
						//Get CC Tip
						String ccTip = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[11]")).getText();
						
						System.out.println("Total CC Tip is : "+ccTip);
						
						test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
						
						//Get Gratuity
						String gratuity = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[12]")).getText();
						
						System.out.println("Total Gratuity is : "+gratuity);
						
						test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
						
						//Get Other Tips
						String otherTips = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[13]")).getText();
						
						System.out.println("Total Other Tips is : "+otherTips);
						
						test.log(LogStatus.INFO, "Total Other Tips is : "+otherTips);
						
						//Get Declared Cash Tip
						String declaredCashTip = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[14]")).getText();
						
						System.out.println("Total Declared Cash Tip is : "+declaredCashTip);
						
						test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);
						
						//Get Total Tips
						String tip = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[15]")).getText();
						
						System.out.println("Total Tips is : "+tip);
						
						test.log(LogStatus.INFO, "Total Tips is : "+tip);
						
						//Get Net Sales
						String netSales = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[16]")).getText();
						
						System.out.println("Total Net Sales is : "+netSales);
						
						test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);
						
						//Get Expected Tip
						String expectedTip = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[17]")).getText();
						
						System.out.println("Total Expected Tip is : "+expectedTip);
						
						test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
						
						
						ArrayList<String> obtainedList = new ArrayList<>(); 
						List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
						for(int i = 1; i <= elementList.size(); i++)
						{
							String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
							
							String[] name = namess.split(" ");
							//System.out.println("TEST A-Z First : "+name[0]);
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
					    
					    //Select the Role option
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[8]/div/div/a")).click();
					    //Enter the required Role
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[8]/div/div/div/div/input")).sendKeys("All");
					    //Press the Enter key
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[8]/div/div/div/div/input")).sendKeys(Keys.ENTER);
					    
					    //Click the Run
					    driver.findElement(By.xpath("//button[@type='submit']")).click();
					    Thread.sleep(1000);
					   
						//Check weather the report is available for the selected time period
						if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
						{
							test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
						}
						
						else if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[1]/td[1]")).getText() != null)
						{
							
							test.log(LogStatus.PASS, "Employee Payroll Report(In Hours and Daily) is available for Specific Date");
							
							System.out.println("******* The Below is Employee Payroll Report for In Hours(Daily) *******");
							
							test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Daily) *******");
							
							List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
							
							//Get Per Rate value
							String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
							
							System.out.println("Total Per Rate is : "+perRate);
							
							test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
							
							//Get Reg Hours
							String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();
							
							System.out.println("Total Reg Hours is : "+regHours);
							
							test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
							
							//Get Reg Pay
							String regPay = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();
							
							System.out.println("Total Reg Pay is : "+regPay);
							
							test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
							
							//Get OT Hours
							String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]")).getText();
							
							System.out.println("Total OT Hours is : "+otHours);
							
							test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);
							
							//Get OT Pay
							String otPay = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
							
							System.out.println("Total OT Pay is : "+otPay);
							
							test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);
							
							//Get Total Hours
							String hours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[9]")).getText();
							
							System.out.println("Total Hours is : "+hours);
							
							test.log(LogStatus.INFO, "Total Hours is : "+hours);
							
							//Get TTL Pay
							String ttlPay = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[10]")).getText();
							
							System.out.println("Total TTL Pay is : "+ttlPay);
							
							test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
							
							//Get CC Tip
							String ccTip = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[11]")).getText();
							
							System.out.println("Total CC Tip is : "+ccTip);
							
							test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
							
							//Get Gratuity
							String gratuity = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[12]")).getText();
							
							System.out.println("Total Gratuity is : "+gratuity);
							
							test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
							
							//Get Other Tips
							String otherTips = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[13]")).getText();
							
							System.out.println("Total Other Tips is : "+otherTips);
							
							test.log(LogStatus.INFO, "Total Other Tips is : "+otherTips);
							
							//Get Declared Cash Tip
							String declaredCashTip = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[14]")).getText();
							
							System.out.println("Total Declared Cash Tip is : "+declaredCashTip);
							
							test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);
							
							//Get Total Tips
							String tip = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[15]")).getText();
							
							System.out.println("Total Tips is : "+tip);
							
							test.log(LogStatus.INFO, "Total Tips is : "+tip);
							
							//Get Net Sales
							String netSales = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[16]")).getText();
							
							System.out.println("Total Net Sales is : "+netSales);
							
							test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);
							
							//Get Expected Tip
							String expectedTip = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[17]")).getText();
							
							System.out.println("Total Expected Tip is : "+expectedTip);
							
							test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
							
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
			
			@Test(priority=52,enabled=true)
			public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport(WebDriver driver) throws Exception
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
				
			    //Select the Role option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[8]/div/div/a")).click();
			    //Enter the required Role
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[8]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[8]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    Thread.sleep(2000);
			    //Enable or Disable the show summary only options
			   driver.findElement(By.xpath("//form[@name='payRoll']/div[9]/div/div/input")).click();
			    
	
			    Thread.sleep(1000);
			     //Click the Run
			    driver.findElement(By.xpath("//button[@type='submit']")).click();
			    Thread.sleep(1000);
			
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//span[@class='lbl ng-binding ng-scope']")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "Employee Payroll Report(In Hours and Weekly) is available for Specific Date");
					
					System.out.println("******* The Below is Employee Payroll Report for In Hours(Weekly) *******");
					
					test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Weekly) *******");
					
					List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
					//Get Summary
					
					String Summary = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]")).getText();
					System.out.println("Total Summary is : "+Summary);
										
					test.log(LogStatus.INFO, "Total Summary is : "+Summary);
					//Get Per Rate value
					String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
					
					System.out.println("Total Per Rate is : "+perRate);
					
					test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
					
					//Get Reg Hours
					String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					System.out.println("Total Reg Hours is : "+regHours);
					
					test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
					
					//Get Reg Pay
					String regPay = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();
					
					System.out.println("Total Reg Pay is : "+regPay);
					
					test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
					
					//Get OT Hours
					String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]")).getText();
					
					System.out.println("Total OT Hours is : "+otHours);
					
					test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);
					
					//Get OT Pay
					String otPay = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
					
					System.out.println("Total OT Pay is : "+otPay);
					
					test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);
					
					//Get Total Hours
					String hours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[9]")).getText();
					
					System.out.println("Total Hours is : "+hours);
					
					test.log(LogStatus.INFO, "Total Hours is : "+hours);
					
					//Get TTL Pay
					String ttlPay = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[10]")).getText();
					
					System.out.println("Total TTL Pay is : "+ttlPay);
					
					test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
					
					//Get CC Tip
					String ccTip = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[11]")).getText();
					
					System.out.println("Total CC Tip is : "+ccTip);
					
					test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
					
					//Get Gratuity
					String gratuity = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[12]")).getText();
					
					System.out.println("Total Gratuity is : "+gratuity);
					
					test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
					
					//Get Other Tips
					String otherTips = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[13]")).getText();
					
					System.out.println("Total Other Tips is : "+otherTips);
					
					test.log(LogStatus.INFO, "Total Other Tips is : "+otherTips);
					
					//Get Declared Cash Tip
					String declaredCashTip = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[14]")).getText();
					
					System.out.println("Total Declared Cash Tip is : "+declaredCashTip);
					
					test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);
					
					//Get Total Tips
					String tip = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[15]")).getText();
					
					System.out.println("Total Tips is : "+tip);
					
					test.log(LogStatus.INFO, "Total Tips is : "+tip);
					
					//Get Net Sales
					String netSales = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[16]")).getText();
					
					System.out.println("Total Net Sales is : "+netSales);
					
					test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);
					
					//Get Expected Tip
					String expectedTip = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[17]")).getText();
					
					System.out.println("Total Expected Tip is : "+expectedTip);
					
					test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
					
					
					
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
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Payroll_Date_Range_To"));
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
				
			    //Select the Role option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[8]/div/div/a")).click();
			    //Enter the required Role
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[8]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[8]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    Thread.sleep(1000);
			     //Click the Run
			    driver.findElement(By.xpath("//button[@type='submit']")).click();
			    Thread.sleep(1000);
			    
			    
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[2]/td[1]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Weekly) is available for Specific Date");
					
					System.out.println("******* The Below is Employee Payroll Report for In Time(Weekly) *******");
					
					test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Weekly) *******");
					
					List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
					//Get Summary
					
					String Summary = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]")).getText();
					System.out.println("Total Summary is : "+Summary);
										
					test.log(LogStatus.INFO, "Total Summary is : "+Summary);
					
					//Get Per Rate value
					String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
					
					System.out.println("Total Per Rate is : "+perRate);
					
					test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
					
					//Get Reg Hours
					String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					System.out.println("Total Reg Hours is : "+regHours);
					
					test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
					
					//Get Reg Pay
					String regPay = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();
					
					System.out.println("Total Reg Pay is : "+regPay);
					
					test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
					
					//Get OT Hours
					String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]")).getText();
					
					System.out.println("Total OT Hours is : "+otHours);
					
					test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);
					
					//Get OT Pay
					String otPay = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
					
					System.out.println("Total OT Pay is : "+otPay);
					
					test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);
					
					//Get Total Hours
					String hours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[9]")).getText();
					
					System.out.println("Total Hours is : "+hours);
					
					test.log(LogStatus.INFO, "Total Hours is : "+hours);
					
					//Get TTL Pay
					String ttlPay = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[10]")).getText();
					
					System.out.println("Total TTL Pay is : "+ttlPay);
					
					test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
					
					//Get CC Tip
					String ccTip = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[11]")).getText();
					
					System.out.println("Total CC Tip is : "+ccTip);
					
					test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
					
					//Get Gratuity
					String gratuity = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[12]")).getText();
					
					System.out.println("Total Gratuity is : "+gratuity);
					
					test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
					
					//Get Other Tips
					String otherTips = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[13]")).getText();
					
					System.out.println("Total Other Tips is : "+otherTips);
					
					test.log(LogStatus.INFO, "Total Other Tips is : "+otherTips);
					
					//Get Declared Cash Tip
					String declaredCashTip = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[14]")).getText();
					
					System.out.println("Total Declared Cash Tip is : "+declaredCashTip);
					
					test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);
					
					//Get Total Tips
					String tip = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[15]")).getText();
					
					System.out.println("Total Tips is : "+tip);
					
					test.log(LogStatus.INFO, "Total Tips is : "+tip);
					
					//Get Net Sales
					String netSales = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[16]")).getText();
					
					System.out.println("Total Net Sales is : "+netSales);
					
					test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);
					
					//Get Expected Tip
					String expectedTip = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[17]")).getText();
					
					System.out.println("Total Expected Tip is : "+expectedTip);
					
					test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
					
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
	
			@Test(priority=60,enabled=true)
			public void Employee_Labour_By_Job_Code_Report_Method_PageOpen(WebDriver driver) throws Exception
			{
	/*			//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Employee']"));
				//Scroll the page till the Transaction option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Employee Option		
				driver.findElement(By.xpath("//span[.='Employee']")).click();
				Thread.sleep(1000);
				//Check Labour By Job Code Report page opened or not
				if(driver.findElement(By.xpath("//a[.='Attendance']")).getText().equalsIgnoreCase("Attendance"))
				{
					test.log(LogStatus.PASS,"Attendance Report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"Attendance Report page loaded Failed");
				}*/
				Thread.sleep(3000);
				//Click the Labour By Job Code option
				//driver.findElement(By.xpath("//span[contains(.,'Labor By Job Code')]")).click();
				//Enter the Users URL
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"laborReport");
	
				Thread.sleep(1500);
				//Check Labour By Job Code Report page opened or not
				if(driver.findElement(By.xpath("//a[.='Labor Report']")).getText().equalsIgnoreCase("Labor Report"))
				{
					test.log(LogStatus.PASS,"Labour By Job Code Report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"Labour By Job Code Report page loaded Failed");
				}
				
			}
	
			@Test(priority=61,enabled=true)
			public void Employee_Labour_By_Job_Code_Report_Method_verifyDailyReport(WebDriver driver) throws Exception
			{
				
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
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				  
				    //Select the Format option
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/a")).click();
				    //Enter the required Format
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys("In Time");
				    //Press the Enter key
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				  
				    //Select the Active/Inactive option
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/a")).click();
				    //Enter the required Active/Inactive
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys("All");
				    //Press the Enter key
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				    
				    //Select the Role option
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/div/a")).click();
				    //Enter the required Role
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/div/div/div/input")).sendKeys("All");
				    //Press the Enter key
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
				    //Click the Run
				    driver.findElement(By.xpath("//button[@type='submit']")).click();
				    Thread.sleep(1000);
				   
					//Check weather the report is available for the selected time period
					if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
					{
						test.log(LogStatus.FAIL, "Employee Labour By Job Code Report is not available for Specific Date");
					}
					
					else if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[2]/td[2]")).getText() != null)
					{
						
						test.log(LogStatus.PASS, "Employee Labour By Job Code Report(In Time and Daily) is available for Specific Date");
						
						System.out.println("******* The Below is Employee Labour By Job Code Report for In Time(Daily) *******");
						
						test.log(LogStatus.INFO, "******* The Below is Employee Labour By Job Code Report for In Time(Daily) *******");
						
						List<WebElement> rows = driver.findElements(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr"));
						
						//Get the Hours
						String hours = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
						
						System.out.println("Total Hours is : "+hours);
						
						test.log(LogStatus.INFO, "Total Hours is : "+hours);
						
						//Get the Reg Pay
						String regPay = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
						
						System.out.println("Total Reg Pay is : "+regPay);
						
						test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
						
						//Get the OT Hours
						String otHours = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
						
						System.out.println("Total OT Hours is : "+otHours);
						
						test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);
						
						//Get the OT Pay
						String otPay = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[7]")).getText();
						
						System.out.println("Total OT Pay is : "+otPay);
						
						test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);
						
						//Get the Total Hours
						String totalHours = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[8]")).getText();
						
						System.out.println("Total Total Hours is : "+totalHours);
						
						test.log(LogStatus.INFO, "Total Total Hours is : "+totalHours);
						
						//Get the Total Pay
						String totalPay = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[9]")).getText();
						
						System.out.println("Total Pay is : "+totalPay);
						
						test.log(LogStatus.INFO, "Total Pay is : "+totalPay);
						
						//Get the % Payroll
						String percentagePayroll = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[10]")).getText();
						
						System.out.println("Total % Payroll is : "+percentagePayroll);
						
						test.log(LogStatus.INFO, "Total % Payroll is : "+percentagePayroll);
						
						List<WebElement> numRows = driver.findElements(By.xpath("//div[@class='col-sm-12 content-block']/div[7]/table/tbody/tr"));
					
						//Get the Total Paid
						String totalPaid = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[7]/table/tbody/tr["+numRows.size()+"]/td[2]")).getText();
						
						System.out.println("Total Paid is : "+totalPaid);
						
						test.log(LogStatus.INFO, "Total Paid is : "+totalPaid);
						
						//Get the % Of Total Payroll
						String percentageOfTotalPayroll = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[7]/table/tbody/tr["+numRows.size()+"]/td[3]")).getText();
						
						System.out.println("Total % Of Total Payroll is : "+percentageOfTotalPayroll);
						
						test.log(LogStatus.INFO, "Total % Of Total Payroll is : "+percentageOfTotalPayroll);
					
					}
					
					else
					{
						test.log(LogStatus.FAIL, "Employee Labour By Job Code Report is not available for Specific Date");
					}  
			  	    	
					
					Thread.sleep(1000);
					//Select the Employee option
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/a")).click();
				    //Enter the required Employee
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys("All");
				    //Press the Enter key
				    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				    
				    Thread.sleep(3000);
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
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
					  
					    //Select the Format option
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/a")).click();
					    //Enter the required Format
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys("In Hours");
					    //Press the Enter key
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
					  
					    //Select the Active/Inactive option
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/a")).click();
					    //Enter the required Active/Inactive
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys("All");
					    //Press the Enter key
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
					    
					    //Select the Role option
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/div/a")).click();
					    //Enter the required Role
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/div/div/div/input")).sendKeys("All");
					    //Press the Enter key
					    driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
					    //Click the Run
					    driver.findElement(By.xpath("//button[@type='submit']")).click();
					    Thread.sleep(1000);
					   
						//Check weather the report is available for the selected time period
						if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
						{
							test.log(LogStatus.FAIL, "Employee Labour By Job Code Report is not available for Specific Date");
						}
						
						else if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[2]/td[2]")).getText() != null)
						{
							
							test.log(LogStatus.PASS, "Employee Labour By Job Code Report(In Hours and Daily) is available for Specific Date");
							
							System.out.println("******* The Below is Employee Labour By Job Code Report for In Hours(Daily) *******");
							
							test.log(LogStatus.INFO, "******* The Below is Employee Labour By Job Code Report for In Hours(Daily) *******");
							
							List<WebElement> rows = driver.findElements(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr"));
							
							//Get the Hours
							String hours = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
							
							System.out.println("Total Hours is : "+hours);
							
							test.log(LogStatus.INFO, "Total Hours is : "+hours);
							
							//Get the Reg Pay
							String regPay = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
							
							System.out.println("Total Reg Pay is : "+regPay);
							
							test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
							
							//Get the OT Hours
							String otHours = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
							
							System.out.println("Total OT Hours is : "+otHours);
							
							test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);
							
							//Get the OT Pay
							String otPay = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[7]")).getText();
							
							System.out.println("Total OT Pay is : "+otPay);
							
							test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);
							
							//Get the Total Hours
							String totalHours = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[8]")).getText();
							
							System.out.println("Total Total Hours is : "+totalHours);
							
							test.log(LogStatus.INFO, "Total Total Hours is : "+totalHours);
							
							//Get the Total Pay
							String totalPay = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[9]")).getText();
							
							System.out.println("Total Pay is : "+totalPay);
							
							test.log(LogStatus.INFO, "Total Pay is : "+totalPay);
							
							//Get the % Payroll
							String percentagePayroll = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[10]")).getText();
							
							System.out.println("Total % Payroll is : "+percentagePayroll);
							
							test.log(LogStatus.INFO, "Total % Payroll is : "+percentagePayroll);
							
							List<WebElement> numRows = driver.findElements(By.xpath("//div[@class='col-sm-12 content-block']/div[7]/table/tbody/tr"));
						
							//Get the Total Paid
							String totalPaid = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[7]/table/tbody/tr["+numRows.size()+"]/td[2]")).getText();
							
							System.out.println("Total Paid is : "+totalPaid);
							
							test.log(LogStatus.INFO, "Total Paid is : "+totalPaid);
							
							//Get the % Of Total Payroll
							String percentageOfTotalPayroll = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[7]/table/tbody/tr["+numRows.size()+"]/td[3]")).getText();
							
							System.out.println("Total % Of Total Payroll is : "+percentageOfTotalPayroll);
							
							test.log(LogStatus.INFO, "Total % Of Total Payroll is : "+percentageOfTotalPayroll);
	
						}
						
						else
						{
							test.log(LogStatus.FAIL, "Employee Labour By Job Code Report is not available for Specific Date");
						}  
			}
	
			@Test(priority=62,enabled=true)
			public void Employee_Labour_By_Job_Code_Report_Method_verifyWeeklyReport(WebDriver driver) throws Exception
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
			    
			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			    
			    //Select the Format option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys("In Hours");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    //Select the Active/Inactive option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/a")).click();
			    //Enter the required Active/Inactive
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
			    //Select the Role option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/div/a")).click();
			    //Enter the required Role
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
			    Thread.sleep(1000);
			     //Click the Run
			    driver.findElement(By.xpath("//button[@type='submit']")).click();
			    Thread.sleep(1000);
	
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Employee Labour By Job Code Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[2]/td[2]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "Employee Labour By Job Code Report(In Hours and Weekly) is available for Specific Date");
					
					System.out.println("******* The Below is Employee Labour By Job Code Report for In Hours(Weekly) *******");
					
					test.log(LogStatus.INFO, "******* The Below is Employee Labour By Job Code Report for In Hours(Weekly) *******");
					
					List<WebElement> rows = driver.findElements(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr"));
					
					//Get the Hours
					String hours = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
					
					System.out.println("Total Hours is : "+hours);
					
					test.log(LogStatus.INFO, "Total Hours is : "+hours);
					
					//Get the Reg Pay
					String regPay = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					System.out.println("Total Reg Pay is : "+regPay);
					
					test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
					
					//Get the OT Hours
					String otHours = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
					
					System.out.println("Total OT Hours is : "+otHours);
					
					test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);
					
					//Get the OT Pay
					String otPay = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[7]")).getText();
					
					System.out.println("Total OT Pay is : "+otPay);
					
					test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);
					
					//Get the Total Hours
					String totalHours = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[8]")).getText();
					
					System.out.println("Total Total Hours is : "+totalHours);
					
					test.log(LogStatus.INFO, "Total Total Hours is : "+totalHours);
					
					//Get the Total Pay
					String totalPay = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[9]")).getText();
					
					System.out.println("Total Pay is : "+totalPay);
					
					test.log(LogStatus.INFO, "Total Pay is : "+totalPay);
					
					//Get the % Payroll
					String percentagePayroll = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[10]")).getText();
					
					System.out.println("Total % Payroll is : "+percentagePayroll);
					
					test.log(LogStatus.INFO, "Total % Payroll is : "+percentagePayroll);
					
					List<WebElement> numRows = driver.findElements(By.xpath("//div[@class='col-sm-12 content-block']/div[7]/table/tbody/tr"));
				
					//Get the Total Paid
					String totalPaid = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[7]/table/tbody/tr["+numRows.size()+"]/td[3]")).getText();
					
					System.out.println("Total Paid is : "+totalPaid);
					
					test.log(LogStatus.INFO, "Total Paid is : "+totalPaid);
					
					//Get the % Of Total Payroll
					String percentageOfTotalPayroll = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[7]/table/tbody/tr["+numRows.size()+"]/td[4]")).getText();
					
					System.out.println("Total % Of Total Payroll is : "+percentageOfTotalPayroll);
					
					test.log(LogStatus.INFO, "Total % Of Total Payroll is : "+percentageOfTotalPayroll);
	
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Employee Labour By Job Code Report is not available for Specific Date");
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
					
			    Thread.sleep(1000);
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
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
			    Thread.sleep(1000);
			    //Clear the Date field
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).clear();
			    //Enter the Date
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			    
			    //Select the Format option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/a")).click();
			    //Enter the required Format
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys("In Time");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
			    //Select the Active/Inactive option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/a")).click();
			    //Enter the required Active/Inactive
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
			    //Select the Role option
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/div/a")).click();
			    //Enter the required Role
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/div/div/div/input")).sendKeys("All");
			    //Press the Enter key
			    driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
			    Thread.sleep(1000);
			     //Click the Run
			    driver.findElement(By.xpath("//button[@type='submit']")).click();
			    Thread.sleep(1000);
			    
			    
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Employee Labour By Job Code Report is not available for Specific Date");
				}
				
				else if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr[2]/td[2]")).getText() != null)
				{
					
					test.log(LogStatus.PASS, "Employee Labour By Job Code Report(In Time and Weekly) is available for Specific Date");
					
					System.out.println("******* The Below is Employee Labour By Job Code Report for In Time(Weekly) *******");
					
					test.log(LogStatus.INFO, "******* The Below is Employee Labour By Job Code Report for In Time(Weekly) *******");
					
					List<WebElement> rows = driver.findElements(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr"));
					
					//Get the Hours
					String hours = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
					
					System.out.println("Total Hours is : "+hours);
					
					test.log(LogStatus.INFO, "Total Hours is : "+hours);
					
					//Get the Reg Pay
					String regPay = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
					
					System.out.println("Total Reg Pay is : "+regPay);
					
					test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
					
					//Get the OT Hours
					String otHours = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
					
					System.out.println("Total OT Hours is : "+otHours);
					
					test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);
					
					//Get the OT Pay
					String otPay = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[7]")).getText();
					
					System.out.println("Total OT Pay is : "+otPay);
					
					test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);
					
					//Get the Total Hours
					String totalHours = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[8]")).getText();
					
					System.out.println("Total Total Hours is : "+totalHours);
					
					test.log(LogStatus.INFO, "Total Total Hours is : "+totalHours);
					
					//Get the Total Pay
					String totalPay = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[9]")).getText();
					
					System.out.println("Total Pay is : "+totalPay);
					
					test.log(LogStatus.INFO, "Total Pay is : "+totalPay);
					
					//Get the % Payroll
					String percentagePayroll = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[5]/table/tbody/tr["+rows.size()+"]/td[10]")).getText();
					
					System.out.println("Total % Payroll is : "+percentagePayroll);
					
					test.log(LogStatus.INFO, "Total % Payroll is : "+percentagePayroll);
					
					List<WebElement> numRows = driver.findElements(By.xpath("//div[@class='col-sm-12 content-block']/div[7]/table/tbody/tr"));
				
					//Get the Total Paid
					String totalPaid = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[7]/table/tbody/tr["+numRows.size()+"]/td[3]")).getText();
					
					System.out.println("Total Paid is : "+totalPaid);
					
					test.log(LogStatus.INFO, "Total Paid is : "+totalPaid);
					
					//Get the % Of Total Payroll
					String percentageOfTotalPayroll = driver.findElement(By.xpath("//div[@class='col-sm-12 content-block']/div[7]/table/tbody/tr["+numRows.size()+"]/td[4]")).getText();
					
					System.out.println("Total % Of Total Payroll is : "+percentageOfTotalPayroll);
					
					test.log(LogStatus.INFO, "Total % Of Total Payroll is : "+percentageOfTotalPayroll);
				}
				
				else
				{
					test.log(LogStatus.FAIL, "Employee Labour By Job Code Report is not available for Specific Date");
				}
			}
			
}