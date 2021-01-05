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

public class Settings_Service_Charge {

	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings_Service_Charge");
	
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
	public void open_Service_Charge() throws Exception
	{
		//Click the Settings option
		driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[5]/a/span[1]")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Store']"));
		//Scroll the page till the Store option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Store Option		
		driver.findElement(By.xpath("//span[.='Store']")).click();
		Thread.sleep(5000);
		//Check Store Information page opened or not
		if(driver.findElement(By.xpath("//a[.='Store Information']")).getText().equalsIgnoreCase("Store Information"))
		{
			test.log(LogStatus.PASS, "Store Information page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Information page loaded Failed");
		}
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		Thread.sleep(4000);
		// Create instance of Java script executor
		JavascriptExecutor je1 = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element1 = driver.findElement(By.xpath("//span[.=' Service Charge ']"));
		//Scroll the page till the Store option present
		je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
		Thread.sleep(3000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		//Click the Service Charge Option
		driver.findElement(By.xpath("//span[.=' Service Charge ']")).click();
		Thread.sleep(3000);

		//Check weather the Service Charge page is loaded or not
		if(driver.findElement(By.xpath("//a[.='Service Charge']")).getText().equalsIgnoreCase("Service Charge"))
		{
			test.log(LogStatus.PASS, "Service Charge page loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charge page loaded fail");
		}

		Thread.sleep(5000);

	}	
	
	@Test(priority=3)
	public void refreash_Service_Charge() throws Exception
	{
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a/i")).click();
		Thread.sleep(3000);
		
		//Check weather the page is refreshed or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Service Charge"))
		{
			test.log(LogStatus.PASS, "Service Charge Page refreshed successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charge Page refreshed successfully");
		}
		
	}
	
	@Test(priority=3)
	public void pagination() throws InterruptedException
	{
		

				
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Pagination option as 10
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[2]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10");
		//Create the web element for Service Charge Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[3]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15");
		//Create the web element for Service Charge Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[4]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20");
		//Create the web element for Service Charge Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[1]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5");
		//Create the web element for Service Charge Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available");
		}
		Thread.sleep(8000);
	}
	
	@Test(priority=4)
	public void add_Service_Charge() throws Exception
	{
		Thread.sleep(2000);
		//Click the Add Service Charge button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/button")).click();
		Thread.sleep(2000);
		
		//Check weather the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='New Service Charge']")).getText().equalsIgnoreCase("New Service Charge"))
		{
			test.log(LogStatus.PASS, "New Service Charge form or page loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Service Charge form or page loaded fail");
		}
		
		Thread.sleep(2000);
		//Select the CArd Type
		Select cardType = new Select(driver.findElement(By.name("cardType")));
		cardType.selectByVisibleText("Master");
		
		//Clear the service charge field
		driver.findElement(By.name("serviceCharge")).clear();
		//Enter the service charge
		driver.findElement(By.name("serviceCharge")).sendKeys("123");
		
		//Clear the tip charge field
		driver.findElement(By.name("tipCharge")).clear();
		//Enter the tip charge
		driver.findElement(By.name("tipCharge")).sendKeys("125");
		
		Thread.sleep(1000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		//Check weather the new denomination form saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Service Charge Added Successfully"))
		{
			test.log(LogStatus.PASS, "New Service Charge saved successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Service Charge saved fail");
		}
	}
	
	
	@Test(priority=6)
	public void edit_Service_Charge() throws Exception
	{
		Thread.sleep(10000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//enter the keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Master");
		
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(5000);
		
		//Clear the service charge field
		driver.findElement(By.name("serviceCharge")).clear();
		//Enter the service charge
		driver.findElement(By.name("serviceCharge")).sendKeys("125");
		
		//Clear the tip charge field
		driver.findElement(By.name("tipCharge")).clear();
		//Enter the tip charge
		driver.findElement(By.name("tipCharge")).sendKeys("126");
		
		Thread.sleep(1000);
		//Click the update button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		//Check weather the new denomination form saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Service Charges Updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Service Charges Updated fail");
		}
		Thread.sleep(3000);
		
		
	}
	
	
	@Test(priority=7)
	public void delete_Service_Charge() throws Exception
	{
		Thread.sleep(2000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//enter the keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Master");
		
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		//Click the Yes button in the popup
		driver.findElement(By.linkText("Yes")).click();
		
		Thread.sleep(3000);
		//Check the denomination deleted or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Service Charge Removed successfuly"))
		{
			test.log(LogStatus.PASS, "Service Charge settings deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charge Settings deleted Failed");
		}
		Thread.sleep(3000);
		
		
	}
	
	@Test(priority=8)
	public void close_Button() throws Exception
	{
		Thread.sleep(2000);
		//Click the Add Service Charge settings button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/button")).click();
		Thread.sleep(2000);
		
		//Check weather the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='New Service Charge']")).getText().equalsIgnoreCase("New Service Charge"))
		{
			test.log(LogStatus.PASS, "New Service Charge form or page loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Service Charge form or page loaded fail");
		}
		
		Thread.sleep(2000);
		//Select the CArd Type
		Select cardType = new Select(driver.findElement(By.name("cardType")));
		cardType.selectByVisibleText("Master");
		
		//Clear the service charge field
		driver.findElement(By.name("serviceCharge")).clear();
		//Enter the service charge
		driver.findElement(By.name("serviceCharge")).sendKeys("123");
		
		//Clear the tip charge field
		driver.findElement(By.name("tipCharge")).clear();
		//Enter the tip charge
		driver.findElement(By.name("tipCharge")).sendKeys("125");
		
		Thread.sleep(1000);
		//Click the Close button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		Thread.sleep(2000);
		
		//Check weather the new service charge form closed or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/button")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Service Charge form Closed successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charge form Closed fail");
		}
	}
}
