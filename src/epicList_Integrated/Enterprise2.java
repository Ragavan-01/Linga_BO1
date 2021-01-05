package epicList_Integrated;

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


public class Enterprise2 {
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete_Enterprise_AccountUsers");

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
		public void Account_User_openpage(WebDriver driver) throws Exception
		{
			Thread.sleep(15000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			//Click the My Stores option
			driver.findElement(By.xpath("//span[.='My Stores']")).click();
	
			Thread.sleep(3000);
	        //Click the EnterPrise Reports Option		
			driver.findElement(By.xpath("//span[.='EnterPrise Reports']")).click();
			
			Thread.sleep(2000);
			//Click the Sale option
			driver.findElement(By.xpath("//span[.='Account Users']")).click();
			
			Thread.sleep(5000);
			//Check Department Report page opened or not
			if(driver.findElement(By.xpath("//a[.='Account Users']")).getText().equalsIgnoreCase("Account Users"))
			{
				test.log(LogStatus.PASS, "Account Users page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Account Users page loaded Failed");
			}
			
			Thread.sleep(3000);
			
		}
		
		@Test(priority=3)
		public void Account_User_pagination(WebDriver driver) throws InterruptedException
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
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div/ul[1]/li[2]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 10");
			//Create the web element for Account Users Table
			List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/table"));
			for (WebElement result : results){						
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available");
			}
			Thread.sleep(8000);
			
			//Click the Pagination option as 15
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div/ul[1]/li[3]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 15");
			//Create the web element for Account Users Table
			List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/table"));
			for (WebElement result : results1){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available");
			}
			Thread.sleep(8000);
			
			//Click the Pagination option as 20
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div/ul[1]/li[4]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 20");
			//Create the web element for Account Users Table
			List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/table"));
			for (WebElement result : results2){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available");
			}
			Thread.sleep(8000);
			
			//Click the Pagination option as 5
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div/ul[1]/li[1]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 5");
			//Create the web element for Account Users Table
			List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/table"));
			for (WebElement result : results3){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available");
			}
			Thread.sleep(8000);
		}
		
		@Test(priority=4)
		public void Account_User_add(WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(1000);
			//Click the Add Account Users Button
			driver.findElement(By.id("createUser")).click();
			
			Thread.sleep(1000);
			//Check whether the New Account User form loaded or not
			if(driver.findElement(By.xpath("//span[.='NEW ACCOUNT USER']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "New Account User form loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Account User form loaded fail");
			}
			Thread.sleep(2000);
			
			//Clear the First name field
			driver.findElement(By.name("firstName")).clear();
			//Enter the First Name
			driver.findElement(By.name("firstName")).sendKeys(Utility.getProperty("Enterprise_Account_User_First_Name"));
			
			Thread.sleep(1000);
			//Clear the Last field
			driver.findElement(By.name("lastName")).clear();
			//Enter the Last Name
			driver.findElement(By.name("lastName")).sendKeys("LName");
			
			Thread.sleep(1000);
			//Enable or Select the Gender as Male
			if(driver.findElement(By.xpath("//input[@value='Male']")).isSelected())
			{
				
			}
			else
			{
				Thread.sleep(1000);
				//Click or select the male radio button
				driver.findElement(By.xpath("//input[@value='Male']")).click();
			}
			
			Thread.sleep(1000);
			//Clear the Date of birth field
			driver.findElement(By.name("dateOfBirth")).clear();
			//Enter the Date of birth
			driver.findElement(By.name("dateOfBirth")).sendKeys("04-Nov-1993");
			
			Thread.sleep(1000);
			//Clear the phone number field
			driver.findElement(By.name("phoneNumber")).clear();
			//Enter the phone number
			driver.findElement(By.name("phoneNumber")).sendKeys("5484958624");
			
			Thread.sleep(1000);
			//Clear the email id field
			driver.findElement(By.name("emailId")).clear();
			//Enter the email id field
			driver.findElement(By.name("emailId")).sendKeys(Utility.getProperty("Enterprise_Account_User_Email_Id"));
			
			Thread.sleep(1000);
			//Clear the password field
			driver.findElement(By.name("pass")).clear();
			//Enter the Password
			driver.findElement(By.name("pass")).sendKeys(Utility.getProperty("Enterprise_Account_User_Password"));
			
			Thread.sleep(1000);
			//Clear the Confirm Password field
			driver.findElement(By.name("conPass")).clear();
			//Enter the Confirm password
			driver.findElement(By.name("conPass")).sendKeys(Utility.getProperty("Enterprise_Account_User_Password"));
			
			Thread.sleep(1000);
			//Click the Language field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[9]/div/div/a")).click();
			//Enter the required Language
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[9]/div/div/div/div/input")).sendKeys("English");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[9]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			//Click the Stores option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[10]/div/div/ul")).click();
			//Enter the required store
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[10]/div/div/ul/li/input")).sendKeys(Utility.getReportProperty("Store"));
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[10]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(1000);
			//Clear the Date of Joining field
			driver.findElement(By.name("dateOfJoining")).clear();
			//Enter the date of joining
			driver.findElement(By.name("dateOfJoining")).sendKeys("05-Apr-2018");
			
			Thread.sleep(1000);
			//Clear the Address1 field
			driver.findElement(By.name("addressLine1")).clear();
			//Enter the Address1
			driver.findElement(By.name("addressLine1")).sendKeys("38/21, Navalar Street");
			
			Thread.sleep(1000);
			//Clear the Address2 field
			driver.findElement(By.name("addressLine2")).clear();
			//Enter the Address2 field
			driver.findElement(By.name("addressLine2")).sendKeys("Arumbakkam");
			
			Thread.sleep(1000);
			//Clear the city field
			driver.findElement(By.name("city")).clear();
			//Enter the city field
			driver.findElement(By.name("city")).sendKeys("Chennai");
			
			Thread.sleep(1000);
			//Clear the State field
			driver.findElement(By.name("state")).clear();
			//Enter the state
			driver.findElement(By.name("state")).sendKeys("Tamil Nadu");
			
			Thread.sleep(1000);
			//Clear the Zip Code
			driver.findElement(By.name("zipCode")).clear();
			//Enter the Zip Code
			driver.findElement(By.name("zipCode")).sendKeys("600106");
			
			Thread.sleep(1000);
			//Select the Employee image
			driver.findElement(By.id("userImage")).sendKeys(Utility.getProperty("Enterprise_Account_Users_Employee_Img"));
			
			
			Thread.sleep(2000);
			//Click the Submit button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(2000);
			//Check whether the account user is saved or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("User Saved Successfully"))
			{
				test.log(LogStatus.PASS, "New Account user is saved successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Account user is saved fail");
			}
			
			Thread.sleep(3000);
		}
		
		@Test(priority=5)
		public void Account_User_edit (WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(1000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//Enter the required key word
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Enterprise_Account_User_First_Name"));
			
			Thread.sleep(1000);
			//Click the pencil icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			Thread.sleep(1000);
			//Clear the First name field
			driver.findElement(By.name("firstName")).clear();
			//Enter the First Name
			driver.findElement(By.name("firstName")).sendKeys(Utility.getProperty("Enterprise_Account_User_First_Name")+"10");
			
			Thread.sleep(1000);
			//Clear the Last field
			driver.findElement(By.name("lastName")).clear();
			//Enter the Last Name
			driver.findElement(By.name("lastName")).sendKeys("LName");
			
			Thread.sleep(1000);
			//Enable or Select the Gender as Male
			if(driver.findElement(By.xpath("//input[@value='Male']")).isSelected())
			{
				
			}
			else
			{
				Thread.sleep(1000);
				//Click or select the male radio button
				driver.findElement(By.xpath("//input[@value='Male']")).click();
			}
			
			Thread.sleep(1000);
			//Clear the Date of birth field
			driver.findElement(By.name("dateOfBirth")).clear();
			//Enter the Date of birth
			driver.findElement(By.name("dateOfBirth")).sendKeys("04-Nov-1993");
			
			Thread.sleep(1000);
			//Clear the phone number field
			driver.findElement(By.name("phoneNumber")).clear();
			//Enter the phone number
			driver.findElement(By.name("phoneNumber")).sendKeys("5484958625");
			
			Thread.sleep(1000);
			//Clear the email id field
			driver.findElement(By.name("emailId")).clear();
			//Enter the email id field
			driver.findElement(By.name("emailId")).sendKeys(Utility.getProperty("Enterprise_Account_User_Email_Id")+".in");
			
			Thread.sleep(2000);
			//Click the update button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(2500);
			//Check whether the account user is updated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("User updated successfully"))
			{
				test.log(LogStatus.PASS, "New Account user is updated successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Account user is updated fail");
			}
			
			Thread.sleep(3000);
			
			
		}
		
		@Test(priority=6)
		public void Account_User_reset_Password(WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(1000);
			Thread.sleep(1000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//Enter the required key word
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Enterprise_Account_User_First_Name"));
			
			Thread.sleep(1000);
			//Click the pencil icon
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-reset")).click();
			
			Thread.sleep(1000);
			//clear the new password field
			driver.findElement(By.name("newPassword")).clear();
			//Enter the new password
			driver.findElement(By.name("newPassword")).sendKeys(Utility.getProperty("Enterprise_Account_User_Password")+"a");
			
			Thread.sleep(1000);
			//clear the confirm password field
			driver.findElement(By.name("confirmPassword")).clear();
			//Enter the confirm password
			driver.findElement(By.name("confirmPassword")).sendKeys(Utility.getProperty("Enterprise_Account_User_Password")+"a");
	
			Thread.sleep(1000);
			//Click the Reset button
			driver.findElement(By.xpath("//body[@id='body']/div[1]/div/div/form/div[2]/div/button")).click();
	
			Thread.sleep(2000);
			
			//Check whether the password is reseted or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Your Password has been reset successfully"))
			{
				test.log(LogStatus.PASS, "New Account user password is updated successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Account user password is updated fail");
			}
			
			Thread.sleep(2000);
			
		}
		
		@Test(priority=7)
		public void NewAccountUser_Cancel_Button(WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(1000);
			//Click the Add Account Users Button
			driver.findElement(By.id("createUser")).click();
			
			//Clear the First name field
			driver.findElement(By.name("firstName")).clear();
			//Enter the First Name
			driver.findElement(By.name("firstName")).sendKeys(Utility.getProperty("Enterprise_Account_User_First_Name"));
			
			Thread.sleep(1000);
			//Clear the Last field
			driver.findElement(By.name("lastName")).clear();
			//Enter the Last Name
			driver.findElement(By.name("lastName")).sendKeys("LName");
			
			Thread.sleep(1000);
			//Enable or Select the Gender as Male
			if(driver.findElement(By.xpath("//input[@value='Male']")).isSelected())
			{
				
			}
			else
			{
				Thread.sleep(1000);
				//Click or select the male radio button
				driver.findElement(By.xpath("//input[@value='Male']")).click();
			}
			
			Thread.sleep(2000);
			//Click the Close button
			driver.findElement(By.xpath("//a[.='Cancel']")).click();
			
			Thread.sleep(1000);
			//Check whether the cancel button is working or not
			if(driver.findElement(By.id("createUser")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Cancel button is working fine in New Account User Create Page");
			}
			else
			{
				test.log(LogStatus.FAIL, "Cancel button is not working in New Account User Create Page");
			}
		}
		
		@Test(priority=8)
		public void EditAccountUser_Cancel_Button(WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(1000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//Enter the required key word
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Enterprise_Account_User_First_Name")+"10");
			
			Thread.sleep(1000);
			//Click the pencil icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			Thread.sleep(1000);
			//Clear the First name field
			driver.findElement(By.name("firstName")).clear();
			//Enter the First Name
			driver.findElement(By.name("firstName")).sendKeys(Utility.getProperty("Enterprise_Account_User_First_Name")+"11");
			
			Thread.sleep(1000);
			//Clear the Last field
			driver.findElement(By.name("lastName")).clear();
			//Enter the Last Name
			driver.findElement(By.name("lastName")).sendKeys("LName");
			
			Thread.sleep(1000);
			//Enable or Select the Gender as Male
			if(driver.findElement(By.xpath("//input[@value='Male']")).isSelected())
			{
				
			}
			else
			{
				Thread.sleep(1000);
				//Click or select the male radio button
				driver.findElement(By.xpath("//input[@value='Male']")).click();
			}
			
			Thread.sleep(2000);
			//Click the Close button
			driver.findElement(By.xpath("//a[.='Cancel']")).click();
			
			Thread.sleep(1000);
			//Check whether the cancel button is working or not
			if(driver.findElement(By.id("createUser")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Cancel button is working fine in Edit Account User Create Page");
			}
			else
			{
				test.log(LogStatus.FAIL, "Cancel button is not working in Edit Account User Create Page");
			}
		}
		
		@Test(priority=9)
		public void Reset_Password_Cancel_Button(WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(1000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//Enter the required key word
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Enterprise_Account_User_First_Name"));
			
			Thread.sleep(1000);
			//Click the pencil icon
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-reset")).click();
			
			Thread.sleep(1000);
			//clear the new password field
			driver.findElement(By.name("newPassword")).clear();
			//Enter the new password
			driver.findElement(By.name("newPassword")).sendKeys(Utility.getProperty("Enterprise_Account_User_Password")+"a");
			
			Thread.sleep(1000);
			//clear the confirm password field
			driver.findElement(By.name("confirmPassword")).clear();
			//Enter the confirm password
			driver.findElement(By.name("confirmPassword")).sendKeys(Utility.getProperty("Enterprise_Account_User_Password")+"a");
	
			Thread.sleep(2000);
			//Click the Close button
			driver.findElement(By.xpath("//a[.='Close']")).click();
			
			Thread.sleep(1000);
			//Check whether the cancel button is working or not
			if(driver.findElement(By.id("createUser")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Cancel button is working fine in Reset Password Page");
			}
			else
			{
				test.log(LogStatus.FAIL, "Cancel button is not working in Reset Password Page");
			}
			
			Thread.sleep(2000);
			
		}
		
		@Test(priority=10)
		public void Account_Users_delete(WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(1000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			//Enter the required key word
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Enterprise_Account_User_First_Name")+"10");
			
			//Click the Delete button
			driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
			
			//Click the Yes button in the popup
			driver.findElement(By.linkText("Yes")).click();
			
			Thread.sleep(3000);
			//Check the menu item deleted or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("User inactivated successfully"))
			{
				test.log(LogStatus.PASS, "Account User deleted Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Account User deleted Failed");
			}
	
			Thread.sleep(5000);
		
	
			//Click the Active Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/input")).click();
			Thread.sleep(3000);
			
			//Click the success button
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
			Thread.sleep(1000);
			
			//Click the Yes button in the popup
			driver.findElement(By.linkText("Yes")).click();
			Thread.sleep(3000);
			
			//Check the menu item activated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("User activated successfully"))
			{
				test.log(LogStatus.PASS, "Account User activated Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Account User activated Failed");
			}
			
			Thread.sleep(5000);
		}
	
		@Test(priority=11)
		public void Loyalty_page_Setting(WebDriver driver) throws Exception
		{
			/*//Click the My Stores option
			driver.findElement(By.xpath("//span[.='My Stores']")).click();
			JavascriptExecutor je1 = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element1 = driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[8]/a/span"));
			//Scroll the page till the Reason option present
			je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
			//Wait for 30 seconds
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(3000);
		    //Click the Loyalty Option		
			driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[8]/a/span")).click();
			*/
			Thread.sleep(3000);	
			//Enter the Coursing URL
			driver.get(Utility.getProperty("Enterprise_Base_URL")+"loyalty");
				
			Thread.sleep(5000);
			//Check Loyalty page opened or not
			if(driver.findElement(By.xpath("//a[.='Loyalty']")).getText().equalsIgnoreCase("Loyalty"))
	
			{
				test.log(LogStatus.PASS, "Loyalty page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Loyalty page loaded Failed");
			}
			
			Thread.sleep(3000);
			
		}
	
		@Test(priority=12)
		public void Loyalty_Settingpage(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			
			//Check whether the Loyalty Account button is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='loyalty.enableLoyalty']")).isSelected()){}
			
			else
			{
				//Enable the Loyalty Account button Option
				driver.findElement(By.xpath("//input[@ng-model='loyalty.enableLoyalty']")).click();
			}
			
			
			Thread.sleep(3000);
			//Clear the Points For Customer Enrollment
			driver.findElement(By.name("customerEnrollment")).clear();
			//Enter the Customer Enrollment value
			driver.findElement(By.name("customerEnrollment")).sendKeys(Utility.getProperty("customerEnrollment_Value"));
			
			//Clear the Points for Every Visit
			driver.findElement(By.name("visit")).clear();
			//Enter the Points For Every Visit
			driver.findElement(By.name("visit")).sendKeys(Utility.getProperty("Loyalty_visitPrice"));
			
			Thread.sleep(2000);
			//Actions act = new Actions(driver);
			//act.moveToElement(driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[5]/div[1]/input"))).click().build().perform();
			
			//Clear the Points for the Cash Payment
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[5]/div[1]/input")).clear();
			//Enter the Points for the Cash Payment
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[5]/div[1]/input")).sendKeys(Utility.getProperty("Loyalty_purchasePoint"));
			
			//Clear the Points for the Cash Payment
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[5]/div[2]/input")).clear();
			//Enter the Points for the Cash Payment
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[5]/div[2]/input")).sendKeys(Utility.getProperty("Loyalty_purchasePoint"));
	
			//Clear the Points for the Non Cash Payment
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[6]/div[1]/input")).clear();
			//Enter the Points for the Non Cash Payment
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[6]/div[1]/input")).sendKeys(Utility.getProperty("Loyalty_purchasePoint"));
			
			//Clear the Points for the Non Cash Payment
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[6]/div[2]/input")).clear();
			//Enter the Points for the Non Cash Payment
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[6]/div[2]/input")).sendKeys(Utility.getProperty("Loyalty_purchasePoint"));
	
			//Click Add Menu item Based
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[7]/div/div/div/a/i")).click();
			
			//Click the Menu Item Option
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[7]/div/div[2]/ng-form/div/div[1]/div/a")).click();
			//Press the Enter Button
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[7]/div/div[2]/ng-form/div/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			//Clear the Quantity Option
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[7]/div/div[2]/ng-form/div/div[2]/div/input")).clear();
			//Enter the Quantity
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[7]/div/div[2]/ng-form/div/div[2]/div/input")).sendKeys("5");
			
			//Clear the Points
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[7]/div/div[2]/ng-form/div/div[3]/div/input")).clear();
			//Enter the Points
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[7]/div/div[2]/ng-form/div/div[3]/div/input")).sendKeys("10");
			
			
			//Click the Add Button
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div/div[7]/div/div/div/a/i")).click();
			
			
			//Click the Close Button of newly added option
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[7]/div/div[3]/ng-form/div/div[3]/div/a")).click();
			
			Thread.sleep(2000);
			//Click the Yes Button
			driver.findElement(By.partialLinkText("Yes")).click();
			
			//Click Add Category Based
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div/div/a")).click();
			
			//Click the Category Option
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div[2]/ng-form/div/div[1]/div/a")).click();
			//Press the Enter Button
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div[2]/ng-form/div/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
			//Clear the Quantity Option
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div[2]/ng-form/div/div[2]/div/input")).clear();
			//Enter the Quantity
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div[2]/ng-form/div/div[2]/div/input")).sendKeys("5");
			
			//Clear the Points
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div[2]/ng-form/div/div[3]/div/input")).clear();
			//Enter the Points
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div[2]/ng-form/div/div[3]/div/input")).sendKeys("8");
			
			//Click the Add Button
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div/div/a")).click();
			
			Thread.sleep(5000);
			//Click the Close Button of newly added option
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div[3]/ng-form/div/div[3]/div/a")).click();
			
			Thread.sleep(2000);
			//Click the Yes Button
			driver.findElement(By.partialLinkText("Yes")).click();
			
			Thread.sleep(2000);
			//Enter the Redeem points
			driver.findElement(By.xpath("//input[@name='exchangeRate']")).clear();
			//Enter the Redeem points
			driver.findElement(By.xpath("//input[@name='exchangeRate']")).sendKeys("2.00");
	
			Thread.sleep(2000);
			//Enter the Minimum points required for redemption option
			driver.findElement(By.xpath("//input[@name='minPoints']")).clear();
			//Enter the Minimum points required for redemption option
			driver.findElement(By.xpath("//input[@name='minPoints']")).sendKeys("2");
	
			
			Thread.sleep(3000);
			//Click the update button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(3000);
			//Check Loyalty updated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("loyalty Saved successfully"))
	
			{
				test.log(LogStatus.PASS, "Loyalty updated Successfully ");
			}
			else
			{
				test.log(LogStatus.FAIL, "Loyalty updated Failed");
			}
			Thread.sleep(3000);
			}
	
		@Test(priority=13)
		public void Loyalty_SettingpageDisable(WebDriver driver) throws Exception
		{
	
			Thread.sleep(2000);
	
			//Check whether the Loyalty Account button is enabled or not
			if(!driver.findElement(By.xpath("//input[@ng-model='loyalty.enableLoyalty']")).isEnabled())
			{}
			else
			{
				//Enable the Loyalty Account button Option
				driver.findElement(By.xpath("//input[@ng-model='loyalty.enableLoyalty']")).click();
			}
	
			//Click the Close Button of newly added option - Menu Item
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[7]/div/div[2]/ng-form/div/div[3]/div/a")).click();
			
			Thread.sleep(2000);
			//Click the Yes Button
			driver.findElement(By.partialLinkText("Yes")).click();
			
			//Click the Close Button of newly added option - Category
			driver.findElement(By.xpath("//form[@name='loyaltyCreation']/div[1]/div[8]/div/div[2]/ng-form/div/div[3]/div/a")).click();	
			
			Thread.sleep(2000);
			//Click the Yes Button
			driver.findElement(By.partialLinkText("Yes")).click();
			
			Thread.sleep(3000);
			//Click the update button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(5000);
			//Check Loyalty updated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("loyalty Saved successfully"))
	
			{
				test.log(LogStatus.PASS, "Loyalty updated Successfully for disabled option");
			}
			else
			{
				test.log(LogStatus.FAIL, "Loyalty updated Failed for disabled option");
			}
			
			Thread.sleep(3000);
		}

		/*

		@Test(priority=14)
		public void Loyalty_page_Report(WebDriver driver) throws InterruptedException
		{
			//Click the My Stores option
			driver.findElement(By.xpath("//span[.='My Stores']")).click();
			
			
			JavascriptExecutor je1 = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element1 = driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[8]/a/span"));
			//Scroll the page till the Reason option present
			je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
			//Wait for 30 seconds
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(3000);
		    //Click the Loyalty Option		
			driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[8]/a/span")).click();
			
			Thread.sleep(5000);
			//Check Loyalty page opened or not
			if(driver.findElement(By.xpath("//a[.='Loyalty']")).getText().equalsIgnoreCase("Loyalty"))

			{
				test.log(LogStatus.PASS, "Loyalty page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Loyalty page loaded Failed");
			}
			
			Thread.sleep(3000);
			
		}*/
		@Test(priority=15)
		public void Loyalty_Report_open_page(WebDriver driver) throws Exception
		{
			//Enter the URl
			Thread.sleep(3000);
			driver.get(Utility.getProperty("Enterprise_Base_URL")+"loyaltyReport");
		
			Thread.sleep(3000);
		//Click Time period option
		driver.findElement(By.xpath("//form[@name='loyaltyReport']/div[1]/div/div/a")).click();
		//Enter the required Time period option
		driver.findElement(By.xpath("//form[@name='loyaltyReport']/div[1]/div/div/div/div/input")).sendKeys("Date Range");
		//Click Time period option
		driver.findElement(By.xpath("//form[@name='loyaltyReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Click Date_Range_From option
		driver.findElement(By.xpath("//form[@name='loyaltyReport']/div[2]/div/div/input[1]")).clear();
		//Enter the required Date_Range_From
		driver.findElement(By.xpath("//form[@name='loyaltyReport']/div[2]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		//Enter Date_Range_From
		driver.findElement(By.xpath("//form[@name='loyaltyReport']/div[2]/div/div/input[1]")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		//Click Date_Range_To option
		driver.findElement(By.xpath("//form[@name='loyaltyReport']/div[2]/div/div/input[2]")).clear();
		//Enter the required Time Date_Range_To
		driver.findElement(By.xpath("//form[@name='loyaltyReport']/div[2]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		//Enter Date_Range_To option
		driver.findElement(By.xpath("//form[@name='loyaltyReport']/div[2]/div/div/input[2]")).sendKeys(Keys.ENTER);
			
		Thread.sleep(3000);
		//Click Customer Name option
		driver.findElement(By.xpath("//form[@name='loyaltyReport']/div[3]/div/a")).click();
		//Enter the required Customer Name
		driver.findElement(By.xpath("//form[@name='loyaltyReport']/div[3]/div/div/div/input")).sendKeys(Utility.getProperty("Loyalty_Customer_Name"));
		//driver.findElement(By.xpath("//form[@name='loyaltyReport']/div[3]/div/div/div/input")).sendKeys(Utility.getProperty("Loyalty_Customer_Name"));
		//Enter Customer Name
		driver.findElement(By.xpath("//form[@name='loyaltyReport']/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
			
		Thread.sleep(3000);
		//Click run button
		driver.findElement(By.xpath("//form[@name='loyaltyReport']/div[4]/div/div/button")).click();
		
		Thread.sleep(10000);
		
		//Check weather the report is available for the selected time period
		if(driver.findElement(By.xpath("//h3[.='No transaction for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.FAIL, "Transaction Report(By Tender Type) is not available for Specific Date");
		}
		//Check weather the table format report is available or not
		else if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText()!=null)
		{
			test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
			
			Thread.sleep(3000);
	        //No.of rows
	        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr"));
	      
	        for(int i = 2; i <= rows.size(); i++)
	        {
	        	if(i == rows.size())
	        	{
	        		test.log(LogStatus.INFO, "Customer Name(Loyalty Report) : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[1]")).getText());
	        		test.log(LogStatus.INFO, "Signup Date(Loyalty Report) : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[2]")).getText());
	        		test.log(LogStatus.INFO, "Last Redemption Date(Loyalty Report) : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[3]")).getText());
	        		test.log(LogStatus.INFO, "Last Accumulation Date(Loyalty Report) : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[4]")).getText());
	        		test.log(LogStatus.INFO, "Total Loyalty Points(Loyalty Report) : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[5]/span")).getText());
	        		test.log(LogStatus.INFO, "Total Redeemed Loyalty Points(Loyalty Report) : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[6]/span")).getText());
	        	}
	        }
		}
		else
		{
			test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date");
		}
	/*	        //Print number of Rows
	        System.out.println("Number of Rows are : "+rows);*/
	        
	    	
/*	    	//Replace all commo's with empty space
	    	String expected1 = Utility.getReportProperty("Loyalty_Customer_Name").replace(",", "");
	    	
	    	//Convert the String value of the Sale_Report_Sale_Amount element into float value
	    	float expect1 = Float.parseFloat(expected1);  
	    		        	
	    	//Replace all commo's with empty space
	    	String expected2 = Utility.getReportProperty("Loyalty_Sign_upDate").replace(",", "");
	    	
	    	Float.parseFloat(expected2);  
	    	
	    	//Replace all commo's with empty space
	    	String expected3 = Utility.getReportProperty("Loyalty_Last_Redemption_Date").replace(",", "");
	    	
	    	Float.parseFloat(expected3);  

	    	//Replace all commo's with empty space
	    	String expected4 = Utility.getReportProperty("Loyalty_Last_AccumulationDate").replace(",", "");
	    	
	    	Float.parseFloat(expected4);  
	    	
	    	//Replace all commo's with empty space
	    	String expected5 = Utility.getReportProperty("Total_Redeemed_LoyaltyPoints").replace(",", "");
	    	
	    	Float.parseFloat(expected5);                              
	        
	    	//Replace all commo's with empty space
	    	String expected6 = Utility.getReportProperty("Total_LoyaltyPoints").replace(",", "");
	    	
	    	Float.parseFloat(expected6);                  
	        //Check weather the Sale Amount Report is correct or not
	        if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
	        {
	        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Sale Amount");
	        	
	        	//Get the Total value of Sale Amount
	        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
	        	
	        	//Replace all commo's with empty space
	        	String actualText= actualText1.replace(",", "");
	        	
	        	//Convert the String value of the Sale Amount Total element into float value
	        	float actual = Float.parseFloat(actualText);
	        	
	        	//Print the actual value
	        	System.out.println("The Actual Sale Amount Value is : "+actual);
	        	
	        	test.log(LogStatus.PASS, "The Last Accumulation Date is : "+ actual);
	        }
	        
			else if(expect1 == unknownValue)
			{
				test.log(LogStatus.PASS, "Here we don't have the exact expected value");
				
	        	//Get the Total value of Check Count
	        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();

	        	System.out.println("The Actual Sale Amount value is : "+actualText);
	        	
	        	test.log(LogStatus.INFO, "Total Loyalty Points value is : "+actualText);
			}
	        
	        else
	        {
	        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Sale Amount");
	        	
	        	//Get the Total value of Sale Amount
	        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/div/table/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
	        	
	        	//Replace all commo's with empty space
	        	String actualText= actualText1.replace(",", "");
	        	
	        	//Convert the String value of the sale amount Total element into float value
	        	float actual = Float.parseFloat(actualText);
	        			        	
	        	//Get the different
	        	float different = actual - expect1;
	        	
	        	//Print the different value
	        	System.out.println("Sale Amount Value different is : "+different);
	        	
	        	test.log(LogStatus.FAIL, "Total Redeemed Loyalty Points different is : "+different);	
	        }
		}*/
		
		}

		@Test(priority=16)
		public void Enterprise_Customers_openpage(WebDriver driver) throws Exception
		{
			/*//Click the My Stores option
			driver.findElement(By.xpath("//span[.='My Stores']")).click();

			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Customers']"));
			//Scroll the page till the Customers option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
			//Wait for 30 seconds
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Thread.sleep(3000);
	        //Click the Group Option		
			driver.findElement(By.xpath("//span[.='Customers']")).click();
			*/
			//Enter the URl
			Thread.sleep(3000);
			driver.get(Utility.getProperty("Enterprise_Base_URL")+"customers");
			
			Thread.sleep(5000);
			//Check CashierOut Report page opened or not
			if(driver.findElement(By.xpath("//a[.='Customers']")).getText().equalsIgnoreCase("Customers"))
			{
				test.log(LogStatus.PASS, "Customers page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Customers page loaded Failed");
			}
			
			Thread.sleep(3000);

		}
		
		@Test(priority=17)
		public void Enterprise_Customer_add_(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Click the add customer button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[3]/div[2]/span[2]/a")).click();
			
			Thread.sleep(3000);
			//Check whether the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New Customer']")).getText().equalsIgnoreCase("New Customer"))
			{
				test.log(LogStatus.PASS, "New customer form loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New customer form loaded fail");
			}
			Thread.sleep(2000);
			
			//Clear the first name filed
			driver.findElement(By.name("firstName")).clear();
			//Enter the first name
			driver.findElement(By.name("firstName")).sendKeys(Utility.getProperty("Enterprise_Customer_FName"));
			
			//Clear the Last name field
			driver.findElement(By.name("lastName")).clear();
			//Enter the Last name
			driver.findElement(By.name("lastName")).sendKeys(Utility.getProperty("Enterprise_Customer_LName"));
			
			//clear the mail id field
			driver.findElement(By.name("emailId")).clear();
			//Enter the mail id
			driver.findElement(By.name("emailId")).sendKeys(Utility.getProperty("Enterprise_Customer_Email"));
			
			//Clear the phone number field
			driver.findElement(By.name("phoneNumber")).clear();
			//Enter the phone number
			driver.findElement(By.name("phoneNumber")).sendKeys(Utility.getProperty("Enterprise_Customer_Phone"));
			
			
			//choose the male option for Gender
			driver.findElement(By.xpath("//input[@value='Male']")).click();

			//Clear the date of birth field
			driver.findElement(By.name("dateOfBirth")).clear();
			//Enter the Date of Birth
			driver.findElement(By.name("dateOfBirth")).sendKeys("01-Jan-1990");
			
			//Clear the Gate Code field
			driver.findElement(By.name("gateCode")).clear();
			//Enter the Gate Code
			driver.findElement(By.name("gateCode")).sendKeys(Utility.getProperty("Enterprise_Customer_Gatecode"));
			
			//Clear the anniversary date field
			driver.findElement(By.name("anniversary")).clear();
			//Enter the anniversary date
			driver.findElement(By.name("anniversary")).sendKeys("01-Jan-2000");
			
			//Clear the Customer Id field
			driver.findElement(By.xpath("//input[@ng-model='customer.customerIdentificationNumber']")).clear();
			//Enter the Customer Id
			driver.findElement(By.xpath("//input[@ng-model='customer.customerIdentificationNumber']")).sendKeys(Utility.getProperty("Enterprise_Customer_Customer_Id"));
			
			//Clear the Notes option
			driver.findElement(By.xpath("//textarea[@ng-model='customer.notes']")).clear();
			//Enter the Notes
			driver.findElement(By.xpath("//textarea[@ng-model='customer.notes']")).sendKeys("Note");
			
			//Clear the Address Line 1
			driver.findElement(By.name("addressLine1")).clear();
			//Enter the Address Line 1
			driver.findElement(By.name("addressLine1")).sendKeys("38/21, Navalar Street, Ranianna Nagar");
			
			//Clear the Address Line 2
			driver.findElement(By.name("addressLine2")).clear();
			//Enter the Address Line 2
			driver.findElement(By.name("addressLine2")).sendKeys("Arumbakkam");
			
			//Clear the City field
			driver.findElement(By.name("city")).clear();
			//Enter the City
			driver.findElement(By.name("city")).sendKeys("Chennai");
			
			//Clear the State field
			driver.findElement(By.name("state")).clear();
			//Enter the State
			driver.findElement(By.name("state")).sendKeys("Tamil Nadu");
			
			//Clear the Country field
			driver.findElement(By.name("country")).clear();
			//Enter the Country
			driver.findElement(By.name("country")).sendKeys("India");
			
			//Clear the Nationality
			driver.findElement(By.name("nationality")).clear();
			//Enter the Nationality
			driver.findElement(By.name("nationality")).sendKeys("Indian");
			
			//Clear the Zipcode field
			driver.findElement(By.name("zipCode")).clear();
			//Enter the Zipcode
			driver.findElement(By.name("zipCode")).sendKeys("600106");
			
			Thread.sleep(3000);
			//Choose the required image
			driver.findElement(By.id("customerImage")).sendKeys(Utility.getProperty("Customer_Img"));
			
			Thread.sleep(2000);
			//Click the Save button
			driver.findElement(By.xpath("//button[@type='submit']")).click();

			Thread.sleep(3500);
			
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Customer saved successfully"))
			{
				test.log(LogStatus.PASS, "New Customer saved successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Customer saved fail");
			}
			Thread.sleep(3000);
		}
		
		@Test(priority=18)
		public void Enterprise_Customer_edit(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(1000);

			//Enter the required group name
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Enterprise_Customer_FName")+" "+ Utility.getProperty("Enterprise_Customer_LName"));
			
			//Click the Search button
			//driver.findElement(By.xpath("//a[@class='btn customer-search-icon']")).click();
			
			Thread.sleep(2000);
			//Click the Edit button
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			//Clear the first name filed
			driver.findElement(By.name("firstName")).clear();
			//Enter the first name
			driver.findElement(By.name("firstName")).sendKeys(Utility.getProperty("Enterprise_Customer_FName")+"1");
			
			//Clear the Last name field
			driver.findElement(By.name("lastName")).clear();
			//Enter the Last name
			driver.findElement(By.name("lastName")).sendKeys(Utility.getProperty("Enterprise_Customer_LName")+"1");
			
			//clear the mail id field
			driver.findElement(By.name("emailId")).clear();
			//Enter the mail id
			driver.findElement(By.name("emailId")).sendKeys(Utility.getProperty("Enterprise_Customer_Email"));
			
			//Clear the phone number field
			driver.findElement(By.name("phoneNumber")).clear();
			//Enter the phone number
			driver.findElement(By.name("phoneNumber")).sendKeys(Utility.getProperty("Enterprise_Customer_Phone")+"1");
			
			
			//choose the male option for Gender
			driver.findElement(By.xpath("//input[@value='Male']")).click();

			//Clear the date of birth field
			driver.findElement(By.name("dateOfBirth")).clear();
			//Enter the Date of Birth
			driver.findElement(By.name("dateOfBirth")).sendKeys("02-Jan-1990");
			
			//Clear the Gate Code field
			driver.findElement(By.name("gateCode")).clear();
			//Enter the Gate Code
			driver.findElement(By.name("gateCode")).sendKeys(Utility.getProperty("Enterprise_Customer_Gatecode")+"1");
			
			//Clear the anniversary date field
			driver.findElement(By.name("anniversary")).clear();
			//Enter the anniversary date
			driver.findElement(By.name("anniversary")).sendKeys("02-Jan-2000");
			
			//Clear the Customer Id field
			driver.findElement(By.xpath("//input[@ng-model='customer.customerIdentificationNumber']")).clear();
			//Enter the Customer Id
			driver.findElement(By.xpath("//input[@ng-model='customer.customerIdentificationNumber']")).sendKeys(Utility.getProperty("Enterprise_Customer_Customer_Id")+"1");
			
			//Clear the Notes option
			driver.findElement(By.xpath("//textarea[@ng-model='customer.notes']")).clear();
			//Enter the Notes
			driver.findElement(By.xpath("//textarea[@ng-model='customer.notes']")).sendKeys("Notes");
			
			
			//Click the update button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(3500);
			
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Customer updated successfully"))
			{
				test.log(LogStatus.PASS, "New Customer updated successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Customer updated fail");
			}
			Thread.sleep(3000);
			
		}
		
		@Test(priority=21)
		public void Enterprise_Customer_delete(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(1000);

			//Enter the required group name
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Enterprise_Customer_FName")+"1 "+ Utility.getProperty("Enterprise_Customer_LName")+"1");
			
			//Click the Search button
			//driver.findElement(By.xpath("//a[@class='btn customer-search-icon']")).click();

			
			Thread.sleep(2000);
			//Click the Delete button
			driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
			
			Thread.sleep(2000);
			//Click the Yes button in the popup
			driver.findElement(By.linkText("Yes")).click();
			Thread.sleep(5000);
			
			try
			{
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Group inactivated successfully"))
				{
					test.log(LogStatus.PASS, "New Group inactivated successfully");
				}
			}
			catch(Exception e)
			{
				test.log(LogStatus.FAIL, "New Group inactivated fail");
			}
			Thread.sleep(3000);
			
	/*		//Click the Active Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
			Thread.sleep(3000);
			
			//Click the success button
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
			Thread.sleep(1000);
			
			//Click the Yes button in the popup
			driver.findElement(By.linkText("Yes")).click();
			Thread.sleep(3000);
			
			//Check the modifier activated or not
			if(driver.findElement(By.xpath("//span[.='Group activated successfully']")).getText().equalsIgnoreCase("Group activated successfully"))
			{
				test.log(LogStatus.PASS, "Group activated successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Group activated Failed");
			}
			
			Thread.sleep(5000);*/
		}
		
		@Test(priority=19)
		public void Enterprise_Customer_cancelButton(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(1000);

			//Enter the required group name
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Enterprise_Customer_FName")+"1 "+ Utility.getProperty("Enterprise_Customer_LName")+"1");
			
			//Click the Search button
			//driver.findElement(By.xpath("//a[@class='btn customer-search-icon']")).click();
			
			
			Thread.sleep(2000);
			//Click the Edit button
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			//Clear the first name filed
			driver.findElement(By.name("firstName")).clear();
			//Enter the first name
			driver.findElement(By.name("firstName")).sendKeys(Utility.getProperty("Enterprise_Customer_FName")+"1");
			
			//Clear the Last name field
			driver.findElement(By.name("lastName")).clear();
			//Enter the Last name
			driver.findElement(By.name("lastName")).sendKeys(Utility.getProperty("Enterprise_Customer_LName")+"1");
			
			//clear the mail id field
			driver.findElement(By.name("emailId")).clear();
			//Enter the mail id
			driver.findElement(By.name("emailId")).sendKeys(Utility.getProperty("Enterprise_Customer_Email"));
			
			//Clear the phone number field
			driver.findElement(By.name("phoneNumber")).clear();
			//Enter the phone number
			driver.findElement(By.name("phoneNumber")).sendKeys(Utility.getProperty("Enterprise_Customer_Phone")+"1");
			
			Thread.sleep(3000);
			//Click the close button
			driver.findElement(By.xpath("//a[.='Cancel']")).click();
			
			Thread.sleep(2000);
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[3]/div[2]/span[2]/a")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Cancel button working fine");
			}
			else
			{
				test.log(LogStatus.FAIL, "Cancel button not working");
			}
		}
		
		@Test(priority=20)
		public void Enterprise_Customer_view_page(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(1000);

			//Enter the required group name
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Enterprise_Customer_FName")+"1 "+ Utility.getProperty("Enterprise_Customer_LName")+"1");
			
			//Click the Search button
			//driver.findElement(By.xpath("//a[@class='btn customer-search-icon']")).click();
			
			Thread.sleep(1500);
			
			//Click the View button
			driver.findElement(By.xpath("//a[.='View']")).click();
			
			Thread.sleep(2000);
			
			
			Thread.sleep(5000);
			//Refresh button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/a[1]/i")).click();
			
			WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			
			Thread.sleep(3000);
			//Check whether the Total Spent report is available or not
			if(driver.findElement(By.xpath("//label[.='Total Spent']")).getText().equalsIgnoreCase("Total Spent"))
			{
				test.log(LogStatus.PASS, "There is Total Spent Report is available");
			}
			else
			{
				test.log(LogStatus.FAIL, "Total Spent report is not available");
			}
			
			Thread.sleep(3000);
			//Check whether the Weekly Spent report is available or not
			if(driver.findElement(By.xpath("//label[.='Weekly Spent']")).getText().equalsIgnoreCase("Weekly Spent"))
			{
				test.log(LogStatus.PASS, "There is Weekly Spent Report is available");
			}
			else
			{
				test.log(LogStatus.FAIL, "Weekly Spent report is not available");
			}
			
			Thread.sleep(3000);
		    //Check Whether the NO. OF VISIT and Sale amount Available or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[1]/span[1]")).getText().equalsIgnoreCase("NO. OF VISIT") && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[2]/span[1]")).getText().equalsIgnoreCase("SALE AMOUNT"))
		    {

		    	test.log(LogStatus.PASS, "Number of visit count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[1]/span[2]")).getText());
		    	
		    	test.log(LogStatus.PASS, "Total Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[2]/span[2]")).getText());
		    }
		    
		    else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[1]/span[1]")).getText().equalsIgnoreCase("NO. OF VISIT") || driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[2]/span[1]")).getText().equalsIgnoreCase("SALE AMOUNT"))
		    {
		    	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[1]/span[1]")).getText().equalsIgnoreCase("NO. OF VISIT"))
		    	{
		    		test.log(LogStatus.PASS, "Number of visit count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[1]/span[2]")).getText());
		    		
		    		test.log(LogStatus.FAIL, "Sale amount field is not available");
		    	}
		    	
		    	else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[2]/span[1]")).getText().equalsIgnoreCase("SALE AMOUNT"))
		    	{
		    		test.log(LogStatus.FAIL, "Number of visit field is not available");
		    		
		    		test.log(LogStatus.PASS, "Total Sale amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[1]/div/div/div[2]/span[2]")).getText());
		
		    	}
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Number of visit field is not available");
		    	
		    	test.log(LogStatus.FAIL, "Sale amount field is not available");
		    }
		    
			Thread.sleep(3000);
		    //Check Whether the LOYALTY REWARD and LOYALTY VALUE Available or not
		    if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[1]/span[1]")).getText().equalsIgnoreCase("LOYALTY REWARD") && driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[2]/span[1]")).getText().equalsIgnoreCase("LOYALTY VALUE"))
		    {

		    	test.log(LogStatus.PASS, "LOYALTY REWARD is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[1]/span[2]")).getText());
		    	
		    	test.log(LogStatus.PASS, "LOYALTY VALUE is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[2]/span[2]")).getText());
		    }
		    
		    else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[1]/span[1]")).getText().equalsIgnoreCase("LOYALTY REWARD") || driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[2]/span[1]")).getText().equalsIgnoreCase("LOYALTY VALUE"))
		    {
		    	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[1]/span[1]")).getText().equalsIgnoreCase("LOYALTY REWARD"))
		    	{
		    		test.log(LogStatus.PASS, "LOYALTY REWARD is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[1]/span[2]")).getText());
		    		
		    		test.log(LogStatus.FAIL, "LOYALTY VALUE field is not available");
		    	}
		    	
		    	else if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[2]/span[1]")).getText().equalsIgnoreCase("LOYALTY VALUE"))
		    	{
		    		test.log(LogStatus.FAIL, "LOYALTY REWARD field is not available");
		    		
		    		test.log(LogStatus.PASS, "LOYALTY VALUE is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[2]/div/div/div[2]/span[2]")).getText());
		
		    	}
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "LOYALTY REWARD field is not available");
		    	
		    	test.log(LogStatus.FAIL, "LOYALTY VALUE field is not available");
		    }
		    
			Thread.sleep(3000);
		    //Check Whether the FEEDBACKS Available or not
		    if(driver.findElement(By.xpath("//div[.='FEEDBACKS']")).getText().equalsIgnoreCase("FEEDBACKS"))
		    {
		    	test.log(LogStatus.PASS, "FEEDBACKS field is available");
		    	
		    	test.log(LogStatus.INFO, "Positive Feedback Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[3]/div/div[2]/div[1]/span[2]")).getText());
		    	
		    	test.log(LogStatus.INFO, "Negative Feedback Count is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[3]/div[3]/div/div[2]/div[2]/span[2]")).getText());
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "FEEDBACKS field is not available");
		    }
		  
		    List<WebElement> ta = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/table/tbody/tr/td"));
		    
		    if(ta.size() == 1)
		    {
		    	test.log(LogStatus.PASS, "Sales details is not available");
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Sales details is available");
		    	/*
		    	List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/table/tbody/tr"));
		    	
		    	test.log(LogStatus.PASS, "Sales details  available");
		    	
			    for(int i = 1; i <= rows.size();i++)
			    {
			    	Thread.sleep(1000);
			    	//Click the required check
			    	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/table/tbody/tr["+i+"]/td[1]/a")).click();
			    	
			    	//Check Whether the Send Receipt is enabled or not
			    	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[1]/div/div[2]/button")).isEnabled())
			    	{
			    	Thread.sleep(1000);
			    	//Click the Send Receipt
			    	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[1]/div/div[2]/button")).click();
			    	
					    	Thread.sleep(1000);
					    	//Check whether the receipt sent successfully or not
					    	if(driver.findElement(By.xpath("//span[.='Email receipt sent successfully']")).getText().equalsIgnoreCase("Email receipt sent successfully"))	
					    	{
					    		test.log(LogStatus.PASS, "Email Receipt sent successfully");
					    	}
					    	
					    	else
					    	{
					    		test.log(LogStatus.FAIL, "Email Receipt sent fail");
					    	}
			    		
			    	}
			    	
			    	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			    	test.log(LogStatus.INFO, "The Check number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[2]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "Date is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[3]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "Table is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[4]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "Seat Number is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[5]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "Server Name is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[6]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "Gratuity is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[7]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "Discount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[8]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "CC Service Charge is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[9]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "Total is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[10]/td")).getText());
			    	
			    	test.log(LogStatus.INFO, "Total Tip is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[11]/td")).getText());
			   
			    	//Get the row size of tax table
			    	List<WebElement> taxRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[3]/div/div[1]/table/tbody/tr"));
			    	
			    		Thread.sleep(1000);
			    		test.log(LogStatus.PASS, "Total Tax amount is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[3]/div/div[1]/table/tbody/tr["+taxRow.size()+"]/td[2]")).getText());
			    	
			    	//Check whether the Payment summary is available or not
			    	if(driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[3]/td[5]")) != null)
			    	{
			    		test.log(LogStatus.PASS, "Payment Summary report is available");
			    	}
			    	
			    	else
			    	{
			    		test.log(LogStatus.FAIL, "Payment Summary report is not available");
			    	}
			    	
			    	//Get the row size of order summary table
			    	List<WebElement> orderSummaryRow = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr"));
			    	
			    		Thread.sleep(1000);
			    		test.log(LogStatus.PASS, "Order Summary subtotal is : "+driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr["+orderSummaryRow.size()+"]/td[2]")).getText());
		
			    		Thread.sleep(1000);
			    		
			    		for(int j = 0; j <= 8; j++)
			    		{
			    			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
			    		}
			    		
			    		Thread.sleep(2000);
			    		//Click the Back button
			    		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[3]/div[4]/div[2]/div/div/div[1]/div/div[2]/a")).click();
			    		
			    		Thread.sleep(3000);
			    }
		    */}

		    
		    driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/a[2]")).click();
		    
		    Thread.sleep(2000);
		}

		@Test(priority=22)
		public void Group_Openpage(WebDriver driver) throws Exception
		{
			/*//Click the My Stores option
			driver.findElement(By.xpath("//span[.='My Stores']")).click();

			
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Group']"));
			//Scroll the page till the Group option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
			//Wait for 30 seconds
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			
			Thread.sleep(3000);
	        //Click the Group Option		
			driver.findElement(By.xpath("//span[.='Group']")).click();*/
			
			
			//Enter the URl
			Thread.sleep(3000);
			driver.get(Utility.getProperty("Enterprise_Base_URL")+"group");
			
			Thread.sleep(5000);
			//Check CashierOut Report page opened or not
			if(driver.findElement(By.xpath("//a[.='Groups']")).getText().equalsIgnoreCase("Groups"))
			{
				test.log(LogStatus.PASS, "Groups page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Groups page loaded Failed");
			}
			
			Thread.sleep(3000);

		}
			
		@Test(priority=23)
		public void Group_pagination(WebDriver driver) throws InterruptedException
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
			test.log(LogStatus.INFO, "Now we click the Pagination option as 10");
			//Create the web element for Modifier Groups Table
			List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/table"));
			for (WebElement result : results){						
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available");
			}
			Thread.sleep(1000);
			
			//Click the Pagination option as 15
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[3]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 15");
			//Create the web element for Modifier Groups Table
			List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/table"));
			for (WebElement result : results1){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available");
			}
			Thread.sleep(1000);
			
			//Click the Pagination option as 20
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[4]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 20");
			//Create the web element for Modifier Groups Table
			List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/table"));
			for (WebElement result : results2){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available");
			}
			Thread.sleep(1000);
			
			//Click the Pagination option as 5
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/ul/li[1]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 5");
			//Create the web element for Modifier Groups Table
			List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/table"));
			for (WebElement result : results3){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available");
			}
		}
		
		@Test(priority=24)
		public void Group_add(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Click the add Group button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/button")).click();
			
			Thread.sleep(3000);
			//Check whether the new form loaded or not
			if(driver.findElement(By.xpath("//span[.='New Group']")).getText().equalsIgnoreCase("New Group"))
			{
				test.log(LogStatus.PASS, "New group form loaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New group form loaded fail");
			}
			Thread.sleep(5000);
			
			//Clear the name filed
			driver.findElement(By.name("name")).clear();
			//Enter the name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Enterprise_Group_Name"));
			Thread.sleep(5000);
			//Click the Stores option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[2]/form/div[2]/div/ul")).click();
			//Enter the required store
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[2]/form/div[2]/div/ul/li/input")).sendKeys(Utility.getProperty("Store"));
			//Press the Enter button          
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[2]/form/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			//Click the Save button
			driver.findElement(By.id("saveGroup")).click();
			Thread.sleep(5000);
			
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Group saved successfully"))
			{
				test.log(LogStatus.PASS, "New Group saved successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Group saved fail");
			}
			Thread.sleep(3000);
		}
		
		@Test(priority=25)
		public void Group_edit(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(1000);

			//Enter the required group name
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Enterprise_Group_Name"));
			
			Thread.sleep(2000);
			      //Click the Edit button
			       driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			       Thread.sleep(3000);
			        //Clear the name filed
					driver.findElement(By.name("name")).clear();
					//Enter the name
					driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Enterprise_Group_Name")+"1");
					
					
					//Click the Stores option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[2]/form/div[2]/div/ul")).click();

					//Clear the Stores option
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[2]/form/div[2]/div/ul/li/input")).clear();
					//Enter the required store
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[2]/form/div[2]/div/ul/li/input")).sendKeys(Utility.getProperty("Store"));
					//Press the Enter button          
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[2]/form/div[2]/div/ul/li/input")).sendKeys(Keys.ENTER);
					
					//Click the Save button
					driver.findElement(By.id("saveGroup")).click();
					Thread.sleep(5000);
			
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Group updated successfully"))
			{
				test.log(LogStatus.PASS, "New Group updated successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Group updated fail");
			}
			Thread.sleep(3000);
			
		}
		
		@Test(priority=26)
		public void Group_delete(WebDriver driver) throws Exception
		{
			Thread.sleep(8000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(1000);

			//Enter the required group name
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Enterprise_Group_Name")+"1");
			
			Thread.sleep(2000);
			//Click the Delete button
			driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
			
			Thread.sleep(2000);
			//Click the Yes button in the popup
			driver.findElement(By.linkText("Yes")).click();
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Group inactivated successfully"))
			{
				test.log(LogStatus.PASS, "New Group inactivated successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Group inactivated fail");
			}
			Thread.sleep(3000);
			
			//Click the Active Button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/input")).click();
			Thread.sleep(3000);
			
			//Click the success button
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
			Thread.sleep(1000);
			
			//Click the Yes button in the popup
			driver.findElement(By.linkText("Yes")).click();
			Thread.sleep(3000);
			
			//Check the modifier activated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Group activated successfully"))
			{
				test.log(LogStatus.PASS, "Group activated successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Group activated Failed");
			}
			
			Thread.sleep(5000);
		}
		
		@Test(priority=27)
		public void Group_cancelButton(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
			Thread.sleep(1000);

			//Enter the required group name
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Enterprise_Group_Name")+"1");
			
			Thread.sleep(2000);
			//Click the Edit button
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			
			Thread.sleep(5000);
			//Clear the name filed
			driver.findElement(By.name("name")).clear();
			//Enter the name
			driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Enterprise_Group_Name"));
			
			Thread.sleep(5000);
			//Click the close button
			driver.findElement(By.xpath("//a[.='Close']")).click();
			
			Thread.sleep(2000);
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/button")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Close button working fine");
			}
			else
			{
				test.log(LogStatus.FAIL, "Close button not working");
			}
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		}
		
		@Test(priority=28)
		public void Advertisement_page(WebDriver driver) throws Exception
		{
			/*//Click the My Stores option
			driver.findElement(By.xpath("//span[.='My Stores']")).click();
			
			
			JavascriptExecutor je1 = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element1 = driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[12]/a/span"));
			//Scroll the page till the Reason option present
			je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
			//Wait for 30 seconds
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(3000);
		    //Click the Advertisement Option		
			driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[12]/a/span")).click();
			
			*/
			//Enter the URl
			Thread.sleep(3000);
			driver.get(Utility.getProperty("Enterprise_Base_URL")+"advertisements");
			
			Thread.sleep(5000);
			//Check Advertisement page opened or not
			if(driver.findElement(By.xpath("//a[.='Advertisement']")).getText().equalsIgnoreCase("Advertisement"))

			{
				test.log(LogStatus.PASS, "Advertisement page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Advertisement page loaded Failed");
			}
			
			Thread.sleep(3000);
			
		}
		
		@Test(priority=29)
		public void Advertisement_Refreshpage(WebDriver driver) throws InterruptedException
		{
		
		
			//Click the refresh button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[1]/div/div/div/a/i")).click();
			Thread.sleep(3000);
			
			//Check weather the page is refreshed or not
			if(driver.findElement(By.xpath("//a[.='Advertisement']")).getText().equalsIgnoreCase("Advertisement"))

			{
				test.log(LogStatus.PASS, "Advertisement Page refreshed successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Advertisement Page refreshed successfully");
			}
			Thread.sleep(3000);
		}
		
		@Test(priority=30)
		public void Advertisement_Setting_Method_pagination(WebDriver driver) throws InterruptedException
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
			Thread.sleep(3000);
			
			//Click the Pagination option as 10
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/ul/li[2]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 10 for Advertisement");
			//Create the web element for Advertisement Table
			List<WebElement> results = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/table"));
			for (WebElement result : results){						
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available");
			}
			Thread.sleep(3000);
			
			//Click the Pagination option as 15
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/ul/li[3]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 15 for Advertisement");
			//Create the web element for Advertisement Table
			List<WebElement> results1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/table"));
			for (WebElement result : results1){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available");
			}
			Thread.sleep(3000);
			
			//Click the Pagination option as 20
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/ul/li[4]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 20 for Advertisement");
			//Create the web element for Advertisement Table
			List<WebElement> results2 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/table"));
			for (WebElement result : results2){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available");
			}
			Thread.sleep(3000);
			
			//Click the Pagination option as 5
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/ul/li[1]/a/span")).click();
			test.log(LogStatus.INFO, "Now we click the Pagination option as 5 for Advertisement");
			//Create the web element for Advertisement Table
			List<WebElement> results3 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/table"));
			for (WebElement result : results3){
				//Create the web element for delete button
			     List<WebElement> boxes = result.findElements(By.cssSelector("i.fa.fa-trash-o"));
			     //Create the variable for getting the size of the box
			     int numberOfBoxes = boxes.size();
			     System.out.println("There are totally "+numberOfBoxes+" elements available");
			}
			Thread.sleep(3000);
		}
				
		@Test(priority=31)
		public void Advertisement_Newcreationpage(WebDriver driver) throws InterruptedException
		{
			//Scroll the web page
		    for(int i=1; i <= 15; i++)
		    {
		    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		    	Thread.sleep(1000);
		    }
		    
					
			//Click Advertisement creation button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[1]/div/div/div/button")).click();
		
			Thread.sleep(2000);
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[1]/h3")).getText().equalsIgnoreCase("Advertisement"))
			{
				test.log(LogStatus.PASS, "New Advertisement Page refreshed successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Advertisement Page refreshed successfully");
			}
			Thread.sleep(3000);
		}
		
		@Test(priority=32)
		public void Advertisement_New_Always(WebDriver driver) throws Exception
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			//Clear name field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div/input")).clear();
			Thread.sleep(2000);
			//Enter name field
	     	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("Advertisement_name"));
			
	     	//Click the Applicable Time Period option
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/a")).click();
	 		//Enter the required Time Period
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/input")).sendKeys("Always");
	 		//Press the Enter button
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	 		
	 		//Click the Level  option
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[3]/div/div/a")).click();
	 		//Enter the required Level
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[3]/div/div/div/div/input")).sendKeys("Stores");
	 		//Press the Enter button
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	 		
	 		//Select the Store
	 		//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[4]/div/div/ul")).click();
	 		Thread.sleep(3000);
	 		//Click remove store
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[4]/div/div/ul/li[1]/a")).click();	
	 		
	 		Thread.sleep(2000);
	 		//Select the Store
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[4]/div/div/ul")).click();
	 		//Enter the required stores
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Utility.getProperty("Advertisement_Store"));
	 		//Enter the required stores
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
	 	
	 		
	 		//Click the select image button
	 		//driver.findElement(By.xpath("//id[.='advertisementImage']")).click();
			//driver.findElement(By.xpath("//span[@id='denomination']")).click();
			
	 		Thread.sleep(3000);
			//Choose the required image
			driver.findElement(By.xpath("//input[@id='advertisementImage']")).sendKeys(Utility.getProperty("Settings_advertisementImage_Store_Image_Path"));
			
			Thread.sleep(2000);
			//Click the Remove image
			driver.findElement(By.xpath("//a[.='Remove']")).click();
			
			Thread.sleep(2000);
			//Choose the required image
			driver.findElement(By.id("advertisementImage")).sendKeys(Utility.getProperty("Settings_advertisementImage_Store_Image_Path"));
			Thread.sleep(5000);
			     //Click the Save button
					driver.findElement(By.xpath("//button[@type='submit']")).click();
					
					Thread.sleep(5000);
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Advertisement saved successfully"))
					{
						test.log(LogStatus.PASS, "New Advertisement saved successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "New Advertisement saved failed");
					}
					Thread.sleep(3000);
		}

		@Test(priority=33)
		public void Advertisement_Close(WebDriver driver) throws Exception
		{
			Thread.sleep(3000);
			//Click Advertisement creation button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[1]/div/div/div/button")).click();
			
			Thread.sleep(2000);
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[1]/h3")).getText().equalsIgnoreCase("Advertisement"))
			{
				test.log(LogStatus.PASS, "New Advertisement Page refreshed successfully for close button");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Advertisement Page refreshed successfully for close button");
			}
		
			//Clear name field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div/input")).clear();
			Thread.sleep(2000);
			//Enter name field
	     	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("Advertisement_name"));
			
	     	//Click the Applicable Time Period option
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/a")).click();
	 		//Enter the required Time Period
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/input")).sendKeys("Always");
	 		//Press the Enter button
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	 		
	 		//Click the Level  option
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[3]/div/div/a")).click();
	 		//Enter the required Level
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[3]/div/div/div/div/input")).sendKeys("Stores");
	 		//Press the Enter button
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	 		
	 		//Select the Store
	 		//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[4]/div/div/ul")).click();
	 		Thread.sleep(3000);
	 		//Click remove store
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[4]/div/div/ul/li[1]/a")).click();	
	 		
	 		Thread.sleep(2000);
	 		//Select the Store
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[4]/div/div/ul")).click();
	 		//Enter the required stores
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Utility.getProperty("Advertisement_Store"));
	 		//Enter the required stores
	 		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[4]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
	 	
	 		
	 		//Click the select image button
	 		//driver.findElement(By.xpath("//id[.='advertisementImage']")).click();
			//driver.findElement(By.xpath("//span[@id='denomination']")).click();
			
	 		Thread.sleep(3000);
			//Choose the required image
			driver.findElement(By.id("advertisementImage")).sendKeys(Utility.getProperty("Settings_advertisementImage_Store_Image_Path"));
			
			Thread.sleep(2000);
			//Click the Remove image
			driver.findElement(By.xpath("//a[.='Remove']")).click();
			
			Thread.sleep(2000);
			//Choose the required image
			driver.findElement(By.id("advertisementImage")).sendKeys(Utility.getProperty("Settings_advertisementImage_Store_Image_Path"));
			Thread.sleep(3000);
			     //Click the Close  button
			driver.findElement(By.xpath("//a[.='Close']")).click();
			Thread.sleep(5000);
			//Check Advertisement page opened or not
			if(driver.findElement(By.xpath("//a[.='Advertisement']")).getText().equalsIgnoreCase("Advertisement"))

			{
				test.log(LogStatus.PASS, "Advertisement page loaded Successfully for close button action");
			}
			else
			{
				test.log(LogStatus.FAIL, "Advertisement page loaded Failed for close button action");
			}
			
			Thread.sleep(3000);
		}
		
		@Test(priority=34)
		public void Advertisement_Edit_Daysofweek(WebDriver driver) throws Exception
		{
			//Clear the search field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
			//Enter the required keyword
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Advertisement_name"));
			//Click the Edit icon
			driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
			Thread.sleep(3000);
			
			
			//Clear name field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div/input")).clear();
			Thread.sleep(2000);
			//Enter name field
		 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("Advertisement_name")+"1");
			
			//Click the Applicable Time Period Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/a")).click();
			//Enter the required Time Period
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/input")).sendKeys("Days of Week");
			//Press Enter Key
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(5000);
			//Click the Days of a week Option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[3]/div/div/ul")).click();
			//Enter the required Day
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[3]/div/div/ul/li/input")).sendKeys("WEDNESDAY");
			//Press Enter Key
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[3]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
			
			//Enable or Disable the Restriction Time
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[4]/div/label/span")).click();

			Thread.sleep(1000);
			//Check it is AM or PM in the Start Time Option
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[5]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
			{
				Thread.sleep(2000);
				//Click the AM or PM option in the End Time
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[5]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
			}
			else
			{
				Thread.sleep(2000);
				//Click the AM or PM option in the Start Time
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[5]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
			}
			
			Thread.sleep(3000);
			//Click the Level  option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[6]/div/div/a")).click();
			//Enter the required Level
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[6]/div/div/div/div/input")).sendKeys("Stores");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
			//Select the Store
			//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[4]/div/div/ul")).click();
			Thread.sleep(3000);
			//Click remove store
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[7]/div/div/ul/li[1]/a")).click();	
			
			Thread.sleep(2000);
			//Select the Store
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[7]/div/div/ul")).click();
			//Enter the required stores
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[7]/div/div/ul/li/input")).sendKeys(Utility.getProperty("Advertisement_Store"));
			//Enter the required stores
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[7]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
		
			
			//Click the select image button
			//driver.findElement(By.xpath("//id[.='advertisementImage']")).click();
			//driver.findElement(By.xpath("//span[@id='denomination']")).click();
			
			Thread.sleep(3000);
			//Choose the required image
			driver.findElement(By.id("advertisementImage")).sendKeys(Utility.getProperty("Settings_advertisementImage_Store_Image_Path"));
			
			Thread.sleep(2000);
			//Click the Remove image
			driver.findElement(By.xpath("//a[.='Remove']")).click();
			
			Thread.sleep(2000);
			//Choose the required image
			driver.findElement(By.id("advertisementImage")).sendKeys(Utility.getProperty("Settings_advertisementImage_Store_Image_Path"));
			Thread.sleep(4000);
			     //Click the Save button
					driver.findElement(By.xpath("//button[@type='submit']")).click();
					
					Thread.sleep(5000);
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Advertisement Updated Successfully"))
					{
						test.log(LogStatus.PASS, "Advertisement Updated Successfully for Days of week");
					}
					else
					{
						test.log(LogStatus.FAIL, "Advertisement Updated failed for Days of week");
					}
					Thread.sleep(3000);
		}
		
		@Test(priority=35)
		public void Advertisement_delete(WebDriver driver) throws Exception
		{
			
			Thread.sleep(3000);
			//Clear the search field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
			//Enter the required keyword
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Advertisement_name")+"1");
			//Click the Delete button
			driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
			Thread.sleep(3000);
			//Click the yes button
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
			Thread.sleep(3000);
			//Check the menu item deleted or not 
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Advertisement Inactivated Successfully"))
			{
				test.log(LogStatus.PASS, "Advertisement deleted Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Advertisement deleted Successfully Failed");
			}
			Thread.sleep(5000);
		}
			
		@Test(priority=36)
		public void Advertisement_deActive(WebDriver driver) throws Exception
		{
			
			//Click the DeActive button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/input")).click();
			
			Thread.sleep(3000);
			//Click the success button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td[3]/div[2]/a/i")).click();
			
			
			Thread.sleep(3000);
			//Click the yes button
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
			
			Thread.sleep(3000);
			//Check the menu item activated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Advertisement Activated Successfully"))
			{
				test.log(LogStatus.PASS, "Advertisement Activated Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Advertisement Activated Successfully Failed");
			}
			//Clear the search field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
			
			Thread.sleep(5000);
			
		}
			
		@Test(priority=37)
		public void Advertisement_AS_DaysOfMonth(WebDriver driver) throws Exception
		{
				//Clear the search field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
				//Enter the required keyword
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Advertisement_name")+"1");
				//Click the Edit icon
				driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
				Thread.sleep(3000);
				
				
				//Clear name field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div/input")).clear();
				Thread.sleep(2000);
				//Enter name field
			 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("Advertisement_name")+"2");

				//Click the Applicable Time Period Option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/input")).sendKeys("Days of Month");
				//Press Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(5000);
				//Click the Required Date from the Days of a Month
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[3]/div/table/tbody/tr[2]/td[3]/button")).click();

				//Enable or Disable the Restriction Time
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[4]/div/label/span")).click();
				//Click the Months OIption
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[5]/div/div/ul")).click();
				//Enter the Required Month
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[5]/div/div/ul/li/input")).sendKeys("MAY");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
				
				//Enable or Disable the Restriction Time
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[6]/div/label/span")).click();

				Thread.sleep(1000);
				//Check it is AM or PM in the Start Time Option
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
				{
					Thread.sleep(2000);
					//Click the AM or PM option in the End Time
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
				}
				else
				{
					Thread.sleep(2000);
					//Click the AM or PM option in the Start Time
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
				}
				
				//Click the select image button
				//driver.findElement(By.xpath("//id[.='advertisementImage']")).click();
				//driver.findElement(By.xpath("//span[@id='denomination']")).click();
				
				Thread.sleep(3000);
				//Choose the required image
				driver.findElement(By.id("advertisementImage")).sendKeys(Utility.getProperty("Settings_advertisementImage_Store_Image_Path"));
				
				Thread.sleep(2000);
				//Click the Remove image
				driver.findElement(By.xpath("//a[.='Remove']")).click();
				
				Thread.sleep(2000);
				//Choose the required image
				driver.findElement(By.id("advertisementImage")).sendKeys(Utility.getProperty("Settings_advertisementImage_Store_Image_Path"));
				Thread.sleep(4000);
				     //Click the Save button
						driver.findElement(By.xpath("//button[@type='submit']")).click();
						
						Thread.sleep(5000);
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Advertisement Updated Successfully"))
						{
							test.log(LogStatus.PASS, "Advertisement Updated Successfully for Days of MONTH");
						}
						else
						{
							test.log(LogStatus.FAIL, "Advertisement Updated failed for Days of MONTH");
						}
						Thread.sleep(3000);
			}
			
		@Test(priority=38)
		public void Advertisement_AS_DateRange(WebDriver driver) throws Exception
		{
				//Clear the search field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
				//Enter the required keyword
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Advertisement_name")+"2");
				//Click the Edit icon
				driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
				Thread.sleep(3000);
				
				
				//Clear name field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div/input")).clear();
				Thread.sleep(2000);
				//Enter name field
			 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("Advertisement_name")+"3");
				
			 	//Click the Applicable Time Period Option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(5000);
				//Clear the From Date Field
				driver.findElement(By.name("fromDate")).clear();
				//Enter the From Date
				driver.findElement(By.name("fromDate")).sendKeys("16-May-2020");
				//Clear the To Date Field
				driver.findElement(By.name("endDate")).clear();
				//Enter the To Date
				driver.findElement(By.name("endDate")).sendKeys("20-May-2020");
			
			
				Thread.sleep(3000);
				//Enable or Disable Restriction days
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[5]/div/label/span")).click();
				//Click the DAys of a week
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[6]/div/div/ul")).click();
				//Enter the Required Day
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[6]/div/div/ul/li/input")).sendKeys("FRIDAY");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[6]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
				
				//Enable or Enable the Restriction Time
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[7]/div/label/span")).click();

				Thread.sleep(1000);
				//Check it is AM or PM in the Start Time Option
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[8]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
				{
					Thread.sleep(2000);
					//Click the AM or PM option in the End Time
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[8]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
				}
				else
				{
					Thread.sleep(2000);
					//Click the AM or PM option in the Start Time
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[8]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
				}
				
				
				//Click the select image button
				//driver.findElement(By.xpath("//id[.='advertisementImage']")).click();
				//driver.findElement(By.xpath("//span[@id='denomination']")).click();
				
				Thread.sleep(3000);
				//Choose the required image
				driver.findElement(By.id("advertisementImage")).sendKeys(Utility.getProperty("Settings_advertisementImage_Store_Image_Path"));
				
				Thread.sleep(2000);
				//Click the Remove image
				driver.findElement(By.xpath("//a[.='Remove']")).click();
				
				Thread.sleep(2000);
				//Choose the required image
				driver.findElement(By.id("advertisementImage")).sendKeys(Utility.getProperty("Settings_advertisementImage_Store_Image_Path"));
				Thread.sleep(4000);
				     //Click the Save button
						driver.findElement(By.xpath("//button[@type='submit']")).click();
						
						Thread.sleep(5000);
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Advertisement Updated Successfully"))
						{
							test.log(LogStatus.PASS, "Advertisement Updated Successfully for DateRange");
						}
						else
						{
							test.log(LogStatus.FAIL, "Advertisement Updated failed for DateRange");
						}
						Thread.sleep(3000);
			}
		
		@Test(priority=39)
		public void Advertisement_AS_Specific_date(WebDriver driver) throws Exception
		{
				//Clear the search field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
				//Enter the required keyword
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Advertisement_name")+"3");
				//Click the Edit icon
				driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
				Thread.sleep(3000);
				
				
				//Clear name field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div/input")).clear();
				Thread.sleep(2000);
				//Enter name field
			 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("Advertisement_name")+"4");
				
				//Click the Applicable Time Period Option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/input")).sendKeys("Specific date");
				//Press Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(5000);
				//Clear the Date Field
				driver.findElement(By.name("date")).clear();
				//Enter the Date
				driver.findElement(By.name("date")).sendKeys("16-May-2020");

				//Enable or Disable the Restriction Time
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[4]/div/label/span")).click();

				Thread.sleep(1000);
				//Check it is AM or PM in the Start Time Option
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[5]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
				{
					Thread.sleep(2000);
					//Click the AM or PM option in the End Time
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[5]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
				}
				else
				{
					Thread.sleep(2000);
					//Click the AM or PM option in the Start Time
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[5]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
				}
				//Click the select image button
				//driver.findElement(By.xpath("//id[.='advertisementImage']")).click();
				//driver.findElement(By.xpath("//span[@id='denomination']")).click();
				
				Thread.sleep(3000);
				//Choose the required image
				driver.findElement(By.id("advertisementImage")).sendKeys(Utility.getProperty("Settings_advertisementImage_Store_Image_Path"));
				
				Thread.sleep(2000);
				//Click the Remove image
				driver.findElement(By.xpath("//a[.='Remove']")).click();
				
				Thread.sleep(2000);
				//Choose the required image
				driver.findElement(By.id("advertisementImage")).sendKeys(Utility.getProperty("Settings_advertisementImage_Store_Image_Path"));
				Thread.sleep(4000);
				     //Click the Save button
						driver.findElement(By.xpath("//button[@type='submit']")).click();
						
						Thread.sleep(5000);
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Advertisement Updated Successfully"))
						{
							test.log(LogStatus.PASS, "Advertisement Updated Successfully for Specific date");
						}
						else
						{
							test.log(LogStatus.FAIL, "Advertisement Updated failed for Specific date");
						}
						Thread.sleep(3000);
			}
			
		@Test(priority=40)
		public void Advertisement_AS_Startdatetime_enddatetime(WebDriver driver) throws Exception
		{
				//Clear the search field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
				//Enter the required keyword
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Advertisement_name")+"4");
				//Click the Edit icon
				driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
				Thread.sleep(3000);
				
				
				//Clear name field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div/input")).clear();
				Thread.sleep(2000);
				//Enter name field
			 	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div/input")).sendKeys(Utility.getProperty("Advertisement_name")+"5");
				
				//Click the Applicable Time Period Option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/input")).sendKeys("Start date time & end date time");
				//Press Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(5000);
				//Clear the From Date Field
				driver.findElement(By.name("fromDate")).clear();
				//Enter the From Date
				driver.findElement(By.name("fromDate")).sendKeys("16-May-2020");
				//Clear the To Date Field
				driver.findElement(By.name("endDate")).clear();
				//Enter the To Date
				driver.findElement(By.name("endDate")).sendKeys("20-May-2020");
				
				//Enable or Disable the Restriction days option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[5]/div/label/span")).click();
				
				//Click the Days of a Week Function
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[6]/div/div/ul")).click();
				//Enter the Required day
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[6]/div/div/ul/li/input")).sendKeys("FRIDAY");
				//Press the Enter button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[6]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

				Thread.sleep(2000);
				//Check it is AM or PM in the Start Time Option
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).getText().equalsIgnoreCase("AM"))
				{
					Thread.sleep(2000);
					//Click the AM or PM option in the End Time
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
				}
				else
				{
					Thread.sleep(2000);
					//Click the AM or PM option in the Start Time
					driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[7]/div/div[1]/div/table/tbody/tr[2]/td[6]/button")).click();
				}
				
				
				//Click the select image button
				//driver.findElement(By.xpath("//id[.='advertisementImage']")).click();
				//driver.findElement(By.xpath("//span[@id='denomination']")).click();
				
				Thread.sleep(3000);
				//Choose the required image
				driver.findElement(By.id("advertisementImage")).sendKeys(Utility.getProperty("Settings_advertisementImage_Store_Image_Path"));
				
				Thread.sleep(2000);
				//Click the Remove image
				driver.findElement(By.xpath("//a[.='Remove']")).click();
				
				Thread.sleep(2000);
				//Choose the required image
				driver.findElement(By.id("advertisementImage")).sendKeys(Utility.getProperty("Settings_advertisementImage_Store_Image_Path"));
				Thread.sleep(4000);
				     //Click the Save button
						driver.findElement(By.xpath("//button[@type='submit']")).click();
						
						Thread.sleep(5000);
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Advertisement Updated Successfully"))
						{
							test.log(LogStatus.PASS, "Advertisement Updated Successfully for Start date time & end date time");
						}
						else
						{
							test.log(LogStatus.FAIL, "Advertisement Updated failed for Start date time & end date time");
						}
						Thread.sleep(3000);
			}
			
		@Test(priority=41)
		public void Mail_Chimp_page(WebDriver driver) throws Exception
		{
				/*//Click the My Stores option
				driver.findElement(By.xpath("//span[.='My Stores']")).click();
				
				
				JavascriptExecutor je1 = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element1 = driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[15]/a/span"));
				//Scroll the page till the Reason option present
				je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
				//Wait for 30 seconds
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(3000);
		        //Click the Mail chimp Option		
				driver.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[2]/div/ul/li[15]/a/span")).click();
				*/
				
				//Enter the URl
				Thread.sleep(3000);
				driver.get(Utility.getProperty("Enterprise_Base_URL")+"mailchimp");
				
				Thread.sleep(5000);
				//Check Mail chimp page opened or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[2]/div/h3")).getText().equalsIgnoreCase("Connect mail chimp to add your customers as subscribers"))
				{
					test.log(LogStatus.PASS, "Mail chimp page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Mail chimp page loaded Failed");
				}
				
				Thread.sleep(3000);
				
			}
			
		@Test(priority=42)
		public void Mail_Chimp_Verifypage(WebDriver driver) throws Exception
		{
				//Click mail chimp button
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[1]/div/div/button")).click();
			
				Thread.sleep(5000);
				//Enter the mail chimp Url
				driver.get(Utility.getProperty("Enterprise_Base_URL")+"mailchimp");
				
				
				Thread.sleep(3000);
				
			}
				
		
}
