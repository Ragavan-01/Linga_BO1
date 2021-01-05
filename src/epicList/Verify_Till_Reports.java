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

import epicList_Integrated.Utility;

public class Verify_Till_Reports {
	public WebDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Verify_Till_Reports");
	
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

		@Test(priority=9)
		public void Till_Report_Method_viewpage() throws Exception
		{
			/*	//Click the Reports option
			driver.findElement(By.xpath("//span[.='Reports']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Till']"));
			//Scroll the page till the Till option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
	        //Click the Till Option		
			driver.findElement(By.xpath("//span[.='Till']")).click(); */
	
			Thread.sleep(3000);
			//Enter the Users URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"tillReport");
	
			Thread.sleep(5000);
			//Check Till page opened or not
			if(driver.findElement(By.xpath("//a[.='Till']")).getText().equalsIgnoreCase("Till"))
			{
				test.log(LogStatus.PASS,"Till Report page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Till Report page loaded Failed");
			}
			Thread.sleep(3000);
	
			}
	
		@Test(priority=10)
		public void Till_Report_Method_verifyAll() throws Exception
		{
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	//Select the Employee option
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/a")).click();
	//Enter the required Employee
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
	//Press the Enter key
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
	//Select the Till type option
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/a")).click();
	//Enter the required Till type
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/div/div/input")).sendKeys("ALL");
	//Press the Enter key
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
	//Click the Time Period option
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/a")).click();
	//Enter the required Period of time for Specific date
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");	    
	//Press the Enter key
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	
	//Clear the date field
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[1]")).clear();
	//Select the required Specific date
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Till_Date_Range_From"));
	
	
	//Clear the date field
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[2]")).clear();
	//Select the required Specific date
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Till_Date_Range_To"));
	
	
	//Click the Run
	driver.findElement(By.cssSelector("button.btn.btn-success")).click();
	Thread.sleep(10000);
	
	List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr"));
	
	//Check weather the report is available for the selected time period
	if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
	{
		test.log(LogStatus.FAIL, "Till Report is not available for Specific Date");
	}
	
	else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr[2]/td[2]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr[2]/td[5]")).getText() != null)
	{
		
		test.log(LogStatus.PASS, "Till Report(All) is available for Specific Date");
	
		System.out.println("***** Till Report for All *****");
		
		test.log(LogStatus.INFO, "***** Till Report for All *****");
		
		
		//Get the Cash Expected Value
		String cash_Expected = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
		
		System.out.println("Total Cash Expected is : "+cash_Expected);
		
		test.log(LogStatus.INFO, "Total Cash Expected is : "+cash_Expected);
	
		
		//Get the amount Value
		String amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
		
		System.out.println("Total Amount is : "+amount);
		
		test.log(LogStatus.INFO, "Total Amount is : "+amount);
		
		//Get the Over/Shortage Value
		String over_Or_Shortage = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
		
		System.out.println("Total Over/Shortage is : "+over_Or_Shortage);
		
		test.log(LogStatus.INFO, "Total Over/Shortage is : "+over_Or_Shortage);
		
		
		Thread.sleep(2000);
		Thread.sleep(3000);
		for(int i=2; i < rows.size();i++)
		{
			String tillName = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText();
			
			String date = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[2]")).getText();
			
			String user = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[3]")).getText();
			
			String cashExpected = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[4]")).getText();
	
			String amount1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[5]")).getText();
	
			Thread.sleep(2000);
			
			test.log(LogStatus.INFO, "The Till("+tillName+") have the following details : ");
			
			test.log(LogStatus.INFO, "Date and Time is : "+date);
			
			test.log(LogStatus.INFO, "User name is : "+user);
			
			test.log(LogStatus.INFO, "Cash Expexted is : "+cashExpected);
			
			test.log(LogStatus.INFO, "Amount is : "+amount1);
			
			//Click the required Check
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]/a")).click();
	
			Thread.sleep(6000);
			
			test.log(LogStatus.INFO, "*******  TILL SUMMARY("+tillName+")  *******");
			
			test.log(LogStatus.INFO, "Total Starting Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[4]/div[2]")).getText());
			
			test.log(LogStatus.INFO, "Pay-Outs is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[6]/div[2]")).getText());
	
			test.log(LogStatus.INFO, "Pay-Ins is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[8]/div[2]")).getText());
	
			test.log(LogStatus.INFO, "Cash Drops is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[10]/div[2]")).getText());
	
			test.log(LogStatus.INFO, "Refund is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[12]/div[2]")).getText());
	
			test.log(LogStatus.INFO, "Void Cash Amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[14]/div[2]")).getText());
	
			test.log(LogStatus.INFO, "Cash Transactions is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[16]/div[2]")).getText());
	
			
			Thread.sleep(5000);
	    	//Replace all commo's with empty space
	    	String expected1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[18]/div[2]")).getText().replace(",", "");
	    	System.out.println("Expected Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[18]/div[2]")).getText());
	    	//Convert the String value of Expected Cash in Till Summary
	    	float expect1 = Float.parseFloat(expected1);
	    	
	    	//Get Cash Expected from the Till Table and Replace all commo's with empty space
	    	String actualText1 = cashExpected.replace(",", "");
	    	
	    	//Convert the String value of the Expected Cash element into float value
	    	float actual = Float.parseFloat(actualText1);
	    	
			
			if(expect1 == actual)
			{
				test.log(LogStatus.INFO, "Expected Cash in Till("+tillName+") is : "+cashExpected);
			}
			else
			{
				test.log(LogStatus.FAIL, "Expected Cash in Till("+tillName+") Summay and Cash Expected are different");
	        			        	
	        	//Get the different
	        	float different = actual - expect1;
	        	
	        	//Print the different value
	        	System.out.println("In Till("+tillName+"),  Expected Cash Value different is : "+different);
	        	
	        	test.log(LogStatus.FAIL, "In Till("+tillName+"),  Expected Cash Value different is : "+different);
	        	
	        	
			}
			
	    	//Replace all commo's with empty space
	    	String expected2 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[20]/div[2]")).getText().replace(",", "");
	    	
	    	//Convert the String value of Ending Cash Total Till Summary
	    	float expect2 = Float.parseFloat(expected2);  
	    	
	    	//Get Amount from the Till Table and Replace all commo's with empty space
	    	String actualText2 = amount1.replace(",", "");
	    	
	    	//Convert the String value of the amount element into float value
	    	float actual2 = Float.parseFloat(actualText2);
	    	
			if(expect2 == actual2)
			{
				test.log(LogStatus.INFO, "Expected Cash in Till is : "+amount1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Expected Cash in Till Summay and Cash Expected are different");
						        			        	
	        	//Get the different
	        	float different = actual2 - expect2;
	        	
	        	//Print the different value
	        	System.out.println("In Till("+tillName+"),  Amount Value different is : "+different);
	        	
	        	test.log(LogStatus.FAIL, "In Till("+tillName+"),  Amount Value different is : "+different);
	        	
	        	
			}
			
			test.log(LogStatus.INFO, "Differences is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[8]/div[2]")).getText());
	
			test.log(LogStatus.INFO, "Reason is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[9]/div[2]")).getText());
			
			Thread.sleep(2000);
			//Click the Load Transactions button
			driver.findElement(By.xpath("//a[.='Load Transactions']")).click();
			Thread.sleep(1000);
			
			try
			{
				//Check whether the Load Transaction details are available or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr[2]/td[1]")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Load Transaction details are available");
					
					List<WebElement> loadTransactionRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr"));
					
						test.log(LogStatus.PASS, "Load Transactions amount total and Expected cash in Till amount are same then the Total in Load Transaction is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr["+loadTransactionRow.size()+"]/td[6]")).getText());
	
				}
			}
			catch(Exception e)
			{
				
				
					test.log(LogStatus.FAIL, "Load Transaction details are not available");
				
			}
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);	
			Thread.sleep(2000);Thread.sleep(1000);
			//Click the Back Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/a")).click();
			
			Thread.sleep(1000);
		}
	}
	
	else
	{
		test.log(LogStatus.FAIL, "Till Report is not available for Specific Date");
	}
	
	/*		String[] date = new String[rows.size()];
	
	String[] user = new String[rows.size()];*/
	
	
	}

		@Test(priority=11)
		public void Till_Report_Method_Global() throws Exception
		{
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(8000);   
		//Select the Employee option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/a")).click();
		//Enter the required Employee
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Select the Till type option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/a")).click();
		//Enter the required Till type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/div/div/input")).sendKeys("GLOBAL");
		//Press the Enter key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Time Period option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/a")).click();
		//Enter the required Period of time for Specific date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");	    
		//Press the Enter key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[1]")).clear();
		//Select the required Specific date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Till_Date_Range_From"));
		
		
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[2]")).clear();
		//Select the required Specific date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Till_Date_Range_To"));
		
		
		//Click the Run
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		Thread.sleep(10000);
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr"));
		
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Till Report is not available for Specific Date");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr[2]/td[2]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr[2]/td[5]")).getText() != null)
		{
			
			test.log(LogStatus.PASS, "Till Report(Global) is available for Specific Date");
		
			System.out.println("***** Till Report for Global *****");
			
			test.log(LogStatus.INFO, "***** Till Report for Global *****");
			
			
			//Get the Cash Expected Value
			String cash_Expected = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
			
			System.out.println("Total Cash Expected is : "+cash_Expected);
			
			test.log(LogStatus.INFO, "Total Cash Expected is : "+cash_Expected);
		
			
			//Get the amount Value
			String amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
			
			System.out.println("Total Amount is : "+amount);
			
			test.log(LogStatus.INFO, "Total Amount is : "+amount);
			
			//Get the Over/Shortage Value
			String over_Or_Shortage = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
			
			System.out.println("Total Over/Shortage is : "+over_Or_Shortage);
			
			test.log(LogStatus.INFO, "Total Over/Shortage is : "+over_Or_Shortage);
			
			
			Thread.sleep(3000);
			for(int i=2; i < rows.size();i++)
			{
				String tillName = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText();
				
				String date = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[2]")).getText();
				
				String user = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[3]")).getText();
				
				String cashExpected = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[4]")).getText();
		
				String amount1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[5]")).getText();
		
				Thread.sleep(1000);
				
				test.log(LogStatus.INFO, "The Till("+tillName+") have the following details : ");
				
				test.log(LogStatus.INFO, "Date and Time is : "+date);
				
				test.log(LogStatus.INFO, "User name is : "+user);
				
				test.log(LogStatus.INFO, "Cash Expexted is : "+cashExpected);
				
				test.log(LogStatus.INFO, "Amount is : "+amount1);
				
				//Click the required Check
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]/a")).click();
		
				Thread.sleep(6000);
				
				test.log(LogStatus.INFO, "*******  TILL SUMMARY("+tillName+")  *******");
				
				test.log(LogStatus.INFO, "Total Starting Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[4]/div[2]")).getText());
				
				test.log(LogStatus.INFO, "Pay-Outs is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[6]/div[2]")).getText());
		
				test.log(LogStatus.INFO, "Pay-Ins is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[8]/div[2]")).getText());
		
				test.log(LogStatus.INFO, "Cash Drops is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[10]/div[2]")).getText());
		
				test.log(LogStatus.INFO, "Refund is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[12]/div[2]")).getText());
		
				test.log(LogStatus.INFO, "Void Cash Amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[14]/div[2]")).getText());
		
				test.log(LogStatus.INFO, "Cash Transactions is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[16]/div[2]")).getText());
		
				
				Thread.sleep(5000);
		    	//Replace all commo's with empty space
		    	String expected1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[18]/div[2]")).getText().replace(",", "");
		    	
		    	//Convert the String value of Expected Cash in Till Summary
		    	float expect1 = Float.parseFloat(expected1);  
		    	
		    	//Get Cash Expected from the Till Table and Replace all commo's with empty space
		    	String actualText1 = cashExpected.replace(",", "");
		    	
		    	//Convert the String value of the Expected Cash element into float value
		    	float actual = Float.parseFloat(actualText1);
		    	
				
				if(expect1 == actual)
				{
					test.log(LogStatus.INFO, "Expected Cash in Till("+tillName+") is : "+cashExpected);
				}
				else
				{
					test.log(LogStatus.FAIL, "Expected Cash in Till("+tillName+") Summay and Cash Expected are different");
		        			        	
		        	//Get the different
		        	float different = actual - expect1;
		        	
		        	//Print the different value
		        	System.out.println("In Till("+tillName+"),  Expected Cash Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "In Till("+tillName+"),  Expected Cash Value different is : "+different);
		        	
		        	
				}
				
		    	//Replace all commo's with empty space
		    	String expected2 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[20]/div[2]")).getText().replace(",", "");
		    	
		    	//Convert the String value of Ending Cash Total Till Summary
		    	float expect2 = Float.parseFloat(expected2);  
		    	
		    	//Get Amount from the Till Table and Replace all commo's with empty space
		    	String actualText2 = amount1.replace(",", "");
		    	
		    	//Convert the String value of the amount element into float value
		    	float actual2 = Float.parseFloat(actualText2);
		    	
				if(expect2 == actual2)
				{
					test.log(LogStatus.INFO, "Expected Cash in Till is : "+amount1);
				}
				else
				{
					test.log(LogStatus.FAIL, "Expected Cash in Till Summay and Cash Expected are different");
							        			        	
		        	//Get the different
		        	float different = actual2 - expect2;
		        	
		        	//Print the different value
		        	System.out.println("In Till("+tillName+"),  Amount Value different is : "+different);
		        	
		        	test.log(LogStatus.FAIL, "In Till("+tillName+"),  Amount Value different is : "+different);
		        	
		        	
				}
				
				Thread.sleep(2000);
				
				test.log(LogStatus.INFO, "Differences is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[8]/div[2]")).getText());
		
				test.log(LogStatus.INFO, "Reason is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[9]/div[2]")).getText());
		
				Thread.sleep(2000);
				//Click the Load Transactions button
				driver.findElement(By.xpath("//a[.='Load Transactions']")).click();
				Thread.sleep(1000);
				
				//Check whether the Load Transaction details are available or not
				try
				{
					//Check whether the Load Transaction details are available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr[2]/td[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Load Transaction details are available");
						
						List<WebElement> loadTransactionRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr"));
						
							test.log(LogStatus.PASS, "Load Transactions amount total and Expected cash in Till amount are same then the Total in Load Transaction is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr["+loadTransactionRow.size()+"]/td[6]")).getText());
		
					}
				}
				catch(Exception e)
				{
					
					
						test.log(LogStatus.FAIL, "Load Transaction details are not available");
					
				}driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(3000);
				//Click the Back Button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/a")).click();
				
				Thread.sleep(1000);
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Till Report is not available for Specific Date");
		}
		
		
		}
		
		@Test(priority=12)
		public void Till_Report_Method_User() throws Exception
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(8000);
		    
			//Select the Employee option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/a")).click();
		    //Enter the required Employee
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		   
		    //Select the Till type option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/a")).click();
		    //Enter the required Till type
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/div/div/input")).sendKeys("USER");
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    
		    //Click the Time Period option
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/a")).click();
		    //Enter the required Period of time for Specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");	    
		    //Press the Enter key
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    
		    //Clear the date field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[1]")).clear();
		    //Select the required Specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Till_Date_Range_From"));
		    
		
		    //Clear the date field
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[2]")).clear();
		    //Select the required Specific date
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Till_Date_Range_To"));
		    
		    Thread.sleep(1000);
		    //Click the Run
		    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		    Thread.sleep(10000);
		    
			List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr"));
			
			Thread.sleep(2000);
			//Check weather the report is available for the selected time period
			if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Till Report is not available for Specific Date");
			}
			
			else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr[2]/td[2]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr[2]/td[5]")).getText() != null)
			{
				
				test.log(LogStatus.PASS, "Till Report(User) is available for Specific Date");
		
				System.out.println("***** Till Report for User *****");
				
				test.log(LogStatus.INFO, "***** Till Report for User *****");
								
				//Get the Cash Expected Value
				String cash_Expected = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[4]")).getText();
				
				System.out.println("Total Cash Expected is : "+cash_Expected);
				
				test.log(LogStatus.INFO, "Total Cash Expected is : "+cash_Expected);
		
				
				//Get the amount Value
				String amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[5]")).getText();
				
				System.out.println("Total Amount is : "+amount);
				
				test.log(LogStatus.INFO, "Total Amount is : "+amount);
				
				//Get the Over/Shortage Value
				String over_Or_Shortage = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
				
				System.out.println("Total Over/Shortage is : "+over_Or_Shortage);
				
				test.log(LogStatus.INFO, "Total Over/Shortage is : "+over_Or_Shortage);
				
				Thread.sleep(3000);
				for(int i=2; i < rows.size();i++)
				{
					String tillName = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText();
					
					String date = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[2]")).getText();
					
					String user = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[3]")).getText();
					
					String cashExpected = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[4]")).getText();
		
					String amount1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[5]")).getText();
		
					Thread.sleep(1000);
					
					test.log(LogStatus.INFO, "The Till("+tillName+") have the following details : ");
					
					test.log(LogStatus.INFO, "Date and Time is : "+date);
					
					test.log(LogStatus.INFO, "User name is : "+user);
					
					test.log(LogStatus.INFO, "Cash Expexted is : "+cashExpected);
					
					test.log(LogStatus.INFO, "Amount is : "+amount1);
					
					//Click the required Check
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]/a")).click();
		
					Thread.sleep(6000);
					
					test.log(LogStatus.INFO, "*******  TILL SUMMARY("+tillName+")  *******");
					
					test.log(LogStatus.INFO, "Total Starting Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[4]/div[2]")).getText());
					
					test.log(LogStatus.INFO, "Pay-Outs is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[6]/div[2]")).getText());
		
					test.log(LogStatus.INFO, "Pay-Ins is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[8]/div[2]")).getText());
		
					test.log(LogStatus.INFO, "Cash Drops is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[10]/div[2]")).getText());
		
					test.log(LogStatus.INFO, "Refund is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[12]/div[2]")).getText());
		
					test.log(LogStatus.INFO, "Void Cash Amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[14]/div[2]")).getText());
		
					test.log(LogStatus.INFO, "Cash Transactions is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[16]/div[2]")).getText());
		
					
					Thread.sleep(5000);
		        	//Replace all commo's with empty space
		        	String expected1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[18]/div[2]")).getText().replace(",", "");
		        	
		        	//Convert the String value of Expected Cash in Till Summary
		        	float expect1 = Float.parseFloat(expected1);  
		        	
		        	//Get Cash Expected from the Till Table and Replace all commo's with empty space
		        	String actualText1 = cashExpected.replace(",", "");
		        	
		        	//Convert the String value of the Expected Cash element into float value
		        	float actual = Float.parseFloat(actualText1);
		        	
					
					if(expect1 == actual)
					{
						test.log(LogStatus.INFO, "Expected Cash in Till("+tillName+") is : "+cashExpected);
					}
					else
					{
						test.log(LogStatus.FAIL, "Expected Cash in Till("+tillName+") Summay and Cash Expected are different");
			        			        	
			        	//Get the different
			        	float different = actual - expect1;
			        	
			        	//Print the different value
			        	System.out.println("In Till("+tillName+"),  Expected Cash Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "In Till("+tillName+"),  Expected Cash Value different is : "+different);
			        	
			        	
					}
					
		        	//Replace all commo's with empty space
		        	String expected2 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[4]/div[20]/div[2]")).getText().replace(",", "");
		        	
		        	//Convert the String value of Ending Cash Total Till Summary
		        	float expect2 = Float.parseFloat(expected2);  
		        	
		        	//Get Amount from the Till Table and Replace all commo's with empty space
		        	String actualText2 = amount1.replace(",", "");
		        	
		        	//Convert the String value of the amount element into float value
		        	float actual2 = Float.parseFloat(actualText2);
		        	
					if(expect2 == actual2)
					{
						test.log(LogStatus.INFO, "Expected Cash in Till is : "+amount1);
					}
					else
					{
						test.log(LogStatus.FAIL, "Expected Cash in Till Summay and Cash Expected are different");
								        			        	
			        	//Get the different
			        	float different = actual2 - expect2;
			        	
			        	//Print the different value
			        	System.out.println("In Till("+tillName+"),  Amount Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "In Till("+tillName+"),  Amount Value different is : "+different);
			        	
			        	
					}
					
					Thread.sleep(2000);
					
					test.log(LogStatus.INFO, "Differences is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[8]/div[2]")).getText());
		
					test.log(LogStatus.INFO, "Reason is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[9]/div[2]")).getText());
		
					Thread.sleep(2000);
					//Click the Load Transactions button
					driver.findElement(By.xpath("//a[.='Load Transactions']")).click();
					Thread.sleep(1000);
					
					try
					{
						//Check whether the Load Transaction details are available or not
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr[2]/td[1]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "Load Transaction details are available");
							
							List<WebElement> loadTransactionRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr"));
							
								test.log(LogStatus.PASS, "Load Transactions amount total and Expected cash in Till amount are same then the Total in Load Transaction is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div[14]/div/div/div[4]/table/tbody/tr["+loadTransactionRow.size()+"]/td[6]")).getText());
		
						}
					}
					catch(Exception e)
					{
						
						
							test.log(LogStatus.FAIL, "Load Transaction details are not available");
						
					}
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);	
					Thread.sleep(3000);
					//Click the Back Button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div[1]/a")).click();
					
					Thread.sleep(1000);
				}
			}
			
			else
			{
				test.log(LogStatus.FAIL, "Till Report is not available for Specific Date");
			}
		    
		
		}
	}
