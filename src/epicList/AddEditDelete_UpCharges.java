package epicList;

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

public class AddEditDelete_UpCharges {
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete_UpCharges");
	
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

	@Test(priority=121)
	public void Upcharges_method_openUpchargesPage() throws Exception
	{
/*		//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Upcharges']"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Discounts Option		
		driver.findElement(By.xpath("//span[.='Upcharges']")).click();*/
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"upcharge/list");
		Thread.sleep(5000);
		//Check Up Charges page opened or not
		if(driver.findElement(By.xpath("//span[.='Up Charges']")).getText().equalsIgnoreCase("Up Charges"))
		{
			test.log(LogStatus.PASS, "Up Charges page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Up Charges page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=122)
	public void Upcharges_method_refreshUpchargesPage() throws InterruptedException
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div/a/i")).click();
		Thread.sleep(5000);
		//Check Up charges page opened or not
		if(driver.findElement(By.xpath("//span[.='Up Charges']")).getText().equalsIgnoreCase("Up Charges"))
		{
			test.log(LogStatus.PASS, "Up Charges page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Up Charges page refreshed Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=124)
	public void Upcharges_method_addUpCharges_ApplicableTimePeriodAsAlways() throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(5000);
		//Click the Add or new up charge button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div/button")).click();
		Thread.sleep(2000);
		//Check whether the new up charges form loaded or not
		if(driver.findElement(By.xpath("//h3[.='UpCharge']")).getText().equalsIgnoreCase("UpCharge"))
		{
			test.log(LogStatus.PASS, "New Up Charges page or form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Up Charges page or form loaded Failed");
		}
		
		Thread.sleep(3000);
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("UpChargeName_Category"));
		
		Thread.sleep(2000);
		//Select Level as a Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/a/div/b")).click();
		//Enter the Required Level
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys("Category");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Click the Category Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul")).click();
		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Choose the option as Percentage and amount option button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/div")).click();
		//Choose the percentage option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		//Enter the Up Charge Amount
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/input")).sendKeys("500");
		
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/a")).click();
		//Enter the required Applicable Time Period
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys("Always");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Enable the include Additional Modifier
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[7]/div/label/span")).click();
		
			Thread.sleep(2000);
		//Click the Roles option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[8]/div/div/ul")).click();
		//Enter the required role
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[8]/div/div/ul/li/input")).sendKeys("Driver");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[8]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(3500);
		
		//Check whether the new up charges form loaded or not
		if(driver.findElement(By.xpath("//span[.='Saved successfully']")).getText().equalsIgnoreCase("Saved successfully"))
		{
			test.log(LogStatus.PASS, "New Up Charges page saved Successfully for Applicable Time Period as Always");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Up Charges page saved Failed for Applicable Time Period as Always");
		}
		Thread.sleep(3000);
	
	}

/*	@Test(priority=123)
	public void Upcharges_method_pagination() throws InterruptedException
	{
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		
		//Click the Pagination option as 10
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[2]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Upcharges");
		//Create the web element for Upcharges Table
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]"));
		for (WebElement result : results){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Upcharges");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 15
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[3]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Upcharges");
		//Create the web element for Upcharges Table
		List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]"));
		for (WebElement result : results1){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Upcharges");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[4]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for Upcharges");
		//Create the web element for Upcharges Table
		List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]"));
		for (WebElement result : results2){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Upcharges");
		}
		Thread.sleep(8000);
		
		//Click the Pagination option as 5
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/ul[1]/li[1]/a/span")).click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Upcharges");
		//Create the web element for Upcharges Table
		List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]"));
		for (WebElement result : results3){
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available for Upcharges");
		}
		Thread.sleep(8000);
	}
*/	
	@Test(priority=125)
	public void Upcharges_method_editUpCharges() throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("UpChargeName_Category")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);
		
		//Clear the Name field
		driver.findElement(By.name("name")).clear();
		//Enter the Name
		driver.findElement(By.name("name")).sendKeys(Utility.getProperty("UpChargeName_Category")+"1");

		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(3000);
		//Click the update
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(3500);
		
		//Check whether the Upcharges updated successfully or not
		if(driver.findElement(By.xpath("//div[@role='alert']/span/span")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "Upcharge is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Upcharge is updated Failed");
		}

		Thread.sleep(5000);

	
	}
	
	@Test(priority=126)
	public void Upcharges_method_deleteUpCharges() throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("UpChargeName_Category")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Delete button
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		//Check the menu item deleted or not
		if(driver.findElement(By.xpath("//span[.='Up-Charge Inactivated Successfully']")).getText().equalsIgnoreCase("Up-Charge Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "New UpChrages Item is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New UpChrages Item is deleted Failed");
		}

		Thread.sleep(5000);
	
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the menu item activated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Up-Charge activated Successfully"))
		{
			test.log(LogStatus.PASS, "New UpChrages Item is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New UpChrages Item is activated failed");
		}
	}
	
	@Test(priority=127)
	public void Upcharges_method_cancelButton() throws Exception
	{
		Thread.sleep(3000);
		//Click the Add or new up charge button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[1]/div/div/button")).click();

		Thread.sleep(3000);
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("UpChargeName_Category"));
	
		Thread.sleep(3000);
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(3000);
		//Check whether the new up charges form loaded or not
		if(driver.findElement(By.xpath("//a[.='Up Charges']")).getText().equalsIgnoreCase("Up Charges"))
		{
			test.log(LogStatus.PASS, "New Up Charges page canceled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Up Charges page canceled Failed");
		}
		Thread.sleep(3000);
	
	}
	
	@Test(priority=128)
	public void Upcharges_method_editUpCharges_ApplicableTimePeriodAsDaysOfWeek() throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("UpChargeName_Category")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);

		//Clear the name field
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("UpChargeName_Category")+"20");
		Thread.sleep(2000);
		
		//Select Level as a Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/a/div/b")).click();
		//Enter the Required Level
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys("Sub category");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		//Click the Category Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/ul")).click();

		//Enter the required Sub Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);			 
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Choose the option as Percentage and amount option button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/button")).click();
		//Choose the amount option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/ul/li[1]/a")).click();
		Thread.sleep(2000);
		//Clear the Upcharge amount field
		driver.findElement(By.name("offer")).clear();
		//Enter the Up Charge Amount
		driver.findElement(By.name("offer")).sendKeys("5000");
		
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[7]/div/div/a")).click();
		//Enter the required Applicable Time Period
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[7]/div/div/div/div/input")).sendKeys("Days of Week");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the DAy of a Week Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[8]/div/div/ul")).click();
		//Enter the Required Day
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[8]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[8]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Restriction Time check box
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[9]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//Check whether the Upcharges updated successfully or not
		if(driver.findElement(By.xpath("//span[.='Updated successfully']")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Up Charges page updated Successfully for Applicable Time Period as Days of week");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Up Charges page updated Failed for Applicable Time Period as Days of Week");
		}
		Thread.sleep(3000);
	
	}
	
	@Test(priority=129)
	public void Upcharges_method_editUpCharges_ApplicableTimePeriodAsDaysOfMonth() throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("UpChargeName_Category")+"201");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);

		//Clear the name field
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("UpChargeName_Category")+"21");
		
		Thread.sleep(2000);
		//Select Level as a Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/a/div/b")).click();
		//Enter the Required Level
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys("Menu item");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Click the Category Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/ul")).click();
		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Choose the option as Percentage and amount option button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/button")).click();
		//Choose the percentage option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		//Clear the offer field
		driver.findElement(By.name("offer")).clear();
		//Enter the Up Charge Amount
		driver.findElement(By.name("offer")).sendKeys("5000");
		
		Thread.sleep(2000);
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[7]/div/div/a")).click();
		//Enter the required Applicable Time Period
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[7]/div/div/div/div/input")).sendKeys("Days of Month");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Click the Required date from the calendar
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[8]/div/table/tbody/tr[2]/td[7]/button")).click();
		
		//Enable or Disable the Restriction Months
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[9]/div/label/span")).click();
		
		//Click the Months field
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul")).click();
		//Enter the Required month
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul/li/input")).sendKeys("MAY");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Enable or Disable the Restriction Time Period option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[11]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[12]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		
		//Enable the include Additional Modifier
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[13]/div/label/span")).click();
		Thread.sleep(2000);
		
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		//Check whether the Upcharges updated successfully or not
		if(driver.findElement(By.xpath("//span[.='Updated successfully']")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Up Charges page updated Successfully for Applicable Time Period as Days of Month");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Up Charges page updated Failed for Applicable Time Period as Days of Month");
		}
		Thread.sleep(3000);
	
	}
	
	@Test(priority=130)
	public void Upcharges_method_editUpCharges_ApplicableTimePeriodAsDateRange() throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("UpChargeName_Category")+"211");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);

		//Clear the name field
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("UpChargeName_Category")+"22");
		
		Thread.sleep(2000);
		//Select Level as a Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/a/div/b")).click();
		//Enter the Required Level
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys("Category");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Click the Category Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul")).click();

		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Choose the option as Percentage and amount option button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/div")).click();
		//Choose the percentage option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		//Clear the amount field
		driver.findElement(By.name("offer")).clear();
		//Enter the Up Charge Amount
		driver.findElement(By.name("offer")).sendKeys("500");
		
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/a")).click();
		//Enter the required Applicable Time Period
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Clear the From date field
		driver.findElement(By.name("fromDate")).clear();
		//Enter the required from Date
		driver.findElement(By.name("fromDate")).sendKeys("25-May-2020");
		//Clear the To Date field
		driver.findElement(By.name("endDate")).clear();
		//Enter the required To Date
		driver.findElement(By.name("endDate")).sendKeys("28-May-2020");

		//Enable or Disable the Restriction Days Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[9]/div/label/span")).click();
		
		Thread.sleep(2000);
		//Click the Days of a Week option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul")).click();
		//Enter the Required Date
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

		//Enable or Disable the Restriction time period
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[11]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[12]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[12]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}

		//Enable the include Additional Modifier
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[13]/div/label/span")).click();
		Thread.sleep(2000);
	
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		//Check whether the Upcharges updated successfully or not
		if(driver.findElement(By.xpath("//div[@role='alert']/span/span")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Up Charges page updated Successfully for Applicable Time Period as Date Range");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Up Charges page updated Failed for Applicable Time Period as Date Range");
		}
		Thread.sleep(3000);
	
	}
	
	@Test(priority=131)
	public void Upcharges_method_editUpCharges_ApplicableTimePeriodAsSpecificDate() throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("UpChargeName_Category")+"221");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);

		//Clear the name field
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("UpChargeName_Category")+"23");
		Thread.sleep(2000);
		
		//Select Level as a Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/a/div/b")).click();
		//Enter the Required Level
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys("Category");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Category Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul")).click();

		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Choose the option as Percentage and amount option button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/div")).click();
		//Choose the percentage option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		//Clear the upcharge amount field
		driver.findElement(By.name("offer")).clear();
		//Enter the Up Charge Amount
		driver.findElement(By.name("offer")).sendKeys("500");
		
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/a")).click();
		//Enter the required Applicable Time Period
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys("Specific date");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		//Clear the Date field
		driver.findElement(By.name("date")).click();
		//Enter the required date
		driver.findElement(By.name("date")).sendKeys("05-May-2020");
		
		//Enable or Disable the Restriction Time Period
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[8]/div/label/span")).click();
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[9]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[9]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[9]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}

		//Enable the include Additional Modifier
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/label/span")).click();
		Thread.sleep(2000);
		
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3500);
		
		//Check whether the Upcharges updated successfully or not
		if(driver.findElement(By.xpath("//div[@role='alert']/span/span")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Up Charges page updated Successfully for Applicable Time Period as Specific Date");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Up Charges page updated Failed for Applicable Time Period as Specific Date");
		}
		Thread.sleep(3000);
	
	}
	
	@Test(priority=132)
	public void Upcharges_method_editUpCharges_ApplicableTimePeriodAsStartDateTimeAndEndDateTime() throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("UpChargeName_Category")+"231");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		//Click the Edit icon
		Thread.sleep(3000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);
		
		//Clear the name field
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("UpChargeName_Category")+"24");
		
		Thread.sleep(2000);
		//Select Level as a Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/a/div/b")).click();
		//Enter the Required Level
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys("Category");
		//Press the Enter button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Category Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul")).click();
		//Enter the required Category
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		//Press the Enter key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		//Choose the option as Percentage and amount option button
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/div")).click();
		//Choose the percentage option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[5]/div/div/div/div/ul/li[1]/a")).click();
		Thread.sleep(2000);
		//Clear the upcharge amount field
		driver.findElement(By.name("offer")).clear();
		//Enter the Up Charge Amount
		driver.findElement(By.name("offer")).sendKeys("5000");
		
		//Click the Applicable Time Period Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/a")).click();
		//Enter the required Applicable Time Period
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys("Start date time & end date time");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Clear the From date field
		driver.findElement(By.name("fromDate")).clear();
		//Enter the required from Date
		driver.findElement(By.name("fromDate")).sendKeys("25-May-2020");
		//Clear the To Date field
		driver.findElement(By.name("endDate")).clear();
		//Enter the required To Date
		driver.findElement(By.name("endDate")).sendKeys("28-May-2020");

		//Enable or Disable the Restriction Days
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[9]/div/label/span")).click();
		
		//Click the Days of Week Option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul")).click();
		//Enter the required date from the given option
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul/li/input")).sendKeys("FRIDAY");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[10]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
		
		//Check it is AM or PM in the Start Time Option
		if(driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[11]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the End Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[11]/div/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
		}
		else
		{
			Thread.sleep(2000);
			//Click the AM or PM option in the Start Time
			driver.findElement(By.xpath("//form[@name='upChargeForm']/div[1]/div[11]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
		}

		driver.findElement(By.tagName("html")).sendKeys(Keys.END);Thread.sleep(3000);
		Thread.sleep(2000);
		
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3500);
		
		//Check whether the Upcharges updated successfully or not
		if(driver.findElement(By.xpath("//div[@role='alert']/span/span")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Up Charges page updated Successfully for Applicable Time Period as Start Date Time And End Date Time");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Up Charges page updated Failed for Applicable Time Period as Start Date Time And End Date Time");
		}
		Thread.sleep(3000);
	
	}

}
