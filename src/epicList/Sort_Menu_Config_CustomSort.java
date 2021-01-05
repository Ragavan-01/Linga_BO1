package epicList;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import epicList_Integrated.Utility;

public class Sort_Menu_Config_CustomSort {
	
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Sort_Menu_Config_CustomSort");

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

	@Test(priority=21)
	public void Sort_Menu_Config_Customsort_method_openSortMenuConfig() throws Exception
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
	public void Sort_Menu_Config_Customsort_method_sortByCustomSort() throws Exception
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
	public void Sort_Menu_Config_Customsort_method_sortByCustomSort_Subctegory() throws Exception
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
	public void Sort_Menu_Config_Customsort_method_sortByCustomSort_MenuItem() throws Exception
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
}
