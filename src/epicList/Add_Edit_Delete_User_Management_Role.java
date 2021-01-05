package epicList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import epicList_Integrated.ExtentManager;
import epicList_Integrated.Utility;

public class Add_Edit_Delete_User_Management_Role {
	public WebDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Add_Edit_Delete_User_Management_Role");
	
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
		
		//SendMail.snedMailWithAttachment();
		//SendMail.sendMailWithAttachment_Passed_And_Failed_Test_Methods();
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
	}}
		
	@Test(priority=2)
	public void Usermanagement_Role_Pageopen() throws Exception
	{
				Thread.sleep(15000);
/*				//Click the User Management option
				driver.findElement(By.xpath("//span[.='User Management']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Roles']"));Thread.sleep(3000);
				//Scroll the page till the Sale option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
				
		        //Click the Roles Option		
				driver.findElement(By.xpath("//span[.='Roles']")).click();*/
				Thread.sleep(4000);
				//Enter the Punchin-out URL
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"roles");

				Thread.sleep(5000);
				//Check  Roles page opened or not
				if(driver.findElement(By.xpath("//a[.='Roles']")).getText().equalsIgnoreCase("Roles"))
				{
					test.log(LogStatus.PASS,"Roles page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"Roles page loaded Failed");
				}
				Thread.sleep(3000);

			}
	
	@Test(priority=12, enabled=false)
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
			
	@Test(priority=3)
	public void Usermanagement_Role_refreshPage() throws InterruptedException
		{
			Thread.sleep(2000);
			WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			
		Thread.sleep(3000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a/i")).click();
		Thread.sleep(3000);
		//Check  Roles page opened or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Role"))
		{
			test.log(LogStatus.PASS,"Roles page refresh loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"Roles page refresh loaded Failed");
		}
		Thread.sleep(3000);
	}

	@Test(priority=5)
	public void Usermanagement_Role_addingpage() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(6000);
		//Click the Add Roles or Create new Role button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/button")).click();
		Thread.sleep(3000);
		//Check  New Role form page loaded or not
		if(driver.findElement(By.xpath("//span[.='New Role']")).getText().equalsIgnoreCase("New Role"))
		{
			test.log(LogStatus.PASS,"New Roles form loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"New Roles form loaded Failed");
		}
		Thread.sleep(3000);
		
		//Clear the name field
		driver.findElement(By.name("name")).clear();
		//Enter the required name
		driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Roles_name"));
		
		Thread.sleep(1000);
		//Click the Priority Field
		driver.findElement(By.xpath("//b[.='Priority']/../../div/div/a")).click();
		//Enter the Required priority
		driver.findElement(By.xpath("//b[.='Priority']/../../div/div/div/div/input")).sendKeys("3");
		//Press the Enter Key
		driver.findElement(By.xpath("//b[.='Priority']/../../div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		//Click the Back Office link
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//a[.='BACK OFFICE']"));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='BACK OFFICE']")).click();
		
		List<WebElement> bockOfficeCount = driver.findElements(By.xpath("//a[.='BACK OFFICE']/../../../../../div[2]/div/div"));
		bockOfficeCount.size();
		
		for(int i = 2; i <= bockOfficeCount.size(); i++)
		{
			//Click the required Check box
			driver.findElement(By.xpath("//a[.='BACK OFFICE']/../../../../../div[2]/div/div["+i+"]/input")).click();
		}
				
		//Click the POS link
		JavascriptExecutor je1 = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element1 = driver.findElement(By.xpath("//a[.='POS']"));
		//Scroll the page till the Reason option present
		je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='POS']")).click();
		Thread.sleep(2000);
		List<WebElement> posCount = driver.findElements(By.xpath("//a[.='POS']/../../../../../div[2]/div/div"));
		posCount.size();
		
		for(int i = 10; i <= posCount.size(); i++)
		{
			//Click the required Check box
			driver.findElement(By.xpath("//a[.='POS']/../../../../../div[2]/div/div["+i+"]/input")).click();
		}
		
		
		//Click the POS OPERATIONS link
		JavascriptExecutor je2 = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element2 = driver.findElement(By.xpath("//a[.='POS OPERATIONS']"));
		//Scroll the page till the Reason option present
		je2.executeScript("arguments[0].scrollIntoView(true);",element2); 
		
		Thread.sleep(2000);
		//Click the POS Operations link
		driver.findElement(By.xpath("//a[.='POS OPERATIONS']")).click();
		
		List<WebElement> posOperationsCount = driver.findElements(By.xpath("//a[.='POS OPERATIONS']/../../../../../div[2]/div/div"));
		posOperationsCount.size();
		//Scroll the web page
	    for(int i=1; i <= 20; i++)
	    {
	    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
	    }
	    Thread.sleep(3000);
		for(int i = 3; i <= posOperationsCount.size(); i++)
		{
			driver.findElement(By.xpath("//a[.='POS OPERATIONS']/../../../../../div[2]/div/div["+i+"]/input")).click();
		}
		
		//Click the REPORT ACCESS link
		JavascriptExecutor je3 = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element3 = driver.findElement(By.xpath("//a[.='REPORT ACCESS']"));
		//Scroll the page till the Reason option present
		je3.executeScript("arguments[0].scrollIntoView(true);",element3); 
		Thread.sleep(2000);
		//Click the REPORT ACCESS link
		driver.findElement(By.xpath("//a[.='REPORT ACCESS']")).click();
		
		List<WebElement> reportAccessCount = driver.findElements(By.xpath("//a[.='REPORT ACCESS']/../../../../../div[2]/div/div")); 
		
		//Scroll the web page
	    for(int i=1; i <= 20; i++)
	    {
	    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
	    }
	    Thread.sleep(3000);
		for(int i = 3; i <= reportAccessCount.size(); i++)
		{
			//Click the required Check box
			driver.findElement(By.xpath("//a[.='REPORT ACCESS']/../../../../../div[2]/div/div["+i+"]/input")).click();
		}
		
		//Click the DASH BOARD link
		JavascriptExecutor je4 = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element4 = driver.findElement(By.xpath("//a[.='DASH BOARD']"));
		//Scroll the page till the Reason option present
		je4.executeScript("arguments[0].scrollIntoView(true);",element4); 
		Thread.sleep(2000);
		
		//Click the DASH BOARD link
		driver.findElement(By.xpath("//a[.='DASH BOARD']")).click();
		
		List<WebElement> dashBoardCount = driver.findElements(By.xpath("//a[.='DASH BOARD']/../../../../../div[2]/div/div"));
		//Scroll the web page
	    for(int i=1; i <= 20; i++)
	    {
	    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
	    }
	    Thread.sleep(3000);
		for(int i = 3; i <= dashBoardCount.size(); i++)
		{
			//Click the required Check box
			driver.findElement(By.xpath("//a[.='DASH BOARD']/../../../../../div[2]/div/div["+i+"]/input")).click();
		}
		Thread.sleep(3000);
		
		//Scroll the web page
	    for(int i=1; i <= 20; i++)
	    {
	    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);Thread.sleep(2000);
	    	Thread.sleep(1000);
	    }

		//Click the DASH BOARD link
		driver.findElement(By.xpath("//a[.='DASH BOARD']")).click();
		
		
		Thread.sleep(3000);
		//Click the Item Access ALl button
		driver.findElement(By.xpath("//form[@name='roleForm']/div/div/div[1]/span/../input")).click();
		
		//Click the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		//Check weather the new role saved successfully or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Role saved successfully"))
		{
			test.log(LogStatus.PASS,"New Role Saved Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"New Role Save Failed");
		}
	

	}

	@Test(priority=6)
	public void Usermanagement_Role_RevertRoles() throws Exception
	{
		
		Thread.sleep(2000);
		//Clear the search field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys("Cook");
		//Click the edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();Thread.sleep(2000);
		Thread.sleep(3000);
		//Click the Back Office link
		driver.findElement(By.xpath("//a[.='BACK OFFICE']")).click();
		//Click the Create Menu
		driver.findElement(By.xpath("(//input[@name=''] )[2]")).click();
		//Click the Back Office link
		driver.findElement(By.xpath("//a[.='BACK OFFICE']")).click();
		Thread.sleep(3000);
		//Click the save or update button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		//Clear the search box
		driver.findElement(By.cssSelector("label.ng-binding > input.ng-pristine.ng-valid")).clear();
		//Enter the required keyword in search box
		driver.findElement(By.cssSelector("label.ng-binding > input.ng-pristine.ng-valid")).sendKeys("Cook");
		Thread.sleep(5000);
		//Click Revert Option
		driver.findElement(By.cssSelector("i.fa.fa-link")).click();
		
		//Click the yes button on popup
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		
		      Thread.sleep(5000);
		       //Check weather the role reverted or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Privileges reverted successfully"))
				{
					test.log(LogStatus.PASS,"Privileges reverted successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"Privileges reverted Failed");
				}
				
			}
	
	@Test(priority=7)
	public void Usermanagement_Role_CheckRevertedRoles() throws Exception
	{
		Thread.sleep(2000);
		//Clear the search field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys("Cook");
		//Click the edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();Thread.sleep(2000);
		Thread.sleep(4000);
		//Click cancel Button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		
		Thread.sleep(2000);
		//Clear the search field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys("Cook");
		//Click the edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();Thread.sleep(2000);
		//Click the Back Office link
		driver.findElement(By.xpath("//a[.='BACK OFFICE']")).click();
		//Click the Edit Menu Price
		driver.findElement(By.xpath("(//input[@name=''] )[4]")).click();
		Thread.sleep(3000);
		//Click the Back Office link
		driver.findElement(By.xpath("//a[.='BACK OFFICE']")).click();
		//Click the save or update button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		//Check weather the new role was updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Role updated successfully"))
		{
			test.log(LogStatus.PASS,"Reverted Role Updated Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"Reverted Role Update Failed");
		}
		//Clear the search box
		driver.findElement(By.cssSelector("label.ng-binding > input.ng-pristine.ng-valid")).clear();
	}
	
	@Test(priority=8)
	public void Usermanagement_Role_editRoles() throws Exception
	{
		Thread.sleep(2000);
		//Clear the search field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Roles_name"));
		//Click the edit button
		Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();Thread.sleep(2000);
		//Clear the name field
		driver.findElement(By.name("name")).clear();
		//Enter the required name
		driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Roles_name")+"1");

		Thread.sleep(2000);
		//Click the Back Office link
		driver.findElement(By.xpath("//a[.='BACK OFFICE']")).click();
		//Click the Gratutity
		driver.findElement(By.xpath("(//input[@name=''] )[7]")).click();
		//Click the Gift Card
		driver.findElement(By.xpath("(//input[@name=''] )[8]")).click();
		//Click the Back Office link
		driver.findElement(By.xpath("//a[.='BACK OFFICE']")).click();
		
		/*List<WebElement> bockOfficeCount = driver.findElements(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[1]/div[2]/div/div"));
		bockOfficeCount.size();
		
		for(int i = 2; i <= bockOfficeCount.size(); i=i+3)
		{
			//Click the required Check box
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[1]/div[2]/div/div["+i+"]/input")).click();
		}*/
		
		Thread.sleep(2000);
		//Click the POS link
		driver.findElement(By.xpath("//a[.='POS']")).click();
		//Click the GC PAYMENT
		driver.findElement(By.xpath("(//input[@name=''] )[25]")).click();
		//Click the Tax Exempt
		driver.findElement(By.xpath("(//input[@name=''] )[30]")).click();
		//Click the POS link
		driver.findElement(By.xpath("//a[.='POS']")).click();
		/*
		List<WebElement> posCount = driver.findElements(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[2]/div[2]/div/div"));
		posCount.size();
		
		for(int i = 2; i <= posCount.size(); i=i+3)
		{
			//Click the required Check box
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[2]/div[2]/div/div["+i+"]/input")).click();
		}*/
		
		
		//Click the POS Operations link
		driver.findElement(By.xpath("//a[.='POS OPERATIONS']")).click();
		//Click the hold Till
		driver.findElement(By.xpath("//span[contains(.,'HOLD TILL')]/../input")).click();
		//Click the Cash Drop
		driver.findElement(By.xpath("//span[contains(.,'CASH DROP')]/../input")).click();
		
		//Click the POS Operations link
		driver.findElement(By.xpath("//a[.='POS OPERATIONS']")).click();
/*
		List<WebElement> posOperationsCount = driver.findElements(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[3]/div[2]/div/div"));
		posOperationsCount.size();
		
		for(int i = 2; i <= posOperationsCount.size(); i=i+3)
		{
			//Click the required Check box
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[3]/div[2]/div/div["+i+"]/input")).click();
		}
				
		*/
		//Click the save or update button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		//Check weather the new role was updated or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Role updated successfully"))
		{
			test.log(LogStatus.PASS,"Role Updated Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"Role Update Failed");
		}
	}
	
	@Test(priority=9)
	public void Usermanagement_Role_Activestatus () throws Exception
	{
		
    Thread.sleep(2000);
	/*//Check active Roles
    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[1]/input")).click();*/
    Thread.sleep(3000);
	//Clear the search field
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
    //Enter the required keyword
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Roles_name")+"1");
     Thread.sleep(3000);
   //Clear the search field
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
	
	Thread.sleep(3000);
	}
	
	@Test(priority=10)
	public void Usermanagement_Role_deleteRoles() throws Exception
	{
		//Clear the search field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Roles_name")+"1");
		Thread.sleep(2000);
		//Click on the delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		Thread.sleep(3000);
		//Click the yes button on popup
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
		Thread.sleep(3000);
		//Check weather the role deleted or not
		if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Role inactivated successfully"))
		{
			test.log(LogStatus.PASS,"Role deleted Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"Role deleted Failed");
		}
	}

	@Test(priority=11)
	public void Usermanagement_Role_DeActivestatus () throws Exception
	{
	Thread.sleep(2000);
	//Check Deactivate Roles
    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[1]/input")).click();
    Thread.sleep(3000);   		
	//Clear the search field
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
	//Enter the required keyword
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Roles_name")+"1");
	Thread.sleep(2000);
	//Click the activate button
	driver.findElement(By.cssSelector("i.fa.fa-check")).click();
	Thread.sleep(2000);
	//Click the Yes button in the popup
	Thread.sleep(5000);
	driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();  
    Thread.sleep(3000);
	//Check if we Deactivate or not
	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("role activated successfully"))
	{
		test.log(LogStatus.PASS,"role activated successfully successfully");
	}
	else
	{
		test.log(LogStatus.FAIL,"role activated successfully is Failed");
	}
	
	Thread.sleep(5000);
	watchTutorial();
	Thread.sleep(5000);
	}

}
