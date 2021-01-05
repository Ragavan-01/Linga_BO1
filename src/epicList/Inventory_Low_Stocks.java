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

public class Inventory_Low_Stocks {
	
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory_Low_Stocks");

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
	public void open_Inventory_Low_stock() throws Exception
	{
		//Click the Inventory option
		driver.findElement(By.xpath("//span[.='Inventory']")).click();
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//span[contains(.,'Low Stocks')]"));
		//Scroll the page till the Inventory Menu Items option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
        //Click the Purchases Option		
		driver.findElement(By.xpath("//span[contains(.,'Low Stocks')]")).click();
		Thread.sleep(5000);

		
		//Check Low stock management page opened or not
		if(driver.findElement(By.xpath("//a[.='Low stock management']")).getText().equalsIgnoreCase("Low stock management"))
		{
			test.log(LogStatus.PASS, "Low stock management page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Low stock management page loaded Failed");
		}
		
		Thread.sleep(5000);
	}
	
	@Test(priority=3)
	public void Create_Purchase_Order_In_Low_Stocks() throws Exception
	{
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//div[@id='createPurchaseOrder']"));
		//Scroll the page till the Inventory Menu Items option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
		Thread.sleep(5000);
		//Check whether the Create Purchase Order Available
		if(driver.findElement(By.xpath("//div[@id='createPurchaseOrder']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Create Purchase Order is available in Low Stocks");
			List<WebElement> purchaseOrder = driver.findElements(By.xpath("//div[@id='createPurchaseOrder']"));
			purchaseOrder.size();
			
			System.out.println("Count :"+purchaseOrder.size());
			
			// Create instance of Java script executor
			JavascriptExecutor je2 = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element2 = driver.findElement(By.xpath("//div[@id='createPurchaseOrder']"));
			//Scroll the page till the Inventory Menu Items option present
			je2.executeScript("arguments[0].scrollIntoView(true);",element2); 
	        //Click the createPurchaseOrder Option		
			driver.findElement(By.xpath("//div[@id='createPurchaseOrder']")).click();
			Thread.sleep(8000);
			
			//Click the Calendar icon
			driver.findElement(By.xpath("//span[@class='input-group-btn']")).click();
			//Enter the Current Date
			driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm active']")).click();
			
			Thread.sleep(5000);
			//Select the required placed order via option
			Select placeOrederVia = new Select(driver.findElement(By.name("placedVia")));
			placeOrederVia.selectByVisibleText("Email");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(5000);
			//Click the Place Order Option
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			
			Thread.sleep(2500);
			//Check whether the order is placed or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Purchase order saved successfully!."))
			{
				test.log(LogStatus.PASS, "Purchase order saved Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Purchase order saved Failed");
			}
			Thread.sleep(5000);
			
			Thread.sleep(1500);
			//Click the Receiving Order Option
			driver.findElement(By.cssSelector("i.fa.fa-recycle")).click();
			
			Thread.sleep(4000);
			//Click the Submit button
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-success']")).click();
			
			Thread.sleep(2500);
			//Check whether the Receive information updated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Receive information updated."))
			{
				test.log(LogStatus.PASS, "Receive information updated Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Receive information updated Failed");
			}
			Thread.sleep(5000);
			
			// Create instance of Java script executor
			JavascriptExecutor je1 = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element1 = driver.findElement(By.xpath("//span[contains(.,'Low Stocks')]"));
			//Scroll the page till the Inventory Menu Items option present
			je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
	        //Click the Purchases Option		
			driver.findElement(By.xpath("//span[contains(.,'Low Stocks')]")).click();
			Thread.sleep(5000);
		}
		else
		{
			test.log(LogStatus.FAIL, "There is no Low Stocks Available for Purchase Order");
		}
	}

	@Test(priority=4)
	public void prepare_SubRecipe_In_Low_Stocks() throws Exception
	{
		Thread.sleep(5000);
		// Create instance of Java script executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//div[@id='prepareSubRecipe']"));
		//Scroll the page till the Inventory Menu Items option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
		//Check whether the prepareSubRecipe Order Available
		if(driver.findElement(By.xpath("//div[@id='prepareSubRecipe']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Prepare Subrecipe is available in Low Stocks");
			List<WebElement> prepareSubRecipe = driver.findElements(By.xpath("//div[@id='prepareSubRecipe']"));
			prepareSubRecipe.size();
			
			// Create instance of Java script executor
			JavascriptExecutor je2 = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element2 = driver.findElement(By.xpath("//div[@id='prepareSubRecipe']"));
			//Scroll the page till the Inventory Menu Items option present
			je2.executeScript("arguments[0].scrollIntoView(true);",element2);
	        //Click the prepareSubRecipe Option		
			driver.findElement(By.xpath("//div[@id='prepareSubRecipe']")).click();
			Thread.sleep(8000);
			
			
			Thread.sleep(2000);
			//Clear the quantity option
			driver.findElement(By.name("quantity")).clear();
			Thread.sleep(2000);
			//Enter the quantity option
		    driver.findElement(By.name("quantity")).sendKeys("1");
		    
		    Thread.sleep(5000);
			driver.findElement(By.xpath("//span[.='Save and Continue']")).click();
			
			Thread.sleep(5000);
			//Check Receive Inventory saved or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sub recipe prepared successfully"))
			{
				test.log(LogStatus.PASS, "Sub recipe prepared successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Sub recipe prepared Failed");
			}
			Thread.sleep(5000);
			
			// Create instance of Java script executor
			JavascriptExecutor je1 = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element1 = driver.findElement(By.xpath("//span[contains(.,'Low Stocks')]"));
			//Scroll the page till the Inventory Menu Items option present
			je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
	        //Click the Purchases Option		
			driver.findElement(By.xpath("//span[contains(.,'Low Stocks')]")).click();
			Thread.sleep(5000);	
			
		}
		else
		{
			test.log(LogStatus.FAIL, "There is no Low Stocks Available for Prepare Subrecipe");
		}
	}
}
