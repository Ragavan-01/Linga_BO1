package epicList;

import java.util.List;
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

public class AddEditDelete_Group {
	
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Add_Edit_Delete_Group");
	
	float unknownValue = 00;
	
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

		@Test(priority=22)
		public void Group_Openpage() throws Exception
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
		public void Group_pagination() throws InterruptedException
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
		public void Group_add() throws Exception
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
		public void Group_edit() throws Exception
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
		public void Group_delete() throws Exception
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
		public void Group_cancelButton() throws Exception
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

}
