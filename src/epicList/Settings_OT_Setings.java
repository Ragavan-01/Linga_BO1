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

import epicList_Integrated.Utility;

public class Settings_OT_Setings {


	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings_OT_Setings");
	
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
			Thread.sleep(5000);
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
			Thread.sleep(5000);
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
		
	@Test(priority=700)
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

	@Test(priority=3, enabled=false)
	public void watchTutorial() throws Exception
	{
		Thread.sleep(2000);
		//Click the Watch Tutorial Option
		driver.findElement(By.xpath("//span[.='Watch Tutorial']")).click();
		WebElement iframe = driver.findElement(By.xpath("//div[@class='modal-content']/span/iframe"));
		driver.switchTo().frame(iframe);
		Thread.sleep(3500);
		try
		{
			if(driver.findElement(By.xpath("//button/div[.='Watch later']")).isDisplayed()&&driver.findElement(By.xpath("//button/div[.='Share']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Watch Tutorial Video Played Well");
				Thread.sleep(2500);
			}
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Watch Tutorial Video not Played");
		}
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		//Click the Close button
		driver.findElement(By.xpath("//span[.='x' and @title='close']")).click();
	}

	@Test(priority=25)
	public void OT_Settings_Method_openpage() throws Exception
		{
			
			Thread.sleep(3000);
			//Enter the URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"overtime");
			
			Thread.sleep(3000);
			
			//Check weather the OT Settings page is loaded or not
			if(driver.findElement(By.xpath("//a[.='Overtime Settings']")).getText().equalsIgnoreCase("Overtime Settings"))
			{
				test.log(LogStatus.PASS, "OT Settings page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "OT Settings page loaded fail");
			}

			Thread.sleep(3000);

		}	
		
	@Test(priority=26)
	public void OT_Settings_Method_add() throws Exception
		{
			
			Thread.sleep(1000);
			//Click the refresh button
			driver.findElement(By.xpath("//i[@ uib-tooltip='refresh']")).click();
			
			Thread.sleep(2000);
			//Click the Add OT settings button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/button")).click();
			Thread.sleep(2000);
			
			//Check weather the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New OT Settings']")).getText().equalsIgnoreCase("New OT Settings"))
			{
				test.log(LogStatus.PASS, "New OT Settings form or page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New OT Settings form or page loaded fail");
			}
			
			Thread.sleep(2000);
			//Select the OT
			Select overTime = new Select(driver.findElement(By.xpath("//select[@ng-model='storeOT.type']")));
			overTime.selectByVisibleText("Daily");
			
			//Clear the hours field
			driver.findElement(By.name("hours")).clear();
			//Enter the hours
			driver.findElement(By.name("hours")).sendKeys("2");
			
			Thread.sleep(2000);
			//Clear the percentage field
			driver.findElement(By.name("percentage")).clear();
			//Enter the percentage
			driver.findElement(By.name("percentage")).sendKeys("102");
			
			
			Thread.sleep(2000);
			//Clear the effectiveDate field
			driver.findElement(By.name("effectiveDate")).clear();
			//Enter the effectiveDate
			driver.findElement(By.name("effectiveDate")).sendKeys(Utility.getProperty("OT_Settings_Date"));
				
			Thread.sleep(1000);
			//Click the Save button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			
			//Check weather the new OT form saved or not
			if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("OT saved successfully"))
			{
				test.log(LogStatus.PASS, "New OT saved successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New OT saved fail");
			}
			Thread.sleep(4000);
			
			//get the number of rows
			List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div[2]/div/table/tbody/tr"));
			rows.size();
			
			for(int i = rows.size()-1 ; i == rows.size()-1; i-- )
			{
				//Print the date
				System.out.println("The Effective Date is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td[1]")).getText());
				test.log(LogStatus.INFO, "The Effective Date is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td[1]")).getText());
				
				//Print the Type
				System.out.println("The OT Type is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td[2]")).getText());
				test.log(LogStatus.INFO, "The OT Type is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td[2]")).getText());
				
				//Print the Hour
				System.out.println("OT Hour is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td[3]")).getText());
				test.log(LogStatus.INFO, "OT Hour is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td[3]")).getText());
				
				//Print the Percentage
				System.out.println("The Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td[4]")).getText());
				test.log(LogStatus.INFO, "The Percentage is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td[4]")).getText());
			
			}
		}
		
	@Test(priority=27)
	public void OT_Settings_Method_close_Button() throws Exception
		{
			Thread.sleep(2000);
			//Click the Add OT settings button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/button")).click();
			Thread.sleep(2000);
			
			//Check weather the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New OT Settings']")).getText().equalsIgnoreCase("New OT Settings"))
			{
				test.log(LogStatus.PASS, "New OT Settings form or page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New OT Settings form or page loaded fail");
			}
			
			Thread.sleep(2000);
			//Select the OT
			Select overTime = new Select(driver.findElement(By.xpath("//select[@ng-model='storeOT.type']")));
			overTime.selectByVisibleText("Daily");
			
			//Clear the hours field
			driver.findElement(By.name("hours")).clear();
			//Enter the hours
			driver.findElement(By.name("hours")).sendKeys("2");
			
			Thread.sleep(2000);
			//Clear the percentage field
			driver.findElement(By.name("percentage")).clear();
			//Enter the percentage
			driver.findElement(By.name("percentage")).sendKeys("102");
			
			
			Thread.sleep(2000);
			//Clear the effectiveDate field
			driver.findElement(By.name("effectiveDate")).clear();
			//Enter the effectiveDate
			driver.findElement(By.name("effectiveDate")).sendKeys("20-Jul-2020");

			Thread.sleep(1000);
			//Click the Close button
			driver.findElement(By.xpath("//a[.='Close']")).click();
			Thread.sleep(2000);
			
			//Check weather the new emv settings form closed or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/button")).isDisplayed())
			{
				test.log(LogStatus.PASS, "OT Settings form Closed successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "OT Settings form Closed fail");
			}
			Thread.sleep(5000);
			watchTutorial();
			Thread.sleep(5000);
		}

}
