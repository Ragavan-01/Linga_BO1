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

public class Enterprise_Account_User {
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise_Account_User");

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
		
		@Test(priority=2)
		public void Account_User_openpage() throws Exception
		{
			Thread.sleep(15000);
/*			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			//Click the My Stores option
			driver.findElement(By.xpath("//span[.='My Stores']")).click();
	
			Thread.sleep(3000);
	        //Click the EnterPrise Reports Option		
			driver.findElement(By.xpath("//span[.='EnterPrise Reports']")).click();
			
			Thread.sleep(2000);
			//Click the Sale option
			driver.findElement(By.xpath("//span[.='Account Users']")).click();*/
			
			//Get the URL
			driver.get(Utility.getProperty("Enterprise_Base_URL")+"users");
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
		public void Account_User_pagination() throws InterruptedException
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
		public void Account_User_add() throws Exception
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
		public void Account_User_edit () throws Exception
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
		public void Account_User_reset_Password() throws Exception
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
		public void NewAccountUser_Cancel_Button() throws Exception
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
		public void EditAccountUser_Cancel_Button() throws Exception
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
		public void Reset_Password_Cancel_Button() throws Exception
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
		public void Account_Users_delete() throws Exception
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

}
