package epicList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import epicList_Integrated.Utility;

public class Printer_Configuration {


	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Printer Configuration");
	
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
		Thread.sleep(3000);

		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
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
		
	@Test(priority=400)
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
	public void Front_End_Receipt_method_open_Front_End_Receipt() throws Exception
	{
		//Click the Settings option
		driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[5]/a/span[1]")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Printer Configuration']"));
		//Scroll the page till the Printer Configuration option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
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

	}	
		
	@Test(priority=3)
	public void Front_End_Receipt_method_update_FrontEndReceipt_Template() throws Exception
	{
		Thread.sleep(5000);
		//Select the font size
/*		WebElement mySelectElement = (WebElement)new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@ng-model='settings.fontSize']")));
		Select fontSize = new Select(mySelectElement);
		fontSize.selectByVisibleText("Small");*/
/*		driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[1]/div[2]/select")).click();
		Thread.sleep(2000);
		WebElement mySelectElement = (WebElement)new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[1]/div[2]/select/option[1]")));
		mySelectElement.click();*/
		
/*		driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[1]/div[2]/select")).click();
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
		}*/
		
		
/*		Select fontSize = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSize']")));
		fontSize.selectByVisibleText("Small");
		Thread.sleep(2000);*/
		
		Thread.sleep(2000);
		
		
		//Check whether the Store Logo is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreLogo']")).isSelected())
		{
			//Select the required store logo
			driver.findElement(By.id("storeImage")).sendKeys(Utility.getProperty("Store_Logo_Path"));
		}
		else
		{
			//Enable the Store Logo option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[2]/label/span")).click();
			Thread.sleep(2000);
			//Select the required store logo
			driver.findElement(By.id("storeImage")).sendKeys(Utility.getProperty("Store_Logo_Path"));
		}
		Thread.sleep(2000);
		
		
		//Check whether the store name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreName']")).isSelected()){}
		
		else
		{
			//Enable the Store name Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[5]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the table name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTableName']")).isSelected()){}
		
		else
		{
			//Enable the table name Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[6]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the seat number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showSeatNumber']")).isSelected()){}
		
		else
		{
			//Enable the seat number Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[7]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Check Open Server field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServerName']")).isSelected()){}
		
		else
		{
			//Enable the Check Open Server Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[8]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Check Close Server field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.closeServerName']")).isSelected()){}
		
		else
		{
			//Enable the Check Close Server Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[9]/label/span")).click();
		}
		Thread.sleep(2000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		//Check whether the Check number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCheckNumber']")).isSelected())
		{
/*			Thread.sleep(2000);
			//select the Position
			WebElement mySelectElement1 = (WebElement)new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@ng-model='settings.checkNumberPosition']")));
			Select position =  new Select(mySelectElement1);
			position.selectByVisibleText("P#1");
			
			Thread.sleep(2000);
			//Select the Font Size
			WebElement mySelectElement2 = (WebElement)new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@ng-model='settings.checkNumberFs']")));
			Select fontSizeCheckNumber = new Select(mySelectElement2);
			fontSizeCheckNumber.selectByVisibleText("Normal");*/
			
			Select position = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[10]/div[1]/select")));
			position.selectByVisibleText("P#1");
			
			Thread.sleep(2000);
			
			Select fontSize = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[10]/div[2]/select")));
			fontSize.selectByVisibleText("2 Height");
			Thread.sleep(2000);
		}
		
		else
		{
			Thread.sleep(2000);
			//Enable the Check number Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[10]/label/span")).click();
			
/*			Thread.sleep(2000);
			//select the Position
			WebElement mySelectElement1 = (WebElement)new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@ng-model='settings.checkNumberPosition']")));
			Select position =  new Select(mySelectElement1);
			position.selectByVisibleText("P#1");
			
			Thread.sleep(2000);
			//Select the Font Size
			WebElement mySelectElement2 = (WebElement)new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@ng-model='settings.checkNumberFs']")));
			Select fontSizeCheckNumber = new Select(mySelectElement2);
			fontSizeCheckNumber.selectByVisibleText("Normal");*/
			Select position = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[10]/div[1]/select")));
			position.selectByVisibleText("P#1");
			
			Thread.sleep(2000);
			
			Select fontSize = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[10]/div[2]/select")));
			fontSize.selectByVisibleText("2 Height");
			Thread.sleep(2000);
			
			
		}
		Thread.sleep(2000);
		
		//Check whether the Open Date and Time field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showDate']")).isSelected()){}
		
		else
		{
			//Enable the Open Date and Time Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[12]/label/span")).click();
		}
		Thread.sleep(2000);
		
		
		//Check whether the Close Date and Time field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.closeDate']")).isSelected()){}
		
		else
		{
			//Enable the Close Date and Time Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[13]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Customer name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerName']")).isSelected()){}
		
		else
		{
			//Enable the customer name Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[14]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Service Type field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServiceType']")).isSelected()){}
		
		else
		{
			//Enable the Service Type Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[15]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Show Secondary menu name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showLocalName']")).isSelected()){}
		
		else
		{
			//Enable the  Show Secondary menu name Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[16]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Roll Out Modifier Price To Menu field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.rollOutModifierPrice']")).isSelected()){}
		
		else
		{
			//Enable the  Roll Out Modifier Price To Menu Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[17]/label/span")).click();
		}
		Thread.sleep(2000);
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		}
		
		//Check whether the Exclude zero price menu item field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.excludeZeroPriceMenu']")).isSelected()){}
		
		else
		{
			//Enable the Exclude zero price menu item Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[18]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Exclude Zero Price Modifier field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.excludeZeroPriceModifier']")).isSelected()){}
		
		else
		{
			//Enable the Exclude Zero Price Modifier item Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[19]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Tax Summary field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTaxSummary']")).isSelected()){}
		
		else
		{
			//Enable the Tax Summary Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[20]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Gratuity field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showGratuity']")).isSelected()){}
		
		else
		{
			//Enable the Gratuity Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[21]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Tip field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTip']")).isSelected()){}
		
		else
		{
			//Enable the Tip Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[22]/label/span")).click();
		}
		Thread.sleep(2000);
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		}
		
		//Check whether the Tender Details field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTenderDetails']")).isSelected()){}
		
		else
		{
			//Enable the Tender Details Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[23]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Loyalty Amount field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showLoyaltyAmount']")).isSelected()){}
		
		else
		{
			//Enable the Loyalty Amount Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[24]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Tip Line field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTipLine']")).isSelected()){}
		
		else
		{
			//Enable the Tip Line Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[25]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Signature field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showSignature']")).isSelected()){}
		
		else
		{
			//Enable the Signature Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[26]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Tip Suggestion field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTipSuggestion']")).isSelected()){}
		
		else
		{
			//Enable the Tip Suggestion Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[27]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Address field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreAddress']")).isSelected()){}
		
		else
		{
			//Enable the Address Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[29]/label/span")).click();
		}
		Thread.sleep(2000);
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		}
		
		//Check whether the Email field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreEmail']")).isSelected()){}
		
		else
		{
			//Enable the Email Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[30]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Phone Number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStorePhoneNumber']")).isSelected()){}
		
		else
		{
			//Enable the Phone Number Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[31]/label/span")).click();
		}
		Thread.sleep(2000);
		
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
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[34]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Email field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showEmail']")).isSelected()){}
		
		else
		{
			//Enable the Email Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[35]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Phone Number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showPhoneNumber']")).isSelected()){}
		
		else
		{
			//Enable the Phone Number Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[36]/label/span")).click();
		}
		Thread.sleep(2000);
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		}
		
		//Check whether the Barcode field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showBarcode']")).isSelected()){}
		
		else
		{
			//Enable the Barcode Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[37]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Clear the free text
		driver.findElement(By.xpath("//textarea[@ng-model='settings.freeText']")).clear();
		//Enter the required text
		driver.findElement(By.xpath("//textarea[@ng-model='settings.freeText']")).sendKeys("Have a nice day, Visit us again!");
		Thread.sleep(2000);
		
		//Check whether the Cut Paper After Each print field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.cutReceipt']")).isSelected()){}
		
		else
		{
			//Enable the Cut Paper After Each print Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[39]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Notes field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showNotes']")).isSelected()){}
		
		else
		{
			//Enable the Notes Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[40]/label/span")).click();
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
	
	@Test(priority=5)
	public void Front_End_Receipt_method_verifyUpdatedDetails() throws Exception
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
		Thread.sleep(2000);
		
		
		//Check whether the store name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreName']")).isSelected())
		{
			test.log(LogStatus.PASS, "Store name button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store name button is disabled");
		}
		Thread.sleep(2000);

		
		//Check whether the table name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTableName']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Table name button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Table name button is disabled");
		}
		Thread.sleep(2000);
		
		//Check whether the seat number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showSeatNumber']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Seat Number button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Seat Number button is disabled");
		}
		Thread.sleep(2000);
		
		//Check whether the Check Open Server field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServerName']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Open Server button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Open Server button is disabled");
		}
		Thread.sleep(2000);
		
		//Check whether the Check Close Server field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.closeServerName']")).isSelected())
		{
			test.log(LogStatus.PASS, "Close Server button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Close Server button is disabled");
		}
		Thread.sleep(2000);
		
		
		
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
		Thread.sleep(2000);
		
		//Check whether the Open Date and Time field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showDate']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Open Date and Time button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Open Date and Time button is disabled");
		}
		Thread.sleep(2000);
		
		
		//Check whether the Close Date and Time field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.closeDate']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Close Date and Time button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Close Date and Time button is disabled");
		}
		Thread.sleep(2000);
		
		//Check whether the Customer name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerName']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Customer name button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Customer name button is disabled");
		}
		
		Thread.sleep(2000);
		
		//Check whether the Service Type field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServiceType']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Service Type button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Type button is disabled");
		}
		Thread.sleep(2000);
		
		//Check whether the Show Secondary menu name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showLocalName']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Secondary menu name button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Secondary menu name button is disabled");
		}
		Thread.sleep(2000);
		
		//Check whether the Roll Out Modifier Price To Menu field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.rollOutModifierPrice']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Roll Out Modifier Price To Menu is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Roll Out Modifier Price To Menu button is disabled");
		}
		Thread.sleep(2000);
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
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
		Thread.sleep(2000);
		
		//Check whether the Exclude Zero Price Modifier field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.excludeZeroPriceModifier']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Exclude Zero Price Modifier button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Exclude Zero Price Modifier button is disabled");
		}
		Thread.sleep(2000);
		
		//Check whether the Tax Summary field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTaxSummary']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Tax Summary button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Summary button is disabled");
		}
		Thread.sleep(2000);
		
		//Check whether the Gratuity field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showGratuity']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Gratuity button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gratuity button is disabled");
		}
		Thread.sleep(2000);
		
		//Check whether the Tip field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTip']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Tip button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip button is disabled");
		}
		Thread.sleep(2000);
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
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
		Thread.sleep(2000);
		
		//Check whether the Loyalty Amount field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showLoyaltyAmount']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Loyalty Amount button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Loyalty Amount button is disabled");
		}
		Thread.sleep(2000);
		
		//Check whether the Tip Line field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTipLine']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Tip Line button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Line button is disabled");
		}
		Thread.sleep(2000);
		
		//Check whether the Signature field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showSignature']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Signature button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Signature button is disabled");
		}
		Thread.sleep(2000);
		
		//Check whether the Tip Suggestion field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTipSuggestion']")).isSelected())	
		{
			test.log(LogStatus.PASS, "Tip Suggestion button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Suggestion button is disabled");
		}
		Thread.sleep(2000);
		
		//Check whether the Address field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreAddress']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Address button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Address button is disabled");
		}
		Thread.sleep(2000);
		
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
		Thread.sleep(2000);
		
		//Check whether the Phone Number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStorePhoneNumber']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Phone Number button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Phone Number button is disabled");
		}
		Thread.sleep(2000);

		
		//Check whether the Address field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showAddress']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Address button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Address button is disabled");
		}
		Thread.sleep(2000);
		
		//Check whether the Email field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showEmail']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Email button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Email button is disabled");
		}
		Thread.sleep(2000);
		
		//Check whether the Phone Number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showPhoneNumber']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Phone Number button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Phone Number button is disabled");
		}
		Thread.sleep(2000);
		
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
		Thread.sleep(2000);
		
		
		//Check whether the Cut Paper After Each print field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.cutReceipt']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Cut Paper After Each print button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Cut Paper After Each print button is disabled");
		}
		Thread.sleep(2000);
		
		//Check whether the Notes field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showNotes']")).isSelected())		
		{
			test.log(LogStatus.PASS, "Notes button is enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Notes button is disabled");
		}
		Thread.sleep(2000);
	}
	
	@Test(priority=11)
	public void Kitchen_Receipt_Template_method_open_Kitchen_Receipt_Template() throws Exception
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
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"frontEndReceiptTemplate");
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
		
		Thread.sleep(3000);
		//Click the Kitchen Receipt Template
		driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/scrollable-tabset/div/div/div/ul/li[2]/a/uib-tab-heading/span")).click();
		Thread.sleep(2000);
		
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
		
	@Test(priority=12)
	public void Kitchen_Receipt_Template_method_update_Kitchen_Receipt_Template() throws Exception
	{
		Thread.sleep(5000);
		//Select the font size
/*		WebElement mySelectElement = (WebElement)new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@ng-model='settings.fontSize']")));
		Select fontSize = new Select(mySelectElement);
		fontSize.selectByVisibleText("Small");*/
		driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[1]/div[2]/select")).click();
		Thread.sleep(2000);
		WebElement mySelectElement = (WebElement)new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[1]/div[2]/select/option[1]")));
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
		//Enable store name field is enabled or not
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[2]/label/span")).click();

		Thread.sleep(2000);
		
		//Check whether the table name field is enabled or not
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[3]/label/span")).click();
		Thread.sleep(2000);
		
		//Check whether the Server name field is enabled or not
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[4]/label/span")).click();
		Thread.sleep(2000);
		
		//Check whether the Check number field is enabled or not
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[5]/label/span")).click();
		Thread.sleep(2000);
		
		//Check whether the Date and Time field is enabled or not
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[6]/label/span")).click();
		Thread.sleep(2000);

				
		//Check whether the Customer name field is enabled or not
	    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[7]/label/span")).click();
        Thread.sleep(2000);
	
		//Check whether the Service Type field is enabled or not
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[8]/label/span")).click();
		Thread.sleep(4000);
		
		//Check whether the Split By Course field is enabled or not
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[9]/label/span")).click();
		Thread.sleep(4000);
		
		//Check whether the Customer Information Position field is enabled or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[10]/lablel[1]/input")).isSelected()){}
		
		else
		{
			//Enable the Customer Information Position Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[10]/lablel[1]/input")).click();
		}
		Thread.sleep(2000);
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		}
		
		
		//Check whether the Address field is enabled or not
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[11]/label/span")).click();
		Thread.sleep(2000);
		
		//Check whether the Email field is enabled or not
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[12]/label/span")).click();
		Thread.sleep(2000);
		
		//Check whether the Phone Number field is enabled or not
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[13]/label/span")).click();
		Thread.sleep(2000);
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		}
		

		//Check whether the Cut Paper After Each print field is enabled or not
		 driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[14]/label/span")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[15]/label/span")).click();
		
		Thread.sleep(5000);
		//Click the update button
		driver.findElement(By.xpath("//button[@id='updateKitchenReceipt']")).click();
		Thread.sleep(4000);
		
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

	@Test(priority=21)
	public void Email_Receipt_Template_method_open_Email_Receipt_Template() throws Exception
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
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"frontEndReceiptTemplate");
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
		
		Thread.sleep(3000);
		//Click the Email Receipt Template
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/scrollable-tabset/div/div/div/ul/li[3]/a/uib-tab-heading/span")).click();

		Thread.sleep(3000);
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
		
	@Test(priority=22)
	public void Email_Receipt_Template_method_update_Email_Receipt_Template() throws Exception
	{
		Thread.sleep(5000);
		//Select the required Banner Background
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[1]/div/div[3]")).click();
		
		Thread.sleep(2000);
			
		//Check whether the Store Image is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showStoreImage']")).isSelected())
		{}
		else
		{
			//Enable the Store Image option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[2]/div/div[1]/label/span")).click();
			}
		Thread.sleep(2000);
		
		
		//Check whether the Customer Feedback field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerFeedBack']")).isSelected()){}
		
		else
		{
			//Enable the Customer Feedback Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[3]/div/div/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the table name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTableName']")).isSelected()){}
		
		else
		{
			//Enable the table name Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[4]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the seat number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showSeatNumber']")).isSelected()){}
		
		else
		{
			//Enable the seat number Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[5]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Server name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServerName']")).isSelected()){}
		
		else
		{
			//Enable the Server name Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[6]/label/span")).click();
		}
		Thread.sleep(2000);
		
		
		
		//Check whether the Check number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCheckNumber']")).isSelected())
		{}
		
		else
		{
			//Enable the Check number Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[7]/div/div/label/span")).click();
					
		}
		Thread.sleep(2000);
		
		//Check whether the Date field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showDate']")).isSelected()){}
		
		else
		{
			//Enable the Date Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[8]/div/div[1]/label/span")).click();
		}
		Thread.sleep(2000);
			
		//Check whether the Customer name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showCustomerName']")).isSelected()){}
		
		else
		{
			//Enable the customer name Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[8]/div/div[2]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Service Type field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showServiceType']")).isSelected()){}
		
		else
		{
			//Enable the Service Type Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[8]/div/div[3]/label/span")).click();
		}
		Thread.sleep(2000);
		
		
		//Check whether the Order Summary field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showOrderSummary']")).isSelected()){}
		
		else
		{
			//Enable the Order Summary Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[9]/div/div/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Show Secondary menu name field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showLocalName']")).isSelected()){}
		
		else
		{
			//Enable the  Show Secondary menu name Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[10]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Roll Out Modifier Price To Menu field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.rollOutModifierPrice']")).isSelected()){}
		
		else
		{
			//Enable the  Roll Out Modifier Price To Menu Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[11]/label/span")).click();
		}
		Thread.sleep(2000);
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		}
		
		//Check whether the Exclude zero price menu item field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.excludeZeroPriceMenu']")).isSelected()){}
		
		else
		{
			//Enable the Exclude zero price menu item Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[12]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Exclude Zero Price Modifier field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.excludeZeroPriceModifier']")).isSelected()){}
		
		else
		{
			//Enable the Exclude Zero Price Modifier item Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[13]/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Tip field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTip']")).isSelected()){}
		
		else
		{
			//Enable the Tip Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[14]/label/span")).click();
		}
		Thread.sleep(2000);
		
		
		//Check whether the Tax Summary field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTaxSummary']")).isSelected()){}
		
		else
		{
			//Enable the Tax Summary Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[15]/div/div/label/span")).click();
		}
		Thread.sleep(2000);
		
		
		for(int i =0; i <=8; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		}
		
		//Check whether the Tender Details field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showTenderDetails']")).isSelected()){}
		
		else
		{
			//Enable the Tender Details Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[16]/label/span")).click();
		}
		Thread.sleep(2000);
				
		//Check whether the Signature field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showSignature']")).isSelected()){}
		
		else
		{
			//Enable the Signature Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[17]/div/div/label/span")).click();
		}
		Thread.sleep(2000);

		//Check whether the Barcode field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showBarcode']")).isSelected()){}
		
		else
		{
			//Enable the Barcode Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[18]/label/span")).click();
		}
		Thread.sleep(2000);
		
		
		//Check whether the Address field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showAddress']")).isSelected()){}
		
		else
		{
			//Enable the Address Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[19]/div/div/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Email field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showEmail']")).isSelected()){}
		
		else
		{
			//Enable the Email Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[20]/div/div/label/span")).click();
		}
		Thread.sleep(2000);
		
		//Check whether the Phone Number field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showPhoneNumber']")).isSelected()){}
		
		else
		{
			//Enable the Phone Number Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[21]/div/div/label/span")).click();
		}
		Thread.sleep(2000);
	
		
		//Clear the free text
		driver.findElement(By.xpath("//textarea[@ng-model='settings.freeText']")).clear();
		//Enter the required text
		driver.findElement(By.xpath("//textarea[@ng-model='settings.freeText']")).sendKeys("Have a nice day, Visit us again!");
		Thread.sleep(2000);
		
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
				driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[23]/div/div[2]/div/label/span")).click();
			}
			Thread.sleep(2000);
			
			//Check whether the Twitter Icons field is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.twitter']")).isSelected())
			{
				
			}
			
			else
			{
				//Enable the Twitter Icons Option
				driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[23]/div/div[3]/div/label/span")).click();
			}
			Thread.sleep(2000);
			
			//Check whether the Linked In Icons field is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.linkedin']")).isSelected())
			{
				
			}
			
			else
			{
				//Enable the Linked In Icons Option
				driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[23]/div/div[4]/div/label/span")).click();
			}
			Thread.sleep(2000);
		}
		
		else
		{
			//Enable the Social Icons Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[23]/div/div/label/span")).click();
		
			//Check whether the Face book Icons field is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.facebook']")).isSelected())
			{
				
			}
			
			else
			{
				//Enable the Face book Icons Option
				driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[23]/div/div[2]/div/label/span")).click();
			}
			Thread.sleep(2000);
			
			//Check whether the Twitter Icons field is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='settings.socialIcons.twitter']")).isSelected())
			{
				
			}
			
			else
			{
				//Enable the Twitter Icons Option
				driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[23]/div/div[3]/div/label/span")).click();
			}
			Thread.sleep(4000);
			
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
				driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[23]/div/div[4]/div/label/span")).click();
			}
			Thread.sleep(3000);
		}
		
		
		Thread.sleep(4000);
		
		//Check whether the Show Linga POS Promotion "Powered by Linga POS" field is enabled or not
		if(driver.findElement(By.xpath("//input[@ng-model='settings.showLingaPromotion']")).isSelected()){}
		
		else
		{
			//Enable the Show Linga POS Promotion "Powered by Linga POS" Option
			driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[2]/div[24]/div/div/label/span")).click();
		}									

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

	@Test(priority=31)
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
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"frontEndReceiptTemplate");
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
		
		Thread.sleep(3000);
		//Click the Kitchen Printer
		driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/scrollable-tabset/div/div/div/ul/li[4]/a/uib-tab-heading/span")).click();

		Thread.sleep(3000);
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
			
	@Test(priority=32)
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
	
	@Test(priority=32)
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
		Thread.sleep(8000);
		
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
		Thread.sleep(8000);
		
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
		Thread.sleep(8000);
		
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
		Thread.sleep(8000);
	}
		
	@Test(priority=34)
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
		
		Thread.sleep(1000);
		//Check whether the Enable Service Type Restriction option is enable or not
		if(driver.findElement(By.name("enableServiceTypeRestriction")).isSelected())
		{
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("QSR");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("ToGo");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("WEBORDER");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
		}
		
		else
		{
			Thread.sleep(1000);
			//Enable or disable service type
			driver.findElement(By.name("enableServiceTypeRestriction")).click();
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("QSR");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("ToGo");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("WEBORDER");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
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
			}
		}
		
		else
		{
			Thread.sleep(1000);
			//Enable the Apply to all Categories
			driver.findElement(By.name("default")).click();
			
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
			}
		}
		
		Thread.sleep(2000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@id='saveKitchen']")).click();
		Thread.sleep(2000);
		
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
	
	@Test(priority=35)
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
		
		Thread.sleep(1000);
		//Check whether the Enable Service Type Restriction option is enable or not
		if(driver.findElement(By.name("enableServiceTypeRestriction")).isSelected())
		{
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul/li/input")).sendKeys("DELIVERY");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul/li/input")).sendKeys("FORHERE");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul/li/input")).sendKeys("PHONEORDER");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul/li/input")).sendKeys(Keys.ENTER);
		}
		
		else
		{
			Thread.sleep(1000);
			//Enable or disable service type
			driver.findElement(By.name("enableServiceTypeRestriction")).click();
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul/li/input")).sendKeys("DELIVERY");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul/li/input")).sendKeys("FORHERE");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul/li/input")).sendKeys("PHONEORDER");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[5]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
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
	}
	
	@Test(priority=36)
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
		driver.findElement(By.linkText("Yes")).click();
		
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
	}
	
	@Test(priority=37)
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

	@Test(priority=41)
	public void Receipt_Printer_method_open_Receipt_Printer() throws Exception
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
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"frontEndReceiptTemplate");
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
		
		Thread.sleep(3000);
		//Click the receipt Printer 
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/scrollable-tabset/div/div/div/ul/li[6]/a/uib-tab-heading/span")).click();

		Thread.sleep(3000);
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
			
	@Test(priority=42)
	public void Receipt_Printer_method_refreshReceipt_Printer() throws InterruptedException
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
	
	@Test(priority=43)
	public void Receipt_Printer_method_pagination() throws InterruptedException
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
		Thread.sleep(8000);
		
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
		Thread.sleep(8000);
		
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
		Thread.sleep(8000);
		
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
		Thread.sleep(8000);
	}
		
	@Test(priority=44)
	public void Receipt_Printer_method_add_Receipt_Printer() throws Exception
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
	
	@Test(priority=45)
	public void Receipt_Printer_method_edit_Receipt_Printer() throws Exception
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
	
	@Test(priority=46)
	public void Receipt_Printer_method_delete_Receipt_Printer() throws Exception
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
		driver.findElement(By.linkText("Yes")).click();
		
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
	
	@Test(priority=47)
	public void Receipt_Printer_method_close_Button() throws Exception
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

	@Test(priority=51)
	public void Label_Printer_method_open_Label_Printer() throws Exception
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
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"frontEndReceiptTemplate");
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
		
		Thread.sleep(3000);
		//Click the Label Printer
		driver.findElement(By.xpath("//span[.='Label Printers']")).click();

		Thread.sleep(3000);
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
			
	@Test(priority=52)
	public void Label_Printer_method_refreshLabel_Printer() throws InterruptedException
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
	
	@Test(priority=53)
	public void Label_Printer_method_pagination() throws InterruptedException
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
		Thread.sleep(8000);
		
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
		Thread.sleep(8000);
		
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
		Thread.sleep(8000);
		
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
		Thread.sleep(8000);
	}
		
	@Test(priority=54)
	public void Label_Printer_method_add_Label_Printer() throws Exception
	{
		for(int i = 0; i <= 10; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
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
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/a")).click();
		//Enter the required type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys("Menu");
		//Press Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the name field
		driver.findElement(By.name("name")).clear();
		//Enter the name
		driver.findElement(By.name("name")).sendKeys("New_Label_Print");
		
		Thread.sleep(1000);
		//Click Printer Model options
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[3]/div/a")).click();
		//Enter the required printer model type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[3]/div/div/div/input")).sendKeys("Epson - M165C");
		//Press the Enter Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1000);
		//Clear the IP Address field
		driver.findElement(By.name("IPAddress")).clear();
		//Enter the IP Address
		driver.findElement(By.name("IPAddress")).sendKeys("192.168.111.11");
		
		Thread.sleep(1000);
		//Check whether the Enable Service Type Restriction option is enable or not
		if(driver.findElement(By.name("enableServiceTypeRestriction")).isSelected())
		{
			Thread.sleep(2000);
			//Click the Options list box   
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("QSR");
			//Press the Enter button      
			driver.findElement(By.xpath("////div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("ToGo");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("WEBORDER");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
		}
		
		else
		{
			Thread.sleep(1000);
			//Enable or disable service type
			driver.findElement(By.name("enableServiceTypeRestriction")).click();
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("QSR");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("ToGo");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("WEBORDER");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
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
			}
		}
		
		else
		{
			Thread.sleep(1000);
			//Enable the Apply to all Categories
			driver.findElement(By.name("default")).click();
			
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
			}
		}
		
		Thread.sleep(2000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@id='saveLabel']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		try
		{
		//Check whether the Label printer was saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Printer saved successfully"))
		{
			test.log(LogStatus.PASS, "Label Printer Saved successfully");
		}
		}
		
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Label Printer Saved fail");
		}
		Thread.sleep(3000);

	}
	
	@Test(priority=55)
	public void Label_Printer_method_edit_Label_Printer() throws Exception
	{
		Thread.sleep(2000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required key word
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("New_Label_Print");
		
		Thread.sleep(1000);
		//Click the Edit button
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(2000);
		//Click the Types Option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/a")).click();
		//Enter the required type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys("Address");
		//Press Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Clear the name field
		driver.findElement(By.name("name")).clear();
		//Enter the name
		driver.findElement(By.name("name")).sendKeys("New_Label_Print1");
		
		Thread.sleep(1000);
		//Clear the IP Address field
		driver.findElement(By.name("IPAddress")).clear();
		//Enter the IP Address
		driver.findElement(By.name("IPAddress")).sendKeys("192.168.111.12");
		
		Thread.sleep(1000);
		//Check whether the Enable Service Type Restriction option is enable or not
		if(driver.findElement(By.name("enableServiceTypeRestriction")).isSelected())
		{
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("DELIVERY");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("FORHERE");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("PHONEORDER");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
		}
		
		else
		{
			Thread.sleep(1000);
			//Enable or disable service type
			driver.findElement(By.name("enableServiceTypeRestriction")).click();
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("DELIVERY");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("FORHERE");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Click the Options list box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul")).click();
			//Enter the required Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys("PHONEORDER");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[6]/div/ul/li/input")).sendKeys(Keys.ENTER);
			
		}
		
		Thread.sleep(2000);
		//Click the Update button
		driver.findElement(By.xpath("//button[@id='saveLabel']")).click();
		Thread.sleep(2000);
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		try
		{
		//Check whether the Label printer was updated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Printer updated successfully"))
		{
			test.log(LogStatus.PASS, "Label Printer Updated successfully");
		}
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Label Printer Updated fail");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=56)
	public void Label_Printer_method_delete_Label_Printer() throws Exception
	{
		Thread.sleep(2000);
		//Clear the Search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required key word
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("New_Label_Print1");
		
		Thread.sleep(1000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		//Click the Yes button in the popup
		driver.findElement(By.linkText("Yes")).click();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		try
		{
		//Check the Label Printer deleted or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Printer deleted successfully"))
		{
			test.log(LogStatus.PASS, "New Label Printer is deleted Successfully");
		}
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "New Label Printer is deleted Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=57)
	public void Label_Printer_method_close_Button() throws Exception
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
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/a")).click();
		//Enter the required type
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys("Address");
		//Press Enter button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[4]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
		
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

	@Test(priority=61)
	public void Kitchen_Label_Template_method_open_Kitchen_Label_Template() throws Exception
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
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"frontEndReceiptTemplate");
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
		
		
		
		Thread.sleep(3000);
		//Click the Kitchen Label Template
		driver.findElement(By.xpath("//span[.='Kitchen Label Template']")).click();

		Thread.sleep(3000);
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
		
	@Test(priority=62)
	public void Kitchen_Label_Template_method_update_Kitchen_Label_Template() throws Exception
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
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[3]/div/label/span")).isSelected())
        {}
        else
        {
        	//Enable the Show Date & Time
        driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[3]/div/label/span")).click();
        }
       Thread.sleep(2000);
       
       //Check whether the Order Type is enabled or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[4]/div/label/span")).isSelected())
		{}
		else
		{
			//Enable the Order Type option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[4]/div/label/span")).click();	
		}
		Thread.sleep(2000);
		
		
		//Check whether the Sale number is enabled or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[5]/div/label/span")).isSelected())
		{}
		else
		{
			//Enable the SAle Number option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[5]/div/label/span")).click();
			}
		Thread.sleep(2000);
		
		
		//Check whether the Order number is enabled or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[6]/div/label/span")).isSelected())
		{}
		else
		{
			//Enable the Order Number option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[6]/div/label/span")).click();
			}
		Thread.sleep(2000);
		
		//Check whether the Customer Name is enabled or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[7]/div/label/span")).isSelected())
		{}
		else
		{
			//Enable the Customer Name option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[7]/div/label/span")).click();
			}
		Thread.sleep(2000);
		
		
		Select fontSize1 = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSize_T']")));
		fontSize1.selectByVisibleText("2 width");
		
		
		Select fontSize2 = new Select(driver.findElement(By.xpath("//select[@ng-model='settings.fontSize_B']")));
		fontSize2.selectByVisibleText("2 width");
		
		
		//Check whether the Autocut is enabled or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[10]/div/label/span")).isSelected())
		{}
		else
		{
			//Enable the Autocut option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[10]/div/label/span")).click();
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

	@Test(priority=71)
	public void Label_Template_method_open_Label_Template() throws Exception
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
		
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"frontEndReceiptTemplate");
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
		
		/*Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		*/
		
		//Click Right Home arrow button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/scrollable-tabset/div/button[2]")).click();
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/scrollable-tabset/div/button[2]")).click();
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/scrollable-tabset/div/button[2]")).click();
		
		/*Thread.sleep(5000);
		// Create instance of Java script executor
		JavascriptExecutor je1 = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element1 = driver.findElement(By.xpath("//span[.='Label Template']"));
		//Scroll the page till the Label Template option present
		je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
			*/
		
		Thread.sleep(5000);
		//Click the Label Template
		driver.findElement(By.xpath("//span[.='Label Template']")).click();

		Thread.sleep(3000);
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
		
	@Test(priority=72)
	public void Label_Template_method_update_Label_Template() throws Exception
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
		
		
		Thread.sleep(3000);
		//Check whether the Autocut is enabled or not
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[8]/div/label/span")).click();
		
		
		Thread.sleep(3000);
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
	
	@Test(priority=73)
	public void Label_Template_method_update_Label_Template1() throws Exception
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
		
		Thread.sleep(3000);
		//Check whether the Autocut is enabled or not
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[9]/div/label/span")).click();
		
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
	
	@Test(priority=74)
	public void Label_Template_method_update_Label_Template2() throws Exception
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
		
		Thread.sleep(3000);
		//Check whether the Autocut is enabled or not
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[9]/div/label/span")).click();
		
		
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

}
