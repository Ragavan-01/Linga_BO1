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
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Product_And_Item_3 {


	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Product and Item 3");
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

	@Test(priority=2)
	public void Sort_Menu_Config_Ascending_method_openSortMenuConfig(WebDriver driver) throws Exception
	{
		Thread.sleep(15000);
		//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();Thread.sleep(2000);
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Sort Menu Config']"));Thread.sleep(2000);
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Discounts Option		
		driver.findElement(By.xpath("//span[.='Sort Menu Config']")).click();
		Thread.sleep(5000);
		//Check Up Charges page opened or not
		if(driver.findElement(By.xpath("//a[.='Sort']")).getText().equalsIgnoreCase("Sort"))
		{
			test.log(LogStatus.PASS, "Sort Menu Config page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sort Menu Config page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void Sort_Menu_Config_Ascending_method_sortByAscendingOrder_Category(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		//Create the webelement for the Category field
		WebElement showCategory = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[1]"));
		actions.moveToElement(showCategory);				
		actions.click().build().perform();
		Thread.sleep(5000);
		
		//Click the settings icon of Category
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div/img")).click();
		Thread.sleep(2000);		   
		//Check the Category sort field page opened or not
		if(driver.findElement(By.id("myModalLabel")).getText().equalsIgnoreCase("Category Sort"))
		{
			test.log(LogStatus.PASS, "Category Sort page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Category Sort page loaded Failed");
		}
		Thread.sleep(3000);
		//Click the Sort A to Z button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/a[3]")).click();
		Thread.sleep(3000);
		
		//Click the Sort A to Z button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/a[2]")).click();
		Thread.sleep(3000);
		
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the required items sorted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Items sorted successfully"))
		{
			test.log(LogStatus.PASS, "Items sorted by Ascending order Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Items sorted by Ascending order Failed");
		}
		Thread.sleep(10000);
		
	}
	
	@Test(priority=5)
	public void Sort_Menu_Config_Ascending_method_sortByAscendingOrder_Subctegory(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		WebElement showCategory = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[1]"));
		actions.moveToElement(showCategory);				
		actions.click().build().perform();
		Thread.sleep(7000);
			//Click the settings icon of Category
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div/img")).click();
		Thread.sleep(2000);	

		//Check the Category sort field page opened or not
		if(driver.findElement(By.id("myModalLabel")).getText().equalsIgnoreCase("Category Sort"))
		{
			test.log(LogStatus.PASS, "Category Sort page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Category Sort page loaded Failed");
		}
		
		Thread.sleep(5000);
		//Click the Custom Sort button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/a[1]")).click();
		Thread.sleep(3000);
		
		// Element which needs to drag.
		WebElement From = driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/form/div/div/div[1]/div/div[3]/div/ol/li[6]/div"));
		// Element on which need to drop.
		WebElement To = driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/form/div/div/div[1]/div/div[3]/div/ol/li[1]/div"));
		// Using Action class for drag and drop.
		Actions act = new Actions(driver);
		// Dragged and dropped.
		act.dragAndDrop(From, To).build().perform();
		
		//Click the Sort A to Z button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/a[2]")).click();
		
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		//Check the required items sorted or not
		if(driver.findElement(By.xpath("//span[.='Items sorted successfully']")).getText().equalsIgnoreCase("Items sorted successfully"))
		{
			test.log(LogStatus.PASS, "Items sorted by Ascending order Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Items sorted by Ascending order Failed");
		}
		Thread.sleep(3000);
		
		//Click the sub category field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[5]/div/div[1]/div/div[1]/div/ul")).click();
		Thread.sleep(2000);
		//Click the Settings Icon of Sub Category Result
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[5]/div/div[1]/div/div[2]/div/img")).click();
		Thread.sleep(2000);
		
		//Check the Sub Category sort field page opened or not
		if(driver.findElement(By.id("myModalLabel")).getText().equalsIgnoreCase("Sub Category Sort"))
		{
			test.log(LogStatus.PASS, "Sub Category Sort page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Category Sort page loaded Failed");
		}
		Thread.sleep(2000);
		//Click the Sort A to Z button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/a[3]")).click();
		
		Thread.sleep(2000);
		//Click the Sort A to Z button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/a[2]")).click();
		
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check the required items sorted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Items sorted successfully"))
		{
			test.log(LogStatus.PASS, "Items sorted by Ascending order Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Items sorted by Ascending order Failed");
		}
		Thread.sleep(30000);	
	}
	
	@Test(priority=4)
	public void Sort_Menu_Config_Ascending_method_sortByAscendingOrder_MenuItem(WebDriver driver) throws Exception
	{
	
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		//Create the webelement for the Category field
		WebElement showCategory = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[1]"));
		actions.moveToElement(showCategory);				
		actions.click().build().perform();
		Thread.sleep(6000);	
		//Click the settings icon of Category
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div/img")).click();
		Thread.sleep(2000);		   

		//Click the Sort A to Z button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/a[2]")).click();
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();

		Thread.sleep(10000);
		
		Thread.sleep(5000);			
		//Click the Menu Item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[5]/div/div[2]/div[3]/div/div/div[1]/ul")).click();
		Thread.sleep(2000);	
		//Click the Settings Icon of Sub Category Result
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[5]/div/div[2]/div[3]/div/div/div[2]/div/img")).click();
		Thread.sleep(2000);
		
		//Check the Sub Category sort field page opened or not
		if(driver.findElement(By.id("myModalLabel")).getText().equalsIgnoreCase("Menu Item Sort"))
		{
			test.log(LogStatus.PASS, "Menu Item Sort page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Item Sort page loaded Failed");
			
		}
		Thread.sleep(2000);
		
		//Click the Sort z to A button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/div/a[3]")).click();
		
		Thread.sleep(5000);
		
		//Click the Sort A to Z button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/div/a[2]")).click();
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check the required items sorted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Items sorted successfully"))
		{
			test.log(LogStatus.PASS, "Items sorted by Ascending order Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Items sorted by Ascending order Failed");
		}
		Thread.sleep(10000);
	}
	
	@Test(priority=6)
	public void Sort_Menu_Config_Ascending_method_closeButton(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		//Create the webelement for the Category field
		WebElement showCategory = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[1]"));
		actions.moveToElement(showCategory);				
		actions.click().build().perform();
		Thread.sleep(2000);
		//Click the settings icon of Category
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div/img")).click();
		Thread.sleep(2000);		   
		//Check the Category sort field page opened or not
		if(driver.findElement(By.id("myModalLabel")).getText().equalsIgnoreCase("Category Sort"))
		{
			test.log(LogStatus.PASS, "Category Sort page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Category Sort page loaded Failed");
		}

		//Click the Save button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		Thread.sleep(2000);
		//Check the required items close button working or not
		if(driver.findElement(By.xpath("//a[.='Sort']")).getText().equalsIgnoreCase("Sort"))
		{
			test.log(LogStatus.PASS, "Items sorting canceled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Items sorting canceled Failed");
		}
		Thread.sleep(3000);
		
		
	}

	@Test(priority=11)
	public void Sort_Menu_Config_Decending_method_openSortMenuConfig(WebDriver driver) throws Exception
	{
		
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"sort");
		Thread.sleep(5000);
		//Check Up Charges page opened or not
		if(driver.findElement(By.xpath("//a[.='Sort']")).getText().equalsIgnoreCase("Sort"))
		{
			test.log(LogStatus.PASS, "Sort Menu Config page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sort Menu Config page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=12)
	public void Sort_Menu_Config_Decending_method_sortByDecendingOrder(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		WebElement showCategory = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[1]"));
		actions.moveToElement(showCategory);
		actions.click().build().perform();
		Thread.sleep(5000);
		
		//Click the settings icon
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div/img")).click();
		Thread.sleep(2000);
		//Check the Category sort field page opened or not
		if(driver.findElement(By.id("myModalLabel")).getText().equalsIgnoreCase("Category Sort"))
		{
			test.log(LogStatus.PASS, "Category Sort page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Category Sort page loaded Failed");
		}
		
		//Click the Sort Z to A button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/a[3]")).click();
		Thread.sleep(3000);
		
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the required items sorted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Items sorted successfully"))
		{
			test.log(LogStatus.PASS, "Items sorted by Decending order Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Items sorted by Decending order Failed");
		}
		Thread.sleep(10000);
	}
	
	@Test(priority=14)
	public void Sort_Menu_Config_Decending_method_sortByDecendingOrder_Subctegory(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		//Create the webelement for the Category field
		WebElement showCategory = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[1]"));
		actions.moveToElement(showCategory);				
		actions.click().build().perform();
		Thread.sleep(5000);
		
		//Click the settings icon of Category
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div/img")).click();
		Thread.sleep(2000);		   

		//Click the Sort A to Z button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/a[2]")).click();
		Thread.sleep(5000);
	
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(10000);
		
		//Click the sub category field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[5]/div/div[1]/div/div[1]/div/ul")).click();
		Thread.sleep(2000);
		//Click the Settings Icon of Sub Category Result
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[5]/div/div[1]/div/div[2]/div/img")).click();
		Thread.sleep(2000);
		
		//Check the Sub Category sort field page opened or not
		if(driver.findElement(By.id("myModalLabel")).getText().equalsIgnoreCase("Sub Category Sort"))
		{
			test.log(LogStatus.PASS, "Sub Category Sort page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Category Sort page loaded Failed");
		}
		Thread.sleep(2000);
		//Click the Sort Z to A button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/a[2]")).click();
		Thread.sleep(1000);
		//Click the Sort Z to A button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/a[3]")).click();
		
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check the required items sorted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Items sorted successfully"))
		{
			test.log(LogStatus.PASS, "Items sorted by Decending order Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Items sorted by Decending order Failed");
		}
		Thread.sleep(3000);
		
	}
	
	@Test(priority=13)
	public void Sort_Menu_Config_Decending_method_sortByDecendingOrder_MenuItem(WebDriver driver) throws Exception
	{
		
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		//Create the webelement for the Category field
		WebElement showCategory = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[1]"));
		actions.moveToElement(showCategory);				
		actions.click().build().perform();
		Thread.sleep(5000);
		
		//Click the settings icon of Category
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div/img")).click();
		Thread.sleep(2000);		   

		//Click the Sort A to Z button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/a[2]")).click();
		Thread.sleep(5000);
	
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(30000);
	
		//Click the menu item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[5]/div/div[2]/div[3]/div/div/div[1]/ul")).click();
		Thread.sleep(2000);
		//Click the Settings Icon of menu item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[5]/div/div[2]/div[3]/div/div/div[2]/div/img")).click();
		Thread.sleep(2000);        
		
		//Check the Sub Category sort field page opened or not
		if(driver.findElement(By.id("myModalLabel")).getText().equalsIgnoreCase("Menu Item Sort"))
		{
			test.log(LogStatus.PASS, "Menu Item Sort page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Item Sort page loaded Failed");
		}
		Thread.sleep(2000);
		//Click the Sort Z to A button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/div/a[2]")).click();
		
		Thread.sleep(2000);
		//Click the Sort Z to A button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/div/a[3]")).click();
		
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check the required items sorted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Items sorted successfully"))
		{
			test.log(LogStatus.PASS, "Items sorted by Decending order Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Items sorted by Decending order Failed");
		}
		Thread.sleep(3000);
	}

	@Test(priority=21)
	public void Sort_Menu_Config_Customsort_method_openSortMenuConfig(WebDriver driver) throws Exception
	{
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"sort");
		Thread.sleep(5000);
		//Check Up Charges page opened or not
		if(driver.findElement(By.xpath("//a[.='Sort']")).getText().equalsIgnoreCase("Sort"))
		{
			test.log(LogStatus.PASS, "Sort Menu Config page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sort Menu Config page loaded Failed");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=22)
	public void Sort_Menu_Config_Customsort_method_sortByCustomSort(WebDriver driver) throws Exception
	{
		Thread.sleep(8000);
		Actions actions = new Actions(driver);
		WebElement showCategory = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[1]"));
		actions.moveToElement(showCategory);
		actions.click().build().perform();
		Thread.sleep(5000);
		
		//Click the settings icon
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div/img")).click();
		Thread.sleep(2000);
		//Check the Category sort field page opened or not
		if(driver.findElement(By.id("myModalLabel")).getText().equalsIgnoreCase("Category Sort"))
		{
			test.log(LogStatus.PASS, "Category Sort page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Category Sort page loaded Failed");
		}
		Thread.sleep(2000);
		//Click the Custom Sort button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/a[1]")).click();
		Thread.sleep(3000);
		
		// Element which needs to drag.
		WebElement From = driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/form/div/div/div[1]/div/div[3]/div/ol/li[3]/div"));
		// Element on which need to drop.
		WebElement To = driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/form/div/div/div[1]/div/div[3]/div/ol/li[1]/div"));
		// Using Action class for drag and drop.
		Actions act = new Actions(driver);
		// Dragged and dropped.
		act.dragAndDrop(From, To).build().perform();
     
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check the required items sorted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Items sorted successfully"))
		{
			test.log(LogStatus.PASS, "Items sorted by Custom Sort order Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Items sorted by Custom Sort order Failed");
		}
		Thread.sleep(10000);
	}
	
	@Test(priority=24)
	public void Sort_Menu_Config_Customsort_method_sortByCustomSort_Subctegory(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		//Create the webelement for the Category field
		WebElement showCategory = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[1]"));
		actions.moveToElement(showCategory);				
		actions.click().build().perform();
		Thread.sleep(5000);
		
		//Click the settings icon of Category
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div/img")).click();
		Thread.sleep(2000);		   

		//Click the Sort A to Z button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/a[2]")).click();
		Thread.sleep(5000);

		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(8000);
		
		Thread.sleep(10000);
		//Click the sub category field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[5]/div/div[1]/div/div[1]/div/ul")).click();
		Thread.sleep(5000);
		//Click the Settings Icon of Sub Category Result
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[5]/div/div[1]/div/div[2]/div/img")).click();
		
		Thread.sleep(2000);
		//Check the Sub Category sort field page opened or not
		if(driver.findElement(By.id("myModalLabel")).getText().equalsIgnoreCase("Sub Category Sort"))
		{
			test.log(LogStatus.PASS, "Sub Category Sort page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Category Sort page loaded Failed");
		}
		Thread.sleep(2000);
		//Click the Custom Sort button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/a[1]")).click();
		Thread.sleep(3000);
		
		// Element which needs to drag.
		WebElement From = driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/form/div/div/div[1]/div/div[3]/div/ol/li[3]/div"));
		// Element on which need to drop.
		WebElement To = driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/form/div/div/div[1]/div/div[3]/div/ol/li[1]/div"));
		// Using Action class for drag and drop.
		Actions act = new Actions(driver);
		// Dragged and dropped.
		act.dragAndDrop(From, To).build().perform();
		
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check the required items sorted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Items sorted successfully"))
		{
			test.log(LogStatus.PASS, "Items sorted by Custom Sort order Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Items sorted by Custom Sort order Failed");
		}
		Thread.sleep(30000);
		
	}
	
	@Test(priority=23)
	public void Sort_Menu_Config_Customsort_method_sortByCustomSort_MenuItem(WebDriver driver) throws Exception
	{
		
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		//Create the webelement for the Category field
		WebElement showCategory = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[1]"));
		actions.moveToElement(showCategory);				
		actions.click().build().perform();
		Thread.sleep(5000);
		
		//Click the settings icon of Category
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div/img")).click();
		Thread.sleep(2000);		   

		//Click the Sort A to Z button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/a[2]")).click();
		Thread.sleep(5000);
	
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(10000);
		
		Thread.sleep(30000);
		//Click the Menu item field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[5]/div/div[2]/div[3]/div/div/div[1]/ul")).click();
		Thread.sleep(2000);
		//Click the Settings Icon of Menu Item Result
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[5]/div/div[2]/div[3]/div/div/div[2]/div/img")).click();
		Thread.sleep(2000);        
		
		//Check the Menu Item sort field page opened or not
		if(driver.findElement(By.id("myModalLabel")).getText().equalsIgnoreCase("Menu Item Sort"))
		{
			test.log(LogStatus.PASS, "Menu Item Sort page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Item Sort page loaded Failed");
		}
		Thread.sleep(2000);
		//Click the Sort Z to A button
		driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/div/div[2]/div/a[1]")).click();
		Thread.sleep(3000);
		
		// Element which needs to drag.
		WebElement From = driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/form/div/div/div[1]/div/div[3]/div/ol/li[2]/div"));
		// Element on which need to drop.
		WebElement To = driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/form/div/div/div[1]/div/div[3]/div/ol/li[1]/div"));
		// Using Action class for drag and drop.
		Actions act = new Actions(driver);
		// Dragged and dropped.
		act.dragAndDrop(From, To).build().perform();
		
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check the required items sorted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Items sorted successfully"))
		{
			test.log(LogStatus.PASS, "Items sorted by Custom Sort order Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Items sorted by Custom Sort order Failed");
		}
		Thread.sleep(3000);
	}

	@Test(priority=31)
	public void Gratuity_method_GratuitiesPage(WebDriver driver) throws Exception
	{

		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"gratuity");
		Thread.sleep(5000);
		//Check items page opened or not
		if(driver.findElement(By.xpath("//a[.='Gratuities']")).getText().equalsIgnoreCase("Gratuities"))
		{
			test.log(LogStatus.PASS, "Gratuities page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gratuities page loaded Failed");
		}
		
		Thread.sleep(5000);

	}
	
	@Test(priority=32)
	public void Gratuity_method_refreshGratuitiesPage(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[1]/i")).click();
		Thread.sleep(5000);
		//Check Check based discount page opened or not
		if(driver.findElement(By.xpath("//a[.='Gratuities']")).getText().equalsIgnoreCase("Gratuities"))
		{
			test.log(LogStatus.PASS, "Gratuities page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gratuities page refreshed Failed");
		}
		Thread.sleep(5000);

	}
	
	@Test(priority=34)
	public void Gratuity_method_addGratuities_Fixed(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		
		Thread.sleep(5000);
		//Click on the Add Gratuities option
		driver.findElement(By.id("newTip")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='New Gratuity']")).getText().equalsIgnoreCase("New Gratuity"))
		{
			test.log(LogStatus.PASS, "New Gratuity form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Gratuity form loaded Failed");
		}

		
		//Clear the Name field
		driver.findElement(By.name("name")).clear();
		//Enter the Name
		driver.findElement(By.name("name")).sendKeys(Utility.getProperty("GratuityName_Fixed"));
		Thread.sleep(2000);
		
		//Create the object for the Select Class
		Select applyTo = new Select(driver.findElement(By.name("type")));
		applyTo.selectByVisibleText("Fixed");
		
		//Clear the percentage field
		driver.findElement(By.name("percentage")).clear();
		//Enter the required percentage
		driver.findElement(By.name("percentage")).sendKeys("5");
		
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		//Check whether the new discount saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Gratuity saved successfully"))
		{
			test.log(LogStatus.PASS, "Gratuity saved Successfully for Fixed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gratuity saved Failed for Fixed");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=35)
	public void Gratuity_method_editGratuity(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("GratuityName_Fixed")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(4000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);

		//Clear the Name field
		driver.findElement(By.name("name")).clear();
		//Enter the Name
		driver.findElement(By.name("name")).sendKeys(Utility.getProperty("GratuityName_Fixed")+"1");
		Thread.sleep(2000);
		
		//Create the object for the Select Class
		Select applyTo = new Select(driver.findElement(By.name("type")));
		applyTo.selectByVisibleText("Varying");
		
		//Clear the minimum percentage field
		driver.findElement(By.name("minPercentage")).clear();
		//Enter the required minimum percentage
		driver.findElement(By.name("minPercentage")).sendKeys("5");
		//Clear the maximum percentage field
		driver.findElement(By.name("maxPercentage")).clear();
		//Enter the required maximum percentage
		driver.findElement(By.name("maxPercentage")).sendKeys("7");
		
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Gratuity updated successfully"))
		{
			test.log(LogStatus.PASS, "Gratuity is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gratuity is updated Failed");
		}

		Thread.sleep(5000);

	}
	
	@Test(priority=36)
	public void Gratuity_method_deleteGratuity(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(5000);
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("GratuityName_Fixed")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Delete button			
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		//Click the Yes button in the popup
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		//Check the menu item deleted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Gratuity inactivated successfully"))
		{
			test.log(LogStatus.PASS, "Gratuity is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gratuity is deleted Failed");
		}

		Thread.sleep(5000);	
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/input")).click();
		
		Thread.sleep(3000);
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		//Click the Yes button in the popup
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		//Check the field activated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("gratuity activated successfully"))
		{
			test.log(LogStatus.PASS, "Gratuity is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gratuity is activated Failed");
		}
		Thread.sleep(3000);
	}

	@Test(priority=37)
	public void Gratuity_method_closeButton(WebDriver driver) throws Exception
	{
		Thread.sleep(2000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
				
		Thread.sleep(5000);
		//Click on the Add Gratuity option
		driver.findElement(By.id("newTip")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='New Gratuity']")).getText().equalsIgnoreCase("New Gratuity"))
		{
			test.log(LogStatus.PASS, "New Gratuity form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Gratuity form loaded Failed");
		}

		
		//Clear the Name field
		driver.findElement(By.name("name")).clear();
		//Enter the Name
		driver.findElement(By.name("name")).sendKeys(Utility.getProperty("GratuityName_Fixed"));
		Thread.sleep(2000);
			
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		
		//Check whether the new discount canceled or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/div/h3")).getText().equalsIgnoreCase("Gratuities"))
		{
			test.log(LogStatus.PASS, "Gratuities Canceled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gratuities Canceled Failed");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=38)
	public void Gratuity_method_sameName(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click on the Add Gratuities option
		driver.findElement(By.id("newTip")).click();
		Thread.sleep(3000);

		//Clear the Name field
		driver.findElement(By.name("name")).clear();
		//Enter the Name
		driver.findElement(By.name("name")).sendKeys(Utility.getProperty("GratuityName_Fixed")+"1");
		Thread.sleep(2000);
		
		//Create the object for the Select Class
		Select applyTo = new Select(driver.findElement(By.name("type")));
		applyTo.selectByVisibleText("Varying");
		
		//Clear the minimum percentage field
		driver.findElement(By.name("minPercentage")).clear();
		//Enter the required minimum percentage
		driver.findElement(By.name("minPercentage")).sendKeys("5");
		//Clear the maximum percentage field
		driver.findElement(By.name("maxPercentage")).clear();
		//Enter the required maximum percentage
		driver.findElement(By.name("maxPercentage")).sendKeys("7");
		
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/form/div[1]/p[2]")).getText().equalsIgnoreCase("Name already exists"))
		{
			test.log(LogStatus.PASS, "Gratuity is updated failed and show the error message");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gratuity is updated successfully");
		}

		Thread.sleep(5000);

	}

	@Test(priority=41)
	public void Giftcard_method_openGiftCard(WebDriver driver) throws Exception
	{

		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"giftcard");
		Thread.sleep(5000);
		//Check Gift Cards page opened or not
		if(driver.findElement(By.xpath("//a[.='Gift Card']")).getText().equalsIgnoreCase("Gift Card"))
		{
			test.log(LogStatus.PASS, "Gift Card page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift Card page loaded Failed");
		}
		
		Thread.sleep(5000);

	}
	
	@Test(priority=42)
	public void Giftcard_method_refreshGiftCard(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a[1]/i")).click();
		Thread.sleep(5000);
		//Check Check based discount page opened or not
		if(driver.findElement(By.xpath("//a[.='Gift Card']")).getText().equalsIgnoreCase("Gift Card"))
		{
			test.log(LogStatus.PASS, "Gift Card page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift Card page refreshed Failed");
		}
		Thread.sleep(5000);

	}
	
	@Test(priority=44)
	public void Giftcard_method_addGiftCard(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		Thread.sleep(5000);
		//Click on the Add Gift Card option
		driver.findElement(By.id("newGiftCard")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='New Gift Card']")).getText().equalsIgnoreCase("New Gift Card"))
		{
			test.log(LogStatus.PASS, "New Gift Card form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Gift Card form loaded Failed");
		}

		
		//Clear the Name field
		driver.findElement(By.name("giftCardNumber")).clear();
		//Enter the Name
		driver.findElement(By.name("giftCardNumber")).sendKeys(Utility.getProperty("GiftCard_Number"));
		Thread.sleep(2000);
		
		//Clear the number field
		driver.findElement(By.name("currentBalance")).clear();
		//Enter the required balance
		driver.findElement(By.name("currentBalance")).sendKeys("600");
		
		
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3500);
		//Check whether the new discount saved or not
		if(driver.findElement(By.xpath("//span[.='Gift Card Saved Successfully']")).getText().equalsIgnoreCase("Gift Card Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Gift Card Saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift Card Saved failed");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=45)
	public void Giftcard_method_editGiftCard(WebDriver driver) throws Exception
	{
		Thread.sleep(6000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("GiftCard_Number")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(4000);
		//Clear the Name field
		driver.findElement(By.name("giftCardNumber")).clear();
		//Enter the Name
		driver.findElement(By.name("giftCardNumber")).sendKeys(Utility.getProperty("GiftCard_Number")+"1");


		Thread.sleep(3000);
		//Click the update
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.xpath("//span[.='Gift card updated successfully']")).getText().equalsIgnoreCase("Gift card updated successfully"))
		{
			test.log(LogStatus.PASS, "Gift card is updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift card is updated Failed");
		}

		Thread.sleep(5000);

	}
	
	@Test(priority=46)
	public void Giftcard_method_deleteGiftCard(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("GiftCard_Number")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		//Click the Yes button in the popup
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(5000);
		//Check the menu item deleted or not
		if(driver.findElement(By.xpath("//span[.='Gift card inactivated successfully']")).getText().equalsIgnoreCase("Gift card inactivated successfully"))
		{
			test.log(LogStatus.PASS, "Gift card deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift card deleted Failed");
		}

		Thread.sleep(7000);
		
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(7000);		
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3500);
		
		//Check the field activated or not
		if(driver.findElement(By.xpath("//span[.='Gift card activated successfully']")).getText().equalsIgnoreCase("Gift card activated successfully"))
		{
			test.log(LogStatus.PASS, "Gift card is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift card is activated Failed");
		}
		Thread.sleep(3000);	
		
	}

	@Test(priority=47)
	public void Giftcard_method_cancelButton(WebDriver driver) throws Exception
	{
     Thread.sleep(5000);
		
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		
		Thread.sleep(5000);
		//Click on the Add Gift Card option
		driver.findElement(By.id("newGiftCard")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//span[.='New Gift Card']")).getText().equalsIgnoreCase("New Gift Card"))
		{
			test.log(LogStatus.PASS, "New Gift Card form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Gift Card form loaded Failed");
		}

		
		//Clear the Name field
		driver.findElement(By.name("giftCardNumber")).clear();
		//Enter the Name
		driver.findElement(By.name("giftCardNumber")).sendKeys(Utility.getProperty("GiftCard_Number"));
		Thread.sleep(2000);
		
		//Click the close button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		Thread.sleep(2000);
		//Check whether the new discount saved or not
		if(driver.findElement(By.id("newGiftCard")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Gift Card canceled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift Card canceled failed");
		}

		Thread.sleep(5000);
	}
		
	@Test(priority=48)
	public void Giftcard_method_sameName(WebDriver driver) throws Exception
	{

		Thread.sleep(5000);
		//Click on the Add Gift Card option
		driver.findElement(By.id("newGiftCard")).click();
		Thread.sleep(3000);
		
		//Clear the Name field
		driver.findElement(By.name("giftCardNumber")).clear();
		//Enter the Name
		driver.findElement(By.name("giftCardNumber")).sendKeys(Utility.getProperty("GiftCard_Number")+"1");
		Thread.sleep(2000);
		
		//Clear the number field
		driver.findElement(By.name("currentBalance")).clear();
		//Enter the required balance
		driver.findElement(By.name("currentBalance")).sendKeys("600");
		
		Thread.sleep(3000);
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1500);
		
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.xpath("//span[.='Validation Error(s)']")).getText().equalsIgnoreCase("Validation Error(s)"))
		{
			test.log(LogStatus.PASS, "Gift card is updated failed and show the error message");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift Card is updated successfully");
		}

		Thread.sleep(5000);
	//Click the close button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=49)
	public void Giftcard_method_recharge(WebDriver driver) throws Exception
	{

		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("GiftCard_Number")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Recharge icon
		driver.findElement(By.cssSelector("i.fa.fa-money")).click();

		Thread.sleep(5000);
		//Clear the Recharge field
		driver.findElement(By.name("amount")).clear();
		Thread.sleep(5000);
		//Enter the recharge amount
		driver.findElement(By.name("amount")).sendKeys("5000");
		
		//Click the Save button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/form/div[3]/div/button")).click();
		Thread.sleep(3500);
		
		//Check whether the recharge successfully or not
		if(driver.findElement(By.xpath("//span[.='Gift card Amount credited successfully']")).getText().equalsIgnoreCase("Gift card Amount credited successfully"))
		{
			test.log(LogStatus.PASS, "Gift card is recharged successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift card is recharged failed");
		}

		Thread.sleep(5000);

	}

	@Test(priority=51)
	public void Cut_and_Modify_Method_openCutAndModify(WebDriver driver) throws Exception
	{

		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"cutAndModify");
		Thread.sleep(5000);
		//Check Gift Cards page opened or not
		if(driver.findElement(By.xpath("//a[.='Cut and modify']")).getText().equalsIgnoreCase("Cut and modify"))
		{
			test.log(LogStatus.PASS, "Cut and modify page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Cut and modify page loaded Failed");
		}
		
		Thread.sleep(5000);

	}
		
	@Test(priority=52)
	public void Cut_and_Modify_Method_editCutAndModify(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Edit button in the Cut and modify page
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/table/tbody/tr[1]/td[3]/span/a/i")).click();
		
		//Clear the percentage field
		driver.findElement(By.name("percentage")).clear();
		//Enter the required name
		driver.findElement(By.name("percentage")).sendKeys("51");
		
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		//Check whether the new discount saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Cut and modify saved successfully"))
		{
			test.log(LogStatus.PASS, "Cut and modify saved successfully for option 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Cut and modify saved successfully for option 1");
		}

		Thread.sleep(5000);
		
	}
	
	@Test(priority=53)
	public void Cut_and_Modify_Method_cancelButton(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the First Edit button in the Cut and modify page
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/table/tbody/tr[1]/td[3]/span/a/i")).click();
		
		//Click the Close button
		driver.findElement(By.xpath("//a[@class='btn btn-small btn-danger']")).click();
		Thread.sleep(2000);
		//Check whether the new discount saved or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/table/tbody/tr[1]/td[3]/span/a/i")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Cut and Modify canceled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Cut and Modify canceled failed");
		}

		Thread.sleep(5000);
	}

	@Test(priority=61)
	public void Tare_Group_method_openTareGroupPage(WebDriver driver) throws Exception
	{

		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"tare");
		Thread.sleep(5000);
		//Check Tare Group page opened or not
		if(driver.findElement(By.cssSelector("h3.ng-binding")).getText().equalsIgnoreCase("Tare Group"))
		{
			test.log(LogStatus.PASS, "Tare Group page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tare Group page loaded Failed");
		}
	}
	
	@Test(priority=62)
	public void Tare_Group_method_refreshTareGroupPage(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a/i")).click();
		Thread.sleep(5000);
		//Check Tare Group page opened or not
		if(driver.findElement(By.cssSelector("h3.ng-binding")).getText().equalsIgnoreCase("Tare Group"))
		{
			test.log(LogStatus.PASS, "Tare Group page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tare Group page loaded Failed");
		}
	}
	
	@Test(priority=64)
	public void Tare_Group_method_addTareGroup(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		Thread.sleep(3000);
		//Click the Add or new Tare Group button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/button")).click();
		Thread.sleep(2000);
		
		//Check whether the new Tare Group form loaded or not
		if(driver.findElement(By.xpath("//span[.='New TareGroup']")).getText().equalsIgnoreCase("New TareGroup"))
		{
			test.log(LogStatus.PASS, "New TareGroup form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New TareGroup form loaded Failed");
		}
		
		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("TareGroupNameWithWeight"));
		Thread.sleep(2000);
		
		//Enable the Default button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[2]/div/label/span")).click();
		
		//Click the Add Weight button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[3]/div/div[1]/a/i")).click();
		Thread.sleep(2000);
		
		//Enter the Seq.Number
		driver.findElement(By.name("sequenceNumber")).sendKeys("3");
		
		//Enter the name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[3]/div/div[3]/ng-form/div/div[2]/div/input")).sendKeys("Weight");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		//Click the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[3]/div/div[3]/ng-form/div/div[3]/div/a/span")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[3]/div/div[3]/ng-form/div/div[3]/div/div/div/input")).sendKeys("kg");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[3]/div/div[3]/ng-form/div/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Clear the amount field
		driver.findElement(By.name("quantity")).clear();
		//Enter the Required Amount
		driver.findElement(By.name("quantity")).sendKeys("20000");
		
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Check whether the new up charges form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Tare Saved Successfully"))
		{
			test.log(LogStatus.PASS, "New Tare Saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tare saved Failed");
		}
		
	
	}

	@Test(priority=65)
	public void Tare_Group_method_editTareGroup(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("TareGroupNameWithWeight")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);
		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[1]/div/input")).clear();
		Thread.sleep(5000);
		//Enter the required name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("TareGroupNameWithWeight")+"1");

		Thread.sleep(2000);
		//Click the Add weight symbol
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[3]/div/div[1]/a/i")).click();
		Thread.sleep(1000);
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[3]/div/div/ng-form/div/div[4]/div/a/i"));
		//Click the close button of new weight button
		int row = rows.size() + 2;
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[3]/div/div["+row+"]/ng-form/div/div[4]/div/a/i")).click();
		
		Thread.sleep(2000);
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(3000);
		//Click the update
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Tare Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Tare updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tare Updated Failed");
		}
		Thread.sleep(3000);

	}
	
	@Test(priority=66)
	public void Tare_Group_method_deleteTareGroup(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("TareGroupNameWithWeight")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		
		//Click the Yes button in the popup
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the menu item deleted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Tare group inactivated successfully"))
		{
			test.log(LogStatus.PASS, "Tare Group is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tare Group is deleted Failed");
		}
		Thread.sleep(7000);
	
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		
		//Click the Yes button in the popup
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(5000);
		
		//Check the item activated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Tare group activated successfully."))
		{
			test.log(LogStatus.PASS, "Tare group is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tare group is activated Failed");
		}
	
		Thread.sleep(5000);
	}
	
	@Test(priority=67)
	public void Tare_Group_method_cancelButton(WebDriver driver) throws Exception
	{
		Thread.sleep(6000);
		
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		
		
		//Click the Add or new Tare Group button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/button")).click();
		Thread.sleep(2000);
		//Check whether the new Tare Group form loaded or not
		if(driver.findElement(By.xpath("//span[.='New TareGroup']")).getText().equalsIgnoreCase("New TareGroup"))
		{
			test.log(LogStatus.PASS, "New TareGroup form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New TareGroup form loaded Failed");
		}
		
		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("TareGroupNameWithWeight")+"1");
		Thread.sleep(2000);

		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		Thread.sleep(2000);
		//Check whether the new discount canceled or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/button")).isDisplayed())
		{
			test.log(LogStatus.PASS, "TareGroup Canceled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "TareGroup Canceled Failed");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=68)
	public void Tare_Group_method_verifyActive_InActiveButton(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
	
		Thread.sleep(5000);
		//Click Active or In Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/input")).click();

		Thread.sleep(5000);
		//Check the New Display Group form is loaded or not
		if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Deleted groups are here, we are in InActive Page");
			Thread.sleep(10000);
			//Click Active or In Active Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/input")).click();

		}
		else if(driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Deleted groups are not here, we are in Active Page");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=69)
	public void Tare_Group_method_sameName(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Click the Add or new Tare Group button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/button")).click();
		Thread.sleep(5000);
		
		
		//Clear the name field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[1]/div/input")).clear();
		//Enter the required name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[1]/div/input")).sendKeys(Utility.getProperty("TareGroupNameWithWeight")+"1");
		Thread.sleep(2000);
		
		//Enable the Default button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[2]/div/label/span")).click();
		
		//Click the Add Weight button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[3]/div/div[1]/a/i")).click();
		Thread.sleep(2000);
		
		//Enter the Seq.Number
		driver.findElement(By.name("sequenceNumber")).sendKeys("3");
		
		//Enter the name
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[3]/div/div[3]/ng-form/div/div[2]/div/input")).sendKeys("Weight");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		//Click the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[3]/div/div[3]/ng-form/div/div[3]/div/a/span")).click();
		//Enter the required option
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[3]/div/div[3]/ng-form/div/div[3]/div/div/div/input")).sendKeys("kg");
		//Press the Enter Key
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/form/div[3]/div/div[3]/ng-form/div/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Clear the amount field
		driver.findElement(By.name("quantity")).clear();
		//Enter the Required Amount
		driver.findElement(By.name("quantity")).sendKeys("20000");
		
		//Click the Save button
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check whether the new up charges form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Validation Error(s)"))
		{
			test.log(LogStatus.PASS, "New Tare Saved Failed and show error message");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tare saved Successfully");
		}
		
	
	}

	@Test(priority=81)
	public void Reasons_TaxExempt_method_openTaxExemptReasons(WebDriver driver) throws Exception
	{
		/*//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Reasons']"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Reasons Option		
		driver.findElement(By.xpath("//span[.='Reasons']")).click();*/
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"reasons");
		Thread.sleep(5000);
		//Check items page opened or not
		if(driver.findElement(By.xpath("//a[.='Tax Exempt Reasons']")).getText().equalsIgnoreCase("Tax Exempt Reasons"))
		{
			test.log(LogStatus.PASS, "Tax Exempt Reasons page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Exempt Reasons page loaded Failed");
		}
		
		Thread.sleep(5000);

	}
	
	@Test(priority=82)
	public void Reasons_TaxExempt_method_refreshTaxExemptReasons(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a/i")).click();
		Thread.sleep(5000);
		//Check Check based discount page opened or not
		if(driver.findElement(By.xpath("//a[.='Tax Exempt Reasons']")).getText().equalsIgnoreCase("Tax Exempt Reasons"))
		{
			test.log(LogStatus.PASS, "Tax Exempt Reasons page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Exempt Reasons page refreshed Failed");
		}
		Thread.sleep(5000);

	}
	
	@Test(priority=84)
	public void Reasons_TaxExempt_method_addTaxExemptReasons(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		Thread.sleep(5000);
		//Click on the Add Tax Exempt Reasons option
		driver.findElement(By.id("newReason")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Tax Exempt Reason"))
		{
			test.log(LogStatus.PASS, "New Tax Exempt Reason form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax Exempt Reason form loaded Failed");
		}

		Thread.sleep(3000);
		
		//Clear the Reason field
		driver.findElement(By.name("reason")).clear();
		//Enter the Name
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("TaxExemptReason"));
		Thread.sleep(2000);
			
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		//Check whether the new discount saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Saved successfully"))
		{
			test.log(LogStatus.PASS, "New Tax Exepmt Reason Saved Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax Exempt Reason Save Failed");
		}

		Thread.sleep(5000);
	}
		
	@Test(priority=85)
	public void Reasons_TaxExempt_method_editTaxExemptReasons(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("TaxExemptReason")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(3000);
		//Clear the Reasons field
		driver.findElement(By.name("reason")).clear();
		//Enter the Reasons
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("TaxExemptReason")+"1");


		//Click the update
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Tax Exepmt Reason Updated Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax Exepmt Reason Updated failed");
		}

		Thread.sleep(5000);

	}
	
	@Test(priority=86)
	public void Reasons_TaxExempt_method_deleteTaxExemptReasons(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("TaxExemptReason")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		Thread.sleep(3000);
		//Click the Yes button in the popup
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		//Check the menu item deleted or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Inactivated successfully"))
		{
			test.log(LogStatus.PASS, "Tax Exepmt Reason is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Exepmt Reason is deleted Failed");
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
			test.log(LogStatus.PASS, "Tax Exepmt Reason is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Exepmt Reason is activated Failed");
		}
		
		Thread.sleep(5000);
	
	}

	@Test(priority=87)
	public void Reasons_TaxExempt_method_closeButton(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		
		
		Thread.sleep(5000);
		//Click on the Add Tax Exempt Reasons option
		driver.findElement(By.id("newReason")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Tax Exempt Reason"))
		{
			test.log(LogStatus.PASS, "New Tax Exempt Reason form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax Exempt Reason form loaded Failed");
		}

		Thread.sleep(3000);
		
		//Clear the Reason field
		driver.findElement(By.name("reason")).clear();
		//Enter the Name
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("TaxExemptReason"));
		Thread.sleep(2000); 
			
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		Thread.sleep(2000);
		//Check whether the new TaxExemptReason canceled or not
		if(driver.findElement(By.id("newReason")).isDisplayed())
		{
			test.log(LogStatus.PASS, "New Tax Exempt Reason Canceled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax Exempt Reason Canceled Failed");
		}

		Thread.sleep(5000);
	}
		
	@Test(priority=88)
	public void Reasons_TaxExempt_method_verifyActive_InActiveButton(WebDriver driver) throws Exception
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
	
	@Test(priority=101)
	public void Reasons_Void_Reasons_method_openVoidReasons(WebDriver driver) throws Exception
	{
		/*//Click the Products/Items option
		driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Reasons']"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Reasons Option		
		driver.findElement(By.xpath("//span[.='Reasons']")).click();
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
		}
		
		Thread.sleep(5000);
		
		*///Click the Void Reasons Tap
		driver.findElement(By.xpath("//span[.='Void Reason']")).click();
		Thread.sleep(3000);
		
		//Check Void Reasons page opened or not
		if(driver.findElement(By.xpath("//a[.='Void Reasons']")).getText().equalsIgnoreCase("Void Reasons"))
		{
			test.log(LogStatus.PASS, "Void Reasons page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Void Reasons page loaded Failed");
		}
		

	}
	
	@Test(priority=102)
	public void Reasons_Void_Reasons_method_refreshVoidReasons(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a/i")).click();
		Thread.sleep(5000);
		//Check Void Reasons page opened or not
		if(driver.findElement(By.xpath("//a[.='Void Reasons']")).getText().equalsIgnoreCase("Void Reasons"))
		{
			test.log(LogStatus.PASS, "Void Reasons page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Void Reasons page refreshed Failed");
		}
		Thread.sleep(5000);

	}
	
	@Test(priority=104)
	public void Reasons_Void_Reasons_method_addVoidReasons(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		Thread.sleep(5000);
		//Click on the Add Void Reasons option
		driver.findElement(By.id("newReason")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Void Reason"))
		{
			test.log(LogStatus.PASS, "New Void Reason form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Void Reason form loaded Failed");
		}

		Thread.sleep(3000);
		
		//Clear the Reason field
		driver.findElement(By.name("reason")).clear();
		//Enter the Name
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("VoidReason"));
		Thread.sleep(2000);
			
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3500);
		//Check whether the new discount saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Saved successfully"))
		{
			test.log(LogStatus.PASS, "New Void Reason Saved Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Void Reason Save Failed");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=105)
	public void Reasons_Void_Reasons_method_editVoidReasons(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("VoidReason")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(3000);
		//Clear the Reasons field
		driver.findElement(By.name("reason")).clear();
		//Enter the Reasons
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("VoidReason")+"1");


		//Click the update
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3500);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Void Reason Updated Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Void Reason Updated failed");
		}

		Thread.sleep(5000);

	}
	
	@Test(priority=106)
	public void Reasons_Void_Reasons_method_deleteVoidReasons(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("VoidReason")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		//Click the Yes button in the popup
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3500);
		//Check the menu item deleted or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Inactivated successfully"))
		{
			test.log(LogStatus.PASS, "Void Reason is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Void Reason is deleted Failed");
		}

		Thread.sleep(7000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		
		Thread.sleep(3000);
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		
		//Click the Yes button in the popup
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the menu item activated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Activated successfully"))
		{
			test.log(LogStatus.PASS, "Void Reason is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Void Reason is activated Failed");
		}
		
		Thread.sleep(5000);
	}

	@Test(priority=107)
	public void Reasons_Void_Reasons_method_closeButton(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		
		Thread.sleep(5000);
		//Click on the Add Tax Exempt Reasons option
		driver.findElement(By.id("newReason")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Void Reason"))
		{
			test.log(LogStatus.PASS, "New Void Reason form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Void Reason form loaded Failed");
		}

		Thread.sleep(3000);
		
		//Clear the Reason field
		driver.findElement(By.name("reason")).clear();
		//Enter the Name
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("VoidReason"));
		Thread.sleep(2000); 
			
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		Thread.sleep(3000);
		//Check whether the new TaxExemptReason canceled or not
		if(driver.findElement(By.id("newReason")).isDisplayed())
		{
			test.log(LogStatus.PASS, "New Void Reason Canceled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Void Reason Canceled Failed");
		}

		Thread.sleep(5000);
	}
		
	@Test(priority=108)
	public void Reasons_Void_Reasons_method_verifyActive_InActiveButton(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		
		Thread.sleep(5000);
		//Click Active or In Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();

		Thread.sleep(3500);
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

	@Test(priority=121)
	public void Reasons_PaidIn_method_openPaidInReasons(WebDriver driver) throws Exception
	{
		//Click the Products/Items option
		/*driver.findElement(By.xpath("//span[.='Products/Items']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[.='Reasons']"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Reasons Option		
		driver.findElement(By.xpath("//span[.='Reasons']")).click();
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
		}
		
		Thread.sleep(5000);
		*/
		//Click the PaidIn Reasons Tap
		driver.findElement(By.xpath("//span[.='Paid In']")).click();
		Thread.sleep(5000);
		
		//Check PaidIn Reasons page opened or not
		if(driver.findElement(By.xpath("//a[.='Paid Ins']")).getText().equalsIgnoreCase("Paid Ins"))
		{
			test.log(LogStatus.PASS, "Paid In Reasons page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Paid In Reasons page loaded Failed");
		}
		

	}
	
	@Test(priority=122)
	public void Reasons_PaidIn_method_refreshPaidInReasons(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a/i")).click();
		Thread.sleep(10000);
		//Check PaidIn Reasons page opened or not
		if(driver.findElement(By.xpath("//a[.='Paid Ins']")).getText().equalsIgnoreCase("Paid Ins"))
		{
			test.log(LogStatus.PASS, "Paid In Reasons page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Paid In Reasons page refreshed Failed");
		}
		Thread.sleep(5000);

	}
	
	@Test(priority=124)
	public void Reasons_PaidIn_method_addPaidInReasons(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(5000);
		//Click on the Add PaidIn Reasons option
		driver.findElement(By.id("newReason")).click();
		Thread.sleep(5000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Paid In"))
		{
			test.log(LogStatus.PASS, "New Paid In Reason form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Paid In Reason form loaded Failed");
		}

		Thread.sleep(3000);
		
		//Clear the Reason field
		driver.findElement(By.name("reason")).clear();
		//Enter the Name
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("PaidInReason"));
		Thread.sleep(2000);
			
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		//Check whether the new discount saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Saved successfully"))
		{
			test.log(LogStatus.PASS, "New PaidIn Reason Saved Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New PaidIn Reason Save Failed");
		}

		Thread.sleep(5000);
	}
	
	@Test(priority=125)
	public void Reasons_PaidIn_method_editPaidInReasons(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("PaidInReason")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(3000);
		//Clear the Reasons field
		driver.findElement(By.name("reason")).clear();
		//Enter the Reasons
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("PaidInReason")+"1");


		//Click the update
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Paid In Reason Updated Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Paid In Reason Updated failed");
		}

		Thread.sleep(5000);

	}
	
	@Test(priority=126)
	public void Reasons_PaidIn_method_deletePaidInReasons(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("PaidInReason")+"11");
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
			test.log(LogStatus.PASS, "Paid In Reason is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Paid In Reason is deleted Failed");
		}

		Thread.sleep(8000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the menu item activated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Activated successfully"))
		{
			test.log(LogStatus.PASS, "Paid In is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Paid In is activated Failed");
		}
		
		Thread.sleep(5000);
	}

	@Test(priority=127)
	public void Reasons_PaidIn_method_closeButton(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		
		Thread.sleep(5000);
		//Click on the Add Tax Exempt Reasons option
		driver.findElement(By.id("newReason")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Paid In"))
		{
			test.log(LogStatus.PASS, "New Paid In Reason form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Paid In Reason form loaded Failed");
		}

		Thread.sleep(3000);
		
		//Clear the Reason field
		driver.findElement(By.name("reason")).clear();
		//Enter the Name
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("PaidInReason"));
		Thread.sleep(2000); 
			
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		Thread.sleep(3000);
		//Check whether the new TaxExemptReason canceled or not
		if(driver.findElement(By.id("newReason")).isDisplayed())
		{
			test.log(LogStatus.PASS, "New Paid In Reason Canceled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Paid In Reason Canceled Failed");
		}

		Thread.sleep(5000);
	}
		
	@Test(priority=128)
	public void Reasons_PaidIn_method_verifyActive_InActiveButton(WebDriver driver) throws Exception
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

	@Test(priority=141)
	public void Reasons_PaidOut_method_openPaidOutReasons(WebDriver driver) throws Exception
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
	public void Reasons_PaidOut_method_refreshPaidOutReasons(WebDriver driver) throws InterruptedException
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
	public void Reasons_PaidOut_method_addPaidOutReasons(WebDriver driver) throws Exception
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
	public void Reasons_PaidOut_method_editPaidOutReasons(WebDriver driver) throws Exception
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
	public void Reasons_PaidOut_method_deletePaidOutReasons(WebDriver driver) throws Exception
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
	public void Reasons_PaidOut_method_closeButton(WebDriver driver) throws Exception
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
	public void Reasons_PaidOut_method_verifyActive_InActiveButton(WebDriver driver) throws Exception
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

	@Test(priority=161)
	public void Reasons_Overshortage_method_openOverShortageReasons(WebDriver driver) throws Exception
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
/*		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+("PAI_Reasons"));
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
		
		//Click the OverShortage Reasons Tap
		driver.findElement(By.xpath("//span[.='Over Shortage']")).click();
		Thread.sleep(3000);
		
		//Check OverShortage Reasons page opened or not
		if(driver.findElement(By.xpath("//a[.='Over Shortages']")).getText().equalsIgnoreCase("Over Shortages"))
		{
			test.log(LogStatus.PASS, "Over Shortage Reasons page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Over Shortage Reasons page loaded Failed");
		}
		

	}
	
	@Test(priority=162)
	public void Reasons_Overshortage_method_refreshOverShortageReasons(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a/i")).click();
		Thread.sleep(5000);
		//Check OverShortage Reasons page opened or not
		if(driver.findElement(By.xpath("//a[.='Over Shortages']")).getText().equalsIgnoreCase("Over Shortages"))
		{
			test.log(LogStatus.PASS, "Over Shortage Reasons page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Over Shortage Reasons page refreshed Failed");
		}
		Thread.sleep(5000);

	}
	
	@Test(priority=164)
	public void Reasons_Overshortage_method_addOverShortageReasons(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		Thread.sleep(5000);
		//Click on the Add OverShortage Reasons option
		driver.findElement(By.id("newReason")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Over Shortage"))
		{
			test.log(LogStatus.PASS, "New Over Shortage Reason form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Over Shortage Reason form loaded Failed");
		}

		Thread.sleep(3000);
		
		//Clear the Reason field
		driver.findElement(By.name("reason")).clear();
		//Enter the Name
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("OverShortageReason"));
		Thread.sleep(2000);
			
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		//Check whether the new discount saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Saved successfully"))
		{
			test.log(LogStatus.PASS, "New OverShortage Reason Saved Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New OverShortage Reason Save Failed");
		}

		Thread.sleep(5000);
	}
		
	@Test(priority=165)
	public void Reasons_Overshortage_method_editOverShortageReasons(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("OverShortageReason")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(3000);
		//Clear the Reasons field
		driver.findElement(By.name("reason")).clear();
		//Enter the Reasons
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("OverShortageReason")+"1");


		//Click the update
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Over Shortage Reason Updated Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Over Shortage Reason Updated failed");
		}

		Thread.sleep(5000);

	}
	
	@Test(priority=166)
	public void Reasons_Overshortage_method_deleteOverShortageReasons(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(5000);
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("OverShortageReason")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		//Click the Yes button in the popup
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		//Check the menu item deleted or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Inactivated successfully"))
		{
			test.log(LogStatus.PASS, "Over Shortage Reason is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Over Shortage Reason is deleted Failed");
		}
		Thread.sleep(7000);
		
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		//Click the Yes button in the popup
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the menu item activated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Activated successfully"))
		{
			test.log(LogStatus.PASS, "Over Shortage is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Over Shortage is activated Failed");
		}
		
		Thread.sleep(5000);
	}

	@Test(priority=167)
	public void Reasons_Overshortage_method_closeButton(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		
		
		//Click on the Add Tax Exempt Reasons option
		driver.findElement(By.id("newReason")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Over Shortage"))
		{
			test.log(LogStatus.PASS, "New Over Shortage Reason form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Over Shortage Reason form loaded Failed");
		}

		Thread.sleep(3000);
		
		//Clear the Reason field
		driver.findElement(By.name("reason")).clear();
		//Enter the Name
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("OverShortageReason"));
		Thread.sleep(2000); 
			
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		Thread.sleep(3000);
		//Check whether the new TaxExemptReason canceled or not
		if(driver.findElement(By.id("newReason")).isDisplayed())
		{
			test.log(LogStatus.PASS, "New Over Shortage Reason Canceled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Over Shortage Reason Canceled Failed");
		}

		Thread.sleep(5000);
	}
		
	@Test(priority=168)
	public void Reasons_Overshortage_method_verifyActive_InActiveButton(WebDriver driver) throws Exception
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

	@Test(priority=181)
	public void Reason_Attach_Request_openAttachRequestReasons(WebDriver driver) throws Exception
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
/*		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+("PAI_Reasons"));
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
		
		//Click the AttachRequest Reasons Tap
		driver.findElement(By.xpath("//span[.='Attach Request']")).click();
		Thread.sleep(3000);
		
		//Check AttachRequest Reasons page opened or not
		if(driver.findElement(By.xpath("//a[.='Attach Requests']")).getText().equalsIgnoreCase("Attach Requests"))
		{
			test.log(LogStatus.PASS, "Attach Request Reasons page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Attach Request Reasons page loaded Failed");
		}
		

	}
	
	@Test(priority=182)
	public void Reason_Attach_Request_refreshAttachRequestReasons(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/a/i")).click();
		Thread.sleep(5000);
		//Check AttachRequest Reasons page opened or not
		if(driver.findElement(By.xpath("//a[.='Attach Requests']")).getText().equalsIgnoreCase("Attach Requests"))
		{
			test.log(LogStatus.PASS, "Attach Request Reasons page refreshed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Attach Request Reasons page refreshed Failed");
		}
		Thread.sleep(5000);

	}
	
	@Test(priority=184)
	public void Reason_Attach_Request_addAttachRequestReasons(WebDriver driver) throws Exception
	{
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		Thread.sleep(5000);
		//Click on the Add AttachRequest Reasons option
		driver.findElement(By.id("newReason")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Attach Request"))
		{
			test.log(LogStatus.PASS, "New Attach Request Reason form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Attach Request Reason form loaded Failed");
		}

		Thread.sleep(3000);
		
		//Clear the Reason field
		driver.findElement(By.name("reason")).clear();
		//Enter the Name
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("AttachRequestReason"));
		Thread.sleep(2000);
			
		//Click the Save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		//Check whether the new discount saved or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Saved successfully"))
		{
			test.log(LogStatus.PASS, "New AttachRequest Reason Saved Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New AttachRequest Reason Save Failed");
		}

		Thread.sleep(5000);
	}
		
	@Test(priority=185)
	public void Reason_Attach_Request_editAttachRequestReasons(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(5000);
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("AttachRequestReason")+"1");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Edit icon
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		
		Thread.sleep(3000);
		//Clear the Reasons field
		driver.findElement(By.name("reason")).clear();
		
		//Enter the Reasons
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("AttachRequestReason")+"1");


		//Click the update
		driver.findElement(By.cssSelector("button.btn.btn-small.btn-success")).click();
		
		Thread.sleep(3000);
		//Check whether the Product Item updated successfully or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Attach Request Reason Updated Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Attach Request Reason Updated failed");
		}

		Thread.sleep(5000);

	}
	
	@Test(priority=186)
	public void Reason_Attach_Request_deleteAttachRequestReasons(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Clear the search field
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("AttachRequestReason")+"11");
		Thread.sleep(2000);driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		//Click the Delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		//Click the Yes button in the popup
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		//Check the menu item deleted or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Inactivated successfully"))
		{
			test.log(LogStatus.PASS, "Attach Request Reason is deleted Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Attach Request Reason is deleted Failed");
		}

		Thread.sleep(7000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);		
		//Click the success button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(1000);
		
		//Click the Yes button in the popup
		Thread.sleep(1500);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		
		//Check the menu item activated or not
		if(driver.findElement(By.cssSelector("span > span.ng-scope")).getText().equalsIgnoreCase("Activated successfully"))
		{
			test.log(LogStatus.PASS, "Attach Request is activated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Attach Request is activated Failed");
		}
		
		Thread.sleep(5000);
	}

	@Test(priority=187)
	public void Reason_Attach_Request_closeButton(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		//Click the Active Button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		//Click on the Add Tax Exempt Reasons option
		driver.findElement(By.id("newReason")).click();
		Thread.sleep(3000);
		//Check whether the new form loaded or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[1]/h3/span")).getText().equalsIgnoreCase("New Attach Request"))
		{
			test.log(LogStatus.PASS, "New Attach Request Reason form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Attach Request Reason form loaded Failed");
		}

		Thread.sleep(3000);
		
		//Clear the Reason field
		driver.findElement(By.name("reason")).clear();
		//Enter the Name
		driver.findElement(By.name("reason")).sendKeys(Utility.getProperty("AttachRequestReason"));
		Thread.sleep(2000); 
			
		//Click the Cancel button
		driver.findElement(By.xpath("//a[.='Close']")).click();
		Thread.sleep(3000);
		//Check whether the new TaxExemptReason canceled or not
		if(driver.findElement(By.id("newReason")).isDisplayed())
		{
			test.log(LogStatus.PASS, "New Attach Request Reason Canceled Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Attach Request Reason Canceled Failed");
		}

		Thread.sleep(5000);
	}
		
	@Test(priority=188)
	public void Reason_Attach_Request_verifyActive_InActiveButton(WebDriver driver) throws Exception
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
