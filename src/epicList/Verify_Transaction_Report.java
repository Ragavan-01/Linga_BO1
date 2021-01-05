package epicList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import epicList_Chrome.Utility;

public class Verify_Transaction_Report {

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Verify_Transaction_Report");

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
	
			@Test(priority=2,enabled = true)
			public void Transaction_Report_Method_openpage() throws Exception
			{
			
				Thread.sleep(12000);
/*				WebElement html = driver.findElement(By.tagName("html"));
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
				driver.findElement(By.xpath("//span[.='Transactions']")).click();*/
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/transactionSale");
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
			public void Transaction_Report_Method_For_Tender_Type() throws Exception
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
			public void Transaction_Report_Method_For_Tender_Name() throws Exception
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
}
