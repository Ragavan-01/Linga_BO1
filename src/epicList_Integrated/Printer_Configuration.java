package epicList_Integrated;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Printer_Configuration {


	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Printer Configuration");
	
	float unknownValue = 00;
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScreenshot(driver, result.getName());
		}
	}
	
	@AfterClass
	public void flushTest() throws Exception
	{
		Thread.sleep(2000);
		rep.endTest(test);
		rep.flush();
	}
	
	@Test(priority=1)
	public void login(WebDriver driver) throws Exception
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
	public void logout(WebDriver driver) throws Exception
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
	public void watchTutorial(WebDriver driver) throws Exception
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

	@Test(priority=2,enabled = true)
	public void Front_End_Receipt_method_open_Front_End_Receipt(WebDriver driver) throws Exception
	{
		Thread.sleep(15000);
		//Click the Settings option
		driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[5]/a/span[1]")).click();Thread.sleep(3000);
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Printer Configuration']"));
		//Scroll the page till the Printer Configuration option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); Thread.sleep(3000);
        //Click the Store Option		
		driver.findElement(By.xpath("//span[.='Printer Configuration']")).click();
		Thread.sleep(5000);
		//Check Front End Receipt page opened or not
		if(driver.findElement(By.xpath("//a[.='Front End Receipt Template']")).getText().equalsIgnoreCase("Front End Receipt Template"))
		{
			test.log(LogStatus.PASS, "Front End Receipt Template page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Front End Receipt Template page loaded Failed");
		}
		
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		//Thread.sleep(3000);watchTutorial();Thread.sleep(3000);
	}	
		
	@Test(priority=3,enabled = true)
	public void Front_End_Receipt_method_update_FrontEndReceipt_Template(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);

		//Select the Font Size
    	Select fontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSize']")));
		fontSize.selectByVisibleText("Small");
		Thread.sleep(3000);
			
		
		//Check whether the Store Logo is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreLogo']")).isSelected())
		{
			//Select the required store logo
			driver.findElement(By.id("storeImage")).sendKeys(Utility.getProperty("Store_Logo_Path"));
		}
		else
		{
			//Enable the Store Logo option
			driver.findElement(By.xpath("//input[@ng-model='settings.showStoreLogo']/../span")).click();
			Thread.sleep(2000);
			//Select the required store logo
			driver.findElement(By.id("storeImage")).sendKeys(Utility.getProperty("Store_Logo_Path"));
		}
		
		
		
		//Check whether the store name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreName']")).isSelected()){}
		
		else
		{
			//Enable the Store name Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showStoreName']/../span")).click();
		}
		
		
		//Check whether the table name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTableName']")).isSelected()){}
		
		else
		{
			//Enable the table name Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showTableName']/../span")).click();
		}
		
		
		//Check whether the seat number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showSeatNumber']")).isSelected()){}
		
		else
		{
			//Enable the seat number Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showSeatNumber']/../span")).click();
		}
		
		
		//Check whether the Check Open Server field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServerName']")).isSelected()){}
		
		else
		{
			//Enable the Check Open Server Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showServerName']/../span")).click();
		}
		
		
		//Check whether the Check Close Server field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.closeServerName']")).isSelected()){}
		
		else
		{
			//Enable the Check Close Server Option
			driver.findElement(By.xpath("//input[@ng-model='settings.closeServerName']/../span")).click();
		}
		Thread.sleep(3000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		//Check whether the Check number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCheckNumber']")).isSelected())
		{			
			Select position = new Select(driver.findElement(By.xpath("//label[.='Position']/../select")));
			position.selectByVisibleText("P#1");
			
			Thread.sleep(2000);
			
			Select fontSize1 = new Select(driver.findElement(By.xpath("//label[.='Font Size']/../select")));
			fontSize1.selectByVisibleText("2 Height");
			Thread.sleep(2000);
		}
		
		else
		{
			Thread.sleep(2000);
			//Enable the Check number Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showCheckNumber']/../span")).click();

			Select position = new Select(driver.findElement(By.xpath("//label[.='Position']/../select")));
			position.selectByVisibleText("P#1");
			
			Thread.sleep(2000);
			
			Select fontSize2 = new Select(driver.findElement(By.xpath("//label[.='Font Size']/../select")));
			fontSize2.selectByVisibleText("2 Height");
			Thread.sleep(2000);
			
			
		}
		
		
		//Check whether the Open Date and Time field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showDate']")).isSelected()){}
		
		else
		{
			//Enable the Open Date and Time Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showDate']/../span")).click();
		}
		
		
		
		//Check whether the Close Date and Time field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.closeDate']")).isSelected()){}
		
		else
		{
			//Enable the Close Date and Time Option
			driver.findElement(By.xpath("//input[@ng-model='settings.closeDate']/../span")).click();
		}
		
		
		//Check whether the Customer name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerName']")).isSelected()){}
		
		else
		{
			//Enable the customer name Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerName']/../span")).click();
		}
		
		
		//Check whether the Service Type field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServiceType']")).isSelected()){}
		
		else
		{
			//Enable the Service Type Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showServiceType']/../span")).click();
		}
		
		
		//Check whether the Show Secondary menu name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showLocalName']")).isSelected()){}
		
		else
		{
			//Enable the  Show Secondary menu name Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showLocalName']/../span")).click();
		}
		
		
		//Check whether the Roll Out Modifier Price To Menu field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.rollOutModifierPrice']")).isSelected()){}
		
		else
		{
			//Enable the  Roll Out Modifier Price To Menu Option
			driver.findElement(By.xpath("//input[@ng-model='settings.rollOutModifierPrice']/../span")).click();
		}
		
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		}
		
		//Check whether the Roll Out Modifier Price & Quantity To Menu field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.rollOutModifierPriceAndQuantity']")).isSelected()){}
		
		else
		{
			//Enable the  Roll Out Modifier Price & Quantity To Menu Option
			driver.findElement(By.xpath("//input[@ng-model='settings.rollOutModifierPriceAndQuantity']/../span")).click();
		}
		
		
		//Check whether the Roll Out Modifier To Menu field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.rollOutModifierNameAndPrice']")).isSelected()){}
		
		else
		{
			//Enable the  Roll Out Modifier To Menu Option
			driver.findElement(By.xpath("//input[@ng-model='settings.rollOutModifierNameAndPrice']/../span")).click();
		}
		
		
		
		//Check whether the Exclude zero price menu item field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.excludeZeroPriceMenu']")).isSelected()){}
		
		else
		{
			//Enable the Exclude zero price menu item Option
			driver.findElement(By.xpath("//input[@ng-model='settings.excludeZeroPriceMenu']/../span")).click();
		}
		
		
		//Check whether the Exclude Zero Price Modifier field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.excludeZeroPriceModifier']")).isSelected()){}
		
		else
		{
			//Enable the Exclude Zero Price Modifier item Option
			driver.findElement(By.xpath("//input[@ng-model='settings.excludeZeroPriceModifier']/../span")).click();
		}
		
		
		//Check whether the Tax Summary field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTaxSummary']")).isSelected()){}
		
		else
		{
			//Enable the Tax Summary Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showTaxSummary']/../span")).click();
		}
		
		
		//Check whether the Gratuity field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showGratuity']")).isSelected()){}
		
		else
		{
			//Enable the Gratuity Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showGratuity']/../span")).click();
		}
		
		
		//Check whether the Tip field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTip']")).isSelected()){}
		
		else
		{
			//Enable the Tip Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showTip']/../span")).click();
		}
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		}
		
		//Check whether the Cash Discount field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.cashDiscount']")).isSelected()){}
		
		else
		{
			//Enable the Cash Discount Option
			driver.findElement(By.xpath("//input[@ng-model='settings.cashDiscount']/../span")).click();
		}
		
		//Check whether the Tender Details field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTenderDetails']")).isSelected()){}
		
		else
		{
			//Enable the Tender Details Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showTenderDetails']/../span")).click();
		}
		
		
		//Check whether the Loyalty Amount field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showLoyaltyAmount']")).isSelected()){}
		
		else
		{
			//Enable the Loyalty Amount Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showLoyaltyAmount']/../span")).click();
		}
		
		
		//Check whether the Tip Line field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTipLine']")).isSelected()){}
		
		else
		{
			//Enable the Tip Line Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showTipLine']/../span")).click();
		}
		
		//Check whether the Signature field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showSignature']")).isSelected()){}
		
		else
		{
			//Enable the Signature Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showSignature']/../span")).click();
		}
		
		//Check whether the Tip Suggestion field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTipSuggestion']")).isSelected()){}
		
		else
		{
			//Enable the Tip Suggestion Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showTipSuggestion']/../span")).click();
		}
		
		//Check whether the Address field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreAddress']")).isSelected()){}
		
		else
		{
			//Enable the Address Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showStoreAddress']/../span")).click();
		}
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		}
		
		//Check whether the Email field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreEmail']")).isSelected()){}
		
		else
		{
			//Enable the Email Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showStoreEmail']/../span")).click();
		}
		
		//Check whether the Phone Number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStorePhoneNumber']")).isSelected()){}
		
		else
		{
			//Enable the Phone Number Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showStorePhoneNumber']/../span")).click();
		}
		
		//Clear the customer text
		driver.findElement(By.xpath("//textarea[@ng-model='settings.customText']")).clear();
		//Enter the required text
		driver.findElement(By.xpath("//textarea[@ng-model='settings.customText']")).sendKeys("Test");
		Thread.sleep(2000);
		
		//Check whether the Address field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showAddress']")).isSelected()){}
		
		else
		{
			//Enable the Address Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showAddress']/../span")).click();
		}
		
		//Check whether the Email field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showEmail']")).isSelected()){}
		
		else
		{
			//Enable the Email Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showEmail']/../span")).click();
		}
		
		//Check whether the Phone Number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showPhoneNumber']")).isSelected()){}
		
		else
		{
			//Enable the Phone Number Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showPhoneNumber']/../span")).click();
		}
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		}
		
		//Check whether the Barcode field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showBarcode']")).isSelected()){}
		
		else
		{
			//Enable the Barcode Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showBarcode']/../span")).click();
		}
		
		//Clear the free text
		driver.findElement(By.xpath("//textarea[@ng-model='settings.freeText']")).clear();
		//Enter the required text
		driver.findElement(By.xpath("//textarea[@ng-model='settings.freeText']")).sendKeys("Have a nice day, Visit us again!");
		
		//Check whether the Cut Paper After Each print field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.cutReceipt']")).isSelected()){}
		
		else
		{
			//Enable the Cut Paper After Each print Option
			driver.findElement(By.xpath("//input[@ng-model='settings.cutReceipt']/../span")).click();
		}
		
		//Check whether the Notes field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showNotes']")).isSelected()){}
		
		else
		{
			//Enable the Notes Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showNotes']/../span")).click();
		}
		Thread.sleep(5000);

	
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		Thread.sleep(5000);
		//Click the update button
		driver.findElement(By.xpath("//button[@id='updateFrontEndReceipt']")).click();
		Thread.sleep(4000);
		
		//Check weather the new denomination form saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Receipt template saved successfully"))
		{
			test.log(LogStatus.PASS, "Front End Receipt template Updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Front End Receipt template Updated fail");
		}
		Thread.sleep(3000);
		
		
	}
	
	@Test(priority=4,enabled = true)
	public void Front_End_Receipt_method_verifyUpdatedDetails(WebDriver driver) throws Exception
	{
		Thread.sleep(2000);
		
		
		//Check whether the Store Logo is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreLogo']")).isSelected())
		{
			test.log(LogStatus.PASS, "Store Logo button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Logo button is disabled");
		}
		
		
		
		//Check whether the store name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreName']")).isSelected())
		{
			test.log(LogStatus.PASS, "Store name button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store name button is disabled");
		}
		

		
		//Check whether the table name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTableName']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Table name button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Table name button is disabled");
		}
		
		
		//Check whether the seat number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showSeatNumber']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Seat Number button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Seat Number button is disabled");
		}
		
		
		//Check whether the Check Open Server field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServerName']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Open Server button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Open Server button is disabled");
		}
		
		
		//Check whether the Check Close Server field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.closeServerName']")).isSelected())
		{
			test.log(LogStatus.PASS, "Close Server button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Close Server button is disabled");
		}
		
		//Check whether the Check number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCheckNumber']")).isSelected())
		{
			test.log(LogStatus.PASS, "Check number button is enabled");
			
			//Check whether the Selected Font Size is displayed or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[10]/div[2]/select/option[2]")).isSelected())		
			{
				test.log(LogStatus.PASS, "2 Height font size is displayed");
			}
			else
			{
				test.log(LogStatus.FAIL, "2 Height font size is not displayed");
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "Check number button is disabled");
		}
		
		//Check whether the Open Date and Time field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showDate']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Open Date and Time button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Open Date and Time button is disabled");
		}
		
		
		//Check whether the Close Date and Time field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.closeDate']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Close Date and Time button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Close Date and Time button is disabled");
		}
		
		//Check whether the Customer name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerName']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Customer name button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Customer name button is disabled");
		}
		
		
		//Check whether the Service Type field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServiceType']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Service Type button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Type button is disabled");
		}
		
		//Check whether the Show Secondary menu name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showLocalName']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Secondary menu name button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Secondary menu name button is disabled");
		}
		
		//Check whether the Roll Out Modifier Price To Menu field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.rollOutModifierPrice']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Roll Out Modifier Price To Menu is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Roll Out Modifier Price To Menu button is disabled");
		}
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		}
		
		//Check whether the Roll Out Modifier Price & Quantity To Menu field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.rollOutModifierPriceAndQuantity']")).isSelected())
		{
			test.log(LogStatus.PASS, "Roll Out Modifier Price & Quantity To Menu button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Roll Out Modifier Price & Quantity To Menu button is not enabled");
		}
		
		//Check whether the Roll Out Modifier To Menu field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.rollOutModifierNameAndPrice']")).isSelected())
		{
			test.log(LogStatus.PASS, "Roll Out Modifier To Menu button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Roll Out Modifier To Menu button is not enabled");
		}
		
		//Check whether the Exclude zero price menu item field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.excludeZeroPriceMenu']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Exclude zero price menu item button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Exclude zero price menu item button is disabled");
		}
		
		//Check whether the Exclude Zero Price Modifier field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.excludeZeroPriceModifier']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Exclude Zero Price Modifier button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Exclude Zero Price Modifier button is disabled");
		}
		
		//Check whether the Tax Summary field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTaxSummary']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Tax Summary button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Summary button is disabled");
		}
		
		//Check whether the Gratuity field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showGratuity']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Gratuity button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gratuity button is disabled");
		}
		
		//Check whether the Tip field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTip']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Tip button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip button is disabled");
		}
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		}
		
		//Check whether the Cash Discount field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.cashDiscount']")).isSelected())
		{
			test.log(LogStatus.PASS, "Cash Discount button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Cash Discount button is not enabled");
		}
		
		//Check whether the Tender Details field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTenderDetails']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Tender Details button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tender Details button is disabled");
		}
		
		//Check whether the Loyalty Amount field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showLoyaltyAmount']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Loyalty Amount button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Loyalty Amount button is disabled");
		}
		
		//Check whether the Tip Line field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTipLine']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Tip Line button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Line button is disabled");
		}
		
		//Check whether the Signature field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showSignature']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Signature button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Signature button is disabled");
		}
		
		//Check whether the Tip Suggestion field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTipSuggestion']")).isSelected())	
		{
			test.log(LogStatus.PASS, "Tip Suggestion button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Suggestion button is disabled");
		}
		
		//Check whether the Address field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreAddress']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Address button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Address button is disabled");
		}
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		}
		
		//Check whether the Email field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreEmail']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Email button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Email button is disabled");
		}
		
		//Check whether the Phone Number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStorePhoneNumber']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Phone Number button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Phone Number button is disabled");
		}

		
		//Check whether the Address field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showAddress']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Address button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Address button is disabled");
		}
		
		//Check whether the Email field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showEmail']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Email button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Email button is disabled");
		}
		
		//Check whether the Phone Number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showPhoneNumber']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Phone Number button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Phone Number button is disabled");
		}
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		}
		
		//Check whether the Barcode field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showBarcode']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Barcode button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Barcode button is disabled");
		}
		
		
		//Check whether the Cut Paper After Each print field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.cutReceipt']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Cut Paper After Each print button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Cut Paper After Each print button is disabled");
		}
		
		//Check whether the Notes field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showNotes']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Notes button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Notes button is disabled");
		}
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);Thread.sleep(2000);
		}
		
	}
	
	@Test(priority=5,enabled = true)
	public void Kitchen_Receipt_Template_method_open_Kitchen_Receipt_Template(WebDriver driver) throws Exception
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
		
		for(int i = 0; i <= 10; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"kitchenReceiptTemplate");
		Thread.sleep(5000);
		
		//Check whether the Kitchen Receipt Template
		if(driver.findElement(By.xpath("//a[.='Kitchen Receipt Template']")).getText().equalsIgnoreCase("Kitchen Receipt Template"))
		{
			test.log(LogStatus.PASS, "Kitchen Receipt Template page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen Receipt Template page loaded Failed");
		}
		Thread.sleep(3000);
	}	

	@Test(priority=6,enabled = true)
	public void Kitchen_Receipt_Template_method_update_Kitchen_Receipt_Template(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Select the font size
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[1]/div[2]/select")).click();
		Thread.sleep(2000);
		WebElement mySelectElement = (WebElement)new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[1]/div[2]/select/option[1]")));
		mySelectElement.click();
		
	/*	driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[1]/div[2]/select")).click();
		List<WebElement> option = driver.findElements(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[1]/div[2]/select/option"));
		for(int i=0;i<option.size();i++ )
		{
		WebElement element  = option.get(i);
		String innerhtml = element.getAttribute("innerHTML");
		if(innerhtml.contentEquals("Small"))
		{
		element.click();
		break;
		}
		}
		*/
		
		//Check whether the Store name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreName']")).isSelected()){}
		
		else
		{
			//Enable the Store Name Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showStoreName']/..//span")).click();
		}
		Thread.sleep(1000);
		
		//Check whether the Table name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTableName']")).isSelected()){}
		
		else
		{
			//Enable the Table Name Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showTableName']/..//span")).click();
		}
		Thread.sleep(1000);
		
		//Check whether the Server name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServerName']")).isSelected()){}
		
		else
		{
			//Enable the Server Name Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showServerName']/..//span")).click();
		}
		Thread.sleep(1000);
		
		
		//Check whether the Check Number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCheckNumber']")).isSelected())
		{
			//Select the Required Position
			Select position = new Select(driver.findElement(By.xpath("//div[@ng-if='settings.showCheckNumber']/select")));
			position.selectByVisibleText("P#1");
			
			Thread.sleep(2000);
			
			//Select the required font size
			Select fontSize2 = new Select(driver.findElement(By.xpath("//div[@ng-if='settings.showCheckNumber']/..//div[2]/select")));
			fontSize2.selectByVisibleText("2 Height");
			Thread.sleep(2000);
		}
		else
		{
			//Enable the Check Number Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showCheckNumber']/..//span")).click();
			
			//Select the Required Position
			Select position = new Select(driver.findElement(By.xpath("//div[@ng-if='settings.showCheckNumber']/select")));
			position.selectByVisibleText("P#1");
			
			Thread.sleep(2000);
			
			//Select the required font size
			Select fontSize2 = new Select(driver.findElement(By.xpath("//div[@ng-if='settings.showCheckNumber']/..//div[2]/select")));
			fontSize2.selectByVisibleText("2 Height");
			Thread.sleep(2000);
		}
		Thread.sleep(1000);
		
		//Check whether the Date & Time field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showDate']")).isSelected()){}
		
		else
		{
			//Enable the Date & Time Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showDate']/..//span")).click();
		}
		Thread.sleep(1000);
		
		//Check whether the Customer name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerName']")).isSelected()){}
		
		else
		{
			//Enable the Customer Name Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerName']/..//span")).click();
		}
		Thread.sleep(1000);
		
		for(int i = 1; i <= 8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(2000);
		//Check whether the Service Type field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServiceType']")).isSelected())
		{
			//Select the Required Position
			Select position = new Select(driver.findElement(By.xpath("//div[@ng-if='settings.showServiceType']/select")));
			position.selectByVisibleText("P#2");
			
			Thread.sleep(2000);
		}
		else
		{
			//Enable the Service Type Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showServiceType']/..//span")).click();
			
			//Select the Required Position
			Select position = new Select(driver.findElement(By.xpath("//div[@ng-if='settings.showServiceType']/select")));
			position.selectByVisibleText("P#2");
			
			Thread.sleep(2000);
		}
		Thread.sleep(1000);
		
		
		//Check whether the Split By Course field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.splitByCourse']")).isSelected()){}
		
		else
		{
			//Enable the Split By Course Option
			driver.findElement(By.xpath("//input[@ng-model='settings.splitByCourse']/..//span")).click();
		}
		Thread.sleep(1000);
		
		
		//Check whether the Customer Information Position field - Below is enabled or not
		if(driver.findElement(By.xpath("//label[.='Customer Information Position']/../lablel[1]/input")).isSelected()){}
		
		else
		{
			//Enable the Customer Information Position Option - Below
			driver.findElement(By.xpath("//label[.='Customer Information Position']/../lablel[1]/input")).click();
		}
		Thread.sleep(1000);
		
		//Check whether the Address field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showAddress']")).isSelected()){}
		
		else
		{
			//Enable the Address Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showAddress']/..//span")).click();
		}
		Thread.sleep(1000);
		
		//Check whether the Email field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showEmail']")).isSelected()){}
		
		else
		{
			//Enable the Email Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showEmail']/..//span")).click();
		}
		Thread.sleep(1000);
		
		for(int i = 1; i <= 8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}Thread.sleep(2000);
		
		//Check whether the Phone number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showPhoneNumber']")).isSelected()){}
		
		else
		{
			//Enable the Phone Number Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showPhoneNumber']/..//span")).click();
		}
		Thread.sleep(1000);
		
		//Check whether the Cut Paper After Each print field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.cutReceipt']")).isSelected()){}
		
		else
		{
			//Enable the Cut Paper After Each print Option
			driver.findElement(By.xpath("//input[@ng-model='settings.cutReceipt']/..//span")).click();
		}
		Thread.sleep(1000);
		
		//Check whether the Print quantity before the menu name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.printQuantityBeforeMenuName']")).isSelected()){}
		
		else
		{
			//Enable the Print quantity before the menu name Option
			driver.findElement(By.xpath("//input[@ng-model='settings.printQuantityBeforeMenuName']/..//span")).click();
		}
		Thread.sleep(1000);
		
		//Check whether the Notes field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showNotes']")).isSelected()){}
		
		else
		{
			//Enable the Notes Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showNotes']/..//span")).click();
		}
		Thread.sleep(1000);
		
		for(int i = 1; i <= 8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		//Check whether the Consolidate Menu In Kitchen field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.consolidateMenuInKitchen']")).isSelected())
		{
			//Disable the Consolidate Menu In Kitchen Option
			driver.findElement(By.xpath("//input[@ng-model='settings.consolidateMenuInKitchen']/..//span")).click();
		}		
		else
		{
		}
		Thread.sleep(1000);
		
		//Check whether the split Menu Quantity field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.splitMenuQty']")).isSelected()){}
		
		else
		{
			//Enable the split Menu Quantity Option
			driver.findElement(By.xpath("//input[@ng-model='settings.splitMenuQty']/..//span")).click();
		}
		
		//Check whether the Is Other Language Menu Name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.isOtherLanguageMenuName']")).isSelected()){}
		
		else
		{
			//Enable the Is Other Language Menu Name Option
			driver.findElement(By.xpath("//input[@ng-model='settings.isOtherLanguageMenuName']/..//span")).click();
		}
		
		Thread.sleep(5000);
		//Click the update button
		driver.findElement(By.xpath("//button[@id='updateKitchenReceipt']")).click();
		
		Thread.sleep(5000);
		//Check weather the new denomination form saved or not									
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Kitchen Receipt template saved successfully"))
		{
			test.log(LogStatus.PASS, "Receipt template Updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Receipt template Updated fail");
		}
		Thread.sleep(3000);
		
		
	}

	@Test(priority=7,enabled = true)
	public void Verify_Kitchen_Receipt_Template_method_update_Kitchen_Receipt_Template(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Check Whether the Font Size is updated or not
		try
		{
			if(driver.findElement(By.xpath("//select[@ng-model='settings.fontSize']/option[.='Small']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Font Size updated successfully in Kitchen Receipt Template");
			}
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Font Size updated Fail in Kitchen Receipt Template");
		}

		
		//Check whether the Store name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreName']")).isSelected())
		{
			test.log(LogStatus.PASS, "Store Name field is Enabled in Kitchen Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Name field is disabled in Kitchen Receipt Template");
		}
		Thread.sleep(1000);
		
		//Check whether the Table name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTableName']")).isSelected())
		{
			test.log(LogStatus.PASS, "Table Name field is Enabled in Kitchen Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Table Name field is disabled in Kitchen Receipt Template");
		}
		Thread.sleep(1000);
		
		//Check whether the Server name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServerName']")).isSelected())
		{
			test.log(LogStatus.PASS, "Server Name field is Enabled in Kitchen Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Server Name field is disabled in Kitchen Receipt Template");
		}
		Thread.sleep(1000);
		
		
		//Check whether the Check Number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCheckNumber']")).isSelected())
		{
			test.log(LogStatus.PASS, "Check Number field is Enabled in Kitchen Receipt Template");
			
			//Check Whether the Position is updated or not
			try
			{
				if(driver.findElement(By.xpath("//select[@ng-model='settings.checkNumberPosition']/option[.='P#1']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Position - Check Number updated successfully in Kitchen Receipt Template");
				}
			}
			catch(Exception e)
			{
				test.log(LogStatus.FAIL, "Position - Check Number updated Fail in Kitchen Receipt Template");
			}
			
			//Check Whether the Position Font Size is updated or not
			try
			{
				if(driver.findElement(By.xpath("//select[@ng-model='settings.checkNumberFs']/option[.='2 Height']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Position Font Size - Check Number updated successfully in Kitchen Receipt Template");
				}
			}
			catch(Exception e)
			{
				test.log(LogStatus.FAIL, "Position Font Size - Check Number updated Fail in Kitchen Receipt Template");
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "Check Number field is disabled in Kitchen Receipt Template");
		}
		Thread.sleep(1000);
		
		//Check whether the Date & Time field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showDate']")).isSelected())
		{
			test.log(LogStatus.PASS, "Date & Time field is Enabled in Kitchen Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Date & Time field is disabled in Kitchen Receipt Template");
		}
		Thread.sleep(1000);
		
		//Check whether the Customer name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerName']")).isSelected())
		{
			test.log(LogStatus.PASS, "Customer Name field is Enabled in Kitchen Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Customer Name field is disabled in Kitchen Receipt Template");
		}
		Thread.sleep(1000);
		
		for(int i = 1; i <= 8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		//Check whether the Service Type field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServiceType']")).isSelected())
		{
			test.log(LogStatus.PASS, "Service Type field is Enabled in Kitchen Receipt Template");
			
			//Check Whether the Position is updated or not
			try
			{
				if(driver.findElement(By.xpath("//select[@ng-model='settings.serviceTypePosition']/option[.='P#2']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Position - Service Type updated successfully in Kitchen Receipt Template");
				}
			}
			catch(Exception e)
			{
				test.log(LogStatus.FAIL, "Position - Service Type updated Fail in Kitchen Receipt Template");
			}

		}
		else
		{
			test.log(LogStatus.FAIL, "Service Type field is disabled in Kitchen Receipt Template");
		}
		Thread.sleep(1000);
		
		
		//Check whether the Customer field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.splitByCourse']")).isSelected())
		{
			test.log(LogStatus.PASS, "Customer field is Enabled in Kitchen Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Customer field is disabled in Kitchen Receipt Template");
		}
		Thread.sleep(1000);
		
		
		//Check whether the Customer Information Position field - Below is enabled or not
		if(driver.findElement(By.xpath("//label[.='Customer Information Position']/../lablel[1]/input")).isSelected())
		{
			test.log(LogStatus.PASS, "Customer Information Position field is Enabled in Kitchen Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Customer Information Position field is disabled in Kitchen Receipt Template");
		}
		Thread.sleep(1000);
		
		for(int i = 1; i <= 8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		//Check whether the Address field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showAddress']")).isSelected())
		{
			test.log(LogStatus.PASS, "Address field is Enabled in Kitchen Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Address field is disabled in Kitchen Receipt Template");
		}
		Thread.sleep(1000);
		
		//Check whether the Email field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showEmail']")).isSelected())
		{
			test.log(LogStatus.PASS, "Email field is Enabled in Kitchen Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Email field is disabled in Kitchen Receipt Template");
		}
		Thread.sleep(1000);
		
		//Check whether the Phone number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showPhoneNumber']")).isSelected())
		{
			test.log(LogStatus.PASS, "Phone number field is Enabled in Kitchen Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Phone number field is disabled in Kitchen Receipt Template");
		}
		Thread.sleep(1000);
		
		//Check whether the Cut Paper After Each print field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.cutReceipt']")).isSelected())
		{
			test.log(LogStatus.PASS, "Cut Paper After Each print field is Enabled in Kitchen Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Cut Paper After Each print field is disabled in Kitchen Receipt Template");
		}
		Thread.sleep(1000);
		
		//Check whether the Print quantity before the menu name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.printQuantityBeforeMenuName']")).isSelected())
		{
			test.log(LogStatus.PASS, "Print quantity before the menu name field is Enabled in Kitchen Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Print quantity before the menu name field is disabled in Kitchen Receipt Template");
		}
		Thread.sleep(1000);
		
		for(int i = 1; i <= 8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		//Check whether the Notes field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showNotes']")).isSelected())
		{
			test.log(LogStatus.PASS, "Notes field is Enabled in Kitchen Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Notes field is disabled in Kitchen Receipt Template");
		}
		Thread.sleep(1000);
				
		//Check whether the Consolidate Menu In Kitchen field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.consolidateMenuInKitchen']")).isSelected())
		{
			test.log(LogStatus.PASS, "Consolidate Menu In Kitchen field is Enabled in Kitchen Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Consolidate Menu In Kitchen field is disabled in Kitchen Receipt Template");
		}
		Thread.sleep(1000);
		
		//Check whether the Is Other Language Menu Name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.isOtherLanguageMenuName']")).isSelected())
		{
			test.log(LogStatus.PASS, "Is Other Language Menu Name field is Enabled in Kitchen Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Is Other Language Menu Name field is disabled in Kitchen Receipt Template");
		}
		
	}
	
	@Test(priority=8,enabled = true)
	public void Email_Receipt_Template_method_open_Email_Receipt_Template(WebDriver driver) throws Exception
	{
		/*//Click the Settings option
		driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[5]/a/span[1]")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Printer Configuration']"));
		//Scroll the page till the Printer Configuration option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Store Option		
		driver.findElement(By.xpath("//span[.='Printer Configuration']")).click();*/
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"emailTemplate");
		Thread.sleep(5000);
		//Check Email Receipt Template page opened or not
		if(driver.findElement(By.xpath("//a[.='Email Receipt Template']")).getText().equalsIgnoreCase("Email Receipt Template"))
		{
			test.log(LogStatus.PASS, "Email Receipt Template page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Email Receipt Template page loaded Failed");
		}
		Thread.sleep(3000);
	}	
		
	@Test(priority=9,enabled = true)
	public void Email_Receipt_Template_method_update_Email_Receipt_Template(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Select the required Banner Background using Act Class
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//p[.='Banner Background']/..//div[7]"))).click().build().perform();

		Thread.sleep(2000);
			
		//Check whether the Store Image is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreImage']")).isSelected())
		{
			
		}
		else
		{
			//Enable the Store Image option
			driver.findElement(By.xpath("//input[@ng-model='settings.showStoreImage']/../span")).click();
		}
		
		//Check whether the Customer Feedback field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerFeedBack']")).isSelected()){
		
		}
		else
		{
			//Enable the Customer Feedback Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerFeedBack']/../span")).click();
		}
		
		//Check whether the table name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTableName']")).isSelected()){
		}
		else
		{
			//Enable the table name Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showTableName']/../span")).click();
		}
		
		//Check whether the seat number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showSeatNumber']")).isSelected()){
		}
		else
		{
			//Enable the seat number Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showSeatNumber']/../span")).click();
		}
		
		//Check whether the Server name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServerName']")).isSelected()){
		}
		else
		{
			//Enable the Server name Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showServerName']/../span")).click();
		}
		
		//Check whether the Check number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCheckNumber']")).isSelected())
		{
		}
		else
		{
			//Enable the Check number Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showCheckNumber']/../span")).click();
					
		}
		
		//Check whether the Date field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showDate']")).isSelected()){
		}
		else
		{
			//Enable the Date Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showDate']/../span")).click();
		}
			
		//Check whether the Customer name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerName']")).isSelected()){
		}
		else
		{
			//Enable the customer name Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerName']/../span")).click();
		}
		
		//Check whether the Service Type field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServiceType']")).isSelected()){
		}
		else
		{
			//Enable the Service Type Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showServiceType']/../span")).click();
		}		
		
		//Check whether the Order Summary field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showOrderSummary']")).isSelected()){
		}
		else
		{
			//Enable the Order Summary Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showOrderSummary']/../span")).click();
		}
		
		//Check whether the Show Secondary menu name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showLocalName']")).isSelected()){
		}
		else
		{
			//Enable the  Show Secondary menu name Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showLocalName']/../span")).click();
		}
		
		//Check whether the Roll Out Modifier Price To Menu field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.rollOutModifierPrice']")).isSelected()){
		}
		else
		{
			//Enable the  Roll Out Modifier Price To Menu Option
			driver.findElement(By.xpath("//input[@ng-model='settings.rollOutModifierPrice']/../span")).click();
		}
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}Thread.sleep(3000);
		
		//Check whether the Exclude zero price menu item field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.excludeZeroPriceMenu']")).isSelected()){
		}
		else
		{
			//Enable the Exclude zero price menu item Option
			driver.findElement(By.xpath("//input[@ng-model='settings.excludeZeroPriceMenu']/../span")).click();
		}
		
		//Check whether the Exclude Zero Price Modifier field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.excludeZeroPriceModifier']")).isSelected()){
		}
		else
		{
			//Enable the Exclude Zero Price Modifier item Option
			driver.findElement(By.xpath("//input[@ng-model='settings.excludeZeroPriceModifier']/../span")).click();
		}
		
		//Check whether the Tip field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTip']")).isSelected()){
		}
		else
		{
			//Enable the Tip Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showTip']/../span")).click();
		}
		
		
		//Check whether the Tax Summary field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTaxSummary']")).isSelected()){
		}
		else
		{
			//Enable the Tax Summary Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showTaxSummary']/../span")).click();
		}
		
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}Thread.sleep(3000);
		
		Thread.sleep(2000);
		//Check whether the Tender Details field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTenderDetails']")).isSelected()){
		}
		else
		{
			//Enable the Tender Details Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showTenderDetails']/../span")).click();
		}
				
		//Check whether the Signature field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showSignature']")).isSelected()){
		}
		else
		{
			//Enable the Signature Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showSignature']/../span")).click();
		}

		//Check whether the Barcode field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showBarcode']")).isSelected()){
		}
		else
		{
			//Enable the Barcode Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showBarcode']/../span")).click();
		}
		
		Thread.sleep(1000);
		//Check whether the Address field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showAddress']")).isSelected()){
		}
		else
		{
			//Enable the Address Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showAddress']/../span")).click();
		}
		
		
		//Check whether the Email field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showEmail']")).isSelected()){
		}
		else
		{
			//Enable the Email Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showEmail']/../span")).click();
		}
		
		//Check whether the Phone Number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showPhoneNumber']")).isSelected()){
		}
		else
		{
			//Enable the Phone Number Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showPhoneNumber']/../span")).click();
		}
	
		
		//Clear the free text
		driver.findElement(By.xpath("//textarea[@ng-model='settings.freeText']")).clear();
		//Enter the required text
		driver.findElement(By.xpath("//textarea[@ng-model='settings.freeText']")).sendKeys("Have a nice day, Visit us again!");
		
		
		//Check whether the Social Icons field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.showSocialIcons']")).isSelected())
		{
			//Check whether the Face book Icons field is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.facebook']")).isSelected())
			{
				
			}
			
			else
			{
				//Enable the Face book Icons Option
				driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.facebook']/../span")).click();
			}
			
			//Check whether the Twitter Icons field is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.twitter']")).isSelected())
			{
				
			}
			
			else
			{
				//Enable the Twitter Icons Option
				driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.twitter']/../span")).click();
			}
			
			//Check whether the Linked In Icons field is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.linkedin']")).isSelected())
			{
				
			}
			
			else
			{
				//Enable the Linked In Icons Option
				driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.linkedin']/../span")).click();
			}
		}
		
		else
		{
			//Enable the Social Icons Option
			driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.showSocialIcons']/../span")).click();
		
			//Check whether the Face book Icons field is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.facebook']")).isSelected())
			{
				
			}
			
			else
			{
				//Enable the Face book Icons Option
				driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.facebook']/../span")).click();
			}
			
			//Check whether the Twitter Icons field is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.twitter']")).isSelected())
			{
				
			}
			
			else
			{
				//Enable the Twitter Icons Option
				driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.twitter']/../span")).click();
			}
			
			 //Scroll the web page
		    for(int i=1; i <= 5; i++)
		    {
		    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		    	Thread.sleep(1000);
		    }
		    
			//Check whether the Linked In Icons field is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.linkedin']")).isSelected())
			{
				
			}
			
			else
			{
				//Enable the Linked In Icons Option
				driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.linkedin']/../span")).click();
			}
		}
		
		Thread.sleep(2000);
		//Check whether the Show Linga POS Promotion "Powered by Linga POS" field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showLingaPromotion']")).isSelected()){
		
		}
		else
		{
			//Enable the Show Linga POS Promotion "Powered by Linga POS" Option
			driver.findElement(By.xpath("//input[@ng-model='settings.showLingaPromotion']/../span")).click();
		}									
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		Thread.sleep(5000);
		//Click the update button
		driver.findElement(By.xpath("//button[@id='updateEmailTemplate']")).click();
		Thread.sleep(4000);
		//Check weather the new denomination form saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Email template saved successfully"))
		{
			test.log(LogStatus.PASS, "Email Receipt template saved successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Email Receipt template saved fail");
		}
		Thread.sleep(4000);
		
	
	}

	@Test(priority=10,enabled = true)
	public void Verify_Email_Receipt_Template_method_update_Email_Receipt_Template(WebDriver driver) throws Exception
	{

		Thread.sleep(2000);
			
		//Check whether the Store Image is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreImage']")).isSelected())
		{
			test.log(LogStatus.PASS, "Store Image Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Image Field is Disabled in the Email Receipt Template");
		}
		
		//Check whether the Customer Feedback field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerFeedBack']")).isSelected())
		{
			test.log(LogStatus.PASS, "Customer Feedback Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Customer Feedback Field is Disabled in the Email Receipt Template");
		}
		
		//Check whether the table name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTableName']")).isSelected())
		{
			test.log(LogStatus.PASS, "Table Name Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Table Name Field is Disabled in the Email Receipt Template");
		}
		
		//Check whether the seat number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showSeatNumber']")).isSelected())
		{
			test.log(LogStatus.PASS, "Seat Number Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Seat Number Field is Disabled in the Email Receipt Template");
		}
		
		//Check whether the Server name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServerName']")).isSelected())
		{
			test.log(LogStatus.PASS, "Server Name Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Server Name Field is Disabled in the Email Receipt Template");
		}
		
		//Check whether the Check number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCheckNumber']")).isSelected())
		{
			test.log(LogStatus.PASS, "Check number Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Check number Field is Disabled in the Email Receipt Template");
		}
		
		//Check whether the Date field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showDate']")).isSelected())
		{
			test.log(LogStatus.PASS, "Date Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Date Field is Disabled in the Email Receipt Template");
		}
			
		//Check whether the Customer name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerName']")).isSelected())
		{
			test.log(LogStatus.PASS, "Customer name Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Customer name Field is Disabled in the Email Receipt Template");
		}
		
		//Check whether the Service Type field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServiceType']")).isSelected())
		{
			test.log(LogStatus.PASS, "Service Type Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Type Field is Disabled in the Email Receipt Template");
		}		
		
		//Check whether the Order Summary field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showOrderSummary']")).isSelected())
		{
			test.log(LogStatus.PASS, "Order Summary Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Order Summary Field is Disabled in the Email Receipt Template");
		}
		
		//Check whether the Show Secondary menu name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showLocalName']")).isSelected())
		{
			test.log(LogStatus.PASS, "Show Secondary menu name Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Show Secondary menu name Field is Disabled in the Email Receipt Template");
		}
		
		//Check whether the Roll Out Modifier Price To Menu field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.rollOutModifierPrice']")).isSelected())
		{
			test.log(LogStatus.PASS, "Roll Out Modifier Price To Menu Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Roll Out Modifier Price To Menu Field is Disabled in the Email Receipt Template");
		}
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		//Check whether the Exclude zero price menu item field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.excludeZeroPriceMenu']")).isSelected())
		{
			test.log(LogStatus.PASS, "Exclude zero price menu item Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Exclude zero price menu item Field is Disabled in the Email Receipt Template");
		}
		
		//Check whether the Exclude Zero Price Modifier field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.excludeZeroPriceModifier']")).isSelected())
		{
			test.log(LogStatus.PASS, "Exclude Zero Price Modifier Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Exclude Zero Price Modifier Field is Disabled in the Email Receipt Template");
		}
		
		//Check whether the Tip field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTip']")).isSelected())
		{
			test.log(LogStatus.PASS, "Tip Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Field is Disabled in the Email Receipt Template");
		}
		
		
		//Check whether the Tax Summary field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTaxSummary']")).isSelected())
		{
			test.log(LogStatus.PASS, "Tax Summary Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Summary Field is Disabled in the Email Receipt Template");
		}
		
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		//Check whether the Tender Details field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTenderDetails']")).isSelected())
		{
			test.log(LogStatus.PASS, "Tender Details Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tender Details Field is Disabled in the Email Receipt Template");
		}
				
		//Check whether the Signature field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showSignature']")).isSelected())
		{
			test.log(LogStatus.PASS, "Signature Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Signature Field is Disabled in the Email Receipt Template");
		}

		//Check whether the Barcode field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showBarcode']")).isSelected())
		{
			test.log(LogStatus.PASS, "Barcode Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Barcode Field is Disabled in the Email Receipt Template");
		}
		
		
		//Check whether the Address field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showAddress']")).isSelected())
		{
			test.log(LogStatus.PASS, "Address Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Address Field is Disabled in the Email Receipt Template");
		}
		
		//Check whether the Email field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showEmail']")).isSelected())
		{
			test.log(LogStatus.PASS, "Email Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Email Field is Disabled in the Email Receipt Template");
		}
		
		//Check whether the Phone Number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showPhoneNumber']")).isSelected())
		{
			test.log(LogStatus.PASS, "Phone Number Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Phone Number Field is Disabled in the Email Receipt Template");
		}
	
		
		//Clear the free text
		driver.findElement(By.xpath("//textarea[@ng-model='settings.freeText']")).clear();
		//Enter the required text
		driver.findElement(By.xpath("//textarea[@ng-model='settings.freeText']")).sendKeys("Have a nice day, Visit us again!");
		
		
		//Check whether the Social Icons field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.showSocialIcons']")).isSelected())
		{
			test.log(LogStatus.PASS, "Social Icons Field is Enabled in the Email Receipt Template");
			//Check whether the Face book Icons field is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.facebook']")).isSelected())
			{
				test.log(LogStatus.PASS, "Face book Icons Field is Enabled in the Email Receipt Template");
			}
			else
			{
				test.log(LogStatus.FAIL, "Face book Icons Field is Disabled in the Email Receipt Template");
			}
			
			//Check whether the Twitter Icons field is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.twitter']")).isSelected())
			{
				test.log(LogStatus.PASS, "Twitter Icons Field is Enabled in the Email Receipt Template");
			}
			else
			{
				test.log(LogStatus.FAIL, "Twitter Icons Field is Disabled in the Email Receipt Template");
			}
			
			//Check whether the Linked In Icons field is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.linkedin']")).isSelected())
			{
				test.log(LogStatus.PASS, "Linked In Icons Field is Enabled in the Email Receipt Template");
			}
			else
			{
				test.log(LogStatus.FAIL, "Linked In Icons Field is Disabled in the Email Receipt Template");
			}
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Social Icons Field is Disabled in the Email Receipt Template");
		}
		
		
		//Check whether the Show Linga POS Promotion "Powered by Linga POS" field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showLingaPromotion']")).isSelected())
		{
			test.log(LogStatus.PASS, "Show Linga POS Promotion 'Powered by Linga POS' Field is Enabled in the Email Receipt Template");
		}
		else
		{
			test.log(LogStatus.FAIL, "Show Linga POS Promotion 'Powered by Linga POS' Field is Disabled in the Email Receipt Template");
		}									

		Thread.sleep(5000);
		
	}
	
	@Test(priority=11,enabled = true)
	public void Kitchen_Printer_method_open_Kitchen_Printer(WebDriver driver) throws Exception
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
	public void Kitchen_Printer_method_refreshKitchen_Printer(WebDriver driver) throws InterruptedException
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
	public void Kitchen_Printer_method_pagination(WebDriver driver) throws InterruptedException
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
	public void Kitchen_Printer_method_add_Kitchen_Printer(WebDriver driver) throws Exception
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
	public void Kitchen_Printer_method_edit_Kitchen_Printer(WebDriver driver) throws Exception
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
	public void Kitchen_Printer_method_delete_Kitchen_Printer(WebDriver driver) throws Exception
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
	public void Kitchen_Printer_method_close_Button(WebDriver driver) throws Exception
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

	@Test(priority=18,enabled = true)
	public void Receipt_Printer_method_open_Receipt_Printer(WebDriver driver) throws Exception
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
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"receiptPrinters");
		Thread.sleep(5000);
		//Check receipt Printer page opened or not
		if(driver.findElement(By.xpath("//a[.='Receipt printers']")).getText().equalsIgnoreCase("Receipt printers"))
		{
			test.log(LogStatus.PASS, "Receipt printers page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Receipt printers page loaded Failed");
		}
		Thread.sleep(3000);
	}	
			
	@Test(priority=19,enabled = true)
	public void Receipt_Printer_method_refreshReceipt_Printer(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/a/i")).click();
		
		Thread.sleep(5000);
		//Check Kitchen Printer page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Receipt Printers"))
		{
			test.log(LogStatus.PASS, "Receipt Printer page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Receipt Printer page refreshed Failed");
		}
	}
	
	@Test(priority=20,enabled = true)
	public void Receipt_Printer_method_pagination(WebDriver driver) throws InterruptedException
	{
						
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Pagination option as 10
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[2]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Receipt Printer");
		//Create the web element for Receipt Printer Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Receipt Printer");
		}
		Thread.sleep(5000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[3]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Receipt Printer");
		//Create the web element for Receipt Printer Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Receipt Printer");
		}
		Thread.sleep(5000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[4]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for Receipt Printer");
		//Create the web element for Receipt Printer Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Receipt Printer");
		}
		Thread.sleep(5000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[1]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Receipt Printer");
		//Create the web element for Receipt Printer Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Receipt Printer");
		}
		Thread.sleep(5000);
	}
		
	@Test(priority=21,enabled = true)
	public void Receipt_Printer_method_add_Receipt_Printer(WebDriver driver) throws Exception
	{
		for(int i = 0; i <= 10; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(5000);
		//Click Add Receipt Printer Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/button")).click();
		
		Thread.sleep(3000);
		//Check New Kitchen Printer form opened or not
		if(driver.findElement(By.xpath("//span[.='New Receipt Printer']")).getText().equalsIgnoreCase("New Receipt Printer"))
		{
			test.log(LogStatus.PASS, "Receipt printer form opened Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Receipt printer form opened Failed");
		}
		Thread.sleep(5000);
		//Clear the name field
		driver.findElement(By.name("name")).clear();
		//Enter the name
		driver.findElement(By.name("name")).sendKeys("New_Receipt_Print");
		
		Thread.sleep(1000);
		//Click Printer Model
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[2]/div/a")).click();
		//Select the Printer
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[2]/div/div/div/input")).sendKeys("Epson - TM-T88IV");
		//Enter the Printer 
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1000);
		//Clear the IP Address field
		driver.findElement(By.name("IPAddress")).clear();
		//Enter the IP Address
		driver.findElement(By.name("IPAddress")).sendKeys("192.168.11.11");
		
		
		Thread.sleep(5000);
		//Check whether the default option is enable or not
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[4]/label/span")).click();
		
	
		Thread.sleep(2000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@id='saveReceipt']")).click();
		Thread.sleep(2000);
		
		//Check whether the Receipt printer was saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Printer saved successfully"))
		{
			test.log(LogStatus.PASS, "Receipt Printer Saved successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Receipt Printer Saved fail");
		}
		Thread.sleep(3000);

	}
	
	@Test(priority=22,enabled = true)
	public void Receipt_Printer_method_edit_Receipt_Printer(WebDriver driver) throws Exception
	{
		Thread.sleep(2000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required key word
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("New_Receipt_Print");
		
		Thread.sleep(1000);
		//Click the Edit button
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(5000);
		//Clear the name field
		driver.findElement(By.name("name")).clear();
		//Enter the name
		driver.findElement(By.name("name")).sendKeys("New_Receipt_Print1");
		
		Thread.sleep(1000);
		//Click Printer Model
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[2]/div/a")).click();
		//Select the Printer
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[2]/div/div/div/input")).sendKeys("Epson - TM-T88IV");
		//Enter the Printer 
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(5000);
		//Clear the IP Address field
		driver.findElement(By.name("IPAddress")).clear();
		//Enter the IP Address
		driver.findElement(By.name("IPAddress")).sendKeys("192.168.11.12");
		
		
		Thread.sleep(5000);
		//Check whether the default option is enable or not
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[4]/label/span")).click();
		
		Thread.sleep(2000);
		//Click the Update button
		driver.findElement(By.xpath("//button[@id='saveReceipt']")).click();
		Thread.sleep(2000);
		
		//Check whether the Receipt printer was updated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Printer updated successfully"))
		{
			test.log(LogStatus.PASS, "Receipt Printer Updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Receipt Printer Updated fail");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=23,enabled = true)
	public void Receipt_Printer_method_delete_Receipt_Printer(WebDriver driver) throws Exception
	{
		Thread.sleep(2000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required key word
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("New_Receipt_Print1");
		
		Thread.sleep(1000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check the Kitchen Printer deleted or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Printer deleted successfully"))
		{
			test.log(LogStatus.PASS, "New Receipt Printer is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Receipt Printer is deleted Failed");
		}
		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
	}
	
	@Test(priority=24,enabled = true)
	public void Receipt_Printer_method_close_Button(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click Add Receipt Printer Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/button")).click();
		
		Thread.sleep(3000);
		//Check New Kitchen Printer form opened or not
		if(driver.findElement(By.xpath("//span[.='New Receipt Printer']")).getText().equalsIgnoreCase("New Receipt Printer"))
		{
			test.log(LogStatus.PASS, "Receipt printer form opened Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Receipt printer form opened Failed");
		}
		Thread.sleep(3000);
		

		//Clear the name field
		driver.findElement(By.name("name")).clear();
		//Enter the name
		driver.findElement(By.name("name")).sendKeys("New_Receipt_Print");
		
	
		Thread.sleep(2000);
		//Click the Close button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		Thread.sleep(2000);
		
		//Check whether the Kitchen printer form was closed or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/button")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Receipt Printer form Closed successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Receipt Printer form Closed fail");
		}
		Thread.sleep(3000);

	}

	@Test(priority=25,enabled = true)
	public void Label_Printer_method_open_Label_Printer(WebDriver driver) throws Exception
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
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"labelPrinters");
		Thread.sleep(5000);

		//Check Label Printer page opened or not
		if(driver.findElement(By.xpath("//a[.='Label printers']")).getText().equalsIgnoreCase("Label printers"))
		{
			test.log(LogStatus.PASS, "Label printers page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Label printers page loaded Failed");
		}
		Thread.sleep(3000);
	}	
			
	@Test(priority=26,enabled = true)
	public void Label_Printer_method_refreshLabel_Printer(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/a/i")).click();
		
		Thread.sleep(5000);
		//Check Label Printer page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Label Printers"))
		{
			test.log(LogStatus.PASS, "Label Printer page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Label Printer page refreshed Failed");
		}
	}
	
	@Test(priority=27,enabled = true)
	public void Label_Printer_method_pagination(WebDriver driver) throws InterruptedException
	{
						
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Pagination option as 10
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[2]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Lable Printer");
		//Create the web element for Label Printer Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Lable Printer");
		}
		Thread.sleep(5000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[3]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Lable Printer");
		//Create the web element for Label Printer Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Lable Printer");
		}
		Thread.sleep(5000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[4]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for Lable Printer");
		//Create the web element for Label Printer Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Lable Printer");
		}
		Thread.sleep(5000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[1]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Lable Printer");
		//Create the web element for Label Printer Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[1]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Lable Printer");
		}
		Thread.sleep(5000);
	}
		
	@Test(priority=28,enabled = true)
	public void Label_Printer_method_add_Label_Printer(WebDriver driver) throws Exception
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
		//Check New Label Printer form opened or not
		if(driver.findElement(By.xpath("//span[.='New Label Printer']")).getText().equalsIgnoreCase("New Label Printer"))
		{
			test.log(LogStatus.PASS, "Label printer form opened Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Label printer form opened Failed");
		}
		Thread.sleep(3000);
		
		//Click the Types Option
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[1]/div/a")).click();
		//Enter the required type
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[1]/div/div/div/input")).sendKeys("Menu");
		//Press Enter button
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the name field
		driver.findElement(By.name("name")).clear();
		//Enter the name
		driver.findElement(By.name("name")).sendKeys("New_Label_Print");
		
		Thread.sleep(2000);
		//Click the Printer model
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[3]/div/a")).click();
		//Click
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[3]/div/div/div/input")).click();
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
				
		Thread.sleep(1000);
		//Clear the IP Address field
		driver.findElement(By.name("IPAddress")).clear();
		//Enter the IP Address
		driver.findElement(By.name("IPAddress")).sendKeys("192.168.17.11");
		
		Thread.sleep(2000);
		//Click the Alternate Printer model
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[5]/div/a")).click();
		//Click
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[5]/div/div/div/input")).click();
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[5]/div/div/div/input")).sendKeys(Keys.ENTER);

		
		Thread.sleep(1000);
		//Check whether the Enable Service Type Restriction option is enable or not
		if(driver.findElement(By.name("enableServiceTypeRestriction")).isSelected())
		{
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("QSR");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("ToGo");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("WEBORDER");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
		}
		
		else
		{
			Thread.sleep(1000);
			//Enable or disable service type
			driver.findElement(By.name("enableServiceTypeRestriction")).click();
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("QSR");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("ToGo");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("WEBORDER");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
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
				//driver.findElement(By.partialLinkText("Yes")).click();
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
		driver.findElement(By.xpath("//button[@id='saveLabel']")).click();
		Thread.sleep(4000);driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Check whether the Kitchen printer was saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Printer saved successfully"))
		{
			test.log(LogStatus.PASS, "Label Printer Saved successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Label Printer Saved fail");
		}
		Thread.sleep(3000);

	}
	
	@Test(priority=29,enabled = true)
	public void Label_Printer_method_edit_Label_Printer(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required key word
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("New_Label_Print");
		
		Thread.sleep(1000);
		//Click the Edit button
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(5000);
		//Click the Types Option
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[1]/div/a")).click();
		//Enter the required type
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[1]/div/div/div/input")).sendKeys("Address");
		//Press Enter button
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the name field
		driver.findElement(By.name("name")).clear();
		//Enter the name
		driver.findElement(By.name("name")).sendKeys("New_Label_Print1");
		
		Thread.sleep(1000);
		//Clear the IP Address field
		driver.findElement(By.name("IPAddress")).clear();
		//Enter the IP Address
		driver.findElement(By.name("IPAddress")).sendKeys("192.168.17.12");
		Thread.sleep(4000);
/*		//Click the Types Option
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[5]/div/a")).click();
		//Enter the required type
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[5]/div/div/div/input")).click();
		//Press Enter button
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[5]/div/div/div/input")).sendKeys(Keys.ENTER);
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
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("DELIVERY");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("FORHERE");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("PHONEORDER");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
		}
		
		else
		{
			Thread.sleep(1000);
			//Enable or disable service type
			driver.findElement(By.name("enableServiceTypeRestriction")).click();
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("DELIVERY");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("FORHERE");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys("PHONEORDER");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@ng-if='labelPrinter.enableServiceTypeRestriction']/div/ul/li/input")).sendKeys(Keys.ENTER);
			
		}
		
		Thread.sleep(2000);
		//Click the Update button
		driver.findElement(By.xpath("//button[@id='saveLabel']")).click();
		Thread.sleep(4000);driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Check whether the Kitchen printer was updated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Printer updated successfully"))
		{
			test.log(LogStatus.PASS, "Label Printer Updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Label Printer Updated fail");
		}
		Thread.sleep(3000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(2000);
	}
	
	@Test(priority=30,enabled = true)
	public void Label_Printer_method_delete_Label_Printer(WebDriver driver) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required key word
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("New_Label_Print1");
		
		Thread.sleep(1000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		Thread.sleep(4000);driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Check the Kitchen Printer deleted or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Printer deleted successfully"))
		{
			test.log(LogStatus.PASS, "New Label Printer is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Label Printer is deleted Failed");
		}
		Thread.sleep(3000);
		
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required key word
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("New_Label_Print1");
		
		Thread.sleep(2000);
		try{
			if(driver.findElement(By.xpath("//td[contains(.,'New_Label_Print1')]")).isDisplayed())
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
	
	@Test(priority=31,enabled = true)
	public void Label_Printer_method_close_Button(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click Add Label Printer Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/button")).click();
		
		Thread.sleep(3000);
		//Check New Label Printer form opened or not
		if(driver.findElement(By.xpath("//span[.='New Label Printer']")).getText().equalsIgnoreCase("New Label Printer"))
		{
			test.log(LogStatus.PASS, "Label printer form opened Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Label printer form opened Failed");
		}
		Thread.sleep(3000);
		
		//Click the Types Option
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[1]/div/a")).click();
		//Enter the required type
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[1]/div/div/div/input")).sendKeys("Address");
		//Press Enter button
		driver.findElement(By.xpath("//form[@name='labelPrinterCreation']/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the name field
		driver.findElement(By.name("name")).clear();
		//Enter the name
		driver.findElement(By.name("name")).sendKeys("New_Label_Print");
		
	
		Thread.sleep(2000);
		//Click the Close button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		Thread.sleep(2000);
		
		//Check whether the Label printer form was closed or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/button")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Label Printer form Closed successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Label Printer form Closed fail");
		}
		Thread.sleep(3000);

	}

	@Test(priority=32,enabled = true)
	public void Kitchen_Label_Template_method_open_Kitchen_Label_Template(WebDriver driver) throws Exception
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
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"kitchenLabelTemplate");
		Thread.sleep(5000);
		//Check Kitchen Label Template page opened or not
		if(driver.findElement(By.xpath("//a[.='Label Template']")).getText().equalsIgnoreCase("Label Template"))
		{
			test.log(LogStatus.PASS, "Kitchen Label Template page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen Label Template page loaded Failed");
		}
		Thread.sleep(3000);
	}	
		
	@Test(priority=33,enabled = true)
	public void Kitchen_Label_Template_method_update_Kitchen_Label_Template(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Width Field
		driver.findElement(By.xpath("//input[@ng-model='settings.width']")).clear();
		//Enter the required Width Field
		driver.findElement(By.xpath("//input[@ng-model='settings.width']")).sendKeys("1");
		
		Thread.sleep(2000);
		//Clear the Height field
		driver.findElement(By.xpath("//input[@ng-model='settings.height']")).clear();
		//Enter the required Height field
		driver.findElement(By.xpath("//input[@ng-model='settings.height']")).sendKeys("2");
		
		Thread.sleep(2000);
		//Select Header Font Size
		Select fontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSize_H']")));
		fontSize.selectByVisibleText("2 width");
		
		 Thread.sleep(2000);
		//Check whether the Show Date & Time enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showDateTime']")).isSelected())
        {}
        else
        {
        	//Enable the Show Date & Time
        driver.findElement(By.xpath("//input[@ng-model='settings.showDateTime']/../span")).click();
        }
       
       //Check whether the Order Type is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showOrderType']")).isSelected())
		{}
		else
		{
			//Enable the Order Type option
			driver.findElement(By.xpath("//input[@ng-model='settings.showOrderType']/../span")).click();	
		}
				
		//Check whether the Sale number is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTicketNo']")).isSelected())
		{}
		else
		{
			//Enable the SAle Number option
			driver.findElement(By.xpath("//input[@ng-model='settings.showTicketNo']/../span")).click();
		}		
		
		//Check whether the Order number is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showOrderNo']")).isSelected())
		{}
		else
		{
			//Enable the Order Number option
			driver.findElement(By.xpath("//input[@ng-model='settings.showOrderNo']/../span")).click();
		}
		
		//Check whether the Customer Name is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerName']")).isSelected())
		{}
		else
		{
			//Enable the Customer Name option
			driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerName']/../span")).click();
		}
		
		Select fontSize1 = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSize_T']")));
		fontSize1.selectByVisibleText("2 width");
		
		
		Select fontSize2 = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSize_B']")));
		fontSize2.selectByVisibleText("2 width");
		
		for(int i = 1; i <= 8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		Thread.sleep(2000);
		//Check whether the Autocut is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.enableAutoCut']")).isSelected())
		{}
		else
		{
			//Enable the Autocut option
			driver.findElement(By.xpath("//input[@ng-model='settings.enableAutoCut']/../span")).click();
		}
		
		//Check whether the Show line seperator in Header is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.lineSeparatorForHeader']")).isSelected())
		{}
		else
		{
			//Enable the Show line seperator in Header option
			driver.findElement(By.xpath("//input[@ng-model='settings.lineSeparatorForHeader']/../span")).click();
		}
		
		//Check whether the Show line seperator in Footer is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.lineSeparatorForFooter']")).isSelected())
		{}
		else
		{
			//Enable the Show line seperator in Footer option
			driver.findElement(By.xpath("//input[@ng-model='settings.lineSeparatorForFooter']/../span")).click();
		}
		Thread.sleep(5000);
		
		//Click the update button
		driver.findElement(By.xpath("//button[@id='UpdateLabelT']")).click();
		Thread.sleep(4000);
		
		//Check weather the new Label Template updated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Label template saved successfully"))
		{
			test.log(LogStatus.PASS, "Kitchen Label template Updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen Label template Updated fail");
		}
		Thread.sleep(3000);
	}

	@Test(priority=34,enabled = true)
	public void Verify_Kitchen_Label_Template_method_Kitchen_Label_Template(WebDriver driver) throws Exception
	{
		
		 Thread.sleep(2000);
		//Check whether the Show Date & Time enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showDateTime']")).isSelected())
        {
			test.log(LogStatus.PASS, "Show Date & Time enabled in Kitchen Label Template");
        }
        else
        {
        	test.log(LogStatus.FAIL, "Show Date & Time disabled in Kitchen Label Template");
        }
       
       //Check whether the Order Type is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showOrderType']")).isSelected())
		{
			test.log(LogStatus.PASS, "Order Type enabled in Kitchen Label Template");
        }
        else
        {
        	test.log(LogStatus.FAIL, "Order Type disabled in Kitchen Label Template");
        }
				
		//Check whether the Sale number is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTicketNo']")).isSelected())
		{
			test.log(LogStatus.PASS, "Sale number enabled in Kitchen Label Template");
        }
        else
        {
        	test.log(LogStatus.FAIL, "Sale number disabled in Kitchen Label Template");
        }

		Thread.sleep(3000);
		//Check whether the Order number is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showOrderNo']")).isSelected())
		{
			test.log(LogStatus.PASS, "Order number enabled in Kitchen Label Template");
        }
        else
        {
        	test.log(LogStatus.FAIL, "Order number disabled in Kitchen Label Template");
        }
		
		//Check whether the Customer Name is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerName']")).isSelected())
		{
			test.log(LogStatus.PASS, "Customer Name enabled in Kitchen Label Template");
        }
        else
        {
        	test.log(LogStatus.FAIL, "Customer Name disabled in Kitchen Label Template");
        }
		
		for(int i = 1; i <= 8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}Thread.sleep(3000);
		
		//Check whether the Autocut is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.enableAutoCut']")).isSelected())
		{
			test.log(LogStatus.PASS, "Autocut enabled in Kitchen Label Template");
        }
        else
        {
        	test.log(LogStatus.FAIL, "Autocut disabled in Kitchen Label Template");
        }
		
		//Check whether the Show line seperator in Header is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.lineSeparatorForHeader']")).isSelected())
		{
			test.log(LogStatus.PASS, "Show line seperator in Header enabled in Kitchen Label Template");
        }
        else
        {
        	test.log(LogStatus.FAIL, "Show line seperator in Header disabled in Kitchen Label Template");
        }
		
		//Check whether the Show line seperator in Footer is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.lineSeparatorForFooter']")).isSelected())
		{
			test.log(LogStatus.PASS, "Show line seperator in Footer enabled in Kitchen Label Template");
        }
        else
        {
        	test.log(LogStatus.FAIL, "Show line seperator in Footer disabled in Kitchen Label Template");
        }
		Thread.sleep(5000);

	}

	@Test(priority=35,enabled = true)
	public void Label_Template_method_open_Label_Template(WebDriver driver) throws Exception
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
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"labelTemplate");
		Thread.sleep(5000);		
		//Click Right Home arrow button
		//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/scrollable-tabset/div/button[2]")).click();
/*		driver.findElement(By.xpath("//div[@class='ui-tabs-scrollable']/button[2]")).click();
		driver.findElement(By.xpath("//div[@class='ui-tabs-scrollable']/button[2]")).click();*/

		//Check Label Template page opened or not
		if(driver.findElement(By.xpath("//a[.='Label Template']")).getText().equalsIgnoreCase("Label Template"))
		{
			test.log(LogStatus.PASS, "Label Template page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Label Template page loaded Failed");
		}
		Thread.sleep(3000);
	}	
		
	@Test(priority=36,enabled = true)
	public void Label_Template_method_update_Label_Template(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		Select template = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.position']")));
		template.selectByVisibleText("Template#0");
	
		//Clear the Width Field
		driver.findElement(By.xpath("//input[@ng-model='settings.width']")).clear();
		//Enter the required Width Field
		driver.findElement(By.xpath("//input[@ng-model='settings.width']")).sendKeys("3");
		
		
		//Clear the Height field
		driver.findElement(By.xpath("//input[@ng-model='settings.height']")).clear();
		//Enter the required Height field
		driver.findElement(By.xpath("//input[@ng-model='settings.height']")).sendKeys("3");
				
		Thread.sleep(3000);
		Select headerFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeH']")));
		headerFontSize.selectByVisibleText("2 width");
		
		Thread.sleep(3000);
		Select customerFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeC']")));
		customerFontSize.selectByVisibleText("Normal");
		
		//Scroll the web page
	    for(int i=1; i <= 10; i++)
	    {
	    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	    }
		Thread.sleep(3000);
		Select menuFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeMenu']")));
		menuFontSize.selectByVisibleText("Normal");
		
		Thread.sleep(3000);
		Select modifierFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeM']")));
		modifierFontSize.selectByVisibleText("Normal");
		
		Thread.sleep(2000);
		Select FontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSize']")));
		FontSize.selectByVisibleText("2 width");
			
		//Check Whether the Autocut is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.enableAutoCut']")).isSelected())
		{
			
		}
		else
		{
			Thread.sleep(3000);
			//Check whether the Autocut is enabled or not
			driver.findElement(By.xpath("//input[@ng-model='settings.enableAutoCut']/../span")).click();
		}
		
		Thread.sleep(3000);
		//Click the update button
		driver.findElement(By.xpath("//button[@id='UpdateLabelT']")).click();
		
		Thread.sleep(3000);
		//Check weather the new Label Template updated or not
				if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Delivery label template saved successfully"))
				{
					test.log(LogStatus.PASS, "Label template Updated successfully for Template#0");
				}
				else
				{
					test.log(LogStatus.FAIL, "Label template Updated fail for Template#0");
				}
				Thread.sleep(3000);
							
		
	}
	
	@Test(priority=37,enabled = true)
	public void Label_Template_method_update_Label_Template1(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		Select template = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.position']")));
		template.selectByVisibleText("Template#1");
	
		//Clear the Width Field
		driver.findElement(By.xpath("//input[@ng-model='settings.width']")).clear();
		//Enter the required Width Field
		driver.findElement(By.xpath("//input[@ng-model='settings.width']")).sendKeys("2.5");
		
		
		//Clear the Height field
		driver.findElement(By.xpath("//input[@ng-model='settings.height']")).clear();
		//Enter the required Height field
		driver.findElement(By.xpath("//input[@ng-model='settings.height']")).sendKeys("2");
				
		Thread.sleep(2000);
		Select headerFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeH']")));
		headerFontSize.selectByVisibleText("Normal");
		
		Thread.sleep(2000);
		Select customerFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeC']")));
		customerFontSize.selectByVisibleText("Normal");
		
		Thread.sleep(2000);
		Select menuFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeMenu']")));
		menuFontSize.selectByVisibleText("Normal");
		
		Thread.sleep(2000);
		Select modifierFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeM']")));
		modifierFontSize.selectByVisibleText("Normal");
		
		//Scroll the web page
	    for(int i=1; i <= 10; i++)
	    {
	    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	    }
	    
		Thread.sleep(2000);
		Select addressFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeA']")));
		addressFontSize.selectByVisibleText("Normal");
		
		Thread.sleep(2000);
		Select deliveryNoteFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeH']")));
		deliveryNoteFontSize.selectByVisibleText("Normal");
		
		//Check Whether the Autocut is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.enableAutoCut']")).isSelected())
		{
			
		}
		else
		{
			Thread.sleep(3000);
			//Check whether the Autocut is enabled or not
			driver.findElement(By.xpath("//input[@ng-model='settings.enableAutoCut']/../span")).click();
		}
		
		Thread.sleep(5000);
		//Click the update button
		driver.findElement(By.xpath("//button[@id='UpdateLabelT']")).click();
		
		
		Thread.sleep(4000);
		//Check weather the new Label Template updated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Delivery label template saved successfully"))
		{
			test.log(LogStatus.PASS, "Label template Updated successfully for Template#1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Label template Updated fail for Template#1");
		}
		Thread.sleep(3000);
		
				
	}
	
	@Test(priority=38,enabled = true)
	public void Label_Template_method_update_Label_Template2(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		Select template = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.position']")));
		template.selectByVisibleText("Template#2");
	
		//Clear the Width Field
		driver.findElement(By.xpath("//input[@ng-model='settings.width']")).clear();
		//Enter the required Width Field
		driver.findElement(By.xpath("//input[@ng-model='settings.width']")).sendKeys("2.5");
		
		
		//Clear the Height field
		driver.findElement(By.xpath("//input[@ng-model='settings.height']")).clear();
		//Enter the required Height field
		driver.findElement(By.xpath("//input[@ng-model='settings.height']")).sendKeys("3");
				
		Thread.sleep(2000);
		Select headerFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeH']")));
		headerFontSize.selectByVisibleText("2 width");
		
		Thread.sleep(2000);
		Select customerFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeC']")));
		customerFontSize.selectByVisibleText("2 width");
		
		Thread.sleep(2000);
		Select menuFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeMenu']")));
		menuFontSize.selectByVisibleText("Normal");
		
		Thread.sleep(2000);
		Select modifierFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeM']")));
		modifierFontSize.selectByVisibleText("Emphasis");
		
		 //Scroll the web page
	    for(int i=1; i <= 10; i++)
	    {
	    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	    }
	    
		
		Thread.sleep(2000);
		Select addressFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeA']")));
		addressFontSize.selectByVisibleText("Normal");
		
		Thread.sleep(2000);
		Select deliveryNoteFontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSizeH']")));
		deliveryNoteFontSize.selectByVisibleText("2 width");
		
		//Check Whether the Autocut is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.enableAutoCut']")).isSelected())
		{
			
		}
		else
		{
			Thread.sleep(3000);
			//Check whether the Autocut is enabled or not
			driver.findElement(By.xpath("//input[@ng-model='settings.enableAutoCut']/../span")).click();
		}	
		
		Thread.sleep(5000);
		//Click the update button
		driver.findElement(By.xpath("//button[@id='UpdateLabelT']")).click();
		
		Thread.sleep(4000);
		//Check weather the new Label Template updated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Delivery label template saved successfully"))
		{
			test.log(LogStatus.PASS, "Label template Updated successfully for Template#2");
		}
		else
		{
			test.log(LogStatus.FAIL, "Label template Updated fail for Template#2");
		}
		Thread.sleep(3000);
		
				
	}

	@Test(priority=50)
	public void Printer_Reroute_Open_Printer_Reroute(WebDriver driver) throws Exception
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
		driver.findElement(By.xpath("//span[.='Printer Configuration']")).click();
		Thread.sleep(5000);*/
/*		
	
		
		//Check Front End Receipt page opened or not
		if(driver.findElement(By.xpath("//a[.='Front End Receipt Template']")).getText().equalsIgnoreCase("Front End Receipt Template"))
		{
			test.log(LogStatus.PASS, "Front End Receipt Template page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Front End Receipt Template page loaded Failed");
		}
		
		Thread.sleep(4000);
		*/
		Thread.sleep(3000);
		//Click the Printer Reroute
		//driver.findElement(By.xpath("//span[.='Printer Reroute']")).click();

		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"printerReroute");
		Thread.sleep(5000);	
		Thread.sleep(3000);
		//Check Printer Reroute page opened or not
		if(driver.findElement(By.xpath("//a[.='Printer Reroute List']")).getText().equalsIgnoreCase("Printer Reroute List"))
		{
			test.log(LogStatus.PASS, "Printer Reroute List page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute List page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=51)
	public void Printer_Reroute_refresh_Page(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/a/i")).click();
		
		Thread.sleep(5000);
		//Check Printer Reroute page opened or not
		if(driver.findElement(By.xpath("//a[.='Printer Reroute List']")).getText().equalsIgnoreCase("Printer Reroute List"))
		{
			test.log(LogStatus.PASS, "Printer Reroute page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute page refreshed Failed");
		}
	}
	
	@Test(priority=52)
	public void Printer_Reroute_pagination(WebDriver driver) throws InterruptedException
	{

		
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Pagination option as 10
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/div/div/div/ul/li[2]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Printer Reroute");
		//Create the web element for Receipt Printer Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Printer Reroute");
		}
		Thread.sleep(4000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/div/div/div/ul/li[3]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Printer Reroute");
		//Create the web element for Receipt Printer Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Printer Reroute");
		}
		Thread.sleep(4000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/div/div/div/ul/li[4]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for Printer Reroute");
		//Create the web element for Receipt Printer Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Printer Reroute");
		}
		Thread.sleep(4000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/div/div/div/ul/li[1]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Printer Reroute");
		//Create the web element for Receipt Printer Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div[2]/table"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Printer Reroute");
		}
		Thread.sleep(4000);
	
	}
	
	@Test(priority=53)
	public void Printer_Reroute_Add_Printer_Reroute_By_Node(WebDriver driver) throws Exception
	{
		for(int i = 0; i <= 10; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(5000);
		//Select the Re-routing Method
		Select for_Node = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/select")));
		for_Node.selectByVisibleText("Reroute By Node");
		
		Thread.sleep(2000);
		//Click the Add by Node Printer Re-routing button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/button")).click();
		
		Thread.sleep(10000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//a[.='Create Printer Reroute']")).getText().equalsIgnoreCase("Create Printer Reroute"))
		{
			test.log(LogStatus.PASS, "Create New Printer Reroute for Node form loaded Successully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Create New Printer Reroute for Node form loaded Fail");
		}
		Thread.sleep(2000);
		
		//Click the Node Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/a")).click();
		//Enter the Required Node
		//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/div/div/input")).sendKeys("A001");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		String node = driver.findElement(By.xpath("//form[@name='printerForm']/div/div[1]/div/div/a/span")).getText();
		node.length();
		
		//Click the From Printer Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[2]/div/div/a")).click();
		//Enter the Required From Printer
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[2]/div/div/div/div/input")).sendKeys("TEST FROM REROUTE");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the To Printer Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/a")).click();
		//Enter the Required To Printer
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/div/div/input")).sendKeys("TEST TO REROUTE");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/a")).click();
		//Enter the Required Applicable Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys("All Days");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1500);
		//Enable or Disable the Set Time option
		driver.findElement(By.xpath("//span[contains(.,'Set time')]")).click();
		
		//Click the down arrow mark
		//driver.findElement(By.xpath("//span[@class='fa fa-chevron-down']")).click();
		
		Thread.sleep(2500);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[6]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		Thread.sleep(3500);
		//Click the Save button
		driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
		
		
		Thread.sleep(3500);
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Saved successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Saved fail");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=54)
	public void Printer_Reroute_Edit_Printer_Reroute_By_Node_Days_Of_Week(WebDriver driver) throws Exception
	{
		//node = (String)extras.getString("node");
		Thread.sleep(5000);
		//Clear the Search button
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("TEST");
		
		Thread.sleep(2000);
		//Click the Edit Icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(10000);
		//Click the Node Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/a")).click();
		//Enter the Required Node
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/div/div/input")).sendKeys("A002");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		//Click the To Printer Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/a")).click();
		//Enter the Required To Printer
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/div/div/input")).sendKeys("No Print");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/a")).click();
		//Enter the Required Applicable Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys("Days of Week");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Days Of Week Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[5]/div/div/ul")).click();
		//Enter the Required Days Of Week
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[5]/div/div/ul/li/input")).sendKeys("WEDNESDAY");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

/*		Thread.sleep(1500);
		//Enable or Disable the Set Time option
		driver.findElement(By.xpath("//span[contains(.,'Set time')]")).click();
		
		//Click the down arrow mark
		//driver.findElement(By.xpath("//span[@class='fa fa-chevron-down']")).click();
				
		Thread.sleep(2500);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[7]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}*/
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		Thread.sleep(3500);
		//Click the update button
		driver.findElement(By.xpath("//span[.='Update']")).click();
		
		Thread.sleep(3000);
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Updated fail");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=55)
	public void Printer_Reroute_Edit_Printer_Reroute_By_Node_Days_Of_Month(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search button
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Test");
		
		Thread.sleep(2000);
		//Click the Edit Icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(10000);
		//Click the Node Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/a")).click();
		//Enter the Required Node
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/div/div/input")).sendKeys("A001");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		//Click the To Printer Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/a")).click();
		//Enter the Required To Printer
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/div/div/input")).sendKeys("TEST TO REROUTE");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/a")).click();
		//Enter the Required Applicable Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys("Days of Month");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Required date from the calendar
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[5]/div/table/tbody/tr[2]/td[6]/button")).click();
		
		//Enable or Disable the Applicable Months
		driver.findElement(By.xpath("//span[contains(.,'Applicable months')]")).click();
		
		//Click the Months field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[7]/div/div/ul")).click();
		//Enter the Required month
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[7]/div/div/ul/li/input")).sendKeys("MAY");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[7]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1500);
/*		//Enable or Disable the Set Time option
		driver.findElement(By.xpath("//span[contains(.,'Set time')]")).click();
		
		//Click the down arrow mark
		//driver.findElement(By.xpath("//span[@class='fa fa-chevron-down']")).click();
				
		Thread.sleep(2500);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[9]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[9]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[9]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}*/
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);

		Thread.sleep(3500);
		//Click the update button
		driver.findElement(By.xpath("//span[.='Update']")).click();
		
		Thread.sleep(3000);
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Updated fail");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=56)
	public void Printer_Reroute_Edit_Printer_Reroute_By_Node_Date_Range(WebDriver driver) throws Exception
	{
		Thread.sleep(8000);
		//Clear the Search button
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("TEST");
		
		Thread.sleep(2000);
		//Click the Edit Icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(5000);
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/a")).click();
		//Enter the Required Applicable Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Clear the from date field
		driver.findElement(By.xpath("//input[@name='fromDate']")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//input[@name='fromDate']")).sendKeys("25-Aug-2020");
		
		Thread.sleep(1500);
		//Clear the from date field
		driver.findElement(By.xpath("//input[@name='endDate']")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//input[@name='endDate']")).sendKeys("27-Aug-2020");
			
		//Enable or Disable the Applicable Months
		driver.findElement(By.xpath("//span[contains(.,'Applicable Days')]")).click();
		
		//Click the Days field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[8]/div/div/ul")).click();
		//Enter the Required Day
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[8]/div/div/ul/li/input")).sendKeys("WEDNESDAY");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[8]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1500);
		//Enable or Disable the Set Time option
/*		driver.findElement(By.xpath("//span[contains(.,'Set time')]")).click();
		
		//Click the down arrow mark
		//driver.findElement(By.xpath("//span[@class='fa fa-chevron-down']")).click();
				
		Thread.sleep(2500);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[10]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}*/
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);

		Thread.sleep(3500);
		//Click the update button
		driver.findElement(By.xpath("//span[.='Update']")).click();
		
		Thread.sleep(3000);
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Updated fail");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=57)
	public void Printer_Reroute_Edit_Printer_Reroute_By_Node_Specific_Date(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search button
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("TEST");
		
		Thread.sleep(2000);
		//Click the Edit Icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(10000);
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/a")).click();
		//Enter the Required Applicable Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys("Specific date");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2500);
		//Clear the date field
		driver.findElement(By.xpath("//input[@name='date']")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//input[@name='date']")).sendKeys("25-Aug-2020");
			
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);

		Thread.sleep(3500);
		//Click the update button
		driver.findElement(By.xpath("//span[.='Update']")).click();
		
		Thread.sleep(3000);
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Updated fail");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=58)
	public void Printer_Reroute_Edit_Printer_Reroute_By_Node_Start_Date_And_End_Date_Time(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search button
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("TEST");
		
		Thread.sleep(2000);
		//Click the Edit Icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(10000);
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/a")).click();
		//Enter the Required Applicable Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys("Start date time & end date time");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1500);
		//Clear the from date field
		driver.findElement(By.xpath("//input[@name='fromDate']")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//input[@name='fromDate']")).sendKeys("25-Aug-2020");
		
		//Clear the to date field
		driver.findElement(By.xpath("//input[@name='endDate']")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//input[@name='endDate']")).sendKeys("27-Aug-2020");
				
		//Enable or Disable the Applicable Days option
		driver.findElement(By.xpath("//span[contains(.,'Applicable Days')]")).click();
		
		//Click the Days Of Week Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[8]/div/div/ul")).click();
		//Enter the Required Days Of Week
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[8]/div/div/ul/li/input")).sendKeys("WEDNESDAY");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[8]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		//Click the down arrow mark
		//driver.findElement(By.xpath("//span[@class='fa fa-chevron-down']")).click();
		Thread.sleep(2000);
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[9]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[9]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[9]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);

		Thread.sleep(3500);
		//Click the update button
		driver.findElement(By.xpath("//span[.='Update']")).click();
		
		Thread.sleep(3000);
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Updated fail");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=59)
	public void Printer_Reroute_Same_From_And_TO_Printer(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search button
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("TEST");
		
		Thread.sleep(2000);
		//Click the Edit Icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(10000);
		//Click the From Printer Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[2]/div/div/a")).click();
		//Enter the required From Printer
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[2]/div/div/div/div/input")).sendKeys("TEST FROM REROUTE");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(5000);
		//Click the From Printer Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/a")).click();
		//Enter the required From Printer
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/div/div/input")).sendKeys("TEST FROM REROUTE");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);

		Thread.sleep(8000);
		//Check whether the validation message is enabled or not
		if(driver.findElement(By.xpath("//p[contains(.,'From & To Printers should not be same')]")).getText().equalsIgnoreCase("From & To Printers should not be same"))
		{
			test.log(LogStatus.PASS, "Validation message shows successfully, when user give the same From and To printers");
		}
		else
		{
			test.log(LogStatus.FAIL, "Validation message shows fail, when user give the same From and To printers");
		}
		
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/a")).click();
		//Enter the Required Applicable Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys("All Days");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1500);
		//Enable or Disable the Set Time option
/*		driver.findElement(By.xpath("//span[contains(.,'Set time')]")).click();
		
		//Click the down arrow mark
		//driver.findElement(By.xpath("//span[@class='fa fa-chevron-down']")).click();
		
		Thread.sleep(2500);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[6]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}*/
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);

		Thread.sleep(3500);
		//Check whether the Update button is enabled or not
		if(driver.findElement(By.xpath("//div[@class='form-actions']/button[@disabled='disabled']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Update button is disabled, when user choose the same prniter in from and to option");
		}
		else
		{
			test.log(LogStatus.FAIL, "Update button is enabled, when user choose the same prniter in from and to option");
		}
		
		Thread.sleep(3000);
		//Click the Close button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=60)
	public void Printer_Reroute_Delete_Printer_Reroute_By_Node(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search button
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("TEST");
		
		Thread.sleep(2000);
		//Click the Edit Icon
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		Thread.sleep(1500);
		//Click the Yes button
		driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
		
		Thread.sleep(2500);
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Deleted Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Deleted successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Deleted fail");
		}
		Thread.sleep(3000);
	}

	@Test(priority=61)
	public void Printer_Reroute_Add_Printer_Reroute_By_Role(WebDriver driver) throws Exception
	{
		for(int i = 0; i <= 10; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(5000);
		//Clear the Search button
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(5000);
		//Select the Re-routing Method
		Select for_Node = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/select")));
		for_Node.selectByVisibleText("Reroute By Role");
		
		Thread.sleep(2000);
		//Click the Add by Role Printer Re-routing button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/button")).click();
		
		Thread.sleep(5000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//a[.='Create Printer Reroute']")).getText().equalsIgnoreCase("Create Printer Reroute") )
		{
			test.log(LogStatus.PASS, "Create New Printer Reroute for Role form loaded Successully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Create New Printer Reroute for Role form loaded Fail");
		}
		Thread.sleep(2000);
		
		//Click the Role Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/a")).click();
		//Enter the Required Node
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/div/div/input")).sendKeys("Admin");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the From Printer Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[2]/div/div/a")).click();
		//Enter the Required From Printer
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[2]/div/div/div/div/input")).sendKeys("TEST FROM REROUTE");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the To Printer Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/a")).click();
		//Enter the Required To Printer
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/div/div/input")).sendKeys("TEST TO REROUTE");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/a")).click();
		//Enter the Required Applicable Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys("All Days");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1500);
		//Enable or Disable the Set Time option
		driver.findElement(By.xpath("//span[contains(.,'Set time')]")).click();
		
		//Click the down arrow mark
		//driver.findElement(By.xpath("//span[@class='fa fa-chevron-down']")).click();
		
		Thread.sleep(2500);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[6]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[6]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		Thread.sleep(2500);
		//Click the Save button
		driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
		
		Thread.sleep(3500);
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Saved successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Saved fail");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=62)
	public void Printer_Reroute_Edit_Printer_Reroute_By_Role_Days_Of_Week(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search button
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Admin");
		
		Thread.sleep(2000);
		//Click the Edit Icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(8000);
		
		Thread.sleep(2000);
		
		//Click the Role Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/a")).click();
		//Enter the Required Node
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/div/div/input")).sendKeys("Cook");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);

		//Click the To Printer Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/a")).click();
		//Enter the Required To Printer
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/div/div/input")).sendKeys("No Print");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/a")).click();
		//Enter the Required Applicable Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys("Days of Week");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Days Of Week Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[5]/div/div/ul")).click();
		//Enter the Required Days Of Week
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[5]/div/div/ul/li/input")).sendKeys("WEDNESDAY");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(1500);
		//Enable or Disable the Set Time option
/*		driver.findElement(By.xpath("//span[contains(.,'Set time')]")).click();
		
		//Click the down arrow mark
		//driver.findElement(By.xpath("//span[@class='fa fa-chevron-down']")).click();
		
		Thread.sleep(2500);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[7]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}*/
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);

		Thread.sleep(3500);
		//Click the update button
		driver.findElement(By.xpath("//span[.='Update']")).click();
		
		Thread.sleep(3000);
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Updated fail");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=63)
	public void Printer_Reroute_Edit_Printer_Reroute_By_Role_Days_Of_Month(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search button
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Cook");
		
		Thread.sleep(2000);
		//Click the Edit Icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(8000);
		Thread.sleep(2000);
		
		//Click the Role Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/a")).click();
		//Enter the Required Node
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/div/div/input")).sendKeys("Admin");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);

		
		//Click the To Printer Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/a")).click();
		//Enter the Required To Printer
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/div/div/input")).sendKeys("TEST TO REROUTE");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/a")).click();
		//Enter the Required Applicable Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys("Days of Month");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Required date from the calendar
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[5]/div/table/tbody/tr[2]/td[6]/button")).click();
		
		//Enable or Disable the Applicable Months
		driver.findElement(By.xpath("//span[contains(.,'Applicable months')]")).click();
		
		//Click the Months field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[7]/div/div/ul")).click();
		//Enter the Required month
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[7]/div/div/ul/li/input")).sendKeys("MAY");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[7]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1500);
		//Enable or Disable the Set Time option
/*		driver.findElement(By.xpath("//span[contains(.,'Set time')]")).click();
		
		//Click the down arrow mark
		//driver.findElement(By.xpath("//span[@class='fa fa-chevron-down']")).click();
		
		Thread.sleep(2500);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[9]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[9]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[9]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}*/
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);

		Thread.sleep(3500);
		//Click the update button
		driver.findElement(By.xpath("//span[.='Update']")).click();
		
		Thread.sleep(3000);
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Updated fail");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=64)
	public void Printer_Reroute_Edit_Printer_Reroute_By_Role_Date_Range(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search button
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Admin");
		
		Thread.sleep(2000);
		//Click the Edit Icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(10000);
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/a")).click();
		//Enter the Required Applicable Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1500);
		//Clear the from date field
		driver.findElement(By.xpath("//input[@name='fromDate']")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//input[@name='fromDate']")).sendKeys("25-Aug-2020");
		
		Thread.sleep(1500);
		//Clear the from date field
		driver.findElement(By.xpath("//input[@name='endDate']")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//input[@name='endDate']")).sendKeys("27-Aug-2020");
			
		//Enable or Disable the Applicable Months
		driver.findElement(By.xpath("//span[contains(.,'Applicable Days')]")).click();
		
		//Click the Days field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[8]/div/div/ul")).click();
		//Enter the Required Day
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[8]/div/div/ul/li/input")).sendKeys("WEDNESDAY");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[8]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1500);
		//Enable or Disable the Set Time option
/*		driver.findElement(By.xpath("//span[contains(.,'Set time')]")).click();
		
		//Click the down arrow mark
		//driver.findElement(By.xpath("//span[@class='fa fa-chevron-down']")).click();
		
		Thread.sleep(2500);
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[10]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}*/
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);

		Thread.sleep(3500);
		//Click the update button
		driver.findElement(By.xpath("//span[.='Update']")).click();
		
		Thread.sleep(3000);
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Updated fail");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=65)
	public void Printer_Reroute_Edit_Printer_Reroute_By_Role_Specific_Date(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search button
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Admin");
		
		Thread.sleep(2000);
		//Click the Edit Icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(10000);
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/a")).click();
		//Enter the Required Applicable Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys("Specific date");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Clear the date field
		driver.findElement(By.xpath("//input[@name='date']")).clear();
		Thread.sleep(1000);
		//Enter the required date
		driver.findElement(By.xpath("//input[@name='date']")).sendKeys("25-Aug-2020");
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);

		Thread.sleep(3500);
		//Click the update button
		driver.findElement(By.xpath("//span[.='Update']")).click();
		
		Thread.sleep(3000);
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Updated fail");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=66)
	public void Printer_Reroute_Edit_Printer_Reroute_By_Role_Start_Date_And_End_Date_Time(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search button
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Admin");
		
		Thread.sleep(2000);
		//Click the Edit Icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(10000);
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/a")).click();
		//Enter the Required Applicable Time Period
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys("Start date time & end date time");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2500);
		//Clear the from date field
		driver.findElement(By.xpath("//input[@name='fromDate']")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//input[@name='fromDate']")).sendKeys("25-Aug-2020");
		
		//Clear the to date field
		driver.findElement(By.xpath("//input[@name='endDate']")).clear();
		//Enter the required date
		driver.findElement(By.xpath("//input[@name='endDate']")).sendKeys("27-Aug-2020");
				
		//Enable or Disable the Applicable Days option
		driver.findElement(By.xpath("//span[contains(.,'Applicable Days')]")).click();
		
		//Click the Days Of Week Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[8]/div/div/ul")).click();
		//Enter the Required Days Of Week
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[8]/div/div/ul/li/input")).sendKeys("WEDNESDAY");
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[8]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		//Click the down arrow mark
		//driver.findElement(By.xpath("//span[@class='fa fa-chevron-down']")).click();
		Thread.sleep(2000);
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[9]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[9]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[9]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);

		Thread.sleep(3500);
		//Click the update button
		driver.findElement(By.xpath("//span[.='Update']")).click();
		
		Thread.sleep(3000);
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Updated fail");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=67)
	public void Printer_Reroute_Delete_Printer_Reroute_By_Role(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the Search button
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Admin");
		
		Thread.sleep(3000);
		//Click the Delete Icon
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		Thread.sleep(1500);
		//Click the Yes button
		driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
		
		Thread.sleep(2500);
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Deleted Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Deleted successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Deleted fail");
		}
		Thread.sleep(3000);
	}

	@Test(priority=68)//19
	public void Printer_Reroute_Verify_Kitchen_KDS_Available_Or_Not(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the Kitchen Printer Option
		driver.findElement(By.xpath("//span[.='Kitchen Printers']")).click();
		Thread.sleep(5000);
		
		//Clear the search text box
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("KitchenPrinters");
		
		Thread.sleep(2000);
		//Click the Edit Icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
/*		Thread.sleep(3000);
    	Select fontSize = new Select(driver.findElement(By.xpath("//div/select[@ng-model='kitchenPrinter.type']")));
		fontSize.selectByVisibleText("KDS");
		
		//Click the Update option
		driver.findElement(By.xpath("//span[.='Update']")).click();*/
		
		Thread.sleep(5000);
		//Click the Type Option of Kitchen Printer
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/a")).click();
		//Enter the Required Type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).clear();
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys("Printer");
		//Press the Enter Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);

		
		Thread.sleep(5000);
		//Click the Type Option of Kitchen Printer
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/a")).click();
		//Enter the Required Type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys("KDS");
		//Press the Enter Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Page down
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(3000);
		//Click the update button
		driver.findElement(By.id("saveKitchen")).click();
		Thread.sleep(5000);
		
		//Clear the search text box
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required Keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("KitchenPrinters");
		
		Thread.sleep(2000);
		//Click the Edit Icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();

		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//span[.='KDS']")).isDisplayed())
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(3000);
			//Click the Close button
			driver.findElement(By.xpath("//a[.='Close']")).click();
			
			//Click the Printer Reroute option
			driver.findElement(By.xpath("//span[.='Printer Reroute']")).click();
			
			Thread.sleep(3000);
			Thread.sleep(2000);
			//Click the Add by Role Printer Re-routing button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/button")).click();

			
			Thread.sleep(5000);
			//Click the From Printer Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[2]/div/div/a")).click();
			Thread.sleep(3000);
			try
			{
				//Check Whether the Printer is available or not
				if(driver.findElement(By.xpath("//li[.='KitchenPrinters']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Kitchen Printer(KDS) Reflected but it is KDS");
				}
			}
			catch (Exception e1)
			{
				test.log(LogStatus.PASS, "Kitchen Printer(KDS) Not Reflected Successfully");
			}
			
			//Click the Close button
			driver.findElement(By.xpath("//a[.='Cancel']")).click();
			Thread.sleep(5000);
			
			Thread.sleep(3000);
			//Click the Kitchen Printer Option
			driver.findElement(By.xpath("//span[.='Kitchen Printers']")).click();
			Thread.sleep(5000);
			
			//Clear the search text box
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//Enter the required Keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("KitchenPrinters");
			
			Thread.sleep(2000);
			//Click the Edit Icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			Thread.sleep(5000);
			
			//Click the Type Option of Kitchen Printer
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/a")).click();
			//Enter the Required Type
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys("Printer");
			//Press the Enter Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			//Page down
			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(3000);
			//Click the update button
			driver.findElement(By.id("saveKitchen")).click();
			
			Thread.sleep(20000);
			//Click the Printer Reroute option
			driver.findElement(By.xpath("//span[.='Printer Reroute']")).click();
			
			Thread.sleep(3000);
			Thread.sleep(2000);
			//Click the Add by Role Printer Re-routing button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/button")).click();

			
			Thread.sleep(5000);
			//Click the From Printer Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[2]/div/div/a")).click();
			Thread.sleep(3000);
			
			try
			{
				//Check Whether the Printer is available or not
				if(driver.findElement(By.xpath("//li[.='KitchenPrinters']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Kitchen Printer Reflected Successfully");
					
					//Click the Node Option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/a")).click();
					//Enter the Required Node
					//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/div/div/input")).sendKeys("A001");
					//Press the Enter button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
					
					//Click the From Printer Option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[2]/div/div/a")).click();
					//Enter the Required From Printer
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[2]/div/div/div/div/input")).sendKeys("KitchenPrinters");
					//Press the Enter button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
					
					//Click the To Printer Option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/a")).click();
					//Enter the Required To Printer
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/div/div/input")).sendKeys("TEST TO REROUTE");
					//Press the Enter button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
					
					//Click the Applicable Time Period Option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/a")).click();
					//Enter the Required Applicable Time Period
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys("All Days");
					//Press the Enter button
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
											
					Thread.sleep(2500);
					//Click the Save button
					driver.findElement(By.xpath("//button[@class='btn btn-small btn-success']")).click();
					
					Thread.sleep(3500);
					if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Saved Successfully"))
					{
						test.log(LogStatus.PASS, "Printer Reroute Saved successfully after Change the KDS TO Printer in Kitchen Printer");
						
						Thread.sleep(5000);
						//Clear the Search button
						driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
						//Enter the required Keyword
						driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("KitchenPrinters");
						
						Thread.sleep(2000);
						//Click the Edit Icon
						driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
						
						Thread.sleep(1500);
						//Click the Yes button
						driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
						
						Thread.sleep(2500);
					}
					else
					{
						test.log(LogStatus.FAIL, "Printer Reroute Saved fail after Change the KDS TO Printer in Kitchen Printer");
					}
					Thread.sleep(3000);

				}
			}
			catch (Exception e1)
			{
				test.log(LogStatus.FAIL, "Kitchen Printer not reflected");
			}
			
			//Click the Close button
			//driver.findElement(By.xpath("//a[.='Cancel']")).click();
			Thread.sleep(5000);
		}
	}

}
