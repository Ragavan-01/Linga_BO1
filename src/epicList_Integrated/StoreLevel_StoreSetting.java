package epicList_Integrated;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class StoreLevel_StoreSetting {
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings_Store");
	
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
	
	@Test(priority=2)
	public void Store_Information_openpage(WebDriver driver) throws Exception
	{
		Thread.sleep(13000);
		//Click the Settings option
		driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[5]/a/span[1]")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Store']"));
		//Scroll the page till the Store option present
		je.executeScript("arguments[0].scrollIntoView(true);",element);Thread.sleep(3000);
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
		
		Thread.sleep(4000);

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
	
	@Test(priority=3)
	public void Store_Information_editpage(WebDriver driver) throws Exception
	{
		Thread.sleep(2000);
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
		Thread.sleep(2000);
		//Clear the name field
		driver.findElement(By.name("name")).clear();
		//Enter the name
		driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Settings_Store_Information_Name"));
		
		Thread.sleep(2000);
		//Clear the phone number field
		driver.findElement(By.name("phoneNumber")).clear();
		//Enter the required phone number
		driver.findElement(By.name("phoneNumber")).sendKeys(Utility.getProperty("Settings_Store_Information_Phone"));
		
		
		Thread.sleep(2000);
		//Clear the email Id field
		driver.findElement(By.name("emailId")).clear();
		//Enter the required mail ID
		driver.findElement(By.name("emailId")).sendKeys(Utility.getProperty("Settings_Store_Information_Email"));

		Thread.sleep(2000);
		//Clear the address1 filed
		driver.findElement(By.name("addressLine1")).clear();
		//Enter the address1
		driver.findElement(By.name("addressLine1")).sendKeys(Utility.getProperty("Settings_Store_Information_Address1"));
		
		Thread.sleep(2000);
		//Clear the address2 field
		driver.findElement(By.name("addressLine2")).clear();
		//Enter the address2
		driver.findElement(By.name("addressLine2")).sendKeys(Utility.getProperty("Settings_Store_Information_Address2"));
		
		Thread.sleep(1000);
		//Clear the City field
		driver.findElement(By.name("city")).clear();
		//Enter the City
		driver.findElement(By.name("city")).sendKeys(Utility.getProperty("Settings_Store_Information_City"));
		
		Thread.sleep(1000);
		//Clear the State field
		driver.findElement(By.name("state")).clear();
		//Enter the State
		driver.findElement(By.name("state")).sendKeys(Utility.getProperty("Settings_Store_Information_State"));
		
		Thread.sleep(1000);
		//Clear the Zip Code Field
		driver.findElement(By.name("zipCode")).clear();
		//Enter the Zipcode
		driver.findElement(By.name("zipCode")).sendKeys(Utility.getProperty("Settings_Store_Information_Zipcode"));
		
		Thread.sleep(1000);
		//Click the Time Zone Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[1]/div/div/a")).click();
		//Enter the required Time Zone
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[1]/div/div/div/div/input")).sendKeys(Utility.getProperty("Settings_Store_Information_TimeZone"));
		//Click the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Close button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[2]/div/div/ul/li/a")).click();
		
		Thread.sleep(2000);
		//Click the Languages Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[2]/div/div/ul")).click();
		//Clear the Languages
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[2]/div/div/ul/li/input")).clear();
		//Enter the required Languages
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[2]/div/div/ul/li/input")).sendKeys(Utility.getProperty("Settings_Store_Information_Language"));
		//Press the Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[2]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		//Scroll the web page
	    for(int i=1; i <= 10; i++)
	    {
	    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
	    	Thread.sleep(1000);
	    }
		
		
		Thread.sleep(3000);
		//Choose the required image
		driver.findElement(By.id("storeImage")).sendKeys(Utility.getProperty("Settings_Store_Information_Store_Image_Path"));
		
		Thread.sleep(2000);
		//Click the Remove image
		driver.findElement(By.xpath("//a[.='Remove']")).click();
		
		Thread.sleep(2000);
		//Choose the required image
		driver.findElement(By.id("storeImage")).sendKeys(Utility.getProperty("Settings_Store_Information_Store_Image_Path"));
		
		Thread.sleep(2000);
		//Click the Get my location option
		driver.findElement(By.xpath("//button[.='Get my location']")).click();
		
		Thread.sleep(6000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		//Check weather the new denomination form saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Store updated successfully"))
		{
			test.log(LogStatus.PASS, "Store updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store updated fail");
		}
		Thread.sleep(5000);watchTutorial(driver);Thread.sleep(5000);
	}

	@Test(priority=4)
	public void Settings_Method_openpage(WebDriver driver) throws Exception
	{

		
		Thread.sleep(3000);
		//Enter the URl
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"store_settings");
		
		Thread.sleep(3000);
		
		//Check weather the Settings page is loaded or not
		if(driver.findElement(By.xpath("//a[.='Settings']")).getText().equalsIgnoreCase("Settings"))
		{
			test.log(LogStatus.PASS, "Settings page loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Settings page loaded fail");
		}

		Thread.sleep(3000);

	}	

	@Test(priority=5)
	public void Settings_update_Method_Daily(WebDriver driver) throws Exception
	{
		
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.HOME));
		html.sendKeys(Keys.chord(Keys.HOME));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
/*		Thread.sleep(2000);
		//Check Whether the log off after each sale is enable or not
		if(driver.findElement(By.name("isLogOffAfterSale")).isSelected())
		{
			Thread.sleep(1000);
			//Disable the log off after each sale button
			driver.findElement(By.name("isLogOffAfterSale")).click();
		}
		else
		{
			
		}*/
		
		Thread.sleep(2000);
		//Check Whether the Enable Gratuity Line in Credit Card screen is enable or not
		if(driver.findElement(By.name("enableGratuityLineInCC")).isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			//Disable the Enable Gratuity Line in Credit Card screen button
			driver.findElement(By.name("enableGratuityLineInCC")).click();
		}
		
		Thread.sleep(2000);
		//Check Whether the Show Tip Screen Before Credit Card screen is enable or not
		if(driver.findElement(By.name("tipScreenBeforeCC")).isSelected())
		{

		}
		else
		{
			Thread.sleep(1000);
			//Enable the Show Tip Screen Before Credit Card screen button
			driver.findElement(By.name("tipScreenBeforeCC")).click();
		}
		
		
		Thread.sleep(2000);
		//Check Whether the Kitchen Print Void Item is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.isKitchenPrintVoidItem']")).isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			//Disable the Kitchen Print Void Item button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.isKitchenPrintVoidItem']")).click();
		}
		
		Thread.sleep(2000);
		//Check Whether the Print Included Modifier In Kitchen is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.printIMWithPrefix']")).isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			//Disable the Print Included Modifier In Kitchen button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.printIMWithPrefix']")).click();
		}
		
		
		Thread.sleep(2000);
		//Check Whether the Auto Print Receipt is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.enableReceiptPrint']")).isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			//Disable the Auto Print Receipt button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.enableReceiptPrint']")).click();
		}
		
		Thread.sleep(2000);
		//Check Whether the Show Digital Receipt Screen is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.isDigitalReceiptAvail']")).isSelected())
		{
		}
		else
		{

			Thread.sleep(1000);
			//Disable the Show Digital Receipt Screen button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.isDigitalReceiptAvail']")).click();
		}
		
		Thread.sleep(2000);
		//Check Whether the Show Signature Pad is enable or not
		if(driver.findElement(By.name("isSignatureEnabled")).isSelected())
		{

		}
		else
		{
			Thread.sleep(1000);
			//Enable the Show Signature Pad button
			driver.findElement(By.name("isSignatureEnabled")).click();
		}
		
		Thread.sleep(2000);
		//Check Whether the Show CC Receipt Screen is enable or not
		if(driver.findElement(By.name("isPaymentDigitalReceiptEnabled")).isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			//Enable the Show CC Receipt Screen button
			driver.findElement(By.name("isPaymentDigitalReceiptEnabled")).click();
		}
		
		Thread.sleep(2000);
		//Check Whether the Print CC Merchant Copy is enable or not
		if(driver.findElement(By.name("isMerchantCopyEnabled")).isSelected())
		{

		}
		else
		{
			Thread.sleep(1000);
			//Enable the Print CC Merchant Copy button
			driver.findElement(By.name("isMerchantCopyEnabled")).click();
		}
		
		Thread.sleep(2000);
		//Check Whether the Print CC Customer Copy is enable or not
		if(driver.findElement(By.name("isCustomerCopyEnabled")).isSelected())
		{

		}
		else
		{
			Thread.sleep(1000);
			//Enable the Print CC Customer Copy button
			driver.findElement(By.name("isCustomerCopyEnabled")).click();
		}
		
		
		//Check Whether the Enable Intranet sync is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.enabledIntranetSync']")).isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			//Enable the Enable Intranet sync button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.enabledIntranetSync']")).click();
			Thread.sleep(1000);
			//Click yes button 
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		}
		
		
		Thread.sleep(3000);
		//Check Whether the Enable Intranet sync is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.enabledIntranetSync']")).isSelected())
		{
			Thread.sleep(1000);
			//Enable the Enable Intranet sync button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.enabledIntranetSync']")).click();

		}
		else
		{
			
		}
		
		
		Thread.sleep(2000);
		//Check Whether the Remove Tip Line is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.removeTipLine']")).isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			//Enable the Remove Tip Line button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.removeTipLine']")).click();

		}
		
		
		Thread.sleep(2000);
		//Check Whether the Enable Pre Auth is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.enablePreAuth']")).isSelected())
		{
			Thread.sleep(1000);
			//Clear the Default pre Auth amount
			driver.findElement(By.name("defaultPreAuthAmountStr")).clear();
			//Enter the Default pre Auth Amount
			driver.findElement(By.name("defaultPreAuthAmountStr")).sendKeys("125");
			
			//Check Whether the Enable Extended Pre Auth is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.enableExtPreAuth']")).isSelected())
			{

			}
			else
			{
				Thread.sleep(1000);
				//Enable the Enable Extended Pre Auth button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.enableExtPreAuth']")).click();
			}
			Thread.sleep(2000);
		}
		else
		{
			Thread.sleep(1000);
			//Enable the Enable Pre Auth button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.enablePreAuth']")).click();
			
			Thread.sleep(1000);
			//Clear the Default pre Auth amount
			driver.findElement(By.name("defaultPreAuthAmountStr")).clear();
			//Enter the Default pre Auth Amount
			driver.findElement(By.name("defaultPreAuthAmountStr")).sendKeys("125");
			
			//Check Whether the Enable Extended Pre Auth is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.enableExtPreAuth']")).isSelected())
			{

			}
			else
			{
				Thread.sleep(1000);
				//Enable the Enable Extended Pre Auth button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.enableExtPreAuth']")).click();
			}
			Thread.sleep(2000);

		}
		
		Thread.sleep(2000);
		//Check Whether the Open Auto Global Till is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.showAdvertisement']")).isSelected())
		{
			Thread.sleep(1000);
			//Disable the Open Auto Global Till button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.showAdvertisement']")).click();
			
		}
		else
		{
			
		}
		
		Thread.sleep(2000);
		//Check Whether the Auto Print CloseDay Report is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.autoPrintCloseDayReport']")).isSelected())
		{
			Thread.sleep(1000);
			//Disable the Auto Print CloseDay Report button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.autoPrintCloseDayReport']")).click();
		}
		else
		{
			
		}
		
		Thread.sleep(2000);
		//Check Whether the Show Advertisements is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.showAdvertisement']")).isSelected())
		{
			Thread.sleep(1000);
			//Disable the Show Advertisements button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.showAdvertisement']")).click();
		}
		else
		{
			
		}
		
		//Select the required iPad Custom Button Action
		Select iPadCustomButton = new Select(driver.findElement(By.name("ipadCustom")));
		iPadCustomButton.selectByValue("0");
		
		Thread.sleep(2000);
		//Check Whether the Suggest Tip In CC Receipt is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.tipSuggestion']")).isSelected())
		{
			Thread.sleep(1000);
			//Disable the Suggest Tip In CC Receipt button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.tipSuggestion']")).click();
		}
		else
		{
			
		}
		
		Thread.sleep(2000);
		//Check Whether the Assign Order To Departed Driver is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.tipSuggestion']")).isSelected())
		{
			Thread.sleep(1000);
			//Disable the Assign Order To Departed Driver button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.tipSuggestion']")).click();

		}
		else
		{
			
		}
		
		Thread.sleep(2000);
		//Check Whether the restrict GiftCardTip is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.restrictGiftCardTip']")).isSelected())
		{

		}
		else
		{
			Thread.sleep(1000);
			//Disable the GiftCardTip button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.restrictGiftCardTip']")).click();
		}
		
	
		//Select the Batch Submit Device option
		Select BatchSubmit = new Select(driver.findElement(By.xpath("//select[@ng-model='storeSettings.batchSubmitDevice']")));
		BatchSubmit.selectByIndex(0);
		
		//Enable or Disable the Tip Paid Out
		driver.findElement(By.xpath("//input[@ng-model='storeSettings.enableTipPaidOut']")).click();
			
		Thread.sleep(3000);
		//Select the required default batch payment
		Select batchPay =  new Select(driver.findElement(By.xpath("//select[@name= 'defaultBatchPayment']")));
		batchPay.selectByVisibleText("Dejavoo");;
		
		
		
		//Select the required day of Week
		Select dayOfWeek = new Select(driver.findElement(By.xpath("//select[@ng-model='storeSettings.startDay']")));
		dayOfWeek.selectByVisibleText("SUNDAY");
		
		//Select the required Default Payroll Process 
		Select defaultPayroll = new Select(driver.findElement(By.xpath("//select[@ng-model='storeSettings.defaultPayrollProcess']")));
		defaultPayroll.selectByVisibleText("DAILY");
		
		//Clear the Table name field
		driver.findElement(By.name("tableExpirationTime")).clear();
		//Enter the required time
		driver.findElement(By.name("tableExpirationTime")).sendKeys("4");
		
		//Clear the Preferred Network field
		driver.findElement(By.name("preferredNetwork")).clear();
		//Enter the Preferred Network
		driver.findElement(By.name("preferredNetwork")).sendKeys("ONUR'S WIFI");
		
		//Clear the delivery Charge field
		driver.findElement(By.name("deliveryCharge")).clear();
		//Enter the delivery Charge
		driver.findElement(By.name("deliveryCharge")).sendKeys("123");
		
		//Clear the Print Future Order Before field
		driver.findElement(By.name("printFutureOrderBefore")).clear();
		//Enter the Print Future Order Before
		driver.findElement(By.name("printFutureOrderBefore")).sendKeys("8");
		
		Thread.sleep(2000);
		//Check whether the amount is enabled or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[1]/input[1]")).isSelected())
		{
			Thread.sleep(1000);
			//Click the Percentage option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[1]/input[2]")).click();
			
			Thread.sleep(2000);
			//Clear the first field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[2]/ng-form/div/div/input")).clear();
			//Enter the required percentage
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[2]/ng-form/div/div/input")).sendKeys("10");

			Thread.sleep(1000);
			//Clear the second field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[3]/ng-form/div/div/input")).clear();
			//Enter the required percentage
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[3]/ng-form/div/div/input")).sendKeys("20");

			Thread.sleep(1000);
			//Clear the third field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[4]/ng-form/div/div/input")).clear();
			//Enter the required percentage
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[4]/ng-form/div/div/input")).sendKeys("30");

			Thread.sleep(1000);
			//Clear the fourth field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[5]/ng-form/div/div/input")).clear();
			//Enter the required percentage
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[5]/ng-form/div/div/input")).sendKeys("40");

		}
		
		//Check the Percentage is enabled or not
		else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[1]/input[2]")).isSelected())
		{
			Thread.sleep(1000);
			//Click the Amount option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[1]/input[1]")).click();
			
			Thread.sleep(2000);
			//Clear the first field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[2]/ng-form/div/div/input")).clear();
			//Enter the required Amount
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[2]/ng-form/div/div/input")).sendKeys("10");

			Thread.sleep(1000);
			//Clear the second field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[3]/ng-form/div/div/input")).clear();
			//Enter the required Amount
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[3]/ng-form/div/div/input")).sendKeys("20");

			Thread.sleep(1000);
			//Clear the third field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[4]/ng-form/div/div/input")).clear();
			//Enter the required Amount
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[4]/ng-form/div/div/input")).sendKeys("30");

			Thread.sleep(1000);
			//Clear the fourth field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[5]/ng-form/div/div/input")).clear();
			//Enter the required Amount
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[5]/ng-form/div/div/input")).sendKeys("40");

		}
		
		List<WebElement> close = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[3]/div/div/a/i"));
		
		for(int i =2; i<=close.size(); i++)
		{
			Thread.sleep(1000);
			//Click the close button of Payment types
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[3]/div[2]/div/a/i")).click();
			
			Thread.sleep(1000);
			//Switch the control to the alert pouup
			Alert x = driver.switchTo().alert();
			//Accept the alert
			x.accept();
		}
		
		Thread.sleep(1000);
		//Click the Add symbol of Payment Methods option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
		
		Thread.sleep(1000);
		//Select the required payment type
		Select paymentType = new Select(driver.findElement(By.name("paymentType")));
		paymentType.selectByVisibleText("Gift Card");
		
		Thread.sleep(1000);
		//Clear the payment name field
		driver.findElement(By.name("paymentMethod")).clear();
		//Enter the required payment name
		driver.findElement(By.name("paymentMethod")).sendKeys("Gift Card");
		
		Thread.sleep(1000);
		//Click the Add button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[4]/a/i")).click();

		
		Thread.sleep(1000);
		//Click the Add symbol of Payment Methods option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
		
		Thread.sleep(1000);
		//Select the required payment type
		paymentType.selectByVisibleText("Credit Card");
		
		Thread.sleep(1000);
		//Clear the payment name field
		driver.findElement(By.name("paymentMethod")).clear();
		//Enter the required payment name
		driver.findElement(By.name("paymentMethod")).sendKeys("Credit Card");	
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='code']")).clear();
		driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_A");
		
		Thread.sleep(1000);
		//Click the Add button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[4]/a/i")).click();
		
		Thread.sleep(1000);
		//Click the Add symbol of Payment Methods option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
		
		Thread.sleep(1000);
		//Select the required payment type
		paymentType.selectByVisibleText("Side CC");
		
		Thread.sleep(1000);
		//Clear the payment name field
		driver.findElement(By.name("paymentMethod")).clear();
		//Enter the required payment name
		driver.findElement(By.name("paymentMethod")).sendKeys("Side CC");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='code']")).clear();
		driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_B");
		
		Thread.sleep(1000);
		//Click the Add button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[4]/a/i")).click();
		
		Thread.sleep(1000);
		//Click the Add symbol of Payment Methods option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
		
		Thread.sleep(1000);
		//Select the required payment type
		paymentType.selectByVisibleText("Castle And Go");
		
		Thread.sleep(1000);
		//Clear the payment name field
		driver.findElement(By.name("paymentMethod")).clear();
		//Enter the required payment name
		driver.findElement(By.name("paymentMethod")).sendKeys("Castle And Go");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='code']")).clear();
		driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_C");
		
		Thread.sleep(1000);
		//Click the Add button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[4]/a/i")).click();
		
		Thread.sleep(1000);
		//Click the Add symbol of Payment Methods option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
		
		Thread.sleep(1000);
		//Select the required payment type
		paymentType.selectByVisibleText("SPPax");
		
		Thread.sleep(1000);
		//Clear the payment name field
		driver.findElement(By.name("paymentMethod")).clear();
		//Enter the required payment name
		driver.findElement(By.name("paymentMethod")).sendKeys("SPPax");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='code']")).clear();
		driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_M");
		
		Thread.sleep(1000);
		//Enable the Enable EBT option
		driver.findElement(By.xpath("//input[@ng-model='paymentMethod.isEbtEnable']")).click();
		
		//Enable the  Factor 4 cards
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@ng-model='paymentMethod.factor4Cards']")).click();
		
		Thread.sleep(1000);
		//Click the Add button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[6]/a/i")).click();
		
		Thread.sleep(1000);
		//Click the Add symbol of Payment Methods option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
		
		Thread.sleep(1000);
		//Select the required payment type
		paymentType.selectByVisibleText("Others");
		
		Thread.sleep(1000);
		//Clear the payment name field
		driver.findElement(By.name("paymentMethod")).clear();
		//Enter the required payment name
		driver.findElement(By.name("paymentMethod")).sendKeys("Others");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='code']")).clear();
		driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_E");
		
		Thread.sleep(1000);
		//Click the Add button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[4]/a/i")).click();
		
		Thread.sleep(1000);
		//Click the Add symbol of Payment Methods option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
		
		Thread.sleep(1000);
		//Select the required payment type
		paymentType.selectByVisibleText("GiveX");
		
		Thread.sleep(1000);
		//Clear the payment name field
		driver.findElement(By.name("paymentMethod")).clear();
		//Enter the required payment name
		driver.findElement(By.name("paymentMethod")).sendKeys("GiveX");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='code']")).clear();
		driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_F");
		
		Thread.sleep(1000);
		//Click the Add button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[4]/a/i")).click();
		
		Thread.sleep(1000);
		//Click the Add symbol of Payment Methods option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
		
		Thread.sleep(1000);
		//Select the required payment type
		paymentType.selectByVisibleText("HAPayment");
		
		Thread.sleep(1000);
		//Clear the payment name field
		driver.findElement(By.name("paymentMethod")).clear();
		//Enter the required payment name
		driver.findElement(By.name("paymentMethod")).sendKeys("HAPayment");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='code']")).clear();
		driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_G");
		
		Thread.sleep(1000);
		//Click the Add button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[4]/a/i")).click();
		
		Thread.sleep(1000);
		//Click the Add symbol of Payment Methods option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
		
		Thread.sleep(1000);
		//Select the required payment type
		paymentType.selectByVisibleText("NMI Tokenization");
		
		Thread.sleep(1000);
		//Clear the payment name field
		driver.findElement(By.name("paymentMethod")).clear();
		//Enter the required payment name
		driver.findElement(By.name("paymentMethod")).sendKeys("NMI Tokenization");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='code']")).clear();
		driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_H");
		
		Thread.sleep(1000);
		//Click the Add button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[4]/a/i")).click();
		
		Thread.sleep(1000);
		//Click the Add symbol of Payment Methods option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
		
		Thread.sleep(1000);
		//Select the required payment type
		paymentType.selectByVisibleText("Dejavoo");
		
		Thread.sleep(1000);
		//Clear the payment name field
		driver.findElement(By.name("paymentMethod")).clear();
		//Enter the required payment name
		driver.findElement(By.name("paymentMethod")).sendKeys("Dejavoo");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='code']")).clear();
		driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_I");
		
		Thread.sleep(1000);
		//Enable the Enable EBT option
		driver.findElement(By.xpath("//input[@ng-model='paymentMethod.isEbtEnable']")).click();
		
		Thread.sleep(1000);
		//Click the Add button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[5]/a/i")).click();
		
		Thread.sleep(3000);
		//Check Whether the Print Coursing Separately is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.printCoursingSeparatley']")).isSelected())
		{
			Thread.sleep(1000);
			//Disable the Print Coursing Separately button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.printCoursingSeparatley']")).click();
		}
		else
		{
		
		}
		
		Thread.sleep(1000);
		//Clear the Floating Tab
		driver.findElement(By.name("floatingTab")).clear();
		//Enter the required Tab Value
		driver.findElement(By.name("floatingTab")).sendKeys("BarTab");
		
		Thread.sleep(2000);
		//Check Whether the Disable Customer Nationality is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.disableCustomerNationality']")).isSelected())
		{
			Thread.sleep(1000);
			//Disable the Disable Customer Nationality button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.disableCustomerNationality']")).click();
		}
		else
		{
		
		}
		
		Thread.sleep(2000);
		//Check Whether the Send Whole Table to Kitchen Printer is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.printTable']")).isSelected())
		{
			Thread.sleep(1000);
			//Disable the Send Whole Table to Kitchen Printer button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.printTable']")).click();
		}
		else
		{
		
		}
		
		Thread.sleep(2000);
		//Check Whether the Show PopUp for Tax Exempt ReferenceId is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.taxExemptId']")).isSelected())
		{
			Thread.sleep(1000);
			//Disable the Show PopUp for Tax Exempt ReferenceId button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.taxExemptId']")).click();
		}
		else
		{
		
		}
		try {
		Thread.sleep(2000);
		//Check Whether the Service Charge is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.saleEnableText']")).isSelected())
		{
			Thread.sleep(3000);
			//Clear the service charge name
			driver.findElement(By.name("nonDiscountFee")).clear();
			//Enter the service charge name
			driver.findElement(By.name("nonDiscountFee")).sendKeys("Service Charge");
		}
		else
		{
			Thread.sleep(1000);
			//Disable the Service Charge button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.saleEnableText']")).click();
			
			Thread.sleep(3000);
			//Clear the service charge name
			driver.findElement(By.name("nonDiscountFee")).clear();
			//Enter the service charge name
			driver.findElement(By.name("nonDiscountFee")).sendKeys("Service Charge");
		}
		Thread.sleep(2000);
		//Check Whether the Service Charge is enable or not
		driver.findElement(By.xpath("//input[@ng-model='storeSettings.saleEnableText']")).click();
		}
		catch (Exception e)
		{
		Thread.sleep(2000);
		//Check Whether the Cash discount is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.cashDiscountEnable']")).isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			//Disable the Cash discount button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.cashDiscountEnable']")).click();
			
		}
		}
		Thread.sleep(2000);
		//Check Whether the Do Not Reset Check Number is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.disableResetCheckNumber']")).isSelected())
		{
			Thread.sleep(1000);
			//Disable the Do Not Reset Check Number button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.disableResetCheckNumber']")).click();
		}
		else
		{
		
		}
		
		Thread.sleep(1000);
		//Select the required CDS Theme
		Select cdsTheme = new Select(driver.findElement(By.xpath("//select[@ng-model='storeSettings.cdsTheme']")));
		cdsTheme.selectByValue("LIGHT");
		
		Thread.sleep(1000);
		//Clear the CDS Discount Text
		driver.findElement(By.name("cdsDiscountText")).clear();
		//Enter the text
		driver.findElement(By.name("cdsDiscountText")).sendKeys("Test");
		
		Thread.sleep(1000);
		//Clear the CDS Loyalty Text
		driver.findElement(By.name("cdsLoyaltyText")).clear();
		//Enter the text
		driver.findElement(By.name("cdsLoyaltyText")).sendKeys("Test");
		
		Thread.sleep(1000);
		//Clear the CDS Get Number Text
		driver.findElement(By.name("cdsGetNumberText")).clear();
		//Enter the text
		driver.findElement(By.name("cdsGetNumberText")).sendKeys("Test");
		
		
		Thread.sleep(2000);
		//Check Whether the CDS Customer Profile is enable or not
		if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.cdsCustomerProfile']")).isSelected())
		{
			Thread.sleep(1000);
			//Disable the CDS Customer Profile button
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.cdsCustomerProfile']")).click();
		}
		else
		{
		
		}
		
		Thread.sleep(4000);
		//Click the update button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//Check weather the new denomination form saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Store settings updated successfully"))
		{
			test.log(LogStatus.PASS, "Store settings updated successfully for Daily");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store settings updated fail for Daily");
		}
	}

	@Test(priority=6)
	public void Settings_update_Method_Weekly(WebDriver driver) throws Exception

		{
			
			Thread.sleep(3000);
/*			//Check Whether the log off after each sale is enable or not
			if(driver.findElement(By.name("isLogOffAfterSale")).isSelected())
			{
				Thread.sleep(1000);
				//Disable the log off after each sale button
				driver.findElement(By.name("isLogOffAfterSale")).click();
			}
			else
			{
			
			}*/
			
			Thread.sleep(2000);
			//Check Whether the Enable Gratuity Line in Credit Card screen is enable or not
			if(driver.findElement(By.name("enableGratuityLineInCC")).isSelected())
			{
				Thread.sleep(1000);
				//Disable the Enable Gratuity Line in Credit Card screen button
				driver.findElement(By.name("enableGratuityLineInCC")).click();
			}
			else
			{
			
			}
			
			Thread.sleep(2000);
			//Check Whether the Show Tip Screen Before Credit Card screen is enable or not
			if(driver.findElement(By.name("tipScreenBeforeCC")).isSelected())
			{
		
			}
			else
			{
				Thread.sleep(1000);
				//Enable the Show Tip Screen Before Credit Card screen button
				driver.findElement(By.name("tipScreenBeforeCC")).click();
			}
			
			
			Thread.sleep(2000);
			//Check Whether the Kitchen Print Void Item is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.isKitchenPrintVoidItem']")).isSelected())
			{
				Thread.sleep(1000);
				//Disable the Kitchen Print Void Item button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.isKitchenPrintVoidItem']")).click();
			}
			else
			{
			
			}
			
			Thread.sleep(2000);
			//Check Whether the Print Included Modifier In Kitchen is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.printIMWithPrefix']")).isSelected())
			{
				
			}
			else
			{
				Thread.sleep(1000);
				//Disable the Print Included Modifier In Kitchen button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.printIMWithPrefix']")).click();
			}
			
			
			Thread.sleep(2000);
			//Check Whether the Auto Print Receipt is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.enableReceiptPrint']")).isSelected())
			{
				
			}
			else
			{
				Thread.sleep(1000);
				//Disable the Auto Print Receipt button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.enableReceiptPrint']")).click();
			}
			
			Thread.sleep(2000);
			//Check Whether the Show Digital Receipt Screen is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.isDigitalReceiptAvail']")).isSelected())
			{
				Thread.sleep(1000);
				//Disable the Show Digital Receipt Screen button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.isDigitalReceiptAvail']")).click();
			}
			else
			{
				
			}
			
			Thread.sleep(2000);
			//Check Whether the Show Signature Pad is enable or not
			if(driver.findElement(By.name("isSignatureEnabled")).isSelected())
			{
		
			}
			else
			{
				Thread.sleep(1000);
				//Enable the Show Signature Pad button
				driver.findElement(By.name("isSignatureEnabled")).click();
			}
			
			Thread.sleep(2000);
			//Check Whether the Show CC Receipt Screen is enable or not
			if(driver.findElement(By.name("isPaymentDigitalReceiptEnabled")).isSelected())
			{
				Thread.sleep(1000);
				//Enable the Show CC Receipt Screen button
				driver.findElement(By.name("isPaymentDigitalReceiptEnabled")).click();
			}
			else
			{
		
			}
			
			Thread.sleep(2000);
			//Check Whether the Print CC Merchant Copy is enable or not
			if(driver.findElement(By.name("isMerchantCopyEnabled")).isSelected())
			{
		
			}
			else
			{
				Thread.sleep(1000);
				//Enable the Print CC Merchant Copy button
				driver.findElement(By.name("isMerchantCopyEnabled")).click();
			}
			
			Thread.sleep(2000);
			//Check Whether the Print CC Customer Copy is enable or not
			if(driver.findElement(By.name("isCustomerCopyEnabled")).isSelected())
			{
		
			}
			else
			{
				Thread.sleep(1000);
				//Enable the Print CC Customer Copy button
				driver.findElement(By.name("isCustomerCopyEnabled")).click();
			}
			
			Thread.sleep(2000);
			//Check Whether the Enable Intranet sync is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.enabledIntranetSync']")).isSelected())
			{
				Thread.sleep(1000);
				//Enable the Enable Intranet sync button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.enabledIntranetSync']")).click();
			}
			else
			{
		
			}
			
			Thread.sleep(2000);
			//Check Whether the Remove Tip Line is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.removeTipLine']")).isSelected())
			{
				Thread.sleep(1000);
				//Enable the Remove Tip Line button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.removeTipLine']")).click();
			}
			else
			{
		
			}
			
			
			Thread.sleep(2000);
			//Check Whether the Enable Pre Auth is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.enablePreAuth']")).isSelected())
			{
				Thread.sleep(1000);
				//Clear the Default pre Auth amount
				driver.findElement(By.name("defaultPreAuthAmountStr")).clear();
				//Enter the Default pre Auth Amount
				driver.findElement(By.name("defaultPreAuthAmountStr")).sendKeys("125");
				
				//Check Whether the Enable Extended Pre Auth is enable or not
				if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.enableExtPreAuth']")).isSelected())
				{
		
				}
				else
				{
					Thread.sleep(1000);
					//Enable the Enable Extended Pre Auth button
					driver.findElement(By.xpath("//input[@ng-model='storeSettings.enableExtPreAuth']")).click();
				}
				Thread.sleep(2000);
			}
			else
			{
				Thread.sleep(1000);
				//Enable the Enable Pre Auth button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.enablePreAuth']")).click();
				
				Thread.sleep(1000);
				//Clear the Default pre Auth amount
				driver.findElement(By.name("defaultPreAuthAmountStr")).clear();
				//Enter the Default pre Auth Amount
				driver.findElement(By.name("defaultPreAuthAmountStr")).sendKeys("125");
				
				//Check Whether the Enable Extended Pre Auth is enable or not
				if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.enableExtPreAuth']")).isSelected())
				{
		
				}
				else
				{
					Thread.sleep(1000);
					//Enable the Enable Extended Pre Auth button
					driver.findElement(By.xpath("//input[@ng-model='storeSettings.enableExtPreAuth']")).click();
				}
				Thread.sleep(2000);
		
			}
			
			Thread.sleep(2000);
			//Check Whether the Open Auto Global Till is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.showAdvertisement']")).isSelected())
			{
				Thread.sleep(1000);
				//Disable the Open Auto Global Till button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.showAdvertisement']")).click();
			}
			else
			{
				
			}
			
			Thread.sleep(2000);
			//Check Whether the Auto Print CloseDay Report is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.autoPrintCloseDayReport']")).isSelected())
			{
				Thread.sleep(1000);
				//Disable the Auto Print CloseDay Report button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.autoPrintCloseDayReport']")).click();
			}
			else
			{
				
			}
			
			Thread.sleep(2000);
			//Check Whether the Show Advertisements is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.showAdvertisement']")).isSelected())
			{
				Thread.sleep(1000);
				//Disable the Show Advertisements button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.showAdvertisement']")).click();
			}
			else
			{
				
			}
			
			//Select the required iPad Custom Button Action
			Select iPadCustomButton = new Select(driver.findElement(By.name("ipadCustom")));
			iPadCustomButton.selectByValue("1");
			
			Thread.sleep(2000);
			//Check Whether the Suggest Tip In CC Receipt is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.tipSuggestion']")).isSelected())
			{
				Thread.sleep(1000);
				//Disable the Suggest Tip In CC Receipt button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.tipSuggestion']")).click();
			}
			else
			{
				
			}
			
			Thread.sleep(2000);
			//Check Whether the Assign Order To Departed Driver is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.tipSuggestion']")).isSelected())
			{
		
			}
			else
			{
				Thread.sleep(1000);
				//Disable the Assign Order To Departed Driver button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.tipSuggestion']")).click();
			}
			
			 
			Thread.sleep(2000);
			//Check Whether the restrict GiftCardTip is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.restrictGiftCardTip']")).isSelected())
			{
		
			}
			else
			{
				Thread.sleep(1000);
				//Disable the GiftCardTip button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.restrictGiftCardTip']")).click();
			}
			
			//Select the Batch Submit Device option
			Select BatchSubmit = new Select(driver.findElement(By.xpath("//select[@ng-model='storeSettings.batchSubmitDevice']")));
			BatchSubmit.selectByIndex(0);
			
			//Enable or Disable the Tip Paid Out
			driver.findElement(By.xpath("//input[@ng-model='storeSettings.enableTipPaidOut']")).click();
			
			//Select the required day of Week
			Select dayOfWeek = new Select(driver.findElement(By.xpath("//select[@ng-model='storeSettings.startDay']")));
			dayOfWeek.selectByVisibleText("FRIDAY");
			
			//Select the required Default Payroll Process 
			Select defaultPayroll = new Select(driver.findElement(By.xpath("//select[@ng-model='storeSettings.defaultPayrollProcess']")));
			defaultPayroll.selectByVisibleText("WEEKLY");
			
			//Clear the Table name field
			driver.findElement(By.name("tableExpirationTime")).clear();
			//Enter the required time
			driver.findElement(By.name("tableExpirationTime")).sendKeys("4");
			
			//Clear the Preferred Network field
			driver.findElement(By.name("preferredNetwork")).clear();
			//Enter the Preferred Network
			driver.findElement(By.name("preferredNetwork")).sendKeys("ONUR'S WIFI");
			
			//Clear the delivery Charge field
			driver.findElement(By.name("deliveryCharge")).clear();
			//Enter the delivery Charge
			driver.findElement(By.name("deliveryCharge")).sendKeys("123");
			
			//Clear the Print Future Order Before field
			driver.findElement(By.name("printFutureOrderBefore")).clear();
			//Enter the Print Future Order Before
			driver.findElement(By.name("printFutureOrderBefore")).sendKeys("8");
			
			Thread.sleep(2000);
			//Check whether the amount is enabled or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[1]/input[1]")).isSelected())
			{
				Thread.sleep(1000);
				//Click the Percentage option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[1]/input[2]")).click();
				
				Thread.sleep(2000);
				//Clear the first field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[2]/ng-form/div/div/input")).clear();
				//Enter the required percentage
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[2]/ng-form/div/div/input")).sendKeys("10");
		
				Thread.sleep(1000);
				//Clear the second field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[3]/ng-form/div/div/input")).clear();
				//Enter the required percentage
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[3]/ng-form/div/div/input")).sendKeys("20");
		
				Thread.sleep(1000);
				//Clear the third field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[4]/ng-form/div/div/input")).clear();
				//Enter the required percentage
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[4]/ng-form/div/div/input")).sendKeys("30");
		
				Thread.sleep(1000);
				//Clear the fourth field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[5]/ng-form/div/div/input")).clear();
				//Enter the required percentage
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[5]/ng-form/div/div/input")).sendKeys("40");
		
			}
			
			//Check the Percentage is enabled or not
			else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[1]/input[2]")).isSelected())
			{
				Thread.sleep(1000);
				//Click the Amount option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[1]/input[1]")).click();
				
				Thread.sleep(2000);
				//Clear the first field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[2]/ng-form/div/div/input")).clear();
				//Enter the required Amount
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[2]/ng-form/div/div/input")).sendKeys("10");
		
				Thread.sleep(1000);
				//Clear the second field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[3]/ng-form/div/div/input")).clear();
				//Enter the required Amount
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[3]/ng-form/div/div/input")).sendKeys("20");
		
				Thread.sleep(1000);
				//Clear the third field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[4]/ng-form/div/div/input")).clear();
				//Enter the required Amount
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[4]/ng-form/div/div/input")).sendKeys("30");
				Thread.sleep(1000);
				//Clear the fourth field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[5]/ng-form/div/div/input")).clear();
				//Enter the required Amount
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[7]/div/div[5]/ng-form/div/div/input")).sendKeys("40");
		
			}
			
			List<WebElement> close = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[3]/div/div/a/i"));
			
			for(int i =2; i<=close.size(); i++)
			{
				Thread.sleep(1000);
				//Click the close button of Payment types
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[3]/div[2]/div/a/i")).click();
				
				Thread.sleep(1000);
				//Switch the control to the alert pouup
				Alert x = driver.switchTo().alert();
				//Accept the alert
				x.accept();
			}
			
			Thread.sleep(1000);
			//Click the Add symbol of Payment Methods option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
			
			Thread.sleep(1000);
			//Select the required payment type
			Select paymentType = new Select(driver.findElement(By.name("paymentType")));
			paymentType.selectByVisibleText("Gift Card");
			
			Thread.sleep(1000);
			//Clear the payment name field
			driver.findElement(By.name("paymentMethod")).clear();
			//Enter the required payment name
			driver.findElement(By.name("paymentMethod")).sendKeys("Gift Card");
			
			Thread.sleep(1000);
			//Click the Add button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[4]/a/i")).click();
		
			
			Thread.sleep(1000);
			//Click the Add symbol of Payment Methods option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
			
			Thread.sleep(1000);
			//Select the required payment type
			paymentType.selectByVisibleText("Credit Card");
			
			Thread.sleep(1000);
			//Clear the payment name field
			driver.findElement(By.name("paymentMethod")).clear();
			//Enter the required payment name
			driver.findElement(By.name("paymentMethod")).sendKeys("Credit Card");
			
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='code']")).clear();
			driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_J");
			
			Thread.sleep(1000);
			//Click the Add button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[4]/a/i")).click();
			
			Thread.sleep(1000);
			//Click the Add symbol of Payment Methods option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
			
			Thread.sleep(1000);
			//Select the required payment type
			paymentType.selectByVisibleText("Side CC");
			
			Thread.sleep(1000);
			//Clear the payment name field
			driver.findElement(By.name("paymentMethod")).clear();
			//Enter the required payment name
			driver.findElement(By.name("paymentMethod")).sendKeys("Side CC");
			
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='code']")).clear();
			driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_K");
			
			Thread.sleep(1000);
			//Click the Add button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[4]/a/i")).click();
			
			Thread.sleep(1000);
			//Click the Add symbol of Payment Methods option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
			
			Thread.sleep(1000);
			//Select the required payment type
			paymentType.selectByVisibleText("Castle And Go");
			
			Thread.sleep(1000);
			//Clear the payment name field
			driver.findElement(By.name("paymentMethod")).clear();
			//Enter the required payment name
			driver.findElement(By.name("paymentMethod")).sendKeys("Castle And Go");
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='code']")).clear();
			driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_L");
			
			Thread.sleep(1000);
			//Click the Add button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[4]/a/i")).click();
			
			Thread.sleep(1000);
			//Click the Add symbol of Payment Methods option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
			
			Thread.sleep(1000);
			//Select the required payment type
			paymentType.selectByVisibleText("SPPax");
			
			Thread.sleep(1000);
			//Clear the payment name field
			driver.findElement(By.name("paymentMethod")).clear();
			//Enter the required payment name
			driver.findElement(By.name("paymentMethod")).sendKeys("SPPax");
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='code']")).clear();
			driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_M");
			
			Thread.sleep(1000);
			//Enable the Enable EBT option
			driver.findElement(By.xpath("//input[@ng-model='paymentMethod.isEbtEnable']")).click();
			
			//Enable the  Factor 4 cards
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@ng-model='paymentMethod.factor4Cards']")).click();
			
			Thread.sleep(1000);
			//Click the Add button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[6]/a/i")).click();
			
			Thread.sleep(1000);
			//Click the Add symbol of Payment Methods option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
			
			Thread.sleep(1000);
			//Select the required payment type
			paymentType.selectByVisibleText("Others");
			
			Thread.sleep(1000);
			//Clear the payment name field
			driver.findElement(By.name("paymentMethod")).clear();
			//Enter the required payment name
			driver.findElement(By.name("paymentMethod")).sendKeys("Others");
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='code']")).clear();
			driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_N");
			
			Thread.sleep(1000);
			//Click the Add button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[4]/a/i")).click();
			
			Thread.sleep(1000);
			//Click the Add symbol of Payment Methods option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
			
			Thread.sleep(1000);
			//Select the required payment type
			paymentType.selectByVisibleText("GiveX");
			
			Thread.sleep(1000);
			//Clear the payment name field
			driver.findElement(By.name("paymentMethod")).clear();
			//Enter the required payment name
			driver.findElement(By.name("paymentMethod")).sendKeys("GiveX");
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='code']")).clear();
			driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_O");
			
			Thread.sleep(1000);
			//Click the Add button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[4]/a/i")).click();
			
			Thread.sleep(1000);
			//Click the Add symbol of Payment Methods option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
			
			Thread.sleep(1000);
			//Select the required payment type
			paymentType.selectByVisibleText("HAPayment");
			
			Thread.sleep(1000);
			//Clear the payment name field
			driver.findElement(By.name("paymentMethod")).clear();
			//Enter the required payment name
			driver.findElement(By.name("paymentMethod")).sendKeys("HAPayment");
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='code']")).clear();
			driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_P");
			
			Thread.sleep(1000);
			//Click the Add button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[4]/a/i")).click();
			
			Thread.sleep(1000);
			//Click the Add symbol of Payment Methods option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
			
			Thread.sleep(1000);
			//Select the required payment type
			paymentType.selectByVisibleText("NMI Tokenization");
			
			Thread.sleep(1000);
			//Clear the payment name field
			driver.findElement(By.name("paymentMethod")).clear();
			//Enter the required payment name
			driver.findElement(By.name("paymentMethod")).sendKeys("NMI Tokenization");
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='code']")).clear();
			driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_Q");
			
			Thread.sleep(1000);
			//Click the Add button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[4]/a/i")).click();
			
			Thread.sleep(1000);
			//Click the Add symbol of Payment Methods option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[1]/div/a[1]/i")).click();
			
			Thread.sleep(1000);
			//Select the required payment type
			paymentType.selectByVisibleText("Dejavoo");
			
			Thread.sleep(1000);
			//Clear the payment name field
			driver.findElement(By.name("paymentMethod")).clear();
			//Enter the required payment name
			driver.findElement(By.name("paymentMethod")).sendKeys("Dejavoo");
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='code']")).clear();
			driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Test_R");
			
			Thread.sleep(1000);
			//Enable the Enable EBT option
			driver.findElement(By.xpath("//input[@ng-model='paymentMethod.isEbtEnable']")).click();
			
			Thread.sleep(1000);
			//Click the Add button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div/div/div/div[2]/form/div[2]/div[8]/div/div[2]/div/div[5]/a/i")).click();
			
			Thread.sleep(3000);
			//Check Whether the Print Coursing Separately is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.printCoursingSeparatley']")).isSelected())
			{
				Thread.sleep(1000);
				//Disable the Print Coursing Separately button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.printCoursingSeparatley']")).click();
			}
			else
			{
			
			}
			
			Thread.sleep(1000);
			//Clear the Floating Tab
			driver.findElement(By.name("floatingTab")).clear();
			//Enter the required Tab Value
			driver.findElement(By.name("floatingTab")).sendKeys("BarTab");
			
			Thread.sleep(2000);
			//Check Whether the Disable Customer Nationality is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.disableCustomerNationality']")).isSelected())
			{
				Thread.sleep(1000);
				//Disable the Disable Customer Nationality button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.disableCustomerNationality']")).click();
			}
			else
			{
			
			}
			
			Thread.sleep(2000);
			//Check Whether the Send Whole Table to Kitchen Printer is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.printTable']")).isSelected())
			{
				Thread.sleep(1000);
				//Disable the Send Whole Table to Kitchen Printer button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.printTable']")).click();
			}
			else
			{
			
			}
			
			Thread.sleep(2000);
			//Check Whether the Show PopUp for Tax Exempt ReferenceId is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.taxExemptId']")).isSelected())
			{
				Thread.sleep(1000);
				//Disable the Show PopUp for Tax Exempt ReferenceId button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.taxExemptId']")).click();
			}
			else
			{
			
			}
			
			Thread.sleep(2000);
			//Check Whether the Service Charge is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.saleEnableText']")).isSelected())
			{
		
			}
			else
			{
				Thread.sleep(1000);
				//Disable the Service Charge button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.saleEnableText']")).click();
			}
			
			try {
					Thread.sleep(2000);
					//Check Whether the Cash discount is enable or not
					if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.cashDiscountEnable']")).isSelected())
					{
						
					}
					else
					{
						Thread.sleep(1000);
						//Disable the Cash discount button
						driver.findElement(By.xpath("//input[@ng-model='storeSettings.cashDiscountEnable']")).click();
						
					}
			}
				catch (Exception e)
				{
					Thread.sleep(2000);
					
					//Check whether the Instant cash Reward
					if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.cashRewardEnable']")).isEnabled())
					{}
					else
					{
						Thread.sleep(3000);
						//Disable the Instant cash Reward button
						driver.findElement(By.xpath("//input[@ng-model='storeSettings.cashRewardEnable']")).click();
					}
					
					Thread.sleep(2000);
					//Check Whether the Service Charge is enable or not
					driver.findElement(By.xpath("//input[@ng-model='storeSettings.saleEnableText']")).click();
					}
			
		
			Thread.sleep(2000);
			//Check Whether the Do Not Reset Check Number is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.disableResetCheckNumber']")).isSelected())
			{
				Thread.sleep(1000);
				//Disable the Do Not Reset Check Number button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.disableResetCheckNumber']")).click();
			}
			else
			{
			
			}
			
			Thread.sleep(1000);
			//Select the required CDS Theme
			Select cdsTheme = new Select(driver.findElement(By.xpath("//select[@ng-model='storeSettings.cdsTheme']")));
			cdsTheme.selectByValue("DARK");
			
			Thread.sleep(1000);
			//Clear the CDS Discount Text
			driver.findElement(By.name("cdsDiscountText")).clear();
			//Enter the text
			driver.findElement(By.name("cdsDiscountText")).sendKeys("Test");
			
			Thread.sleep(1000);
			//Clear the CDS Loyalty Text
			driver.findElement(By.name("cdsLoyaltyText")).clear();
			//Enter the text
			driver.findElement(By.name("cdsLoyaltyText")).sendKeys("Test");
			
			Thread.sleep(1000);
			//Clear the CDS Get Number Text
			driver.findElement(By.name("cdsGetNumberText")).clear();
			//Enter the text
			driver.findElement(By.name("cdsGetNumberText")).sendKeys("Test");
			
			
			Thread.sleep(2000);
			//Check Whether the CDS Customer Profile is enable or not
			if(driver.findElement(By.xpath("//input[@ng-model='storeSettings.cdsCustomerProfile']")).isSelected())
			{
				Thread.sleep(1000);
				//Disable the CDS Customer Profile button
				driver.findElement(By.xpath("//input[@ng-model='storeSettings.cdsCustomerProfile']")).click();
			}
			else
			{
			
			}
			
		
			Thread.sleep(4000);
			//Click the update button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(3000);
			//Check weather the new denomination form saved or not
			if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Store settings updated successfully"))
			{
				test.log(LogStatus.PASS, "Store settings updated successfully for weekly");
			}
			else
			{
				test.log(LogStatus.FAIL, "Store settings updated fail for weeekly");
			}
			Thread.sleep(5000);watchTutorial(driver);Thread.sleep(5000);
		}

	@Test(priority=7)
	public void Store_Hours_Setting_Method_pageopen(WebDriver driver) throws Exception
	{

		
		//Enter the URl
		Thread.sleep(3000);
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"timings");
		
		Thread.sleep(3000);

		
		//Check weather the Store Hours page is loaded or not
		if(driver.findElement(By.xpath("//a[.='Store Hours']")).getText().equalsIgnoreCase("Store Hours"))
		{
			test.log(LogStatus.PASS, "Store Hours page loaded successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Hours page loaded fail");
		}

		Thread.sleep(3000);

	}	
	
	@Test(priority=8)
	public void StoreHours_Setting_Method_process(WebDriver driver) throws Exception
	{

		Thread.sleep(2000);
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.HOME);
		html.sendKeys(Keys.HOME);
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(2000);

		if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[2]/div/input")).isSelected())
		{}
		else
		{
			driver.findElement(By.xpath("//form[@name='storeCreation']/div[2]/div/input")).click();
			
			//Click the Yes button
			driver.findElement(By.partialLinkText("Yes")).click();
		}
		
		
		Thread.sleep(2000);
		//Click Reset button
		driver.findElement(By.xpath("//a[.='Reset']")).click();
		Thread.sleep(2000);
		
		
		// THE BELOW FOR SUNDAY
		//Click the Up Hour button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a/span")).click();
									     
		//Click the Up minute button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[1]/div/table/tbody/tr[1]/td[3]/a/span")).click();
										
		//Click the Up Hour button of End time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of End Time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[2]/div/table/tbody/tr[1]/td[3]/a/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}


		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
										
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[3]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}
		}
		
		
		
		// THE BELOW FOR MONDAY
		//Click the Up Hour button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a/span")).click();
										
		//Click the Up minute button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[1]/div/table/tbody/tr[1]/td[3]/a/span")).click();
										
		//Click the Up Hour button of End time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of End Time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[3]/a/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}


		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
										
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}
		}
		
		
		
		
		// THE BELOW FOR TUESDAY
		//Click the Up Hour button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[1]/div/table/tbody/tr[1]/td[3]/a/span")).click();
										
		//Click the Up Hour button of End time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of End Time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[2]/div/table/tbody/tr[1]/td[3]/a/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Options
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}


		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
										
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[5]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}
		}
		
		
		
		// THE BELOW FOR WEDNESDAY
		//Click the Up Hour button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[1]/div/table/tbody/tr[1]/td[3]/a/span")).click();
										
		//Click the Up Hour button of End time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of End Time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[2]/div/table/tbody/tr[1]/td[3]/a/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}


		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
										
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[6]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}
		}
		
		
		
		// THE BELOW FOR THURSDAY
		//Click the Up Hour button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[1]/div/table/tbody/tr[1]/td[3]/a/span")).click();
										
		//Click the Up Hour button of End time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of End Time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[2]/div/table/tbody/tr[1]/td[3]/a/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}


		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
										
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[7]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}
		}
		
		
		// THE BELOW FOR FRIDAY
		//Click the Up Hour button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[1]/div/table/tbody/tr[1]/td[3]/a/span")).click();
										
		//Click the Up Hour button of End time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of End Time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[2]/div/table/tbody/tr[1]/td[3]/a/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		
			}


		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
										
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[8]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		
			}
		}
		
		// THE BELOW FOR SATURDAY
		//Click the Up Hour button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of Start time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[1]/div/table/tbody/tr[1]/td[3]/a/span")).click();
										
		//Click the Up Hour button of End time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a/span")).click();
		
		//Click the Up minute button of End Time
		driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[2]/div/table/tbody/tr[1]/td[3]/a/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		

			}


		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
										
			Thread.sleep(2000);
			//Check it is AM or PM in the End Time Option
			if(driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//form[@name='storeCreation']/div[9]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		
				//form[@name='storeCreation']
			}
		}
		
			Thread.sleep(3000);
		//Click the update button
		driver.findElement(By.xpath("//span[.='Update']")).click();
		
		Thread.sleep(5000);watchTutorial(driver);Thread.sleep(5000);
	}

	@Test(priority=9)
	public void StoreHours_DayPart(WebDriver driver) throws Exception
	{
		//Enter the URl
		Thread.sleep(3000);
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"timings");
		
		Thread.sleep(3000);
/*		//Check Store Information page opened or not
		if(driver.findElement(By.xpath("//a[.='Store Information']")).getText().equalsIgnoreCase("Store Information"))
		{
			test.log(LogStatus.PASS, "Store Information page loaded Successfully for Day part");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Information page loaded Failed for Day part");
		}
		 
		Thread.sleep(3000);*/
		
		//Click the Store Hours Option
		//driver.findElement(By.xpath("//span[@id='timing']")).click();
		Thread.sleep(3000);
		
		//Check weather the Store Hours page is loaded or not
		if(driver.findElement(By.xpath("//a[.='Store Hours']")).getText().equalsIgnoreCase("Store Hours"))
		{
			test.log(LogStatus.PASS, "Store Hours page loaded successfully for Day part");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Hours page loaded fail for Day part");
		}

		
		Thread.sleep(2000);
	//Click Day Part option 
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/span/scrollable-tabset/div/div/div/ul/li[2]/a/uib-tab-heading/span")).click();
		
	try		
	{
	Thread.sleep(4000);
	//Click remove button
	if(driver.findElement(By.cssSelector("i.fa.fa-trash-o")).isDisplayed())
	{
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[3]/a/i")).click();
	Thread.sleep(2000);
	//Click yes button
	driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
	}
	else
	{
		
	}
	}
	catch (Exception e)		
	{
	Thread.sleep(3000);
	//Click ADD button to create meals type to update
	driver.findElement(By.cssSelector("button.btn.btn-medium.ng-binding")).click();
	Thread.sleep(3000);
	//Clear the day part meal box
	driver.findElement(By.name("mealType")).clear();
	//Enter the day part meal box
	driver.findElement(By.name("mealType")).sendKeys("Food");
	Thread.sleep(3000);
	//Click the Up Hour button of Start time
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a/span")).click();
	Thread.sleep(2000);
	//Click the Up minute button of Start time
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[1]/div/table/tbody/tr[1]/td[3]/a/span")).click();
	Thread.sleep(3000);							
	//Click the Up Hour button of End time
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a/span")).click();
	
	//Click the Up minute button of End Time
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[2]/div/table/tbody/tr[1]/td[3]/a/span")).click();
	Thread.sleep(2000);
	//Check it is AM or PM in the Start Time Option
	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
	{
		Thread.sleep(2000);
		//Check it is AM or PM in the End Time Option
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}

	}
	else
	{
		Thread.sleep(2000);
		//Click the AM or PM option in the Start Time
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
									
		Thread.sleep(2000);
		//Check it is AM or PM in the End Time Option
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
	

		}
		Thread.sleep(3000);
		//Click the update button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		//Check Store Information page opened or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Shift Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Shift Saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Shift Saved Failed");
		}
		Thread.sleep(4000);
		//Clear the day part meal box
		driver.findElement(By.name("mealType")).clear();
		//Enter the day part meal box
		driver.findElement(By.name("mealType")).sendKeys("Foodie");
		
		Thread.sleep(4000);
		//Click remove button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div/div/div[3]/a/i")).click();
		
		Thread.sleep(2000);
		//Click yes button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();	
		Thread.sleep(3000);
		//Check Store Information page opened or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Shift Removed Successfully"))
		{
			test.log(LogStatus.PASS, "Shift Removed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Shift Removed Failed");
		}
	}}	
	
	}

	@Test(priority=10)
	public void Denominations_Setting_Method_Pageopen(WebDriver driver) throws Exception
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
	public void Denominations_Setting_Method_refresh(WebDriver driver) throws Exception
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
	
	@Test(priority=13)
	public void Denominations_Setting_Method_pagination(WebDriver driver) throws InterruptedException
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
	
	@Test(priority=12)
	public void Denominations_Setting_Method_add(WebDriver driver) throws Exception
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
	public void Denominations_Setting_Method_delete(WebDriver driver) throws Exception
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
	public void Denominations_Setting_Method_close_Button(WebDriver driver) throws Exception
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

	@Test(priority=16)
	public void EMV_Settings_Method_openpage(WebDriver driver) throws Exception
		{

			
			Thread.sleep(3000);
			//Enter the URl
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"emvSettings");
			
			Thread.sleep(3000);
			
			//Check weather the Emv Settings page is loaded or not
			if(driver.findElement(By.xpath("//a[.='Emv Settings']")).getText().equalsIgnoreCase("Emv Settings"))
			{
				test.log(LogStatus.PASS, "Emv Settings page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Emv Settings page loaded fail");
			}

			Thread.sleep(3000);

		}	
		
	@Test(priority=17)
	public void EMV_Settings_Method_refresh(WebDriver driver) throws Exception
		{
			//Click the refresh button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a[1]/i")).click();
			Thread.sleep(3000);
			
			//Check weather the page is refreshed or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Emv Settings"))
			{
				test.log(LogStatus.PASS, "Emv Settings Page refreshed successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Emv Settings Page refreshed successfully");
			}
			
		}
		
	@Test(priority=18)
	public void EMV_Settings_Method_pagination(WebDriver driver) throws InterruptedException
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
			Thread.sleep(1000);
			
			//Click the Pagination option as 10
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[2]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for EMV Settings");
			//Create the web element for Emv Settings Table
			List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table"));
			for (WebElement result : results){						
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available for EMV Settings");
			}
			Thread.sleep(3000);
			
			//Click the Pagination option as 15
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[3]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for EMV Settings");
			//Create the web element for Emv Settings Table
			List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table"));
			for (WebElement result : results1){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available for EMV Settings");
			}
			Thread.sleep(3000);
			
			//Click the Pagination option as 20
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[4]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for EMV Settings");
			//Create the web element for Emv Settings Table
			List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table"));
			for (WebElement result : results2){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available for EMV Settings");
			}
			Thread.sleep(3000);
			
			//Click the Pagination option as 5
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[1]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for EMV Settings");
			//Create the web element for Emv Settings Table
			List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table"));
			for (WebElement result : results3){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available for EMV Settings");
			}
			Thread.sleep(3000);
		}
		
	@Test(priority=19)
	public void EMV_Settings_Method_add(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Click the Add EMV settings button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/button")).click();
			Thread.sleep(2000);
			
			//Check weather the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New EMV Settings']")).getText().equalsIgnoreCase("New EMV Settings"))
			{
				test.log(LogStatus.PASS, "New EMV Settings form or page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New EMV Settings form or page loaded fail");
			}
			
			Thread.sleep(2000);
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the name
			driver.findElement(By.name("name")).sendKeys("New_EMV");
			
			Thread.sleep(2000);
			//Clear the IP Address field
			driver.findElement(By.name("ipAddress")).clear();
			//Enter the IP Address
			driver.findElement(By.name("ipAddress")).sendKeys("192.100.100.145");
			
			//Select the required type
			Select type = new Select(driver.findElement(By.name("type")));
			type.selectByVisibleText("OPTOMANY");
			
			//Clear the port field
			driver.findElement(By.name("optomanyPort")).clear();
			//Enter the PORT number
			driver.findElement(By.name("optomanyPort")).sendKeys("3");
			
			Thread.sleep(5000);
			//Click the Save button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2500);
			
			//Check weather the new denomination form saved or not
			if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("EMV Saved Successfully"))
			{
				test.log(LogStatus.PASS, "New EMV saved successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New EMV saved fail");
			}
		}
				
	@Test(priority=20)
	public void EMV_Settings_Method_edit(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//enter the keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("New_EMV");
			
			//Click the Delete button
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			Thread.sleep(2000);
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the name
			driver.findElement(By.name("name")).sendKeys("New_EMV1");
			
			Thread.sleep(2000);
			//Clear the IP Address field
			driver.findElement(By.name("ipAddress")).clear();
			//Enter the IP Address
			driver.findElement(By.name("ipAddress")).sendKeys("192.100.100.121");
			
			Thread.sleep(4000);
			//Click the update button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(4000);
			//Check weather the new denomination form saved or not
			if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("EMV Updated Successfully"))
			{
				test.log(LogStatus.PASS, "New EMV Updated successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New EMV Updated fail");
			}
			Thread.sleep(3000);
			
			
		}
				
	@Test(priority=21)
	public void EMV_Settings_Method_delete(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//enter the keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("New_EMV1");
			
			//Click the Delete button
			driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
			
			//Click the Yes button in the popup
			Thread.sleep(5000);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
			
			Thread.sleep(3000);
			//Check the denomination deleted or not
			if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("EMV Settings removed successfuly"))
			{
				test.log(LogStatus.PASS, "EMV settings deleted Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "EMV Settings deleted Failed");
			}
			Thread.sleep(3000);
			
			
		}
		
	@Test(priority=22)
	public void EMV_Settings_Method_close_Button(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Click the Add EMV settings button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/button")).click();
			Thread.sleep(2000);
			
			//Check weather the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New EMV Settings']")).getText().equalsIgnoreCase("New EMV Settings"))
			{
				test.log(LogStatus.PASS, "New EMV Settings form or page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New EMV Settings form or page loaded fail");
			}
			
			Thread.sleep(2000);
			//Clear the name field
			driver.findElement(By.name("name")).clear();
			//Enter the name
			driver.findElement(By.name("name")).sendKeys("New_EMV");
			
			Thread.sleep(2000);
			//Clear the IP Address field
			driver.findElement(By.name("ipAddress")).clear();
			//Enter the IP Address
			driver.findElement(By.name("ipAddress")).sendKeys("192.100.100.111");
			
			Thread.sleep(1000);
			//Click the Close button
			driver.findElement(By.xpath("//a[.='Close']")).click();
			Thread.sleep(2000);
			
			//Check weather the new emv settings form closed or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/button")).isDisplayed())
			{
				test.log(LogStatus.PASS, "EMV Settings form Closed successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "EMV Settings form Closed fail");
			}
			Thread.sleep(5000);watchTutorial(driver);Thread.sleep(5000);
	}
		
	@Test(priority=23)
	public void Web_Order_Settings_Method_pageopen(WebDriver driver) throws Exception
		{
			
			Thread.sleep(3000);
			//Enter the URl
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"zenpepper/sync");
			Thread.sleep(3000);

			Thread.sleep(3000);
			//Check weather the Web Order page is loaded or not
			if(driver.findElement(By.xpath("//a[.='Web Order']")).getText().equalsIgnoreCase("Web Order"))
			{
				test.log(LogStatus.PASS, "Web Order page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Web Order page loaded fail");
			}

			Thread.sleep(3000);

		}	
			
	@Test(priority=24)
	public void WebOrder_Settings_Method_update(WebDriver driver) throws Exception
		{		
				Thread.sleep(5000);
				//Click the Sync Data to Web Order button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(8000);
				//Click the Yes button in the popup
				driver.findElement(By.linkText("Yes")).click();

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(5000);
				//Check weather the Store synced or not
				if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Store successfully synced"))
				{
					test.log(LogStatus.PASS, "(Web Order)Store successfully synced");
				}
				else
				{
					test.log(LogStatus.FAIL, "(Web Order)Store synced fail");
				}
				Thread.sleep(5000);watchTutorial(driver);Thread.sleep(5000);
			}
		
	@Test(priority=25)
	public void OT_Settings_Method_openpage(WebDriver driver) throws Exception
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
	public void OT_Settings_Method_add(WebDriver driver) throws Exception
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
	public void OT_Settings_Method_close_Button(WebDriver driver) throws Exception
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
			Thread.sleep(5000);watchTutorial(driver);Thread.sleep(5000);
		}
		
	@Test(priority=28)
	public void Notification_Settings_Method_open(WebDriver driver) throws Exception
		{
			
			Thread.sleep(3000);
			//Enter the URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"notificationSettings");
			
			Thread.sleep(3000);
			
			
			
			Thread.sleep(3000);
			
			WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
			//Check weather the notification Settings page is loaded or not
			if(driver.findElement(By.xpath("//a[.='Notification Settings']")).getText().equalsIgnoreCase("Notification Settings"))
			{
				test.log(LogStatus.PASS, "Notification Settings page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Notification Settings page loaded fail");
			}

			Thread.sleep(3000);

		}	
		
	@Test(priority=29)
	public void Notification_Settings_Method_edit(WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(5000);
			//Clear the Discount amount
			driver.findElement(By.name("discountAmount")).clear();
			//Enter the required Discount amount
			driver.findElement(By.name("discountAmount")).sendKeys("125");
			
			Thread.sleep(2000);
			//Clear the Void amount
			driver.findElement(By.name("voidAmount")).clear();
			//Enter the required Void amount
			driver.findElement(By.name("voidAmount")).sendKeys("110");
			
			Thread.sleep(2000);
			//Clear the Max No Cash Drawer Accessed For No Sale 
			driver.findElement(By.name("noSale")).clear();
			//Enter the required Max No Cash Drawer Accessed For No Sale 
			driver.findElement(By.name("noSale")).sendKeys("2");
			
			Thread.sleep(3000);
			//Check weather the Discount mail check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.discount.enableEmail']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[1]/div/textarea")).sendKeys("test1@mail.com");
				
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[1]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[1]/div/textarea")).sendKeys("test1@mail.com");
			
			
			}
			
			//Check weather the Discount text check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.discount.enableText']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[2]/div/textarea")).sendKeys("7485961425");
				
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[2]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[4]/div[2]/div/textarea")).sendKeys("7485961425");
				
			}
			
			
			//Check weather the Void mail check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.void.enableEmail']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[1]/div/textarea")).sendKeys("test2@mail.com");
					
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[1]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[1]/div/textarea")).sendKeys("test2@mail.com");
				
			}
			
			//Check weather the Void text check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.void.enableText']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[2]/div/textarea")).sendKeys("7485961426");
				
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[2]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[5]/div[2]/div/textarea")).sendKeys("7485961426");
				
			}
			
			//Check weather the Max No Cash Drawer Accessed For No Sale mail check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.noSale.enableEmail']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[1]/div/textarea")).sendKeys("test3@mail.com");
					
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[1]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[1]/div/textarea")).sendKeys("test3@mail.com");
				
			}
			
			//Check weather the Max No Cash Drawer Accessed For No Sale text check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.noSale.enableText']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[2]/div/textarea")).sendKeys("7485961427");
				
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[2]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[6]/div[2]/div/textarea")).sendKeys("7485961427");
				
			}
			
			//Check weather the Time Clock mail check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.timeClock.enableEmail']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[1]/div/textarea")).sendKeys("test4@mail.com");
					
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[1]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[1]/div/textarea")).sendKeys("test4@mail.com");
				
			}
			
			//Check weather the Time Clock text check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.timeClock.enableText']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[2]/div/textarea")).sendKeys("7485961428");
				
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[2]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[7]/div[2]/div/textarea")).sendKeys("7485961428");
				
			}
			
			//Check weather the Daily KPI mail check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.dailyKPI.enableEmail']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[1]/div/textarea")).sendKeys("test5@mail.com");
					
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[1]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[1]/div/textarea")).sendKeys("test5@mail.com");
				
			}
			
			//Check weather the Daily KPI text check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.dailyKPI.enableText']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[2]/div/textarea")).sendKeys("7485961429");
				
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[2]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[8]/div[2]/div/textarea")).sendKeys("7485961429");
				
			}
			
			//Check weather the End Of the Day Alert  mail check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.closeTheDay.enableEmail']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[1]/div/textarea")).sendKeys("test6@mail.com");
					
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[1]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[1]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[1]/div/textarea")).sendKeys("test6@mail.com");
				
			}
			
			//Check weather the End Of the Day Alert text check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.closeTheDay.enableText']")).isSelected())
			{

				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[2]/div/textarea")).sendKeys("7485961430");
				
			}
			else
			{

				Thread.sleep(1000);
				//Enable or disable the first email check box
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[2]/input")).click();
				
				Thread.sleep(1000);
				//CLear the first text are
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[2]/div/textarea")).clear();
				//Enter the required test mail
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[9]/div[2]/div/textarea")).sendKeys("7485961430");
				
			}
			
			
			Thread.sleep(1000);
			//CLear the first text are
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[10]/div[1]/div/textarea")).clear();
			//Enter the required test mail
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[10]/div[1]/div/textarea")).sendKeys("test7@mail.com");
			
		
		
		//Check weather the End Of the Day Alert text check box is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='notificationSettings.waitlist.enableText']")).isSelected())
		{

			Thread.sleep(1000);
			//CLear the first text are
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[10]/div[2]/div/textarea")).clear();
			//Enter the required test mail
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[10]/div[2]/div/textarea")).sendKeys("7485961431");
			
		}
		else
		{

			Thread.sleep(1000);
			//Enable or disable the first email check box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[10]/div[2]/input")).click();
			
			Thread.sleep(1000);
			//CLear the first text are
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[10]/div[2]/div/textarea")).clear();
			//Enter the required test mail
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div[10]/div[2]/div/textarea")).sendKeys("7485961431");
			
		}
			
			Thread.sleep(3000);
			//Click the update button
			driver.findElement(By.xpath("//span[.='Update']")).click();
			Thread.sleep(3000);
			
			//Check weather the notification setting is updated or not  Notification Settings updated successfully
			if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Notification Settings updated successfully"))
			{
				test.log(LogStatus.PASS, "Notification Settings updated successfully");
			}
			
			else{
				test.log(LogStatus.FAIL, "Notification Settings updated fail");
			}
			Thread.sleep(5000);watchTutorial(driver);Thread.sleep(5000);
		}
		
	@Test(priority=30)
	public void Sale_Recap_Settings_Method_openpage(WebDriver driver) throws Exception
		{
			
			Thread.sleep(3000);
			//Enter the URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"saleRecapReportSettings");
			
				
			Thread.sleep(3000);
		
			//Check whether the Sale recap Report Settings page is loaded or not
			if(driver.findElement(By.xpath("//a[.='Sale recap Report Settings']")).getText().equalsIgnoreCase("Sale recap Report Settings"))
			{
				test.log(LogStatus.PASS, " Sale recap Report Settings page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, " Sale recap Report Settings page loaded fail");
			}

			Thread.sleep(3000);

		}	
		
	@Test(priority=31)
	public void  Sale_Recap_Settings_Method_edit(WebDriver driver) throws Exception
	{
			Thread.sleep(2000);
			Thread.sleep(1000);
			//Enable the Guests/Checks check box
			driver.findElement(By.name("guestOrCheck")).click();
			Thread.sleep(2000);
			//Check weather the Guests/Checks check box is enabled or not
			if(driver.findElement(By.name("guestOrCheck")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the Guests/Checks check box
				driver.findElement(By.name("guestOrCheck")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the grandSales check box is enabled or not
			if(driver.findElement(By.name("grandSales")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the grandSales check box
				driver.findElement(By.name("grandSales")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the grossReceipt check box is enabled or not
			if(driver.findElement(By.name("grossReceipt")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the grossReceipt check box
				driver.findElement(By.name("grossReceipt")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the grossVoid check box is enabled or not
			if(driver.findElement(By.name("grossVoid")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the grossVoid check box
				driver.findElement(By.name("grossVoid")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the netVoid check box is enabled or not
			if(driver.findElement(By.name("netVoid")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the netVoid check box
				driver.findElement(By.name("netVoid")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the creditCardSplitUps check box is enabled or not
			if(driver.findElement(By.name("creditCardSplitUp")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the creditCardSplitUp check box
				driver.findElement(By.name("creditCardSplitUp")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the otherPayments check box is enabled or not
			if(driver.findElement(By.name("otherPayments")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the otherPayments check box
				driver.findElement(By.name("otherPayments")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the taxes check box is enabled or not
			if(driver.findElement(By.name("taxes")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the taxes check box
				driver.findElement(By.name("taxes")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the taxExempt check box is enabled or not
			if(driver.findElement(By.name("taxExempt")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the taxExempt check box
				driver.findElement(By.name("taxExempt")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the departmentSummary check box is enabled or not
			if(driver.findElement(By.name("departmentSummary")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the departmentSummary check box
				driver.findElement(By.name("departmentSummary")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the categorySummary check box is enabled or not
			if(driver.findElement(By.name("categorySummary")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the categorySummary check box
				driver.findElement(By.name("categorySummary")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the hourlySummary check box is enabled or not
			if(driver.findElement(By.name("hourlySummary")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the hourlySummary check box
				driver.findElement(By.name("hourlySummary")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the openingBalance check box is enabled or not
			if(driver.findElement(By.name("openingBalance")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the openingBalance check box
				driver.findElement(By.name("openingBalance")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the paid check box is enabled or not
			if(driver.findElement(By.name("paid")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the paid check box
				driver.findElement(By.name("paid")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the Cash drop check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='store.saleRecapReport.cashDrop']")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the Cash drop check box
				driver.findElement(By.xpath("//input[@ng-model='store.saleRecapReport.cashDrop']")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the cashExpected check box is enabled or not
			if(driver.findElement(By.name("cashExpected")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the cashExpected check box
				driver.findElement(By.name("cashExpected")).click();
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
			//Check weather the Over Shortage check box is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='store.saleRecapReport.overShortage']")).isSelected()){}
			else
			{
				Thread.sleep(1000);
				//Enable the Over Shortage check box
				driver.findElement(By.xpath("//input[@ng-model='store.saleRecapReport.overShortage']")).click();
				Thread.sleep(1000);
			}
			Thread.sleep(2000);
			//Check weather the Exclude Opening Balance Calculation is enabled or not
			if(driver.findElement(By.xpath("//input[@name= 'excludeOpeningBalance']")).isSelected()) {}
			else
			{
				Thread.sleep(3000);
				//Enable the Exclude Opening Balance Calculation
				driver.findElement(By.xpath("//input[@name= 'excludeOpeningBalance']")).click();
			}
			
			Thread.sleep(1000);
			//Check whether the User defined name is selected or not
			if(driver.findElement(By.xpath("//input[@ng-model='store.saleRecapReport.paymentMethodOrType']/../../../div[contains(.,'User')]/div/input")).isSelected()){}
			else
			{
				//Click the user defined name check box
				driver.findElement(By.xpath("//input[@ng-model='store.saleRecapReport.paymentMethodOrType']/../../../div[contains(.,'User')]/div/input")).click();
			}
			
			Thread.sleep(1000);
			//Click the update button
			driver.findElement(By.xpath("//span[.='Update']")).click();
			Thread.sleep(3000);
			
			//Check weather theSale recap Report Settings is updated or not
			if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("SaleRecap Report Settings updated successsfully"))
			{
				test.log(LogStatus.PASS, "Sale recap Report Settings updated successfully");
			}
			
			else{
				test.log(LogStatus.FAIL, "Sale recap Report Settings updated fail");
			}
			Thread.sleep(5000);watchTutorial(driver);Thread.sleep(5000);
		}
	
	@Test(priority=32)
	public void  Wait_List_Settings_Method_open_(WebDriver driver) throws Exception
	{

			
			Thread.sleep(3000);
			//Enter the URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"waitList");
			
			Thread.sleep(3000);
			
			//Check weather the Wait List page is loaded or not
			if(driver.findElement(By.xpath("//a[.='Wait List']")).getText().equalsIgnoreCase("Wait List"))
			{
				test.log(LogStatus.PASS, "Wait List page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Wait List page loaded fail");
			}

			Thread.sleep(3000);

		}	
		
	@Test(priority=33)
	public void Wait_List_Settings_Method_refresh(WebDriver driver) throws Exception
		{
			//Click the refresh button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/a/i")).click();
			Thread.sleep(3000);
			
			//Check weather the page is refreshed or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Wait List"))
			{
				test.log(LogStatus.PASS, "Wait List Page refreshed successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Wait List Page refreshed successfully");
			}
			
		}
		
	@Test(priority=34)
	public void Wait_List_Settings_Method_pagination(WebDriver driver) throws InterruptedException
	{
	
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(1000);
			
			//Click the Pagination option as 10
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[2]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Wait List");
			//Create the web element for Wait List Table
			List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table"));
			for (WebElement result : results){						
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available for Wait List");
			}
			Thread.sleep(3000);
			
			//Click the Pagination option as 15
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[3]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Wait List");
			//Create the web element for Wait List Table
			List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table"));
			for (WebElement result : results1){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available for Wait List");
			}
			Thread.sleep(3000);
			
			//Click the Pagination option as 20
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[4]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for Wait List");
			//Create the web element for Wait List Table
			List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table"));
			for (WebElement result : results2){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available for Wait List");
			}
			Thread.sleep(3000);
			
			//Click the Pagination option as 5
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[1]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Wait List");
			//Create the web element for Wait List Table
			List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table"));
			for (WebElement result : results3){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available for Wait List");
			}
			Thread.sleep(3000);
		}
		
	@Test(priority=35)
	public void Wait_List_Settings_Method_add(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Click the Add Wait List button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/button")).click();
			Thread.sleep(2000);
			
			//Check weather the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New Wait List']")).getText().equalsIgnoreCase("New Wait List"))
			{
				test.log(LogStatus.PASS, "New Wait List form or page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Wait List form or page loaded fail");
			}
			
			
			Thread.sleep(2000);
	        List<WebElement> rows=driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table/tbody/tr/td[2]"));
	        rows.size();
	        int large = 0;
	        for(int i = 1; i<= rows.size(); i++)
	        {
	        	String max_Seat_Value = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table/tbody/tr["+i+"]/td[2]")).getText();
	        	int seat_Value = Integer.parseInt(max_Seat_Value);
	        	
	        	if(seat_Value > large)
	        	{
	        		large  = seat_Value;
	        	}
	        	
	        }
	        
	        System.out.println("Maximum Seat number is : "+large);
	        
	        int min_Value = large+1;
	        int max_Value = min_Value+2;
	        
	        Thread.sleep(2000);
	        //Clear the minimum seat value
	        driver.findElement(By.name("minSeat")).clear();
	        //Enter the minimum seat value
	        driver.findElement(By.name("minSeat")).sendKeys(""+min_Value);
	        
	        Thread.sleep(2000);
	        //Clear the maximum seat value
	        driver.findElement(By.name("maxSeat")).clear();
	        //Enter the maximum seat value
	        driver.findElement(By.name("maxSeat")).sendKeys(""+max_Value);
			
			Thread.sleep(2000);
			//Select the required hour
			Select hour = new Select(driver.findElement(By.xpath("//select[@ng-model='selectedHrs']")));
			hour.selectByVisibleText("00");
			
			Thread.sleep(2000);
			//Select the required min
			Select min = new Select(driver.findElement(By.xpath("//select[@ng-model='selectedMins']")));
			min.selectByVisibleText("15");
			
			Thread.sleep(5000);
			//Click the Save button
			driver.findElement(By.xpath("//button[@type='submit']")).click();


			Thread.sleep(2000);
			//Check weather the new denomination form saved or not
			if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Wait List Added Succesfully"))
			{
				test.log(LogStatus.PASS, "Wait List Added Succesfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Wait List Added fail");
			}
		}
		
	@Test(priority=36)
	public void Wait_List_Settings_Method_delete(WebDriver driver) throws Exception
		{     
			Thread.sleep(2000);
	        List<WebElement> rows=driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table/tbody/tr/td[2]"));
	        rows.size();
	        int large = 0;
	        for(int i = 1; i<= rows.size()-1; i++)
	        {
	        	String max_Seat_Value = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table/tbody/tr["+i+"]/td[2]")).getText();
	        	int seat_Value = Integer.parseInt(max_Seat_Value);
	        	
	        	if(seat_Value > large)
	        	{
	        		large  = seat_Value;
	        	}
	        	
	        }
	        
	        int min_Value = large+1;
	        int max_Value = min_Value+2;
	        
			Thread.sleep(2000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//enter the keyword
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(""+max_Value);
			
			
			Thread.sleep(3000);
			//Click the Delete button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/span/a")).click();
		
		
			Thread.sleep(2500);
			//Check the denomination deleted or not
			if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Wait List Removed successfuly"))
			{
				test.log(LogStatus.PASS, "Wait List deleted Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Wait List deleted Failed");
			}
			Thread.sleep(3000);
			
			
		}
		
	@Test(priority=37)
	public void Wait_List_Settings_Method_close_Button(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			
			Thread.sleep(2000);
			//Click the Add Wait List button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/button")).click();
			Thread.sleep(2000);
			
			//Check weather the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New Wait List']")).getText().equalsIgnoreCase("New Wait List"))
			{
				test.log(LogStatus.PASS, "New Wait List form or page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Wait List form or page loaded fail");
			}
			

			
			Thread.sleep(1000);
			//Click the Close button
			driver.findElement(By.xpath("//a[.='Close']")).click();
			Thread.sleep(2000);
			
			//Check weather the new Wait List form closed or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/button")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Wait List form Closed successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Wait List form Closed fail");
			}
			Thread.sleep(5000);watchTutorial(driver);Thread.sleep(5000);
		}
		
	@Test(priority=38)
	public void Wait_List_Reason_Settings_Method_pagination(WebDriver driver) throws InterruptedException
		{			
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchReasonText']")).clear();
			Thread.sleep(1000);
			
			//Click the Pagination option as 10
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[3]/div/div/div/div[2]/div[2]/div/div/div/ul/li[2]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Wait List Reason");
			//Create the web element for Wait List reason Table
			List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[3]/div/div/div/div[2]/div[2]/table"));
			for (WebElement result : results){						
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available for Wait List Reason");
			}
			Thread.sleep(3000);
			
			//Click the Pagination option as 15
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[3]/div/div/div/div[2]/div[2]/div/div/div/ul/li[3]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Wait List Reason");
			//Create the web element for Wait List reason Table
			List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[3]/div/div/div/div[2]/div[2]/table"));
			for (WebElement result : results1){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available for Wait List Reason");
			}
			Thread.sleep(3000);
			
			//Click the Pagination option as 20
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[3]/div/div/div/div[2]/div[2]/div/div/div/ul/li[4]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for Wait List Reason");
			//Create the web element for Wait List reason Table
			List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[3]/div/div/div/div[2]/div[2]/table"));
			for (WebElement result : results2){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available for Wait List Reason");
			}
			Thread.sleep(3000);
			
			//Click the Pagination option as 5
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[3]/div/div/div/div[2]/div[2]/div/div/div/ul/li[1]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Wait List Reason");
			//Create the web element for Wait List REason Table
			List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[3]/div/div/div/div[2]/div[2]/table"));
			for (WebElement result : results3){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available for Wait List Reason");
			}
			Thread.sleep(3000);
		}

	@Test(priority=39)
	public void Wait_List_Reason_Settings_Method_add(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Click the Add Wait List Reason button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/button")).click();
			Thread.sleep(2000);
			
			//Check weather the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New Wait List Reason']")).getText().equalsIgnoreCase("New Wait List Reason"))
			{
				test.log(LogStatus.PASS, "New Wait List Reason form or page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Wait List Reason form or page loaded fail");
			}
			
			Thread.sleep(2000);
			//Clear the reason
			driver.findElement(By.name("waitListReason")).clear();
			Thread.sleep(3000);
			//Enter the reason
			driver.findElement(By.name("waitListReason")).sendKeys("Cleaning Process is going on");
			
			Thread.sleep(3000);
			//Click the Save button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[3]/div/div/div[2]/form/div[2]/div/button")).click();

			Thread.sleep(2500);
			//Check weather the new denomination form saved or not
			if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Wait List Reason Added Succesfully"))
			{
				test.log(LogStatus.PASS, "Wait List Reason Added Succesfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Wait List Reason Added fail");
			}
			Thread.sleep(3000);
		}
		
	@Test(priority=40)
	public void Wait_List_Reason_Settings_Method_delete(WebDriver driver) throws Exception
		{     

	        
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchReasonText']")).clear();
			Thread.sleep(2000);
			//Enter the keyword
			driver.findElement(By.xpath("//input[@ng-model='searchReasonText']")).sendKeys("Cleaning Process is going on");
			
			Thread.sleep(3000);
		 	//Click the Delete button
		   driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/span/a")).click();;
			
			Thread.sleep(2000);
			//Check the denomination deleted or not
			if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Wait List Reason Removed successfuly"))
			{
				test.log(LogStatus.PASS, "Wait List Reason deleted Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Wait List Reason deleted Failed");
			}
			Thread.sleep(3000);
			
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchReasonText']")).clear();
			
		}
		
	@Test(priority=41)
	public void Wait_List_Reason_Settings_Method_close_Button(WebDriver driver) throws Exception
		{
			
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchReasonText']")).clear();
			Thread.sleep(2000);
			//Click the Add Wait List Reason button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/button")).click();
			Thread.sleep(2000);
			
			//Check weather the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New Wait List Reason']")).getText().equalsIgnoreCase("New Wait List Reason"))
			{
				test.log(LogStatus.PASS, "New Wait List Reason form or page loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Wait List Reason form or page loaded fail");
			}
			
			Thread.sleep(2000);
			//Clear the reason
			driver.findElement(By.name("waitListReason")).clear();
			//Enter the reason
			driver.findElement(By.name("waitListReason")).sendKeys("Cleaning Process is going on");

			Thread.sleep(3000);
			//Click the Close button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[3]/div/div/div[2]/form/div[2]/div/a")).click();
			Thread.sleep(2000);
			
			//Check weather the new Wait List form closed or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/button")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Wait List Reason form Closed successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Wait List Reason form Closed fail");
			}
				
				Thread.sleep(3000);
		
		}
}
		