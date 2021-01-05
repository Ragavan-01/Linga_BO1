package epicList;

import java.text.DecimalFormat;
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

public class Royalty_Franchise_Royalty_Report {
	public WebDriver driver;
		
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Royalty_Franchise_Royalty_Report");

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
	
	@Test(priority=14)
	public void Enterprice_Royalty_Franchise_Settings_method_open_Enterprice_Royalty_Franchise_Royalty_Report() throws Exception
	{
		/*driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		//Click the My Stores option
		driver.findElement(By.xpath("//span[.='My Stores']")).click();
		

		Thread.sleep(3000);
        //Click the Royalty/Franchise Option		
		driver.findElement(By.xpath("//span[.='Royalty/Franchise']")).click();
		
		Thread.sleep(5000);
		//Check Royalty/Franchise page opened or not
		if(driver.findElement(By.xpath("//a[.='Royalty/Franchise']")).getText().equalsIgnoreCase("Royalty/Franchise"))
		{
			test.log(LogStatus.PASS, "Royalty/Franchise Settings page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Royalty/Franchise Settings page loaded Failed");
		}
		*/
		Thread.sleep(3000);
		//Enter the Coursing URL
		driver.get(Utility.getProperty("Enterprise_Base_URL")+"royaltyReport");

		Thread.sleep(2500);
		
		//Check Royalty Report page opened or not
		if(driver.findElement(By.xpath("//a[.='Royalty Report']")).getText().equalsIgnoreCase("Royalty Report"))
		{
			test.log(LogStatus.PASS, "Royalty Report page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report page loaded Failed");
		}
		Thread.sleep(3000);
	}

	@Test(priority=15)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_Store() throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Stores");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Store"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Store");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Store");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount(Store) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount(Store) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee(Store) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee(Store) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee(Store) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee(Store) is Incorrect");
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Store");
		}
		
	}
	
	@Test(priority=16)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_Group() throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Group"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Group");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Group");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount(Group) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount(Group) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee(Group) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee(Group) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee(Group) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee(Group) is Incorrect");
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Group");
		}
		Thread.sleep(3000);
	}

	@Test(priority=17)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_City() throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("City");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("City"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for City");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for City");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount(City) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount(City) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee(City) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee(City) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee(City) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee(City) is Incorrect");
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for City");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=18)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_State() throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("State");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("State"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for State");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for State");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount(State) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount(State) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee(State) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee(State) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee(State) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee(State) is Incorrect");
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for State");
		}
		Thread.sleep(3000);
	}
		
	@Test(priority=19)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_Zipcode() throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Zip Code");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Zipcode"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Zipcode");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Zipcode");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount(Zipcode) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount(Zipcode) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee(Zipcode) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee(Zipcode) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee(Zipcode) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee(Zipcode) is Incorrect");
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Zipcode");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=21)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_Store_With_ExcludeLoyaltyRedemtion() throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Stores");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Store"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1500);
		//Enable the ExcludeLoyaltyRedemtion button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[5]/div/div/input")).click();
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Store");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Store(With Exclude Loyalty Redemtion)");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount for Store(With Exclude Loyalty Redemtion) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount for Store(With Exclude Loyalty Redemtion) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee for Store(With Exclude Loyalty Redemtion) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee for Store(With Exclude Loyalty Redemtion) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee for Store(With Exclude Loyalty Redemtion) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee for Store(With Exclude Loyalty Redemtion) is Incorrect");
			}
				
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Store");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=22)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_Group_With_ExcludeLoyaltyRedemtion() throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Group");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Group"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1500);
		//Enable the ExcludeLoyaltyRedemtion button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[5]/div/div/input")).click();
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Group");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Group(With Exclude Loyalty Redemtion)");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount for Group(With Exclude Loyalty Redemtion) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount for Group(With Exclude Loyalty Redemtion) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee for Group(With Exclude Loyalty Redemtion) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee for Group(With Exclude Loyalty Redemtion) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee for Group(With Exclude Loyalty Redemtion) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee for Group(With Exclude Loyalty Redemtion) is Incorrect");
			}
				
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Group");
		}
		Thread.sleep(3000);
	}

	@Test(priority=23)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_City_With_ExcludeLoyaltyRedemtion() throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("City");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("City"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1500);
		//Enable the ExcludeLoyaltyRedemtion button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[5]/div/div/input")).click();
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for City");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for City(With Exclude Loyalty Redemtion)");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount for City(With Exclude Loyalty Redemtion) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount for City(With Exclude Loyalty Redemtion) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee for City(With Exclude Loyalty Redemtion) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee for City(With Exclude Loyalty Redemtion) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee for City(With Exclude Loyalty Redemtion) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee for City(With Exclude Loyalty Redemtion) is Incorrect");
			}
				
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for City");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=24)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_State_With_ExcludeLoyaltyRedemtion() throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("State");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("State"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1500);
		//Enable the ExcludeLoyaltyRedemtion button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[5]/div/div/input")).click();
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for State");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for State(With Exclude Loyalty Redemtion)");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount for State(With Exclude Loyalty Redemtion) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount for State(With Exclude Loyalty Redemtion) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee for State(With Exclude Loyalty Redemtion) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee for State(With Exclude Loyalty Redemtion) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee for State(With Exclude Loyalty Redemtion) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee for State(With Exclude Loyalty Redemtion) is Incorrect");
			}
				
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for state");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=25)
	public void Enterprice_Royalty_Franchise_Settings_method_Royalty_Report_Zipcode_With_ExcludeLoyaltyRedemtion() throws Exception
	{
		Thread.sleep(5000);
		//Click the First Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/a")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys("Zip code");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(1000);
		//Click the Second Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul")).click();
		//Enter the Group option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Utility.getReportProperty("Zipcode"));
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/a")).click();
		//Enter the Time option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the from date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
		//Enter the from Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
		Thread.sleep(1000);
		//Clear the To date option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
		//Enter the To Date
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(1500);
		//Enable the ExcludeLoyaltyRedemtion button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/form/div[5]/div/div/input")).click();
		
		Thread.sleep(3000);
		//Click the Run button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1500);
		
		Thread.sleep(3000);
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available  for Zipcode");
		}
		
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[1]")).getText() != null)
		{
			test.log(LogStatus.PASS, "Royalty Report is available for Zipcode(With Exclude Loyalty Redemtion)");
			
			//Get the Total amount value
			String Total_Amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[5]")).getText();
			
			float total_AMT = Float.parseFloat(Total_Amount);
			
			String Net_Sale = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[4]/table/tbody/tr[2]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ ,]", "");
			
			float netsale_AMT = Float.parseFloat(Net_Sale);
			
			//Print the Net sale value
			System.out.println("Netsale Amount for Zipcode(With Exclude Loyalty Redemtion) is : "+netsale_AMT);
			
			test.log(LogStatus.INFO, "Netsale Amount for Zipcode(With Exclude Loyalty Redemtion) is : "+netsale_AMT);	
			
			//Print the Total_Amount value
			System.out.println("Royalty Fee for Zipcode(With Exclude Loyalty Redemtion) is : "+total_AMT);
			
			test.log(LogStatus.INFO, "Royalty Fee for Zipcode(With Exclude Loyalty Redemtion) is : "+total_AMT);		
			
			float percen = (float)((netsale_AMT*5.0)/100.0);
			
		     DecimalFormat f = new DecimalFormat("##.00");
		     	    
		     String a = f.format(percen);
		     
		     float percentage = Float.parseFloat(a);
		     
			if(percentage == total_AMT)
			{
				test.log(LogStatus.PASS, "Royalty Fee for Zipcode(With Exclude Loyalty Redemtion) is Correct");
			}
			else
			{
				test.log(LogStatus.FAIL, "Royalty Fee for Zipcode(With Exclude Loyalty Redemtion) is Incorrect");
			}
				
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Royalty Report is not available for Zipcode");
		}
		Thread.sleep(3000);
	}

}
