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

public class Settings_Add_Edit_Delete_Kitchen_Printer {

	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings_Add_Edit_Delete_Kitchen_Printer");
	
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
	
	@Test(priority=11,enabled = true)
	public void Kitchen_Printer_method_open_Kitchen_Printer() throws Exception
	{
/*		//Click the Settings option
		driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[5]/a/span[1]")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Printer Configuration']"));
		//Scroll the page till the Printer Configuration option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Store Option		
		driver.findElement(By.xpath("//span[.='Printer Configuration']")).click();*/
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"kitchenPrinters");
		Thread.sleep(5000);
		//Check Kitchen Printer page opened or not
		if(driver.findElement(By.xpath("//a[.='Kitchen printers']")).getText().equalsIgnoreCase("Kitchen printers"))
		{
			test.log(LogStatus.PASS, "Kitchen printers page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen printers page loaded Failed");
		}
		Thread.sleep(3000);
	}	
			
	@Test(priority=12,enabled = true)
	public void Kitchen_Printer_method_refreshKitchen_Printer() throws InterruptedException
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/a/i")).click();
		
		Thread.sleep(5000);
		//Check Kitchen Printer page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Kitchen Printers"))
		{
			test.log(LogStatus.PASS, "Kitchen Printer page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen Printer page refreshed Failed");
		}
	}
	
	@Test(priority=13,enabled = true)
	public void Kitchen_Printer_method_pagination() throws InterruptedException
	{
						
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Pagination option as 10
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[2]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Kitchen Printer");
		//Create the web element for Kitchen Printer Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Kitchen Printer");
		}
		Thread.sleep(5000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[3]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Kitchen Printer");
		//Create the web element for Kitchen Printer Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Kitchen Printer");
		}
		Thread.sleep(5000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[4]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for Kitchen Printer");
		//Create the web element for Kitchen Printer Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Kitchen Printer");
		}
		Thread.sleep(5000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[1]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Kitchen Printer");
		//Create the web element for Kitchen Printer Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Kitchen Printer");
		}
		Thread.sleep(5000);
	}
		
	@Test(priority=14,enabled = true)
	public void Kitchen_Printer_method_add_Kitchen_Printer() throws Exception
	{
		for(int i = 0; i <= 10; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		Thread.sleep(5000);
		//Click Add Kitchen Printer Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/button")).click();
		
		Thread.sleep(3000);
		//Check New Kitchen Printer form opened or not
		if(driver.findElement(By.xpath("//span[.='New Kitchen Printers']")).getText().equalsIgnoreCase("New Kitchen Printers"))
		{
			test.log(LogStatus.PASS, "Kitchen printer form opened Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen printer form opened Failed");
		}
		Thread.sleep(3000);
		
		//Click the Types Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/a")).click();
		//Enter the required type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys("Printer");
		//Press Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Printer model
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[2]/div/a")).click();
		//Click
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[2]/div/div/div/input")).click();
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the name field
		driver.findElement(By.name("name")).clear();
		//Enter the name
		driver.findElement(By.name("name")).sendKeys("New_Kitch_Print");
		
		Thread.sleep(1000);
		//Clear the IP Address field
		driver.findElement(By.name("IPAddress")).clear();
		//Enter the IP Address
		driver.findElement(By.name("IPAddress")).sendKeys("192.168.1.11");
		
		Thread.sleep(2000);
		//Click the Printer model
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/a")).click();
		//Click
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/div/div/input")).click();
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/div/div/input")).sendKeys(Keys.ENTER);

		
		Thread.sleep(1000);
		//Check whether the Enable Service Type Restriction option is enable or not
		if(driver.findElement(By.name("enableServiceTypeRestriction")).isSelected())
		{
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("QSR");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("ToGo");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("WEBORDER");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
		}
		
		else
		{
			Thread.sleep(1000);
			//Enable or disable service type
			driver.findElement(By.name("enableServiceTypeRestriction")).click();
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("QSR");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("ToGo");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("WEBORDER");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
		}
		for(int i = 1; i <= 8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		Thread.sleep(1000);
		//Check whether the Apply to all Categories is enabled or not
		if(driver.findElement(By.name("default")).isSelected())
		{
			Thread.sleep(1000);
			//Check whether the Apply to all menu items is enabled or not
			if(driver.findElement(By.name("forAllMenuItems")).isSelected())
			{
				
			}
			
			else
			{
				
				Thread.sleep(1000);
				//Enable the Apply to all menu items
				driver.findElement(By.name("forAllMenuItems")).click();
				
				//Click the Yes button
				driver.findElement(By.partialLinkText("Yes")).click();
			}
		}
		
		else
		{
			Thread.sleep(1000);
			//Enable the Apply to all Categories
			driver.findElement(By.name("default")).click();
			Thread.sleep(1000);
			//Click the Yes button
			//driver.findElement(By.partialLinkText("Yes")).click();
			
			Thread.sleep(1000);
			//Check whether the Apply to all menu items is enabled or not
			if(driver.findElement(By.name("forAllMenuItems")).isSelected())
			{
				
			}
			
			else
			{
				Thread.sleep(1000);
				//Enable the Apply to all menu items
				driver.findElement(By.name("forAllMenuItems")).click();
				
				Thread.sleep(1000);
				//Click the Yes button
				//driver.findElement(By.partialLinkText("Yes")).click();
			}
		}
		
		Thread.sleep(2000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@id='saveKitchen']")).click();
		Thread.sleep(2500);
		
		//Check whether the Kitchen printer was saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Printer saved successfully"))
		{
			test.log(LogStatus.PASS, "Kitchen Printer Saved successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen Printer Saved fail");
		}
		Thread.sleep(3000);

	}
	
	@Test(priority=15,enabled = true)
	public void Kitchen_Printer_method_edit_Kitchen_Printer() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required key word
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("New_Kitch_Print");
		
		Thread.sleep(1000);
		//Click the Edit button
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(5000);
		//Click the Types Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/a")).click();
		//Enter the required type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys("KDS");
		//Press Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the name field
		driver.findElement(By.name("name")).clear();
		//Enter the name
		driver.findElement(By.name("name")).sendKeys("New_Kitch_Print1");
		
		Thread.sleep(1000);
		//Clear the IP Address field
		driver.findElement(By.name("IPAddress")).clear();
		//Enter the IP Address
		driver.findElement(By.name("IPAddress")).sendKeys("192.168.1.12");
		
/*		Thread.sleep(2000);
		//Click the Printer model
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/a")).click();
		//Press the down arrow button
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(1000);
		//Click
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/div/div/input")).click();
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/div/div/input")).sendKeys(Keys.ENTER);
*/
		Thread.sleep(1000);
		//Check whether the Enable Service Type Restriction option is enable or not
		if(driver.findElement(By.name("enableServiceTypeRestriction")).isSelected())
		{
			for(int i = 1; i <= 3; i++)
			{
				driver.findElement(By.xpath("//a[@class='search-choice-close']")).click();
			}
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("DELIVERY");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("FORHERE");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("PHONEORDER");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
		}
		
		else
		{
			Thread.sleep(1000);
			//Enable or disable service type
			driver.findElement(By.name("enableServiceTypeRestriction")).click();
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("DELIVERY");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("FORHERE");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("PHONEORDER");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='kitchenPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
		}
		
		Thread.sleep(2000);
		//Click the Update button
		driver.findElement(By.xpath("//button[@id='saveKitchen']")).click();
		Thread.sleep(2000);
		
		//Check whether the Kitchen printer was updated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Printer updated successfully"))
		{
			test.log(LogStatus.PASS, "Kitchen Printer Updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen Printer Updated fail");
		}
		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(2000);
	}
	
	@Test(priority=16,enabled = true)
	public void Kitchen_Printer_method_delete_Kitchen_Printer() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required key word
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("New_Kitch_Print1");
		
		Thread.sleep(1000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check the Kitchen Printer deleted or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Printer deleted successfully"))
		{
			test.log(LogStatus.PASS, "New Kitchen Printer is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Kitchen Printer is deleted Failed");
		}
		Thread.sleep(3000);
		
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required key word
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("New_Kitch_Print1");
		
		Thread.sleep(2000);
		try{
			if(driver.findElement(By.xpath("//td[contains(.,'New_Kitch_Print1')]")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Deleted Printer available here");
			}
		}

		catch(Exception e)
		{
			test.log(LogStatus.PASS, "Deleted Printer not available here");
		}
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(2000);
	}
	
	@Test(priority=17,enabled = true)
	public void Kitchen_Printer_method_close_Button() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click Add Kitchen Printer Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/button")).click();
		
		Thread.sleep(3000);
		//Check New Kitchen Printer form opened or not
		if(driver.findElement(By.xpath("//span[.='New Kitchen Printers']")).getText().equalsIgnoreCase("New Kitchen Printers"))
		{
			test.log(LogStatus.PASS, "Kitchen printer form opened Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen printer form opened Failed");
		}
		Thread.sleep(3000);
		
		//Click the Types Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/a")).click();
		//Enter the required type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys("Printer");
		//Press Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the name field
		driver.findElement(By.name("name")).clear();
		//Enter the name
		driver.findElement(By.name("name")).sendKeys("New_Kitch_Print");
		
	
		Thread.sleep(2000);
		//Click the Close button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		Thread.sleep(2000);
		
		//Check whether the Kitchen printer form was closed or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/button")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Kitchen Printer form Closed successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen Printer form Closed fail");
		}
		Thread.sleep(3000);

	}

}