package reportsWithoutActualTax;

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

public class View_Customer_Info {


	public WebDriver driver;
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("View_Customer_Info");

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
	public void open_Customer_Info_Page() throws Exception
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
	public void view_Customers_Info() throws Exception
	{
		Thread.sleep(2000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the key word
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("sara@mail.com");
		//Click the search button
		driver.findElement(By.xpath("//a[@ class='btn customer-search-icon']")).click();
		
		Thread.sleep(2000);
		//Click the View button
		driver.findElement(By.xpath("//a[.='View']")).click();
		
		Thread.sleep(5000);
		//Refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/a[1]/i")).click();
		
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
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
	    
	    List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/table/tbody/tr"));
	    
	    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/table/tbody/tr[1]/td[1]/a")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/table/tbody/tr[1]/td[2]")).getText() != null)
	    {
	    	
	    	
	    	test.log(LogStatus.PASS, "Sales details  available");
	    	
		    for(int i = 1; i <= rows.size();i++)
		    {
		    	Thread.sleep(1000);
		    	//Click the required check
		    	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/table/tbody/tr["+i+"]/td[1]/a")).click();
		    	
		    	//Check Whether the Send Receipt is enabled or not
		    	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[1]/div/div[2]/button")).isEnabled())
		    	{
		    	Thread.sleep(1000);
		    	//Click the Send Receipt
		    	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[1]/div/div[2]/button")).click();
		    	
				    	Thread.sleep(1000);
				    	//Check whether the receipt sent successfully or not
				    	if(driver.findElement(By.xpath("//span[.='Email receipt sent successfully']")).getText().equalsIgnoreCase("Email receipt sent successfully"))	
				    	{
				    		test.log(LogStatus.PASS, "Email Receipt sent successfully");
				    	}
				    	
				    	else
				    	{
				    		test.log(LogStatus.FAIL, "Email Receipt sent fail");
				    	}
		    		
		    	}
		    	
		    	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
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
		    	
		    	//Check whether the Payment summary is available or not
		    	if(driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[3]/td[5]")) != null)
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
	
		    		Thread.sleep(1000);
		    		
		    		//Click the Back button
		    		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[1]/div/div[2]/a")).click();
		    		
		    		Thread.sleep(2000);
		    }
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Sales details is not available");
	    }
	    
	    driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/a[2]")).click();
	    
	    Thread.sleep(2000);
	}
		
}
