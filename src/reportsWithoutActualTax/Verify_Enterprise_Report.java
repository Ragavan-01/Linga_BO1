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

public class Verify_Enterprise_Report {

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Verify_Enterprise_Report");

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
	public void open_Enterprise_Report() throws Exception
	{
		//Click the My Stores option
		driver.findElement(By.xpath("//span[.='My Stores']")).click();

		Thread.sleep(3000);
        //Click the EnterPrise Reports Option		
		driver.findElement(By.xpath("//span[.='EnterPrise Reports']")).click();
		
		Thread.sleep(2000);
		//Click the Sale option
		driver.findElement(By.xpath("//span[.='Sale']")).click();
		
		Thread.sleep(5000);
		//Check Consolidated Report page opened or not
		if(driver.findElement(By.xpath("//a[.='Consolidated Report']")).getText().equalsIgnoreCase("Consolidated Report"))
		{
			test.log(LogStatus.PASS, "Consolidated Report page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Consolidated Report page loaded Failed");
		}
		
		Thread.sleep(3000);
		
	}
	
	@Test(priority=4)
	public void view_Enterprise_Report_Stores() throws Exception
	{

		Thread.sleep(2000);
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

		Thread.sleep(3000);
		System.out.println("********************* View The Store Report *************************");
		test.log(LogStatus.INFO, "********************* View The Store Report *************************");
		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Stores");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1500);
		//Click the Select Some Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Store"));
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1500);
		//Click the Time Period Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		try
		{
			//Check whether the Net sale is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText().equalsIgnoreCase(Utility.getReportProperty("Store")))
			{
				test.log(LogStatus.PASS, "Enterprise Report is avilable for the selected Time Period");
				
				//Get the rows count
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr"));
				rows.size();
				
				//Get the columns count
				List<WebElement> columns = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[2]/td"));
				columns.size();
				
				for(int i = 2; i < rows.size() ; i++)
				{
					for(int j = 2; j <= columns.size() ; j++)
					{
						System.out.println(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+i+"]/td[1]")).getText()+" contain the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[1]/th["+j+"]")).getText()+" Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td["+j+"]")).getText());
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+i+"]/td[1]")).getText()+" contain the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[1]/th["+j+"]")).getText()+" Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td["+j+"]")).getText());
					}
				}
					
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Enterprise Report is not available");
		}
				
		Thread.sleep(3000);
		System.out.println("********************* End of Store Report *************************");
		test.log(LogStatus.INFO, "********************* End of Store Report *************************");

		
	}
	
	@Test(priority=5)
	public void view_Enterprise_Report_Group() throws Exception
	{

		Thread.sleep(3000);
		System.out.println("********************* View The Group Report *************************");
		test.log(LogStatus.INFO, "********************* View The Store Report *************************");
		
		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1500);
		//Click the Select Some Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys("TestGroup");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1500);
		//Click the Time Period Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		try
		{
			//Check whether the Net sale is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText().equalsIgnoreCase(Utility.getReportProperty("Store")))
			{
				test.log(LogStatus.PASS, "Enterprise Report is avilable for the selected Time Period");
				
				//Get the rows count
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr"));
				rows.size();
				
				//Get the columns count
				List<WebElement> columns = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[2]/td"));
				columns.size();
				
				for(int i = 2; i < rows.size() ; i++)
				{
					for(int j = 2; j <= columns.size() ; j++)
					{
						System.out.println(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+i+"]/td[1]")).getText()+" contain the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[1]/th["+j+"]")).getText()+" Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td["+j+"]")).getText());
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+i+"]/td[1]")).getText()+" contain the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[1]/th["+j+"]")).getText()+" Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td["+j+"]")).getText());
					}
				}
					
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Enterprise Report is not available");
		}
				
		
		Thread.sleep(3000);
		System.out.println("********************* End of Group Report *************************");
		test.log(LogStatus.INFO, "********************* End of Group Report *************************");
	}
	
	@Test(priority=6)
	public void view_Enterprise_Report_City() throws Exception
	{

		Thread.sleep(3000);
		System.out.println("********************* View The City Report *************************");
		test.log(LogStatus.INFO, "********************* View The City Report *************************");

		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("City");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1500);
		//Click the Select Some Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys("Chennai");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1500);
		//Click the Time Period Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		try
		{
			//Check whether the Net sale is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText().equalsIgnoreCase(Utility.getReportProperty("Store")))
			{
				test.log(LogStatus.PASS, "Enterprise Report is avilable for the selected Time Period");
				
				//Get the rows count
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr"));
				rows.size();
				
				//Get the columns count
				List<WebElement> columns = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[2]/td"));
				columns.size();
				
				for(int i = 2; i < rows.size() ; i++)
				{
					for(int j = 2; j <= columns.size() ; j++)
					{
						System.out.println(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+i+"]/td[1]")).getText()+" contain the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[1]/th["+j+"]")).getText()+" Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td["+j+"]")).getText());
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+i+"]/td[1]")).getText()+" contain the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[1]/th["+j+"]")).getText()+" Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td["+j+"]")).getText());
					}
				}
					
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Enterprise Report is not available");
		}
						
		Thread.sleep(3000);
		System.out.println("********************* End of City Report *************************");
		test.log(LogStatus.INFO, "********************* End of City Report *************************");
	}
	
	@Test(priority=7)
	public void view_Enterprise_Report_State() throws Exception
	{

		Thread.sleep(3000);
		System.out.println("********************* View The State Report *************************");
		test.log(LogStatus.INFO, "********************* View The State Report *************************");

		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("State");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1500);
		//Click the Select Some Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys("Tamil Nadu");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1500);
		//Click the Time Period Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		try
		{
			//Check whether the Net sale is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText().equalsIgnoreCase(Utility.getReportProperty("Store")))
			{
				test.log(LogStatus.PASS, "Enterprise Report is avilable for the selected Time Period");
				
				//Get the rows count
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr"));
				rows.size();
				
				//Get the columns count
				List<WebElement> columns = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[2]/td"));
				columns.size();
				
				for(int i = 2; i < rows.size() ; i++)
				{
					for(int j = 2; j <= columns.size() ; j++)
					{
						System.out.println(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+i+"]/td[1]")).getText()+" contain the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[1]/th["+j+"]")).getText()+" Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td["+j+"]")).getText());
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+i+"]/td[1]")).getText()+" contain the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[1]/th["+j+"]")).getText()+" Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td["+j+"]")).getText());
					}
				}
					
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Enterprise Report is not available");
		}
				
		
		Thread.sleep(3000);
		System.out.println("********************* End of State Report *************************");
		test.log(LogStatus.INFO, "********************* End of State Report *************************");
	}
	
	@Test(priority=8)
	public void view_Enterprise_Report_ZipCode() throws Exception
	{

		Thread.sleep(3000);
		System.out.println("********************* View The Zip Code Report *************************");
		test.log(LogStatus.INFO, "********************* View The Zip Code Report *************************");
		
		//Click the Select option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the required filter
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Zip Code");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1500);
		//Click the Select Some Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys("600106");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1500);
		//Click the Time Period Options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[2]/div/div/a")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		//Clear the date field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		try
		{
			//Check whether the Net sale is available or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[2]/td[1]")).getText().equalsIgnoreCase(Utility.getReportProperty("Store")))
			{
				test.log(LogStatus.PASS, "Enterprise Report is avilable for the selected Time Period");
				
				//Get the rows count
				List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr"));
				rows.size();
				
				//Get the columns count
				List<WebElement> columns = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[2]/td"));
				columns.size();
				
				for(int i = 2; i < rows.size() ; i++)
				{
					for(int j = 2; j <= columns.size() ; j++)
					{
						System.out.println(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+i+"]/td[1]")).getText()+" contain the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[1]/th["+j+"]")).getText()+" Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td["+j+"]")).getText());
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+i+"]/td[1]")).getText()+" contain the "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr[1]/th["+j+"]")).getText()+" Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td["+j+"]")).getText());
					}
				}
					
			}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Enterprise Report is not available");
		}
				
		
		Thread.sleep(3000);
		System.out.println("********************* End of Zip Code Report *************************");
		test.log(LogStatus.INFO, "********************* End of Zip Code Report *************************");

	}


}
