package epicList;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor; 
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import epicList_Integrated.Utility;

public class AddEditDelete_Gratuity {
	
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete_Gratuity");

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
	
	@Test(priority=31)
	public void Gratuity_method_GratuitiesPage() throws Exception
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
	public void Gratuity_method_refreshGratuitiesPage() throws InterruptedException
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
	public void Gratuity_method_addGratuities_Fixed() throws Exception
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
	public void Gratuity_method_editGratuity() throws Exception
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
	public void Gratuity_method_deleteGratuity() throws Exception
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
	public void Gratuity_method_closeButton() throws Exception
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
	public void Gratuity_method_sameName() throws Exception
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

}
