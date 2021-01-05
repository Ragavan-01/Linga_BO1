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

public class Verify_PaidIn_Or_PaidOut_Report {

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Verify_PaidIn_Or_PaidOut_Report");

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
	    	test.log(LogStatus.PASS, "User Logged out Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "User Logged out Failed");
		}
		Thread.sleep(5000);
		//Close the Browser
		driver.close();
	}
	
	@Test(priority=2)
	public void open_PaidIn_Or_PaidOut_Report() throws Exception
	{
	
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
		driver.findElement(By.xpath("//span[.='Paid In/Paid Out']")).click();
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
	
	@Test(priority=3)
	public void paidIn_Or_PaidOut_Report() throws Exception
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
	
	@Test(priority=4)
	public void paidIn_Report() throws Exception
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
	
	@Test(priority=5)
	public void paidOut_Report() throws Exception
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
}
