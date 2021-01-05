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


public class Verify_Till_Cash_Transaction_Reports {
	public WebDriver driver;

		ExtentReports rep = ExtentManager.getInstance();
		ExtentTest test = rep.startTest("Verify_Employee_Payroll_Reports");
		
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

	@Test(priority=40)
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
	public void viewTransactionTypeAll() throws Exception
	{
		//Click the Reports option
		driver.findElement(By.xpath("//span[.='Reports']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Till']"));
		//Scroll the page till the Till option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Till Option		
		driver.findElement(By.xpath("//span[.='Till']")).click();
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
		//Click the Cash Transaction report in the Till report
		driver.findElement(By.xpath("//span[.=' Cash Transaction']")).click();
		Thread.sleep(3000);
		
		//Check Cash Transaction page opened or not
		if(driver.findElement(By.xpath("//a[.='Cash Transaction']")).getText().equalsIgnoreCase("Cash Transaction"))
		{
			test.log(LogStatus.PASS,"Cash Transaction Report page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"Cash Transaction Report page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	
	@Test(priority=3)
	public void verifyTransactionTypeAll() throws Exception
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
	  	
		//Select the Employee option
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/a")).click();
	    //Enter the required Employee
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
	    //Press the Enter key
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	    
	    //Select the Transaction type option (All)
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/a")).click();
	    //Enter the required Transaction type (All)
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/div/div/input")).sendKeys("All");
	    //Press the Enter key
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

	    //Select the Time Period option
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/a")).click();
	    //Enter the required Period of time (Specific date)
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
	    //Press the Enter key
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    
	    //Clear the Date field
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[1]")).clear();
	    //Enter the number of days
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

	    //Clear the Date field
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[2]")).clear();
	    //Enter the number of days
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
	    
	    //Click the Run
	    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
	    Thread.sleep(10000);

		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Cash Transaction Report is not available for Specific Date");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr[2]/td[1]")).getText() != null && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr[2]/td[6]")).getText() != null)
		{
			
			test.log(LogStatus.PASS, "Cash Transaction Report is available for Specific Date");
		
			
			List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr"));
			
			//Get the amount Value
			String amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+rows.size()+"]/td[6]")).getText();
			
			System.out.println("Total Amount is : "+amount);
			
			test.log(LogStatus.INFO, "Total Amount is : "+amount);
			
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Cash Transaction Report is not available for Specific Date");
		}  
	    
	}
	
}
