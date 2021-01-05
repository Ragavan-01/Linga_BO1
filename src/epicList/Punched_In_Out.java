package epicList;

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

import epicList_Integrated.Utility;


public class Punched_In_Out {
public WebDriver driver;
	
ExtentReports rep = ExtentManager.getInstance();
ExtentTest test = rep.startTest("Punched_In_Out");

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
	}}

	@Test(priority=24)
	public void Usermanagement_ForcedPunchInOut_OpenPage() throws Exception
				{
					
					//Click the User Management option
					//driver.findElement(By.xpath("//span[.='User Management']")).click();
					
					Thread.sleep(4000);
					//Enter the Punchin-out URL
					driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"employeeList");
					
					Thread.sleep(3000);
					//Check  Forced Punch-In/Out page opened or not
					if(driver.findElement(By.xpath("//a[.='Forced Punch-In/Out(s)']")).getText().equalsIgnoreCase("Forced Punch-In/Out(s)"))
					{
						test.log(LogStatus.PASS,"Forced Punch-In/Out page loaded Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL,"Forced Punch-In/Out page loaded Failed");
					}
					
				
					
					Thread.sleep(3000);
					//Click the Employee option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/form/div[1]/div/div/a")).click();
					//Enter the required Employee     
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/form/div[1]/div/div/div/div/input")).sendKeys(Utility.getProperty("Punchin/out_name"));
					//Press the Enter Key              
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
					//Clear the Date field
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/form/div[2]/div/div/input")).clear();
					Thread.sleep(3000);
					//Enter the required date to view the clock In/Out
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/form/div[2]/div/div/input")).sendKeys(Utility.getProperty("Punchin/out_Date"));
				
				    //Click the Run
				    driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
				    Thread.sleep(3000);

				    //Check whether the Forced Punch-In report is available or not		    
				    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[1]/div/div[2]/div/table/tbody/tr[1]/td[2]")).getText().equalsIgnoreCase("IN"))
				    {
				    	test.log(LogStatus.PASS,"Forced Punch-In report is available for the selected date");
				    	
				    }
				    else
				    {
				    	test.log(LogStatus.FAIL,"Forced Punch-In report is not available for the selected date");
				    }
		
				}
				
	@Test(priority=25)
	public void Usermanagement_ForcedPunchInOut_addTimeEvent() throws Exception
				{      
					Thread.sleep(3000);
					//click the time event or create the time event
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/form/div[4]/div/span/a")).click();
					Thread.sleep(3000); 	
					//check new time event can able to create or not
					if (driver.findElement(By.xpath("//span[.='New Clock-In Event']")).getText().equalsIgnoreCase("New Clock-In Event"))
					
						{
							test.log(LogStatus.PASS,"Time event loaded Successfully");
						}
						else
						{
							test.log(LogStatus.FAIL,"Time event loading Failed");
						}
					Thread.sleep(3000);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					//click on roles option  	 
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/form/div[1]/div[1]/div/div/a/span")).click();
					
					Thread.sleep(3000);
					//Clear the Search field		
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/form/div[1]/div[1]/div/div/div/div/input")).clear();
					
					
					//Search the required roles from the below list
					//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/form/div[1]/div[1]/div/div/div/div/input")).sendKeys();
								
					//PRESS THE ENTER KEY
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/form/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
					//Clear the check in date field 
					driver.findElement(By.name("checkIn")).clear();		
					//Enter the check in date field
					driver.findElement(By.name("checkIn")).sendKeys(Utility.getProperty("Check_In"));

					Thread.sleep(3000);
					//Click the up arrow(minute) of Check in Time
					Thread.sleep(3000);
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/form/div[1]/div[3]/div/div/div/table/tbody/tr[1]/td[3]/a/span")).click();

					
					//Clear the check out date field 
					driver.findElement(By.name("checkOut")).clear();		
					//Enter the check out date field
					driver.findElement(By.name("checkOut")).sendKeys(Utility.getProperty("Check_Out"));
									
					Thread.sleep(3000);
					//Click the up arrow(minute) of Check Out Time
					Thread.sleep(3000);
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/form/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[3]/a/span")).click();
						Thread.sleep(3000);

						//Check it is AM or PM in the Start Time Option
			          	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/form/div[1]/div[3]/div/div/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			          {
			          Thread.sleep(3000);  
			          //Click the AM or PM option in the End Time
			          	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/form/div[2]/div[2]/div/div/div/table/tbody/tr[2]/td[6]/button")).click();
			          }
			          else
			          {
			          Thread.sleep(3000);
			          //Click the AM or PM option in the Start Time
			          	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/form/div[1]/div[3]/div/div/div/table/tbody/tr[2]/td[6]/button")).click();
			         }
			          
			         Thread.sleep(2000);
			         
					//Click the save button
						driver.findElement(By.xpath("//button[@type='submit']")).click();
					
						Thread.sleep(2000);
					
					//Check whether time event saved successfully or not
					if(driver.findElement(By.xpath("//a[.='Forced Punch-In/Out(s)']")).getText().equalsIgnoreCase("Forced Punch-In/Out(s)"))
					{
						test.log(LogStatus.PASS,"Time Event Saved Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL,"Time Event failed to save");
					}
					Thread.sleep(5000);
				}
				
	@Test(priority=26)
	public void Usermanagement_ForcedPunchInOut_cancelButton_punchin_out() throws Exception
				{
					Thread.sleep(5000);
					//click the time event or create the time event
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/form/div[4]/div/span/a")).click();
					Thread.sleep(3000);
					//check new time event page is loaded or not
					if (driver.findElement(By.xpath("//span[.='New Clock-In Event']")).getText().equalsIgnoreCase("New Clock-In Event"))
					
					{
				    	test.log(LogStatus.PASS,"New Clock-In Event page loaded succesfully");
				    	
				    }
				    else
				    {
				    	test.log(LogStatus.FAIL,"New Clock-In Event page loaded failed");
				    }
					Thread.sleep(3000);
						//Click the cancel button
						driver.findElement(By.xpath("//a[.='Cancel']")).click();
						Thread.sleep(3000);
						//Check Whether time event table cancelled successfully or not
						if(driver.findElement(By.xpath("//a[.='Forced Punch-In/Out(s)']")).getText().equalsIgnoreCase("Forced Punch-In/Out(s)"))
						{
							test.log(LogStatus.PASS,"Time Event cancelled successfully");
					    	
					    }
					    else
					    {
					    	test.log(LogStatus.FAIL,"Time Event cancellation failed");
						}
						Thread.sleep(3000);
					}
				
	@Test(priority=27)
	public void Usermanagement_ForcedPunchInOut_edit_Employee_clock_in () throws Exception
				{
						Thread.sleep(3000);
						//Click the edit icon
						Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();Thread.sleep(2000);
						Thread.sleep(3000);
						
						//Clear the check in date field 
						driver.findElement(By.name("checkIn")).clear();		
						//Enter the check in date field
						driver.findElement(By.name("checkIn")).sendKeys("18-May-2018");
						
						Thread.sleep(3000);
						//Click the up arrow(minute) of Check in Time
						Thread.sleep(3000);
							driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/form/div[1]/div[3]/div/div/div/table/tbody/tr[1]/td[3]/a/span")).click();
						
						//Clear the check out date field 
						driver.findElement(By.name("checkOut")).clear();		
						//Enter the check out date field
						driver.findElement(By.name("checkOut")).sendKeys("18-May-2018");
						
						Thread.sleep(3000);
						//Click the up arrow(minute) of Check Out Time
						Thread.sleep(3000);
							driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/form/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[3]/a/span")).click();

				    		//Check it is AM or PM in the Start Time Option
				          	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/form/div[1]/div[3]/div/div/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("PM") && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/form/div[2]/div[2]/div/div/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
				          {
				          Thread.sleep(3000);
				          //Click the AM or PM option in the End Time
				        	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/form/div[2]/div[2]/div/div/div/table/tbody/tr[2]/td[6]/button")).click();

				          
				          Thread.sleep(3000);
				          //Click the AM or PM option in the Start Time
				          	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/form/div[1]/div[3]/div/div/div/table/tbody/tr[2]/td[6]/button")).click();

				          }
						
						//Click the update button
						driver.findElement(By.xpath("//button[@type='submit']")).click();
						Thread.sleep(3000);

						//Check whether the time-event was updated successfully or not
						if(driver.findElement(By.xpath("//a[.='Forced Punch-In/Out(s)']")).getText().equalsIgnoreCase("Forced Punch-In/Out(s)"))
						{
							test.log(LogStatus.PASS,"details updated successfully");
						}
						else
						{
							test.log(LogStatus.FAIL,"details updated successfully is failed");
						}
				}
						
	@Test(priority=28)
	public void Usermanagement_ForcedPunchInOut_DeleteEmplyoee_Clock_In() throws Exception

						{
							Thread.sleep(3000);
							//Click the Delete button
							driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
							Thread.sleep(3000);
							//Check the ServingSizeLevel deleted or not
							if(driver.findElement(By.xpath("//a[.='Forced Punch-In/Out(s)']")).getText().equalsIgnoreCase("Forced Punch-In/Out(s)"))
							{
								test.log(LogStatus.PASS,"ClockIn-Out record removed sucessfully");
							}
							else
							{
								test.log(LogStatus.FAIL,"ClockIn-Out record removed sucessfully is Failed");
							}
							Thread.sleep(3000);
				}


}
