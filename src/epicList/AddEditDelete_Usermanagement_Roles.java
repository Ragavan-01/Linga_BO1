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


public class AddEditDelete_Usermanagement_Roles {

	public WebDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete_Usermanagement_Roles");

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
			//Launch the	URL
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
				test.log(LogStatus.PASS,"User Logged in Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"User Logged in Failed");
			}
		}
			@Test(priority=2)
			public void openRolesPage() throws Exception
			{
				//Click the User Management option
				driver.findElement(By.xpath("//span[.='User Management']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Roles']"));
				//Scroll the page till the Roles option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Roles Option		
				driver.findElement(By.xpath("//span[.='Roles']")).click();
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
		
		@Test(priority=3)
		public void refreshRolesPage() throws InterruptedException
		{
			Thread.sleep(2000);
			WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			
		Thread.sleep(5000);
		//Click the refresh button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/a/i")).click();
		Thread.sleep(5000);
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

	@Test(priority=4)
	public void addRoles() throws Exception
	{
		Thread.sleep(5000);
		//Click the Add Roles or Create new Role button
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/button")).click();
		Thread.sleep(5000);
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
		//Click the Back Office link
		driver.findElement(By.xpath("//a[.='BACK OFFICE']")).click();
		
		List<WebElement> bockOfficeCount = driver.findElements(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[1]/div[2]/div/div"));
		bockOfficeCount.size();
		
		for(int i = 2; i <= bockOfficeCount.size(); i++)
		{
			//Click the required Check box
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[1]/div[2]/div/div["+i+"]/input")).click();
		}
		
/*		//Click the Edit ALL
    	driver.findElement(By.xpath("(//input[@name=''] )[1]")).click();
		//Click the Edit Menu
		driver.findElement(By.xpath("(//input[@name=''] )[3]")).click();
		//Click the Edit Menu Price
		driver.findElement(By.xpath("(//input[@name=''] )[4]")).click();
		//Click the Edit Menu Configuration
		driver.findElement(By.xpath("(//input[@name=''] )[6]")).click();
		//Click the Edit Gratuity
		driver.findElement(By.xpath("(//input[@name=''] )[7]")).click();
		//Click the Edit Gift Card
		driver.findElement(By.xpath("(//input[@name=''] )[8]")).click();
		//Click the Edit Printer Settings
		driver.findElement(By.xpath("(//input[@name=''] )[9]")).click();	
		//Click the Edit Tax Settings
		driver.findElement(By.xpath("(//input[@name=''] )[10]")).click();
		//Click the Edit Store Settings
		driver.findElement(By.xpath("(//input[@name=''] )[11]")).click();
		//Click the Edit Store Info
		driver.findElement(By.xpath("(//input[@name=''] )[12]")).click();
		//Click the Edit Report
		driver.findElement(By.xpath("(//input[@name=''] )[13]")).click();
		//Click the Edit Single User Settings
		driver.findElement(By.xpath("(//input[@name=''] )[14]")).click();
		//Click the Edit Multi User Settings
		driver.findElement(By.xpath("(//input[@name=''] )[15]")).click();
		//Click the Edit Discount Settings
		driver.findElement(By.xpath("(//input[@name=''] )[16]")).click();
		//Click the Edit Inventory Settings
		driver.findElement(By.xpath("(//input[@name=''] )[17]")).click();
		//Click the Edit Customer
		driver.findElement(By.xpath("(//input[@name=''] )[18]")).click();
		//Click the Edit User Management
		driver.findElement(By.xpath("(//input[@name=''] )[19]")).click();
		//Click the Edit Disable Back Office Login
    	driver.findElement(By.xpath("(//input[@name=''] )[20]")).click();	*/
    	  Thread.sleep(5000);
/* 	  	 for(int i=0; i<=5; i++)
 	  	 {
 	  		 Thread.sleep(1000);
 	  		 driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
 	  	 }
    	//Click the Back Office link
		driver.findElement(By.xpath("//a[.='BACK OFFICE']")).click();*/
		
		//Click the POS link
		driver.findElement(By.xpath("//a[.='POS']")).click();
		
		List<WebElement> posCount = driver.findElements(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[2]/div[2]/div/div"));
		posCount.size();
		
		for(int i = 2; i <= posCount.size(); i++)
		{
			//Click the required Check box
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[2]/div[2]/div/div["+i+"]/input")).click();
		}
		
/*		//Click the Edit ALL
    	driver.findElement(By.xpath("(//input[@name=''] )[21]")).click();
		//Click the Edit Create Order
		driver.findElement(By.xpath("(//input[@name=''] )[22]")).click();   
		//Click the Edit Void Item
		driver.findElement(By.xpath("(//input[@name=''] )[23]")).click();
		//Click the Edit GC Payment
		driver.findElement(By.xpath("(//input[@name=''] )[24]")).click();
		//Click the Edit HA Payment
		driver.findElement(By.xpath("(//input[@name=''] )[25]")).click();
		//Click the Edit Payment 1 Settings
		driver.findElement(By.xpath("(//input[@name=''] )[26]")).click();
		//Click the Edit Payment 2 Settings
		driver.findElement(By.xpath("(//input[@name=''] )[27]")).click();	
		//Click the Edit Pay Cash
		driver.findElement(By.xpath("(//input[@name=''] )[28]")).click();
		//Click the Edit Tax Exempt
		driver.findElement(By.xpath("(//input[@name=''] )[29]")).click();
		//Click the Edit Open Item
		driver.findElement(By.xpath("(//input[@name=''] )[30]")).click();
		//Click the Edit Gift Card Issue
		driver.findElement(By.xpath("(//input[@name=''] )[31]")).click();
		//Click the Edit Discount 
		driver.findElement(By.xpath("(//input[@name=''] )[32]")).click();
		//Click the Edit Cash Drawer
		driver.findElement(By.xpath("(//input[@name=''] )[33]")).click();
		//Click the Edit Discount Settings
		driver.findElement(By.xpath("(//input[@name=''] )[34]")).click();
		//Click the Edit Resent to Kitchen
		driver.findElement(By.xpath("(//input[@name=''] )[35]")).click();
		//Click the Edit View All Checks
		driver.findElement(By.xpath("(//input[@name=''] )[36]")).click();
		//Click the Edit Is Driver
		driver.findElement(By.xpath("(//input[@name=''] )[37]")).click();
		//Click the Edit Restict Check Summary
		driver.findElement(By.xpath("(//input[@name=''] )[38]")).click();
		//Click the Edit Restict Check Summary
		driver.findElement(By.xpath("(//input[@name=''] )[38]")).click();
		 Thread.sleep(5000);*/
/* 	  	 for(int i=0; i<=5; i++)
 	  	 {
 	  		 Thread.sleep(1000);
 	  		 driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
 	  	 }
		//Click the POS link
		driver.findElement(By.xpath("//a[.='POS']")).click();*/
	    
		//Click the POS Operations link
		driver.findElement(By.xpath("//a[.='POS OPERATIONS']")).click();
		
		List<WebElement> posOperationsCount = driver.findElements(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[3]/div[2]/div/div"));
		posOperationsCount.size();
		
		for(int i = 2; i <= posOperationsCount.size(); i++)
		{
			//Click the required Check box
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[3]/div[2]/div/div["+i+"]/input")).click();
		}
		
/*		//Click the Edit ALL
    	driver.findElement(By.xpath("(//input[@name=''] )[39]")).click();
    	//Click the Edit Open Till
    			driver.findElement(By.xpath("(//input[@name=''] )[40]")).click();   
    			//Click the Edit Hold Till
    			driver.findElement(By.xpath("(//input[@name=''] )[41]")).click();
    			//Click the Edit Close Own Till
    			driver.findElement(By.xpath("(//input[@name=''] )[42]")).click();
    			//Click the Edit View/Close All Till
    			driver.findElement(By.xpath("(//input[@name=''] )[43]")).click();
    			//Click the Edit Cash Drop
    			driver.findElement(By.xpath("(//input[@name=''] )[44]")).click();
    			//Click the Edit Pay-In/Out
    			driver.findElement(By.xpath("(//input[@name=''] )[45]")).click();	
    			//Click the Edit Open Cash Drawer
    			driver.findElement(By.xpath("(//input[@name=''] )[46]")).click();
    			//Click the Edit Print Cash LOG
    			driver.findElement(By.xpath("(//input[@name=''] )[47]")).click();
    			//Click the Edit Void Check
    			driver.findElement(By.xpath("(//input[@name=''] )[48]")).click();
    			//Click the Edit Re-Open Check
    			driver.findElement(By.xpath("(//input[@name=''] )[49]")).click();
    			//Click the Edit POS Settings
    			driver.findElement(By.xpath("(//input[@name=''] )[50]")).click();
    			//Click the Edit Close Own Cash Out
    			driver.findElement(By.xpath("(//input[@name=''] )[51]")).click();
    			//Click the Edit Close All Cash Out
    			driver.findElement(By.xpath("(//input[@name=''] )[52]")).click();
    			//Click the Edit Close the Day
    			driver.findElement(By.xpath("(//input[@name=''] )[53]")).click();
    			//Click the Edit Close Batch
    			driver.findElement(By.xpath("(//input[@name=''] )[54]")).click();
    			//Click the Edit Hardware Settings
    			driver.findElement(By.xpath("(//input[@name=''] )[55]")).click();
    			//Click the Edit Operational Reports
    			driver.findElement(By.xpath("(//input[@name=''] )[56]")).click();
		//Click the Refund
		driver.findElement(By.xpath("(//input[@name=''] )[57]")).click();
		//Click the Edit Reprint Check
    	driver.findElement(By.xpath("(//input[@name=''] )[58]")).click();	
    	//Click the Edit Unlock Check
    	driver.findElement(By.xpath("(//input[@name=''] )[59]")).click();	
    	//Click the Edit Transfer Check/Table
    	driver.findElement(By.xpath("(//input[@name=''] )[60]")).click();	
    	//Click the Edit Restrict Report On Active Check
    	driver.findElement(By.xpath("(//input[@name=''] )[61]")).click();
    	
    	  Thread.sleep(5000);
 	  	 for(int i=0; i<=5; i++)
 	  	 {
 	  		 Thread.sleep(1000);
 	  		 driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
 	  	 }*/
		//Click the POS Operations link
		driver.findElement(By.xpath("//a[.='POS OPERATIONS']")).click();
		
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
	@Test(priority=5)
	public void RevertRoles() throws Exception
	{
		
		Thread.sleep(4000);
		//Clear the search field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys("Cook");
		//Click the edit button
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(3000);
		//Click the Back Office link
		driver.findElement(By.xpath("//a[.='BACK OFFICE']")).click();
		//Click the Create Menu
		driver.findElement(By.xpath("(//input[@name=''] )[2]")).click();
		//Click the Back Office link
		driver.findElement(By.xpath("//a[.='BACK OFFICE']")).click();
		Thread.sleep(5000);
		//Click the save or update button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		//Clear the search box
		driver.findElement(By.cssSelector("label.ng-binding > input.ng-pristine.ng-valid")).clear();
		//Enter the required keyword in search box
		driver.findElement(By.cssSelector("label.ng-binding > input.ng-pristine.ng-valid")).sendKeys("Cook");
		//Click Revert Option
		driver.findElement(By.cssSelector("i.fa.fa-link")).click();
		Thread.sleep(5000);
		//Click the yes button on popup
		driver.findElement(By.linkText("Yes")).click();
		
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
	@Test(priority=6)
	public void CheckRevertedRoles() throws Exception
	{
		Thread.sleep(4000);
		//Clear the search field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys("Cook");
		//Click the edit button
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		Thread.sleep(4000);
		//Click cancel Button
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		
		Thread.sleep(4000);
		//Clear the search field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys("Cook");
		//Click the edit button
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
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
	@Test(priority=7)
	public void editRoles() throws Exception
	{
		Thread.sleep(4000);
		//Clear the search field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Roles_name"));
		//Click the edit button
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		//Clear the name field
		driver.findElement(By.name("name")).clear();
		//Enter the required name
		driver.findElement(By.name("name")).sendKeys(Utility.getProperty("Roles_name")+"1");
		//Click the Back Office link
		driver.findElement(By.xpath("//a[.='BACK OFFICE']")).click();
/*		//Click the Gratutity
		driver.findElement(By.xpath("(//input[@name=''] )[7]")).click();
		//Click the Gift Card
		driver.findElement(By.xpath("(//input[@name=''] )[8]")).click();
		//Click the Back Office link
		driver.findElement(By.xpath("//a[.='BACK OFFICE']")).click();*/
		
		List<WebElement> bockOfficeCount = driver.findElements(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[1]/div[2]/div/div"));
		bockOfficeCount.size();
		
		for(int i = 2; i <= bockOfficeCount.size(); i=i+3)
		{
			//Click the required Check box
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[1]/div[2]/div/div["+i+"]/input")).click();
		}
		
		//Click the POS link
		driver.findElement(By.xpath("//a[.='POS']")).click();
/*		//Click the GC PAYMENT
		driver.findElement(By.xpath("(//input[@name=''] )[25]")).click();
		//Click the Tax Exempt
		driver.findElement(By.xpath("(//input[@name=''] )[30]")).click();
		//Click the POS link
		driver.findElement(By.xpath("//a[.='POS']")).click();*/
		
		List<WebElement> posCount = driver.findElements(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[2]/div[2]/div/div"));
		posCount.size();
		
		for(int i = 2; i <= posCount.size(); i=i+3)
		{
			//Click the required Check box
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[2]/div[2]/div/div["+i+"]/input")).click();
		}
		
		
/*		//Click the POS Operations link
		driver.findElement(By.xpath("//a[.='POS OPERATIONS']")).click();
		//Click the hold Till
		driver.findElement(By.xpath("(//input[@name=''] )[41]")).click();
		//Click the Cash Drop
		driver.findElement(By.xpath("(//input[@name=''] )[44]")).click();*/
		
		//Click the POS Operations link
		driver.findElement(By.xpath("//a[.='POS OPERATIONS']")).click();

		List<WebElement> posOperationsCount = driver.findElements(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[3]/div[2]/div/div"));
		posOperationsCount.size();
		
		for(int i = 2; i <= posOperationsCount.size(); i=i+3)
		{
			//Click the required Check box
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/div[2]/uib-accordion/div/div[3]/div[2]/div/div["+i+"]/input")).click();
		}
				
		
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
	
	@Test(priority=8)
	public void deleteRoles() throws Exception
	{
		//Clear the search field
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
		//Enter the required keyword
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Roles_name")+"1");
		Thread.sleep(4000);
		//Click on the delete button
		driver.findElement(By.cssSelector("i.fa.fa-trash-o")).click();
		Thread.sleep(5000);
		//Click the yes button on popup
		driver.findElement(By.linkText("Yes")).click();
		Thread.sleep(5000);
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
	@Test(priority=9)
	public void RolesDeActivestatus () throws Exception
	{
	Thread.sleep(4000);
	//Check Deactivate Roles
    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[1]/input")).click();
    Thread.sleep(3000);   		
	//Clear the search field
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
	//Enter the required keyword
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Roles_name")+"1");
	Thread.sleep(4000);
	//Click the activate button
	driver.findElement(By.cssSelector("i.fa.fa-check")).click();
	Thread.sleep(4000);
	//Click the Yes button in the popup
	driver.findElement(By.linkText("Yes")).click();  
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
	Thread.sleep(3000);
	}

	@Test(priority=10)
	public void RolesActivestatus () throws Exception
	{
		
    Thread.sleep(4000);
	//Check active Roles
    driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[1]/input")).click();
    Thread.sleep(3000);
	//Clear the search field
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
    //Enter the required keyword
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).sendKeys(Utility.getProperty("Roles_name")+"1");
     Thread.sleep(6000);
   //Clear the search field
	driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/label/input")).clear();
	
	}
			
				@Test(priority=11)
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
			    	test.log(LogStatus.PASS,"User Logged out Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"User Logged out Failed");
				}
				
				Thread.sleep(5000);
				//Close the Browser
				driver.close();
				}
	
}
