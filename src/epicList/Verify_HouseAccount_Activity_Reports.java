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


public class Verify_HouseAccount_Activity_Reports {
	
	
	public WebDriver driver;
	

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Verify_HouseAccount_Activity_Reports");
	
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

			@Test(priority=38,enabled=true)
			public void Employee_HAActivity_Repor_Method_Openpage() throws Exception
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
			public void Employee_HAActivity_Repor_Method_verify() throws Exception
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
			public void Employee_HAActivity_Repor_Method_verify_Card_Number() throws Exception
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

}
