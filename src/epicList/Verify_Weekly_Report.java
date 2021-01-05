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
	
			@Test(priority=180,enabled = true)
			public void Weekly_SaleSummary_method_Report_Openpage() throws Exception
			{
				/*WebElement html = driver.findElement(By.tagName("html"));
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
				driver.findElement(By.xpath("//span[.='Sale']")).click();*/
				
				Thread.sleep(3000);
				//Enter the Categories Url
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/weeklySale");
				
				// Create instance of Java script executor
				JavascriptExecutor je1 = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element1 = driver.findElement(By.xpath("//span[.=' Weekly Summary ']"));
				//Scroll the page till the Weekly Summary option present
				je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
				
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				
				//Check weather the Weekly Summary Report page is loaded or not
				if(driver.findElement(By.xpath("//li[@class='uib-tab nav-item ng-isolate-scope active']/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Weekly Summary"))
				{
					test.log(LogStatus.PASS, "Weekly Summary Report page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Weekly Summary Report page loaded fail");
				}

				Thread.sleep(3000);
				
			}
			
			@Test(priority=181,enabled = true)
			public void Weekly_Summary_Sale_method_Report_This_Week() throws Exception
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
				
				Thread.sleep(10000);
				//Check weather the Table Type report available or not for This Week
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Table format reprot is available for This Week");
								
					
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr/td[1]"));
					for(int i = 2; i <= rows.size(); i++)
					{
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Gross Sales"))
						{
							
							List<WebElement> Column = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
							
				        	//Replace all commo's with empty space
				        	String expected1 = Utility.getReportProperty("This_Weekly_Gross_Sale").replace("/[^A-Za-z ,₹$]/", "");
				        	
				        	//Convert the String value of the This_Weekly_Gross_Sale element into float value
				        	float expect1 = Float.parseFloat(expected1);  
				        	
				        	//Get the Total value of Check Count
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replaceAll("/[^A-Za-z ,₹$]/", "");
				        	
							Thread.sleep(2000);
							//Check the Gross Sale
							if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Gross_Sale")))
							{
								test.log(LogStatus.PASS, "Actual and Expected Gross Sale is same");
									        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText);
					        	
					        	//Print the actual value
					        	System.out.println("The Actual Gross Sale(This Week) Value is : "+actual);
					        	
					        	test.log(LogStatus.PASS, "The Actual Gross Sale(This Week) Value is : "+ actual);

							}
							
							else if(expect1 == unknownValue)
							{
								test.log(LogStatus.PASS, "Here we don't have the exact expected value");
								
					        	System.out.println("The Actual Gross Sale(This Week) value is : "+actualText);
					        	
					        	test.log(LogStatus.INFO, "The Actual Gross Sale(This Week) value is : "+actualText);
							}
							
							else
							{
								test.log(LogStatus.FAIL, "Actual and Expected Gross Sale is different");
					        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText);
					        			        	
					        	//Get the different
					        	float different = actual - expect1;
					        	
					        	//Print the different value
					        	System.out.println("Gross Sale(This Week) Actual value is : "+actualText1);
					        	
					        	test.log(LogStatus.FAIL, "Gross Sale(This Week) Actual value is : "+actualText1);	
					        	
					        	//Print the different value
					        	System.out.println("Gross Sale(This Week) different is : "+different);
					        	
					        	test.log(LogStatus.FAIL, "Gross Sale(This Week) different is : "+different);	

							}
							
						}
					}
					
					for(int i = 2; i <= rows.size(); i++)
					{
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Net Sales"))
						{
							
							List<WebElement> Column1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
							
				        	//Replace all commo's with empty space
				        	String expected2 = Utility.getReportProperty("This_Weekly_Net_Sale").replace("/[^A-Za-z ,₹$]/", "");
				        	
				        	//Convert the String value of the This_Weekly_Net_Sale element into float value
				        	float expect2 = Float.parseFloat(expected2);  
				        	
				        	//Get the Total value of Net Sale
				        	String actualText3 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText2 = actualText3.replaceAll("/[^A-Za-z ,₹$]/", "");
								
							Thread.sleep(2000);
							//Check the Net Sale
							if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Net_Sale")))
							{
								test.log(LogStatus.PASS, "Actual and Expected Net Sale is same");
									        	
					        	//Convert the String value of the Net Sale Total element into float value
					        	float actual = Float.parseFloat(actualText2);
					        	
					        	//Print the actual value
					        	System.out.println("The Actual Net Sale(This Week) Value is : "+actual);
					        	
					        	test.log(LogStatus.PASS, "The Actual Net Sale(This Week) Value is : "+ actual);

							}
							
							else if(expect2 == unknownValue)
							{
								test.log(LogStatus.PASS, "Here we don't have the exact expected value");
								
					        	System.out.println("The Actual Net Sale(This Week) value is : "+actualText2);
					        	
					        	test.log(LogStatus.INFO, "The Actual Net Sale(This Week) value is : "+actualText2);
							}
							
							else
							{
								test.log(LogStatus.FAIL, "Actual and Expected Net Sale is different");
					        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText2);
					        			        	
					        	//Get the different
					        	float different = actual - expect2;
					        	
					        	//Print the different value
					        	System.out.println("Net Sale(This Week) Actual value is : "+actualText3);
					        	
					        	test.log(LogStatus.FAIL, "Net Sale(This Week) Actual value is : "+actualText3);
					        	
					        	//Print the different value
					        	System.out.println("Net Sale(This Week) different is : "+different);
					        	
					        	test.log(LogStatus.FAIL, "Net Sale(This Week) different is : "+different);	

							}

							}

					}

				}
				else
				{
					test.log(LogStatus.FAIL, "Table format report is not available for This Week");
				}
			}
			
			@Test(priority=182,enabled = true)
			public void Weekly_Summary_Sale_method_Report_Last_Week() throws Exception
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
				
				Thread.sleep(10000);
				//Check weather the Table Type report available or not for Last Week
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Table format reprot is available for Last Week");
								
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr/td[1]"));
					for(int i = 2; i <= rows.size(); i++)
					{
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Gross Sales"))
						{
							
							List<WebElement> Column = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
							
				        	//Replace all commo's with empty space
				        	String expected1 = Utility.getReportProperty("This_Weekly_Gross_Sale").replace("/[^A-Za-z ,₹$]/", "");
				        	
				        	//Convert the String value of the This_Weekly_Gross_Sale element into float value
				        	float expect1 = Float.parseFloat(expected1);  
				        	
				        	//Get the Total value of Check Count
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replaceAll("/[^A-Za-z ,₹$]/", "");
				        	
							Thread.sleep(2000);
							//Check the Gross Sale
							if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Gross_Sale")))
							{
								test.log(LogStatus.PASS, "Actual and Expected Gross Sale is same");
									        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText);
					        	
					        	//Print the actual value
					        	System.out.println("The Actual Gross Sale(Last Week) Value is : "+actual);
					        	
					        	test.log(LogStatus.PASS, "The Actual Gross Sale(Last Week) Value is : "+ actual);

							}
							
							else if(expect1 == unknownValue)
							{
								test.log(LogStatus.PASS, "Here we don't have the exact expected value");
								
					        	System.out.println("The Actual Gross Sale(Last Week) value is : "+actualText);
					        	
					        	test.log(LogStatus.INFO, "The Actual Gross Sale(Last Week) value is : "+actualText);
							}
							
							else
							{
								test.log(LogStatus.FAIL, "Actual and Expected Gross Sale is different");
					        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText);
					        			        	
					        	//Get the different
					        	float different = actual - expect1;
					        	
					        	//Print the different value
					        	System.out.println("Gross Sale(Last Week) Actual value is : "+actualText1);
					        	
					        	test.log(LogStatus.FAIL, "Gross Sale(Last Week) Actual value is : "+actualText1);
					        	
					        	//Print the different value
					        	System.out.println("Gross Sale(Last Week) different is : "+different);
					        	
					        	test.log(LogStatus.FAIL, "Gross Sale(Last Week) different is : "+different);	

							}
							
						}
					}
					
					for(int i = 2; i <= rows.size(); i++)
					{
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Net Sales"))
						{
							
							List<WebElement> Column1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
							
				        	//Replace all commo's with empty space
				        	String expected2 = Utility.getReportProperty("This_Weekly_Net_Sale").replace("/[^A-Za-z ,₹$]/", "");
				        	
				        	//Convert the String value of the This_Weekly_Net_Sale element into float value
				        	float expect2 = Float.parseFloat(expected2);  
				        	
				        	//Get the Total value of Check Count
				        	String actualText3 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText2 = actualText3.replaceAll("/[^A-Za-z ,₹$]/", "");
								
							Thread.sleep(2000);
							//Check the Net Sale
							if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Net_Sale")))
							{
								test.log(LogStatus.PASS, "Actual and Expected Net Sale is same");
									        	
					        	//Convert the String value of the Net Sale Total element into float value
					        	float actual = Float.parseFloat(actualText2);
					        	
					        	//Print the actual value
					        	System.out.println("The Actual Net Sale(Last Week) Value is : "+actual);
					        	
					        	test.log(LogStatus.PASS, "The Actual Net Sale(Last Week) Value is : "+ actual);

							}
							
							else if(expect2 == unknownValue)
							{
								test.log(LogStatus.PASS, "Here we don't have the exact expected value");
								
					        	System.out.println("The Actual Net Sale(Last Week) value is : "+actualText2);
					        	
					        	test.log(LogStatus.INFO, "The Actual Net Sale(Last Week) value is : "+actualText2);
							}
							
							else
							{
								test.log(LogStatus.FAIL, "Actual and Expected Net Sale is different");
					        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText2);
					        			        	
					        	//Get the different
					        	float different = actual - expect2;
					        	
					        	//Print the different value
					        	System.out.println("Net Sale(Last Week) Actual value is : "+actualText3);
					        	
					        	test.log(LogStatus.FAIL, "Net Sale(Last Week) Actual value is : "+actualText3);
					        	
					        	//Print the different value
					        	System.out.println("Net Sale(Last Week) different is : "+different);
					        	
					        	test.log(LogStatus.FAIL, "Net Sale(Last Week) different is : "+different);	

							}

							}

					}
				}
				else
				{
					test.log(LogStatus.FAIL, "Table format report is not available for Last Week");
				}
			}
			
			@Test(priority=183,enabled = true)
			public void Weekly_Summary_Sale_method_Report_Last7days() throws Exception
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
				
				Thread.sleep(10000);
				//Check weather the Table Type report available or not for Last 7 days
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Table format reprot is available for Last 7 Days");
								
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr/td[1]"));
					for(int i = 2; i <= rows.size(); i++)
					{
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Gross Sales"))
						{
							
							List<WebElement> Column = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
							
				        	//Replace all commo's with empty space
				        	String expected1 = Utility.getReportProperty("This_Weekly_Gross_Sale").replace("/[^A-Za-z ,₹$]/", "");
				        	
				        	//Convert the String value of the This_Weekly_Gross_Sale element into float value
				        	float expect1 = Float.parseFloat(expected1);  
				        	
				        	//Get the Total value of Check Count
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replaceAll("/[^A-Za-z ,₹$]/", "");
				        	
							Thread.sleep(2000);
							//Check the Gross Sale
							if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Gross_Sale")))
							{
								test.log(LogStatus.PASS, "Actual and Expected Gross Sale is same");
									        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText);
					        	
					        	//Print the actual value
					        	System.out.println("The Actual Gross Sale(Last 7 Days) Value is : "+actual);
					        	
					        	test.log(LogStatus.PASS, "The Actual Gross Sale(Last 7 Days) Value is : "+ actual);

							}
							
							else if(expect1 == unknownValue)
							{
								test.log(LogStatus.PASS, "Here we don't have the exact expected value");
								
					        	System.out.println("The Actual Gross Sale(Last 7 Days) value is : "+actualText);
					        	
					        	test.log(LogStatus.INFO, "The Actual Gross Sale(Last 7 Days) value is : "+actualText);
							}
							
							else
							{
								test.log(LogStatus.FAIL, "Actual and Expected Gross Sale is different");
					        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText);
					        			        	
					        	//Get the different
					        	float different = actual - expect1;
					        	
					        	//Print the different value
					        	System.out.println("Gross Sale(Last 7 Days) Actual value is : "+actualText1);
					        	
					        	test.log(LogStatus.FAIL, "Gross Sale(Last 7 Days) Actual value is : "+actualText1);
					        	
					        	//Print the different value
					        	System.out.println("Gross Sale(Last 7 Days) different is : "+different);
					        	
					        	test.log(LogStatus.FAIL, "Gross Sale(Last 7 Days) different is : "+different);	

							}
							
						}
					}
					
					for(int i = 2; i <= rows.size(); i++)
					{
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Net Sales"))
						{
							
							List<WebElement> Column1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
							
				        	//Replace all commo's with empty space
				        	String expected2 = Utility.getReportProperty("This_Weekly_Net_Sale").replace("/[^A-Za-z ,₹$]/", "");
				        	
				        	//Convert the String value of the This_Weekly_Net_Sale element into float value
				        	float expect2 = Float.parseFloat(expected2);  
				        	
				        	//Get the Total value of Check Count
				        	String actualText3 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText2 = actualText3.replaceAll("/[^A-Za-z ,₹$]/", "");
								
							Thread.sleep(2000);
							//Check the Net Sale
							if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Net_Sale")))
							{
								test.log(LogStatus.PASS, "Actual and Expected Net Sale is same");
									        	
					        	//Convert the String value of the Net Sale Total element into float value
					        	float actual = Float.parseFloat(actualText2);
					        	
					        	//Print the actual value
					        	System.out.println("The Actual Net Sale(Last 7 Days) Value is : "+actual);
					        	
					        	test.log(LogStatus.PASS, "The Actual Net Sale(Last 7 Days) Value is : "+ actual);

							}
							
							else if(expect2 == unknownValue)
							{
								test.log(LogStatus.PASS, "Here we don't have the exact expected value");
								
					        	System.out.println("The Actual Net Sale(Last 7 Days) value is : "+actualText2);
					        	
					        	test.log(LogStatus.INFO, "The Actual Net(Last 7 Days) Sale value is : "+actualText2);
							}
							
							else
							{
								test.log(LogStatus.FAIL, "Actual and Expected Net Sale is different");
					        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText2);
					        			        	
					        	//Get the different
					        	float different = actual - expect2;
					        	
					        	//Print the different value
					        	System.out.println("Net Sale(Last 7 Days) Actual value is : "+actualText3);
					        	
					        	test.log(LogStatus.FAIL, "Net Sale(Last 7 Days) Actual value is : "+actualText3);
					        	
					        	//Print the different value
					        	System.out.println("Net Sale(Last 7 Days) different is : "+different);
					        	
					        	test.log(LogStatus.FAIL, "Net Sale(Last 7 Days) different is : "+different);	

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
