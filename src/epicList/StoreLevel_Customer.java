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

public class StoreLevel_Customer {
	
	public WebDriver driver;
		ExtentReports rep = ExtentManager.getInstance();
		ExtentTest test = rep.startTest("StoreLevel_Customer");

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
			Thread.sleep(3000);

			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
			//Click the login button
			driver.findElement(By.name("submitlogin")).click();
			//Check if we logged in or not
			if(driver.findElement(By.xpath("//span[.='Live Updates']")).getText().equalsIgnoreCase("Live Updates"))
			{
				test.log(LogStatus.PASS, "User Logged in Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "User Logged in Failed");
			}
			Thread.sleep(5000);
		}
			
		@Test(priority=28)
		public void logout() throws InterruptedException
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
			Thread.sleep(5000);
		   //Check whether user get logged out or not
			if(driver.findElement(By.xpath("//div[@id='x-content-band-1']/div/div[2]/h2")).getText().equalsIgnoreCase("Account Login"))
			{
		    	test.log(LogStatus.PASS,"User Logged out Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"User Logged out Failed");
			}
			Thread.sleep(5000);
			//Close the Browser
			driver.close();
		}
		
		@Test(priority=2)
		public void Customer_Info_Method_open_Page() throws Exception
		{
			//Click the Customers option
			driver.findElement(By.xpath("//span[.='Customers']")).click();
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Customers Info']"));
			//Scroll the page till the Customers Info option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
	        //Click the Customers Info Option		
			driver.findElement(By.xpath("//span[.='Customers Info']")).click();
			
			//Check Customers Info page opened or not
			if(driver.findElement(By.xpath("//a[.='Customers']")).getText().equalsIgnoreCase("Customers"))
			{
				test.log(LogStatus.PASS,"Customers Info page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Customers Info page loaded Failed");
			}
			Thread.sleep(2000);
		}
		
		@Test(priority=2)
		public void Customer_Info_Method_viewpage() throws Exception
		{
			Thread.sleep(2000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//Enter the key word
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Linga bo");
			//Click the search button
			driver.findElement(By.xpath("//a[@ class='btn customer-search-icon']")).click();
			
			Thread.sleep(2000);
			//Click the View button
			driver.findElement(By.xpath("//a[.='View']")).click();
			
			Thread.sleep(5000);
			//Refresh button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/a[1]/i")).click();
			
			/*WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			 html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			*/
			 Thread.sleep(3000);
			   //Scroll the web page
			    for(int i=1; i <= 15; i++)
			    {
			    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			    	Thread.sleep(1000);
			    }
			    
			    Thread.sleep(3000);
				//Check whether the Total Spent report is available or not
				if(driver.findElement(By.xpath("//label[.='Total Spent']")).getText().equalsIgnoreCase("Total Spent"))
				{
					test.log(LogStatus.PASS, "There is Total Spent Report is available");
				}
				else
				{
					test.log(LogStatus.FAIL, "Total Spent report is not available");
				}
				
				Thread.sleep(3000);
				//Check whether the Weekly Spent report is available or not
				if(driver.findElement(By.xpath("//label[.='Weekly Spent']")).getText().equalsIgnoreCase("Weekly Spent"))
				{
					test.log(LogStatus.PASS, "There is Weekly Spent Report is available");
				}
				else
				{
					test.log(LogStatus.FAIL, "Weekly Spent report is not available");
				}
				
				Thread.sleep(3000);
			    //Check Whether the NO. OF VISIT and Sale amount Available or not
			    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[1]/span[1]")).getText().equalsIgnoreCase("NO. OF VISIT") && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[2]/span[1]")).getText().equalsIgnoreCase("SALE AMOUNT"))
			    {

			    	test.log(LogStatus.PASS, "Number of visit count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[1]/span[2]")).getText());
			    	
			    	test.log(LogStatus.PASS, "Total Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[2]/span[2]")).getText());
			    }
			    
			    else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[1]/span[1]")).getText().equalsIgnoreCase("NO. OF VISIT") || driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[2]/span[1]")).getText().equalsIgnoreCase("SALE AMOUNT"))
			    {
			    	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[1]/span[1]")).getText().equalsIgnoreCase("NO. OF VISIT"))
			    	{
			    		test.log(LogStatus.PASS, "Number of visit count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[1]/span[2]")).getText());
			    		
			    		test.log(LogStatus.FAIL, "Sale amount field is not available");
			    	}
			    	
			    	else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[2]/span[1]")).getText().equalsIgnoreCase("SALE AMOUNT"))
			    	{
			    		test.log(LogStatus.FAIL, "Number of visit field is not available");
			    		
			    		test.log(LogStatus.PASS, "Total Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[2]/span[2]")).getText());
			
			    	}
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "Number of visit field is not available");
			    	
			    	test.log(LogStatus.FAIL, "Sale amount field is not available");
			    }
			    
				Thread.sleep(3000);
			    //Check Whether the LOYALTY REWARD and LOYALTY VALUE Available or not
			    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[1]/span[1]")).getText().equalsIgnoreCase("LOYALTY REWARD") && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[2]/span[1]")).getText().equalsIgnoreCase("LOYALTY VALUE"))
			    {

			    	test.log(LogStatus.PASS, "LOYALTY REWARD is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[1]/span[2]")).getText());
			    	
			    	test.log(LogStatus.PASS, "LOYALTY VALUE is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[2]/span[2]")).getText());
			    }
			    
			    else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[1]/span[1]")).getText().equalsIgnoreCase("LOYALTY REWARD") || driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[2]/span[1]")).getText().equalsIgnoreCase("LOYALTY VALUE"))
			    {
			    	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[1]/span[1]")).getText().equalsIgnoreCase("LOYALTY REWARD"))
			    	{
			    		test.log(LogStatus.PASS, "LOYALTY REWARD is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[1]/span[2]")).getText());
			    		
			    		test.log(LogStatus.FAIL, "LOYALTY VALUE field is not available");
			    	}
			    	
			    	else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[2]/span[1]")).getText().equalsIgnoreCase("LOYALTY VALUE"))
			    	{
			    		test.log(LogStatus.FAIL, "LOYALTY REWARD field is not available");
			    		
			    		test.log(LogStatus.PASS, "LOYALTY VALUE is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[2]/span[2]")).getText());
			
			    	}
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "LOYALTY REWARD field is not available");
			    	
			    	test.log(LogStatus.FAIL, "LOYALTY VALUE field is not available");
			    }
			    
				Thread.sleep(3000);
			    //Check Whether the FEEDBACKS Available or not
			    if(driver.findElement(By.xpath("//div[.='FEEDBACKS']")).getText().equalsIgnoreCase("FEEDBACKS"))
			    {
			    	test.log(LogStatus.PASS, "FEEDBACKS field is available");
			    	
			    	test.log(LogStatus.INFO, "Positive Feedback Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[3]/div/div[2]/div[1]/span[2]")).getText());
			    	
			    	test.log(LogStatus.INFO, "Negative Feedback Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[3]/div/div[2]/div[2]/span[2]")).getText());
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "FEEDBACKS field is not available");
			    }
			    Thread.sleep(3000);
			    //view the Sales
			  	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[1]/span/button")).click();
			  	Thread.sleep(2000);
			  	//Click the check
			  	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/table/tbody/tr/td[1]/a")).click();
			  	Thread.sleep(5000);
			    //Click the mail id Enter box
			  	Thread.sleep(2000);           //
			  	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[1]/div/div[1]/input")).click();
			   	//clear the mail id
			  	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[1]/div/div[1]/input")).clear();
			  	//Enter the mail id
			  	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[1]/div/div[1]/input")).sendKeys("Kirubas@benseron.com");
			  	Thread.sleep(5000);
			  	//click the sendEmailReceipt button
			  	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[1]/div/div[2]/button")).click();
			  	Thread.sleep(5000);
			    	
			    //Scroll the web page
			    for(int i=1; i <= 60; i++)
			    {
			    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			    	Thread.sleep(1000);
			    }
			    
			    	test.log(LogStatus.INFO, "The Check number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "Date is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[3]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "Table is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[4]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "Seat Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[5]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "Server Name is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[6]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[7]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[8]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "CC Service Charge is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[9]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[10]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "Total Tip is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[11]/td")).getText());
			   
			    	//Get the row size of tax table
			    	List<WebElement> taxRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[3]/div/div[1]/table/tbody/tr"));
			    	
			    		Thread.sleep(1000);
			    		test.log(LogStatus.PASS, "Total Tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[3]/div/div[1]/table/tbody/tr["+taxRow.size()+"]/td[2]")).getText());
			    		{
			    	//Check whether the Payment summary is available or not
			    	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[3]/td[5]")) != null)
			    	{
			    		test.log(LogStatus.PASS, "Payment Summary report is available");
			    	}
			    	
			    	else
			    	{
			    		test.log(LogStatus.FAIL, "Payment Summary report is not available");
			    	}
			      //Get the row size of order summary table
			    	List<WebElement> orderSummaryRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr"));
			    	
			    		Thread.sleep(1000);
			    		test.log(LogStatus.PASS, "Order Summary subtotal is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr["+orderSummaryRow.size()+"]/td[2]")).getText());
		
			    		Thread.sleep(5000);
			    		
			    		//click the sendEmailReceipt button
					  	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[3]/td[9]/button")).click();
					  	Thread.sleep(5000);
					  	
			    		 for(int i=0; i<=10; i++)
				   	  	 {
				   	  		 Thread.sleep(1000);
				   	  		 driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				   	  	 }
			    		 Thread.sleep(5000);
				   	        //view the Sales
						  	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[1]/span/button")).click();
						  	Thread.sleep(2000);
						  	
						  	 for(int i=0; i<=10; i++)
					   	  	 {
					   	  		 Thread.sleep(1000);
					   	  		 driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
					   	  	 }
			   		         Thread.sleep(3000);
			                //click the back button
			   	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[1]/div/div[2]/a")).click();
			   	    Thread.sleep(5000);
			   		
			   	 //view the Sales
				  	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[1]/span/button")).click();
				  	Thread.sleep(2000);
				  	
				  	 for(int i=0; i<=15; i++)
			   	  	 {
			   	  		 Thread.sleep(3000);
			   	  		 driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
			   	  	 }
			   	  	
			       	//clcik the back button
			       	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/a[2]")).click();
			       	 Thread.sleep(5000);
			   	}
			    		Thread.sleep(5000);
			    		//Clear the search field
			    		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			    		//Click the search button
			    		driver.findElement(By.xpath("//a[@ class='btn customer-search-icon']")).click();
			    		
		}
@Test(priority=3)
public void HouseAccount_Method_OpenPage() throws Exception
{
	/*//Click the Customers option
	driver.findElement(By.xpath("//span[.='Customers']")).click();
	// Create instance of Java script executor
	JavascriptExecutor je = (JavascriptExecutor) driver;
	//Identify the WebElement which will appear after scrolling down
	WebElement element = driver.findElement(By.xpath("//span[.='House Account']"));
	//Scroll the page till the House Account option present
	je.executeScript("arguments[0].scrollIntoView(true);",element); 
    //Click the House Account Option		
	driver.findElement(By.xpath("//span[.='House Account']")).click();  */
	
	//Enter the URL 
	driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"houseAccount");
	
	//Check House Account page opened or not
	if(driver.findElement(By.xpath("//a[.='HouseAccount']")).getText().equalsIgnoreCase("HouseAccount"))
	{
		test.log(LogStatus.PASS,"House Account page loaded Successfully");
	}
	else
	{
		test.log(LogStatus.FAIL,"House Account page loaded Failed");
	}
	
}

@Test(priority=4)
public void HouseAccount_Method_refresh() throws InterruptedException
{
	Thread.sleep(2000);
	//Click the refresh button
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a/i")).click();
	Thread.sleep(2000);
	//Check House Account page opened or not
	if(driver.findElement(By.xpath("//a[.='HouseAccount']")).getText().equalsIgnoreCase("HouseAccount"))
	{
		test.log(LogStatus.PASS,"House Account page refresh  Successfully");
	}
	else
	{
		test.log(LogStatus.FAIL,"House Account page refresh  Successfully is Failed");
	}
	
}

@Test(priority=5)
public void HouseAccount_Method_CreateNewHouseAccounts() throws Exception
{
	Thread.sleep(2000);
	//Click the Add House Account or Create new House Account button
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/button")).click();
	Thread.sleep(2000);
	//Check  New House Account form page loaded or not
	if(driver.findElement(By.xpath("//span[.='New House Account']")).getText().equalsIgnoreCase("New House Account"))
	{
		test.log(LogStatus.PASS,"New House Account form loaded Successfully");
	}
	else
	{
		test.log(LogStatus.FAIL,"New House Account form loaded Failed");
	}
}
	@Test(priority=6)
	public void HouseAccount_Method_addHouseAccountsfor_Daily() throws Exception
	{
		Thread.sleep(3000);
	//Click the Customer Field
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[1]/div/div/a")).click();
	//Enter the required Customer name in the Corresponding field
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[1]/div/div/div/div/input")).sendKeys(Utility.getProperty("HA_Customer_Name"));
	//Press the Enter Key
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	
	//Clear the Account number field
	driver.findElement(By.name("accountNumber")).clear();
	//Enter the required name
	driver.findElement(By.name("accountNumber")).sendKeys(Utility.getProperty("HA_Account_Number"));
	//Click the Allow Credits Check box
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[3]/div[1]/label[2]/span")).click();
	//Click the Enable Limit Check box
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[3]/div[2]/label[2]/span")).click();
	//Click the Enable Max Limit button
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[3]/div[3]/label[2]/span")).click();
	//Select the Limit Period as Daily
	Select limitPeriod = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[2]/div[1]/div/select")));
	limitPeriod.selectByVisibleText("Daily");
	//Enter the minimum Limit
	driver.findElement(By.name("limit")).clear();
	//Enter the minimum Limit
	driver.findElement(By.name("limit")).sendKeys("1500");
	//Enter the Maximum Limit
	driver.findElement(By.name("maxAmount")).clear();
	//Enter the Maximum Limit
	driver.findElement(By.name("maxAmount")).sendKeys("2000");
	//Click the Save button
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	Thread.sleep(3000);
	//Check weather the new House Account saved successfully or not
	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("HouseAccount saved successfully"))
	{										
		test.log(LogStatus.PASS,"House Account Daily Saved  Sucessfully");
	}
	else
	{
		test.log(LogStatus.FAIL,"House Account Daily Save Failed");
	}

}

@Test(priority=7)
public void HouseAccount_Method_EditHouseAccountsfor_Weekly() throws Exception
{

Thread.sleep(3000);
//Clear the search field
driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/label/input")).clear();
//Enter the required keyword
driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("HA_Customer_Name"));
//Click the Edit icon
driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
Thread.sleep(3000);
	//Click the Allow Credits Check box
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[3]/div[1]/label[2]/span")).click();
	//Click the Enable Limit Check box
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[3]/div[2]/label[2]/span")).click();
	//Click the Enable Max Limit button
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/div[3]/div[3]/label[2]/span")).click();
	//Select the Limit Period as Weekly
	Select limitPeriod = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[2]/div[1]/div/select")));
	limitPeriod.selectByVisibleText("Weekly");
	Thread.sleep(2000);
	//Select the Start Day option
	Select startDay = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[2]/div[2]/div/select")));
	startDay.selectByVisibleText("WEDNESDAY");
	Thread.sleep(2000);
	//Clear the limit field
	driver.findElement(By.name("limit")).clear();
	//Enter the minimum Limit
	driver.findElement(By.name("limit")).sendKeys("1600");
	//Clear the Maximum Limit
	driver.findElement(By.name("maxAmount")).clear();
	//Enter the Maximum Limit
	driver.findElement(By.name("maxAmount")).sendKeys("2100");
	//Click the Save button
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(5000);
	
	//Check weather the new House Account saved successfully or not
	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("House account updated successfully"))
	{
		test.log(LogStatus.PASS,"House account Weekly updated successfully");
	}
	else
	{
		test.log(LogStatus.FAIL,"House account Weekly updated successfully is Failed");
	}

}


@Test(priority=8)
public void HouseAccount_Method_EditHouseAccountsfor_Monthly() throws Exception
{
	Thread.sleep(3000);
	//Clear the search field
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/label/input")).clear();
	//Enter the required keyword
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("HA_Customer_Name"));
	//Click the Edit icon
	driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
	Thread.sleep(3000);
	//Select the Limit Period as Monthly
	Select limitPeriod = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[2]/div[1]/div/select")));
	limitPeriod.selectByVisibleText("Monthly");
	//Clear the limit field
	driver.findElement(By.name("limit")).clear();
	//Enter the minimum Limit
	driver.findElement(By.name("limit")).sendKeys("1700");
	//Clear the Maximum Limit
	driver.findElement(By.name("maxAmount")).clear();
	//Enter the Maximum Limit
	driver.findElement(By.name("maxAmount")).sendKeys("2200");
	//Click the Save button
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(5000);

	//Check weather the new House Account saved successfully or not
	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("House account updated successfully"))
	{
		test.log(LogStatus.PASS,"House account Monthly updated successfully");
	}
	else
	{
		test.log(LogStatus.FAIL,"House account Monthly updated successfully is Failed");
	}
	Thread.sleep(5000);
}

@Test(priority=9)
public void HouseAccount_Method_deleteHouseAccounts() throws Exception
{	
	Thread.sleep(5000);
     //Clear the search field       
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/label/input")).clear();
	//Enter the required keyword
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("HA_Customer_Name"));
	Thread.sleep(5000);		
	//Click the delete button
	driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
	Thread.sleep(5000);
	//Click the yes button on popup
	driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
	
	Thread.sleep(8000);
	//Check weather the House Account deleted or not
	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("House account  inactivated successfully"))
	{									
		test.log(LogStatus.PASS,"House account  inactivated successfully");
	}
	else
	{
		test.log(LogStatus.FAIL,"House Account deletedHouse account  inactivated successfully is Failed");
	}
	Thread.sleep(5000);
}
	@Test(priority=10)
	public void HouseAccount_Method_DeActivestatus () throws Exception
	{
	Thread.sleep(2000);
	//Check Deactivate course
    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/input")).click();
	//Clear the search field
    Thread.sleep(6000);
    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/label/input")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("HA_Customer_Name"));
		Thread.sleep(6000);
		//Click the activate button
	driver.findElement(By.cssSelector("i.fa.fa-check")).click();
	Thread.sleep(4000);
	//Click the Yes button in the popup
	driver.findElement(By.linkText("Yes")).click();  
    Thread.sleep(4000);
	//Check if we Deactivate or not///House account  activated successfully
	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("House account activated successfully"))
	{
		test.log(LogStatus.PASS,"House account  activated successfully");
	}
	else
	{
		test.log(LogStatus.FAIL,"House account  activated successfully is Failed");
	}
	Thread.sleep(5000);
	}
	
	/*
	@Test(priority=9)
	public void HouseAccountActivestatus () throws Exception
	{
	//Check active course           
    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/input")).click();
    Thread.sleep(5000);
	///Clear the search field        
    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/label/input")).clear();
    Thread.sleep(5000);   	
	//Enter the required keyword
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("HA_Customer_Name"));
		
	    //Clear the search field
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/label/input")).clear();
	Thread.sleep(3000);
	}
	
	*/
	}

	


