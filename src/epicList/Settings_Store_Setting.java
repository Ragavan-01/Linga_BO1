package epicList;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import epicList_Integrated.Utility;

public class Settings_Store_Setting {


	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings_Store_Setting");
	
	float unknownValue = 00;
	
	@AfterClass
	public void flushTest() throws Exception
	{
		//Thread.sleep(2000);
		rep.endTest(test);
		rep.flush();
	}
	
	@Test(priority=1)
	public void login() throws Exception
	{
		if(Utility.getProperty("Product").equalsIgnoreCase("UPOS"))
		{
			//Thread.sleep(2000);
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
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);//Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);//Thread.sleep(2000);
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

			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);//Thread.sleep(2000);
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
	
	@Test(priority=4)
	public void Settings_Method_openpage() throws Exception
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
	public void Settings_update_Method_Daily() throws Exception
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
	public void Settings_update_Method_Weekly() throws Exception

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
			Thread.sleep(5000);watchTutorial();Thread.sleep(5000);
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

}
