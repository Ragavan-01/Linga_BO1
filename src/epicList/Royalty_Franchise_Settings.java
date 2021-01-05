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

public class Royalty_Franchise_Settings {


	public WebDriver driver;
		
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Royalty_Franchise_Settings");

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

	@Test(priority=8)
	public void Enterprice_Royalty_Franchise_Settings_method_open_Enterprice_Royalty_Franchise_Settings() throws Exception
	{
		/*driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		//Click the My Stores option
		driver.findElement(By.xpath("//span[.='My Stores']")).click();

		
		Thread.sleep(3000);
        //Click the Royalty/Franchise Option		
		driver.findElement(By.xpath("//span[.='Royalty/Franchise']")).click();
		

		*/
		//Enter the Coursing URL
		driver.get(Utility.getProperty("Enterprise_Base_URL")+"royalty");
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
		
	}

	@Test(priority=9)
	public void Enterprice_Royalty_Franchise_Settings_method_Pagination() throws Exception
	{

		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Pagination option as 10
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/div/div/div/ul/li[2]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Royalty/Franchise");
		//Create the web element for Account Users Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Royalty/Franchise, When user click 10");
		}
		Thread.sleep(4000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/div/div/div/ul/li[3]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Royalty/Franchise");
		//Create the web element for Account Users Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Royalty/Franchise, When user click 15");
		}
		Thread.sleep(4000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/div/div/div/ul/li[4]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20 Fran");
		//Create the web element for Account Users Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Royalty/Franchise, When user click 20");
		}
		Thread.sleep(4000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/div/div/div/ul/li[1]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Royalty/Franchise");
		//Create the web element for Account Users Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Royalty/Franchise, When user click 5");
		}
		Thread.sleep(4000);
	}

	@Test(priority=10)
	public void Enterprice_Royalty_Franchise_Settings_method_Update_Settings() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		//Search the required store
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Store"));
		
		Thread.sleep(8000);
		//Click Royalty/Franchise button is enabled or disabled
		driver.findElement(By.xpath("//td[2]/div/div/label/span")).click();
		
		Thread.sleep(1500);
		//Check whether the Royalty/Franchise button is enabled or not
		if(driver.findElement(By.xpath("//td[2]/div/div/label/input")).isSelected())
		{}
		else
		{
			Thread.sleep(2500);
			
			//Click Royalty/Franchise button is enabled or disabled
			driver.findElement(By.xpath("//td[2]/div/div/label/span")).click();
		}

		Thread.sleep(1500);
		//Enter the Bank Details
		//Clear the routing field
		driver.findElement(By.xpath("//td[3]/div[1]/input")).clear();
		//Enter the required routing name
		driver.findElement(By.xpath("//td[3]/div[1]/input")).sendKeys("Test");
		
		Thread.sleep(1500);
		//Clear the Bank Name
		driver.findElement(By.xpath("//td[3]/div[2]/input")).clear();
		//Enter the Bank Name
		driver.findElement(By.xpath("//td[3]/div[2]/input")).sendKeys("Standard");
		
		Thread.sleep(1500);
		//Clear the Account Number
		driver.findElement(By.xpath("//td[3]/div[3]/input")).clear();
		//Enter the Required Account Number
		driver.findElement(By.xpath("//td[3]/div[3]/input")).sendKeys("7458962531");
		
		//System.out.println("Per : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[4]/div/div[3]/ng-form/div/div/div[2]/div/input")).getText());
		
		Thread.sleep(2000);
		//Click the Add Percentage button
		driver.findElement(By.xpath("//td[4]/div/div[1]/div/a/i")).click();
		
		//Clear the name of percentage
		driver.findElement(By.xpath("//td[4]/div/div[3]/ng-form/div/div/div[1]/div/input")).clear();
		//Enter the name of Percentage
		driver.findElement(By.xpath("//td[4]/div/div[3]/ng-form/div/div/div[1]/div/input")).sendKeys("Employee");
	
		Thread.sleep(1500);
		//Clear the percentage
		driver.findElement(By.xpath("//td[4]/div/div[3]/ng-form/div/div/div[2]/div/input")).clear();
		//Enter the percentage
		driver.findElement(By.xpath("//td[4]/div/div[3]/ng-form/div/div/div[2]/div/input")).sendKeys("5");
		
		Thread.sleep(1000);
		//Enable or Disable the Set Default in the newly add percentage option
		driver.findElement(By.xpath("//td[4]/div/div[3]/ng-form/div/div/div[3]/label/span")).click();

		Thread.sleep(2000);
		//Click the Add Percentage button
		driver.findElement(By.xpath("//td[4]/div/div[1]/div/a/i")).click();
		
		Thread.sleep(1000);
		//Clear the name of percentage
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[1]/div/input")).clear();
		//Enter the name of Percentage
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[1]/div/input")).sendKeys("Employee");
		
		//Clear the percentage
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[2]/div/input")).clear();
		//Enter the percentage
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[2]/div/input")).sendKeys("50");
		
		Thread.sleep(1000);
		//Enable or Disable the Set Default in the newly add percentage option
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[3]/label/span")).click();
		
		Thread.sleep(3000);
		//Check whether the error or warning message displayed or not
		if(driver.findElement(By.xpath("//p[.='Select only one as default']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Error message showed successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Error message showed fail");
		}
		Thread.sleep(1000);
		//Enable or Disable the Set Default in the newly add percentage option
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[3]/label/span")).click();

		Thread.sleep(2000);
		//Click the Add Percentage button
		driver.findElement(By.xpath("//td[4]/div/div[1]/div/a/i")).click();

		Thread.sleep(2000);
		//Click the Close button of newly added one
		driver.findElement(By.xpath("//td[4]/div/div[5]/ng-form/div/div/div[3]/a/i")).click();
		
		Thread.sleep(1000);
		//Click the Yes button
		driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
		
		Thread.sleep(2000);
		//Click the Save button in Controls field
		driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
		
		Thread.sleep(2500);
		//Check whether the account user is saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Royalty details updated successfully."))
		{
			test.log(LogStatus.PASS, "Royalty/Franchise updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Royalty/Franchise updated fail");
		}
		
		Thread.sleep(3000);
		
		Thread.sleep(2000);
		//Click the Close button of newly added one
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[3]/a/i")).click();
		
		Thread.sleep(1000);
		//Click the Yes button
		driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
		
		Thread.sleep(2000);
		//Click the Save button in Controls field
		driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
		Thread.sleep(3000);
		
		
	}
	
	@Test(priority=11)
	public void Enterprice_Royalty_Franchise_Settings_method_Close_Button() throws Exception
	{

		Thread.sleep(3500);
		//Enter the Bank Details
		//Clear the routing field
		driver.findElement(By.xpath("//td[3]/div[1]/input")).clear();
		//Enter the required routing name
		driver.findElement(By.xpath("//td[3]/div[1]/input")).sendKeys("Test");
		
		Thread.sleep(1500);
		//Clear the Bank Name
		driver.findElement(By.xpath("//td[3]/div[2]/input")).clear();
		//Enter the Bank Name
		driver.findElement(By.xpath("//td[3]/div[2]/input")).sendKeys("Standard");
		
		Thread.sleep(1500);
		//Clear the Account Number
		driver.findElement(By.xpath("//td[3]/div[3]/input")).clear();
		//Enter the Required Account Number
		driver.findElement(By.xpath("//td[3]/div[3]/input")).sendKeys("7458962531");
		
		Thread.sleep(2000);
		//Click the Add Percentage button
		driver.findElement(By.xpath("//td[4]/div/div[1]/div/a/i")).click();
		
		Thread.sleep(3000);
		//Clear the name of percentage
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[1]/div/input")).clear();
		//Enter the name of Percentage
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[1]/div/input")).sendKeys("Employee");
		
		//Clear the percentage
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[2]/div/input")).clear();
		//Enter the percentage
		driver.findElement(By.xpath("//td[4]/div/div[4]/ng-form/div/div/div[2]/div/input")).sendKeys("50");
		
		//Click the Close button in Controls field
		driver.findElement(By.xpath("//a[@class='btn btn-small btn-danger']")).click();
		Thread.sleep(5000);
		
		int close = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[4]/div/div/ng-form/div/div/div[3]/a")).size();
		//Check whether the Closed or not
		if( close == 1)
		{
			test.log(LogStatus.PASS, "Close button working fine");
		}
		else
		{
			test.log(LogStatus.FAIL, "Close button not working");
		}
		Thread.sleep(2000);
		//Click Royalty/Franchise button is enabled or disabled
		driver.findElement(By.xpath("//td[2]/div/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the Save button in Controls field
		driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
		Thread.sleep(3000);
	}

}
