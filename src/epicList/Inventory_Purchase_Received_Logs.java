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

public class Inventory_Purchase_Received_Logs {
	
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory_Received_Logs");

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
	
	@Test(priority=17)
	public void Inventory_Purchase_Received_Logs_openpage() throws Exception
	{
		/*//Click the Inventory option
		driver.findElement(By.xpath("//span[.='Inventory']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[contains(.,'Purchases')]"));
		//Scroll the page till the Inventory Menu Items option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Purchases Option		
		driver.findElement(By.xpath("//span[contains(.,'Purchases')]")).click();
		Thread.sleep(5000);
		
        //Click the Purchases Order Option		
		driver.findElement(By.xpath("//span[contains(.,'Received Logs')]")).click();
		Thread.sleep(5000);
		*/
		Thread.sleep(5000);
		//Get the URl
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"receivedLogs");
				
				
		//Check Storage Locations page opened or not
		if(driver.findElement(By.xpath("//a[.='Received Log']")).getText().equalsIgnoreCase("Received Log"))
		{
			test.log(LogStatus.PASS, "Received Log page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Received Log page loaded Failed");
		}
		
		Thread.sleep(5000);
	}
	
	@Test(priority=18)
	public void Inventory_Purchase_Received_Logs_verify_All_All() throws Exception
	{
		Thread.sleep(5000);
		//Select the Required Type
		Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
		type.selectByVisibleText("All");
		
		Thread.sleep(2000);
		//Select the Consumption Option
		Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[2]/div/div/select")));
		consumptionStatus.selectByVisibleText("All");
		
		Thread.sleep(2000);
		//Select the Time Period Option
		Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
		timePeriod.selectByVisibleText("Date Range");
		
		Thread.sleep(1500);
		//Clear the Date Range from Option
		driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

		Thread.sleep(1500);
		//Clear the Date Range To Option
		driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
		
		Thread.sleep(1000);
		//Click the Search button
		driver.findElement(By.xpath("//button[.='Search']")).click();
		
		Thread.sleep(10000);
		try
		{
			//Check whether the Received Items are Loaded Or not
			if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for All(All)");
			}
		}
		catch(Exception e)//else// if(driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr/td[1]")) != null)
		{
			test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for All(All)");
			test.log(LogStatus.INFO, "**********   The below is for All filter data   **********");
			List<WebElement> data = driver.findElements(By.xpath("//table[@ng-table='tableParams']/tbody/tr/td[1]"));
			data.size();
			
			for(int i=1;i<=data.size();i++)
			{
				test.log(LogStatus.INFO, "Name : "+driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[1]")).getText()+", Type : "+driver.findElement(By.xpath("//table[@ng-table='tableParams']/tbody/tr["+i+"]/td[2]")).getText());
			}
			
		}
/*		else
		{
			test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for All(All)");
		}*/
					
	}
	
	@Test(priority=19)
	public void Inventory_Purchase_Received_Logs_verify_All_NotStarted() throws Exception
	{
		Thread.sleep(5000);
		//Select the Required Type
		Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
		type.selectByVisibleText("All");
		
		Thread.sleep(2000);
		//Select the Consumption Option
		Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[2]/div/div/select")));
		consumptionStatus.selectByVisibleText("Not Started");
		
		Thread.sleep(2000);
		//Select the Time Period Option
		Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
		timePeriod.selectByVisibleText("Date Range");
		
		Thread.sleep(1500);
		//Clear the Date Range from Option
		driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

		Thread.sleep(1500);
		//Clear the Date Range To Option
		driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
		
		Thread.sleep(1000);
		//Click the Search button
		driver.findElement(By.xpath("//button[.='Search']")).click();
		
		Thread.sleep(10000);
		//Check whether the Received Items are Loaded Or not
		try
		{
			if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Not Started(All)");
			}
		}
		catch (Exception e)
		{
		
			test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Not Started(All)");			
		
		}

					
	}
	
	@Test(priority=20)
	public void Inventory_Purchase_Received_Logs_verify_All_Progress() throws Exception
	{
		Thread.sleep(5000);
		//Select the Required Type
		Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
		type.selectByVisibleText("All");
		
		Thread.sleep(2000);
		//Select the Consumption Option
		Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[2]/div/div/select")));
		consumptionStatus.selectByVisibleText("Progress");
		
		Thread.sleep(2000);
		//Select the Time Period Option
		Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
		timePeriod.selectByVisibleText("Date Range");
		
		Thread.sleep(1500);
		//Clear the Date Range from Option
		driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

		Thread.sleep(1500);
		//Clear the Date Range To Option
		driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
		
		Thread.sleep(1000);
		//Click the Search button
		driver.findElement(By.xpath("//button[.='Search']")).click();
		
		Thread.sleep(10000);
		//Check whether the Received Items are Loaded Or not
		try
		{
			if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Progress(All)");
			}
		}
		catch (Exception e)
		{
		
			test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Progress(All)");			
		
		}
					
	}
	
	@Test(priority=21)
	public void Inventory_Purchase_Received_Logs_verify_All_Finished() throws Exception
	{
		Thread.sleep(5000);
		//Select the Required Type
		Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
		type.selectByVisibleText("All");
		
		Thread.sleep(2000);
		//Select the Consumption Option
		Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[2]/div/div/select")));
		consumptionStatus.selectByVisibleText("Finished");
		
		Thread.sleep(2000);
		//Select the Time Period Option
		Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
		timePeriod.selectByVisibleText("Date Range");
		
		Thread.sleep(1500);
		//Clear the Date Range from Option
		driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

		Thread.sleep(1500);
		//Clear the Date Range To Option
		driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
		
		Thread.sleep(1000);
		//Click the Search button
		driver.findElement(By.xpath("//button[.='Search']")).click();
		
		Thread.sleep(10000);
		//Check whether the Received Items are Loaded Or not
		try
		{
			if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Finished(All)");
			}
		}
		catch (Exception e)
		{
			test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Finished(All)");			
		}

					
	}
	
	@Test(priority=22)
	public void Inventory_Purchase_Received_Logs_verify_All_NotFinished() throws Exception
	{
		Thread.sleep(5000);
		//Select the Required Type
		Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
		type.selectByVisibleText("All");
		
		Thread.sleep(2000);
		//Select the Consumption Option
		Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[2]/div/div/select")));
		consumptionStatus.selectByVisibleText("Not Finished");
		
		Thread.sleep(2000);
		//Select the Time Period Option
		Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
		timePeriod.selectByVisibleText("Date Range");
		
		Thread.sleep(1500);
		//Clear the Date Range from Option
		driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[4]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

		Thread.sleep(1500);
		//Clear the Date Range To Option
		driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[4]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
		
		Thread.sleep(1000);
		//Click the Search button
		driver.findElement(By.xpath("//button[.='Search']")).click();
		
		Thread.sleep(10000);
		//Check whether the Received Items are Loaded Or not
		try
		{
			if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Not Finished(All)");
			}
		}
		catch (Exception e)
		{
			test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Not Finished(All)");			
		}

					
	}
	
	@Test(priority=23)
	public void Inventory_Purchase_Received_Logs_verify_Inv_All() throws Exception
	{
		Thread.sleep(5000);
		//Select the Required Type
		Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
		type.selectByVisibleText("Inventory Item");
		
		Thread.sleep(1000);
		//Click the Category Option
		driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
		//Enter the required Keyword
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
		//Press the Enter button
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Inventory Item Option
		driver.findElement(By.xpath("//form/div[3]/div/div/div/a")).click();
		//Enter the required Keyword
		driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys("All");
		//Press the Enter button
		driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Select the Consumption Option
		Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
		consumptionStatus.selectByVisibleText("All");
		
		Thread.sleep(2000);
		//Select the Time Period Option
		Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[5]/div/div/select")));
		timePeriod.selectByVisibleText("Date Range");
		
		Thread.sleep(1500);
		//Clear the Date Range from Option
		driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

		Thread.sleep(1500);
		//Clear the Date Range To Option
		driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
		
		Thread.sleep(1000);
		//Click the Search button
		driver.findElement(By.xpath("//button[.='Search']")).click();
		
		Thread.sleep(10000);
		//Check whether the Received Items are Loaded Or not
		try
		{
			if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for All(Inventory Item)");
			}
		}
		catch (Exception e)
		{
			test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for All(Inventory Item)");			
		}

					
	}
	
	@Test(priority=24)
	public void Inventory_Purchase_Received_Logs_verify_Inv_NotStarted() throws Exception
	{
		Thread.sleep(5000);
		//Select the Required Type
		Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
		type.selectByVisibleText("Inventory Item");
		
		Thread.sleep(1000);
		//Click the Category Option
		driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
		//Enter the required Keyword
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
		//Press the Enter button
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Inventory Item Option
		driver.findElement(By.xpath("//form/div[3]/div/div/div/a")).click();
		//Enter the required Keyword
		driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys("All");
		//Press the Enter button
		driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Select the Consumption Option
		Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
		consumptionStatus.selectByVisibleText("Not Started");
		
		Thread.sleep(2000);
		//Select the Time Period Option
		Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[5]/div/div/select")));
		timePeriod.selectByVisibleText("Date Range");
		
		Thread.sleep(1500);
		//Clear the Date Range from Option
		driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

		Thread.sleep(1500);
		//Clear the Date Range To Option
		driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
		
		Thread.sleep(1000);
		//Click the Search button
		driver.findElement(By.xpath("//button[.='Search']")).click();
		
		Thread.sleep(10000);
		//Check whether the Received Items are Loaded Or not
		try
		{
			if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Not Started(Inventory Item)");
			}
		}
		catch (Exception e)
		{
			test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Not Started(Inventory Item)");			
		}

					
	}
	
	@Test(priority=25)
	public void Inventory_Purchase_Received_Logs_verify_Inv_Progress() throws Exception
	{
		Thread.sleep(5000);
		//Select the Required Type
		Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
		type.selectByVisibleText("Inventory Item");
		
		Thread.sleep(1000);
		//Click the Category Option
		driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
		//Enter the required Keyword
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
		//Press the Enter button
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Inventory Item Option
		driver.findElement(By.xpath("//form/div[3]/div/div/div/a")).click();
		//Enter the required Keyword
		driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys("All");
		//Press the Enter button
		driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Select the Consumption Option
		Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
		consumptionStatus.selectByVisibleText("Progress");
		
		Thread.sleep(2000);
		//Select the Time Period Option
		Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[5]/div/div/select")));
		timePeriod.selectByVisibleText("Date Range");
		
		Thread.sleep(1500);
		//Clear the Date Range from Option
		driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

		Thread.sleep(1500);
		//Clear the Date Range To Option
		driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
		
		Thread.sleep(1000);
		//Click the Search button
		driver.findElement(By.xpath("//button[.='Search']")).click();
		
		Thread.sleep(10000);
		//Check whether the Received Items are Loaded Or not
		try
		{
			if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Progress(Inventory Item)");
			}
		}
		catch (Exception e)
		{
			test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Progress(Inventory Item)");			
		}

					
	}
	
	@Test(priority=26)
	public void Inventory_Purchase_Received_Logs_verify_Inv_Finished() throws Exception
	{
		Thread.sleep(5000);
		//Select the Required Type
		Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
		type.selectByVisibleText("Inventory Item");
		
		Thread.sleep(1000);
		//Click the Category Option
		driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
		//Enter the required Keyword
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
		//Press the Enter button
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Inventory Item Option
		driver.findElement(By.xpath("//form/div[3]/div/div/div/a")).click();
		//Enter the required Keyword
		driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys("All");
		//Press the Enter button
		driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Select the Consumption Option
		Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
		consumptionStatus.selectByVisibleText("Finished");
		
		Thread.sleep(2000);
		//Select the Time Period Option
		Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[5]/div/div/select")));
		timePeriod.selectByVisibleText("Date Range");
		
		Thread.sleep(1500);
		//Clear the Date Range from Option
		driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

		Thread.sleep(1500);
		//Clear the Date Range To Option
		driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
		
		Thread.sleep(1000);
		//Click the Search button
		driver.findElement(By.xpath("//button[.='Search']")).click();
		
		Thread.sleep(10000);
		//Check whether the Received Items are Loaded Or not
		try
		{
			if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Finished(Inventory Item)");
			}
		}
		catch (Exception e)
		{
			test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Finished(Inventory Item)");			
		}

					
	}
	
	@Test(priority=27)
	public void Inventory_Purchase_Received_Logs_verify_Inv_NotFinished() throws Exception
	{
		Thread.sleep(5000);
		//Select the Required Type
		Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
		type.selectByVisibleText("Inventory Item");
		
		Thread.sleep(1000);
		//Click the Category Option
		driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
		//Enter the required Keyword
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
		//Press the Enter button
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Inventory Item Option
		driver.findElement(By.xpath("//form/div[3]/div/div/div/a")).click();
		//Enter the required Keyword
		driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys("All");
		//Press the Enter button
		driver.findElement(By.xpath("//form/div[3]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Select the Consumption Option
		Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
		consumptionStatus.selectByVisibleText("Not Finished");
		
		Thread.sleep(2000);
		//Select the Time Period Option
		Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[5]/div/div/select")));
		timePeriod.selectByVisibleText("Date Range");
		
		Thread.sleep(1500);
		//Clear the Date Range from Option
		driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[6]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

		Thread.sleep(1500);
		//Clear the Date Range To Option
		driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[6]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
		
		Thread.sleep(1000);
		//Click the Search button
		driver.findElement(By.xpath("//button[.='Search']")).click();
		
		Thread.sleep(10000);
		//Check whether the Received Items are Loaded Or not
		try
		{
			if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Not Finished(Inventory Item)");
			}
		}
		catch (Exception e)
		{
			test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Not Finished(Inventory Item)");			
		}
					
	}
	
	@Test(priority=28)
	public void Inventory_Purchase_Received_Logs_verify_SubRecipe_All() throws Exception
	{
		Thread.sleep(5000);
		//Select the Required Type
		Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
		type.selectByVisibleText("Sub Recipe");
		
		Thread.sleep(1000);
		//Click the Sub Recipe Option
		driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
		//Enter the required Keyword
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
		//Press the Enter button
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(2000);
		//Select the Consumption Option
		Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
		consumptionStatus.selectByVisibleText("All");
		
		Thread.sleep(2000);
		//Select the Time Period Option
		Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
		timePeriod.selectByVisibleText("Date Range");
		
		Thread.sleep(1500);
		//Clear the Date Range from Option
		driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

		Thread.sleep(1500);
		//Clear the Date Range To Option
		driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
		
		Thread.sleep(1000);
		//Click the Search button
		driver.findElement(By.xpath("//button[.='Search']")).click();
		
		Thread.sleep(10000);
		//Check whether the Received Items are Loaded Or not
		try
		{
			if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for All(Sub Recipe)");
			}
		}
		catch (Exception e)
		{
			test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for All(Sub Recipe)");			
		}

					
	}
	
	@Test(priority=29)
	public void Inventory_Purchase_Received_Logs_verify_SubRecipe_NotStarted() throws Exception
	{
		Thread.sleep(5000);
		//Select the Required Type
		Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
		type.selectByVisibleText("Sub Recipe");
		
		Thread.sleep(1000);
		//Click the Sub Recipe Option
		driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
		//Enter the required Keyword
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
		//Press the Enter button
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(2000);
		//Select the Consumption Option
		Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
		consumptionStatus.selectByVisibleText("Not Started");
		
		Thread.sleep(2000);
		//Select the Time Period Option
		Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
		timePeriod.selectByVisibleText("Date Range");
		
		Thread.sleep(1500);
		//Clear the Date Range from Option
		driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

		Thread.sleep(1500);
		//Clear the Date Range To Option
		driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
		
		Thread.sleep(1000);
		//Click the Search button
		driver.findElement(By.xpath("//button[.='Search']")).click();
		
		Thread.sleep(10000);
		//Check whether the Received Items are Loaded Or not
		try
		{
			if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Not Started(Sub Recipe)");
			}
		}
		catch (Exception e)
		{
			test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Not Started(Sub Recipe)");			
		}

					
	}
	
	@Test(priority=30)
	public void Inventory_Purchase_Received_Logs_verify_SubRecipe_Progress() throws Exception
	{
		Thread.sleep(5000);
		//Select the Required Type	
		Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
		type.selectByVisibleText("Sub Recipe");
		
		Thread.sleep(1000);
		//Click the Sub Recipe Option
		driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
		//Enter the required Keyword
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
		//Press the Enter button
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(2000);
		//Select the Consumption Option
		Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
		consumptionStatus.selectByVisibleText("Progress");
		
		Thread.sleep(2000);
		//Select the Time Period Option
		Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
		timePeriod.selectByVisibleText("Date Range");
		
		Thread.sleep(1500);
		//Clear the Date Range from Option
		driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

		Thread.sleep(1500);
		//Clear the Date Range To Option
		driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
		
		Thread.sleep(1000);
		//Click the Search button
		driver.findElement(By.xpath("//button[.='Search']")).click();
		
		Thread.sleep(10000);
		//Check whether the Received Items are Loaded Or not
		try
		{
			if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Progress(Sub Recipe)");
			}
		}
		catch (Exception e)
		{
			test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Progress(Sub Recipe)");			
		}
					
	}
	
	@Test(priority=31)
	public void Inventory_Purchase_Received_Logs_verify_SubRecipe_Finished() throws Exception
	{
		Thread.sleep(5000);
		//Select the Required Type	
		Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
		type.selectByVisibleText("Sub Recipe");
		
		Thread.sleep(1000);
		//Click the Sub Recipe Option
		driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
		//Enter the required Keyword
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
		//Press the Enter button
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(2000);
		//Select the Consumption Option
		Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
		consumptionStatus.selectByVisibleText("Finished");
		
		Thread.sleep(2000);
		//Select the Time Period Option
		Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
		timePeriod.selectByVisibleText("Date Range");
		
		Thread.sleep(1500);
		//Clear the Date Range from Option
		driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

		Thread.sleep(1500);
		//Clear the Date Range To Option
		driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
		
		Thread.sleep(1000);
		//Click the Search button
		driver.findElement(By.xpath("//button[.='Search']")).click();
		
		Thread.sleep(10000);
		//Check whether the Received Items are Loaded Or not
		try
		{
			if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Finished(Sub Recipe)");
			}
		}
		catch (Exception e)
		{
			test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Finished(Sub Recipe)");			
		}

					
	}
	
	@Test(priority=32)
	public void Inventory_Purchase_Received_Logs_verify_SubRecipe_NotFinished() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Select the Required Type	
		Select type = new Select(driver.findElement(By.xpath("//form/div[1]/div/div/select")));
		type.selectByVisibleText("Sub Recipe");
		
		Thread.sleep(1000);
		//Click the Sub Recipe Option
		driver.findElement(By.xpath("//form/div[2]/div/div/div/a")).click();
		//Enter the required Keyword
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys("All");
		//Press the Enter button
		driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(2000);
		//Select the Consumption Option
		Select consumptionStatus = new Select(driver.findElement(By.xpath("//form/div[3]/div/div/select")));
		consumptionStatus.selectByVisibleText("Not Finished");
		
		Thread.sleep(2000);
		//Select the Time Period Option
		Select timePeriod = new Select(driver.findElement(By.xpath("//form/div[4]/div/div/select")));
		timePeriod.selectByVisibleText("Date Range");
		
		Thread.sleep(1500);
		//Clear the Date Range from Option
		driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[5]/div/div/input[1]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_From_Date"));

		Thread.sleep(1500);
		//Clear the Date Range To Option
		driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).clear();
		//Enter the required
		driver.findElement(By.xpath("//form/div[5]/div/div/input[2]")).sendKeys(Utility.getProperty("Inventory_Received_Logs_To_Date"));
		
		Thread.sleep(1000);
		//Click the Search button
		driver.findElement(By.xpath("//button[.='Search']")).click();
		
		Thread.sleep(10000);
		//Check whether the Received Items are Loaded Or not
		try
		{
			if(driver.findElement(By.xpath("//td[.='No purchase record for selected item or time period']")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "There is no record available for the Selected Time Period for Not Finished(Sub Recipe)");
			}
		}
		catch (Exception e)
		{
			test.log(LogStatus.PASS, "Received Item Log is available for the Selected time period for Not Finished(Sub Recipe)");			
		}
	}	

}
