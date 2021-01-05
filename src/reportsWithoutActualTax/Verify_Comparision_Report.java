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

public class Verify_Comparision_Report {

	public WebDriver driver;

		ExtentReports rep = ExtentManager.getInstance();
		ExtentTest test = rep.startTest("Verify_Comparision_Report");
		
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

	@Test(priority=30)
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
	public void viewComparisionReport() throws Exception
	{
		//Click the Reports option
		driver.findElement(By.xpath("//span[.='Reports']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Comparision Report']"));
		//Scroll the page till the Comparision Report option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Comparision Report Option		
		driver.findElement(By.xpath("//span[.='Comparision Report']")).click();
		Thread.sleep(5000);
		//Check Comparision Report page opened or not
		if(driver.findElement(By.xpath("//a[.='Comparision Report']")).getText().equalsIgnoreCase("Comparision Report"))
		{
			test.log(LogStatus.PASS,"Comparision Report page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"Comparision Report page loaded Failed");
		}
		
		Thread.sleep(3000);
		
	}
	
	@Test(priority=3)
	public void verifyComparisionReport_By_Payment_Type() throws Exception
	{
		
	    Thread.sleep(5000);
		//Select the Time Period option
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[1]/div/div/div/a")).click();
	    //Enter the required Period of time for Specific date
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[1]/div/div/div/div/div/input")).sendKeys("Today");
	    //Press the Enter key
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    
	    Thread.sleep(5000);
		//Select the Time Period option
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[2]/div/div/div/a")).click();
	    //Enter the required Period of time for Specific date
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[2]/div/div/div/div/div/input")).sendKeys("Yesterday");
	    //Press the Enter key
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    
	    Thread.sleep(5000);
		//Select the Time Period option
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[3]/div/div/div/a")).click();
	    //Enter the required Period of time for Specific date
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[3]/div/div/div/div/div/input")).sendKeys("Last 'N' days");
	    //Press the Enter key
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    
	    //Clear the number of day field
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[3]/div[2]/div/div/input")).clear();
	    //Enter the required days
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[3]/div[2]/div/div/input")).sendKeys("100");
	    //Press the Enter Key
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[3]/div[2]/div/div/input")).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(5000);
		//Select the Time Period option
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[4]/div/div/div/a")).click();
	    //Enter the required Period of time for Specific date
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[4]/div/div/div/div/div/input")).sendKeys("This week");
	    //Press the Enter key
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[4]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    
	    //Click the Run
	    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
	    Thread.sleep(2000);

	    driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	    
	    String no_sale_amount = "₹0.00";
	    
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[1]")).getText() == no_sale_amount && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[1]")).getText() == no_sale_amount && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[1]")).getText() == no_sale_amount && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[1]")).getText() == no_sale_amount)
		{
			test.log(LogStatus.FAIL, "Comparision Report is not available for Specific Date");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[1]")).getText() != no_sale_amount && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[1]")).getText() != no_sale_amount && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[1]")).getText() != no_sale_amount && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[1]")).getText() != no_sale_amount)
		{
			
			test.log(LogStatus.PASS, "Comparision Report is available for Specific Date");
			
			List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div"));
			rows.size();

			System.out.println("Date or Date Range is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[2]")).getText());
			
			test.log(LogStatus.INFO, "Date or Date Range is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[2]")).getText());


			for(int i = 1; i <= rows.size(); i++)
			{
				
				System.out.println(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div["+i+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div["+i+"]")).getText());
				
				test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div["+i+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div["+i+"]")).getText());

			}
			

			System.out.println("Date or Date Range is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[3]")).getText());
			
			test.log(LogStatus.INFO, "Date or Date Range is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[3]")).getText());

			for(int i = 1; i <= rows.size(); i++)
			{
				

				System.out.println(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div["+i+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div["+i+"]")).getText());
				
				test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div["+i+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div["+i+"]")).getText());

			}

			System.out.println("Date or Date Range is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[4]")).getText());
			
			test.log(LogStatus.INFO, "Date or Date Range is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[4]")).getText());


			for(int i = 1; i <= rows.size(); i++)
			{
				
				System.out.println(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div["+i+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div["+i+"]")).getText());
				
				test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div["+i+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div["+i+"]")).getText());

			}
			
			
			System.out.println("Date or Date Range is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[5]")).getText());
			
			test.log(LogStatus.INFO, "Date or Date Range is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[5]")).getText());


			for(int i = 1; i <= rows.size(); i++)
			{
				
				System.out.println(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div["+i+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div["+i+"]")).getText());
				
				test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[1]/div["+i+"]")).getText()+" is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div["+i+"]")).getText());

			}
			
			
			
/*			
			
			
			
			
			System.out.println("Date or Date Range is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[2]")).getText());
			
			test.log(LogStatus.INFO, "Date or Date Range is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[2]")).getText());
			
			System.out.println("Net Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[1]")).getText());			
			
			test.log(LogStatus.INFO, "Net Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[1]")).getText());
			
			System.out.println("Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[2]")).getText());
			
			test.log(LogStatus.INFO, "Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[2]")).getText());
			
			System.out.println("Actual Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[3]")).getText());
			
			test.log(LogStatus.INFO, "Actual Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[3]")).getText());
			
			System.out.println("Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[4]")).getText());
			
			test.log(LogStatus.INFO, "Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[4]")).getText());
			
			System.out.println("Discounts is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[5]")).getText());			
			
			test.log(LogStatus.INFO, "Discounts is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[5]")).getText());
			
			System.out.println("Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[6]")).getText());
			
			test.log(LogStatus.INFO, "Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[6]")).getText());
			
			System.out.println("Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[7]")).getText());
			
			test.log(LogStatus.INFO, "Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[7]")).getText());
			
			System.out.println("Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[8]")).getText());
			
			test.log(LogStatus.INFO, "Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[8]")).getText());
			
			System.out.println("Payments is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[9]")).getText());
			
			test.log(LogStatus.INFO, "Payments is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[2]/div[9]")).getText());

			System.out.println("Date or Date Range is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[3]")).getText());
			
			test.log(LogStatus.INFO, "Date or Date Range is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[3]")).getText());
			
			System.out.println("Net Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[1]")).getText());			
			
			test.log(LogStatus.INFO, "Net Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[1]")).getText());
			
			System.out.println("Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[2]")).getText());
			
			test.log(LogStatus.INFO, "Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[2]")).getText());
			
			System.out.println("Actual Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[3]")).getText());
			
			test.log(LogStatus.INFO, "Actual Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[3]")).getText());
			
			System.out.println("Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[4]")).getText());
			
			test.log(LogStatus.INFO, "Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[4]")).getText());
			
			System.out.println("Discounts is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[5]")).getText());			
			
			test.log(LogStatus.INFO, "Discounts is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[5]")).getText());
			
			System.out.println("Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[6]")).getText());
			
			test.log(LogStatus.INFO, "Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[6]")).getText());
			
			System.out.println("Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[7]")).getText());
			
			test.log(LogStatus.INFO, "Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[7]")).getText());
			
			System.out.println("Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[8]")).getText());
			
			test.log(LogStatus.INFO, "Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[8]")).getText());
			
			System.out.println("Payments is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[9]")).getText());
			
			test.log(LogStatus.INFO, "Payments is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[3]/div[9]")).getText());
			
			System.out.println("Date or Date Range is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[4]")).getText());
			
			test.log(LogStatus.INFO, "Date or Date Range is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[4]")).getText());
			
			System.out.println("Net Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[1]")).getText());			
			
			test.log(LogStatus.INFO, "Net Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[1]")).getText());
			
			System.out.println("Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[2]")).getText());
			
			test.log(LogStatus.INFO, "Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[2]")).getText());
			
			System.out.println("Actual Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[3]")).getText());
			
			test.log(LogStatus.INFO, "Actual Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[3]")).getText());
			
			System.out.println("Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[4]")).getText());
			
			test.log(LogStatus.INFO, "Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[4]")).getText());
			
			System.out.println("Discounts is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[5]")).getText());			
			
			test.log(LogStatus.INFO, "Discounts is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[5]")).getText());
			
			System.out.println("Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[6]")).getText());
			
			test.log(LogStatus.INFO, "Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[6]")).getText());
			
			System.out.println("Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[7]")).getText());
			
			test.log(LogStatus.INFO, "Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[7]")).getText());
			
			System.out.println("Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[8]")).getText());
			
			test.log(LogStatus.INFO, "Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[8]")).getText());
			
			System.out.println("Payments is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[9]")).getText());
			
			test.log(LogStatus.INFO, "Payments is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[4]/div[9]")).getText());
			
			System.out.println("Date or Date Range is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[5]")).getText());
			
			test.log(LogStatus.INFO, "Date or Date Range is : "+ driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[1]/th[5]")).getText());
			
			System.out.println("Net Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[1]")).getText());			
			
			test.log(LogStatus.INFO, "Net Sales is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[1]")).getText());
			
			System.out.println("Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[2]")).getText());
			
			test.log(LogStatus.INFO, "Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[2]")).getText());
			
			System.out.println("Actual Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[3]")).getText());
			
			test.log(LogStatus.INFO, "Actual Tax is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[3]")).getText());
			
			System.out.println("Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[4]")).getText());
			
			test.log(LogStatus.INFO, "Net Void is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[4]")).getText());
			
			System.out.println("Discounts is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[5]")).getText());			
			
			test.log(LogStatus.INFO, "Discounts is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[5]")).getText());
			
			System.out.println("Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[6]")).getText());
			
			test.log(LogStatus.INFO, "Refunds is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[6]")).getText());
			
			System.out.println("Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[7]")).getText());
			
			test.log(LogStatus.INFO, "Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[7]")).getText());
			
			System.out.println("Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[8]")).getText());
			
			test.log(LogStatus.INFO, "Cash is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[8]")).getText());
			
			System.out.println("Payments is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[9]")).getText());
			
			test.log(LogStatus.INFO, "Payments is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/form/div[7]/div/table/tbody/tr[2]/td[5]/div[9]")).getText());
*/


		}
		
		else
		{
			test.log(LogStatus.FAIL, "Comparision Report is not available for Specific Date");
		}  
	    Thread.sleep(2000);
	    
	}
	
}
