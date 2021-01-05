package epicList;

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

import epicList_Integrated.Utility;


public class AddEditDelete_Users {

	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete_Users");

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
	}}

	@Test(priority=12)
    public void Usermanagement_User_Pageopen() throws Exception
		{
			//Click the User option
			//driver.findElement(By.xpath("//span[.='Users']")).click();
			Thread.sleep(3000);
			//Enter the Users URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"users");
			Thread.sleep(3000);
			//Check  Users page opened or not
			if(driver.findElement(By.xpath("//a[.='Users']")).getText().equalsIgnoreCase("Users"))
			{
				test.log(LogStatus.PASS,"Users page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Users page loaded Failed");
			}
			
		}
		
	@Test(priority=13)
    public void Usermanagement_User_refreshPage() throws InterruptedException
		{
			Thread.sleep(3000);
			//Click the refresh button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[1]/div/div/div/a/i")).click();
			Thread.sleep(3000);
			//Check  Users page opened or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[1]/div/h3")).getText().equalsIgnoreCase("Users"))
			{
				test.log(LogStatus.PASS,"Users page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Users page loaded Failed");
			}
		}

	@Test(priority=14)
    public void Usermanagement_User_addUsers() throws Exception
		{
			Thread.sleep(3000);
			//Click the Add User or Create new User button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[1]/div/div/div/button")).click();
			Thread.sleep(3000);
			//Check  New User form page loaded or not
			if(driver.findElement(By.xpath("//span[.='NEW USER']")).getText().equalsIgnoreCase("NEW USER"))
			{
				test.log(LogStatus.PASS,"New Users form loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"New Users form loaded Failed");
			}
			Thread.sleep(3000);
			
			WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

			//Clear the first name field
			driver.findElement(By.name("firstName")).clear();
			//Enter the required first name
			driver.findElement(By.name("firstName")).sendKeys(Utility.getProperty("UMFirstName"));
			//Clear the last name field
			driver.findElement(By.name("lastName")).clear();
			//Enter the last first name
			driver.findElement(By.name("lastName")).sendKeys(Utility.getProperty("UMLastName"));
			//Click the required Gender(Male)
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[3]/div/div/label[1]/input")).click();
			//Clear the date of birth field
			driver.findElement(By.name("dateOfBirth")).clear();
			//Enter the date of birth
			driver.findElement(By.name("dateOfBirth")).sendKeys("04-Nov-1993");
			//Clear the phone number field
			driver.findElement(By.name("phoneNumber")).clear();
			//Enter the phone number
			driver.findElement(By.name("phoneNumber")).sendKeys(Utility.getProperty("UMPhoneNumber"));
			//Click the Enable Sign in option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[6]/div/input")).click();
			//Clear the email id field
			driver.findElement(By.name("emailId")).clear();
			//Enter the email id
			driver.findElement(By.name("emailId")).sendKeys(Utility.getProperty("Usermanagement_user_emailid"));	
			//Click the password
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[8]/div/input")).click();
			//Enter the password
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[8]/div/input")).sendKeys("8596abcd");
			//Enter the Confirm password
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[8]/div/input")).sendKeys(Keys.ENTER);
			
			//Click the password
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[9]/div/input")).click();
			//Enter the password
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[9]/div/input")).sendKeys("8596abcd");
			//Enter the Confirm password
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[9]/div/input")).sendKeys(Keys.ENTER);
			
		
			Thread.sleep(3000);
			//Click the Roles option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[10]/div/div/ul")).click();
			//Enter the required role		
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[10]/div/div/ul/li/input")).sendKeys("Precook");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[10]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			//Click the Language option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[11]/div/div/a")).click();
			//Enter the required Language
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[11]/div/div/div/div/input")).sendKeys("English");
			//Press the Enter button
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[1]/div[11]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			//Clear the employee pin field
			driver.findElement(By.name("employeePin")).clear();
			//Enter the required pin number2
			driver.findElement(By.name("employeePin")).sendKeys(Utility.getProperty("Usermanagement_user_Employeepin"));
			//Clear the date of join field
			driver.findElement(By.name("dateOfJoining")).clear();
			//Enter the date of join pin number
			driver.findElement(By.name("dateOfJoining")).sendKeys("15-Jan-2011");
			
			//Clear the termination date field
			driver.findElement(By.name("dateOfTermination")).clear();
			//Enter the termination date
			driver.findElement(By.name("dateOfTermination")).sendKeys("09-Aug-2019");
			//Clear the termination reason
			driver.findElement(By.name("reasonForTermination")).clear();
			//Enter the required reason
			driver.findElement(By.name("reasonForTermination")).sendKeys("For Testing purpose");
			//Enter the iPad Initial Screen
			driver.findElement(By.name("firstScreen")).sendKeys("Table Screen");
			Thread.sleep(3000);
			//Click the ClockIn Required option
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/ng-form/div[2]/div[2]/div/input")).click();
			Thread.sleep(3000);
			//Enable the Do Auto CashierOut
			driver.findElement(By.name("doAutoCashierOut")).click();
			//Enable the Cash Tip
			driver.findElement(By.name("hasCashTip")).click();
			//Clear the Address1 field
			driver.findElement(By.name("addressLine1")).clear();
			//Enter the required Address
			driver.findElement(By.name("addressLine1")).sendKeys("Address 1 for the user");
			//Clear the Address2 field
			driver.findElement(By.name("addressLine2")).clear();
			//Enter the required Address
			driver.findElement(By.name("addressLine2")).sendKeys("Address 2 for the user");
			//Clear the City field
			driver.findElement(By.name("city")).clear();
			//Enter the required city
			driver.findElement(By.name("city")).sendKeys("Chennai");
			//Clear the State field
			driver.findElement(By.name("state")).clear();
			//Enter the required State
			driver.findElement(By.name("state")).sendKeys("TN");
			//Clear the Zip code field
			driver.findElement(By.name("zipCode")).clear();
			//Enter the required Zip Code
			driver.findElement(By.name("zipCode")).sendKeys("123456");
			
			//Click the image option for upload the image
			//driver.findElement(By.xpath("//input[@id='userImage']")).sendKeys("C:\\Users\\hariprasanth_j\\Desktop\\RetailItem.jpg");
			
			Thread.sleep(3000);
			//Click the save and next button
					driver.findElement(By.xpath("//span[.='Save & Next']")).click();
					Thread.sleep(3000);
					//Check weather the new User Saved Successfully or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("User Saved Successfully"))
					{
						test.log(LogStatus.PASS,"New User Saved Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL,"New User Saved Failed");
					}
					
			Thread.sleep(2000);
			//Click the add payments option   
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div/label/a")).click();
			//Select the required Wages by
			Select wagesBy = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div/div/div/div/div[2]/div[1]/select")));
			wagesBy.selectByVisibleText("Monthly");
			//Clear the effectiveDate field
		   driver.findElement(By.name("effectiveDate")).clear();
			//Enter effective date
			driver.findElement(By.name("effectiveDate")).sendKeys(Utility.getProperty("UMDATE1"));
			//Clear the Salary amount
			driver.findElement(By.name("salary")).clear();
			//Enter the Salary amount
		    driver.findElement(By.name("salary")).sendKeys("1500");
		   //Click cancel button
	       driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div/div/div/div/div[2]/div[4]/div/div/a[1]")).click();
	       Thread.sleep(2000);
	       //Click the add payments option
	       driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div/label/a")).click();
	       //Select the required Wages by
	       Select wagesBy1 = new Select(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div/div/div/div/div[2]/div[1]/select")));
	       wagesBy1.selectByVisibleText("Hourly");
	       //Clear the effectiveDate field
		   driver.findElement(By.name("effectiveDate")).clear();
	       //Enter effective date
	       driver.findElement(By.name("effectiveDate")).sendKeys(Utility.getProperty("UMDATE2"));
		   //Enter the Salary amount
		   driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/form/div/div/div/div/div[2]/div[3]/div/div/input")).sendKeys("1500");
		   Thread.sleep(3000);
		   //Click the Save button     
		   driver.findElement(By.cssSelector("a.btn.btn-success.btn-small")).click();
		   Thread.sleep(3000);
		   //Check weather the payment added Successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Payment added successfully"))
			{
				test.log(LogStatus.PASS,"Payment added successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Payment added Failed");
			}
			Thread.sleep(3000);
			//Click the Close button
		driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger.pull-right.ng-binding")).click();
		}
		
	@Test(priority=16)
    public void Usermanagement_User_edit() throws Exception
		{
			Thread.sleep(3000);
			//Clear the search box
			driver.findElement(By.cssSelector("label.ng-binding > input.ng-pristine.ng-valid")).clear();
			//Enter the required keyword in search box
			driver.findElement(By.cssSelector("label.ng-binding > input.ng-pristine.ng-valid")).sendKeys(Utility.getProperty("UMFirstName"));
			//Click the edit button
			Thread.sleep(2000);driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();Thread.sleep(2000);
			//Clear the first name field
			driver.findElement(By.name("firstName")).clear();
			//Enter the required first name
			driver.findElement(By.name("firstName")).sendKeys(Utility.getProperty("UMFirstName")+"1");
			Thread.sleep(3000);
			//Click the update and next button
			driver.findElement(By.xpath("//span[.='Update & Next']")).click();
			Thread.sleep(3000);
			//Check weather the new role was updated or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("User updated successfully"))
			{							
				test.log(LogStatus.PASS,"User updated successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"User updated Failed");
			}
			Thread.sleep(3000);
			//Click the Close button
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-danger.pull-right.ng-binding")).click();
		}
	
	@Test(priority=18)
    public void Usermanagement_User_givePasswordOREnableSignIn() throws Exception
		{
			
			Thread.sleep(2000);
			//Clear the search field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
			
			//Clear the search field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("UMFirstName")+"1");
			
			//Click the edit button
			driver.findElement(By.cssSelector("i.fa.fa-sign-in")).click();
			Thread.sleep(3000);
			//Click yes button
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
			
			Thread.sleep(2000);
			//Check weather the Sign in disabled successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("Sign in disabled successfully"))
			{
				test.log(LogStatus.PASS,"Sign in disabled successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Sign in disabled successfully is  Failed");
			}

			
		}
		
	@Test(priority=19)
    public void Usermanagement_User_givePasswordORDisableSignIn() throws Exception
		{
			Thread.sleep(2000);
			//Clear the search field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
			
			//Clear the search field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("UMFirstName")+"1");
			
			//Click the edit button
			driver.findElement(By.cssSelector("i.fa.fa-sign-in")).click();
			Thread.sleep(3000);
			//Clear the Password field
			driver.findElement(By.xpath("//input[@ng-model='user.password']")).clear();
			//Enter the required Password
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@ng-model='user.password']")).sendKeys("test1235");
			Thread.sleep(3000);
			//Clear the Confirm Password field
			driver.findElement(By.xpath("//input[@ng-model='user.confirmPassword']")).clear();
			Thread.sleep(3000);
			//Enter the required Confirm Password
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@ng-model='user.confirmPassword']")).sendKeys("test1235");
			Thread.sleep(3000);
			//Click the Submit button
			driver.findElement(By.cssSelector("button.btn.btn-small.btn-success.ng-binding")).click();
			
			Thread.sleep(2000);
			//Check weather the Sign in Enabled successfully or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div[1]/span/span")).getText().equalsIgnoreCase("Sign in enabled successfully"))
			{
				test.log(LogStatus.PASS,"Sign in enabled successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Sign in enabled successfully is  Failed");
			}
			
			Thread.sleep(2000);
		}
		
	@Test(priority=21)
    public void Usermanagement_User_delete() throws Exception
		{
			driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
			//Clear the search box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
			//Enter the required keyword in search box
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("UMFirstName")+"1");
			Thread.sleep(3000);
			//Click on the delete button	
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr/td[7]/div[1]/a[2]/i")).click();
			
			Thread.sleep(3000);
			//Click the yes button
			driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();
				
			Thread.sleep(3000);
			//Check weather the role deleted or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("User inactivated successfully"))
			{
				test.log(LogStatus.PASS,"User deleted Sucessfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"User deleted Failed");
			}
			}

	@Test(priority=22)
    public void Usermanagement_User_DeActivestatus () throws Exception
			{
			Thread.sleep(2000);
			//Check Deactivate User
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/input")).click();
			Thread.sleep(3000);   		
			//Clear the search field
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
			//Enter the required keyword
			driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("UMFirstName")+"1");
			Thread.sleep(2000);
			//Click the Delete button
			driver.findElement(By.cssSelector("i.fa.fa-check")).click();
			Thread.sleep(2000);
			//Click the Yes button in the popup
			Thread.sleep(5000);driver.findElement(By.cssSelector("a.btn.btn-small.btn-success")).click();  
			Thread.sleep(3000);
			//Check if we Deactivate or not
			if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[1]/div/span/span")).getText().equalsIgnoreCase("User activated successfully"))
			{
				test.log(LogStatus.PASS,"User activated successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"User activated successfully is Failed");
			}
			Thread.sleep(3000);
				}
							
	@Test(priority=20)
	public void UsersActivestatus () throws Exception
				{
					
				Thread.sleep(2000);
				//Clear the search field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
				
				//Enter the required keyword
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("UMFirstName")+"1");
			   Thread.sleep(3000);
			   //Clear the search field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
				
				
				Thread.sleep(5000);
				watchTutorial();
				Thread.sleep(5000);
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

				
			}
