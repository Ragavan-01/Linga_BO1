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

public class Settings_Denomination {

	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings_Denomination");
	
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
	
	@Test(priority=10)
	public void Denominations_Setting_Method_Pageopen() throws Exception
	{
		
		
		Thread.sleep(3000);
		//Enter the URl
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"denominations");
		
		Thread.sleep(3000);
		
		//Check weather the denomination page is loaded or not
		if(driver.findElement(By.xpath("//a[.='Denominations']")).getText().equalsIgnoreCase("Denominations"))
		{
			test.log(LogStatus.PASS, "Denomination page loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Denomination page loaded fail");
		}

		Thread.sleep(3000);

	}	
	
	@Test(priority=11)
	public void Denominations_Setting_Method_refresh() throws Exception
	{
		Thread.sleep(3000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/a/i")).click();

		
		//Check weather the page is refreshed or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Denomination"))
		{
			test.log(LogStatus.PASS, "Denominations Page refreshed successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Denominations Page refreshed successfully");
		}
		
	}
	
	@Test(priority=12)
	public void Denominations_Setting_Method_pagination() throws InterruptedException
	{
		
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		
		//Click the Pagination option as 10
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div/ul/li[2]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Denominations for Denomination");
		//Create the web element for denomination Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Denomination");
		}
		Thread.sleep(3000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div/ul/li[3]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Denominations for Denomination");
		//Create the web element for denomination Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Denomination");
		}
		Thread.sleep(3000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div/ul/li[4]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for Denominations for Denomination");
		//Create the web element for denomination Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Denomination");
		}
		Thread.sleep(3000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div/ul/li[1]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Denominations for Denomination");
		//Create the web element for denomination Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/table"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Denomination");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=13)
	public void Denominations_Setting_Method_add() throws Exception
	{
		Thread.sleep(4000);
		//Click the Add denomination button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/button")).click();
		Thread.sleep(2000);
		
		//Check weather the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='New Denomination']")).getText().equalsIgnoreCase("New Denomination"))
		{
			test.log(LogStatus.PASS, "New Denomination form or page loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Denomination form or page loaded fail");
		}
		
		Thread.sleep(2000);
		//Clear the Display name field
		driver.findElement(By.name("displayAmount")).clear();
		//Enter the name
		driver.findElement(By.name("displayAmount")).sendKeys("New_Demo");
		
		Thread.sleep(2000);
		//Clear the amount field
		driver.findElement(By.name("amount")).clear();
		//Enter the amount
		driver.findElement(By.name("amount")).sendKeys("125");
		
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		//Check weather the new denomination form saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Denomination saved successfully"))
		{
			test.log(LogStatus.PASS, "New Denomination saved successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Denomination saved fail");
		}
	}
	
	@Test(priority=14)
	public void Denominations_Setting_Method_delete() throws Exception
	{
		Thread.sleep(2000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//enter the keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("New");
		
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		//Click the Yes button in the popup
		Thread.sleep(5000);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check the denomination deleted or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Denomination Deleted successfully"))
		{
			test.log(LogStatus.PASS, "New Denomination is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Denomination is deleted Failed");
		}
		Thread.sleep(3000);
		
		
	}
		
	@Test(priority=15)
	public void Denominations_Setting_Method_close_Button() throws Exception
	{
		Thread.sleep(2000);
		//Click the Add denomination button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/button")).click();
		Thread.sleep(2000);
		
		//Check weather the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='New Denomination']")).getText().equalsIgnoreCase("New Denomination"))
		{
			test.log(LogStatus.PASS, "New Denomination form or page loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Denomination form or page loaded fail");
		}
		
		Thread.sleep(2000);
		//Clear the Display name field
		driver.findElement(By.name("displayAmount")).clear();
		//Enter the name
		driver.findElement(By.name("displayAmount")).sendKeys("New_Demo");
		
		Thread.sleep(2000);
		//Clear the amount field
		driver.findElement(By.name("amount")).clear();
		//Enter the amount
		driver.findElement(By.name("amount")).sendKeys("125");
		
		Thread.sleep(1000);
		//Click the Close button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		Thread.sleep(2000);
		
		//Check weather the new denomination form closed or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/button")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Denomination Closed successfully for Daily");
		}
		else
		{
			test.log(LogStatus.FAIL, "Denomination Closed fail");
		}
		Thread.sleep(3000);
	}
}
