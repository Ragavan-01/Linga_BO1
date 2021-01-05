package epicList;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import epicList_Integrated.Utility;

public class AddEditDelete_PaidOut_Reason {
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete_PaidOut");

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
	
	@Test(priority=141)
	public void Reasons_PaidOut_method_openPaidOutReasons() throws Exception
	{
/*		//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Reasons']"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Reasons Option		
		driver.findElement(By.xpath("//span[.='Reasons']")).click();*/
		/*
		Thread.sleep(2000);
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"reasons");
		Thread.sleep(5000);
		//Check Tax exempt page opened or not
		if(driver.findElement(By.xpath("//a[.='Tax Exempt Reasons']")).getText().equalsIgnoreCase("Tax Exempt Reasons"))
		{
			test.log(LogStatus.PASS, "Tax Exempt Reasons page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Exempt Reasons page loaded Failed");
		}*/
		
		Thread.sleep(5000);
		
		//Click the PaidOut Reasons Tap
		driver.findElement(By.xpath("//span[.='Paid Out']")).click();
		Thread.sleep(3000);
		
		//Check PaidOut Reasons page opened or not
		if(driver.findElement(By.xpath("//a[.='Paid Outs']")).getText().equalsIgnoreCase("Paid Outs"))
		{
			test.log(LogStatus.PASS, "Paid Out Reasons page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Paid Out Reasons page loaded Failed");
		}
		

	}
	
	@Test(priority=142)
	public void Reasons_PaidOut_method_refreshPaidOutReasons() throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a/i")).click();
		Thread.sleep(5000);
		//Check PaidOut Reasons page opened or not
		if(driver.findElement(By.xpath("//a[.='Paid Outs']")).getText().equalsIgnoreCase("Paid Outs"))
		{
			test.log(LogStatus.PASS, "Paid Out Reasons page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Paid Out Reasons page refreshed Failed");
		}
		Thread.sleep(5000);

	}
	
	@Test(priority=144)
	public void Reasons_PaidOut_method_addPaidOutReasons() throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		Thread.sleep(5000);
		//Click on the Add PaidOut Reasons option
		driver.findElement(By.id("newReason")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Paid Out"))
		{
			test.log(LogStatus.PASS, "New Paid Out Reason form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Paid Out Reason form loaded Failed");
		}

		Thread.sleep(3000);
		
		//Clear the Reason field
		driver.findElement(By.name("reason")).clear();
		//Enter the Name
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("PaidOutReason"));
		Thread.sleep(2000);
			
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		//Check whether the new discount saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Saved successfully"))
		{
			test.log(LogStatus.PASS, "New Paid Out Reason Saved Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Paid Out Reason Save Failed");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=145)
	public void Reasons_PaidOut_method_editPaidOutReasons() throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("PaidOutReason")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(3000);
		//Clear the Reasons field
		driver.findElement(By.name("reason")).clear();
		//Enter the Reasons
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("PaidOutReason")+"1");


		//Click the update
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Paid Out Reason Updated Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Paid Out Reason Updated failed");
		}

		Thread.sleep(5000);

	}
	
	@Test(priority=146)
	public void Reasons_PaidOut_method_deletePaidOutReasons() throws Exception
	{
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("PaidOutReason")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		//Check the menu item deleted or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Inactivated successfully"))
		{
			test.log(LogStatus.PASS, "Paid Out Reason is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Paid Out Reason is deleted Failed");
		}

		Thread.sleep(7000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		//Click the Yes button in the popup
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the menu item activated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Activated successfully"))
		{
			test.log(LogStatus.PASS, "Paid Out is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Paid Out is activated Failed");
		}
		
		Thread.sleep(5000);
	}

	@Test(priority=147)
	public void Reasons_PaidOut_method_closeButton() throws Exception
	{
		Thread.sleep(5000);
		
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		
		
		//Click on the Add Tax Exempt Reasons option
		driver.findElement(By.id("newReason")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Paid Out"))
		{
			test.log(LogStatus.PASS, "New Paid Out Reason form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Paid Out Reason form loaded Failed");
		}

		Thread.sleep(3000);
		
		//Clear the Reason field
		driver.findElement(By.name("reason")).clear();
		//Enter the Name
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("PaidOutReason"));
		Thread.sleep(2000); 
			
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		Thread.sleep(3000);
		//Check whether the new TaxExemptReason canceled or not
		if(driver.findElement(By.id("newReason")).isDisplayed())
		{
			test.log(LogStatus.PASS, "New Paid Out Reason Canceled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Paid Out Reason Canceled Failed");
		}

		Thread.sleep(5000);
	}
		
	@Test(priority=148)
	public void Reasons_PaidOut_method_verifyActive_InActiveButton() throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();

		Thread.sleep(5000);
		//Click Active or In Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();

		Thread.sleep(5000);
		//Check the New Display Group form is loaded or not
		if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Deleted groups are here, we are in InActive Page");
			Thread.sleep(10000);
			//Click Active or In Active Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();

		}
		else if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Deleted groups are not here, we are in Active Page");
		}
		Thread.sleep(5000);
	}

}
